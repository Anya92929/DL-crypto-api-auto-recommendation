package org.apache.commons.lang3.text;

import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

public class ExtendedMessageFormat extends MessageFormat {
    private static final long serialVersionUID = -2362048321261811743L;

    /* renamed from: a */
    private String f7153a;

    /* renamed from: b */
    private final Map<String, ? extends FormatFactory> f7154b;

    public ExtendedMessageFormat(String str) {
        this(str, Locale.getDefault());
    }

    public ExtendedMessageFormat(String str, Locale locale) {
        this(str, locale, (Map<String, ? extends FormatFactory>) null);
    }

    public ExtendedMessageFormat(String str, Map<String, ? extends FormatFactory> map) {
        this(str, Locale.getDefault(), map);
    }

    public ExtendedMessageFormat(String str, Locale locale, Map<String, ? extends FormatFactory> map) {
        super("");
        setLocale(locale);
        this.f7154b = map;
        applyPattern(str);
    }

    public String toPattern() {
        return this.f7153a;
    }

    public final void applyPattern(String str) {
        String str2;
        Format format;
        boolean z;
        boolean z2;
        int i = 0;
        if (this.f7154b == null) {
            super.applyPattern(str);
            this.f7153a = super.toPattern();
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StringBuilder sb = new StringBuilder(str.length());
        ParsePosition parsePosition = new ParsePosition(0);
        char[] charArray = str.toCharArray();
        int i2 = 0;
        while (parsePosition.getIndex() < str.length()) {
            switch (charArray[parsePosition.getIndex()]) {
                case '\'':
                    m7439a(str, parsePosition, sb, true);
                    continue;
                case '{':
                    int i3 = i2 + 1;
                    m7445c(str, parsePosition);
                    int index = parsePosition.getIndex();
                    sb.append('{').append(m7437a(str, m7441a(parsePosition)));
                    m7445c(str, parsePosition);
                    if (charArray[parsePosition.getIndex()] == ',') {
                        str2 = m7444b(str, m7441a(parsePosition));
                        format = m7440a(str2);
                        if (format == null) {
                            sb.append(',').append(str2);
                        }
                    } else {
                        str2 = null;
                        format = null;
                    }
                    arrayList.add(format);
                    if (format == null) {
                        str2 = null;
                    }
                    arrayList2.add(str2);
                    if (arrayList.size() == i3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Validate.isTrue(z);
                    if (arrayList2.size() == i3) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Validate.isTrue(z2);
                    if (charArray[parsePosition.getIndex()] == '}') {
                        i2 = i3;
                        break;
                    } else {
                        throw new IllegalArgumentException("Unreadable format element at position " + index);
                    }
            }
            sb.append(charArray[parsePosition.getIndex()]);
            m7441a(parsePosition);
        }
        super.applyPattern(sb.toString());
        this.f7153a = m7438a(super.toPattern(), (ArrayList<String>) arrayList2);
        if (m7443a((Collection<?>) arrayList)) {
            Format[] formats = getFormats();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Format format2 = (Format) it.next();
                if (format2 != null) {
                    formats[i] = format2;
                }
                i++;
            }
            super.setFormats(formats);
        }
    }

    public void setFormat(int i, Format format) {
        throw new UnsupportedOperationException();
    }

    public void setFormatByArgumentIndex(int i, Format format) {
        throw new UnsupportedOperationException();
    }

    public void setFormats(Format[] formatArr) {
        throw new UnsupportedOperationException();
    }

    public void setFormatsByArgumentIndex(Format[] formatArr) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (ObjectUtils.notEqual(getClass(), obj.getClass())) {
            return false;
        }
        ExtendedMessageFormat extendedMessageFormat = (ExtendedMessageFormat) obj;
        if (ObjectUtils.notEqual(this.f7153a, extendedMessageFormat.f7153a)) {
            return false;
        }
        if (ObjectUtils.notEqual(this.f7154b, extendedMessageFormat.f7154b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((super.hashCode() * 31) + ObjectUtils.hashCode(this.f7154b)) * 31) + ObjectUtils.hashCode(this.f7153a);
    }

    /* renamed from: a */
    private Format m7440a(String str) {
        String str2;
        if (this.f7154b == null) {
            return null;
        }
        int indexOf = str.indexOf(44);
        if (indexOf > 0) {
            str = str.substring(0, indexOf).trim();
            str2 = str.substring(indexOf + 1).trim();
        } else {
            str2 = null;
        }
        FormatFactory formatFactory = (FormatFactory) this.f7154b.get(str);
        if (formatFactory != null) {
            return formatFactory.getFormat(str, str2, getLocale());
        }
        return null;
    }

    /* renamed from: a */
    private int m7437a(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        m7445c(str, parsePosition);
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = false;
        while (!z && parsePosition.getIndex() < str.length()) {
            char charAt = str.charAt(parsePosition.getIndex());
            if (Character.isWhitespace(charAt)) {
                m7445c(str, parsePosition);
                charAt = str.charAt(parsePosition.getIndex());
                if (!(charAt == ',' || charAt == '}')) {
                    z = true;
                    m7441a(parsePosition);
                }
            }
            char c = charAt;
            if ((c == ',' || c == '}') && stringBuffer.length() > 0) {
                try {
                    return Integer.parseInt(stringBuffer.toString());
                } catch (NumberFormatException e) {
                }
            }
            if (!Character.isDigit(c)) {
                z = true;
            } else {
                z = false;
            }
            stringBuffer.append(c);
            m7441a(parsePosition);
        }
        if (z) {
            throw new IllegalArgumentException("Invalid format argument index at position " + index + ": " + str.substring(index, parsePosition.getIndex()));
        }
        throw new IllegalArgumentException("Unterminated format element at position " + index);
    }

    /* renamed from: b */
    private String m7444b(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        m7445c(str, parsePosition);
        int index2 = parsePosition.getIndex();
        int i = 1;
        while (parsePosition.getIndex() < str.length()) {
            switch (str.charAt(parsePosition.getIndex())) {
                case '\'':
                    m7442a(str, parsePosition, false);
                    break;
                case '{':
                    i++;
                    break;
                case '}':
                    i--;
                    if (i != 0) {
                        break;
                    } else {
                        return str.substring(index2, parsePosition.getIndex());
                    }
            }
            m7441a(parsePosition);
        }
        throw new IllegalArgumentException("Unterminated format element at position " + index);
    }

    /* renamed from: a */
    private String m7438a(String str, ArrayList<String> arrayList) {
        if (!m7443a((Collection<?>) arrayList)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() * 2);
        ParsePosition parsePosition = new ParsePosition(0);
        int i = -1;
        int i2 = 0;
        while (parsePosition.getIndex() < str.length()) {
            char charAt = str.charAt(parsePosition.getIndex());
            switch (charAt) {
                case '\'':
                    m7439a(str, parsePosition, sb, false);
                    continue;
                case '{':
                    int i3 = i2 + 1;
                    if (i3 != 1) {
                        i2 = i3;
                        break;
                    } else {
                        i++;
                        sb.append('{').append(m7437a(str, m7441a(parsePosition)));
                        String str2 = arrayList.get(i);
                        if (str2 != null) {
                            sb.append(',').append(str2);
                        }
                        i2 = i3;
                        continue;
                    }
                case '}':
                    i2--;
                    break;
            }
            sb.append(charAt);
            m7441a(parsePosition);
        }
        return sb.toString();
    }

    /* renamed from: c */
    private void m7445c(String str, ParsePosition parsePosition) {
        char[] charArray = str.toCharArray();
        do {
            int isMatch = StrMatcher.splitMatcher().isMatch(charArray, parsePosition.getIndex());
            parsePosition.setIndex(parsePosition.getIndex() + isMatch);
            if (isMatch <= 0 || parsePosition.getIndex() >= str.length()) {
            }
            int isMatch2 = StrMatcher.splitMatcher().isMatch(charArray, parsePosition.getIndex());
            parsePosition.setIndex(parsePosition.getIndex() + isMatch2);
            return;
        } while (parsePosition.getIndex() >= str.length());
    }

    /* renamed from: a */
    private ParsePosition m7441a(ParsePosition parsePosition) {
        parsePosition.setIndex(parsePosition.getIndex() + 1);
        return parsePosition;
    }

    /* renamed from: a */
    private StringBuilder m7439a(String str, ParsePosition parsePosition, StringBuilder sb, boolean z) {
        int index = parsePosition.getIndex();
        char[] charArray = str.toCharArray();
        if (!z || charArray[index] != '\'') {
            int i = index;
            for (int index2 = parsePosition.getIndex(); index2 < str.length(); index2++) {
                if (!z || !str.substring(index2).startsWith("''")) {
                    switch (charArray[parsePosition.getIndex()]) {
                        case '\'':
                            m7441a(parsePosition);
                            if (sb != null) {
                                return sb.append(charArray, i, parsePosition.getIndex() - i);
                            }
                            return null;
                        default:
                            m7441a(parsePosition);
                            break;
                    }
                } else {
                    sb.append(charArray, i, parsePosition.getIndex() - i).append('\'');
                    parsePosition.setIndex("''".length() + index2);
                    i = parsePosition.getIndex();
                }
            }
            throw new IllegalArgumentException("Unterminated quoted string at position " + index);
        }
        m7441a(parsePosition);
        if (sb == null) {
            return null;
        }
        return sb.append('\'');
    }

    /* renamed from: a */
    private void m7442a(String str, ParsePosition parsePosition, boolean z) {
        m7439a(str, parsePosition, (StringBuilder) null, z);
    }

    /* renamed from: a */
    private boolean m7443a(Collection<?> collection) {
        if (collection == null || collection.size() == 0) {
            return false;
        }
        for (Object obj : collection) {
            if (obj != null) {
                return true;
            }
        }
        return false;
    }
}
