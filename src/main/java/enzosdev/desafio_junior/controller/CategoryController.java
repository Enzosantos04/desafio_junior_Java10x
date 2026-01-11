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
public class CategoryController {


    private final CategoryService categoryService;
    private final ProductService productService;

    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category newCategory = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>>CategoriesList(){
        List<Category> categories = categoryService.listCategories();
        return ResponseEntity.ok(categories);

    }

    @GetMapping("/categories/{categoryId}/products")
    public ResponseEntity<?> ProductsList(@PathVariable Long categoryId){
        if(categoryService.findCategoryById(categoryId).isPresent()){
            List<Product> products = productService.productsByCategory(categoryId);
            return ResponseEntity.status(HttpStatus.OK).body(products);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found.");
        }
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<?> updateCategoryById(@PathVariable Long id, @RequestBody Category category){
        if (categoryService.findCategoryById(id).isPresent()){
            Category categoryUpdated = categoryService.updateCategoryById(id,category);
            return ResponseEntity.status(HttpStatus.OK).body(categoryUpdated);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category Not Found");
        }
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable Long id){
        if (categoryService.findCategoryById(id).isPresent()){
            categoryService.deleteCategoryById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not Found");
        }
    }
}
