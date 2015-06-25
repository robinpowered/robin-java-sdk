package com.robinpowered.sdk.model.adapter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles adapting common types in the Robin API.
 */
public class RobinTypeAdapterFactory implements TypeAdapterFactory {

    @Override
    @SuppressWarnings("unchecked") // We are doing some generic magic here
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        // Get our default adapter for this type
        final TypeAdapter<T> defaultAdapter = gson.getDelegateAdapter(this, type);

        // Handle LIST weirdness
        if (List.class.isAssignableFrom(type.getRawType())) {
            return (TypeAdapter<T>) new ListAdapter((TypeAdapter<List>) defaultAdapter);
        }

        return null;
    }

    /**
     * A custom ListAdapter for handling possibly incorrect responses.
     *
     * <p>
     * If we tell GSON that we expect our data to be returned as a List, but
     * a serialization error happens on the API side causing the data to come
     * back as an empty object/map, then GSON will throw a JsonSyntaxException
     *
     * <p>
     * This is unfortunately possible due to the way that PHP may be encoding
     * empty arrays in the API. This should be fixed in the API, definitely, but
     * it doesn't hurt to be more resilient on the client side either.
     */
    private class ListAdapter extends TypeAdapter<List> {
        private TypeAdapter<List> defaultAdapter;

        public ListAdapter(TypeAdapter<List> defaultAdapter) {
            this.defaultAdapter = defaultAdapter;
        }

        @Override
        public void write(JsonWriter out, List value) throws IOException {
            defaultAdapter.write(out, value);
        }

        @Override
        public List read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;

            } else if (in.peek() == JsonToken.BEGIN_OBJECT) {
                in.beginObject();
                in.endObject();

                return new ArrayList();
            }

            return defaultAdapter.read(in);
        }
    }
}
