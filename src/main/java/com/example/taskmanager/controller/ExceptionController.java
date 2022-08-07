package com.example.taskmanager.controller;

import exception.ErrorResponse;
import exception.TaskManagerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = TaskManagerException.class)
    @ResponseBody
    ErrorResponse handleTaskManagerException(TaskManagerException taskManagerException) {
        return new ErrorResponse(
                taskManagerException.getMessage(),
                taskManagerException.getCode(),
                taskManagerException.getUserDescription(),
                taskManagerException.getDevDescription());
    }
}
