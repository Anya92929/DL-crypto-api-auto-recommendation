package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.internal.zzb;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.google.android.gms.common.images.c */
final class C1353c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ImageManager f4423a;

    /* renamed from: b */
    private final Uri f4424b;

    /* renamed from: c */
    private final ParcelFileDescriptor f4425c;

    public C1353c(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.f4423a = imageManager;
        this.f4424b = uri;
        this.f4425c = parcelFileDescriptor;
    }

    public void run() {
        zzb.zzhj("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        boolean z = false;
        Bitmap bitmap = null;
        if (this.f4425c != null) {
            try {
                bitmap = BitmapFactory.decodeFileDescriptor(this.f4425c.getFileDescriptor());
            } catch (OutOfMemoryError e) {
                String valueOf = String.valueOf(this.f4424b);
                Log.e("ImageManager", new StringBuilder(String.valueOf(valueOf).length() + 34).append("OOM while loading bitmap for uri: ").append(valueOf).toString(), e);
                z = true;
            }
            try {
                this.f4425c.close();
            } catch (IOException e2) {
                Log.e("ImageManager", "closed failed", e2);
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f4423a.f4407f.post(new C1356f(this.f4423a, this.f4424b, bitmap, z, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e3) {
            String valueOf2 = String.valueOf(this.f4424b);
            Log.w("ImageManager", new StringBuilder(String.valueOf(valueOf2).length() + 32).append("Latch interrupted while posting ").append(valueOf2).toString());
        }
    }
}
