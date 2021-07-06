package ru.geekbrains;


import ru.geekbrains.entity.Product;

public class App {
    public static void main(String[] args) {


        ProductDAO productDAO = new ProductDAO();
        Product product = new Product(null, "pen", 100);
        productDAO.saveOrUpdate(product);
        Product findProduct=productDAO.findById(1L);
        System.out.println(findProduct);

        productDAO.entityManager.close();
    }



}







