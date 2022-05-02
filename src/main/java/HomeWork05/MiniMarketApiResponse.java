package HomeWork05;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class MiniMarketApiResponse {

    private List<MiniMarketApiResponseItems> responseItems;

}
