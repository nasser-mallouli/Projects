package swt.eCommerceSystem.bestellung.command.api.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "bestellungen")
public class Bestellung {

    @Id
    private String BestellungId;
    private String KontoID;
    private String produktID;
    private String AddressID;
    private int quantity;
    private String BestellungStatus;
}
