package org.example.service;

import org.example.entity.Employee;

import java.util.List;

public interface serviceEmployee {

    List<Employee> findAll();
    Employee findOne(String id);
    Employee create(Employee emp);
    Employee delete(String id);
    Employee update(String id,Employee employee);

}
