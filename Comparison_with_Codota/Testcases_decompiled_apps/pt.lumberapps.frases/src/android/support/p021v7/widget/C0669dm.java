package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.widget.dm */
class C0669dm extends C0650cu {

    /* renamed from: a */
    private final WeakReference f1649a;

    public C0669dm(Context context, Resources resources) {
        super(resources);
        this.f1649a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.f1649a.get();
        if (!(drawable == null || context == null)) {
            C0591ap.m2736a();
            C0591ap.m2742a(context, i, drawable);
        }
        return drawable;
    }
}
