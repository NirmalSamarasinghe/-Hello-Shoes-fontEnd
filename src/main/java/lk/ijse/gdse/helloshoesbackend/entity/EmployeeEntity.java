package lk.ijse.gdse.helloshoesbackend.entity;

import jakarta.persistence.*;
import lk.ijse.gdse.helloshoesbackend.Enum.Gender;
import lk.ijse.gdse.helloshoesbackend.Enum.Role;
import lk.ijse.gdse.helloshoesbackend.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    private String employeeCode;
    private String employee_name;
    @Column(columnDefinition = "LONGTEXT")
    private String profile_picture;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String designation;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String date_of_birth;
    private String attached_branch;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String postalCode;
    private String contact_no;
    private String email;
    private String name_of_the_guardian;
    private String emergency_contact_no;

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;

}
