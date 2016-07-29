package com.robinpowered.sdk.model.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.robinpowered.sdk.model.IbeaconIdentifier;
import com.robinpowered.sdk.model.Identifiable;
import com.robinpowered.sdk.model.Identifier;

import java.lang.reflect.Type;

/**
 * Handles adapting {@link com.robinpowered.sdk.model.Identifiable} from JSON representations.
 */
public class IdentifiableAdapter implements JsonDeserializer<Identifiable>,
        JsonSerializer<Identifiable> {

    @Override
    public Identifiable deserialize(
            JsonElement json,
            Type typeOfT,
            JsonDeserializationContext context
    ) throws JsonParseException {

        JsonObject object = json.getAsJsonObject();
        boolean isIBeacon = object.has("device_id")
                && object.has("major")
                && object.has("minor")
                && object.has("uuid");
        boolean isIdentifier = object.has("urn")
                && object.has("value")
                && object.has("interface");

        if (isIBeacon) {
            return context.deserialize(object, IbeaconIdentifier.class);
        } else if (isIdentifier) {
            return context.deserialize(object, Identifier.class);
        }

        throw new JsonParseException("Malformed json for identifier.");
    }

    @Override
    public JsonElement serialize(Identifiable identifiable, Type typeOfSrc,
                                 JsonSerializationContext context) {
        return context.serialize(identifiable);
    }
}
