package android.support.p001v4.net;

import android.os.Build;
import java.net.Socket;
import java.net.SocketException;

/* renamed from: android.support.v4.net.TrafficStatsCompat */
public class TrafficStatsCompat {

    /* renamed from: a */
    private static final C0224c f763a;

    /* renamed from: android.support.v4.net.TrafficStatsCompat$c */
    interface C0224c {
        /* renamed from: a */
        void mo1443a();

        /* renamed from: a */
        void mo1444a(int i);

        /* renamed from: a */
        void mo1445a(int i, int i2);

        /* renamed from: a */
        void mo1446a(Socket socket) throws SocketException;

        /* renamed from: b */
        int mo1447b();

        /* renamed from: b */
        void mo1448b(int i);

        /* renamed from: b */
        void mo1449b(Socket socket) throws SocketException;
    }

    /* renamed from: android.support.v4.net.TrafficStatsCompat$a */
    static class C0220a implements C0224c {

        /* renamed from: a */
        private ThreadLocal<C0222a> f764a = new ThreadLocal<C0222a>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public C0222a initialValue() {
                return new C0222a();
            }
        };

        /* renamed from: android.support.v4.net.TrafficStatsCompat$a$a */
        static class C0222a {

            /* renamed from: a */
            public int f766a;

            private C0222a() {
                this.f766a = -1;
            }
        }

        C0220a() {
        }

        /* renamed from: a */
        public void mo1443a() {
            this.f764a.get().f766a = -1;
        }

        /* renamed from: b */
        public int mo1447b() {
            return this.f764a.get().f766a;
        }

        /* renamed from: a */
        public void mo1444a(int i) {
        }

        /* renamed from: a */
        public void mo1445a(int i, int i2) {
        }

        /* renamed from: b */
        public void mo1448b(int i) {
            this.f764a.get().f766a = i;
        }

        /* renamed from: a */
        public void mo1446a(Socket socket) {
        }

        /* renamed from: b */
        public void mo1449b(Socket socket) {
        }
    }

    /* renamed from: android.support.v4.net.TrafficStatsCompat$b */
    static class C0223b implements C0224c {
        C0223b() {
        }

        /* renamed from: a */
        public void mo1443a() {
            C0654cd.m3572a();
        }

        /* renamed from: b */
        public int mo1447b() {
            return C0654cd.m3576b();
        }

        /* renamed from: a */
        public void mo1444a(int i) {
            C0654cd.m3573a(i);
        }

        /* renamed from: a */
        public void mo1445a(int i, int i2) {
            C0654cd.m3574a(i, i2);
        }

        /* renamed from: b */
        public void mo1448b(int i) {
            C0654cd.m3577b(i);
        }

        /* renamed from: a */
        public void mo1446a(Socket socket) throws SocketException {
            C0654cd.m3575a(socket);
        }

        /* renamed from: b */
        public void mo1449b(Socket socket) throws SocketException {
            C0654cd.m3578b(socket);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f763a = new C0223b();
        } else {
            f763a = new C0220a();
        }
    }

    public static void clearThreadStatsTag() {
        f763a.mo1443a();
    }

    public static int getThreadStatsTag() {
        return f763a.mo1447b();
    }

    public static void incrementOperationCount(int i) {
        f763a.mo1444a(i);
    }

    public static void incrementOperationCount(int i, int i2) {
        f763a.mo1445a(i, i2);
    }

    public static void setThreadStatsTag(int i) {
        f763a.mo1448b(i);
    }

    public static void tagSocket(Socket socket) throws SocketException {
        f763a.mo1446a(socket);
    }

    public static void untagSocket(Socket socket) throws SocketException {
        f763a.mo1449b(socket);
    }
}
