package com.goreactive.reactivedemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication
public class ReactiveDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveDemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner initData(MongoOperations mongo) {
        return (String... args) ->  {

            mongo.dropCollection(Employee.class);
            mongo.createCollection(Employee.class,  CollectionOptions.empty().size(1000000).capped());

            mongo.save(new Employee("Raju", 23, "Bangalore" ));
            mongo.save(new Employee("Lalu", 56, "Patna" ));
            mongo.save(new Employee("Rabri", 50, "Patna" ));
            mongo.save(new Employee("Kejriwal", 44, "New Delhi" ));
        };
    }
}
