package com.company.sample.service;

public interface BasketService<E> {

    /**
     * Calculate the total price of the basket contents
     * @return  The total price of the contents of the basket
     */
    int calculatePrice(E basket);
}
