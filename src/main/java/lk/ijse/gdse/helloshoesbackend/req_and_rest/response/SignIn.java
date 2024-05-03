package lk.ijse.gdse.helloshoesbackend.req_and_rest.response;

import lombok.*;
import  jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignIn {
    @NotNull(message = "Email cannot be null")
    @Email
    private String email;

    @NotNull(message = "Password cannot be null")
    private String password;
}
