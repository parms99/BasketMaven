package com.company.sample.service;

import com.company.sample.entity.Item;
import com.company.sample.entity.ShoppingBasket;
import com.company.sample.type.FruitItemType;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.company.sample.type.FruitItemType.*;
import static junit.framework.Assert.assertEquals;

public class ShoppingBasketServiceTest {

    private ShoppingBasketService service;

    @Before
    public void setUp() {
        service = new ShoppingBasketService();
    }

    @Test
    public void price_of_an_empty_basket_is_zero() {
        ShoppingBasket<Item> basket = new ShoppingBasket<>();
        assertEquals(0, service.calculatePrice(basket));
    }

    @Test
    public void the_price_of_a_basket_with_one_item_is_as_expected() {
        ShoppingBasket<Item> basket = new ShoppingBasket<>();
        Item<FruitItemType> item = new Item<>(BANANA, BANANA.getPricePerUnit());
        basket.addItem(item);

        assertEquals(BANANA.getPricePerUnit(), service.calculatePrice(basket));
    }

    @Test
    public void the_price_of_a_basket_of_fruit_is_as_expected() {
        ShoppingBasket<Item> basket = new ShoppingBasket<>();
        Item<FruitItemType> banana = new Item<>(BANANA, BANANA.getPricePerUnit());
        basket.addItem(banana, 2);
        Item<FruitItemType> apple = new Item<>(APPLE, APPLE.getPricePerUnit());
        basket.addItem(apple, 5);
        Item<FruitItemType> orange = new Item<>(ORANGE, ORANGE.getPricePerUnit());
        basket.addItem(orange, 3);
        Item<FruitItemType> lemon = new Item<>(LEMON, LEMON.getPricePerUnit());
        basket.addItem(lemon, 2);

        int expectedCost =
                        2*BANANA.getPricePerUnit() +
                        5*APPLE.getPricePerUnit() +
                        3*ORANGE.getPricePerUnit() +
                        2*LEMON.getPricePerUnit();

        assertEquals(expectedCost, service.calculatePrice(basket));
    }

}