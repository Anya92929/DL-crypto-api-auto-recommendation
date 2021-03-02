package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzra;
import com.google.android.gms.internal.zzrb;
import com.google.android.gms.internal.zzrc;
import java.lang.ref.WeakReference;

public abstract class zza {

    /* renamed from: a */
    final C1357g f4435a;

    /* renamed from: b */
    protected int f4436b = 0;

    /* renamed from: c */
    protected int f4437c = 0;

    /* renamed from: d */
    protected boolean f4438d = false;

    /* renamed from: e */
    private boolean f4439e = true;

    /* renamed from: f */
    private boolean f4440f = false;

    /* renamed from: g */
    private boolean f4441g = true;

    public final class zzb extends zza {

        /* renamed from: e */
        private WeakReference f4442e;

        public zzb(ImageView imageView, int i) {
            super((Uri) null, i);
            com.google.android.gms.common.internal.zzb.zzu(imageView);
            this.f4442e = new WeakReference(imageView);
        }

        public zzb(ImageView imageView, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzu(imageView);
            this.f4442e = new WeakReference(imageView);
        }

        /* renamed from: a */
        private void m6046a(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            boolean z4 = !z2 && !z3;
            if (z4 && (imageView instanceof zzrb)) {
                int zzars = ((zzrb) imageView).zzars();
                if (this.f4437c != 0 && zzars == this.f4437c) {
                    return;
                }
            }
            boolean a = mo6517a(z, z2);
            Drawable a2 = a ? mo6512a(imageView.getDrawable(), drawable) : drawable;
            imageView.setImageDrawable(a2);
            if (imageView instanceof zzrb) {
                zzrb zzrb = (zzrb) imageView;
                zzrb.zzp(z3 ? this.f4435a.f4434a : null);
                zzrb.zzga(z4 ? this.f4437c : 0);
            }
            if (a) {
                ((zzra) a2).startTransition(250);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo6516a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.f4442e.get();
            if (imageView != null) {
                m6046a(imageView, drawable, z, z2, z3);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.f4442e.get();
            ImageView imageView2 = (ImageView) ((zzb) obj).f4442e.get();
            return (imageView2 == null || imageView == null || !zzaa.equal(imageView2, imageView)) ? false : true;
        }

        public int hashCode() {
            return 0;
        }
    }

    public final class zzc extends zza {

        /* renamed from: e */
        private WeakReference f4443e;

        public zzc(ImageManager.OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzu(onImageLoadedListener);
            this.f4443e = new WeakReference(onImageLoadedListener);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo6516a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageManager.OnImageLoadedListener onImageLoadedListener;
            if (!z2 && (onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.f4443e.get()) != null) {
                onImageLoadedListener.onImageLoaded(this.f4435a.f4434a, drawable, z3);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc zzc = (zzc) obj;
            ImageManager.OnImageLoadedListener onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.f4443e.get();
            ImageManager.OnImageLoadedListener onImageLoadedListener2 = (ImageManager.OnImageLoadedListener) zzc.f4443e.get();
            return onImageLoadedListener2 != null && onImageLoadedListener != null && zzaa.equal(onImageLoadedListener2, onImageLoadedListener) && zzaa.equal(zzc.f4435a, this.f4435a);
        }

        public int hashCode() {
            return zzaa.hashCode(this.f4435a);
        }
    }

    public zza(Uri uri, int i) {
        this.f4435a = new C1357g(uri);
        this.f4437c = i;
    }

    /* renamed from: a */
    private Drawable m6039a(Context context, zzrc zzrc, int i) {
        return context.getResources().getDrawable(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzra mo6512a(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof zzra) {
            drawable = ((zzra) drawable).zzarq();
        }
        return new zzra(drawable, drawable2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6513a(Context context, Bitmap bitmap, boolean z) {
        com.google.android.gms.common.internal.zzb.zzu(bitmap);
        mo6516a(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6514a(Context context, zzrc zzrc) {
        if (this.f4441g) {
            mo6516a((Drawable) null, false, true, false);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6515a(Context context, zzrc zzrc, boolean z) {
        Drawable drawable = null;
        if (this.f4437c != 0) {
            drawable = m6039a(context, zzrc, this.f4437c);
        }
        mo6516a(drawable, z, false, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6516a(Drawable drawable, boolean z, boolean z2, boolean z3);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo6517a(boolean z, boolean z2) {
        return this.f4439e && !z2 && !z;
    }

    public void zzfy(int i) {
        this.f4437c = i;
    }
}
