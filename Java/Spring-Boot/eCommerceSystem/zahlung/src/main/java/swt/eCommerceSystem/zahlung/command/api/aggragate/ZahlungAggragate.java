package swt.eCommerceSystem.zahlung.command.api.aggragate;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import swt.eCommerceSystem.core.api.commands.ZahlungBestatigungCommand;
import swt.eCommerceSystem.core.api.events.ZahlungProcessedEvent;
import swt.eCommerceSystem.core.api.model.CardDetails;

@Aggregate
@Slf4j
public class ZahlungAggragate {

    @AggregateIdentifier
    private String zahlungId;
    private String bestellungId;
    private String paymentStatus;

    public ZahlungAggragate() {
    }
    public ZahlungAggragate(ZahlungBestatigungCommand zahlungBestatigungCommand) {
        // Validate the Zahlung Details
        // Publish the Zahlung Processed Event
        log.info("Execute ZahlungAggragate Commanf for bestellungID {} mit dem ZahlungID",
                zahlungBestatigungCommand.getBestellungId(),
                zahlungBestatigungCommand.getZahlungId());

        ZahlungProcessedEvent zahlungProcessedEvent
                = new ZahlungProcessedEvent(zahlungBestatigungCommand.getZahlungId(),
                zahlungBestatigungCommand.getBestellungId() );

        AggregateLifecycle.apply(zahlungProcessedEvent);
        log.info("Zahlung Prozess in Aggregate Applied");
    }

    @EventSourcingHandler
    public void on(ZahlungProcessedEvent event){
        this.zahlungId = event.getZahlungID();
        this.bestellungId = event.getBestellungID();
    }

}
