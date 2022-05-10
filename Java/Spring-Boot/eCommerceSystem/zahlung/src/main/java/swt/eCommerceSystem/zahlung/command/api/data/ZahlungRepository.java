package swt.eCommerceSystem.zahlung.command.api.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ZahlungRepository extends JpaRepository<Zahlung,String> {
}
