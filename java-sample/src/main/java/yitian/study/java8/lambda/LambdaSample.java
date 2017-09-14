package yitian.study.java8.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class LambdaSample {
    static void firstLambda() {
        //匿名内部类
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("任务一");
            }
        };

        //lambda表达式
        Runnable task2 = () -> System.out.println("任务二");

    }

    static void lambdas() {
        //无参lambda
        Interface1 interface1 = new Interface1() {
            @Override
            public void f() {
                System.out.println("f");
            }
        };
        Interface1 lambda1 = () -> {
            System.out.println("f");
        };
        //如果方法体只有一行代码，可以省略大括号
        Interface1 lambda1a = () -> System.out.println("f");

        //一个参数的lambda
        Interface2 interface2 = new Interface2() {
            @Override
            public void f(int a) {
                System.out.println(a);
            }
        };
        Interface2 lambda2 = (a) -> System.out.println(a);
        Interface2 lambda2a = a -> System.out.println(a);
        Interface2 methodReference2 = System.out::println;

        //多个参数lambda
        Interface3 interface3 = new Interface3() {
            @Override
            public void f(int a, int b) {
                System.out.println(a + b);
            }
        };
        Interface3 lambda3 = (a, b) -> System.out.println(a + b);

        //带有返回值的lambda
        Interface4 interface4 = new Interface4() {
            @Override
            public int f(int a, int b) {
                return a + b;
            }
        };
        Interface4 lambda4 = (a, b) -> {
            return a + b;
        };
        Interface4 lambda4a = (a, b) -> a + b;
    }

    static void lambdaUsages() {
        //编写线程
        Runnable task = () -> System.out.println("简单的任务");
        Executor executor = Executors.newCachedThreadPool();
        executor.execute(task);

        //编写比较器
        List<Student> students = new ArrayList<>();
        students.add(new Student("yitian", 25));
        students.add(new Student("anna", 26));
        students.add(new Student("wang5", 24));

        students.sort((a, b) -> a.getAge() - b.getAge());
        System.out.println(students);

        students.sort(Comparator.comparing(Student::getName));
        System.out.println(students);

        students.sort(
                Comparator.comparing(Student::getName)
                        .thenComparing(Student::getAge));
        System.out.println(students);
    }

    public static void main(String[] args) {
        System.out.println("----------------");
        firstLambda();
        System.out.println("----------------");
        lambdas();
        System.out.println("----------------");
        lambdaUsages();
    }
}

class Student {
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {

        this.name = name;
        this.age = age;
    }
}