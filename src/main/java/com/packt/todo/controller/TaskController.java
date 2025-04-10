package com.packt.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.packt.todo.dto.TaskRequestDto;
import com.packt.todo.response.ApiResponse;
import com.packt.todo.service.InterfaceTaskService;

import lombok.RequiredArgsConstructor;

@RestController // Define as a rest controller
@RequestMapping("/tasks") // define the end point that the requests will start.
//@RequiredArgsConstructor // creating an a contructor with required elements.
//@Component
public class TaskController {

    // private final TaskService taskService;
    private final InterfaceTaskService taskService;

    // Constructeur explicite
    public TaskController(InterfaceTaskService taskService) {
        this.taskService = taskService;
    }

    //first end point for my "findAll" service
    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllTasks() {
        return ResponseEntity.ok(new ApiResponse("Task fetch successfully", taskService.findAll()));
    }

    //end point for my "save" service
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createTask(@RequestBody TaskRequestDto task) {
        return ResponseEntity.ok(new ApiResponse("Task created successfully", taskService.save(task)));
    }

    //end point for my "deleteById" service
    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deleteTask(@RequestParam Long taskId ){
        taskService.deleteById(taskId); // return anything
        return ResponseEntity.ok(new ApiResponse("Task delete successfully",null)); // return anything 
    }

    //end point for my "update" service
    @PutMapping("/update/{taskId}")
    public ResponseEntity<ApiResponse> updateTask(@PathVariable Long taskId,@RequestBody TaskRequestDto task){
        return ResponseEntity.ok(new ApiResponse("Task Update successfully", taskService.update(task, taskId)));
    }

    //end point for my "findByStatus" service
    @GetMapping("/show_by_status")
    public ResponseEntity<ApiResponse> findByStatus(@RequestParam String status){
        try {
            return ResponseEntity.ok(new ApiResponse("Task find by status", taskService.findByStatus(status)));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }
}
