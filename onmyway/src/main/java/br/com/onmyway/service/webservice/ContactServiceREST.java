package br.com.onmyway.service.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.onmyway.dom.dao.ContactDao;
import br.com.onmyway.dom.dao.UserDao;
import br.com.onmyway.dom.entity.Contact;
import br.com.onmyway.dom.entity.User;
import br.com.onmyway.dom.repository.ContactRepository;
import br.com.onmyway.dom.repository.UserRepository;
import br.com.onmyway.valueobject.ContatoDTO;

import com.google.common.collect.Lists;

@Path("/contact")
public class ContactServiceREST {

    private ContactRepository contactDao = new ContactDao();

    private UserRepository userDao = new UserDao();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(	List<ContatoDTO> contatosDTO) {

	Response response = null;
	try {
	    if (contatosDTO == null || contatosDTO.isEmpty()) {
		response = Response.status(Status.INTERNAL_SERVER_ERROR)
			.entity("Lista de contatos vazia").build();
	    } else {
		User user = userDao.findById(Integer.valueOf(contatosDTO.get(0)
			.getUserId()));
		List<Contact> contatos = Lists.newArrayList();
		for (ContatoDTO contatoDTO : contatosDTO) {
		    Contact contact = new Contact();
		    contact.setCellphoneNumber(contatoDTO.getCellphone());
		    contact.setEmail(contatoDTO.getEmail());
		    contact.setUser(user);
		    contatos.add(contact);
		}
		contactDao.saveContacts(contatos);
		response = Response.status(Status.OK)
			.entity("Contatos salvos com sucesso").build();
	    }
	} catch (Exception e) {
	    response = Response.status(Status.INTERNAL_SERVER_ERROR)
		    .entity("Erro ao inserir contatos: " + e.getMessage())
		    .build();
	    e.printStackTrace();
	}
	return response;
    }

}