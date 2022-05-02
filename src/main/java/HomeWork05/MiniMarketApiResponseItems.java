package HomeWork05;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class MiniMarketApiResponseItems {
    private Long id;
    private String title;
    private Long price;
    private String categoryTitle;
}
