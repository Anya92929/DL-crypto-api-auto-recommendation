package com.parse;

import org.json.JSONException;
import org.json.JSONObject;

class ParseIncrementOperation implements ParseFieldOperation {
    private Number amount;

    public ParseIncrementOperation(Number amount2) {
        this.amount = amount2;
    }

    public JSONObject encode() throws JSONException {
        JSONObject output = new JSONObject();
        output.put("__op", "Increment");
        output.put("amount", this.amount);
        return output;
    }

    /* Debug info: failed to restart local var, previous not found, register: 4 */
    public ParseFieldOperation mergeWithPrevious(ParseFieldOperation previous) {
        if (previous == null) {
            return this;
        }
        if (previous instanceof ParseDeleteOperation) {
            return new ParseSetOperation(this.amount);
        }
        if (previous instanceof ParseSetOperation) {
            Object oldValue = ((ParseSetOperation) previous).getValue();
            if (oldValue instanceof Number) {
                return new ParseSetOperation(Parse.addNumbers((Number) oldValue, this.amount));
            }
            throw new IllegalArgumentException("You cannot increment a non-number.");
        } else if (previous instanceof ParseIncrementOperation) {
            return new ParseIncrementOperation(Parse.addNumbers(((ParseIncrementOperation) previous).amount, this.amount));
        } else {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
    }

    public Object apply(Object oldValue, ParseObject object, String key) {
        if (oldValue == null) {
            return this.amount;
        }
        if (oldValue instanceof Number) {
            return Parse.addNumbers((Number) oldValue, this.amount);
        }
        throw new IllegalArgumentException("You cannot increment a non-number.");
    }
}
