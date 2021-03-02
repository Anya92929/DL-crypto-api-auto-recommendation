package org.apache.cordova;

import org.json.JSONException;
import org.json.JSONObject;
import org.scribe.model.OAuthConstants;

public class GlobalizationError extends Exception {
    public static final String FORMATTING_ERROR = "FORMATTING_ERROR";
    public static final String PARSING_ERROR = "PARSING_ERROR";
    public static final String PATTERN_ERROR = "PATTERN_ERROR";
    public static final String UNKNOWN_ERROR = "UNKNOWN_ERROR";
    private static final long serialVersionUID = 1;
    int error = 0;

    public GlobalizationError() {
    }

    public GlobalizationError(String s) {
        if (s.equalsIgnoreCase(FORMATTING_ERROR)) {
            this.error = 1;
        } else if (s.equalsIgnoreCase(PARSING_ERROR)) {
            this.error = 2;
        } else if (s.equalsIgnoreCase(PATTERN_ERROR)) {
            this.error = 3;
        }
    }

    public String getErrorString() {
        switch (this.error) {
            case 0:
                return UNKNOWN_ERROR;
            case 1:
                return FORMATTING_ERROR;
            case 2:
                return PARSING_ERROR;
            case 3:
                return PATTERN_ERROR;
            default:
                return "";
        }
    }

    public int getErrorCode() {
        return this.error;
    }

    public JSONObject toJson() {
        JSONObject obj = new JSONObject();
        try {
            obj.put(OAuthConstants.CODE, getErrorCode());
            obj.put("message", getErrorString());
        } catch (JSONException e) {
        }
        return obj;
    }
}
