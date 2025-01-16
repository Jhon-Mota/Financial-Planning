package project.financialplanning.handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import project.financialplanning.exceptions.GoalNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(GoalNotFoundException.class)
    private ResponseEntity<String> goalNotfoundHandler(GoalNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found.");
    }
    
}
