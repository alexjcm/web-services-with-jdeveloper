package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.entities.OrderrDetail;

import model.facade.CustomSessionEJBLocal;

@Stateless
@Path("orderrdetail")
@Produces(MediaType.APPLICATION_JSON)
public class OrderrDetailImpl {

    @EJB(beanName = "CustomSessionEJB")
    CustomSessionEJBLocal mySessionBean;

    private static final Logger logger = Logger.getLogger(OrderrDetailImpl.class.getName());

    @GET
    @Path("/list")
    public List<OrderrDetail> getOrderrsDetailsFindAll() {
        return mySessionBean.getOrderrsDetailsFindAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)   
    public OrderrDetail insertOrderrDetail(OrderrDetail orderrDetail) {
        return mySessionBean.persistOrderrDetail(orderrDetail);
    }

    @DELETE
    @Path("/deleteAll")
    @Produces(MediaType.TEXT_PLAIN)
    public Boolean deleteAllOrderrDetails() {
        return mySessionBean.deleteAllOrderrDetails();
    }

}
