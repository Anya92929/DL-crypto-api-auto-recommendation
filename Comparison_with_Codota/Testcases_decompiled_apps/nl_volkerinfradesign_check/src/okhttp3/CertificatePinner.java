package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okio.ByteString;

public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();

    /* renamed from: a */
    private final Map<String, Set<ByteString>> f5745a;

    private CertificatePinner(Builder builder) {
        this.f5745a = Util.immutableMap(builder.f5746a);
    }

    public void check(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        Set<ByteString> a = mo10584a(str);
        if (a != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                if (!a.contains(m6511a((X509Certificate) list.get(i)))) {
                    i++;
                } else {
                    return;
                }
            }
            StringBuilder append = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i2);
                append.append("\n    ").append(pin(x509Certificate)).append(": ").append(x509Certificate.getSubjectDN().getName()); // CRYPTOGRAPHIC API CALLSITE 05; CRYPTOGRAPHIC API CALLSITE 12
            }
            append.append("\n  Pinned certificates for ").append(str).append(":");
            for (ByteString base64 : a) {
                append.append("\n    sha1/").append(base64.base64());
            }
            throw new SSLPeerUnverifiedException(append.toString());
        }
    }

    public void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        check(str, (List<Certificate>) Arrays.asList(certificateArr));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Set<ByteString> mo10584a(String str) {
        Set<ByteString> set;
        Set<ByteString> set2 = this.f5745a.get(str);
        int indexOf = str.indexOf(46);
        if (indexOf != str.lastIndexOf(46)) {
            set = this.f5745a.get("*." + str.substring(indexOf + 1));
        } else {
            set = null;
        }
        if (set2 == null && set == null) {
            return null;
        }
        if (set2 != null && set != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            linkedHashSet.addAll(set2);
            linkedHashSet.addAll(set);
            return linkedHashSet;
        } else if (set2 == null) {
            return set;
        } else {
            return set2;
        }
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha1/" + m6511a((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    /* renamed from: a */
    private static ByteString m6511a(X509Certificate x509Certificate) {
        return Util.sha1(ByteString.m6892of(x509Certificate.getPublicKey().getEncoded()));
    }

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Map<String, Set<ByteString>> f5746a = new LinkedHashMap();

        public Builder add(String str, String... strArr) {
            if (str == null) {
                throw new IllegalArgumentException("hostname == null");
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Set put = this.f5746a.put(str, Collections.unmodifiableSet(linkedHashSet));
            if (put != null) {
                linkedHashSet.addAll(put);
            }
            for (String str2 : strArr) {
                if (!str2.startsWith("sha1/")) {
                    throw new IllegalArgumentException("pins must start with 'sha1/': " + str2);
                }
                ByteString decodeBase64 = ByteString.decodeBase64(str2.substring("sha1/".length()));
                if (decodeBase64 == null) {
                    throw new IllegalArgumentException("pins must be base64: " + str2);
                }
                linkedHashSet.add(decodeBase64);
            }
            return this;
        }

        public CertificatePinner build() {
            return new CertificatePinner(this);
        }
    }
}
