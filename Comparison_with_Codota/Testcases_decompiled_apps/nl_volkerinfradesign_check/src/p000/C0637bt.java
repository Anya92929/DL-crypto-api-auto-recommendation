package p000;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import p000.C0635bs;

/* renamed from: bt */
public class C0637bt {

    /* renamed from: a */
    private static boolean f2433a = true;

    /* renamed from: a */
    public static Object m3498a(C0635bs.C0636a aVar) {
        return new C0638a(aVar);
    }

    /* renamed from: a */
    public static void m3499a(Context context, PendingIntent pendingIntent, ComponentName componentName) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (f2433a) {
            try {
                audioManager.registerMediaButtonEventReceiver(pendingIntent);
            } catch (NullPointerException e) {
                Log.w("MediaSessionCompatApi18", "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                f2433a = false;
            }
        }
        if (!f2433a) {
            audioManager.registerMediaButtonEventReceiver(componentName);
        }
    }

    /* renamed from: b */
    public static void m3503b(Context context, PendingIntent pendingIntent, ComponentName componentName) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (f2433a) {
            audioManager.unregisterMediaButtonEventReceiver(pendingIntent);
        } else {
            audioManager.unregisterMediaButtonEventReceiver(componentName);
        }
    }

    /* renamed from: a */
    public static void m3500a(Object obj, int i, long j, float f, long j2) {
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
        ((RemoteControlClient) obj).setPlaybackState(C0635bs.m3486a(i), j, f);
    }

    /* renamed from: a */
    public static void m3501a(Object obj, long j) {
        ((RemoteControlClient) obj).setTransportControlFlags(m3497a(j));
    }

    /* renamed from: a */
    public static void m3502a(Object obj, Object obj2) {
        ((RemoteControlClient) obj).setPlaybackPositionUpdateListener((RemoteControlClient.OnPlaybackPositionUpdateListener) obj2);
    }

    /* renamed from: a */
    static int m3497a(long j) {
        int a = C0635bs.m3487a(j);
        if ((256 & j) != 0) {
            return a | 256;
        }
        return a;
    }

    /* renamed from: bt$a */
    static class C0638a<T extends C0635bs.C0636a> implements RemoteControlClient.OnPlaybackPositionUpdateListener {

        /* renamed from: a */
        protected final T f2434a;

        public C0638a(T t) {
            this.f2434a = t;
        }

        public void onPlaybackPositionUpdate(long j) {
            this.f2434a.mo1387a(j);
        }
    }
}
