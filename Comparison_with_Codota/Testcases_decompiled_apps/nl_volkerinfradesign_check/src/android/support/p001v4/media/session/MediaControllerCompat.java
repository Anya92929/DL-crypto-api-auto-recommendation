package android.support.p001v4.media.session;

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
import android.support.p001v4.media.MediaMetadataCompat;
import android.support.p001v4.media.RatingCompat;
import android.support.p001v4.media.session.IMediaControllerCallback;
import android.support.p001v4.media.session.IMediaSession;
import android.support.p001v4.media.session.MediaControllerCompatApi21;
import android.support.p001v4.media.session.MediaControllerCompatApi23;
import android.support.p001v4.media.session.MediaSessionCompat;
import android.support.p001v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaControllerCompat */
public final class MediaControllerCompat {

    /* renamed from: a */
    private final C0188a f661a;

    /* renamed from: b */
    private final MediaSessionCompat.Token f662b;

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$a */
    interface C0188a {
        /* renamed from: a */
        TransportControls mo1267a();

        /* renamed from: a */
        void mo1268a(int i, int i2);

        /* renamed from: a */
        void mo1269a(Callback callback);

        /* renamed from: a */
        void mo1270a(Callback callback, Handler handler);

        /* renamed from: a */
        void mo1271a(String str, Bundle bundle, ResultReceiver resultReceiver);

        /* renamed from: a */
        boolean mo1272a(KeyEvent keyEvent);

        /* renamed from: b */
        PlaybackStateCompat mo1273b();

        /* renamed from: b */
        void mo1274b(int i, int i2);

        /* renamed from: c */
        MediaMetadataCompat mo1275c();

        /* renamed from: d */
        List<MediaSessionCompat.QueueItem> mo1276d();

        /* renamed from: e */
        CharSequence mo1277e();

        /* renamed from: f */
        Bundle mo1278f();

        /* renamed from: g */
        int mo1279g();

        /* renamed from: h */
        long mo1280h();

        /* renamed from: i */
        PlaybackInfo mo1281i();

        /* renamed from: j */
        PendingIntent mo1282j();

        /* renamed from: k */
        String mo1283k();

        /* renamed from: l */
        Object mo1284l();
    }

    public MediaControllerCompat(Context context, MediaSessionCompat mediaSessionCompat) {
        if (mediaSessionCompat == null) {
            throw new IllegalArgumentException("session must not be null");
        }
        this.f662b = mediaSessionCompat.getSessionToken();
        if (Build.VERSION.SDK_INT >= 23) {
            this.f661a = new C0190c(context, mediaSessionCompat);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.f661a = new C0189b(context, mediaSessionCompat);
        } else {
            this.f661a = new C0191d(this.f662b);
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) throws RemoteException {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.f662b = token;
        if (Build.VERSION.SDK_INT >= 21) {
            this.f661a = new C0189b(context, token);
        } else {
            this.f661a = new C0191d(this.f662b);
        }
    }

    public TransportControls getTransportControls() {
        return this.f661a.mo1267a();
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.f661a.mo1272a(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.f661a.mo1273b();
    }

    public MediaMetadataCompat getMetadata() {
        return this.f661a.mo1275c();
    }

    public List<MediaSessionCompat.QueueItem> getQueue() {
        return this.f661a.mo1276d();
    }

    public CharSequence getQueueTitle() {
        return this.f661a.mo1277e();
    }

    public Bundle getExtras() {
        return this.f661a.mo1278f();
    }

    public int getRatingType() {
        return this.f661a.mo1279g();
    }

    public long getFlags() {
        return this.f661a.mo1280h();
    }

    public PlaybackInfo getPlaybackInfo() {
        return this.f661a.mo1281i();
    }

    public PendingIntent getSessionActivity() {
        return this.f661a.mo1282j();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.f662b;
    }

    public void setVolumeTo(int i, int i2) {
        this.f661a.mo1268a(i, i2);
    }

    public void adjustVolume(int i, int i2) {
        this.f661a.mo1274b(i, i2);
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
        this.f661a.mo1270a(callback, handler);
    }

    public void unregisterCallback(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        this.f661a.mo1269a(callback);
    }

    public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command cannot be null or empty");
        }
        this.f661a.mo1271a(str, bundle, resultReceiver);
    }

