package com.parse;

import com.parse.ParseObject;
import java.util.Collections;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseRelation<T extends ParseObject> {
    private String key;
    private ParseObject parent;
    private String targetClass;

    ParseRelation(ParseObject parent2, String key2) {
        this.parent = parent2;
        this.key = key2;
        this.targetClass = null;
    }

    ParseRelation(String targetClass2) {
        this.parent = null;
        this.key = null;
        this.targetClass = targetClass2;
    }

    /* access modifiers changed from: package-private */
    public void ensureParentAndKey(ParseObject someParent, String someKey) {
        if (this.parent == null) {
            this.parent = someParent;
        }
        if (this.key == null) {
            this.key = someKey;
        }
        if (this.parent != someParent) {
            throw new IllegalStateException("Internal error. One ParseRelation retrieved from two different ParseObjects.");
        } else if (!this.key.equals(someKey)) {
            throw new IllegalStateException("Internal error. One ParseRelation retrieved from two different keys.");
        }
    }

    public void add(T object) {
        ParseRelationOperation<T> operation = new ParseRelationOperation<>(Collections.singleton(object), (Set) null);
        this.targetClass = operation.getTargetClass();
        this.parent.performOperation(this.key, operation);
    }

    public void remove(T object) {
        ParseRelationOperation<T> operation = new ParseRelationOperation<>((Set) null, Collections.singleton(object));
        this.targetClass = operation.getTargetClass();
        this.parent.performOperation(this.key, operation);
    }

    public ParseQuery<T> getQuery() {
        ParseQuery<T> query;
        if (this.targetClass == null) {
            query = ParseQuery.getQuery(this.parent.getClassName());
            query.redirectClassNameForKey(this.key);
        } else {
            query = ParseQuery.getQuery(this.targetClass);
        }
        query.whereRelatedTo(this.parent, this.key);
        return query;
    }

    /* access modifiers changed from: package-private */
    public JSONObject encodeToJSON() throws JSONException {
        JSONObject relation = new JSONObject();
        relation.put("__type", "Relation");
        relation.put("className", this.targetClass);
        return relation;
    }

    /* access modifiers changed from: package-private */
    public String getTargetClass() {
        return this.targetClass;
    }

    /* access modifiers changed from: package-private */
    public void setTargetClass(String className) {
        this.targetClass = className;
    }
}
