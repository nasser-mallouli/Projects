package swt.eCommerceSystem.Bestellung.command.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BestellungRestModel {
    private String produktID;
    private String kontoID;
    private String addressID;
    private Integer quantity;

}
