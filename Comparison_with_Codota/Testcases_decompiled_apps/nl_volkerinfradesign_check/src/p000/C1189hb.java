package p000;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.p004v7.widget.TintManager;

/* renamed from: hb */
public class C1189hb extends ContextWrapper {

    /* renamed from: a */
    private Resources f4247a;

    /* renamed from: a */
    public static Context m5259a(Context context) {
        if (!(context instanceof C1189hb)) {
            return new C1189hb(context);
        }
        return context;
    }

    private C1189hb(Context context) {
        super(context);
    }

    public Resources getResources() {
        if (this.f4247a == null) {
            this.f4247a = new C1190a(super.getResources(), TintManager.get(this));
        }
        return this.f4247a;
    }

    /* renamed from: hb$a */
    static class C1190a extends C1180gx {

        /* renamed from: a */
        private final TintManager f4248a;

        public C1190a(Resources resources, TintManager tintManager) {
            super(resources);
            this.f4248a = tintManager;
        }

        public Drawable getDrawable(int i) throws Resources.NotFoundException {
            Drawable drawable = super.getDrawable(i);
            if (drawable != null) {
                this.f4248a.tintDrawableUsingColorFilter(i, drawable);
            }
            return drawable;
        }
    }
}
