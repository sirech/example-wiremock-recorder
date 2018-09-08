package com.hceris.recorder;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.recording.SnapshotRecordResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@Category(IntegrationTest.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonPlaceholderIntegrationTest {
    @Value("${recordingServerUrl}")
    String recordingServerUrl;

    @Autowired
    JsonPlaceholder subject;

    WireMockServer server;

    @Before
    public void setUp() throws Exception {
        server = new WireMockServer();
        server.start();
        server.startRecording(recordingServerUrl);
    }

    @After
    public void tearDown() throws Exception {
        SnapshotRecordResult result = server.stopRecording();
        server.stop();
    }

    @Test
    public void todos() {
       assertThat(subject.todos()).isNotNull();
    }

    @Test
    public void todo() {
        assertThat(subject.todo(1)).isNotNull();
    }
}