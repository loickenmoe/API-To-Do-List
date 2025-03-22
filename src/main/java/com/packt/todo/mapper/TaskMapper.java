package com.packt.todo.mapper;

import com.packt.todo.dto.TaskRequestDto;
import com.packt.todo.model.Task;

public class TaskMapper {
    public static  Task toTaskEntity(TaskRequestDto dto) { //get data for creating an element to Task table 
        Task task = new Task();  // Creating the task object for return
        task.setDescription(dto.getDescription()); 
        task.setStatus(dto.getStatus() );
        task.setTitle(dto.getTitle());
        return task;
    }
}
