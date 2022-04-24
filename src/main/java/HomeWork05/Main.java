package HomeWork05;

import HomeWork05.Clients.MiniMarketClient;

public class Main {
    public static void main(String[] args) {
        MiniMarketClient client = new MiniMarketClient();
        MiniMarketApiResponse products = client.findProductById("*/*");
        System.out.println(products);
    }
}
