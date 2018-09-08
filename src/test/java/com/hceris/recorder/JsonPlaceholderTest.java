package com.hceris.recorder;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonPlaceholderTest extends RecordedTest {
    @Autowired
    JsonPlaceholder subject;

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