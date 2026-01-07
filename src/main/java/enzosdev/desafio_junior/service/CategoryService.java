package enzosdev.desafio_junior.service;

import enzosdev.desafio_junior.entity.Category;
import enzosdev.desafio_junior.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category){
       return categoryRepository.save(category);
    }
}
