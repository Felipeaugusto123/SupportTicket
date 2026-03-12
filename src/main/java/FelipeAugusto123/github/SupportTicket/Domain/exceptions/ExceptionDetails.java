package FelipeAugusto123.github.SupportTicket.Domain.exceptions;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
@Data
public class ExceptionDetails {

    private String title;
    private int status;
    private String details;
    private LocalDateTime timestamp;
    private String developerMessage;
}
