package br.com.onmyway.service.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.onmyway.dom.dao.UserDao;
import br.com.onmyway.dom.entity.User;
import br.com.onmyway.dom.repository.UserRepository;

@Path("/user")
public class UserServiceREST {
    
    private static final Object EMPTY_STR = "";
    private UserRepository userDao = new UserDao();
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response register(@FormParam("email") String email, @FormParam("password") String password){
        
	Response response = null;
	try {
	    User user = new User();
	    user.setEmail(email);
	    user.setPassword(password);
	    User saveUser = userDao.saveUser(user);
	    response = Response.status(Status.OK).entity(saveUser).build();
	} catch (Exception e) {
	    response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(EMPTY_STR).build();
	    e.printStackTrace();
	}
	return response;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@QueryParam("email") String email, @QueryParam("password") String password){
        
	Response response = null;
	try {
	    User user = userDao.findUserByEmailAndPassword(email, password);
	    if(user == null){
		response = Response.status(Status.OK).entity(EMPTY_STR).build();
	    }else{
		response = Response.status(Status.OK).entity(user).build();
	    }
	} catch (Exception e) {
	    response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(EMPTY_STR).build();
	    e.printStackTrace();
	}
	return response;
    }
    
}
