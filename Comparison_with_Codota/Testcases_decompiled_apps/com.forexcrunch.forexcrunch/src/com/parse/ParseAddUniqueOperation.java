package com.parse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseAddUniqueOperation implements ParseFieldOperation {
    protected LinkedHashSet<Object> objects = new LinkedHashSet<>();

    public ParseAddUniqueOperation(Collection<?> coll) {
        this.objects.addAll(coll);
    }

    public ParseAddUniqueOperation(Object o) {
        this.objects.add(o);
    }

    public JSONObject encode() throws JSONException {
        JSONObject output = new JSONObject();
        output.put("__op", "AddUnique");
        output.put("objects", Parse.maybeReferenceAndEncode(new ArrayList(this.objects)));
        return output;
    }

    /* Debug info: failed to restart local var, previous not found, register: 5 */
    public ParseFieldOperation mergeWithPrevious(ParseFieldOperation previous) {
        if (previous == null) {
            return this;
        }
        if (previous instanceof ParseDeleteOperation) {
            return new ParseSetOperation(this.objects);
        }
        if (previous instanceof ParseSetOperation) {
            Object value = ((ParseSetOperation) previous).getValue();
            if ((value instanceof JSONArray) || (value instanceof List)) {
                return new ParseSetOperation(apply(value, (ParseObject) null, (String) null));
            }
            throw new IllegalArgumentException("You can only add an item to a List or JSONArray.");
        } else if (previous instanceof ParseAddUniqueOperation) {
            return new ParseAddUniqueOperation((Collection<?>) (List) apply(new ArrayList<>(((ParseAddUniqueOperation) previous).objects), (ParseObject) null, (String) null));
        } else {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
    }

    public Object apply(Object oldValue, ParseObject object, String key) {
        if (oldValue == null) {
            return new ArrayList(this.objects);
        }
        if (oldValue instanceof JSONArray) {
            return new JSONArray((ArrayList) apply(ParseFieldOperations.jsonArrayAsArrayList((JSONArray) oldValue), object, key));
        }
        if (oldValue instanceof List) {
            ArrayList<Object> result = new ArrayList<>((List) oldValue);
            HashMap<String, Integer> existingObjectIds = new HashMap<>();
            for (int i = 0; i < result.size(); i++) {
                if (result.get(i) instanceof ParseObject) {
                    existingObjectIds.put(((ParseObject) result.get(i)).getObjectId(), Integer.valueOf(i));
                }
            }
            Iterator it = this.objects.iterator();
            while (it.hasNext()) {
                Object obj = it.next();
                if (obj instanceof ParseObject) {
                    Integer index = existingObjectIds.get(((ParseObject) obj).getObjectId());
                    if (index != null) {
                        result.set(index.intValue(), obj);
                    } else {
                        result.add(obj);
                    }
                } else if (!result.contains(obj)) {
                    result.add(obj);
                }
            }
            return result;
        }
        throw new IllegalArgumentException("Operation is invalid after previous operation.");
    }
}
