package com.bazi.hotelmanagementsystem.model.CompositeKeys;

import java.io.Serializable;

public class EmployeeRole implements Serializable {
    private String employee;
    private Long role;

    public EmployeeRole(String employee, Long role) {
        this.employee = employee;
        this.role = role;
    }
}
