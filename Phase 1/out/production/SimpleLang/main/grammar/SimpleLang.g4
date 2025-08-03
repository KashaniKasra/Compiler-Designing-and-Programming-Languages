grammar SimpleLang;

@header {
    import main.ast.nodes.expr.*;
    import main.ast.nodes.expr.operator.*;
    import main.ast.nodes.expr.primitives.*;
    import main.ast.nodes.expr.primitives.constants.*;
    import main.ast.nodes.node.*;
    import main.ast.nodes.node.design.*;
    import main.ast.nodes.node.direct_abstract_declarator.*;
    import main.ast.nodes.node.direct_declarator.*;
    import main.ast.nodes.node.initial.*;
    import main.ast.nodes.node.type.*;
    import main.ast.nodes.stmt.*;
    import main.ast.nodes.stmt.iteration.*;
    import main.ast.nodes.stmt.jump.*;
}

compilationUnit returns [CompilationUnit compilationUnitRet]
    : (t=translationUnit { $compilationUnitRet = new CompilationUnit($t.translationUnitRet); })?
      EOF
    ;

translationUnit returns [TranslationUnit translationUnitRet]
    : { $translationUnitRet = new TranslationUnit(); }
      (e=externalDeclaration { $translationUnitRet.addExternalDeclaration($e.externalDeclarationRet); })+
    ;

externalDeclaration returns [ExternalDeclaration externalDeclarationRet]
    : f=functionDefinition { $externalDeclarationRet = new ExternalDeclaration($f.functionDefinitionRet); }
    | d=declaration { $externalDeclarationRet = new ExternalDeclaration($d.declarationRet); }
    | Semi
    ;

functionDefinition returns [FunctionDefinition functionDefinitionRet]
    : { $functionDefinitionRet = new FunctionDefinition();
        boolean isFirst = true; }
      (ds=declarationSpecifiers { $functionDefinitionRet.setTypeSpecifiers($ds.declarationSpecifiersRet);
                                  $functionDefinitionRet.setLine($ds.declarationSpecifiersRet.get(0).getLine());
                                  isFirst = false; })?
      d=declarator { $functionDefinitionRet.setDeclarator($d.declaratorRet);
                     if (isFirst) $functionDefinitionRet.setLine($d.declaratorRet.getLine()); }
      (dl=declarationList { $functionDefinitionRet.setDeclarations($dl.declarationListRet); })?
      c=compoundStatement { $functionDefinitionRet.setCompoundStatement($c.compoundStatementRet); }
    ;

declarationList returns [ArrayList<Declaration> declarationListRet]
    : { $declarationListRet = new ArrayList<Declaration>(); }
      (d=declaration { $declarationListRet.add($d.declarationRet); })+
    ;

