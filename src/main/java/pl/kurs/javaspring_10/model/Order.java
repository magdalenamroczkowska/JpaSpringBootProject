package pl.kurs.javaspring_10.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="clients_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;
    @Column(nullable = false)
    private String product;
    @Column(nullable = false)
    private String orderDetails;

    @ManyToOne
    @JoinColumn(name="id_client")
    private Client client;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="order_products",
    joinColumns = { @JoinColumn(name = "order_id", referencedColumnName = "id_order")},
    inverseJoinColumns = { @JoinColumn(name = "product_id", referencedColumnName = "id_product")})
    private List<Product> products = new ArrayList<>();

    public Order() {
    }

    public Order(String product, String orderDetails) {
        this.product = product;
        this.orderDetails = orderDetails;

    }

    public Long getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public String getOrderDetails() {
        return orderDetails;
    }


    public void setProduct(String product) {
        this.product = product;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", orderDetails='" + orderDetails + '\'' +
                "products = " + products +

                '}';
    }
}
