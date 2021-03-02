package org.apache.commons.p009io.input;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.p009io.ByteOrderMark;

/* renamed from: org.apache.commons.io.input.XmlStreamReader */
public class XmlStreamReader extends Reader {
    public static final Pattern ENCODING_PATTERN = Pattern.compile("<\\?xml.*encoding[\\s]*=[\\s]*((?:\".[^\"]*\")|(?:'.[^']*'))", 8);

    /* renamed from: a */
    private static final ByteOrderMark[] f6950a = {ByteOrderMark.UTF_8, ByteOrderMark.UTF_16BE, ByteOrderMark.UTF_16LE, ByteOrderMark.UTF_32BE, ByteOrderMark.UTF_32LE};

    /* renamed from: b */
    private static final ByteOrderMark[] f6951b = {new ByteOrderMark(CharEncoding.UTF_8, 60, 63, 120, 109), new ByteOrderMark(CharEncoding.UTF_16BE, 0, 60, 0, 63), new ByteOrderMark(CharEncoding.UTF_16LE, 60, 0, 63, 0), new ByteOrderMark("UTF-32BE", 0, 0, 0, 60, 0, 0, 0, 63, 0, 0, 0, 120, 0, 0, 0, 109), new ByteOrderMark("UTF-32LE", 60, 0, 0, 0, 63, 0, 0, 0, 120, 0, 0, 0, 109, 0, 0, 0), new ByteOrderMark("CP1047", 76, 111, 167, 148)};

    /* renamed from: f */
    private static final Pattern f6952f = Pattern.compile("charset=[\"']?([.[^; \"']]*)[\"']?");

    /* renamed from: c */
    private final Reader f6953c;

    /* renamed from: d */
    private final String f6954d;

    /* renamed from: e */
    private final String f6955e;

    public String getDefaultEncoding() {
        return this.f6955e;
    }

    public XmlStreamReader(File file) throws IOException {
        this((InputStream) new FileInputStream(file));
    }

    public XmlStreamReader(InputStream inputStream) throws IOException {
        this(inputStream, true);
    }

    public XmlStreamReader(InputStream inputStream, boolean z) throws IOException {
        this(inputStream, z, (String) null);
    }

