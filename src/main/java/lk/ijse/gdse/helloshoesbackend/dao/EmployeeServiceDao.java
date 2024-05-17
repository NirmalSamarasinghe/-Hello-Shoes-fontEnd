package lk.ijse.gdse.helloshoesbackend.dao;

import lk.ijse.gdse.helloshoesbackend.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeServiceDao extends JpaRepository<EmployeeEntity,String> {
    EmployeeEntity findByOrderByEmployeeCodeDesc();
}
