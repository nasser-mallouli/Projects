package swt.eCommerceSystem.core.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Konto {
    private String userId;
    private String firstName;
    private String lastName;
    private CardDetails cardDetails;
}
