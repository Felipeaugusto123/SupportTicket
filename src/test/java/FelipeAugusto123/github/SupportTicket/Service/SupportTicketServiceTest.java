package FelipeAugusto123.github.SupportTicket.Service;

import FelipeAugusto123.github.SupportTicket.Domain.SupportTicket;
import FelipeAugusto123.github.SupportTicket.Service.Util.Create;
import FelipeAugusto123.github.SupportTicket.repository.SupportTicketRepository;
import FelipeAugusto123.github.SupportTicket.request.SupportTicketRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SupportTicketServiceTest {

    @InjectMocks
    private SupportTicketService service;

    @Mock
    private SupportTicketRepository repository;

    @Mock
    private UserService userService;
    @Mock
    private TecTiService tecTIService;

    @Test
    void save_ReturnSaveSupportTicket_WhenSuccessful() {

        BDDMockito.when(userService.findById(ArgumentMatchers.any())).thenReturn(Create.createValidUser());
        BDDMockito.when(tecTIService.findById(ArgumentMatchers.any())).thenReturn(Create.createValidTecTI());
        BDDMockito.when(repository.save(ArgumentMatchers.any())).thenReturn(Create.createValidTicket());

        SupportTicket expectedSupportTicket = Create.createValidTicket();

        SupportTicket getSupportTicket = service.createSupportTicket(new SupportTicketRequest());

        Assertions.assertThat(getSupportTicket.getId()).isNotNull();
        Assertions.assertThat(getSupportTicket.getTitle()).isEqualTo(expectedSupportTicket.getTitle());
        Assertions.assertThat(getSupportTicket.getDescription()).isEqualTo(expectedSupportTicket.getDescription());
        Assertions.assertThat(getSupportTicket.getPriority()).isEqualTo(expectedSupportTicket.getPriority());
        Assertions.assertThat(getSupportTicket.getStatus()).isEqualTo(expectedSupportTicket.getStatus());


    }
}