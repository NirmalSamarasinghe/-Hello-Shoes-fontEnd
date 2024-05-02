package lk.ijse.gdse.helloshoesbackend.repository;

import lk.ijse.gdse.helloshoesbackend.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierServiceDao extends JpaRepository<SupplierEntity,String> {
}
