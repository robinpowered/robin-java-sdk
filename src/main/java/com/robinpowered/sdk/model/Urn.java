package com.robinpowered.sdk.model;

import com.google.common.base.Objects;
import com.robinpowered.sdk.model.exception.UrnSyntaxException;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * A Urn, used commonly by {@link BasicIdentifier} and {@link Device} models.
 */
public class Urn {

    /**
     * Properties
     */

    private final URI uri;


    /**
     * Methods
     */

    /**
     * Constructs a new instance from a {@link URI}. The URI must have the sceme "urn".
     *
     * @param uri The URI.
     * @throws UrnSyntaxException Thrown when the URI has an invalid scheme.
     */
    public Urn(URI uri) throws UrnSyntaxException {

        if (!uri.getScheme().equalsIgnoreCase("urn")) {
            throw new UrnSyntaxException(uri.toString(), "Not a valid URN. Scheme must be \"urn\"");
        }

        this.uri = uri;
    }

    /**
     * Creates a {@link Urn} from an NID and an NSS.
     *
     * @param nid The namespace identifier.
     * @param nss The namespace specific string.
     * @throws URISyntaxException
     */
    public static Urn create(String nid, String nss) throws URISyntaxException {
        return create("urn" + ":" + nid + ":" + nss);
    }

    /**
     * Creates a {@link Urn} from an {@link BasicIdentifier.Interface} and
     * an NSS.
     *
     * @param identifierInterface The identifier interface to use as an NID.
     * @param nss The namespace specific string.
     * @return A new Urn instance.
     * @throws URISyntaxException
     */
    public static Urn create(BasicIdentifier.Interface identifierInterface, String nss)
            throws URISyntaxException {

        return create("urn" + ":" + identifierInterface.getValue() + ":" + nss);
    }

    /**
     * Creates a {@link Urn} from segments of a URI.
     *
     * The underlying {@link URI} will have the pattern: "urn:segment1:segment2:etc".
     *
     * @param parts The segments.
     * @return The
     * @throws URISyntaxException
     */
    public static Urn create(String... parts) throws URISyntaxException {
        String uriString = "urn";

        for (String part : parts) {
            uriString += ":" + part;
        }

        return create(uriString);
    }

    /**
     * Creates a {@link Urn} from a URI string.
     *
     * @param uri A valid URI.
     * @return A new Urn instance.
     * @throws URISyntaxException
     */
    public static Urn create(String uri) throws URISyntaxException {
        return new Urn(new URI(uri));
    }

    /**
     * Returns the {@link Urn} segments as an array.
     *
     * @return The parts.
     */
    public String[] getParts() {
        return uri.getSchemeSpecificPart().split(":");
    }

    /**
     * Returns the namespace identifier.
     *
     * @return The namespace identifier.
     */
    public String getNid() {
        String[] parts = getParts();

        if (parts.length >= 1 && null != parts[0]) {
            return getParts()[0];
        }

        return null;
    }


    /**
     * Returns the namespace specific string.
     *
     * @return The namespace specific string.
     */
    public String getNss() {
        String[] parts = getParts();

        if (parts.length >= 2 && null != parts[1]) {
            return getParts()[1];
        }

        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Urn urn = (Urn) o;
        return Objects.equal(uri, urn.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uri);
    }

    @Override
    public String toString() {
        return uri.toString();
    }
}
