package swt.eCommerceSystem.Bestellung.command.api.saga;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;
import swt.eCommerceSystem.Bestellung.command.api.events.BestellungCreatedEvent;
import swt.eCommerceSystem.core.api.commands.CompletBestellungCommand;
import swt.eCommerceSystem.core.api.commands.VersandBestellungCommand;
import swt.eCommerceSystem.core.api.commands.ZahlungBestatigungCommand;
import swt.eCommerceSystem.core.api.events.BestellungVersandEvent;
import swt.eCommerceSystem.core.api.events.ZahlungProcessedEvent;
import swt.eCommerceSystem.core.api.model.Konto;
import swt.eCommerceSystem.core.api.queries.GetKontoZahlungDetailsQuery;

import java.util.UUID;

@Saga
@Slf4j
public class BestellungProcessingSaga {


        @Autowired
        private transient CommandGateway commandGateway;
        @Autowired
        private transient QueryGateway queryGateway;


    public BestellungProcessingSaga()
    {
    }

    @StartSaga
        @SagaEventHandler(associationProperty = "bestellungID")
        private void handle(BestellungCreatedEvent event) {
            log.info("BestellungCreatedEvent in Saga for Bestellung Id: {}", event.getBestellungID());

            /*  get User information with Id, */
            GetKontoZahlungDetailsQuery getKontoZahlungDetailsQuery =
                    new GetKontoZahlungDetailsQuery(event.getKontoID());
            Konto konto = null;
            // we just need to wait until we get our query here

            try {
                konto = queryGateway.query(getKontoZahlungDetailsQuery, ResponseTypes.instanceOf(Konto.class)).join();
            }catch (Exception e) {
                log.error(e.getMessage());
                // Start The Componsating transaction
            }
            ZahlungBestatigungCommand zahlungBestatigungCommand = ZahlungBestatigungCommand.builder()
                    .cardDetails(konto.getCardDetails())
                    .bestellungID(event.getBestellungID())
                    .zahlungId(UUID.randomUUID().toString())
                    .build();

            commandGateway.sendAndWait(zahlungBestatigungCommand);
        }

        @SagaEventHandler(associationProperty = "bestellungID")
        private void handle(ZahlungProcessedEvent event) {
            log.info("ZahlungProcessedEvent in Saga Handler for Zahlung Id: {}", event.getZahlungID());
            try {
                VersandBestellungCommand versandBestellungCommand =
                        VersandBestellungCommand.builder()
                                .versandID(UUID.randomUUID().toString())
                                .bestellungID(event.getBestellungID())
                                .build();
                commandGateway.send(versandBestellungCommand);
            }catch ( Exception e) {
                log.error(e.getMessage());
                // Start the Compensation transaction
            }
        }
        @SagaEventHandler(associationProperty = "bestellungID")
        public void handle(BestellungVersandEvent event) {
            log.info("BestellungVersandEvent in Saga Handler for Bestellung Id: {}", event.getBestellungID());
            try
            {
                CompletBestellungCommand completBestellungCommand =
                        CompletBestellungCommand.builder()
                                .bestellungID(event.getBestellungID())
                                .bestellungStatus("APPROVED")
                                .build();
                commandGateway.send(completBestellungCommand);
            } catch ( Exception e) {
                log.error(e.getMessage());
                // Start the Compensation transaction
            }

        }
        @SagaEventHandler(associationProperty = "bestellungID")
        @EndSaga
        public void handle(CompletBestellungCommand event) {
            log.info("CompletBestellungCommand in Saga Handler for Bestellung Id: {}", event.getBestellungID());
        }


}
