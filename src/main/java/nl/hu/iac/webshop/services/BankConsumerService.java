package nl.hu.iac.webshop.services;

import nl.hu.iac.webshop.DTO.BankConfirmationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankConsumerService {

    @Autowired
    private BestellingService bestellingService;

    public void receiveMessage(BankConfirmationDTO dto) {
        if(dto.isAccept()) {
            bestellingService.goedgekeurd(dto.getBestellingId());
        } else {
            bestellingService.afgekeurd(dto.getBestellingId());
        }
    }
}
