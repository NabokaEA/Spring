package ru.gb.persist;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {

    // Identity Map
    private Map<Long, Product> productMapMap = new ConcurrentHashMap<>();

    private AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init() {
        this.insert(new Product("Молоко"));
        this.insert(new Product("Булка"));
        this.insert(new Product("Хлеб"));
    }

    public List<Product> findAll() {
        return new ArrayList<>(productMapMap.values());
    }

    public Product findById(long id) {
        return productMapMap.get(id);
    }

    public void insert(Product user) {
        long id = identity.incrementAndGet();
        user.setId(id);
        productMapMap.put(id, user);
    }

    public void update(Product product) {
        productMapMap.put(product.getId(), product);
    }

    public void delete(long id) {
        productMapMap.remove(id);
    }

    public void save (Product product){
        if (product.getId() == null) {
            insert(product);
        } else {
            update(product);
        }
    }

}