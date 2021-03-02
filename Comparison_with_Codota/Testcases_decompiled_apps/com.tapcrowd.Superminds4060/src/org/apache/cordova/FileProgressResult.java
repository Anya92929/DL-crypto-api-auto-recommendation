package org.apache.cordova;

import org.json.JSONException;
import org.json.JSONObject;

public class FileProgressResult {
    private boolean lengthComputable = false;
    private long loaded = 0;
    private long total = 0;

    public boolean getLengthComputable() {
        return this.lengthComputable;
    }

    public void setLengthComputable(boolean computable) {
        this.lengthComputable = computable;
    }

    public long getLoaded() {
        return this.loaded;
    }

    public void setLoaded(long bytes) {
        this.loaded = bytes;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long bytes) {
        this.total = bytes;
    }

    public JSONObject toJSONObject() throws JSONException {
        return new JSONObject("{loaded:" + this.loaded + ",total:" + this.total + ",lengthComputable:" + (this.lengthComputable ? "true" : "false") + "}");
    }
}
