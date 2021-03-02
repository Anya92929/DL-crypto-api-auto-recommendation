package com.parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ParseFieldOperation */
final class ParseFieldOperations {
    static Map<String, ParseFieldOperationFactory> opDecoderMap = new HashMap();

    /* compiled from: ParseFieldOperation */
    private interface ParseFieldOperationFactory {
        ParseFieldOperation decode(JSONObject jSONObject) throws JSONException;
    }

    private ParseFieldOperations() {
    }

    private static void registerDecoder(String opName, ParseFieldOperationFactory factory) {
        opDecoderMap.put(opName, factory);
    }

    static void registerDefaultDecoders() {
        registerDecoder("Batch", new ParseFieldOperationFactory() {
            public ParseFieldOperation decode(JSONObject object) throws JSONException {
                ParseFieldOperation op = null;
                JSONArray ops = object.getJSONArray("ops");
                for (int i = 0; i < ops.length(); i++) {
                    op = ParseFieldOperations.decode(ops.getJSONObject(i)).mergeWithPrevious(op);
                }
                return op;
            }
        });
        registerDecoder("Delete", new ParseFieldOperationFactory() {
            public ParseFieldOperation decode(JSONObject object) throws JSONException {
                return ParseDeleteOperation.getInstance();
            }
        });
        registerDecoder("Increment", new ParseFieldOperationFactory() {
            public ParseFieldOperation decode(JSONObject object) throws JSONException {
                return new ParseIncrementOperation((Number) object.opt("amount"));
            }
        });
        registerDecoder("Add", new ParseFieldOperationFactory() {
            public ParseFieldOperation decode(JSONObject object) throws JSONException {
                return new ParseAddOperation(object.opt("objects"));
            }
        });
        registerDecoder("AddUnique", new ParseFieldOperationFactory() {
            public ParseFieldOperation decode(JSONObject object) throws JSONException {
                return new ParseAddUniqueOperation(object.opt("objects"));
            }
        });
        registerDecoder("Remove", new ParseFieldOperationFactory() {
            public ParseFieldOperation decode(JSONObject object) throws JSONException {
                return new ParseRemoveOperation(object.opt("objects"));
            }
        });
        registerDecoder("AddRelation", new ParseFieldOperationFactory() {
            public ParseFieldOperation decode(JSONObject object) throws JSONException {
                return new ParseRelationOperation((Set) null, (Set) null);
            }
        });
        registerDecoder("RemoveRelation", new ParseFieldOperationFactory() {
            public ParseFieldOperation decode(JSONObject object) throws JSONException {
                return new ParseRelationOperation((Set) null, (Set) null);
            }
        });
    }

    static ParseFieldOperation decode(JSONObject encoded) throws JSONException {
        String op = encoded.optString("__op");
        ParseFieldOperationFactory factory = opDecoderMap.get(op);
        if (factory != null) {
            return factory.decode(encoded);
        }
        throw new RuntimeException("Unable to decode operation of type " + op);
    }

    static ArrayList<Object> jsonArrayAsArrayList(JSONArray array) {
        ArrayList<Object> result = new ArrayList<>(array.length());
        int i = 0;
        while (i < array.length()) {
            try {
                result.add(array.get(i));
                i++;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
