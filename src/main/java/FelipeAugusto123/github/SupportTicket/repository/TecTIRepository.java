package FelipeAugusto123.github.SupportTicket.repository;

import FelipeAugusto123.github.SupportTicket.Domain.TecTI;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TecTIRepository extends JpaRepository<TecTI, Long> {

    Optional<TecTI> findByCPF(String CPF);

}
