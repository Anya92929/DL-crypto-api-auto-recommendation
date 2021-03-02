package android.support.p004v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.p004v7.appcompat.C0505R;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.widget.ViewStubCompat */
public final class ViewStubCompat extends View {

    /* renamed from: a */
    private int f2392a;

    /* renamed from: b */
    private int f2393b;

    /* renamed from: c */
    private WeakReference<View> f2394c;

    /* renamed from: d */
    private LayoutInflater f2395d;

    /* renamed from: e */
    private OnInflateListener f2396e;

    /* renamed from: android.support.v7.widget.ViewStubCompat$OnInflateListener */
    public interface OnInflateListener {
        void onInflate(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2392a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0505R.styleable.ViewStubCompat, i, 0);
        this.f2393b = obtainStyledAttributes.getResourceId(C0505R.styleable.ViewStubCompat_android_inflatedId, -1);
        this.f2392a = obtainStyledAttributes.getResourceId(C0505R.styleable.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(C0505R.styleable.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public int getInflatedId() {
        return this.f2393b;
    }

    public void setInflatedId(int i) {
        this.f2393b = i;
    }

    public int getLayoutResource() {
        return this.f2392a;
    }

    public void setLayoutResource(int i) {
        this.f2392a = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f2395d = layoutInflater;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f2395d;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void draw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    public void setVisibility(int i) {
        if (this.f2394c != null) {
            View view = (View) this.f2394c.get();
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

    public View inflate() {
        LayoutInflater from;
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f2392a != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (this.f2395d != null) {
                from = this.f2395d;
            } else {
                from = LayoutInflater.from(getContext());
            }
            View inflate = from.inflate(this.f2392a, viewGroup, false);
            if (this.f2393b != -1) {
                inflate.setId(this.f2393b);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f2394c = new WeakReference<>(inflate);
            if (this.f2396e != null) {
                this.f2396e.onInflate(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    public void setOnInflateListener(OnInflateListener onInflateListener) {
        this.f2396e = onInflateListener;
    }
}
