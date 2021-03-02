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
    private static final String TAG = "MediaControllerCompat";
    private final MediaControllerImpl mImpl;
    private final MediaSessionCompat.Token mToken;

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

    public MediaControllerCompat(Context context, MediaSessionCompat session) {
        if (session == null) {
            throw new IllegalArgumentException("session must not be null");
        }
        this.mToken = session.getSessionToken();
        if (Build.VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaControllerImplApi23(context, session);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaControllerImplApi21(context, session);
        } else {
            this.mImpl = new MediaControllerImplBase(this.mToken);
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token sessionToken) throws RemoteException {
        if (sessionToken == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.mToken = sessionToken;
        if (Build.VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaControllerImplApi23(context, sessionToken);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaControllerImplApi21(context, sessionToken);
        } else {
            this.mImpl = new MediaControllerImplBase(this.mToken);
        }
    }

    public TransportControls getTransportControls() {
        return this.mImpl.getTransportControls();
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.mImpl.dispatchMediaButtonEvent(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.mImpl.getPlaybackState();
    }

    public MediaMetadataCompat getMetadata() {
        return this.mImpl.getMetadata();
    }

    public List<MediaSessionCompat.QueueItem> getQueue() {
        return this.mImpl.getQueue();
    }

    public CharSequence getQueueTitle() {
        return this.mImpl.getQueueTitle();
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public int getRatingType() {
        return this.mImpl.getRatingType();
    }

    public long getFlags() {
        return this.mImpl.getFlags();
    }

    public PlaybackInfo getPlaybackInfo() {
        return this.mImpl.getPlaybackInfo();
    }

    public PendingIntent getSessionActivity() {
        return this.mImpl.getSessionActivity();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mToken;
    }

    public void setVolumeTo(int value, int flags) {
        this.mImpl.setVolumeTo(value, flags);
    }

    public void adjustVolume(int direction, int flags) {
        this.mImpl.adjustVolume(direction, flags);
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
        this.mImpl.registerCallback(callback, handler);
    }

    public void unregisterCallback(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        this.mImpl.unregisterCallback(callback);
    }

    public void sendCommand(String command, Bundle params, ResultReceiver cb) {
        if (TextUtils.isEmpty(command)) {
            throw new IllegalArgumentException("command cannot be null or empty");
        }
        this.mImpl.sendCommand(command, params, cb);
    }

    public String getPackageName() {
        return this.mImpl.getPackageName();
    }

    public Object getMediaController() {
        return this.mImpl.getMediaController();
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback */
    public static abstract class Callback implements IBinder.DeathRecipient {
        /* access modifiers changed from: private */
        public final Object mCallbackObj;
        /* access modifiers changed from: private */
        public MessageHandler mHandler;
        /* access modifiers changed from: private */
        public boolean mRegistered = false;

        public Callback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.mCallbackObj = MediaControllerCompatApi21.createCallback(new StubApi21());
            } else {
                this.mCallbackObj = new StubCompat();
            }
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String event, Bundle extras) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat state) {
        }

        public void onMetadataChanged(MediaMetadataCompat metadata) {
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
        }

        public void onQueueTitleChanged(CharSequence title) {
        }

        public void onExtrasChanged(Bundle extras) {
        }

        public void onAudioInfoChanged(PlaybackInfo info) {
        }

        public void binderDied() {
            onSessionDestroyed();
        }

        /* access modifiers changed from: private */
        public void setHandler(Handler handler) {
            this.mHandler = new MessageHandler(handler.getLooper());
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback$StubApi21 */
        private class StubApi21 implements MediaControllerCompatApi21.Callback {
            private StubApi21() {
            }

            public void onSessionDestroyed() {
                Callback.this.onSessionDestroyed();
            }

            public void onSessionEvent(String event, Bundle extras) {
                Callback.this.onSessionEvent(event, extras);
            }

            public void onPlaybackStateChanged(Object stateObj) {
                Callback.this.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(stateObj));
            }

            public void onMetadataChanged(Object metadataObj) {
                Callback.this.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(metadataObj));
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat */
        private class StubCompat extends IMediaControllerCallback.Stub {
            private StubCompat() {
            }

            public void onEvent(String event, Bundle extras) throws RemoteException {
                Callback.this.mHandler.post(1, event, extras);
            }

            public void onSessionDestroyed() throws RemoteException {
                Callback.this.mHandler.post(8, (Object) null, (Bundle) null);
            }

            public void onPlaybackStateChanged(PlaybackStateCompat state) throws RemoteException {
                Callback.this.mHandler.post(2, state, (Bundle) null);
            }

            public void onMetadataChanged(MediaMetadataCompat metadata) throws RemoteException {
                Callback.this.mHandler.post(3, metadata, (Bundle) null);
            }

            public void onQueueChanged(List<MediaSessionCompat.QueueItem> queue) throws RemoteException {
                Callback.this.mHandler.post(5, queue, (Bundle) null);
            }

            public void onQueueTitleChanged(CharSequence title) throws RemoteException {
                Callback.this.mHandler.post(6, title, (Bundle) null);
            }

            public void onExtrasChanged(Bundle extras) throws RemoteException {
                Callback.this.mHandler.post(7, extras, (Bundle) null);
            }

            public void onVolumeInfoChanged(ParcelableVolumeInfo info) throws RemoteException {
                PlaybackInfo pi = null;
                if (info != null) {
                    pi = new PlaybackInfo(info.volumeType, info.audioStream, info.controlType, info.maxVolume, info.currentVolume);
                }
                Callback.this.mHandler.post(4, pi, (Bundle) null);
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback$MessageHandler */
        private class MessageHandler extends Handler {
            private static final int MSG_DESTROYED = 8;
            private static final int MSG_EVENT = 1;
            private static final int MSG_UPDATE_EXTRAS = 7;
            private static final int MSG_UPDATE_METADATA = 3;
            private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
            private static final int MSG_UPDATE_QUEUE = 5;
            private static final int MSG_UPDATE_QUEUE_TITLE = 6;
            private static final int MSG_UPDATE_VOLUME = 4;

            public MessageHandler(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message msg) {
                if (Callback.this.mRegistered) {
                    switch (msg.what) {
                        case 1:
                            Callback.this.onSessionEvent((String) msg.obj, msg.getData());
                            return;
                        case 2:
                            Callback.this.onPlaybackStateChanged((PlaybackStateCompat) msg.obj);
                            return;
                        case 3:
                            Callback.this.onMetadataChanged((MediaMetadataCompat) msg.obj);
                            return;
                        case 4:
                            Callback.this.onAudioInfoChanged((PlaybackInfo) msg.obj);
                            return;
                        case 5:
                            Callback.this.onQueueChanged((List) msg.obj);
                            return;
                        case 6:
                            Callback.this.onQueueTitleChanged((CharSequence) msg.obj);
                            return;
                        case 7:
                            Callback.this.onExtrasChanged((Bundle) msg.obj);
                            return;
                        case 8:
                            Callback.this.onSessionDestroyed();
                            return;
                        default:
                            return;
                    }
                }
            }

            public void post(int what, Object obj, Bundle data) {
                Message msg = obtainMessage(what, obj);
                msg.setData(data);
                msg.sendToTarget();
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$TransportControls */
    public static abstract class TransportControls {
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

        TransportControls() {
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$PlaybackInfo */
    public static final class PlaybackInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        private final int mAudioStream;
        private final int mCurrentVolume;
        private final int mMaxVolume;
        private final int mPlaybackType;
        private final int mVolumeControl;

        PlaybackInfo(int type, int stream, int control, int max, int current) {
            this.mPlaybackType = type;
            this.mAudioStream = stream;
            this.mVolumeControl = control;
            this.mMaxVolume = max;
            this.mCurrentVolume = current;
        }

        public int getPlaybackType() {
            return this.mPlaybackType;
        }

        public int getAudioStream() {
            return this.mAudioStream;
        }

        public int getVolumeControl() {
            return this.mVolumeControl;
        }

        public int getMaxVolume() {
            return this.mMaxVolume;
        }

        public int getCurrentVolume() {
            return this.mCurrentVolume;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplBase */
    static class MediaControllerImplBase implements MediaControllerImpl {
        private IMediaSession mBinder;
        private MediaSessionCompat.Token mToken;
        private TransportControls mTransportControls;

        public MediaControllerImplBase(MediaSessionCompat.Token token) {
            this.mToken = token;
            this.mBinder = IMediaSession.Stub.asInterface((IBinder) token.getToken());
        }

        public void registerCallback(Callback callback, Handler handler) {
            if (callback == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.mBinder.asBinder().linkToDeath(callback, 0);
                this.mBinder.registerCallbackListener((IMediaControllerCallback) callback.mCallbackObj);
                callback.setHandler(handler);
                boolean unused = callback.mRegistered = true;
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in registerCallback. " + e);
                callback.onSessionDestroyed();
            }
        }

        public void unregisterCallback(Callback callback) {
            if (callback == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.mBinder.unregisterCallbackListener((IMediaControllerCallback) callback.mCallbackObj);
                this.mBinder.asBinder().unlinkToDeath(callback, 0);
                boolean unused = callback.mRegistered = false;
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in unregisterCallback. " + e);
            }
        }

        public boolean dispatchMediaButtonEvent(KeyEvent event) {
            if (event == null) {
                throw new IllegalArgumentException("event may not be null.");
            }
            try {
                this.mBinder.sendMediaButton(event);
                return false;
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in dispatchMediaButtonEvent. " + e);
                return false;
            }
        }

        public TransportControls getTransportControls() {
            if (this.mTransportControls == null) {
                this.mTransportControls = new TransportControlsBase(this.mBinder);
            }
            return this.mTransportControls;
        }

        public PlaybackStateCompat getPlaybackState() {
            try {
                return this.mBinder.getPlaybackState();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackState. " + e);
                return null;
            }
        }

        public MediaMetadataCompat getMetadata() {
            try {
                return this.mBinder.getMetadata();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getMetadata. " + e);
                return null;
            }
        }

        public List<MediaSessionCompat.QueueItem> getQueue() {
            try {
                return this.mBinder.getQueue();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getQueue. " + e);
                return null;
            }
        }

        public CharSequence getQueueTitle() {
            try {
                return this.mBinder.getQueueTitle();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getQueueTitle. " + e);
                return null;
            }
        }

        public Bundle getExtras() {
            try {
                return this.mBinder.getExtras();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getExtras. " + e);
                return null;
            }
        }

        public int getRatingType() {
            try {
                return this.mBinder.getRatingType();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getRatingType. " + e);
                return 0;
            }
        }

        public long getFlags() {
            try {
                return this.mBinder.getFlags();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getFlags. " + e);
                return 0;
            }
        }

        public PlaybackInfo getPlaybackInfo() {
            try {
                ParcelableVolumeInfo info = this.mBinder.getVolumeAttributes();
                return new PlaybackInfo(info.volumeType, info.audioStream, info.controlType, info.maxVolume, info.currentVolume);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackInfo. " + e);
                return null;
            }
        }

        public PendingIntent getSessionActivity() {
            try {
                return this.mBinder.getLaunchPendingIntent();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getSessionActivity. " + e);
                return null;
            }
        }

        public void setVolumeTo(int value, int flags) {
            try {
                this.mBinder.setVolumeTo(value, flags, (String) null);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in setVolumeTo. " + e);
            }
        }

        public void adjustVolume(int direction, int flags) {
            try {
                this.mBinder.adjustVolume(direction, flags, (String) null);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in adjustVolume. " + e);
            }
        }

        public void sendCommand(String command, Bundle params, ResultReceiver cb) {
            try {
                this.mBinder.sendCommand(command, params, new MediaSessionCompat.ResultReceiverWrapper(cb));
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in sendCommand. " + e);
            }
        }

        public String getPackageName() {
            try {
                return this.mBinder.getPackageName();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in getPackageName. " + e);
                return null;
            }
        }

        public Object getMediaController() {
            return null;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$TransportControlsBase */
    static class TransportControlsBase extends TransportControls {
        private IMediaSession mBinder;

        public TransportControlsBase(IMediaSession binder) {
            this.mBinder = binder;
        }

        public void play() {
            try {
                this.mBinder.play();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in play. " + e);
            }
        }

        public void playFromMediaId(String mediaId, Bundle extras) {
            try {
                this.mBinder.playFromMediaId(mediaId, extras);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in playFromMediaId. " + e);
            }
        }

        public void playFromSearch(String query, Bundle extras) {
            try {
                this.mBinder.playFromSearch(query, extras);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in playFromSearch. " + e);
            }
        }

        public void playFromUri(Uri uri, Bundle extras) {
            try {
                this.mBinder.playFromUri(uri, extras);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in playFromUri. " + e);
            }
        }

        public void skipToQueueItem(long id) {
            try {
                this.mBinder.skipToQueueItem(id);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in skipToQueueItem. " + e);
            }
        }

        public void pause() {
            try {
                this.mBinder.pause();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in pause. " + e);
            }
        }

        public void stop() {
            try {
                this.mBinder.stop();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in stop. " + e);
            }
        }

        public void seekTo(long pos) {
            try {
                this.mBinder.seekTo(pos);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in seekTo. " + e);
            }
        }

        public void fastForward() {
            try {
                this.mBinder.fastForward();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in fastForward. " + e);
            }
        }

        public void skipToNext() {
            try {
                this.mBinder.next();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in skipToNext. " + e);
            }
        }

        public void rewind() {
            try {
                this.mBinder.rewind();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in rewind. " + e);
            }
        }

        public void skipToPrevious() {
            try {
                this.mBinder.previous();
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in skipToPrevious. " + e);
            }
        }

        public void setRating(RatingCompat rating) {
            try {
                this.mBinder.rate(rating);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in setRating. " + e);
            }
        }

        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle args) {
            sendCustomAction(customAction.getAction(), args);
        }

        public void sendCustomAction(String action, Bundle args) {
            try {
                this.mBinder.sendCustomAction(action, args);
            } catch (RemoteException e) {
                Log.e(MediaControllerCompat.TAG, "Dead object in sendCustomAction. " + e);
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21 */
    static class MediaControllerImplApi21 implements MediaControllerImpl {
        protected final Object mControllerObj;

        public MediaControllerImplApi21(Context context, MediaSessionCompat session) {
            this.mControllerObj = MediaControllerCompatApi21.fromToken(context, session.getSessionToken().getToken());
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token sessionToken) throws RemoteException {
            this.mControllerObj = MediaControllerCompatApi21.fromToken(context, sessionToken.getToken());
            if (this.mControllerObj == null) {
                throw new RemoteException();
            }
        }

        public void registerCallback(Callback callback, Handler handler) {
            MediaControllerCompatApi21.registerCallback(this.mControllerObj, callback.mCallbackObj, handler);
        }

        public void unregisterCallback(Callback callback) {
            MediaControllerCompatApi21.unregisterCallback(this.mControllerObj, callback.mCallbackObj);
        }

        public boolean dispatchMediaButtonEvent(KeyEvent event) {
            return MediaControllerCompatApi21.dispatchMediaButtonEvent(this.mControllerObj, event);
        }

        public TransportControls getTransportControls() {
            Object controlsObj = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (controlsObj != null) {
                return new TransportControlsApi21(controlsObj);
            }
            return null;
        }

        public PlaybackStateCompat getPlaybackState() {
            Object stateObj = MediaControllerCompatApi21.getPlaybackState(this.mControllerObj);
            if (stateObj != null) {
                return PlaybackStateCompat.fromPlaybackState(stateObj);
            }
            return null;
        }

        public MediaMetadataCompat getMetadata() {
            Object metadataObj = MediaControllerCompatApi21.getMetadata(this.mControllerObj);
            if (metadataObj != null) {
                return MediaMetadataCompat.fromMediaMetadata(metadataObj);
            }
            return null;
        }

        public List<MediaSessionCompat.QueueItem> getQueue() {
            List<Object> queueObjs = MediaControllerCompatApi21.getQueue(this.mControllerObj);
            if (queueObjs == null) {
                return null;
            }
            List<MediaSessionCompat.QueueItem> queue = new ArrayList<>();
            for (Object item : queueObjs) {
                queue.add(MediaSessionCompat.QueueItem.obtain(item));
            }
            return queue;
        }

        public CharSequence getQueueTitle() {
            return MediaControllerCompatApi21.getQueueTitle(this.mControllerObj);
        }

        public Bundle getExtras() {
            return MediaControllerCompatApi21.getExtras(this.mControllerObj);
        }

        public int getRatingType() {
            return MediaControllerCompatApi21.getRatingType(this.mControllerObj);
        }

        public long getFlags() {
            return MediaControllerCompatApi21.getFlags(this.mControllerObj);
        }

        public PlaybackInfo getPlaybackInfo() {
            Object volumeInfoObj = MediaControllerCompatApi21.getPlaybackInfo(this.mControllerObj);
            if (volumeInfoObj != null) {
                return new PlaybackInfo(MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(volumeInfoObj), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(volumeInfoObj), MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(volumeInfoObj), MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(volumeInfoObj), MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(volumeInfoObj));
            }
            return null;
        }

        public PendingIntent getSessionActivity() {
            return MediaControllerCompatApi21.getSessionActivity(this.mControllerObj);
        }

        public void setVolumeTo(int value, int flags) {
            MediaControllerCompatApi21.setVolumeTo(this.mControllerObj, value, flags);
        }

        public void adjustVolume(int direction, int flags) {
            MediaControllerCompatApi21.adjustVolume(this.mControllerObj, direction, flags);
        }

        public void sendCommand(String command, Bundle params, ResultReceiver cb) {
            MediaControllerCompatApi21.sendCommand(this.mControllerObj, command, params, cb);
        }

        public String getPackageName() {
            return MediaControllerCompatApi21.getPackageName(this.mControllerObj);
        }

        public Object getMediaController() {
            return this.mControllerObj;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$TransportControlsApi21 */
    static class TransportControlsApi21 extends TransportControls {
        protected final Object mControlsObj;

        public TransportControlsApi21(Object controlsObj) {
            this.mControlsObj = controlsObj;
        }

        public void play() {
            MediaControllerCompatApi21.TransportControls.play(this.mControlsObj);
        }

        public void pause() {
            MediaControllerCompatApi21.TransportControls.pause(this.mControlsObj);
        }

        public void stop() {
            MediaControllerCompatApi21.TransportControls.stop(this.mControlsObj);
        }

        public void seekTo(long pos) {
            MediaControllerCompatApi21.TransportControls.seekTo(this.mControlsObj, pos);
        }

        public void fastForward() {
            MediaControllerCompatApi21.TransportControls.fastForward(this.mControlsObj);
        }

        public void rewind() {
            MediaControllerCompatApi21.TransportControls.rewind(this.mControlsObj);
        }

        public void skipToNext() {
            MediaControllerCompatApi21.TransportControls.skipToNext(this.mControlsObj);
        }

        public void skipToPrevious() {
            MediaControllerCompatApi21.TransportControls.skipToPrevious(this.mControlsObj);
        }

        public void setRating(RatingCompat rating) {
            MediaControllerCompatApi21.TransportControls.setRating(this.mControlsObj, rating != null ? rating.getRating() : null);
        }

        public void playFromMediaId(String mediaId, Bundle extras) {
            MediaControllerCompatApi21.TransportControls.playFromMediaId(this.mControlsObj, mediaId, extras);
        }

        public void playFromSearch(String query, Bundle extras) {
            MediaControllerCompatApi21.TransportControls.playFromSearch(this.mControlsObj, query, extras);
        }

        public void playFromUri(Uri uri, Bundle extras) {
            if (uri == null || Uri.EMPTY.equals(uri)) {
                throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, uri);
            bundle.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, extras);
            sendCustomAction(MediaSessionCompat.ACTION_PLAY_FROM_URI, bundle);
        }

        public void skipToQueueItem(long id) {
            MediaControllerCompatApi21.TransportControls.skipToQueueItem(this.mControlsObj, id);
        }

        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle args) {
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, customAction.getAction(), args);
        }

        public void sendCustomAction(String action, Bundle args) {
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, action, args);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi23 */
    static class MediaControllerImplApi23 extends MediaControllerImplApi21 {
        public MediaControllerImplApi23(Context context, MediaSessionCompat session) {
            super(context, session);
        }

        public MediaControllerImplApi23(Context context, MediaSessionCompat.Token sessionToken) throws RemoteException {
            super(context, sessionToken);
        }

        public TransportControls getTransportControls() {
            Object controlsObj = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (controlsObj != null) {
                return new TransportControlsApi23(controlsObj);
            }
            return null;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$TransportControlsApi23 */
    static class TransportControlsApi23 extends TransportControlsApi21 {
        public TransportControlsApi23(Object controlsObj) {
            super(controlsObj);
        }

        public void playFromUri(Uri uri, Bundle extras) {
            MediaControllerCompatApi23.TransportControls.playFromUri(this.mControlsObj, uri, extras);
        }
    }
}
