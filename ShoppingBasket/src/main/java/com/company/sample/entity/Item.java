package com.company.sample.entity;

/**
 * A basket item comprises of an item and its price
 */
public class Item<E> {
    final private int price;
    final E item;

    public Item(E item, int price) {
        this.item = item;
        this.price = price;
    }

    public E getItem() {
        return item;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item1 = (Item) o;

        if (price != item1.price) return false;
        if (item != null ? !item.equals(item1.item) : item1.item != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        return result;
    }
}
