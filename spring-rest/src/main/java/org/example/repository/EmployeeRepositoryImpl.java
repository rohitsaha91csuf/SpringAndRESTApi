package org.example.repository;

import org.example.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
    @Override
    public List<Employee> findAll() {
        List<Employee> employee = new ArrayList<>();
        employee.add(new Employee("","RohitSaha",1000));
        employee.add(new Employee("","ParijatDas",5000));
        employee.add(new Employee("","RatikShetty",3000));
        return employee;
    }

    @Override
    public Employee findOne(String id) {
        return new Employee("","RohitSaha",100);
    }

    @Override
    public Employee create(Employee emp) {
        return null;
    }

    @Override
    public Employee delete(String id) {
        return null;
    }

    @Override
    public Employee update(String id, Employee employee) {
        return null;
    }
}
