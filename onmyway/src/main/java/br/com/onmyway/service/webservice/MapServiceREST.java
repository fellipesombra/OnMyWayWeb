package br.com.onmyway.service.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.onmyway.dom.dao.PositionDao;
import br.com.onmyway.dom.entity.Position;
import br.com.onmyway.dom.repository.PositionRepository;
import br.com.onmyway.valueobject.LatLng;
import br.com.onmyway.valueobject.MapInfo;

import com.google.common.collect.Lists;

@Path("/map")
public class MapServiceREST {

    private PositionRepository positionRepository = new PositionDao();

    @GET
    @Path("/trip/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPathInfomration(@PathParam("id") String id) {

	Response response = null;
	try {
	    List<Position> positions = positionRepository.findByTripId(Integer.valueOf(id));

	    if(positions == null || positions.isEmpty()){
		response = Response.status(Status.INTERNAL_SERVER_ERROR).entity("Nenhuma viagem encontrada").build();
	    }else{
        	List<LatLng> latLng = Lists.newArrayList();
        	List<String> dates = Lists.newArrayList();
        	for (Position position : positions) {
        	    latLng.add(position.getLatLng());
        	    dates.add(position.getDateTime().toString());
        	}
        	    
        	MapInfo mapInfo = new MapInfo(latLng, dates);
        	response = Response.status(Status.OK).entity(mapInfo).build();
	    }
	} catch (Exception e) {
	    response =  Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao recuperar viagem").build();
	    e.printStackTrace();
	}
	
	return response;
    }
    
}