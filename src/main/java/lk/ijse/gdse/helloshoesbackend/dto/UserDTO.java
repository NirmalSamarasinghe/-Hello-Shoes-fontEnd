package lk.ijse.gdse.helloshoesbackend.dto;

import lk.ijse.gdse.helloshoesbackend.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    private String id;
    private String email;
    private String password;
    private Role role;
}