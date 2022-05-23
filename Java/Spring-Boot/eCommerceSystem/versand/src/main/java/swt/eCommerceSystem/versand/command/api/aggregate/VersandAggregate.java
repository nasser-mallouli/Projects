package swt.eCommerceSystem.versand.command.api.aggregate;

import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import swt.eCommerceSystem.core.api.commands.VersandBestellungCommand;
import swt.eCommerceSystem.core.api.events.BestellungVersandEvent;

@Aggregate
public class VersandAggregate
{
    @AggregateIdentifier
    private String versandID;
    private String bestellungID;
    private String versandStatus;

    public VersandAggregate()
    {
    }
    public VersandAggregate(VersandBestellungCommand versandBestellungCommand) {
        // Validate the Command
        // Publish the Order Shipped Event
        BestellungVersandEvent bestellungVersandEvent =
                BestellungVersandEvent.builder()
                        .bestellungID(versandBestellungCommand.getBestellungID())
                        .versandID(versandBestellungCommand.getVersandID())
                        .versandStatus("COMPLETED")
                        .build();

        AggregateLifecycle.apply(bestellungVersandEvent);
    }

    @EventSourcingHandler
    public void on(BestellungVersandEvent event) {
        this.bestellungID = event.getBestellungID();
        this.versandID = event.getVersandID();
        this.versandStatus = event.getVersandStatus();
    }
}
