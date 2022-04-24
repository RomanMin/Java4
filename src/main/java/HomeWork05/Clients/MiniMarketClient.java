package HomeWork05.Clients;

import HomeWork05.Api.MiniMarketApi;
import HomeWork05.Api.ResponseUtils;
import HomeWork05.MiniMarketApiResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MiniMarketClient {
    private final MiniMarketApi api;
    private static final String API_URL = "https://minimarket1.herokuapp.com/market/";


    public MiniMarketClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.api = retrofit.create(MiniMarketApi.class);
    }

   public MiniMarketApiResponse findAllProducts(
            String query
    ) {
        Call<MiniMarketApiResponse> responseCall = api.findAllProducts(query);
      return ResponseUtils.executeCall(responseCall);
        }
    public MiniMarketApiResponse findProductById(
            String path

    ) {
        Call<MiniMarketApiResponse> responseCall = api.findProductById(path);
        return ResponseUtils.executeCall(responseCall);
    }

}
