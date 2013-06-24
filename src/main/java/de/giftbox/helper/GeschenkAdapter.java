package de.giftbox.helper;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import de.giftbox.domain.Geschenk;
import de.giftbox.domain.Geschenkliste;

public class GeschenkAdapter implements JsonSerializer<Geschenk> {

    @Override
    public JsonElement serialize(Geschenk geschenk, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", geschenk.getBezeichnung());
        jsonObject.addProperty("preis", geschenk.getPreis());
        jsonObject.addProperty("ort", geschenk.getOrt());
        jsonObject.addProperty("link", geschenk.getLink());

        return jsonObject;      
    }

}
