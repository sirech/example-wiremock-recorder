package com.hceris.recorder;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.recording.RecordSpec;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Value;

import static com.github.tomakehurst.wiremock.client.WireMock.recordSpec;

public abstract class RecordingTest {
    @Value("${record.port}")
    int port;

    @Value("${record.proxyTo}")
    private String recordingServerUrl;

    @Value("${record.persist}")
    private boolean persistRecordings;

    @Value("${record.extractBody}")
    private int extractBody;

    private WireMockServer server;

    @Before
    public void setUp() throws Exception {
        server = new WireMockServer(port);
        server.start();
        server.startRecording(config());
    }

    @After
    public void tearDown() throws Exception {
        server.stopRecording();
        server.stop();
    }

    private RecordSpec config() {
        return recordSpec()
                .forTarget(recordingServerUrl)
                .makeStubsPersistent(persistRecordings)
                .extractTextBodiesOver(extractBody)
                .build();
    }
}
