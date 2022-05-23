package swt.eCommerceSystem.core.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CompletBestellungCommand
{
    @TargetAggregateIdentifier
    private String bestellungID;
    private String bestellungStatus;

}
