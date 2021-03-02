package android.support.p000v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.os.SystemClock;
import android.support.p000v4.media.session.MediaSessionCompatApi14;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v4.media.session.MediaSessionCompatApi18 */
public class MediaSessionCompatApi18 {

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi18$OnPlaybackPositionUpdateListener */
    class OnPlaybackPositionUpdateListener<T extends MediaSessionCompatApi14.Callback> implements RemoteControlClient.OnPlaybackPositionUpdateListener {

        /* renamed from: a */
        protected final T f969a;

        public OnPlaybackPositionUpdateListener(T t) {
            this.f969a = t;
        }

        public void onPlaybackPositionUpdate(long j) {
            this.f969a.onSeekTo(j);
        }
    }

    /* renamed from: a */
    static int m734a(long j) {
        int a = MediaSessionCompatApi14.m732a(j);
        return (256 & j) != 0 ? a | 256 : a;
    }

    public static Object createPlaybackPositionUpdateListener(MediaSessionCompatApi14.Callback callback) {
        return new OnPlaybackPositionUpdateListener(callback);
    }

    public static void registerMediaButtonEventReceiver(Context context, PendingIntent pendingIntent) {
        ((AudioManager) context.getSystemService("audio")).registerMediaButtonEventReceiver(pendingIntent);
    }

    public static void setOnPlaybackPositionUpdateListener(Object obj, Object obj2) {
        ((RemoteControlClient) obj).setPlaybackPositionUpdateListener((RemoteControlClient.OnPlaybackPositionUpdateListener) obj2);
    }

    public static void setState(Object obj, int i, long j, float f, long j2) {
        long j3 = 0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (i == 3 && j > 0) {
            if (j2 > 0) {
                j3 = elapsedRealtime - j2;
                if (f > BitmapDescriptorFactory.HUE_RED && f != 1.0f) {
                    j3 = (long) (((float) j3) * f);
                }
            }
            j += j3;
        }
        ((RemoteControlClient) obj).setPlaybackState(MediaSessionCompatApi14.m731a(i), j, f);
    }

    public static void setTransportControlFlags(Object obj, long j) {
        ((RemoteControlClient) obj).setTransportControlFlags(m734a(j));
    }

    public static void unregisterMediaButtonEventReceiver(Context context, PendingIntent pendingIntent) {
        ((AudioManager) context.getSystemService("audio")).unregisterMediaButtonEventReceiver(pendingIntent);
    }
}
