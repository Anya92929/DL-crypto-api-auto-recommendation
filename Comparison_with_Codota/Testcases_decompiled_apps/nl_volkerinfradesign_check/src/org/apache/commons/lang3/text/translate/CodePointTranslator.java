package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

public abstract class CodePointTranslator extends CharSequenceTranslator {
    public abstract boolean translate(int i, Writer writer) throws IOException;

    public final int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
        if (translate(Character.codePointAt(charSequence, i), writer)) {
            return 1;
        }
        return 0;
    }
}
