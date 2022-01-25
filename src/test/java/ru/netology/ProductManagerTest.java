package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductManagerTest {
    @Test
    public void ShouldSearchByFirst() {
        ProductRepository productRepository = new ProductRepository();
        ProductManager productManager = new ProductManager(productRepository);

        Book book1 = new Book(1, "Harry Potter and Half-Blood Prince", 500, "Joanne Rowling");
        Book book2 = new Book(2, "Harry Potter and the Deathly Hallows", 600, "Joanne Rowling");
        Book book3 = new Book(3, "Harry Potter and Order of the Phoenix", 500, "Joanne Rowling");
        Book book4 = new Book(4, "Manual for Xiaomi phone", 500, "kim jon");

        Smartphone smartphone1 = new Smartphone(5, "Redmi 9A", 10_000, "Xiaomi");
        Smartphone smartphone2 = new Smartphone(6, "Redmi 8 Pro", 12_000, "Xiaomi");
        Smartphone smartphone3 = new Smartphone(7, "Iphone 11", 12_000, "Apple");

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(book4);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);

        Product[] results = productManager.searchBy("Xiaomi");
        for (Product product : results) {
            System.out.println(product);
        }
        Product[] expected = new Product[3];
        expected[0] = book4;
        expected[1] = smartphone1;
        expected[2] = smartphone2;

        assertArrayEquals(expected, results);
    }

    @Test
    public void ShouldSearchBySecond() {
        ProductRepository productRepository = new ProductRepository();
        ProductManager productManager = new ProductManager(productRepository);

        Book book1 = new Book(1, "Harry Potter and Half-Blood Prince", 500, "Joanne Rowling");
        Book book2 = new Book(2, "Harry Potter and the Deathly Hallows", 600, "Joanne Rowling");
        Book book3 = new Book(3, "Harry Potter and Order of the Phoenix", 500, "Joanne Rowling");
        Book book4 = new Book(4, "Manual for Xiaomi phone", 500, "Harry Smith");

        Smartphone smartphone1 = new Smartphone(5, "Redmi 9A", 10_000, "Xiaomi");
        Smartphone smartphone2 = new Smartphone(6, "Redmi 8 Pro", 12_500, "Xiaomi");
        Smartphone smartphone3 = new Smartphone(7, "Iphone 11", 12_000, "Apple");

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(book4);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);

        Product[] results = productManager.searchBy("Harry");
        for (Product product : results) {
            System.out.println(product);
        }
        Product[] expected = new Product[4];
        expected[0] = book1;
        expected[1] = book2;
        expected[2] = book3;
        expected[3] = book4;

        assertArrayEquals(expected, results);
    }
}
