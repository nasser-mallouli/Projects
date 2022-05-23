package swt.eCommerceSystem.Bestellung.command.api.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
import swt.eCommerceSystem.Bestellung.command.api.command.CreateBestellungCommand;
import swt.eCommerceSystem.Bestellung.command.api.events.BestellungCreatedEvent;
import swt.eCommerceSystem.core.api.commands.CompletBestellungCommand;
import swt.eCommerceSystem.core.api.events.BestellungCompletedEvent;
import swt.eCommerceSystem.core.api.events.BestellungVersandEvent;

@Aggregate
public class BestellungAggregate {

    @AggregateIdentifier
    private String bestellungID;
    private String kontoID;
    private String produktID;
    private String addressID;
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
    public void on( BestellungCreatedEvent event){
        this.BestellungStatus = event.getBestellungStatus();
        this.bestellungID = event.getBestellungID();
        this.addressID = event.getAddressID();
        this.quantity = event.getQuantity();
        this.produktID = event.getProduktID();
        this.kontoID = event.getKontoID();
    }

    @CommandHandler
    public void handle(CompletBestellungCommand completBestellungCommand) {
        //Validate the Command
        // Publish Bestellung Completed Event
        BestellungVersandEvent bestellungVersandEvent =
                BestellungVersandEvent.builder()
                        .versandStatus(completBestellungCommand.getBestellungStatus())
                        .bestellungID(completBestellungCommand.getBestellungID())
                        .build();
                AggregateLifecycle.apply(bestellungVersandEvent);
    }

    @EventSourcingHandler
    public void on(BestellungCompletedEvent event) {
        this.BestellungStatus = event.getBestellungStatus();
    }
}
