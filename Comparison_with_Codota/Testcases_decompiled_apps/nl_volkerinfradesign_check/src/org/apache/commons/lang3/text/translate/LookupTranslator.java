package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

public class LookupTranslator extends CharSequenceTranslator {

    /* renamed from: a */
    private final HashMap<CharSequence, CharSequence> f7204a = new HashMap<>();

    /* renamed from: b */
    private final int f7205b;

    /* renamed from: c */
    private final int f7206c;

    public LookupTranslator(CharSequence[]... charSequenceArr) {
        int i;
        int i2 = Integer.MAX_VALUE;
        if (charSequenceArr != null) {
            int length = charSequenceArr.length;
            int i3 = 0;
            i = 0;
            int i4 = Integer.MAX_VALUE;
            while (i3 < length) {
                CharSequence[] charSequenceArr2 = charSequenceArr[i3];
                this.f7204a.put(charSequenceArr2[0], charSequenceArr2[1]);
                int length2 = charSequenceArr2[0].length();
                i4 = length2 < i4 ? length2 : i4;
                if (length2 <= i) {
                    length2 = i;
                }
                i3++;
                i = length2;
            }
            i2 = i4;
        } else {
            i = 0;
        }
        this.f7205b = i2;
        this.f7206c = i;
    }

    public int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
        int i2 = this.f7206c;
        if (this.f7206c + i > charSequence.length()) {
            i2 = charSequence.length() - i;
        }
        while (true) {
            int i3 = i2;
            if (i3 < this.f7205b) {
                return 0;
            }
            CharSequence charSequence2 = this.f7204a.get(charSequence.subSequence(i, i + i3));
            if (charSequence2 != null) {
                writer.write(charSequence2.toString());
                return i3;
            }
            i2 = i3 - 1;
        }
    }
}
