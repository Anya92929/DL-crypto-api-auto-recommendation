package org.p004a.p005a.p025g;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import org.p004a.p005a.C0566o;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p010c.C0266m;
import org.p004a.p005a.p025g.p031f.C0511m;
import org.p004a.p005a.p025g.p031f.C0512n;
import org.p004a.p005a.p032h.C0519f;
import org.p004a.p005a.p032h.C0520g;
import org.p004a.p005a.p034j.C0544b;

/* renamed from: org.a.a.g.f */
public class C0498f extends C0384a implements C0566o {

    /* renamed from: a */
    private volatile boolean f498a;

    /* renamed from: b */
    private volatile Socket f499b = null;

    /* renamed from: a */
    private static void m945a(StringBuilder sb, SocketAddress socketAddress) {
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            sb.append(inetSocketAddress.getAddress() != null ? inetSocketAddress.getAddress().getHostAddress() : inetSocketAddress.getAddress()).append(':').append(inetSocketAddress.getPort());
            return;
        }
        sb.append(socketAddress);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0519f mo5222a(Socket socket, int i, C0544b bVar) {
        return new C0511m(socket, i, bVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo5275a(Socket socket, C0544b bVar) {
        C0250b.m84a((Object) socket, "Socket");
        C0250b.m84a((Object) bVar, "HTTP parameters");
        this.f499b = socket;
        int a = bVar.mo5389a("http.socket.buffer-size", -1);
        mo5131a(mo5222a(socket, a, bVar), mo5224b(socket, a, bVar), bVar);
        this.f498a = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0520g mo5224b(Socket socket, int i, C0544b bVar) {
        return new C0512n(socket, i, bVar);
    }

    /* renamed from: b */
    public final void mo5245b(int i) {
        mo5138j();
        if (this.f499b != null) {
            try {
                this.f499b.setSoTimeout(i);
            } catch (SocketException e) {
            }
        }
    }

    /* renamed from: c */
    public final boolean mo5246c() {
        return this.f498a;
    }

    public void close() {
        if (this.f498a) {
            this.f498a = false;
            Socket socket = this.f499b;
            try {
                mo5139k();
                try {
                    socket.shutdownOutput();
                } catch (IOException e) {
                }
                try {
                    socket.shutdownInput();
                } catch (IOException | UnsupportedOperationException e2) {
                }
            } finally {
                socket.close();
            }
        }
    }

    /* renamed from: e */
    public void mo5226e() {
        this.f498a = false;
        Socket socket = this.f499b;
        if (socket != null) {
            socket.close();
        }
    }

    /* renamed from: f */
    public final InetAddress mo5247f() {
        if (this.f499b != null) {
            return this.f499b.getInetAddress();
        }
        return null;
    }

    /* renamed from: g */
    public final int mo5248g() {
        if (this.f499b != null) {
            return this.f499b.getPort();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public Socket mo5038i() {
        return this.f499b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public final void mo5138j() {
        C0266m.m146a(this.f498a, "Connection is not open");
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public final void mo5276l() {
        C0266m.m146a(!this.f498a, "Connection is already open");
    }

    public String toString() {
        if (this.f499b == null) {
            return super.toString();
        }
        StringBuilder sb = new StringBuilder();
        SocketAddress remoteSocketAddress = this.f499b.getRemoteSocketAddress();
        SocketAddress localSocketAddress = this.f499b.getLocalSocketAddress();
        if (!(remoteSocketAddress == null || localSocketAddress == null)) {
            m945a(sb, localSocketAddress);
            sb.append("<->");
            m945a(sb, remoteSocketAddress);
        }
        return sb.toString();
    }
}
