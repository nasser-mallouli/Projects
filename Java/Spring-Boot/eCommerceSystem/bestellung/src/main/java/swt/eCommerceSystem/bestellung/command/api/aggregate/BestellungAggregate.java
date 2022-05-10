package swt.eCommerceSystem.bestellung.command.api.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
import swt.eCommerceSystem.bestellung.command.api.command.CreateBestellungCommand;
import swt.eCommerceSystem.bestellung.command.api.events.BestellungCreatedEvent;

@Aggregate
public class BestellungAggregate {

    @AggregateIdentifier
    private String BestellungId;
    private String KontoID;
    private String produktID;
    private String AddressID;
    private int quantity;
    private String BestellungStatus;

    public BestellungAggregate( ){
    }
    @CommandHandler
    public BestellungAggregate(CreateBestellungCommand createBestellungCommand){
        // Validate the Command

        BestellungCreatedEvent bestellungCreatedEvent
                = new BestellungCreatedEvent();
        /* Copy Data from BestellungCommand to BestellungEvent*/
        BeanUtils.copyProperties(createBestellungCommand,
                bestellungCreatedEvent);
        AggregateLifecycle.apply(bestellungCreatedEvent);
    }

    @EventSourcingHandler
    public void on( BestellungCreatedEvent event ){
        this.BestellungStatus = event.getBestellungStatus();
        this.BestellungId = event.getBestellungId();
        this.AddressID = event.getAddressID();
        this.quantity = event.getQuantity();
        this.produktID = event.getProduktID();
        this.KontoID = event.getKontoID();
    }
}
