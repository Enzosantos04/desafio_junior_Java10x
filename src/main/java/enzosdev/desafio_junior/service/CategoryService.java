package enzosdev.desafio_junior.service;

import enzosdev.desafio_junior.entity.Category;
import enzosdev.desafio_junior.exceptions.CategoryNameIsBlank;
import enzosdev.desafio_junior.exceptions.CategoryNotFoundException;
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
        if(category.getName() == null || category.getName().isBlank()){
            throw new CategoryNameIsBlank("Category name must not be blank");
        }
        return categoryRepository.save(category);
    }


    public List<Category> listCategories(){
        return categoryRepository.findAll();
    }


    public Category findCategoryById(Long categoryId){
         return categoryRepository.findById(categoryId)
                 .orElseThrow(()-> new CategoryNotFoundException("Category Not Found."));
    }


    public Category updateCategoryById(Long id, Category category){
        Category existingCategory = categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException("Category Not Found"));
        existingCategory.setName(category.getName());
        return categoryRepository.save(existingCategory);
    }


    public void deleteCategoryById(Long id){
        if (categoryRepository.findById(id).isPresent()){
        categoryRepository.deleteById(id);
        }else{
            throw new CategoryNotFoundException("Category Not Found.");
        }
    }

}
