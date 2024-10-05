package com.jobrecommendation.jobrecommendationsystem.ErrorHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {
    private String error;
    private String message;

    public ErrorResponse(String error,String message){
        this.error = error;
        this.message = message;
    }
}