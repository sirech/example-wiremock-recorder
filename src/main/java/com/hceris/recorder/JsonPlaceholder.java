package com.hceris.recorder;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class JsonPlaceholder {
    @Autowired
    RestTemplate template;

    public JsonNode todos() {
         ResponseEntity<JsonNode> response = template.getForEntity("/todos", JsonNode.class);
         return response.getBody();
    }

    public JsonNode todo(int id) {
        ResponseEntity<JsonNode> response = template.getForEntity("/todos/{id}", JsonNode.class, id);
        return response.getBody();
    }
}
