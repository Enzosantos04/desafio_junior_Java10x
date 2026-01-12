package enzosdev.desafio_junior.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCategoryNotFound(CategoryNotFoundException ex){
        Map<String, String> response = new HashMap<>();
        response.put("Error: ", ex.getMessage());
        response.put("Message: ", "Category Not Found.");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }
}
