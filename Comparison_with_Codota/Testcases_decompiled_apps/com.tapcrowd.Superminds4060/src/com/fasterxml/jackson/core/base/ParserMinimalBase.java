package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.p003io.NumberInput;
import com.fasterxml.jackson.core.util.VersionUtil;
import java.io.IOException;

public abstract class ParserMinimalBase extends JsonParser {
    protected static final int INT_APOSTROPHE = 39;
    protected static final int INT_ASTERISK = 42;
    protected static final int INT_BACKSLASH = 92;
    protected static final int INT_COLON = 58;
    protected static final int INT_COMMA = 44;
    protected static final int INT_CR = 13;
    protected static final int INT_LBRACKET = 91;
    protected static final int INT_LCURLY = 123;
    protected static final int INT_LF = 10;
    protected static final int INT_QUOTE = 34;
    protected static final int INT_RBRACKET = 93;
    protected static final int INT_RCURLY = 125;
    protected static final int INT_SLASH = 47;
    protected static final int INT_SPACE = 32;
    protected static final int INT_TAB = 9;
    protected static final int INT_b = 98;
    protected static final int INT_f = 102;
    protected static final int INT_n = 110;
    protected static final int INT_r = 114;
    protected static final int INT_t = 116;
    protected static final int INT_u = 117;
    protected JsonToken _currToken;
    protected JsonToken _lastClearedToken;

    /* access modifiers changed from: protected */
    public abstract void _handleEOF() throws JsonParseException;

    public abstract void close() throws IOException;

    public abstract byte[] getBinaryValue(Base64Variant base64Variant) throws IOException, JsonParseException;

    public abstract String getCurrentName() throws IOException, JsonParseException;

    public abstract JsonStreamContext getParsingContext();

    public abstract String getText() throws IOException, JsonParseException;

    public abstract char[] getTextCharacters() throws IOException, JsonParseException;

    public abstract int getTextLength() throws IOException, JsonParseException;

    public abstract int getTextOffset() throws IOException, JsonParseException;

    public abstract boolean hasTextCharacters();

    public abstract boolean isClosed();

    public abstract JsonToken nextToken() throws IOException, JsonParseException;

    public abstract void overrideCurrentName(String str);

    protected ParserMinimalBase() {
    }

    protected ParserMinimalBase(int features) {
        super(features);
    }

    public Version version() {
        return VersionUtil.versionFor(getClass());
    }

    public JsonToken getCurrentToken() {
        return this._currToken;
    }

    public boolean hasCurrentToken() {
        return this._currToken != null;
    }

    public JsonToken nextValue() throws IOException, JsonParseException {
        JsonToken t = nextToken();
        if (t == JsonToken.FIELD_NAME) {
            return nextToken();
        }
        return t;
    }

    public JsonParser skipChildren() throws IOException, JsonParseException {
        if (this._currToken == JsonToken.START_OBJECT || this._currToken == JsonToken.START_ARRAY) {
            int open = 1;
            while (true) {
                JsonToken t = nextToken();
                if (t == null) {
                    _handleEOF();
                } else {
                    switch (t) {
                        case START_OBJECT:
                        case START_ARRAY:
                            open++;
                            continue;
                        case END_OBJECT:
                        case END_ARRAY:
                            open--;
                            if (open == 0) {
                                break;
                            } else {
                                continue;
                            }
                    }
                }
            }
        }
        return this;
    }

    public void clearCurrentToken() {
        if (this._currToken != null) {
            this._lastClearedToken = this._currToken;
            this._currToken = null;
        }
    }

    public JsonToken getLastClearedToken() {
        return this._lastClearedToken;
    }

    public boolean getValueAsBoolean(boolean defaultValue) throws IOException, JsonParseException {
        if (this._currToken != null) {
            switch (this._currToken) {
                case VALUE_NUMBER_INT:
                    if (getIntValue() == 0) {
                        return false;
                    }
                    return true;
                case VALUE_TRUE:
                    return true;
                case VALUE_FALSE:
                case VALUE_NULL:
                    return false;
                case VALUE_EMBEDDED_OBJECT:
                    Object value = getEmbeddedObject();
                    if (value instanceof Boolean) {
                        return ((Boolean) value).booleanValue();
                    }
                    break;
                case VALUE_STRING:
                    break;
            }
            if ("true".equals(getText().trim())) {
                return true;
            }
        }
        return defaultValue;
    }

