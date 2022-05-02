package HomeWork05;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MiniMarketApiProductsResponse {
        public List<ProductView> products;
        public String type;
}
