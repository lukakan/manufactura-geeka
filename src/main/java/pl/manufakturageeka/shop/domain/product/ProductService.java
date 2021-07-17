package pl.manufakturageeka.shop.domain.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.manufakturageeka.shop.domain.config.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;
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

    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::toDto).collect(Collectors.toList());
    }

    public ProductDto toDto(Product product) {
        return new ProductDto(product);
    }

    public ProductDto findById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            return toDto(productOptional.get());
        } else {
            throw new ResourceNotFoundException();
        }
    }
}
