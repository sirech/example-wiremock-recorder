package com.hceris.recorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class JsonPlaceholder {
    @Autowired
    RestTemplate template;

    public List<Todo> todos() {
        ResponseEntity<List<Todo>> response = template.exchange(
                "/todos",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Todo>>() {
                });
        return response.getBody();
    }

    public Todo todo(int id) {
        ResponseEntity<Todo> response = template.getForEntity("/todos/{id}", Todo.class, id);
        return response.getBody();
    }
}
