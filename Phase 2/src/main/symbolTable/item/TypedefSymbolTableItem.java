package main.symbolTable.item;

public class TypedefSymbolTableItem extends SymbolTableItem {
    public static final String START_KEY = "Typedef_";
    private String newType;
    private String originalType;

    public TypedefSymbolTableItem(String newType, String originalType) {
        this.newType = newType;
        this.originalType = originalType;
    }

    @Override
    public String getKey() { return START_KEY + newType; }

    public String getNewType() { return newType; }

    public void setNewType(String newType) { this.newType = newType; }

    public String getOriginalType() { return originalType; }

    public void setOriginalType(String originalType) { this.originalType = originalType; }
}