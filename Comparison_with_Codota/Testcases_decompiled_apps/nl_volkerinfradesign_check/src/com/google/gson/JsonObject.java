package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

public final class JsonObject extends JsonElement {

    /* renamed from: a */
    private final LinkedTreeMap<String, JsonElement> f3645a = new LinkedTreeMap<>();

    public void add(String str, JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        this.f3645a.put(str, jsonElement);
    }

    public JsonElement remove(String str) {
        return this.f3645a.remove(str);
    }

    public void addProperty(String str, String str2) {
        add(str, m4270a(str2));
    }

    public void addProperty(String str, Number number) {
        add(str, m4270a(number));
    }

    public void addProperty(String str, Boolean bool) {
        add(str, m4270a(bool));
    }

    public void addProperty(String str, Character ch) {
        add(str, m4270a(ch));
    }

    /* renamed from: a */
    private JsonElement m4270a(Object obj) {
        return obj == null ? JsonNull.INSTANCE : new JsonPrimitive(obj);
    }

    public Set<Map.Entry<String, JsonElement>> entrySet() {
        return this.f3645a.entrySet();
    }

    public boolean has(String str) {
        return this.f3645a.containsKey(str);
    }

    public JsonElement get(String str) {
        return this.f3645a.get(str);
    }

    public JsonPrimitive getAsJsonPrimitive(String str) {
        return (JsonPrimitive) this.f3645a.get(str);
    }

    public JsonArray getAsJsonArray(String str) {
        return (JsonArray) this.f3645a.get(str);
    }

    public JsonObject getAsJsonObject(String str) {
        return (JsonObject) this.f3645a.get(str);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonObject) && ((JsonObject) obj).f3645a.equals(this.f3645a));
    }

    public int hashCode() {
        return this.f3645a.hashCode();
    }
}
