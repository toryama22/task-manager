package com.aidarkstu.entity;

import com.aidarkstu.constant.Role;
import com.aidarkstu.dto.EmployeeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends BaseEntity implements UserDetails {
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

    @Enumerated(EnumType.STRING)
    private Role role;

    public Employee(EmployeeDto dto) {
        super(dto);
        this.firstname = dto.getFirstname();
        this.lastname = dto.getLastname();
        this.email = dto.getEmail();
        this.phoneNumber = dto.getPhoneNumber();
        this.hireDate = dto.getHireDate();
        this.password = dto.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
