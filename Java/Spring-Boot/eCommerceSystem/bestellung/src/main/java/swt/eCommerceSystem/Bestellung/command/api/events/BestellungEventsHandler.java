package swt.eCommerceSystem.Bestellung.command.api.events;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import swt.eCommerceSystem.Bestellung.command.api.data.Bestellung;
import swt.eCommerceSystem.Bestellung.command.api.data.BestellungRepository;
import swt.eCommerceSystem.core.api.events.BestellungCompletedEvent;

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
    @EventHandler
    public void on(BestellungCompletedEvent event) {
        Bestellung bestellung = bestellungRepository.findById(event.getBestellungID()).get();
        bestellung.setBestellungStatus(event.getBestellungStatus());
        bestellungRepository.save(bestellung);
    }
}