expression returns [Expression expressionRet]
  : id=Identifier { $expressionRet = new Identifier($id.text);
                    $expressionRet.setLine($id.line); }
  | co=Constant { String text = $co.getText();
                  if (text.startsWith("\'") && text.endsWith("\'")) {
                      $expressionRet = new CharacterConstant($co.text);
                  } else if (text.contains(".") || text.contains("p") || text.contains("P") || ((text.contains("e") || text.contains("E")) && !text.contains("x") && !text.contains("X"))) {
                      $expressionRet = new FloatingConstant($co.text);
                  } else {
                      $expressionRet = new IntegerConstant($co.int);
                  }
                  $expressionRet.setLine($co.line); }
  | { $expressionRet = new StringLiteral();
      boolean isFirst = true; }
      (s=StringLiteral { ((StringLiteral)$expressionRet).addName($s.text);
                         if (isFirst) {
                            $expressionRet.setLine($s.line);
                            isFirst = false;
                         } })+
  | l=LeftParen e=expression RightParen { $expressionRet = new ParanthesisExpression($e.expressionRet);
                                          $expressionRet.setLine($l.line); }
  | l=LeftParen t=typeName RightParen LeftBrace i=initializerList Comma? RightBrace { $expressionRet = new CompoundExpression($t.typeNameRet, $i.initializerListRet);
                                                                                      $expressionRet.setLine($l.line); }
  | e1=expression LeftBracket e2=expression RightBracket { $expressionRet = new ArrayExpression($e1.expressionRet, $e2.expressionRet);
                                                           $expressionRet.setLine($e1.expressionRet.getLine()); }
  | e1=expression { $expressionRet = new FunctionCallExpression($e1.expressionRet); } LeftParen { $expressionRet.setLine($e1.expressionRet.getLine()); }
    (a=argumentExpressionList { ((FunctionCallExpression)$expressionRet).setParameters($a.argumentExpressionListRet); })? RightParen
  | e=expression PlusPlus { $expressionRet = new UnaryExpression($e.expressionRet, UnaryOperator.POST_INC);
                            $expressionRet.setLine($e.expressionRet.getLine()); }
  | e=expression MinusMinus { $expressionRet = new UnaryExpression($e.expressionRet, UnaryOperator.POST_DEC);
                              $expressionRet.setLine($e.expressionRet.getLine()); }
  | { ArrayList<UnaryOperator> ops = new ArrayList<UnaryOperator>();
      Expression expr = null;
      boolean isFirst = true;
       int line = -1; }
    ( l=PlusPlus { ops.add(UnaryOperator.PRE_INC);
                  if (isFirst) {
                    line = $l.line;
                    isFirst = false;
                  } }
     | l=MinusMinus { ops.add(UnaryOperator.PRE_DEC);
                  if (isFirst) {
                    line = $l.line;
                    isFirst = false;
                  } }
     | l=Sizeof { ops.add(UnaryOperator.SIZEOF);
                  if (isFirst) {
                    line = $l.line;
                    isFirst = false;
                  } })*
    ( id=Identifier { expr = new Identifier($id.text);
                      if (isFirst) expr.setLine($id.line); }
      | co=Constant { String text = $co.getText();
                      if (text.startsWith("\'") && text.endsWith("\'")) {
                          expr = new CharacterConstant($co.text);
                      } else if (text.contains(".") || text.contains("p") || text.contains("P") || ((text.contains("e") || text.contains("E")) && !text.contains("x") && !text.contains("X"))) {
                          expr = new FloatingConstant($co.text);
                      } else {
                          expr = new IntegerConstant($co.int);
                      }
                      if (isFirst) expr.setLine($co.line); }
      | { expr = new StringLiteral();
           boolean isFirst2 = true; }
           (s=StringLiteral { ((StringLiteral)expr).addName($s.text);
                              if (isFirst && isFirst2) {
                                  expr.setLine($s.line);
                                  isFirst2 = false;
                               } })+
      | l=LeftParen e=expression RightParen { expr = new ParanthesisExpression($e.expressionRet);
                                             if (isFirst) expr.setLine($l.line); }
      | l=LeftParen t=typeName RightParen LeftBrace i=initializerList Comma? RightBrace { expr = new CompoundExpression($t.typeNameRet, $i.initializerListRet);
                                                                                          if (isFirst) expr.setLine($l.line); }
      | u=unaryOperator c=castExpression { expr = new UnaryCastExpression($u.unaryOperatorRet, $c.castExpressionRet);
                                           if (isFirst) expr.setLine($u.start.getLine()); }
      | s=Sizeof LeftParen t=typeName RightParen { expr = new SizeofTypeNameExpression($t.typeNameRet);
                                                   if (isFirst) expr.setLine($s.line); }
    ) { if (!isFirst) expr.setLine(line);
        $expressionRet = new NestedUnaryExpression(ops, expr);
        $expressionRet.setLine(expr.getLine()); }
  | l=LeftParen t=typeName RightParen c=castExpression { $expressionRet = new CastExpression($t.typeNameRet, $c.castExpressionRet);
                                                         $expressionRet.setLine($l.line); }
  | e1=expression { BinaryOperator op = null; } (Star { op = BinaryOperator.STAR; } | Div { op = BinaryOperator.DIV; } | Mod { op = BinaryOperator.MOD; })
    e2=expression { $expressionRet = new BinaryExpression($e1.expressionRet, op, $e2.expressionRet);
                    $expressionRet.setLine($e1.expressionRet.getLine()); }
  | e1=expression { BinaryOperator op = null; } (Plus { op = BinaryOperator.PLUS; } | Minus { op = BinaryOperator.MINUS; })
    e2=expression { $expressionRet = new BinaryExpression($e1.expressionRet, op, $e2.expressionRet);
                    $expressionRet.setLine($e1.expressionRet.getLine()); }
  | e1=expression { BinaryOperator op = null; } (LeftShift { op = BinaryOperator.LEFT_SHIFT; } | RightShift { op = BinaryOperator.RIGHT_SHIFT; })
    e2=expression { $expressionRet = new BinaryExpression($e1.expressionRet, op, $e2.expressionRet);
                    $expressionRet.setLine($e1.expressionRet.getLine()); }
  | e1=expression { BinaryOperator op = null; } (Less { op = BinaryOperator.LESS; } | Greater { op = BinaryOperator.GREATER; } | LessEqual { op = BinaryOperator.LESS_EQUAL; } | GreaterEqual { op = BinaryOperator.GREATER_EQUAL; })
    e2=expression { $expressionRet = new BinaryExpression($e1.expressionRet, op, $e2.expressionRet);
                    $expressionRet.setLine($e1.expressionRet.getLine()); }
  | e1=expression { BinaryOperator op = null; } (Equal { op = BinaryOperator.EQUAL; } | NotEqual { op = BinaryOperator.NOT_EQUAL; })
    e2=expression { $expressionRet = new BinaryExpression($e1.expressionRet, op, $e2.expressionRet);
                    $expressionRet.setLine($e1.expressionRet.getLine()); }
  | e1=expression And e2=expression { $expressionRet = new BinaryExpression($e1.expressionRet, BinaryOperator.AND, $e2.expressionRet);
                                      $expressionRet.setLine($e1.expressionRet.getLine()); }
  | e1=expression Xor e2=expression { $expressionRet = new BinaryExpression($e1.expressionRet, BinaryOperator.XOR, $e2.expressionRet);
                                      $expressionRet.setLine($e1.expressionRet.getLine()); }
  | e1=expression Or e2=expression { $expressionRet = new BinaryExpression($e1.expressionRet, BinaryOperator.OR, $e2.expressionRet);
                                     $expressionRet.setLine($e1.expressionRet.getLine()); }
  | e1=expression AndAnd e2=expression { $expressionRet = new BinaryExpression($e1.expressionRet, BinaryOperator.AND_AND, $e2.expressionRet);
                                         $expressionRet.setLine($e1.expressionRet.getLine()); }
  | e1=expression OrOr e2=expression { $expressionRet = new BinaryExpression($e1.expressionRet, BinaryOperator.OR_OR, $e2.expressionRet);
                                       $expressionRet.setLine($e1.expressionRet.getLine()); }
  | e1=expression Question e2=expression Colon e3=expression { $expressionRet = new QuestionColonExpression($e1.expressionRet, $e2.expressionRet, $e3.expressionRet);
                                                               $expressionRet.setLine($e1.expressionRet.getLine()); }
  | e1=expression ass=assignmentOperator e2=expression { $expressionRet = new AssignmentExpression($e1.expressionRet, $ass.assignmentOperatorRet, $e2.expressionRet);
                                                         $expressionRet.setLine($e1.expressionRet.getLine()); }
