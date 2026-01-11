package enzosdev.desafio_junior.controller;



import enzosdev.desafio_junior.entity.Product;
import enzosdev.desafio_junior.service.CategoryService;
import enzosdev.desafio_junior.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


    @GetMapping("/products")
    public ResponseEntity<List<Product>> findProducts(){
        List<Product> products = productService.findAllProducts();
        return ResponseEntity.ok(products);
    }


    @PatchMapping("/products/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable Long id, @RequestBody Product product){
        if (productService.findProductById(id).isPresent()){
            Product productUpdated = productService.updateProductById(id,product);
            return ResponseEntity.status(HttpStatus.OK).body(productUpdated);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id){
        if(productService.findProductById(id).isPresent()){
            Optional<Product> product = productService.findProductById(id);
            return ResponseEntity.ok().body(product);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not Found");
        }
    }


}
