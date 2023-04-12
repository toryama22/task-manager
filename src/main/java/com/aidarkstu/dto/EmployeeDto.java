package com.aidarkstu.dto;

import com.aidarkstu.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto extends BaseDto {
    private String firstname;
    private String lastname;
    private Long positionId;
    private Long departmentId;
    private Long managerId;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String password;

    public EmployeeDto(Employee employee) {
        super(employee);
        this.firstname = employee.getFirstname();
        this.lastname = employee.getLastname();
        //this.positionId = employee.getPosition().getId();
        //this.departmentId = employee.getDepartment().getId();
        //this.managerId = employee.getManager().getId();
        this.email = employee.getEmail();
        this.phoneNumber = employee.getPhoneNumber();
        this.hireDate = employee.getHireDate();
        this.password = employee.getPassword();
    }
}
