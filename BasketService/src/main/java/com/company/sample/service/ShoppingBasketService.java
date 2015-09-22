package com.company.sample.service;

import com.company.sample.entity.Item;
import com.company.sample.entity.ShoppingBasket;

public class ShoppingBasketService implements BasketService<ShoppingBasket<Item>> {

    @Override
    public int calculatePrice(ShoppingBasket<Item> basket) {
        return basket.getTotalPrice();
    }
}