//  | e1=expression { $expressionRet = new CommaExpression();
//                    ((CommaExpression)$expressionRet).addExpression($e1.expressionRet);
//                     $expressionRet.setLine($e1.expressionRet.getLine()); }
//    (Comma e2=expression { ((CommaExpression)$expressionRet).addExpression($e2.expressionRet); })+
  ;

argumentExpressionList returns [ArrayList<Expression> argumentExpressionListRet]
  : { $argumentExpressionListRet = new ArrayList<Expression>(); }
    e1=expression { $argumentExpressionListRet.add($e1.expressionRet); }
    (Comma e2=expression { $argumentExpressionListRet.add($e2.expressionRet); })*
  ;

unaryOperator returns [UnaryOperator unaryOperatorRet]
  : And { $unaryOperatorRet = UnaryOperator.AND; }
  | Star { $unaryOperatorRet = UnaryOperator.STAR; }
  | Plus { $unaryOperatorRet = UnaryOperator.PLUS; }
  | Minus { $unaryOperatorRet = UnaryOperator.MINUS; }
  | Tilde { $unaryOperatorRet = UnaryOperator.TILDE; }
  | Not { $unaryOperatorRet = UnaryOperator.NOT; }
  ;

castExpression returns [Expression castExpressionRet]
  : l=LeftParen t=typeName RightParen c=castExpression { $castExpressionRet = new CastExpression($t.typeNameRet, $c.castExpressionRet);
                                                         $castExpressionRet.setLine($l.line); }
  | e=expression { $castExpressionRet = $e.expressionRet;
                   $castExpressionRet.setLine($e.expressionRet.getLine()); }
  | d=DigitSequence { $castExpressionRet = new IntegerConstant($d.int);
                      $castExpressionRet.setLine($d.line); }
  ;

assignmentOperator returns [AssignmentOperator assignmentOperatorRet]
  : Assign { $assignmentOperatorRet = AssignmentOperator.ASSIGN; }
  | StarAssign { $assignmentOperatorRet = AssignmentOperator.STAR_ASSIGN; }
  | DivAssign { $assignmentOperatorRet = AssignmentOperator.DIV_ASSIGN; }
  | ModAssign { $assignmentOperatorRet = AssignmentOperator.MOD_ASSIGN; }
  | PlusAssign { $assignmentOperatorRet = AssignmentOperator.PLUS_ASSIGN; }
  | MinusAssign { $assignmentOperatorRet = AssignmentOperator.MINUS_ASSIGN; }
  | LeftShiftAssign { $assignmentOperatorRet = AssignmentOperator.LEFT_SHIFT_ASSIGN; }
  | RightShiftAssign { $assignmentOperatorRet = AssignmentOperator.RIGHT_SHIFT_ASSIGN; }
  | AndAssign { $assignmentOperatorRet = AssignmentOperator.AND_ASSIGN; }
  | XorAssign { $assignmentOperatorRet = AssignmentOperator.XOR_ASSIGN; }
  | OrAssign { $assignmentOperatorRet = AssignmentOperator.OR_ASSIGN; }
  ;

