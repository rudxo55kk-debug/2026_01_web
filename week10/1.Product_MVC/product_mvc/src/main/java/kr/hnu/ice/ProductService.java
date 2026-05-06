package kr.hnu.ice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
    private Map<String, Product> products;

    public ProductService() {
        products = new HashMap<>();

        Product p1 = new Product("P001", "Galaxy S24", "Samsung", 1290000, "2025-03-01");
        Product p2 = new Product("P002", "iPhone 16", "Apple", 1490000, "2025-02-15");
        Product p3 = new Product("P003", "Xperia 1 VI", "Sony", 1390000, "2024-11-20");
        Product p4 = new Product("P004", "Pixel 9", "Google", 1190000, "2025-01-10");
        Product p5 = new Product("P005", "Redmi Note 14", "Xiaomi", 399000, "2024-12-05");

        products.put(p1.getId(), p1);
        products.put(p2.getId(), p2);
        products.put(p3.getId(), p3);
        products.put(p4.getId(), p4);
        products.put(p5.getId(), p5);
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public Product find(String id) {
        return products.get(id);
    }
}
