package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.internal.C0411dm;
import com.google.android.gms.internal.C0414dp;
import com.google.android.gms.internal.C0553fm;

public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;

    /* renamed from: hN */
    private String f1794hN;
    private int mSize;
    /* access modifiers changed from: private */

    /* renamed from: re */
    public View f1795re;

    /* renamed from: rf */
    private int f1796rf;
    /* access modifiers changed from: private */

    /* renamed from: rg */
    public int f1797rg;

    /* renamed from: rh */
    private OnPlusOneClickListener f1798rh;

    protected class DefaultOnPlusOneClickListener implements View.OnClickListener, OnPlusOneClickListener {

        /* renamed from: ri */
        private final OnPlusOneClickListener f1799ri;

        public DefaultOnPlusOneClickListener(OnPlusOneClickListener proxy) {
            this.f1799ri = proxy;
        }

        public void onClick(View view) {
            Intent intent = (Intent) PlusOneButton.this.f1795re.getTag();
            if (this.f1799ri != null) {
                this.f1799ri.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        public void onPlusOneClick(Intent intent) {
            Context context = PlusOneButton.this.getContext();
            if ((context instanceof Activity) && intent != null) {
                ((Activity) context).startActivityForResult(intent, PlusOneButton.this.f1797rg);
            }
        }
    }

    public interface OnPlusOneClickListener {
        void onPlusOneClick(Intent intent);
    }

    public PlusOneButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public PlusOneButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mSize = getSize(context, attrs);
        this.f1796rf = getAnnotation(context, attrs);
        this.f1797rg = -1;
        m2157p(getContext());
        if (isInEditMode()) {
        }
    }

    protected static int getAnnotation(Context context, AttributeSet attrs) {
        String a = C0414dp.m958a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attrs, true, false, "PlusOneButton");
        if ("INLINE".equalsIgnoreCase(a)) {
            return 2;
        }
        return !"NONE".equalsIgnoreCase(a) ? 1 : 0;
    }

    protected static int getSize(Context context, AttributeSet attrs) {
        String a = C0414dp.m958a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attrs, true, false, "PlusOneButton");
        if ("SMALL".equalsIgnoreCase(a)) {
            return 0;
        }
        if ("MEDIUM".equalsIgnoreCase(a)) {
            return 1;
        }
        return "TALL".equalsIgnoreCase(a) ? 2 : 3;
    }

    /* renamed from: p */
    private void m2157p(Context context) {
        if (this.f1795re != null) {
            removeView(this.f1795re);
        }
        this.f1795re = C0553fm.m1658a(context, this.mSize, this.f1796rf, this.f1794hN, this.f1797rg);
        setOnPlusOneClickListener(this.f1798rh);
        addView(this.f1795re);
    }

    public void initialize(String url, int activityRequestCode) {
        C0411dm.m941a(getContext() instanceof Activity, (Object) "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(PlusClient, String, OnPlusOneClickListener).");
        this.f1794hN = url;
        this.f1797rg = activityRequestCode;
        m2157p(getContext());
    }

    public void initialize(String url, OnPlusOneClickListener plusOneClickListener) {
        this.f1794hN = url;
        this.f1797rg = 0;
        m2157p(getContext());
        setOnPlusOneClickListener(plusOneClickListener);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.f1795re.layout(0, 0, right - left, bottom - top);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View view = this.f1795re;
        measureChild(view, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setAnnotation(int annotation) {
        this.f1796rf = annotation;
        m2157p(getContext());
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener listener) {
        this.f1798rh = listener;
        this.f1795re.setOnClickListener(new DefaultOnPlusOneClickListener(listener));
    }

    public void setSize(int size) {
        this.mSize = size;
        m2157p(getContext());
    }
}
