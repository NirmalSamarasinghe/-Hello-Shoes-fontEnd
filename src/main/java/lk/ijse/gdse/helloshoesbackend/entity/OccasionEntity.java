package lk.ijse.gdse.helloshoesbackend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
//@Table(name = "occation")
@Data
public class OccasionEntity {
    @Id
    private String occasionCode;
    private String occasionDesc;
    @OneToMany(mappedBy = "occasionEntity",cascade = CascadeType.ALL)
    private List<ItemEntity> itemEntities;
}
