package mobilnoposlovanje.web.springmvcrest.repositories;

import mobilnoposlovanje.web.springmvcrest.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdictRepository extends JpaRepository<Product, Long> {
}
