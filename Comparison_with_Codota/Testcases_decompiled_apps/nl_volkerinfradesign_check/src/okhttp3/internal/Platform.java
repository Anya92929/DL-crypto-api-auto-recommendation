package okhttp3.internal;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okio.Buffer;

public class Platform {

    /* renamed from: a */
    private static final Platform f6004a = m6676a();

    public static Platform get() {
        return f6004a;
    }

    public String getPrefix() {
        return "OkHttp";
    }

    public void logW(String str) {
        System.out.println(str);
    }

    public void tagSocket(Socket socket) throws SocketException {
    }

    public void untagSocket(Socket socket) throws SocketException {
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    public void afterHandshake(SSLSocket sSLSocket) {
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void log(String str) {
        System.out.println(str);
    }

    /* renamed from: a */
    private static Platform m6676a() {
        C1300ix ixVar;
        Method method;
        Method method2;
        C1300ix ixVar2;
        Method method3;
        C1300ix ixVar3;
        Method method4;
        Method method5;
        C1300ix ixVar4;
        C1300ix ixVar5;
        C1300ix ixVar6;
        C1300ix ixVar7;
        try {
            Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e) {
            Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
        }
        try {
            C1300ix ixVar8 = new C1300ix((Class<?>) null, "setUseSessionTickets", Boolean.TYPE);
            C1300ix ixVar9 = new C1300ix((Class<?>) null, "setHostname", String.class);
            try {
                Class<?> cls = Class.forName("android.net.TrafficStats");
                Method method6 = cls.getMethod("tagSocket", new Class[]{Socket.class});
                try {
                    method5 = cls.getMethod("untagSocket", new Class[]{Socket.class});
                    method = method5;
                    ixVar3 = ixVar5;
                    method3 = method6;
                    ixVar2 = ixVar6;
                } catch (ClassNotFoundException e2) {
                    method4 = method6;
                    method = null;
                    method2 = method4;
                    ixVar = null;
                    ixVar2 = null;
                    method3 = method2;
                    ixVar3 = ixVar;
                    return new C1781a(ixVar8, ixVar9, method3, method, ixVar3, ixVar2);
                } catch (NoSuchMethodException e3) {
                    ixVar = null;
                    method = null;
                    method2 = method6;
                    ixVar2 = null;
                    method3 = method2;
                    ixVar3 = ixVar;
                    return new C1781a(ixVar8, ixVar9, method3, method, ixVar3, ixVar2);
                }
                try {
                    Class.forName("android.net.Network");
                    ixVar7 = new C1300ix(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                } catch (ClassNotFoundException e4) {
                    ixVar4 = null;
                    ixVar5 = ixVar4;
                    ixVar6 = null;
                    method = method5;
                    ixVar3 = ixVar5;
                    method3 = method6;
                    ixVar2 = ixVar6;
                    return new C1781a(ixVar8, ixVar9, method3, method, ixVar3, ixVar2);
                } catch (NoSuchMethodException e5) {
                    ixVar = null;
                    method = method5;
                    method2 = method6;
                    ixVar2 = null;
                    method3 = method2;
                    ixVar3 = ixVar;
                    return new C1781a(ixVar8, ixVar9, method3, method, ixVar3, ixVar2);
                }
                try {
                    ixVar6 = new C1300ix((Class<?>) null, "setAlpnProtocols", byte[].class);
                    ixVar5 = ixVar7;
                } catch (ClassNotFoundException e6) {
                    ixVar4 = ixVar7;
                    ixVar5 = ixVar4;
                    ixVar6 = null;
                    method = method5;
                    ixVar3 = ixVar5;
                    method3 = method6;
                    ixVar2 = ixVar6;
                    return new C1781a(ixVar8, ixVar9, method3, method, ixVar3, ixVar2);
                } catch (NoSuchMethodException e7) {
                    ixVar = ixVar7;
                    method = method5;
                    method2 = method6;
                    ixVar2 = null;
                    method3 = method2;
                    ixVar3 = ixVar;
                    return new C1781a(ixVar8, ixVar9, method3, method, ixVar3, ixVar2);
                }
            } catch (ClassNotFoundException e8) {
                method4 = null;
                method = null;
                method2 = method4;
                ixVar = null;
                ixVar2 = null;
                method3 = method2;
                ixVar3 = ixVar;
                return new C1781a(ixVar8, ixVar9, method3, method, ixVar3, ixVar2);
            } catch (NoSuchMethodException e9) {
                ixVar = null;
                method = null;
                method2 = null;
                ixVar2 = null;
                method3 = method2;
                ixVar3 = ixVar;
                return new C1781a(ixVar8, ixVar9, method3, method, ixVar3, ixVar2);
            }
            return new C1781a(ixVar8, ixVar9, method3, method, ixVar3, ixVar2);
        } catch (ClassNotFoundException e10) {
            try {
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
                return new C1782b(cls2.getMethod("put", new Class[]{SSLSocket.class, cls3}), cls2.getMethod("get", new Class[]{SSLSocket.class}), cls2.getMethod("remove", new Class[]{SSLSocket.class}), Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider"));
            } catch (ClassNotFoundException | NoSuchMethodException e11) {
                return new Platform();
            }
        }
    }

    /* renamed from: okhttp3.internal.Platform$a */
    static class C1781a extends Platform {

        /* renamed from: a */
        private final C1300ix<Socket> f6005a;

        /* renamed from: b */
        private final C1300ix<Socket> f6006b;

        /* renamed from: c */
        private final Method f6007c;

        /* renamed from: d */
        private final Method f6008d;

        /* renamed from: e */
        private final C1300ix<Socket> f6009e;

        /* renamed from: f */
        private final C1300ix<Socket> f6010f;

        public C1781a(C1300ix<Socket> ixVar, C1300ix<Socket> ixVar2, Method method, Method method2, C1300ix<Socket> ixVar3, C1300ix<Socket> ixVar4) {
            this.f6005a = ixVar;
            this.f6006b = ixVar2;
            this.f6007c = method;
            this.f6008d = method2;
            this.f6009e = ixVar3;
            this.f6010f = ixVar4;
        }

        public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
            try {
                socket.connect(inetSocketAddress, i);
            } catch (AssertionError e) {
                if (Util.isAndroidGetsocknameError(e)) {
                    throw new IOException(e);
                }
                throw e;
            } catch (SecurityException e2) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e2);
                throw iOException;
            }
        }

        public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
            if (str != null) {
                this.f6005a.mo8708b(sSLSocket, true);
                this.f6006b.mo8708b(sSLSocket, str);
            }
            if (this.f6010f != null && this.f6010f.mo8707a(sSLSocket)) {
                this.f6010f.mo8710d(sSLSocket, m6677a(list));
            }
        }

        public String getSelectedProtocol(SSLSocket sSLSocket) {
            if (this.f6009e == null || !this.f6009e.mo8707a(sSLSocket)) {
                return null;
            }
            byte[] bArr = (byte[]) this.f6009e.mo8710d(sSLSocket, new Object[0]);
            return bArr != null ? new String(bArr, Util.UTF_8) : null;
        }

        public void tagSocket(Socket socket) throws SocketException {
            if (this.f6007c != null) {
                try {
                    this.f6007c.invoke((Object) null, new Object[]{socket});
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2.getCause());
                }
            }
        }

