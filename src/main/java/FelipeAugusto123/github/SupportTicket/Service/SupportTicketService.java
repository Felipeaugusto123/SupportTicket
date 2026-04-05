package FelipeAugusto123.github.SupportTicket.Service;

import FelipeAugusto123.github.SupportTicket.Domain.SupportTicket;
import FelipeAugusto123.github.SupportTicket.Domain.TecTI;
import FelipeAugusto123.github.SupportTicket.Domain.User;
import FelipeAugusto123.github.SupportTicket.Domain.enums.Priority;
import FelipeAugusto123.github.SupportTicket.Domain.enums.Status;
import FelipeAugusto123.github.SupportTicket.Domain.exceptions.BadRequest;
import FelipeAugusto123.github.SupportTicket.repository.SupportTicketRepository;
import FelipeAugusto123.github.SupportTicket.request.SupportTicketRequest;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@Service
public class SupportTicketService {

    private final SupportTicketRepository repository;
    private final UserService userService;
    private final TecTiService tecTIService;

    public Page<SupportTicket> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public SupportTicket findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BadRequest("SupportTicket not found with id: " + id));
    }

    @Transactional
    public SupportTicket createSupportTicket(SupportTicketRequest supportTicket) {
        User user = userService.findById(supportTicket.getUserID());
        TecTI tecTI = tecTIService.findById(supportTicket.getTecTIID());

        return repository.save(SupportTicket.builder()
                .title(supportTicket.getTitle())
                .description(supportTicket.getDescription())
                .createdAt(LocalDateTime.now())
                .priority(Priority.fromString(supportTicket.getPriority()))
                .status(Status.fromString(supportTicket.getStatus()))
                .user(user)
                .tecTI(tecTI)
                .build());
    }

    @Transactional
    public SupportTicket updateSupportTicket(Long id, SupportTicketRequest supportTicket) {
        SupportTicket existingSupportTicket = findById(id);
        User user = userService.findById(supportTicket.getUserID());
        TecTI tecTI = tecTIService.findById(supportTicket.getTecTIID());

        existingSupportTicket.setTitle(supportTicket.getTitle());
        existingSupportTicket.setDescription(supportTicket.getDescription());
        existingSupportTicket.setPriority(Priority.fromString(supportTicket.getStatus()));
        existingSupportTicket.setUser(user);
        existingSupportTicket.setStatus(Status.fromString(supportTicket.getStatus()));
        existingSupportTicket.setTecTI(tecTI);

        return repository.save(existingSupportTicket);
    }

    @Transactional
    public void closeSupportTicket(Long id) {
        SupportTicket existingSupportTicket = findById(id);
        existingSupportTicket.setStatus(Status.CLOSED);
        existingSupportTicket.setClosedAt(LocalDateTime.now());
        repository.save(existingSupportTicket);
    }

    @Transactional
    public void deleteSupportTicket(Long id) {
        SupportTicket existingSupportTicket = findById(id);
        repository.delete(existingSupportTicket);
    }

}
