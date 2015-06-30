package com.robinpowered.sdk.model.adapter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.robinpowered.sdk.model.Account;

import java.lang.reflect.Type;

/**
 * Handles adapting {@link com.robinpowered.sdk.model.Account.Reference} from string representations.
 */
public class AccountReferenceAdapter implements JsonSerializer<Account.Reference> {

    @Override
    public JsonElement serialize(Account.Reference src, Type typeOfSrc, JsonSerializationContext context) {
        if (src.getId() != null) {
            return new JsonPrimitive(src.getId());
        } else if (src.getSlug() != null) {
            return new JsonPrimitive(src.getSlug());
        } else {
            throw new RuntimeException("Both the slug and id are null");
        }
    }
}
