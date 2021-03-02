package org.apache.cordova;

import org.json.JSONException;
import org.json.JSONObject;

public class FileUploadResult {
    private long bytesSent = 0;
    private String objectId = null;
    private String response = null;
    private int responseCode = -1;

    public long getBytesSent() {
        return this.bytesSent;
    }

    public void setBytesSent(long bytes) {
        this.bytesSent = bytes;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(int responseCode2) {
        this.responseCode = responseCode2;
    }

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String response2) {
        this.response = response2;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public void setObjectId(String objectId2) {
        this.objectId = objectId2;
    }

    public JSONObject toJSONObject() throws JSONException {
        return new JSONObject("{bytesSent:" + this.bytesSent + ",responseCode:" + this.responseCode + ",response:" + JSONObject.quote(this.response) + ",objectId:" + JSONObject.quote(this.objectId) + "}");
    }
}
