package com.hceris.recorder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import lombok.Value;

@Value
public class Todo {
    @JsonCreator
            public static Todo create(@JsonProperty("userId") int userId,
                                      @JsonProperty("title") String title,
                                      @JsonProperty("completed") boolean completed) {
        return new Todo(userId, title, completed);
    }

    int userId;
    @NonNull
    String title;
    boolean completed;
}
