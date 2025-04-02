package com.calendar.calendar_meeting.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "calendars")
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", unique = true)
    @JsonBackReference
    @ToString.Exclude
    private Employee employee;

    @OneToMany(mappedBy = "calendar", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Meeting> meetings = new ArrayList<>();

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}