package swt.eCommerceSystem.Bestellung.command.api.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "bestellungen")
public class Bestellung {

    @Id
    private String bestellungID;
    private String kontoID;
    private String produktID;
    private String addressID;
    private int quantity;
    private String BestellungStatus;
}
