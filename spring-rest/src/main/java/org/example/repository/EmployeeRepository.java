package org.example.repository;

import org.example.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> findAll();
    Employee findOne(String id);
    Employee create(Employee emp);
    Employee delete(String id);
    Employee update(String id,Employee employee);

}
