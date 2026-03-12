package FelipeAugusto123.github.SupportTicket.Domain;


import FelipeAugusto123.github.SupportTicket.Domain.enums.Position;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@DiscriminatorValue("TEC_TI")
public class TecTI extends User {

    @Enumerated(EnumType.STRING)
    private Position position;

    @OneToMany(mappedBy = "tecTI", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<SupportTicket> assignedTickets = new HashSet<>();

}
