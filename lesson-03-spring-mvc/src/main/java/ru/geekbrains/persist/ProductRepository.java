package ru.geekbrains.persist;

import org.springframework.stereotype.Repository;
import ru.geekbrains.model.Product;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {
    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();

    public Map<Long, Product> getProductMap() { return productMap; }

    private final AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init() {
        this.insert(new Product("product1"));
        this.insert(new Product("product2"));
        this.insert(new Product("product3"));
    }

    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    public Product findById(long id) { return productMap.get(id); }

    public void insert(Product product) {
        long id = identity.incrementAndGet();
        product.setId(id);
        productMap.put(id, product);
    }
    public void update(Product product) { productMap.put(product.getId(), product); }

    public void deleteProduct(long id){ productMap.remove(id); }

}
