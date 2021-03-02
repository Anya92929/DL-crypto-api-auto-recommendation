package com.SocketMobile.ScanAPICore;

public class SktOperationResult {
    private long _result;
    private int _resultInteger;
    private String _resultString;
    private int _type;

    static class type {
        public static final int typeInt = 2;
        public static final int typeString = 1;
        public static final int typeStringOrInt = 3;

        type() {
        }
    }

    public SktOperationResult() {
        this._type = 2;
        this._resultInteger = 0;
        this._result = 0;
        this._resultString = "";
    }

    public SktOperationResult(SktOperationResult result) {
        this._type = result._type;
        this._resultInteger = result._resultInteger;
        this._result = result._result;
        this._resultString = result._resultString;
    }

    public long WriteResult(String resultString) {
        this._resultString = resultString;
        return 0;
    }

    public void setResult(int resultInteger) {
        this._resultInteger = resultInteger;
    }

    public void setError(long result) {
        this._result = result;
    }

    public int getType() {
        return this._type;
    }

    public String getResultString() {
        return this._resultString;
    }

    public int getResultInteger() {
        return this._resultInteger;
    }

    public long getError() {
        return this._result;
    }

    /* access modifiers changed from: protected */
    public long CreateStringFromInteger() {
        return 0;
    }
}
