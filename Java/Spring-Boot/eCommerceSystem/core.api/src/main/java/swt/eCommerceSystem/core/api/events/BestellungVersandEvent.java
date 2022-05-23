package swt.eCommerceSystem.core.api.events;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BestellungVersandEvent
{
    private String versandID;
    private String bestellungID;
    private String versandStatus;
}
