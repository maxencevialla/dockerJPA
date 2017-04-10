package com.kronologia.resources;

/**
 * Created by maxence on 03/04/17.
 */
import com.kronologia.JsonConverter;
import com.kronologia.controller.CharacterController;
import com.kronologia.controller.Controller;
import com.kronologia.characters.MyCharacter;

import javax.print.DocFlavor;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

@Path("character")
public class CharacterResource extends Controller {

    private CharacterController controller = new CharacterController();
    private final static Logger LOGGER = Logger.getLogger(CharacterResource.class.getSimpleName());

    public CharacterResource() {
        super();
    }

    //Create a new character
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createCharacter(MyCharacter c) {
        controller.addCharacter(c);
        return JsonConverter.generateCharacterJson(c);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("id") int id) {
        MyCharacter c = controller.getCharacter(id);
        return JsonConverter.generateCharacterJson(c);
    }

    @PUT
    @Path("/levelup/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String levelup(@PathParam("id") int id) {
        MyCharacter c = controller.levelup(id);
        return JsonConverter.generateCharacterJson(c);
    }
}
