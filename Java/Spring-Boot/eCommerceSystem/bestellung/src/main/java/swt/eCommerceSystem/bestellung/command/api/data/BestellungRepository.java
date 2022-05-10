package swt.eCommerceSystem.bestellung.command.api.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BestellungRepository extends JpaRepository<Bestellung, String> {
}
