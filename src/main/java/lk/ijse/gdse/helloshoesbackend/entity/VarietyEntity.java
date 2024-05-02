package lk.ijse.gdse.helloshoesbackend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
//@Table(name = "variety")
@Data
public class VarietyEntity {
    @Id
    private String varietyCode;
    private String varietyDesc;
    @OneToMany(mappedBy = "varietyEntity",cascade = CascadeType.ALL)
    private List<ItemEntity> itemEntities;
}
