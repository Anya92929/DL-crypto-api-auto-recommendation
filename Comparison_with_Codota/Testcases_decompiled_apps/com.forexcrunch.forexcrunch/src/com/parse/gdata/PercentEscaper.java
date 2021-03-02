package com.parse.gdata;

import com.parse.ParseException;

public class PercentEscaper extends UnicodeEscaper {
    public static final String SAFECHARS_URLENCODER = "-_.*";
    public static final String SAFEPATHCHARS_URLENCODER = "-_.!~*'()@:$&,;=";
    public static final String SAFEQUERYSTRINGCHARS_URLENCODER = "-_.!~*'()@:$,;/?:";
    private static final char[] UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private static final char[] URI_ESCAPED_SPACE = {'+'};
    private final boolean plusForSpace;
    private final boolean[] safeOctets;

    public PercentEscaper(String safeChars, boolean plusForSpace2) {
        if (safeChars.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        } else if (plusForSpace2 && safeChars.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        } else if (safeChars.contains("%")) {
            throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
        } else {
            this.plusForSpace = plusForSpace2;
            this.safeOctets = createSafeOctets(safeChars);
        }
    }

    private static boolean[] createSafeOctets(String safeChars) {
        int maxChar = ParseException.INVALID_FILE_NAME;
        char[] safeCharArray = safeChars.toCharArray();
        for (char c : safeCharArray) {
            maxChar = Math.max(c, maxChar);
        }
        boolean[] octets = new boolean[(maxChar + 1)];
        for (int c2 = 48; c2 <= 57; c2++) {
            octets[c2] = true;
        }
        for (int c3 = 65; c3 <= 90; c3++) {
            octets[c3] = true;
        }
        for (int c4 = 97; c4 <= 122; c4++) {
            octets[c4] = true;
        }
        for (char c5 : safeCharArray) {
            octets[c5] = true;
        }
        return octets;
    }

    /* access modifiers changed from: protected */
    public int nextEscapeIndex(CharSequence csq, int index, int end) {
        while (index < end) {
            char c = csq.charAt(index);
            if (c >= this.safeOctets.length || !this.safeOctets[c]) {
                break;
            }
            index++;
        }
        return index;
    }

    public String escape(String s) {
        int slen = s.length();
        for (int index = 0; index < slen; index++) {
            char c = s.charAt(index);
            if (c >= this.safeOctets.length || !this.safeOctets[c]) {
                return escapeSlow(s, index);
            }
        }
        return s;
    }

    /* access modifiers changed from: protected */
    public char[] escape(int cp) {
        if (cp < this.safeOctets.length && this.safeOctets[cp]) {
            return null;
        }
        if (cp == 32 && this.plusForSpace) {
            return URI_ESCAPED_SPACE;
        }
        if (cp <= 127) {
            char[] dest = new char[3];
            dest[0] = '%';
            dest[2] = UPPER_HEX_DIGITS[cp & 15];
            dest[1] = UPPER_HEX_DIGITS[cp >>> 4];
            return dest;
        } else if (cp <= 2047) {
            char[] dest2 = new char[6];
            dest2[0] = '%';
            dest2[3] = '%';
            dest2[5] = UPPER_HEX_DIGITS[cp & 15];
            int cp2 = cp >>> 4;
            dest2[4] = UPPER_HEX_DIGITS[(cp2 & 3) | 8];
            int cp3 = cp2 >>> 2;
            dest2[2] = UPPER_HEX_DIGITS[cp3 & 15];
            dest2[1] = UPPER_HEX_DIGITS[(cp3 >>> 4) | 12];
            return dest2;
        } else if (cp <= 65535) {
            char[] dest3 = new char[9];
            dest3[0] = '%';
            dest3[1] = 'E';
            dest3[3] = '%';
            dest3[6] = '%';
            dest3[8] = UPPER_HEX_DIGITS[cp & 15];
            int cp4 = cp >>> 4;
            dest3[7] = UPPER_HEX_DIGITS[(cp4 & 3) | 8];
            int cp5 = cp4 >>> 2;
            dest3[5] = UPPER_HEX_DIGITS[cp5 & 15];
            int cp6 = cp5 >>> 4;
            dest3[4] = UPPER_HEX_DIGITS[(cp6 & 3) | 8];
            dest3[2] = UPPER_HEX_DIGITS[cp6 >>> 2];
            return dest3;
        } else if (cp <= 1114111) {
            char[] dest4 = new char[12];
            dest4[0] = '%';
            dest4[1] = 'F';
            dest4[3] = '%';
            dest4[6] = '%';
            dest4[9] = '%';
            dest4[11] = UPPER_HEX_DIGITS[cp & 15];
            int cp7 = cp >>> 4;
            dest4[10] = UPPER_HEX_DIGITS[(cp7 & 3) | 8];
            int cp8 = cp7 >>> 2;
            dest4[8] = UPPER_HEX_DIGITS[cp8 & 15];
            int cp9 = cp8 >>> 4;
            dest4[7] = UPPER_HEX_DIGITS[(cp9 & 3) | 8];
            int cp10 = cp9 >>> 2;
            dest4[5] = UPPER_HEX_DIGITS[cp10 & 15];
            int cp11 = cp10 >>> 4;
            dest4[4] = UPPER_HEX_DIGITS[(cp11 & 3) | 8];
            dest4[2] = UPPER_HEX_DIGITS[(cp11 >>> 2) & 7];
            return dest4;
        } else {
            throw new IllegalArgumentException("Invalid unicode character value " + cp);
        }
    }
}
