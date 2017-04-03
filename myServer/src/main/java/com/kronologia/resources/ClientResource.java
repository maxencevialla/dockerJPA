package com.kronologia.resources;

/**
 * Created by mvialla109 on 20/01/17.
 */


import com.kronologia.classes.Client;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("clientResource")
public class ClientResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return Client.getAllClients();
    }

    @POST
    @Path("/{nom}/{age}")
    @Produces(MediaType.TEXT_PLAIN)
    public String postIt(@PathParam("nom") String nom, @PathParam("age") int age) {
        Client c = new Client(nom, age);
        Client.allClients.add(c);
        return c.toString();
    }

    @PUT
    @Path("/{nom}/{age}/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String putIt(@PathParam("id") int id, @PathParam("nom") String nom, @PathParam("age") int age) {
        if(Client.mapClients.containsKey(id)) {

            Client c = Client.getByID(id);

            c.setName(nom);
            c.setAge(age);

            return c.toString();
        }

        return "Client does not exist\n";
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteIt(@PathParam("id") int id) {

        if(Client.mapClients.containsKey(id)) {
            Client.mapClients.remove(id);
            return "Client " + id + " deleted";
        } else

        return "Client " + id + " did not exist";
    }
}
