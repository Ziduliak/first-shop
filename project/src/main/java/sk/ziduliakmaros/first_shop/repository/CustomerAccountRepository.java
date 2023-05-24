package sk.ziduliakmaros.first_shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sk.ziduliakmaros.first_shop.model.entity.CustomerAccountEntity;


import java.math.BigDecimal;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccountEntity,Integer> {

    @Query("SELECT account.money " +
            "FROM CustomerAccountEntity account " +
            "WHERE account.customer.id = :customerId")
    BigDecimal getMoney(@Param("customerId") Integer customerId);

    @Query("UPDATE CustomerAccountEntity account " +
            "SET account.money = :money " +
            "WHERE account.customer.id = :customerId")
    @Modifying
    @Transactional
    void updateMoney(@Param("customerId") Integer customerId, @Param("money") BigDecimal money);

}
