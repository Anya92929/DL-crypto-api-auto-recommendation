package android.support.p000v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.p000v4.media.MediaMetadataCompat;
import android.support.p000v4.media.RatingCompat;
import android.support.p000v4.media.session.IMediaControllerCallback;
import android.support.p000v4.media.session.IMediaSession;
import android.support.p000v4.media.session.MediaControllerCompatApi21;
import android.support.p000v4.media.session.MediaControllerCompatApi23;
import android.support.p000v4.media.session.MediaSessionCompat;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaControllerCompat */
public final class MediaControllerCompat {

    /* renamed from: a */
    private final MediaControllerImpl f901a;

    /* renamed from: b */
    private final MediaSessionCompat.Token f902b;

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback */
    public abstract class Callback implements IBinder.DeathRecipient {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Object f903a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public MessageHandler f904b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f905c = false;

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback$MessageHandler */
        class MessageHandler extends Handler {
            public MessageHandler(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                if (Callback.this.f905c) {
                    switch (message.what) {
                        case 1:
                            Callback.this.onSessionEvent((String) message.obj, message.getData());
                            return;
                        case 2:
                            Callback.this.onPlaybackStateChanged((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            Callback.this.onMetadataChanged((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            Callback.this.onAudioInfoChanged((PlaybackInfo) message.obj);
                            return;
                        case 5:
                            Callback.this.onQueueChanged((List) message.obj);
                            return;
                        case 6:
                            Callback.this.onQueueTitleChanged((CharSequence) message.obj);
                            return;
                        case 7:
                            Callback.this.onExtrasChanged((Bundle) message.obj);
                            return;
                        case 8:
                            Callback.this.onSessionDestroyed();
                            return;
                        default:
                            return;
                    }
                }
            }

            public void post(int i, Object obj, Bundle bundle) {
                obtainMessage(i, obj).sendToTarget();
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback$StubApi21 */
        class StubApi21 implements MediaControllerCompatApi21.Callback {
            private StubApi21() {
            }

            public void onMetadataChanged(Object obj) {
                Callback.this.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(obj));
            }

            public void onPlaybackStateChanged(Object obj) {
                Callback.this.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(obj));
            }

            public void onSessionDestroyed() {
                Callback.this.onSessionDestroyed();
            }

            public void onSessionEvent(String str, Bundle bundle) {
                Callback.this.onSessionEvent(str, bundle);
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat */
        class StubCompat extends IMediaControllerCallback.Stub {
            private StubCompat() {
            }

            public void onEvent(String str, Bundle bundle) {
                Callback.this.f904b.post(1, str, bundle);
            }

            public void onExtrasChanged(Bundle bundle) {
                Callback.this.f904b.post(7, bundle, (Bundle) null);
            }

            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
                Callback.this.f904b.post(3, mediaMetadataCompat, (Bundle) null);
            }

            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
                Callback.this.f904b.post(2, playbackStateCompat, (Bundle) null);
            }

            public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
                Callback.this.f904b.post(5, list, (Bundle) null);
            }

            public void onQueueTitleChanged(CharSequence charSequence) {
                Callback.this.f904b.post(6, charSequence, (Bundle) null);
            }

            public void onSessionDestroyed() {
                Callback.this.f904b.post(8, (Object) null, (Bundle) null);
            }

            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
                Callback.this.f904b.post(4, parcelableVolumeInfo != null ? new PlaybackInfo(parcelableVolumeInfo.volumeType, parcelableVolumeInfo.audioStream, parcelableVolumeInfo.controlType, parcelableVolumeInfo.maxVolume, parcelableVolumeInfo.currentVolume) : null, (Bundle) null);
            }
        }

        public Callback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f903a = MediaControllerCompatApi21.createCallback(new StubApi21());
            } else {
                this.f903a = new StubCompat();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m689a(Handler handler) {
            this.f904b = new MessageHandler(handler.getLooper());
        }

        public void binderDied() {
            onSessionDestroyed();
        }

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
        }

