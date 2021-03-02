package com.parse;

import com.parse.ParseObject;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseRelationOperation<T extends ParseObject> implements ParseFieldOperation {
    private Set<String> relationsToAdd;
    private Set<String> relationsToRemove;
    private String targetClass;

    ParseRelationOperation(Set<T> newRelationsToAdd, Set<T> newRelationsToRemove) {
        this.targetClass = null;
        this.relationsToAdd = new HashSet();
        this.relationsToRemove = new HashSet();
        if (newRelationsToAdd != null) {
            for (T object : newRelationsToAdd) {
                if (object.getObjectId() == null) {
                    throw new IllegalArgumentException("All objects in a relation must have object ids.");
                }
                this.relationsToAdd.add(object.getObjectId());
                if (this.targetClass == null) {
                    this.targetClass = object.getClassName();
                } else if (!this.targetClass.equals(object.getClassName())) {
                    throw new IllegalArgumentException("All objects in a relation must be of the same class.");
                }
            }
        }
        if (newRelationsToRemove != null) {
            for (T object2 : newRelationsToRemove) {
                if (object2.getObjectId() == null) {
                    throw new IllegalArgumentException("All objects in a relation must have object ids.");
                }
                this.relationsToRemove.add(object2.getObjectId());
                if (this.targetClass == null) {
                    this.targetClass = object2.getClassName();
                } else if (!this.targetClass.equals(object2.getClassName())) {
                    throw new IllegalArgumentException("All objects in a relation must be of the same class.");
                }
            }
        }
        if (this.targetClass == null) {
            throw new IllegalArgumentException("Cannot create a ParseRelationOperation with no objects.");
        }
    }

    private ParseRelationOperation(String newTargetClass, Set<String> newRelationsToAdd, Set<String> newRelationsToRemove) {
        this.targetClass = newTargetClass;
        this.relationsToAdd = new HashSet(newRelationsToAdd);
        this.relationsToRemove = new HashSet(newRelationsToRemove);
    }

    /* access modifiers changed from: package-private */
    public String getTargetClass() {
        return this.targetClass;
    }

    /* access modifiers changed from: package-private */
    public JSONArray convertSetToArray(Set<String> set) throws JSONException {
        JSONArray array = new JSONArray();
        for (String id : set) {
            JSONObject pointer = new JSONObject();
            pointer.put("__type", "Pointer");
            pointer.put("className", this.targetClass);
            pointer.put("objectId", id);
            array.put(pointer);
        }
        return array;
    }

    public JSONObject encode() throws JSONException {
        JSONObject adds = null;
        JSONObject removes = null;
        if (this.relationsToAdd.size() > 0) {
            adds = new JSONObject();
            adds.put("__op", "AddRelation");
            adds.put("objects", convertSetToArray(this.relationsToAdd));
        }
        if (this.relationsToRemove.size() > 0) {
            removes = new JSONObject();
            removes.put("__op", "RemoveRelation");
            removes.put("objects", convertSetToArray(this.relationsToRemove));
        }
        if (adds != null && removes != null) {
            JSONObject result = new JSONObject();
            result.put("__op", "Batch");
            JSONArray ops = new JSONArray();
            ops.put(adds);
            ops.put(removes);
            result.put("ops", ops);
            return result;
        } else if (adds != null) {
            return adds;
        } else {
            if (removes != null) {
                return removes;
            }
            throw new IllegalArgumentException("A ParseRelationOperation was created without any data.");
        }
    }

    public ParseFieldOperation mergeWithPrevious(ParseFieldOperation previous) {
        if (previous == null) {
            return this;
        }
        if (previous instanceof ParseDeleteOperation) {
            throw new IllegalArgumentException("You can't modify a relation after deleting it.");
        } else if (previous instanceof ParseRelationOperation) {
            ParseRelationOperation<T> previousOperation = (ParseRelationOperation) previous;
            if (previousOperation.targetClass == null || previousOperation.targetClass.equals(this.targetClass)) {
                Set<String> newRelationsToAdd = new HashSet<>(previousOperation.relationsToAdd);
                Set<String> newRelationsToRemove = new HashSet<>(previousOperation.relationsToRemove);
                if (this.relationsToAdd != null) {
                    newRelationsToAdd.addAll(this.relationsToAdd);
                    newRelationsToRemove.removeAll(this.relationsToAdd);
                }
                if (this.relationsToRemove != null) {
                    newRelationsToAdd.removeAll(this.relationsToRemove);
                    newRelationsToRemove.addAll(this.relationsToRemove);
                }
                return new ParseRelationOperation<>(this.targetClass, newRelationsToAdd, newRelationsToRemove);
            }
            throw new IllegalArgumentException("Related object object must be of class " + previousOperation.targetClass + ", but " + this.targetClass + " was passed in.");
        } else {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
    }

    public Object apply(Object oldValue, ParseObject object, String key) {
        if (oldValue == null) {
            ParseRelation<T> relation = new ParseRelation<>(object, key);
            relation.setTargetClass(this.targetClass);
            return relation;
        } else if (oldValue instanceof ParseRelation) {
            ParseRelation<T> relation2 = (ParseRelation) oldValue;
            if (!(this.targetClass == null || relation2.getTargetClass() == null)) {
                if (!relation2.getTargetClass().equals(this.targetClass)) {
                    throw new IllegalArgumentException("Related object object must be of class " + relation2.getTargetClass() + ", but " + this.targetClass + " was passed in.");
                }
                relation2.setTargetClass(this.targetClass);
            }
            return relation2;
        } else {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
        }
    }
}
