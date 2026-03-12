package FelipeAugusto123.github.SupportTicket.Domain.enums;

import FelipeAugusto123.github.SupportTicket.Domain.exceptions.BadRequest;
import lombok.Getter;

@Getter
public enum Status {
    IN_PROGRESS(1),
    CLOSED(2);

    private final int valor;

    Status(int i) {
        this.valor = i;
    }

    public static Status fromString(String status) {
        if (status == null) {
            return null;
        }

        for (Status x : Status.values()) {
            if (status.equalsIgnoreCase(x.name())) {
                return x;
            }
        }

        throw new BadRequest("Status inválido: " + status);

    }
}
