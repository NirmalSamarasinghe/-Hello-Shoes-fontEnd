package lk.ijse.gdse.helloshoesbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "StockSizeOrderDetails")
public class StockSizeOrderDetailsEntity {
    @Id
    private String stockSizeOrderDetailsId;
    private int qty;

    @ManyToOne
    @JoinColumn(name = "stockSizeId",nullable = false)
    private StockSizeEntity stockSizeEntity;

    @ManyToOne
    @JoinColumn(name = "orderId",nullable = false)
    private OrderEntity orderEntity;
}
