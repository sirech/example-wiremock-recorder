package com.hceris.recorder;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Value;

public abstract class BaseIntegrationTest {
    @Value("${recordingServerUrl}")
    private String recordingServerUrl;

    private WireMockServer server;

    @Before
    public void setUp() throws Exception {
        server = new WireMockServer();
        server.start();
        server.startRecording(recordingServerUrl);
    }

    @After
    public void tearDown() throws Exception {
        server.stopRecording();
        server.stop();
    }
}
