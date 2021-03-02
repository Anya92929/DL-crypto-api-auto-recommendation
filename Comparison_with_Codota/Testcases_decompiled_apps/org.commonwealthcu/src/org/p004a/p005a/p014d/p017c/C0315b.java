package org.p004a.p005a.p014d.p017c;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p014d.C0323e;
import org.p004a.p005a.p034j.C0544b;

/* renamed from: org.a.a.d.c.b */
public final class C0315b implements C0320g {
    /* renamed from: a */
    public final Socket mo4992a(Socket socket, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, C0544b bVar) {
        C0250b.m84a((Object) inetSocketAddress, "Remote address");
        C0250b.m84a((Object) bVar, "HTTP parameters");
        if (socket == null) {
            socket = new Socket();
        }
        if (inetSocketAddress2 != null) {
            C0250b.m84a((Object) bVar, "HTTP parameters");
            socket.setReuseAddress(bVar.mo5390a("http.socket.reuseaddr", false));
            socket.bind(inetSocketAddress2);
        }
        int d = C0250b.m111d(bVar);
        try {
            socket.setSoTimeout(C0250b.m108c(bVar));
            socket.connect(inetSocketAddress, d);
            return socket;
        } catch (SocketTimeoutException e) {
            throw new C0323e("Connect to " + inetSocketAddress + " timed out");
        }
    }

    /* renamed from: a */
    public final Socket mo4993a(C0544b bVar) {
        return new Socket();
    }

    /* renamed from: a */
    public final boolean mo4994a(Socket socket) {
        return false;
    }
}
