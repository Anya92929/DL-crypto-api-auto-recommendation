package com.google.gson.stream;

import com.google.android.gms.location.LocationRequest;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public final class JsonReader implements Closeable {
    private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
    private final char[] buffer = new char[1024];
    private boolean hasToken;

    /* renamed from: in */
    private final Reader f1948in;
    private boolean lenient = false;
    private int limit = 0;
    private String name;
    private int pos = 0;
    private boolean skipping;
    private final List<JsonScope> stack = new ArrayList();
    private JsonToken token;
    private String value;

    public JsonReader(Reader in) {
        push(JsonScope.EMPTY_DOCUMENT);
        this.skipping = false;
        if (in == null) {
            throw new NullPointerException("in == null");
        }
        this.f1948in = in;
    }

    public void setLenient(boolean lenient2) {
        this.lenient = lenient2;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public void beginArray() throws IOException {
        expect(JsonToken.BEGIN_ARRAY);
    }

    public void endArray() throws IOException {
        expect(JsonToken.END_ARRAY);
    }

    public void beginObject() throws IOException {
        expect(JsonToken.BEGIN_OBJECT);
    }

    public void endObject() throws IOException {
        expect(JsonToken.END_OBJECT);
    }

    private void expect(JsonToken expected) throws IOException {
        quickPeek();
        if (this.token != expected) {
            throw new IllegalStateException("Expected " + expected + " but was " + peek());
        }
        advance();
    }

    public boolean hasNext() throws IOException {
        quickPeek();
        return (this.token == JsonToken.END_OBJECT || this.token == JsonToken.END_ARRAY) ? false : true;
    }

    public JsonToken peek() throws IOException {
        quickPeek();
        if (this.token == null) {
            decodeLiteral();
        }
        return this.token;
    }

    private JsonToken quickPeek() throws IOException {
        if (this.hasToken) {
            return this.token;
        }
        switch (peekStack()) {
            case EMPTY_DOCUMENT:
                if (this.lenient) {
                    consumeNonExecutePrefix();
                }
                replaceTop(JsonScope.NONEMPTY_DOCUMENT);
                JsonToken firstToken = nextValue();
                if (this.lenient || firstToken == JsonToken.BEGIN_ARRAY || firstToken == JsonToken.BEGIN_OBJECT) {
                    return firstToken;
                }
                syntaxError("Expected JSON document to start with '[' or '{'");
                return firstToken;
            case EMPTY_ARRAY:
                return nextInArray(true);
            case NONEMPTY_ARRAY:
                return nextInArray(false);
            case EMPTY_OBJECT:
                return nextInObject(true);
            case DANGLING_NAME:
                return objectValue();
            case NONEMPTY_OBJECT:
                return nextInObject(false);
            case NONEMPTY_DOCUMENT:
                try {
                    JsonToken token2 = nextValue();
                    if (this.lenient) {
                        return token2;
                    }
                    throw syntaxError("Expected EOF");
                } catch (EOFException e) {
                    this.hasToken = true;
                    JsonToken jsonToken = JsonToken.END_DOCUMENT;
                    this.token = jsonToken;
                    return jsonToken;
                }
            case CLOSED:
                throw new IllegalStateException("JsonReader is closed");
            default:
                throw new AssertionError();
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace();
        this.pos--;
        if (this.pos + NON_EXECUTE_PREFIX.length <= this.limit || fillBuffer(NON_EXECUTE_PREFIX.length)) {
            int i = 0;
            while (i < NON_EXECUTE_PREFIX.length) {
                if (this.buffer[this.pos + i] == NON_EXECUTE_PREFIX[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.pos += NON_EXECUTE_PREFIX.length;
        }
    }

    private JsonToken advance() throws IOException {
        quickPeek();
        JsonToken result = this.token;
        this.hasToken = false;
        this.token = null;
        this.value = null;
        this.name = null;
        return result;
    }

    public String nextName() throws IOException {
        quickPeek();
        if (this.token != JsonToken.NAME) {
            throw new IllegalStateException("Expected a name but was " + peek());
        }
        String result = this.name;
        advance();
        return result;
    }

    public String nextString() throws IOException {
        peek();
        if (this.value == null || !(this.token == JsonToken.STRING || this.token == JsonToken.NUMBER)) {
            throw new IllegalStateException("Expected a string but was " + peek());
        }
        String result = this.value;
        advance();
        return result;
    }

    public boolean nextBoolean() throws IOException {
        boolean result;
        quickPeek();
        if (this.value == null || this.token == JsonToken.STRING) {
            throw new IllegalStateException("Expected a boolean but was " + peek());
        }
        if (this.value.equalsIgnoreCase("true")) {
            result = true;
        } else if (this.value.equalsIgnoreCase("false")) {
            result = false;
        } else {
            throw new IllegalStateException("Not a boolean: " + this.value);
        }
        advance();
        return result;
    }

    public void nextNull() throws IOException {
        quickPeek();
        if (this.value == null || this.token == JsonToken.STRING) {
            throw new IllegalStateException("Expected null but was " + peek());
        } else if (!this.value.equalsIgnoreCase("null")) {
            throw new IllegalStateException("Not a null: " + this.value);
        } else {
            advance();
        }
    }

    public double nextDouble() throws IOException {
        quickPeek();
        if (this.value == null) {
            throw new IllegalStateException("Expected a double but was " + peek());
        }
        double result = Double.parseDouble(this.value);
        if (result >= 1.0d && this.value.startsWith("0")) {
            throw new NumberFormatException("JSON forbids octal prefixes: " + this.value);
        } else if (this.lenient || (!Double.isNaN(result) && !Double.isInfinite(result))) {
            advance();
            return result;
        } else {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + this.value);
        }
    }

    public long nextLong() throws IOException {
        long result;
        quickPeek();
        if (this.value == null) {
            throw new IllegalStateException("Expected a long but was " + peek());
        }
        try {
            result = Long.parseLong(this.value);
        } catch (NumberFormatException e) {
            double asDouble = Double.parseDouble(this.value);
            result = (long) asDouble;
            if (((double) result) != asDouble) {
                throw new NumberFormatException(this.value);
            }
        }
        if (result < 1 || !this.value.startsWith("0")) {
            advance();
            return result;
        }
        throw new NumberFormatException("JSON forbids octal prefixes: " + this.value);
    }

    public int nextInt() throws IOException {
        int result;
        quickPeek();
        if (this.value == null) {
            throw new IllegalStateException("Expected an int but was " + peek());
        }
        try {
            result = Integer.parseInt(this.value);
        } catch (NumberFormatException e) {
            double asDouble = Double.parseDouble(this.value);
            result = (int) asDouble;
            if (((double) result) != asDouble) {
                throw new NumberFormatException(this.value);
            }
        }
        if (((long) result) < 1 || !this.value.startsWith("0")) {
            advance();
            return result;
        }
        throw new NumberFormatException("JSON forbids octal prefixes: " + this.value);
    }

    public void close() throws IOException {
        this.hasToken = false;
        this.value = null;
        this.token = null;
        this.stack.clear();
        this.stack.add(JsonScope.CLOSED);
        this.f1948in.close();
    }

    public void skipValue() throws IOException {
        this.skipping = true;
        int count = 0;
        do {
            try {
                JsonToken token2 = advance();
                if (token2 == JsonToken.BEGIN_ARRAY || token2 == JsonToken.BEGIN_OBJECT) {
                    count++;
                    continue;
                } else if (token2 == JsonToken.END_ARRAY || token2 == JsonToken.END_OBJECT) {
                    count--;
                    continue;
                }
            } finally {
                this.skipping = false;
            }
        } while (count != 0);
    }

    private JsonScope peekStack() {
        return this.stack.get(this.stack.size() - 1);
    }

    private JsonScope pop() {
        return this.stack.remove(this.stack.size() - 1);
    }

    private void push(JsonScope newTop) {
        this.stack.add(newTop);
    }

    private void replaceTop(JsonScope newTop) {
        this.stack.set(this.stack.size() - 1, newTop);
    }

    private JsonToken nextInArray(boolean firstElement) throws IOException {
        if (firstElement) {
            replaceTop(JsonScope.NONEMPTY_ARRAY);
        } else {
            switch (nextNonWhitespace()) {
                case 44:
                    break;
                case 59:
                    checkLenient();
                    break;
                case 93:
                    pop();
                    this.hasToken = true;
                    JsonToken jsonToken = JsonToken.END_ARRAY;
                    this.token = jsonToken;
                    return jsonToken;
                default:
                    throw syntaxError("Unterminated array");
            }
        }
        switch (nextNonWhitespace()) {
            case 44:
            case 59:
                break;
            case 93:
                if (firstElement) {
                    pop();
                    this.hasToken = true;
                    JsonToken jsonToken2 = JsonToken.END_ARRAY;
                    this.token = jsonToken2;
                    return jsonToken2;
                }
                break;
            default:
                this.pos--;
                return nextValue();
        }
        checkLenient();
        this.pos--;
        this.hasToken = true;
        this.value = "null";
        JsonToken jsonToken3 = JsonToken.NULL;
        this.token = jsonToken3;
        return jsonToken3;
    }

    private JsonToken nextInObject(boolean firstElement) throws IOException {
        if (firstElement) {
            switch (nextNonWhitespace()) {
                case 125:
                    pop();
                    this.hasToken = true;
                    JsonToken jsonToken = JsonToken.END_OBJECT;
                    this.token = jsonToken;
                    return jsonToken;
                default:
                    this.pos--;
                    break;
            }
        } else {
            switch (nextNonWhitespace()) {
                case 44:
                case 59:
                    break;
                case 125:
                    pop();
                    this.hasToken = true;
                    JsonToken jsonToken2 = JsonToken.END_OBJECT;
                    this.token = jsonToken2;
                    return jsonToken2;
                default:
                    throw syntaxError("Unterminated object");
            }
        }
        int quote = nextNonWhitespace();
        switch (quote) {
            case 34:
                break;
            case 39:
                checkLenient();
                break;
            default:
                checkLenient();
                this.pos--;
                this.name = nextLiteral();
                if (this.name.length() == 0) {
                    throw syntaxError("Expected name");
                }
                break;
        }
        this.name = nextString((char) quote);
        replaceTop(JsonScope.DANGLING_NAME);
        this.hasToken = true;
        JsonToken jsonToken3 = JsonToken.NAME;
        this.token = jsonToken3;
        return jsonToken3;
    }

    private JsonToken objectValue() throws IOException {
        switch (nextNonWhitespace()) {
            case 58:
                break;
            case 61:
                checkLenient();
                if ((this.pos < this.limit || fillBuffer(1)) && this.buffer[this.pos] == '>') {
                    this.pos++;
                    break;
                }
            default:
                throw syntaxError("Expected ':'");
        }
        replaceTop(JsonScope.NONEMPTY_OBJECT);
        return nextValue();
    }

    private JsonToken nextValue() throws IOException {
        int c = nextNonWhitespace();
        switch (c) {
            case 34:
                break;
            case 39:
                checkLenient();
                break;
            case 91:
                push(JsonScope.EMPTY_ARRAY);
                this.hasToken = true;
                JsonToken jsonToken = JsonToken.BEGIN_ARRAY;
                this.token = jsonToken;
                return jsonToken;
            case 123:
                push(JsonScope.EMPTY_OBJECT);
                this.hasToken = true;
                JsonToken jsonToken2 = JsonToken.BEGIN_OBJECT;
                this.token = jsonToken2;
                return jsonToken2;
            default:
                this.pos--;
                return readLiteral();
        }
        this.value = nextString((char) c);
        this.hasToken = true;
        JsonToken jsonToken3 = JsonToken.STRING;
        this.token = jsonToken3;
        return jsonToken3;
    }

    private boolean fillBuffer(int minimum) throws IOException {
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(this.buffer, this.pos, this.buffer, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            int total = this.f1948in.read(this.buffer, this.limit, this.buffer.length - this.limit);
            if (total == -1) {
                return false;
            }
            this.limit += total;
        } while (this.limit < minimum);
        return true;
    }

    private int nextNonWhitespace() throws IOException {
        char c;
        while (true) {
            if (this.pos < this.limit || fillBuffer(1)) {
                char[] cArr = this.buffer;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                switch (c) {
                    case 9:
                    case 10:
                    case 13:
                    case ' ':
                        break;
                    case '#':
                        checkLenient();
                        skipToEndOfLine();
                        continue;
                    case '/':
                        if (this.pos == this.limit && !fillBuffer(1)) {
                            break;
                        } else {
                            checkLenient();
                            switch (this.buffer[this.pos]) {
                                case '*':
                                    this.pos++;
                                    if (!skipTo("*/")) {
                                        throw syntaxError("Unterminated comment");
                                    }
                                    this.pos += 2;
                                    continue;
                                    continue;
                                case '/':
                                    this.pos++;
                                    skipToEndOfLine();
                                    continue;
                            }
                        }
                        break;
                }
            } else {
                throw new EOFException("End of input");
            }
        }
        return c;
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x000d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void skipToEndOfLine() throws java.io.IOException {
        /*
            r4 = this;
        L_0x0000:
            int r1 = r4.pos
            int r2 = r4.limit
            if (r1 < r2) goto L_0x000d
            r1 = 1
            boolean r1 = r4.fillBuffer(r1)
            if (r1 == 0) goto L_0x001f
        L_0x000d:
            char[] r1 = r4.buffer
            int r2 = r4.pos
            int r3 = r2 + 1
            r4.pos = r3
            char r0 = r1[r2]
            r1 = 13
            if (r0 == r1) goto L_0x001f
            r1 = 10
            if (r0 != r1) goto L_0x0000
        L_0x001f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.skipToEndOfLine():void");
    }

    private boolean skipTo(String toFind) throws IOException {
        while (true) {
            if (this.pos + toFind.length() >= this.limit && !fillBuffer(toFind.length())) {
                return false;
            }
            int c = 0;
            while (c < toFind.length()) {
                if (this.buffer[this.pos + c] != toFind.charAt(c)) {
                    this.pos++;
                } else {
                    c++;
                }
            }
            return true;
        }
    }

    private String nextString(char quote) throws IOException {
        StringBuilder builder = null;
        do {
            int start = this.pos;
            while (this.pos < this.limit) {
                char[] cArr = this.buffer;
                int i = this.pos;
                this.pos = i + 1;
                char c = cArr[i];
                if (c == quote) {
                    if (this.skipping) {
                        return "skipped!";
                    }
                    if (builder == null) {
                        return new String(this.buffer, start, (this.pos - start) - 1);
                    }
                    builder.append(this.buffer, start, (this.pos - start) - 1);
                    return builder.toString();
                } else if (c == '\\') {
                    if (builder == null) {
                        builder = new StringBuilder();
                    }
                    builder.append(this.buffer, start, (this.pos - start) - 1);
                    builder.append(readEscapeCharacter());
                    start = this.pos;
                }
            }
            if (builder == null) {
                builder = new StringBuilder();
            }
            builder.append(this.buffer, start, this.pos - start);
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    private String nextLiteral() throws IOException {
        StringBuilder builder = null;
        do {
            int start = this.pos;
            while (this.pos < this.limit) {
                char[] cArr = this.buffer;
                int i = this.pos;
                this.pos = i + 1;
                switch (cArr[i]) {
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        checkLenient();
                        break;
                }
                this.pos--;
                if (this.skipping) {
                    return "skipped!";
                }
                if (builder == null) {
                    return new String(this.buffer, start, this.pos - start);
                }
                builder.append(this.buffer, start, this.pos - start);
                return builder.toString();
            }
            if (builder == null) {
                builder = new StringBuilder();
            }
            builder.append(this.buffer, start, this.pos - start);
        } while (fillBuffer(1));
        return builder.toString();
    }

    public String toString() {
        return getClass().getSimpleName() + " near " + getSnippet();
    }

    private char readEscapeCharacter() throws IOException {
        if (this.pos != this.limit || fillBuffer(1)) {
            char[] cArr = this.buffer;
            int i = this.pos;
            this.pos = i + 1;
            char escaped = cArr[i];
            switch (escaped) {
                case 'b':
                    return 8;
                case LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY:
                    return 12;
                case 'n':
                    return 10;
                case 'r':
                    return 13;
                case 't':
                    return 9;
                case 'u':
                    if (this.pos + 4 <= this.limit || fillBuffer(4)) {
                        String hex = new String(this.buffer, this.pos, 4);
                        this.pos += 4;
                        return (char) Integer.parseInt(hex, 16);
                    }
                    throw syntaxError("Unterminated escape sequence");
                default:
                    return escaped;
            }
        } else {
            throw syntaxError("Unterminated escape sequence");
        }
    }

    private JsonToken readLiteral() throws IOException {
        String literal = nextLiteral();
        if (literal.length() == 0) {
            throw syntaxError("Expected literal value");
        }
        this.value = literal;
        this.hasToken = true;
        this.token = null;
        return null;
    }

    private void decodeLiteral() throws IOException {
        if (this.value.equalsIgnoreCase("null")) {
            this.token = JsonToken.NULL;
        } else if (this.value.equalsIgnoreCase("true") || this.value.equalsIgnoreCase("false")) {
            this.token = JsonToken.BOOLEAN;
        } else {
            try {
                Double.parseDouble(this.value);
                this.token = JsonToken.NUMBER;
            } catch (NumberFormatException e) {
                throw syntaxError("invalid number or unquoted string");
            }
        }
    }

    private IOException syntaxError(String message) throws IOException {
        throw new MalformedJsonException(message + " near " + getSnippet());
    }

    private CharSequence getSnippet() {
        StringBuilder snippet = new StringBuilder();
        int beforePos = Math.min(this.pos, 20);
        snippet.append(this.buffer, this.pos - beforePos, beforePos);
        snippet.append(this.buffer, this.pos, Math.min(this.limit - this.pos, 20));
        return snippet;
    }
}
