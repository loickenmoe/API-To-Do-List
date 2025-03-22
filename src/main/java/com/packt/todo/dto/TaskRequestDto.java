package com.packt.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok annotation to generate all the boilerplate code
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequestDto {
    private String title;
    private String description;
    private String status;
}
