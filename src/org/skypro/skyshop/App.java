package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {

    public static void main(String[] args) {

        Product milk = new Product("Молоко", 100);
        Product bread = new Product("Хлеб", 80);
        Product cheese = new Product("Сыр", 300);
        Product tea = new Product("Чай", 200);
        Product coffee = new Product("Кофе", 400);
        Product butter = new Product("Масло", 150);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(milk);
        basket.addProduct(bread);
        basket.addProduct(cheese);
        basket.addProduct(tea);
        basket.addProduct(coffee);

        basket.addProduct(butter);

        basket.printBasket();

        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice());

        System.out.println("Есть ли Хлеб: " +
                basket.containsProduct("Хлеб"));

        System.out.println("Есть ли Вода: " +
                basket.containsProduct("Вода"));

        basket.clearBasket();

        basket.printBasket();

        System.out.println("Стоимость пустой корзины: " +
                basket.getTotalPrice());

        System.out.println("Есть ли Хлеб в пустой корзине: " +
                basket.containsProduct("Хлеб"));
    }
}