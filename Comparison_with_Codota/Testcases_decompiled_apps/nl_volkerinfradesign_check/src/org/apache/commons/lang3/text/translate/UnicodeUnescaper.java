package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

public class UnicodeUnescaper extends CharSequenceTranslator {
    public int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
        if (charSequence.charAt(i) != '\\' || i + 1 >= charSequence.length() || charSequence.charAt(i + 1) != 'u') {
            return 0;
        }
        int i2 = 2;
        while (i + i2 < charSequence.length() && charSequence.charAt(i + i2) == 'u') {
            i2++;
        }
        if (i + i2 < charSequence.length() && charSequence.charAt(i + i2) == '+') {
            i2++;
        }
        if (i + i2 + 4 <= charSequence.length()) {
            CharSequence subSequence = charSequence.subSequence(i + i2, i + i2 + 4);
            try {
                writer.write((char) Integer.parseInt(subSequence.toString(), 16));
                return i2 + 4;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Unable to parse unicode value: " + subSequence, e);
            }
        } else {
            throw new IllegalArgumentException("Less than 4 hex digits in unicode value: '" + charSequence.subSequence(i, charSequence.length()) + "' due to end of CharSequence");
        }
    }
}
