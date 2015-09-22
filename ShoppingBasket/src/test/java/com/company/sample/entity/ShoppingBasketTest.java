package com.company.sample.entity;

import com.company.sample.type.FruitItemType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.company.sample.type.FruitItemType.*;
import static org.junit.Assert.*;

public class ShoppingBasketTest {
    private ShoppingBasket<Item<FruitItemType>> basket;
    private final static FruitItem BANANA_ITEM = new FruitItem(BANANA);
    private final static FruitItem APPLE_ITEM = new FruitItem(APPLE);
    private final static FruitItem LEMON_ITEM = new FruitItem(LEMON);
    private final static FruitItem ORANGE_ITEM = new FruitItem(ORANGE);
    private final static FruitItem PEACH_ITEM = new FruitItem(PEACH);

    @Before
    public void setUp() {
        basket = new ShoppingBasket<>();
    }

    @After
    public void tearDown() {
        basket = null;
    }

    @Test
    public void an_item_can_be_added() {
        Item<FruitItemType> item = new Item<>(BANANA, BANANA.getPricePerUnit());
        basket.addItem(item);
        assertEquals(1, basket.getTotalNumberOfItems());
    }

    @Test
    public void an_item_can_be_removed() {
        FruitItem item = APPLE_ITEM;
        basket.addItem(item);
        assertEquals(1, basket.getTotalNumberOfItems());
        basket.removeItem(item);
        assertEquals(0, basket.getTotalNumberOfItems());
    }

    @Test
    public void attempting_to_remove_an_item_from_an_empty_basket_returns_false() {
        assertFalse(basket.removeItem(BANANA_ITEM));
    }

    @Test
    public void attempting_to_remove_an_item_with_quantity_greater_than_zero_returns_true() {
        FruitItem banana = BANANA_ITEM;
        basket.addItem(banana);
        assertTrue(basket.removeItem(banana));
    }

    @Test
    public void attempting_to_remove_an_item_that_has_zero_quantity_returns_false() {
        FruitItem banana = BANANA_ITEM;
        basket.addItem(banana);
        basket.removeItem(banana);
        assertEquals(0, basket.getTotalNumberOfItems());
        assertFalse(basket.removeItem(banana));
    }

    @Test
    public void two_different_types_of_items_can_be_added() {
        FruitItem banana = BANANA_ITEM;
        FruitItem apple = APPLE_ITEM;
        basket.addItem(banana);
        basket.addItem(apple);
        assertEquals(2, basket.getTotalNumberOfItems());
    }

    @Test
    public void two_different_types_of_item_can_be_removed() {
        FruitItem lemon = LEMON_ITEM;
        FruitItem peach = PEACH_ITEM;
        basket.addItem(lemon);
        basket.addItem(peach);
        assertEquals(2, basket.getTotalNumberOfItems());
        basket.removeItem(lemon);
        assertEquals(1, basket.getTotalNumberOfItems());
        basket.removeItem(peach);
        assertEquals(0, basket.getTotalNumberOfItems());
    }

    @Test
    public void two_of_the_same_types_of_items_can_be_added_to_the_basket() {
        FruitItem orange = ORANGE_ITEM;
        basket.addItem(orange);
        basket.addItem(orange);
        assertEquals(2, basket.getTotalNumberOfItems());
    }

    @Test
    public void multiple_items_of_the_same_type_can_be_added_to_the_basket_when_none_existed() {

        FruitItem banana = BANANA_ITEM;
        basket.addItem(banana, 2);
        assertEquals(2, basket.getTotalNumberOfItems());
    }

    @Test
    public void multiple_items_of_the_same_type_can_be_added_to_the_basket_when_items_of_that_type_already_exist() {
        FruitItem apple = APPLE_ITEM;
        basket.addItem(apple, 2);
        assertEquals(2, basket.getTotalNumberOfItems());
        basket.addItem(apple, 5);
        assertEquals(7, basket.getTotalNumberOfItems());
    }

    @Test
    public void multiple_items_of_different_type_can_be_added_to_the_basket() {
        FruitItem banana = BANANA_ITEM;
        FruitItem apple = APPLE_ITEM;
        basket.addItem(banana, 3);
        basket.addItem(apple, 4);
        assertEquals(7, basket.getTotalNumberOfItems());
    }

    @Test
    public void the_basket_can_be_emptied() {
        FruitItem apple = APPLE_ITEM;
        basket.addItem(apple);
        basket.empty();
        assertEquals(0, basket.getTotalNumberOfItems());
    }

    @Test
    public void a_specific_item_can_be_removed() {
        FruitItem apple = APPLE_ITEM;
        FruitItem banana = BANANA_ITEM;
        FruitItem orange = ORANGE_ITEM;
        FruitItem lemon = LEMON_ITEM;
        FruitItem peach = PEACH_ITEM;

        basket.addItem(apple, 4);
        basket.addItem(banana, 7);
        basket.addItem(orange, 12);
        basket.addItem(lemon, 3);
        basket.addItem(peach, 6);

        assertEquals(32, basket.getTotalNumberOfItems());
        assertEquals(4, basket.getQuantityForItem(apple));
        assertEquals(7, basket.getQuantityForItem(banana));
        assertEquals(12, basket.getQuantityForItem(orange));
        assertEquals(3, basket.getQuantityForItem(lemon));
        assertEquals(6, basket.getQuantityForItem(peach));

        basket.removeAllOfItem(lemon);

        assertEquals(29, basket.getTotalNumberOfItems());
        assertEquals(4, basket.getQuantityForItem(apple));
        assertEquals(7, basket.getQuantityForItem(banana));
        assertEquals(12, basket.getQuantityForItem(orange));
        assertEquals(0, basket.getQuantityForItem(lemon));
        assertEquals(6, basket.getQuantityForItem(peach));
    }

    @Test
    public void the_price_is_as_expected() {
        FruitItem apple = APPLE_ITEM;
        FruitItem banana = BANANA_ITEM;
        FruitItem orange = ORANGE_ITEM;
        FruitItem lemon = LEMON_ITEM;
        FruitItem peach = PEACH_ITEM;

        basket.addItem(apple, 4);
        basket.addItem(banana, 7);
        basket.addItem(orange, 12);
        basket.addItem(lemon, 3);
        basket.addItem(peach, 6);

        int price = basket.getTotalPrice();
        assertEquals(2179, price);
    }
}