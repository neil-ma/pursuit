package com.pmpa.java.java8.lambda;

import java.util.Comparator;
import java.util.function.Consumer;
import org.junit.Test;

/***
 * Lambda表达式的语法
 *   函数式接口：只有一个方法定义的接口。Lambda表达式针对实现函数式接口。
 *   
 *   Java8引入新的语法符号 -> ，该操作符称为箭头操作符或 Lambda 操作符
 *   箭头操作符将 Lambda 表达式拆分成两部分：
 *   	符号->左边： Lambda 表达式的参数列表
 *      符号->右边： Lambda 表达式中所需执行的功能， 即 Lambda 体
 *   
 *   语法格式一： 没有参数，没有返回值。（Runnable接口为例）
 *    	() -> System.out.println("Lambda Expression without para!");
 *   
 *   语法格式二： 一个参数，没有返回值。（java.util.function.Consumer接口为例）
 * 		(x) -> System.out.println(x);
 *      如果只有一个参数，可以将括号去掉，x -> System.out.println(x);
 *      
 *   语法格式三： 有两个以上的参数，有返回值，并且 Lambda 体中有多条语句 （java.util.Consumer接口为例）
 *   	Comparator<Integer> comp = (x,y) -> {
 *			System.out.println("Comparing "+x+" "+y+":");
 *			return Integer.compare(x, y);
 *		};
 *    
 *    语法格式四： 如果只有一条语句（有返回值），可以省略大括号 和 return
 *   
 * 
 * @author natty
 */

public class LambdaBasicPro {
	
	@Test
	public void test01(){
		Runnable ra = () -> System.out.println("Lambda Expression without para!");
		ra.run();
	}
	
	@Test
	public void test02() {
		Consumer<Integer> con = x -> System.out.println(x);
		con.accept(20);
	}
	
	@Test 
	public void test03() {
		Comparator<Integer> comp = (x,y) -> {
			System.out.println("Comparing "+x+" "+y+":");
			return Integer.compare(x, y);
		};
		System.out.println(comp.compare(1000, 100));
	}
	
	@Test
	public void test04() {
		Comparator<Integer> comp = (z,t) -> Integer.compare(z, t);
		System.out.println(comp.compare(1000, 100));
	}
	
	@Test
	public void test8() {
		String str  = "{\"category\":\"住宿服务;宾馆酒店;五星级宾馆\",\"idx\":0,\"queryId\":\"B00155MTKJ\",\"requestId\":\"8cf273c9c65f44f98c9d73f59ca1d0c7\",\"searchType\":2,\"source\":\"MAP_GD_SEARCH\",\"subIdx\":-1,\"timestamp\":1544025600000,\"type\":4003}";
		System.out.println(str);
	}

}
