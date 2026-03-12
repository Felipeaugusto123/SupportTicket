package FelipeAugusto123.github.SupportTicket.repository;

import FelipeAugusto123.github.SupportTicket.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByCPF(String CPF);
}
