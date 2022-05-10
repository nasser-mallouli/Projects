package swt.eCommerceSystem.core.api.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZahlungProcessedEvent {
    private String zahlungID;
    private String bestellungID;
}
