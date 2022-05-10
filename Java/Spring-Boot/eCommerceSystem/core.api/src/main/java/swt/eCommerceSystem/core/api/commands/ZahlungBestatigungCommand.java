package swt.eCommerceSystem.core.api.commands;

import lombok.Builder;
import lombok.Data;
import swt.eCommerceSystem.core.api.model.CardDetails;

@Data
@Builder
public class ZahlungBestatigungCommand {

    private String zahlungId;
    private String bestellungId;
    private CardDetails cardDetails;

}
