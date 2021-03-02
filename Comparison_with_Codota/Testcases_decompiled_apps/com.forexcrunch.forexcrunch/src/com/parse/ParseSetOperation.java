package com.parse;

class ParseSetOperation implements ParseFieldOperation {
    private Object value;

    public ParseSetOperation(Object newValue) {
        this.value = newValue;
    }

    public Object getValue() {
        return this.value;
    }

    public Object encode() {
        return Parse.maybeEncodeJSONObject(this.value, true);
    }

    public ParseFieldOperation mergeWithPrevious(ParseFieldOperation previous) {
        return this;
    }

    public Object apply(Object oldValue, ParseObject object, String key) {
        return this.value;
    }
}
