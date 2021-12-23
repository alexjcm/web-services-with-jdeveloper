package model.facade;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.entities.Customer;
import model.entities.Orderr;
import model.entities.OrderrDetail;
import model.entities.Product;

@Stateless(name = "CustomSessionEJB", mappedName = "TestRESTWeb-CustomEJBModel-CustomSessionEJB")
public class CustomSessionEJBBean implements CustomSessionEJBLocal {

    @Resource
    SessionContext sessionContext;

    @PersistenceContext(unitName = "CustomEJBModel")
    private EntityManager em;

    public CustomSessionEJBBean() {
    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    ///////////////////////////

    // SELECT o FROM  Customer o
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Customer> getCustomersFindAll() {
        return em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }

    public Customer findCustomerByTax(String taxIdentificationNumber) {
        return (Customer) em.createQuery("SELECT o FROM Customer o WHERE o.taxIdentificationNumber=:taxIdentificationNumber")
                            .setParameter("taxIdentificationNumber", taxIdentificationNumber)
                            .getSingleResult();
    }
    
    public Customer persistCustomer(Customer customer) {
            em.persist(customer);
            return customer;
        }

    // SELECT o FROM  OrderrDetail o
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<OrderrDetail> getOrderrsDetailsFindAll() {
        return em.createNamedQuery("OrderrDetail.findAll", OrderrDetail.class).getResultList();
    }

    public OrderrDetail persistOrderrDetail(OrderrDetail orderrDetail) {
        em.persist(orderrDetail);
        return orderrDetail;
    }

    public Boolean deleteAllOrderrDetails() {
        try {
            em.createQuery("DELETE FROM OrderrDetail").executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // SELECT o FROM  Orderr o
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Orderr> getOrderrsFindAll() {
        return em.createNamedQuery("Orderr.findAll", Orderr.class).getResultList();
    }

    public Orderr persistOrderr(Orderr orderr) {
        em.persist(orderr);
        return orderr;
    }

    public Boolean deleteAllOrderrs() {
        try {
            em.createQuery("DELETE FROM Orderr").executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    };

    // SELECT o FROM  Product o
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Product> getProductsFindAll() {
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    public Product findProductByCode(String productCode) {
        ;
        return (Product) em.createQuery("SELECT o FROM Product o WHERE o.productCode=:productCode")
                           .setParameter("productCode", productCode)
                           .getSingleResult();
    }

    public Product persistProduct(Product product) {
        em.persist(product);
        return product;
    }

}
