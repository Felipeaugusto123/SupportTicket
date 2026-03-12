package FelipeAugusto123.github.SupportTicket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class SupportTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupportTicketApplication.class, args);
    }


}
