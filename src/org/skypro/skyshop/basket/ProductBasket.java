package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {

    private final LinkedList<Product> products = new LinkedList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getTotalPrice() {
        int total = 0;

        for (Product product : products) {
            total += product.getPrice();
        }

        return total;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + getSpecialProductCount());
    }

    public boolean containsProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return true;
            }
        }

        return false;
    }

    public void clearBasket() {
        products.clear();
    }

    public int getSpecialProductCount() {
        int count = 0;

        for (Product product : products) {
            if (product.isSpecial()) {
                count++;
            }
        }

        return count;
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = new LinkedList<>();

        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();

            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }

        return removedProducts;
    }
}