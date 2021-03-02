package p006nl.volkerinfradesign.checkandroid.data.tree;

import com.google.gson.JsonObject;

/* renamed from: nl.volkerinfradesign.checkandroid.data.tree.FormInfo */
public interface FormInfo {
    boolean areProjectsEnabled();

    FormItem get(int i);

    JsonObject getExtras(int i);

    boolean hasLonelyItems(boolean z);

    int size();
}
