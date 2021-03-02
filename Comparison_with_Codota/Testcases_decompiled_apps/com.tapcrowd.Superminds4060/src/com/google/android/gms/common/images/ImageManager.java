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
import com.google.android.gms.common.images.C0151a;
import com.google.android.gms.internal.C0384db;
import com.google.android.gms.internal.C0415dq;
import com.google.android.gms.internal.C0441ek;
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

    /* renamed from: jC */
    public static final Object f393jC = new Object();
    /* access modifiers changed from: private */

    /* renamed from: jD */
    public static HashSet<Uri> f394jD = new HashSet<>();

    /* renamed from: jE */
    private static ImageManager f395jE;

    /* renamed from: jF */
    private static ImageManager f396jF;
    /* access modifiers changed from: private */

    /* renamed from: jG */
    public final ExecutorService f397jG = Executors.newFixedThreadPool(4);
    /* access modifiers changed from: private */

    /* renamed from: jH */
    public final C0146b f398jH;
    /* access modifiers changed from: private */

    /* renamed from: jI */
    public final Map<C0151a, ImageReceiver> f399jI;
    /* access modifiers changed from: private */

    /* renamed from: jJ */
    public final Map<Uri, ImageReceiver> f400jJ;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper());

    private final class ImageReceiver extends ResultReceiver {
        /* access modifiers changed from: private */

        /* renamed from: jK */
        public final ArrayList<C0151a> f401jK;

        /* renamed from: jL */
        boolean f402jL = false;
        private final Uri mUri;

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
            this.f401jK = new ArrayList<>();
        }

        /* renamed from: aR */
        public void mo3629aR() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }

        /* renamed from: c */
        public void mo3630c(C0151a aVar) {
            C0384db.m829a(!this.f402jL, "Cannot add an ImageRequest when mHandlingRequests is true");
            C0384db.m832w("ImageReceiver.addImageRequest() must be called in the main thread");
            this.f401jK.add(aVar);
        }

        /* renamed from: d */
        public void mo3631d(C0151a aVar) {
            C0384db.m829a(!this.f402jL, "Cannot remove an ImageRequest when mHandlingRequests is true");
            C0384db.m832w("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.f401jK.remove(aVar);
        }

        public void onReceiveResult(int resultCode, Bundle resultData) {
            ImageManager.this.f397jG.execute(new C0147c(this.mUri, (ParcelFileDescriptor) resultData.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable);
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$a */
    private static final class C0145a {
        /* renamed from: a */
        static int m288a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$b */
    private static final class C0146b extends C0415dq<C0151a.C0152a, Bitmap> {
        public C0146b(Context context) {
            super(m289q(context));
        }

        /* renamed from: q */
        private static int m289q(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (int) (((float) (((!((context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0) || !C0441ek.m1086bJ()) ? activityManager.getMemoryClass() : C0145a.m288a(activityManager)) * AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START)) * 0.33f);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(C0151a.C0152a aVar, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void entryRemoved(boolean z, C0151a.C0152a aVar, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, aVar, bitmap, bitmap2);
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$c */
    private final class C0147c implements Runnable {

        /* renamed from: jN */
        private final ParcelFileDescriptor f405jN;
        private final Uri mUri;

        public C0147c(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.f405jN = parcelFileDescriptor;
        }

        public void run() {
            C0384db.m833x("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.f405jN != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.f405jN.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.f405jN.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(new C0150f(this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$d */
    private final class C0148d implements Runnable {

        /* renamed from: jO */
        private final C0151a f407jO;

        public C0148d(C0151a aVar) {
            this.f407jO = aVar;
        }

        public void run() {
            C0384db.m832w("LoadImageRunnable must be executed on the main thread");
            boolean unused = ImageManager.this.m278b(this.f407jO);
            C0151a.C0152a aVar = this.f407jO.f413jS;
            if (aVar.uri == null) {
                this.f407jO.mo3647b(ImageManager.this.mContext, true);
                return;
            }
            Bitmap a = ImageManager.this.m271a(aVar);
            if (a != null) {
                this.f407jO.mo3644a(ImageManager.this.mContext, a, true);
                return;
            }
            this.f407jO.mo3650r(ImageManager.this.mContext);
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f400jJ.get(aVar.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(aVar.uri);
                ImageManager.this.f400jJ.put(aVar.uri, imageReceiver);
            }
            imageReceiver.mo3630c(this.f407jO);
            if (this.f407jO.f416jV != 1) {
                ImageManager.this.f399jI.put(this.f407jO, imageReceiver);
            }
            synchronized (ImageManager.f393jC) {
                if (!ImageManager.f394jD.contains(aVar.uri)) {
                    ImageManager.f394jD.add(aVar.uri);
                    imageReceiver.mo3629aR();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$e */
    private static final class C0149e implements ComponentCallbacks2 {

        /* renamed from: jH */
        private final C0146b f408jH;

        public C0149e(C0146b bVar) {
            this.f408jH = bVar;
        }

        public void onConfigurationChanged(Configuration newConfig) {
        }

        public void onLowMemory() {
            this.f408jH.evictAll();
        }

        public void onTrimMemory(int level) {
            if (level >= 60) {
                this.f408jH.evictAll();
            } else if (level >= 20) {
                this.f408jH.trimToSize(this.f408jH.size() / 2);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$f */
    private final class C0150f implements Runnable {

        /* renamed from: jP */
        private final Bitmap f410jP;

        /* renamed from: jQ */
        private final CountDownLatch f411jQ;

        /* renamed from: jR */
        private boolean f412jR;
        private final Uri mUri;

        public C0150f(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.f410jP = bitmap;
            this.f412jR = z;
            this.f411jQ = countDownLatch;
        }

        /* renamed from: a */
        private void m292a(ImageReceiver imageReceiver, boolean z) {
            imageReceiver.f402jL = true;
            ArrayList a = imageReceiver.f401jK;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                C0151a aVar = (C0151a) a.get(i);
                if (z) {
                    aVar.mo3644a(ImageManager.this.mContext, this.f410jP, false);
                } else {
                    aVar.mo3647b(ImageManager.this.mContext, false);
                }
                if (aVar.f416jV != 1) {
                    ImageManager.this.f399jI.remove(aVar);
                }
            }
            imageReceiver.f402jL = false;
        }

        public void run() {
            C0384db.m832w("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.f410jP != null;
            if (ImageManager.this.f398jH != null) {
                if (this.f412jR) {
                    ImageManager.this.f398jH.evictAll();
                    System.gc();
                    this.f412jR = false;
                    ImageManager.this.mHandler.post(this);
                    return;
                } else if (z) {
                    ImageManager.this.f398jH.put(new C0151a.C0152a(this.mUri), this.f410jP);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f400jJ.remove(this.mUri);
            if (imageReceiver != null) {
                m292a(imageReceiver, z);
            }
            this.f411jQ.countDown();
            synchronized (ImageManager.f393jC) {
                ImageManager.f394jD.remove(this.mUri);
            }
        }
    }

    private ImageManager(Context context, boolean withMemoryCache) {
        this.mContext = context.getApplicationContext();
        if (withMemoryCache) {
            this.f398jH = new C0146b(this.mContext);
            if (C0441ek.m1089bM()) {
                m274aO();
            }
        } else {
            this.f398jH = null;
        }
        this.f399jI = new HashMap();
        this.f400jJ = new HashMap();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Bitmap m271a(C0151a.C0152a aVar) {
        if (this.f398jH == null) {
            return null;
        }
        return (Bitmap) this.f398jH.get(aVar);
    }

    /* renamed from: a */
    public static ImageManager m272a(Context context, boolean z) {
        if (z) {
            if (f396jF == null) {
                f396jF = new ImageManager(context, true);
            }
            return f396jF;
        }
        if (f395jE == null) {
            f395jE = new ImageManager(context, false);
        }
        return f395jE;
    }

    /* renamed from: aO */
    private void m274aO() {
        this.mContext.registerComponentCallbacks(new C0149e(this.f398jH));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m278b(C0151a aVar) {
        C0384db.m832w("ImageManager.cleanupHashMaps() must be called in the main thread");
        if (aVar.f416jV == 1) {
            return true;
        }
        ImageReceiver imageReceiver = this.f399jI.get(aVar);
        if (imageReceiver == null) {
            return true;
        }
        if (imageReceiver.f402jL) {
            return false;
        }
        this.f399jI.remove(aVar);
        imageReceiver.mo3631d(aVar);
        return true;
    }

    public static ImageManager create(Context context) {
        return m272a(context, false);
    }

    /* renamed from: a */
    public void mo3623a(C0151a aVar) {
        C0384db.m832w("ImageManager.loadImage() must be called in the main thread");
        boolean b = m278b(aVar);
        C0148d dVar = new C0148d(aVar);
        if (b) {
            dVar.run();
        } else {
            this.mHandler.post(dVar);
        }
    }

    public void loadImage(ImageView imageView, int resId) {
        C0151a aVar = new C0151a(resId);
        aVar.mo3645a(imageView);
        mo3623a(aVar);
    }

    public void loadImage(ImageView imageView, Uri uri) {
        C0151a aVar = new C0151a(uri);
        aVar.mo3645a(imageView);
        mo3623a(aVar);
    }

    public void loadImage(ImageView imageView, Uri uri, int defaultResId) {
        C0151a aVar = new C0151a(uri);
        aVar.mo3651v(defaultResId);
        aVar.mo3645a(imageView);
        mo3623a(aVar);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri) {
        C0151a aVar = new C0151a(uri);
        aVar.mo3646a(listener);
        mo3623a(aVar);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri, int defaultResId) {
        C0151a aVar = new C0151a(uri);
        aVar.mo3651v(defaultResId);
        aVar.mo3646a(listener);
        mo3623a(aVar);
    }
}
