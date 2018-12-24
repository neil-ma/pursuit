package com.pmpa.java.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * 
 * @author natty Java中内置了一些函数式接口 ： 1. 消费型接口 Consumer<T>：消费型接口 有输入参数，但是无返回值，有来无回
 *         void accept(T t)
 * 
 *         2. 供给型接口 Supplier<T>: 供给型接口 没有输入参数，但是有返回值 T get() T
 * 
 *         3. 函数型接口 Function<T,R> 有一个参数，有一个返回值 R apply(T t)
 * 
 *         4. 断言型接口 Predicate<T> 有一个参数，返回布尔值结果 boolean test(T t)
 * 
 */

public class MainFunctionInterface {

	// 消费型接口测试。
	public void testConsumer(String test, Consumer<String> con) {
		con.accept(test);

	}

	// 测试供给型接口
	public String testSupplier(Supplier<String> sup) {
		return sup.get();
	}

	// 函数型接口
	public String testFunction(Integer ls, Function<Integer, String> func) {
		return func.apply(ls);
	}

	// 断言型接口
	public List<String> testPredicate(List<String> li, Predicate<String> pre) {
		List<String> re = new ArrayList<String>();
		for (String str : li) {
			if (pre.test(str))
				re.add(str);
		}
		return re;
	}

	@Test
	public void test1() {
		testConsumer("vipkid",(x) -> System.out.print("The choise for " + x)); 
	}

	@Test
	public void test2() {
		System.out.println(testSupplier(() -> "abc"));
	}

	@Test
	public void test3() {
		String phnics = testFunction(2000, (x) -> "The dollar using" + x);
		System.out.println(phnics);
	}

	@Test
	public void test4() {
		List<String> phs = Arrays.asList("US-Harvard", "UK-Cambrige", "US-Yale", "JP-Tokyo", "US-Duke");
		List<String> output = testPredicate(phs, (x) -> x.substring(0, 2).equals("US"));
		output.forEach(System.out::println);
	}
}
