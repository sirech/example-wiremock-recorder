package com.hceris.recorder;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.recording.RecordSpec;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Value;

import static com.github.tomakehurst.wiremock.client.WireMock.recordSpec;

/**
 * This class can be used as the base class for any test that will generate
 * recordings using WireMock.
 *
 *
 * It will automatically proxy the request through it. If [.persistRecordings] is set to true
 * and [.extractBody] is set to 0, it will automatically store the records of the call
 * in the `src/test/resources/mappings` folder
 */
public abstract class RecordingTest {
    @Value("${record.port}")
    int port = 0;

    abstract String recordingServerUrl();

    @Value("${record.persist}")
    private boolean persistRecordings = false;

    @Value("${record.extractBody}")
    private int extractBody = 0;

    private WireMockServer server;

    @Before
    public void startRecording() throws Exception {
        server = new WireMockServer(port);
        server.start();
        server.startRecording(config());
    }

    @After
    public void stopRecording() throws Exception {
        server.stopRecording();
        server.stop();
    }

    private RecordSpec config() {
        return recordSpec()
                .forTarget(recordingServerUrl())
                .makeStubsPersistent(persistRecordings)
                .extractTextBodiesOver(extractBody)
                .captureHeader("Content-Type")
                .build();
    }
}
