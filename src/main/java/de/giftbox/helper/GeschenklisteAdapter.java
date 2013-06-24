package de.giftbox.helper;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import de.giftbox.domain.Geschenkliste;

public class GeschenklisteAdapter implements JsonSerializer<Geschenkliste> {

    @Override
    public JsonElement serialize(Geschenkliste geschenkliste, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id_Geschenkliste", geschenkliste.getIdGeschenkliste());
        jsonObject.addProperty("name", geschenkliste.getName());
        return jsonObject;      
    }

}