declaration returns [Declaration declarationRet]
    : d=declarationSpecifiers { $declarationRet = new Declaration($d.declarationSpecifiersRet);
                                $declarationRet.setLine($d.declarationSpecifiersRet.get(0).getLine()); }
      (i=initDeclaratorList { $declarationRet.setInitDeclarators($i.initDeclaratorListRet); })?
      Semi
    ;

declarationSpecifiers returns [ArrayList<DeclarationSpecifier> declarationSpecifiersRet]
    : { $declarationSpecifiersRet = new ArrayList<DeclarationSpecifier>(); }
      (d=declarationSpecifier { $declarationSpecifiersRet.add($d.declarationSpecifierRet); })+
    ;

declarationSpecifier returns [DeclarationSpecifier declarationSpecifierRet]
    : ty=Typedef { Typedefs t = new Typedefs();
                $declarationSpecifierRet = new DeclarationSpecifier(t);
                $declarationSpecifierRet.setLine($ty.line); }
    | ts=typeSpecifier { $declarationSpecifierRet = new DeclarationSpecifier($ts.typeSpecifierRet);
                         $declarationSpecifierRet.setLine($ts.typeSpecifierRet.getLine()); }
    | co=Const { Consts c = new Consts();
              $declarationSpecifierRet = new DeclarationSpecifier(c);
              $declarationSpecifierRet.setLine($co.line); }
    ;

initDeclaratorList returns [ArrayList<InitDeclarator> initDeclaratorListRet]
    : { $initDeclaratorListRet = new ArrayList<InitDeclarator>(); }
      i1=initDeclarator { $initDeclaratorListRet.add($i1.initDeclaratorRet); }
      (Comma i2=initDeclarator { $initDeclaratorListRet.add($i2.initDeclaratorRet); })*
    ;

initDeclarator returns [InitDeclarator initDeclaratorRet]
    : d=declarator { $initDeclaratorRet = new InitDeclarator($d.declaratorRet);
                     $initDeclaratorRet.setLine($d.declaratorRet.getLine()); }
      (Assign i=initializer { $initDeclaratorRet.setInitializer($i.initializerRet); })?
    ;

typeSpecifier returns [TypeSpecifier typeSpecifierRet]
    : v=Void { $typeSpecifierRet = new TypeSpecifier($v.text);
               $typeSpecifierRet.setLine($v.line); }
    | c=Char { $typeSpecifierRet = new TypeSpecifier($c.text);
               $typeSpecifierRet.setLine($c.line); }
    | s=Short { $typeSpecifierRet = new TypeSpecifier($s.text);
                $typeSpecifierRet.setLine($s.line); }
    | i=Int { $typeSpecifierRet = new TypeSpecifier($i.text);
               $typeSpecifierRet.setLine($i.line); }
    | l=Long { $typeSpecifierRet = new TypeSpecifier($l.text);
               $typeSpecifierRet.setLine($l.line); }
    | f=Float { $typeSpecifierRet = new TypeSpecifier($f.text);
                $typeSpecifierRet.setLine($f.line); }
    | d=Double { $typeSpecifierRet = new TypeSpecifier($d.text);
                 $typeSpecifierRet.setLine($d.line); }
    | s=Signed { $typeSpecifierRet = new TypeSpecifier($s.text);
                 $typeSpecifierRet.setLine($s.line); }
    | u=Unsigned { $typeSpecifierRet = new TypeSpecifier($u.text);
                   $typeSpecifierRet.setLine($u.line); }
    | b=Bool { $typeSpecifierRet = new TypeSpecifier($b.text);
               $typeSpecifierRet.setLine($b.line); }
    | id=Identifier { $typeSpecifierRet = new TypeSpecifier($id.text);
                      $typeSpecifierRet.setLine($id.line); }
    ;

specifierQualifierList returns [ArrayList<Type> specifierQualifierListRet]
    : { $specifierQualifierListRet = new ArrayList<Type>(); }
      (t=typeSpecifier { $specifierQualifierListRet.add($t.typeSpecifierRet); }
       | Const { Consts c = new Consts();
                 $specifierQualifierListRet.add(c); })
      (s=specifierQualifierList { for (Type t : $s.specifierQualifierListRet) $specifierQualifierListRet.add(t); })?
    ;

declarator returns [Declarator declaratorRet]
    : { $declaratorRet = new Declarator();
        boolean isFirst = true; }
      (p=pointer { ((Declarator)$declaratorRet).setPointer($p.pointerRet);
                    $declaratorRet.setLine($p.pointerRet.getLine());
                    isFirst = false; })?
      d=directDeclarator { $declaratorRet.setDirectDeclarator($d.directDeclaratorRet);
                           if (isFirst) $declaratorRet.setLine($d.directDeclaratorRet.getLine()); }
    ;

