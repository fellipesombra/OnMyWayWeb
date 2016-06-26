package br.com.onmyway.webservice;

import java.util.Calendar;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.onmyway.valueobject.LatLng;
import br.com.onmyway.valueobject.MapInfo;

import com.google.common.collect.Lists;

@Path("/map")
public class MapServiceREST {
    
    @GET
    @Path("/trip/{oid}")
    @Produces(MediaType.APPLICATION_JSON)
    public MapInfo getPathInfomration(@PathParam("oid") String tripOid){
        
	//TODO: acessar o banco e recuperar as informações da viagem da pessoa
	// botando infos na mão pra testar por enquanto
	LatLng l1 = new LatLng(-22.915413,-43.221121);
	LatLng l2 = new LatLng(-22.914345,-43.206959);
	LatLng l3 = new LatLng(-22.941696,-43.182325);
	LatLng l4 = new LatLng(-22.966693,-43.186529);
	List<LatLng> list = Lists.newArrayList(l1,l2,l3,l4);
	
	String d1 = Calendar.getInstance().getTime().toString();
	List<String> dates = Lists.newArrayList(d1,d1,d1,d1);
	
	MapInfo mapInfo = new MapInfo(list,dates);
	return mapInfo;
	
    }
}