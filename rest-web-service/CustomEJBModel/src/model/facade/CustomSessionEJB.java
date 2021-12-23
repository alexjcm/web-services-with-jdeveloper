package model.facade;

import java.util.List;

import javax.ejb.Remote;

import model.entities.Customer;
import model.entities.Orderr;
import model.entities.OrderrDetail;
import model.entities.Product;

/**
 * This interface allows a connection to a remote database such as ATP.
 */
@Remote
public interface CustomSessionEJB {
    
    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    List<Customer> getCustomersFindAll();

    public Customer findCustomerByTax(String taxIdentificationNumber);
    
    Customer persistCustomer(Customer customer);

    List<OrderrDetail> getOrderrsDetailsFindAll();

    OrderrDetail persistOrderrDetail(OrderrDetail orderrDetail);

    public Boolean deleteAllOrderrDetails();

    List<Orderr> getOrderrsFindAll();

    Orderr persistOrderr(Orderr orderr);

    public Boolean deleteAllOrderrs();

    List<Product> getProductsFindAll();

    public Product findProductByCode(String productCode);

    Product persistProduct(Product product);
}
