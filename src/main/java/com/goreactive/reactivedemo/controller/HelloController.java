package com.goreactive.reactivedemo.controller;

import com.goreactive.reactivedemo.Employee;
import org.apache.commons.compress.utils.Iterators;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping("/employees")
    public List<Employee> getAllEmployees() {
        Iterable<Employee> employeeIterable = employeeRepository.findAll();
        return Lists.newArrayList(employeeIterable.iterator());
    }

}

@Repository
interface EmployeeRepository extends CrudRepository<Employee, String> {

}