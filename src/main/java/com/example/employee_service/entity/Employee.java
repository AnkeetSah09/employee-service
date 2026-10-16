
package com.example.employee_service.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long id;
    private String name;
    private String email;
    private String department;
}
