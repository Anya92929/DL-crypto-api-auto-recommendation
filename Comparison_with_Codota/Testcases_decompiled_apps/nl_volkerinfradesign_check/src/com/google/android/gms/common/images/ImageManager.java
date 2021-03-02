package com.google.android.gms.common.images;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.p001v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.images.zza;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.internal.zzmd;
import com.google.android.gms.internal.zzne;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.time.DateUtils;

public final class ImageManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Object f2859a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static HashSet<Uri> f2860b = new HashSet<>();

    /* renamed from: c */
    private static ImageManager f2861c;

    /* renamed from: d */
    private static ImageManager f2862d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Context f2863e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Handler f2864f = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final ExecutorService f2865g = Executors.newFixedThreadPool(4);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C0722b f2866h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final zzmd f2867i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final Map<zza, ImageReceiver> f2868j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final Map<Uri, ImageReceiver> f2869k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final Map<Uri, Long> f2870l;

    @KeepName
    final class ImageReceiver extends ResultReceiver {

        /* renamed from: b */
        private final Uri f2872b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final ArrayList<zza> f2873c = new ArrayList<>();

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.f2872b = uri;
        }

        /* renamed from: a */
        public void mo5336a() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.f2872b);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.f2863e.sendBroadcast(intent);
        }

        /* renamed from: a */
        public void mo5337a(zza zza) {
            zzb.zzcD("ImageReceiver.addImageRequest() must be called in the main thread");
            this.f2873c.add(zza);
        }

        /* renamed from: b */
        public void mo5338b(zza zza) {
            zzb.zzcD("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.f2873c.remove(zza);
        }

        public void onReceiveResult(int i, Bundle bundle) {
            ImageManager.this.f2865g.execute(new C0723c(this.f2872b, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    @TargetApi(11)
    /* renamed from: com.google.android.gms.common.images.ImageManager$a */
    static final class C0721a {
        /* renamed from: a */
        static int m3877a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$b */
    static final class C0722b extends LruCache<zza.C0727a, Bitmap> {
        public C0722b(Context context) {
            super(m3878a(context));
        }

        @TargetApi(11)
        /* renamed from: a */
        private static int m3878a(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (int) (((float) (((!((context.getApplicationInfo().flags & 1048576) != 0) || !zzne.zzsd()) ? activityManager.getMemoryClass() : C0721a.m3877a(activityManager)) * 1048576)) * 0.33f);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(zza.C0727a aVar, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void entryRemoved(boolean z, zza.C0727a aVar, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, aVar, bitmap, bitmap2);
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$c */
    final class C0723c implements Runnable {

        /* renamed from: b */
        private final Uri f2875b;

        /* renamed from: c */
        private final ParcelFileDescriptor f2876c;

        public C0723c(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.f2875b = uri;
            this.f2876c = parcelFileDescriptor;
        }

        public void run() {
            zzb.zzcE("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.f2876c != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.f2876c.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.f2875b, e);
                    z = true;
                }
                try {
                    this.f2876c.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.f2864f.post(new C0726f(this.f2875b, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.f2875b);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$d */
    final class C0724d implements Runnable {

        /* renamed from: b */
        private final zza f2878b;

        public C0724d(zza zza) {
            this.f2878b = zza;
        }

        public void run() {
            zzb.zzcD("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f2868j.get(this.f2878b);
            if (imageReceiver != null) {
                ImageManager.this.f2868j.remove(this.f2878b);
                imageReceiver.mo5338b(this.f2878b);
            }
            zza.C0727a aVar = this.f2878b.f2891a;
            if (aVar.f2895a == null) {
                this.f2878b.mo5366a(ImageManager.this.f2863e, ImageManager.this.f2867i, true);
                return;
            }
            Bitmap a = ImageManager.this.m3861a(aVar);
            if (a != null) {
                this.f2878b.mo5364a(ImageManager.this.f2863e, a, true);
                return;
            }
            Long l = (Long) ImageManager.this.f2870l.get(aVar.f2895a);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < DateUtils.MILLIS_PER_HOUR) {
                    this.f2878b.mo5366a(ImageManager.this.f2863e, ImageManager.this.f2867i, true);
                    return;
                }
                ImageManager.this.f2870l.remove(aVar.f2895a);
            }
            this.f2878b.mo5365a(ImageManager.this.f2863e, ImageManager.this.f2867i);
            ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.f2869k.get(aVar.f2895a);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageReceiver(aVar.f2895a);
                ImageManager.this.f2869k.put(aVar.f2895a, imageReceiver2);
            }
            imageReceiver2.mo5337a(this.f2878b);
            if (!(this.f2878b instanceof zza.zzc)) {
                ImageManager.this.f2868j.put(this.f2878b, imageReceiver2);
            }
            synchronized (ImageManager.f2859a) {
                if (!ImageManager.f2860b.contains(aVar.f2895a)) {
                    ImageManager.f2860b.add(aVar.f2895a);
                    imageReceiver2.mo5336a();
                }
            }
        }
    }

    @TargetApi(14)
    /* renamed from: com.google.android.gms.common.images.ImageManager$e */
    static final class C0725e implements ComponentCallbacks2 {

        /* renamed from: a */
        private final C0722b f2879a;

        public C0725e(C0722b bVar) {
            this.f2879a = bVar;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
            this.f2879a.evictAll();
        }

        public void onTrimMemory(int i) {
            if (i >= 60) {
                this.f2879a.evictAll();
            } else if (i >= 20) {
                this.f2879a.trimToSize(this.f2879a.size() / 2);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$f */
    final class C0726f implements Runnable {

        /* renamed from: b */
        private final Uri f2881b;

        /* renamed from: c */
        private final Bitmap f2882c;

        /* renamed from: d */
        private final CountDownLatch f2883d;

        /* renamed from: e */
        private boolean f2884e;

        public C0726f(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.f2881b = uri;
            this.f2882c = bitmap;
            this.f2884e = z;
            this.f2883d = countDownLatch;
        }

        /* renamed from: a */
        private void m3881a(ImageReceiver imageReceiver, boolean z) {
            ArrayList a = imageReceiver.f2873c;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                zza zza = (zza) a.get(i);
                if (z) {
                    zza.mo5364a(ImageManager.this.f2863e, this.f2882c, false);
                } else {
                    ImageManager.this.f2870l.put(this.f2881b, Long.valueOf(SystemClock.elapsedRealtime()));
                    zza.mo5366a(ImageManager.this.f2863e, ImageManager.this.f2867i, false);
                }
                if (!(zza instanceof zza.zzc)) {
                    ImageManager.this.f2868j.remove(zza);
                }
            }
        }

        public void run() {
            zzb.zzcD("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.f2882c != null;
            if (ImageManager.this.f2866h != null) {
                if (this.f2884e) {
                    ImageManager.this.f2866h.evictAll();
                    System.gc();
                    this.f2884e = false;
                    ImageManager.this.f2864f.post(this);
                    return;
                } else if (z) {
                    ImageManager.this.f2866h.put(new zza.C0727a(this.f2881b), this.f2882c);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f2869k.remove(this.f2881b);
            if (imageReceiver != null) {
                m3881a(imageReceiver, z);
            }
            this.f2883d.countDown();
            synchronized (ImageManager.f2859a) {
                ImageManager.f2860b.remove(this.f2881b);
            }
        }
    }

    private ImageManager(Context context, boolean z) {
        this.f2863e = context.getApplicationContext();
        if (z) {
            this.f2866h = new C0722b(this.f2863e);
            if (zzne.zzsg()) {
                m3867c();
            }
        } else {
            this.f2866h = null;
        }
        this.f2867i = new zzmd();
        this.f2868j = new HashMap();
        this.f2869k = new HashMap();
        this.f2870l = new HashMap();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Bitmap m3861a(zza.C0727a aVar) {
        if (this.f2866h == null) {
            return null;
        }
        return (Bitmap) this.f2866h.get(aVar);
    }

    @TargetApi(14)
    /* renamed from: c */
    private void m3867c() {
        this.f2863e.registerComponentCallbacks(new C0725e(this.f2866h));
    }

    public static ImageManager create(Context context) {
        return zzc(context, false);
    }

    public static ImageManager zzc(Context context, boolean z) {
        if (z) {
            if (f2862d == null) {
                f2862d = new ImageManager(context, true);
            }
            return f2862d;
        }
        if (f2861c == null) {
            f2861c = new ImageManager(context, false);
        }
        return f2861c;
    }

    public void loadImage(ImageView imageView, int i) {
        zza(new zza.zzb(imageView, i));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zza(new zza.zzb(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int i) {
        zza.zzb zzb = new zza.zzb(imageView, uri);
        zzb.zzbM(i);
        zza(zzb);
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zza(new zza.zzc(onImageLoadedListener, uri));
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zza.zzc zzc = new zza.zzc(onImageLoadedListener, uri);
        zzc.zzbM(i);
        zza(zzc);
    }

    public void zza(zza zza) {
        zzb.zzcD("ImageManager.loadImage() must be called in the main thread");
        new C0724d(zza).run();
    }
}
