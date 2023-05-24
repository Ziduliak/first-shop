package sk.ziduliakmaros.first_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.ziduliakmaros.first_shop.model.entity.MerchantEntity;

@Repository
public interface MerchantRepository extends JpaRepository<MerchantEntity,Integer> {
}
