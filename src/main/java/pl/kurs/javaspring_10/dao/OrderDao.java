package pl.kurs.javaspring_10.dao;

import org.springframework.stereotype.Repository;
import pl.kurs.javaspring_10.model.Order;
import pl.kurs.javaspring_10.model.Product;

import javax.transaction.Transactional;

@Repository
@Transactional
public class OrderDao extends GenericDao<Order, Long>{

//    OrderDao() {
//        super(Order.class);
//    }

    public void addProductsToOrder(Long idOrder, Product... products){
        Order order = get(idOrder);
        if(order != null){
            for(Product product : products){
                order.getProducts().add(product);
            }
        }
    }
}
