package com.Sachin.CustomerManagement.ApiResponse;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class ApiResponse {

    private String message;
    private boolean success;
    private Object details;

    public ApiResponse(String message, boolean success, Object details) {
        this.message = message;
        this.success = success;
        this.details = details;
    }

//    public ApiResponse(String message) {
//        this.message = message;
//    }


}
