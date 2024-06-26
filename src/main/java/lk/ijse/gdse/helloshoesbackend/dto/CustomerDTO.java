package lk.ijse.gdse.helloshoesbackend.dto;
import jakarta.validation.constraints.*;
import lk.ijse.gdse.helloshoesbackend.Enum.Gender;
import lk.ijse.gdse.helloshoesbackend.Enum.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Timestamp;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements SuperDTO {
    @Null(message = "Customer ID is Auto Generated")
    private String customerID;
    @NotBlank(message = "Customer name is cannot be blank")
    @Size(min = 2, max = 50, message = "Customer name is required")
    private String customerName;
    @NotNull(message = "Gender cannot be null")
    private Gender gender;
    @NotNull(message = "Join date cannot be null")
    @PastOrPresent(message = "Join date is must be before")
    private Date joinDate;
    @NotNull(message = "Level cannot be null")
    private Level level;
    @PositiveOrZero(message = "Total points cannot be negative")
    private Integer totalPoints;
    @NotNull(message = "DOB cannot be null")
    @Past(message = "DOB is must be Past")
    private Date dateOfBirth;
    @NotBlank(message = "Address 1 cannot be blank")
    private String address1;
    @NotBlank(message = "Address 2 cannot be blank")
    private String address2;
    @NotBlank(message = "Address 3 cannot be blank")
    private String address3;
    @NotBlank(message = "Address 4 cannot be blank")
    private String address4;
    @NotBlank(message = "postal code cannot be blank")
    @Pattern(regexp = "\\d{5}",message = "postal code must be between 5 digits")
    private String address5;
    @NotNull(message = "Number not specified")
    private String contact;
    @NotNull(message = "email address must not be empty")
    private String email;
    @NotNull(message = "purchase")
    private Timestamp purchaseTimeDate;
}