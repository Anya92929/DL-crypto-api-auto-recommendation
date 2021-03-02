package org.p004a.p005a.p014d.p019e;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.p004a.p005a.p014d.p020f.C0332a;

/* renamed from: org.a.a.d.e.a */
public abstract class C0324a implements C0330g {

    /* renamed from: a */
    private static final String[] f164a;

    /* renamed from: b */
    private final Log f165b = LogFactory.getLog(getClass());

    static {
        String[] strArr = {"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        f164a = strArr;
        Arrays.sort(strArr);
    }

    /* renamed from: a */
    private void m291a(String str, X509Certificate x509Certificate) {
        String[] strArr;
        LinkedList linkedList = new LinkedList();
        StringTokenizer stringTokenizer = new StringTokenizer(x509Certificate.getSubjectX500Principal().toString(), ",+"); // CRYPTOGRAPHIC API CALLSITE 6
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if (trim.length() > 3 && trim.substring(0, 3).equalsIgnoreCase("CN=")) {
                linkedList.add(trim.substring(3));
            }
        }
        if (!linkedList.isEmpty()) {
            strArr = new String[linkedList.size()];
            linkedList.toArray(strArr);
        } else {
            strArr = null;
        }
        mo5012a(str, strArr, m292a(x509Certificate, str));
    }

    /* renamed from: a */
    private static String[] m292a(X509Certificate x509Certificate, String str) {
        Collection<List<?>> collection;
        int i = m294c(str) ? 7 : 2;
        LinkedList linkedList = new LinkedList();
        try {
            collection = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException e) {
            collection = null;
        }
        if (collection != null) {
            for (List next : collection) {
                if (((Integer) next.get(0)).intValue() == i) {
                    linkedList.add((String) next.get(1));
                }
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        return strArr;
    }

    /* renamed from: b */
    private static int m293b(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '.') {
                i++;
            }
        }
        return i;
    }

    /* renamed from: c */
    private static boolean m294c(String str) {
        return str != null && (C0332a.m317a(str) || C0332a.m318b(str));
    }

    /* renamed from: d */
    private String m295d(String str) {
        if (str == null || !C0332a.m318b(str)) {
            return str;
        }
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException e) {
            this.f165b.error("Unexpected error converting " + str, e);
            return str;
        }
    }

    /* renamed from: a */
    public final void mo5008a(String str, SSLSocket sSLSocket) {
        if (str == null) {
            throw new NullPointerException("host to verify is null");
        }
        SSLSession session = sSLSocket.getSession();
        if (session == null) {
            sSLSocket.getInputStream().available();
            session = sSLSocket.getSession();
            if (session == null) {
                sSLSocket.startHandshake();
                session = sSLSocket.getSession();
            }
        }
        m291a(str, (X509Certificate) session.getPeerCertificates()[0]);
    }

    /* renamed from: a */
    public final void mo5009a(String str, String[] strArr, String[] strArr2, boolean z) {
        LinkedList linkedList = new LinkedList();
        if (!(strArr == null || strArr.length <= 0 || strArr[0] == null)) {
            linkedList.add(strArr[0]);
        }
        if (strArr2 != null) {
            for (String str2 : strArr2) {
                if (str2 != null) {
                    linkedList.add(str2);
                }
            }
        }
        if (linkedList.isEmpty()) {
            throw new SSLException("Certificate for <" + str + "> doesn't contain CN or DNS subjectAlt");
        }
        StringBuilder sb = new StringBuilder();
        String d = m295d(str.trim().toLowerCase(Locale.US));
        Iterator it = linkedList.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            String lowerCase = ((String) it.next()).toLowerCase(Locale.US);
            sb.append(" <");
            sb.append(lowerCase);
            sb.append('>');
            if (it.hasNext()) {
                sb.append(" OR");
            }
            String[] split = lowerCase.split("\\.");
            if (split.length >= 3 && split[0].endsWith("*") && mo5010a(lowerCase) && !m294c(str)) {
                String str3 = split[0];
                if (str3.length() > 1) {
                    String substring = str3.substring(0, str3.length() - 1);
                    z2 = d.startsWith(substring) && d.substring(substring.length()).endsWith(lowerCase.substring(str3.length()));
                } else {
                    z2 = d.endsWith(lowerCase.substring(1));
                }
                if (z2 && z) {
                    if (m293b(d) == m293b(lowerCase)) {
                        z2 = true;
                        continue;
                    } else {
                        z2 = false;
                        continue;
                    }
                }
            } else {
                z2 = d.equals(m295d(lowerCase));
                continue;
            }
            if (z2) {
                break;
            }
        }
        if (!z2) {
            throw new SSLException("hostname in certificate didn't match: <" + str + "> !=" + sb);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5010a(String str) {
        String[] split = str.split("\\.");
        return (split.length == 3 && split[2].length() == 2 && Arrays.binarySearch(f164a, split[1]) >= 0) ? false : true;
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            m291a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
            return true;
        } catch (SSLException e) {
            return false;
        }
    }
}
