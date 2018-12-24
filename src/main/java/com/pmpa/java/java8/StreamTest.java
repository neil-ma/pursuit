package com.pmpa.java.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 *  关于Stream API的一些练习。
 *  @date 2018-12-23
 */
public class StreamTest {

    /**
     *  1. 给定一个数字列表，返回每个数字的平方组成的列表，例如输入 1,3,7,8  返回 1,9,49,64
     * @param input_list   一个数字列表
     * @return             数字的平方组成的列表
     */
    public List<Integer> squareCal(List<Integer> input_list){
       Stream<Integer> st_in = input_list.stream();

       List<Integer> out_list =
               st_in.map(x -> x*x)
               .collect(Collectors.toList());
       return out_list;
    }

    /**
     *  2.使用map 和reduce方法 数一数流中有多少个Employee
     * @param emp   Employee对象列表
     * @return
     */
    public int CountEmp(List<Employee> emp){
        return emp.stream()
                .map(e -> 1)
                .reduce(0,(x,y ) -> x+y);
    }

    /**
     * 3. 使用基础类Trader, Transaction ，并使用Stream完成如下一些需求：
     * 1) 找出2011年发生的所有交易，并按照交易额排序（从低到高）
     * 2) 交易员都在哪些不同的城市工作过。
     * 3) 查找所有来自剑桥的交易员，并按照名字排序。
     * 4）返回所有交易员的姓名字符串，按字母排序。
     * 5) 打印生活在剑桥的交易员的交易额
     * 6）所有的交易中，最高的交易额是多少
     * 7）找到交易额最小的交易
     * 8）有没有在米兰工作的交易员。
     * */

    public void transactionTest(){

        //初始化基础测试数据
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

       List<Transaction> transactions =  Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

       System.out.println(" --------------------找出2011年发生的所有交易，并按照交易额排序（从低到高）--------------------");
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted((x,y) ->Integer.compare(x.getValue(),y.getValue()))
                .forEach(System.out::println);

        System.out.println(" --------------------交易员都在哪些不同的城市工作过--------------------");
        transactions.stream()
                .map(x ->x.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println(" --------------------查找所有来自剑桥的交易员，并按照名字排序--------------------");
        transactions.stream()
                .filter(x ->x.getTrader().getCity().equals("Cambridge"))
                .map(x -> x.getTrader() )
                .sorted((x,y) -> x.getName().compareTo(y.getName()))
                .distinct()
                .forEach(System.out::println);

        System.out.println(" --------------------返回所有交易员的姓名字符串，按字母排序--------------------");
        transactions.stream()
                .map(x -> x.getTrader().getName())
                .sorted((x,y) -> x.compareTo(y))
                .forEach(System.out::println);

        System.out.println(" --------------------打印生活在剑桥的交易员的交易额--------------------");
        transactions.stream()
                .filter(x -> x.getTrader().getCity().equals("Cambridge"))
                .map(x -> x.getValue())
                .forEach(System.out::println);

        System.out.println(" --------------------所有的交易中，最高的交易额是多少--------------------");
        Optional<Integer> max_value =  transactions.stream()
                .max((x,y) -> Integer.compare(x.getValue(),y.getValue()))
                .map(x -> x.getValue());
        System.out.println(max_value.get());


        System.out.println(" --------------------找到交易额最小的交易--------------------");
        Optional<Transaction> min_trans = transactions.stream()
                .min((x,y) -> Integer.compare(x.getValue(),y.getValue()))
                ;
        System.out.println(min_trans.get());

        System.out.println(" --------------------有没有在米兰工作的交易员--------------------");
        boolean Milan_exi = transactions.stream()
                .map(x -> x.getTrader())
                .anyMatch(x -> x.getCity().equals("Milan"));
        System.out.println(Milan_exi);

    }

    public static void main(String[] args) {
        StreamTest st_ob = new StreamTest();

        // 问题1 测试
        List<Integer> list = Arrays.asList(4,8,2,199,5,37);
        System.out.println(Arrays.toString(st_ob.squareCal(list).toArray()));

        //问题2 测试
        List<Employee> emp_list = Arrays.asList(
                new Employee("Joe",28000,31),
                new Employee("Denny",5000,36),
                new Employee("Lucy",5000,18),
                new Employee("Robin",400,7),
                new Employee("Cristina",40000,35),
                new Employee("Fancy",18000,55),
                new Employee("Lion",4000,26)
        );
        System.out.println(st_ob.CountEmp(emp_list));

        //问题3 测试：qa
        st_ob.transactionTest();
    }


}
