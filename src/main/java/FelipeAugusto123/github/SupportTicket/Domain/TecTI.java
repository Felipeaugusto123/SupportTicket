package FelipeAugusto123.github.SupportTicket.Domain;


import FelipeAugusto123.github.SupportTicket.Domain.enums.Position;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@DiscriminatorValue("TEC_TI")
public class TecTI extends User implements UserDetails {

    @Enumerated(EnumType.STRING)
    private Position position;

    @OneToMany(mappedBy = "tecTI", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<SupportTicket> assignedTickets = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if (position == Position.SENIOR || position == Position.PLENO) {
            return List.of(new SimpleGrantedAuthority("ROLE_SENIOR"), new SimpleGrantedAuthority("ROLE_PLENO"), new SimpleGrantedAuthority("ROLE_JUNIOR"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_JUNIOR"), new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getUsername() {
        return getEmail();
    }
}
