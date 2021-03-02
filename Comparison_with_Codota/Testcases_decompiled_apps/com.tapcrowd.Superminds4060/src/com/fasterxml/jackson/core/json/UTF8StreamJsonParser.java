package com.fasterxml.jackson.core.json;

import android.support.p000v4.view.MotionEventCompat;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.p003io.CharTypes;
import com.fasterxml.jackson.core.p003io.IOContext;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.core.sym.Name;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.flurry.android.Constants;
import com.google.android.gms.location.LocationRequest;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class UTF8StreamJsonParser extends ParserBase {
    static final byte BYTE_LF = 10;
    private static final int[] sInputCodesLatin1 = CharTypes.getInputCodeLatin1();
    private static final int[] sInputCodesUtf8 = CharTypes.getInputCodeUtf8();
    protected boolean _bufferRecyclable;
    protected byte[] _inputBuffer;
    protected InputStream _inputStream;
    protected ObjectCodec _objectCodec;
    private int _quad1;
    protected int[] _quadBuffer = new int[16];
    protected final BytesToNameCanonicalizer _symbols;
    protected boolean _tokenIncomplete = false;

    public UTF8StreamJsonParser(IOContext ctxt, int features, InputStream in, ObjectCodec codec, BytesToNameCanonicalizer sym, byte[] inputBuffer, int start, int end, boolean bufferRecyclable) {
        super(ctxt, features);
        this._inputStream = in;
        this._objectCodec = codec;
        this._symbols = sym;
        this._inputBuffer = inputBuffer;
        this._inputPtr = start;
        this._inputEnd = end;
        this._bufferRecyclable = bufferRecyclable;
    }

    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    public void setCodec(ObjectCodec c) {
        this._objectCodec = c;
    }

    public Version version() {
        return CoreVersion.instance.version();
    }

    public int releaseBuffered(OutputStream out) throws IOException {
        int count = this._inputEnd - this._inputPtr;
        if (count < 1) {
            return 0;
        }
        out.write(this._inputBuffer, this._inputPtr, count);
        return count;
    }

    public Object getInputSource() {
        return this._inputStream;
    }

    /* access modifiers changed from: protected */
    public boolean loadMore() throws IOException {
        this._currInputProcessed += (long) this._inputEnd;
        this._currInputRowStart -= this._inputEnd;
        if (this._inputStream == null) {
            return false;
        }
        int count = this._inputStream.read(this._inputBuffer, 0, this._inputBuffer.length);
        if (count > 0) {
            this._inputPtr = 0;
            this._inputEnd = count;
            return true;
        }
        _closeInput();
        if (count != 0) {
            return false;
        }
        throw new IOException("InputStream.read() returned 0 characters when trying to read " + this._inputBuffer.length + " bytes");
    }

    /* access modifiers changed from: protected */
    public boolean _loadToHaveAtLeast(int minAvailable) throws IOException {
        if (this._inputStream == null) {
            return false;
        }
        int amount = this._inputEnd - this._inputPtr;
        if (amount <= 0 || this._inputPtr <= 0) {
            this._inputEnd = 0;
        } else {
            this._currInputProcessed += (long) this._inputPtr;
            this._currInputRowStart -= this._inputPtr;
            System.arraycopy(this._inputBuffer, this._inputPtr, this._inputBuffer, 0, amount);
            this._inputEnd = amount;
        }
        this._inputPtr = 0;
        while (this._inputEnd < minAvailable) {
            int count = this._inputStream.read(this._inputBuffer, this._inputEnd, this._inputBuffer.length - this._inputEnd);
            if (count < 1) {
                _closeInput();
                if (count != 0) {
                    return false;
                }
                throw new IOException("InputStream.read() returned 0 characters when trying to read " + amount + " bytes");
            }
            this._inputEnd += count;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void _closeInput() throws IOException {
        if (this._inputStream != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this._inputStream.close();
            }
            this._inputStream = null;
        }
    }

    /* access modifiers changed from: protected */
    public void _releaseBuffers() throws IOException {
        byte[] buf;
        super._releaseBuffers();
        if (this._bufferRecyclable && (buf = this._inputBuffer) != null) {
            this._inputBuffer = null;
            this._ioContext.releaseReadIOBuffer(buf);
        }
    }

    public String getText() throws IOException, JsonParseException {
        if (this._currToken != JsonToken.VALUE_STRING) {
            return _getText2(this._currToken);
        }
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.contentsAsString();
    }

    public String getValueAsString() throws IOException, JsonParseException {
        if (this._currToken != JsonToken.VALUE_STRING) {
            return super.getValueAsString((String) null);
        }
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.contentsAsString();
    }

    public String getValueAsString(String defValue) throws IOException, JsonParseException {
        if (this._currToken != JsonToken.VALUE_STRING) {
            return super.getValueAsString(defValue);
        }
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.contentsAsString();
    }

    /* access modifiers changed from: protected */
    public String _getText2(JsonToken t) {
        if (t == null) {
            return null;
        }
        switch (t) {
            case FIELD_NAME:
                return this._parsingContext.getCurrentName();
            case VALUE_STRING:
            case VALUE_NUMBER_INT:
            case VALUE_NUMBER_FLOAT:
                return this._textBuffer.contentsAsString();
            default:
                return t.asString();
        }
    }

    public char[] getTextCharacters() throws IOException, JsonParseException {
        if (this._currToken == null) {
            return null;
        }
        switch (this._currToken) {
            case FIELD_NAME:
                if (!this._nameCopied) {
                    String name = this._parsingContext.getCurrentName();
                    int nameLen = name.length();
                    if (this._nameCopyBuffer == null) {
                        this._nameCopyBuffer = this._ioContext.allocNameCopyBuffer(nameLen);
                    } else if (this._nameCopyBuffer.length < nameLen) {
                        this._nameCopyBuffer = new char[nameLen];
                    }
                    name.getChars(0, nameLen, this._nameCopyBuffer, 0);
                    this._nameCopied = true;
                }
                return this._nameCopyBuffer;
            case VALUE_STRING:
                if (this._tokenIncomplete) {
                    this._tokenIncomplete = false;
                    _finishString();
                    break;
                }
                break;
            case VALUE_NUMBER_INT:
            case VALUE_NUMBER_FLOAT:
                break;
            default:
                return this._currToken.asCharArray();
        }
        return this._textBuffer.getTextBuffer();
    }

    public int getTextLength() throws IOException, JsonParseException {
        if (this._currToken == null) {
            return 0;
        }
        switch (this._currToken) {
            case FIELD_NAME:
                return this._parsingContext.getCurrentName().length();
            case VALUE_STRING:
                if (this._tokenIncomplete) {
                    this._tokenIncomplete = false;
                    _finishString();
                    break;
                }
                break;
            case VALUE_NUMBER_INT:
            case VALUE_NUMBER_FLOAT:
                break;
            default:
                return this._currToken.asCharArray().length;
        }
        return this._textBuffer.size();
    }

    public int getTextOffset() throws IOException, JsonParseException {
        if (this._currToken == null) {
            return 0;
        }
        switch (this._currToken) {
            case VALUE_STRING:
                if (this._tokenIncomplete) {
                    this._tokenIncomplete = false;
                    _finishString();
                    break;
                }
                break;
            case VALUE_NUMBER_INT:
            case VALUE_NUMBER_FLOAT:
                break;
            default:
                return 0;
        }
        return this._textBuffer.getTextOffset();
    }

    public Object getEmbeddedObject() throws IOException, JsonParseException {
        return null;
    }

    public byte[] getBinaryValue(Base64Variant b64variant) throws IOException, JsonParseException {
        if (this._currToken != JsonToken.VALUE_STRING && (this._currToken != JsonToken.VALUE_EMBEDDED_OBJECT || this._binaryValue == null)) {
            _reportError("Current token (" + this._currToken + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this._tokenIncomplete) {
            try {
                this._binaryValue = _decodeBase64(b64variant);
                this._tokenIncomplete = false;
            } catch (IllegalArgumentException iae) {
                throw _constructError("Failed to decode VALUE_STRING as base64 (" + b64variant + "): " + iae.getMessage());
            }
        } else if (this._binaryValue == null) {
            ByteArrayBuilder builder = _getByteArrayBuilder();
            _decodeBase64(getText(), builder, b64variant);
            this._binaryValue = builder.toByteArray();
        }
        return this._binaryValue;
    }

    public int readBinaryValue(Base64Variant b64variant, OutputStream out) throws IOException, JsonParseException {
        if (!this._tokenIncomplete || this._currToken != JsonToken.VALUE_STRING) {
            byte[] b = getBinaryValue(b64variant);
            out.write(b);
            return b.length;
        }
        byte[] buf = this._ioContext.allocBase64Buffer();
        try {
            return _readBinary(b64variant, out, buf);
        } finally {
            this._ioContext.releaseBase64Buffer(buf);
        }
    }

    /* access modifiers changed from: protected */
    public int _readBinary(Base64Variant b64variant, OutputStream out, byte[] buffer) throws IOException, JsonParseException {
        int outputPtr = 0;
        int outputEnd = buffer.length - 3;
        int outputCount = 0;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int ch = bArr[i] & MotionEventCompat.ACTION_MASK;
            if (ch > 32) {
                int bits = b64variant.decodeBase64Char(ch);
                if (bits < 0) {
                    if (ch == 34) {
                        break;
                    }
                    bits = _decodeBase64Escape(b64variant, ch, 0);
                    if (bits < 0) {
                        continue;
                    }
                }
                if (outputPtr > outputEnd) {
                    outputCount += outputPtr;
                    out.write(buffer, 0, outputPtr);
                    outputPtr = 0;
                }
                int decodedData = bits;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr2 = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                int ch2 = bArr2[i2] & MotionEventCompat.ACTION_MASK;
                int bits2 = b64variant.decodeBase64Char(ch2);
                if (bits2 < 0) {
                    bits2 = _decodeBase64Escape(b64variant, ch2, 1);
                }
                int decodedData2 = (decodedData << 6) | bits2;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                int ch3 = bArr3[i3] & MotionEventCompat.ACTION_MASK;
                int bits3 = b64variant.decodeBase64Char(ch3);
                if (bits3 < 0) {
                    if (bits3 != -2) {
                        if (ch3 == 34 && !b64variant.usesPadding()) {
                            buffer[outputPtr] = (byte) (decodedData2 >> 4);
                            outputPtr++;
                            break;
                        }
                        bits3 = _decodeBase64Escape(b64variant, ch3, 2);
                    }
                    if (bits3 == -2) {
                        if (this._inputPtr >= this._inputEnd) {
                            loadMoreGuaranteed();
                        }
                        byte[] bArr4 = this._inputBuffer;
                        int i4 = this._inputPtr;
                        this._inputPtr = i4 + 1;
                        int ch4 = bArr4[i4] & MotionEventCompat.ACTION_MASK;
                        if (!b64variant.usesPaddingChar(ch4)) {
                            throw reportInvalidBase64Char(b64variant, ch4, 3, "expected padding character '" + b64variant.getPaddingChar() + "'");
                        }
                        buffer[outputPtr] = (byte) (decodedData2 >> 4);
                        outputPtr++;
                    }
                }
                int decodedData3 = (decodedData2 << 6) | bits3;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr5 = this._inputBuffer;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                int ch5 = bArr5[i5] & MotionEventCompat.ACTION_MASK;
                int bits4 = b64variant.decodeBase64Char(ch5);
                if (bits4 < 0) {
                    if (bits4 != -2) {
                        if (ch5 == 34 && !b64variant.usesPadding()) {
                            int decodedData4 = decodedData3 >> 2;
                            int outputPtr2 = outputPtr + 1;
                            buffer[outputPtr] = (byte) (decodedData4 >> 8);
                            outputPtr = outputPtr2 + 1;
                            buffer[outputPtr2] = (byte) decodedData4;
                            break;
                        }
                        bits4 = _decodeBase64Escape(b64variant, ch5, 3);
                    }
                    if (bits4 == -2) {
                        int decodedData5 = decodedData3 >> 2;
                        int outputPtr3 = outputPtr + 1;
                        buffer[outputPtr] = (byte) (decodedData5 >> 8);
                        outputPtr = outputPtr3 + 1;
                        buffer[outputPtr3] = (byte) decodedData5;
                    }
                }
                int decodedData6 = (decodedData3 << 6) | bits4;
                int outputPtr4 = outputPtr + 1;
                buffer[outputPtr] = (byte) (decodedData6 >> 16);
                int outputPtr5 = outputPtr4 + 1;
                buffer[outputPtr4] = (byte) (decodedData6 >> 8);
                buffer[outputPtr5] = (byte) decodedData6;
                outputPtr = outputPtr5 + 1;
            }
        }
        this._tokenIncomplete = false;
        if (outputPtr <= 0) {
            return outputCount;
        }
        int outputCount2 = outputCount + outputPtr;
        out.write(buffer, 0, outputPtr);
        return outputCount2;
    }

    public JsonToken nextToken() throws IOException, JsonParseException {
        JsonToken t;
        this._numTypesValid = 0;
        if (this._currToken == JsonToken.FIELD_NAME) {
            return _nextAfterName();
        }
        if (this._tokenIncomplete) {
            _skipString();
        }
        int i = _skipWSOrEnd();
        if (i < 0) {
            close();
            this._currToken = null;
            return null;
        }
        this._tokenInputTotal = (this._currInputProcessed + ((long) this._inputPtr)) - 1;
        this._tokenInputRow = this._currInputRow;
        this._tokenInputCol = (this._inputPtr - this._currInputRowStart) - 1;
        this._binaryValue = null;
        if (i == 93) {
            if (!this._parsingContext.inArray()) {
                _reportMismatchedEndMarker(i, '}');
            }
            this._parsingContext = this._parsingContext.getParent();
            JsonToken jsonToken = JsonToken.END_ARRAY;
            this._currToken = jsonToken;
            return jsonToken;
        } else if (i == 125) {
            if (!this._parsingContext.inObject()) {
                _reportMismatchedEndMarker(i, ']');
            }
            this._parsingContext = this._parsingContext.getParent();
            JsonToken jsonToken2 = JsonToken.END_OBJECT;
            this._currToken = jsonToken2;
            return jsonToken2;
        } else {
            if (this._parsingContext.expectComma()) {
                if (i != 44) {
                    _reportUnexpectedChar(i, "was expecting comma to separate " + this._parsingContext.getTypeDesc() + " entries");
                }
                i = _skipWS();
            }
            if (!this._parsingContext.inObject()) {
                return _nextTokenNotInObject(i);
            }
            this._parsingContext.setCurrentName(_parseFieldName(i).getName());
            this._currToken = JsonToken.FIELD_NAME;
            int i2 = _skipWS();
            if (i2 != 58) {
                _reportUnexpectedChar(i2, "was expecting a colon to separate field name and value");
            }
            int i3 = _skipWS();
            if (i3 == 34) {
                this._tokenIncomplete = true;
                this._nextToken = JsonToken.VALUE_STRING;
                return this._currToken;
            }
            switch (i3) {
                case 45:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    t = parseNumberText(i3);
                    break;
                case 91:
                    t = JsonToken.START_ARRAY;
                    break;
                case 93:
                case 125:
                    _reportUnexpectedChar(i3, "expected a value");
                    break;
                case LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
                    _matchToken("false", 1);
                    t = JsonToken.VALUE_FALSE;
                    break;
                case 110:
                    _matchToken("null", 1);
                    t = JsonToken.VALUE_NULL;
                    break;
                case 116:
                    break;
                case 123:
                    t = JsonToken.START_OBJECT;
                    break;
                default:
                    t = _handleUnexpectedValue(i3);
                    break;
            }
            _matchToken("true", 1);
            t = JsonToken.VALUE_TRUE;
            this._nextToken = t;
            return this._currToken;
        }
    }

    private JsonToken _nextTokenNotInObject(int i) throws IOException, JsonParseException {
        if (i == 34) {
            this._tokenIncomplete = true;
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            this._currToken = jsonToken;
            return jsonToken;
        }
        switch (i) {
            case 45:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                JsonToken parseNumberText = parseNumberText(i);
                this._currToken = parseNumberText;
                return parseNumberText;
            case 91:
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                JsonToken jsonToken2 = JsonToken.START_ARRAY;
                this._currToken = jsonToken2;
                return jsonToken2;
            case 93:
            case 125:
                _reportUnexpectedChar(i, "expected a value");
                break;
            case LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
                _matchToken("false", 1);
                JsonToken jsonToken3 = JsonToken.VALUE_FALSE;
                this._currToken = jsonToken3;
                return jsonToken3;
            case 110:
                _matchToken("null", 1);
                JsonToken jsonToken4 = JsonToken.VALUE_NULL;
                this._currToken = jsonToken4;
                return jsonToken4;
            case 116:
                break;
            case 123:
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                JsonToken jsonToken5 = JsonToken.START_OBJECT;
                this._currToken = jsonToken5;
                return jsonToken5;
            default:
                JsonToken _handleUnexpectedValue = _handleUnexpectedValue(i);
                this._currToken = _handleUnexpectedValue;
                return _handleUnexpectedValue;
        }
        _matchToken("true", 1);
        JsonToken jsonToken6 = JsonToken.VALUE_TRUE;
        this._currToken = jsonToken6;
        return jsonToken6;
    }

    private JsonToken _nextAfterName() {
        this._nameCopied = false;
        JsonToken t = this._nextToken;
        this._nextToken = null;
        if (t == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (t == JsonToken.START_OBJECT) {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        this._currToken = t;
        return t;
    }

    public void close() throws IOException {
        super.close();
        this._symbols.release();
    }

    public boolean nextFieldName(SerializableString str) throws IOException, JsonParseException {
        this._numTypesValid = 0;
        if (this._currToken == JsonToken.FIELD_NAME) {
            _nextAfterName();
            return false;
        }
        if (this._tokenIncomplete) {
            _skipString();
        }
        int i = _skipWSOrEnd();
        if (i < 0) {
            close();
            this._currToken = null;
            return false;
        }
        this._tokenInputTotal = (this._currInputProcessed + ((long) this._inputPtr)) - 1;
        this._tokenInputRow = this._currInputRow;
        this._tokenInputCol = (this._inputPtr - this._currInputRowStart) - 1;
        this._binaryValue = null;
        if (i == 93) {
            if (!this._parsingContext.inArray()) {
                _reportMismatchedEndMarker(i, '}');
            }
            this._parsingContext = this._parsingContext.getParent();
            this._currToken = JsonToken.END_ARRAY;
            return false;
        } else if (i == 125) {
            if (!this._parsingContext.inObject()) {
                _reportMismatchedEndMarker(i, ']');
            }
            this._parsingContext = this._parsingContext.getParent();
            this._currToken = JsonToken.END_OBJECT;
            return false;
        } else {
            if (this._parsingContext.expectComma()) {
                if (i != 44) {
                    _reportUnexpectedChar(i, "was expecting comma to separate " + this._parsingContext.getTypeDesc() + " entries");
                }
                i = _skipWS();
            }
            if (!this._parsingContext.inObject()) {
                _nextTokenNotInObject(i);
                return false;
            }
            if (i == 34) {
                byte[] nameBytes = str.asQuotedUTF8();
                int len = nameBytes.length;
                if (this._inputPtr + len < this._inputEnd) {
                    int end = this._inputPtr + len;
                    if (this._inputBuffer[end] == 34) {
                        int offset = 0;
                        int ptr = this._inputPtr;
                        while (offset != len) {
                            if (nameBytes[offset] == this._inputBuffer[ptr + offset]) {
                                offset++;
                            }
                        }
                        this._inputPtr = end + 1;
                        this._parsingContext.setCurrentName(str.getValue());
                        this._currToken = JsonToken.FIELD_NAME;
                        _isNextTokenNameYes();
                        return true;
                    }
                }
            }
            return _isNextTokenNameMaybe(i, str);
        }
    }

    private void _isNextTokenNameYes() throws IOException, JsonParseException {
        int i;
        if (this._inputPtr >= this._inputEnd || this._inputBuffer[this._inputPtr] != 58) {
            i = _skipColon();
        } else {
            this._inputPtr++;
            byte[] bArr = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            byte i3 = bArr[i2];
            if (i3 == 34) {
                this._tokenIncomplete = true;
                this._nextToken = JsonToken.VALUE_STRING;
                return;
            } else if (i3 == 123) {
                this._nextToken = JsonToken.START_OBJECT;
                return;
            } else if (i3 == 91) {
                this._nextToken = JsonToken.START_ARRAY;
                return;
            } else {
                i = i3 & Constants.UNKNOWN;
                if (i <= 32 || i == 47) {
                    this._inputPtr--;
                    i = _skipWS();
                }
            }
        }
        switch (i) {
            case 34:
                this._tokenIncomplete = true;
                this._nextToken = JsonToken.VALUE_STRING;
                return;
            case 45:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                this._nextToken = parseNumberText(i);
                return;
            case 91:
                this._nextToken = JsonToken.START_ARRAY;
                return;
            case 93:
            case 125:
                _reportUnexpectedChar(i, "expected a value");
                break;
            case LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
                _matchToken("false", 1);
                this._nextToken = JsonToken.VALUE_FALSE;
                return;
            case 110:
                _matchToken("null", 1);
                this._nextToken = JsonToken.VALUE_NULL;
                return;
            case 116:
                break;
            case 123:
                this._nextToken = JsonToken.START_OBJECT;
                return;
            default:
                this._nextToken = _handleUnexpectedValue(i);
                return;
        }
        _matchToken("true", 1);
        this._nextToken = JsonToken.VALUE_TRUE;
    }

    private boolean _isNextTokenNameMaybe(int i, SerializableString str) throws IOException, JsonParseException {
        JsonToken t;
        String nameStr = _parseFieldName(i).getName();
        this._parsingContext.setCurrentName(nameStr);
        boolean match = nameStr.equals(str.getValue());
        this._currToken = JsonToken.FIELD_NAME;
        int i2 = _skipWS();
        if (i2 != 58) {
            _reportUnexpectedChar(i2, "was expecting a colon to separate field name and value");
        }
        int i3 = _skipWS();
        if (i3 == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
        } else {
            switch (i3) {
                case 45:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    t = parseNumberText(i3);
                    break;
                case 91:
                    t = JsonToken.START_ARRAY;
                    break;
                case 93:
                case 125:
                    _reportUnexpectedChar(i3, "expected a value");
                    break;
                case LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
                    _matchToken("false", 1);
                    t = JsonToken.VALUE_FALSE;
                    break;
                case 110:
                    _matchToken("null", 1);
                    t = JsonToken.VALUE_NULL;
                    break;
                case 116:
                    break;
                case 123:
                    t = JsonToken.START_OBJECT;
                    break;
                default:
                    t = _handleUnexpectedValue(i3);
                    break;
            }
            _matchToken("true", 1);
            t = JsonToken.VALUE_TRUE;
            this._nextToken = t;
        }
        return match;
    }

    public String nextTextValue() throws IOException, JsonParseException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nameCopied = false;
            JsonToken t = this._nextToken;
            this._nextToken = null;
            this._currToken = t;
            if (t == JsonToken.VALUE_STRING) {
                if (this._tokenIncomplete) {
                    this._tokenIncomplete = false;
                    _finishString();
                }
                return this._textBuffer.contentsAsString();
            } else if (t == JsonToken.START_ARRAY) {
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                return null;
            } else if (t != JsonToken.START_OBJECT) {
                return null;
            } else {
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                return null;
            }
        } else if (nextToken() == JsonToken.VALUE_STRING) {
            return getText();
        } else {
            return null;
        }
    }

    public int nextIntValue(int defaultValue) throws IOException, JsonParseException {
        if (this._currToken != JsonToken.FIELD_NAME) {
            return nextToken() == JsonToken.VALUE_NUMBER_INT ? getIntValue() : defaultValue;
        }
        this._nameCopied = false;
        JsonToken t = this._nextToken;
        this._nextToken = null;
        this._currToken = t;
        if (t == JsonToken.VALUE_NUMBER_INT) {
            return getIntValue();
        }
        if (t == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
            return defaultValue;
        } else if (t != JsonToken.START_OBJECT) {
            return defaultValue;
        } else {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
            return defaultValue;
        }
    }

    public long nextLongValue(long defaultValue) throws IOException, JsonParseException {
        if (this._currToken != JsonToken.FIELD_NAME) {
            return nextToken() == JsonToken.VALUE_NUMBER_INT ? getLongValue() : defaultValue;
        }
        this._nameCopied = false;
        JsonToken t = this._nextToken;
        this._nextToken = null;
        this._currToken = t;
        if (t == JsonToken.VALUE_NUMBER_INT) {
            return getLongValue();
        }
        if (t == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
            return defaultValue;
        } else if (t != JsonToken.START_OBJECT) {
            return defaultValue;
        } else {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
            return defaultValue;
        }
    }

    public Boolean nextBooleanValue() throws IOException, JsonParseException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nameCopied = false;
            JsonToken t = this._nextToken;
            this._nextToken = null;
            this._currToken = t;
            if (t == JsonToken.VALUE_TRUE) {
                return Boolean.TRUE;
            }
            if (t == JsonToken.VALUE_FALSE) {
                return Boolean.FALSE;
            }
            if (t == JsonToken.START_ARRAY) {
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                return null;
            } else if (t != JsonToken.START_OBJECT) {
                return null;
            } else {
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                return null;
            }
        } else {
            switch (nextToken()) {
                case VALUE_TRUE:
                    return Boolean.TRUE;
                case VALUE_FALSE:
                    return Boolean.FALSE;
                default:
                    return null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public JsonToken parseNumberText(int c) throws IOException, JsonParseException {
        int outPtr;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        boolean negative = c == 45;
        if (negative) {
            outPtr = 0 + 1;
            outBuf[0] = '-';
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            c = bArr[i] & Constants.UNKNOWN;
            if (c < 48 || c > 57) {
                int i2 = outPtr;
                return _handleInvalidNumberStart(c, true);
            }
        } else {
            outPtr = 0;
        }
        if (c == 48) {
            c = _verifyNoLeadingZeroes();
        }
        int outPtr2 = outPtr + 1;
        outBuf[outPtr] = (char) c;
        int intLen = 1;
        int end = this._inputPtr + outBuf.length;
        if (end > this._inputEnd) {
            end = this._inputEnd;
        }
        while (this._inputPtr < end) {
            byte[] bArr2 = this._inputBuffer;
            int i3 = this._inputPtr;
            this._inputPtr = i3 + 1;
            int c2 = bArr2[i3] & MotionEventCompat.ACTION_MASK;
            if (c2 >= 48 && c2 <= 57) {
                intLen++;
                outBuf[outPtr2] = (char) c2;
                outPtr2++;
            } else if (c2 == 46 || c2 == 101 || c2 == 69) {
                return _parseFloatText(outBuf, outPtr2, c2, negative, intLen);
            } else {
                this._inputPtr--;
                this._textBuffer.setCurrentLength(outPtr2);
                return resetInt(negative, intLen);
            }
        }
        return _parserNumber2(outBuf, outPtr2, negative, intLen);
    }

    private JsonToken _parserNumber2(char[] outBuf, int outPtr, boolean negative, int intPartLength) throws IOException, JsonParseException {
        int c;
        while (true) {
            if (this._inputPtr < this._inputEnd || loadMore()) {
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                c = bArr[i] & MotionEventCompat.ACTION_MASK;
                if (c <= 57 && c >= 48) {
                    if (outPtr >= outBuf.length) {
                        outBuf = this._textBuffer.finishCurrentSegment();
                        outPtr = 0;
                    }
                    outBuf[outPtr] = (char) c;
                    intPartLength++;
                    outPtr++;
                }
            } else {
                this._textBuffer.setCurrentLength(outPtr);
                return resetInt(negative, intPartLength);
            }
        }
        if (c == 46 || c == 101 || c == 69) {
            return _parseFloatText(outBuf, outPtr, c, negative, intPartLength);
        }
        this._inputPtr--;
        this._textBuffer.setCurrentLength(outPtr);
        return resetInt(negative, intPartLength);
    }

    private int _verifyNoLeadingZeroes() throws IOException, JsonParseException {
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            return 48;
        }
        int ch = this._inputBuffer[this._inputPtr] & MotionEventCompat.ACTION_MASK;
        if (ch < 48 || ch > 57) {
            return 48;
        }
        if (!isEnabled(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            reportInvalidNumber("Leading zeroes not allowed");
        }
        this._inputPtr++;
        if (ch != 48) {
            return ch;
        }
        do {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                return ch;
            }
            ch = this._inputBuffer[this._inputPtr] & MotionEventCompat.ACTION_MASK;
            if (ch < 48 || ch > 57) {
                return 48;
            }
            this._inputPtr++;
        } while (ch == 48);
        return ch;
    }

    private JsonToken _parseFloatText(char[] outBuf, int outPtr, int c, boolean negative, int integerPartLength) throws IOException, JsonParseException {
        int outPtr2;
        int fractLen = 0;
        boolean eof = false;
        if (c == 46) {
            int outPtr3 = outPtr + 1;
            outBuf[outPtr] = (char) c;
            while (true) {
                outPtr = outPtr3;
                if (this._inputPtr >= this._inputEnd && !loadMore()) {
                    eof = true;
                    break;
                }
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                c = bArr[i] & Constants.UNKNOWN;
                if (c < 48 || c > 57) {
                    break;
                }
                fractLen++;
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                }
                outPtr3 = outPtr + 1;
                outBuf[outPtr] = (char) c;
            }
            if (fractLen == 0) {
                reportUnexpectedNumberChar(c, "Decimal point not followed by a digit");
            }
        }
        int expLen = 0;
        if (c == 101 || c == 69) {
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            int outPtr4 = outPtr + 1;
            outBuf[outPtr] = (char) c;
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr2 = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            int c2 = bArr2[i2] & MotionEventCompat.ACTION_MASK;
            if (c2 == 45 || c2 == 43) {
                if (outPtr4 >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr2 = 0;
                } else {
                    outPtr2 = outPtr4;
                }
                int outPtr5 = outPtr2 + 1;
                outBuf[outPtr2] = (char) c2;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                c2 = bArr3[i3] & MotionEventCompat.ACTION_MASK;
                outPtr = outPtr5;
            } else {
                outPtr = outPtr4;
            }
            while (true) {
                if (c2 > 57 || c2 < 48) {
                    break;
                }
                expLen++;
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                }
                int outPtr6 = outPtr + 1;
                outBuf[outPtr] = (char) c2;
                if (this._inputPtr >= this._inputEnd && !loadMore()) {
                    eof = true;
                    outPtr = outPtr6;
                    break;
                }
                byte[] bArr4 = this._inputBuffer;
                int i4 = this._inputPtr;
                this._inputPtr = i4 + 1;
                c2 = bArr4[i4] & MotionEventCompat.ACTION_MASK;
                outPtr = outPtr6;
            }
            if (expLen == 0) {
                reportUnexpectedNumberChar(c2, "Exponent indicator not followed by a digit");
            }
        }
        if (!eof) {
            this._inputPtr--;
        }
        this._textBuffer.setCurrentLength(outPtr);
        return resetFloat(negative, integerPartLength, fractLen, expLen);
    }

    /* access modifiers changed from: protected */
    public Name _parseFieldName(int i) throws IOException, JsonParseException {
        if (i != 34) {
            return _handleUnusualFieldName(i);
        }
        if (this._inputPtr + 9 > this._inputEnd) {
            return slowParseFieldName();
        }
        byte[] input = this._inputBuffer;
        int[] codes = sInputCodesLatin1;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        int q = input[i2] & MotionEventCompat.ACTION_MASK;
        if (codes[q] == 0) {
            int i3 = this._inputPtr;
            this._inputPtr = i3 + 1;
            int i4 = input[i3] & MotionEventCompat.ACTION_MASK;
            if (codes[i4] == 0) {
                int q2 = (q << 8) | i4;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                int i6 = input[i5] & MotionEventCompat.ACTION_MASK;
                if (codes[i6] == 0) {
                    int q3 = (q2 << 8) | i6;
                    int i7 = this._inputPtr;
                    this._inputPtr = i7 + 1;
                    int i8 = input[i7] & MotionEventCompat.ACTION_MASK;
                    if (codes[i8] == 0) {
                        int q4 = (q3 << 8) | i8;
                        int i9 = this._inputPtr;
                        this._inputPtr = i9 + 1;
                        int i10 = input[i9] & MotionEventCompat.ACTION_MASK;
                        if (codes[i10] == 0) {
                            this._quad1 = q4;
                            return parseMediumFieldName(i10, codes);
                        } else if (i10 == 34) {
                            return findName(q4, 4);
                        } else {
                            return parseFieldName(q4, i10, 4);
                        }
                    } else if (i8 == 34) {
                        return findName(q3, 3);
                    } else {
                        return parseFieldName(q3, i8, 3);
                    }
                } else if (i6 == 34) {
                    return findName(q2, 2);
                } else {
                    return parseFieldName(q2, i6, 2);
                }
            } else if (i4 == 34) {
                return findName(q, 1);
            } else {
                return parseFieldName(q, i4, 1);
            }
        } else if (q == 34) {
            return BytesToNameCanonicalizer.getEmptyName();
        } else {
            return parseFieldName(0, q, 0);
        }
    }

    /* access modifiers changed from: protected */
    public Name parseMediumFieldName(int q2, int[] codes) throws IOException, JsonParseException {
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
        if (codes[i2] == 0) {
            int q22 = (q2 << 8) | i2;
            byte[] bArr2 = this._inputBuffer;
            int i3 = this._inputPtr;
            this._inputPtr = i3 + 1;
            int i4 = bArr2[i3] & MotionEventCompat.ACTION_MASK;
            if (codes[i4] == 0) {
                int q23 = (q22 << 8) | i4;
                byte[] bArr3 = this._inputBuffer;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                int i6 = bArr3[i5] & MotionEventCompat.ACTION_MASK;
                if (codes[i6] == 0) {
                    int q24 = (q23 << 8) | i6;
                    byte[] bArr4 = this._inputBuffer;
                    int i7 = this._inputPtr;
                    this._inputPtr = i7 + 1;
                    int i8 = bArr4[i7] & MotionEventCompat.ACTION_MASK;
                    if (codes[i8] == 0) {
                        this._quadBuffer[0] = this._quad1;
                        this._quadBuffer[1] = q24;
                        return parseLongFieldName(i8);
                    } else if (i8 == 34) {
                        return findName(this._quad1, q24, 4);
                    } else {
                        return parseFieldName(this._quad1, q24, i8, 4);
                    }
                } else if (i6 == 34) {
                    return findName(this._quad1, q23, 3);
                } else {
                    return parseFieldName(this._quad1, q23, i6, 3);
                }
            } else if (i4 == 34) {
                return findName(this._quad1, q22, 2);
            } else {
                return parseFieldName(this._quad1, q22, i4, 2);
            }
        } else if (i2 == 34) {
            return findName(this._quad1, q2, 1);
        } else {
            return parseFieldName(this._quad1, q2, i2, 1);
        }
    }

    /* access modifiers changed from: protected */
    public Name parseLongFieldName(int q) throws IOException, JsonParseException {
        int[] codes = sInputCodesLatin1;
        int qlen = 2;
        while (this._inputEnd - this._inputPtr >= 4) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
            if (codes[i2] == 0) {
                int q2 = (q << 8) | i2;
                byte[] bArr2 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                int i4 = bArr2[i3] & MotionEventCompat.ACTION_MASK;
                if (codes[i4] == 0) {
                    int q3 = (q2 << 8) | i4;
                    byte[] bArr3 = this._inputBuffer;
                    int i5 = this._inputPtr;
                    this._inputPtr = i5 + 1;
                    int i6 = bArr3[i5] & MotionEventCompat.ACTION_MASK;
                    if (codes[i6] == 0) {
                        int q4 = (q3 << 8) | i6;
                        byte[] bArr4 = this._inputBuffer;
                        int i7 = this._inputPtr;
                        this._inputPtr = i7 + 1;
                        int i8 = bArr4[i7] & MotionEventCompat.ACTION_MASK;
                        if (codes[i8] == 0) {
                            if (qlen >= this._quadBuffer.length) {
                                this._quadBuffer = growArrayBy(this._quadBuffer, qlen);
                            }
                            this._quadBuffer[qlen] = q4;
                            q = i8;
                            qlen++;
                        } else if (i8 == 34) {
                            return findName(this._quadBuffer, qlen, q4, 4);
                        } else {
                            return parseEscapedFieldName(this._quadBuffer, qlen, q4, i8, 4);
                        }
                    } else if (i6 == 34) {
                        return findName(this._quadBuffer, qlen, q3, 3);
                    } else {
                        return parseEscapedFieldName(this._quadBuffer, qlen, q3, i6, 3);
                    }
                } else if (i4 == 34) {
                    return findName(this._quadBuffer, qlen, q2, 2);
                } else {
                    return parseEscapedFieldName(this._quadBuffer, qlen, q2, i4, 2);
                }
            } else if (i2 == 34) {
                return findName(this._quadBuffer, qlen, q, 1);
            } else {
                return parseEscapedFieldName(this._quadBuffer, qlen, q, i2, 1);
            }
        }
        return parseEscapedFieldName(this._quadBuffer, qlen, 0, q, 0);
    }

    /* access modifiers changed from: protected */
    public Name slowParseFieldName() throws IOException, JsonParseException {
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            _reportInvalidEOF(": was expecting closing '\"' for name");
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
        if (i2 == 34) {
            return BytesToNameCanonicalizer.getEmptyName();
        }
        return parseEscapedFieldName(this._quadBuffer, 0, 0, i2, 0);
    }

    private Name parseFieldName(int q1, int ch, int lastQuadBytes) throws IOException, JsonParseException {
        return parseEscapedFieldName(this._quadBuffer, 0, q1, ch, lastQuadBytes);
    }

    private Name parseFieldName(int q1, int q2, int ch, int lastQuadBytes) throws IOException, JsonParseException {
        this._quadBuffer[0] = q1;
        return parseEscapedFieldName(this._quadBuffer, 1, q2, ch, lastQuadBytes);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.core.sym.Name parseEscapedFieldName(int[] r8, int r9, int r10, int r11, int r12) throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r7 = this;
            r6 = 4
            int[] r0 = sInputCodesLatin1
        L_0x0003:
            r3 = r0[r11]
            if (r3 == 0) goto L_0x00c6
            r3 = 34
            if (r11 != r3) goto L_0x0029
            if (r12 <= 0) goto L_0x001c
            int r3 = r8.length
            if (r9 < r3) goto L_0x0017
            int r3 = r8.length
            int[] r8 = growArrayBy(r8, r3)
            r7._quadBuffer = r8
        L_0x0017:
            int r2 = r9 + 1
            r8[r9] = r10
            r9 = r2
        L_0x001c:
            com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer r3 = r7._symbols
            com.fasterxml.jackson.core.sym.Name r1 = r3.findName((int[]) r8, (int) r9)
            if (r1 != 0) goto L_0x0028
            com.fasterxml.jackson.core.sym.Name r1 = r7.addName(r8, r9, r12)
        L_0x0028:
            return r1
        L_0x0029:
            r3 = 92
            if (r11 == r3) goto L_0x0083
            java.lang.String r3 = "name"
            r7._throwUnquotedSpace(r11, r3)
        L_0x0032:
            r3 = 127(0x7f, float:1.78E-43)
            if (r11 <= r3) goto L_0x00c6
            if (r12 < r6) goto L_0x00c4
            int r3 = r8.length
            if (r9 < r3) goto L_0x0042
            int r3 = r8.length
            int[] r8 = growArrayBy(r8, r3)
            r7._quadBuffer = r8
        L_0x0042:
            int r2 = r9 + 1
            r8[r9] = r10
            r10 = 0
            r12 = 0
        L_0x0048:
            r3 = 2048(0x800, float:2.87E-42)
            if (r11 >= r3) goto L_0x0088
            int r3 = r10 << 8
            int r4 = r11 >> 6
            r4 = r4 | 192(0xc0, float:2.69E-43)
            r10 = r3 | r4
            int r12 = r12 + 1
            r9 = r2
        L_0x0057:
            r3 = r11 & 63
            r11 = r3 | 128(0x80, float:1.794E-43)
            r2 = r9
        L_0x005c:
            if (r12 >= r6) goto L_0x00b1
            int r12 = r12 + 1
            int r3 = r10 << 8
            r10 = r3 | r11
            r9 = r2
        L_0x0065:
            int r3 = r7._inputPtr
            int r4 = r7._inputEnd
            if (r3 < r4) goto L_0x0076
            boolean r3 = r7.loadMore()
            if (r3 != 0) goto L_0x0076
            java.lang.String r3 = " in field name"
            r7._reportInvalidEOF(r3)
        L_0x0076:
            byte[] r3 = r7._inputBuffer
            int r4 = r7._inputPtr
            int r5 = r4 + 1
            r7._inputPtr = r5
            byte r3 = r3[r4]
            r11 = r3 & 255(0xff, float:3.57E-43)
            goto L_0x0003
        L_0x0083:
            char r11 = r7._decodeEscaped()
            goto L_0x0032
        L_0x0088:
            int r3 = r10 << 8
            int r4 = r11 >> 12
            r4 = r4 | 224(0xe0, float:3.14E-43)
            r10 = r3 | r4
            int r12 = r12 + 1
            if (r12 < r6) goto L_0x00c2
            int r3 = r8.length
            if (r2 < r3) goto L_0x009e
            int r3 = r8.length
            int[] r8 = growArrayBy(r8, r3)
            r7._quadBuffer = r8
        L_0x009e:
            int r9 = r2 + 1
            r8[r2] = r10
            r10 = 0
            r12 = 0
        L_0x00a4:
            int r3 = r10 << 8
            int r4 = r11 >> 6
            r4 = r4 & 63
            r4 = r4 | 128(0x80, float:1.794E-43)
            r10 = r3 | r4
            int r12 = r12 + 1
            goto L_0x0057
        L_0x00b1:
            int r3 = r8.length
            if (r2 < r3) goto L_0x00bb
            int r3 = r8.length
            int[] r8 = growArrayBy(r8, r3)
            r7._quadBuffer = r8
        L_0x00bb:
            int r9 = r2 + 1
            r8[r2] = r10
            r10 = r11
            r12 = 1
            goto L_0x0065
        L_0x00c2:
            r9 = r2
            goto L_0x00a4
        L_0x00c4:
            r2 = r9
            goto L_0x0048
        L_0x00c6:
            r2 = r9
            goto L_0x005c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.parseEscapedFieldName(int[], int, int, int, int):com.fasterxml.jackson.core.sym.Name");
    }

    /* access modifiers changed from: protected */
    public Name _handleUnusualFieldName(int ch) throws IOException, JsonParseException {
        if (ch == 39 && isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return _parseApostropheFieldName();
        }
        if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            _reportUnexpectedChar(ch, "was expecting double-quote to start field name");
        }
        int[] codes = CharTypes.getInputCodeUtf8JsNames();
        if (codes[ch] != 0) {
            _reportUnexpectedChar(ch, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int[] quads = this._quadBuffer;
        int qlen = 0;
        int currQuad = 0;
        int currQuadBytes = 0;
        while (true) {
            int qlen2 = qlen;
            if (currQuadBytes < 4) {
                currQuadBytes++;
                currQuad = (currQuad << 8) | ch;
                qlen = qlen2;
            } else {
                if (qlen2 >= quads.length) {
                    quads = growArrayBy(quads, quads.length);
                    this._quadBuffer = quads;
                }
                qlen = qlen2 + 1;
                quads[qlen2] = currQuad;
                currQuad = ch;
                currQuadBytes = 1;
            }
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOF(" in field name");
            }
            ch = this._inputBuffer[this._inputPtr] & Constants.UNKNOWN;
            if (codes[ch] != 0) {
                break;
            }
            this._inputPtr++;
        }
        if (currQuadBytes > 0) {
            if (qlen >= quads.length) {
                quads = growArrayBy(quads, quads.length);
                this._quadBuffer = quads;
            }
            quads[qlen] = currQuad;
            qlen++;
        }
        Name name = this._symbols.findName(quads, qlen);
        if (name == null) {
            return addName(quads, qlen, currQuadBytes);
        }
        return name;
    }

    /* access modifiers changed from: protected */
    public Name _parseApostropheFieldName() throws IOException, JsonParseException {
        int currQuadBytes;
        int currQuad;
        int qlen;
        int qlen2;
        int currQuad2;
        int qlen3;
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            _reportInvalidEOF(": was expecting closing ''' for name");
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int ch = bArr[i] & MotionEventCompat.ACTION_MASK;
        if (ch == 39) {
            return BytesToNameCanonicalizer.getEmptyName();
        }
        int[] quads = this._quadBuffer;
        int currQuad3 = 0;
        int currQuadBytes2 = 0;
        int[] codes = sInputCodesLatin1;
        int qlen4 = 0;
        while (ch != 39) {
            if (!(ch == 34 || codes[ch] == 0)) {
                if (ch != 92) {
                    _throwUnquotedSpace(ch, DBFavorites.KEY_NAME);
                } else {
                    ch = _decodeEscaped();
                }
                if (ch > 127) {
                    if (currQuadBytes >= 4) {
                        if (qlen4 >= quads.length) {
                            quads = growArrayBy(quads, quads.length);
                            this._quadBuffer = quads;
                        }
                        quads[qlen4] = currQuad;
                        currQuad = 0;
                        currQuadBytes = 0;
                        qlen4++;
                    }
                    if (ch < 2048) {
                        currQuad = (currQuad << 8) | (ch >> 6) | 192;
                        currQuadBytes++;
                        qlen3 = qlen4;
                    } else {
                        int currQuad4 = (currQuad << 8) | (ch >> 12) | 224;
                        int currQuadBytes3 = currQuadBytes + 1;
                        if (currQuadBytes3 >= 4) {
                            if (qlen4 >= quads.length) {
                                quads = growArrayBy(quads, quads.length);
                                this._quadBuffer = quads;
                            }
                            qlen3 = qlen4 + 1;
                            quads[qlen4] = currQuad4;
                            currQuad4 = 0;
                            currQuadBytes3 = 0;
                        } else {
                            qlen3 = qlen4;
                        }
                        currQuad = (currQuad4 << 8) | ((ch >> 6) & 63) | 128;
                        currQuadBytes = currQuadBytes3 + 1;
                    }
                    ch = (ch & 63) | 128;
                    qlen4 = qlen3;
                }
            }
            if (currQuadBytes < 4) {
                currQuadBytes2 = currQuadBytes + 1;
                currQuad2 = (currQuad << 8) | ch;
                qlen2 = qlen4;
            } else {
                if (qlen4 >= quads.length) {
                    quads = growArrayBy(quads, quads.length);
                    this._quadBuffer = quads;
                }
                qlen2 = qlen4 + 1;
                quads[qlen4] = currQuad;
                currQuad2 = ch;
                currQuadBytes2 = 1;
            }
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOF(" in field name");
            }
            byte[] bArr2 = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            ch = bArr2[i2] & MotionEventCompat.ACTION_MASK;
            qlen4 = qlen2;
            currQuad3 = currQuad2;
        }
        if (currQuadBytes > 0) {
            if (qlen4 >= quads.length) {
                quads = growArrayBy(quads, quads.length);
                this._quadBuffer = quads;
            }
            qlen = qlen4 + 1;
            quads[qlen4] = currQuad;
        } else {
            qlen = qlen4;
        }
        Name name = this._symbols.findName(quads, qlen);
        if (name == null) {
            return addName(quads, qlen, currQuadBytes);
        }
        return name;
    }

    private Name findName(int q1, int lastQuadBytes) throws JsonParseException {
        Name name = this._symbols.findName(q1);
        if (name != null) {
            return name;
        }
        this._quadBuffer[0] = q1;
        return addName(this._quadBuffer, 1, lastQuadBytes);
    }

    private Name findName(int q1, int q2, int lastQuadBytes) throws JsonParseException {
        Name name = this._symbols.findName(q1, q2);
        if (name != null) {
            return name;
        }
        this._quadBuffer[0] = q1;
        this._quadBuffer[1] = q2;
        return addName(this._quadBuffer, 2, lastQuadBytes);
    }

    private Name findName(int[] quads, int qlen, int lastQuad, int lastQuadBytes) throws JsonParseException {
        if (qlen >= quads.length) {
            quads = growArrayBy(quads, quads.length);
            this._quadBuffer = quads;
        }
        int qlen2 = qlen + 1;
        quads[qlen] = lastQuad;
        Name name = this._symbols.findName(quads, qlen2);
        if (name == null) {
            return addName(quads, qlen2, lastQuadBytes);
        }
        return name;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d0 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.fasterxml.jackson.core.sym.Name addName(int[] r15, int r16, int r17) throws com.fasterxml.jackson.core.JsonParseException {
        /*
            r14 = this;
            int r12 = r16 << 2
            int r12 = r12 + -4
            int r3 = r12 + r17
            r12 = 4
            r0 = r17
            if (r0 >= r12) goto L_0x00d7
            int r12 = r16 + -1
            r10 = r15[r12]
            int r12 = r16 + -1
            int r13 = 4 - r17
            int r13 = r13 << 3
            int r13 = r10 << r13
            r15[r12] = r13
        L_0x0019:
            com.fasterxml.jackson.core.util.TextBuffer r12 = r14._textBuffer
            char[] r4 = r12.emptyAndGetCurrentSegment()
            r7 = 0
            r9 = 0
            r8 = r7
        L_0x0022:
            if (r9 >= r3) goto L_0x00f7
            int r12 = r9 >> 2
            r5 = r15[r12]
            r2 = r9 & 3
            int r12 = 3 - r2
            int r12 = r12 << 3
            int r12 = r5 >> r12
            r5 = r12 & 255(0xff, float:3.57E-43)
            int r9 = r9 + 1
            r12 = 127(0x7f, float:1.78E-43)
            if (r5 <= r12) goto L_0x010f
            r12 = r5 & 224(0xe0, float:3.14E-43)
            r13 = 192(0xc0, float:2.69E-43)
            if (r12 != r13) goto L_0x00da
            r5 = r5 & 31
            r11 = 1
        L_0x0041:
            int r12 = r9 + r11
            if (r12 <= r3) goto L_0x004a
            java.lang.String r12 = " in field name"
            r14._reportInvalidEOF(r12)
        L_0x004a:
            int r12 = r9 >> 2
            r6 = r15[r12]
            r2 = r9 & 3
            int r12 = 3 - r2
            int r12 = r12 << 3
            int r6 = r6 >> r12
            int r9 = r9 + 1
            r12 = r6 & 192(0xc0, float:2.69E-43)
            r13 = 128(0x80, float:1.794E-43)
            if (r12 == r13) goto L_0x0060
            r14._reportInvalidOther(r6)
        L_0x0060:
            int r12 = r5 << 6
            r13 = r6 & 63
            r5 = r12 | r13
            r12 = 1
            if (r11 <= r12) goto L_0x00a6
            int r12 = r9 >> 2
            r6 = r15[r12]
            r2 = r9 & 3
            int r12 = 3 - r2
            int r12 = r12 << 3
            int r6 = r6 >> r12
            int r9 = r9 + 1
            r12 = r6 & 192(0xc0, float:2.69E-43)
            r13 = 128(0x80, float:1.794E-43)
            if (r12 == r13) goto L_0x007f
            r14._reportInvalidOther(r6)
        L_0x007f:
            int r12 = r5 << 6
            r13 = r6 & 63
            r5 = r12 | r13
            r12 = 2
            if (r11 <= r12) goto L_0x00a6
            int r12 = r9 >> 2
            r6 = r15[r12]
            r2 = r9 & 3
            int r12 = 3 - r2
            int r12 = r12 << 3
            int r6 = r6 >> r12
            int r9 = r9 + 1
            r12 = r6 & 192(0xc0, float:2.69E-43)
            r13 = 128(0x80, float:1.794E-43)
            if (r12 == r13) goto L_0x00a0
            r12 = r6 & 255(0xff, float:3.57E-43)
            r14._reportInvalidOther(r12)
        L_0x00a0:
            int r12 = r5 << 6
            r13 = r6 & 63
            r5 = r12 | r13
        L_0x00a6:
            r12 = 2
            if (r11 <= r12) goto L_0x010f
            r12 = 65536(0x10000, float:9.18355E-41)
            int r5 = r5 - r12
            int r12 = r4.length
            if (r8 < r12) goto L_0x00b5
            com.fasterxml.jackson.core.util.TextBuffer r12 = r14._textBuffer
            char[] r4 = r12.expandCurrentSegment()
        L_0x00b5:
            int r7 = r8 + 1
            r12 = 55296(0xd800, float:7.7486E-41)
            int r13 = r5 >> 10
            int r12 = r12 + r13
            char r12 = (char) r12
            r4[r8] = r12
            r12 = 56320(0xdc00, float:7.8921E-41)
            r13 = r5 & 1023(0x3ff, float:1.434E-42)
            r5 = r12 | r13
        L_0x00c7:
            int r12 = r4.length
            if (r7 < r12) goto L_0x00d0
            com.fasterxml.jackson.core.util.TextBuffer r12 = r14._textBuffer
            char[] r4 = r12.expandCurrentSegment()
        L_0x00d0:
            int r8 = r7 + 1
            char r12 = (char) r5
            r4[r7] = r12
            goto L_0x0022
        L_0x00d7:
            r10 = 0
            goto L_0x0019
        L_0x00da:
            r12 = r5 & 240(0xf0, float:3.36E-43)
            r13 = 224(0xe0, float:3.14E-43)
            if (r12 != r13) goto L_0x00e5
            r5 = r5 & 15
            r11 = 2
            goto L_0x0041
        L_0x00e5:
            r12 = r5 & 248(0xf8, float:3.48E-43)
            r13 = 240(0xf0, float:3.36E-43)
            if (r12 != r13) goto L_0x00f0
            r5 = r5 & 7
            r11 = 3
            goto L_0x0041
        L_0x00f0:
            r14._reportInvalidInitial(r5)
            r5 = 1
            r11 = r5
            goto L_0x0041
        L_0x00f7:
            java.lang.String r1 = new java.lang.String
            r12 = 0
            r1.<init>(r4, r12, r8)
            r12 = 4
            r0 = r17
            if (r0 >= r12) goto L_0x0106
            int r12 = r16 + -1
            r15[r12] = r10
        L_0x0106:
            com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer r12 = r14._symbols
            r0 = r16
            com.fasterxml.jackson.core.sym.Name r12 = r12.addName((java.lang.String) r1, (int[]) r15, (int) r0)
            return r12
        L_0x010f:
            r7 = r8
            goto L_0x00c7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.addName(int[], int, int):com.fasterxml.jackson.core.sym.Name");
    }

    /* access modifiers changed from: protected */
    public void _finishString() throws IOException, JsonParseException {
        int ptr = this._inputPtr;
        if (ptr >= this._inputEnd) {
            loadMoreGuaranteed();
            ptr = this._inputPtr;
        }
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int[] codes = sInputCodesUtf8;
        int max = Math.min(this._inputEnd, outBuf.length + ptr);
        byte[] inputBuffer = this._inputBuffer;
        int outPtr = 0;
        while (true) {
            if (ptr >= max) {
                break;
            }
            int c = inputBuffer[ptr] & MotionEventCompat.ACTION_MASK;
            if (codes[c] == 0) {
                ptr++;
                outBuf[outPtr] = (char) c;
                outPtr++;
            } else if (c == 34) {
                this._inputPtr = ptr + 1;
                this._textBuffer.setCurrentLength(outPtr);
                return;
            }
        }
        this._inputPtr = ptr;
        _finishString2(outBuf, outPtr);
    }

    private void _finishString2(char[] outBuf, int outPtr) throws IOException, JsonParseException {
        int outPtr2;
        int[] codes = sInputCodesUtf8;
        byte[] inputBuffer = this._inputBuffer;
        while (true) {
            int ptr = this._inputPtr;
            if (ptr >= this._inputEnd) {
                loadMoreGuaranteed();
                ptr = this._inputPtr;
            }
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            int max = Math.min(this._inputEnd, (outBuf.length - outPtr) + ptr);
            int ptr2 = ptr;
            int outPtr3 = outPtr;
            while (true) {
                if (ptr2 < max) {
                    int ptr3 = ptr2 + 1;
                    int c = inputBuffer[ptr2] & Constants.UNKNOWN;
                    if (codes[c] != 0) {
                        this._inputPtr = ptr3;
                        if (c == 34) {
                            this._textBuffer.setCurrentLength(outPtr3);
                            return;
                        }
                        switch (codes[c]) {
                            case 1:
                                c = _decodeEscaped();
                                outPtr2 = outPtr3;
                                break;
                            case 2:
                                c = _decodeUtf8_2(c);
                                outPtr2 = outPtr3;
                                break;
                            case 3:
                                if (this._inputEnd - this._inputPtr < 2) {
                                    c = _decodeUtf8_3(c);
                                    outPtr2 = outPtr3;
                                    break;
                                } else {
                                    c = _decodeUtf8_3fast(c);
                                    outPtr2 = outPtr3;
                                    break;
                                }
                            case 4:
                                int c2 = _decodeUtf8_4(c);
                                outPtr2 = outPtr3 + 1;
                                outBuf[outPtr3] = (char) (55296 | (c2 >> 10));
                                if (outPtr2 >= outBuf.length) {
                                    outBuf = this._textBuffer.finishCurrentSegment();
                                    outPtr2 = 0;
                                }
                                c = 56320 | (c2 & 1023);
                                break;
                            default:
                                if (c >= 32) {
                                    _reportInvalidChar(c);
                                    outPtr2 = outPtr3;
                                    break;
                                } else {
                                    _throwUnquotedSpace(c, "string value");
                                    outPtr2 = outPtr3;
                                    break;
                                }
                        }
                        if (outPtr2 >= outBuf.length) {
                            outBuf = this._textBuffer.finishCurrentSegment();
                            outPtr2 = 0;
                        }
                        outBuf[outPtr2] = (char) c;
                        outPtr = outPtr2 + 1;
                    } else {
                        outBuf[outPtr3] = (char) c;
                        ptr2 = ptr3;
                        outPtr3++;
                    }
                } else {
                    this._inputPtr = ptr2;
                    outPtr = outPtr3;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void _skipString() throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r7 = this;
            r6 = 0
            r7._tokenIncomplete = r6
            int[] r1 = sInputCodesUtf8
            byte[] r2 = r7._inputBuffer
        L_0x0007:
            int r4 = r7._inputPtr
            int r3 = r7._inputEnd
            if (r4 < r3) goto L_0x004e
            r7.loadMoreGuaranteed()
            int r4 = r7._inputPtr
            int r3 = r7._inputEnd
            r5 = r4
        L_0x0015:
            if (r5 >= r3) goto L_0x0028
            int r4 = r5 + 1
            byte r6 = r2[r5]
            r0 = r6 & 255(0xff, float:3.57E-43)
            r6 = r1[r0]
            if (r6 == 0) goto L_0x004e
            r7._inputPtr = r4
            r6 = 34
            if (r0 != r6) goto L_0x002b
            return
        L_0x0028:
            r7._inputPtr = r5
            goto L_0x0007
        L_0x002b:
            r6 = r1[r0]
            switch(r6) {
                case 1: goto L_0x003a;
                case 2: goto L_0x003e;
                case 3: goto L_0x0042;
                case 4: goto L_0x0046;
                default: goto L_0x0030;
            }
        L_0x0030:
            r6 = 32
            if (r0 >= r6) goto L_0x004a
            java.lang.String r6 = "string value"
            r7._throwUnquotedSpace(r0, r6)
            goto L_0x0007
        L_0x003a:
            r7._decodeEscaped()
            goto L_0x0007
        L_0x003e:
            r7._skipUtf8_2(r0)
            goto L_0x0007
        L_0x0042:
            r7._skipUtf8_3(r0)
            goto L_0x0007
        L_0x0046:
            r7._skipUtf8_4(r0)
            goto L_0x0007
        L_0x004a:
            r7._reportInvalidChar(r0)
            goto L_0x0007
        L_0x004e:
            r5 = r4
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser._skipString():void");
    }

    /* access modifiers changed from: protected */
    public JsonToken _handleUnexpectedValue(int c) throws IOException, JsonParseException {
        switch (c) {
            case 39:
                if (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
                    return _handleApostropheValue();
                }
                break;
            case 43:
                if (this._inputPtr >= this._inputEnd && !loadMore()) {
                    _reportInvalidEOFInValue();
                }
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                return _handleInvalidNumberStart(bArr[i] & Constants.UNKNOWN, false);
            case 78:
                _matchToken("NaN", 1);
                if (!isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    _reportError("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                    break;
                } else {
                    return resetAsNaN("NaN", Double.NaN);
                }
        }
        _reportUnexpectedChar(c, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonToken _handleApostropheValue() throws IOException, JsonParseException {
        int outPtr = 0;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int[] codes = sInputCodesUtf8;
        byte[] inputBuffer = this._inputBuffer;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            int max = this._inputEnd;
            int max2 = this._inputPtr + (outBuf.length - outPtr);
            if (max2 < max) {
                max = max2;
            }
            while (true) {
                if (this._inputPtr < max) {
                    int i = this._inputPtr;
                    this._inputPtr = i + 1;
                    int c = inputBuffer[i] & Constants.UNKNOWN;
                    if (c != 39 && codes[c] == 0) {
                        outBuf[outPtr] = (char) c;
                        outPtr++;
                    } else if (c == 39) {
                        this._textBuffer.setCurrentLength(outPtr);
                        return JsonToken.VALUE_STRING;
                    } else {
                        switch (codes[c]) {
                            case 1:
                                if (c != 34) {
                                    c = _decodeEscaped();
                                    break;
                                }
                                break;
                            case 2:
                                c = _decodeUtf8_2(c);
                                break;
                            case 3:
                                if (this._inputEnd - this._inputPtr < 2) {
                                    c = _decodeUtf8_3(c);
                                    break;
                                } else {
                                    c = _decodeUtf8_3fast(c);
                                    break;
                                }
                            case 4:
                                int c2 = _decodeUtf8_4(c);
                                int outPtr2 = outPtr + 1;
                                outBuf[outPtr] = (char) (55296 | (c2 >> 10));
                                if (outPtr2 >= outBuf.length) {
                                    outBuf = this._textBuffer.finishCurrentSegment();
                                    outPtr = 0;
                                } else {
                                    outPtr = outPtr2;
                                }
                                c = 56320 | (c2 & 1023);
                                break;
                            default:
                                if (c < 32) {
                                    _throwUnquotedSpace(c, "string value");
                                }
                                _reportInvalidChar(c);
                                break;
                        }
                        if (outPtr >= outBuf.length) {
                            outBuf = this._textBuffer.finishCurrentSegment();
                            outPtr = 0;
                        }
                        outBuf[outPtr] = (char) c;
                        outPtr++;
                    }
                }
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, byte], vars: [r10v0 ?, r10v1 ?, r10v2 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    protected com.fasterxml.jackson.core.JsonToken _handleInvalidNumberStart(
/*
Method generation error in method: com.fasterxml.jackson.core.json.UTF8StreamJsonParser._handleInvalidNumberStart(int, boolean):com.fasterxml.jackson.core.JsonToken, dex: classes.dex
    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v0 ?
    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
    	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:157)
    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:129)
    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
    
*/

    /* access modifiers changed from: protected */
    public void _matchToken(String matchStr, int i) throws IOException, JsonParseException {
        int ch;
        int len = matchStr.length();
        do {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOF(" in a value");
            }
            if (this._inputBuffer[this._inputPtr] != matchStr.charAt(i)) {
                _reportInvalidToken(matchStr.substring(0, i), "'null', 'true', 'false' or NaN");
            }
            this._inputPtr++;
            i++;
        } while (i < len);
        if ((this._inputPtr < this._inputEnd || loadMore()) && (ch = this._inputBuffer[this._inputPtr] & MotionEventCompat.ACTION_MASK) >= 48 && ch != 93 && ch != 125 && Character.isJavaIdentifierPart((char) _decodeCharForError(ch))) {
            this._inputPtr++;
            _reportInvalidToken(matchStr.substring(0, i), "'null', 'true', 'false' or NaN");
        }
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidToken(String matchedPart, String msg) throws IOException, JsonParseException {
        StringBuilder sb = new StringBuilder(matchedPart);
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                break;
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c = (char) _decodeCharForError(bArr[i]);
            if (!Character.isJavaIdentifierPart(c)) {
                break;
            }
            sb.append(c);
        }
        _reportError("Unrecognized token '" + sb.toString() + "': was expecting " + msg);
    }

    private int _skipWS() throws IOException, JsonParseException {
        while (true) {
            if (this._inputPtr < this._inputEnd || loadMore()) {
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
                if (i2 > 32) {
                    if (i2 != 47) {
                        return i2;
                    }
                    _skipComment();
                } else if (i2 != 32) {
                    if (i2 == 10) {
                        _skipLF();
                    } else if (i2 == 13) {
                        _skipCR();
                    } else if (i2 != 9) {
                        _throwInvalidSpace(i2);
                    }
                }
            } else {
                throw _constructError("Unexpected end-of-input within/between " + this._parsingContext.getTypeDesc() + " entries");
            }
        }
    }

    private int _skipWSOrEnd() throws IOException, JsonParseException {
        while (true) {
            if (this._inputPtr < this._inputEnd || loadMore()) {
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
                if (i2 > 32) {
                    if (i2 != 47) {
                        return i2;
                    }
                    _skipComment();
                } else if (i2 != 32) {
                    if (i2 == 10) {
                        _skipLF();
                    } else if (i2 == 13) {
                        _skipCR();
                    } else if (i2 != 9) {
                        _throwInvalidSpace(i2);
                    }
                }
            } else {
                _handleEOF();
                return -1;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006b, code lost:
        if (r8._inputPtr < r8._inputEnd) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006d, code lost:
        loadMoreGuaranteed();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int _skipColon() throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r8 = this;
            r7 = 58
            r6 = 47
            r5 = 32
            int r2 = r8._inputPtr
            int r3 = r8._inputEnd
            if (r2 < r3) goto L_0x000f
            r8.loadMoreGuaranteed()
        L_0x000f:
            byte[] r2 = r8._inputBuffer
            int r3 = r8._inputPtr
            int r4 = r3 + 1
            r8._inputPtr = r4
            byte r0 = r2[r3]
            if (r0 != r7) goto L_0x0035
            int r2 = r8._inputPtr
            int r3 = r8._inputEnd
            if (r2 >= r3) goto L_0x0046
            byte[] r2 = r8._inputBuffer
            int r3 = r8._inputPtr
            byte r2 = r2[r3]
            r0 = r2 & 255(0xff, float:3.57E-43)
            if (r0 <= r5) goto L_0x0046
            if (r0 == r6) goto L_0x0046
            int r2 = r8._inputPtr
            int r2 = r2 + 1
            r8._inputPtr = r2
            r1 = r0
        L_0x0034:
            return r1
        L_0x0035:
            r0 = r0 & 255(0xff, float:3.57E-43)
        L_0x0037:
            switch(r0) {
                case 9: goto L_0x0067;
                case 10: goto L_0x007d;
                case 13: goto L_0x0064;
                case 32: goto L_0x0067;
                case 47: goto L_0x0081;
                default: goto L_0x003a;
            }
        L_0x003a:
            if (r0 >= r5) goto L_0x003f
            r8._throwInvalidSpace(r0)
        L_0x003f:
            if (r0 == r7) goto L_0x0046
            java.lang.String r2 = "was expecting a colon to separate field name and value"
            r8._reportUnexpectedChar(r0, r2)
        L_0x0046:
            int r2 = r8._inputPtr
            int r3 = r8._inputEnd
            if (r2 < r3) goto L_0x0052
            boolean r2 = r8.loadMore()
            if (r2 == 0) goto L_0x00a3
        L_0x0052:
            byte[] r2 = r8._inputBuffer
            int r3 = r8._inputPtr
            int r4 = r3 + 1
            r8._inputPtr = r4
            byte r2 = r2[r3]
            r0 = r2 & 255(0xff, float:3.57E-43)
            if (r0 <= r5) goto L_0x0089
            if (r0 == r6) goto L_0x0085
            r1 = r0
            goto L_0x0034
        L_0x0064:
            r8._skipCR()
        L_0x0067:
            int r2 = r8._inputPtr
            int r3 = r8._inputEnd
            if (r2 < r3) goto L_0x0070
            r8.loadMoreGuaranteed()
        L_0x0070:
            byte[] r2 = r8._inputBuffer
            int r3 = r8._inputPtr
            int r4 = r3 + 1
            r8._inputPtr = r4
            byte r2 = r2[r3]
            r0 = r2 & 255(0xff, float:3.57E-43)
            goto L_0x0037
        L_0x007d:
            r8._skipLF()
            goto L_0x0067
        L_0x0081:
            r8._skipComment()
            goto L_0x0067
        L_0x0085:
            r8._skipComment()
            goto L_0x0046
        L_0x0089:
            if (r0 == r5) goto L_0x0046
            r2 = 10
            if (r0 != r2) goto L_0x0093
            r8._skipLF()
            goto L_0x0046
        L_0x0093:
            r2 = 13
            if (r0 != r2) goto L_0x009b
            r8._skipCR()
            goto L_0x0046
        L_0x009b:
            r2 = 9
            if (r0 == r2) goto L_0x0046
            r8._throwInvalidSpace(r0)
            goto L_0x0046
        L_0x00a3:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unexpected end-of-input within/between "
            java.lang.StringBuilder r2 = r2.append(r3)
            com.fasterxml.jackson.core.json.JsonReadContext r3 = r8._parsingContext
            java.lang.String r3 = r3.getTypeDesc()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " entries"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.fasterxml.jackson.core.JsonParseException r2 = r8._constructError(r2)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser._skipColon():int");
    }

    private void _skipComment() throws IOException, JsonParseException {
        if (!isEnabled(JsonParser.Feature.ALLOW_COMMENTS)) {
            _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            _reportInvalidEOF(" in a comment");
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int c = bArr[i] & MotionEventCompat.ACTION_MASK;
        if (c == 47) {
            _skipCppComment();
        } else if (c == 42) {
            _skipCComment();
        } else {
            _reportUnexpectedChar(c, "was expecting either '*' or '/' for a comment");
        }
    }

    private void _skipCComment() throws IOException, JsonParseException {
        int[] codes = CharTypes.getInputCodeComment();
        while (true) {
            if (this._inputPtr < this._inputEnd || loadMore()) {
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
                int code = codes[i2];
                if (code != 0) {
                    switch (code) {
                        case 2:
                            _skipUtf8_2(i2);
                            continue;
                        case 3:
                            _skipUtf8_3(i2);
                            continue;
                        case 4:
                            _skipUtf8_4(i2);
                            continue;
                        case 10:
                            _skipLF();
                            continue;
                        case 13:
                            _skipCR();
                            continue;
                        case 42:
                            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                                break;
                            } else if (this._inputBuffer[this._inputPtr] == 47) {
                                this._inputPtr++;
                                return;
                            } else {
                                continue;
                            }
                        default:
                            _reportInvalidChar(i2);
                            continue;
                    }
                }
            }
        }
        _reportInvalidEOF(" in a comment");
    }

    private void _skipCppComment() throws IOException, JsonParseException {
        int[] codes = CharTypes.getInputCodeComment();
        while (true) {
            if (this._inputPtr < this._inputEnd || loadMore()) {
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                int i2 = bArr[i] & MotionEventCompat.ACTION_MASK;
                int code = codes[i2];
                if (code != 0) {
                    switch (code) {
                        case 2:
                            _skipUtf8_2(i2);
                            break;
                        case 3:
                            _skipUtf8_3(i2);
                            break;
                        case 4:
                            _skipUtf8_4(i2);
                            break;
                        case 10:
                            _skipLF();
                            return;
                        case 13:
                            _skipCR();
                            return;
                        case 42:
                            break;
                        default:
                            _reportInvalidChar(i2);
                            break;
                    }
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public char _decodeEscaped() throws IOException, JsonParseException {
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            _reportInvalidEOF(" in character escape sequence");
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte c = bArr[i];
        switch (c) {
            case 34:
            case 47:
            case 92:
                return (char) c;
            case 98:
                return 8;
            case LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
                return 12;
            case 110:
                return 10;
            case 114:
                return 13;
            case 116:
                return 9;
            case 117:
                int value = 0;
                for (int i2 = 0; i2 < 4; i2++) {
                    if (this._inputPtr >= this._inputEnd && !loadMore()) {
                        _reportInvalidEOF(" in character escape sequence");
                    }
                    byte[] bArr2 = this._inputBuffer;
                    int i3 = this._inputPtr;
                    this._inputPtr = i3 + 1;
                    byte ch = bArr2[i3];
                    int digit = CharTypes.charToHex(ch);
                    if (digit < 0) {
                        _reportUnexpectedChar(ch, "expected a hex-digit for character escape sequence");
                    }
                    value = (value << 4) | digit;
                }
                return (char) value;
            default:
                return _handleUnrecognizedCharacterEscape((char) _decodeCharForError(c));
        }
    }

    /* access modifiers changed from: protected */
    public int _decodeCharForError(int firstByte) throws IOException, JsonParseException {
        int needed;
        int c = firstByte;
        if (c >= 0) {
            return c;
        }
        if ((c & 224) == 192) {
            c &= 31;
            needed = 1;
        } else if ((c & 240) == 224) {
            c &= 15;
            needed = 2;
        } else if ((c & 248) == 240) {
            c &= 7;
            needed = 3;
        } else {
            _reportInvalidInitial(c & MotionEventCompat.ACTION_MASK);
            needed = 1;
        }
        int d = nextByte();
        if ((d & 192) != 128) {
            _reportInvalidOther(d & MotionEventCompat.ACTION_MASK);
        }
        int c2 = (c << 6) | (d & 63);
        if (needed <= 1) {
            return c2;
        }
        int d2 = nextByte();
        if ((d2 & 192) != 128) {
            _reportInvalidOther(d2 & MotionEventCompat.ACTION_MASK);
        }
        int c3 = (c2 << 6) | (d2 & 63);
        if (needed <= 2) {
            return c3;
        }
        int d3 = nextByte();
        if ((d3 & 192) != 128) {
            _reportInvalidOther(d3 & MotionEventCompat.ACTION_MASK);
        }
        return (c3 << 6) | (d3 & 63);
    }

    private int _decodeUtf8_2(int c) throws IOException, JsonParseException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte d = bArr[i];
        if ((d & 192) != 128) {
            _reportInvalidOther(d & Constants.UNKNOWN, this._inputPtr);
        }
        return ((c & 31) << 6) | (d & 63);
    }

    private int _decodeUtf8_3(int c1) throws IOException, JsonParseException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        int c12 = c1 & 15;
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte d = bArr[i];
        if ((d & 192) != 128) {
            _reportInvalidOther(d & Constants.UNKNOWN, this._inputPtr);
        }
        int c = (c12 << 6) | (d & 63);
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte d2 = bArr2[i2];
        if ((d2 & 192) != 128) {
            _reportInvalidOther(d2 & Constants.UNKNOWN, this._inputPtr);
        }
        return (c << 6) | (d2 & 63);
    }

    private int _decodeUtf8_3fast(int c1) throws IOException, JsonParseException {
        int c12 = c1 & 15;
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte d = bArr[i];
        if ((d & 192) != 128) {
            _reportInvalidOther(d & Constants.UNKNOWN, this._inputPtr);
        }
        int c = (c12 << 6) | (d & 63);
        byte[] bArr2 = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte d2 = bArr2[i2];
        if ((d2 & 192) != 128) {
            _reportInvalidOther(d2 & Constants.UNKNOWN, this._inputPtr);
        }
        return (c << 6) | (d2 & 63);
    }

    private int _decodeUtf8_4(int c) throws IOException, JsonParseException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte d = bArr[i];
        if ((d & 192) != 128) {
            _reportInvalidOther(d & Constants.UNKNOWN, this._inputPtr);
        }
        int c2 = ((c & 7) << 6) | (d & 63);
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte d2 = bArr2[i2];
        if ((d2 & 192) != 128) {
            _reportInvalidOther(d2 & Constants.UNKNOWN, this._inputPtr);
        }
        int c3 = (c2 << 6) | (d2 & 63);
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr3 = this._inputBuffer;
        int i3 = this._inputPtr;
        this._inputPtr = i3 + 1;
        byte d3 = bArr3[i3];
        if ((d3 & 192) != 128) {
            _reportInvalidOther(d3 & Constants.UNKNOWN, this._inputPtr);
        }
        return ((c3 << 6) | (d3 & 63)) - Constants.FEMALE;
    }

    private void _skipUtf8_2(int c) throws IOException, JsonParseException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte c2 = bArr[i];
        if ((c2 & 192) != 128) {
            _reportInvalidOther(c2 & Constants.UNKNOWN, this._inputPtr);
        }
    }

    private void _skipUtf8_3(int c) throws IOException, JsonParseException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte c2 = bArr[i];
        if ((c2 & 192) != 128) {
            _reportInvalidOther(c2 & Constants.UNKNOWN, this._inputPtr);
        }
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte c3 = bArr2[i2];
        if ((c3 & 192) != 128) {
            _reportInvalidOther(c3 & Constants.UNKNOWN, this._inputPtr);
        }
    }

    private void _skipUtf8_4(int c) throws IOException, JsonParseException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte d = bArr[i];
        if ((d & 192) != 128) {
            _reportInvalidOther(d & Constants.UNKNOWN, this._inputPtr);
        }
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte d2 = bArr2[i2];
        if ((d2 & 192) != 128) {
            _reportInvalidOther(d2 & Constants.UNKNOWN, this._inputPtr);
        }
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr3 = this._inputBuffer;
        int i3 = this._inputPtr;
        this._inputPtr = i3 + 1;
        byte d3 = bArr3[i3];
        if ((d3 & 192) != 128) {
            _reportInvalidOther(d3 & Constants.UNKNOWN, this._inputPtr);
        }
    }

    /* access modifiers changed from: protected */
    public void _skipCR() throws IOException {
        if ((this._inputPtr < this._inputEnd || loadMore()) && this._inputBuffer[this._inputPtr] == 10) {
            this._inputPtr++;
        }
        this._currInputRow++;
        this._currInputRowStart = this._inputPtr;
    }

    /* access modifiers changed from: protected */
    public void _skipLF() throws IOException {
        this._currInputRow++;
        this._currInputRowStart = this._inputPtr;
    }

    private int nextByte() throws IOException, JsonParseException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        return bArr[i] & Constants.UNKNOWN;
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidChar(int c) throws JsonParseException {
        if (c < 32) {
            _throwInvalidSpace(c);
        }
        _reportInvalidInitial(c);
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidInitial(int mask) throws JsonParseException {
        _reportError("Invalid UTF-8 start byte 0x" + Integer.toHexString(mask));
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidOther(int mask) throws JsonParseException {
        _reportError("Invalid UTF-8 middle byte 0x" + Integer.toHexString(mask));
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidOther(int mask, int ptr) throws JsonParseException {
        this._inputPtr = ptr;
        _reportInvalidOther(mask);
    }

    public static int[] growArrayBy(int[] arr, int more) {
        if (arr == null) {
            return new int[more];
        }
        int[] old = arr;
        int len = arr.length;
        int[] arr2 = new int[(len + more)];
        System.arraycopy(old, 0, arr2, 0, len);
        return arr2;
    }

    /* access modifiers changed from: protected */
    public byte[] _decodeBase64(Base64Variant b64variant) throws IOException, JsonParseException {
        ByteArrayBuilder builder = _getByteArrayBuilder();
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int ch = bArr[i] & MotionEventCompat.ACTION_MASK;
            if (ch > 32) {
                int bits = b64variant.decodeBase64Char(ch);
                if (bits < 0) {
                    if (ch == 34) {
                        return builder.toByteArray();
                    }
                    bits = _decodeBase64Escape(b64variant, ch, 0);
                    if (bits < 0) {
                        continue;
                    }
                }
                int decodedData = bits;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr2 = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                int ch2 = bArr2[i2] & MotionEventCompat.ACTION_MASK;
                int bits2 = b64variant.decodeBase64Char(ch2);
                if (bits2 < 0) {
                    bits2 = _decodeBase64Escape(b64variant, ch2, 1);
                }
                int decodedData2 = (decodedData << 6) | bits2;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                int ch3 = bArr3[i3] & MotionEventCompat.ACTION_MASK;
                int bits3 = b64variant.decodeBase64Char(ch3);
                if (bits3 < 0) {
                    if (bits3 != -2) {
                        if (ch3 != 34 || b64variant.usesPadding()) {
                            bits3 = _decodeBase64Escape(b64variant, ch3, 2);
                        } else {
                            builder.append(decodedData2 >> 4);
                            return builder.toByteArray();
                        }
                    }
                    if (bits3 == -2) {
                        if (this._inputPtr >= this._inputEnd) {
                            loadMoreGuaranteed();
                        }
                        byte[] bArr4 = this._inputBuffer;
                        int i4 = this._inputPtr;
                        this._inputPtr = i4 + 1;
                        int ch4 = bArr4[i4] & MotionEventCompat.ACTION_MASK;
                        if (!b64variant.usesPaddingChar(ch4)) {
                            throw reportInvalidBase64Char(b64variant, ch4, 3, "expected padding character '" + b64variant.getPaddingChar() + "'");
                        }
                        builder.append(decodedData2 >> 4);
                    }
                }
                int decodedData3 = (decodedData2 << 6) | bits3;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr5 = this._inputBuffer;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                int ch5 = bArr5[i5] & MotionEventCompat.ACTION_MASK;
                int bits4 = b64variant.decodeBase64Char(ch5);
                if (bits4 < 0) {
                    if (bits4 != -2) {
                        if (ch5 != 34 || b64variant.usesPadding()) {
                            bits4 = _decodeBase64Escape(b64variant, ch5, 3);
                        } else {
                            builder.appendTwoBytes(decodedData3 >> 2);
                            return builder.toByteArray();
                        }
                    }
                    if (bits4 == -2) {
                        builder.appendTwoBytes(decodedData3 >> 2);
                    }
                }
                builder.appendThreeBytes((decodedData3 << 6) | bits4);
            }
        }
    }
}
