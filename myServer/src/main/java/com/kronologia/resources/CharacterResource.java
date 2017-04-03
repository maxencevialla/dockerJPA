package com.kronologia.resources;

/**
 * Created by maxence on 03/04/17.
 */
import com.kronologia.classes.Character;
import com.kronologia.classes.Item;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("character")
public class CharacterResource {

    //Get all characters from the database
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAll() {
        return Character.getAllCharacters();
    }

    //Create a new character given his name
    @POST
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String createCharacter(@PathParam("name") String name) {
        Character.createCharacter(name);
        return name;
    }

    //Add a level to the character identified by ID
    @PUT
    @Path("/{id}/levelup")
    @Produces(MediaType.TEXT_PLAIN)
    public String levelup(@PathParam("id") int id) {
        Character c = Character.getCharacterByID(id);
        c.levelUp();

        return c.getLevel()+"";
    }

    //Add a new item to a character identified by id
    @PUT
    @Path("/{id}/{itemName}/{description}/{cost}")
    @Produces(MediaType.TEXT_PLAIN)
    public String addItem(@PathParam("id") int id, @PathParam("itemName") String itemName,
                          @PathParam("description") String description, @PathParam("cost") int cost) {
        Item i = new Item(itemName, description, cost);
        Character c = Character.getCharacterByID(id);
        c.addItem(i);

        return i.getName();
    }
}
