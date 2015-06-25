package com.robinpowered.sdk.model.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.DateTimePrinter;
import org.joda.time.format.ISODateTimeFormat;

import java.lang.reflect.Type;

/**
 * Handles adapting {@link DateTime} from string representations.
 */
public class JodaDateTimeAdapter implements JsonDeserializer<DateTime>, JsonSerializer<DateTime> {

    /**
     * Constants
     */

    public static final DateTimeParser DEFAULT_DATETIME_PARSER = ISODateTimeFormat.dateTimeParser().getParser();
    public static final DateTimePrinter DEFAULT_DATETIME_PRINTER = ISODateTimeFormat.dateTimeNoMillis().getPrinter();

    /**
     * Properties
     */

    private final DateTimeFormatter parser;
    private final DateTimeFormatter printer;


    /**
     * Methods
     */

    /**
     * Build a JodaDateTimeAdapter
     *
     * @param parser Must be a DateTimeFormatter that is capable of parsing
     * @param printer Must be a DateTimeFormatter that is capable of printing
     */
    public JodaDateTimeAdapter(DateTimeParser parser, DateTimePrinter printer) {
        if (null == parser || null == printer) {
            throw new IllegalArgumentException("Parser and printer may not be null");
        }

        this.parser = new DateTimeFormatterBuilder().append(parser).toFormatter();
        this.printer = new DateTimeFormatterBuilder().append(printer).toFormatter();
    }

    /**
     * Build a JodaDateTimeAdapter with a default ISODateTimeFormat parser and printer
     */
    public JodaDateTimeAdapter() {
        this(
            DEFAULT_DATETIME_PARSER,
            DEFAULT_DATETIME_PRINTER
        );
    }

    @Override
    public DateTime deserialize(
        JsonElement json,
        Type typeOfT,
        JsonDeserializationContext context
    ) throws JsonParseException {

        if (json.isJsonPrimitive()) {
            String dateTimeString = json.getAsString();

            if (null != dateTimeString && !"".equals(dateTimeString)) {
                if (typeOfT == DateTime.class) {
                    return DateTime.parse(dateTimeString, parser);
                }
            }
        }

        return null;
    }

    @Override
    public JsonElement serialize(DateTime src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(
            src.toString(printer)
        );
    }
}
