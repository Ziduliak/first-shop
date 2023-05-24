package sk.ziduliakmaros.first_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.ziduliakmaros.first_shop.model.entity.ProductEntity;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
}
