package com.parse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseAddOperation implements ParseFieldOperation {
    protected final ArrayList<Object> objects = new ArrayList<>();

    public ParseAddOperation(Collection<?> coll) {
        this.objects.addAll(coll);
    }

    public ParseAddOperation(Object o) {
        this.objects.add(o);
    }

    public JSONObject encode() throws JSONException {
        JSONObject output = new JSONObject();
        output.put("__op", "Add");
        output.put("objects", Parse.maybeReferenceAndEncode(this.objects));
        return output;
    }

    /* Debug info: failed to restart local var, previous not found, register: 4 */
    public ParseFieldOperation mergeWithPrevious(ParseFieldOperation previous) {
        if (previous == null) {
            return this;
        }
        if (previous instanceof ParseDeleteOperation) {
            return new ParseSetOperation(this.objects);
        }
        if (previous instanceof ParseSetOperation) {
            Object value = ((ParseSetOperation) previous).getValue();
            if (value instanceof JSONArray) {
                ArrayList<Object> result = ParseFieldOperations.jsonArrayAsArrayList((JSONArray) value);
                result.addAll(this.objects);
                return new ParseSetOperation(new JSONArray(result));
            } else if (value instanceof List) {
                ArrayList<Object> result2 = new ArrayList<>((List) value);
                result2.addAll(this.objects);
                return new ParseSetOperation(result2);
            } else {
                throw new IllegalArgumentException("You can only add an item to a List or JSONArray.");
            }
        } else if (previous instanceof ParseAddOperation) {
            ArrayList<Object> result3 = new ArrayList<>(((ParseAddOperation) previous).objects);
            result3.addAll(this.objects);
            return new ParseAddOperation((Collection<?>) result3);
        } else {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
    }

    public Object apply(Object oldValue, ParseObject object, String key) {
        if (oldValue == null) {
            return this.objects;
        }
        if (oldValue instanceof JSONArray) {
            return new JSONArray((ArrayList) apply(ParseFieldOperations.jsonArrayAsArrayList((JSONArray) oldValue), object, key));
        }
        if (oldValue instanceof List) {
            ArrayList<Object> result = new ArrayList<>((List) oldValue);
            result.addAll(this.objects);
            return result;
        }
        throw new IllegalArgumentException("Operation is invalid after previous operation.");
    }
}
