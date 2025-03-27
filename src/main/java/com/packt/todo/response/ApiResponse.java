package com.packt.todo.response;

import lombok.Data;
import java.util.List;

@Data
public class ApiResponse<T> { // Make the class generic to support typed data
    private String message;
    private T data; // Use generic type T for flexibility

    // Manually define the constructor
    public ApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    // No-args constructor (optional, add if needed)
    public ApiResponse() {}
}


/*
package com.packt.todo.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private String message;
    private Object data;
}

 */
