package com.company.sample.type;

public enum FruitItemType {
    BANANA  (68, "KG"),
    ORANGE  (34, "EACH"),
    APPLE   (200, "KG"),
    LEMON   (35, "EACH"),
    PEACH   (65, "EACH");

    private final int pricePerUnit;
    private final String unit;

    FruitItemType(int pricePerUnit, String unit) {
        this.pricePerUnit = pricePerUnit;
        this.unit = unit;
    }

    public int getPricePerUnit() {
        return pricePerUnit;
    }

    public String getUnit() {
        return unit;
    }
}
