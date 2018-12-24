package com.pmpa.java.java8.lambda;

public class Employee {
	   private String name;
	    private float salary;
	    private int age;

	    public String getName() {
	        return name;
	    }

	    public float getSalary() {
	        return salary;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setSalary(float salary) {
	        this.salary = salary;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    public Employee() {
	    }
	    
	    public Employee(String name) {
	    	this.name = name;
	    }

	    public Employee(String name, float salary, int age) {
	        this.name = name;
	        this.salary = salary;
	        this.age = age;
	    }

	    @Override
	    public String toString() {
	        return "Employee{" +
	                "name='" + name + '\'' +
	                ", salary=" + salary +
	                ", age=" + age +
	                '}';
	    }
}



