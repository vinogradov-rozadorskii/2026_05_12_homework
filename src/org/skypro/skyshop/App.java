package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Article;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;

import java.util.List;

public class App {

    public static void main(String[] args) {

        try {
            new SimpleProduct("", 100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            new SimpleProduct("Хлеб", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            new SimpleProduct("Хлеб", -100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            new DiscountedProduct("Сыр", 300, 150);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            new DiscountedProduct("Сыр", -300, 20);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            new DiscountedProduct("Сыр", 300, -10);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

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

        basket.printBasket();

        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice());

        System.out.println("Есть ли Хлеб: " + basket.containsProduct("Хлеб"));
        System.out.println("Есть ли Вода: " + basket.containsProduct("Вода"));

        System.out.println();
        System.out.println("Удаляем существующий продукт:");

        List<Product> removedProducts = basket.removeProductByName("Хлеб");
        System.out.println(removedProducts);

        basket.printBasket();

        System.out.println();
        System.out.println("Удаляем несуществующий продукт:");

        removedProducts = basket.removeProductByName("Вода");

        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println(removedProducts);
        }

        basket.printBasket();

        basket.clearBasket();

        basket.printBasket();

        System.out.println("Стоимость пустой корзины: " + basket.getTotalPrice());

        System.out.println("Есть ли Хлеб в пустой корзине: " + basket.containsProduct("Хлеб"));

        SearchEngine searchEngine = new SearchEngine(20);

        searchEngine.add(milk);
        searchEngine.add(bread);
        searchEngine.add(cheese);
        searchEngine.add(tea);
        searchEngine.add(coffee);
        searchEngine.add(butter);

        Article article1 = new Article(
                "Молочные продукты",
                "Молоко и сыр богаты кальцием."
        );

        Article article2 = new Article(
                "Кофе",
                "Кофе помогает взбодриться утром."
        );

        Article article3 = new Article(
                "Чай",
                "Зеленый чай полезен для здоровья."
        );

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        System.out.println(searchEngine.search("Мол"));
        System.out.println(searchEngine.search("Кофе"));
        System.out.println(searchEngine.search("чай"));

        try {
            System.out.println(searchEngine.search(""));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(searchEngine.search(null));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(searchEngine.searchBest("Кофе"));
            System.out.println(searchEngine.searchBest("Мол"));
            System.out.println(searchEngine.searchBest("Несуществующий"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}