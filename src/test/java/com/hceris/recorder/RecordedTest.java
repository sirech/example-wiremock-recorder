package com.hceris.recorder;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Value;

/**
 * Base class for tests that use recordings.
 *
 * The server is started manually instead of using a {@code Rule}
 * to be able to inject the port from the config
 */
public abstract class RecordedTest {
    @Value("${record.port}")
    int port;

    WireMockServer server;

    @Before
    public void useMocks() throws Exception {
        server = new WireMockServer(port);
        server.start();
    }

    @After
    public void stopUsingMocks() throws Exception {
        server.stop();
    }
}
