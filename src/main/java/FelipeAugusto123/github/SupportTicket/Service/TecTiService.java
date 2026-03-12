package FelipeAugusto123.github.SupportTicket.Service;

import FelipeAugusto123.github.SupportTicket.Domain.TecTI;
import FelipeAugusto123.github.SupportTicket.Domain.enums.Position;
import FelipeAugusto123.github.SupportTicket.Domain.exceptions.BadRequest;
import FelipeAugusto123.github.SupportTicket.repository.TecTIRepository;
import FelipeAugusto123.github.SupportTicket.request.TecTIRequest;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@RequiredArgsConstructor
@Service
public class TecTiService {

    private final TecTIRepository repository;

    public TecTI findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BadRequest("TecTI not found with id: " + id));
    }

    public TecTI findByCPF(String CPF) {
        return repository.findByCPF(CPF).orElseThrow(() -> new BadRequest("TecTI not found with CPF: " + CPF));
    }

    @Transactional
    public TecTI createTecTI(TecTIRequest request) {
        return repository.save(TecTI.builder()
                .name(request.getName())
                .email(request.getEmail())
                .CPF(request.getCPF())
                .position(Position.fromString(request.getPosition().toUpperCase()))
                .build());
    }

    @Transactional
    public TecTI updateTecTi(Long id, TecTIRequest request) {
        TecTI user = findById(id);
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setCPF(request.getCPF());
        user.setPosition(Position.fromString(request.getPosition()));
        return repository.save(user);
    }

}
