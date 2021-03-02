package p006nl.volkerinfradesign.checkandroid.services.tasks;

import com.google.gson.JsonArray;
import p006nl.volkerinfradesign.checkandroid.environments.Account;

/* renamed from: nl.volkerinfradesign.checkandroid.services.tasks.TasksParam */
public final class TasksParam {
    public final Account account;
    public final JsonArray delegatedTasks;
    public final JsonArray finishedTasks;

    public TasksParam(Account account2, JsonArray jsonArray, JsonArray jsonArray2) {
        this.account = account2.copy();
        this.finishedTasks = jsonArray;
        this.delegatedTasks = jsonArray2;
    }
}
