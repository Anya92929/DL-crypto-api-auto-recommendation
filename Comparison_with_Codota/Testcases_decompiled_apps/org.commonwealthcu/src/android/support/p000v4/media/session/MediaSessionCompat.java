package android.support.p000v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
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
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaSessionCompat */
public class MediaSessionCompat {
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    private final ArrayList mActiveListeners = new ArrayList();
    private final MediaControllerCompat mController;
    private final MediaSessionImpl mImpl;

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$Callback */
    public abstract class Callback {
        final Object mCallbackObj;

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

        public Callback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.mCallbackObj = MediaSessionCompatApi21.createCallback(new StubApi21());
            } else {
                this.mCallbackObj = null;
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

        void setQueue(List list);

        void setQueueTitle(CharSequence charSequence);

        void setRatingType(int i);

        void setSessionActivity(PendingIntent pendingIntent);
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21 */
    class MediaSessionImplApi21 implements MediaSessionImpl {
        private PendingIntent mMediaButtonIntent;
        private final Object mSessionObj;
        private final Token mToken = new Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj));

        public MediaSessionImplApi21(Context context, String str) {
            this.mSessionObj = MediaSessionCompatApi21.createSession(context, str);
        }

        public MediaSessionImplApi21(Object obj) {
            this.mSessionObj = MediaSessionCompatApi21.verifySession(obj);
        }

        public Object getMediaSession() {
            return this.mSessionObj;
        }

