package com.pmpa.java.java8.lambda;

public class MyFilterEmployeeByAge implements FilterBusi<Employee> {
    @Override
    public boolean filterBusi(Employee employee) {
        return employee.getAge()<35;
    }
}
