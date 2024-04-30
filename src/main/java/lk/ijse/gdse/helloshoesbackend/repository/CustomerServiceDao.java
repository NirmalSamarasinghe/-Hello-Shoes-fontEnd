package lk.ijse.gdse.helloshoesbackend.repository;

import lk.ijse.gdse.helloshoesbackend.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerServiceDao extends JpaRepository<CustomerEntity,String> {
}
