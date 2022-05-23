package swt.eCommerceSystem.Bestellung.command.api.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BestellungRepository extends JpaRepository<Bestellung, String> {
}
