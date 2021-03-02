package com.google.android.gms.common.images;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.images.zza;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzrc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Object f4402a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static HashSet f4403b = new HashSet();

    /* renamed from: c */
    private static ImageManager f4404c;

    /* renamed from: d */
    private static ImageManager f4405d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Context f4406e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Handler f4407f = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final ExecutorService f4408g = Executors.newFixedThreadPool(4);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C1352b f4409h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final zzrc f4410i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final Map f4411j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final Map f4412k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final Map f4413l;

    @KeepName
    final class ImageReceiver extends ResultReceiver {

        /* renamed from: b */
        private final Uri f4415b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final ArrayList f4416c = new ArrayList();

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.f4415b = uri;
        }

        /* renamed from: a */
        public void mo6483a() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.f4415b);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.f4406e.sendBroadcast(intent);
        }

        /* renamed from: a */
        public void mo6484a(zza zza) {
            zzb.zzhi("ImageReceiver.addImageRequest() must be called in the main thread");
            this.f4416c.add(zza);
        }

        /* renamed from: b */
        public void mo6485b(zza zza) {
            zzb.zzhi("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.f4416c.remove(zza);
        }

        public void onReceiveResult(int i, Bundle bundle) {
            ImageManager.this.f4408g.execute(new C1353c(ImageManager.this, this.f4415b, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    private ImageManager(Context context, boolean z) {
        this.f4406e = context.getApplicationContext();
        if (z) {
            this.f4409h = new C1352b(this.f4406e);
            if (zzs.zzavq()) {
                m6019c();
            }
        } else {
            this.f4409h = null;
        }
        this.f4410i = new zzrc();
        this.f4411j = new HashMap();
        this.f4412k = new HashMap();
        this.f4413l = new HashMap();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Bitmap m6013a(C1357g gVar) {
        if (this.f4409h == null) {
            return null;
        }
        return (Bitmap) this.f4409h.get(gVar);
    }

    @TargetApi(14)
    /* renamed from: c */
    private void m6019c() {
        this.f4406e.registerComponentCallbacks(new C1355e(this.f4409h));
    }

    public static ImageManager create(Context context) {
        return zzg(context, false);
    }

    public static ImageManager zzg(Context context, boolean z) {
        if (z) {
            if (f4405d == null) {
                f4405d = new ImageManager(context, true);
            }
            return f4405d;
        }
        if (f4404c == null) {
            f4404c = new ImageManager(context, false);
        }
        return f4404c;
    }

    public void loadImage(ImageView imageView, int i) {
        zza(new zza.zzb(imageView, i));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zza(new zza.zzb(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int i) {
        zza.zzb zzb = new zza.zzb(imageView, uri);
        zzb.zzfy(i);
        zza(zzb);
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zza(new zza.zzc(onImageLoadedListener, uri));
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zza.zzc zzc = new zza.zzc(onImageLoadedListener, uri);
        zzc.zzfy(i);
        zza(zzc);
    }

    public void zza(zza zza) {
        zzb.zzhi("ImageManager.loadImage() must be called in the main thread");
        new C1354d(this, zza).run();
    }
}