        public void onExtrasChanged(Bundle bundle) {
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String str, Bundle bundle) {
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImpl */
    interface MediaControllerImpl {
        void adjustVolume(int i, int i2);

        boolean dispatchMediaButtonEvent(KeyEvent keyEvent);

        Bundle getExtras();

        long getFlags();

        Object getMediaController();

        MediaMetadataCompat getMetadata();

        String getPackageName();

        PlaybackInfo getPlaybackInfo();

        PlaybackStateCompat getPlaybackState();

        List<MediaSessionCompat.QueueItem> getQueue();

        CharSequence getQueueTitle();

        int getRatingType();

        PendingIntent getSessionActivity();

        TransportControls getTransportControls();

        void registerCallback(Callback callback, Handler handler);

        void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void setVolumeTo(int i, int i2);

        void unregisterCallback(Callback callback);
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21 */
    class MediaControllerImplApi21 implements MediaControllerImpl {

        /* renamed from: a */
        protected final Object f909a;

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.f909a = MediaControllerCompatApi21.fromToken(context, token.getToken());
            if (this.f909a == null) {
                throw new RemoteException();
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat mediaSessionCompat) {
            this.f909a = MediaControllerCompatApi21.fromToken(context, mediaSessionCompat.getSessionToken().getToken());
        }

        public void adjustVolume(int i, int i2) {
            MediaControllerCompatApi21.adjustVolume(this.f909a, i, i2);
        }

        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            return MediaControllerCompatApi21.dispatchMediaButtonEvent(this.f909a, keyEvent);
        }

        public Bundle getExtras() {
            return MediaControllerCompatApi21.getExtras(this.f909a);
        }

        public long getFlags() {
            return MediaControllerCompatApi21.getFlags(this.f909a);
        }

        public Object getMediaController() {
            return this.f909a;
        }

        public MediaMetadataCompat getMetadata() {
            Object metadata = MediaControllerCompatApi21.getMetadata(this.f909a);
            if (metadata != null) {
                return MediaMetadataCompat.fromMediaMetadata(metadata);
            }
            return null;
        }

        public String getPackageName() {
            return MediaControllerCompatApi21.getPackageName(this.f909a);
        }

        public PlaybackInfo getPlaybackInfo() {
            Object playbackInfo = MediaControllerCompatApi21.getPlaybackInfo(this.f909a);
            if (playbackInfo != null) {
                return new PlaybackInfo(MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(playbackInfo), MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(playbackInfo));
            }
            return null;
        }

        public PlaybackStateCompat getPlaybackState() {
            Object playbackState = MediaControllerCompatApi21.getPlaybackState(this.f909a);
            if (playbackState != null) {
                return PlaybackStateCompat.fromPlaybackState(playbackState);
            }
            return null;
        }

        public List<MediaSessionCompat.QueueItem> getQueue() {
            List<Object> queue = MediaControllerCompatApi21.getQueue(this.f909a);
            if (queue == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obtain : queue) {
                arrayList.add(MediaSessionCompat.QueueItem.obtain(obtain));
            }
            return arrayList;
        }

        public CharSequence getQueueTitle() {
            return MediaControllerCompatApi21.getQueueTitle(this.f909a);
        }

        public int getRatingType() {
            return MediaControllerCompatApi21.getRatingType(this.f909a);
        }

        public PendingIntent getSessionActivity() {
            return MediaControllerCompatApi21.getSessionActivity(this.f909a);
        }

        public TransportControls getTransportControls() {
            Object transportControls = MediaControllerCompatApi21.getTransportControls(this.f909a);
            if (transportControls != null) {
                return new TransportControlsApi21(transportControls);
            }
            return null;
        }

        public void registerCallback(Callback callback, Handler handler) {
            MediaControllerCompatApi21.registerCallback(this.f909a, callback.f903a, handler);
        }

        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaControllerCompatApi21.sendCommand(this.f909a, str, bundle, resultReceiver);
        }

        public void setVolumeTo(int i, int i2) {
            MediaControllerCompatApi21.setVolumeTo(this.f909a, i, i2);
        }

        public void unregisterCallback(Callback callback) {
            MediaControllerCompatApi21.unregisterCallback(this.f909a, callback.f903a);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi23 */
    class MediaControllerImplApi23 extends MediaControllerImplApi21 {
        public MediaControllerImplApi23(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }

        public MediaControllerImplApi23(Context context, MediaSessionCompat mediaSessionCompat) {
            super(context, mediaSessionCompat);
        }

        public TransportControls getTransportControls() {
            Object transportControls = MediaControllerCompatApi21.getTransportControls(this.f909a);
            if (transportControls != null) {
                return new TransportControlsApi23(transportControls);
            }
            return null;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplBase */
    class MediaControllerImplBase implements MediaControllerImpl {

        /* renamed from: a */
        private MediaSessionCompat.Token f910a;

        /* renamed from: b */
        private IMediaSession f911b;

        /* renamed from: c */
        private TransportControls f912c;

        public MediaControllerImplBase(MediaSessionCompat.Token token) {
            this.f910a = token;
            this.f911b = IMediaSession.Stub.asInterface((IBinder) token.getToken());
        }

        public void adjustVolume(int i, int i2) {
            try {
                this.f911b.adjustVolume(i, i2, (String) null);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in adjustVolume. " + e);
            }
        }

        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            if (keyEvent == null) {
                throw new IllegalArgumentException("event may not be null.");
            }
            try {
                this.f911b.sendMediaButton(keyEvent);
                return false;
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent. " + e);
                return false;
            }
        }

        public Bundle getExtras() {
            try {
                return this.f911b.getExtras();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getExtras. " + e);
                return null;
            }
        }

        public long getFlags() {
            try {
                return this.f911b.getFlags();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getFlags. " + e);
                return 0;
            }
        }

        public Object getMediaController() {
            return null;
        }

        public MediaMetadataCompat getMetadata() {
            try {
                return this.f911b.getMetadata();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getMetadata. " + e);
                return null;
            }
        }

        public String getPackageName() {
            try {
                return this.f911b.getPackageName();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getPackageName. " + e);
                return null;
            }
        }

        public PlaybackInfo getPlaybackInfo() {
            try {
                ParcelableVolumeInfo volumeAttributes = this.f911b.getVolumeAttributes();
                return new PlaybackInfo(volumeAttributes.volumeType, volumeAttributes.audioStream, volumeAttributes.controlType, volumeAttributes.maxVolume, volumeAttributes.currentVolume);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackInfo. " + e);
                return null;
            }
        }

        public PlaybackStateCompat getPlaybackState() {
            try {
                return this.f911b.getPlaybackState();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackState. " + e);
                return null;
            }
        }

        public List<MediaSessionCompat.QueueItem> getQueue() {
            try {
                return this.f911b.getQueue();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getQueue. " + e);
                return null;
            }
        }

        public CharSequence getQueueTitle() {
            try {
                return this.f911b.getQueueTitle();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getQueueTitle. " + e);
                return null;
            }
        }

        public int getRatingType() {
            try {
                return this.f911b.getRatingType();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getRatingType. " + e);
                return 0;
            }
        }

        public PendingIntent getSessionActivity() {
            try {
                return this.f911b.getLaunchPendingIntent();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getSessionActivity. " + e);
                return null;
            }
        }

        public TransportControls getTransportControls() {
            if (this.f912c == null) {
                this.f912c = new TransportControlsBase(this.f911b);
            }
            return this.f912c;
        }

        public void registerCallback(Callback callback, Handler handler) {
            if (callback == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.f911b.asBinder().linkToDeath(callback, 0);
                this.f911b.registerCallbackListener((IMediaControllerCallback) callback.f903a);
                callback.m689a(handler);
                boolean unused = callback.f905c = true;
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback. " + e);
                callback.onSessionDestroyed();
            }
        }

        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            try {
                this.f911b.sendCommand(str, bundle, new MediaSessionCompat.ResultReceiverWrapper(resultReceiver));
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in sendCommand. " + e);
            }
        }

        public void setVolumeTo(int i, int i2) {
            try {
                this.f911b.setVolumeTo(i, i2, (String) null);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in setVolumeTo. " + e);
            }
        }

        public void unregisterCallback(Callback callback) {
            if (callback == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.f911b.unregisterCallbackListener((IMediaControllerCallback) callback.f903a);
                this.f911b.asBinder().unlinkToDeath(callback, 0);
                boolean unused = callback.f905c = false;
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in unregisterCallback. " + e);
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$PlaybackInfo */
    public final class PlaybackInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;

        /* renamed from: a */
        private final int f913a;

        /* renamed from: b */
        private final int f914b;

        /* renamed from: c */
        private final int f915c;

        /* renamed from: d */
        private final int f916d;

        /* renamed from: e */
        private final int f917e;

        PlaybackInfo(int i, int i2, int i3, int i4, int i5) {
            this.f913a = i;
            this.f914b = i2;
            this.f915c = i3;
            this.f916d = i4;
            this.f917e = i5;
        }

        public int getAudioStream() {
            return this.f914b;
        }

        public int getCurrentVolume() {
            return this.f917e;
        }

        public int getMaxVolume() {
            return this.f916d;
        }

        public int getPlaybackType() {
            return this.f913a;
        }

        public int getVolumeControl() {
            return this.f915c;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$TransportControls */
    public abstract class TransportControls {
        TransportControls() {
        }

        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(String str, Bundle bundle);

        public abstract void playFromSearch(String str, Bundle bundle);

        public abstract void playFromUri(Uri uri, Bundle bundle);

        public abstract void rewind();

        public abstract void seekTo(long j);

        public abstract void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle);

        public abstract void sendCustomAction(String str, Bundle bundle);

        public abstract void setRating(RatingCompat ratingCompat);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long j);

        public abstract void stop();
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$TransportControlsApi21 */
    class TransportControlsApi21 extends TransportControls {

        /* renamed from: a */
        protected final Object f918a;

        public TransportControlsApi21(Object obj) {
            this.f918a = obj;
        }

        public void fastForward() {
            MediaControllerCompatApi21.TransportControls.fastForward(this.f918a);
        }

        public void pause() {
            MediaControllerCompatApi21.TransportControls.pause(this.f918a);
        }

        public void play() {
            MediaControllerCompatApi21.TransportControls.play(this.f918a);
        }

        public void playFromMediaId(String str, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.playFromMediaId(this.f918a, str, bundle);
        }

        public void playFromSearch(String str, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.playFromSearch(this.f918a, str, bundle);
        }

        public void playFromUri(Uri uri, Bundle bundle) {
        }

        public void rewind() {
            MediaControllerCompatApi21.TransportControls.rewind(this.f918a);
        }

        public void seekTo(long j) {
            MediaControllerCompatApi21.TransportControls.seekTo(this.f918a, j);
        }

        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.f918a, customAction.getAction(), bundle);
        }

        public void sendCustomAction(String str, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.f918a, str, bundle);
        }

        public void setRating(RatingCompat ratingCompat) {
            MediaControllerCompatApi21.TransportControls.setRating(this.f918a, ratingCompat != null ? ratingCompat.getRating() : null);
        }

        public void skipToNext() {
            MediaControllerCompatApi21.TransportControls.skipToNext(this.f918a);
        }

        public void skipToPrevious() {
            MediaControllerCompatApi21.TransportControls.skipToPrevious(this.f918a);
        }

        public void skipToQueueItem(long j) {
            MediaControllerCompatApi21.TransportControls.skipToQueueItem(this.f918a, j);
        }

        public void stop() {
            MediaControllerCompatApi21.TransportControls.stop(this.f918a);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$TransportControlsApi23 */
    class TransportControlsApi23 extends TransportControlsApi21 {
        public TransportControlsApi23(Object obj) {
            super(obj);
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            MediaControllerCompatApi23.TransportControls.playFromUri(this.f918a, uri, bundle);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$TransportControlsBase */
    class TransportControlsBase extends TransportControls {

        /* renamed from: a */
        private IMediaSession f919a;

        public TransportControlsBase(IMediaSession iMediaSession) {
            this.f919a = iMediaSession;
        }

        public void fastForward() {
            try {
                this.f919a.fastForward();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in fastForward. " + e);
            }
        }

        public void pause() {
            try {
                this.f919a.pause();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in pause. " + e);
            }
        }

        public void play() {
            try {
                this.f919a.play();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in play. " + e);
            }
        }

        public void playFromMediaId(String str, Bundle bundle) {
            try {
                this.f919a.playFromMediaId(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in playFromMediaId. " + e);
            }
        }

        public void playFromSearch(String str, Bundle bundle) {
            try {
                this.f919a.playFromSearch(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in playFromSearch. " + e);
            }
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            try {
                this.f919a.playFromUri(uri, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in playFromUri. " + e);
            }
        }

        public void rewind() {
            try {
                this.f919a.rewind();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in rewind. " + e);
            }
        }

        public void seekTo(long j) {
            try {
                this.f919a.seekTo(j);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in seekTo. " + e);
            }
        }

        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            sendCustomAction(customAction.getAction(), bundle);
        }

        public void sendCustomAction(String str, Bundle bundle) {
            try {
                this.f919a.sendCustomAction(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in sendCustomAction. " + e);
            }
        }

        public void setRating(RatingCompat ratingCompat) {
            try {
                this.f919a.rate(ratingCompat);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in setRating. " + e);
            }
        }

        public void skipToNext() {
            try {
                this.f919a.next();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in skipToNext. " + e);
            }
        }

        public void skipToPrevious() {
            try {
                this.f919a.previous();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in skipToPrevious. " + e);
            }
        }

        public void skipToQueueItem(long j) {
            try {
                this.f919a.skipToQueueItem(j);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in skipToQueueItem. " + e);
            }
        }

        public void stop() {
            try {
                this.f919a.stop();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in stop. " + e);
            }
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.f902b = token;
        if (Build.VERSION.SDK_INT >= 21) {
            this.f901a = new MediaControllerImplApi21(context, token);
        } else {
            this.f901a = new MediaControllerImplBase(this.f902b);
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat mediaSessionCompat) {
        if (mediaSessionCompat == null) {
            throw new IllegalArgumentException("session must not be null");
        }
        this.f902b = mediaSessionCompat.getSessionToken();
        if (Build.VERSION.SDK_INT >= 23) {
            this.f901a = new MediaControllerImplApi23(context, mediaSessionCompat);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.f901a = new MediaControllerImplApi21(context, mediaSessionCompat);
        } else {
            this.f901a = new MediaControllerImplBase(this.f902b);
        }
    }

    public void adjustVolume(int i, int i2) {
        this.f901a.adjustVolume(i, i2);
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.f901a.dispatchMediaButtonEvent(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public Bundle getExtras() {
        return this.f901a.getExtras();
    }

    public long getFlags() {
        return this.f901a.getFlags();
    }

    public Object getMediaController() {
        return this.f901a.getMediaController();
    }

    public MediaMetadataCompat getMetadata() {
        return this.f901a.getMetadata();
    }

    public String getPackageName() {
        return this.f901a.getPackageName();
    }

    public PlaybackInfo getPlaybackInfo() {
        return this.f901a.getPlaybackInfo();
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.f901a.getPlaybackState();
    }

    public List<MediaSessionCompat.QueueItem> getQueue() {
        return this.f901a.getQueue();
    }

    public CharSequence getQueueTitle() {
        return this.f901a.getQueueTitle();
    }

    public int getRatingType() {
        return this.f901a.getRatingType();
    }

    public PendingIntent getSessionActivity() {
        return this.f901a.getSessionActivity();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.f902b;
    }

    public TransportControls getTransportControls() {
        return this.f901a.getTransportControls();
    }

    public void registerCallback(Callback callback) {
        registerCallback(callback, (Handler) null);
    }

    public void registerCallback(Callback callback, Handler handler) {
        if (callback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        if (handler == null) {
            handler = new Handler();
        }
        this.f901a.registerCallback(callback, handler);
    }

    public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command cannot be null or empty");
        }
        this.f901a.sendCommand(str, bundle, resultReceiver);
    }

    public void setVolumeTo(int i, int i2) {
        this.f901a.setVolumeTo(i, i2);
    }

    public void unregisterCallback(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        this.f901a.unregisterCallback(callback);
    }
}
