package org.apache.commons.p009io.output;

import java.io.Serializable;
import java.io.Writer;

/* renamed from: org.apache.commons.io.output.StringBuilderWriter */
public class StringBuilderWriter extends Writer implements Serializable {

    /* renamed from: a */
    private final StringBuilder f6998a;

    public StringBuilderWriter() {
        this.f6998a = new StringBuilder();
    }

    public StringBuilderWriter(int i) {
        this.f6998a = new StringBuilder(i);
    }

    public StringBuilderWriter(StringBuilder sb) {
        this.f6998a = sb == null ? new StringBuilder() : sb;
    }

    public Writer append(char c) {
        this.f6998a.append(c);
        return this;
    }

    public Writer append(CharSequence charSequence) {
        this.f6998a.append(charSequence);
        return this;
    }

    public Writer append(CharSequence charSequence, int i, int i2) {
        this.f6998a.append(charSequence, i, i2);
        return this;
    }

    public void close() {
    }

    public void flush() {
    }

    public void write(String str) {
        if (str != null) {
            this.f6998a.append(str);
        }
    }

    public void write(char[] cArr, int i, int i2) {
        if (cArr != null) {
            this.f6998a.append(cArr, i, i2);
        }
    }

    public StringBuilder getBuilder() {
        return this.f6998a;
    }

    public String toString() {
        return this.f6998a.toString();
    }
}
