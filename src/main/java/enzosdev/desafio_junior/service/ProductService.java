package enzosdev.desafio_junior.service;


import enzosdev.desafio_junior.entity.Category;
import enzosdev.desafio_junior.entity.Product;
import enzosdev.desafio_junior.repository.CategoryRepository;
import enzosdev.desafio_junior.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product createProduct(Long categoryId, Product product){
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new RuntimeException("Category Not Found"));

        product.setCategory(category);

        return productRepository.save(product);

    }

    public List<Product> productsByCategory(Long categoryId){
        return productRepository.findByCategoryId(categoryId);
    }


    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }


    public Product updateProductById(Long id, Product product){
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());

        if (product.getCategory() != null && product.getCategory().getId() != null) {
            Category category = categoryRepository.findById(product.getCategory().getId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            existingProduct.setCategory(category);
        }
        return productRepository.save(existingProduct);
    }


    public Optional<Product> findProductById(Long id){
        return productRepository.findById(id);
    }
}
