package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.internal.C0427as;
import com.google.android.gms.internal.C0588f;
import com.google.android.gms.internal.C0593g;
import com.google.android.gms.internal.C0594h;
import com.google.android.gms.internal.C0618r;
import com.parse.ParseException;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.images.a */
public final class C0355a {

    /* renamed from: aG */
    final C0356a f839aG;

    /* renamed from: aH */
    private int f840aH;

    /* renamed from: aI */
    private int f841aI;

    /* renamed from: aJ */
    int f842aJ;

    /* renamed from: aK */
    private int f843aK;

    /* renamed from: aL */
    private WeakReference<ImageManager.OnImageLoadedListener> f844aL;

    /* renamed from: aM */
    private WeakReference<ImageView> f845aM;

    /* renamed from: aN */
    private WeakReference<TextView> f846aN;

    /* renamed from: aO */
    private int f847aO;

    /* renamed from: aP */
    private boolean f848aP;

    /* renamed from: aQ */
    private boolean f849aQ;

    /* renamed from: com.google.android.gms.common.images.a$a */
    public static final class C0356a {
        public final Uri uri;

        public C0356a(Uri uri2) {
            this.uri = uri2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0356a)) {
                return false;
            }
            return this == obj || ((C0356a) obj).hashCode() == hashCode();
        }

        public int hashCode() {
            return C0618r.hashCode(this.uri);
        }
    }

    public C0355a(int i) {
        this.f840aH = 0;
        this.f841aI = 0;
        this.f847aO = -1;
        this.f848aP = true;
        this.f849aQ = false;
        this.f839aG = new C0356a((Uri) null);
        this.f841aI = i;
    }

    public C0355a(Uri uri) {
        this.f840aH = 0;
        this.f841aI = 0;
        this.f847aO = -1;
        this.f848aP = true;
        this.f849aQ = false;
        this.f839aG = new C0356a(uri);
        this.f841aI = 0;
    }

    /* renamed from: a */
    private C0588f m616a(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof C0588f) {
            drawable = ((C0588f) drawable).mo5408r();
        }
        return new C0588f(drawable, drawable2);
    }

    /* renamed from: a */
    private void m617a(Drawable drawable, boolean z, boolean z2, boolean z3) {
        ImageManager.OnImageLoadedListener onImageLoadedListener;
        switch (this.f842aJ) {
            case 1:
                if (!z2 && (onImageLoadedListener = (ImageManager.OnImageLoadedListener) this.f844aL.get()) != null) {
                    onImageLoadedListener.onImageLoaded(this.f839aG.uri, drawable);
                    return;
                }
                return;
            case 2:
                ImageView imageView = (ImageView) this.f845aM.get();
                if (imageView != null) {
                    m618a(imageView, drawable, z, z2, z3);
                    return;
                }
                return;
            case 3:
                TextView textView = (TextView) this.f846aN.get();
                if (textView != null) {
                    m619a(textView, this.f847aO, drawable, z, z2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m618a(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
        boolean z4 = !z2 && !z3;
        if (z4 && (imageView instanceof C0593g)) {
            int t = ((C0593g) imageView).mo5425t();
            if (this.f841aI != 0 && t == this.f841aI) {
                return;
            }
        }
        boolean a = m620a(z, z2);
        Drawable a2 = a ? m616a(imageView.getDrawable(), drawable) : drawable;
        imageView.setImageDrawable(a2);
        if (imageView instanceof C0593g) {
            C0593g gVar = (C0593g) imageView;
            gVar.mo5423a(z3 ? this.f839aG.uri : null);
            gVar.mo5424k(z4 ? this.f841aI : 0);
        }
        if (a) {
            ((C0588f) a2).startTransition(ParseException.LINKED_ID_MISSING);
        }
    }

    /* renamed from: a */
    private void m619a(TextView textView, int i, Drawable drawable, boolean z, boolean z2) {
        boolean a = m620a(z, z2);
        Drawable[] compoundDrawablesRelative = C0427as.m914as() ? textView.getCompoundDrawablesRelative() : textView.getCompoundDrawables();
        Drawable a2 = a ? m616a(compoundDrawablesRelative[i], drawable) : drawable;
        Drawable drawable2 = i == 0 ? a2 : compoundDrawablesRelative[0];
        Drawable drawable3 = i == 1 ? a2 : compoundDrawablesRelative[1];
        Drawable drawable4 = i == 2 ? a2 : compoundDrawablesRelative[2];
        Drawable drawable5 = i == 3 ? a2 : compoundDrawablesRelative[3];
        if (C0427as.m914as()) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable5);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable5);
        }
        if (a) {
            ((C0588f) a2).startTransition(ParseException.LINKED_ID_MISSING);
        }
    }

    /* renamed from: a */
    private boolean m620a(boolean z, boolean z2) {
        return this.f848aP && !z2 && (!z || this.f849aQ);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4094a(Context context, Bitmap bitmap, boolean z) {
        C0594h.m1779b(bitmap);
        m617a(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    /* renamed from: a */
    public void mo4095a(ImageView imageView) {
        C0594h.m1779b(imageView);
        this.f844aL = null;
        this.f845aM = new WeakReference<>(imageView);
        this.f846aN = null;
        this.f847aO = -1;
        this.f842aJ = 2;
        this.f843aK = imageView.hashCode();
    }

    /* renamed from: a */
    public void mo4096a(ImageManager.OnImageLoadedListener onImageLoadedListener) {
        C0594h.m1779b(onImageLoadedListener);
        this.f844aL = new WeakReference<>(onImageLoadedListener);
        this.f845aM = null;
        this.f846aN = null;
        this.f847aO = -1;
        this.f842aJ = 1;
        this.f843aK = C0618r.hashCode(onImageLoadedListener, this.f839aG);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4097b(Context context, boolean z) {
        Drawable drawable = null;
        if (this.f841aI != 0) {
            drawable = context.getResources().getDrawable(this.f841aI);
        }
        m617a(drawable, z, false, false);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0355a)) {
            return false;
        }
        return this == obj || ((C0355a) obj).hashCode() == hashCode();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo4099f(Context context) {
        Drawable drawable = null;
        if (this.f840aH != 0) {
            drawable = context.getResources().getDrawable(this.f840aH);
        }
        m617a(drawable, false, true, false);
    }

    public int hashCode() {
        return this.f843aK;
    }

    /* renamed from: j */
    public void mo4101j(int i) {
        this.f841aI = i;
    }
}
