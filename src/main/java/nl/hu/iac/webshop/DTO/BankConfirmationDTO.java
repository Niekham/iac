package nl.hu.iac.webshop.DTO;

public class BankConfirmationDTO {
    private Long bestellingId;
    private boolean accept;

    public BankConfirmationDTO(Long bestellingId, boolean accept) {
        this.bestellingId = bestellingId;
        this.accept = accept;
    }

    public BankConfirmationDTO(Long bestellingId) {
        this.bestellingId = bestellingId;
        this.accept = false;
    }

    public Long getBestellingId() {
        return bestellingId;
    }

    public boolean isAccept() {
        return accept;
    }
}