    public XmlStreamReader(InputStream inputStream, boolean z, String str) throws IOException {
        this.f6955e = str;
        BOMInputStream bOMInputStream = new BOMInputStream(new BufferedInputStream(inputStream, 4096), false, f6950a);
        BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream, true, f6951b);
        this.f6954d = m7313a(bOMInputStream, bOMInputStream2, z);
        this.f6953c = new InputStreamReader(bOMInputStream2, this.f6954d);
    }

    public XmlStreamReader(URL url) throws IOException {
        this(url.openConnection(), (String) null);
    }

    public XmlStreamReader(URLConnection uRLConnection, String str) throws IOException {
        this.f6955e = str;
        String contentType = uRLConnection.getContentType();
        BOMInputStream bOMInputStream = new BOMInputStream(new BufferedInputStream(uRLConnection.getInputStream(), 4096), false, f6950a);
        BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream, true, f6951b);
        if ((uRLConnection instanceof HttpURLConnection) || contentType != null) {
            this.f6954d = m7312a(bOMInputStream, bOMInputStream2, contentType, true);
        } else {
            this.f6954d = m7313a(bOMInputStream, bOMInputStream2, true);
        }
        this.f6953c = new InputStreamReader(bOMInputStream2, this.f6954d);
    }

    public XmlStreamReader(InputStream inputStream, String str) throws IOException {
        this(inputStream, str, true);
    }

    public XmlStreamReader(InputStream inputStream, String str, boolean z, String str2) throws IOException {
        this.f6955e = str2;
        BOMInputStream bOMInputStream = new BOMInputStream(new BufferedInputStream(inputStream, 4096), false, f6950a);
        BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream, true, f6951b);
        this.f6954d = m7312a(bOMInputStream, bOMInputStream2, str, z);
        this.f6953c = new InputStreamReader(bOMInputStream2, this.f6954d);
    }

    public XmlStreamReader(InputStream inputStream, String str, boolean z) throws IOException {
        this(inputStream, str, z, (String) null);
    }

    public String getEncoding() {
        return this.f6954d;
    }

    public int read(char[] cArr, int i, int i2) throws IOException {
        return this.f6953c.read(cArr, i, i2);
    }

    public void close() throws IOException {
        this.f6953c.close();
    }

    /* renamed from: a */
    private String m7313a(BOMInputStream bOMInputStream, BOMInputStream bOMInputStream2, boolean z) throws IOException {
        String bOMCharsetName = bOMInputStream.getBOMCharsetName();
        String bOMCharsetName2 = bOMInputStream2.getBOMCharsetName();
        try {
            return mo12679a(bOMCharsetName, bOMCharsetName2, m7309a((InputStream) bOMInputStream2, bOMCharsetName2));
        } catch (XmlStreamReaderException e) {
            if (z) {
                return m7311a((String) null, e);
            }
            throw e;
        }
    }

    /* renamed from: a */
    private String m7312a(BOMInputStream bOMInputStream, BOMInputStream bOMInputStream2, String str, boolean z) throws IOException {
        String bOMCharsetName = bOMInputStream.getBOMCharsetName();
        String bOMCharsetName2 = bOMInputStream2.getBOMCharsetName();
        try {
            return mo12680a(str, bOMCharsetName, bOMCharsetName2, m7309a((InputStream) bOMInputStream2, bOMCharsetName2), z);
        } catch (XmlStreamReaderException e) {
            if (z) {
                return m7311a(str, e);
            }
            throw e;
        }
    }

    /* renamed from: a */
    private String m7311a(String str, XmlStreamReaderException e) throws IOException {
        if (str != null && str.startsWith("text/html")) {
            try {
                return mo12680a("text/xml" + str.substring("text/html".length()), e.getBomEncoding(), e.getXmlGuessEncoding(), e.getXmlEncoding(), true);
            } catch (XmlStreamReaderException e2) {
                e = e2;
            }
        }
        String xmlEncoding = e.getXmlEncoding();
        if (xmlEncoding == null) {
            xmlEncoding = e.getContentTypeEncoding();
        }
        if (xmlEncoding == null) {
            return this.f6955e == null ? CharEncoding.UTF_8 : this.f6955e;
        }
        return xmlEncoding;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo12679a(String str, String str2, String str3) throws IOException {
        String str4;
        if (str == null) {
            if (str2 == null || str3 == null) {
                if (this.f6955e == null) {
                    str4 = CharEncoding.UTF_8;
                } else {
                    str4 = this.f6955e;
                }
                return str4;
            } else if (!str3.equals(CharEncoding.UTF_16) || (!str2.equals(CharEncoding.UTF_16BE) && !str2.equals(CharEncoding.UTF_16LE))) {
                return str3;
            } else {
                return str2;
            }
        } else if (str.equals(CharEncoding.UTF_8)) {
            if (str2 != null && !str2.equals(CharEncoding.UTF_8)) {
                throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[]{str, str2, str3}), str, str2, str3);
            } else if (str3 == null || str3.equals(CharEncoding.UTF_8)) {
                return str;
            } else {
                throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[]{str, str2, str3}), str, str2, str3);
            }
        } else if (str.equals(CharEncoding.UTF_16BE) || str.equals(CharEncoding.UTF_16LE)) {
            if (str2 != null && !str2.equals(str)) {
                throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[]{str, str2, str3}), str, str2, str3);
            } else if (str3 == null || str3.equals(CharEncoding.UTF_16) || str3.equals(str)) {
                return str;
            } else {
                throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[]{str, str2, str3}), str, str2, str3);
            }
        } else if (!str.equals("UTF-32BE") && !str.equals("UTF-32LE")) {
            throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] unknown BOM", new Object[]{str, str2, str3}), str, str2, str3);
        } else if (str2 != null && !str2.equals(str)) {
            throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[]{str, str2, str3}), str, str2, str3);
        } else if (str3 == null || str3.equals("UTF-32") || str3.equals(str)) {
            return str;
        } else {
            throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[]{str, str2, str3}), str, str2, str3);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo12680a(String str, String str2, String str3, String str4, boolean z) throws IOException {
        if (z && str4 != null) {
            return str4;
        }
        String a = m7310a(str);
        String b = m7314b(str);
        boolean c = m7315c(a);
        boolean d = m7316d(a);
        if (!c && !d) {
            throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], Invalid MIME", new Object[]{a, b, str2, str3, str4}), a, b, str2, str3, str4);
        } else if (b == null) {
            if (c) {
                return mo12679a(str2, str3, str4);
            }
            return this.f6955e == null ? CharEncoding.US_ASCII : this.f6955e;
        } else if (b.equals(CharEncoding.UTF_16BE) || b.equals(CharEncoding.UTF_16LE)) {
            if (str2 == null) {
                return b;
            }
            throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be NULL", new Object[]{a, b, str2, str3, str4}), a, b, str2, str3, str4);
        } else if (b.equals(CharEncoding.UTF_16)) {
            if (str2 != null && str2.startsWith(CharEncoding.UTF_16)) {
                return str2;
            }
            throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch", new Object[]{a, b, str2, str3, str4}), a, b, str2, str3, str4);
        } else if (b.equals("UTF-32BE") || b.equals("UTF-32LE")) {
            if (str2 == null) {
                return b;
            }
            throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be NULL", new Object[]{a, b, str2, str3, str4}), a, b, str2, str3, str4);
        } else if (!b.equals("UTF-32")) {
            return b;
        } else {
            if (str2 != null && str2.startsWith("UTF-32")) {
                return str2;
            }
            throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch", new Object[]{a, b, str2, str3, str4}), a, b, str2, str3, str4);
        }
    }

    /* renamed from: a */
    static String m7310a(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(";");
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        return str.trim();
    }

    /* renamed from: b */
    static String m7314b(String str) {
        int indexOf;
        String str2;
        if (str == null || (indexOf = str.indexOf(";")) <= -1) {
            return null;
        }
        Matcher matcher = f6952f.matcher(str.substring(indexOf + 1));
        if (matcher.find()) {
            str2 = matcher.group(1);
        } else {
            str2 = null;
        }
        if (str2 != null) {
            return str2.toUpperCase(Locale.US);
        }
        return null;
    }

    /* renamed from: a */
    private static String m7309a(InputStream inputStream, String str) throws IOException {
        if (str == null) {
            return null;
        }
        byte[] bArr = new byte[4096];
        inputStream.mark(4096);
        int i = -1;
        int read = inputStream.read(bArr, 0, 4096);
        int i2 = 4096;
        int i3 = 0;
        String str2 = null;
        while (read != -1 && i == -1 && i3 < 4096) {
            i3 += read;
            i2 -= read;
            read = inputStream.read(bArr, i3, i2);
            str2 = new String(bArr, 0, i3, str);
            i = str2.indexOf(62);
        }
        if (i == -1) {
            if (read == -1) {
                throw new IOException("Unexpected end of XML stream");
            }
            throw new IOException("XML prolog or ROOT element not found on first " + i3 + " bytes");
        } else if (i3 <= 0) {
            return null;
        } else {
            inputStream.reset();
            BufferedReader bufferedReader = new BufferedReader(new StringReader(str2.substring(0, i + 1)));
            StringBuffer stringBuffer = new StringBuffer();
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                stringBuffer.append(readLine);
            }
            Matcher matcher = ENCODING_PATTERN.matcher(stringBuffer);
            if (!matcher.find()) {
                return null;
            }
            String upperCase = matcher.group(1).toUpperCase();
            return upperCase.substring(1, upperCase.length() - 1);
        }
    }

    /* renamed from: c */
    static boolean m7315c(String str) {
        return str != null && (str.equals("application/xml") || str.equals("application/xml-dtd") || str.equals("application/xml-external-parsed-entity") || (str.startsWith("application/") && str.endsWith("+xml")));
    }

    /* renamed from: d */
    static boolean m7316d(String str) {
        return str != null && (str.equals("text/xml") || str.equals("text/xml-external-parsed-entity") || (str.startsWith("text/") && str.endsWith("+xml")));
    }
}
