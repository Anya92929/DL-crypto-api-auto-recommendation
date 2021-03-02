package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.EnumSet;

public class NumericEntityUnescaper extends CharSequenceTranslator {

    /* renamed from: a */
    private final EnumSet<OPTION> f7210a;

    public enum OPTION {
        semiColonRequired,
        semiColonOptional,
        errorIfNoSemiColon
    }

    public NumericEntityUnescaper(OPTION... optionArr) {
        if (optionArr.length > 0) {
            this.f7210a = EnumSet.copyOf(Arrays.asList(optionArr));
            return;
        }
        this.f7210a = EnumSet.copyOf(Arrays.asList(new OPTION[]{OPTION.semiColonRequired}));
    }

    public boolean isSet(OPTION option) {
        if (this.f7210a == null) {
            return false;
        }
        return this.f7210a.contains(option);
    }

    public int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
        int i2;
        boolean z;
        int parseInt;
        int i3;
        int i4 = 1;
        int length = charSequence.length();
        if (charSequence.charAt(i) != '&' || i >= length - 2 || charSequence.charAt(i + 1) != '#') {
            return 0;
        }
        int i5 = i + 2;
        char charAt = charSequence.charAt(i5);
        if (charAt == 'x' || charAt == 'X') {
            int i6 = i5 + 1;
            if (i6 == length) {
                return 0;
            }
            i2 = i6;
            z = true;
        } else {
            i2 = i5;
            z = false;
        }
        int i7 = i2;
        while (i7 < length && ((charSequence.charAt(i7) >= '0' && charSequence.charAt(i7) <= '9') || ((charSequence.charAt(i7) >= 'a' && charSequence.charAt(i7) <= 'f') || (charSequence.charAt(i7) >= 'A' && charSequence.charAt(i7) <= 'F')))) {
            i7++;
        }
        boolean z2 = i7 != length && charSequence.charAt(i7) == ';';
        if (!z2) {
            if (isSet(OPTION.semiColonRequired)) {
                return 0;
            }
            if (isSet(OPTION.errorIfNoSemiColon)) {
                throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
            }
        }
        if (z) {
            try {
                parseInt = Integer.parseInt(charSequence.subSequence(i2, i7).toString(), 16);
            } catch (NumberFormatException e) {
                return 0;
            }
        } else {
            parseInt = Integer.parseInt(charSequence.subSequence(i2, i7).toString(), 10);
        }
        if (parseInt > 65535) {
            char[] chars = Character.toChars(parseInt);
            writer.write(chars[0]);
            writer.write(chars[1]);
        } else {
            writer.write(parseInt);
        }
        int i8 = (i7 - i2) + 2;
        if (z) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i9 = i3 + i8;
        if (!z2) {
            i4 = 0;
        }
        return i9 + i4;
    }
}
