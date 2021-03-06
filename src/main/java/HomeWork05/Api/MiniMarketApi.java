package HomeWork05.Api;

import HomeWork05.MiniMarketApiResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface MiniMarketApi {
    static final String BASE_URL = "api/v1/products/3";

   @GET(BASE_URL)
    Call<MiniMarketApiResponse> findAllProducts(
           @Query("query") String query
    );

    // @POST(BASE_URL)
    // @PUT(BASE_URL)
    @GET(BASE_URL)
    Call<MiniMarketApiResponse> findProductById(
            @Query("id") Long id
    );
    //@DELETE(BASE_URL)

}
