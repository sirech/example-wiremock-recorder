package com.hceris.recorder;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.After;
import org.junit.Before;

public abstract class RecordedTest {
    WireMockServer server;

    @Before
    public void setUp() throws Exception {
        server = new WireMockServer(8081);
        server.start();
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }
}
