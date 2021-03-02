package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzma;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmc;
import com.google.android.gms.internal.zzmd;
import java.lang.ref.WeakReference;

public abstract class zza {

    /* renamed from: a */
    final C0727a f2891a;

    /* renamed from: b */
    private boolean f2892b = true;

    /* renamed from: c */
    private boolean f2893c = false;

    /* renamed from: d */
    private boolean f2894d = true;
    protected int zzajP = 0;
    protected int zzajQ = 0;
    protected boolean zzajR = false;
    protected ImageManager.OnImageLoadedListener zzajS;
    protected int zzajW;

    /* renamed from: com.google.android.gms.common.images.zza$a */
    static final class C0727a {

        /* renamed from: a */
        public final Uri f2895a;

        public C0727a(Uri uri) {
            this.f2895a = uri;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0727a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return zzw.equal(((C0727a) obj).f2895a, this.f2895a);
        }

        public int hashCode() {
            return zzw.hashCode(this.f2895a);
        }
    }

    public static final class zzb extends zza {

        /* renamed from: b */
        private WeakReference<ImageView> f2896b;

        public zzb(ImageView imageView, int i) {
            super((Uri) null, i);
            com.google.android.gms.common.internal.zzb.zzv(imageView);
            this.f2896b = new WeakReference<>(imageView);
        }

        public zzb(ImageView imageView, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzv(imageView);
            this.f2896b = new WeakReference<>(imageView);
        }

        /* renamed from: a */
        private void m3889a(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            boolean z4 = !z2 && !z3;
            if (z4 && (imageView instanceof zzmc)) {
                int zzqp = ((zzmc) imageView).zzqp();
                if (this.zzajQ != 0 && zzqp == this.zzajQ) {
                    return;
                }
            }
            boolean zzb = zzb(z, z2);
            Drawable newDrawable = (!this.zzajR || drawable == null) ? drawable : drawable.getConstantState().newDrawable();
            if (zzb) {
                newDrawable = zza(imageView.getDrawable(), newDrawable);
            }
            imageView.setImageDrawable(newDrawable);
            if (imageView instanceof zzmc) {
                zzmc zzmc = (zzmc) imageView;
                zzmc.zzm(z3 ? this.f2891a.f2895a : null);
                zzmc.zzbO(z4 ? this.zzajQ : 0);
            }
            if (zzb) {
                ((zzma) newDrawable).startTransition(250);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.f2896b.get();
            ImageView imageView2 = (ImageView) ((zzb) obj).f2896b.get();
            return (imageView2 == null || imageView == null || !zzw.equal(imageView2, imageView)) ? false : true;
        }

        public int hashCode() {
            return 0;
        }

        /* access modifiers changed from: protected */
        public void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.f2896b.get();
            if (imageView != null) {
                m3889a(imageView, drawable, z, z2, z3);
            }
        }
    }

    public static final class zzc extends zza {

        /* renamed from: b */
        private WeakReference<ImageManager.OnImageLoadedListener> f2897b;

        public zzc(ImageManager.OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzv(onImageLoadedListener);
            this.f2897b = new WeakReference<>(onImageLoadedListener);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc zzc = (zzc) obj;
            ImageManager.OnImageLoadedListener onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.f2897b.get();
            ImageManager.OnImageLoadedListener onImageLoadedListener2 = (ImageManager.OnImageLoadedListener) zzc.f2897b.get();
            return onImageLoadedListener2 != null && onImageLoadedListener != null && zzw.equal(onImageLoadedListener2, onImageLoadedListener) && zzw.equal(zzc.f2891a, this.f2891a);
        }

        public int hashCode() {
            return zzw.hashCode(this.f2891a);
        }

        /* access modifiers changed from: protected */
        public void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageManager.OnImageLoadedListener onImageLoadedListener;
            if (!z2 && (onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.f2897b.get()) != null) {
                onImageLoadedListener.onImageLoaded(this.f2891a.f2895a, drawable, z3);
            }
        }
    }

    public zza(Uri uri, int i) {
        this.f2891a = new C0727a(uri);
        this.zzajQ = i;
    }

    /* renamed from: a */
    private Drawable m3885a(Context context, zzmd zzmd, int i) {
        Resources resources = context.getResources();
        if (this.zzajW <= 0) {
            return resources.getDrawable(i);
        }
        zzmd.zza zza = new zzmd.zza(i, this.zzajW);
        Drawable drawable = (Drawable) zzmd.get(zza);
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = resources.getDrawable(i);
        if ((this.zzajW & 1) != 0) {
            drawable2 = zza(resources, drawable2);
        }
        zzmd.put(zza, drawable2);
        return drawable2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5364a(Context context, Bitmap bitmap, boolean z) {
        com.google.android.gms.common.internal.zzb.zzv(bitmap);
        if ((this.zzajW & 1) != 0) {
            bitmap = zzmb.zzb(bitmap);
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        if (this.zzajS != null) {
            this.zzajS.onImageLoaded(this.f2891a.f2895a, bitmapDrawable, true);
        }
        zza(bitmapDrawable, z, false, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5365a(Context context, zzmd zzmd) {
        if (this.f2894d) {
            Drawable drawable = null;
            if (this.zzajP != 0) {
                drawable = m3885a(context, zzmd, this.zzajP);
            }
            zza(drawable, false, true, false);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5366a(Context context, zzmd zzmd, boolean z) {
        Drawable drawable = null;
        if (this.zzajQ != 0) {
            drawable = m3885a(context, zzmd, this.zzajQ);
        }
        if (this.zzajS != null) {
            this.zzajS.onImageLoaded(this.f2891a.f2895a, drawable, false);
        }
        zza(drawable, z, false, false);
    }

    /* access modifiers changed from: protected */
    public Drawable zza(Resources resources, Drawable drawable) {
        return zzmb.zza(resources, drawable);
    }

    /* access modifiers changed from: protected */
    public zzma zza(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof zzma) {
            drawable = ((zzma) drawable).zzqn();
        }
        return new zzma(drawable, drawable2);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(Drawable drawable, boolean z, boolean z2, boolean z3);

    /* access modifiers changed from: protected */
    public boolean zzb(boolean z, boolean z2) {
        return this.f2892b && !z2 && (!z || this.f2893c);
    }

    public void zzbM(int i) {
        this.zzajQ = i;
    }
}
