package com.hceris.recorder;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Todo {
    int userId;
    @NonNull
    String title;
    boolean completed;
}
