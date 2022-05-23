package swt.eCommerceSystem.nutzerverwaltung.controller;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swt.eCommerceSystem.core.api.model.Konto;
import swt.eCommerceSystem.core.api.queries.GetKontoZahlungDetailsQuery;

@RestController
@RequestMapping("/kontos")
public class KontoController
{
    private transient QueryGateway queryGateway;

    public KontoController(QueryGateway queryGateway)
    {
        this.queryGateway = queryGateway;
    }

    @GetMapping("{kontos}")
    public Konto getKontoZahlungDetails(@PathVariable String kontoID)  {
        GetKontoZahlungDetailsQuery getKontoZahlungDetailsQuery
                = new GetKontoZahlungDetailsQuery(kontoID);
        Konto konto = queryGateway.query(getKontoZahlungDetailsQuery, ResponseTypes.instanceOf(Konto.class)).join();
        return konto;
    }
}
