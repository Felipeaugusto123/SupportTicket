package FelipeAugusto123.github.SupportTicket.Domain.exceptions;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ValidationExceptionDetails extends ExceptionDetails {
    private String fieldsNotValidated;
    private String fieldsMessage;
}
