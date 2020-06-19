package mobilnoposlovanje.web.springmvcrest.controllers;

import mobilnoposlovanje.web.springmvcrest.domain.Product;
import mobilnoposlovanje.web.springmvcrest.service.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ProductController.BASE_URL)
public class ProductController {
    public static final String BASE_URL = "/api/v1/product";
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @CrossOrigin//(origins = "http://localhost:8100")
    @GetMapping
    List<Product> getAllProducts(){
        System.out.println("===getAllProducts()===");
        return productService.findAllProducts();
    }

    @CrossOrigin//(origins = "http://localhost:8100")
    @GetMapping("/{id}")
    public Product getUserById(@PathVariable Long id){
        System.out.println("===getUserById(id)===");
        return productService.findProductById(id);
    }

    @CrossOrigin//(origins = "http://localhost:8100")
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveUser(@RequestBody Product product){
        Product savedUser = productService.saveProduct(product);
        System.out.println("SavedUser:" + savedUser);
        System.out.println("savedUser:" + savedUser);
        return savedUser;
    }


}
