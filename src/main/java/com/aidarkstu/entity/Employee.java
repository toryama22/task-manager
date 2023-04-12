package com.aidarkstu.entity;

import com.aidarkstu.dto.EmployeeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends BaseEntity {
    private String firstname;
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String password;

    public Employee(EmployeeDto dto) {
        super(dto);
        this.firstname = dto.getFirstname();
        this.lastname = dto.getLastname();
        this.email = dto.getEmail();
        this.phoneNumber = dto.getPhoneNumber();
        this.hireDate = dto.getHireDate();
        this.password = dto.getPassword();
    }
}
