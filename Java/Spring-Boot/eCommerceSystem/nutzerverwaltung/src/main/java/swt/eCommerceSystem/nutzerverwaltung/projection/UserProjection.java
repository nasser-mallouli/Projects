package swt.eCommerceSystem.nutzerverwaltung.projection;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import swt.eCommerceSystem.core.api.model.CardDetails;
import swt.eCommerceSystem.core.api.model.Konto;
import swt.eCommerceSystem.core.api.queries.GetKontoZahlungDetailsQuery;

@Component
public class UserProjection {

    @QueryHandler
    public Konto GetUserZahlungDetails(GetKontoZahlungDetailsQuery guery) {
        // We need to get Details from the DB
        CardDetails cardDetails = CardDetails.builder()
                .name("Mallouli FJ")
                    .cardNumber("123456789")
                        .validUntilMonth("10")
                                .validUntilYear("200")
                                        .cvv(111)
                .build();
        return Konto.builder()
                .kontoID(guery.getKontoID())
                        .firstName("Mallouli")
                                .lastName("FJ")
                                        .cardDetails(cardDetails)

                .build();
    }
}
