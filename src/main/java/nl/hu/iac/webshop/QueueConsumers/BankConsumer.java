package nl.hu.iac.webshop.QueueConsumers;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.hu.iac.webshop.DTO.BankConfirmationDTO;
import nl.hu.iac.webshop.services.BankConsumerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BankConsumer {

    @Autowired
    private BankConsumerService bankConsumerService;

    @RabbitListener(queues = "bankConfirmationQueue")
    public void receive(String message) {

        BankConfirmationDTO confirmation = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            confirmation = mapper.readValue(message, BankConfirmationDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bankConsumerService.receiveMessage(confirmation);
    }
}
