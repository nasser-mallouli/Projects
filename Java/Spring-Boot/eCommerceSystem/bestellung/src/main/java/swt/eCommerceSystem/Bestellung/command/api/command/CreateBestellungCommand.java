package swt.eCommerceSystem.Bestellung.command.api.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateBestellungCommand {

    @TargetAggregateIdentifier
    private String bestellungID;
    private String kontoID;
    private String produktID;
    private String addressID;
    private int quantity;
    private String bestellungStatus;
}
