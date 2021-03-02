package okhttp3;

import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

public final class Handshake {

    /* renamed from: a */
    private final TlsVersion f5802a;

    /* renamed from: b */
    private final CipherSuite f5803b;

    /* renamed from: c */
    private final List<Certificate> f5804c;

    /* renamed from: d */
    private final List<Certificate> f5805d;

    private Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        this.f5802a = tlsVersion;
        this.f5803b = cipherSuite;
        this.f5804c = list;
        this.f5805d = list2;
    }

    public static Handshake get(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List emptyList;
        List emptyList2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        CipherSuite forJavaName = CipherSuite.forJavaName(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        TlsVersion forJavaName2 = TlsVersion.forJavaName(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            certificateArr = null;
        }
        if (certificateArr != null) {
            emptyList = Util.immutableList((T[]) certificateArr);
        } else {
            emptyList = Collections.emptyList();
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            emptyList2 = Util.immutableList((T[]) localCertificates);
        } else {
            emptyList2 = Collections.emptyList();
        }
        return new Handshake(forJavaName2, forJavaName, emptyList, emptyList2);
    }

    public static Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        if (cipherSuite != null) {
            return new Handshake(tlsVersion, cipherSuite, Util.immutableList(list), Util.immutableList(list2));
        }
        throw new IllegalArgumentException("cipherSuite == null");
    }

    public TlsVersion tlsVersion() {
        return this.f5802a;
    }

    public CipherSuite cipherSuite() {
        return this.f5803b;
    }

    public List<Certificate> peerCertificates() {
        return this.f5804c;
    }

    public Principal peerPrincipal() {
        if (!this.f5804c.isEmpty()) {
            return ((X509Certificate) this.f5804c.get(0)).getSubjectX500Principal(); //CRYPTOGRAPHIC API CALLSITE 23
        }
        return null;
    }

    public List<Certificate> localCertificates() {
        return this.f5805d;
    }

    public Principal localPrincipal() {
        if (!this.f5805d.isEmpty()) {
            return ((X509Certificate) this.f5805d.get(0)).getSubjectX500Principal(); //CRYPTOGRAPHIC API CALLSITE 09
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        if (!Util.equal(this.f5803b, handshake.f5803b) || !this.f5803b.equals(handshake.f5803b) || !this.f5804c.equals(handshake.f5804c) || !this.f5805d.equals(handshake.f5805d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((this.f5802a != null ? this.f5802a.hashCode() : 0) + 527) * 31) + this.f5803b.hashCode()) * 31) + this.f5804c.hashCode()) * 31) + this.f5805d.hashCode();
    }
}
