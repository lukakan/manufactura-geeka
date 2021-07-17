package pl.manufakturageeka.shop.domain.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.manufakturageeka.shop.domain.config.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produkty")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String productsList(Model model) {
        List<ProductDto> products = productService.findAll();
        model.addAttribute("products", products);
        return "product/products";
    }

    @GetMapping("/{id}")
    public String product(@PathVariable(name = "id") Long id, Model model) {
        ProductDto productDto = productService.findById(id);
        model.addAttribute("product", productDto);
        return "product/single";
    }
}
