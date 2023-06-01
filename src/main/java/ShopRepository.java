public class ShopRepository {
    private Product[] products = new Product[0];

    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    public void add(Product productToAdd) {
        boolean flag = false;
        for (Product product : products) {
            if (productToAdd.id == product.id) {
                flag = true;
            }
        }
        if (flag == true) {
            throw new AlreadyExistsException(
                    "Товар с данным ID: " + productToAdd.id + "уже существует"
            );
        } else {
            products = addToArray(products, productToAdd);
        }
    }

    public Product[] findAll() {
        return products;
    }

    public void remove(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    public Product findByID(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeByID(int id) {
        Product productToRemove;
        Product[] tmp = new Product[products.length - 1];
        int productNumber = 0;
        if (findByID(id) == null) {
            throw new NotFoundException(
                    "Товара с данным ID: " + id + " не существует"
            );
        } else {
            for (Product product : products) {
                if (product != findByID(id)) {
                    tmp[productNumber] = product;
                    productNumber++;
                }
            }
        }
        products = tmp;
    }
}