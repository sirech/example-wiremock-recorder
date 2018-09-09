package com.hceris.recorder;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.recording.RecordSpec;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Value;

import static com.github.tomakehurst.wiremock.client.WireMock.recordSpec;

public abstract class RecordingTest {
    @Value("${recordingServerUrl}")
    private String recordingServerUrl;

    @Value("${persistRecordings}")
    private boolean persistRecordings;

    @Value("${extractBody}")
    private int extractBody;

    private WireMockServer server;

    @Before
    public void setUp() throws Exception {
        server = new WireMockServer(8081);
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
                // _files are always saved to disk, so we need to put
                // everything on the main request for makeStubsPersistent
                // to work properly
                .extractTextBodiesOver(extractBody)
                .build();
    }
}
