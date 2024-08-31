package com.jasper.report.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="emplotee")
@Data
public class Employee {
    @Id
    private Integer id;
    private String name;
    private String place;
}
