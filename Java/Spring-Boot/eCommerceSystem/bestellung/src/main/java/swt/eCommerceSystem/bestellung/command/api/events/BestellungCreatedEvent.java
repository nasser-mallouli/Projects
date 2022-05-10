package swt.eCommerceSystem.bestellung.command.api.events;

import lombok.Data;

@Data
public class BestellungCreatedEvent {

    private String BestellungId;
    private String KontoID;
    private String produktID;
    private String AddressID;
    private int quantity;
    private String BestellungStatus;
}
