package com.company.sample;

import com.company.sample.entity.Item;
import com.company.sample.entity.ShoppingBasket;
import com.company.sample.type.FruitItemType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BasketMain {

    public static void main(String[] args) {
        JSONObject jsonObject = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("basket.json").toURI()));
            String jsonBasket = new String(bytes);
            jsonObject = new JSONObject(jsonBasket);
        } catch (IOException | URISyntaxException | JSONException e) {
            e.printStackTrace();
        }
        ShoppingBasket<Item<FruitItemType>> shoppingBasket = extractBasket(jsonObject);

        double price = (double) shoppingBasket.getTotalPrice()/100.00;
        System.out.println("Total price of basket is: " + price);
    }

    private static ShoppingBasket<Item<FruitItemType>> extractBasket(JSONObject jsonObject) {
        ShoppingBasket<Item<FruitItemType>> shoppingBasket = new ShoppingBasket<>();
        if (jsonObject != null) {
            JSONArray basket = jsonObject.getJSONArray("basket");
            for (int i = 0; i < basket.length(); i++) {
                JSONObject basketItem = basket.getJSONObject(i);
                String itemLabel = basketItem.getString("item");
                int quantity = basketItem.getInt("quantity");

                FruitItemType item = FruitItemType.valueOf(itemLabel);
                Item<FruitItemType> fruitItem = new Item<>(item, quantity);
                shoppingBasket.addItem(fruitItem, quantity);
            }
        }
        return shoppingBasket;
    }
}
