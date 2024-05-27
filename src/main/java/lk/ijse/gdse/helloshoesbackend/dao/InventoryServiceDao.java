package lk.ijse.gdse.helloshoesbackend.dao;

import lk.ijse.gdse.helloshoesbackend.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryServiceDao extends JpaRepository<ItemEntity,String> {
    @Query("SELECT itemCode FROM ItemEntity WHERE itemCode LIKE CONCAT(:prefix,'%')ORDER BY itemCode DESC")
    String findLastItemCodeStartingWithPrefix(@Param("prefix") String prefix);
}
