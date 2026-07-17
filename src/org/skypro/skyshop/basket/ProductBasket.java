package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductBasket {

    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), key -> new ArrayList<>())
                .add(product);
    }

    public int getTotalPrice() {
        int total = 0;

        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }

        return total;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                System.out.println(product);
            }
        }

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + getSpecialProductCount());
    }

    public boolean containsProduct(String productName) {
        return products.containsKey(productName);
    }

    public void clearBasket() {
        products.clear();
    }

    public int getSpecialProductCount() {
        int count = 0;

        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product.isSpecial()) {
                    count++;
                }
            }
        }

        return count;
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = products.remove(name);

        if (removedProducts == null) {
            return new ArrayList<>();
        }

        return removedProducts;
    }
}