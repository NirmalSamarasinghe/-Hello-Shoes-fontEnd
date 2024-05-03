package lk.ijse.gdse.helloshoesbackend.req_and_rest.response;

import lk.ijse.gdse.helloshoesbackend.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SignUp {
    private String password;
    private String email;
    private Role role;
}
