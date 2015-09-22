package com.company.sample.entity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ShoppingBasket<E extends Item> implements Basket<E> {

    final private Map<E, Integer> items = new ConcurrentHashMap<>();

    @Override
    public void addItem(E item, int quantity) {
        items.compute(item, (i, q) -> (q == null) ? quantity : q + quantity);
    }

    public void addItem(E item) {
        addItem(item, 1);
    }

    @Override
    public boolean removeItem(E item, int quantity) {
        return (items.computeIfPresent(item, (i, q) -> (q >= quantity) ? q - quantity : null) != null);
    }

    @Override
    public boolean removeItem(E item) {
        return removeItem(item, 1);
    }

    @Override
    public void removeAllOfItem(E item) {
        items.remove(item);
    }

    @Override
    public void empty() {
        items.clear();
    }

    @Override
    public int getTotalPrice() {
        final int[] total = {0};
        items.forEach((basketItem, quantity)-> total[0] += basketItem.getPrice()* quantity );
        return total[0];
    }

    public int getTotalNumberOfItems() {
        final int[] total = {0};
        items.values().forEach(n -> total[0] += n);
        return total[0];
    }

    public int getQuantityForItem(E item) {
        return (items.get(item) == null ? 0 : items.get(item));
    }
}
