package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;

public final class ConnectionSpec {
    public static final ConnectionSpec CLEARTEXT = new Builder(false).build();
    public static final ConnectionSpec COMPATIBLE_TLS = new Builder(MODERN_TLS).tlsVersions(TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    public static final ConnectionSpec MODERN_TLS = new Builder(true).cipherSuites(f5760a).tlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();

    /* renamed from: a */
    private static final CipherSuite[] f5760a = {CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final boolean f5761b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final boolean f5762c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final String[] f5763d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final String[] f5764e;

    private ConnectionSpec(Builder builder) {
        this.f5761b = builder.f5765a;
        this.f5763d = builder.f5766b;
        this.f5764e = builder.f5767c;
        this.f5762c = builder.f5768d;
    }

    public boolean isTls() {
        return this.f5761b;
    }

    public List<CipherSuite> cipherSuites() {
        if (this.f5763d == null) {
            return null;
        }
        CipherSuite[] cipherSuiteArr = new CipherSuite[this.f5763d.length];
        for (int i = 0; i < this.f5763d.length; i++) {
            cipherSuiteArr[i] = CipherSuite.forJavaName(this.f5763d[i]);
        }
        return Util.immutableList((T[]) cipherSuiteArr);
    }

    public List<TlsVersion> tlsVersions() {
        if (this.f5764e == null) {
            return null;
        }
        TlsVersion[] tlsVersionArr = new TlsVersion[this.f5764e.length];
        for (int i = 0; i < this.f5764e.length; i++) {
            tlsVersionArr[i] = TlsVersion.forJavaName(this.f5764e[i]);
        }
        return Util.immutableList((T[]) tlsVersionArr);
    }

    public boolean supportsTlsExtensions() {
        return this.f5762c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10607a(SSLSocket sSLSocket, boolean z) {
        ConnectionSpec b = m6521b(sSLSocket, z);
        if (b.f5764e != null) {
            sSLSocket.setEnabledProtocols(b.f5764e);
        }
        if (b.f5763d != null) {
            sSLSocket.setEnabledCipherSuites(b.f5763d);
        }
    }

    /* renamed from: b */
    private ConnectionSpec m6521b(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f5763d != null) {
            enabledCipherSuites = (String[]) Util.intersect(String.class, this.f5763d, sSLSocket.getEnabledCipherSuites());
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f5764e != null) {
            enabledProtocols = (String[]) Util.intersect(String.class, this.f5764e, sSLSocket.getEnabledProtocols());
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        if (z && Util.contains(sSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV")) {
            enabledCipherSuites = Util.concat(enabledCipherSuites, "TLS_FALLBACK_SCSV");
        }
        return new Builder(this).cipherSuites(enabledCipherSuites).tlsVersions(enabledProtocols).build();
    }

    public boolean isCompatible(SSLSocket sSLSocket) {
        if (!this.f5761b) {
            return false;
        }
        if (this.f5764e != null && !m6520a(this.f5764e, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        if (this.f5763d == null || m6520a(this.f5763d, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m6520a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (String contains : strArr) {
            if (Util.contains(strArr2, contains)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        if (this.f5761b != connectionSpec.f5761b) {
            return false;
        }
        if (!this.f5761b || (Arrays.equals(this.f5763d, connectionSpec.f5763d) && Arrays.equals(this.f5764e, connectionSpec.f5764e) && this.f5762c == connectionSpec.f5762c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (!this.f5761b) {
            return 17;
        }
        return (this.f5762c ? 0 : 1) + ((((Arrays.hashCode(this.f5763d) + 527) * 31) + Arrays.hashCode(this.f5764e)) * 31);
    }

    public String toString() {
        if (!this.f5761b) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f5763d != null ? cipherSuites().toString() : "[all enabled]") + ", tlsVersions=" + (this.f5764e != null ? tlsVersions().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f5762c + ")";
    }

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public boolean f5765a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String[] f5766b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String[] f5767c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public boolean f5768d;

        Builder(boolean z) {
            this.f5765a = z;
        }

        public Builder(ConnectionSpec connectionSpec) {
            this.f5765a = connectionSpec.f5761b;
            this.f5766b = connectionSpec.f5763d;
            this.f5767c = connectionSpec.f5764e;
            this.f5768d = connectionSpec.f5762c;
        }

        public Builder allEnabledCipherSuites() {
            if (!this.f5765a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            this.f5766b = null;
            return this;
        }

        public Builder cipherSuites(CipherSuite... cipherSuiteArr) {
            if (!this.f5765a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[cipherSuiteArr.length];
            for (int i = 0; i < cipherSuiteArr.length; i++) {
                strArr[i] = cipherSuiteArr[i].f5750a;
            }
            return cipherSuites(strArr);
        }

        public Builder cipherSuites(String... strArr) {
            if (!this.f5765a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            } else {
                this.f5766b = (String[]) strArr.clone();
                return this;
            }
        }

        public Builder allEnabledTlsVersions() {
            if (!this.f5765a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            this.f5767c = null;
            return this;
        }

        public Builder tlsVersions(TlsVersion... tlsVersionArr) {
            if (!this.f5765a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[tlsVersionArr.length];
            for (int i = 0; i < tlsVersionArr.length; i++) {
                strArr[i] = tlsVersionArr[i].f5952a;
            }
            return tlsVersions(strArr);
        }

        public Builder tlsVersions(String... strArr) {
            if (!this.f5765a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            } else {
                this.f5767c = (String[]) strArr.clone();
                return this;
            }
        }

        public Builder supportsTlsExtensions(boolean z) {
            if (!this.f5765a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f5768d = z;
            return this;
        }

        public ConnectionSpec build() {
            return new ConnectionSpec(this);
        }
    }
}
