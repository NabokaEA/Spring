package HomeWork01.Persist;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ProductRepository {
    private Map<Long,Product> productMap=new ConcurrentHashMap<>();
    private AtomicLong identity=new AtomicLong();

    public ArrayList<Product> findAll(){
        return new ArrayList<Product> (productMap.values());
    }

    public void save (Product product){
        if (product.getId()==null){
            Long id=identity.incrementAndGet();
            product.setId(id);
        }
        productMap.put(product.getId(), product);
    }
    public void delete (long id){
        productMap.remove(id);
    }



}
