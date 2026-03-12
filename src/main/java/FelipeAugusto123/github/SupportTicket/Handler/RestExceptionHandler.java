package FelipeAugusto123.github.SupportTicket.Handler;

import FelipeAugusto123.github.SupportTicket.Domain.exceptions.BadRequestExceptionDetails;
import FelipeAugusto123.github.SupportTicket.Domain.exceptions.ValidationExceptionDetails;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity.badRequest().body(BadRequestExceptionDetails.builder()
                .title("Bad Request Exception, Check the Details")
                .status(HttpStatus.BAD_REQUEST.value())
                .details(ex.getMessage())
                .developerMessage(ex.getClass().getName())
                .build());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionDetails> handleValidationException(MethodArgumentNotValidException ex) {

        var fieldError = ex.getBindingResult().getFieldErrors();
        var fieldsNotValidated = fieldError.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        var fieldsMessage = fieldError.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        return ResponseEntity.badRequest().body(ValidationExceptionDetails.builder()
                .title("Bad Request Exception, Check the Details")
                .status(HttpStatus.BAD_REQUEST.value())
                .details(ex.getMessage())
                .developerMessage(ex.getClass().getName())
                .fieldsNotValidated(fieldsNotValidated)
                .fieldsMessage(fieldsMessage)
                .build());
    }
}
