package com.robinpowered.sdk;

import com.robinpowered.sdk.credential.AccessTokenCredential;
import com.robinpowered.sdk.credential.Credential;
import com.robinpowered.sdk.service.MockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import retrofit.client.OkClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RobinApiTest
{
    private final String testToken = "abcd";

    @Mock private RobinServiceFactory robinServiceFactory;
    @Mock private OkClient client;

    @Test
    public void testConstructors()
    {
        // Create mock
        Credential credential = new AccessTokenCredential(testToken);

        RobinApi robinApi = new RobinApi();
        assertThat(robinApi.credential).isNull();
        assertThat(robinApi.httpClient).isNull();

        robinApi = new RobinApi(client);
        assertThat(robinApi.credential).isNull();
        assertThat(robinApi.httpClient).isEqualTo(client);

        robinApi = new RobinApi(credential);
        assertThat(robinApi.credential).isEqualTo(credential);
        assertThat(robinApi.httpClient).isNull();

        robinApi = new RobinApi(credential, client);
        assertThat(robinApi.credential).isEqualTo(credential);
        assertThat(robinApi.httpClient).isEqualTo(client);
    }

    @Test
    public void testGetService()
    {
        // Create mocks
        MockService serviceMock = mock(MockService.class);
        Credential credential = new AccessTokenCredential(testToken);

        // Spy on the factory's create method.
        when(robinServiceFactory.create(MockService.class, credential, client))
                .thenReturn(serviceMock);

        RobinApi robinApi = new RobinApi();
        robinApi.credential = credential;
        robinApi.httpClient = client;
        robinApi.serviceFactory = robinServiceFactory;

        assertThat(robinApi.serviceMap).isEmpty();

        MockService service = robinApi.getService(MockService.class);

        assertThat(service).isEqualTo(serviceMock);
        assertThat(robinApi.serviceMap).containsKey(MockService.class);

        // Get the same service, but this time it should come from the map.
        service = robinApi.getService(MockService.class);

        assertThat(service).isEqualTo(serviceMock);

        // Verify we only called the factory method once, even though we got the service twice.
        verify(robinServiceFactory, times(1)).create(MockService.class, credential, client);
    }

    @Test
    public void testSetCredential()
    {
        // Create mocks
        MockService serviceMock = mock(MockService.class);
        Credential credential = new AccessTokenCredential(testToken);

        RobinApi robinApi = new RobinApi();

        // Add an entry to the map so we can test if it gets emptied.
        robinApi.serviceMap.put(MockService.class, serviceMock);

        robinApi.setCredential(credential);

        assertThat(robinApi.credential).isEqualTo(credential);
        assertThat(robinApi.serviceMap).isEmpty();
    }

    @Test
    public void testGetCredential()
    {
        // Create mock
        Credential credentialMock = mock(Credential.class);

        RobinApi robinApi = new RobinApi(credentialMock);

        Credential credential = robinApi.getCredential();

        assertThat(credential).isEqualTo(credentialMock);
    }
}
