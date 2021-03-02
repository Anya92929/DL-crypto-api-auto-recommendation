package org.apache.commons.p009io.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.p009io.input.XmlStreamReader;

/* renamed from: org.apache.commons.io.output.XmlStreamWriter */
public class XmlStreamWriter extends Writer {

    /* renamed from: a */
    static final Pattern f7008a = XmlStreamReader.ENCODING_PATTERN;

    /* renamed from: b */
    private final OutputStream f7009b;

    /* renamed from: c */
    private final String f7010c;

    /* renamed from: d */
    private StringWriter f7011d;

    /* renamed from: e */
    private Writer f7012e;

    /* renamed from: f */
    private String f7013f;

    public XmlStreamWriter(OutputStream outputStream) {
        this(outputStream, (String) null);
    }

    public XmlStreamWriter(OutputStream outputStream, String str) {
        this.f7011d = new StringWriter(4096);
        this.f7009b = outputStream;
        this.f7010c = str == null ? CharEncoding.UTF_8 : str;
    }

    public XmlStreamWriter(File file) throws FileNotFoundException {
        this(file, (String) null);
    }

    public XmlStreamWriter(File file, String str) throws FileNotFoundException {
        this((OutputStream) new FileOutputStream(file), str);
    }

    public String getEncoding() {
        return this.f7013f;
    }

    public String getDefaultEncoding() {
        return this.f7010c;
    }

    public void close() throws IOException {
        if (this.f7012e == null) {
            this.f7013f = this.f7010c;
            this.f7012e = new OutputStreamWriter(this.f7009b, this.f7013f);
            this.f7012e.write(this.f7011d.toString());
        }
        this.f7012e.close();
    }

    public void flush() throws IOException {
        if (this.f7012e != null) {
            this.f7012e.flush();
        }
    }

    /* renamed from: a */
    private void m7333a(char[] cArr, int i, int i2) throws IOException {
        int i3;
        StringBuffer buffer = this.f7011d.getBuffer();
        if (buffer.length() + i2 > 4096) {
            i3 = 4096 - buffer.length();
        } else {
            i3 = i2;
        }
        this.f7011d.write(cArr, i, i3);
        if (buffer.length() >= 5) {
            if (buffer.substring(0, 5).equals("<?xml")) {
                int indexOf = buffer.indexOf("?>");
                if (indexOf > 0) {
                    Matcher matcher = f7008a.matcher(buffer.substring(0, indexOf));
                    if (matcher.find()) {
                        this.f7013f = matcher.group(1).toUpperCase();
                        this.f7013f = this.f7013f.substring(1, this.f7013f.length() - 1);
                    } else {
                        this.f7013f = this.f7010c;
                    }
                } else if (buffer.length() >= 4096) {
                    this.f7013f = this.f7010c;
                }
            } else {
                this.f7013f = this.f7010c;
            }
            if (this.f7013f != null) {
                this.f7011d = null;
                this.f7012e = new OutputStreamWriter(this.f7009b, this.f7013f);
                this.f7012e.write(buffer.toString());
                if (i2 > i3) {
                    this.f7012e.write(cArr, i + i3, i2 - i3);
                }
            }
        }
    }

    public void write(char[] cArr, int i, int i2) throws IOException {
        if (this.f7011d != null) {
            m7333a(cArr, i, i2);
        } else {
            this.f7012e.write(cArr, i, i2);
        }
    }
}
