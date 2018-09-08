package com.hceris.recorder;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    JsonPlaceholder placeholder;

    @RequestMapping("/todos")
    public JsonNode todos() {
        return placeholder.todos();
    }

    @RequestMapping("/todos/{id}")
    public JsonNode todo(@PathVariable int id) {
        return placeholder.todo(id);
    }
}
