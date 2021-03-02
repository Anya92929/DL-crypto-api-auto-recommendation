package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.C0313a;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.internal.C1348iw;
import com.google.android.gms.internal.C1353ix;
import com.google.android.gms.internal.C1354iy;
import com.google.android.gms.internal.C1356iz;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.images.a */
public abstract class C0308a {

    /* renamed from: KA */
    final C0309a f725KA;

    /* renamed from: KB */
    protected int f726KB = 0;

    /* renamed from: KC */
    protected int f727KC = 0;

    /* renamed from: KD */
    protected ImageManager.OnImageLoadedListener f728KD;

    /* renamed from: KE */
    private boolean f729KE = true;

    /* renamed from: KF */
    private boolean f730KF = false;

    /* renamed from: KG */
    protected int f731KG;

    /* renamed from: com.google.android.gms.common.images.a$a */
    static final class C0309a {
        public final Uri uri;

        public C0309a(Uri uri2) {
            this.uri = uri2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0309a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return C0345m.equal(((C0309a) obj).uri, this.uri);
        }

        public int hashCode() {
            return C0345m.hashCode(this.uri);
        }
    }

    /* renamed from: com.google.android.gms.common.images.a$b */
    public static final class C0310b extends C0308a {

        /* renamed from: KH */
        private WeakReference<ImageView> f732KH;

        public C0310b(ImageView imageView, int i) {
            super((Uri) null, i);
            C0313a.m682f(imageView);
            this.f732KH = new WeakReference<>(imageView);
        }

        public C0310b(ImageView imageView, Uri uri) {
            super(uri, 0);
            C0313a.m682f(imageView);
            this.f732KH = new WeakReference<>(imageView);
        }

        /* renamed from: a */
        private void m671a(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            boolean z4 = !z2 && !z3;
            if (z4 && (imageView instanceof C1354iy)) {
                int gN = ((C1354iy) imageView).mo8966gN();
                if (this.f727KC != 0 && gN == this.f727KC) {
                    return;
                }
            }
            boolean b = mo4397b(z, z2);
            Drawable a = b ? mo4391a(imageView.getDrawable(), drawable) : drawable;
            imageView.setImageDrawable(a);
            if (imageView instanceof C1354iy) {
                C1354iy iyVar = (C1354iy) imageView;
                iyVar.mo8965g(z3 ? this.f725KA.uri : null);
                iyVar.mo8964ay(z4 ? this.f727KC : 0);
            }
            if (b) {
                ((C1348iw) a).startTransition(250);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4395a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.f732KH.get();
            if (imageView != null) {
                m671a(imageView, drawable, z, z2, z3);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0310b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.f732KH.get();
            ImageView imageView2 = (ImageView) ((C0310b) obj).f732KH.get();
            return (imageView2 == null || imageView == null || !C0345m.equal(imageView2, imageView)) ? false : true;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* renamed from: com.google.android.gms.common.images.a$c */
    public static final class C0311c extends C0308a {

        /* renamed from: KI */
        private WeakReference<ImageManager.OnImageLoadedListener> f733KI;

        public C0311c(ImageManager.OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            C0313a.m682f(onImageLoadedListener);
            this.f733KI = new WeakReference<>(onImageLoadedListener);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4395a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageManager.OnImageLoadedListener onImageLoadedListener;
            if (!z2 && (onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.f733KI.get()) != null) {
                onImageLoadedListener.onImageLoaded(this.f725KA.uri, drawable, z3);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0311c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0311c cVar = (C0311c) obj;
            ImageManager.OnImageLoadedListener onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.f733KI.get();
            ImageManager.OnImageLoadedListener onImageLoadedListener2 = (ImageManager.OnImageLoadedListener) cVar.f733KI.get();
            return onImageLoadedListener2 != null && onImageLoadedListener != null && C0345m.equal(onImageLoadedListener2, onImageLoadedListener) && C0345m.equal(cVar.f725KA, this.f725KA);
        }

        public int hashCode() {
            return C0345m.hashCode(this.f725KA);
        }
    }

    public C0308a(Uri uri, int i) {
        this.f725KA = new C0309a(uri);
        this.f727KC = i;
    }

    /* renamed from: a */
    private Drawable m662a(Context context, C1356iz izVar, int i) {
        Resources resources = context.getResources();
        if (this.f731KG <= 0) {
            return resources.getDrawable(i);
        }
        C1356iz.C1357a aVar = new C1356iz.C1357a(i, this.f731KG);
        Drawable drawable = (Drawable) izVar.get(aVar);
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = resources.getDrawable(i);
        if ((this.f731KG & 1) != 0) {
            drawable2 = mo4390a(resources, drawable2);
        }
        izVar.put(aVar, drawable2);
        return drawable2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Drawable mo4390a(Resources resources, Drawable drawable) {
        return C1353ix.m5090a(resources, drawable);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1348iw mo4391a(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof C1348iw) {
            drawable = ((C1348iw) drawable).mo8941gL();
        }
        return new C1348iw(drawable, drawable2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4392a(Context context, Bitmap bitmap, boolean z) {
        C0313a.m682f(bitmap);
        if ((this.f731KG & 1) != 0) {
            bitmap = C1353ix.m5088a(bitmap);
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        if (this.f728KD != null) {
            this.f728KD.onImageLoaded(this.f725KA.uri, bitmapDrawable, true);
        }
        mo4395a(bitmapDrawable, z, false, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4393a(Context context, C1356iz izVar) {
        Drawable drawable = null;
        if (this.f726KB != 0) {
            drawable = m662a(context, izVar, this.f726KB);
        }
        mo4395a(drawable, false, true, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4394a(Context context, C1356iz izVar, boolean z) {
        Drawable drawable = null;
        if (this.f727KC != 0) {
            drawable = m662a(context, izVar, this.f727KC);
        }
        if (this.f728KD != null) {
            this.f728KD.onImageLoaded(this.f725KA.uri, drawable, false);
        }
        mo4395a(drawable, z, false, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo4395a(Drawable drawable, boolean z, boolean z2, boolean z3);

    /* renamed from: aw */
    public void mo4396aw(int i) {
        this.f727KC = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo4397b(boolean z, boolean z2) {
        return this.f729KE && !z2 && (!z || this.f730KF);
    }
}
