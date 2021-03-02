package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

public class NumericEntityEscaper extends CodePointTranslator {

    /* renamed from: a */
    private final int f7207a;

    /* renamed from: b */
    private final int f7208b;

    /* renamed from: c */
    private final boolean f7209c;

    private NumericEntityEscaper(int i, int i2, boolean z) {
        this.f7207a = i;
        this.f7208b = i2;
        this.f7209c = z;
    }

    public NumericEntityEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }

    public static NumericEntityEscaper below(int i) {
        return outsideOf(i, Integer.MAX_VALUE);
    }

    public static NumericEntityEscaper above(int i) {
        return outsideOf(0, i);
    }

    public static NumericEntityEscaper between(int i, int i2) {
        return new NumericEntityEscaper(i, i2, true);
    }

    public static NumericEntityEscaper outsideOf(int i, int i2) {
        return new NumericEntityEscaper(i, i2, false);
    }

    public boolean translate(int i, Writer writer) throws IOException {
        if (this.f7209c) {
            if (i < this.f7207a || i > this.f7208b) {
                return false;
            }
        } else if (i >= this.f7207a && i <= this.f7208b) {
            return false;
        }
        writer.write("&#");
        writer.write(Integer.toString(i, 10));
        writer.write(59);
        return true;
    }
}
