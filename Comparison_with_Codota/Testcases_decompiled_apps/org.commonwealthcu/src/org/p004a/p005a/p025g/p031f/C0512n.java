package org.p004a.p005a.p025g.p031f;

import java.net.Socket;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p034j.C0544b;

/* renamed from: org.a.a.g.f.n */
public final class C0512n extends C0502d {
    public C0512n(Socket socket, int i, C0544b bVar) {
        int i2 = 1024;
        C0250b.m84a((Object) socket, "Socket");
        int sendBufferSize = i < 0 ? socket.getSendBufferSize() : i;
        mo5285a(socket.getOutputStream(), sendBufferSize >= 1024 ? sendBufferSize : i2, bVar);
    }
}
