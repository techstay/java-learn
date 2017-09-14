package yitian.study.java8.lambda;

@FunctionalInterface
interface Interface1 {
    void f();
}


@FunctionalInterface
interface Interface2 {
    void f(int a);
}

@FunctionalInterface
interface Interface3 {
    void f(int a, int b);
}

@FunctionalInterface
interface Interface4 {
    int f(int a, int b);
}

@FunctionalInterface
interface Interface5 {
    void f();

    String toString();
}

