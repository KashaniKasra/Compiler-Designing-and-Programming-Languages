
//no errors

FuncDec first_func(){
    int apple;
    apple = 10;
    int x;
    x=6;
    return apple + x;
}

FuncDec second_func(){
    return 3;
}

FuncDec third_func(){
    double banana;
    banana = 33 / second_func();
    return banana == 55;
}


main(){
    int test;
    test = first_func()++;
    bool first_bool;
    bool second_bool;
    first_bool = true || third_func();
    first_bool = test == first_func() && first_bool;
    int tmp;
    tmp = 55++ + 10 * first_func() + second_func();
    return tmp * test;
}