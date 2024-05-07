package lk.ijse.gdse.helloshoesbackend.dto;

import jakarta.validation.constraints.*;
import lk.ijse.gdse.helloshoesbackend.Enum.Gender;
import lk.ijse.gdse.helloshoesbackend.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO implements SuperDTO {

    @Null(message = "Employ code generate by the programmer")
    private String employee_code;

    @NotBlank(message = "Employee name can't be null")
    private String employee_name;

    @NotBlank(message = "Employee profile picture can't be null")
    private String profile_picture;

    @NotNull(message = "Gender can't be null")
    private Gender gender;

    @NotNull(message = "status can't be null")
    private String status;

    @NotNull(message = "Designation can't be null")
    private String designation;

    @NotNull(message = "Role can't be null")
    private Role role;

    @Past(message = "Date of Birth should be in the past")
    @NotNull(message = "Date of Birth can't be null")
    private String date_of_birth;

    @NotBlank(message = "Attendance branch can't be blank")
    private String attached_branch;

    @NotBlank(message = "Address 1 can't be blank")
    private String address1;

    @NotBlank(message = "Address 2 can't be blank")
    private String address2;

    @NotBlank(message = "Address 3 can't be blank")
    private String address3;

    @NotBlank(message = "Address 4 can't be blank")
    private String address4;

    @NotBlank(message = "postal code can't be blank")
    @Pattern(regexp = "\\d{5}",message = "postal code must be 5 digits")
    private String postalCode;

    @NotBlank(message = "Contact No can't be blank")
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid contact number format")
    private String contact_no;
    
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email can't be blank")
    private String email;

    @NotBlank(message = "Emergency Contact Name cannot be blank")
    private String name_of_the_guardian;

    @NotBlank(message = "Emergency Contact No cannot be blank")
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid Emergency contact number format")
    private String emergency_contact_no;

}
