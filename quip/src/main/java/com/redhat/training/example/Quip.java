package com.redhat.training.example;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;

import java.net.InetAddress;


@Path("/")
public class Quip {

  @GET
  @Produces("text/plain")
  public Response index(
		    @QueryParam("lang") 
		    @DefaultValue("en") 
		    final String lang
	) throws Exception {
    String host = InetAddress.getLocalHost().getHostName();
    switch(lang) {
      case "lat": return Response.ok("Veni, vidi, vici...\n").build();
      case "pt":  return Response.ok("Vim, vi, venci...\n").build();
      default:    return Response.ok("I came, I saw, I conquered...\n").build();
    }
  }

  @GET
  @Path("/ready")
  @Produces("text/plain")
  public Response ready() throws Exception {
    return Response.ok("OK\n").build();
  }

}

