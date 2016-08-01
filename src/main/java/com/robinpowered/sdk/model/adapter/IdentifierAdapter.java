package com.robinpowered.sdk.model.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.robinpowered.sdk.model.BasicIdentifier;
import com.robinpowered.sdk.model.IbeaconIdentifier;
import com.robinpowered.sdk.model.Identifier;

import java.lang.reflect.Type;

/**
 * Handles adapting {@link Identifier} from JSON representations.
 */
public class IdentifierAdapter implements JsonDeserializer<Identifier>,
        JsonSerializer<Identifier> {

    @Override
    public Identifier deserialize(
            JsonElement json,
            Type typeOfT,
            JsonDeserializationContext context
    ) throws JsonParseException {

        JsonObject object = json.getAsJsonObject();

        if (typeOfT == Identifier.class) {
            // Object is an identifier.
            if ("robin-ibeacon".equals(object.get("interface").getAsString())) {
                // Object is an iBeacon identifier.
                return context.deserialize(object, IbeaconIdentifier.class);
            } else {
                // Use the basic identifier class.
                return context.deserialize(object, BasicIdentifier.class);
            }
        }

        throw new JsonParseException("Malformed json for identifier.");
    }

    @Override
    public JsonElement serialize(Identifier identifier, Type typeOfSrc,
                                 JsonSerializationContext context) {
        return context.serialize(identifier);
    }
}
