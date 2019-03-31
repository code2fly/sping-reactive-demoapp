package com.goreactive.reactivedemo.controller;

import com.goreactive.reactivedemo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class HelloController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping("/employees")
    public Flux<Employee> getAllEmployees() {
        Flux<Employee> employeeFlux = employeeRepository.findAll();
        return employeeFlux;
    }

}

@Repository
interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {

}