        public void untagSocket(Socket socket) throws SocketException {
            if (this.f6008d != null) {
                try {
                    this.f6008d.invoke((Object) null, new Object[]{socket});
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2.getCause());
                }
            }
        }

        public void log(String str) {
            int min;
            int i = 0;
            int length = str.length();
            while (i < length) {
                int indexOf = str.indexOf(10, i);
                if (indexOf == -1) {
                    indexOf = length;
                }
                while (true) {
                    min = Math.min(indexOf, i + 4000);
                    Log.d("OkHttp", str.substring(i, min));
                    if (min >= indexOf) {
                        break;
                    }
                    i = min;
                }
                i = min + 1;
            }
        }
    }

    /* renamed from: okhttp3.internal.Platform$b */
    static class C1782b extends Platform {

        /* renamed from: a */
        private final Method f6011a;

        /* renamed from: b */
        private final Method f6012b;

        /* renamed from: c */
        private final Method f6013c;

        /* renamed from: d */
        private final Class<?> f6014d;

        /* renamed from: e */
        private final Class<?> f6015e;

        public C1782b(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
            this.f6011a = method;
            this.f6012b = method2;
            this.f6013c = method3;
            this.f6014d = cls;
            this.f6015e = cls2;
        }

        public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Protocol protocol = list.get(i);
                if (protocol != Protocol.HTTP_1_0) {
                    arrayList.add(protocol.toString());
                }
            }
            try {
                this.f6011a.invoke((Object) null, new Object[]{sSLSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.f6014d, this.f6015e}, new C1783c(arrayList))});
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new AssertionError(e);
            }
        }

        public void afterHandshake(SSLSocket sSLSocket) {
            try {
                this.f6013c.invoke((Object) null, new Object[]{sSLSocket});
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new AssertionError();
            }
        }

        public String getSelectedProtocol(SSLSocket sSLSocket) {
            try {
                C1783c cVar = (C1783c) Proxy.getInvocationHandler(this.f6012b.invoke((Object) null, new Object[]{sSLSocket}));
                if (cVar.f6017b || cVar.f6018c != null) {
                    return cVar.f6017b ? null : cVar.f6018c;
                }
                Internal.logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                return null;
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new AssertionError();
            }
        }
    }

    /* renamed from: okhttp3.internal.Platform$c */
    static class C1783c implements InvocationHandler {

        /* renamed from: a */
        private final List<String> f6016a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public boolean f6017b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String f6018c;

        public C1783c(List<String> list) {
            this.f6016a = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = Util.EMPTY_STRING_ARRAY;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f6017b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f6016a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f6016a.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.f6018c = str;
                            return str;
                        }
                    }
                    String str2 = this.f6016a.get(0);
                    this.f6018c = str2;
                    return str2;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f6018c = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    /* renamed from: a */
    static byte[] m6677a(List<Protocol> list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.writeUtf8(protocol.toString());
            }
        }
        return buffer.readByteArray();
    }
}
