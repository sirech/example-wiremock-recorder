package com.hceris.recorder;

import lombok.NonNull;
import lombok.Value;

@Value
public class Todo {
    int userId;
    @NonNull
    String title;
    boolean completed;
}
