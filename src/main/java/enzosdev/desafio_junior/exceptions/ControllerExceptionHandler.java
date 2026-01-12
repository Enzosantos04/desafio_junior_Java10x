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
        response.put("Message: ", "Category Not Found, Try again.");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }


    @ExceptionHandler(CategoryNameIsBlank.class)
    public ResponseEntity<Map<String, String>> handleCategoryNameIsBlank(CategoryNameIsBlank ex){
        Map<String, String> response = new HashMap<>();
        response.put("Error: ", ex.getMessage());
        response.put("Message: ", "Category Name is Blank, try again.");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProductNotFound(ProductNotFoundException ex){
        Map<String, String> response = new HashMap<>();
        response.put("Error: ", ex.getMessage());
        response.put("Message: ", "Product is Not Found, try again.");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ProductNameIsBlank.class)
    public ResponseEntity<Map<String,String>> handleProductNameIsBlank(ProductNameIsBlank ex){
        Map<String, String> response = new HashMap<>();
        response.put("Error: ", ex.getMessage());
        response.put("Message: ", "Product name must not be blank, try again.");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(CategoryListEmptyException.class)
    public ResponseEntity<Map<String, String>> handleCategoryListEmptyException(CategoryListEmptyException ex){
        Map<String, String> response = new HashMap<>();
        response.put("Error: ", ex.getMessage());
        response.put("Message: ", "Category list is empty. Try again");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(ProductListEmptyException.class)
    public ResponseEntity<Map<String, String>> handleProductListEmptyException(ProductListEmptyException ex){
        Map<String, String> response = new HashMap<>();
        response.put("Error: ", ex.getMessage());
        response.put("Message: ", "Product list is empty. Try again");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }





}
