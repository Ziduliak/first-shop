package sk.ziduliakmaros.first_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.ziduliakmaros.first_shop.model.entity.BoughtProductEntity;

@Repository
public interface BoughtProductRepository extends JpaRepository<BoughtProductEntity,Integer> {

}
