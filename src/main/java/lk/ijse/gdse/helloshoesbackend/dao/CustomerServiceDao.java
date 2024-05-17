package lk.ijse.gdse.helloshoesbackend.dao;

import lk.ijse.gdse.helloshoesbackend.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerServiceDao extends JpaRepository<CustomerEntity,String> {

}
