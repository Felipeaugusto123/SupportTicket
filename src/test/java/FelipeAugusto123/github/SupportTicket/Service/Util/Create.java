package FelipeAugusto123.github.SupportTicket.Service.Util;

import FelipeAugusto123.github.SupportTicket.Domain.SupportTicket;
import FelipeAugusto123.github.SupportTicket.Domain.TecTI;
import FelipeAugusto123.github.SupportTicket.Domain.User;
import FelipeAugusto123.github.SupportTicket.Domain.enums.Position;
import FelipeAugusto123.github.SupportTicket.Domain.enums.Priority;
import FelipeAugusto123.github.SupportTicket.Domain.enums.Status;

public class Create {

    public static User createValidUser() {

        User user = new User();
        user.setId(1L);
        user.setName("Felipe Augusto");
        user.setEmail("teste@gmail.com");
        user.setPassword("123456");
        user.setCPF("12345678900");
        user.setSupportTickets(new java.util.HashSet<>());

        return user;
    }

    public static TecTI createValidTecTI() {

        TecTI tecTI = new TecTI();
        tecTI.setId(2L);
        tecTI.setName("João Silva");
        tecTI.setEmail("teste1@gmail.com");
        tecTI.setPassword("123456");
        tecTI.setCPF("09876543211");
        tecTI.setSupportTickets(new java.util.HashSet<>());
        tecTI.setPosition(Position.JUNIOR);
        tecTI.setAssignedTickets(new java.util.HashSet<>());
        return tecTI;

    }

    public static SupportTicket createValidTicket() {
        TecTI tecTI = createValidTecTI();
        User user = createValidUser();

        SupportTicket supportTicket = new SupportTicket();
        supportTicket.setId(1L);
        supportTicket.setTitle("Problema com o computador");
        supportTicket.setDescription("O computador não liga");
        supportTicket.setPriority(Priority.MEDIUM);
        supportTicket.setStatus(Status.IN_PROGRESS);
        supportTicket.setUser(user);
        supportTicket.setTecTI(tecTI);

        return supportTicket;
    }

}