directDeclarator returns [DirectDeclarator directDeclaratorRet]
    : id=Identifier { $directDeclaratorRet = new IdentifierDeclarator($id.text);
                      $directDeclaratorRet.setLine($id.line); }
    | l=LeftParen d=declarator RightParen { $directDeclaratorRet = new NestedDeclarator($d.declaratorRet);
                                            $directDeclaratorRet.setLine($l.line); }
    | dd1=directDeclarator { $directDeclaratorRet = new ArrayDeclarator($dd1.directDeclaratorRet);
                             $directDeclaratorRet.setLine($dd1.directDeclaratorRet.getLine()); }
      LeftBracket (e=expression { ((ArrayDeclarator)$directDeclaratorRet).setExpression($e.expressionRet); })? RightBracket
    | dd2=directDeclarator { $directDeclaratorRet = new FunctionDeclarator($dd2.directDeclaratorRet);
                             $directDeclaratorRet.setLine($dd2.directDeclaratorRet.getLine()); }
      LeftParen  (p=parameterList { ((FunctionDeclarator)$directDeclaratorRet).setParameters($p.parameterListRet); }
                  | (i=identifierList { ((FunctionDeclarator)$directDeclaratorRet).setIdentifiers($i.identifierListRet); })?) RightParen
    ;

pointer returns [Pointer pointerRet]
    : { $pointerRet = new Pointer();
        boolean isFirst = true; }
      (s=Star { $pointerRet.addPointer($s.text);
                if (isFirst) {
                    $pointerRet.setLine($s.line);
                    isFirst = false;
                } }
       ((c=Const { $pointerRet.addPointer($c.text); })+)?)+
    ;

parameterList returns [ArrayList<ParameterDeclaration> parameterListRet]
    : { $parameterListRet = new ArrayList<ParameterDeclaration>(); }
      p1=parameterDeclaration { $parameterListRet.add($p1.parameterDeclarationRet); }
      (Comma p2=parameterDeclaration { $parameterListRet.add($p2.parameterDeclarationRet); })*
    ;

parameterDeclaration returns [ParameterDeclaration parameterDeclarationRet]
    : ds=declarationSpecifiers { $parameterDeclarationRet = new ParameterDeclaration($ds.declarationSpecifiersRet);
                                 $parameterDeclarationRet.setLine($ds.declarationSpecifiersRet.get(0).getLine()); }
      (d=declarator { $parameterDeclarationRet.setDeclarator($d.declaratorRet); }
       | (a=abstractDeclarator { $parameterDeclarationRet.setAbstractDeclarator($a.abstractDeclaratorRet); })?)
    ;

identifierList returns [ArrayList<String> identifierListRet]
    : { $identifierListRet = new ArrayList<String>(); }
      id1=Identifier { $identifierListRet.add($id1.text); }
      (Comma id2=Identifier { $identifierListRet.add($id2.text); })*
    ;

typeName returns [TypeName typeNameRet]
    : s=specifierQualifierList { $typeNameRet = new TypeName($s.specifierQualifierListRet);
                                 $typeNameRet.setLine($s.specifierQualifierListRet.get(0).getLine()); }
      (a=abstractDeclarator { $typeNameRet.setAbstractDeclarator($a.abstractDeclaratorRet); })?
    ;

abstractDeclarator returns [AbstractDeclarator abstractDeclaratorRet]
    : { $abstractDeclaratorRet = new AbstractDeclarator(); }
      p1=pointer { ((AbstractDeclarator)$abstractDeclaratorRet).setPointer($p1.pointerRet);
                   $abstractDeclaratorRet.setLine($p1.pointerRet.getLine()); }
    | { $abstractDeclaratorRet = new AbstractDeclarator();
        boolean isFirst = true; }
      (p2=pointer { ((AbstractDeclarator)$abstractDeclaratorRet).setPointer($p2.pointerRet);
                    $abstractDeclaratorRet.setLine($p2.pointerRet.getLine());
                    isFirst = false; })?
      d=directAbstractDeclarator { $abstractDeclaratorRet.setDirectAbstractDeclarator($d.directAbstractDeclaratorRet);
                                   if (isFirst) $abstractDeclaratorRet.setLine($d.directAbstractDeclaratorRet.getLine()); }
    ;

