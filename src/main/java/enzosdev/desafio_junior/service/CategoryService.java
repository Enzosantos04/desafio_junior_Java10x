package enzosdev.desafio_junior.service;

import enzosdev.desafio_junior.entity.Category;
import enzosdev.desafio_junior.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category){
       return categoryRepository.save(category);
    }


    public List<Category> listCategories(){
        return categoryRepository.findAll();
    }


    public Optional<Category> findCategoryById(Long categoryId){
        return categoryRepository.findById(categoryId);
    }


    public Category updateCategoryById(Long id, Category category){
        Category existingCategory = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category Not Found"));
        existingCategory.setName(category.getName());
        return categoryRepository.save(existingCategory);
    }
}
