package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.ArrayUtils;

public class AggregateTranslator extends CharSequenceTranslator {

    /* renamed from: a */
    private final CharSequenceTranslator[] f7193a;

    public AggregateTranslator(CharSequenceTranslator... charSequenceTranslatorArr) {
        this.f7193a = (CharSequenceTranslator[]) ArrayUtils.clone((T[]) charSequenceTranslatorArr);
    }

    public int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
        for (CharSequenceTranslator translate : this.f7193a) {
            int translate2 = translate.translate(charSequence, i, writer);
            if (translate2 != 0) {
                return translate2;
            }
        }
        return 0;
    }
}
