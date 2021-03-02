package p006nl.volkerinfradesign.checkandroid.services.tasks;

import com.google.gson.JsonArray;

/* renamed from: nl.volkerinfradesign.checkandroid.services.tasks.TasksCallback */
public interface TasksCallback {
    void onError(Exception exc);

    void onSessionExpired(Exception exc);

    void onStart();

    void onSuccess(JsonArray jsonArray);
}
