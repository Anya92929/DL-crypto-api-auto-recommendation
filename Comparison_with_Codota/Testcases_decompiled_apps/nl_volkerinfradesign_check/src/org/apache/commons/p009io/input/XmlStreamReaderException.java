package org.apache.commons.p009io.input;

import java.io.IOException;

/* renamed from: org.apache.commons.io.input.XmlStreamReaderException */
public class XmlStreamReaderException extends IOException {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private final String f6956a;

    /* renamed from: b */
    private final String f6957b;

    /* renamed from: c */
    private final String f6958c;

    /* renamed from: d */
    private final String f6959d;

    /* renamed from: e */
    private final String f6960e;

    public XmlStreamReaderException(String str, String str2, String str3, String str4) {
        this(str, (String) null, (String) null, str2, str3, str4);
    }

    public XmlStreamReaderException(String str, String str2, String str3, String str4, String str5, String str6) {
        super(str);
        this.f6959d = str2;
        this.f6960e = str3;
        this.f6956a = str4;
        this.f6957b = str5;
        this.f6958c = str6;
    }

    public String getBomEncoding() {
        return this.f6956a;
    }

    public String getXmlGuessEncoding() {
        return this.f6957b;
    }

    public String getXmlEncoding() {
        return this.f6958c;
    }

    public String getContentTypeMime() {
        return this.f6959d;
    }

    public String getContentTypeEncoding() {
        return this.f6960e;
    }
}
