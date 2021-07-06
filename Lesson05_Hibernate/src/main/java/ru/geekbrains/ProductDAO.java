package ru.geekbrains;

import org.hibernate.cfg.Configuration;
import ru.geekbrains.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ProductDAO {
    EntityManagerFactory eMFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    EntityManager entityManager = eMFactory.createEntityManager();

    public void saveOrUpdate(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    public Product findById(Long id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    public List<Product> findAll() {
        List<Product> resultList = entityManager.createQuery("select u from Product u", Product.class).getResultList();
        return resultList;
    }

    public void deleteById(Long id) {

    }

}