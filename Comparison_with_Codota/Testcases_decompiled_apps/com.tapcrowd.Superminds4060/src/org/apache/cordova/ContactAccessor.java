package org.apache.cordova;

import android.util.Log;
import android.webkit.WebView;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.util.HashMap;
import org.apache.cordova.api.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ContactAccessor {
    protected final String LOG_TAG = "ContactsAccessor";
    protected CordovaInterface mApp;
    protected WebView mView;

    public abstract JSONObject getContactById(String str) throws JSONException;

    public abstract boolean remove(String str);

    public abstract String save(JSONObject jSONObject);

    public abstract JSONArray search(JSONArray jSONArray, JSONObject jSONObject);

    /* access modifiers changed from: protected */
    public boolean isRequired(String key, HashMap<String, Boolean> map) {
        Boolean retVal = map.get(key);
        if (retVal == null) {
            return false;
        }
        return retVal.booleanValue();
    }

    /* access modifiers changed from: protected */
    public HashMap<String, Boolean> buildPopulationSet(JSONArray fields) {
        HashMap<String, Boolean> map = new HashMap<>();
        try {
            if (fields.length() != 1 || !fields.getString(0).equals("*")) {
                for (int i = 0; i < fields.length(); i++) {
                    String key = fields.getString(i);
                    if (key.startsWith("displayName")) {
                        map.put("displayName", true);
                    } else if (key.startsWith(DBFavorites.KEY_NAME)) {
                        map.put("displayName", true);
                        map.put(DBFavorites.KEY_NAME, true);
                    } else if (key.startsWith("nickname")) {
                        map.put("nickname", true);
                    } else if (key.startsWith("phoneNumbers")) {
                        map.put("phoneNumbers", true);
                    } else if (key.startsWith("emails")) {
                        map.put("emails", true);
                    } else if (key.startsWith("addresses")) {
                        map.put("addresses", true);
                    } else if (key.startsWith("ims")) {
                        map.put("ims", true);
                    } else if (key.startsWith("organizations")) {
                        map.put("organizations", true);
                    } else if (key.startsWith("birthday")) {
                        map.put("birthday", true);
                    } else if (key.startsWith("note")) {
                        map.put("note", true);
                    } else if (key.startsWith("urls")) {
                        map.put("urls", true);
                    } else if (key.startsWith("photos")) {
                        map.put("photos", true);
                    } else if (key.startsWith("categories")) {
                        map.put("categories", true);
                    }
                }
                return map;
            }
            map.put("displayName", true);
            map.put(DBFavorites.KEY_NAME, true);
            map.put("nickname", true);
            map.put("phoneNumbers", true);
            map.put("emails", true);
            map.put("addresses", true);
            map.put("ims", true);
            map.put("organizations", true);
            map.put("birthday", true);
            map.put("note", true);
            map.put("urls", true);
            map.put("photos", true);
            map.put("categories", true);
            return map;
        } catch (JSONException e) {
            Log.e("ContactsAccessor", e.getMessage(), e);
        }
    }

    /* access modifiers changed from: protected */
    public String getJsonString(JSONObject obj, String property) {
        if (obj == null) {
            return null;
        }
        try {
            String value = obj.getString(property);
            if (!value.equals("null")) {
                return value;
            }
            Log.d("ContactsAccessor", property + " is string called 'null'");
            return null;
        } catch (JSONException e) {
            Log.d("ContactsAccessor", "Could not get = " + e.getMessage());
            return null;
        }
    }

    class WhereOptions {
        private String where;
        private String[] whereArgs;

        WhereOptions() {
        }

        public void setWhere(String where2) {
            this.where = where2;
        }

        public String getWhere() {
            return this.where;
        }

        public void setWhereArgs(String[] whereArgs2) {
            this.whereArgs = whereArgs2;
        }

        public String[] getWhereArgs() {
            return this.whereArgs;
        }
    }
}