directAbstractDeclarator returns [DirectAbstractDeclarator directAbstractDeclaratorRet]
    : { $directAbstractDeclaratorRet = new ExpressionAbstractDeclarator(); }
      l=LeftBracket (e1=expression { ((ExpressionAbstractDeclarator)$directAbstractDeclaratorRet).setExpression($e1.expressionRet); })? RightBracket
      { $directAbstractDeclaratorRet.setLine($l.line); }
    | { $directAbstractDeclaratorRet = new NestedAbstractDeclarator(); }
      l=LeftParen  (a=abstractDeclarator { ((NestedAbstractDeclarator)$directAbstractDeclaratorRet).setAbstractDeclarator($a.abstractDeclaratorRet); }
                  | (pl1=parameterList { ((NestedAbstractDeclarator)$directAbstractDeclaratorRet).setParameters($pl1.parameterListRet); })?) RightParen
      { $directAbstractDeclaratorRet.setLine($l.line); }
    | dd1=directAbstractDeclarator { $directAbstractDeclaratorRet = new ArrayAbstractDeclarator($dd1.directAbstractDeclaratorRet); }
      LeftBracket (e2=expression { ((ArrayAbstractDeclarator)$directAbstractDeclaratorRet).setExpression($e2.expressionRet); })? RightBracket
      { $directAbstractDeclaratorRet.setLine($dd1.directAbstractDeclaratorRet.getLine()); }
    | dd2=directAbstractDeclarator { $directAbstractDeclaratorRet = new FunctionAbstractDeclarator($dd2.directAbstractDeclaratorRet); }
      LeftParen (pl2=parameterList { ((FunctionAbstractDeclarator)$directAbstractDeclaratorRet).setParameters($pl2.parameterListRet); })? RightParen
      { $directAbstractDeclaratorRet.setLine($dd2.directAbstractDeclaratorRet.getLine()); }
    ;

initializer returns [Initializer initializerRet]
    : e=expression { $initializerRet = new ExpressionInitializer($e.expressionRet);
                     $initializerRet.setLine($e.expressionRet.getLine()); }
    | l=LeftBrace i=initializerList Comma? RightBrace { $initializerRet = new NestedInitializer($i.initializerListRet);
                                                        $initializerRet.setLine($l.line); }
    ;

initializerList returns [ArrayList<DesignationInitializer> initializerListRet]
    : { $initializerListRet = new ArrayList<DesignationInitializer>();
        ArrayList<Designator> desig1 = new ArrayList<Designator>(); }
      (d1=designation { desig1 = $d1.designationRet; })?
      i1=initializer { DesignationInitializer tuple1 = new DesignationInitializer(desig1, $i1.initializerRet);
                       $initializerListRet.add(tuple1); }
      ({ ArrayList<Designator> desig2 = new ArrayList<Designator>(); }
       Comma (d2=designation { desig2 = $d2.designationRet; })?
       i2=initializer { DesignationInitializer tuple2 = new DesignationInitializer(desig2, $i2.initializerRet);
                        $initializerListRet.add(tuple2); })*
    ;

designation returns [ArrayList<Designator> designationRet]
    : { $designationRet = new ArrayList<Designator>(); }
      (d=designator { $designationRet.add($d.designatorRet); })+ Assign
    ;

designator returns [Designator designatorRet]
    : l=LeftBracket e=expression RightBracket { $designatorRet = new ExpressionDesignator($e.expressionRet);
                                                $designatorRet.setLine($l.line); }
    | d=Dot id=Identifier { $designatorRet = new IdentifierDesignator($id.text);
                            $designatorRet.setLine($d.line); }
    ;

statement returns [Statement statementRet]
    : c=compoundStatement { $statementRet = $c.compoundStatementRet; }
    | e=expressionStatement { $statementRet = $e.expressionStatementRet; }
    | s=selectionStatement { $statementRet = $s.selectionStatementRet; }
    | i=iterationStatement { $statementRet = $i.iterationStatementRet; }
    | j=jumpStatement { $statementRet = $j.jumpStatementRet; }
    ;

compoundStatement returns [CompoundStatement compoundStatementRet]
    : { $compoundStatementRet = new CompoundStatement(); }
      l=LeftBrace ((b=blockItem { ((CompoundStatement)$compoundStatementRet).addBlockItem($b.blockItemRet); })+)? RightBrace
      { $compoundStatementRet.setLine($l.line); }
    ;

blockItem returns [Node blockItemRet]
    : s=statement { $blockItemRet = $s.statementRet; }
    | d=declaration { $blockItemRet = $d.declarationRet; }
    ;

expressionStatement returns [ExpressionStatement expressionStatementRet]
    : { $expressionStatementRet = new ExpressionStatement();
        boolean isFirst = true; }
      (e=expression { $expressionStatementRet.setExpression($e.expressionRet);
                      $expressionStatementRet.setLine($e.expressionRet.getLine());
                      isFirst = false; })?
      s=Semi { if (isFirst) $expressionStatementRet.setLine($s.line); }
    ;

selectionStatement returns [SelectionStatement selectionStatementRet]
    : i=If LeftParen e=expression RightParen s1=statement { $selectionStatementRet = new SelectionStatement($e.expressionRet, $s1.statementRet);
                                                            $selectionStatementRet.setIfLine($i.line); }
      (el=Else s2=statement { $selectionStatementRet.setElseStatement($s2.statementRet);
                              $selectionStatementRet.setElseLine($el.line); })?
    ;

