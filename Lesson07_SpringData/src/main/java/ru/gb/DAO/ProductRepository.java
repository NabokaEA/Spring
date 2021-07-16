package ru.gb.DAO;

import ru.gb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product,Long>{
}
