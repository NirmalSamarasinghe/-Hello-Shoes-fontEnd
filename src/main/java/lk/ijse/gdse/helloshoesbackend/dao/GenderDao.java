package lk.ijse.gdse.helloshoesbackend.dao;

import lk.ijse.gdse.helloshoesbackend.entity.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderDao extends JpaRepository<GenderEntity,String > {
}
