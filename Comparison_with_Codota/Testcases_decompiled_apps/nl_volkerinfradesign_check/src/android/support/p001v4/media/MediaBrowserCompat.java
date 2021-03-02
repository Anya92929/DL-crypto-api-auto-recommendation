package android.support.p001v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p001v4.media.IMediaBrowserServiceCompat;
import android.support.p001v4.media.IMediaBrowserServiceCompatCallbacks;
import android.support.p001v4.media.session.MediaSessionCompat;
import android.support.p001v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* renamed from: android.support.v4.media.MediaBrowserCompat */
public final class MediaBrowserCompat {

    /* renamed from: a */
    private final C0154a f521a;

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        this.f521a = new C0154a(context, componentName, connectionCallback, bundle);
    }

    public void connect() {
        this.f521a.mo994a();
    }

    public void disconnect() {
        this.f521a.mo998b();
    }

    public boolean isConnected() {
        return this.f521a.mo999c();
    }

    @NonNull
    public ComponentName getServiceComponent() {
        return this.f521a.mo1000d();
    }

    @NonNull
    public String getRoot() {
        return this.f521a.mo1001e();
    }

    @Nullable
    public Bundle getExtras() {
        return this.f521a.mo1002f();
    }

    @NonNull
    public MediaSessionCompat.Token getSessionToken() {
        return this.f521a.mo1003g();
    }

    public void subscribe(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
        this.f521a.mo997a(str, subscriptionCallback);
    }

    public void unsubscribe(@NonNull String str) {
        this.f521a.mo995a(str);
    }

    public void getItem(@NonNull String str, @NonNull ItemCallback itemCallback) {
        this.f521a.mo996a(str, itemCallback);
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() {
            /* renamed from: a */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            /* renamed from: a */
            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        };
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;

        /* renamed from: a */
        private final int f522a;

        /* renamed from: b */
        private final MediaDescriptionCompat f523b;

        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem$Flags */
        public @interface Flags {
        }

        public MediaItem(@NonNull MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            } else if (TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            } else {
                this.f522a = i;
                this.f523b = mediaDescriptionCompat;
            }
        }

        private MediaItem(Parcel parcel) {
            this.f522a = parcel.readInt();
            this.f523b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f522a);
            this.f523b.writeToParcel(parcel, i);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MediaItem{");
            sb.append("mFlags=").append(this.f522a);
            sb.append(", mDescription=").append(this.f523b);
            sb.append('}');
            return sb.toString();
        }

        public int getFlags() {
            return this.f522a;
        }

        public boolean isBrowsable() {
            return (this.f522a & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.f522a & 2) != 0;
        }

        @NonNull
        public MediaDescriptionCompat getDescription() {
            return this.f523b;
        }

        @NonNull
        public String getMediaId() {
            return this.f523b.getMediaId();
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ConnectionCallback */
    public static class ConnectionCallback {
        public void onConnected() {
        }

        public void onConnectionSuspended() {
        }

        public void onConnectionFailed() {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$SubscriptionCallback */
    public static abstract class SubscriptionCallback {
        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaItem> list) {
        }

        public void onError(@NonNull String str) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ItemCallback */
    public static abstract class ItemCallback {
        public void onItemLoaded(MediaItem mediaItem) {
        }

        public void onError(@NonNull String str) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$a */
    static class C0154a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Context f524a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final ComponentName f525b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final ConnectionCallback f526c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final Bundle f527d;

        /* renamed from: e */
        private final Handler f528e = new Handler();
        /* access modifiers changed from: private */

        /* renamed from: f */
        public final ArrayMap<String, C0163c> f529f = new ArrayMap<>();
        /* access modifiers changed from: private */

        /* renamed from: g */
        public int f530g = 0;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public C0161a f531h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public IMediaBrowserServiceCompat f532i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public IMediaBrowserServiceCompatCallbacks f533j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public String f534k;
        /* access modifiers changed from: private */

        /* renamed from: l */
        public MediaSessionCompat.Token f535l;
        /* access modifiers changed from: private */

        /* renamed from: m */
        public Bundle f536m;

        public C0154a(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            } else if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            } else if (connectionCallback == null) {
                throw new IllegalArgumentException("connection callback must not be null");
            } else {
                this.f524a = context;
                this.f525b = componentName;
                this.f526c = connectionCallback;
                this.f527d = bundle;
            }
        }

        /* renamed from: a */
        public void mo994a() {
            if (this.f530g != 0) {
                throw new IllegalStateException("connect() called while not disconnected (state=" + m572b(this.f530g) + ")");
            } else if (this.f532i != null) {
                throw new RuntimeException("mServiceBinder should be null. Instead it is " + this.f532i);
            } else if (this.f533j != null) {
                throw new RuntimeException("mServiceCallbacks should be null. Instead it is " + this.f533j);
            } else {
                this.f530g = 1;
                Intent intent = new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE);
                intent.setComponent(this.f525b);
                final C0161a aVar = new C0161a();
                this.f531h = aVar;
                boolean z = false;
                try {
                    z = this.f524a.bindService(intent, this.f531h, 1);
                } catch (Exception e) {
                    Log.e("MediaBrowserCompat", "Failed binding to service " + this.f525b);
                }
                if (!z) {
                    this.f528e.post(new Runnable() {
                        public void run() {
                            if (aVar == C0154a.this.f531h) {
                                C0154a.this.m581h();
                                C0154a.this.f526c.onConnectionFailed();
                            }
                        }
                    });
                }
            }
        }

        /* renamed from: b */
        public void mo998b() {
            if (this.f533j != null) {
                try {
                    this.f532i.disconnect(this.f533j);
                } catch (RemoteException e) {
                    Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.f525b);
                }
            }
            m581h();
        }

        /* access modifiers changed from: private */
        /* renamed from: h */
        public void m581h() {
            if (this.f531h != null) {
                this.f524a.unbindService(this.f531h);
            }
            this.f530g = 0;
            this.f531h = null;
            this.f532i = null;
            this.f533j = null;
            this.f534k = null;
            this.f535l = null;
        }

        /* renamed from: c */
        public boolean mo999c() {
            return this.f530g == 2;
        }

        @NonNull
        /* renamed from: d */
        public ComponentName mo1000d() {
            if (mo999c()) {
                return this.f525b;
            }
            throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.f530g + ")");
        }

        @NonNull
        /* renamed from: e */
        public String mo1001e() {
            if (mo999c()) {
                return this.f534k;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + m572b(this.f530g) + ")");
        }

        @Nullable
        /* renamed from: f */
        public Bundle mo1002f() {
            if (mo999c()) {
                return this.f536m;
            }
            throw new IllegalStateException("getExtras() called while not connected (state=" + m572b(this.f530g) + ")");
        }

        @NonNull
        /* renamed from: g */
        public MediaSessionCompat.Token mo1003g() {
            if (mo999c()) {
                return this.f535l;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.f530g + ")");
        }

        /* renamed from: a */
        public void mo997a(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
            if (str == null) {
                throw new IllegalArgumentException("parentId is null");
            } else if (subscriptionCallback == null) {
                throw new IllegalArgumentException("callback is null");
            } else {
                C0163c cVar = this.f529f.get(str);
                if (cVar == null) {
                    cVar = new C0163c(str);
                    this.f529f.put(str, cVar);
                }
                cVar.f559b = subscriptionCallback;
                if (this.f530g == 2) {
                    try {
                        this.f532i.addSubscription(str, this.f533j);
                    } catch (RemoteException e) {
                        Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + str);
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo995a(@NonNull String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("parentId is empty.");
            }
            C0163c remove = this.f529f.remove(str);
            if (this.f530g == 2 && remove != null) {
                try {
                    this.f532i.removeSubscription(str, this.f533j);
                } catch (RemoteException e) {
                    Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + str);
                }
            }
        }

        /* renamed from: a */
        public void mo996a(@NonNull final String str, @NonNull final ItemCallback itemCallback) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("mediaId is empty.");
            } else if (itemCallback == null) {
                throw new IllegalArgumentException("cb is null.");
            } else if (this.f530g != 2) {
                Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
                this.f528e.post(new Runnable() {
                    public void run() {
                        itemCallback.onError(str);
                    }
                });
            } else {
                try {
                    this.f532i.getMediaItem(str, new MediaBrowserCompat$MediaBrowserImplBase$3(this, this.f528e, itemCallback, str));
                } catch (RemoteException e) {
                    Log.i("MediaBrowserCompat", "Remote error getting media item.");
                    this.f528e.post(new Runnable() {
                        public void run() {
                            itemCallback.onError(str);
                        }
                    });
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public static String m572b(int i) {
            switch (i) {
                case 0:
                    return "CONNECT_STATE_DISCONNECTED";
                case 1:
                    return "CONNECT_STATE_CONNECTING";
                case 2:
                    return "CONNECT_STATE_CONNECTED";
                case 3:
                    return "CONNECT_STATE_SUSPENDED";
                default:
                    return "UNKNOWN/" + i;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public final void m566a(IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks, String str, MediaSessionCompat.Token token, Bundle bundle) {
            final IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks2 = iMediaBrowserServiceCompatCallbacks;
            final String str2 = str;
            final MediaSessionCompat.Token token2 = token;
            final Bundle bundle2 = bundle;
            this.f528e.post(new Runnable() {
                public void run() {
                    if (C0154a.this.m570a(iMediaBrowserServiceCompatCallbacks2, "onConnect")) {
                        if (C0154a.this.f530g != 1) {
                            Log.w("MediaBrowserCompat", "onConnect from service while mState=" + C0154a.m572b(C0154a.this.f530g) + "... ignoring");
                            return;
                        }
                        String unused = C0154a.this.f534k = str2;
                        MediaSessionCompat.Token unused2 = C0154a.this.f535l = token2;
                        Bundle unused3 = C0154a.this.f536m = bundle2;
                        int unused4 = C0154a.this.f530g = 2;
                        C0154a.this.f526c.onConnected();
                        for (String str : C0154a.this.f529f.keySet()) {
                            try {
                                C0154a.this.f532i.addSubscription(str, C0154a.this.f533j);
                            } catch (RemoteException e) {
                                Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + str);
                            }
                        }
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public final void m565a(final IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) {
            this.f528e.post(new Runnable() {
                public void run() {
                    Log.e("MediaBrowserCompat", "onConnectFailed for " + C0154a.this.f525b);
                    if (C0154a.this.m570a(iMediaBrowserServiceCompatCallbacks, "onConnectFailed")) {
                        if (C0154a.this.f530g != 1) {
                            Log.w("MediaBrowserCompat", "onConnect from service while mState=" + C0154a.m572b(C0154a.this.f530g) + "... ignoring");
                            return;
                        }
                        C0154a.this.m581h();
                        C0154a.this.f526c.onConnectionFailed();
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public final void m567a(final IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks, final String str, final List list) {
            this.f528e.post(new Runnable() {
                public void run() {
                    List list;
                    if (C0154a.this.m570a(iMediaBrowserServiceCompatCallbacks, "onLoadChildren")) {
                        List list2 = list;
                        if (list2 == null) {
                            list = Collections.emptyList();
                        } else {
                            list = list2;
                        }
                        C0163c cVar = (C0163c) C0154a.this.f529f.get(str);
                        if (cVar != null) {
                            cVar.f559b.onChildrenLoaded(str, list);
                        }
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public boolean m570a(IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks, String str) {
            if (this.f533j == iMediaBrowserServiceCompatCallbacks) {
                return true;
            }
            if (this.f530g != 0) {
                Log.i("MediaBrowserCompat", str + " for " + this.f525b + " with mServiceConnection=" + this.f533j + " this=" + this);
            }
            return false;
        }

        /* access modifiers changed from: private */
        /* renamed from: i */
        public C0162b m582i() {
            return new C0162b(this);
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$a$a */
        class C0161a implements ServiceConnection {
            private C0161a() {
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (m596a("onServiceConnected")) {
                    IMediaBrowserServiceCompat unused = C0154a.this.f532i = IMediaBrowserServiceCompat.Stub.asInterface(iBinder);
                    IMediaBrowserServiceCompatCallbacks unused2 = C0154a.this.f533j = C0154a.this.m582i();
                    int unused3 = C0154a.this.f530g = 1;
                    try {
                        C0154a.this.f532i.connect(C0154a.this.f524a.getPackageName(), C0154a.this.f527d, C0154a.this.f533j);
                    } catch (RemoteException e) {
                        Log.w("MediaBrowserCompat", "RemoteException during connect for " + C0154a.this.f525b);
                    }
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                if (m596a("onServiceDisconnected")) {
                    IMediaBrowserServiceCompat unused = C0154a.this.f532i = null;
                    IMediaBrowserServiceCompatCallbacks unused2 = C0154a.this.f533j = null;
                    int unused3 = C0154a.this.f530g = 3;
                    C0154a.this.f526c.onConnectionSuspended();
                }
            }

            /* renamed from: a */
            private boolean m596a(String str) {
                if (C0154a.this.f531h == this) {
                    return true;
                }
                if (C0154a.this.f530g != 0) {
                    Log.i("MediaBrowserCompat", str + " for " + C0154a.this.f525b + " with mServiceConnection=" + C0154a.this.f531h + " this=" + this);
                }
                return false;
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$a$b */
        static class C0162b extends IMediaBrowserServiceCompatCallbacks.Stub {

            /* renamed from: a */
            private WeakReference<C0154a> f557a;

            public C0162b(C0154a aVar) {
                this.f557a = new WeakReference<>(aVar);
            }

            public void onConnect(String str, MediaSessionCompat.Token token, Bundle bundle) {
                C0154a aVar = (C0154a) this.f557a.get();
                if (aVar != null) {
                    aVar.m566a((IMediaBrowserServiceCompatCallbacks) this, str, token, bundle);
                }
            }

            public void onConnectFailed() {
                C0154a aVar = (C0154a) this.f557a.get();
                if (aVar != null) {
                    aVar.m565a((IMediaBrowserServiceCompatCallbacks) this);
                }
            }

            public void onLoadChildren(String str, List list) {
                C0154a aVar = (C0154a) this.f557a.get();
                if (aVar != null) {
                    aVar.m567a((IMediaBrowserServiceCompatCallbacks) this, str, list);
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$a$c */
        static class C0163c {

            /* renamed from: a */
            final String f558a;

            /* renamed from: b */
            SubscriptionCallback f559b;

            C0163c(String str) {
                this.f558a = str;
            }
        }
    }
}
