package pl.kurs.javaspring_10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.kurs.javaspring_10.dao.ClientDao;
import pl.kurs.javaspring_10.dao.OrderDao;
import pl.kurs.javaspring_10.dao.ProductDao;
import pl.kurs.javaspring_10.model.Client;
import pl.kurs.javaspring_10.model.Order;
import pl.kurs.javaspring_10.model.Product;

@SpringBootApplication()

public class JavaSpring10Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(JavaSpring10Application.class, args);



        Client client = new Client("Jan", "Kowalski", "Krakowskie przedmieście 23, Warszawa");
        ClientDao clientDao = ctx.getBean(ClientDao.class);
        clientDao.save(client);

        Order order = new Order("Telewizor LG", "dostawa do domu");
        order.setClient(client);
        OrderDao orderDao = ctx.getBean(OrderDao.class);
        orderDao.save(order);

        Product product1 = new Product("Telewizor LG", 4999.00, "42', czarny");
        Product product2 = new Product("Telefon Samsung", 3000.00, "ładowarka i słuchawki w zestawie");

        ProductDao productDao = ctx.getBean(ProductDao.class);
        productDao.save(product1);
        productDao.save(product2);

        orderDao.addProductsToOrder(1L, product1, product2);


        Client getClient = clientDao.get(client.getId());
        System.out.println(getClient);


        ctx.close();
    }

}
