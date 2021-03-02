package com.parse.gdata;

import java.io.IOException;

public abstract class UnicodeEscaper implements Escaper {
    private static final int DEST_PAD = 32;
    private static final ThreadLocal<char[]> DEST_TL = new ThreadLocal<char[]>() {
        /* access modifiers changed from: protected */
        public char[] initialValue() {
            return new char[1024];
        }
    };

    /* access modifiers changed from: protected */
    public abstract char[] escape(int i);

    /* access modifiers changed from: protected */
    public int nextEscapeIndex(CharSequence csq, int start, int end) {
        int index = start;
        while (index < end) {
            int cp = codePointAt(csq, index, end);
            if (cp < 0 || escape(cp) != null) {
                break;
            }
            index += Character.isSupplementaryCodePoint(cp) ? 2 : 1;
        }
        return index;
    }

    public String escape(String string) {
        int end = string.length();
        int index = nextEscapeIndex(string, 0, end);
        return index == end ? string : escapeSlow(string, index);
    }

    /* access modifiers changed from: protected */
    public final String escapeSlow(String s, int index) {
        int end = s.length();
        char[] dest = DEST_TL.get();
        int destIndex = 0;
        int unescapedChunkStart = 0;
        while (index < end) {
            int cp = codePointAt(s, index, end);
            if (cp < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] escaped = escape(cp);
            if (escaped != null) {
                int charsSkipped = index - unescapedChunkStart;
                int sizeNeeded = destIndex + charsSkipped + escaped.length;
                if (dest.length < sizeNeeded) {
                    dest = growBuffer(dest, destIndex, (end - index) + sizeNeeded + 32);
                }
                if (charsSkipped > 0) {
                    s.getChars(unescapedChunkStart, index, dest, destIndex);
                    destIndex += charsSkipped;
                }
                if (escaped.length > 0) {
                    System.arraycopy(escaped, 0, dest, destIndex, escaped.length);
                    destIndex += escaped.length;
                }
            }
            unescapedChunkStart = index + (Character.isSupplementaryCodePoint(cp) ? 2 : 1);
            index = nextEscapeIndex(s, unescapedChunkStart, end);
        }
        int charsSkipped2 = end - unescapedChunkStart;
        if (charsSkipped2 > 0) {
            int endIndex = destIndex + charsSkipped2;
            if (dest.length < endIndex) {
                dest = growBuffer(dest, destIndex, endIndex);
            }
            s.getChars(unescapedChunkStart, end, dest, destIndex);
            destIndex = endIndex;
        }
        return new String(dest, 0, destIndex);
    }

    public Appendable escape(final Appendable out) {
        Preconditions.checkNotNull(out);
        return new Appendable() {
            char[] decodedChars = new char[2];
            int pendingHighSurrogate = -1;

            public Appendable append(CharSequence csq) throws IOException {
                return append(csq, 0, csq.length());
            }

            public Appendable append(CharSequence csq, int start, int end) throws IOException {
                int index = start;
                if (index < end) {
                    int unescapedChunkStart = index;
                    if (this.pendingHighSurrogate != -1) {
                        int index2 = index + 1;
                        char c = csq.charAt(index);
                        if (!Character.isLowSurrogate(c)) {
                            throw new IllegalArgumentException("Expected low surrogate character but got " + c);
                        }
                        char[] escaped = UnicodeEscaper.this.escape(Character.toCodePoint((char) this.pendingHighSurrogate, c));
                        if (escaped != null) {
                            outputChars(escaped, escaped.length);
                            unescapedChunkStart++;
                        } else {
                            out.append((char) this.pendingHighSurrogate);
                        }
                        this.pendingHighSurrogate = -1;
                        index = index2;
                    }
                    while (true) {
                        int index3 = UnicodeEscaper.this.nextEscapeIndex(csq, index, end);
                        if (index3 > unescapedChunkStart) {
                            out.append(csq, unescapedChunkStart, index3);
                        }
                        if (index3 == end) {
                            break;
                        }
                        int cp = UnicodeEscaper.codePointAt(csq, index3, end);
                        if (cp < 0) {
                            this.pendingHighSurrogate = -cp;
                            break;
                        }
                        char[] escaped2 = UnicodeEscaper.this.escape(cp);
                        if (escaped2 != null) {
                            outputChars(escaped2, escaped2.length);
                        } else {
                            outputChars(this.decodedChars, Character.toChars(cp, this.decodedChars, 0));
                        }
                        index = index3 + (Character.isSupplementaryCodePoint(cp) ? 2 : 1);
                        unescapedChunkStart = index;
                    }
                }
                return this;
            }

            public Appendable append(char c) throws IOException {
                if (this.pendingHighSurrogate != -1) {
                    if (!Character.isLowSurrogate(c)) {
                        throw new IllegalArgumentException("Expected low surrogate character but got '" + c + "' with value " + c);
                    }
                    char[] escaped = UnicodeEscaper.this.escape(Character.toCodePoint((char) this.pendingHighSurrogate, c));
                    if (escaped != null) {
                        outputChars(escaped, escaped.length);
                    } else {
                        out.append((char) this.pendingHighSurrogate);
                        out.append(c);
                    }
                    this.pendingHighSurrogate = -1;
                } else if (Character.isHighSurrogate(c)) {
                    this.pendingHighSurrogate = c;
                } else if (Character.isLowSurrogate(c)) {
                    throw new IllegalArgumentException("Unexpected low surrogate character '" + c + "' with value " + c);
                } else {
                    char[] escaped2 = UnicodeEscaper.this.escape((int) c);
                    if (escaped2 != null) {
                        outputChars(escaped2, escaped2.length);
                    } else {
                        out.append(c);
                    }
                }
                return this;
            }

            private void outputChars(char[] chars, int len) throws IOException {
                for (int n = 0; n < len; n++) {
                    out.append(chars[n]);
                }
            }
        };
    }

    protected static final int codePointAt(CharSequence seq, int index, int end) {
        if (index < end) {
            int index2 = index + 1;
            char c1 = seq.charAt(index);
            if (c1 < 55296 || c1 > 57343) {
                return c1;
            }
            if (c1 > 56319) {
                throw new IllegalArgumentException("Unexpected low surrogate character '" + c1 + "' with value " + c1 + " at index " + (index2 - 1));
            } else if (index2 == end) {
                return -c1;
            } else {
                char c2 = seq.charAt(index2);
                if (Character.isLowSurrogate(c2)) {
                    return Character.toCodePoint(c1, c2);
                }
                throw new IllegalArgumentException("Expected low surrogate but got char '" + c2 + "' with value " + c2 + " at index " + index2);
            }
        } else {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
    }

    private static final char[] growBuffer(char[] dest, int index, int size) {
        char[] copy = new char[size];
        if (index > 0) {
            System.arraycopy(dest, 0, copy, 0, index);
        }
        return copy;
    }
}
