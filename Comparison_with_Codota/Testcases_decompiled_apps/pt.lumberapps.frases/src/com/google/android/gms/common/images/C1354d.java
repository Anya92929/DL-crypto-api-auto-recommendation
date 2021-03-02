package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.zza;
import com.google.android.gms.common.internal.zzb;

/* renamed from: com.google.android.gms.common.images.d */
final class C1354d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ImageManager f4426a;

    /* renamed from: b */
    private final zza f4427b;

    public C1354d(ImageManager imageManager, zza zza) {
        this.f4426a = imageManager;
        this.f4427b = zza;
    }

    public void run() {
        zzb.zzhi("LoadImageRunnable must be executed on the main thread");
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.f4426a.f4411j.get(this.f4427b);
        if (imageReceiver != null) {
            this.f4426a.f4411j.remove(this.f4427b);
            imageReceiver.mo6485b(this.f4427b);
        }
        C1357g gVar = this.f4427b.f4435a;
        if (gVar.f4434a == null) {
            this.f4427b.mo6515a(this.f4426a.f4406e, this.f4426a.f4410i, true);
            return;
        }
        Bitmap a = this.f4426a.m6013a(gVar);
        if (a != null) {
            this.f4427b.mo6513a(this.f4426a.f4406e, a, true);
            return;
        }
        Long l = (Long) this.f4426a.f4413l.get(gVar.f4434a);
        if (l != null) {
            if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                this.f4427b.mo6515a(this.f4426a.f4406e, this.f4426a.f4410i, true);
                return;
            }
            this.f4426a.f4413l.remove(gVar.f4434a);
        }
        this.f4427b.mo6514a(this.f4426a.f4406e, this.f4426a.f4410i);
        ImageManager.ImageReceiver imageReceiver2 = (ImageManager.ImageReceiver) this.f4426a.f4412k.get(gVar.f4434a);
        if (imageReceiver2 == null) {
            imageReceiver2 = new ImageManager.ImageReceiver(gVar.f4434a);
            this.f4426a.f4412k.put(gVar.f4434a, imageReceiver2);
        }
        imageReceiver2.mo6484a(this.f4427b);
        if (!(this.f4427b instanceof zza.zzc)) {
            this.f4426a.f4411j.put(this.f4427b, imageReceiver2);
        }
        synchronized (ImageManager.f4402a) {
            if (!ImageManager.f4403b.contains(gVar.f4434a)) {
                ImageManager.f4403b.add(gVar.f4434a);
                imageReceiver2.mo6483a();
            }
        }
    }
}
