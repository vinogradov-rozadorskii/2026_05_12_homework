package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {

    public static void main(String[] args) {
        Product milk = new SimpleProduct("Молоко", 100);
        Product bread = new SimpleProduct("Хлеб", 80);
        Product cheese = new DiscountedProduct("Сыр", 300, 20);
        Product tea = new FixPriceProduct("Чай");
        Product coffee = new DiscountedProduct("Кофе", 500, 10);
        Product butter = new SimpleProduct("Масло", 200);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(milk);
        basket.addProduct(bread);
        basket.addProduct(cheese);
        basket.addProduct(tea);
        basket.addProduct(coffee);

        basket.addProduct(butter);

        basket.printBasket();

        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice());

        System.out.println("Есть ли Хлеб: " + basket.containsProduct("Хлеб"));

        System.out.println("Есть ли Вода: " + basket.containsProduct("Вода"));

        basket.clearBasket();

        basket.printBasket();

        System.out.println("Стоимость пустой корзины: " + basket.getTotalPrice());

        System.out.println("Есть ли Хлеб в пустой корзине: " + basket.containsProduct("Хлеб"));
    }
}