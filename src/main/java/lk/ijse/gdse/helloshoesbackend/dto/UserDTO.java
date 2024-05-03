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
    private String username_code;
    private String email;
    private String Password;
    private Role role;
}