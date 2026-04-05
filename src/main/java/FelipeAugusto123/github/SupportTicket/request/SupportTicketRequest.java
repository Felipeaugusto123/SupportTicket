package FelipeAugusto123.github.SupportTicket.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class SupportTicketRequest {

    @NotEmpty(message = "Title cannot be empty")
    @NotNull(message = "Title cannot be null")
    private String title;
    @NotEmpty(message = "Description cannot be empty")
    @NotNull(message = "Description cannot be null")
    private String description;

    @NotNull(message = "Priority cannot be null")
    @NotEmpty(message = "Priority cannot be blank")
    private String priority;

    @NotNull(message = "Priority cannot be null")
    @NotEmpty(message = "Priority cannot be blank")
    private String status;

    @NotNull(message = "UserID cannot be null")
    private Long userID;

    @NotNull(message = "TecTIID cannot be null")
    private Long tecTIID;
}
