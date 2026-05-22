package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private final int discount;

    public DiscountedProduct(String name, int price, int discount) {
        super(name, price);
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return super.getPrice() - discount;
    }

}
