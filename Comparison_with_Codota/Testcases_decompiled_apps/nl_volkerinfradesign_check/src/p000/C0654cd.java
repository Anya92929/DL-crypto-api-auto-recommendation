package p000;

import android.net.TrafficStats;
import java.net.Socket;
import java.net.SocketException;

/* renamed from: cd */
public class C0654cd {
    /* renamed from: a */
    public static void m3572a() {
        TrafficStats.clearThreadStatsTag();
    }

    /* renamed from: b */
    public static int m3576b() {
        return TrafficStats.getThreadStatsTag();
    }

    /* renamed from: a */
    public static void m3573a(int i) {
        TrafficStats.incrementOperationCount(i);
    }

    /* renamed from: a */
    public static void m3574a(int i, int i2) {
        TrafficStats.incrementOperationCount(i, i2);
    }

    /* renamed from: b */
    public static void m3577b(int i) {
        TrafficStats.setThreadStatsTag(i);
    }

    /* renamed from: a */
    public static void m3575a(Socket socket) throws SocketException {
        TrafficStats.tagSocket(socket);
    }

    /* renamed from: b */
    public static void m3578b(Socket socket) throws SocketException {
        TrafficStats.untagSocket(socket);
    }
}
