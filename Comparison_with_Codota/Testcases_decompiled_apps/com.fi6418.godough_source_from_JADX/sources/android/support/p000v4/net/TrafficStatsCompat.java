package android.support.p000v4.net;

import android.os.Build;
import java.net.Socket;

/* renamed from: android.support.v4.net.TrafficStatsCompat */
public class TrafficStatsCompat {

    /* renamed from: a */
    private static final TrafficStatsCompatImpl f1003a;

    /* renamed from: android.support.v4.net.TrafficStatsCompat$BaseTrafficStatsCompatImpl */
    class BaseTrafficStatsCompatImpl implements TrafficStatsCompatImpl {

        /* renamed from: a */
        private ThreadLocal<SocketTags> f1004a = new ThreadLocal<SocketTags>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public SocketTags initialValue() {
                return new SocketTags();
            }
        };

        /* renamed from: android.support.v4.net.TrafficStatsCompat$BaseTrafficStatsCompatImpl$SocketTags */
        class SocketTags {
            public int statsTag;

            private SocketTags() {
                this.statsTag = -1;
            }
        }

        BaseTrafficStatsCompatImpl() {
        }

        public void clearThreadStatsTag() {
            this.f1004a.get().statsTag = -1;
        }

        public int getThreadStatsTag() {
            return this.f1004a.get().statsTag;
        }

        public void incrementOperationCount(int i) {
        }

        public void incrementOperationCount(int i, int i2) {
        }

        public void setThreadStatsTag(int i) {
            this.f1004a.get().statsTag = i;
        }

        public void tagSocket(Socket socket) {
        }

        public void untagSocket(Socket socket) {
        }
    }

    /* renamed from: android.support.v4.net.TrafficStatsCompat$IcsTrafficStatsCompatImpl */
    class IcsTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        IcsTrafficStatsCompatImpl() {
        }

        public void clearThreadStatsTag() {
            TrafficStatsCompatIcs.clearThreadStatsTag();
        }

        public int getThreadStatsTag() {
            return TrafficStatsCompatIcs.getThreadStatsTag();
        }

        public void incrementOperationCount(int i) {
            TrafficStatsCompatIcs.incrementOperationCount(i);
        }

        public void incrementOperationCount(int i, int i2) {
            TrafficStatsCompatIcs.incrementOperationCount(i, i2);
        }

        public void setThreadStatsTag(int i) {
            TrafficStatsCompatIcs.setThreadStatsTag(i);
        }

        public void tagSocket(Socket socket) {
            TrafficStatsCompatIcs.tagSocket(socket);
        }

        public void untagSocket(Socket socket) {
            TrafficStatsCompatIcs.untagSocket(socket);
        }
    }

    /* renamed from: android.support.v4.net.TrafficStatsCompat$TrafficStatsCompatImpl */
    interface TrafficStatsCompatImpl {
        void clearThreadStatsTag();

        int getThreadStatsTag();

        void incrementOperationCount(int i);

        void incrementOperationCount(int i, int i2);

        void setThreadStatsTag(int i);

        void tagSocket(Socket socket);

        void untagSocket(Socket socket);
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f1003a = new IcsTrafficStatsCompatImpl();
        } else {
            f1003a = new BaseTrafficStatsCompatImpl();
        }
    }

    public static void clearThreadStatsTag() {
        f1003a.clearThreadStatsTag();
    }

    public static int getThreadStatsTag() {
        return f1003a.getThreadStatsTag();
    }

    public static void incrementOperationCount(int i) {
        f1003a.incrementOperationCount(i);
    }

    public static void incrementOperationCount(int i, int i2) {
        f1003a.incrementOperationCount(i, i2);
    }

    public static void setThreadStatsTag(int i) {
        f1003a.setThreadStatsTag(i);
    }

    public static void tagSocket(Socket socket) {
        f1003a.tagSocket(socket);
    }

    public static void untagSocket(Socket socket) {
        f1003a.untagSocket(socket);
    }
}
