package HomeWork05;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductView {
    private Long id;
    private String title;
    private Long price;
    private String categoryTitle;
}
