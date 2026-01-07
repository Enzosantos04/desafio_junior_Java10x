package enzosdev.desafio_junior.repository;

import enzosdev.desafio_junior.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
