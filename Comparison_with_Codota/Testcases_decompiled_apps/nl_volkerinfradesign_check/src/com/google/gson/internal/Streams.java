package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

public final class Streams {
    public static JsonElement parse(JsonReader jsonReader) throws JsonParseException {
        boolean z = true;
        try {
            jsonReader.peek();
            z = false;
            return TypeAdapters.JSON_ELEMENT.read(jsonReader);
        } catch (EOFException e) {
            if (z) {
                return JsonNull.INSTANCE;
            }
            throw new JsonSyntaxException((Throwable) e);
        } catch (MalformedJsonException e2) {
            throw new JsonSyntaxException((Throwable) e2);
        } catch (IOException e3) {
            throw new JsonIOException((Throwable) e3);
        } catch (NumberFormatException e4) {
            throw new JsonSyntaxException((Throwable) e4);
        }
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) throws IOException {
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new C0941a(appendable);
    }

    /* renamed from: com.google.gson.internal.Streams$a */
    static final class C0941a extends Writer {

        /* renamed from: a */
        private final Appendable f3753a;

        /* renamed from: b */
        private final C0942a f3754b;

        private C0941a(Appendable appendable) {
            this.f3754b = new C0942a();
            this.f3753a = appendable;
        }

        public void write(char[] cArr, int i, int i2) throws IOException {
            this.f3754b.f3755a = cArr;
            this.f3753a.append(this.f3754b, i, i + i2);
        }

        public void write(int i) throws IOException {
            this.f3753a.append((char) i);
        }

        public void flush() {
        }

        public void close() {
        }

        /* renamed from: com.google.gson.internal.Streams$a$a */
        static class C0942a implements CharSequence {

            /* renamed from: a */
            char[] f3755a;

            C0942a() {
            }

            public int length() {
                return this.f3755a.length;
            }

            public char charAt(int i) {
                return this.f3755a[i];
            }

            public CharSequence subSequence(int i, int i2) {
                return new String(this.f3755a, i, i2 - i);
            }
        }
    }
}
