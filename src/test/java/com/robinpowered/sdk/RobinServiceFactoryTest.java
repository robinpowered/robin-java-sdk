package com.robinpowered.sdk;

import com.robinpowered.sdk.credential.Credential;
import com.robinpowered.sdk.service.MockService;
import com.squareup.okhttp.HttpUrl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.converter.GsonConverter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class RobinServiceFactoryTest {

    @Test
    public void testConstructors() {
        HttpUrl expectedDefaultEndpoint = HttpUrl.parse(RobinServiceFactory.BASE_URL);
        RobinServiceFactory factory = new RobinServiceFactory();
        assertThat(factory.endpoint).isEqualTo(expectedDefaultEndpoint);

        HttpUrl endpoint = HttpUrl.parse("http://example.com");
        factory = new RobinServiceFactory(endpoint);
        assertThat(factory.endpoint).isEqualTo(endpoint);
    }

    @Test
    public void testGetResponseDataConverter() {
        RobinServiceFactory factory = new RobinServiceFactory();
        assertThat(factory.getResponseDataConverter()).isExactlyInstanceOf(GsonConverter.class);
    }

    @Test
    public void testGetRestAdapterBuilder() {
        RobinServiceFactory factory = new RobinServiceFactory();
        assertThat(factory.getRestAdapterBuilder()).isNotNull();
    }

    @Test
    public void testCreate1() {
        RobinServiceFactory factory = mock(RobinServiceFactory.class, Mockito.CALLS_REAL_METHODS);
        MockService service = mock(MockService.class);

        doReturn(service).when(factory).create(MockService.class, null);

        assertThat(factory.create(MockService.class)).isEqualTo(service);
        verify(factory, times(1)).create(MockService.class, null);
        verify(factory, times(0)).create(any(Class.class), any(Credential.class), any(Client.class));
    }

    @Test
    public void testCreate2() {
        RobinServiceFactory factory = mock(RobinServiceFactory.class, Mockito.CALLS_REAL_METHODS);
        MockService service = mock(MockService.class);
        Credential credential = mock(Credential.class);

        doReturn(service).when(factory).create(MockService.class, credential, null);

        assertThat(factory.create(MockService.class, credential)).isEqualTo(service);
        verify(factory, times(1)).create(MockService.class, credential, null);
        verify(factory, times(0)).create(any(Class.class), any(Credential.class), any(Client.class), any(HttpUrl.class));
    }

    @Test
    public void testCreate3() {
        RobinServiceFactory factory = mock(RobinServiceFactory.class, Mockito.CALLS_REAL_METHODS);
        MockService service = mock(MockService.class);
        Credential credential = mock(Credential.class);
        Client client = mock(Client.class);

        doReturn(service).when(factory).create(MockService.class, credential, client, factory.endpoint);

        assertThat(factory.create(MockService.class, credential, client)).isEqualTo(service);
        verify(factory, times(1)).create(MockService.class, credential, client, factory.endpoint);
    }

    @Test
    public void testCreate4() {
        RobinServiceFactory factory = mock(RobinServiceFactory.class, Mockito.CALLS_REAL_METHODS);
        Credential credential = mock(Credential.class);
        Client client = mock(Client.class);
        HttpUrl endpoint = HttpUrl.parse("http://example.com");

        RestAdapter.Builder builder = mock(RestAdapter.Builder.class, Mockito.CALLS_REAL_METHODS);
        doReturn(builder).when(factory).getRestAdapterBuilder();

        MockService service = factory.create(MockService.class, credential, client, endpoint);
        assertThat(service).isNotNull();

        verify(builder, times(1)).setRequestInterceptor(any(RequestInterceptor.class));
        verify(builder, times(1)).setEndpoint(endpoint.toString());
    }
}
