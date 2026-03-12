package FelipeAugusto123.github.SupportTicket.repository;

import FelipeAugusto123.github.SupportTicket.Domain.SupportTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {
}
