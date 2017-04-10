package com.kronologia.resources;

import com.kronologia.JsonConverter;
import com.kronologia.characters.MyCharacter;
import com.kronologia.controller.CharacterController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by maxence on 09/04/17.
 */
@Path("characters")
public class CharactersResource {

    private CharacterController controller = new CharacterController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        List<MyCharacter> characters = controller.getCharacters();

        return JsonConverter.generateCharactersJson(characters);
    }

}
