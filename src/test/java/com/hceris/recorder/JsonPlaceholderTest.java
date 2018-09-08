package com.hceris.recorder;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonPlaceholderTest {
    @Autowired
    JsonPlaceholder subject;

    WireMockServer server;

    @Before
    public void setUp() throws Exception {
        server = new WireMockServer();
        server.start();
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void todos() {
        assertThat(subject.todos()).isNotNull();
    }

    @Test
    public void todo() {
        JsonNode todo = subject.todo(1);
        assertThat(todo).isNotNull();
    }
}