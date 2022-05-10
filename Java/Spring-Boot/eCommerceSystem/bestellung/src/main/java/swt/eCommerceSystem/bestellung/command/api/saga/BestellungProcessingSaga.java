package swt.eCommerceSystem.bestellung.command.api.saga;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Saga;
import swt.eCommerceSystem.bestellung.command.api.events.BestellungCreatedEvent;
import swt.eCommerceSystem.core.api.commands.ZahlungBestatigungCommand;
import swt.eCommerceSystem.core.api.model.Konto;
import swt.eCommerceSystem.core.api.queries.GetKontoZahlungDetailsQuery;

import java.util.UUID;

@Saga
@Slf4j
public class BestellungProcessingSaga {


        private CommandGateway commandGateway;
        private QueryGateway queryGateway;

    public BestellungProcessingSaga(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @StartSaga
        @SagaEventHandler(associationProperty = "BestellungId")
        private void handle(BestellungCreatedEvent event) {
            log.info("BestellungCreatedEvent in Saga for Bestellung Id: {}", event.getBestellungId());

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
                    .bestellungId(event.getBestellungId())
                    .zahlungId(UUID.randomUUID().toString())
                    .build();

            commandGateway.sendAndWait(zahlungBestatigungCommand);

        }
}
