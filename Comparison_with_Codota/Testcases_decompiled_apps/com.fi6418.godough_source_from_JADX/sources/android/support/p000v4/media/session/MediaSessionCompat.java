package android.support.p000v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.p000v4.media.MediaDescriptionCompat;
import android.support.p000v4.media.MediaMetadataCompat;
import android.support.p000v4.media.RatingCompat;
import android.support.p000v4.media.VolumeProviderCompat;
import android.support.p000v4.media.session.IMediaSession;
import android.support.p000v4.media.session.MediaSessionCompatApi14;
import android.support.p000v4.media.session.MediaSessionCompatApi21;
import android.support.p000v4.media.session.MediaSessionCompatApi23;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaSessionCompat */
public class MediaSessionCompat {
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;

    /* renamed from: a */
    private final MediaSessionImpl f921a;

    /* renamed from: b */
    private final MediaControllerCompat f922b;

    /* renamed from: c */
    private final ArrayList<OnActiveChangeListener> f923c = new ArrayList<>();

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$Callback */
    public abstract class Callback {

        /* renamed from: a */
        final Object f924a;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Callback$StubApi21 */
        class StubApi21 implements MediaSessionCompatApi21.Callback {
            private StubApi21() {
            }

            public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
                Callback.this.onCommand(str, bundle, resultReceiver);
            }

            public void onCustomAction(String str, Bundle bundle) {
                Callback.this.onCustomAction(str, bundle);
            }

            public void onFastForward() {
                Callback.this.onFastForward();
            }

            public boolean onMediaButtonEvent(Intent intent) {
                return Callback.this.onMediaButtonEvent(intent);
            }

            public void onPause() {
                Callback.this.onPause();
            }

            public void onPlay() {
                Callback.this.onPlay();
            }

            public void onPlayFromMediaId(String str, Bundle bundle) {
                Callback.this.onPlayFromMediaId(str, bundle);
            }

            public void onPlayFromSearch(String str, Bundle bundle) {
                Callback.this.onPlayFromSearch(str, bundle);
            }

            public void onRewind() {
                Callback.this.onRewind();
            }

            public void onSeekTo(long j) {
                Callback.this.onSeekTo(j);
            }

            public void onSetRating(Object obj) {
                Callback.this.onSetRating(RatingCompat.fromRating(obj));
            }

            public void onSkipToNext() {
                Callback.this.onSkipToNext();
            }

            public void onSkipToPrevious() {
                Callback.this.onSkipToPrevious();
            }

            public void onSkipToQueueItem(long j) {
                Callback.this.onSkipToQueueItem(j);
            }

            public void onStop() {
                Callback.this.onStop();
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Callback$StubApi23 */
        class StubApi23 extends StubApi21 implements MediaSessionCompatApi23.Callback {
            private StubApi23() {
                super();
            }

            public void onPlayFromUri(Uri uri, Bundle bundle) {
                Callback.this.onPlayFromUri(uri, bundle);
            }
        }

        public Callback() {
            if (Build.VERSION.SDK_INT >= 23) {
                this.f924a = MediaSessionCompatApi23.createCallback(new StubApi23());
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.f924a = MediaSessionCompatApi21.createCallback(new StubApi21());
            } else {
                this.f924a = null;
            }
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void onCustomAction(String str, Bundle bundle) {
        }

        public void onFastForward() {
        }

        public boolean onMediaButtonEvent(Intent intent) {
            return false;
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long j) {
        }

        public void onSetRating(RatingCompat ratingCompat) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long j) {
        }

        public void onStop() {
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl */
    interface MediaSessionImpl {
        Object getMediaSession();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String str, Bundle bundle);

        void setActive(boolean z);

        void setCallback(Callback callback, Handler handler);

        void setExtras(Bundle bundle);

        void setFlags(int i);

        void setMediaButtonReceiver(PendingIntent pendingIntent);

        void setMetadata(MediaMetadataCompat mediaMetadataCompat);

        void setPlaybackState(PlaybackStateCompat playbackStateCompat);

        void setPlaybackToLocal(int i);

        void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat);

        void setQueue(List<QueueItem> list);

        void setQueueTitle(CharSequence charSequence);

        void setRatingType(int i);

        void setSessionActivity(PendingIntent pendingIntent);
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21 */
    class MediaSessionImplApi21 implements MediaSessionImpl {

        /* renamed from: a */
        private final Object f927a;

        /* renamed from: b */
        private final Token f928b = new Token(MediaSessionCompatApi21.getSessionToken(this.f927a));

        /* renamed from: c */
        private PendingIntent f929c;

        public MediaSessionImplApi21(Context context, String str) {
            this.f927a = MediaSessionCompatApi21.createSession(context, str);
        }

        public MediaSessionImplApi21(Object obj) {
            this.f927a = MediaSessionCompatApi21.verifySession(obj);
        }

        public Object getMediaSession() {
            return this.f927a;
        }

        public Object getRemoteControlClient() {
            return null;
        }

        public Token getSessionToken() {
            return this.f928b;
        }

        public boolean isActive() {
            return MediaSessionCompatApi21.isActive(this.f927a);
        }

        public void release() {
            MediaSessionCompatApi21.release(this.f927a);
        }

        public void sendSessionEvent(String str, Bundle bundle) {
            MediaSessionCompatApi21.sendSessionEvent(this.f927a, str, bundle);
        }

        public void setActive(boolean z) {
            MediaSessionCompatApi21.setActive(this.f927a, z);
        }

        public void setCallback(Callback callback, Handler handler) {
            MediaSessionCompatApi21.setCallback(this.f927a, callback.f924a, handler);
        }

        public void setExtras(Bundle bundle) {
            MediaSessionCompatApi21.setExtras(this.f927a, bundle);
        }

        public void setFlags(int i) {
            MediaSessionCompatApi21.setFlags(this.f927a, i);
        }

        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
            this.f929c = pendingIntent;
            MediaSessionCompatApi21.setMediaButtonReceiver(this.f927a, pendingIntent);
        }

        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            MediaSessionCompatApi21.setMetadata(this.f927a, mediaMetadataCompat.getMediaMetadata());
        }

        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            MediaSessionCompatApi21.setPlaybackState(this.f927a, playbackStateCompat.getPlaybackState());
        }

