package enzosdev.desafio_junior.config;

import enzosdev.desafio_junior.entity.Category;
import enzosdev.desafio_junior.entity.Product;
import enzosdev.desafio_junior.repository.CategoryRepository;
import enzosdev.desafio_junior.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


//@Component
//public class DataInitializer implements CommandLineRunner {
//
//    private final ProductRepository productRepository;
//    private final CategoryRepository categoryRepository;
//
//
//    public DataInitializer(ProductRepository productRepository, CategoryRepository categoryRepository) {
//        this.productRepository = productRepository;
//        this.categoryRepository = categoryRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//       Category clothes = categoryRepository.save(new Category(null, "Clothes"));
//       Category games = categoryRepository.save(new Category(null, "Games"));
//        Product tshirt = new Product(null, "T-Shirt", new BigDecimal("30"), clothes);
//        Product shoes = new Product(null, "Shoes", new BigDecimal("30"), clothes);
//        Product dress = new Product(null, "Dress", new BigDecimal("30"), clothes);
//        Product game1= new Product(null, "Arc Raiders", new BigDecimal("30"), games);
//        Product game2= new Product(null, "God of War", new BigDecimal("30"), games);
//        Product game3= new Product(null, "Resident Evil", new BigDecimal("30"), games);
//
//
//        productRepository.save(tshirt);
//        productRepository.save(shoes);
//        productRepository.save(dress);
//        productRepository.save(game1);
//        productRepository.save(game2);
//        productRepository.save(game3);
//
//    }
//}
