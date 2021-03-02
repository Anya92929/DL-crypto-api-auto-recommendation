package com.parse.codec.binary;

import com.parse.codec.BinaryDecoder;
import com.parse.codec.BinaryEncoder;
import com.parse.codec.DecoderException;
import com.parse.codec.EncoderException;

public abstract class BaseNCodec implements BinaryEncoder, BinaryDecoder {
    private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    protected static final int MASK_8BITS = 255;
    public static final int MIME_CHUNK_SIZE = 76;
    protected static final byte PAD_DEFAULT = 61;
    public static final int PEM_CHUNK_SIZE = 64;
    protected final byte PAD = PAD_DEFAULT;
    protected byte[] buffer;
    private final int chunkSeparatorLength;
    protected int currentLinePos;
    private final int encodedBlockSize;
    protected boolean eof;
    protected final int lineLength;
    protected int modulus;
    protected int pos;
    private int readPos;
    private final int unencodedBlockSize;

    /* access modifiers changed from: package-private */
    public abstract void decode(byte[] bArr, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void encode(byte[] bArr, int i, int i2);

    /* access modifiers changed from: protected */
    public abstract boolean isInAlphabet(byte b);

    protected BaseNCodec(int unencodedBlockSize2, int encodedBlockSize2, int lineLength2, int chunkSeparatorLength2) {
        this.unencodedBlockSize = unencodedBlockSize2;
        this.encodedBlockSize = encodedBlockSize2;
        this.lineLength = (lineLength2 <= 0 || chunkSeparatorLength2 <= 0) ? 0 : (lineLength2 / encodedBlockSize2) * encodedBlockSize2;
        this.chunkSeparatorLength = chunkSeparatorLength2;
    }

    /* access modifiers changed from: package-private */
    public boolean hasData() {
        return this.buffer != null;
    }

    /* access modifiers changed from: package-private */
    public int available() {
        if (this.buffer != null) {
            return this.pos - this.readPos;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getDefaultBufferSize() {
        return 8192;
    }

    private void resizeBuffer() {
        if (this.buffer == null) {
            this.buffer = new byte[getDefaultBufferSize()];
            this.pos = 0;
            this.readPos = 0;
            return;
        }
        byte[] b = new byte[(this.buffer.length * 2)];
        System.arraycopy(this.buffer, 0, b, 0, this.buffer.length);
        this.buffer = b;
    }

    /* access modifiers changed from: protected */
    public void ensureBufferSize(int size) {
        if (this.buffer == null || this.buffer.length < this.pos + size) {
            resizeBuffer();
        }
    }

    /* access modifiers changed from: package-private */
    public int readResults(byte[] b, int bPos, int bAvail) {
        if (this.buffer != null) {
            int len = Math.min(available(), bAvail);
            System.arraycopy(this.buffer, this.readPos, b, bPos, len);
            this.readPos += len;
            if (this.readPos < this.pos) {
                return len;
            }
            this.buffer = null;
            return len;
        }
        return this.eof ? -1 : 0;
    }

    protected static boolean isWhiteSpace(byte byteToCheck) {
        switch (byteToCheck) {
            case 9:
            case 10:
            case 13:
            case 32:
                return true;
            default:
                return false;
        }
    }

    private void reset() {
        this.buffer = null;
        this.pos = 0;
        this.readPos = 0;
        this.currentLinePos = 0;
        this.modulus = 0;
        this.eof = false;
    }

    public Object encode(Object pObject) throws EncoderException {
        if (pObject instanceof byte[]) {
            return encode((byte[]) pObject);
        }
        throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    public String encodeToString(byte[] pArray) {
        return StringUtils.newStringUtf8(encode(pArray));
    }

    public Object decode(Object pObject) throws DecoderException {
        if (pObject instanceof byte[]) {
            return decode((byte[]) pObject);
        }
        if (pObject instanceof String) {
            return decode((String) pObject);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    public byte[] decode(String pArray) {
        return decode(StringUtils.getBytesUtf8(pArray));
    }

    public byte[] decode(byte[] pArray) {
        reset();
        if (pArray == null || pArray.length == 0) {
            return pArray;
        }
        decode(pArray, 0, pArray.length);
        decode(pArray, 0, -1);
        byte[] result = new byte[this.pos];
        readResults(result, 0, result.length);
        return result;
    }

    public byte[] encode(byte[] pArray) {
        reset();
        if (pArray == null || pArray.length == 0) {
            return pArray;
        }
        encode(pArray, 0, pArray.length);
        encode(pArray, 0, -1);
        byte[] buf = new byte[(this.pos - this.readPos)];
        readResults(buf, 0, buf.length);
        return buf;
    }

    public String encodeAsString(byte[] pArray) {
        return StringUtils.newStringUtf8(encode(pArray));
    }

    public boolean isInAlphabet(byte[] arrayOctet, boolean allowWSPad) {
        for (int i = 0; i < arrayOctet.length; i++) {
            if (!isInAlphabet(arrayOctet[i]) && (!allowWSPad || (arrayOctet[i] != 61 && !isWhiteSpace(arrayOctet[i])))) {
                return false;
            }
        }
        return true;
    }

    public boolean isInAlphabet(String basen) {
        return isInAlphabet(StringUtils.getBytesUtf8(basen), true);
    }

    /* access modifiers changed from: protected */
    public boolean containsAlphabetOrPad(byte[] arrayOctet) {
        if (arrayOctet == null) {
            return false;
        }
        for (int i = 0; i < arrayOctet.length; i++) {
            if (61 == arrayOctet[i] || isInAlphabet(arrayOctet[i])) {
                return true;
            }
        }
        return false;
    }

    public long getEncodedLength(byte[] pArray) {
        long len = ((long) (((pArray.length + this.unencodedBlockSize) - 1) / this.unencodedBlockSize)) * ((long) this.encodedBlockSize);
        if (this.lineLength > 0) {
            return len + ((((((long) this.lineLength) + len) - 1) / ((long) this.lineLength)) * ((long) this.chunkSeparatorLength));
        }
        return len;
    }
}
