package swt.eCommerceSystem.core.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardDetails {
    private String name;
    private String cardNumber;
    private String validUntilMonth;
    private String validUntilYear;
    private Integer cvv;

}
