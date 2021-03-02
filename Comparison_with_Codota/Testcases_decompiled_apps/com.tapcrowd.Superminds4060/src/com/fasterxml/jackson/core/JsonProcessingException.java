package com.fasterxml.jackson.core;

import java.io.IOException;

public class JsonProcessingException extends IOException {
    static final long serialVersionUID = 123;
    protected JsonLocation _location;

    protected JsonProcessingException(String msg, JsonLocation loc, Throwable rootCause) {
        super(msg);
        if (rootCause != null) {
            initCause(rootCause);
        }
        this._location = loc;
    }

    protected JsonProcessingException(String msg) {
        super(msg);
    }

    protected JsonProcessingException(String msg, JsonLocation loc) {
        this(msg, loc, (Throwable) null);
    }

    protected JsonProcessingException(String msg, Throwable rootCause) {
        this(msg, (JsonLocation) null, rootCause);
    }

    protected JsonProcessingException(Throwable rootCause) {
        this((String) null, (JsonLocation) null, rootCause);
    }

    public JsonLocation getLocation() {
        return this._location;
    }

    public String getOriginalMessage() {
        return super.getMessage();
    }

    /* access modifiers changed from: protected */
    public String getMessageSuffix() {
        return null;
    }

    public String getMessage() {
        String msg = super.getMessage();
        if (msg == null) {
            msg = "N/A";
        }
        JsonLocation loc = getLocation();
        String suffix = getMessageSuffix();
        if (loc == null && suffix == null) {
            return msg;
        }
        StringBuilder sb = new StringBuilder(100);
        sb.append(msg);
        if (suffix != null) {
            sb.append(suffix);
        }
        if (loc != null) {
            sb.append(10);
            sb.append(" at ");
            sb.append(loc.toString());
        }
        return sb.toString();
    }

    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }
}
