import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    // ProductRepository repo;

    Product item1 = new Book(1, "Книга1", 100, "Автор1");
    Product item2 = new Book(2, "Книга2", 200, "Автор2");
    Product item3 = new Smartphone(3, "Смартфон1", 1_000, "Производитель1");
    Product item4 = new Book(4, "Книга4", 400, "Автор4");


    @Test
    public void removeByIdTest() {

        ProductRepository repo = new ProductRepository();

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.removeById(item2.getId());

        Product[] expected = {item1, item3, item4};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);

    }

}
