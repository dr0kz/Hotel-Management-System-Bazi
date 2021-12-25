package com.bazi.hotelmanagementsystem.model;

import com.bazi.hotelmanagementsystem.model.CompositeKeys.EmployeeRole;
import com.bazi.hotelmanagementsystem.model.CompositeKeys.RoomPriceCategory;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="employee_specified_role")
@IdClass(EmployeeRole.class)
@Data
public class Specified {
    @Id
    @ManyToOne
    @JoinColumn(name="ssn")
    private Employee employee;
    @Id
    @ManyToOne
    @JoinColumn(name="id_role")
    private Role role;
}
