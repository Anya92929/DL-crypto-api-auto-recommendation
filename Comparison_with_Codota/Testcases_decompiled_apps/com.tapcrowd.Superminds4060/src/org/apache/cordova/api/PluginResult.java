package org.apache.cordova.api;

import org.json.JSONArray;
import org.json.JSONObject;

public class PluginResult {
    public static final int MESSAGE_TYPE_BOOLEAN = 4;
    public static final int MESSAGE_TYPE_JSON = 2;
    public static final int MESSAGE_TYPE_NULL = 5;
    public static final int MESSAGE_TYPE_NUMBER = 3;
    public static final int MESSAGE_TYPE_STRING = 1;
    public static String[] StatusMessages = {"No result", "OK", "Class not found", "Illegal access", "Instantiation error", "Malformed url", "IO error", "Invalid action", "JSON error", "Error"};
    private String encodedMessage;
    private boolean keepCallback;
    private final int messageType;
    private final int status;
    private String strMessage;

    public enum Status {
        NO_RESULT,
        OK,
        CLASS_NOT_FOUND_EXCEPTION,
        ILLEGAL_ACCESS_EXCEPTION,
        INSTANTIATION_EXCEPTION,
        MALFORMED_URL_EXCEPTION,
        IO_EXCEPTION,
        INVALID_ACTION,
        JSON_EXCEPTION,
        ERROR
    }

    public PluginResult(Status status2) {
        this(status2, StatusMessages[status2.ordinal()]);
    }

    public PluginResult(Status status2, String message) {
        this.keepCallback = false;
        this.status = status2.ordinal();
        this.messageType = message == null ? 5 : 1;
        this.strMessage = message;
    }

    public PluginResult(Status status2, JSONArray message) {
        this.keepCallback = false;
        this.status = status2.ordinal();
        this.messageType = 2;
        this.encodedMessage = message.toString();
    }

    public PluginResult(Status status2, JSONObject message) {
        this.keepCallback = false;
        this.status = status2.ordinal();
        this.messageType = 2;
        this.encodedMessage = message.toString();
    }

    public PluginResult(Status status2, int i) {
        this.keepCallback = false;
        this.status = status2.ordinal();
        this.messageType = 3;
        this.encodedMessage = "" + i;
    }

    public PluginResult(Status status2, float f) {
        this.keepCallback = false;
        this.status = status2.ordinal();
        this.messageType = 3;
        this.encodedMessage = "" + f;
    }

    public PluginResult(Status status2, boolean b) {
        this.keepCallback = false;
        this.status = status2.ordinal();
        this.messageType = 4;
        this.encodedMessage = Boolean.toString(b);
    }

    public void setKeepCallback(boolean b) {
        this.keepCallback = b;
    }

    public int getStatus() {
        return this.status;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public String getMessage() {
        if (this.encodedMessage == null) {
            this.encodedMessage = JSONObject.quote(this.strMessage);
        }
        return this.encodedMessage;
    }

    public String getStrMessage() {
        return this.strMessage;
    }

    public boolean getKeepCallback() {
        return this.keepCallback;
    }

    @Deprecated
    public String getJSONString() {
        return "{\"status\":" + this.status + ",\"message\":" + getMessage() + ",\"keepCallback\":" + this.keepCallback + "}";
    }

    @Deprecated
    public String toCallbackString(String callbackId) {
        if (this.status == Status.NO_RESULT.ordinal() && this.keepCallback) {
            return null;
        }
        if (this.status == Status.OK.ordinal() || this.status == Status.NO_RESULT.ordinal()) {
            return toSuccessCallbackString(callbackId);
        }
        return toErrorCallbackString(callbackId);
    }

    @Deprecated
    public String toSuccessCallbackString(String callbackId) {
        return "cordova.callbackSuccess('" + callbackId + "'," + getJSONString() + ");";
    }

    @Deprecated
    public String toErrorCallbackString(String callbackId) {
        return "cordova.callbackError('" + callbackId + "', " + getJSONString() + ");";
    }
}
