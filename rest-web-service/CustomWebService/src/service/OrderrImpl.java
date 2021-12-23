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

import model.entities.Orderr;

import model.facade.CustomSessionEJBLocal;

@Stateless
@Path("orderr")
@Produces(MediaType.APPLICATION_JSON)
public class OrderrImpl {

    @EJB(beanName = "CustomSessionEJB")
    CustomSessionEJBLocal mySessionBean;

    private static final Logger logger = Logger.getLogger(OrderrImpl.class.getName());

    @GET
    @Path("/list")
    public List<Orderr> getOrderrsFindAll() {
        return mySessionBean.getOrderrsFindAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    public Orderr insertOrderr(Orderr orderr) {
        return mySessionBean.persistOrderr(orderr);
    }

    @DELETE
    @Path("/deleteAll")
    @Produces(MediaType.TEXT_PLAIN)
    public Boolean deleteAllOrderrs() {
        return mySessionBean.deleteAllOrderrs();
    }

}
