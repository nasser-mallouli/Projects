package swt.eCommerceSystem.bestellung.command.api.events;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import swt.eCommerceSystem.bestellung.command.api.data.Bestellung;
import swt.eCommerceSystem.bestellung.command.api.data.BestellungRepository;

@Component
public class BestellungEventsHandler {

    private BestellungRepository bestellungRepository;

    public BestellungEventsHandler(BestellungRepository bestellungRepository) {
        this.bestellungRepository = bestellungRepository;
    }

    @EventHandler
    public void on(BestellungCreatedEvent event){
        Bestellung bestellung = new Bestellung();
        BeanUtils.copyProperties(event, bestellung);
    }
}
