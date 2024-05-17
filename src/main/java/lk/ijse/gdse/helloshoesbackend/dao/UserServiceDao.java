package lk.ijse.gdse.helloshoesbackend.dao;

import lk.ijse.gdse.helloshoesbackend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserServiceDao extends JpaRepository<UserEntity,String> {
    Optional<UserEntity> findByEmail(String email);
}
