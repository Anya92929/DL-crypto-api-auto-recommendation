package com.tapcrowd.app.utils;

import android.text.Html;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.util.HashMap;
import org.json.JSONObject;

public class TCObject {
    public HashMap<String, String> vars = new HashMap<>();

    public TCObject() {
    }

    public String toString() {
        if (this.vars.containsKey(DBFavorites.KEY_NAME)) {
            return this.vars.get(DBFavorites.KEY_NAME);
        }
        if (this.vars.containsKey(PlusShare.KEY_CALL_TO_ACTION_LABEL)) {
            return this.vars.get(PlusShare.KEY_CALL_TO_ACTION_LABEL);
        }
        if (this.vars.containsKey(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)) {
            return this.vars.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        }
        return this.vars.toString();
    }

    public TCObject(JSONObject jo) {
        while (jo.keys().hasNext()) {
            try {
                String key = jo.keys().next();
                try {
                    if (jo.get(key).toString() != null) {
                        this.vars.put(key, jo.get(key).toString());
                    }
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                return;
            }
        }
    }

    public boolean has(String key) {
        if (!this.vars.containsKey(key)) {
            return false;
        }
        if (this.vars.get(key) == null) {
            return false;
        }
        if (this.vars.get(key).equals("")) {
            return false;
        }
        if (this.vars.get(key).equals("null")) {
            return false;
        }
        return true;
    }

    public String get(String key) {
        if (key == null) {
            return null;
        }
        try {
            if (!this.vars.containsKey(key)) {
                return null;
            }
            String s = this.vars.get(key).replace("\n", "<br/>").replace("", "");
            if (s == null) {
                return null;
            }
            if (s.equalsIgnoreCase("")) {
                return null;
            }
            return Html.fromHtml(s).toString();
        } catch (Exception e) {
            return null;
        }
    }

    public String get(String key, boolean html) {
        if (key == null || !this.vars.containsKey(key)) {
            return null;
        }
        if (html) {
            return get(key);
        }
        return this.vars.get(key);
    }

    public String get(String key, String def) {
        return get(key) == null ? def : get(key);
    }
}
