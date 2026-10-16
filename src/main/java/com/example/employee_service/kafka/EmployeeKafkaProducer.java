package com.example.employee_service.kafka;

import com.example.employee_service.entity.Employee;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeKafkaProducer {

    private final KafkaTemplate<String, Employee> kafkaTemplate;

    public EmployeeKafkaProducer(
            KafkaTemplate<String, Employee> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishEmployee(Employee employee) {
        kafkaTemplate.send(
                "employee-created",
                employee.getEmail(),
                employee
        );
    }
}
