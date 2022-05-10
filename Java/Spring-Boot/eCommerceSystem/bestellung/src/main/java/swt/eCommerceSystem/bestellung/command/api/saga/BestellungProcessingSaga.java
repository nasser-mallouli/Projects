package swt.eCommerceSystem.bestellung.command.api.saga;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import swt.eCommerceSystem.bestellung.command.api.events.BestellungCreatedEvent;
import swt.eCommerceSystem.core.api.commands.ZahlungBestatigungCommand;

@Saga
@Slf4j
public class BestellungProcessingSaga {

        @StartSaga
        @SagaEventHandler(associationProperty = "BestellungId")
        private void handle(BestellungCreatedEvent event) {
            log.info("BestellungCreatedEvent in Saga for Bestellung Id: {}", event.getBestellungId());

            /*  get User information with Id, */


            ZahlungBestatigungCommand zahlungBestatigungCommand = ZahlungBestatigungCommand.builder().build();

        }
}
