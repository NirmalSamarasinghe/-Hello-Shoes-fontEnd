package lk.ijse.gdse.helloshoesbackend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenderDTO implements SuperDTO{
    @NotNull(message = "gender code cannot be null")
    private String gender_code;
    @NotNull(message = "genderDesc cannot be null")
    private String gender_desc;
}
