package com.packt.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor // create a task without constructor
@Entity // JPA entity: Create a table in our database
public class Task {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    private Long id;
    private String title;
    private String description;
    private String status;
}
