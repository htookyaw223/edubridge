package cu.edubridge.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ParentReqDto {
    @NotEmpty(message = "Name must not be empty")
    private String name;
    @NotEmpty(message = "Phone must not be empty")
    private String phone;
    @NotEmpty(message = "Address must not be empty")
    private String address;
    private String image;
}
