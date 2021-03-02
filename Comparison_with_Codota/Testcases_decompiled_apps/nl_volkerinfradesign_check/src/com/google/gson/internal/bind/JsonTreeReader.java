package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class JsonTreeReader extends JsonReader {

    /* renamed from: a */
    private static final Reader f3770a = new Reader() {
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        public void close() throws IOException {
            throw new AssertionError();
        }
    };

    /* renamed from: b */
    private static final Object f3771b = new Object();

    /* renamed from: c */
    private final List<Object> f3772c = new ArrayList();

    public JsonTreeReader(JsonElement jsonElement) {
        super(f3770a);
        this.f3772c.add(jsonElement);
    }

    public void beginArray() throws IOException {
        m4340a(JsonToken.BEGIN_ARRAY);
        this.f3772c.add(((JsonArray) m4339a()).iterator());
    }

    public void endArray() throws IOException {
        m4340a(JsonToken.END_ARRAY);
        m4341b();
        m4341b();
    }

    public void beginObject() throws IOException {
        m4340a(JsonToken.BEGIN_OBJECT);
        this.f3772c.add(((JsonObject) m4339a()).entrySet().iterator());
    }

    public void endObject() throws IOException {
        m4340a(JsonToken.END_OBJECT);
        m4341b();
        m4341b();
    }

    public boolean hasNext() throws IOException {
        JsonToken peek = peek();
        return (peek == JsonToken.END_OBJECT || peek == JsonToken.END_ARRAY) ? false : true;
    }

    public JsonToken peek() throws IOException {
        if (this.f3772c.isEmpty()) {
            return JsonToken.END_DOCUMENT;
        }
        Object a = m4339a();
        if (a instanceof Iterator) {
            boolean z = this.f3772c.get(this.f3772c.size() - 2) instanceof JsonObject;
            Iterator it = (Iterator) a;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (z) {
                return JsonToken.NAME;
            }
            this.f3772c.add(it.next());
            return peek();
        } else if (a instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (a instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (a instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) a;
                if (jsonPrimitive.isString()) {
                    return JsonToken.STRING;
                }
                if (jsonPrimitive.isBoolean()) {
                    return JsonToken.BOOLEAN;
                }
                if (jsonPrimitive.isNumber()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (a instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (a == f3771b) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    /* renamed from: a */
    private Object m4339a() {
        return this.f3772c.get(this.f3772c.size() - 1);
    }

    /* renamed from: b */
    private Object m4341b() {
        return this.f3772c.remove(this.f3772c.size() - 1);
    }

    /* renamed from: a */
    private void m4340a(JsonToken jsonToken) throws IOException {
        if (peek() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek());
        }
    }

    public String nextName() throws IOException {
        m4340a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m4339a()).next();
        this.f3772c.add(entry.getValue());
        return (String) entry.getKey();
    }

    public String nextString() throws IOException {
        JsonToken peek = peek();
        if (peek == JsonToken.STRING || peek == JsonToken.NUMBER) {
            return ((JsonPrimitive) m4341b()).getAsString();
        }
        throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + peek);
    }

    public boolean nextBoolean() throws IOException {
        m4340a(JsonToken.BOOLEAN);
        return ((JsonPrimitive) m4341b()).getAsBoolean();
    }

    public void nextNull() throws IOException {
        m4340a(JsonToken.NULL);
        m4341b();
    }

    public double nextDouble() throws IOException {
        JsonToken peek = peek();
        if (peek == JsonToken.NUMBER || peek == JsonToken.STRING) {
            double asDouble = ((JsonPrimitive) m4339a()).getAsDouble();
            if (isLenient() || (!Double.isNaN(asDouble) && !Double.isInfinite(asDouble))) {
                m4341b();
                return asDouble;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + peek);
    }

    public long nextLong() throws IOException {
        JsonToken peek = peek();
        if (peek == JsonToken.NUMBER || peek == JsonToken.STRING) {
            long asLong = ((JsonPrimitive) m4339a()).getAsLong();
            m4341b();
            return asLong;
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + peek);
    }

    public int nextInt() throws IOException {
        JsonToken peek = peek();
        if (peek == JsonToken.NUMBER || peek == JsonToken.STRING) {
            int asInt = ((JsonPrimitive) m4339a()).getAsInt();
            m4341b();
            return asInt;
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + peek);
    }

    public void close() throws IOException {
        this.f3772c.clear();
        this.f3772c.add(f3771b);
    }

    public void skipValue() throws IOException {
        if (peek() == JsonToken.NAME) {
            nextName();
        } else {
            m4341b();
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public void promoteNameToValue() throws IOException {
        m4340a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m4339a()).next();
        this.f3772c.add(entry.getValue());
        this.f3772c.add(new JsonPrimitive((String) entry.getKey()));
    }
}
