package mobilnoposlovanje.web.springmvcrest.service.product;


import mobilnoposlovanje.web.springmvcrest.domain.Product;

import java.util.List;

public interface ProductService {
    Product findProductById(Long id);

    List<Product> findAllProducts();

    Product saveProduct(Product product);
}
