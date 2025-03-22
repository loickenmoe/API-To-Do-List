package com.packt.todo.service;

import java.util.List;

import com.packt.todo.dto.TaskRequestDto;
import com.packt.todo.model.Task;

public interface InterfaceTaskService {
    public List<Task> findAll();

    public Task save(TaskRequestDto task);
    public void deleteById(Long id);

    public Task update(TaskRequestDto task, Long id);

    public List<Task> findByStatus(String status);

}
