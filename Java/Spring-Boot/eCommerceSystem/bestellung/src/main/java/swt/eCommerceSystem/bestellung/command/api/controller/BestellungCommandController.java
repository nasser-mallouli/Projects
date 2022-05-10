package swt.eCommerceSystem.bestellung.command.api.controller;


import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swt.eCommerceSystem.bestellung.command.api.command.CreateBestellungCommand;
import swt.eCommerceSystem.bestellung.command.api.model.BestellungRestModel;

import java.util.UUID;

@RestController
@RequestMapping("/bestellungs")
public class BestellungCommandController {

    private CommandGateway commandGateway;

    public BestellungCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createBestellung(@RequestBody BestellungRestModel bestellungRestModel) {
        String BestellungID = UUID.randomUUID().toString();

        CreateBestellungCommand createBestellungCommand = CreateBestellungCommand.builder()
                        .bestellungID(BestellungID)
                        .addressID(bestellungRestModel.getAddressID())
                .produktID(bestellungRestModel.getAddressID())
                .quantity(bestellungRestModel.getQuantity())
                .bestellungStatus("Created")
                .build();
        commandGateway.sendAndWait(createBestellungCommand);
        return "Bestellung schon erstellt";
    }
}
