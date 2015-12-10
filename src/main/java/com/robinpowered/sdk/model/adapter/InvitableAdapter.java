package com.robinpowered.sdk.model.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.robinpowered.sdk.model.Invitable;
import com.robinpowered.sdk.model.Invitee;

import java.lang.reflect.Type;

/**
 * Handles adapting {@link Invitable} from JSON representations.
 */
public class InvitableAdapter implements JsonDeserializer<Invitable>, JsonSerializer<Invitable> {

    @Override
    public Invitable deserialize(
            JsonElement json,
            Type typeOfT,
            JsonDeserializationContext context
    ) throws JsonParseException {

        JsonObject object = json.getAsJsonObject();
        boolean isInvitation = object.has("email") && !object.has("id");
        boolean isInvitee = object.has("email")
                && object.has("id")
                && object.has("eventId");

        if (isInvitation) {
            return context.deserialize(object, Invitee.Invitation.class);
        } else if (isInvitee) {
            return context.deserialize(object, Invitee.class);
        }

        throw new JsonParseException("Malformed json for invitees.");
    }

    @Override
    public JsonElement serialize(Invitable invitable, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(invitable);
    }
}
