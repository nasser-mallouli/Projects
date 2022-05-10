package swt.eCommerceSystem.zahlung.command.api.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Zahlung {

    @Id
    private String zahlungID;
    private String bestellungID;
    private Date timeStamp;
    private String zahlungStatus;
}
