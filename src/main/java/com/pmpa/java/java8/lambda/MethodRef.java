package com.pmpa.java.java8.lambda;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * Lambda体中调用方法的参数列表和返回值类型 要与函数式接口中抽象方法的函数列表和返回值类型保持一致。
 * 
 * @author natty
 *
 */

public class MethodRef {
	
	// 对象::实例方法  方法引用
	@Test
	public void test1() {
		Employee emp = new Employee("Honda",23,5000);
		Supplier<String> sup = () -> emp.getName();
		// Lambda体中的内容emp的getName方法已经实现了，可以使用方法引用
		Supplier<String> sup2 = emp::getName;
		System.out.println(sup2.get());		
	}
	
	// 类::静态方法   方法引用
	@Test
	public void test2() {
		//compare()方法是Integer类的一个静态方法   lambda体的实现使用Integer.compare方法实现。
		Comparator<Integer> com = Integer::compare;
		Comparator<Integer> com1 = (x,y) -> Integer.compare(x, y);
		System.out.println(com.compare(10, 200));
	}
	
	// 类:: 实例方法   方法引用
	@Test
	public void test3() {
		BiPredicate<String,String> bip = (x,y) -> x.equals(y);
		//使用类::实例方法  方式来简化
		//若Lambda参数列表中的第一参数是实例方法(equals)的调用者，第二个参数是实例方法的参数时，可以使用ClassName::method
		BiPredicate<String,String> bip2 = String::equals;
		System.out.println(bip.test("Juventus", "Juventus"));
	}
	
	//构造器应用
	@Test
	public void test4() {
		//使用函数式接口创建对象
		Supplier<Employee> sup = () -> new Employee();
		//因为Supplier接口的方法是无参有返回值，那么对应的Employee::new 也会使用Employee的无参构造器
		Supplier<Employee> sup1 = Employee::new;
		Employee emp1 = sup1.get();
		System.out.println(emp1);
		
		//func是有一个参数，一个返回值的函数式接口，那会调用Employee包含一个参数的构造方法。
		Function<String,Employee> func = (c) -> new Employee(c);
		Function<String,Employee> func2 = Employee::new;
		Employee sg = func2.apply("Liverpool");
		System.out.println(sg);
	}
	
	//数组应用
	@Test 
	public void test5() {
		Function<Integer,String[]> func = (x) -> new String[x]; 
		Function<Integer,String[]> func2 = String[]::new; 
		
		String[] chelsea = func2.apply(20);
		System.out.println(chelsea.length);
	}

}
