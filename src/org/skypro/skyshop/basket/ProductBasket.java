package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private final Product[] products = new Product[5];

    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }

        System.out.println("Невозможно добавить продукт");
    }

    public int getTotalPrice() {
        int total = 0;

        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();
            }
        }

        return total;
    }

    public void printBasket() {
        boolean isEmpty = true;

        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
                isEmpty = false;
            }
        }

        if (isEmpty) {
            System.out.println("В корзине пусто");
            return;
        }

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + getSpecialProductCount());
    }

    public boolean containsProduct(String productName) {
        for (Product product : products) {
            if (product != null && product.getName().equals(productName)) {
                return true;
            }
        }

        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }

    public int getSpecialProductCount() {
        int count = 0;

        for (Product product : products) {
            if (product != null && product.isSpecial()) {
                count++;
            }
        }

        return count;
    }
}
