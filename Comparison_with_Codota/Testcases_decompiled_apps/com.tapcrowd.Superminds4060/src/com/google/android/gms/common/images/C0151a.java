package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.internal.C0377cz;
import com.google.android.gms.internal.C0383da;
import com.google.android.gms.internal.C0384db;
import com.google.android.gms.internal.C0408dl;
import com.google.android.gms.internal.C0441ek;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.images.a */
public final class C0151a {

    /* renamed from: jS */
    final C0152a f413jS;

    /* renamed from: jT */
    private int f414jT;

    /* renamed from: jU */
    private int f415jU;

    /* renamed from: jV */
    int f416jV;

    /* renamed from: jW */
    private int f417jW;

    /* renamed from: jX */
    private WeakReference<ImageManager.OnImageLoadedListener> f418jX;

    /* renamed from: jY */
    private WeakReference<ImageView> f419jY;

    /* renamed from: jZ */
    private WeakReference<TextView> f420jZ;

    /* renamed from: ka */
    private int f421ka;

    /* renamed from: kb */
    private boolean f422kb;

    /* renamed from: kc */
    private boolean f423kc;

    /* renamed from: com.google.android.gms.common.images.a$a */
    public static final class C0152a {
        public final Uri uri;

        public C0152a(Uri uri2) {
            this.uri = uri2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0152a)) {
                return false;
            }
            return this == obj || ((C0152a) obj).hashCode() == hashCode();
        }

        public int hashCode() {
            return C0408dl.hashCode(this.uri);
        }
    }

    public C0151a(int i) {
        this.f414jT = 0;
        this.f415jU = 0;
        this.f421ka = -1;
        this.f422kb = true;
        this.f423kc = false;
        this.f413jS = new C0152a((Uri) null);
        this.f415jU = i;
    }

    public C0151a(Uri uri) {
        this.f414jT = 0;
        this.f415jU = 0;
        this.f421ka = -1;
        this.f422kb = true;
        this.f423kc = false;
        this.f413jS = new C0152a(uri);
        this.f415jU = 0;
    }

    /* renamed from: a */
    private C0377cz m293a(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof C0377cz) {
            drawable = ((C0377cz) drawable).mo4290aS();
        }
        return new C0377cz(drawable, drawable2);
    }

    /* renamed from: a */
    private void m294a(Drawable drawable, boolean z, boolean z2, boolean z3) {
        ImageManager.OnImageLoadedListener onImageLoadedListener;
        switch (this.f416jV) {
            case 1:
                if (!z2 && (onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.f418jX.get()) != null) {
                    onImageLoadedListener.onImageLoaded(this.f413jS.uri, drawable);
                    return;
                }
                return;
            case 2:
                ImageView imageView = (ImageView) this.f419jY.get();
                if (imageView != null) {
                    m295a(imageView, drawable, z, z2, z3);
                    return;
                }
                return;
            case 3:
                TextView textView = (TextView) this.f420jZ.get();
                if (textView != null) {
                    m296a(textView, this.f421ka, drawable, z, z2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m295a(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
        boolean z4 = !z2 && !z3;
        if (z4 && (imageView instanceof C0383da)) {
            int aU = ((C0383da) imageView).mo4319aU();
            if (this.f415jU != 0 && aU == this.f415jU) {
                return;
            }
        }
        boolean a = m297a(z, z2);
        Drawable a2 = a ? m293a(imageView.getDrawable(), drawable) : drawable;
        imageView.setImageDrawable(a2);
        if (imageView instanceof C0383da) {
            C0383da daVar = (C0383da) imageView;
            daVar.mo4320d(z3 ? this.f413jS.uri : null);
            daVar.mo4321w(z4 ? this.f415jU : 0);
        }
        if (a) {
            ((C0377cz) a2).startTransition(250);
        }
    }

    /* renamed from: a */
    private void m296a(TextView textView, int i, Drawable drawable, boolean z, boolean z2) {
        boolean a = m297a(z, z2);
        Drawable[] compoundDrawablesRelative = C0441ek.m1091bO() ? textView.getCompoundDrawablesRelative() : textView.getCompoundDrawables();
        Drawable a2 = a ? m293a(compoundDrawablesRelative[i], drawable) : drawable;
        Drawable drawable2 = i == 0 ? a2 : compoundDrawablesRelative[0];
        Drawable drawable3 = i == 1 ? a2 : compoundDrawablesRelative[1];
        Drawable drawable4 = i == 2 ? a2 : compoundDrawablesRelative[2];
        Drawable drawable5 = i == 3 ? a2 : compoundDrawablesRelative[3];
        if (C0441ek.m1091bO()) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable5);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable5);
        }
        if (a) {
            ((C0377cz) a2).startTransition(250);
        }
    }

    /* renamed from: a */
    private boolean m297a(boolean z, boolean z2) {
        return this.f422kb && !z2 && (!z || this.f423kc);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3644a(Context context, Bitmap bitmap, boolean z) {
        C0384db.m830c(bitmap);
        m294a(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    /* renamed from: a */
    public void mo3645a(ImageView imageView) {
        C0384db.m830c(imageView);
        this.f418jX = null;
        this.f419jY = new WeakReference<>(imageView);
        this.f420jZ = null;
        this.f421ka = -1;
        this.f416jV = 2;
        this.f417jW = imageView.hashCode();
    }

    /* renamed from: a */
    public void mo3646a(ImageManager.OnImageLoadedListener onImageLoadedListener) {
        C0384db.m830c(onImageLoadedListener);
        this.f418jX = new WeakReference<>(onImageLoadedListener);
        this.f419jY = null;
        this.f420jZ = null;
        this.f421ka = -1;
        this.f416jV = 1;
        this.f417jW = C0408dl.hashCode(onImageLoadedListener, this.f413jS);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3647b(Context context, boolean z) {
        Drawable drawable = null;
        if (this.f415jU != 0) {
            drawable = context.getResources().getDrawable(this.f415jU);
        }
        m294a(drawable, z, false, false);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0151a)) {
            return false;
        }
        return this == obj || ((C0151a) obj).hashCode() == hashCode();
    }

    public int hashCode() {
        return this.f417jW;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo3650r(Context context) {
        Drawable drawable = null;
        if (this.f414jT != 0) {
            drawable = context.getResources().getDrawable(this.f414jT);
        }
        m294a(drawable, false, true, false);
    }

    /* renamed from: v */
    public void mo3651v(int i) {
        this.f415jU = i;
    }
}
