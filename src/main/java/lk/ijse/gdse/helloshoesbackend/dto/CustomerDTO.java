package lk.ijse.gdse.helloshoesbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements SuperDTO{
    private String customer_code;
    private String customer_name;
    private String gender;
    private Date joinDate;
    private String level;
    private Integer TotalPoints;
    private Date DOB;
    private String address;

}
