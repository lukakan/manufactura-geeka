package pl.manufakturageeka.shop.domain.product;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    @OneToMany(mappedBy = "product")
    private Set<Tag> tags;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(columnDefinition = "TEXT")
    private String description;
    @OneToMany(mappedBy = "product")
    private List<Picture> pictures;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate addDate;

}
