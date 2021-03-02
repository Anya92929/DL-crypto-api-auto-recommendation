package com.fasterxml.jackson.core.json;

import android.support.p000v4.view.MotionEventCompat;
import com.actionbarsherlock.view.Menu;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.p003io.CharTypes;
import com.fasterxml.jackson.core.p003io.CharacterEscapes;
import com.fasterxml.jackson.core.p003io.IOContext;
import com.fasterxml.jackson.core.p003io.NumberOutput;
import com.flurry.android.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class UTF8JsonGenerator extends JsonGeneratorImpl {
    private static final byte BYTE_0 = 48;
    private static final byte BYTE_BACKSLASH = 92;
    private static final byte BYTE_COLON = 58;
    private static final byte BYTE_COMMA = 44;
    private static final byte BYTE_LBRACKET = 91;
    private static final byte BYTE_LCURLY = 123;
    private static final byte BYTE_QUOTE = 34;
    private static final byte BYTE_RBRACKET = 93;
    private static final byte BYTE_RCURLY = 125;
    private static final byte BYTE_u = 117;
    private static final byte[] FALSE_BYTES = {102, 97, 108, 115, 101};
    static final byte[] HEX_CHARS = CharTypes.copyHexBytes();
    private static final int MAX_BYTES_TO_BUFFER = 512;
    private static final byte[] NULL_BYTES = {110, BYTE_u, 108, 108};
    protected static final int SURR1_FIRST = 55296;
    protected static final int SURR1_LAST = 56319;
    protected static final int SURR2_FIRST = 56320;
    protected static final int SURR2_LAST = 57343;
    private static final byte[] TRUE_BYTES = {116, 114, BYTE_u, 101};
    protected boolean _bufferRecyclable;
    protected char[] _charBuffer;
    protected final int _charBufferLength;
    protected byte[] _entityBuffer;
    protected byte[] _outputBuffer;
    protected final int _outputEnd;
    protected final int _outputMaxContiguous;
    protected final OutputStream _outputStream;
    protected int _outputTail = 0;

    public UTF8JsonGenerator(IOContext ctxt, int features, ObjectCodec codec, OutputStream out) {
        super(ctxt, features, codec);
        this._outputStream = out;
        this._bufferRecyclable = true;
        this._outputBuffer = ctxt.allocWriteEncodingBuffer();
        this._outputEnd = this._outputBuffer.length;
        this._outputMaxContiguous = this._outputEnd >> 3;
        this._charBuffer = ctxt.allocConcatBuffer();
        this._charBufferLength = this._charBuffer.length;
        if (isEnabled(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
            setHighestNonEscapedChar(127);
        }
    }

    public UTF8JsonGenerator(IOContext ctxt, int features, ObjectCodec codec, OutputStream out, byte[] outputBuffer, int outputOffset, boolean bufferRecyclable) {
        super(ctxt, features, codec);
        this._outputStream = out;
        this._bufferRecyclable = bufferRecyclable;
        this._outputTail = outputOffset;
        this._outputBuffer = outputBuffer;
        this._outputEnd = this._outputBuffer.length;
        this._outputMaxContiguous = this._outputEnd >> 3;
        this._charBuffer = ctxt.allocConcatBuffer();
        this._charBufferLength = this._charBuffer.length;
    }

    public Object getOutputTarget() {
        return this._outputStream;
    }

    public final void writeFieldName(String name) throws IOException, JsonGenerationException {
        boolean z = true;
        int status = this._writeContext.writeFieldName(name);
        if (status == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        if (this._cfgPrettyPrinter != null) {
            if (status != 1) {
                z = false;
            }
            _writePPFieldName(name, z);
            return;
        }
        if (status == 1) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_COMMA;
        }
        _writeFieldName(name);
    }

    public final void writeFieldName(SerializableString name) throws IOException, JsonGenerationException {
        boolean z = true;
        int status = this._writeContext.writeFieldName(name.getValue());
        if (status == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        if (this._cfgPrettyPrinter != null) {
            if (status != 1) {
                z = false;
            }
            _writePPFieldName(name, z);
            return;
        }
        if (status == 1) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_COMMA;
        }
        _writeFieldName(name);
    }

    public final void writeStartArray() throws IOException, JsonGenerationException {
        _verifyValueWrite("start an array");
        this._writeContext = this._writeContext.createChildArrayContext();
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeStartArray(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_LBRACKET;
    }

    public final void writeEndArray() throws IOException, JsonGenerationException {
        if (!this._writeContext.inArray()) {
            _reportError("Current context not an ARRAY but " + this._writeContext.getTypeDesc());
        }
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeEndArray(this, this._writeContext.getEntryCount());
        } else {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_RBRACKET;
        }
        this._writeContext = this._writeContext.getParent();
    }

    public final void writeStartObject() throws IOException, JsonGenerationException {
        _verifyValueWrite("start an object");
        this._writeContext = this._writeContext.createChildObjectContext();
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeStartObject(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_LCURLY;
    }

    public final void writeEndObject() throws IOException, JsonGenerationException {
        if (!this._writeContext.inObject()) {
            _reportError("Current context not an object but " + this._writeContext.getTypeDesc());
        }
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeEndObject(this, this._writeContext.getEntryCount());
        } else {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_RCURLY;
        }
        this._writeContext = this._writeContext.getParent();
    }

    /* access modifiers changed from: protected */
    public final void _writeFieldName(String name) throws IOException, JsonGenerationException {
        if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            _writeStringSegments(name);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        int len = name.length();
        if (len <= this._charBufferLength) {
            name.getChars(0, len, this._charBuffer, 0);
            if (len <= this._outputMaxContiguous) {
                if (this._outputTail + len > this._outputEnd) {
                    _flushBuffer();
                }
                _writeStringSegment(this._charBuffer, 0, len);
            } else {
                _writeStringSegments(this._charBuffer, 0, len);
            }
        } else {
            _writeStringSegments(name);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = BYTE_QUOTE;
    }

    /* access modifiers changed from: protected */
    public final void _writeFieldName(SerializableString name) throws IOException, JsonGenerationException {
        if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            int len = name.appendQuotedUTF8(this._outputBuffer, this._outputTail);
            if (len < 0) {
                _writeBytes(name.asQuotedUTF8());
            } else {
                this._outputTail += len;
            }
        } else {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_QUOTE;
            int len2 = name.appendQuotedUTF8(this._outputBuffer, this._outputTail);
            if (len2 < 0) {
                _writeBytes(name.asQuotedUTF8());
            } else {
                this._outputTail += len2;
            }
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr2 = this._outputBuffer;
            int i2 = this._outputTail;
            this._outputTail = i2 + 1;
            bArr2[i2] = BYTE_QUOTE;
        }
    }

    /* access modifiers changed from: protected */
    public final void _writePPFieldName(String name, boolean commaBefore) throws IOException, JsonGenerationException {
        if (commaBefore) {
            this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
        } else {
            this._cfgPrettyPrinter.beforeObjectEntries(this);
        }
        if (isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_QUOTE;
            int len = name.length();
            if (len <= this._charBufferLength) {
                name.getChars(0, len, this._charBuffer, 0);
                if (len <= this._outputMaxContiguous) {
                    if (this._outputTail + len > this._outputEnd) {
                        _flushBuffer();
                    }
                    _writeStringSegment(this._charBuffer, 0, len);
                } else {
                    _writeStringSegments(this._charBuffer, 0, len);
                }
            } else {
                _writeStringSegments(name);
            }
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr2 = this._outputBuffer;
            int i2 = this._outputTail;
            this._outputTail = i2 + 1;
            bArr2[i2] = BYTE_QUOTE;
            return;
        }
        _writeStringSegments(name);
    }

    /* access modifiers changed from: protected */
    public final void _writePPFieldName(SerializableString name, boolean commaBefore) throws IOException, JsonGenerationException {
        if (commaBefore) {
            this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
        } else {
            this._cfgPrettyPrinter.beforeObjectEntries(this);
        }
        boolean addQuotes = isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES);
        if (addQuotes) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_QUOTE;
        }
        _writeBytes(name.asQuotedUTF8());
        if (addQuotes) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr2 = this._outputBuffer;
            int i2 = this._outputTail;
            this._outputTail = i2 + 1;
            bArr2[i2] = BYTE_QUOTE;
        }
    }

    public void writeString(String text) throws IOException, JsonGenerationException {
        _verifyValueWrite("write text value");
        if (text == null) {
            _writeNull();
            return;
        }
        int len = text.length();
        if (len > this._charBufferLength) {
            _writeLongString(text);
            return;
        }
        text.getChars(0, len, this._charBuffer, 0);
        if (len > this._outputMaxContiguous) {
            _writeLongString(this._charBuffer, 0, len);
            return;
        }
        if (this._outputTail + len >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        _writeStringSegment(this._charBuffer, 0, len);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = BYTE_QUOTE;
    }

    private void _writeLongString(String text) throws IOException, JsonGenerationException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        _writeStringSegments(text);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = BYTE_QUOTE;
    }

    private void _writeLongString(char[] text, int offset, int len) throws IOException, JsonGenerationException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        _writeStringSegments(this._charBuffer, 0, len);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = BYTE_QUOTE;
    }

    public void writeString(char[] text, int offset, int len) throws IOException, JsonGenerationException {
        _verifyValueWrite("write text value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        if (len <= this._outputMaxContiguous) {
            if (this._outputTail + len > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(text, offset, len);
        } else {
            _writeStringSegments(text, offset, len);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = BYTE_QUOTE;
    }

    public final void writeString(SerializableString text) throws IOException, JsonGenerationException {
        _verifyValueWrite("write text value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        int len = text.appendQuotedUTF8(this._outputBuffer, this._outputTail);
        if (len < 0) {
            _writeBytes(text.asQuotedUTF8());
        } else {
            this._outputTail += len;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = BYTE_QUOTE;
    }

    public void writeRawUTF8String(byte[] text, int offset, int length) throws IOException, JsonGenerationException {
        _verifyValueWrite("write text value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        _writeBytes(text, offset, length);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = BYTE_QUOTE;
    }

    public void writeUTF8String(byte[] text, int offset, int len) throws IOException, JsonGenerationException {
        _verifyValueWrite("write text value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        if (len <= this._outputMaxContiguous) {
            _writeUTF8Segment(text, offset, len);
        } else {
            _writeUTF8Segments(text, offset, len);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = BYTE_QUOTE;
    }

    public void writeRaw(String text) throws IOException, JsonGenerationException {
        int len2;
        int start = 0;
        int len = text.length();
        while (len > 0) {
            char[] buf = this._charBuffer;
            int blen = buf.length;
            if (len < blen) {
                len2 = len;
            } else {
                len2 = blen;
            }
            text.getChars(start, start + len2, buf, 0);
            writeRaw(buf, 0, len2);
            start += len2;
            len -= len2;
        }
    }

    public void writeRaw(String text, int offset, int len) throws IOException, JsonGenerationException {
        int len2;
        while (len > 0) {
            char[] buf = this._charBuffer;
            int blen = buf.length;
            if (len < blen) {
                len2 = len;
            } else {
                len2 = blen;
            }
            text.getChars(offset, offset + len2, buf, 0);
            writeRaw(buf, 0, len2);
            offset += len2;
            len -= len2;
        }
    }

    public void writeRaw(SerializableString text) throws IOException, JsonGenerationException {
        byte[] raw = text.asUnquotedUTF8();
        if (raw.length > 0) {
            _writeBytes(raw);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        r2 = r8 + 1;
        r0 = r7[r8];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        if (r0 >= 2048) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        r3 = r6._outputBuffer;
        r4 = r6._outputTail;
        r6._outputTail = r4 + 1;
        r3[r4] = (byte) ((r0 >> 6) | 192);
        r3 = r6._outputBuffer;
        r4 = r6._outputTail;
        r6._outputTail = r4 + 1;
        r3[r4] = (byte) ((r0 & '?') | 128);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
        r8 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        _outputRawMultiByteChar(r0, r7, r2, r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writeRaw(char[] r7, int r8, int r9) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r6 = this;
            int r3 = r9 + r9
            int r1 = r3 + r9
            int r3 = r6._outputTail
            int r3 = r3 + r1
            int r4 = r6._outputEnd
            if (r3 <= r4) goto L_0x0016
            int r3 = r6._outputEnd
            if (r3 >= r1) goto L_0x0013
            r6._writeSegmentedRaw(r7, r8, r9)
        L_0x0012:
            return
        L_0x0013:
            r6._flushBuffer()
        L_0x0016:
            int r9 = r9 + r8
        L_0x0017:
            if (r8 >= r9) goto L_0x0012
        L_0x0019:
            char r0 = r7[r8]
            r3 = 127(0x7f, float:1.78E-43)
            if (r0 <= r3) goto L_0x0047
            int r2 = r8 + 1
            char r0 = r7[r8]
            r3 = 2048(0x800, float:2.87E-42)
            if (r0 >= r3) goto L_0x0057
            byte[] r3 = r6._outputBuffer
            int r4 = r6._outputTail
            int r5 = r4 + 1
            r6._outputTail = r5
            int r5 = r0 >> 6
            r5 = r5 | 192(0xc0, float:2.69E-43)
            byte r5 = (byte) r5
            r3[r4] = r5
            byte[] r3 = r6._outputBuffer
            int r4 = r6._outputTail
            int r5 = r4 + 1
            r6._outputTail = r5
            r5 = r0 & 63
            r5 = r5 | 128(0x80, float:1.794E-43)
            byte r5 = (byte) r5
            r3[r4] = r5
        L_0x0045:
            r8 = r2
            goto L_0x0017
        L_0x0047:
            byte[] r3 = r6._outputBuffer
            int r4 = r6._outputTail
            int r5 = r4 + 1
            r6._outputTail = r5
            byte r5 = (byte) r0
            r3[r4] = r5
            int r8 = r8 + 1
            if (r8 < r9) goto L_0x0019
            goto L_0x0012
        L_0x0057:
            r6._outputRawMultiByteChar(r0, r7, r2, r9)
            goto L_0x0045
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8JsonGenerator.writeRaw(char[], int, int):void");
    }

    public void writeRaw(char ch) throws IOException, JsonGenerationException {
        if (this._outputTail + 3 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bbuf = this._outputBuffer;
        if (ch <= 127) {
            int i = this._outputTail;
            this._outputTail = i + 1;
            bbuf[i] = (byte) ch;
        } else if (ch < 2048) {
            int i2 = this._outputTail;
            this._outputTail = i2 + 1;
            bbuf[i2] = (byte) ((ch >> 6) | 192);
            int i3 = this._outputTail;
            this._outputTail = i3 + 1;
            bbuf[i3] = (byte) ((ch & '?') | 128);
        } else {
            _outputRawMultiByteChar(ch, (char[]) null, 0, 0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        r8 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        _outputRawMultiByteChar(r1, r7, r3, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        if ((r6._outputTail + 3) < r6._outputEnd) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        _flushBuffer();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r3 = r8 + 1;
        r1 = r7[r8];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r1 >= 2048) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r4 = r6._outputTail;
        r6._outputTail = r4 + 1;
        r0[r4] = (byte) ((r1 >> 6) | 192);
        r4 = r6._outputTail;
        r6._outputTail = r4 + 1;
        r0[r4] = (byte) ((r1 & '?') | 128);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void _writeSegmentedRaw(char[] r7, int r8, int r9) throws java.io.IOException, com.fasterxml.jackson.core.JsonGenerationException {
        /*
            r6 = this;
            int r2 = r6._outputEnd
            byte[] r0 = r6._outputBuffer
        L_0x0004:
            if (r8 >= r9) goto L_0x004f
        L_0x0006:
            char r1 = r7[r8]
            r4 = 128(0x80, float:1.794E-43)
            if (r1 < r4) goto L_0x003b
            int r4 = r6._outputTail
            int r4 = r4 + 3
            int r5 = r6._outputEnd
            if (r4 < r5) goto L_0x0017
            r6._flushBuffer()
        L_0x0017:
            int r3 = r8 + 1
            char r1 = r7[r8]
            r4 = 2048(0x800, float:2.87E-42)
            if (r1 >= r4) goto L_0x0050
            int r4 = r6._outputTail
            int r5 = r4 + 1
            r6._outputTail = r5
            int r5 = r1 >> 6
            r5 = r5 | 192(0xc0, float:2.69E-43)
            byte r5 = (byte) r5
            r0[r4] = r5
            int r4 = r6._outputTail
            int r5 = r4 + 1
            r6._outputTail = r5
            r5 = r1 & 63
            r5 = r5 | 128(0x80, float:1.794E-43)
            byte r5 = (byte) r5
            r0[r4] = r5
        L_0x0039:
            r8 = r3
            goto L_0x0004
        L_0x003b:
            int r4 = r6._outputTail
            if (r4 < r2) goto L_0x0042
            r6._flushBuffer()
        L_0x0042:
            int r4 = r6._outputTail
            int r5 = r4 + 1
            r6._outputTail = r5
            byte r5 = (byte) r1
            r0[r4] = r5
            int r8 = r8 + 1
            if (r8 < r9) goto L_0x0006
        L_0x004f:
            return
        L_0x0050:
            r6._outputRawMultiByteChar(r1, r7, r3, r9)
            goto L_0x0039
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8JsonGenerator._writeSegmentedRaw(char[], int, int):void");
    }

    public void writeBinary(Base64Variant b64variant, byte[] data, int offset, int len) throws IOException, JsonGenerationException {
        _verifyValueWrite("write binary value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        _writeBinary(b64variant, data, offset, offset + len);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = BYTE_QUOTE;
    }

    public int writeBinary(Base64Variant b64variant, InputStream data, int dataLength) throws IOException, JsonGenerationException {
        int bytes;
        _verifyValueWrite("write binary value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        byte[] encodingBuffer = this._ioContext.allocBase64Buffer();
        if (dataLength < 0) {
            try {
                bytes = _writeBinary(b64variant, data, encodingBuffer);
            } catch (Throwable th) {
                this._ioContext.releaseBase64Buffer(encodingBuffer);
                throw th;
            }
        } else {
            int missing = _writeBinary(b64variant, data, encodingBuffer, dataLength);
            if (missing > 0) {
                _reportError("Too few bytes available: missing " + missing + " bytes (out of " + dataLength + ")");
            }
            bytes = dataLength;
        }
        this._ioContext.releaseBase64Buffer(encodingBuffer);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = BYTE_QUOTE;
        return bytes;
    }

    public void writeNumber(int i) throws IOException, JsonGenerationException {
        _verifyValueWrite("write number");
        if (this._outputTail + 11 >= this._outputEnd) {
            _flushBuffer();
        }
        if (this._cfgNumbersAsStrings) {
            _writeQuotedInt(i);
        } else {
            this._outputTail = NumberOutput.outputInt(i, this._outputBuffer, this._outputTail);
        }
    }

    private void _writeQuotedInt(int i) throws IOException {
        if (this._outputTail + 13 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr[i2] = BYTE_QUOTE;
        this._outputTail = NumberOutput.outputInt(i, this._outputBuffer, this._outputTail);
        byte[] bArr2 = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bArr2[i3] = BYTE_QUOTE;
    }

    public void writeNumber(long l) throws IOException, JsonGenerationException {
        _verifyValueWrite("write number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedLong(l);
            return;
        }
        if (this._outputTail + 21 >= this._outputEnd) {
            _flushBuffer();
        }
        this._outputTail = NumberOutput.outputLong(l, this._outputBuffer, this._outputTail);
    }

    private void _writeQuotedLong(long l) throws IOException {
        if (this._outputTail + 23 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        this._outputTail = NumberOutput.outputLong(l, this._outputBuffer, this._outputTail);
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = BYTE_QUOTE;
    }

    public void writeNumber(BigInteger value) throws IOException, JsonGenerationException {
        _verifyValueWrite("write number");
        if (value == null) {
            _writeNull();
        } else if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(value);
        } else {
            writeRaw(value.toString());
        }
    }

    public void writeNumber(double d) throws IOException, JsonGenerationException {
        if (this._cfgNumbersAsStrings || ((Double.isNaN(d) || Double.isInfinite(d)) && isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            writeString(String.valueOf(d));
            return;
        }
        _verifyValueWrite("write number");
        writeRaw(String.valueOf(d));
    }

    public void writeNumber(float f) throws IOException, JsonGenerationException {
        if (this._cfgNumbersAsStrings || ((Float.isNaN(f) || Float.isInfinite(f)) && isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            writeString(String.valueOf(f));
            return;
        }
        _verifyValueWrite("write number");
        writeRaw(String.valueOf(f));
    }

    public void writeNumber(BigDecimal value) throws IOException, JsonGenerationException {
        _verifyValueWrite("write number");
        if (value == null) {
            _writeNull();
        } else if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(value);
        } else {
            writeRaw(value.toString());
        }
    }

    public void writeNumber(String encodedValue) throws IOException, JsonGenerationException {
        _verifyValueWrite("write number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(encodedValue);
        } else {
            writeRaw(encodedValue);
        }
    }

    private void _writeQuotedRaw(Object value) throws IOException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        writeRaw(value.toString());
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr2[i2] = BYTE_QUOTE;
    }

    public void writeBoolean(boolean state) throws IOException, JsonGenerationException {
        _verifyValueWrite("write boolean value");
        if (this._outputTail + 5 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] keyword = state ? TRUE_BYTES : FALSE_BYTES;
        int len = keyword.length;
        System.arraycopy(keyword, 0, this._outputBuffer, this._outputTail, len);
        this._outputTail += len;
    }

    public void writeNull() throws IOException, JsonGenerationException {
        _verifyValueWrite("write null value");
        _writeNull();
    }

    /* access modifiers changed from: protected */
    public final void _verifyValueWrite(String typeMsg) throws IOException, JsonGenerationException {
        byte b;
        int status = this._writeContext.writeValue();
        if (status == 5) {
            _reportError("Can not " + typeMsg + ", expecting field name");
        }
        if (this._cfgPrettyPrinter == null) {
            switch (status) {
                case 1:
                    b = BYTE_COMMA;
                    break;
                case 2:
                    b = BYTE_COLON;
                    break;
                case 3:
                    if (this._rootValueSeparator != null) {
                        byte[] raw = this._rootValueSeparator.asUnquotedUTF8();
                        if (raw.length > 0) {
                            _writeBytes(raw);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            this._outputBuffer[this._outputTail] = b;
            this._outputTail++;
            return;
        }
        _verifyPrettyValueWrite(typeMsg, status);
    }

    /* access modifiers changed from: protected */
    public final void _verifyPrettyValueWrite(String typeMsg, int status) throws IOException, JsonGenerationException {
        switch (status) {
            case 0:
                if (this._writeContext.inArray()) {
                    this._cfgPrettyPrinter.beforeArrayValues(this);
                    return;
                } else if (this._writeContext.inObject()) {
                    this._cfgPrettyPrinter.beforeObjectEntries(this);
                    return;
                } else {
                    return;
                }
            case 1:
                this._cfgPrettyPrinter.writeArrayValueSeparator(this);
                return;
            case 2:
                this._cfgPrettyPrinter.writeObjectFieldValueSeparator(this);
                return;
            case 3:
                this._cfgPrettyPrinter.writeRootValueSeparator(this);
                return;
            default:
                _cantHappen();
                return;
        }
    }

    public final void flush() throws IOException {
        _flushBuffer();
        if (this._outputStream != null && isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            this._outputStream.flush();
        }
    }

    public void close() throws IOException {
        super.close();
        if (this._outputBuffer != null && isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                JsonStreamContext ctxt = getOutputContext();
                if (!ctxt.inArray()) {
                    if (!ctxt.inObject()) {
                        break;
                    }
                    writeEndObject();
                } else {
                    writeEndArray();
                }
            }
        }
        _flushBuffer();
        if (this._outputStream != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
                this._outputStream.close();
            } else if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
                this._outputStream.flush();
            }
        }
        _releaseBuffers();
    }

    /* access modifiers changed from: protected */
    public void _releaseBuffers() {
        byte[] buf = this._outputBuffer;
        if (buf != null && this._bufferRecyclable) {
            this._outputBuffer = null;
            this._ioContext.releaseWriteEncodingBuffer(buf);
        }
        char[] cbuf = this._charBuffer;
        if (cbuf != null) {
            this._charBuffer = null;
            this._ioContext.releaseConcatBuffer(cbuf);
        }
    }

    private final void _writeBytes(byte[] bytes) throws IOException {
        int len = bytes.length;
        if (this._outputTail + len > this._outputEnd) {
            _flushBuffer();
            if (len > 512) {
                this._outputStream.write(bytes, 0, len);
                return;
            }
        }
        System.arraycopy(bytes, 0, this._outputBuffer, this._outputTail, len);
        this._outputTail += len;
    }

    private final void _writeBytes(byte[] bytes, int offset, int len) throws IOException {
        if (this._outputTail + len > this._outputEnd) {
            _flushBuffer();
            if (len > 512) {
                this._outputStream.write(bytes, offset, len);
                return;
            }
        }
        System.arraycopy(bytes, offset, this._outputBuffer, this._outputTail, len);
        this._outputTail += len;
    }

    private final void _writeStringSegments(String text) throws IOException, JsonGenerationException {
        int left = text.length();
        int offset = 0;
        char[] cbuf = this._charBuffer;
        while (left > 0) {
            int len = Math.min(this._outputMaxContiguous, left);
            text.getChars(offset, offset + len, cbuf, 0);
            if (this._outputTail + len > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(cbuf, 0, len);
            offset += len;
            left -= len;
        }
    }

    private final void _writeStringSegments(char[] cbuf, int offset, int totalLen) throws IOException, JsonGenerationException {
        do {
            int len = Math.min(this._outputMaxContiguous, totalLen);
            if (this._outputTail + len > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(cbuf, offset, len);
            offset += len;
            totalLen -= len;
        } while (totalLen > 0);
    }

    private final void _writeStringSegment(char[] cbuf, int offset, int len) throws IOException, JsonGenerationException {
        int len2 = len + offset;
        int outputPtr = this._outputTail;
        byte[] outputBuffer = this._outputBuffer;
        int[] escCodes = this._outputEscapes;
        int outputPtr2 = outputPtr;
        while (offset < len2) {
            char ch = cbuf[offset];
            if (ch > 127 || escCodes[ch] != 0) {
                break;
            }
            outputBuffer[outputPtr2] = (byte) ch;
            offset++;
            outputPtr2++;
        }
        this._outputTail = outputPtr2;
        if (offset >= len2) {
            return;
        }
        if (this._characterEscapes != null) {
            _writeCustomStringSegment2(cbuf, offset, len2);
        } else if (this._maximumNonEscapedChar == 0) {
            _writeStringSegment2(cbuf, offset, len2);
        } else {
            _writeStringSegmentASCII2(cbuf, offset, len2);
        }
    }

    private final void _writeStringSegment2(char[] cbuf, int offset, int end) throws IOException, JsonGenerationException {
        int outputPtr;
        if (this._outputTail + ((end - offset) * 6) > this._outputEnd) {
            _flushBuffer();
        }
        int outputPtr2 = this._outputTail;
        byte[] outputBuffer = this._outputBuffer;
        int[] escCodes = this._outputEscapes;
        int outputPtr3 = outputPtr2;
        int offset2 = offset;
        while (offset2 < end) {
            int offset3 = offset2 + 1;
            char ch = cbuf[offset2];
            if (ch > 127) {
                if (ch <= 2047) {
                    int outputPtr4 = outputPtr3 + 1;
                    outputBuffer[outputPtr3] = (byte) ((ch >> 6) | 192);
                    outputBuffer[outputPtr4] = (byte) ((ch & '?') | 128);
                    outputPtr = outputPtr4 + 1;
                } else {
                    outputPtr = _outputMultiByteChar(ch, outputPtr3);
                }
                outputPtr3 = outputPtr;
                offset2 = offset3;
            } else if (escCodes[ch] == 0) {
                outputBuffer[outputPtr3] = (byte) ch;
                outputPtr3++;
                offset2 = offset3;
            } else {
                int escape = escCodes[ch];
                if (escape > 0) {
                    int outputPtr5 = outputPtr3 + 1;
                    outputBuffer[outputPtr3] = BYTE_BACKSLASH;
                    outputPtr3 = outputPtr5 + 1;
                    outputBuffer[outputPtr5] = (byte) escape;
                    offset2 = offset3;
                } else {
                    outputPtr3 = _writeGenericEscape(ch, outputPtr3);
                    offset2 = offset3;
                }
            }
        }
        this._outputTail = outputPtr3;
    }

    private final void _writeStringSegmentASCII2(char[] cbuf, int offset, int end) throws IOException, JsonGenerationException {
        int outputPtr;
        if (this._outputTail + ((end - offset) * 6) > this._outputEnd) {
            _flushBuffer();
        }
        int outputPtr2 = this._outputTail;
        byte[] outputBuffer = this._outputBuffer;
        int[] escCodes = this._outputEscapes;
        int maxUnescaped = this._maximumNonEscapedChar;
        int outputPtr3 = outputPtr2;
        int offset2 = offset;
        while (offset2 < end) {
            int offset3 = offset2 + 1;
            char ch = cbuf[offset2];
            if (ch <= 127) {
                if (escCodes[ch] == 0) {
                    outputBuffer[outputPtr3] = (byte) ch;
                    outputPtr3++;
                    offset2 = offset3;
                } else {
                    int escape = escCodes[ch];
                    if (escape > 0) {
                        int outputPtr4 = outputPtr3 + 1;
                        outputBuffer[outputPtr3] = BYTE_BACKSLASH;
                        outputPtr3 = outputPtr4 + 1;
                        outputBuffer[outputPtr4] = (byte) escape;
                        offset2 = offset3;
                    } else {
                        outputPtr3 = _writeGenericEscape(ch, outputPtr3);
                        offset2 = offset3;
                    }
                }
            } else if (ch > maxUnescaped) {
                outputPtr3 = _writeGenericEscape(ch, outputPtr3);
                offset2 = offset3;
            } else {
                if (ch <= 2047) {
                    int outputPtr5 = outputPtr3 + 1;
                    outputBuffer[outputPtr3] = (byte) ((ch >> 6) | 192);
                    outputBuffer[outputPtr5] = (byte) ((ch & '?') | 128);
                    outputPtr = outputPtr5 + 1;
                } else {
                    outputPtr = _outputMultiByteChar(ch, outputPtr3);
                }
                outputPtr3 = outputPtr;
                offset2 = offset3;
            }
        }
        this._outputTail = outputPtr3;
    }

    private void _writeCustomStringSegment2(char[] cbuf, int offset, int end) throws IOException, JsonGenerationException {
        int outputPtr;
        if (this._outputTail + ((end - offset) * 6) > this._outputEnd) {
            _flushBuffer();
        }
        int outputPtr2 = this._outputTail;
        byte[] outputBuffer = this._outputBuffer;
        int[] escCodes = this._outputEscapes;
        int maxUnescaped = this._maximumNonEscapedChar <= 0 ? Menu.USER_MASK : this._maximumNonEscapedChar;
        CharacterEscapes customEscapes = this._characterEscapes;
        int outputPtr3 = outputPtr2;
        int offset2 = offset;
        while (offset2 < end) {
            int offset3 = offset2 + 1;
            char ch = cbuf[offset2];
            if (ch <= 127) {
                if (escCodes[ch] == 0) {
                    outputBuffer[outputPtr3] = (byte) ch;
                    outputPtr3++;
                    offset2 = offset3;
                } else {
                    int escape = escCodes[ch];
                    if (escape > 0) {
                        int outputPtr4 = outputPtr3 + 1;
                        outputBuffer[outputPtr3] = BYTE_BACKSLASH;
                        outputPtr3 = outputPtr4 + 1;
                        outputBuffer[outputPtr4] = (byte) escape;
                        offset2 = offset3;
                    } else if (escape == -2) {
                        SerializableString esc = customEscapes.getEscapeSequence(ch);
                        if (esc == null) {
                            _reportError("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(ch) + ", although was supposed to have one");
                        }
                        outputPtr3 = _writeCustomEscape(outputBuffer, outputPtr3, esc, end - offset3);
                        offset2 = offset3;
                    } else {
                        outputPtr3 = _writeGenericEscape(ch, outputPtr3);
                        offset2 = offset3;
                    }
                }
            } else if (ch > maxUnescaped) {
                outputPtr3 = _writeGenericEscape(ch, outputPtr3);
                offset2 = offset3;
            } else {
                SerializableString esc2 = customEscapes.getEscapeSequence(ch);
                if (esc2 != null) {
                    outputPtr3 = _writeCustomEscape(outputBuffer, outputPtr3, esc2, end - offset3);
                    offset2 = offset3;
                } else {
                    if (ch <= 2047) {
                        int outputPtr5 = outputPtr3 + 1;
                        outputBuffer[outputPtr3] = (byte) ((ch >> 6) | 192);
                        outputBuffer[outputPtr5] = (byte) ((ch & '?') | 128);
                        outputPtr = outputPtr5 + 1;
                    } else {
                        outputPtr = _outputMultiByteChar(ch, outputPtr3);
                    }
                    outputPtr3 = outputPtr;
                    offset2 = offset3;
                }
            }
        }
        this._outputTail = outputPtr3;
    }

    private int _writeCustomEscape(byte[] outputBuffer, int outputPtr, SerializableString esc, int remainingChars) throws IOException, JsonGenerationException {
        byte[] raw = esc.asUnquotedUTF8();
        int len = raw.length;
        if (len > 6) {
            return _handleLongCustomEscape(outputBuffer, outputPtr, this._outputEnd, raw, remainingChars);
        }
        System.arraycopy(raw, 0, outputBuffer, outputPtr, len);
        return outputPtr + len;
    }

    private int _handleLongCustomEscape(byte[] outputBuffer, int outputPtr, int outputEnd, byte[] raw, int remainingChars) throws IOException, JsonGenerationException {
        int len = raw.length;
        if (outputPtr + len > outputEnd) {
            this._outputTail = outputPtr;
            _flushBuffer();
            int outputPtr2 = this._outputTail;
            if (len > outputBuffer.length) {
                this._outputStream.write(raw, 0, len);
                return outputPtr2;
            }
            System.arraycopy(raw, 0, outputBuffer, outputPtr2, len);
            outputPtr = outputPtr2 + len;
        }
        if ((remainingChars * 6) + outputPtr <= outputEnd) {
            return outputPtr;
        }
        _flushBuffer();
        return this._outputTail;
    }

    private void _writeUTF8Segments(byte[] utf8, int offset, int totalLen) throws IOException, JsonGenerationException {
        do {
            int len = Math.min(this._outputMaxContiguous, totalLen);
            _writeUTF8Segment(utf8, offset, len);
            offset += len;
            totalLen -= len;
        } while (totalLen > 0);
    }

    private void _writeUTF8Segment(byte[] utf8, int offset, int len) throws IOException, JsonGenerationException {
        int[] escCodes = this._outputEscapes;
        int end = offset + len;
        int ptr = offset;
        while (ptr < end) {
            int ptr2 = ptr + 1;
            byte ch = utf8[ptr];
            if (ch < 0 || escCodes[ch] == 0) {
                ptr = ptr2;
            } else {
                _writeUTF8Segment2(utf8, offset, len);
                return;
            }
        }
        if (this._outputTail + len > this._outputEnd) {
            _flushBuffer();
        }
        System.arraycopy(utf8, offset, this._outputBuffer, this._outputTail, len);
        this._outputTail += len;
        int i = ptr;
    }

    private void _writeUTF8Segment2(byte[] utf8, int offset, int len) throws IOException, JsonGenerationException {
        int outputPtr;
        int outputPtr2 = this._outputTail;
        if ((len * 6) + outputPtr2 > this._outputEnd) {
            _flushBuffer();
            outputPtr2 = this._outputTail;
        }
        byte[] outputBuffer = this._outputBuffer;
        int[] escCodes = this._outputEscapes;
        int len2 = len + offset;
        int outputPtr3 = outputPtr2;
        int offset2 = offset;
        while (offset2 < len2) {
            int offset3 = offset2 + 1;
            byte b = utf8[offset2];
            int ch = b;
            if (ch < 0 || escCodes[ch] == 0) {
                outputBuffer[outputPtr3] = b;
                outputPtr3++;
                offset2 = offset3;
            } else {
                int escape = escCodes[ch];
                if (escape > 0) {
                    int outputPtr4 = outputPtr3 + 1;
                    outputBuffer[outputPtr3] = BYTE_BACKSLASH;
                    outputBuffer[outputPtr4] = (byte) escape;
                    outputPtr = outputPtr4 + 1;
                } else {
                    outputPtr = _writeGenericEscape(ch, outputPtr3);
                }
                outputPtr3 = outputPtr;
                offset2 = offset3;
            }
        }
        this._outputTail = outputPtr3;
    }

    /* access modifiers changed from: protected */
    public void _writeBinary(Base64Variant b64variant, byte[] input, int inputPtr, int inputEnd) throws IOException, JsonGenerationException {
        int safeInputEnd = inputEnd - 3;
        int safeOutputEnd = this._outputEnd - 6;
        int chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
        int inputPtr2 = inputPtr;
        while (inputPtr2 <= safeInputEnd) {
            if (this._outputTail > safeOutputEnd) {
                _flushBuffer();
            }
            int inputPtr3 = inputPtr2 + 1;
            int inputPtr4 = inputPtr3 + 1;
            int inputPtr5 = inputPtr4 + 1;
            this._outputTail = b64variant.encodeBase64Chunk((((input[inputPtr2] << 8) | (input[inputPtr3] & MotionEventCompat.ACTION_MASK)) << 8) | (input[inputPtr4] & MotionEventCompat.ACTION_MASK), this._outputBuffer, this._outputTail);
            chunksBeforeLF--;
            if (chunksBeforeLF <= 0) {
                byte[] bArr = this._outputBuffer;
                int i = this._outputTail;
                this._outputTail = i + 1;
                bArr[i] = BYTE_BACKSLASH;
                byte[] bArr2 = this._outputBuffer;
                int i2 = this._outputTail;
                this._outputTail = i2 + 1;
                bArr2[i2] = 110;
                chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
            }
            inputPtr2 = inputPtr5;
        }
        int inputLeft = inputEnd - inputPtr2;
        if (inputLeft > 0) {
            if (this._outputTail > safeOutputEnd) {
                _flushBuffer();
            }
            int inputPtr6 = inputPtr2 + 1;
            int b24 = input[inputPtr2] << 16;
            if (inputLeft == 2) {
                b24 |= (input[inputPtr6] & Constants.UNKNOWN) << 8;
                int i3 = inputPtr6 + 1;
            }
            this._outputTail = b64variant.encodeBase64Partial(b24, inputLeft, this._outputBuffer, this._outputTail);
            return;
        }
    }

    /* access modifiers changed from: protected */
    public int _writeBinary(Base64Variant b64variant, InputStream data, byte[] readBuffer, int bytesLeft) throws IOException, JsonGenerationException {
        int inputEnd;
        int amount;
        int inputPtr = 0;
        int inputEnd2 = 0;
        int lastFullOffset = -3;
        int safeOutputEnd = this._outputEnd - 6;
        int chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
        while (bytesLeft > 2) {
            if (inputPtr > lastFullOffset) {
                inputEnd2 = _readMore(data, readBuffer, inputPtr, inputEnd2, bytesLeft);
                inputPtr = 0;
                if (inputEnd2 < 3) {
                    break;
                }
                lastFullOffset = inputEnd2 - 3;
            }
            if (this._outputTail > safeOutputEnd) {
                _flushBuffer();
            }
            int inputPtr2 = inputPtr + 1;
            int inputPtr3 = inputPtr2 + 1;
            int inputPtr4 = inputPtr3 + 1;
            bytesLeft -= 3;
            this._outputTail = b64variant.encodeBase64Chunk((((readBuffer[inputPtr] << 8) | (readBuffer[inputPtr2] & MotionEventCompat.ACTION_MASK)) << 8) | (readBuffer[inputPtr3] & MotionEventCompat.ACTION_MASK), this._outputBuffer, this._outputTail);
            chunksBeforeLF--;
            if (chunksBeforeLF <= 0) {
                byte[] bArr = this._outputBuffer;
                int i = this._outputTail;
                this._outputTail = i + 1;
                bArr[i] = BYTE_BACKSLASH;
                byte[] bArr2 = this._outputBuffer;
                int i2 = this._outputTail;
                this._outputTail = i2 + 1;
                bArr2[i2] = 110;
                chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
            }
            inputPtr = inputPtr4;
        }
        if (bytesLeft <= 0 || (inputEnd = _readMore(data, readBuffer, inputPtr, inputEnd2, bytesLeft)) <= 0) {
            return bytesLeft;
        }
        if (this._outputTail > safeOutputEnd) {
            _flushBuffer();
        }
        int inputPtr5 = 0 + 1;
        int b24 = readBuffer[0] << 16;
        if (inputPtr5 < inputEnd) {
            b24 |= (readBuffer[inputPtr5] & Constants.UNKNOWN) << 8;
            amount = 2;
        } else {
            amount = 1;
        }
        this._outputTail = b64variant.encodeBase64Partial(b24, amount, this._outputBuffer, this._outputTail);
        int i3 = inputPtr5;
        return bytesLeft - amount;
    }

    /* access modifiers changed from: protected */
    public int _writeBinary(Base64Variant b64variant, InputStream data, byte[] readBuffer) throws IOException, JsonGenerationException {
        int inputPtr = 0;
        int inputEnd = 0;
        int lastFullOffset = -3;
        int bytesDone = 0;
        int safeOutputEnd = this._outputEnd - 6;
        int chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
        while (true) {
            if (inputPtr > lastFullOffset) {
                inputEnd = _readMore(data, readBuffer, inputPtr, inputEnd, readBuffer.length);
                inputPtr = 0;
                if (inputEnd < 3) {
                    break;
                }
                lastFullOffset = inputEnd - 3;
            }
            if (this._outputTail > safeOutputEnd) {
                _flushBuffer();
            }
            int inputPtr2 = inputPtr + 1;
            int inputPtr3 = inputPtr2 + 1;
            int inputPtr4 = inputPtr3 + 1;
            bytesDone += 3;
            this._outputTail = b64variant.encodeBase64Chunk((((readBuffer[inputPtr] << 8) | (readBuffer[inputPtr2] & MotionEventCompat.ACTION_MASK)) << 8) | (readBuffer[inputPtr3] & MotionEventCompat.ACTION_MASK), this._outputBuffer, this._outputTail);
            chunksBeforeLF--;
            if (chunksBeforeLF <= 0) {
                byte[] bArr = this._outputBuffer;
                int i = this._outputTail;
                this._outputTail = i + 1;
                bArr[i] = BYTE_BACKSLASH;
                byte[] bArr2 = this._outputBuffer;
                int i2 = this._outputTail;
                this._outputTail = i2 + 1;
                bArr2[i2] = 110;
                chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
            }
            inputPtr = inputPtr4;
        }
        if (0 >= inputEnd) {
            return bytesDone;
        }
        if (this._outputTail > safeOutputEnd) {
            _flushBuffer();
        }
        int inputPtr5 = 0 + 1;
        int b24 = readBuffer[0] << 16;
        int amount = 1;
        if (inputPtr5 < inputEnd) {
            b24 |= (readBuffer[inputPtr5] & Constants.UNKNOWN) << 8;
            amount = 2;
        }
        int bytesDone2 = bytesDone + amount;
        this._outputTail = b64variant.encodeBase64Partial(b24, amount, this._outputBuffer, this._outputTail);
        int i3 = inputPtr5;
        return bytesDone2;
    }

    private int _readMore(InputStream in, byte[] readBuffer, int inputPtr, int inputEnd, int maxRead) throws IOException {
        int i = 0;
        for (int inputPtr2 = inputPtr; inputPtr2 < inputEnd; inputPtr2++) {
            readBuffer[i] = readBuffer[inputPtr2];
            i++;
        }
        int inputEnd2 = i;
        int maxRead2 = Math.min(maxRead, readBuffer.length);
        do {
            int count = in.read(readBuffer, inputEnd2, maxRead2 - inputEnd2);
            if (count < 0) {
                return inputEnd2;
            }
            inputEnd2 += count;
        } while (inputEnd2 < 3);
        return inputEnd2;
    }

    private int _outputRawMultiByteChar(int ch, char[] cbuf, int inputOffset, int inputLen) throws IOException {
        if (ch < SURR1_FIRST || ch > SURR2_LAST) {
            byte[] bbuf = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bbuf[i] = (byte) ((ch >> 12) | 224);
            int i2 = this._outputTail;
            this._outputTail = i2 + 1;
            bbuf[i2] = (byte) (((ch >> 6) & 63) | 128);
            int i3 = this._outputTail;
            this._outputTail = i3 + 1;
            bbuf[i3] = (byte) ((ch & 63) | 128);
            return inputOffset;
        }
        if (inputOffset >= inputLen) {
            _reportError("Split surrogate on writeRaw() input (last character)");
        }
        _outputSurrogates(ch, cbuf[inputOffset]);
        return inputOffset + 1;
    }

    /* access modifiers changed from: protected */
    public final void _outputSurrogates(int surr1, int surr2) throws IOException {
        int c = _decodeSurrogate(surr1, surr2);
        if (this._outputTail + 4 > this._outputEnd) {
            _flushBuffer();
        }
        byte[] bbuf = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bbuf[i] = (byte) ((c >> 18) | 240);
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bbuf[i2] = (byte) (((c >> 12) & 63) | 128);
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        bbuf[i3] = (byte) (((c >> 6) & 63) | 128);
        int i4 = this._outputTail;
        this._outputTail = i4 + 1;
        bbuf[i4] = (byte) ((c & 63) | 128);
    }

    private int _outputMultiByteChar(int ch, int outputPtr) throws IOException {
        byte[] bbuf = this._outputBuffer;
        if (ch < SURR1_FIRST || ch > SURR2_LAST) {
            int outputPtr2 = outputPtr + 1;
            bbuf[outputPtr] = (byte) ((ch >> 12) | 224);
            int outputPtr3 = outputPtr2 + 1;
            bbuf[outputPtr2] = (byte) (((ch >> 6) & 63) | 128);
            bbuf[outputPtr3] = (byte) ((ch & 63) | 128);
            return outputPtr3 + 1;
        }
        int outputPtr4 = outputPtr + 1;
        bbuf[outputPtr] = BYTE_BACKSLASH;
        int outputPtr5 = outputPtr4 + 1;
        bbuf[outputPtr4] = BYTE_u;
        int outputPtr6 = outputPtr5 + 1;
        bbuf[outputPtr5] = HEX_CHARS[(ch >> 12) & 15];
        int outputPtr7 = outputPtr6 + 1;
        bbuf[outputPtr6] = HEX_CHARS[(ch >> 8) & 15];
        int outputPtr8 = outputPtr7 + 1;
        bbuf[outputPtr7] = HEX_CHARS[(ch >> 4) & 15];
        int outputPtr9 = outputPtr8 + 1;
        bbuf[outputPtr8] = HEX_CHARS[ch & 15];
        return outputPtr9;
    }

    /* access modifiers changed from: protected */
    public final int _decodeSurrogate(int surr1, int surr2) throws IOException {
        if (surr2 < SURR2_FIRST || surr2 > SURR2_LAST) {
            _reportError("Incomplete surrogate pair: first char 0x" + Integer.toHexString(surr1) + ", second 0x" + Integer.toHexString(surr2));
        }
        return 65536 + ((surr1 - SURR1_FIRST) << 10) + (surr2 - SURR2_FIRST);
    }

    private void _writeNull() throws IOException {
        if (this._outputTail + 4 >= this._outputEnd) {
            _flushBuffer();
        }
        System.arraycopy(NULL_BYTES, 0, this._outputBuffer, this._outputTail, 4);
        this._outputTail += 4;
    }

    private int _writeGenericEscape(int charToEscape, int outputPtr) throws IOException {
        int outputPtr2;
        byte[] bbuf = this._outputBuffer;
        int outputPtr3 = outputPtr + 1;
        bbuf[outputPtr] = BYTE_BACKSLASH;
        int outputPtr4 = outputPtr3 + 1;
        bbuf[outputPtr3] = BYTE_u;
        if (charToEscape > 255) {
            int hi = (charToEscape >> 8) & MotionEventCompat.ACTION_MASK;
            int outputPtr5 = outputPtr4 + 1;
            bbuf[outputPtr4] = HEX_CHARS[hi >> 4];
            outputPtr2 = outputPtr5 + 1;
            bbuf[outputPtr5] = HEX_CHARS[hi & 15];
            charToEscape &= MotionEventCompat.ACTION_MASK;
        } else {
            int outputPtr6 = outputPtr4 + 1;
            bbuf[outputPtr4] = BYTE_0;
            outputPtr2 = outputPtr6 + 1;
            bbuf[outputPtr6] = BYTE_0;
        }
        int outputPtr7 = outputPtr2 + 1;
        bbuf[outputPtr2] = HEX_CHARS[charToEscape >> 4];
        int outputPtr8 = outputPtr7 + 1;
        bbuf[outputPtr7] = HEX_CHARS[charToEscape & 15];
        return outputPtr8;
    }

    /* access modifiers changed from: protected */
    public final void _flushBuffer() throws IOException {
        int len = this._outputTail;
        if (len > 0) {
            this._outputTail = 0;
            this._outputStream.write(this._outputBuffer, 0, len);
        }
    }
}
