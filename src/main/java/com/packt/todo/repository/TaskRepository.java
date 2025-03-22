package com.packt.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.packt.todo.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(String status);
    
}
