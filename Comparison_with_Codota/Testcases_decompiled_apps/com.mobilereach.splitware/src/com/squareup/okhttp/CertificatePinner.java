package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final Map<String, List<ByteString>> hostnameToPins;

    private CertificatePinner(Builder builder) {
        this.hostnameToPins = Util.immutableMap(builder.hostnameToPins);
    }

    public void check(String hostname, List<Certificate> peerCertificates) throws SSLPeerUnverifiedException {
        List<ByteString> pins = this.hostnameToPins.get(hostname);
        if (pins != null) {
            int i = 0;
            int size = peerCertificates.size();
            while (i < size) {
                if (!pins.contains(sha1((X509Certificate) peerCertificates.get(i)))) {
                    i++;
                } else {
                    return;
                }
            }
            StringBuilder message = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
            int size2 = peerCertificates.size();
            for (int i2 = 0; i2 < size2; i2++) {
                X509Certificate x509Certificate = (X509Certificate) peerCertificates.get(i2);
                message.append("\n    ").append(pin(x509Certificate)).append(": ").append(x509Certificate.getSubjectDN().getName()); // CRYPTOGRAPHIC API CALLSITE 2, CRYPTOGRAPHIC API CALLSITE 16
            }
            message.append("\n  Pinned certificates for ").append(hostname).append(":");
            int size3 = pins.size();
            for (int i3 = 0; i3 < size3; i3++) {
                message.append("\n    sha1/").append(pins.get(i3).base64());
            }
            throw new SSLPeerUnverifiedException(message.toString());
        }
    }

    public void check(String hostname, Certificate... peerCertificates) throws SSLPeerUnverifiedException {
        check(hostname, (List<Certificate>) Arrays.asList(peerCertificates));
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha1/" + sha1((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    private static ByteString sha1(X509Certificate x509Certificate) {
        return Util.sha1(ByteString.m20of(x509Certificate.getPublicKey().getEncoded()));
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public final Map<String, List<ByteString>> hostnameToPins = new LinkedHashMap();

        public Builder add(String hostname, String... pins) {
            if (hostname == null) {
                throw new IllegalArgumentException("hostname == null");
            }
            List<ByteString> hostPins = new ArrayList<>();
            List<ByteString> previousPins = this.hostnameToPins.put(hostname, Collections.unmodifiableList(hostPins));
            if (previousPins != null) {
                hostPins.addAll(previousPins);
            }
            for (String pin : pins) {
                if (!pin.startsWith("sha1/")) {
                    throw new IllegalArgumentException("pins must start with 'sha1/': " + pin);
                }
                ByteString decodedPin = ByteString.decodeBase64(pin.substring("sha1/".length()));
                if (decodedPin == null) {
                    throw new IllegalArgumentException("pins must be base64: " + pin);
                }
                hostPins.add(decodedPin);
            }
            return this;
        }

        public CertificatePinner build() {
            return new CertificatePinner(this);
        }
    }
}
