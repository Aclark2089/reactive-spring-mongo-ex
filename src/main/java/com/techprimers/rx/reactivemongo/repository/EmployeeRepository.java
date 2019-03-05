package com.techprimers.rx.reactivemongo.repository;

import com.techprimers.rx.reactivemongo.models.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
}
