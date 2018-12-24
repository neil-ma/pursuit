package com.pmpa.java.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaTest {
    /**
     * 使用传统方法形式,该方法不能复用，一个业务逻辑需要创建一个方法。
     * @param employee
     * @return
     */
    public List<Employee> filterEmployeeBySalary(List<Employee> employee){
        List<Employee> emps = new ArrayList<Employee>();
        for (Employee emp : employee){
            if(emp.getSalary()>20000){
                emps.add(emp);
            }
        }
        return emps;
    }

    /**
     * 使用实现接口定义的方式来实现，该方法可以进行复用。用接口  FilterBusi mg 来筛选。
     * @param employee
     * @param mg
     * @return
     */
    public List<Employee> filterEmployeeByImp(List<Employee> employee
            , FilterBusi<Employee> mg){
        List<Employee> emps = new ArrayList<Employee>();
        for (Employee emp : employee){
            if(mg.filterBusi(emp)){    //抽象出一个通用形式
                emps.add(emp);
            }
        }
        return emps;
    }

    public static void main(String[] args) {
        LambdaTest test = new LambdaTest();
        List<Employee> employees = Arrays.asList(
                new Employee("Joe",28000,31),
                new Employee("Lucy",5000,18),
                new Employee("Robin",400,7),
                new Employee("Cristina",40000,35),
                new Employee("Fancy",18000,55),
                new Employee("Lion",4000,26)
        );
        //列表全集
        for(Employee emp:employees){
            System.out.println(emp);
        }
        System.out.println("-------------------------------------------");

        //传统方法，采取增加方法实现的方法来实现业务扩展
        List<Employee> emps = test.filterEmployeeBySalary(employees);
        for(Employee emp:emps){
            System.out.println(emp);
        }
        System.out.println("-------------------------------------------");

        //设计模式 策略模式  缺点是：每次我都需要事先创建好一个类似于MyFilterEmployeeByAge这样的类
        List<Employee> emps1 = test.filterEmployeeByImp(employees,new MyFilterEmployeeByAge());
        for(Employee emp:emps1){
            System.out.println(emp);
        }
        System.out.println("-------------------------------------------");

        //这次复用之前创建的方法filterEmployeeByImp（根据接口来筛选）
        List<Employee> emps2 = test.filterEmployeeByImp(employees, new FilterBusi<Employee>() {
            @Override
            public boolean filterBusi(Employee employee) {
                return employee.getSalary()<6000;
            }
        });
        for(Employee emp:emps2){
            System.out.println(emp);
        }
        System.out.println("-------------------------------------------");

        //使用lambda表达式来实现
        List<Employee> emps3 = test.filterEmployeeByImp(employees,(e) -> e.getSalary()<2000);
        for(Employee emp:emps3){
            System.out.println(emp);
        }
        System.out.println("-------------------------------------------");
    }

}
