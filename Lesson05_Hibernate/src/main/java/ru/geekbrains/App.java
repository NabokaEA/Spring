package ru.geekbrains;


import ru.geekbrains.entity.Product;

import java.util.List;

public class App {
    public static void main(String[] args) {


        ProductDAO productDAO = new ProductDAO();
        Product product = new Product(null, "pen", 100);
        List.of(
                new Product(null, "pensil", 100),
                new Product(null, "pen", 400),
                new Product(null, "plate", 500),
                new Product(null, "hen", 300),
                new Product(null, "hat", 700)
        ).forEach(productDAO.entityManager::persist);
        productDAO.saveOrUpdate(product);
        Product findProduct = productDAO.findById(1L);
        System.out.println(findProduct);

        productDAO.entityManager.close();
    }


}