iterationStatement returns [IterationStatement iterationStatementRet]
    : w=While LeftParen e=expression RightParen s=statement { $iterationStatementRet = new WhileIteration($e.expressionRet, $s.statementRet);
                                                              $iterationStatementRet.setLine($w.line); }
    | d=Do s=statement While LeftParen e=expression RightParen Semi { $iterationStatementRet = new DoWhileIteration($s.statementRet, $e.expressionRet);
                                                                      $iterationStatementRet.setLine($d.line); }
    | fo=For LeftParen f=forCondition RightParen s=statement { $iterationStatementRet = new ForIteration($f.forConditionRet, $s.statementRet);
                                                               $iterationStatementRet.setLine($fo.line); }
    ;

forCondition returns [ForCondition forConditionRet]
    : { $forConditionRet = new ForCondition();
        boolean isFirst = true; }
      (fd=forDeclaration { $forConditionRet.setInitial($fd.forDeclarationRet);
                           $forConditionRet.setLine($fd.forDeclarationRet.getLine());
                           isFirst = false; }
       | (e=expression { $forConditionRet.setInitial($e.expressionRet);
                         $forConditionRet.setLine($e.expressionRet.getLine());
                         isFirst = false; })?) Semi
      (fe1=forExpression { $forConditionRet.setConditions($fe1.forExpressionRet);
                           if (isFirst) {
                            $forConditionRet.setLine($fe1.forExpressionRet.get(0).getLine());
                            isFirst = false;
                           } })? Semi
      (fe2=forExpression { $forConditionRet.setUpdates($fe2.forExpressionRet);
                           if (isFirst) {
                               $forConditionRet.setLine($fe1.forExpressionRet.get(0).getLine());
                               isFirst = false;
                           } })?
    ;

forDeclaration returns [Declaration forDeclarationRet]
    : d=declarationSpecifiers { $forDeclarationRet = new Declaration($d.declarationSpecifiersRet);
                                $forDeclarationRet.setLine($d.declarationSpecifiersRet.get(0).getLine()); }
      (i=initDeclaratorList { $forDeclarationRet.setInitDeclarators($i.initDeclaratorListRet); })?
    ;

forExpression returns [ArrayList<Expression> forExpressionRet]
    : { $forExpressionRet = new ArrayList<Expression>(); }
      e1=expression { $forExpressionRet.add($e1.expressionRet); }
      (Comma e2=expression { $forExpressionRet.add($e2.expressionRet); })*
    ;

jumpStatement returns [JumpStatement jumpStatementRet]
    : (c=Continue { $jumpStatementRet = new ContinueJump();
                    $jumpStatementRet.setLine($c.line); }
       | b=Break { $jumpStatementRet = new BreakJump();
                   $jumpStatementRet.setLine($b.line); }
       | r=Return { $jumpStatementRet = new ReturnJump();
                    $jumpStatementRet.setLine($r.line); }
        (e=expression { ((ReturnJump)$jumpStatementRet).setExpression($e.expressionRet); })?)
      Semi
    ;

Break                 : 'break'                 ;
Char                  : 'char'                  ;
Const                 : 'const'                 ;
Continue              : 'continue'              ;
Do                    : 'do'                    ;
Double                : 'double'                ;
Else                  : 'else'                  ;
Float                 : 'float'                 ;
For                   : 'for'                   ;
If                    : 'if'                    ;
Int                   : 'int'                   ;
Long                  : 'long'                  ;
Return                : 'return'                ;
Short                 : 'short'                 ;
Signed                : 'signed'                ;
Sizeof                : 'sizeof'                ;
Switch                : 'switch'                ;
Typedef               : 'typedef'               ;
Unsigned              : 'unsigned'              ;
Void                  : 'void'                  ;
While                 : 'while'                 ;
Bool                  : 'bool'                  ;
LeftParen             : '('                     ;
RightParen            : ')'                     ;
LeftBracket           : '['                     ;
RightBracket          : ']'                     ;
LeftBrace             : '{'                     ;
RightBrace            : '}'                     ;
Less                  : '<'                     ;
LessEqual             : '<='                    ;
Greater               : '>'                     ;
GreaterEqual          : '>='                    ;
LeftShift             : '<<'                    ;
RightShift            : '>>'                    ;
Plus                  : '+'                     ;
PlusPlus              : '++'                    ;
Minus                 : '-'                     ;
MinusMinus            : '--'                    ;
Star                  : '*'                     ;
Div                   : '/'                     ;
Mod                   : '%'                     ;
And                   : '&'                     ;
Or                    : '|'                     ;
AndAnd                : '&&'                    ;
OrOr                  : '||'                    ;
Xor                   : '^'                     ;
Not                   : '!'                     ;
Tilde                 : '~'                     ;
Question              : '?'                     ;
Colon                 : ':'                     ;
Semi                  : ';'                     ;
Comma                 : ','                     ;
Assign                : '='                     ;
StarAssign            : '*='                    ;
DivAssign             : '/='                    ;
ModAssign             : '%='                    ;
PlusAssign            : '+='                    ;
MinusAssign           : '-='                    ;
LeftShiftAssign       : '<<='                   ;
RightShiftAssign      : '>>='                   ;
AndAssign             : '&='                    ;
XorAssign             : '^='                    ;
OrAssign              : '|='                    ;
Equal                 : '=='                    ;
NotEqual              : '!='                    ;
Arrow                 : '->'                    ;
Dot                   : '.'                     ;

