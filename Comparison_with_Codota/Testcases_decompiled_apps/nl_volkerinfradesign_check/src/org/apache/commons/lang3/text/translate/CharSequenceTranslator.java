package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

public abstract class CharSequenceTranslator {
    public abstract int translate(CharSequence charSequence, int i, Writer writer) throws IOException;

    public final String translate(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(charSequence.length() * 2);
            translate(charSequence, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public final void translate(CharSequence charSequence, Writer writer) throws IOException {
        int i;
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        } else if (charSequence != null) {
            int codePointCount = Character.codePointCount(charSequence, 0, charSequence.length());
            int i2 = 0;
            while (i < codePointCount) {
                int translate = translate(charSequence, i, writer);
                if (translate == 0) {
                    writer.write(Character.toChars(Character.codePointAt(charSequence, i)));
                } else {
                    for (int i3 = 0; i3 < translate; i3++) {
                        if (i < codePointCount - 2) {
                            i += Character.charCount(Character.codePointAt(charSequence, i));
                        } else {
                            i++;
                        }
                    }
                    i--;
                }
                i2 = i + 1;
            }
        }
    }

    public final CharSequenceTranslator with(CharSequenceTranslator... charSequenceTranslatorArr) {
        CharSequenceTranslator[] charSequenceTranslatorArr2 = new CharSequenceTranslator[(charSequenceTranslatorArr.length + 1)];
        charSequenceTranslatorArr2[0] = this;
        System.arraycopy(charSequenceTranslatorArr, 0, charSequenceTranslatorArr2, 1, charSequenceTranslatorArr.length);
        return new AggregateTranslator(charSequenceTranslatorArr2);
    }

    public static String hex(int i) {
        return Integer.toHexString(i).toUpperCase(Locale.ENGLISH);
    }
}
