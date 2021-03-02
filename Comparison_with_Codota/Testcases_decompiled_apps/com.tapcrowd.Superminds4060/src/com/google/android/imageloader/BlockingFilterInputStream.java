package com.google.android.imageloader;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class BlockingFilterInputStream extends FilterInputStream {
    public BlockingFilterInputStream(InputStream input) {
        super(input);
    }

    public int read(byte[] buffer, int offset, int count) throws IOException {
        int total = 0;
        while (total < count) {
            int read = super.read(buffer, offset + total, count - total);
            if (read != -1) {
                total += read;
            } else if (total != 0) {
                return total;
            } else {
                return -1;
            }
        }
        return total;
    }

    public int read(byte[] buffer) throws IOException {
        int total = 0;
        while (total < buffer.length) {
            int read = super.read(buffer, total, buffer.length - total);
            if (read != -1) {
                total += read;
            } else if (total != 0) {
                return total;
            } else {
                return -1;
            }
        }
        return total;
    }

    public long skip(long count) throws IOException {
        long total = 0;
        while (total < count) {
            long skipped = super.skip(count - total);
            if (skipped == 0) {
                if (super.read() < 0) {
                    break;
                }
                skipped++;
            }
            total += skipped;
        }
        return total;
    }
}
