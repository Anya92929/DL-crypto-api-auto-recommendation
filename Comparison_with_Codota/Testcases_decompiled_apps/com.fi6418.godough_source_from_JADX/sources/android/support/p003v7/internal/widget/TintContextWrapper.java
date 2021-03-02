package android.support.p003v7.internal.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v7.internal.widget.TintContextWrapper */
public class TintContextWrapper extends ContextWrapper {

    /* renamed from: a */
    private Resources f2377a;

    /* renamed from: android.support.v7.internal.widget.TintContextWrapper$TintResources */
    class TintResources extends ResourcesWrapper {

        /* renamed from: a */
        private final TintManager f2378a;

        public TintResources(Resources resources, TintManager tintManager) {
            super(resources);
            this.f2378a = tintManager;
        }

        public Drawable getDrawable(int i) {
            Drawable drawable = super.getDrawable(i);
            if (drawable != null) {
                this.f2378a.tintDrawableUsingColorFilter(i, drawable);
            }
            return drawable;
        }
    }

    private TintContextWrapper(Context context) {
        super(context);
    }

    public static Context wrap(Context context) {
        return !(context instanceof TintContextWrapper) ? new TintContextWrapper(context) : context;
    }

    public Resources getResources() {
        if (this.f2377a == null) {
            this.f2377a = new TintResources(super.getResources(), TintManager.get(this));
        }
        return this.f2377a;
    }
}
