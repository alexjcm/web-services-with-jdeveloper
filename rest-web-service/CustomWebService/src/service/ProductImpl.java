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

import model.entities.Product;
import model.facade.CustomSessionEJBLocal;

@Stateless
@Path("product")
@Produces(MediaType.APPLICATION_JSON)
public class ProductImpl {

    @EJB(beanName = "CustomSessionEJB")
    CustomSessionEJBLocal mySessionBean;

    @GET
    @Path("/list")
    public List<Product> getProductsFindAll() {
        return mySessionBean.getProductsFindAll();
    }

    @GET  
    public Product findProductByCode(@QueryParam("productCode") String productCode) {
        return mySessionBean.findProductByCode(productCode);
    }

    @POST  
    @Consumes(MediaType.APPLICATION_JSON) 
    public Product insertProduct(Product product) {
        return mySessionBean.persistProduct(product);
    }
}
