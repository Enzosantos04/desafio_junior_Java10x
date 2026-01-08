package enzosdev.desafio_junior.service;


import enzosdev.desafio_junior.entity.Category;
import enzosdev.desafio_junior.entity.Product;
import enzosdev.desafio_junior.repository.CategoryRepository;
import enzosdev.desafio_junior.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