        public Object getRemoteControlClient() {
            return null;
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        public boolean isActive() {
            return MediaSessionCompatApi21.isActive(this.mSessionObj);
        }

        public void release() {
            MediaSessionCompatApi21.release(this.mSessionObj);
        }

        public void sendSessionEvent(String str, Bundle bundle) {
            MediaSessionCompatApi21.sendSessionEvent(this.mSessionObj, str, bundle);
        }

        public void setActive(boolean z) {
            MediaSessionCompatApi21.setActive(this.mSessionObj, z);
        }

        public void setCallback(Callback callback, Handler handler) {
            MediaSessionCompatApi21.setCallback(this.mSessionObj, callback.mCallbackObj, handler);
        }

        public void setExtras(Bundle bundle) {
            MediaSessionCompatApi21.setExtras(this.mSessionObj, bundle);
        }

        public void setFlags(int i) {
            MediaSessionCompatApi21.setFlags(this.mSessionObj, i);
        }

        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
            this.mMediaButtonIntent = pendingIntent;
            MediaSessionCompatApi21.setMediaButtonReceiver(this.mSessionObj, pendingIntent);
        }

        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            MediaSessionCompatApi21.setMetadata(this.mSessionObj, mediaMetadataCompat.getMediaMetadata());
        }

        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            MediaSessionCompatApi21.setPlaybackState(this.mSessionObj, playbackStateCompat.getPlaybackState());
        }

        public void setPlaybackToLocal(int i) {
            MediaSessionCompatApi21.setPlaybackToLocal(this.mSessionObj, i);
        }

        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            MediaSessionCompatApi21.setPlaybackToRemote(this.mSessionObj, volumeProviderCompat.getVolumeProvider());
        }

        public void setQueue(List list) {
            ArrayList arrayList = null;
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((QueueItem) it.next()).getQueueItem());
                }
                arrayList = arrayList2;
            }
            MediaSessionCompatApi21.setQueue(this.mSessionObj, arrayList);
        }

        public void setQueueTitle(CharSequence charSequence) {
            MediaSessionCompatApi21.setQueueTitle(this.mSessionObj, charSequence);
        }

        public void setRatingType(int i) {
            if (Build.VERSION.SDK_INT >= 22) {
                MediaSessionCompatApi22.setRatingType(this.mSessionObj, i);
            }
        }

        public void setSessionActivity(PendingIntent pendingIntent) {
            MediaSessionCompatApi21.setSessionActivity(this.mSessionObj, pendingIntent);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase */
    class MediaSessionImplBase implements MediaSessionImpl {
        /* access modifiers changed from: private */
        public final AudioManager mAudioManager;
        /* access modifiers changed from: private */
        public Callback mCallback;
        private final ComponentName mComponentName;
        private final Context mContext;
        /* access modifiers changed from: private */
        public final RemoteCallbackList mControllerCallbacks = new RemoteCallbackList();
        /* access modifiers changed from: private */
        public boolean mDestroyed = false;
        /* access modifiers changed from: private */
        public Bundle mExtras;
        /* access modifiers changed from: private */
        public int mFlags;
        /* access modifiers changed from: private */
        public final MessageHandler mHandler;
        private boolean mIsActive = false;
        private boolean mIsMbrRegistered = false;
        private boolean mIsRccRegistered = false;
        /* access modifiers changed from: private */
        public int mLocalStream;
        /* access modifiers changed from: private */
        public final Object mLock = new Object();
        private final PendingIntent mMediaButtonEventReceiver;
        /* access modifiers changed from: private */
        public MediaMetadataCompat mMetadata;
        /* access modifiers changed from: private */
        public final String mPackageName;
        /* access modifiers changed from: private */
        public List mQueue;
        /* access modifiers changed from: private */
        public CharSequence mQueueTitle;
        /* access modifiers changed from: private */
        public int mRatingType;
        private final Object mRccObj;
        /* access modifiers changed from: private */
        public PendingIntent mSessionActivity;
        private PlaybackStateCompat mState;
        private final MediaSessionStub mStub;
        /* access modifiers changed from: private */
        public final String mTag;
        private final Token mToken;
        private VolumeProviderCompat.Callback mVolumeCallback = new VolumeProviderCompat.Callback() {
            public void onVolumeChanged(VolumeProviderCompat volumeProviderCompat) {
                if (MediaSessionImplBase.this.mVolumeProvider == volumeProviderCompat) {
                    MediaSessionImplBase.this.sendVolumeInfoChanged(new ParcelableVolumeInfo(MediaSessionImplBase.this.mVolumeType, MediaSessionImplBase.this.mLocalStream, volumeProviderCompat.getVolumeControl(), volumeProviderCompat.getMaxVolume(), volumeProviderCompat.getCurrentVolume()));
                }
            }
        };
        /* access modifiers changed from: private */
        public VolumeProviderCompat mVolumeProvider;
        /* access modifiers changed from: private */
        public int mVolumeType;

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
                MediaSessionImplBase.this.adjustVolume(i, i2);
            }

            public void fastForward() {
                MediaSessionImplBase.this.mHandler.post(9);
            }

            public Bundle getExtras() {
                Bundle access$2200;
                synchronized (MediaSessionImplBase.this.mLock) {
                    access$2200 = MediaSessionImplBase.this.mExtras;
                }
                return access$2200;
            }

            public long getFlags() {
                long access$800;
                synchronized (MediaSessionImplBase.this.mLock) {
                    access$800 = (long) MediaSessionImplBase.this.mFlags;
                }
                return access$800;
            }

            public PendingIntent getLaunchPendingIntent() {
                PendingIntent access$1400;
                synchronized (MediaSessionImplBase.this.mLock) {
                    access$1400 = MediaSessionImplBase.this.mSessionActivity;
                }
                return access$1400;
            }

            public MediaMetadataCompat getMetadata() {
                return MediaSessionImplBase.this.mMetadata;
            }

            public String getPackageName() {
                return MediaSessionImplBase.this.mPackageName;
            }

            public PlaybackStateCompat getPlaybackState() {
                return MediaSessionImplBase.this.getStateWithUpdatedPosition();
            }

            public List getQueue() {
                List access$2000;
                synchronized (MediaSessionImplBase.this.mLock) {
                    access$2000 = MediaSessionImplBase.this.mQueue;
                }
                return access$2000;
            }

            public CharSequence getQueueTitle() {
                return MediaSessionImplBase.this.mQueueTitle;
            }

            public int getRatingType() {
                return MediaSessionImplBase.this.mRatingType;
            }

            public String getTag() {
                return MediaSessionImplBase.this.mTag;
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                int access$300;
                int access$400;
                int streamMaxVolume;
                int streamVolume;
                int i = 2;
                synchronized (MediaSessionImplBase.this.mLock) {
                    access$300 = MediaSessionImplBase.this.mVolumeType;
                    access$400 = MediaSessionImplBase.this.mLocalStream;
                    VolumeProviderCompat access$200 = MediaSessionImplBase.this.mVolumeProvider;
                    if (access$300 == 2) {
                        i = access$200.getVolumeControl();
                        streamMaxVolume = access$200.getMaxVolume();
                        streamVolume = access$200.getCurrentVolume();
                    } else {
                        streamMaxVolume = MediaSessionImplBase.this.mAudioManager.getStreamMaxVolume(access$400);
                        streamVolume = MediaSessionImplBase.this.mAudioManager.getStreamVolume(access$400);
                    }
                }
                return new ParcelableVolumeInfo(access$300, access$400, i, streamMaxVolume, streamVolume);
            }

            public boolean isTransportControlEnabled() {
                return (MediaSessionImplBase.this.mFlags & 2) != 0;
            }

            public void next() {
                MediaSessionImplBase.this.mHandler.post(7);
            }

            public void pause() {
                MediaSessionImplBase.this.mHandler.post(5);
            }

            public void play() {
                MediaSessionImplBase.this.mHandler.post(1);
            }

            public void playFromMediaId(String str, Bundle bundle) {
                MediaSessionImplBase.this.mHandler.post(2, (Object) str, bundle);
            }

            public void playFromSearch(String str, Bundle bundle) {
                MediaSessionImplBase.this.mHandler.post(3, (Object) str, bundle);
            }

            public void previous() {
                MediaSessionImplBase.this.mHandler.post(8);
            }

            public void rate(RatingCompat ratingCompat) {
                MediaSessionImplBase.this.mHandler.post(12, ratingCompat);
            }

            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                if (MediaSessionImplBase.this.mDestroyed) {
                    try {
                        iMediaControllerCallback.onSessionDestroyed();
                    } catch (Exception e) {
                    }
                } else {
                    MediaSessionImplBase.this.mControllerCallbacks.register(iMediaControllerCallback);
                }
            }

            public void rewind() {
                MediaSessionImplBase.this.mHandler.post(10);
            }

            public void seekTo(long j) {
                MediaSessionImplBase.this.mHandler.post(11, Long.valueOf(j));
            }

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                MediaSessionImplBase.this.mHandler.post(15, new Command(str, bundle, resultReceiverWrapper.mResultReceiver));
            }

            public void sendCustomAction(String str, Bundle bundle) {
                MediaSessionImplBase.this.mHandler.post(13, (Object) str, bundle);
            }

            public boolean sendMediaButton(KeyEvent keyEvent) {
                boolean z = (MediaSessionImplBase.this.mFlags & 1) != 0;
                if (z) {
                    MediaSessionImplBase.this.mHandler.post(14, keyEvent);
                }
                return z;
            }

            public void setVolumeTo(int i, int i2, String str) {
                MediaSessionImplBase.this.setVolumeTo(i, i2);
            }

            public void skipToQueueItem(long j) {
                MediaSessionImplBase.this.mHandler.post(4, Long.valueOf(j));
            }

            public void stop() {
                MediaSessionImplBase.this.mHandler.post(6);
            }

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplBase.this.mControllerCallbacks.unregister(iMediaControllerCallback);
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MessageHandler */
        class MessageHandler extends Handler {
            private static final int MSG_ADJUST_VOLUME = 16;
            private static final int MSG_COMMAND = 15;
            private static final int MSG_CUSTOM_ACTION = 13;
            private static final int MSG_FAST_FORWARD = 9;
            private static final int MSG_MEDIA_BUTTON = 14;
            private static final int MSG_NEXT = 7;
            private static final int MSG_PAUSE = 5;
            private static final int MSG_PLAY = 1;
            private static final int MSG_PLAY_MEDIA_ID = 2;
            private static final int MSG_PLAY_SEARCH = 3;
            private static final int MSG_PREVIOUS = 8;
            private static final int MSG_RATE = 12;
            private static final int MSG_REWIND = 10;
            private static final int MSG_SEEK_TO = 11;
            private static final int MSG_SET_VOLUME = 17;
            private static final int MSG_SKIP_TO_ITEM = 4;
            private static final int MSG_STOP = 6;

            public MessageHandler(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                if (MediaSessionImplBase.this.mCallback != null) {
                    switch (message.what) {
                        case 1:
                            MediaSessionImplBase.this.mCallback.onPlay();
                            return;
                        case 2:
                            MediaSessionImplBase.this.mCallback.onPlayFromMediaId((String) message.obj, message.getData());
                            return;
                        case 3:
                            MediaSessionImplBase.this.mCallback.onPlayFromSearch((String) message.obj, message.getData());
                            return;
                        case 4:
                            MediaSessionImplBase.this.mCallback.onSkipToQueueItem(((Long) message.obj).longValue());
                            return;
                        case 5:
                            MediaSessionImplBase.this.mCallback.onPause();
                            return;
                        case 6:
                            MediaSessionImplBase.this.mCallback.onStop();
                            return;
                        case 7:
                            MediaSessionImplBase.this.mCallback.onSkipToNext();
                            return;
                        case 8:
                            MediaSessionImplBase.this.mCallback.onSkipToPrevious();
                            return;
                        case 9:
                            MediaSessionImplBase.this.mCallback.onFastForward();
                            return;
                        case 10:
                            MediaSessionImplBase.this.mCallback.onRewind();
                            return;
                        case 11:
                            MediaSessionImplBase.this.mCallback.onSeekTo(((Long) message.obj).longValue());
                            return;
                        case 12:
                            MediaSessionImplBase.this.mCallback.onSetRating((RatingCompat) message.obj);
                            return;
                        case 13:
                            MediaSessionImplBase.this.mCallback.onCustomAction((String) message.obj, message.getData());
                            return;
                        case 14:
                            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent.putExtra("android.intent.extra.KEY_EVENT", (KeyEvent) message.obj);
                            MediaSessionImplBase.this.mCallback.onMediaButtonEvent(intent);
                            return;
                        case 15:
                            Command command = (Command) message.obj;
                            MediaSessionImplBase.this.mCallback.onCommand(command.command, command.extras, command.stub);
                            return;
                        case 16:
                            MediaSessionImplBase.this.adjustVolume(((Integer) message.obj).intValue(), 0);
                            return;
                        case 17:
                            MediaSessionImplBase.this.setVolumeTo(((Integer) message.obj).intValue(), 0);
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
            this.mContext = context;
            this.mPackageName = context.getPackageName();
            this.mAudioManager = (AudioManager) context.getSystemService("audio");
            this.mTag = str;
            this.mComponentName = componentName;
            this.mMediaButtonEventReceiver = pendingIntent;
            this.mStub = new MediaSessionStub();
            this.mToken = new Token(this.mStub);
            this.mHandler = new MessageHandler(Looper.myLooper());
            this.mRatingType = 0;
            this.mVolumeType = 1;
            this.mLocalStream = 3;
            if (Build.VERSION.SDK_INT >= 14) {
                this.mRccObj = MediaSessionCompatApi14.createRemoteControlClient(pendingIntent);
            } else {
                this.mRccObj = null;
            }
        }

        /* access modifiers changed from: private */
        public void adjustVolume(int i, int i2) {
            if (this.mVolumeType != 2) {
                this.mAudioManager.adjustStreamVolume(i, this.mLocalStream, i2);
            } else if (this.mVolumeProvider != null) {
                this.mVolumeProvider.onAdjustVolume(i);
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.support.p000v4.media.session.PlaybackStateCompat getStateWithUpdatedPosition() {
            /*
                r12 = this;
                r0 = 0
                r2 = -1
                java.lang.Object r4 = r12.mLock
                monitor-enter(r4)
                android.support.v4.media.session.PlaybackStateCompat r7 = r12.mState     // Catch:{ all -> 0x0072 }
                android.support.v4.media.MediaMetadataCompat r5 = r12.mMetadata     // Catch:{ all -> 0x0072 }
                if (r5 == 0) goto L_0x001f
                android.support.v4.media.MediaMetadataCompat r5 = r12.mMetadata     // Catch:{ all -> 0x0072 }
                java.lang.String r6 = "android.media.metadata.DURATION"
                boolean r5 = r5.containsKey(r6)     // Catch:{ all -> 0x0072 }
                if (r5 == 0) goto L_0x001f
                android.support.v4.media.MediaMetadataCompat r2 = r12.mMetadata     // Catch:{ all -> 0x0072 }
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
            throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.media.session.MediaSessionCompat.MediaSessionImplBase.getStateWithUpdatedPosition():android.support.v4.media.session.PlaybackStateCompat");
        }

        private void sendEvent(String str, Bundle bundle) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onEvent(str, bundle);
                } catch (RemoteException e) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendMetadata(MediaMetadataCompat mediaMetadataCompat) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onMetadataChanged(mediaMetadataCompat);
                } catch (RemoteException e) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueue(List list) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onQueueChanged(list);
                } catch (RemoteException e) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueueTitle(CharSequence charSequence) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onQueueTitleChanged(charSequence);
                } catch (RemoteException e) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendSessionDestroyed() {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onSessionDestroyed();
                } catch (RemoteException e) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
            this.mControllerCallbacks.kill();
        }

        private void sendState(PlaybackStateCompat playbackStateCompat) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onPlaybackStateChanged(playbackStateCompat);
                } catch (RemoteException e) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        /* access modifiers changed from: private */
        public void sendVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(beginBroadcast)).onVolumeInfoChanged(parcelableVolumeInfo);
                } catch (RemoteException e) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        /* access modifiers changed from: private */
        public void setVolumeTo(int i, int i2) {
            if (this.mVolumeType != 2) {
                this.mAudioManager.setStreamVolume(this.mLocalStream, i, i2);
            } else if (this.mVolumeProvider != null) {
                this.mVolumeProvider.onSetVolumeTo(i);
            }
        }

        private boolean update() {
            if (this.mIsActive) {
                if (Build.VERSION.SDK_INT >= 8) {
                    if (!this.mIsMbrRegistered && (this.mFlags & 1) != 0) {
                        if (Build.VERSION.SDK_INT >= 18) {
                            MediaSessionCompatApi18.registerMediaButtonEventReceiver(this.mContext, this.mMediaButtonEventReceiver);
                        } else {
                            MediaSessionCompatApi8.registerMediaButtonEventReceiver(this.mContext, this.mComponentName);
                        }
                        this.mIsMbrRegistered = true;
                    } else if (this.mIsMbrRegistered && (this.mFlags & 1) == 0) {
                        if (Build.VERSION.SDK_INT >= 18) {
                            MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(this.mContext, this.mMediaButtonEventReceiver);
                        } else {
                            MediaSessionCompatApi8.unregisterMediaButtonEventReceiver(this.mContext, this.mComponentName);
                        }
                        this.mIsMbrRegistered = false;
                    }
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    if (!this.mIsRccRegistered && (this.mFlags & 2) != 0) {
                        MediaSessionCompatApi14.registerRemoteControlClient(this.mContext, this.mRccObj);
                        this.mIsRccRegistered = true;
                        return true;
                    } else if (this.mIsRccRegistered && (this.mFlags & 2) == 0) {
                        MediaSessionCompatApi14.unregisterRemoteControlClient(this.mContext, this.mRccObj);
                        this.mIsRccRegistered = false;
                        return false;
                    }
                }
            } else {
                if (this.mIsMbrRegistered) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(this.mContext, this.mMediaButtonEventReceiver);
                    } else {
                        MediaSessionCompatApi8.unregisterMediaButtonEventReceiver(this.mContext, this.mComponentName);
                    }
                    this.mIsMbrRegistered = false;
                }
                if (this.mIsRccRegistered) {
                    MediaSessionCompatApi14.unregisterRemoteControlClient(this.mContext, this.mRccObj);
                    this.mIsRccRegistered = false;
                }
            }
            return false;
        }

        public Object getMediaSession() {
            return null;
        }

        public Object getRemoteControlClient() {
            return this.mRccObj;
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        public boolean isActive() {
            return this.mIsActive;
        }

        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            update();
            sendSessionDestroyed();
        }

        public void sendSessionEvent(String str, Bundle bundle) {
            sendEvent(str, bundle);
        }

        public void setActive(boolean z) {
            if (z != this.mIsActive) {
                this.mIsActive = z;
                if (update()) {
                    setMetadata(this.mMetadata);
                    setPlaybackState(this.mState);
                }
            }
        }

        public void setCallback(final Callback callback, Handler handler) {
            if (callback != this.mCallback) {
                if (callback == null || Build.VERSION.SDK_INT < 18) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(this.mRccObj, (Object) null);
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        MediaSessionCompatApi19.setOnMetadataUpdateListener(this.mRccObj, (Object) null);
                    }
                } else {
                    if (handler == null) {
                        new Handler();
                    }
                    C00512 r0 = new MediaSessionCompatApi14.Callback() {
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
                        MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(this.mRccObj, MediaSessionCompatApi18.createPlaybackPositionUpdateListener(r0));
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        MediaSessionCompatApi19.setOnMetadataUpdateListener(this.mRccObj, MediaSessionCompatApi19.createMetadataUpdateListener(r0));
                    }
                }
                this.mCallback = callback;
            }
        }

        public void setExtras(Bundle bundle) {
            this.mExtras = bundle;
        }

        public void setFlags(int i) {
            synchronized (this.mLock) {
                this.mFlags = i;
            }
            update();
        }

        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        }

        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            Bundle bundle = null;
            synchronized (this.mLock) {
                this.mMetadata = mediaMetadataCompat;
            }
            sendMetadata(mediaMetadataCompat);
            if (this.mIsActive) {
                if (Build.VERSION.SDK_INT >= 19) {
                    Object obj = this.mRccObj;
                    if (mediaMetadataCompat != null) {
                        bundle = mediaMetadataCompat.getBundle();
                    }
                    MediaSessionCompatApi19.setMetadata(obj, bundle, this.mState == null ? 0 : this.mState.getActions());
                } else if (Build.VERSION.SDK_INT >= 14) {
                    Object obj2 = this.mRccObj;
                    if (mediaMetadataCompat != null) {
                        bundle = mediaMetadataCompat.getBundle();
                    }
                    MediaSessionCompatApi14.setMetadata(obj2, bundle);
                }
            }
        }

        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.mLock) {
                this.mState = playbackStateCompat;
            }
            sendState(playbackStateCompat);
            if (this.mIsActive) {
                if (playbackStateCompat != null) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.setState(this.mRccObj, playbackStateCompat.getState(), playbackStateCompat.getPosition(), playbackStateCompat.getPlaybackSpeed(), playbackStateCompat.getLastPositionUpdateTime());
                    } else if (Build.VERSION.SDK_INT >= 14) {
                        MediaSessionCompatApi14.setState(this.mRccObj, playbackStateCompat.getState());
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        MediaSessionCompatApi19.setTransportControlFlags(this.mRccObj, playbackStateCompat.getActions());
                    } else if (Build.VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.setTransportControlFlags(this.mRccObj, playbackStateCompat.getActions());
                    } else if (Build.VERSION.SDK_INT >= 14) {
                        MediaSessionCompatApi14.setTransportControlFlags(this.mRccObj, playbackStateCompat.getActions());
                    }
                } else if (Build.VERSION.SDK_INT >= 14) {
                    MediaSessionCompatApi14.setState(this.mRccObj, 0);
                    MediaSessionCompatApi14.setTransportControlFlags(this.mRccObj, 0);
                }
            }
        }

        public void setPlaybackToLocal(int i) {
            if (this.mVolumeProvider != null) {
                this.mVolumeProvider.setCallback((VolumeProviderCompat.Callback) null);
            }
            this.mVolumeType = 1;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, 2, this.mAudioManager.getStreamMaxVolume(this.mLocalStream), this.mAudioManager.getStreamVolume(this.mLocalStream)));
        }

        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            if (volumeProviderCompat == null) {
                throw new IllegalArgumentException("volumeProvider may not be null");
            }
            if (this.mVolumeProvider != null) {
                this.mVolumeProvider.setCallback((VolumeProviderCompat.Callback) null);
            }
            this.mVolumeType = 2;
            this.mVolumeProvider = volumeProviderCompat;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume()));
            volumeProviderCompat.setCallback(this.mVolumeCallback);
        }

        public void setQueue(List list) {
            this.mQueue = list;
            sendQueue(list);
        }

        public void setQueueTitle(CharSequence charSequence) {
            this.mQueueTitle = charSequence;
            sendQueueTitle(charSequence);
        }

        public void setRatingType(int i) {
            this.mRatingType = i;
        }

        public void setSessionActivity(PendingIntent pendingIntent) {
            synchronized (this.mLock) {
                this.mSessionActivity = pendingIntent;
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$OnActiveChangeListener */
    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem */
    public final class QueueItem implements Parcelable {
        public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
            public final QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            public final QueueItem[] newArray(int i) {
                return new QueueItem[i];
            }
        };
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat mDescription;
        private final long mId;
        private Object mItem;

        private QueueItem(Parcel parcel) {
            this.mDescription = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.mId = parcel.readLong();
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
                this.mDescription = mediaDescriptionCompat;
                this.mId = j;
                this.mItem = obj;
            }
        }

        public static QueueItem obtain(Object obj) {
            return new QueueItem(obj, MediaDescriptionCompat.fromMediaDescription(MediaSessionCompatApi21.QueueItem.getDescription(obj)), MediaSessionCompatApi21.QueueItem.getQueueId(obj));
        }

        public final int describeContents() {
            return 0;
        }

        public final MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public final long getQueueId() {
            return this.mId;
        }

        public final Object getQueueItem() {
            if (this.mItem != null || Build.VERSION.SDK_INT < 21) {
                return this.mItem;
            }
            this.mItem = MediaSessionCompatApi21.QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
            return this.mItem;
        }

        public final String toString() {
            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
        }

        public final void writeToParcel(Parcel parcel, int i) {
            this.mDescription.writeToParcel(parcel, i);
            parcel.writeLong(this.mId);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper */
    final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
            public final ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            public final ResultReceiverWrapper[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }
        };
        /* access modifiers changed from: private */
        public ResultReceiver mResultReceiver;

        ResultReceiverWrapper(Parcel parcel) {
            this.mResultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public ResultReceiverWrapper(ResultReceiver resultReceiver) {
            this.mResultReceiver = resultReceiver;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            this.mResultReceiver.writeToParcel(parcel, i);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$Token */
    public final class Token implements Parcelable {
        public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
            public final Token createFromParcel(Parcel parcel) {
                return new Token(Build.VERSION.SDK_INT >= 21 ? parcel.readParcelable((ClassLoader) null) : parcel.readStrongBinder());
            }

            public final Token[] newArray(int i) {
                return new Token[i];
            }
        };
        private final Object mInner;

        Token(Object obj) {
            this.mInner = obj;
        }

        public static Token fromToken(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new Token(MediaSessionCompatApi21.verifyToken(obj));
        }

        public final int describeContents() {
            return 0;
        }

        public final Object getToken() {
            return this.mInner;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.mInner, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.mInner);
            }
        }
    }

    private MediaSessionCompat(Context context, MediaSessionImpl mediaSessionImpl) {
        this.mImpl = mediaSessionImpl;
        this.mController = new MediaControllerCompat(context, this);
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
                this.mImpl = new MediaSessionImplApi21(context, str);
                this.mImpl.setMediaButtonReceiver(pendingIntent);
            } else {
                this.mImpl = new MediaSessionImplBase(context, str, componentName, pendingIntent);
            }
            this.mController = new MediaControllerCompat(context, this);
        }
    }

    public static MediaSessionCompat obtain(Context context, Object obj) {
        return new MediaSessionCompat(context, new MediaSessionImplApi21(obj));
    }

    public void addOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.mActiveListeners.add(onActiveChangeListener);
    }

    public MediaControllerCompat getController() {
        return this.mController;
    }

    public Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    public void release() {
        this.mImpl.release();
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.mActiveListeners.remove(onActiveChangeListener);
    }

    public void sendSessionEvent(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        this.mImpl.sendSessionEvent(str, bundle);
    }

    public void setActive(boolean z) {
        this.mImpl.setActive(z);
        Iterator it = this.mActiveListeners.iterator();
        while (it.hasNext()) {
            ((OnActiveChangeListener) it.next()).onActiveChanged();
        }
    }

    public void setCallback(Callback callback) {
        setCallback(callback, (Handler) null);
    }

    public void setCallback(Callback callback, Handler handler) {
        MediaSessionImpl mediaSessionImpl = this.mImpl;
        if (handler == null) {
            handler = new Handler();
        }
        mediaSessionImpl.setCallback(callback, handler);
    }

    public void setExtras(Bundle bundle) {
        this.mImpl.setExtras(bundle);
    }

    public void setFlags(int i) {
        this.mImpl.setFlags(i);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        this.mImpl.setMediaButtonReceiver(pendingIntent);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        this.mImpl.setMetadata(mediaMetadataCompat);
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        this.mImpl.setPlaybackState(playbackStateCompat);
    }

    public void setPlaybackToLocal(int i) {
        this.mImpl.setPlaybackToLocal(i);
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
        if (volumeProviderCompat == null) {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }
        this.mImpl.setPlaybackToRemote(volumeProviderCompat);
    }

    public void setQueue(List list) {
        this.mImpl.setQueue(list);
    }

    public void setQueueTitle(CharSequence charSequence) {
        this.mImpl.setQueueTitle(charSequence);
    }

    public void setRatingType(int i) {
        this.mImpl.setRatingType(i);
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        this.mImpl.setSessionActivity(pendingIntent);
    }
}
