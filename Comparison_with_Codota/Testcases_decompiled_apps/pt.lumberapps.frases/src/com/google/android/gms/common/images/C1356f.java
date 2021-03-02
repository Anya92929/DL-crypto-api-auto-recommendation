package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.zza;
import com.google.android.gms.common.internal.zzb;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.google.android.gms.common.images.f */
final class C1356f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ImageManager f4429a;

    /* renamed from: b */
    private final Uri f4430b;

    /* renamed from: c */
    private final Bitmap f4431c;

    /* renamed from: d */
    private final CountDownLatch f4432d;

    /* renamed from: e */
    private boolean f4433e;

    public C1356f(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
        this.f4429a = imageManager;
        this.f4430b = uri;
        this.f4431c = bitmap;
        this.f4433e = z;
        this.f4432d = countDownLatch;
    }

    /* renamed from: a */
    private void m6038a(ImageManager.ImageReceiver imageReceiver, boolean z) {
        ArrayList a = imageReceiver.f4416c;
        int size = a.size();
        for (int i = 0; i < size; i++) {
            zza zza = (zza) a.get(i);
            if (z) {
                zza.mo6513a(this.f4429a.f4406e, this.f4431c, false);
            } else {
                this.f4429a.f4413l.put(this.f4430b, Long.valueOf(SystemClock.elapsedRealtime()));
                zza.mo6515a(this.f4429a.f4406e, this.f4429a.f4410i, false);
            }
            if (!(zza instanceof zza.zzc)) {
                this.f4429a.f4411j.remove(zza);
            }
        }
    }

    public void run() {
        zzb.zzhi("OnBitmapLoadedRunnable must be executed in the main thread");
        boolean z = this.f4431c != null;
        if (this.f4429a.f4409h != null) {
            if (this.f4433e) {
                this.f4429a.f4409h.evictAll();
                System.gc();
                this.f4433e = false;
                this.f4429a.f4407f.post(this);
                return;
            } else if (z) {
                this.f4429a.f4409h.put(new C1357g(this.f4430b), this.f4431c);
            }
        }
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.f4429a.f4412k.remove(this.f4430b);
        if (imageReceiver != null) {
            m6038a(imageReceiver, z);
        }
        this.f4432d.countDown();
        synchronized (ImageManager.f4402a) {
            ImageManager.f4403b.remove(this.f4430b);
        }
    }
}
