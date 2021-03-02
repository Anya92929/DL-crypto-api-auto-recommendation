package org.apache.commons.p009io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: org.apache.commons.io.LineIterator */
public class LineIterator implements Iterator<String> {

    /* renamed from: a */
    private final BufferedReader f6847a;

    /* renamed from: b */
    private String f6848b;

    /* renamed from: c */
    private boolean f6849c = false;

    public LineIterator(Reader reader) throws IllegalArgumentException {
        if (reader == null) {
            throw new IllegalArgumentException("Reader must not be null");
        } else if (reader instanceof BufferedReader) {
            this.f6847a = (BufferedReader) reader;
        } else {
            this.f6847a = new BufferedReader(reader);
        }
    }

    public boolean hasNext() {
        String readLine;
        if (this.f6848b != null) {
            return true;
        }
        if (this.f6849c) {
            return false;
        }
        do {
            try {
                readLine = this.f6847a.readLine();
                if (readLine == null) {
                    this.f6849c = true;
                    return false;
                }
            } catch (IOException e) {
                close();
                throw new IllegalStateException(e);
            }
        } while (!isValidLine(readLine));
        this.f6848b = readLine;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isValidLine(String str) {
        return true;
    }

    public String next() {
        return nextLine();
    }

    public String nextLine() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more lines");
        }
        String str = this.f6848b;
        this.f6848b = null;
        return str;
    }

    public void close() {
        this.f6849c = true;
        IOUtils.closeQuietly((Reader) this.f6847a);
        this.f6848b = null;
    }

    public void remove() {
        throw new UnsupportedOperationException("Remove unsupported on LineIterator");
    }

    public static void closeQuietly(LineIterator lineIterator) {
        if (lineIterator != null) {
            lineIterator.close();
        }
    }
}
