package com.google.android.gms.tasks;

public interface Continuation {
    Object then(Task task);
}
