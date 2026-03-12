package FelipeAugusto123.github.SupportTicket.Domain.enums;

import FelipeAugusto123.github.SupportTicket.Domain.exceptions.BadRequest;
import lombok.Getter;

@Getter
public enum Priority {
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private final int valor;

    Priority(int i) {
        this.valor = i;
    }

    public static Priority fromString(String priority) {
        if (priority == null) {
            return null;
        }

        for (Priority x : Priority.values()) {
            if (priority.equalsIgnoreCase(x.name())) {
                return x;
            }
        }

        throw new BadRequest("Prioridade inválida: " + priority);

    }
}
