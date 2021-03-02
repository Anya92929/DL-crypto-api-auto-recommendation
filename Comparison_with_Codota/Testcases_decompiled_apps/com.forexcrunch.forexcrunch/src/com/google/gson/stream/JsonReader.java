package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import com.parse.ParseException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class JsonReader implements Closeable {
    private static final String FALSE = "false";
    private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
    private static final String TRUE = "true";
    private final char[] buffer = new char[1024];
    private int bufferStartColumn = 1;
    private int bufferStartLine = 1;

    /* renamed from: in */
    private final Reader f1746in;
    private boolean lenient = false;
    private int limit = 0;
    /* access modifiers changed from: private */
    public String name;
    private int pos = 0;
    private boolean skipping;
    private JsonScope[] stack = new JsonScope[32];
    private int stackSize = 0;
    private final StringPool stringPool = new StringPool();
    /* access modifiers changed from: private */
    public JsonToken token;
    /* access modifiers changed from: private */
    public String value;
    private int valueLength;
    private int valuePos;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() {
            public void promoteNameToValue(JsonReader reader) throws IOException {
                if (reader instanceof JsonTreeReader) {
                    ((JsonTreeReader) reader).promoteNameToValue();
                    return;
                }
                reader.peek();
                if (reader.token != JsonToken.NAME) {
                    throw new IllegalStateException("Expected a name but was " + reader.peek() + " " + " at line " + reader.getLineNumber() + " column " + reader.getColumnNumber());
                }
                String unused = reader.value = reader.name;
                String unused2 = reader.name = null;
                JsonToken unused3 = reader.token = JsonToken.STRING;
            }
        };
    }

    public JsonReader(Reader in) {
        push(JsonScope.EMPTY_DOCUMENT);
        this.skipping = false;
        if (in == null) {
            throw new NullPointerException("in == null");
        }
        this.f1746in = in;
    }

    public final void setLenient(boolean lenient2) {
        this.lenient = lenient2;
    }

    public final boolean isLenient() {
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
        peek();
        if (this.token != expected) {
            throw new IllegalStateException("Expected " + expected + " but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        advance();
    }

    public boolean hasNext() throws IOException {
        peek();
        return (this.token == JsonToken.END_OBJECT || this.token == JsonToken.END_ARRAY) ? false : true;
    }

    public JsonToken peek() throws IOException {
        if (this.token != null) {
            return this.token;
        }
        switch (this.stack[this.stackSize + -1]) {
            case EMPTY_DOCUMENT:
                if (this.lenient) {
                    consumeNonExecutePrefix();
                }
                this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_DOCUMENT;
                JsonToken nextValue = nextValue();
                if (this.lenient || this.token == JsonToken.BEGIN_ARRAY || this.token == JsonToken.BEGIN_OBJECT) {
                    return nextValue;
                }
                throw new IOException("Expected JSON document to start with '[' or '{' but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
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
                if (nextNonWhitespace(false) == -1) {
                    return JsonToken.END_DOCUMENT;
                }
                this.pos--;
                if (this.lenient) {
                    return nextValue();
                }
                throw syntaxError("Expected EOF");
            case CLOSED:
                throw new IllegalStateException("JsonReader is closed");
            default:
                throw new AssertionError();
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
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
        peek();
        JsonToken result = this.token;
        this.token = null;
        this.value = null;
        this.name = null;
        return result;
    }

    public String nextName() throws IOException {
        peek();
        if (this.token != JsonToken.NAME) {
            throw new IllegalStateException("Expected a name but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        String result = this.name;
        advance();
        return result;
    }

    public String nextString() throws IOException {
        peek();
        if (this.token == JsonToken.STRING || this.token == JsonToken.NUMBER) {
            String result = this.value;
            advance();
            return result;
        }
        throw new IllegalStateException("Expected a string but was " + peek() + " at line " + getLineNumber() + " column " + getColumnNumber());
    }

    public boolean nextBoolean() throws IOException {
        peek();
        if (this.token != JsonToken.BOOLEAN) {
            throw new IllegalStateException("Expected a boolean but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        boolean result = this.value == TRUE;
        advance();
        return result;
    }

    public void nextNull() throws IOException {
        peek();
        if (this.token != JsonToken.NULL) {
            throw new IllegalStateException("Expected null but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        advance();
    }

    public double nextDouble() throws IOException {
        peek();
        if (this.token == JsonToken.STRING || this.token == JsonToken.NUMBER) {
            double result = Double.parseDouble(this.value);
            if (result >= 1.0d && this.value.startsWith("0")) {
                throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
            } else if (this.lenient || (!Double.isNaN(result) && !Double.isInfinite(result))) {
                advance();
                return result;
            } else {
                throw new MalformedJsonException("JSON forbids NaN and infinities: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
            }
        } else {
            throw new IllegalStateException("Expected a double but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
    }

    public long nextLong() throws IOException {
        long result;
        peek();
        if (this.token == JsonToken.STRING || this.token == JsonToken.NUMBER) {
            try {
                result = Long.parseLong(this.value);
            } catch (NumberFormatException e) {
                double asDouble = Double.parseDouble(this.value);
                result = (long) asDouble;
                if (((double) result) != asDouble) {
                    throw new NumberFormatException("Expected a long but was " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
                }
            }
            if (result < 1 || !this.value.startsWith("0")) {
                advance();
                return result;
            }
            throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        throw new IllegalStateException("Expected a long but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
    }

    public int nextInt() throws IOException {
        int result;
        peek();
        if (this.token == JsonToken.STRING || this.token == JsonToken.NUMBER) {
            try {
                result = Integer.parseInt(this.value);
            } catch (NumberFormatException e) {
                double asDouble = Double.parseDouble(this.value);
                result = (int) asDouble;
                if (((double) result) != asDouble) {
                    throw new NumberFormatException("Expected an int but was " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
                }
            }
            if (((long) result) < 1 || !this.value.startsWith("0")) {
                advance();
                return result;
            }
            throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + getLineNumber() + " column " + getColumnNumber());
        }
        throw new IllegalStateException("Expected an int but was " + this.token + " at line " + getLineNumber() + " column " + getColumnNumber());
    }

    public void close() throws IOException {
        this.value = null;
        this.token = null;
        this.stack[0] = JsonScope.CLOSED;
        this.stackSize = 1;
        this.f1746in.close();
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

    private void push(JsonScope newTop) {
        if (this.stackSize == this.stack.length) {
            JsonScope[] newStack = new JsonScope[(this.stackSize * 2)];
            System.arraycopy(this.stack, 0, newStack, 0, this.stackSize);
            this.stack = newStack;
        }
        JsonScope[] jsonScopeArr = this.stack;
        int i = this.stackSize;
        this.stackSize = i + 1;
        jsonScopeArr[i] = newTop;
    }

    private JsonToken nextInArray(boolean firstElement) throws IOException {
        if (firstElement) {
            this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_ARRAY;
        } else {
            switch (nextNonWhitespace(true)) {
                case 44:
                    break;
                case 59:
                    checkLenient();
                    break;
                case 93:
                    this.stackSize--;
                    JsonToken jsonToken = JsonToken.END_ARRAY;
                    this.token = jsonToken;
                    return jsonToken;
                default:
                    throw syntaxError("Unterminated array");
            }
        }
        switch (nextNonWhitespace(true)) {
            case 44:
            case 59:
                break;
            case 93:
                if (firstElement) {
                    this.stackSize--;
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
        this.value = "null";
        JsonToken jsonToken3 = JsonToken.NULL;
        this.token = jsonToken3;
        return jsonToken3;
    }

    private JsonToken nextInObject(boolean firstElement) throws IOException {
        if (firstElement) {
            switch (nextNonWhitespace(true)) {
                case ParseException.INVALID_EMAIL_ADDRESS /*125*/:
                    this.stackSize--;
                    JsonToken jsonToken = JsonToken.END_OBJECT;
                    this.token = jsonToken;
                    return jsonToken;
                default:
                    this.pos--;
                    break;
            }
        } else {
            switch (nextNonWhitespace(true)) {
                case 44:
                case 59:
                    break;
                case ParseException.INVALID_EMAIL_ADDRESS /*125*/:
                    this.stackSize--;
                    JsonToken jsonToken2 = JsonToken.END_OBJECT;
                    this.token = jsonToken2;
                    return jsonToken2;
                default:
                    throw syntaxError("Unterminated object");
            }
        }
        int quote = nextNonWhitespace(true);
        switch (quote) {
            case 34:
                break;
            case 39:
                checkLenient();
                break;
            default:
                checkLenient();
                this.pos--;
                this.name = nextLiteral(false);
                if (this.name.length() == 0) {
                    throw syntaxError("Expected name");
                }
                break;
        }
        this.name = nextString((char) quote);
        this.stack[this.stackSize - 1] = JsonScope.DANGLING_NAME;
        JsonToken jsonToken3 = JsonToken.NAME;
        this.token = jsonToken3;
        return jsonToken3;
    }

    private JsonToken objectValue() throws IOException {
        switch (nextNonWhitespace(true)) {
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
        this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_OBJECT;
        return nextValue();
    }

    private JsonToken nextValue() throws IOException {
        int c = nextNonWhitespace(true);
        switch (c) {
            case 34:
                break;
            case 39:
                checkLenient();
                break;
            case 91:
                push(JsonScope.EMPTY_ARRAY);
                JsonToken jsonToken = JsonToken.BEGIN_ARRAY;
                this.token = jsonToken;
                return jsonToken;
            case ParseException.INVALID_ACL /*123*/:
                push(JsonScope.EMPTY_OBJECT);
                JsonToken jsonToken2 = JsonToken.BEGIN_OBJECT;
                this.token = jsonToken2;
                return jsonToken2;
            default:
                this.pos--;
                return readLiteral();
        }
        this.value = nextString((char) c);
        JsonToken jsonToken3 = JsonToken.STRING;
        this.token = jsonToken3;
        return jsonToken3;
    }

    private boolean fillBuffer(int minimum) throws IOException {
        char[] buffer2 = this.buffer;
        int line = this.bufferStartLine;
        int column = this.bufferStartColumn;
        int p = this.pos;
        for (int i = 0; i < p; i++) {
            if (buffer2[i] == 10) {
                line++;
                column = 1;
            } else {
                column++;
            }
        }
        this.bufferStartLine = line;
        this.bufferStartColumn = column;
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(buffer2, this.pos, buffer2, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            int total = this.f1746in.read(buffer2, this.limit, buffer2.length - this.limit);
            if (total == -1) {
                return false;
            }
            this.limit += total;
            if (this.bufferStartLine == 1 && this.bufferStartColumn == 1 && this.limit > 0 && buffer2[0] == 65279) {
                this.pos++;
                this.bufferStartColumn--;
            }
        } while (this.limit < minimum);
        return true;
    }

    /* access modifiers changed from: private */
    public int getLineNumber() {
        int result = this.bufferStartLine;
        for (int i = 0; i < this.pos; i++) {
            if (this.buffer[i] == 10) {
                result++;
            }
        }
        return result;
    }

    /* access modifiers changed from: private */
    public int getColumnNumber() {
        int result = this.bufferStartColumn;
        for (int i = 0; i < this.pos; i++) {
            if (this.buffer[i] == 10) {
                result = 1;
            } else {
                result++;
            }
        }
        return result;
    }

    private int nextNonWhitespace(boolean throwOnEof) throws IOException {
        char[] buffer2 = this.buffer;
        int p = this.pos;
        int l = this.limit;
        while (true) {
            if (p == l) {
                this.pos = p;
                if (fillBuffer(1)) {
                    p = this.pos;
                    l = this.limit;
                } else if (!throwOnEof) {
                    return -1;
                } else {
                    throw new EOFException("End of input at line " + getLineNumber() + " column " + getColumnNumber());
                }
            }
            int p2 = p + 1;
            char c = buffer2[p];
            switch (c) {
                case 9:
                case 10:
                case 13:
                case ' ':
                    p = p2;
                    break;
                case '#':
                    this.pos = p2;
                    checkLenient();
                    skipToEndOfLine();
                    p = this.pos;
                    l = this.limit;
                    break;
                case '/':
                    this.pos = p2;
                    if (p2 == l) {
                        this.pos--;
                        boolean charsLoaded = fillBuffer(2);
                        this.pos++;
                        if (!charsLoaded) {
                            int i = p2;
                            return c;
                        }
                    }
                    checkLenient();
                    switch (buffer2[this.pos]) {
                        case '*':
                            this.pos++;
                            if (skipTo("*/")) {
                                p = this.pos + 2;
                                l = this.limit;
                                break;
                            } else {
                                throw syntaxError("Unterminated comment");
                            }
                        case '/':
                            this.pos++;
                            skipToEndOfLine();
                            p = this.pos;
                            l = this.limit;
                            break;
                        default:
                            int i2 = p2;
                            return c;
                    }
                default:
                    this.pos = p2;
                    int i3 = p2;
                    return c;
            }
        }
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
            if (this.pos + toFind.length() > this.limit && !fillBuffer(toFind.length())) {
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
        char[] buffer2 = this.buffer;
        StringBuilder builder = null;
        do {
            int p = this.pos;
            int l = this.limit;
            int start = p;
            int p2 = p;
            while (p2 < l) {
                int p3 = p2 + 1;
                char c = buffer2[p2];
                if (c == quote) {
                    this.pos = p3;
                    if (this.skipping) {
                        return "skipped!";
                    }
                    if (builder == null) {
                        return this.stringPool.get(buffer2, start, (p3 - start) - 1);
                    }
                    builder.append(buffer2, start, (p3 - start) - 1);
                    return builder.toString();
                }
                if (c == '\\') {
                    this.pos = p3;
                    if (builder == null) {
                        builder = new StringBuilder();
                    }
                    builder.append(buffer2, start, (p3 - start) - 1);
                    builder.append(readEscapeCharacter());
                    p3 = this.pos;
                    l = this.limit;
                    start = p3;
                }
                p2 = p3;
            }
            if (builder == null) {
                builder = new StringBuilder();
            }
            builder.append(buffer2, start, p2 - start);
            this.pos = p2;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    private String nextLiteral(boolean assignOffsetsOnly) throws IOException {
        String result;
        StringBuilder builder = null;
        this.valuePos = -1;
        this.valueLength = 0;
        int i = 0;
        while (true) {
            if (this.pos + i < this.limit) {
                switch (this.buffer[this.pos + i]) {
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case ParseException.INVALID_ACL /*123*/:
                    case ParseException.INVALID_EMAIL_ADDRESS /*125*/:
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        checkLenient();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.buffer.length) {
                if (builder == null) {
                    builder = new StringBuilder();
                }
                builder.append(this.buffer, this.pos, i);
                this.valueLength += i;
                this.pos += i;
                i = 0;
                if (!fillBuffer(1)) {
                }
            } else if (!fillBuffer(i + 1)) {
                this.buffer[this.limit] = 0;
            }
        }
        if (assignOffsetsOnly && builder == null) {
            this.valuePos = this.pos;
            result = null;
        } else if (this.skipping) {
            result = "skipped!";
        } else if (builder == null) {
            result = this.stringPool.get(this.buffer, this.pos, i);
        } else {
            builder.append(this.buffer, this.pos, i);
            result = builder.toString();
        }
        this.valueLength += i;
        this.pos += i;
        return result;
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + getLineNumber() + " column " + getColumnNumber();
    }

    private char readEscapeCharacter() throws IOException {
        int i;
        if (this.pos != this.limit || fillBuffer(1)) {
            char[] cArr = this.buffer;
            int i2 = this.pos;
            this.pos = i2 + 1;
            char escaped = cArr[i2];
            switch (escaped) {
                case 'b':
                    return 8;
                case 'f':
                    return 12;
                case 'n':
                    return 10;
                case 'r':
                    return 13;
                case ParseException.OBJECT_TOO_LARGE /*116*/:
                    return 9;
                case 'u':
                    if (this.pos + 4 <= this.limit || fillBuffer(4)) {
                        char result = 0;
                        int i3 = this.pos;
                        int end = i3 + 4;
                        while (i3 < end) {
                            char c = this.buffer[i3];
                            char result2 = (char) (result << 4);
                            if (c >= '0' && c <= '9') {
                                i = c - '0';
                            } else if (c >= 'a' && c <= 'f') {
                                i = (c - 'a') + 10;
                            } else if (c < 'A' || c > 'F') {
                                throw new NumberFormatException("\\u" + this.stringPool.get(this.buffer, this.pos, 4));
                            } else {
                                i = (c - 'A') + 10;
                            }
                            result = (char) (i + result2);
                            i3++;
                        }
                        this.pos += 4;
                        return result;
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
        this.value = nextLiteral(true);
        if (this.valueLength == 0) {
            throw syntaxError("Expected literal value");
        }
        this.token = decodeLiteral();
        if (this.token == JsonToken.STRING) {
            checkLenient();
        }
        return this.token;
    }

    private JsonToken decodeLiteral() throws IOException {
        if (this.valuePos == -1) {
            return JsonToken.STRING;
        }
        if (this.valueLength == 4 && (('n' == this.buffer[this.valuePos] || 'N' == this.buffer[this.valuePos]) && (('u' == this.buffer[this.valuePos + 1] || 'U' == this.buffer[this.valuePos + 1]) && (('l' == this.buffer[this.valuePos + 2] || 'L' == this.buffer[this.valuePos + 2]) && ('l' == this.buffer[this.valuePos + 3] || 'L' == this.buffer[this.valuePos + 3]))))) {
            this.value = "null";
            return JsonToken.NULL;
        } else if (this.valueLength == 4 && (('t' == this.buffer[this.valuePos] || 'T' == this.buffer[this.valuePos]) && (('r' == this.buffer[this.valuePos + 1] || 'R' == this.buffer[this.valuePos + 1]) && (('u' == this.buffer[this.valuePos + 2] || 'U' == this.buffer[this.valuePos + 2]) && ('e' == this.buffer[this.valuePos + 3] || 'E' == this.buffer[this.valuePos + 3]))))) {
            this.value = TRUE;
            return JsonToken.BOOLEAN;
        } else if (this.valueLength == 5 && (('f' == this.buffer[this.valuePos] || 'F' == this.buffer[this.valuePos]) && (('a' == this.buffer[this.valuePos + 1] || 'A' == this.buffer[this.valuePos + 1]) && (('l' == this.buffer[this.valuePos + 2] || 'L' == this.buffer[this.valuePos + 2]) && (('s' == this.buffer[this.valuePos + 3] || 'S' == this.buffer[this.valuePos + 3]) && ('e' == this.buffer[this.valuePos + 4] || 'E' == this.buffer[this.valuePos + 4])))))) {
            this.value = FALSE;
            return JsonToken.BOOLEAN;
        } else {
            this.value = this.stringPool.get(this.buffer, this.valuePos, this.valueLength);
            return decodeNumber(this.buffer, this.valuePos, this.valueLength);
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r0v0, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r0v11, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r0v12, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r0v13, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r0v15, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r0v16, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r0v17, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r0v2, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r0v4, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r0v7, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r0v9, types: [char] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.gson.stream.JsonToken decodeNumber(char[] r7, int r8, int r9) {
        /*
            r6 = this;
            r5 = 45
            r4 = 57
            r3 = 48
            r1 = r8
            char r0 = r7[r1]
            if (r0 != r5) goto L_0x000f
            int r1 = r1 + 1
            char r0 = r7[r1]
        L_0x000f:
            if (r0 != r3) goto L_0x0026
            int r1 = r1 + 1
            char r0 = r7[r1]
        L_0x0015:
            r2 = 46
            if (r0 != r2) goto L_0x003c
            int r1 = r1 + 1
            char r0 = r7[r1]
        L_0x001d:
            if (r0 < r3) goto L_0x003c
            if (r0 > r4) goto L_0x003c
            int r1 = r1 + 1
            char r0 = r7[r1]
            goto L_0x001d
        L_0x0026:
            r2 = 49
            if (r0 < r2) goto L_0x0039
            if (r0 > r4) goto L_0x0039
            int r1 = r1 + 1
            char r0 = r7[r1]
        L_0x0030:
            if (r0 < r3) goto L_0x0015
            if (r0 > r4) goto L_0x0015
            int r1 = r1 + 1
            char r0 = r7[r1]
            goto L_0x0030
        L_0x0039:
            com.google.gson.stream.JsonToken r2 = com.google.gson.stream.JsonToken.STRING
        L_0x003b:
            return r2
        L_0x003c:
            r2 = 101(0x65, float:1.42E-43)
            if (r0 == r2) goto L_0x0044
            r2 = 69
            if (r0 != r2) goto L_0x0066
        L_0x0044:
            int r1 = r1 + 1
            char r0 = r7[r1]
            r2 = 43
            if (r0 == r2) goto L_0x004e
            if (r0 != r5) goto L_0x0052
        L_0x004e:
            int r1 = r1 + 1
            char r0 = r7[r1]
        L_0x0052:
            if (r0 < r3) goto L_0x0063
            if (r0 > r4) goto L_0x0063
            int r1 = r1 + 1
            char r0 = r7[r1]
        L_0x005a:
            if (r0 < r3) goto L_0x0066
            if (r0 > r4) goto L_0x0066
            int r1 = r1 + 1
            char r0 = r7[r1]
            goto L_0x005a
        L_0x0063:
            com.google.gson.stream.JsonToken r2 = com.google.gson.stream.JsonToken.STRING
            goto L_0x003b
        L_0x0066:
            int r2 = r8 + r9
            if (r1 != r2) goto L_0x006d
            com.google.gson.stream.JsonToken r2 = com.google.gson.stream.JsonToken.NUMBER
            goto L_0x003b
        L_0x006d:
            com.google.gson.stream.JsonToken r2 = com.google.gson.stream.JsonToken.STRING
            goto L_0x003b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.decodeNumber(char[], int, int):com.google.gson.stream.JsonToken");
    }

    private IOException syntaxError(String message) throws IOException {
        throw new MalformedJsonException(message + " at line " + getLineNumber() + " column " + getColumnNumber());
    }
}
