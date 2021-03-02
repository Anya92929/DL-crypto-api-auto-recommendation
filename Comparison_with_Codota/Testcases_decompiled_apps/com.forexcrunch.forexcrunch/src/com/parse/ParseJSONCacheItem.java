package com.parse;

import com.parse.codec.digest.DigestUtils;
import org.json.JSONException;
import org.json.JSONObject;

class ParseJSONCacheItem {
    private String hashValue;
    private JSONObject json = new JSONObject();

    public ParseJSONCacheItem(Object object) throws JSONException {
        this.json.put("object", Parse.maybeEncodeJSONObject(object, true));
        this.hashValue = DigestUtils.md5Hex(this.json.toString());
    }

    public boolean equals(ParseJSONCacheItem other) {
        return this.hashValue.equals(other.getHashValue());
    }

    public String getHashValue() {
        return this.hashValue;
    }

    public Object getJSONObject() {
        try {
            return this.json.get("object");
        } catch (JSONException e) {
            return null;
        }
    }
}
