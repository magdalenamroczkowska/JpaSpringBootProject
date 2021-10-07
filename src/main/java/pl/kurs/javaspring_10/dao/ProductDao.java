package pl.kurs.javaspring_10.dao;

import org.springframework.stereotype.Repository;
import pl.kurs.javaspring_10.model.Product;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ProductDao extends GenericDao<Product, Long>{

}