        public void setPlaybackToLocal(int i) {
            MediaSessionCompatApi21.setPlaybackToLocal(this.f927a, i);
        }

        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            MediaSessionCompatApi21.setPlaybackToRemote(this.f927a, volumeProviderCompat.getVolumeProvider());
        }

        public void setQueue(List<QueueItem> list) {
            ArrayList arrayList = null;
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                for (QueueItem queueItem : list) {
                    arrayList2.add(queueItem.getQueueItem());
                }
                arrayList = arrayList2;
            }
            MediaSessionCompatApi21.setQueue(this.f927a, arrayList);
        }

        public void setQueueTitle(CharSequence charSequence) {
            MediaSessionCompatApi21.setQueueTitle(this.f927a, charSequence);
        }

        public void setRatingType(int i) {
            if (Build.VERSION.SDK_INT >= 22) {
                MediaSessionCompatApi22.setRatingType(this.f927a, i);
            }
        }

        public void setSessionActivity(PendingIntent pendingIntent) {
            MediaSessionCompatApi21.setSessionActivity(this.f927a, pendingIntent);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase */
    class MediaSessionImplBase implements MediaSessionImpl {
        /* access modifiers changed from: private */

        /* renamed from: A */
        public int f930A;
        /* access modifiers changed from: private */

        /* renamed from: B */
        public VolumeProviderCompat f931B;

        /* renamed from: C */
        private VolumeProviderCompat.Callback f932C = new VolumeProviderCompat.Callback() {
            public void onVolumeChanged(VolumeProviderCompat volumeProviderCompat) {
                if (MediaSessionImplBase.this.f931B == volumeProviderCompat) {
                    MediaSessionImplBase.this.m700a(new ParcelableVolumeInfo(MediaSessionImplBase.this.f958z, MediaSessionImplBase.this.f930A, volumeProviderCompat.getVolumeControl(), volumeProviderCompat.getMaxVolume(), volumeProviderCompat.getCurrentVolume()));
                }
            }
        };

        /* renamed from: a */
        private final Context f933a;

        /* renamed from: b */
        private final ComponentName f934b;

        /* renamed from: c */
        private final PendingIntent f935c;

        /* renamed from: d */
        private final Object f936d;

        /* renamed from: e */
        private final MediaSessionStub f937e;

        /* renamed from: f */
        private final Token f938f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public final MessageHandler f939g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public final String f940h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public final String f941i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public final AudioManager f942j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public final Object f943k = new Object();
        /* access modifiers changed from: private */

        /* renamed from: l */
        public final RemoteCallbackList<IMediaControllerCallback> f944l = new RemoteCallbackList<>();
        /* access modifiers changed from: private */

        /* renamed from: m */
        public boolean f945m = false;

        /* renamed from: n */
        private boolean f946n = false;

        /* renamed from: o */
        private boolean f947o = false;

        /* renamed from: p */
        private boolean f948p = false;
        /* access modifiers changed from: private */

        /* renamed from: q */
        public Callback f949q;
        /* access modifiers changed from: private */

        /* renamed from: r */
        public int f950r;
        /* access modifiers changed from: private */

        /* renamed from: s */
        public MediaMetadataCompat f951s;
        /* access modifiers changed from: private */

        /* renamed from: t */
        public PlaybackStateCompat f952t;
        /* access modifiers changed from: private */

        /* renamed from: u */
        public PendingIntent f953u;
        /* access modifiers changed from: private */

        /* renamed from: v */
        public List<QueueItem> f954v;
        /* access modifiers changed from: private */

        /* renamed from: w */
        public CharSequence f955w;
        /* access modifiers changed from: private */

        /* renamed from: x */
        public int f956x;
        /* access modifiers changed from: private */

        /* renamed from: y */
        public Bundle f957y;
        /* access modifiers changed from: private */

        /* renamed from: z */
        public int f958z;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$Command */
        final class Command {
            public final String command;
            public final Bundle extras;
            public final ResultReceiver stub;

            public Command(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.command = str;
                this.extras = bundle;
                this.stub = resultReceiver;
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MediaSessionStub */
        class MediaSessionStub extends IMediaSession.Stub {
            MediaSessionStub() {
            }

            public void adjustVolume(int i, int i2, String str) {
                MediaSessionImplBase.this.m696a(i, i2);
            }

            public void fastForward() {
                MediaSessionImplBase.this.f939g.post(9);
            }

            public Bundle getExtras() {
                Bundle q;
                synchronized (MediaSessionImplBase.this.f943k) {
                    q = MediaSessionImplBase.this.f957y;
                }
                return q;
            }

            public long getFlags() {
                long e;
                synchronized (MediaSessionImplBase.this.f943k) {
                    e = (long) MediaSessionImplBase.this.f950r;
                }
                return e;
            }

            public PendingIntent getLaunchPendingIntent() {
                PendingIntent k;
                synchronized (MediaSessionImplBase.this.f943k) {
                    k = MediaSessionImplBase.this.f953u;
                }
                return k;
            }

            public MediaMetadataCompat getMetadata() {
                return MediaSessionImplBase.this.f951s;
            }

            public String getPackageName() {
                return MediaSessionImplBase.this.f940h;
            }

            public PlaybackStateCompat getPlaybackState() {
                return MediaSessionImplBase.this.m707b();
            }

            public List<QueueItem> getQueue() {
                List<QueueItem> o;
                synchronized (MediaSessionImplBase.this.f943k) {
                    o = MediaSessionImplBase.this.f954v;
                }
                return o;
            }

            public CharSequence getQueueTitle() {
                return MediaSessionImplBase.this.f955w;
            }

            public int getRatingType() {
                return MediaSessionImplBase.this.f956x;
            }

            public String getTag() {
                return MediaSessionImplBase.this.f941i;
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                int b;
                int c;
                int streamMaxVolume;
                int streamVolume;
                int i = 2;
                synchronized (MediaSessionImplBase.this.f943k) {
                    b = MediaSessionImplBase.this.f958z;
                    c = MediaSessionImplBase.this.f930A;
                    VolumeProviderCompat a = MediaSessionImplBase.this.f931B;
                    if (b == 2) {
                        i = a.getVolumeControl();
                        streamMaxVolume = a.getMaxVolume();
                        streamVolume = a.getCurrentVolume();
                    } else {
                        streamMaxVolume = MediaSessionImplBase.this.f942j.getStreamMaxVolume(c);
                        streamVolume = MediaSessionImplBase.this.f942j.getStreamVolume(c);
                    }
                }
                return new ParcelableVolumeInfo(b, c, i, streamMaxVolume, streamVolume);
            }

            public boolean isTransportControlEnabled() {
                return (MediaSessionImplBase.this.f950r & 2) != 0;
            }

            public void next() {
                MediaSessionImplBase.this.f939g.post(7);
            }

            public void pause() {
                MediaSessionImplBase.this.f939g.post(5);
            }

            public void play() {
                MediaSessionImplBase.this.f939g.post(1);
            }

            public void playFromMediaId(String str, Bundle bundle) {
                MediaSessionImplBase.this.f939g.post(2, (Object) str, bundle);
            }

            public void playFromSearch(String str, Bundle bundle) {
                MediaSessionImplBase.this.f939g.post(3, (Object) str, bundle);
            }

            public void playFromUri(Uri uri, Bundle bundle) {
                MediaSessionImplBase.this.f939g.post(18, (Object) uri, bundle);
            }

            public void previous() {
                MediaSessionImplBase.this.f939g.post(8);
            }

            public void rate(RatingCompat ratingCompat) {
                MediaSessionImplBase.this.f939g.post(12, ratingCompat);
            }

            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                if (MediaSessionImplBase.this.f945m) {
                    try {
                        iMediaControllerCallback.onSessionDestroyed();
                    } catch (Exception e) {
                    }
                } else {
                    MediaSessionImplBase.this.f944l.register(iMediaControllerCallback);
                }
            }

            public void rewind() {
                MediaSessionImplBase.this.f939g.post(10);
            }

            public void seekTo(long j) {
                MediaSessionImplBase.this.f939g.post(11, Long.valueOf(j));
            }

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                MediaSessionImplBase.this.f939g.post(15, new Command(str, bundle, resultReceiverWrapper.f967a));
            }

            public void sendCustomAction(String str, Bundle bundle) {
                MediaSessionImplBase.this.f939g.post(13, (Object) str, bundle);
            }

            public boolean sendMediaButton(KeyEvent keyEvent) {
                boolean z = (MediaSessionImplBase.this.f950r & 1) != 0;
                if (z) {
                    MediaSessionImplBase.this.f939g.post(14, keyEvent);
                }
                return z;
            }

            public void setVolumeTo(int i, int i2, String str) {
                MediaSessionImplBase.this.m708b(i, i2);
            }

            public void skipToQueueItem(long j) {
                MediaSessionImplBase.this.f939g.post(4, Long.valueOf(j));
            }

            public void stop() {
                MediaSessionImplBase.this.f939g.post(6);
            }

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplBase.this.f944l.unregister(iMediaControllerCallback);
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MessageHandler */
        class MessageHandler extends Handler {
            public MessageHandler(Looper looper) {
                super(looper);
            }

            /* renamed from: a */
            private void m729a(KeyEvent keyEvent) {
                if (keyEvent != null && keyEvent.getAction() == 0) {
                    long actions = MediaSessionImplBase.this.f952t == null ? 0 : MediaSessionImplBase.this.f952t.getActions();
                    switch (keyEvent.getKeyCode()) {
                        case 79:
                        case 85:
                            boolean z = MediaSessionImplBase.this.f952t != null && MediaSessionImplBase.this.f952t.getState() == 3;
                            boolean z2 = (516 & actions) != 0;
                            boolean z3 = (actions & 514) != 0;
                            if (z && z3) {
                                MediaSessionImplBase.this.f949q.onPause();
                                return;
                            } else if (!z && z2) {
                                MediaSessionImplBase.this.f949q.onPlay();
                                return;
                            } else {
                                return;
                            }
                        case 86:
                            if ((actions & 1) != 0) {
                                MediaSessionImplBase.this.f949q.onStop();
                                return;
                            }
                            return;
                        case 87:
                            if ((actions & 32) != 0) {
                                MediaSessionImplBase.this.f949q.onSkipToNext();
                                return;
                            }
                            return;
                        case 88:
                            if ((actions & 16) != 0) {
                                MediaSessionImplBase.this.f949q.onSkipToPrevious();
                                return;
                            }
                            return;
                        case 89:
                            if ((actions & 8) != 0) {
                                MediaSessionImplBase.this.f949q.onRewind();
                                return;
                            }
                            return;
                        case 90:
                            if ((actions & 64) != 0) {
                                MediaSessionImplBase.this.f949q.onFastForward();
                                return;
                            }
                            return;
                        case 126:
                            if ((actions & 4) != 0) {
                                MediaSessionImplBase.this.f949q.onPlay();
                                return;
                            }
                            return;
                        case 127:
                            if ((actions & 2) != 0) {
                                MediaSessionImplBase.this.f949q.onPause();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }

            public void handleMessage(Message message) {
                if (MediaSessionImplBase.this.f949q != null) {
                    switch (message.what) {
                        case 1:
                            MediaSessionImplBase.this.f949q.onPlay();
                            return;
                        case 2:
                            MediaSessionImplBase.this.f949q.onPlayFromMediaId((String) message.obj, message.getData());
                            return;
                        case 3:
                            MediaSessionImplBase.this.f949q.onPlayFromSearch((String) message.obj, message.getData());
                            return;
                        case 4:
                            MediaSessionImplBase.this.f949q.onSkipToQueueItem(((Long) message.obj).longValue());
                            return;
                        case 5:
                            MediaSessionImplBase.this.f949q.onPause();
                            return;
                        case 6:
                            MediaSessionImplBase.this.f949q.onStop();
                            return;
                        case 7:
                            MediaSessionImplBase.this.f949q.onSkipToNext();
                            return;
                        case 8:
                            MediaSessionImplBase.this.f949q.onSkipToPrevious();
                            return;
                        case 9:
                            MediaSessionImplBase.this.f949q.onFastForward();
                            return;
                        case 10:
                            MediaSessionImplBase.this.f949q.onRewind();
                            return;
                        case 11:
                            MediaSessionImplBase.this.f949q.onSeekTo(((Long) message.obj).longValue());
                            return;
                        case 12:
                            MediaSessionImplBase.this.f949q.onSetRating((RatingCompat) message.obj);
                            return;
                        case 13:
                            MediaSessionImplBase.this.f949q.onCustomAction((String) message.obj, message.getData());
                            return;
                        case 14:
                            KeyEvent keyEvent = (KeyEvent) message.obj;
                            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                            if (!MediaSessionImplBase.this.f949q.onMediaButtonEvent(intent)) {
                                m729a(keyEvent);
                                return;
                            }
                            return;
                        case 15:
                            Command command = (Command) message.obj;
                            MediaSessionImplBase.this.f949q.onCommand(command.command, command.extras, command.stub);
                            return;
                        case 16:
                            MediaSessionImplBase.this.m696a(((Integer) message.obj).intValue(), 0);
                            return;
                        case 17:
                            MediaSessionImplBase.this.m708b(((Integer) message.obj).intValue(), 0);
                            return;
                        case 18:
                            MediaSessionImplBase.this.f949q.onPlayFromUri((Uri) message.obj, message.getData());
                            return;
                        default:
                            return;
                    }
                }
            }

            public void post(int i) {
                post(i, (Object) null);
            }

            public void post(int i, Object obj) {
                obtainMessage(i, obj).sendToTarget();
            }

            public void post(int i, Object obj, int i2) {
                obtainMessage(i, i2, 0, obj).sendToTarget();
            }

            public void post(int i, Object obj, Bundle bundle) {
                Message obtainMessage = obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        public MediaSessionImplBase(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            if (componentName == null) {
                throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
            }
            this.f933a = context;
            this.f940h = context.getPackageName();
            this.f942j = (AudioManager) context.getSystemService("audio");
            this.f941i = str;
            this.f934b = componentName;
            this.f935c = pendingIntent;
            this.f937e = new MediaSessionStub();
            this.f938f = new Token(this.f937e);
            this.f939g = new MessageHandler(Looper.myLooper());
            this.f956x = 0;
            this.f958z = 1;
            this.f930A = 3;
            if (Build.VERSION.SDK_INT >= 14) {
                this.f936d = MediaSessionCompatApi14.createRemoteControlClient(pendingIntent);
            } else {
                this.f936d = null;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m696a(int i, int i2) {
            if (this.f958z != 2) {
                this.f942j.adjustStreamVolume(i, this.f930A, i2);
            } else if (this.f931B != null) {
                this.f931B.onAdjustVolume(i);
            }
        }

        /* renamed from: a */
        private void m697a(MediaMetadataCompat mediaMetadataCompat) {
            for (int beginBroadcast = this.f944l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f944l.getBroadcastItem(beginBroadcast).onMetadataChanged(mediaMetadataCompat);
                } catch (RemoteException e) {
                }
            }
            this.f944l.finishBroadcast();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m700a(ParcelableVolumeInfo parcelableVolumeInfo) {
            for (int beginBroadcast = this.f944l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f944l.getBroadcastItem(beginBroadcast).onVolumeInfoChanged(parcelableVolumeInfo);
                } catch (RemoteException e) {
                }
            }
            this.f944l.finishBroadcast();
        }

        /* renamed from: a */
        private void m701a(PlaybackStateCompat playbackStateCompat) {
            for (int beginBroadcast = this.f944l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f944l.getBroadcastItem(beginBroadcast).onPlaybackStateChanged(playbackStateCompat);
                } catch (RemoteException e) {
                }
            }
            this.f944l.finishBroadcast();
        }

        /* renamed from: a */
        private void m702a(CharSequence charSequence) {
            for (int beginBroadcast = this.f944l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f944l.getBroadcastItem(beginBroadcast).onQueueTitleChanged(charSequence);
                } catch (RemoteException e) {
                }
            }
            this.f944l.finishBroadcast();
        }

        /* renamed from: a */
        private void m703a(String str, Bundle bundle) {
            for (int beginBroadcast = this.f944l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f944l.getBroadcastItem(beginBroadcast).onEvent(str, bundle);
                } catch (RemoteException e) {
                }
            }
            this.f944l.finishBroadcast();
        }

        /* renamed from: a */
        private void m704a(List<QueueItem> list) {
            for (int beginBroadcast = this.f944l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f944l.getBroadcastItem(beginBroadcast).onQueueChanged(list);
                } catch (RemoteException e) {
                }
            }
            this.f944l.finishBroadcast();
        }

        /* renamed from: a */
        private boolean m705a() {
            if (this.f946n) {
                if (Build.VERSION.SDK_INT >= 8) {
                    if (!this.f948p && (this.f950r & 1) != 0) {
                        if (Build.VERSION.SDK_INT >= 18) {
                            MediaSessionCompatApi18.registerMediaButtonEventReceiver(this.f933a, this.f935c);
                        } else {
                            MediaSessionCompatApi8.registerMediaButtonEventReceiver(this.f933a, this.f934b);
                        }
                        this.f948p = true;
                    } else if (this.f948p && (this.f950r & 1) == 0) {
                        if (Build.VERSION.SDK_INT >= 18) {
                            MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(this.f933a, this.f935c);
                        } else {
                            MediaSessionCompatApi8.unregisterMediaButtonEventReceiver(this.f933a, this.f934b);
                        }
                        this.f948p = false;
                    }
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    if (!this.f947o && (this.f950r & 2) != 0) {
                        MediaSessionCompatApi14.registerRemoteControlClient(this.f933a, this.f936d);
                        this.f947o = true;
                        return true;
                    } else if (this.f947o && (this.f950r & 2) == 0) {
                        MediaSessionCompatApi14.setState(this.f936d, 0);
                        MediaSessionCompatApi14.unregisterRemoteControlClient(this.f933a, this.f936d);
                        this.f947o = false;
                        return false;
                    }
                }
            } else {
                if (this.f948p) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(this.f933a, this.f935c);
                    } else {
                        MediaSessionCompatApi8.unregisterMediaButtonEventReceiver(this.f933a, this.f934b);
                    }
                    this.f948p = false;
                }
                if (this.f947o) {
                    MediaSessionCompatApi14.setState(this.f936d, 0);
                    MediaSessionCompatApi14.unregisterRemoteControlClient(this.f933a, this.f936d);
                    this.f947o = false;
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.support.p000v4.media.session.PlaybackStateCompat m707b() {
            /*
                r12 = this;
                r0 = 0
                r2 = -1
                java.lang.Object r4 = r12.f943k
                monitor-enter(r4)
                android.support.v4.media.session.PlaybackStateCompat r7 = r12.f952t     // Catch:{ all -> 0x0072 }
                android.support.v4.media.MediaMetadataCompat r5 = r12.f951s     // Catch:{ all -> 0x0072 }
                if (r5 == 0) goto L_0x001f
                android.support.v4.media.MediaMetadataCompat r5 = r12.f951s     // Catch:{ all -> 0x0072 }
                java.lang.String r6 = "android.media.metadata.DURATION"
                boolean r5 = r5.containsKey(r6)     // Catch:{ all -> 0x0072 }
                if (r5 == 0) goto L_0x001f
                android.support.v4.media.MediaMetadataCompat r2 = r12.f951s     // Catch:{ all -> 0x0072 }
                java.lang.String r3 = "android.media.metadata.DURATION"
                long r2 = r2.getLong(r3)     // Catch:{ all -> 0x0072 }
            L_0x001f:
                monitor-exit(r4)     // Catch:{ all -> 0x0072 }
                r4 = 0
                if (r7 == 0) goto L_0x007d
                int r5 = r7.getState()
                r6 = 3
                if (r5 == r6) goto L_0x0038
                int r5 = r7.getState()
                r6 = 4
                if (r5 == r6) goto L_0x0038
                int r5 = r7.getState()
                r6 = 5
                if (r5 != r6) goto L_0x007d
            L_0x0038:
                long r8 = r7.getLastPositionUpdateTime()
                long r5 = android.os.SystemClock.elapsedRealtime()
                int r10 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r10 <= 0) goto L_0x007d
                float r4 = r7.getPlaybackSpeed()
                long r8 = r5 - r8
                float r8 = (float) r8
                float r4 = r4 * r8
                long r8 = (long) r4
                long r10 = r7.getPosition()
                long r8 = r8 + r10
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 < 0) goto L_0x0075
                int r4 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x0075
            L_0x005a:
                android.support.v4.media.session.PlaybackStateCompat$Builder r0 = new android.support.v4.media.session.PlaybackStateCompat$Builder
                r0.<init>(r7)
                int r1 = r7.getState()
                float r4 = r7.getPlaybackSpeed()
                r0.setState(r1, r2, r4, r5)
                android.support.v4.media.session.PlaybackStateCompat r0 = r0.build()
            L_0x006e:
                if (r0 != 0) goto L_0x0071
                r0 = r7
            L_0x0071:
                return r0
            L_0x0072:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0072 }
                throw r0
            L_0x0075:
                int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r2 >= 0) goto L_0x007b
                r2 = r0
                goto L_0x005a
            L_0x007b:
                r2 = r8
                goto L_0x005a
            L_0x007d:
                r0 = r4
                goto L_0x006e
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.media.session.MediaSessionCompat.MediaSessionImplBase.m707b():android.support.v4.media.session.PlaybackStateCompat");
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m708b(int i, int i2) {
            if (this.f958z != 2) {
                this.f942j.setStreamVolume(this.f930A, i, i2);
            } else if (this.f931B != null) {
                this.f931B.onSetVolumeTo(i);
            }
        }

        /* renamed from: c */
        private void m711c() {
            for (int beginBroadcast = this.f944l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f944l.getBroadcastItem(beginBroadcast).onSessionDestroyed();
                } catch (RemoteException e) {
                }
            }
            this.f944l.finishBroadcast();
            this.f944l.kill();
        }

        public Object getMediaSession() {
            return null;
        }

        public Object getRemoteControlClient() {
            return this.f936d;
        }

        public Token getSessionToken() {
            return this.f938f;
        }

        public boolean isActive() {
            return this.f946n;
        }

        public void release() {
            this.f946n = false;
            this.f945m = true;
            m705a();
            m711c();
        }

        public void sendSessionEvent(String str, Bundle bundle) {
            m703a(str, bundle);
        }

        public void setActive(boolean z) {
            if (z != this.f946n) {
                this.f946n = z;
                if (m705a()) {
                    setMetadata(this.f951s);
                    setPlaybackState(this.f952t);
                }
            }
        }

        public void setCallback(final Callback callback, Handler handler) {
            if (callback != this.f949q) {
                if (callback == null || Build.VERSION.SDK_INT < 18) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(this.f936d, (Object) null);
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        MediaSessionCompatApi19.setOnMetadataUpdateListener(this.f936d, (Object) null);
                    }
                } else {
                    if (handler == null) {
                        new Handler();
                    }
                    C01422 r0 = new MediaSessionCompatApi14.Callback() {
                        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
                            callback.onCommand(str, bundle, resultReceiver);
                        }

                        public void onFastForward() {
                            callback.onFastForward();
                        }

                        public boolean onMediaButtonEvent(Intent intent) {
                            return callback.onMediaButtonEvent(intent);
                        }

                        public void onPause() {
                            callback.onPause();
                        }

                        public void onPlay() {
                            callback.onPlay();
                        }

                        public void onRewind() {
                            callback.onRewind();
                        }

                        public void onSeekTo(long j) {
                            callback.onSeekTo(j);
                        }

                        public void onSetRating(Object obj) {
                            callback.onSetRating(RatingCompat.fromRating(obj));
                        }

                        public void onSkipToNext() {
                            callback.onSkipToNext();
                        }

                        public void onSkipToPrevious() {
                            callback.onSkipToPrevious();
                        }

                        public void onStop() {
                            callback.onStop();
                        }
                    };
                    if (Build.VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(this.f936d, MediaSessionCompatApi18.createPlaybackPositionUpdateListener(r0));
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        MediaSessionCompatApi19.setOnMetadataUpdateListener(this.f936d, MediaSessionCompatApi19.createMetadataUpdateListener(r0));
                    }
                }
                this.f949q = callback;
            }
        }

        public void setExtras(Bundle bundle) {
            this.f957y = bundle;
        }

        public void setFlags(int i) {
            synchronized (this.f943k) {
                this.f950r = i;
            }
            m705a();
        }

        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        }

        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            Bundle bundle = null;
            synchronized (this.f943k) {
                this.f951s = mediaMetadataCompat;
            }
            m697a(mediaMetadataCompat);
            if (this.f946n) {
                if (Build.VERSION.SDK_INT >= 19) {
                    Object obj = this.f936d;
                    if (mediaMetadataCompat != null) {
                        bundle = mediaMetadataCompat.getBundle();
                    }
                    MediaSessionCompatApi19.setMetadata(obj, bundle, this.f952t == null ? 0 : this.f952t.getActions());
                } else if (Build.VERSION.SDK_INT >= 14) {
                    Object obj2 = this.f936d;
                    if (mediaMetadataCompat != null) {
                        bundle = mediaMetadataCompat.getBundle();
                    }
                    MediaSessionCompatApi14.setMetadata(obj2, bundle);
                }
            }
        }

        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.f943k) {
                this.f952t = playbackStateCompat;
            }
            m701a(playbackStateCompat);
            if (this.f946n) {
                if (playbackStateCompat != null) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.setState(this.f936d, playbackStateCompat.getState(), playbackStateCompat.getPosition(), playbackStateCompat.getPlaybackSpeed(), playbackStateCompat.getLastPositionUpdateTime());
                    } else if (Build.VERSION.SDK_INT >= 14) {
                        MediaSessionCompatApi14.setState(this.f936d, playbackStateCompat.getState());
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        MediaSessionCompatApi19.setTransportControlFlags(this.f936d, playbackStateCompat.getActions());
                    } else if (Build.VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.setTransportControlFlags(this.f936d, playbackStateCompat.getActions());
                    } else if (Build.VERSION.SDK_INT >= 14) {
                        MediaSessionCompatApi14.setTransportControlFlags(this.f936d, playbackStateCompat.getActions());
                    }
                } else if (Build.VERSION.SDK_INT >= 14) {
                    MediaSessionCompatApi14.setState(this.f936d, 0);
                    MediaSessionCompatApi14.setTransportControlFlags(this.f936d, 0);
                }
            }
        }

        public void setPlaybackToLocal(int i) {
            if (this.f931B != null) {
                this.f931B.setCallback((VolumeProviderCompat.Callback) null);
            }
            this.f958z = 1;
            m700a(new ParcelableVolumeInfo(this.f958z, this.f930A, 2, this.f942j.getStreamMaxVolume(this.f930A), this.f942j.getStreamVolume(this.f930A)));
        }

        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            if (volumeProviderCompat == null) {
                throw new IllegalArgumentException("volumeProvider may not be null");
            }
            if (this.f931B != null) {
                this.f931B.setCallback((VolumeProviderCompat.Callback) null);
            }
            this.f958z = 2;
            this.f931B = volumeProviderCompat;
            m700a(new ParcelableVolumeInfo(this.f958z, this.f930A, this.f931B.getVolumeControl(), this.f931B.getMaxVolume(), this.f931B.getCurrentVolume()));
            volumeProviderCompat.setCallback(this.f932C);
        }

        public void setQueue(List<QueueItem> list) {
            this.f954v = list;
            m704a(list);
        }

        public void setQueueTitle(CharSequence charSequence) {
            this.f955w = charSequence;
            m702a(charSequence);
        }

        public void setRatingType(int i) {
            this.f956x = i;
        }

        public void setSessionActivity(PendingIntent pendingIntent) {
            synchronized (this.f943k) {
                this.f953u = pendingIntent;
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$OnActiveChangeListener */
    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem */
    public final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>() {
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            public QueueItem[] newArray(int i) {
                return new QueueItem[i];
            }
        };
        public static final int UNKNOWN_ID = -1;

        /* renamed from: a */
        private final MediaDescriptionCompat f964a;

        /* renamed from: b */
        private final long f965b;

        /* renamed from: c */
        private Object f966c;

        private QueueItem(Parcel parcel) {
            this.f964a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f965b = parcel.readLong();
        }

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j) {
            this((Object) null, mediaDescriptionCompat, j);
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            } else {
                this.f964a = mediaDescriptionCompat;
                this.f965b = j;
                this.f966c = obj;
            }
        }

        public static QueueItem obtain(Object obj) {
            return new QueueItem(obj, MediaDescriptionCompat.fromMediaDescription(MediaSessionCompatApi21.QueueItem.getDescription(obj)), MediaSessionCompatApi21.QueueItem.getQueueId(obj));
        }

        public int describeContents() {
            return 0;
        }

        public MediaDescriptionCompat getDescription() {
            return this.f964a;
        }

        public long getQueueId() {
            return this.f965b;
        }

        public Object getQueueItem() {
            if (this.f966c != null || Build.VERSION.SDK_INT < 21) {
                return this.f966c;
            }
            this.f966c = MediaSessionCompatApi21.QueueItem.createItem(this.f964a.getMediaDescription(), this.f965b);
            return this.f966c;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f964a + ", Id=" + this.f965b + " }";
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f964a.writeToParcel(parcel, i);
            parcel.writeLong(this.f965b);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper */
    final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator<ResultReceiverWrapper>() {
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            public ResultReceiverWrapper[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }
        };
        /* access modifiers changed from: private */

        /* renamed from: a */
        public ResultReceiver f967a;

        ResultReceiverWrapper(Parcel parcel) {
            this.f967a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public ResultReceiverWrapper(ResultReceiver resultReceiver) {
            this.f967a = resultReceiver;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f967a.writeToParcel(parcel, i);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.MediaSessionCompat$SessionFlags */
    public @interface SessionFlags {
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$Token */
    public final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>() {
            public Token createFromParcel(Parcel parcel) {
                return new Token(Build.VERSION.SDK_INT >= 21 ? parcel.readParcelable((ClassLoader) null) : parcel.readStrongBinder());
            }

            public Token[] newArray(int i) {
                return new Token[i];
            }
        };

        /* renamed from: a */
        private final Object f968a;

        Token(Object obj) {
            this.f968a = obj;
        }

        public static Token fromToken(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new Token(MediaSessionCompatApi21.verifyToken(obj));
        }

        public int describeContents() {
            return 0;
        }

        public Object getToken() {
            return this.f968a;
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f968a, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.f968a);
            }
        }
    }

    private MediaSessionCompat(Context context, MediaSessionImpl mediaSessionImpl) {
        this.f921a = mediaSessionImpl;
        this.f922b = new MediaControllerCompat(context, this);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("tag must not be null or empty");
        } else {
            if (componentName != null && pendingIntent == null) {
                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                intent.setComponent(componentName);
                pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.f921a = new MediaSessionImplApi21(context, str);
                this.f921a.setMediaButtonReceiver(pendingIntent);
            } else {
                this.f921a = new MediaSessionImplBase(context, str, componentName, pendingIntent);
            }
            this.f922b = new MediaControllerCompat(context, this);
        }
    }

    public static MediaSessionCompat obtain(Context context, Object obj) {
        return new MediaSessionCompat(context, new MediaSessionImplApi21(obj));
    }

    public void addOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.f923c.add(onActiveChangeListener);
    }

    public MediaControllerCompat getController() {
        return this.f922b;
    }

    public Object getMediaSession() {
        return this.f921a.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.f921a.getRemoteControlClient();
    }

    public Token getSessionToken() {
        return this.f921a.getSessionToken();
    }

    public boolean isActive() {
        return this.f921a.isActive();
    }

    public void release() {
        this.f921a.release();
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.f923c.remove(onActiveChangeListener);
    }

    public void sendSessionEvent(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        this.f921a.sendSessionEvent(str, bundle);
    }

    public void setActive(boolean z) {
        this.f921a.setActive(z);
        Iterator<OnActiveChangeListener> it = this.f923c.iterator();
        while (it.hasNext()) {
            it.next().onActiveChanged();
        }
    }

    public void setCallback(Callback callback) {
        setCallback(callback, (Handler) null);
    }

    public void setCallback(Callback callback, Handler handler) {
        MediaSessionImpl mediaSessionImpl = this.f921a;
        if (handler == null) {
            handler = new Handler();
        }
        mediaSessionImpl.setCallback(callback, handler);
    }

    public void setExtras(Bundle bundle) {
        this.f921a.setExtras(bundle);
    }

    public void setFlags(int i) {
        this.f921a.setFlags(i);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        this.f921a.setMediaButtonReceiver(pendingIntent);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        this.f921a.setMetadata(mediaMetadataCompat);
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        this.f921a.setPlaybackState(playbackStateCompat);
    }

    public void setPlaybackToLocal(int i) {
        this.f921a.setPlaybackToLocal(i);
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
        if (volumeProviderCompat == null) {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }
        this.f921a.setPlaybackToRemote(volumeProviderCompat);
    }

    public void setQueue(List<QueueItem> list) {
        this.f921a.setQueue(list);
    }

    public void setQueueTitle(CharSequence charSequence) {
        this.f921a.setQueueTitle(charSequence);
    }

    public void setRatingType(int i) {
        this.f921a.setRatingType(i);
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        this.f921a.setSessionActivity(pendingIntent);
    }
}
