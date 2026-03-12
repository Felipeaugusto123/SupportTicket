package FelipeAugusto123.github.SupportTicket.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class TecTIRequest {

    @NotEmpty(message = "Name cannot be empty")
    @NotNull(message = "Name cannot be null")
    private String name;
    @Email
    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @CPF
    @NotEmpty(message = "CPF cannot be empty")
    @NotNull(message = "CPF cannot be null")
    private String CPF;

    @NotNull(message = "Position cannot be null")
    @NotEmpty(message = "Position cannot be blank")
    private String position;


}
