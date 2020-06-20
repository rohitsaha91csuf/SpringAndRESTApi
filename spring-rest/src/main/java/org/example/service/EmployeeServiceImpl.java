package org.example.service;

import org.example.entity.Employee;
import org.example.exception.EmployeeNotFoundException;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements serviceEmployee {
    @Autowired
    private EmployeeRepository repo;

    @Override
    public List<Employee> findAll() {
        return repo.findAll();
    }

    @Override
    public Employee findOne(String id) {
        Employee employee= repo.findOne(id);
        if(employee==null)
            throw new EmployeeNotFoundException("The employee "+id+" isNOTFOUND");
        return employee;
    }

    @Override
    public Employee create(Employee emp) {
        return null;
    }

    @Override
    public Employee delete(String id) {
        return repo.delete(id);
    }

    @Override
    public Employee update(String id, Employee employee) {
        return repo.update(id, employee);
    }
}
