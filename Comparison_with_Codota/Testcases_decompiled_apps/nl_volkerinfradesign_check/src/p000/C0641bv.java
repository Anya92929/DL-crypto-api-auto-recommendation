package p000;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: bv */
public class C0641bv {

    /* renamed from: bv$a */
    public interface C0642a {
        /* renamed from: a */
        void mo1328a();

        /* renamed from: a */
        void mo1329a(long j);

        /* renamed from: a */
        void mo1330a(Object obj);

        /* renamed from: a */
        void mo1331a(String str, Bundle bundle);

        /* renamed from: a */
        void mo1332a(String str, Bundle bundle, ResultReceiver resultReceiver);

        /* renamed from: a */
        boolean mo1333a(Intent intent);

        /* renamed from: b */
        void mo1334b();

        /* renamed from: b */
        void mo1335b(long j);

        /* renamed from: b */
        void mo1336b(String str, Bundle bundle);

        /* renamed from: c */
        void mo1337c();

        /* renamed from: c */
        void mo1338c(String str, Bundle bundle);

        /* renamed from: d */
        void mo1339d();

        /* renamed from: e */
        void mo1340e();

        /* renamed from: f */
        void mo1341f();

        /* renamed from: g */
        void mo1342g();
    }

    /* renamed from: a */
    public static Object m3510a(Context context, String str) {
        return new MediaSession(context, str);
    }

    /* renamed from: a */
    public static Object m3512a(Object obj) {
        if (obj instanceof MediaSession) {
            return obj;
        }
        throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
    }

    /* renamed from: b */
    public static Object m3522b(Object obj) {
        if (obj instanceof MediaSession.Token) {
            return obj;
        }
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }

    /* renamed from: a */
    public static Object m3511a(C0642a aVar) {
        return new C0643b(aVar);
    }

    /* renamed from: a */
    public static void m3518a(Object obj, Object obj2, Handler handler) {
        ((MediaSession) obj).setCallback((MediaSession.Callback) obj2, handler);
    }

    /* renamed from: a */
    public static void m3513a(Object obj, int i) {
        ((MediaSession) obj).setFlags(i);
    }

    /* renamed from: b */
    public static void m3523b(Object obj, int i) {
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(i);
        ((MediaSession) obj).setPlaybackToLocal(builder.build());
    }

    /* renamed from: a */
    public static void m3517a(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackToRemote((VolumeProvider) obj2);
    }

    /* renamed from: a */
    public static void m3521a(Object obj, boolean z) {
        ((MediaSession) obj).setActive(z);
    }

    /* renamed from: c */
    public static boolean m3527c(Object obj) {
        return ((MediaSession) obj).isActive();
    }

    /* renamed from: a */
    public static void m3519a(Object obj, String str, Bundle bundle) {
        ((MediaSession) obj).sendSessionEvent(str, bundle);
    }

    /* renamed from: d */
    public static void m3528d(Object obj) {
        ((MediaSession) obj).release();
    }

    /* renamed from: e */
    public static Parcelable m3529e(Object obj) {
        return ((MediaSession) obj).getSessionToken();
    }

    /* renamed from: b */
    public static void m3525b(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackState((PlaybackState) obj2);
    }

    /* renamed from: c */
    public static void m3526c(Object obj, Object obj2) {
        ((MediaSession) obj).setMetadata((MediaMetadata) obj2);
    }

    /* renamed from: a */
    public static void m3514a(Object obj, PendingIntent pendingIntent) {
        ((MediaSession) obj).setSessionActivity(pendingIntent);
    }

    /* renamed from: b */
    public static void m3524b(Object obj, PendingIntent pendingIntent) {
        ((MediaSession) obj).setMediaButtonReceiver(pendingIntent);
    }

    /* renamed from: a */
    public static void m3520a(Object obj, List<Object> list) {
        if (list == null) {
            ((MediaSession) obj).setQueue((List) null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((MediaSession.QueueItem) it.next());
        }
        ((MediaSession) obj).setQueue(arrayList);
    }

    /* renamed from: a */
    public static void m3516a(Object obj, CharSequence charSequence) {
        ((MediaSession) obj).setQueueTitle(charSequence);
    }

    /* renamed from: a */
    public static void m3515a(Object obj, Bundle bundle) {
        ((MediaSession) obj).setExtras(bundle);
    }

    /* renamed from: bv$b */
    public static class C0643b<T extends C0642a> extends MediaSession.Callback {

        /* renamed from: a */
        public final T f2436a;

        public C0643b(T t) {
            this.f2436a = t;
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            this.f2436a.mo1332a(str, bundle, resultReceiver);
        }

        public boolean onMediaButtonEvent(Intent intent) {
            return this.f2436a.mo1333a(intent) || super.onMediaButtonEvent(intent);
        }

        public void onPlay() {
            this.f2436a.mo1328a();
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
            this.f2436a.mo1331a(str, bundle);
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
            this.f2436a.mo1336b(str, bundle);
        }

        public void onSkipToQueueItem(long j) {
            this.f2436a.mo1329a(j);
        }

        public void onPause() {
            this.f2436a.mo1334b();
        }

        public void onSkipToNext() {
            this.f2436a.mo1337c();
        }

        public void onSkipToPrevious() {
            this.f2436a.mo1339d();
        }

        public void onFastForward() {
            this.f2436a.mo1340e();
        }

        public void onRewind() {
            this.f2436a.mo1341f();
        }

        public void onStop() {
            this.f2436a.mo1342g();
        }

        public void onSeekTo(long j) {
            this.f2436a.mo1335b(j);
        }

        public void onSetRating(Rating rating) {
            this.f2436a.mo1330a((Object) rating);
        }

        public void onCustomAction(String str, Bundle bundle) {
            this.f2436a.mo1338c(str, bundle);
        }
    }

    /* renamed from: bv$c */
    public static class C0644c {
        /* renamed from: a */
        public static Object m3546a(Object obj, long j) {
            return new MediaSession.QueueItem((MediaDescription) obj, j);
        }

        /* renamed from: a */
        public static Object m3545a(Object obj) {
            return ((MediaSession.QueueItem) obj).getDescription();
        }

        /* renamed from: b */
        public static long m3547b(Object obj) {
            return ((MediaSession.QueueItem) obj).getQueueId();
        }
    }
}
