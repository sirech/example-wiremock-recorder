package com.hceris.recorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    JsonPlaceholder placeholder;

    @RequestMapping("/todos")
    public List<Todo> todos() {
        return placeholder.todos();
    }

    @RequestMapping("/todos/{id}")
    public Todo todo(@PathVariable int id) {
        return placeholder.todo(id);
    }
}
