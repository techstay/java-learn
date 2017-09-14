package yitian.study.java8.stream;

import java.util.*;
import java.util.stream.*;

public class StreamSample {
    static void firstStream() {
        List<Integer> integers = new ArrayList<>();
        integers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        //获取大于5的 所有元素
        List<Integer> integersGreaterThan5 = new ArrayList<>();
        for (int i : integers) {
            if (i > 5) {
                integersGreaterThan5.add(i);
            }
        }
        System.out.println(integersGreaterThan5);

        integersGreaterThan5.clear();
        //使用流类库
        integersGreaterThan5 = integers.stream()
                .filter(i -> i > 5)
                .collect(Collectors.toList());
        System.out.println(integersGreaterThan5);

    }

    static void filter() {
        List<Integer> integers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(i -> i > 3)
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(integers);
    }

    static void map() {
        List<Integer> integers = Stream.of(1, 2, 3, 4, 5)
                .map(i -> i * i)
                .collect(Collectors.toList());
        System.out.println(integers);
    }

    static void flatmap() {
        List<Integer> integers = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(n -> n.stream())
                .collect(Collectors.toList());
        System.out.println(integers);
    }

    static void minAndMax() {
        int min = Stream.of(1, 2, 3, 4)
                .min(Comparator.comparingInt(i -> i)).get();
        int max = Stream.of(1, 2, 3, 4)
                .max(Comparator.comparingInt(i -> i)).get();
        System.out.println(String.format("max:%d,min:%d", max, min));
    }

    static void reduce() {
        int sum = Stream.of(1, 2, 3, 4, 5)
                .reduce((acc, e) -> acc + e)
                .get();
        System.out.println(String.format("sum:%d", sum));

        int product = Stream.of(1, 2, 3, 4, 5)
                .reduce(1, (acc, e) -> acc * e);
        System.out.println(String.format("product:%d", product));
    }

    static void predictOperation() {
        boolean allGreaterThan5 = Stream.of(1, 2, 3, 4, 5)
                .allMatch(i -> i > 5);
        System.out.println("allGreaterThan5:" + allGreaterThan5);

        boolean anyEqualsTo2 = Stream.of(1, 2, 3, 4, 5)
                .anyMatch(i -> i == 2);
        System.out.println("anyEqualsTo2:" + anyEqualsTo2);

        boolean noneLessThan0 = Stream.of(1, 2, 3, 4)
                .noneMatch(i -> i < 0);
        System.out.println("noneLessThan0:" + noneLessThan0);

        List<Integer> distinct = Stream.of(1, 1, 2, 3, 2, 4, 5)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinct);

        String list1 = Stream.of(1, 2, 3, 4, 5)
                .limit(3)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(list1);

        String list2 = Stream.of(1, 2, 3, 4, 5)
                .skip(3)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(list2);

    }

    static void basicTypeStream() {
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        LongStream longStream = LongStream.of(1, 2, 3, 4);
        DoubleStream doubleStream = DoubleStream.of(1.0, 2.0);

        int sum = Stream.of(1, 2, 3, 4)
                .mapToInt(i -> i)
                .reduce(0, (acc, e) -> acc + e);
        System.out.println(String.format("sum:%d", sum));
    }

    static void collect() {
        //获取集合
        List<Integer> integers = Stream.of(1, 2, 3, 4)
                .collect(Collectors.toList());
        Set<Integer> set = Stream.of(1, 2, 3)
                .collect(Collectors.toSet());
        //使用自己希望的集合
        ArrayList<Integer> integers2 = Stream.of(1, 2, 3)
                .collect(Collectors.toCollection(ArrayList::new));

        //获取值
        int max = Stream.of(1, 2, 3, 4)
                .collect(Collectors.maxBy(Comparator.comparing(i -> i)))
                .get();
        int min = Stream.of(1, 2, 3, 4)
                .collect(Collectors.minBy(Comparator.comparing(i -> i)))
                .get();
        double average = Stream.of(1, 2, 3, 4)
                .collect(Collectors.averagingDouble(Integer::doubleValue));
        int sum = Stream.of(1, 2, 3, 4)
                .collect(Collectors.summingInt(i -> i));
        System.out.println(
                String.format("max:%d,min:%d,average:%f,sum:%d", max, min, average, sum));

        //获取字符串
        String string = Stream.of(1, 2, 3, 4, 5)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(string);

        // 计数收集器
        long count = Stream.of(1, 2, 3)
                .collect(Collectors.counting());
        System.out.println("count:" + count);
    }

    static void partitioningBy() {
        Map<Boolean, List<Integer>> map = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println(map);
    }

    static void groupingBy() {
        Map<Integer, List<Integer>> map = Stream.of(21, 32, 43, 54, 11, 33, 22)
                .collect(Collectors.groupingBy(i -> i % 10));
        System.out.println(map);
    }

    static void multipleCollect() {
        //按个位数字分组，然后只获取十位数字
        Map<Integer, List<Integer>> map = Stream.of(21, 32, 43, 54, 11, 33, 22)
                .collect(Collectors.groupingBy(i -> i % 10,
                        Collectors.mapping(i -> i / 10, Collectors.toList())));
        System.out.println(map);

        //按个位数字分组，然后求各组的和
        Map<Integer, Integer> map2 = Stream.of(21, 32, 43, 54, 11, 33, 22)
                .collect(Collectors.groupingBy(i -> i % 10,
                        Collectors.summingInt(i -> i)));
        System.out.println(map2);
    }

    static void lazyEvaluation() {
        Stream.of(1, 2, 3, 4, 5)
                .filter(i -> i > 1)
                .filter(i -> {
                    System.out.print(i);
                    return i <= 3;
                });
        System.out.println();
        List<Integer> integers = Stream.of(1, 2, 3, 4, 5)
                .filter(i -> {
                    System.out.print(i);
                    return i > 1;
                })
                .filter(i -> {
                    System.out.print(i);
                    return i <= 3;
                })
                .collect(Collectors.toList());
        System.out.println();

        //如果需要在迭代的时候同时查看数据，可以使用peek
        Stream.of(1, 2, 3)
                .peek(i -> System.out.print(i))
                .filter(i -> i > 1)
                .collect(Collectors.toList());
        System.out.println();
    }

    static void iteration() {
        //传统for循环
        for (int i = 0; i < 3; ++i) {
            System.out.print(i);
        }
        System.out.println();

        IntStream.range(0, 3)
                .forEach(i -> System.out.print(i));
        System.out.println();
        IntStream.range(0, 3)
                .forEach(System.out::print);
        System.out.println();
    }

    static void parallel() {
        List<Integer> integers = IntStream.range(1, 101)
                .parallel()
                .filter(i -> i % 2 == 0)
                .boxed()
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        firstStream();
        filter();
        map();
        flatmap();
        minAndMax();
        reduce();
        predictOperation();
        basicTypeStream();
        collect();
        partitioningBy();
        groupingBy();
        multipleCollect();
        lazyEvaluation();
        iteration();
        parallel();
    }
}
