package org.apache.commons.p009io.output;

import java.io.Writer;

/* renamed from: org.apache.commons.io.output.NullWriter */
public class NullWriter extends Writer {
    public static final NullWriter NULL_WRITER = new NullWriter();

    public Writer append(char c) {
        return this;
    }

    public Writer append(CharSequence charSequence, int i, int i2) {
        return this;
    }

    public Writer append(CharSequence charSequence) {
        return this;
    }

    public void write(int i) {
    }

    public void write(char[] cArr) {
    }

    public void write(char[] cArr, int i, int i2) {
    }

    public void write(String str) {
    }

    public void write(String str, int i, int i2) {
    }

    public void flush() {
    }

    public void close() {
    }
}
