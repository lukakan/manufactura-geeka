package pl.manufakturageeka.shop.domain.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> findByOrderByAddDate() {
        List<Product> products = productRepository.findTop3ByOrderByAddDate();
        return products.stream().map(this::toDto).collect(Collectors.toList());
    }

    public ProductDto toDto(Product product) {
        return new ProductDto(product);
    }
}
