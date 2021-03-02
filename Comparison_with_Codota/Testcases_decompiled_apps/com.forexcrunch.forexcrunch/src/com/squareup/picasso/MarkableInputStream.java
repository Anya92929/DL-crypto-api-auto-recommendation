package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

final class MarkableInputStream extends InputStream {
    private long defaultMark = -1;

    /* renamed from: in */
    private final InputStream f1760in;
    private long limit;
    private long offset;
    private long reset;

    public MarkableInputStream(InputStream in) {
        this.f1760in = !in.markSupported() ? new BufferedInputStream(in) : in;
    }

    public void mark(int readLimit) {
        this.defaultMark = savePosition(readLimit);
    }

    public long savePosition(int readLimit) {
        long offsetLimit = this.offset + ((long) readLimit);
        if (this.limit < offsetLimit) {
            setLimit(offsetLimit);
        }
        return this.offset;
    }

    private void setLimit(long limit2) {
        try {
            if (this.reset >= this.offset || this.offset > this.limit) {
                this.reset = this.offset;
                this.f1760in.mark((int) (limit2 - this.offset));
            } else {
                this.f1760in.reset();
                this.f1760in.mark((int) (limit2 - this.reset));
                skip(this.reset, this.offset);
            }
            this.limit = limit2;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to mark: " + e);
        }
    }

    public void reset() throws IOException {
        reset(this.defaultMark);
    }

    public void reset(long token) throws IOException {
        if (this.offset > this.limit || token < this.reset) {
            throw new IOException("Cannot reset");
        }
        this.f1760in.reset();
        skip(this.reset, token);
        this.offset = token;
    }

    private void skip(long current, long target) throws IOException {
        while (current < target) {
            current += this.f1760in.skip(target - current);
        }
    }

    public int read() throws IOException {
        int result = this.f1760in.read();
        if (result != -1) {
            this.offset++;
        }
        return result;
    }

    public int read(byte[] buffer) throws IOException {
        int count = this.f1760in.read(buffer);
        if (count != -1) {
            this.offset += (long) count;
        }
        return count;
    }

    public int read(byte[] buffer, int offset2, int length) throws IOException {
        int count = this.f1760in.read(buffer, offset2, length);
        if (count != -1) {
            this.offset += (long) count;
        }
        return count;
    }

    public long skip(long byteCount) throws IOException {
        long skipped = this.f1760in.skip(byteCount);
        this.offset += skipped;
        return skipped;
    }

    public int available() throws IOException {
        return this.f1760in.available();
    }

    public void close() throws IOException {
        this.f1760in.close();
    }

    public boolean markSupported() {
        return this.f1760in.markSupported();
    }
}
