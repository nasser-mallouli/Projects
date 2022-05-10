package swt.eCommerceSystem.bestellung.command.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BestellungRestModel {
    private String KontoID;
    private String produktID;
    private String AddressID;
    private int quantity;

}
