package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.entities.Customer;
import model.entities.Orderr;

import model.facade.CustomSessionEJBLocal;

@Stateless
@Path("customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerImpl {

    @EJB(beanName = "CustomSessionEJB")
    CustomSessionEJBLocal mySessionBean;

    @GET
    @Path("/list")
    public List<Customer> getCustomersFindAll() {
        return mySessionBean.getCustomersFindAll();
    }

    @GET 
    public Customer findCustomerByTax(@QueryParam("taxIdentificationNumber") String taxIdentificationNumber) {
        return mySessionBean.findCustomerByTax(taxIdentificationNumber);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)  
    public Customer insertCustomer(Customer customer) {
        return mySessionBean.persistCustomer(customer);
    }

}
