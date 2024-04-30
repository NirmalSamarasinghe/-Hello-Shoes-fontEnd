package lk.ijse.gdse.helloshoesbackend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "customer")
@Data
public class CustomerEntity {

    @Id
    private String customerId;
    private String customerName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private  Level level;

    @Temporal(TemporalType.DATE)
    private Date joinDate;
    private Integer totalPoints;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String address5;
    private String contact;
    private String email;
    private String purchaseTimeDate;

}
