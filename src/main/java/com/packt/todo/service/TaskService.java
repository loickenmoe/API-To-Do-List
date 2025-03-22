package com.packt.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.packt.todo.dto.TaskRequestDto;
import com.packt.todo.exception.ResourceNotFoundException;
import com.packt.todo.mapper.TaskMapper;
import com.packt.todo.model.Task;
import com.packt.todo.repository.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService implements InterfaceTaskService {
    private final TaskRepository taskRepository; // Injecting the TaskRepository: Communicate with the database

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll(); // Return all tasks
    }

    @Override
    public Task save(TaskRequestDto task) {
        return taskRepository.save(TaskMapper.toTaskEntity(task)); // Save a task
    }

    @Override
    public void deleteById(Long id) {
        try {
            taskRepository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Task not found");
        }
    }

    @Override
    public Task update(TaskRequestDto task, Long id) {
        Task taskToUpdate = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
        taskToUpdate.setTitle(task.getTitle());
        taskToUpdate.setDescription(task.getDescription());
        taskToUpdate.setStatus(task.getStatus());
        return taskRepository.save(taskToUpdate);
    }

    @Override
    public List<Task> findByStatus(String status) {
        try {
            List<Task> tasks = taskRepository.findByStatus(status);
            if (tasks.isEmpty()) {
                throw new ResourceNotFoundException("No tasks found with status " + status);
            }
            return tasks;
        } catch (Exception e) {
            throw new ResourceNotFoundException("Status not found");
        }

    }

}