    public int getValueAsInt(int defaultValue) throws IOException, JsonParseException {
        if (this._currToken == null) {
            return defaultValue;
        }
        switch (this._currToken) {
            case VALUE_NUMBER_INT:
            case VALUE_NUMBER_FLOAT:
                return getIntValue();
            case VALUE_TRUE:
                return 1;
            case VALUE_FALSE:
            case VALUE_NULL:
                return 0;
            case VALUE_EMBEDDED_OBJECT:
                Object value = getEmbeddedObject();
                if (value instanceof Number) {
                    return ((Number) value).intValue();
                }
                return defaultValue;
            case VALUE_STRING:
                return NumberInput.parseAsInt(getText(), defaultValue);
            default:
                return defaultValue;
        }
    }

    public long getValueAsLong(long defaultValue) throws IOException, JsonParseException {
        if (this._currToken == null) {
            return defaultValue;
        }
        switch (this._currToken) {
            case VALUE_NUMBER_INT:
            case VALUE_NUMBER_FLOAT:
                return getLongValue();
            case VALUE_TRUE:
                return 1;
            case VALUE_FALSE:
            case VALUE_NULL:
                return 0;
            case VALUE_EMBEDDED_OBJECT:
                Object value = getEmbeddedObject();
                if (value instanceof Number) {
                    return ((Number) value).longValue();
                }
                return defaultValue;
            case VALUE_STRING:
                return NumberInput.parseAsLong(getText(), defaultValue);
            default:
                return defaultValue;
        }
    }

    public double getValueAsDouble(double defaultValue) throws IOException, JsonParseException {
        if (this._currToken == null) {
            return defaultValue;
        }
        switch (this._currToken) {
            case VALUE_NUMBER_INT:
            case VALUE_NUMBER_FLOAT:
                return getDoubleValue();
            case VALUE_TRUE:
                return 1.0d;
            case VALUE_FALSE:
            case VALUE_NULL:
                return 0.0d;
            case VALUE_EMBEDDED_OBJECT:
                Object value = getEmbeddedObject();
                if (value instanceof Number) {
                    return ((Number) value).doubleValue();
                }
                return defaultValue;
            case VALUE_STRING:
                return NumberInput.parseAsDouble(getText(), defaultValue);
            default:
                return defaultValue;
        }
    }

