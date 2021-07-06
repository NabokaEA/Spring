package HomeWork02;

import HomeWork02.Persist.Product;
import HomeWork02.Persist.ProductRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BootsTrapListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext sc= sce.getServletContext();

        ProductRepository productRepository=new ProductRepository();
        productRepository.save(new Product(0L, "Полотенце", 100));
        productRepository.save(new Product(1L, "Мыло", 50));
        productRepository.save(new Product(2L, "Шампунь", 130));
        productRepository.save(new Product(3L, "Мочалка", 33));
        productRepository.save(new Product(4L, "Пенка для бритья", 120));
        productRepository.save(new Product(5L, "Палка для битья", 145));
        productRepository.save(new Product(6L, "Пробковый шлем", 100));
        productRepository.save(new Product(7L, "Памперсы", 500));
        productRepository.save(new Product(8L, "Прокладки", 100));
        productRepository.save(new Product(9L, "Санаторон-курортная путевка в курорт Старая Русса", 10000));

        sc.setAttribute("ProductRepository", productRepository);
    }
}
