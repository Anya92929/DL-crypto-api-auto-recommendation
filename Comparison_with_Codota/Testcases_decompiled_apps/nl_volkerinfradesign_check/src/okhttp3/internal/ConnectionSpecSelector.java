package okhttp3.internal;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.ConnectionSpec;

public final class ConnectionSpecSelector {

    /* renamed from: a */
    private final List<ConnectionSpec> f5953a;

    /* renamed from: b */
    private int f5954b = 0;

    /* renamed from: c */
    private boolean f5955c;

    /* renamed from: d */
    private boolean f5956d;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        this.f5953a = list;
    }

    public ConnectionSpec configureSecureSocket(SSLSocket sSLSocket) throws IOException {
        ConnectionSpec connectionSpec;
        int i = this.f5954b;
        int size = this.f5953a.size();
        int i2 = i;
        while (true) {
            if (i2 >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.f5953a.get(i2);
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.f5954b = i2 + 1;
                break;
            }
            i2++;
        }
        if (connectionSpec == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f5956d + ", modes=" + this.f5953a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.f5955c = m6626a(sSLSocket);
        Internal.instance.apply(connectionSpec, sSLSocket, this.f5956d);
        return connectionSpec;
    }

    public boolean connectionFailed(IOException iOException) {
        this.f5956d = true;
        if (!this.f5955c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if ((iOException instanceof SSLHandshakeException) || (iOException instanceof SSLProtocolException)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m6626a(SSLSocket sSLSocket) {
        int i = this.f5954b;
        while (true) {
            int i2 = i;
            if (i2 >= this.f5953a.size()) {
                return false;
            }
            if (this.f5953a.get(i2).isCompatible(sSLSocket)) {
                return true;
            }
            i = i2 + 1;
        }
    }
}
