package lk.ijse.gdse.helloshoesbackend.req_and_rest.secure;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JWTAuthResponse {
    private String token;
}