    public String getValueAsString(String defaultValue) throws IOException, JsonParseException {
        return (this._currToken == JsonToken.VALUE_STRING || !(this._currToken == null || this._currToken == JsonToken.VALUE_NULL || !this._currToken.isScalarValue())) ? getText() : defaultValue;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        if (r5 < r3) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        _reportBase64EOF();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        r4 = r5 + 1;
        r1 = r12.charAt(r5);
        r0 = r14.decodeBase64Char(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r0 >= 0) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        _reportInvalidBase64(r14, r1, 1, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        r2 = (r2 << 6) | r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        if (r4 < r3) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        if (r14.usesPadding() != false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        r13.append(r2 >> 4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004a, code lost:
        _reportBase64EOF();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
        r5 = r4 + 1;
        r1 = r12.charAt(r4);
        r0 = r14.decodeBase64Char(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        if (r0 >= 0) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
        if (r0 == -2) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005b, code lost:
        _reportInvalidBase64(r14, r1, 2, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005f, code lost:
        if (r5 < r3) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0061, code lost:
        _reportBase64EOF();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0064, code lost:
        r4 = r5 + 1;
        r1 = r12.charAt(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006e, code lost:
        if (r14.usesPaddingChar(r1) != false) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0070, code lost:
        _reportInvalidBase64(r14, r1, 3, "expected padding character '" + r14.getPaddingChar() + "'");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0090, code lost:
        r13.append(r2 >> 4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0097, code lost:
        r2 = (r2 << 6) | r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009b, code lost:
        if (r5 < r3) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a1, code lost:
        if (r14.usesPadding() != false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a3, code lost:
        r13.appendTwoBytes(r2 >> 2);
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ab, code lost:
        _reportBase64EOF();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ae, code lost:
        r4 = r5 + 1;
        r1 = r12.charAt(r5);
        r0 = r14.decodeBase64Char(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b8, code lost:
        if (r0 >= 0) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ba, code lost:
        if (r0 == -2) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bc, code lost:
        _reportInvalidBase64(r14, r1, 3, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bf, code lost:
        r13.appendTwoBytes(r2 >> 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c6, code lost:
        r13.appendThreeBytes((r2 << 6) | r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        r0 = r14.decodeBase64Char(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r0 >= 0) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        _reportInvalidBase64(r14, r1, 0, (java.lang.String) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void _decodeBase64(java.lang.String r12, com.fasterxml.jackson.core.util.ByteArrayBuilder r13, com.fasterxml.jackson.core.Base64Variant r14) throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r11 = this;
            r10 = 3
            r9 = -2
            r8 = 0
            r4 = 0
            int r3 = r12.length()
        L_0x0008:
            if (r4 >= r3) goto L_0x0013
        L_0x000a:
            int r5 = r4 + 1
            char r1 = r12.charAt(r4)
            if (r5 < r3) goto L_0x0014
            r4 = r5
        L_0x0013:
            return
        L_0x0014:
            r6 = 32
            if (r1 <= r6) goto L_0x00cf
            int r0 = r14.decodeBase64Char((char) r1)
            if (r0 >= 0) goto L_0x0022
            r6 = 0
            r11._reportInvalidBase64(r14, r1, r6, r8)
        L_0x0022:
            r2 = r0
            if (r5 < r3) goto L_0x0028
            r11._reportBase64EOF()
        L_0x0028:
            int r4 = r5 + 1
            char r1 = r12.charAt(r5)
            int r0 = r14.decodeBase64Char((char) r1)
            if (r0 >= 0) goto L_0x0038
            r6 = 1
            r11._reportInvalidBase64(r14, r1, r6, r8)
        L_0x0038:
            int r6 = r2 << 6
            r2 = r6 | r0
            if (r4 < r3) goto L_0x004d
            boolean r6 = r14.usesPadding()
            if (r6 != 0) goto L_0x004a
            int r2 = r2 >> 4
            r13.append(r2)
            goto L_0x0013
        L_0x004a:
            r11._reportBase64EOF()
        L_0x004d:
            int r5 = r4 + 1
            char r1 = r12.charAt(r4)
            int r0 = r14.decodeBase64Char((char) r1)
            if (r0 >= 0) goto L_0x0097
            if (r0 == r9) goto L_0x005f
            r6 = 2
            r11._reportInvalidBase64(r14, r1, r6, r8)
        L_0x005f:
            if (r5 < r3) goto L_0x0064
            r11._reportBase64EOF()
        L_0x0064:
            int r4 = r5 + 1
            char r1 = r12.charAt(r5)
            boolean r6 = r14.usesPaddingChar((char) r1)
            if (r6 != 0) goto L_0x0090
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "expected padding character '"
            java.lang.StringBuilder r6 = r6.append(r7)
            char r7 = r14.getPaddingChar()
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r7 = "'"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            r11._reportInvalidBase64(r14, r1, r10, r6)
        L_0x0090:
            int r2 = r2 >> 4
            r13.append(r2)
            goto L_0x0008
        L_0x0097:
            int r6 = r2 << 6
            r2 = r6 | r0
            if (r5 < r3) goto L_0x00ae
            boolean r6 = r14.usesPadding()
            if (r6 != 0) goto L_0x00ab
            int r2 = r2 >> 2
            r13.appendTwoBytes(r2)
            r4 = r5
            goto L_0x0013
        L_0x00ab:
            r11._reportBase64EOF()
        L_0x00ae:
            int r4 = r5 + 1
            char r1 = r12.charAt(r5)
            int r0 = r14.decodeBase64Char((char) r1)
            if (r0 >= 0) goto L_0x00c6
            if (r0 == r9) goto L_0x00bf
            r11._reportInvalidBase64(r14, r1, r10, r8)
        L_0x00bf:
            int r2 = r2 >> 2
            r13.appendTwoBytes(r2)
            goto L_0x0008
        L_0x00c6:
            int r6 = r2 << 6
            r2 = r6 | r0
            r13.appendThreeBytes(r2)
            goto L_0x0008
        L_0x00cf:
            r4 = r5
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.base.ParserMinimalBase._decodeBase64(java.lang.String, com.fasterxml.jackson.core.util.ByteArrayBuilder, com.fasterxml.jackson.core.Base64Variant):void");
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidBase64(Base64Variant b64variant, char ch, int bindex, String msg) throws JsonParseException {
        String base;
        if (ch <= ' ') {
            base = "Illegal white space character (code 0x" + Integer.toHexString(ch) + ") as character #" + (bindex + 1) + " of 4-char base64 unit: can only used between units";
        } else if (b64variant.usesPaddingChar(ch)) {
            base = "Unexpected padding character ('" + b64variant.getPaddingChar() + "') as character #" + (bindex + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(ch) || Character.isISOControl(ch)) {
            base = "Illegal character (code 0x" + Integer.toHexString(ch) + ") in base64 content";
        } else {
            base = "Illegal character '" + ch + "' (code 0x" + Integer.toHexString(ch) + ") in base64 content";
        }
        if (msg != null) {
            base = base + ": " + msg;
        }
        throw _constructError(base);
    }

    /* access modifiers changed from: protected */
    public void _reportBase64EOF() throws JsonParseException {
        throw _constructError("Unexpected end-of-String in base64 content");
    }

    /* access modifiers changed from: protected */
    public void _reportUnexpectedChar(int ch, String comment) throws JsonParseException {
        String msg = "Unexpected character (" + _getCharDesc(ch) + ")";
        if (comment != null) {
            msg = msg + ": " + comment;
        }
        _reportError(msg);
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidEOF() throws JsonParseException {
        _reportInvalidEOF(" in " + this._currToken);
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidEOF(String msg) throws JsonParseException {
        _reportError("Unexpected end-of-input" + msg);
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidEOFInValue() throws JsonParseException {
        _reportInvalidEOF(" in a value");
    }

    /* access modifiers changed from: protected */
    public void _throwInvalidSpace(int i) throws JsonParseException {
        _reportError("Illegal character (" + _getCharDesc((char) i) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
    }

    /* access modifiers changed from: protected */
    public void _throwUnquotedSpace(int i, String ctxtDesc) throws JsonParseException {
        if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS) || i >= 32) {
            _reportError("Illegal unquoted character (" + _getCharDesc((char) i) + "): has to be escaped using backslash to be included in " + ctxtDesc);
        }
    }

    /* access modifiers changed from: protected */
    public char _handleUnrecognizedCharacterEscape(char ch) throws JsonProcessingException {
        if (!isEnabled(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER) && (ch != '\'' || !isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES))) {
            _reportError("Unrecognized character escape " + _getCharDesc(ch));
        }
        return ch;
    }

    protected static final String _getCharDesc(int ch) {
        char c = (char) ch;
        if (Character.isISOControl(c)) {
            return "(CTRL-CHAR, code " + ch + ")";
        }
        if (ch > 255) {
            return "'" + c + "' (code " + ch + " / 0x" + Integer.toHexString(ch) + ")";
        }
        return "'" + c + "' (code " + ch + ")";
    }

    /* access modifiers changed from: protected */
    public final void _reportError(String msg) throws JsonParseException {
        throw _constructError(msg);
    }

    /* access modifiers changed from: protected */
    public final void _wrapError(String msg, Throwable t) throws JsonParseException {
        throw _constructError(msg, t);
    }

    /* access modifiers changed from: protected */
    public final void _throwInternal() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }

    /* access modifiers changed from: protected */
    public final JsonParseException _constructError(String msg, Throwable t) {
        return new JsonParseException(msg, getCurrentLocation(), t);
    }
}
