package lk.ijse.gdse.helloshoesbackend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "stock")
@Data
public class StockEntity {
    @Id
    private String stockId;
    @ManyToOne
    @JoinColumn(name = "supplierCode")
    private SupplierEntity supplierEntity;
}
