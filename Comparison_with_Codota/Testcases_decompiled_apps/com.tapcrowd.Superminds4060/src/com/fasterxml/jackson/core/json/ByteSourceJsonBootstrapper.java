package com.fasterxml.jackson.core.json;

import android.support.p000v4.view.MotionEventCompat;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.p003io.IOContext;
import com.fasterxml.jackson.core.p003io.MergedStream;
import com.fasterxml.jackson.core.p003io.UTF32Reader;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.flurry.android.Constants;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public final class ByteSourceJsonBootstrapper {
    static final byte UTF8_BOM_1 = -17;
    static final byte UTF8_BOM_2 = -69;
    static final byte UTF8_BOM_3 = -65;
    protected boolean _bigEndian = true;
    private final boolean _bufferRecyclable;
    protected int _bytesPerChar = 0;
    protected final IOContext _context;
    protected final InputStream _in;
    protected final byte[] _inputBuffer;
    private int _inputEnd;
    protected int _inputProcessed;
    private int _inputPtr;

    public ByteSourceJsonBootstrapper(IOContext ctxt, InputStream in) {
        this._context = ctxt;
        this._in = in;
        this._inputBuffer = ctxt.allocReadIOBuffer();
        this._inputPtr = 0;
        this._inputEnd = 0;
        this._inputProcessed = 0;
        this._bufferRecyclable = true;
    }

    public ByteSourceJsonBootstrapper(IOContext ctxt, byte[] inputBuffer, int inputStart, int inputLen) {
        this._context = ctxt;
        this._in = null;
        this._inputBuffer = inputBuffer;
        this._inputPtr = inputStart;
        this._inputEnd = inputStart + inputLen;
        this._inputProcessed = -inputStart;
        this._bufferRecyclable = false;
    }

    public JsonEncoding detectEncoding() throws IOException, JsonParseException {
        JsonEncoding enc;
        boolean foundEncoding = false;
        if (ensureLoaded(4)) {
            int quad = (this._inputBuffer[this._inputPtr] << 24) | ((this._inputBuffer[this._inputPtr + 1] & Constants.UNKNOWN) << 16) | ((this._inputBuffer[this._inputPtr + 2] & Constants.UNKNOWN) << 8) | (this._inputBuffer[this._inputPtr + 3] & MotionEventCompat.ACTION_MASK);
            if (handleBOM(quad)) {
                foundEncoding = true;
            } else if (checkUTF32(quad)) {
                foundEncoding = true;
            } else if (checkUTF16(quad >>> 16)) {
                foundEncoding = true;
            }
        } else if (ensureLoaded(2) && checkUTF16(((this._inputBuffer[this._inputPtr] & Constants.UNKNOWN) << 8) | (this._inputBuffer[this._inputPtr + 1] & MotionEventCompat.ACTION_MASK))) {
            foundEncoding = true;
        }
        if (!foundEncoding) {
            enc = JsonEncoding.UTF8;
        } else {
            switch (this._bytesPerChar) {
                case 1:
                    enc = JsonEncoding.UTF8;
                    break;
                case 2:
                    if (!this._bigEndian) {
                        enc = JsonEncoding.UTF16_LE;
                        break;
                    } else {
                        enc = JsonEncoding.UTF16_BE;
                        break;
                    }
                case 4:
                    if (!this._bigEndian) {
                        enc = JsonEncoding.UTF32_LE;
                        break;
                    } else {
                        enc = JsonEncoding.UTF32_BE;
                        break;
                    }
                default:
                    throw new RuntimeException("Internal error");
            }
        }
        this._context.setEncoding(enc);
        return enc;
    }

    public Reader constructReader() throws IOException {
        InputStream in;
        JsonEncoding enc = this._context.getEncoding();
        switch (enc) {
            case UTF32_BE:
            case UTF32_LE:
                return new UTF32Reader(this._context, this._in, this._inputBuffer, this._inputPtr, this._inputEnd, this._context.getEncoding().isBigEndian());
            case UTF16_BE:
            case UTF16_LE:
            case UTF8:
                InputStream in2 = this._in;
                if (in2 == null) {
                    in = new ByteArrayInputStream(this._inputBuffer, this._inputPtr, this._inputEnd);
                } else {
                    in = this._inputPtr < this._inputEnd ? new MergedStream(this._context, in2, this._inputBuffer, this._inputPtr, this._inputEnd) : in2;
                }
                return new InputStreamReader(in, enc.getJavaName());
            default:
                throw new RuntimeException("Internal error");
        }
    }

    public JsonParser constructParser(int parserFeatures, ObjectCodec codec, BytesToNameCanonicalizer rootByteSymbols, CharsToNameCanonicalizer rootCharSymbols, boolean canonicalize, boolean intern) throws IOException, JsonParseException {
        if (detectEncoding() != JsonEncoding.UTF8 || !canonicalize) {
            return new ReaderBasedJsonParser(this._context, parserFeatures, constructReader(), codec, rootCharSymbols.makeChild(canonicalize, intern));
        }
        return new UTF8StreamJsonParser(this._context, parserFeatures, this._in, codec, rootByteSymbols.makeChild(canonicalize, intern), this._inputBuffer, this._inputPtr, this._inputEnd, this._bufferRecyclable);
    }

    public static MatchStrength hasJSONFormat(InputAccessor acc) throws IOException {
        if (!acc.hasMoreBytes()) {
            return MatchStrength.INCONCLUSIVE;
        }
        byte b = acc.nextByte();
        if (b == -17) {
            if (!acc.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (acc.nextByte() != -69) {
                return MatchStrength.NO_MATCH;
            }
            if (!acc.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (acc.nextByte() != -65) {
                return MatchStrength.NO_MATCH;
            }
            if (!acc.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            b = acc.nextByte();
        }
        int ch = skipSpace(acc, b);
        if (ch < 0) {
            return MatchStrength.INCONCLUSIVE;
        }
        if (ch == 123) {
            int ch2 = skipSpace(acc);
            if (ch2 < 0) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (ch2 == 34 || ch2 == 125) {
                return MatchStrength.SOLID_MATCH;
            }
            return MatchStrength.NO_MATCH;
        } else if (ch == 91) {
            int ch3 = skipSpace(acc);
            if (ch3 < 0) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (ch3 == 93 || ch3 == 91) {
                return MatchStrength.SOLID_MATCH;
            }
            return MatchStrength.SOLID_MATCH;
        } else {
            MatchStrength strength = MatchStrength.WEAK_MATCH;
            if (ch == 34) {
                return strength;
            }
            if (ch <= 57 && ch >= 48) {
                return strength;
            }
            if (ch == 45) {
                int ch4 = skipSpace(acc);
                if (ch4 < 0) {
                    return MatchStrength.INCONCLUSIVE;
                }
                if (ch4 > 57 || ch4 < 48) {
                    return MatchStrength.NO_MATCH;
                }
                return strength;
            } else if (ch == 110) {
                return tryMatch(acc, "ull", strength);
            } else {
                if (ch == 116) {
                    return tryMatch(acc, "rue", strength);
                }
                if (ch == 102) {
                    return tryMatch(acc, "alse", strength);
                }
                return MatchStrength.NO_MATCH;
            }
        }
    }

    private static MatchStrength tryMatch(InputAccessor acc, String matchStr, MatchStrength fullMatchStrength) throws IOException {
        int len = matchStr.length();
        for (int i = 0; i < len; i++) {
            if (!acc.hasMoreBytes()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (acc.nextByte() != matchStr.charAt(i)) {
                return MatchStrength.NO_MATCH;
            }
        }
        return fullMatchStrength;
    }

    private static int skipSpace(InputAccessor acc) throws IOException {
        if (!acc.hasMoreBytes()) {
            return -1;
        }
        return skipSpace(acc, acc.nextByte());
    }

    private static int skipSpace(InputAccessor acc, byte b) throws IOException {
        while (true) {
            byte ch = b & Constants.UNKNOWN;
            if (ch != 32 && ch != 13 && ch != 10 && ch != 9) {
                return ch;
            }
            if (!acc.hasMoreBytes()) {
                return -1;
            }
            b = acc.nextByte();
            byte b2 = b & Constants.UNKNOWN;
        }
    }

    private boolean handleBOM(int quad) throws IOException {
        switch (quad) {
            case -16842752:
                break;
            case -131072:
                this._inputPtr += 4;
                this._bytesPerChar = 4;
                this._bigEndian = false;
                return true;
            case 65279:
                this._bigEndian = true;
                this._inputPtr += 4;
                this._bytesPerChar = 4;
                return true;
            case 65534:
                reportWeirdUCS4("2143");
                break;
        }
        reportWeirdUCS4("3412");
        int msw = quad >>> 16;
        if (msw == 65279) {
            this._inputPtr += 2;
            this._bytesPerChar = 2;
            this._bigEndian = true;
            return true;
        } else if (msw == 65534) {
            this._inputPtr += 2;
            this._bytesPerChar = 2;
            this._bigEndian = false;
            return true;
        } else if ((quad >>> 8) != 15711167) {
            return false;
        } else {
            this._inputPtr += 3;
            this._bytesPerChar = 1;
            this._bigEndian = true;
            return true;
        }
    }

    private boolean checkUTF32(int quad) throws IOException {
        if ((quad >> 8) == 0) {
            this._bigEndian = true;
        } else if ((16777215 & quad) == 0) {
            this._bigEndian = false;
        } else if ((-16711681 & quad) == 0) {
            reportWeirdUCS4("3412");
        } else if ((-65281 & quad) != 0) {
            return false;
        } else {
            reportWeirdUCS4("2143");
        }
        this._bytesPerChar = 4;
        return true;
    }

    private boolean checkUTF16(int i16) {
        if ((65280 & i16) == 0) {
            this._bigEndian = true;
        } else if ((i16 & MotionEventCompat.ACTION_MASK) != 0) {
            return false;
        } else {
            this._bigEndian = false;
        }
        this._bytesPerChar = 2;
        return true;
    }

    private void reportWeirdUCS4(String type) throws IOException {
        throw new CharConversionException("Unsupported UCS-4 endianness (" + type + ") detected");
    }

    /* access modifiers changed from: protected */
    public boolean ensureLoaded(int minimum) throws IOException {
        int count;
        int gotten = this._inputEnd - this._inputPtr;
        while (gotten < minimum) {
            if (this._in == null) {
                count = -1;
            } else {
                count = this._in.read(this._inputBuffer, this._inputEnd, this._inputBuffer.length - this._inputEnd);
            }
            if (count < 1) {
                return false;
            }
            this._inputEnd += count;
            gotten += count;
        }
        return true;
    }
}
