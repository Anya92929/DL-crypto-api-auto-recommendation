package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class ConnectionSpec {
    public static final ConnectionSpec CLEARTEXT = new Builder(false).build();
    public static final ConnectionSpec COMPATIBLE_TLS = new Builder(MODERN_TLS).tlsVersions(TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    public static final ConnectionSpec MODERN_TLS = new Builder(true).cipherSuites(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_DSS_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA).tlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    /* access modifiers changed from: private */
    public final String[] cipherSuites;
    final boolean supportsTlsExtensions;
    final boolean tls;
    /* access modifiers changed from: private */
    public final String[] tlsVersions;

    private ConnectionSpec(Builder builder) {
        this.tls = builder.tls;
        this.cipherSuites = builder.cipherSuites;
        this.tlsVersions = builder.tlsVersions;
        this.supportsTlsExtensions = builder.supportsTlsExtensions;
    }

    public boolean isTls() {
        return this.tls;
    }

    public List<CipherSuite> cipherSuites() {
        if (this.cipherSuites == null) {
            return null;
        }
        CipherSuite[] result = new CipherSuite[this.cipherSuites.length];
        for (int i = 0; i < this.cipherSuites.length; i++) {
            result[i] = CipherSuite.forJavaName(this.cipherSuites[i]);
        }
        return Util.immutableList((T[]) result);
    }

    public List<TlsVersion> tlsVersions() {
        TlsVersion[] result = new TlsVersion[this.tlsVersions.length];
        for (int i = 0; i < this.tlsVersions.length; i++) {
            result[i] = TlsVersion.forJavaName(this.tlsVersions[i]);
        }
        return Util.immutableList((T[]) result);
    }

    public boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    /* access modifiers changed from: package-private */
    public void apply(SSLSocket sslSocket, Route route) {
        String[] oldEnabledCipherSuites;
        ConnectionSpec specToApply = supportedSpec(sslSocket);
        sslSocket.setEnabledProtocols(specToApply.tlsVersions);
        String[] cipherSuitesToEnable = specToApply.cipherSuites;
        if (route.shouldSendTlsFallbackIndicator && Arrays.asList(sslSocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV")) {
            if (cipherSuitesToEnable != null) {
                oldEnabledCipherSuites = cipherSuitesToEnable;
            } else {
                oldEnabledCipherSuites = sslSocket.getEnabledCipherSuites();
            }
            String[] newEnabledCipherSuites = new String[(oldEnabledCipherSuites.length + 1)];
            System.arraycopy(oldEnabledCipherSuites, 0, newEnabledCipherSuites, 0, oldEnabledCipherSuites.length);
            newEnabledCipherSuites[newEnabledCipherSuites.length - 1] = "TLS_FALLBACK_SCSV";
            cipherSuitesToEnable = newEnabledCipherSuites;
        }
        if (cipherSuitesToEnable != null) {
            sslSocket.setEnabledCipherSuites(cipherSuitesToEnable);
        }
        Platform platform = Platform.get();
        if (specToApply.supportsTlsExtensions) {
            platform.configureTlsExtensions(sslSocket, route.address.uriHost, route.address.protocols);
        }
    }

    private ConnectionSpec supportedSpec(SSLSocket sslSocket) {
        String[] cipherSuitesToEnable = null;
        if (this.cipherSuites != null) {
            cipherSuitesToEnable = (String[]) Util.intersect(String.class, this.cipherSuites, sslSocket.getEnabledCipherSuites());
        }
        String[] protocolsToSelectFrom = sslSocket.getEnabledProtocols();
        return new Builder(this).cipherSuites(cipherSuitesToEnable).tlsVersions((String[]) Util.intersect(String.class, this.tlsVersions, protocolsToSelectFrom)).build();
    }

    public boolean equals(Object other) {
        if (!(other instanceof ConnectionSpec)) {
            return false;
        }
        if (other == this) {
            return true;
        }
        ConnectionSpec that = (ConnectionSpec) other;
        if (this.tls != that.tls) {
            return false;
        }
        if (!this.tls || (Arrays.equals(this.cipherSuites, that.cipherSuites) && Arrays.equals(this.tlsVersions, that.tlsVersions) && this.supportsTlsExtensions == that.supportsTlsExtensions)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (!this.tls) {
            return 17;
        }
        return ((((Arrays.hashCode(this.cipherSuites) + 527) * 31) + Arrays.hashCode(this.tlsVersions)) * 31) + (this.supportsTlsExtensions ? 0 : 1);
    }

    public String toString() {
        if (!this.tls) {
            return "ConnectionSpec()";
        }
        List<CipherSuite> cipherSuites2 = cipherSuites();
        return "ConnectionSpec(cipherSuites=" + (cipherSuites2 == null ? "[use default]" : cipherSuites2.toString()) + ", tlsVersions=" + tlsVersions() + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ")";
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public String[] cipherSuites;
        /* access modifiers changed from: private */
        public boolean supportsTlsExtensions;
        /* access modifiers changed from: private */
        public boolean tls;
        /* access modifiers changed from: private */
        public String[] tlsVersions;

        Builder(boolean tls2) {
            this.tls = tls2;
        }

        public Builder(ConnectionSpec connectionSpec) {
            this.tls = connectionSpec.tls;
            this.cipherSuites = connectionSpec.cipherSuites;
            this.tlsVersions = connectionSpec.tlsVersions;
            this.supportsTlsExtensions = connectionSpec.supportsTlsExtensions;
        }

        public Builder cipherSuites(CipherSuite... cipherSuites2) {
            if (!this.tls) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strings = new String[cipherSuites2.length];
            for (int i = 0; i < cipherSuites2.length; i++) {
                strings[i] = cipherSuites2[i].javaName;
            }
            this.cipherSuites = strings;
            return this;
        }

        public Builder cipherSuites(String... cipherSuites2) {
            if (!this.tls) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (cipherSuites2 == null) {
                this.cipherSuites = null;
            } else {
                this.cipherSuites = (String[]) cipherSuites2.clone();
            }
            return this;
        }

        public Builder tlsVersions(TlsVersion... tlsVersions2) {
            if (!this.tls) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strings = new String[tlsVersions2.length];
            for (int i = 0; i < tlsVersions2.length; i++) {
                strings[i] = tlsVersions2[i].javaName;
            }
            this.tlsVersions = strings;
            return this;
        }

        public Builder tlsVersions(String... tlsVersions2) {
            if (!this.tls) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (tlsVersions2 == null) {
                this.tlsVersions = null;
            } else {
                this.tlsVersions = (String[]) tlsVersions2.clone();
            }
            return this;
        }

        public Builder supportsTlsExtensions(boolean supportsTlsExtensions2) {
            if (!this.tls) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.supportsTlsExtensions = supportsTlsExtensions2;
            return this;
        }

        public ConnectionSpec build() {
            return new ConnectionSpec(this);
        }
    }
}
