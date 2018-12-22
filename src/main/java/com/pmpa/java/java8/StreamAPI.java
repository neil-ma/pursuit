package com.pmpa.java.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI {

    private Employee[] emp = new Employee[]{
            new Employee("Joe",28000,31),
            new Employee("Lucy",5000,18),
            new Employee("Robin",400,7),
            new Employee("Cristina",40000,35),
            new Employee("Cristina",40000,35),
            new Employee("Fancy",18000,55),
            new Employee("Lion",4000,26)
    };
    /**
     * 演示创建Stream流的四种方式。
     */
    @Test
    public void test(){
        /**
        1. Collections(实现了Collections接口的类) 的 stream()方法
        和 parallelStream() 方法获取。
         */
        List<String> lis = new ArrayList<>();
        lis.add("Lucas");
        lis.add("Alice");
        lis.add("Jim");
        lis.add("Zeus");
        Stream<String> sl = lis.parallelStream();
        sl.forEach(System.out::println);

        /**
         * 2. 通过Arrays中的静态方法获取数组流
         */

        Stream<Employee> estr = Arrays.stream(emp);
        estr.forEach(System.out::println);

        /**
         * 3.通过Stream类的静态方法of获取数据流
         *
         * public static<T> Stream<T> of(T... values) {
         *         return Arrays.stream(values);
         *  }
         * T... 可变长参数，就是这个位置可以传入任意个该类型参数,简单来说就是个数组。
         *
         */
        Stream<Integer> estr1 = Stream.of(new Integer[]{5,6,7,2,1,9});
        estr1.forEach(System.out::println);

        /**
         * 4.由函数创建流，无限流。
         *   可以使用静态方法Stream.iterate() 和Stream.generate(), 创建无限流。
         *
         *  seed是种子，也就是初始值，后边UnaryOperator是一个Function函数式接口。
         *  public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
         *
         * public static<T> Stream<T> generate(Supplier<T> s)
         */

        Stream<Integer> si = Stream.iterate(0,x->x+2);
        si.limit(10).forEach(System.out::println);

        Stream si1 = Stream.generate(()->89);
        si1.limit(10).forEach(System.out::println);
    }

    /**
     * 演示Stream流的中间操作
     */
    @Test
    public void test02(){
        /**
         * 筛选和切片： filter,distinct,limit,skip;
         *
         * Stream<T> filter(Predicate<? super T> predicate);
         * Stream<T> limit(long maxSize);
         * Stream<T> distinct();
         * Stream<T> skip(long n);
         * skip: 跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补
         *
         * 内部迭代，迭代工作由Stream API完成。
         */
        //获取到流
        Stream<Employee> se = Arrays.stream(emp);
        se.filter((e)->e.getSalary()>10000)    //筛选大于10000工资的emp
                .limit(3)
                .distinct()
                .forEach(System.out::println);
        System.out.println("---------------------------------------------");
        //获取到流
        Stream<Employee> se1 = Arrays.stream(emp);
        se1.skip(2)
                .forEach(System.out::println);
    }


    public Stream<Character> str2CharStream(String str){
        List<Character> li = new ArrayList<>();

        for(Character ch : str.toCharArray()){
            li.add(ch);
        }
        return li.stream();
    }

    @Test
    public void test03(){
        /**
         * 映射操作
         *     map:接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
         * <R> Stream<R> map(Function<? super T, ? extends R> mapper);
         * <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
         *
         *
         */

        Integer[] sers = new Integer[]{9,8,3,2,1,34,76};
        Stream<Integer> st1 = Arrays.stream(sers);
        st1.map(x -> x+20)
                .map(x -> x+".3")
                .map(x -> Double.valueOf(x))
                .forEach(System.out::println);

        String[] sers1 = new String[]{"Alice","Bob","Christina","Rose","Peak"};
        Stream<String> st2 = Arrays.stream(sers1);
//        Stream<Stream<Character>>  ssc = st2.flatMap(x -> str2CharStream(x));


    }

}
