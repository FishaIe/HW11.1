import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    Product item1 = new Book(1, "Книга1", 100, "Автор1");
    Product item2 = new Book(2, "Книга2", 200, "Автор2");
    Product item3 = new Smartphone(3, "Смартфон1", 1_000, "Производитель1");
    Product item4 = new Book(4, "Книга1", 400, "Автор4");

    @Test
    public void managerAddTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);


        Product[] expected = {item1, item2, item3, item4};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void managerSearchByTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        Product[] expected = {item2};
        Product[] actual = manager.searchBy("Книга2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void managerSearchByWith2ItemsTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        Product[] expected = {item1, item4};
        Product[] actual = manager.searchBy("Книга1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void managerSearchByWithNoItemTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Книга21");

        Assertions.assertArrayEquals(expected, actual);
    }
}
