package FelipeAugusto123.github.SupportTicket.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthDTO {

    @NotNull
    @Email
    private String email;

    @NotNull
    @Min(4)
    private String password;

}