    public String getPackageName() {
        return this.f661a.mo1283k();
    }

    public Object getMediaController() {
        return this.f661a.mo1284l();
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback */
    public static abstract class Callback implements IBinder.DeathRecipient {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Object f663a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public C0185a f664b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f665c = false;

        public Callback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f663a = MediaControllerCompatApi21.m700a((MediaControllerCompatApi21.Callback) new C0186b());
            } else {
                this.f663a = new C0187c();
            }
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String str, Bundle bundle) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
        }

        public void onExtrasChanged(Bundle bundle) {
        }

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
        }

        public void binderDied() {
            onSessionDestroyed();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m638a(Handler handler) {
            this.f664b = new C0185a(handler.getLooper());
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback$b */
        class C0186b implements MediaControllerCompatApi21.Callback {
            private C0186b() {
            }

            public void onSessionDestroyed() {
                Callback.this.onSessionDestroyed();
            }

            public void onSessionEvent(String str, Bundle bundle) {
                Callback.this.onSessionEvent(str, bundle);
            }

            public void onPlaybackStateChanged(Object obj) {
                Callback.this.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(obj));
            }

            public void onMetadataChanged(Object obj) {
                Callback.this.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(obj));
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback$c */
        class C0187c extends IMediaControllerCallback.Stub {
            private C0187c() {
            }

            public void onEvent(String str, Bundle bundle) throws RemoteException {
                Callback.this.f664b.mo1241a(1, str, bundle);
            }

            public void onSessionDestroyed() throws RemoteException {
                Callback.this.f664b.mo1241a(8, (Object) null, (Bundle) null);
            }

            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Callback.this.f664b.mo1241a(2, playbackStateCompat, (Bundle) null);
            }

            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Callback.this.f664b.mo1241a(3, mediaMetadataCompat, (Bundle) null);
            }

            public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                Callback.this.f664b.mo1241a(5, list, (Bundle) null);
            }

            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                Callback.this.f664b.mo1241a(6, charSequence, (Bundle) null);
            }

            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                Callback.this.f664b.mo1241a(7, bundle, (Bundle) null);
            }

            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                PlaybackInfo playbackInfo;
                if (parcelableVolumeInfo != null) {
                    playbackInfo = new PlaybackInfo(parcelableVolumeInfo.volumeType, parcelableVolumeInfo.audioStream, parcelableVolumeInfo.controlType, parcelableVolumeInfo.maxVolume, parcelableVolumeInfo.currentVolume);
                } else {
                    playbackInfo = null;
                }
                Callback.this.f664b.mo1241a(4, playbackInfo, (Bundle) null);
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback$a */
        class C0185a extends Handler {
            public C0185a(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                if (Callback.this.f665c) {
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

            /* renamed from: a */
            public void mo1241a(int i, Object obj, Bundle bundle) {
                obtainMessage(i, obj).sendToTarget();
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

        /* renamed from: a */
        private final int f669a;

        /* renamed from: b */
        private final int f670b;

        /* renamed from: c */
        private final int f671c;

        /* renamed from: d */
        private final int f672d;

        /* renamed from: e */
        private final int f673e;

        PlaybackInfo(int i, int i2, int i3, int i4, int i5) {
            this.f669a = i;
            this.f670b = i2;
            this.f671c = i3;
            this.f672d = i4;
            this.f673e = i5;
        }

        public int getPlaybackType() {
            return this.f669a;
        }

        public int getAudioStream() {
            return this.f670b;
        }

        public int getVolumeControl() {
            return this.f671c;
        }

        public int getMaxVolume() {
            return this.f672d;
        }

        public int getCurrentVolume() {
            return this.f673e;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$d */
    static class C0191d implements C0188a {

        /* renamed from: a */
        private MediaSessionCompat.Token f675a;

        /* renamed from: b */
        private IMediaSession f676b;

        /* renamed from: c */
        private TransportControls f677c;

        public C0191d(MediaSessionCompat.Token token) {
            this.f675a = token;
            this.f676b = IMediaSession.Stub.asInterface((IBinder) token.getToken());
        }

        /* renamed from: a */
        public void mo1270a(Callback callback, Handler handler) {
            if (callback == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.f676b.asBinder().linkToDeath(callback, 0);
                this.f676b.registerCallbackListener((IMediaControllerCallback) callback.f663a);
                callback.m638a(handler);
                boolean unused = callback.f665c = true;
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback. " + e);
                callback.onSessionDestroyed();
            }
        }

        /* renamed from: a */
        public void mo1269a(Callback callback) {
            if (callback == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.f676b.unregisterCallbackListener((IMediaControllerCallback) callback.f663a);
                this.f676b.asBinder().unlinkToDeath(callback, 0);
                boolean unused = callback.f665c = false;
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in unregisterCallback. " + e);
            }
        }

        /* renamed from: a */
        public boolean mo1272a(KeyEvent keyEvent) {
            if (keyEvent == null) {
                throw new IllegalArgumentException("event may not be null.");
            }
            try {
                this.f676b.sendMediaButton(keyEvent);
                return false;
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent. " + e);
                return false;
            }
        }

        /* renamed from: a */
        public TransportControls mo1267a() {
            if (this.f677c == null) {
                this.f677c = new C0194g(this.f676b);
            }
            return this.f677c;
        }

        /* renamed from: b */
        public PlaybackStateCompat mo1273b() {
            try {
                return this.f676b.getPlaybackState();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackState. " + e);
                return null;
            }
        }

        /* renamed from: c */
        public MediaMetadataCompat mo1275c() {
            try {
                return this.f676b.getMetadata();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getMetadata. " + e);
                return null;
            }
        }

        /* renamed from: d */
        public List<MediaSessionCompat.QueueItem> mo1276d() {
            try {
                return this.f676b.getQueue();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getQueue. " + e);
                return null;
            }
        }

        /* renamed from: e */
        public CharSequence mo1277e() {
            try {
                return this.f676b.getQueueTitle();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getQueueTitle. " + e);
                return null;
            }
        }

        /* renamed from: f */
        public Bundle mo1278f() {
            try {
                return this.f676b.getExtras();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getExtras. " + e);
                return null;
            }
        }

        /* renamed from: g */
        public int mo1279g() {
            try {
                return this.f676b.getRatingType();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getRatingType. " + e);
                return 0;
            }
        }

        /* renamed from: h */
        public long mo1280h() {
            try {
                return this.f676b.getFlags();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getFlags. " + e);
                return 0;
            }
        }

        /* renamed from: i */
        public PlaybackInfo mo1281i() {
            try {
                ParcelableVolumeInfo volumeAttributes = this.f676b.getVolumeAttributes();
                return new PlaybackInfo(volumeAttributes.volumeType, volumeAttributes.audioStream, volumeAttributes.controlType, volumeAttributes.maxVolume, volumeAttributes.currentVolume);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackInfo. " + e);
                return null;
            }
        }

        /* renamed from: j */
        public PendingIntent mo1282j() {
            try {
                return this.f676b.getLaunchPendingIntent();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getSessionActivity. " + e);
                return null;
            }
        }

        /* renamed from: a */
        public void mo1268a(int i, int i2) {
            try {
                this.f676b.setVolumeTo(i, i2, (String) null);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in setVolumeTo. " + e);
            }
        }

        /* renamed from: b */
        public void mo1274b(int i, int i2) {
            try {
                this.f676b.adjustVolume(i, i2, (String) null);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in adjustVolume. " + e);
            }
        }

        /* renamed from: a */
        public void mo1271a(String str, Bundle bundle, ResultReceiver resultReceiver) {
            try {
                this.f676b.sendCommand(str, bundle, new MediaSessionCompat.ResultReceiverWrapper(resultReceiver));
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in sendCommand. " + e);
            }
        }

        /* renamed from: k */
        public String mo1283k() {
            try {
                return this.f676b.getPackageName();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getPackageName. " + e);
                return null;
            }
        }

        /* renamed from: l */
        public Object mo1284l() {
            return null;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$g */
    static class C0194g extends TransportControls {

        /* renamed from: a */
        private IMediaSession f679a;

        public C0194g(IMediaSession iMediaSession) {
            this.f679a = iMediaSession;
        }

        public void play() {
            try {
                this.f679a.play();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in play. " + e);
            }
        }

        public void playFromMediaId(String str, Bundle bundle) {
            try {
                this.f679a.playFromMediaId(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in playFromMediaId. " + e);
            }
        }

        public void playFromSearch(String str, Bundle bundle) {
            try {
                this.f679a.playFromSearch(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in playFromSearch. " + e);
            }
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            try {
                this.f679a.playFromUri(uri, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in playFromUri. " + e);
            }
        }

        public void skipToQueueItem(long j) {
            try {
                this.f679a.skipToQueueItem(j);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in skipToQueueItem. " + e);
            }
        }

        public void pause() {
            try {
                this.f679a.pause();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in pause. " + e);
            }
        }

        public void stop() {
            try {
                this.f679a.stop();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in stop. " + e);
            }
        }

        public void seekTo(long j) {
            try {
                this.f679a.seekTo(j);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in seekTo. " + e);
            }
        }

        public void fastForward() {
            try {
                this.f679a.fastForward();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in fastForward. " + e);
            }
        }

        public void skipToNext() {
            try {
                this.f679a.next();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in skipToNext. " + e);
            }
        }

        public void rewind() {
            try {
                this.f679a.rewind();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in rewind. " + e);
            }
        }

        public void skipToPrevious() {
            try {
                this.f679a.previous();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in skipToPrevious. " + e);
            }
        }

        public void setRating(RatingCompat ratingCompat) {
            try {
                this.f679a.rate(ratingCompat);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in setRating. " + e);
            }
        }

        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            sendCustomAction(customAction.getAction(), bundle);
        }

        public void sendCustomAction(String str, Bundle bundle) {
            try {
                this.f679a.sendCustomAction(str, bundle);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in sendCustomAction. " + e);
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$b */
    static class C0189b implements C0188a {

        /* renamed from: a */
        protected final Object f674a;

        public C0189b(Context context, MediaSessionCompat mediaSessionCompat) {
            this.f674a = MediaControllerCompatApi21.m699a(context, mediaSessionCompat.getSessionToken().getToken());
        }

        public C0189b(Context context, MediaSessionCompat.Token token) throws RemoteException {
            this.f674a = MediaControllerCompatApi21.m699a(context, token.getToken());
            if (this.f674a == null) {
                throw new RemoteException();
            }
        }

        /* renamed from: a */
        public void mo1270a(Callback callback, Handler handler) {
            MediaControllerCompatApi21.m704a(this.f674a, callback.f663a, handler);
        }

        /* renamed from: a */
        public void mo1269a(Callback callback) {
            MediaControllerCompatApi21.m703a(this.f674a, callback.f663a);
        }

        /* renamed from: a */
        public boolean mo1272a(KeyEvent keyEvent) {
            return MediaControllerCompatApi21.m706a(this.f674a, keyEvent);
        }

        /* renamed from: a */
        public TransportControls mo1267a() {
            Object a = MediaControllerCompatApi21.m701a(this.f674a);
            if (a != null) {
                return new C0192e(a);
            }
            return null;
        }

        /* renamed from: b */
        public PlaybackStateCompat mo1273b() {
            Object b = MediaControllerCompatApi21.m707b(this.f674a);
            if (b != null) {
                return PlaybackStateCompat.fromPlaybackState(b);
            }
            return null;
        }

        /* renamed from: c */
        public MediaMetadataCompat mo1275c() {
            Object c = MediaControllerCompatApi21.m709c(this.f674a);
            if (c != null) {
                return MediaMetadataCompat.fromMediaMetadata(c);
            }
            return null;
        }

        /* renamed from: d */
        public List<MediaSessionCompat.QueueItem> mo1276d() {
            List<Object> d = MediaControllerCompatApi21.m710d(this.f674a);
            if (d == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obtain : d) {
                arrayList.add(MediaSessionCompat.QueueItem.obtain(obtain));
            }
            return arrayList;
        }

        /* renamed from: e */
        public CharSequence mo1277e() {
            return MediaControllerCompatApi21.m711e(this.f674a);
        }

        /* renamed from: f */
        public Bundle mo1278f() {
            return MediaControllerCompatApi21.m712f(this.f674a);
        }

        /* renamed from: g */
        public int mo1279g() {
            return MediaControllerCompatApi21.m713g(this.f674a);
        }

        /* renamed from: h */
        public long mo1280h() {
            return MediaControllerCompatApi21.m714h(this.f674a);
        }

        /* renamed from: i */
        public PlaybackInfo mo1281i() {
            Object i = MediaControllerCompatApi21.m715i(this.f674a);
            if (i != null) {
                return new PlaybackInfo(MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(i), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(i), MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(i), MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(i), MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(i));
            }
            return null;
        }

        /* renamed from: j */
        public PendingIntent mo1282j() {
            return MediaControllerCompatApi21.m716j(this.f674a);
        }

        /* renamed from: a */
        public void mo1268a(int i, int i2) {
            MediaControllerCompatApi21.m702a(this.f674a, i, i2);
        }

        /* renamed from: b */
        public void mo1274b(int i, int i2) {
            MediaControllerCompatApi21.m708b(this.f674a, i, i2);
        }

        /* renamed from: a */
        public void mo1271a(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaControllerCompatApi21.m705a(this.f674a, str, bundle, resultReceiver);
        }

        /* renamed from: k */
        public String mo1283k() {
            return MediaControllerCompatApi21.m717k(this.f674a);
        }

        /* renamed from: l */
        public Object mo1284l() {
            return this.f674a;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$e */
    static class C0192e extends TransportControls {

        /* renamed from: a */
        protected final Object f678a;

        public C0192e(Object obj) {
            this.f678a = obj;
        }

        public void play() {
            MediaControllerCompatApi21.TransportControls.play(this.f678a);
        }

        public void pause() {
            MediaControllerCompatApi21.TransportControls.pause(this.f678a);
        }

        public void stop() {
            MediaControllerCompatApi21.TransportControls.stop(this.f678a);
        }

        public void seekTo(long j) {
            MediaControllerCompatApi21.TransportControls.seekTo(this.f678a, j);
        }

        public void fastForward() {
            MediaControllerCompatApi21.TransportControls.fastForward(this.f678a);
        }

        public void rewind() {
            MediaControllerCompatApi21.TransportControls.rewind(this.f678a);
        }

        public void skipToNext() {
            MediaControllerCompatApi21.TransportControls.skipToNext(this.f678a);
        }

        public void skipToPrevious() {
            MediaControllerCompatApi21.TransportControls.skipToPrevious(this.f678a);
        }

        public void setRating(RatingCompat ratingCompat) {
            MediaControllerCompatApi21.TransportControls.setRating(this.f678a, ratingCompat != null ? ratingCompat.getRating() : null);
        }

        public void playFromMediaId(String str, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.playFromMediaId(this.f678a, str, bundle);
        }

        public void playFromSearch(String str, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.playFromSearch(this.f678a, str, bundle);
        }

        public void playFromUri(Uri uri, Bundle bundle) {
        }

        public void skipToQueueItem(long j) {
            MediaControllerCompatApi21.TransportControls.skipToQueueItem(this.f678a, j);
        }

        public void sendCustomAction(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.f678a, customAction.getAction(), bundle);
        }

        public void sendCustomAction(String str, Bundle bundle) {
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.f678a, str, bundle);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$c */
    static class C0190c extends C0189b {
        public C0190c(Context context, MediaSessionCompat mediaSessionCompat) {
            super(context, mediaSessionCompat);
        }

        /* renamed from: a */
        public TransportControls mo1267a() {
            Object a = MediaControllerCompatApi21.m701a(this.f674a);
            if (a != null) {
                return new C0193f(a);
            }
            return null;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$f */
    static class C0193f extends C0192e {
        public C0193f(Object obj) {
            super(obj);
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            MediaControllerCompatApi23.TransportControls.playFromUri(this.f678a, uri, bundle);
        }
    }
}
