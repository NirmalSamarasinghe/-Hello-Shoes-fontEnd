package lk.ijse.gdse.helloshoesbackend.entity;

import jakarta.persistence.*;
import lk.ijse.gdse.helloshoesbackend.Enum.PaymentMethod;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    private String orderNo;
    private Timestamp purchasedDate;
    private int addedPoints;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "cutomerId",nullable = false)
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name = "email",nullable = false)
    private UserEntity userEntity;

    @OneToMany(mappedBy = "orderEntity",cascade = CascadeType.ALL)
    private List<StockSizeOrderDetailsEntity> stockSizeOrderDetailsEntities;

}
