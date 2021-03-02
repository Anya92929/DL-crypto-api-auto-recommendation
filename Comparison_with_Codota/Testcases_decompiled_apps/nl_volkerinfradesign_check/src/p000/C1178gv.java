package p000;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.p004v7.widget.TintManager;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: gv */
class C1178gv extends C1177gu {

    /* renamed from: b */
    private static final int[] f4197b = {16843666, 16843667};

    /* renamed from: c */
    private C1191hc f4198c;

    /* renamed from: d */
    private C1191hc f4199d;

    C1178gv(TextView textView) {
        super(textView);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8205a(AttributeSet attributeSet, int i) {
        super.mo8205a(attributeSet, i);
        Context context = this.f4192a.getContext();
        TintManager tintManager = TintManager.get(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4197b, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f4198c = m5218a(context, tintManager, obtainStyledAttributes.getResourceId(0, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f4199d = m5218a(context, tintManager, obtainStyledAttributes.getResourceId(1, 0));
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8202a() {
        super.mo8202a();
        if (this.f4198c != null || this.f4199d != null) {
            Drawable[] compoundDrawablesRelative = this.f4192a.getCompoundDrawablesRelative();
            mo8204a(compoundDrawablesRelative[0], this.f4198c);
            mo8204a(compoundDrawablesRelative[2], this.f4199d);
        }
    }
}
