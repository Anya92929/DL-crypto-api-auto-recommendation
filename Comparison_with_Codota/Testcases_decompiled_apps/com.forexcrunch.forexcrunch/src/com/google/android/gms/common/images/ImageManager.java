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
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.images.C0355a;
import com.google.android.gms.internal.C0427as;
import com.google.android.gms.internal.C0594h;
import com.google.android.gms.internal.C0625w;
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

    /* renamed from: aq */
    public static final Object f819aq = new Object();
    /* access modifiers changed from: private */

    /* renamed from: ar */
    public static HashSet<Uri> f820ar = new HashSet<>();

    /* renamed from: as */
    private static ImageManager f821as;

    /* renamed from: at */
    private static ImageManager f822at;
    /* access modifiers changed from: private */

    /* renamed from: au */
    public final ExecutorService f823au = Executors.newFixedThreadPool(4);
    /* access modifiers changed from: private */

    /* renamed from: av */
    public final C0350b f824av;
    /* access modifiers changed from: private */

    /* renamed from: aw */
    public final Map<C0355a, ImageReceiver> f825aw;
    /* access modifiers changed from: private */

    /* renamed from: ax */
    public final Map<Uri, ImageReceiver> f826ax;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper());

    private final class ImageReceiver extends ResultReceiver {
        /* access modifiers changed from: private */

        /* renamed from: ay */
        public final ArrayList<C0355a> f828ay;

        /* renamed from: az */
        boolean f829az = false;
        private final Uri mUri;

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
            this.f828ay = new ArrayList<>();
        }

        /* renamed from: c */
        public void mo4079c(C0355a aVar) {
            C0594h.m1778a(!this.f829az, "Cannot add an ImageRequest when mHandlingRequests is true");
            C0594h.m1780f("ImageReceiver.addImageRequest() must be called in the main thread");
            this.f828ay.add(aVar);
        }

        /* renamed from: d */
        public void mo4080d(C0355a aVar) {
            C0594h.m1778a(!this.f829az, "Cannot remove an ImageRequest when mHandlingRequests is true");
            C0594h.m1780f("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.f828ay.remove(aVar);
        }

        public void onReceiveResult(int resultCode, Bundle resultData) {
            ImageManager.this.f823au.execute(new C0351c(this.mUri, (ParcelFileDescriptor) resultData.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        /* renamed from: q */
        public void mo4082q() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable);
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$a */
    private static final class C0349a {
        /* renamed from: a */
        static int m611a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$b */
    private static final class C0350b extends C0625w<C0355a.C0356a, Bitmap> {
        public C0350b(Context context) {
            super(m612e(context));
        }

        /* renamed from: e */
        private static int m612e(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (int) (((float) (((!((context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0) || !C0427as.m909an()) ? activityManager.getMemoryClass() : C0349a.m611a(activityManager)) * AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START)) * 0.33f);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(C0355a.C0356a aVar, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void entryRemoved(boolean z, C0355a.C0356a aVar, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, aVar, bitmap, bitmap2);
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$c */
    private final class C0351c implements Runnable {

        /* renamed from: aB */
        private final ParcelFileDescriptor f831aB;
        private final Uri mUri;

        public C0351c(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.f831aB = parcelFileDescriptor;
        }

        public void run() {
            C0594h.m1781g("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.f831aB != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.f831aB.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.f831aB.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(new C0354f(this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$d */
    private final class C0352d implements Runnable {

        /* renamed from: aC */
        private final C0355a f833aC;

        public C0352d(C0355a aVar) {
            this.f833aC = aVar;
        }

        public void run() {
            C0594h.m1780f("LoadImageRunnable must be executed on the main thread");
            boolean unused = ImageManager.this.m598b(this.f833aC);
            C0355a.C0356a aVar = this.f833aC.f839aG;
            if (aVar.uri == null) {
                this.f833aC.mo4097b(ImageManager.this.mContext, true);
                return;
            }
            Bitmap a = ImageManager.this.m594a(aVar);
            if (a != null) {
                this.f833aC.mo4094a(ImageManager.this.mContext, a, true);
                return;
            }
            this.f833aC.mo4099f(ImageManager.this.mContext);
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f826ax.get(aVar.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(aVar.uri);
                ImageManager.this.f826ax.put(aVar.uri, imageReceiver);
            }
            imageReceiver.mo4079c(this.f833aC);
            if (this.f833aC.f842aJ != 1) {
                ImageManager.this.f825aw.put(this.f833aC, imageReceiver);
            }
            synchronized (ImageManager.f819aq) {
                if (!ImageManager.f820ar.contains(aVar.uri)) {
                    ImageManager.f820ar.add(aVar.uri);
                    imageReceiver.mo4082q();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$e */
    private static final class C0353e implements ComponentCallbacks2 {

        /* renamed from: av */
        private final C0350b f834av;

        public C0353e(C0350b bVar) {
            this.f834av = bVar;
        }

        public void onConfigurationChanged(Configuration newConfig) {
        }

        public void onLowMemory() {
            this.f834av.evictAll();
        }

        public void onTrimMemory(int level) {
            if (level >= 60) {
                this.f834av.evictAll();
            } else if (level >= 20) {
                this.f834av.trimToSize(this.f834av.size() / 2);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$f */
    private final class C0354f implements Runnable {

        /* renamed from: aD */
        private final Bitmap f836aD;

        /* renamed from: aE */
        private final CountDownLatch f837aE;

        /* renamed from: aF */
        private boolean f838aF;
        private final Uri mUri;

        public C0354f(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.f836aD = bitmap;
            this.f838aF = z;
            this.f837aE = countDownLatch;
        }

        /* renamed from: a */
        private void m615a(ImageReceiver imageReceiver, boolean z) {
            imageReceiver.f829az = true;
            ArrayList a = imageReceiver.f828ay;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                C0355a aVar = (C0355a) a.get(i);
                if (z) {
                    aVar.mo4094a(ImageManager.this.mContext, this.f836aD, false);
                } else {
                    aVar.mo4097b(ImageManager.this.mContext, false);
                }
                if (aVar.f842aJ != 1) {
                    ImageManager.this.f825aw.remove(aVar);
                }
            }
            imageReceiver.f829az = false;
        }

        public void run() {
            C0594h.m1780f("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.f836aD != null;
            if (ImageManager.this.f824av != null) {
                if (this.f838aF) {
                    ImageManager.this.f824av.evictAll();
                    System.gc();
                    this.f838aF = false;
                    ImageManager.this.mHandler.post(this);
                    return;
                } else if (z) {
                    ImageManager.this.f824av.put(new C0355a.C0356a(this.mUri), this.f836aD);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f826ax.remove(this.mUri);
            if (imageReceiver != null) {
                m615a(imageReceiver, z);
            }
            this.f837aE.countDown();
            synchronized (ImageManager.f819aq) {
                ImageManager.f820ar.remove(this.mUri);
            }
        }
    }

    private ImageManager(Context context, boolean withMemoryCache) {
        this.mContext = context.getApplicationContext();
        if (withMemoryCache) {
            this.f824av = new C0350b(this.mContext);
            if (C0427as.m912aq()) {
                m603n();
            }
        } else {
            this.f824av = null;
        }
        this.f825aw = new HashMap();
        this.f826ax = new HashMap();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Bitmap m594a(C0355a.C0356a aVar) {
        if (this.f824av == null) {
            return null;
        }
        return (Bitmap) this.f824av.get(aVar);
    }

    /* renamed from: a */
    public static ImageManager m595a(Context context, boolean z) {
        if (z) {
            if (f822at == null) {
                f822at = new ImageManager(context, true);
            }
            return f822at;
        }
        if (f821as == null) {
            f821as = new ImageManager(context, false);
        }
        return f821as;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m598b(C0355a aVar) {
        C0594h.m1780f("ImageManager.cleanupHashMaps() must be called in the main thread");
        if (aVar.f842aJ == 1) {
            return true;
        }
        ImageReceiver imageReceiver = this.f825aw.get(aVar);
        if (imageReceiver == null) {
            return true;
        }
        if (imageReceiver.f829az) {
            return false;
        }
        this.f825aw.remove(aVar);
        imageReceiver.mo4080d(aVar);
        return true;
    }

    public static ImageManager create(Context context) {
        return m595a(context, false);
    }

    /* renamed from: n */
    private void m603n() {
        this.mContext.registerComponentCallbacks(new C0353e(this.f824av));
    }

    /* renamed from: a */
    public void mo4073a(C0355a aVar) {
        C0594h.m1780f("ImageManager.loadImage() must be called in the main thread");
        boolean b = m598b(aVar);
        C0352d dVar = new C0352d(aVar);
        if (b) {
            dVar.run();
        } else {
            this.mHandler.post(dVar);
        }
    }

    public void loadImage(ImageView imageView, int resId) {
        C0355a aVar = new C0355a(resId);
        aVar.mo4095a(imageView);
        mo4073a(aVar);
    }

    public void loadImage(ImageView imageView, Uri uri) {
        C0355a aVar = new C0355a(uri);
        aVar.mo4095a(imageView);
        mo4073a(aVar);
    }

    public void loadImage(ImageView imageView, Uri uri, int defaultResId) {
        C0355a aVar = new C0355a(uri);
        aVar.mo4101j(defaultResId);
        aVar.mo4095a(imageView);
        mo4073a(aVar);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri) {
        C0355a aVar = new C0355a(uri);
        aVar.mo4096a(listener);
        mo4073a(aVar);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri, int defaultResId) {
        C0355a aVar = new C0355a(uri);
        aVar.mo4101j(defaultResId);
        aVar.mo4096a(listener);
        mo4073a(aVar);
    }
}
