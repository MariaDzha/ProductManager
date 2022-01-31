package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductManagerTest {

    ProductRepository productRepository = new ProductRepository();
    ProductManager productManager = new ProductManager(productRepository);

    Book book1 = new Book(1, "Harry Potter and Half-Blood Prince", 500, "Joanne Rowling");
    Book book2 = new Book(2, "Harry Potter and the Deathly Hallows", 600, "Joanne Rowling");
    Book book3 = new Book(3, "Harry Potter and Order of the Phoenix", 500, "Joanne Rowling");
    Book book4 = new Book(4, "Manual for Xiaomi phone", 500, "Harry Smith");

    Smartphone smartphone1 = new Smartphone(5, "Redmi 9A", 10_000, "Xiaomi");
    Smartphone smartphone2 = new Smartphone(6, "Redmi 8 Pro", 12_000, "Xiaomi");
    Smartphone smartphone3 = new Smartphone(7, "Iphone 11", 12_000, "Apple");

    @BeforeEach
    public void addProduct() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(book4);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);
    }
    @Test
    public void shouldSearchByExistingManufacturer() {
        Product[] results = productManager.searchBy("Xiaomi");

        Product[] expected = new Product[] {book4, smartphone1, smartphone2};
       assertArrayEquals(expected, results);
    }

    @Test
    public void shouldSearchByExistingName() {
        Product[] results = productManager.searchBy("Harry");

        Product[] expected = new Product[] {book1, book2, book3, book4};

        assertArrayEquals(expected, results);
    }

    @Test
    public void shouldSearchByNoExistingManufacturer() {
        Product[] results = productManager.searchBy("Nokia");

        Product[] expected = new Product[0];

        assertArrayEquals(expected, results);
    }
}
