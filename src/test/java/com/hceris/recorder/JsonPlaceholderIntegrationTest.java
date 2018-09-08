package com.hceris.recorder;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@Category(IntegrationTest.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonPlaceholderIntegrationTest extends RecordingTest {
    @Autowired
    JsonPlaceholder subject;

    @Test
    public void todos() {
       assertThat(subject.todos()).isNotNull();
    }

    @Test
    public void todo() {
        assertThat(subject.todo(1)).isNotNull();
    }
}