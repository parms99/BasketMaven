package com.company.sample.entity;

import com.company.sample.type.FruitItemType;

public class FruitItem extends Item<FruitItemType> {
    public FruitItem(FruitItemType fruit) {
        super(fruit, fruit.getPricePerUnit());
    }
}