Identifier
    : IdentifierNondigit (IdentifierNondigit | Digit)* ;

fragment IdentifierNondigit
    : Nondigit | UniversalCharacterName ;

fragment Nondigit
    : [a-zA-Z_] ;

fragment Digit
    : [0-9] ;

fragment UniversalCharacterName
    : '\\u' HexQuad | '\\U' HexQuad HexQuad ;

fragment HexQuad
    : HexadecimalDigit HexadecimalDigit HexadecimalDigit HexadecimalDigit ;

Constant
    : IntegerConstant | FloatingConstant | CharacterConstant ;

fragment IntegerConstant
    : DecimalConstant IntegerSuffix?
    | OctalConstant IntegerSuffix?
    | HexadecimalConstant IntegerSuffix?
    | BinaryConstant ;

fragment BinaryConstant
    : '0' [bB] [0-1]+ ;

fragment DecimalConstant
    : NonzeroDigit Digit* ;

fragment OctalConstant
    : '0' OctalDigit* ;

fragment HexadecimalConstant
    : HexadecimalPrefix HexadecimalDigit+ ;

fragment HexadecimalPrefix
    : '0' [xX] ;

fragment NonzeroDigit
    : [1-9] ;

fragment OctalDigit
    : [0-7] ;

fragment HexadecimalDigit
    : [0-9a-fA-F] ;

fragment IntegerSuffix
    : UnsignedSuffix LongSuffix? | UnsignedSuffix LongLongSuffix | LongSuffix UnsignedSuffix? | LongLongSuffix UnsignedSuffix? ;

fragment UnsignedSuffix
    : [uU] ;

fragment LongSuffix
    : [lL] ;

fragment LongLongSuffix
    : 'll' | 'LL' ;

fragment FloatingConstant
    : DecimalFloatingConstant | HexadecimalFloatingConstant ;

fragment DecimalFloatingConstant
    : FractionalConstant ExponentPart? FloatingSuffix? | DigitSequence ExponentPart FloatingSuffix? ;

fragment HexadecimalFloatingConstant
    : HexadecimalPrefix (HexadecimalFractionalConstant | HexadecimalDigitSequence) BinaryExponentPart FloatingSuffix? ;

fragment FractionalConstant
    : DigitSequence? Dot DigitSequence | DigitSequence Dot ;

fragment ExponentPart
    : [eE] Sign? DigitSequence ;

fragment Sign
    : [+-] ;

DigitSequence
    : Digit+ ;

fragment HexadecimalFractionalConstant
    : HexadecimalDigitSequence? Dot HexadecimalDigitSequence | HexadecimalDigitSequence Dot ;

fragment BinaryExponentPart
    : [pP] Sign? DigitSequence ;

fragment HexadecimalDigitSequence
    : HexadecimalDigit+ ;

fragment FloatingSuffix
    : [flFL] ;

fragment CharacterConstant
    : '\'' CCharSequence '\'' | 'L\'' CCharSequence '\''| 'u\'' CCharSequence '\'' | 'U\'' CCharSequence '\'' ;

fragment CCharSequence
    : CChar+ ;

fragment CChar
    : ~['\\\r\n] | EscapeSequence ;

fragment EscapeSequence
    : SimpleEscapeSequence | OctalEscapeSequence | HexadecimalEscapeSequence | UniversalCharacterName ;

fragment SimpleEscapeSequence
    : '\\' ['"?abfnrtv\\] ;

fragment OctalEscapeSequence
    : '\\' OctalDigit OctalDigit? OctalDigit? ;

fragment HexadecimalEscapeSequence
    : '\\x' HexadecimalDigit+ ;

StringLiteral
    : EncodingPrefix? '"' SCharSequence? '"' ;

fragment EncodingPrefix
    : 'u8' | 'u' | 'U' | 'L' ;

fragment SCharSequence
    : SChar+ ;

fragment SChar
    : ~["\\\r\n] | EscapeSequence | '\\\n' | '\\\r\n' ;

MultiLineMacro
    : '#' (~[\n]*? '\\' '\r'? '\n')+ ~ [\n]+ -> channel(HIDDEN) ;

Directive
    : '#' ~[\n]* -> channel(HIDDEN) ;

Whitespace
    : [ \t]+ -> channel(HIDDEN) ;

Newline
    : ('\r' '\n'? | '\n') -> channel(HIDDEN) ;

BlockComment
    : '/*' .*? '*/' -> channel(HIDDEN) ;

LineComment
    : '//' ~[\r\n]* -> channel(HIDDEN) ;