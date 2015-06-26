package com.robinpowered.sdk.model;

import com.robinpowered.sdk.model.exception.UrnSyntaxException;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Urn.class})
public class UrnTest {

    @Test
    public void testContructor() throws Exception {
        String uriString = "urn:12345:abcdef";
        URI uri = URI.create(uriString);

        new Urn(uri);
    }

    @Test(expected = UrnSyntaxException.class)
    public void testContructorFails() throws Exception {
        String uriString = "brian:12345:abcdef";
        URI uri = URI.create(uriString);

        new Urn(uri);
    }

    @Test
    public void testCreate1() throws Exception {
        mockStatic(Urn.class, Mockito.CALLS_REAL_METHODS);
        String nid = "nid";
        String nss = "nss";

        doReturn(new Urn(URI.create("urn" + ":" + nid + ":" + nss))).when(Urn.class, "create", anyString());

        Urn.create(nid, nss);

        // Verify that the static method create(String) was called once.
        verifyStatic(times(1));
        Urn.create("urn" + ":" + nid + ":" + nss);
    }

    @Test
    public void testCreate2() throws Exception {
        mockStatic(Urn.class, Mockito.CALLS_REAL_METHODS);
        Identifier.Interface identifierType = Identifier.Interface.BLE;
        String nss = "abc";

        doReturn(new Urn(URI.create("urn" + ":" + identifierType.getValue() + ":" + nss)))
                .when(Urn.class, "create", anyString());

        Urn.create(identifierType, nss);

        // Verify that the static method create(String) was called once.
        verifyStatic(times(1));
        Urn.create("urn" + ":" + identifierType.getValue() + ":" + nss);
    }

    @Test
    public void testCreate3() throws Exception {
        mockStatic(Urn.class, Mockito.CALLS_REAL_METHODS);
        String part1 = "a";
        String part2 = "b";
        String part3 = "c";
        String expectedUri = "urn:" + part1 + ":" + part2 + ":" + part3;

        doReturn(new Urn(URI.create(expectedUri)))
                .when(Urn.class, "create", anyString());

        Urn.create(part1, part2, part3);

        // Verify that the static method create(String) was called once.
        verifyStatic(times(1));
        Urn.create(expectedUri);
    }

    @Test
    public void testCreate4() throws Exception {
        String uri = "urn:abc:123";

        Urn urn1 = Urn.create(uri);
        Urn urn2 = new Urn(new URI(uri));

        assertThat(urn1).isEqualTo(urn2);
    }

    @Test
    public void testGetParts() throws Exception {
        String part1 = "a";
        String part2 = "b";
        String part3 = "c";
        String uri = "urn:" + part1 + ":" + part2 + ":" + part3;
        Urn urn = new Urn(URI.create(uri));

        String[] parts = urn.getParts();

        assertThat(parts).containsExactly(part1, part2, part3);
    }

    @Test
    public void testGetNid() throws Exception {
        String nid = "nid";
        String nss = "nss";
        String uri = "urn:" + nid + ":" + nss;
        Urn urn = new Urn(URI.create(uri));

        assertThat(urn.getNid()).isEqualTo(nid);
    }

    @Test
    public void testGetNss() throws Exception {
        String nid = "nid";
        String nss = "nss";
        String uri = "urn:" + nid + ":" + nss;
        Urn urn = new Urn(URI.create(uri));

        assertThat(urn.getNss()).isEqualTo(nss);

        Urn urnNoNss = new Urn(URI.create("urn:nid"));

        assertThat(urnNoNss.getNss()).isNull();
    }

    @Test
    public void testEqualsAndHashcode() {
        EqualsVerifier.forClass(Urn.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void testToString() throws Exception {
        String uriString = "urn:12345:abcdef";
        URI uri = URI.create(uriString);

        Urn urn = new Urn(uri);
        assertThat(urn.toString()).isEqualTo(uriString);
    }
}
