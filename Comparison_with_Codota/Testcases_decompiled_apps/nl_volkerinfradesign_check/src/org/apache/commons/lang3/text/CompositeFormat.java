package org.apache.commons.lang3.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;

public class CompositeFormat extends Format {
    private static final long serialVersionUID = -4329119827877627683L;

    /* renamed from: a */
    private final Format f7151a;

    /* renamed from: b */
    private final Format f7152b;

    public CompositeFormat(Format format, Format format2) {
        this.f7151a = format;
        this.f7152b = format2;
    }

    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.f7152b.format(obj, stringBuffer, fieldPosition);
    }

    public Object parseObject(String str, ParsePosition parsePosition) {
        return this.f7151a.parseObject(str, parsePosition);
    }

    public Format getParser() {
        return this.f7151a;
    }

    public Format getFormatter() {
        return this.f7152b;
    }

    public String reformat(String str) throws ParseException {
        return format(parseObject(str));
    }
}
