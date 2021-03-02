package org.p004a.p005a.p014d.p019e;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p010c.C0266m;
import org.p004a.p005a.p014d.C0337k;
import org.p004a.p005a.p014d.p017c.C0314a;
import org.p004a.p005a.p014d.p017c.C0317d;
import org.p004a.p005a.p014d.p018d.C0322a;
import org.p004a.p005a.p034j.C0544b;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.d.e.e */
public final class C0328e implements C0314a, C0317d, C0322a {

    /* renamed from: a */
    private static C0330g f166a = new C0326c();

    /* renamed from: b */
    private final SSLSocketFactory f167b;

    /* renamed from: c */
    private volatile C0330g f168c;

    /* renamed from: d */
    private final String[] f169d;

    /* renamed from: e */
    private final String[] f170e;

    static {
        new C0325b();
        new C0329f();
    }

    private C0328e(SSLContext sSLContext, C0330g gVar) {
        this(((SSLContext) C0250b.m84a((Object) sSLContext, "SSL context")).getSocketFactory(), (String[]) null, (String[]) null, gVar);
    }

    private C0328e(SSLSocketFactory sSLSocketFactory, String[] strArr, String[] strArr2, C0330g gVar) {
        this.f167b = (SSLSocketFactory) C0250b.m84a((Object) sSLSocketFactory, "SSL socket factory");
        this.f169d = null;
        this.f170e = null;
        this.f168c = gVar == null ? f166a : gVar;
    }

    /* renamed from: a */
    private Socket m302a(int i, Socket socket, C0565n nVar, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, C0553e eVar) {
        C0250b.m84a((Object) nVar, "HTTP host");
        C0250b.m84a((Object) inetSocketAddress, "Remote address");
        Socket b = socket != null ? socket : m306b();
        if (inetSocketAddress2 != null) {
            b.bind(inetSocketAddress2);
        }
        try {
            b.connect(inetSocketAddress, i);
            if (!(b instanceof SSLSocket)) {
                return m307c(b, nVar.mo5441a(), inetSocketAddress.getPort());
            }
            SSLSocket sSLSocket = (SSLSocket) b;
            sSLSocket.startHandshake();
            m305a(sSLSocket, nVar.mo5441a());
            return b;
        } catch (IOException e) {
            try {
                b.close();
            } catch (IOException e2) {
            }
            throw e;
        }
    }

    /* renamed from: a */
    public static C0328e m303a() {
        return new C0328e(C0250b.m102b(), f166a);
    }

    /* renamed from: a */
    private void m304a(SSLSocket sSLSocket) {
        if (this.f169d != null) {
            sSLSocket.setEnabledProtocols(this.f169d);
        }
        if (this.f170e != null) {
            sSLSocket.setEnabledCipherSuites(this.f170e);
        }
    }

    /* renamed from: a */
    private void m305a(SSLSocket sSLSocket, String str) {
        try {
            this.f168c.mo5008a(str, sSLSocket);
        } catch (IOException e) {
            try {
                sSLSocket.close();
            } catch (Exception e2) {
            }
            throw e;
        }
    }

    /* renamed from: b */
    private Socket m306b() {
        SSLSocket sSLSocket = (SSLSocket) this.f167b.createSocket();
        m304a(sSLSocket);
        return sSLSocket;
    }

    /* renamed from: c */
    private Socket m307c(Socket socket, String str, int i) {
        SSLSocket sSLSocket = (SSLSocket) this.f167b.createSocket(socket, str, i, true);
        m304a(sSLSocket);
        sSLSocket.startHandshake();
        m305a(sSLSocket, str);
        return sSLSocket;
    }

    /* renamed from: a */
    public final Socket mo4991a(Socket socket, String str, int i) {
        return m307c(socket, str, i);
    }

    /* renamed from: a */
    public final Socket mo4992a(Socket socket, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, C0544b bVar) {
        C0250b.m84a((Object) inetSocketAddress, "Remote address");
        C0250b.m84a((Object) bVar, "HTTP parameters");
        return m302a(C0250b.m111d(bVar), socket, inetSocketAddress instanceof C0337k ? ((C0337k) inetSocketAddress).mo5023a() : new C0565n(inetSocketAddress.getHostName(), inetSocketAddress.getPort(), "https"), inetSocketAddress, inetSocketAddress2, (C0553e) null);
    }

    /* renamed from: a */
    public final Socket mo4993a(C0544b bVar) {
        return m306b();
    }

    /* renamed from: a */
    public final boolean mo4994a(Socket socket) {
        C0250b.m84a((Object) socket, "Socket");
        C0266m.m146a(socket instanceof SSLSocket, "Socket not created by this factory");
        C0266m.m146a(!socket.isClosed(), "Socket is closed");
        return true;
    }

    /* renamed from: b */
    public final Socket mo5003b(Socket socket, String str, int i) {
        return m307c(socket, str, i);
    }
}
