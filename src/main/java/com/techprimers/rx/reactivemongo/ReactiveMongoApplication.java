package com.techprimers.rx.reactivemongo;

import com.techprimers.rx.reactivemongo.models.Employee;
import com.techprimers.rx.reactivemongo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ReactiveMongoApplication {

    @Bean
    CommandLineRunner employees(EmployeeRepository repo) {
        return args -> {
            repo.deleteAll().subscribe(null, null, () -> {
                Stream.of(new Employee(UUID.randomUUID().toString(), "Jake", 2000L),
                        new Employee(UUID.randomUUID().toString(), "Steven", 3000L),
                        new Employee(UUID.randomUUID().toString(), "Alex", 4000L))
                        .forEach(employee -> {
                            repo.save(employee)
                                    .subscribe(System.out::println);
                        });
            });
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ReactiveMongoApplication.class, args);
    }

}
