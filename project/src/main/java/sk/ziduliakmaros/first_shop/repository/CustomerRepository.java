package sk.ziduliakmaros.first_shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.ziduliakmaros.first_shop.model.entity.CustomerEntity;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}
