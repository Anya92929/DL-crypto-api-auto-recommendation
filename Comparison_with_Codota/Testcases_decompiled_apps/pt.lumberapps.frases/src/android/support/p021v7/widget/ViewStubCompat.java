package android.support.p021v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.p021v7.p023b.C0515k;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.widget.ViewStubCompat */
public final class ViewStubCompat extends View {

    /* renamed from: a */
    private int f1343a;

    /* renamed from: b */
    private int f1344b;

    /* renamed from: c */
    private WeakReference f1345c;

    /* renamed from: d */
    private LayoutInflater f1346d;

    /* renamed from: e */
    private C0681dy f1347e;

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1343a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0515k.ViewStubCompat, i, 0);
        this.f1344b = obtainStyledAttributes.getResourceId(C0515k.ViewStubCompat_android_inflatedId, -1);
        this.f1343a = obtainStyledAttributes.getResourceId(C0515k.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(C0515k.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    /* renamed from: a */
    public View mo2898a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f1343a != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            View inflate = (this.f1346d != null ? this.f1346d : LayoutInflater.from(getContext())).inflate(this.f1343a, viewGroup, false);
            if (this.f1344b != -1) {
                inflate.setId(this.f1344b);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f1345c = new WeakReference(inflate);
            if (this.f1347e != null) {
                this.f1347e.mo3348a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f1344b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f1346d;
    }

    public int getLayoutResource() {
        return this.f1343a;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f1344b = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f1346d = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f1343a = i;
    }

    public void setOnInflateListener(C0681dy dyVar) {
        this.f1347e = dyVar;
    }

    public void setVisibility(int i) {
        if (this.f1345c != null) {
            View view = (View) this.f1345c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            mo2898a();
        }
    }
}
