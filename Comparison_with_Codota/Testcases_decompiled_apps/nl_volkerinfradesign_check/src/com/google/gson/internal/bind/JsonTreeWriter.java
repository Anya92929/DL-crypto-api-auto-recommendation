package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class JsonTreeWriter extends JsonWriter {

    /* renamed from: a */
    private static final Writer f3773a = new Writer() {
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        public void flush() throws IOException {
            throw new AssertionError();
        }

        public void close() throws IOException {
            throw new AssertionError();
        }
    };

    /* renamed from: b */
    private static final JsonPrimitive f3774b = new JsonPrimitive("closed");

    /* renamed from: c */
    private final List<JsonElement> f3775c = new ArrayList();

    /* renamed from: d */
    private String f3776d;

    /* renamed from: e */
    private JsonElement f3777e = JsonNull.INSTANCE;

    public JsonTreeWriter() {
        super(f3773a);
    }

    public JsonElement get() {
        if (this.f3775c.isEmpty()) {
            return this.f3777e;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f3775c);
    }

    /* renamed from: a */
    private JsonElement m4342a() {
        return this.f3775c.get(this.f3775c.size() - 1);
    }

    /* renamed from: a */
    private void m4343a(JsonElement jsonElement) {
        if (this.f3776d != null) {
            if (!jsonElement.isJsonNull() || getSerializeNulls()) {
                ((JsonObject) m4342a()).add(this.f3776d, jsonElement);
            }
            this.f3776d = null;
        } else if (this.f3775c.isEmpty()) {
            this.f3777e = jsonElement;
        } else {
            JsonElement a = m4342a();
            if (a instanceof JsonArray) {
                ((JsonArray) a).add(jsonElement);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public JsonWriter beginArray() throws IOException {
        JsonArray jsonArray = new JsonArray();
        m4343a(jsonArray);
        this.f3775c.add(jsonArray);
        return this;
    }

    public JsonWriter endArray() throws IOException {
        if (this.f3775c.isEmpty() || this.f3776d != null) {
            throw new IllegalStateException();
        } else if (m4342a() instanceof JsonArray) {
            this.f3775c.remove(this.f3775c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public JsonWriter beginObject() throws IOException {
        JsonObject jsonObject = new JsonObject();
        m4343a(jsonObject);
        this.f3775c.add(jsonObject);
        return this;
    }

    public JsonWriter endObject() throws IOException {
        if (this.f3775c.isEmpty() || this.f3776d != null) {
            throw new IllegalStateException();
        } else if (m4342a() instanceof JsonObject) {
            this.f3775c.remove(this.f3775c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public JsonWriter name(String str) throws IOException {
        if (this.f3775c.isEmpty() || this.f3776d != null) {
            throw new IllegalStateException();
        } else if (m4342a() instanceof JsonObject) {
            this.f3776d = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        m4343a(new JsonPrimitive(str));
        return this;
    }

    public JsonWriter nullValue() throws IOException {
        m4343a(JsonNull.INSTANCE);
        return this;
    }

    public JsonWriter value(boolean z) throws IOException {
        m4343a(new JsonPrimitive(Boolean.valueOf(z)));
        return this;
    }

    public JsonWriter value(double d) throws IOException {
        if (isLenient() || (!Double.isNaN(d) && !Double.isInfinite(d))) {
            m4343a(new JsonPrimitive((Number) Double.valueOf(d)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d);
    }

    public JsonWriter value(long j) throws IOException {
        m4343a(new JsonPrimitive((Number) Long.valueOf(j)));
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        m4343a(new JsonPrimitive(number));
        return this;
    }

    public void flush() throws IOException {
    }

    public void close() throws IOException {
        if (!this.f3775c.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f3775c.add(f3774b);
    }
}
