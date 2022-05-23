package swt.eCommerceSystem.core.api.events;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BestellungCompletedEvent
{
    private String bestellungID;
    private String bestellungStatus;
}
