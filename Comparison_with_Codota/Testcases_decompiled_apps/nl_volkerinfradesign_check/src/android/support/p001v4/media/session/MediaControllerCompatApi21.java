package android.support.p001v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaControllerCompatApi21 */
class MediaControllerCompatApi21 {

    /* renamed from: android.support.v4.media.session.MediaControllerCompatApi21$Callback */
    public interface Callback {
        void onMetadataChanged(Object obj);

        void onPlaybackStateChanged(Object obj);

        void onSessionDestroyed();

        void onSessionEvent(String str, Bundle bundle);
    }

    /* renamed from: a */
    public static Object m699a(Context context, Object obj) {
        return new MediaController(context, (MediaSession.Token) obj);
    }

    /* renamed from: a */
    public static Object m700a(Callback callback) {
        return new C0195a(callback);
    }

    /* renamed from: a */
    public static void m704a(Object obj, Object obj2, Handler handler) {
        ((MediaController) obj).registerCallback((MediaController.Callback) obj2, handler);
    }

    /* renamed from: a */
    public static void m703a(Object obj, Object obj2) {
        ((MediaController) obj).unregisterCallback((MediaController.Callback) obj2);
    }

    /* renamed from: a */
    public static Object m701a(Object obj) {
        return ((MediaController) obj).getTransportControls();
    }

    /* renamed from: b */
    public static Object m707b(Object obj) {
        return ((MediaController) obj).getPlaybackState();
    }

    /* renamed from: c */
    public static Object m709c(Object obj) {
        return ((MediaController) obj).getMetadata();
    }

    /* renamed from: d */
    public static List<Object> m710d(Object obj) {
        List<MediaSession.QueueItem> queue = ((MediaController) obj).getQueue();
        if (queue == null) {
            return null;
        }
        return new ArrayList(queue);
    }

    /* renamed from: e */
    public static CharSequence m711e(Object obj) {
        return ((MediaController) obj).getQueueTitle();
    }

    /* renamed from: f */
    public static Bundle m712f(Object obj) {
        return ((MediaController) obj).getExtras();
    }

    /* renamed from: g */
    public static int m713g(Object obj) {
        return ((MediaController) obj).getRatingType();
    }

    /* renamed from: h */
    public static long m714h(Object obj) {
        return ((MediaController) obj).getFlags();
    }

    /* renamed from: i */
    public static Object m715i(Object obj) {
        return ((MediaController) obj).getPlaybackInfo();
    }

    /* renamed from: j */
    public static PendingIntent m716j(Object obj) {
        return ((MediaController) obj).getSessionActivity();
    }

    /* renamed from: a */
    public static boolean m706a(Object obj, KeyEvent keyEvent) {
        return ((MediaController) obj).dispatchMediaButtonEvent(keyEvent);
    }

    /* renamed from: a */
    public static void m702a(Object obj, int i, int i2) {
        ((MediaController) obj).setVolumeTo(i, i2);
    }

    /* renamed from: b */
    public static void m708b(Object obj, int i, int i2) {
        ((MediaController) obj).adjustVolume(i, i2);
    }

    /* renamed from: a */
    public static void m705a(Object obj, String str, Bundle bundle, ResultReceiver resultReceiver) {
        ((MediaController) obj).sendCommand(str, bundle, resultReceiver);
    }

    /* renamed from: k */
    public static String m717k(Object obj) {
        return ((MediaController) obj).getPackageName();
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompatApi21$TransportControls */
    public static class TransportControls {
        public static void play(Object obj) {
            ((MediaController.TransportControls) obj).play();
        }

        public static void pause(Object obj) {
            ((MediaController.TransportControls) obj).pause();
        }

        public static void stop(Object obj) {
            ((MediaController.TransportControls) obj).stop();
        }

        public static void seekTo(Object obj, long j) {
            ((MediaController.TransportControls) obj).seekTo(j);
        }

        public static void fastForward(Object obj) {
            ((MediaController.TransportControls) obj).fastForward();
        }

        public static void rewind(Object obj) {
            ((MediaController.TransportControls) obj).rewind();
        }

        public static void skipToNext(Object obj) {
            ((MediaController.TransportControls) obj).skipToNext();
        }

        public static void skipToPrevious(Object obj) {
            ((MediaController.TransportControls) obj).skipToPrevious();
        }

        public static void setRating(Object obj, Object obj2) {
            ((MediaController.TransportControls) obj).setRating((Rating) obj2);
        }

        public static void playFromMediaId(Object obj, String str, Bundle bundle) {
            ((MediaController.TransportControls) obj).playFromMediaId(str, bundle);
        }

        public static void playFromSearch(Object obj, String str, Bundle bundle) {
            ((MediaController.TransportControls) obj).playFromSearch(str, bundle);
        }

        public static void skipToQueueItem(Object obj, long j) {
            ((MediaController.TransportControls) obj).skipToQueueItem(j);
        }

        public static void sendCustomAction(Object obj, String str, Bundle bundle) {
            ((MediaController.TransportControls) obj).sendCustomAction(str, bundle);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompatApi21$PlaybackInfo */
    public static class PlaybackInfo {
        public static int getPlaybackType(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getPlaybackType();
        }

        public static AudioAttributes getAudioAttributes(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getAudioAttributes();
        }

        public static int getLegacyAudioStream(Object obj) {
            return m718a(getAudioAttributes(obj));
        }

        public static int getVolumeControl(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getVolumeControl();
        }

        public static int getMaxVolume(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getMaxVolume();
        }

        public static int getCurrentVolume(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getCurrentVolume();
        }

        /* renamed from: a */
        private static int m718a(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            switch (audioAttributes.getUsage()) {
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 13:
                    return 1;
                default:
                    return 3;
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompatApi21$a */
    static class C0195a<T extends Callback> extends MediaController.Callback {

        /* renamed from: a */
        protected final T f680a;

        public C0195a(T t) {
            this.f680a = t;
        }

        public void onSessionDestroyed() {
            this.f680a.onSessionDestroyed();
        }

        public void onSessionEvent(String str, Bundle bundle) {
            this.f680a.onSessionEvent(str, bundle);
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f680a.onPlaybackStateChanged(playbackState);
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f680a.onMetadataChanged(mediaMetadata);
        }
    }
}
