package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repository = new ShopRepository();
    Product product1 = new Product(1, "Pen", 10);
    Product product2 = new Product(2, "Magazine", 30);
    Product product3 = new Product(3, "Phone", 200);
    Product product4 = new Product(4, "Laptop", 3232);
    Product product5 = new Product(5, "Hat", 98);

    @Test
    public void test1() {
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.add(product5);
        repository.removeById(3);
        Product[] expected = {product1, product2, product4, product5};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.add(product5);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(6);
        });
    }

    @Test
    public void test3() {
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.add(product5);
        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test4() {
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.add(product5);
        Assertions.assertThrows(AlreadyExistException.class, () -> {
            repository.add(product3);
        });
    }

}
