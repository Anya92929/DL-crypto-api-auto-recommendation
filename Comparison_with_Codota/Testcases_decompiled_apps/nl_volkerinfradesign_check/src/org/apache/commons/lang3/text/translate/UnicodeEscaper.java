package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

public class UnicodeEscaper extends CodePointTranslator {

    /* renamed from: a */
    private final int f7213a;

    /* renamed from: b */
    private final int f7214b;

    /* renamed from: c */
    private final boolean f7215c;

    public UnicodeEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }

    private UnicodeEscaper(int i, int i2, boolean z) {
        this.f7213a = i;
        this.f7214b = i2;
        this.f7215c = z;
    }

    public static UnicodeEscaper below(int i) {
        return outsideOf(i, Integer.MAX_VALUE);
    }

    public static UnicodeEscaper above(int i) {
        return outsideOf(0, i);
    }

    public static UnicodeEscaper outsideOf(int i, int i2) {
        return new UnicodeEscaper(i, i2, false);
    }

    public static UnicodeEscaper between(int i, int i2) {
        return new UnicodeEscaper(i, i2, true);
    }

    public boolean translate(int i, Writer writer) throws IOException {
        if (this.f7215c) {
            if (i < this.f7213a || i > this.f7214b) {
                return false;
            }
        } else if (i >= this.f7213a && i <= this.f7214b) {
            return false;
        }
        if (i > 65535) {
            writer.write("\\u" + hex(i));
        } else if (i > 4095) {
            writer.write("\\u" + hex(i));
        } else if (i > 255) {
            writer.write("\\u0" + hex(i));
        } else if (i > 15) {
            writer.write("\\u00" + hex(i));
        } else {
            writer.write("\\u000" + hex(i));
        }
        return true;
    }
}
