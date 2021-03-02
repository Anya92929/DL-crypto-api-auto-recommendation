package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class JsonStreamParser implements Iterator<JsonElement> {

    /* renamed from: a */
    private final JsonReader f3648a;

    /* renamed from: b */
    private final Object f3649b;

    public JsonStreamParser(String str) {
        this((Reader) new StringReader(str));
    }

    public JsonStreamParser(Reader reader) {
        this.f3648a = new JsonReader(reader);
        this.f3648a.setLenient(true);
        this.f3649b = new Object();
    }

    public JsonElement next() throws JsonParseException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return Streams.parse(this.f3648a);
        } catch (StackOverflowError e) {
            throw new JsonParseException("Failed parsing JSON source to Json", e);
        } catch (OutOfMemoryError e2) {
            throw new JsonParseException("Failed parsing JSON source to Json", e2);
        } catch (JsonParseException e3) {
            boolean z = e3.getCause() instanceof EOFException;
            Throwable th = e3;
            if (z) {
                th = new NoSuchElementException();
            }
            throw th;
        }
    }

    public boolean hasNext() {
        boolean z;
        synchronized (this.f3649b) {
            try {
                z = this.f3648a.peek() != JsonToken.END_DOCUMENT;
            } catch (MalformedJsonException e) {
                throw new JsonSyntaxException((Throwable) e);
            } catch (IOException e2) {
                throw new JsonIOException((Throwable) e2);
            }
        }
        return z;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
