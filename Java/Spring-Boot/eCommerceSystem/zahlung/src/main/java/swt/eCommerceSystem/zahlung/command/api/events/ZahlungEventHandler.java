package swt.eCommerceSystem.zahlung.command.api.events;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import swt.eCommerceSystem.core.api.events.ZahlungProcessedEvent;
import swt.eCommerceSystem.zahlung.command.api.data.Zahlung;
import swt.eCommerceSystem.zahlung.command.api.data.ZahlungRepository;

import java.util.Date;

@Component
public class ZahlungEventHandler {

    private ZahlungRepository zahlungRepository;

    @EventHandler
    public void on(ZahlungProcessedEvent event) {
        Zahlung zahlung = Zahlung.builder()
                .zahlungID(event.getZahlungID())
                .bestellungID(event.getBestellungID())
                .zahlungStatus("COMPLETED")
                .timeStamp(new Date())
                .build();


    }
}
