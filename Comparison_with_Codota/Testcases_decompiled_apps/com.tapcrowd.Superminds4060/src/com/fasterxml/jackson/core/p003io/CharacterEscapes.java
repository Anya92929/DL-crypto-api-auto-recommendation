package com.fasterxml.jackson.core.p003io;

import com.fasterxml.jackson.core.SerializableString;
import java.io.Serializable;

/* renamed from: com.fasterxml.jackson.core.io.CharacterEscapes */
public abstract class CharacterEscapes implements Serializable {
    public static final int ESCAPE_CUSTOM = -2;
    public static final int ESCAPE_NONE = 0;
    public static final int ESCAPE_STANDARD = -1;
    private static final long serialVersionUID = 1;

    public abstract int[] getEscapeCodesForAscii();

    public abstract SerializableString getEscapeSequence(int i);

    public static int[] standardAsciiEscapesForJSON() {
        int[] esc = CharTypes.get7BitOutputEscapes();
        int[] result = new int[esc.length];
        System.arraycopy(esc, 0, result, 0, esc.length);
        return result;
    }
}
