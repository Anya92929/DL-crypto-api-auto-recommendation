package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.text.AllCapsTransformationMethod;
import android.support.p004v7.widget.TintManager;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: gu */
public class C1177gu {

    /* renamed from: b */
    private static final int[] f4190b = {16842804, 16843119, 16843117, 16843120, 16843118};

    /* renamed from: c */
    private static final int[] f4191c = {C0505R.attr.textAllCaps};

    /* renamed from: a */
    final TextView f4192a;

    /* renamed from: d */
    private C1191hc f4193d;

    /* renamed from: e */
    private C1191hc f4194e;

    /* renamed from: f */
    private C1191hc f4195f;

    /* renamed from: g */
    private C1191hc f4196g;

    /* renamed from: a */
    public static C1177gu m5217a(TextView textView) {
        if (Build.VERSION.SDK_INT >= 17) {
            return new C1178gv(textView);
        }
        return new C1177gu(textView);
    }

    C1177gu(TextView textView) {
        this.f4192a = textView;
    }

    /* renamed from: a */
    public void mo8205a(AttributeSet attributeSet, int i) {
        Context context = this.f4192a.getContext();
        TintManager tintManager = TintManager.get(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4190b, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (obtainStyledAttributes.hasValue(1)) {
            this.f4193d = m5218a(context, tintManager, obtainStyledAttributes.getResourceId(1, 0));
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.f4194e = m5218a(context, tintManager, obtainStyledAttributes.getResourceId(2, 0));
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.f4195f = m5218a(context, tintManager, obtainStyledAttributes.getResourceId(3, 0));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            this.f4196g = m5218a(context, tintManager, obtainStyledAttributes.getResourceId(4, 0));
        }
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, C0505R.styleable.TextAppearance);
            if (obtainStyledAttributes2.hasValue(C0505R.styleable.TextAppearance_textAllCaps)) {
                mo8206a(obtainStyledAttributes2.getBoolean(C0505R.styleable.TextAppearance_textAllCaps, false));
            }
            obtainStyledAttributes2.recycle();
        }
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f4191c, i, 0);
        if (obtainStyledAttributes3.getBoolean(0, false)) {
            mo8206a(true);
        }
        obtainStyledAttributes3.recycle();
    }

    /* renamed from: a */
    public void mo8203a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, f4191c);
        if (obtainStyledAttributes.hasValue(0)) {
            mo8206a(obtainStyledAttributes.getBoolean(0, false));
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public void mo8206a(boolean z) {
        this.f4192a.setTransformationMethod(z ? new AllCapsTransformationMethod(this.f4192a.getContext()) : null);
    }

    /* renamed from: a */
    public void mo8202a() {
        if (this.f4193d != null || this.f4194e != null || this.f4195f != null || this.f4196g != null) {
            Drawable[] compoundDrawables = this.f4192a.getCompoundDrawables();
            mo8204a(compoundDrawables[0], this.f4193d);
            mo8204a(compoundDrawables[1], this.f4194e);
            mo8204a(compoundDrawables[2], this.f4195f);
            mo8204a(compoundDrawables[3], this.f4196g);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo8204a(Drawable drawable, C1191hc hcVar) {
        if (drawable != null && hcVar != null) {
            TintManager.tintDrawable(drawable, hcVar, this.f4192a.getDrawableState());
        }
    }

    /* renamed from: a */
    protected static C1191hc m5218a(Context context, TintManager tintManager, int i) {
        ColorStateList tintList = tintManager.getTintList(i);
        if (tintList == null) {
            return null;
        }
        C1191hc hcVar = new C1191hc();
        hcVar.f4252d = true;
        hcVar.f4249a = tintList;
        return null;
    }
}
