package br.com.onmyway.service.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.onmyway.dom.dao.UserDao;
import br.com.onmyway.dom.entity.User;
import br.com.onmyway.dom.repository.UserRepository;

@Path("/user")
public class UserServiceREST {
    
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
	    userDao.saveUser(user);
	    response = Response.status(Status.OK).entity("Usuário Salvo com sucesso").build();
	} catch (Exception e) {
	    response = Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar o usuário: "+ e.getMessage()).build();
	    e.printStackTrace();
	}
	return response;
    }
    
}
