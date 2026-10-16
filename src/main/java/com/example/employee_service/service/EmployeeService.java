
package com.example.employee_service.service;

import com.example.employee_service.dto.EmployeeRequestDto;
import com.example.employee_service.entity.Employee;
import com.example.employee_service.kafka.EmployeeKafkaProducer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();
    private final EmployeeKafkaProducer kafkaProducer;

    public EmployeeService(EmployeeKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public Employee saveEmployee(EmployeeRequestDto request) {

        long randomId = ThreadLocalRandom.current()
                .nextInt(100000, 1_000_000);

        Employee employee = new Employee(
                randomId,
                request.name(),
                request.email(),
                request.department()
        );

        employees.add(employee);

        kafkaProducer.publishEmployee(employee);

        return employee;
    }
}
