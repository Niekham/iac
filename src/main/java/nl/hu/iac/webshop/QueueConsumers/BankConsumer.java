package nl.hu.iac.webshop.QueueConsumers;

import com.fasterxml.jackson.databind.JsonNode;
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

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BankConfirmationDTO confirmation = new BankConfirmationDTO(jsonNode.get("bestellingId").asLong(), jsonNode.get("accept").asBoolean());
        bankConsumerService.receiveMessage(confirmation);
    }
}
