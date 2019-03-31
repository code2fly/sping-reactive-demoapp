package com.goreactive.reactivedemo.controller;

import com.goreactive.reactivedemo.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping("/employees")
    public Flux<Employee> getAllEmployees() {
        logger.info("request recieved for employee");
        Flux<Employee> employeeFlux = employeeRepository.findAll();
        logger.info("returning from employee controller call");
        return employeeFlux;
    }

}

@Repository
interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {

}