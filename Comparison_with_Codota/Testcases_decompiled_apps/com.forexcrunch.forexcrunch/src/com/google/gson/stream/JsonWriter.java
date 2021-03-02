package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class JsonWriter implements Closeable, Flushable {
    private static final String[] HTML_SAFE_REPLACEMENT_CHARS = ((String[]) REPLACEMENT_CHARS.clone());
    private static final String[] REPLACEMENT_CHARS = new String[128];
    private String deferredName;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer out;
    private String separator;
    private boolean serializeNulls;
    private final List<JsonScope> stack = new ArrayList();

    static {
        for (int i = 0; i <= 31; i++) {
            REPLACEMENT_CHARS[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        REPLACEMENT_CHARS[34] = "\\\"";
        REPLACEMENT_CHARS[92] = "\\\\";
        REPLACEMENT_CHARS[9] = "\\t";
        REPLACEMENT_CHARS[8] = "\\b";
        REPLACEMENT_CHARS[10] = "\\n";
        REPLACEMENT_CHARS[13] = "\\r";
        REPLACEMENT_CHARS[12] = "\\f";
        HTML_SAFE_REPLACEMENT_CHARS[60] = "\\u003c";
        HTML_SAFE_REPLACEMENT_CHARS[62] = "\\u003e";
        HTML_SAFE_REPLACEMENT_CHARS[38] = "\\u0026";
        HTML_SAFE_REPLACEMENT_CHARS[61] = "\\u003d";
        HTML_SAFE_REPLACEMENT_CHARS[39] = "\\u0027";
    }

    public JsonWriter(Writer out2) {
        this.stack.add(JsonScope.EMPTY_DOCUMENT);
        this.separator = ":";
        this.serializeNulls = true;
        if (out2 == null) {
            throw new NullPointerException("out == null");
        }
        this.out = out2;
    }

    public final void setIndent(String indent2) {
        if (indent2.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = indent2;
        this.separator = ": ";
    }

    public final void setLenient(boolean lenient2) {
        this.lenient = lenient2;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public final void setHtmlSafe(boolean htmlSafe2) {
        this.htmlSafe = htmlSafe2;
    }

    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    public final void setSerializeNulls(boolean serializeNulls2) {
        this.serializeNulls = serializeNulls2;
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public JsonWriter beginArray() throws IOException {
        writeDeferredName();
        return open(JsonScope.EMPTY_ARRAY, "[");
    }

    public JsonWriter endArray() throws IOException {
        return close(JsonScope.EMPTY_ARRAY, JsonScope.NONEMPTY_ARRAY, "]");
    }

    public JsonWriter beginObject() throws IOException {
        writeDeferredName();
        return open(JsonScope.EMPTY_OBJECT, "{");
    }

    public JsonWriter endObject() throws IOException {
        return close(JsonScope.EMPTY_OBJECT, JsonScope.NONEMPTY_OBJECT, "}");
    }

    private JsonWriter open(JsonScope empty, String openBracket) throws IOException {
        beforeValue(true);
        this.stack.add(empty);
        this.out.write(openBracket);
        return this;
    }

    private JsonWriter close(JsonScope empty, JsonScope nonempty, String closeBracket) throws IOException {
        JsonScope context = peek();
        if (context != nonempty && context != empty) {
            throw new IllegalStateException("Nesting problem: " + this.stack);
        } else if (this.deferredName != null) {
            throw new IllegalStateException("Dangling name: " + this.deferredName);
        } else {
            this.stack.remove(this.stack.size() - 1);
            if (context == nonempty) {
                newline();
            }
            this.out.write(closeBracket);
            return this;
        }
    }

    private JsonScope peek() {
        int size = this.stack.size();
        if (size != 0) {
            return this.stack.get(size - 1);
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void replaceTop(JsonScope topOfStack) {
        this.stack.set(this.stack.size() - 1, topOfStack);
    }

    public JsonWriter name(String name) throws IOException {
        if (name == null) {
            throw new NullPointerException("name == null");
        } else if (this.deferredName != null) {
            throw new IllegalStateException();
        } else if (this.stack.isEmpty()) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.deferredName = name;
            return this;
        }
    }

    private void writeDeferredName() throws IOException {
        if (this.deferredName != null) {
            beforeName();
            string(this.deferredName);
            this.deferredName = null;
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 1 */
    public JsonWriter value(String value) throws IOException {
        if (value == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue(false);
        string(value);
        return this;
    }

    public JsonWriter nullValue() throws IOException {
        if (this.deferredName != null) {
            if (this.serializeNulls) {
                writeDeferredName();
            } else {
                this.deferredName = null;
                return this;
            }
        }
        beforeValue(false);
        this.out.write("null");
        return this;
    }

    public JsonWriter value(boolean value) throws IOException {
        writeDeferredName();
        beforeValue(false);
        this.out.write(value ? "true" : "false");
        return this;
    }

    public JsonWriter value(double value) throws IOException {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + value);
        }
        writeDeferredName();
        beforeValue(false);
        this.out.append(Double.toString(value));
        return this;
    }

    public JsonWriter value(long value) throws IOException {
        writeDeferredName();
        beforeValue(false);
        this.out.write(Long.toString(value));
        return this;
    }

    /* Debug info: failed to restart local var, previous not found, register: 4 */
    public JsonWriter value(Number value) throws IOException {
        if (value == null) {
            return nullValue();
        }
        writeDeferredName();
        String string = value.toString();
        if (this.lenient || (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN"))) {
            beforeValue(false);
            this.out.append(string);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + value);
    }

    public void flush() throws IOException {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    public void close() throws IOException {
        this.out.close();
        int size = this.stack.size();
        if (size > 1 || (size == 1 && this.stack.get(size - 1) != JsonScope.NONEMPTY_DOCUMENT)) {
            throw new IOException("Incomplete document");
        }
        this.stack.clear();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void string(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r6 = r8.htmlSafe
            if (r6 == 0) goto L_0x0024
            java.lang.String[] r5 = HTML_SAFE_REPLACEMENT_CHARS
        L_0x0006:
            java.io.Writer r6 = r8.out
            java.lang.String r7 = "\""
            r6.write(r7)
            r2 = 0
            int r3 = r9.length()
            r1 = 0
        L_0x0013:
            if (r1 >= r3) goto L_0x0045
            char r0 = r9.charAt(r1)
            r6 = 128(0x80, float:1.794E-43)
            if (r0 >= r6) goto L_0x0027
            r4 = r5[r0]
            if (r4 != 0) goto L_0x002d
        L_0x0021:
            int r1 = r1 + 1
            goto L_0x0013
        L_0x0024:
            java.lang.String[] r5 = REPLACEMENT_CHARS
            goto L_0x0006
        L_0x0027:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r0 != r6) goto L_0x003e
            java.lang.String r4 = "\\u2028"
        L_0x002d:
            if (r2 >= r1) goto L_0x0036
            java.io.Writer r6 = r8.out
            int r7 = r1 - r2
            r6.write(r9, r2, r7)
        L_0x0036:
            java.io.Writer r6 = r8.out
            r6.write(r4)
            int r2 = r1 + 1
            goto L_0x0021
        L_0x003e:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r0 != r6) goto L_0x0021
            java.lang.String r4 = "\\u2029"
            goto L_0x002d
        L_0x0045:
            if (r2 >= r3) goto L_0x004e
            java.io.Writer r6 = r8.out
            int r7 = r3 - r2
            r6.write(r9, r2, r7)
        L_0x004e:
            java.io.Writer r6 = r8.out
            java.lang.String r7 = "\""
            r6.write(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonWriter.string(java.lang.String):void");
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.out.write("\n");
            for (int i = 1; i < this.stack.size(); i++) {
                this.out.write(this.indent);
            }
        }
    }

    private void beforeName() throws IOException {
        JsonScope context = peek();
        if (context == JsonScope.NONEMPTY_OBJECT) {
            this.out.write(44);
        } else if (context != JsonScope.EMPTY_OBJECT) {
            throw new IllegalStateException("Nesting problem: " + this.stack);
        }
        newline();
        replaceTop(JsonScope.DANGLING_NAME);
    }

    private void beforeValue(boolean root) throws IOException {
        switch (peek()) {
            case NONEMPTY_DOCUMENT:
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            case EMPTY_DOCUMENT:
                break;
            case EMPTY_ARRAY:
                replaceTop(JsonScope.NONEMPTY_ARRAY);
                newline();
                return;
            case NONEMPTY_ARRAY:
                this.out.append(',');
                newline();
                return;
            case DANGLING_NAME:
                this.out.append(this.separator);
                replaceTop(JsonScope.NONEMPTY_OBJECT);
                return;
            default:
                throw new IllegalStateException("Nesting problem: " + this.stack);
        }
        if (this.lenient || root) {
            replaceTop(JsonScope.NONEMPTY_DOCUMENT);
            return;
        }
        throw new IllegalStateException("JSON must start with an array or an object.");
    }
}
