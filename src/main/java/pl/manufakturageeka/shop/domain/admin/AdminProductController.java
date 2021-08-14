package pl.manufakturageeka.shop.domain.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.manufakturageeka.shop.domain.product.ProductDto;
import pl.manufakturageeka.shop.domain.product.ProductService;

import java.util.List;

@Controller
@RequestMapping("/admin/produkty")
public class AdminProductController {

    private final ProductService productService;

    public AdminProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String productList(Model model) {
        List<ProductDto> products = productService.findAll();
        model.addAttribute("products", products);
        return "admin/products";
    }

}
