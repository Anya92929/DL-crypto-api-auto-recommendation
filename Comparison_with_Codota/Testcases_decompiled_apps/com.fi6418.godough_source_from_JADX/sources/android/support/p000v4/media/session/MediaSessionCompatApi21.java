package android.support.p000v4.media.session;

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

/* renamed from: android.support.v4.media.session.MediaSessionCompatApi21 */
class MediaSessionCompatApi21 {

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi21$Callback */
    public interface Callback {
        void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void onCustomAction(String str, Bundle bundle);

        void onFastForward();

        boolean onMediaButtonEvent(Intent intent);

        void onPause();

        void onPlay();

        void onPlayFromMediaId(String str, Bundle bundle);

        void onPlayFromSearch(String str, Bundle bundle);

        void onRewind();

        void onSeekTo(long j);

        void onSetRating(Object obj);

        void onSkipToNext();

        void onSkipToPrevious();

        void onSkipToQueueItem(long j);

        void onStop();
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi21$CallbackProxy */
    class CallbackProxy<T extends Callback> extends MediaSession.Callback {

        /* renamed from: a */
        protected final T f971a;

        public CallbackProxy(T t) {
            this.f971a = t;
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            this.f971a.onCommand(str, bundle, resultReceiver);
        }

        public void onCustomAction(String str, Bundle bundle) {
            this.f971a.onCustomAction(str, bundle);
        }

        public void onFastForward() {
            this.f971a.onFastForward();
        }

        public boolean onMediaButtonEvent(Intent intent) {
            return this.f971a.onMediaButtonEvent(intent) || super.onMediaButtonEvent(intent);
        }

        public void onPause() {
            this.f971a.onPause();
        }

        public void onPlay() {
            this.f971a.onPlay();
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
            this.f971a.onPlayFromMediaId(str, bundle);
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
            this.f971a.onPlayFromSearch(str, bundle);
        }

        public void onRewind() {
            this.f971a.onRewind();
        }

        public void onSeekTo(long j) {
            this.f971a.onSeekTo(j);
        }

        public void onSetRating(Rating rating) {
            this.f971a.onSetRating(rating);
        }

        public void onSkipToNext() {
            this.f971a.onSkipToNext();
        }

        public void onSkipToPrevious() {
            this.f971a.onSkipToPrevious();
        }

        public void onSkipToQueueItem(long j) {
            this.f971a.onSkipToQueueItem(j);
        }

        public void onStop() {
            this.f971a.onStop();
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompatApi21$QueueItem */
    class QueueItem {
        QueueItem() {
        }

        public static Object createItem(Object obj, long j) {
            return new MediaSession.QueueItem((MediaDescription) obj, j);
        }

        public static Object getDescription(Object obj) {
            return ((MediaSession.QueueItem) obj).getDescription();
        }

        public static long getQueueId(Object obj) {
            return ((MediaSession.QueueItem) obj).getQueueId();
        }
    }

    MediaSessionCompatApi21() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }

    public static Object createSession(Context context, String str) {
        return new MediaSession(context, str);
    }

    public static Parcelable getSessionToken(Object obj) {
        return ((MediaSession) obj).getSessionToken();
    }

    public static boolean isActive(Object obj) {
        return ((MediaSession) obj).isActive();
    }

    public static void release(Object obj) {
        ((MediaSession) obj).release();
    }

    public static void sendSessionEvent(Object obj, String str, Bundle bundle) {
        ((MediaSession) obj).sendSessionEvent(str, bundle);
    }

    public static void setActive(Object obj, boolean z) {
        ((MediaSession) obj).setActive(z);
    }

    public static void setCallback(Object obj, Object obj2, Handler handler) {
        ((MediaSession) obj).setCallback((MediaSession.Callback) obj2, handler);
    }

    public static void setExtras(Object obj, Bundle bundle) {
        ((MediaSession) obj).setExtras(bundle);
    }

    public static void setFlags(Object obj, int i) {
        ((MediaSession) obj).setFlags(i);
    }

    public static void setMediaButtonReceiver(Object obj, PendingIntent pendingIntent) {
        ((MediaSession) obj).setMediaButtonReceiver(pendingIntent);
    }

    public static void setMetadata(Object obj, Object obj2) {
        ((MediaSession) obj).setMetadata((MediaMetadata) obj2);
    }

    public static void setPlaybackState(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackState((PlaybackState) obj2);
    }

    public static void setPlaybackToLocal(Object obj, int i) {
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(i);
        ((MediaSession) obj).setPlaybackToLocal(builder.build());
    }

    public static void setPlaybackToRemote(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackToRemote((VolumeProvider) obj2);
    }

    public static void setQueue(Object obj, List<Object> list) {
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

    public static void setQueueTitle(Object obj, CharSequence charSequence) {
        ((MediaSession) obj).setQueueTitle(charSequence);
    }

    public static void setSessionActivity(Object obj, PendingIntent pendingIntent) {
        ((MediaSession) obj).setSessionActivity(pendingIntent);
    }

    public static Object verifySession(Object obj) {
        if (obj instanceof MediaSession) {
            return obj;
        }
        throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
    }

    public static Object verifyToken(Object obj) {
        if (obj instanceof MediaSession.Token) {
            return obj;
        }
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }
}
