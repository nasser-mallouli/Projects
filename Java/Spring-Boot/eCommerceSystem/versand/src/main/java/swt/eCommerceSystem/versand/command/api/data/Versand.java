package swt.eCommerceSystem.versand.command.api.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Versand
{
    @Id
    private String versandID;
    private String bestellungID;
    private String versandStatus;
}
