package pl.manufakturageeka.shop.domain.product;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private Set<Tag> tags;
    private Status status;
    private String description;
    private String picture;
    private LocalDate addDate;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.tags = product.getTags();
        this.status = product.getStatus();
        this.description = product.getDescription();
        this.picture = product.getPictures().get(0).getUrl();
        this.addDate = product.getAddDate();
    }

}
