package swt.eCommerceSystem.versand.command.api.events;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import swt.eCommerceSystem.core.api.events.BestellungVersandEvent;
import swt.eCommerceSystem.versand.command.api.data.Versand;
import swt.eCommerceSystem.versand.command.api.data.VersandRepository;

@Component
public class VersandEventHandler
{
    private VersandRepository versandRepository;

    public VersandEventHandler(VersandRepository versandRepository)
    {
        this.versandRepository = versandRepository;
    }

    public void on(BestellungVersandEvent event)
    {
        Versand versand = new Versand();
        BeanUtils.copyProperties(event, versand);
        versandRepository.save(versand);


    }
}
