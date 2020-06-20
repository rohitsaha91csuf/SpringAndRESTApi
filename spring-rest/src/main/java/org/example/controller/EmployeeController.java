package org.example.controller;

import org.example.entity.Employee;

import org.example.service.serviceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RequestMapping(value = "employees")
@RestController
public class EmployeeController {

    @Autowired
    private serviceEmployee service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> findAll(){
       return service.findAll() ;
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Employee findOne(@PathVariable("id") String id){
        return service.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Employee create(@RequestBody Employee employee){
        return service.create(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Employee update(@PathVariable("id") String id, @RequestBody  Employee employee){
        return service.update(id,employee);
    }

    @RequestMapping(method = RequestMethod.DELETE, value ="{id}")
    public void delete(@PathVariable("id") String id){
        service.delete(id);
    }
}
