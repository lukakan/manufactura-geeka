package pl.manufakturageeka.shop.domain.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.manufakturageeka.shop.domain.product.ProductDto;
import pl.manufakturageeka.shop.domain.product.ProductService;

import java.util.List;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        List<ProductDto> products = productService.findRecentlyAdded();
        model.addAttribute("products", products);
        return "home";
    }

}
