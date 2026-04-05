package FelipeAugusto123.github.SupportTicket.Service;

import FelipeAugusto123.github.SupportTicket.Domain.User;
import FelipeAugusto123.github.SupportTicket.Domain.exceptions.BadRequest;
import FelipeAugusto123.github.SupportTicket.repository.UserRepository;
import FelipeAugusto123.github.SupportTicket.request.UserRequest;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    @Transactional
    public User createUser(UserRequest request) {
        return repository.save(User.builder().name(request.getName())
                .email(request.getEmail())
                .CPF(request.getCPF())
                .password(request.getPassword())
                .build());
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BadRequest("User not found with id: " + id));
    }

    public User findByCPF(String CPF) {
        return repository.findByCPF(CPF).orElseThrow(() -> new BadRequest("User not found with CPF: " + CPF));
    }

    @Transactional
    public User updateUser(Long id, UserRequest request) {
        User user = findById(id);
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setCPF(request.getCPF());
        user.setPassword(request.getPassword());
        return repository.save(user);
    }


    @Transactional
    public void deleteUser(Long id) {
        User user = findById(id);
        repository.delete(user);
    }


}
