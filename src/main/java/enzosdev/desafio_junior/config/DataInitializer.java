package enzosdev.desafio_junior.config;

import enzosdev.desafio_junior.entity.Category;
import enzosdev.desafio_junior.entity.Product;
import enzosdev.desafio_junior.repository.CategoryRepository;
import enzosdev.desafio_junior.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;

public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    public DataInitializer(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryRepository.save(new Category(null, "Beverages"));
        productRepository.save(new Product(null, "Soft Drink", new BigDecimal("10"), new Category(null, "Beverages")));

    }
}
