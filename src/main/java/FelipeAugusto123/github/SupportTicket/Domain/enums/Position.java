package FelipeAugusto123.github.SupportTicket.Domain.enums;

import FelipeAugusto123.github.SupportTicket.Domain.exceptions.BadRequest;
import lombok.Getter;

@Getter
public enum Position {
    JUNIOR(1),
    PLENO(2),
    SENIOR(3);

    private final int valor;


    Position(int i) {
        this.valor = i;

    }

    public static Position fromString(String position) {
        if (position == null) {
            return null;
        }

        for (Position x : Position.values()) {
            if (position.equalsIgnoreCase(x.name())) {
                return x;
            }
        }

        throw new BadRequest("Posição inválida: " + position);

    }

}
