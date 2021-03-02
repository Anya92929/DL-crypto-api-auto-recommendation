package android.support.p003v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.p003v7.appcompat.C0235R;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.internal.widget.ViewStubCompat */
public final class ViewStubCompat extends View {

    /* renamed from: a */
    private int f2420a;

    /* renamed from: b */
    private int f2421b;

    /* renamed from: c */
    private WeakReference<View> f2422c;

    /* renamed from: d */
    private LayoutInflater f2423d;

    /* renamed from: e */
    private OnInflateListener f2424e;

    /* renamed from: android.support.v7.internal.widget.ViewStubCompat$OnInflateListener */
    public interface OnInflateListener {
        void onInflate(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2420a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0235R.styleable.ViewStubCompat, i, 0);
        this.f2421b = obtainStyledAttributes.getResourceId(C0235R.styleable.ViewStubCompat_android_inflatedId, -1);
        this.f2420a = obtainStyledAttributes.getResourceId(C0235R.styleable.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(C0235R.styleable.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f2421b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f2423d;
    }

    public int getLayoutResource() {
        return this.f2420a;
    }

    public View inflate() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f2420a != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            View inflate = (this.f2423d != null ? this.f2423d : LayoutInflater.from(getContext())).inflate(this.f2420a, viewGroup, false);
            if (this.f2421b != -1) {
                inflate.setId(this.f2421b);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f2422c = new WeakReference<>(inflate);
            if (this.f2424e != null) {
                this.f2424e.onInflate(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f2421b = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f2423d = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f2420a = i;
    }

    public void setOnInflateListener(OnInflateListener onInflateListener) {
        this.f2424e = onInflateListener;
    }

    public void setVisibility(int i) {
        if (this.f2422c != null) {
            View view = (View) this.f2422c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            inflate();
        }
    }
}
