package android.support.p001v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
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
import android.support.p001v4.media.MediaDescriptionCompat;
import android.support.p001v4.media.MediaMetadataCompat;
import android.support.p001v4.media.RatingCompat;
import android.support.p001v4.media.TransportMediator;
import android.support.p001v4.media.VolumeProviderCompat;
import android.support.p001v4.media.session.IMediaSession;
import android.support.p001v4.media.session.MediaSessionCompatApi23;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000.C0635bs;
import p000.C0641bv;

/* renamed from: android.support.v4.media.session.MediaSessionCompat */
public class MediaSessionCompat {
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;

    /* renamed from: a */
    private final C0202a f681a;

    /* renamed from: b */
    private final MediaControllerCompat f682b;

    /* renamed from: c */
    private final ArrayList<OnActiveChangeListener> f683c;

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$OnActiveChangeListener */
    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.MediaSessionCompat$SessionFlags */
    public @interface SessionFlags {
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$a */
    interface C0202a {
        /* renamed from: a */
        void mo1368a(int i);

        /* renamed from: a */
        void mo1369a(PendingIntent pendingIntent);

        /* renamed from: a */
        void mo1370a(Bundle bundle);

        /* renamed from: a */
        void mo1371a(MediaMetadataCompat mediaMetadataCompat);

        /* renamed from: a */
        void mo1372a(VolumeProviderCompat volumeProviderCompat);

        /* renamed from: a */
        void mo1373a(Callback callback, Handler handler);

        /* renamed from: a */
        void mo1374a(PlaybackStateCompat playbackStateCompat);

        /* renamed from: a */
        void mo1375a(CharSequence charSequence);

        /* renamed from: a */
        void mo1376a(String str, Bundle bundle);

        /* renamed from: a */
        void mo1377a(List<QueueItem> list);

        /* renamed from: a */
        void mo1378a(boolean z);

        /* renamed from: a */
        boolean mo1379a();

        /* renamed from: b */
        void mo1380b();

        /* renamed from: b */
        void mo1381b(int i);

        /* renamed from: b */
        void mo1382b(PendingIntent pendingIntent);

        /* renamed from: c */
        Token mo1383c();

        /* renamed from: c */
        void mo1384c(int i);

        /* renamed from: d */
        Object mo1385d();

        /* renamed from: e */
        Object mo1386e();
    }

    public MediaSessionCompat(Context context, String str) {
        this(context, str, (ComponentName) null, (PendingIntent) null);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
        this.f683c = new ArrayList<>();
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("tag must not be null or empty");
        } else {
            if (componentName == null) {
                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                intent.setPackage(context.getPackageName());
                List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
                if (queryBroadcastReceivers.size() == 1) {
                    ResolveInfo resolveInfo = queryBroadcastReceivers.get(0);
                    componentName = new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
                } else if (queryBroadcastReceivers.size() > 1) {
                    Log.w("MediaSessionCompat", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, using null. Provide a specific ComponentName to use as this session's media button receiver");
                }
            }
            if (componentName != null && pendingIntent == null) {
                Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON");
                intent2.setComponent(componentName);
                pendingIntent = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.f681a = new C0203b(context, str);
                this.f681a.mo1382b(pendingIntent);
            } else {
                this.f681a = new C0204c(context, str, componentName, pendingIntent);
            }
            this.f682b = new MediaControllerCompat(context, this);
        }
    }

    private MediaSessionCompat(Context context, C0202a aVar) {
        this.f683c = new ArrayList<>();
        this.f681a = aVar;
        this.f682b = new MediaControllerCompat(context, this);
    }

    public void setCallback(Callback callback) {
        setCallback(callback, (Handler) null);
    }

    public void setCallback(Callback callback, Handler handler) {
        C0202a aVar = this.f681a;
        if (handler == null) {
            handler = new Handler();
        }
        aVar.mo1373a(callback, handler);
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        this.f681a.mo1369a(pendingIntent);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        this.f681a.mo1382b(pendingIntent);
    }

    public void setFlags(int i) {
        this.f681a.mo1368a(i);
    }

    public void setPlaybackToLocal(int i) {
        this.f681a.mo1381b(i);
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
        if (volumeProviderCompat == null) {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }
        this.f681a.mo1372a(volumeProviderCompat);
    }

    public void setActive(boolean z) {
        this.f681a.mo1378a(z);
        Iterator<OnActiveChangeListener> it = this.f683c.iterator();
        while (it.hasNext()) {
            it.next().onActiveChanged();
        }
    }

    public boolean isActive() {
        return this.f681a.mo1379a();
    }

    public void sendSessionEvent(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        this.f681a.mo1376a(str, bundle);
    }

    public void release() {
        this.f681a.mo1380b();
    }

    public Token getSessionToken() {
        return this.f681a.mo1383c();
    }

    public MediaControllerCompat getController() {
        return this.f682b;
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        this.f681a.mo1374a(playbackStateCompat);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        this.f681a.mo1371a(mediaMetadataCompat);
    }

