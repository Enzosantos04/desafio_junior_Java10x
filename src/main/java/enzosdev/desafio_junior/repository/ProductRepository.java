package enzosdev.desafio_junior.repository;

import enzosdev.desafio_junior.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
