package com.kronologia;

import com.google.gson.Gson;
import com.kronologia.characters.MyCharacter;

import java.util.List;

/**
 * Created by maxence on 10/04/17.
 */
public class JsonConverter {

    static Gson gson = new Gson();

    public static String generateCharacterJson(MyCharacter c) {
        return gson.toJson(c);
    }

    public static String generateCharactersJson(List<MyCharacter> cs) {
        return gson.toJson(cs);
    }
}
