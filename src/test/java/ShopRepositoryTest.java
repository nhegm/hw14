import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldThrowExceptionWhenIDNotFound() {

        ShopRepository shopRepository = new ShopRepository();
        Product notebook = new Product(523, "Lenovo g543", 45_000);
        Product TV = new Product(411, "SAMSUNG 92819", 60_000);
        Product smartphone = new Product(129, "iPhone 15 Pro Super Mega MAX ", 130_000);
        Product headphones = new Product(51, "Edifier i39", 4_000);
        shopRepository.add(notebook);
        shopRepository.add(TV);
        shopRepository.add(smartphone);
        shopRepository.add(headphones);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.removeByID(-100);
        });
    }

    @Test
    public void shouldRemoveByID() {

        ShopRepository shopRepository = new ShopRepository();
        Product notebook = new Product(523, "Lenovo g543", 45_000);
        Product TV = new Product(411, "SAMSUNG 92819", 60_000);
        Product smartphone = new Product(129, "iPhone 15 Pro Super Mega MAX ", 130_000);
        Product headphones = new Product(51, "Edifier i39", 4_000);
        shopRepository.add(notebook);
        shopRepository.add(TV);
        shopRepository.add(smartphone);
        shopRepository.add(headphones);

        shopRepository.removeByID(129);
        Product[] expected = {notebook, TV, headphones};
        Assertions.assertArrayEquals(expected, shopRepository.findAll());

    }

    @Test
    public void shouldAddProduct() {

        ShopRepository shopRepository = new ShopRepository();
        Product notebook = new Product(523, "Lenovo g543", 45_000);
        Product TV = new Product(411, "SAMSUNG 92819", 60_000);
        Product smartphone = new Product(129, "iPhone 15 Pro Super Mega MAX ", 130_000);
        Product headphones = new Product(523, "Edifier i39", 4_000);
        shopRepository.add(notebook);
        shopRepository.add(TV);
        shopRepository.add(smartphone);

        Product[] expected = {notebook, TV, smartphone};
        Assertions.assertArrayEquals(expected, shopRepository.findAll());

    }

    @Test
    public void shouldNotAddProduct() {

        ShopRepository shopRepository = new ShopRepository();
        Product notebook = new Product(523, "Lenovo g543", 45_000);
        Product TV = new Product(411, "SAMSUNG 92819", 60_000);
        Product smartphone = new Product(129, "iPhone 15 Pro Super Mega MAX ", 130_000);
        Product headphones = new Product(523, "Edifier i39", 4_000);
        shopRepository.add(notebook);
        shopRepository.add(TV);
        shopRepository.add(smartphone);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shopRepository.add(headphones);
        });
    }
}
