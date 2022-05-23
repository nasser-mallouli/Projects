package swt.eCommerceSystem.core.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class VersandBestellungCommand
{
    @TargetAggregateIdentifier
    private String versandID;
    private String bestellungID;
}
