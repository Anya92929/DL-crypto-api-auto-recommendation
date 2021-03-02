package com.google.android.gms.common.images;

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
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.images.C0308a;
import com.google.android.gms.common.internal.C0313a;
import com.google.android.gms.internal.C1356iz;
import com.google.android.gms.internal.C1360ja;
import com.google.android.gms.internal.C1394kc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    /* access modifiers changed from: private */

    /* renamed from: Kl */
    public static final Object f701Kl = new Object();
    /* access modifiers changed from: private */

    /* renamed from: Km */
    public static HashSet<Uri> f702Km = new HashSet<>();

    /* renamed from: Kn */
    private static ImageManager f703Kn;

    /* renamed from: Ko */
    private static ImageManager f704Ko;
    /* access modifiers changed from: private */

    /* renamed from: Kp */
    public final ExecutorService f705Kp = Executors.newFixedThreadPool(4);
    /* access modifiers changed from: private */

    /* renamed from: Kq */
    public final C0303b f706Kq;
    /* access modifiers changed from: private */

    /* renamed from: Kr */
    public final C1356iz f707Kr;
    /* access modifiers changed from: private */

    /* renamed from: Ks */
    public final Map<C0308a, ImageReceiver> f708Ks;
    /* access modifiers changed from: private */

    /* renamed from: Kt */
    public final Map<Uri, ImageReceiver> f709Kt;
    /* access modifiers changed from: private */

    /* renamed from: Ku */
    public final Map<Uri, Long> f710Ku;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper());

    private final class ImageReceiver extends ResultReceiver {
        /* access modifiers changed from: private */

        /* renamed from: Kv */
        public final ArrayList<C0308a> f711Kv = new ArrayList<>();
        private final Uri mUri;

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        /* renamed from: b */
        public void mo4365b(C0308a aVar) {
            C0313a.m680aT("ImageReceiver.addImageRequest() must be called in the main thread");
            this.f711Kv.add(aVar);
        }

        /* renamed from: c */
        public void mo4366c(C0308a aVar) {
            C0313a.m680aT("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.f711Kv.remove(aVar);
        }

        /* renamed from: gK */
        public void mo4367gK() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }

        public void onReceiveResult(int resultCode, Bundle resultData) {
            ImageManager.this.f705Kp.execute(new C0304c(this.mUri, (ParcelFileDescriptor) resultData.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$a */
    private static final class C0302a {
        /* renamed from: a */
        static int m655a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$b */
    private static final class C0303b extends C1360ja<C0308a.C0309a, Bitmap> {
        public C0303b(Context context) {
            super(m656I(context));
        }

        /* renamed from: I */
        private static int m656I(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (int) (((float) (((!((context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0) || !C1394kc.m5238hB()) ? activityManager.getMemoryClass() : C0302a.m655a(activityManager)) * AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START)) * 0.33f);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(C0308a.C0309a aVar, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void entryRemoved(boolean z, C0308a.C0309a aVar, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, aVar, bitmap, bitmap2);
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$c */
    private final class C0304c implements Runnable {

        /* renamed from: Kx */
        private final ParcelFileDescriptor f714Kx;
        private final Uri mUri;

        public C0304c(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.f714Kx = parcelFileDescriptor;
        }

        public void run() {
            C0313a.m681aU("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.f714Kx != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.f714Kx.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.f714Kx.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(new C0307f(this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$d */
    private final class C0305d implements Runnable {

        /* renamed from: Ky */
        private final C0308a f716Ky;

        public C0305d(C0308a aVar) {
            this.f716Ky = aVar;
        }

        public void run() {
            C0313a.m680aT("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f708Ks.get(this.f716Ky);
            if (imageReceiver != null) {
                ImageManager.this.f708Ks.remove(this.f716Ky);
                imageReceiver.mo4366c(this.f716Ky);
            }
            C0308a.C0309a aVar = this.f716Ky.f725KA;
            if (aVar.uri == null) {
                this.f716Ky.mo4394a(ImageManager.this.mContext, ImageManager.this.f707Kr, true);
                return;
            }
            Bitmap a = ImageManager.this.m637a(aVar);
            if (a != null) {
                this.f716Ky.mo4392a(ImageManager.this.mContext, a, true);
                return;
            }
            Long l = (Long) ImageManager.this.f710Ku.get(aVar.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.f716Ky.mo4394a(ImageManager.this.mContext, ImageManager.this.f707Kr, true);
                    return;
                }
                ImageManager.this.f710Ku.remove(aVar.uri);
            }
            this.f716Ky.mo4393a(ImageManager.this.mContext, ImageManager.this.f707Kr);
            ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.f709Kt.get(aVar.uri);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageReceiver(aVar.uri);
                ImageManager.this.f709Kt.put(aVar.uri, imageReceiver2);
            }
            imageReceiver2.mo4365b(this.f716Ky);
            if (!(this.f716Ky instanceof C0308a.C0311c)) {
                ImageManager.this.f708Ks.put(this.f716Ky, imageReceiver2);
            }
            synchronized (ImageManager.f701Kl) {
                if (!ImageManager.f702Km.contains(aVar.uri)) {
                    ImageManager.f702Km.add(aVar.uri);
                    imageReceiver2.mo4367gK();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$e */
    private static final class C0306e implements ComponentCallbacks2 {

        /* renamed from: Kq */
        private final C0303b f717Kq;

        public C0306e(C0303b bVar) {
            this.f717Kq = bVar;
        }

        public void onConfigurationChanged(Configuration newConfig) {
        }

        public void onLowMemory() {
            this.f717Kq.evictAll();
        }

        public void onTrimMemory(int level) {
            if (level >= 60) {
                this.f717Kq.evictAll();
            } else if (level >= 20) {
                this.f717Kq.trimToSize(this.f717Kq.size() / 2);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$f */
    private final class C0307f implements Runnable {

        /* renamed from: Kz */
        private boolean f719Kz;
        private final Bitmap mBitmap;
        private final Uri mUri;

        /* renamed from: mg */
        private final CountDownLatch f720mg;

        public C0307f(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.f719Kz = z;
            this.f720mg = countDownLatch;
        }

        /* renamed from: a */
        private void m659a(ImageReceiver imageReceiver, boolean z) {
            ArrayList a = imageReceiver.f711Kv;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                C0308a aVar = (C0308a) a.get(i);
                if (z) {
                    aVar.mo4392a(ImageManager.this.mContext, this.mBitmap, false);
                } else {
                    ImageManager.this.f710Ku.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    aVar.mo4394a(ImageManager.this.mContext, ImageManager.this.f707Kr, false);
                }
                if (!(aVar instanceof C0308a.C0311c)) {
                    ImageManager.this.f708Ks.remove(aVar);
                }
            }
        }

        public void run() {
            C0313a.m680aT("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (ImageManager.this.f706Kq != null) {
                if (this.f719Kz) {
                    ImageManager.this.f706Kq.evictAll();
                    System.gc();
                    this.f719Kz = false;
                    ImageManager.this.mHandler.post(this);
                    return;
                } else if (z) {
                    ImageManager.this.f706Kq.put(new C0308a.C0309a(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f709Kt.remove(this.mUri);
            if (imageReceiver != null) {
                m659a(imageReceiver, z);
            }
            this.f720mg.countDown();
            synchronized (ImageManager.f701Kl) {
                ImageManager.f702Km.remove(this.mUri);
            }
        }
    }

    private ImageManager(Context context, boolean withMemoryCache) {
        this.mContext = context.getApplicationContext();
        if (withMemoryCache) {
            this.f706Kq = new C0303b(this.mContext);
            if (C1394kc.m5241hE()) {
                m646gH();
            }
        } else {
            this.f706Kq = null;
        }
        this.f707Kr = new C1356iz();
        this.f708Ks = new HashMap();
        this.f709Kt = new HashMap();
        this.f710Ku = new HashMap();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Bitmap m637a(C0308a.C0309a aVar) {
        if (this.f706Kq == null) {
            return null;
        }
        return (Bitmap) this.f706Kq.get(aVar);
    }

    /* renamed from: c */
    public static ImageManager m640c(Context context, boolean z) {
        if (z) {
            if (f704Ko == null) {
                f704Ko = new ImageManager(context, true);
            }
            return f704Ko;
        }
        if (f703Kn == null) {
            f703Kn = new ImageManager(context, false);
        }
        return f703Kn;
    }

    public static ImageManager create(Context context) {
        return m640c(context, false);
    }

    /* renamed from: gH */
    private void m646gH() {
        this.mContext.registerComponentCallbacks(new C0306e(this.f706Kq));
    }

    /* renamed from: a */
    public void mo4359a(C0308a aVar) {
        C0313a.m680aT("ImageManager.loadImage() must be called in the main thread");
        new C0305d(aVar).run();
    }

    public void loadImage(ImageView imageView, int resId) {
        mo4359a((C0308a) new C0308a.C0310b(imageView, resId));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        mo4359a((C0308a) new C0308a.C0310b(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int defaultResId) {
        C0308a.C0310b bVar = new C0308a.C0310b(imageView, uri);
        bVar.mo4396aw(defaultResId);
        mo4359a((C0308a) bVar);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri) {
        mo4359a((C0308a) new C0308a.C0311c(listener, uri));
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri, int defaultResId) {
        C0308a.C0311c cVar = new C0308a.C0311c(listener, uri);
        cVar.mo4396aw(defaultResId);
        mo4359a((C0308a) cVar);
    }
}
