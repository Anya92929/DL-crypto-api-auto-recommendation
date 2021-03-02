package android.support.p001v4.media;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p001v4.media.IMediaBrowserServiceCompat;
import android.support.p001v4.media.MediaBrowserCompat;
import android.support.p001v4.media.session.MediaSessionCompat;
import android.support.p001v4.p003os.ResultReceiver;
import android.support.p001v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;

/* renamed from: android.support.v4.media.MediaBrowserServiceCompat */
public abstract class MediaBrowserServiceCompat extends Service {
    public static final String KEY_MEDIA_ITEM = "media_item";
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserServiceCompat";

    /* renamed from: a */
    MediaSessionCompat.Token f563a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final ArrayMap<IBinder, C0168a> f564b = new ArrayMap<>();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Handler f565c = new Handler();

    /* renamed from: d */
    private C0169b f566d;

    @Nullable
    public abstract BrowserRoot onGetRoot(@NonNull String str, int i, @Nullable Bundle bundle);

    public abstract void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result);

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$a */
    class C0168a {

        /* renamed from: a */
        String f582a;

        /* renamed from: b */
        Bundle f583b;

        /* renamed from: c */
        IMediaBrowserServiceCompatCallbacks f584c;

        /* renamed from: d */
        BrowserRoot f585d;

        /* renamed from: e */
        HashSet<String> f586e;

        private C0168a() {
            this.f586e = new HashSet<>();
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$Result */
    public class Result<T> {

        /* renamed from: a */
        private Object f578a;

        /* renamed from: b */
        private boolean f579b;

        /* renamed from: c */
        private boolean f580c;

        Result(Object obj) {
            this.f578a = obj;
        }

        public void sendResult(T t) {
            if (this.f580c) {
                throw new IllegalStateException("sendResult() called twice for: " + this.f578a);
            }
            this.f580c = true;
            mo1024a(t);
        }

        public void detach() {
            if (this.f579b) {
                throw new IllegalStateException("detach() called when detach() had already been called for: " + this.f578a);
            } else if (this.f580c) {
                throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.f578a);
            } else {
                this.f579b = true;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo1029a() {
            return this.f579b || this.f580c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1024a(T t) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$b */
    class C0169b extends IMediaBrowserServiceCompat.Stub {
        private C0169b() {
        }

        public void connect(String str, Bundle bundle, IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) {
            final int callingUid = Binder.getCallingUid();
            if (!MediaBrowserServiceCompat.this.m603a(str, callingUid)) {
                throw new IllegalArgumentException("Package/uid mismatch: uid=" + callingUid + " package=" + str);
            }
            final IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks2 = iMediaBrowserServiceCompatCallbacks;
            final String str2 = str;
            final Bundle bundle2 = bundle;
            MediaBrowserServiceCompat.this.f565c.post(new Runnable() {
                public void run() {
                    IBinder asBinder = iMediaBrowserServiceCompatCallbacks2.asBinder();
                    MediaBrowserServiceCompat.this.f564b.remove(asBinder);
                    C0168a aVar = new C0168a();
                    aVar.f582a = str2;
                    aVar.f583b = bundle2;
                    aVar.f584c = iMediaBrowserServiceCompatCallbacks2;
                    aVar.f585d = MediaBrowserServiceCompat.this.onGetRoot(str2, callingUid, bundle2);
                    if (aVar.f585d == null) {
                        Log.i("MediaBrowserServiceCompat", "No root for client " + str2 + " from service " + getClass().getName());
                        try {
                            iMediaBrowserServiceCompatCallbacks2.onConnectFailed();
                        } catch (RemoteException e) {
                            Log.w("MediaBrowserServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + str2);
                        }
                    } else {
                        try {
                            MediaBrowserServiceCompat.this.f564b.put(asBinder, aVar);
                            if (MediaBrowserServiceCompat.this.f563a != null) {
                                iMediaBrowserServiceCompatCallbacks2.onConnect(aVar.f585d.getRootId(), MediaBrowserServiceCompat.this.f563a, aVar.f585d.getExtras());
                            }
                        } catch (RemoteException e2) {
                            Log.w("MediaBrowserServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + str2);
                            MediaBrowserServiceCompat.this.f564b.remove(asBinder);
                        }
                    }
                }
            });
        }

        public void disconnect(final IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) {
            MediaBrowserServiceCompat.this.f565c.post(new Runnable() {
                public void run() {
                    if (((C0168a) MediaBrowserServiceCompat.this.f564b.remove(iMediaBrowserServiceCompatCallbacks.asBinder())) != null) {
                    }
                }
            });
        }

        public void addSubscription(final String str, final IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) {
            MediaBrowserServiceCompat.this.f565c.post(new Runnable() {
                public void run() {
                    C0168a aVar = (C0168a) MediaBrowserServiceCompat.this.f564b.get(iMediaBrowserServiceCompatCallbacks.asBinder());
                    if (aVar == null) {
                        Log.w("MediaBrowserServiceCompat", "addSubscription for callback that isn't registered id=" + str);
                    } else {
                        MediaBrowserServiceCompat.this.m600a(str, aVar);
                    }
                }
            });
        }

        public void removeSubscription(final String str, final IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) {
            MediaBrowserServiceCompat.this.f565c.post(new Runnable() {
                public void run() {
                    C0168a aVar = (C0168a) MediaBrowserServiceCompat.this.f564b.get(iMediaBrowserServiceCompatCallbacks.asBinder());
                    if (aVar == null) {
                        Log.w("MediaBrowserServiceCompat", "removeSubscription for callback that isn't registered id=" + str);
                    } else if (!aVar.f586e.remove(str)) {
                        Log.w("MediaBrowserServiceCompat", "removeSubscription called for " + str + " which is not subscribed");
                    }
                }
            });
        }

        public void getMediaItem(final String str, final ResultReceiver resultReceiver) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.f565c.post(new Runnable() {
                    public void run() {
                        MediaBrowserServiceCompat.this.m601a(str, resultReceiver);
                    }
                });
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        this.f566d = new C0169b();
    }

    public IBinder onBind(Intent intent) {
        if (SERVICE_INTERFACE.equals(intent.getAction())) {
            return this.f566d;
        }
        return null;
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public void onLoadItem(String str, Result<MediaBrowserCompat.MediaItem> result) {
        result.sendResult(null);
    }

    public void setSessionToken(final MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        } else if (this.f563a != null) {
            throw new IllegalStateException("The session token has already been set.");
        } else {
            this.f563a = token;
            this.f565c.post(new Runnable() {
                public void run() {
                    for (IBinder iBinder : MediaBrowserServiceCompat.this.f564b.keySet()) {
                        C0168a aVar = (C0168a) MediaBrowserServiceCompat.this.f564b.get(iBinder);
                        try {
                            aVar.f584c.onConnect(aVar.f585d.getRootId(), token, aVar.f585d.getExtras());
                        } catch (RemoteException e) {
                            Log.w("MediaBrowserServiceCompat", "Connection for " + aVar.f582a + " is no longer valid.");
                            MediaBrowserServiceCompat.this.f564b.remove(iBinder);
                        }
                    }
                }
            });
        }
    }

    @Nullable
    public MediaSessionCompat.Token getSessionToken() {
        return this.f563a;
    }

    public void notifyChildrenChanged(@NonNull final String str) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        this.f565c.post(new Runnable() {
            public void run() {
                for (IBinder iBinder : MediaBrowserServiceCompat.this.f564b.keySet()) {
                    C0168a aVar = (C0168a) MediaBrowserServiceCompat.this.f564b.get(iBinder);
                    if (aVar.f586e.contains(str)) {
                        MediaBrowserServiceCompat.this.m606b(str, aVar);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m603a(String str, int i) {
        if (str == null) {
            return false;
        }
        for (String equals : getPackageManager().getPackagesForUid(i)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m600a(String str, C0168a aVar) {
        aVar.f586e.add(str);
        m606b(str, aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m606b(final String str, final C0168a aVar) {
        C01663 r0 = new Result<List<MediaBrowserCompat.MediaItem>>(str) {
            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo1024a(List<MediaBrowserCompat.MediaItem> list) {
                if (list == null) {
                    throw new IllegalStateException("onLoadChildren sent null list for id " + str);
                } else if (MediaBrowserServiceCompat.this.f564b.get(aVar.f584c.asBinder()) == aVar) {
                    try {
                        aVar.f584c.onLoadChildren(str, list);
                    } catch (RemoteException e) {
                        Log.w("MediaBrowserServiceCompat", "Calling onLoadChildren() failed for id=" + str + " package=" + aVar.f582a);
                    }
                }
            }
        };
        onLoadChildren(str, r0);
        if (!r0.mo1029a()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + aVar.f582a + " id=" + str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m601a(String str, final ResultReceiver resultReceiver) {
        C01674 r0 = new Result<MediaBrowserCompat.MediaItem>(str) {
            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public void mo1024a(MediaBrowserCompat.MediaItem mediaItem) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM, mediaItem);
                resultReceiver.send(0, bundle);
            }
        };
        onLoadItem(str, r0);
        if (!r0.mo1029a()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$BrowserRoot */
    public static final class BrowserRoot {

        /* renamed from: a */
        private final String f576a;

        /* renamed from: b */
        private final Bundle f577b;

        public BrowserRoot(@NonNull String str, @Nullable Bundle bundle) {
            if (str == null) {
                throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
            }
            this.f576a = str;
            this.f577b = bundle;
        }

        public String getRootId() {
            return this.f576a;
        }

        public Bundle getExtras() {
            return this.f577b;
        }
    }
}
