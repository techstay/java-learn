package yitian.study.java8;

public class OtherNewFeatures {
    static void interfaceDefaultMethod() {
        MyInterface1 notImplemented = new MyInterface1() {
        };
        MyInterface1 implemented = new MyInterface1() {
            @Override
            public void hello() {
                System.out.println("我很好");
            }
        };
        notImplemented.hello();
        implemented.hello();
    }

    static void interfaceStaticMethod() {
        MyInterface2.hello();
    }

    public static void main(String[] args) {
        interfaceDefaultMethod();
        interfaceStaticMethod();
        //Todo 还有一些新特性懒得写了，就这样吧
    }
}

interface MyInterface1 {
    default void hello() {
        System.out.println("你好啊");
    }
}

interface MyInterface2 {
    static void hello() {
        System.out.println("你好啊");
    }
}