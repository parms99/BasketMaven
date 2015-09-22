package com.company.sample.entity;

public interface Basket<E> {
    /**
     * Add the given quantity of an item to the basket.
     * @param item      The item to add
     * @param quantity  The quantity of the item to add
     */
    void addItem(E item, int quantity);

    /**
     * Add one item to the basket.
     * @param item      The item to add
     */
    void addItem(E item);

    /**
     * Remove one instance of the given item from the basket
     * @param item  The item to remove
     * @return  whether or not the item was removed
     */
    boolean removeItem(E item);

    /**
     * Remove the given quantity of the given item from the basket. If there are not enough
     * @param item      The item to remove
     * @param quantity  The quantity of the item to remove from the basket
     * @return  whether or not the number of items was removed
     */
    boolean removeItem(E item, int quantity);

    /**
     * Remove all of the given item from the basket
     * @param item  The item to remove
     */
    void removeAllOfItem(E item);

    /**
     * Get the total number of items in the basket
     * @return  the total number of items in the basket
     */
    int getTotalNumberOfItems();

    /**
     * Get the quantity of the given item in the basket
     * @param item  The item for which the quantity is required
     * @return  The quantity of the given item
     */
    int getQuantityForItem(E item);

    /**
     * Empty the basket
     */
    void empty();

    /**
     * Get the resulting map
     * @return the map
     */
    int getTotalPrice();
}
