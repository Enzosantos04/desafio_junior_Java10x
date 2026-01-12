package enzosdev.desafio_junior.service;


import enzosdev.desafio_junior.entity.Category;
import enzosdev.desafio_junior.entity.Product;
import enzosdev.desafio_junior.exceptions.CategoryNotFoundException;
import enzosdev.desafio_junior.exceptions.ProductNameIsBlank;
import enzosdev.desafio_junior.exceptions.ProductNotFoundException;
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
        if(product.getName() == null || product.getName().isBlank()){
            throw new ProductNameIsBlank("Product Name must not be Blank");
        }

        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new CategoryNotFoundException("Category Not Found"));
        product.setCategory(category);
        return productRepository.save(product);
    }

    public List<Product> productsByCategory(Long categoryId){
        if(categoryRepository.findById(categoryId).isPresent()){
        return productRepository.findByCategoryId(categoryId);
        }else {
            throw new CategoryNotFoundException("Category Not Found.");
        }
    }


    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }


    public Product updateProductById(Long id, Product product){
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("Product Not Found."));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());

        if (product.getCategory() != null && product.getCategory().getId() != null) {
            Category category = categoryRepository.findById(product.getCategory().getId())
                    .orElseThrow(() -> new CategoryNotFoundException("Category Not Found."));
            existingProduct.setCategory(category);
        }
        return productRepository.save(existingProduct);
    }


    public Product findProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("Product Not Found."));
    }


    public void deleteProductById(Long id){
        if (productRepository.findById(id).isPresent()){
           productRepository.deleteById(id);
        }else{
         throw new ProductNotFoundException("Product Not Found.");
        }


    }
}
