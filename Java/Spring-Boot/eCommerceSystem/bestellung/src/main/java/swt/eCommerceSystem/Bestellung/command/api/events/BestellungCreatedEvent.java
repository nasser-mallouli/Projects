package swt.eCommerceSystem.Bestellung.command.api.events;

import lombok.Data;

@Data
public class BestellungCreatedEvent {

    private String bestellungID;
    private String kontoID;
    private String produktID;
    private String addressID;
    private Integer quantity;
    private String BestellungStatus;
}
