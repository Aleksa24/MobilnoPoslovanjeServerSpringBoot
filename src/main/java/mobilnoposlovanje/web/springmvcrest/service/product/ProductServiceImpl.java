package mobilnoposlovanje.web.springmvcrest.service.product;

import mobilnoposlovanje.web.springmvcrest.domain.Product;
import mobilnoposlovanje.web.springmvcrest.repositories.ProdictRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProdictRepository prodictRepository;

    public ProductServiceImpl(ProdictRepository prodictRepository) {
        this.prodictRepository = prodictRepository;
    }


    @Override
    public Product findProductById(Long id) {
        return prodictRepository.findById(id).get();
    }

    @Override
    public List<Product> findAllProducts() {
        return prodictRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return prodictRepository.save(product);
    }
}