    public void setQueue(List<QueueItem> list) {
        this.f681a.mo1377a(list);
    }

    public void setQueueTitle(CharSequence charSequence) {
        this.f681a.mo1375a(charSequence);
    }

    public void setRatingType(int i) {
        this.f681a.mo1384c(i);
    }

    public void setExtras(Bundle bundle) {
        this.f681a.mo1370a(bundle);
    }

    public Object getMediaSession() {
        return this.f681a.mo1385d();
    }

    public Object getRemoteControlClient() {
        return this.f681a.mo1386e();
    }

    public void addOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.f683c.add(onActiveChangeListener);
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.f683c.remove(onActiveChangeListener);
    }

    public static MediaSessionCompat obtain(Context context, Object obj) {
        return new MediaSessionCompat(context, (C0202a) new C0203b(obj));
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$Callback */
    public static abstract class Callback {

        /* renamed from: a */
        final Object f684a;

        public Callback() {
            if (Build.VERSION.SDK_INT >= 23) {
                this.f684a = MediaSessionCompatApi23.m838a(new C0198b());
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.f684a = C0641bv.m3511a((C0641bv.C0642a) new C0197a());
            } else {
                this.f684a = null;
            }
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public boolean onMediaButtonEvent(Intent intent) {
            return false;
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
        }

        public void onSkipToQueueItem(long j) {
        }

        public void onPause() {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onFastForward() {
        }

        public void onRewind() {
        }

        public void onStop() {
        }

        public void onSeekTo(long j) {
        }

        public void onSetRating(RatingCompat ratingCompat) {
        }

        public void onCustomAction(String str, Bundle bundle) {
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Callback$a */
        class C0197a implements C0641bv.C0642a {
            private C0197a() {
            }

            /* renamed from: a */
            public void mo1332a(String str, Bundle bundle, ResultReceiver resultReceiver) {
                Callback.this.onCommand(str, bundle, resultReceiver);
            }

            /* renamed from: a */
            public boolean mo1333a(Intent intent) {
                return Callback.this.onMediaButtonEvent(intent);
            }

            /* renamed from: a */
            public void mo1328a() {
                Callback.this.onPlay();
            }

            /* renamed from: a */
            public void mo1331a(String str, Bundle bundle) {
                Callback.this.onPlayFromMediaId(str, bundle);
            }

            /* renamed from: b */
            public void mo1336b(String str, Bundle bundle) {
                Callback.this.onPlayFromSearch(str, bundle);
            }

            /* renamed from: a */
            public void mo1329a(long j) {
                Callback.this.onSkipToQueueItem(j);
            }

            /* renamed from: b */
            public void mo1334b() {
                Callback.this.onPause();
            }

            /* renamed from: c */
            public void mo1337c() {
                Callback.this.onSkipToNext();
            }

            /* renamed from: d */
            public void mo1339d() {
                Callback.this.onSkipToPrevious();
            }

            /* renamed from: e */
            public void mo1340e() {
                Callback.this.onFastForward();
            }

            /* renamed from: f */
            public void mo1341f() {
                Callback.this.onRewind();
            }

            /* renamed from: g */
            public void mo1342g() {
                Callback.this.onStop();
            }

            /* renamed from: b */
            public void mo1335b(long j) {
                Callback.this.onSeekTo(j);
            }

            /* renamed from: a */
            public void mo1330a(Object obj) {
                Callback.this.onSetRating(RatingCompat.fromRating(obj));
            }

            /* renamed from: c */
            public void mo1338c(String str, Bundle bundle) {
                Callback.this.onCustomAction(str, bundle);
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Callback$b */
        class C0198b extends C0197a implements MediaSessionCompatApi23.Callback {
            private C0198b() {
                super();
            }

            public void onPlayFromUri(Uri uri, Bundle bundle) {
                Callback.this.onPlayFromUri(uri, bundle);
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$Token */
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>() {
            /* renamed from: a */
            public Token createFromParcel(Parcel parcel) {
                Object readStrongBinder;
                if (Build.VERSION.SDK_INT >= 21) {
                    readStrongBinder = parcel.readParcelable((ClassLoader) null);
                } else {
                    readStrongBinder = parcel.readStrongBinder();
                }
                return new Token(readStrongBinder);
            }

            /* renamed from: a */
            public Token[] newArray(int i) {
                return new Token[i];
            }
        };

        /* renamed from: a */
        private final Object f691a;

        Token(Object obj) {
            this.f691a = obj;
        }

        public static Token fromToken(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new Token(C0641bv.m3522b(obj));
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f691a, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.f691a);
            }
        }

        public Object getToken() {
            return this.f691a;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem */
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>() {
            /* renamed from: a */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            /* renamed from: a */
            public QueueItem[] newArray(int i) {
                return new QueueItem[i];
            }
        };
        public static final int UNKNOWN_ID = -1;

        /* renamed from: a */
        private final MediaDescriptionCompat f687a;

        /* renamed from: b */
        private final long f688b;

        /* renamed from: c */
        private Object f689c;

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j) {
            this((Object) null, mediaDescriptionCompat, j);
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            } else {
                this.f687a = mediaDescriptionCompat;
                this.f688b = j;
                this.f689c = obj;
            }
        }

        private QueueItem(Parcel parcel) {
            this.f687a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f688b = parcel.readLong();
        }

        public MediaDescriptionCompat getDescription() {
            return this.f687a;
        }

        public long getQueueId() {
            return this.f688b;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f687a.writeToParcel(parcel, i);
            parcel.writeLong(this.f688b);
        }

        public int describeContents() {
            return 0;
        }

        public Object getQueueItem() {
            if (this.f689c != null || Build.VERSION.SDK_INT < 21) {
                return this.f689c;
            }
            this.f689c = C0641bv.C0644c.m3546a(this.f687a.getMediaDescription(), this.f688b);
            return this.f689c;
        }

        public static QueueItem obtain(Object obj) {
            return new QueueItem(obj, MediaDescriptionCompat.fromMediaDescription(C0641bv.C0644c.m3545a(obj)), C0641bv.C0644c.m3547b(obj));
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f687a + ", Id=" + this.f688b + " }";
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper */
    static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator<ResultReceiverWrapper>() {
            /* renamed from: a */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            /* renamed from: a */
            public ResultReceiverWrapper[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }
        };
        /* access modifiers changed from: private */

        /* renamed from: a */
        public ResultReceiver f690a;

        public ResultReceiverWrapper(ResultReceiver resultReceiver) {
            this.f690a = resultReceiver;
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f690a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f690a.writeToParcel(parcel, i);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$c */
    static class C0204c implements C0202a {
        /* access modifiers changed from: private */

        /* renamed from: A */
        public int f695A;
        /* access modifiers changed from: private */

        /* renamed from: B */
        public VolumeProviderCompat f696B;

        /* renamed from: C */
        private VolumeProviderCompat.Callback f697C = new VolumeProviderCompat.Callback() {
            public void onVolumeChanged(VolumeProviderCompat volumeProviderCompat) {
                if (C0204c.this.f696B == volumeProviderCompat) {
                    C0204c.this.m783a(new ParcelableVolumeInfo(C0204c.this.f723z, C0204c.this.f695A, volumeProviderCompat.getVolumeControl(), volumeProviderCompat.getMaxVolume(), volumeProviderCompat.getCurrentVolume()));
                }
            }
        };

        /* renamed from: a */
        private final Context f698a;

        /* renamed from: b */
        private final ComponentName f699b;

        /* renamed from: c */
        private final PendingIntent f700c;

        /* renamed from: d */
        private final Object f701d;

        /* renamed from: e */
        private final C0208b f702e;

        /* renamed from: f */
        private final Token f703f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public final C0209c f704g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public final String f705h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public final String f706i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public final AudioManager f707j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public final Object f708k = new Object();
        /* access modifiers changed from: private */

        /* renamed from: l */
        public final RemoteCallbackList<IMediaControllerCallback> f709l = new RemoteCallbackList<>();
        /* access modifiers changed from: private */

        /* renamed from: m */
        public boolean f710m = false;

        /* renamed from: n */
        private boolean f711n = false;

        /* renamed from: o */
        private boolean f712o = false;

        /* renamed from: p */
        private boolean f713p = false;
        /* access modifiers changed from: private */

        /* renamed from: q */
        public Callback f714q;
        /* access modifiers changed from: private */

        /* renamed from: r */
        public int f715r;
        /* access modifiers changed from: private */

        /* renamed from: s */
        public MediaMetadataCompat f716s;
        /* access modifiers changed from: private */

        /* renamed from: t */
        public PlaybackStateCompat f717t;
        /* access modifiers changed from: private */

        /* renamed from: u */
        public PendingIntent f718u;
        /* access modifiers changed from: private */

        /* renamed from: v */
        public List<QueueItem> f719v;
        /* access modifiers changed from: private */

        /* renamed from: w */
        public CharSequence f720w;
        /* access modifiers changed from: private */

        /* renamed from: x */
        public int f721x;
        /* access modifiers changed from: private */

        /* renamed from: y */
        public Bundle f722y;
        /* access modifiers changed from: private */

        /* renamed from: z */
        public int f723z;

        public C0204c(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            if (componentName == null) {
                throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
            }
            this.f698a = context;
            this.f705h = context.getPackageName();
            this.f707j = (AudioManager) context.getSystemService("audio");
            this.f706i = str;
            this.f699b = componentName;
            this.f700c = pendingIntent;
            this.f702e = new C0208b();
            this.f703f = new Token(this.f702e);
            this.f704g = new C0209c(Looper.myLooper());
            this.f721x = 0;
            this.f723z = 1;
            this.f695A = 3;
            if (Build.VERSION.SDK_INT >= 14) {
                this.f701d = C0635bs.m3488a(pendingIntent);
            } else {
                this.f701d = null;
            }
        }

        /* renamed from: a */
        public void mo1373a(final Callback callback, Handler handler) {
            if (callback != this.f714q) {
                if (callback == null || Build.VERSION.SDK_INT < 18) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        C0637bt.m3502a(this.f701d, (Object) null);
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        C0639bu.m3509a(this.f701d, (Object) null);
                    }
                } else {
                    if (handler == null) {
                        new Handler();
                    }
                    C02062 r0 = new C0635bs.C0636a() {
                        /* renamed from: a */
                        public void mo1388a(Object obj) {
                            callback.onSetRating(RatingCompat.fromRating(obj));
                        }

                        /* renamed from: a */
                        public void mo1387a(long j) {
                            callback.onSeekTo(j);
                        }
                    };
                    if (Build.VERSION.SDK_INT >= 18) {
                        C0637bt.m3502a(this.f701d, C0637bt.m3498a((C0635bs.C0636a) r0));
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        C0639bu.m3509a(this.f701d, C0639bu.m3505a((C0635bs.C0636a) r0));
                    }
                }
                this.f714q = callback;
            }
        }

        /* renamed from: a */
        public void mo1368a(int i) {
            synchronized (this.f708k) {
                this.f715r = i;
            }
            m795f();
        }

        /* renamed from: b */
        public void mo1381b(int i) {
            if (this.f696B != null) {
                this.f696B.setCallback((VolumeProviderCompat.Callback) null);
            }
            this.f723z = 1;
            m783a(new ParcelableVolumeInfo(this.f723z, this.f695A, 2, this.f707j.getStreamMaxVolume(this.f695A), this.f707j.getStreamVolume(this.f695A)));
        }

        /* renamed from: a */
        public void mo1372a(VolumeProviderCompat volumeProviderCompat) {
            if (volumeProviderCompat == null) {
                throw new IllegalArgumentException("volumeProvider may not be null");
            }
            if (this.f696B != null) {
                this.f696B.setCallback((VolumeProviderCompat.Callback) null);
            }
            this.f723z = 2;
            this.f696B = volumeProviderCompat;
            m783a(new ParcelableVolumeInfo(this.f723z, this.f695A, this.f696B.getVolumeControl(), this.f696B.getMaxVolume(), this.f696B.getCurrentVolume()));
            volumeProviderCompat.setCallback(this.f697C);
        }

        /* renamed from: a */
        public void mo1378a(boolean z) {
            if (z != this.f711n) {
                this.f711n = z;
                if (m795f()) {
                    mo1371a(this.f716s);
                    mo1374a(this.f717t);
                }
            }
        }

        /* renamed from: a */
        public boolean mo1379a() {
            return this.f711n;
        }

        /* renamed from: a */
        public void mo1376a(String str, Bundle bundle) {
            m790b(str, bundle);
        }

        /* renamed from: b */
        public void mo1380b() {
            this.f711n = false;
            this.f710m = true;
            m795f();
            m800h();
        }

        /* renamed from: c */
        public Token mo1383c() {
            return this.f703f;
        }

        /* renamed from: a */
        public void mo1374a(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.f708k) {
                this.f717t = playbackStateCompat;
            }
            m788b(playbackStateCompat);
            if (this.f711n) {
                if (playbackStateCompat != null) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        C0637bt.m3500a(this.f701d, playbackStateCompat.getState(), playbackStateCompat.getPosition(), playbackStateCompat.getPlaybackSpeed(), playbackStateCompat.getLastPositionUpdateTime());
                    } else if (Build.VERSION.SDK_INT >= 14) {
                        C0635bs.m3491a(this.f701d, playbackStateCompat.getState());
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        C0639bu.m3507a(this.f701d, playbackStateCompat.getActions());
                    } else if (Build.VERSION.SDK_INT >= 18) {
                        C0637bt.m3501a(this.f701d, playbackStateCompat.getActions());
                    } else if (Build.VERSION.SDK_INT >= 14) {
                        C0635bs.m3492a(this.f701d, playbackStateCompat.getActions());
                    }
                } else if (Build.VERSION.SDK_INT >= 14) {
                    C0635bs.m3491a(this.f701d, 0);
                    C0635bs.m3492a(this.f701d, 0);
                }
            }
        }

        /* renamed from: a */
        public void mo1371a(MediaMetadataCompat mediaMetadataCompat) {
            Bundle bundle = null;
            synchronized (this.f708k) {
                this.f716s = mediaMetadataCompat;
            }
            m786b(mediaMetadataCompat);
            if (this.f711n) {
                if (Build.VERSION.SDK_INT >= 19) {
                    Object obj = this.f701d;
                    if (mediaMetadataCompat != null) {
                        bundle = mediaMetadataCompat.getBundle();
                    }
                    C0639bu.m3508a(obj, bundle, this.f717t == null ? 0 : this.f717t.getActions());
                } else if (Build.VERSION.SDK_INT >= 14) {
                    Object obj2 = this.f701d;
                    if (mediaMetadataCompat != null) {
                        bundle = mediaMetadataCompat.getBundle();
                    }
                    C0635bs.m3493a(obj2, bundle);
                }
            }
        }

        /* renamed from: a */
        public void mo1369a(PendingIntent pendingIntent) {
            synchronized (this.f708k) {
                this.f718u = pendingIntent;
            }
        }

        /* renamed from: b */
        public void mo1382b(PendingIntent pendingIntent) {
        }

        /* renamed from: a */
        public void mo1377a(List<QueueItem> list) {
            this.f719v = list;
            m791b(list);
        }

        /* renamed from: a */
        public void mo1375a(CharSequence charSequence) {
            this.f720w = charSequence;
            m789b(charSequence);
        }

        /* renamed from: d */
        public Object mo1385d() {
            return null;
        }

        /* renamed from: e */
        public Object mo1386e() {
            return this.f701d;
        }

        /* renamed from: c */
        public void mo1384c(int i) {
            this.f721x = i;
        }

        /* renamed from: a */
        public void mo1370a(Bundle bundle) {
            this.f722y = bundle;
        }

        /* renamed from: f */
        private boolean m795f() {
            if (this.f711n) {
                if (Build.VERSION.SDK_INT >= 8) {
                    if (!this.f713p && (this.f715r & 1) != 0) {
                        if (Build.VERSION.SDK_INT >= 18) {
                            C0637bt.m3499a(this.f698a, this.f700c, this.f699b);
                        } else {
                            C0646bx.m3549a(this.f698a, this.f699b);
                        }
                        this.f713p = true;
                    } else if (this.f713p && (this.f715r & 1) == 0) {
                        if (Build.VERSION.SDK_INT >= 18) {
                            C0637bt.m3503b(this.f698a, this.f700c, this.f699b);
                        } else {
                            C0646bx.m3550b(this.f698a, this.f699b);
                        }
                        this.f713p = false;
                    }
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    if (!this.f712o && (this.f715r & 2) != 0) {
                        C0635bs.m3489a(this.f698a, this.f701d);
                        this.f712o = true;
                        return true;
                    } else if (this.f712o && (this.f715r & 2) == 0) {
                        C0635bs.m3491a(this.f701d, 0);
                        C0635bs.m3494b(this.f698a, this.f701d);
                        this.f712o = false;
                        return false;
                    }
                }
            } else {
                if (this.f713p) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        C0637bt.m3503b(this.f698a, this.f700c, this.f699b);
                    } else {
                        C0646bx.m3550b(this.f698a, this.f699b);
                    }
                    this.f713p = false;
                }
                if (this.f712o) {
                    C0635bs.m3491a(this.f701d, 0);
                    C0635bs.m3494b(this.f698a, this.f701d);
                    this.f712o = false;
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m780a(int i, int i2) {
            if (this.f723z != 2) {
                this.f707j.adjustStreamVolume(this.f695A, i, i2);
            } else if (this.f696B != null) {
                this.f696B.onAdjustVolume(i);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m785b(int i, int i2) {
            if (this.f723z != 2) {
                this.f707j.setStreamVolume(this.f695A, i, i2);
            } else if (this.f696B != null) {
                this.f696B.onSetVolumeTo(i);
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
        /* renamed from: g */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.support.p001v4.media.session.PlaybackStateCompat m798g() {
            /*
                r12 = this;
                r0 = 0
                r2 = -1
                java.lang.Object r4 = r12.f708k
                monitor-enter(r4)
                android.support.v4.media.session.PlaybackStateCompat r7 = r12.f717t     // Catch:{ all -> 0x0072 }
                android.support.v4.media.MediaMetadataCompat r5 = r12.f716s     // Catch:{ all -> 0x0072 }
                if (r5 == 0) goto L_0x001f
                android.support.v4.media.MediaMetadataCompat r5 = r12.f716s     // Catch:{ all -> 0x0072 }
                java.lang.String r6 = "android.media.metadata.DURATION"
                boolean r5 = r5.containsKey(r6)     // Catch:{ all -> 0x0072 }
                if (r5 == 0) goto L_0x001f
                android.support.v4.media.MediaMetadataCompat r2 = r12.f716s     // Catch:{ all -> 0x0072 }
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
            throw new UnsupportedOperationException("Method not decompiled: android.support.p001v4.media.session.MediaSessionCompat.C0204c.m798g():android.support.v4.media.session.PlaybackStateCompat");
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m783a(ParcelableVolumeInfo parcelableVolumeInfo) {
            for (int beginBroadcast = this.f709l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f709l.getBroadcastItem(beginBroadcast).onVolumeInfoChanged(parcelableVolumeInfo);
                } catch (RemoteException e) {
                }
            }
            this.f709l.finishBroadcast();
        }

        /* renamed from: h */
        private void m800h() {
            for (int beginBroadcast = this.f709l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f709l.getBroadcastItem(beginBroadcast).onSessionDestroyed();
                } catch (RemoteException e) {
                }
            }
            this.f709l.finishBroadcast();
            this.f709l.kill();
        }

        /* renamed from: b */
        private void m790b(String str, Bundle bundle) {
            for (int beginBroadcast = this.f709l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f709l.getBroadcastItem(beginBroadcast).onEvent(str, bundle);
                } catch (RemoteException e) {
                }
            }
            this.f709l.finishBroadcast();
        }

        /* renamed from: b */
        private void m788b(PlaybackStateCompat playbackStateCompat) {
            for (int beginBroadcast = this.f709l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f709l.getBroadcastItem(beginBroadcast).onPlaybackStateChanged(playbackStateCompat);
                } catch (RemoteException e) {
                }
            }
            this.f709l.finishBroadcast();
        }

        /* renamed from: b */
        private void m786b(MediaMetadataCompat mediaMetadataCompat) {
            for (int beginBroadcast = this.f709l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f709l.getBroadcastItem(beginBroadcast).onMetadataChanged(mediaMetadataCompat);
                } catch (RemoteException e) {
                }
            }
            this.f709l.finishBroadcast();
        }

        /* renamed from: b */
        private void m791b(List<QueueItem> list) {
            for (int beginBroadcast = this.f709l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f709l.getBroadcastItem(beginBroadcast).onQueueChanged(list);
                } catch (RemoteException e) {
                }
            }
            this.f709l.finishBroadcast();
        }

        /* renamed from: b */
        private void m789b(CharSequence charSequence) {
            for (int beginBroadcast = this.f709l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.f709l.getBroadcastItem(beginBroadcast).onQueueTitleChanged(charSequence);
                } catch (RemoteException e) {
                }
            }
            this.f709l.finishBroadcast();
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$c$b */
        class C0208b extends IMediaSession.Stub {
            C0208b() {
            }

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                C0204c.this.f704g.mo1390a(15, new C0207a(str, bundle, resultReceiverWrapper.f690a));
            }

            public boolean sendMediaButton(KeyEvent keyEvent) {
                boolean z = (C0204c.this.f715r & 1) != 0;
                if (z) {
                    C0204c.this.f704g.mo1390a(14, keyEvent);
                }
                return z;
            }

            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                if (C0204c.this.f710m) {
                    try {
                        iMediaControllerCallback.onSessionDestroyed();
                    } catch (Exception e) {
                    }
                } else {
                    C0204c.this.f709l.register(iMediaControllerCallback);
                }
            }

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                C0204c.this.f709l.unregister(iMediaControllerCallback);
            }

            public String getPackageName() {
                return C0204c.this.f705h;
            }

            public String getTag() {
                return C0204c.this.f706i;
            }

            public PendingIntent getLaunchPendingIntent() {
                PendingIntent k;
                synchronized (C0204c.this.f708k) {
                    k = C0204c.this.f718u;
                }
                return k;
            }

            public long getFlags() {
                long e;
                synchronized (C0204c.this.f708k) {
                    e = (long) C0204c.this.f715r;
                }
                return e;
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                int b;
                int c;
                int streamMaxVolume;
                int streamVolume;
                int i = 2;
                synchronized (C0204c.this.f708k) {
                    b = C0204c.this.f723z;
                    c = C0204c.this.f695A;
                    VolumeProviderCompat a = C0204c.this.f696B;
                    if (b == 2) {
                        i = a.getVolumeControl();
                        streamMaxVolume = a.getMaxVolume();
                        streamVolume = a.getCurrentVolume();
                    } else {
                        streamMaxVolume = C0204c.this.f707j.getStreamMaxVolume(c);
                        streamVolume = C0204c.this.f707j.getStreamVolume(c);
                    }
                }
                return new ParcelableVolumeInfo(b, c, i, streamMaxVolume, streamVolume);
            }

            public void adjustVolume(int i, int i2, String str) {
                C0204c.this.m780a(i, i2);
            }

            public void setVolumeTo(int i, int i2, String str) {
                C0204c.this.m785b(i, i2);
            }

            public void play() throws RemoteException {
                C0204c.this.f704g.mo1389a(1);
            }

            public void playFromMediaId(String str, Bundle bundle) throws RemoteException {
                C0204c.this.f704g.mo1391a(2, str, bundle);
            }

            public void playFromSearch(String str, Bundle bundle) throws RemoteException {
                C0204c.this.f704g.mo1391a(3, str, bundle);
            }

            public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
                C0204c.this.f704g.mo1391a(18, uri, bundle);
            }

            public void skipToQueueItem(long j) {
                C0204c.this.f704g.mo1390a(4, Long.valueOf(j));
            }

            public void pause() throws RemoteException {
                C0204c.this.f704g.mo1389a(5);
            }

            public void stop() throws RemoteException {
                C0204c.this.f704g.mo1389a(6);
            }

            public void next() throws RemoteException {
                C0204c.this.f704g.mo1389a(7);
            }

            public void previous() throws RemoteException {
                C0204c.this.f704g.mo1389a(8);
            }

            public void fastForward() throws RemoteException {
                C0204c.this.f704g.mo1389a(9);
            }

            public void rewind() throws RemoteException {
                C0204c.this.f704g.mo1389a(10);
            }

            public void seekTo(long j) throws RemoteException {
                C0204c.this.f704g.mo1390a(11, Long.valueOf(j));
            }

            public void rate(RatingCompat ratingCompat) throws RemoteException {
                C0204c.this.f704g.mo1390a(12, ratingCompat);
            }

            public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
                C0204c.this.f704g.mo1391a(13, str, bundle);
            }

            public MediaMetadataCompat getMetadata() {
                return C0204c.this.f716s;
            }

            public PlaybackStateCompat getPlaybackState() {
                return C0204c.this.m798g();
            }

            public List<QueueItem> getQueue() {
                List<QueueItem> o;
                synchronized (C0204c.this.f708k) {
                    o = C0204c.this.f719v;
                }
                return o;
            }

            public CharSequence getQueueTitle() {
                return C0204c.this.f720w;
            }

            public Bundle getExtras() {
                Bundle q;
                synchronized (C0204c.this.f708k) {
                    q = C0204c.this.f722y;
                }
                return q;
            }

            public int getRatingType() {
                return C0204c.this.f721x;
            }

            public boolean isTransportControlEnabled() {
                return (C0204c.this.f715r & 2) != 0;
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$c$a */
        static final class C0207a {

            /* renamed from: a */
            public final String f727a;

            /* renamed from: b */
            public final Bundle f728b;

            /* renamed from: c */
            public final ResultReceiver f729c;

            public C0207a(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f727a = str;
                this.f728b = bundle;
                this.f729c = resultReceiver;
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$c$c */
        class C0209c extends Handler {
            public C0209c(Looper looper) {
                super(looper);
            }

            /* renamed from: a */
            public void mo1391a(int i, Object obj, Bundle bundle) {
                Message obtainMessage = obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }

            /* renamed from: a */
            public void mo1390a(int i, Object obj) {
                obtainMessage(i, obj).sendToTarget();
            }

            /* renamed from: a */
            public void mo1389a(int i) {
                mo1390a(i, (Object) null);
            }

            public void handleMessage(Message message) {
                if (C0204c.this.f714q != null) {
                    switch (message.what) {
                        case 1:
                            C0204c.this.f714q.onPlay();
                            return;
                        case 2:
                            C0204c.this.f714q.onPlayFromMediaId((String) message.obj, message.getData());
                            return;
                        case 3:
                            C0204c.this.f714q.onPlayFromSearch((String) message.obj, message.getData());
                            return;
                        case 4:
                            C0204c.this.f714q.onSkipToQueueItem(((Long) message.obj).longValue());
                            return;
                        case 5:
                            C0204c.this.f714q.onPause();
                            return;
                        case 6:
                            C0204c.this.f714q.onStop();
                            return;
                        case 7:
                            C0204c.this.f714q.onSkipToNext();
                            return;
                        case 8:
                            C0204c.this.f714q.onSkipToPrevious();
                            return;
                        case 9:
                            C0204c.this.f714q.onFastForward();
                            return;
                        case 10:
                            C0204c.this.f714q.onRewind();
                            return;
                        case 11:
                            C0204c.this.f714q.onSeekTo(((Long) message.obj).longValue());
                            return;
                        case 12:
                            C0204c.this.f714q.onSetRating((RatingCompat) message.obj);
                            return;
                        case 13:
                            C0204c.this.f714q.onCustomAction((String) message.obj, message.getData());
                            return;
                        case 14:
                            KeyEvent keyEvent = (KeyEvent) message.obj;
                            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                            if (!C0204c.this.f714q.onMediaButtonEvent(intent)) {
                                m834a(keyEvent);
                                return;
                            }
                            return;
                        case 15:
                            C0207a aVar = (C0207a) message.obj;
                            C0204c.this.f714q.onCommand(aVar.f727a, aVar.f728b, aVar.f729c);
                            return;
                        case 16:
                            C0204c.this.m780a(((Integer) message.obj).intValue(), 0);
                            return;
                        case 17:
                            C0204c.this.m785b(((Integer) message.obj).intValue(), 0);
                            return;
                        case 18:
                            C0204c.this.f714q.onPlayFromUri((Uri) message.obj, message.getData());
                            return;
                        default:
                            return;
                    }
                }
            }

            /* renamed from: a */
            private void m834a(KeyEvent keyEvent) {
                boolean z;
                boolean z2;
                boolean z3;
                if (keyEvent != null && keyEvent.getAction() == 0) {
                    long actions = C0204c.this.f717t == null ? 0 : C0204c.this.f717t.getActions();
                    switch (keyEvent.getKeyCode()) {
                        case 79:
                        case 85:
                            if (C0204c.this.f717t == null || C0204c.this.f717t.getState() != 3) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if ((516 & actions) != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if ((actions & 514) != 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z && z3) {
                                C0204c.this.f714q.onPause();
                                return;
                            } else if (!z && z2) {
                                C0204c.this.f714q.onPlay();
                                return;
                            } else {
                                return;
                            }
                        case 86:
                            if ((actions & 1) != 0) {
                                C0204c.this.f714q.onStop();
                                return;
                            }
                            return;
                        case 87:
                            if ((actions & 32) != 0) {
                                C0204c.this.f714q.onSkipToNext();
                                return;
                            }
                            return;
                        case 88:
                            if ((actions & 16) != 0) {
                                C0204c.this.f714q.onSkipToPrevious();
                                return;
                            }
                            return;
                        case 89:
                            if ((actions & 8) != 0) {
                                C0204c.this.f714q.onRewind();
                                return;
                            }
                            return;
                        case 90:
                            if ((actions & 64) != 0) {
                                C0204c.this.f714q.onFastForward();
                                return;
                            }
                            return;
                        case TransportMediator.KEYCODE_MEDIA_PLAY:
                            if ((actions & 4) != 0) {
                                C0204c.this.f714q.onPlay();
                                return;
                            }
                            return;
                        case TransportMediator.KEYCODE_MEDIA_PAUSE:
                            if ((actions & 2) != 0) {
                                C0204c.this.f714q.onPause();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$b */
    static class C0203b implements C0202a {

        /* renamed from: a */
        private final Object f692a;

        /* renamed from: b */
        private final Token f693b = new Token(C0641bv.m3529e(this.f692a));

        /* renamed from: c */
        private PendingIntent f694c;

        public C0203b(Context context, String str) {
            this.f692a = C0641bv.m3510a(context, str);
        }

        public C0203b(Object obj) {
            this.f692a = C0641bv.m3512a(obj);
        }

        /* renamed from: a */
        public void mo1373a(Callback callback, Handler handler) {
            C0641bv.m3518a(this.f692a, callback == null ? null : callback.f684a, handler);
        }

        /* renamed from: a */
        public void mo1368a(int i) {
            C0641bv.m3513a(this.f692a, i);
        }

        /* renamed from: b */
        public void mo1381b(int i) {
            C0641bv.m3523b(this.f692a, i);
        }

        /* renamed from: a */
        public void mo1372a(VolumeProviderCompat volumeProviderCompat) {
            C0641bv.m3517a(this.f692a, volumeProviderCompat.getVolumeProvider());
        }

        /* renamed from: a */
        public void mo1378a(boolean z) {
            C0641bv.m3521a(this.f692a, z);
        }

        /* renamed from: a */
        public boolean mo1379a() {
            return C0641bv.m3527c(this.f692a);
        }

        /* renamed from: a */
        public void mo1376a(String str, Bundle bundle) {
            C0641bv.m3519a(this.f692a, str, bundle);
        }

        /* renamed from: b */
        public void mo1380b() {
            C0641bv.m3528d(this.f692a);
        }

        /* renamed from: c */
        public Token mo1383c() {
            return this.f693b;
        }

        /* renamed from: a */
        public void mo1374a(PlaybackStateCompat playbackStateCompat) {
            C0641bv.m3525b(this.f692a, playbackStateCompat == null ? null : playbackStateCompat.getPlaybackState());
        }

        /* renamed from: a */
        public void mo1371a(MediaMetadataCompat mediaMetadataCompat) {
            C0641bv.m3526c(this.f692a, mediaMetadataCompat == null ? null : mediaMetadataCompat.getMediaMetadata());
        }

        /* renamed from: a */
        public void mo1369a(PendingIntent pendingIntent) {
            C0641bv.m3514a(this.f692a, pendingIntent);
        }

        /* renamed from: b */
        public void mo1382b(PendingIntent pendingIntent) {
            this.f694c = pendingIntent;
            C0641bv.m3524b(this.f692a, pendingIntent);
        }

        /* renamed from: a */
        public void mo1377a(List<QueueItem> list) {
            ArrayList arrayList = null;
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                for (QueueItem queueItem : list) {
                    arrayList2.add(queueItem.getQueueItem());
                }
                arrayList = arrayList2;
            }
            C0641bv.m3520a(this.f692a, (List<Object>) arrayList);
        }

        /* renamed from: a */
        public void mo1375a(CharSequence charSequence) {
            C0641bv.m3516a(this.f692a, charSequence);
        }

        /* renamed from: c */
        public void mo1384c(int i) {
            if (Build.VERSION.SDK_INT >= 22) {
                C0645bw.m3548a(this.f692a, i);
            }
        }

        /* renamed from: a */
        public void mo1370a(Bundle bundle) {
            C0641bv.m3515a(this.f692a, bundle);
        }

        /* renamed from: d */
        public Object mo1385d() {
            return this.f692a;
        }

        /* renamed from: e */
        public Object mo1386e() {
            return null;
        }
    }
}
