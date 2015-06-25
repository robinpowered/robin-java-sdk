package com.robinpowered.sdk.model.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.robinpowered.sdk.model.Urn;

import java.lang.reflect.Type;
import java.net.URISyntaxException;

/**
 * Handles adapting {@link Urn} from string representations.
 */
public class UrnAdapter implements JsonDeserializer<Urn>, JsonSerializer<Urn> {

    @Override
    public Urn deserialize(
        JsonElement json,
        Type typeOfT,
        JsonDeserializationContext context
    ) throws JsonParseException {

        if (json.isJsonPrimitive()) {
            String urnString = json.getAsString();

            if (null != urnString && !"".equals(urnString)) {
                if (typeOfT == Urn.class) {
                    try {
                        return Urn.create(urnString);
                    } catch (URISyntaxException e) {
                        throw new JsonParseException(e);
                    }
                }
            }
        }

        return null;
    }

    @Override
    public JsonElement serialize(Urn src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(
            src.toString()
        );
    }
}
