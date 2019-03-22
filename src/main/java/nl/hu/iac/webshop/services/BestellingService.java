package nl.hu.iac.webshop.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.hu.iac.webshop.DTO.BankConfirmationDTO;
import nl.hu.iac.webshop.domain.Account;
import nl.hu.iac.webshop.domain.Bestelling;
import nl.hu.iac.webshop.domain.Bestellingsregel;
import nl.hu.iac.webshop.exceptions.BestellingNotFoundException;
import nl.hu.iac.webshop.repositories.BestellingRegelRepository;
import nl.hu.iac.webshop.repositories.BestellingRepository;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BestellingService {
    private final BestellingRepository bestellingRepository;
    private final BestellingRegelRepository bestellingRegelRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Exchange exchange;

    public BestellingService(BestellingRepository bestellingRepository, BestellingRegelRepository bestellingRegelRepository) {
        this.bestellingRepository = bestellingRepository;
        this.bestellingRegelRepository = bestellingRegelRepository;
    }

    public void goedgekeurd(Long id) {
        Bestelling bes = getBestelling(id);
        bes.setStatus("goedgekeurd");
        bestellingRepository.save(bes);
    }

    public void afgekeurd(Long id) {
        Bestelling bes = getBestelling(id);
        bes.setStatus("afgekeurd");
        bestellingRepository.save(bes);
    }

    private Bestelling getBestelling(Long id) {
        return bestellingRepository.findById(id).orElseThrow(()-> new BestellingNotFoundException(id));
    }

    public void nieuweBestelling(Account account, List<Bestellingsregel> bestellingsregels) {
        // maken en opslaan van een bestelling
        Bestelling newBestelling = new Bestelling("open", account, bestellingsregels);
        for(Bestellingsregel regel : bestellingsregels){
            regel.setBestelling(newBestelling);
        }
        bestellingRepository.save(newBestelling);
        for(Bestellingsregel regel : bestellingsregels)
        bestellingRegelRepository.save(regel);

        // bericht in de queue zetten naar de bank
        BankConfirmationDTO confirmation = new BankConfirmationDTO(newBestelling.getId());

        String routingKey = "bank.request";
        String json = convertToJson(confirmation);
        rabbitTemplate.convertAndSend(exchange.getName(), routingKey, json);
        System.out.println("Send message to Queue");
    }

    private String convertToJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
