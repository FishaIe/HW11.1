public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product item) {
        repo.save(item);
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[1];
        int copyToIndex = 0;
        for (Product product: repo.getItems()) {
            if (matches(product, text)) {
                result[copyToIndex] = product;
                copyToIndex++;
            }
        }
        return result;
    }



    public boolean matches(Product product, String search) {
            return product.getName().contains(search);
    }

}