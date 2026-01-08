package enzosdev.desafio_junior.controller;


import enzosdev.desafio_junior.entity.Category;
import enzosdev.desafio_junior.entity.Product;
import enzosdev.desafio_junior.service.CategoryService;
import enzosdev.desafio_junior.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("desafio/")
public class ProductController {

    private final CategoryService categoryService;
    private final ProductService productService;

    public ProductController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }


    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestParam Long categoryId, @RequestBody Product product){
        if(categoryService.findCategoryById(categoryId).isPresent()){
            Product newProduct = productService.createProduct(categoryId, product);
            return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }


}
