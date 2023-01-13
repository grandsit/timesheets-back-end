package com.example.timeSheets.boot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank
    @Column(name = "project_name")
    private String projectName;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @JoinTable(name = "project_employee",
    joinColumns = @JoinColumn(name = "project_id"),
    inverseJoinColumns = @JoinColumn(name = "employee_id"))
    @ManyToMany
    private List<Employee> employees;

    @JoinTable(name = "project_customer",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    @ManyToMany
    private List<Customer> customers;
}