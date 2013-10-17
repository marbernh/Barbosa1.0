/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Daniel
 */
public class UserHandlerResource {

    private final static Logger log = Logger.getAnonymousLogger();
    private final static IUserRegister register = UserRegister.newInstance("quiz_pu");
    @Context
    private UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response add(@FormParam("userName") String userName,
            @FormParam("password") String password) {

        log.log(Level.INFO, "User added, OK", new Object[]{userName});
        UserDB u = new UserDB(userName, password);
        try {
            register.add(u);
            URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(u.getId())).build(u);
            return Response.created(uri).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response update(@PathParam("id") Long id,
            @FormParam("userName") String userName,
            @FormParam("password") String password) {
        log.log(Level.INFO, "PUT id {0}, OK", id);
        try {
            UserDB u = new UserDB(id, userName, password);
            register.update(u);
            return Response.ok(u).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response login(@FormParam("userName") String userName,
            @FormParam("password") String password) {
        UserDB userlogin = register.getByName(userName);
        try {
            if (userlogin == null || !(userlogin.getPassword().equals(password))) {
                return Response.ok("login fail").build();
            } else {
                return Response.ok("login success").build();
            }
        } catch(IllegalArgumentException e)  {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
