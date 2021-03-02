package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.internal.C0538bu;
import com.google.android.gms.internal.C0621s;
import com.google.android.gms.internal.C0624v;

public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;

    /* renamed from: O */
    private int f1660O;
    /* access modifiers changed from: private */

    /* renamed from: ic */
    public View f1661ic;

    /* renamed from: id */
    private int f1662id;

    /* renamed from: ie */
    private String f1663ie;
    /* access modifiers changed from: private */

    /* renamed from: if */
    public int f1664if;

    /* renamed from: ig */
    private OnPlusOneClickListener f1665ig;

    protected class DefaultOnPlusOneClickListener implements View.OnClickListener, OnPlusOneClickListener {

        /* renamed from: ih */
        private final OnPlusOneClickListener f1666ih;

        public DefaultOnPlusOneClickListener(OnPlusOneClickListener proxy) {
            this.f1666ih = proxy;
        }

        public void onClick(View view) {
            Intent intent = (Intent) PlusOneButton.this.f1661ic.getTag();
            if (this.f1666ih != null) {
                this.f1666ih.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        public void onPlusOneClick(Intent intent) {
            Context context = PlusOneButton.this.getContext();
            if ((context instanceof Activity) && intent != null) {
                ((Activity) context).startActivityForResult(intent, PlusOneButton.this.f1664if);
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
        this.f1660O = getSize(context, attrs);
        this.f1662id = getAnnotation(context, attrs);
        this.f1664if = -1;
        m2117d(getContext());
        if (isInEditMode()) {
        }
    }

    /* renamed from: d */
    private void m2117d(Context context) {
        if (this.f1661ic != null) {
            removeView(this.f1661ic);
        }
        this.f1661ic = C0538bu.m1531a(context, this.f1660O, this.f1662id, this.f1663ie, this.f1664if);
        setOnPlusOneClickListener(this.f1665ig);
        addView(this.f1661ic);
    }

    protected static int getAnnotation(Context context, AttributeSet attrs) {
        String a = C0624v.m1900a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attrs, true, false, "PlusOneButton");
        if ("INLINE".equalsIgnoreCase(a)) {
            return 2;
        }
        return !"NONE".equalsIgnoreCase(a) ? 1 : 0;
    }

    protected static int getSize(Context context, AttributeSet attrs) {
        String a = C0624v.m1900a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attrs, true, false, "PlusOneButton");
        if ("SMALL".equalsIgnoreCase(a)) {
            return 0;
        }
        if ("MEDIUM".equalsIgnoreCase(a)) {
            return 1;
        }
        return "TALL".equalsIgnoreCase(a) ? 2 : 3;
    }

    public void initialize(String url, int activityRequestCode) {
        C0621s.m1885a(getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(PlusClient, String, OnPlusOneClickListener).");
        this.f1663ie = url;
        this.f1664if = activityRequestCode;
        m2117d(getContext());
    }

    public void initialize(String url, OnPlusOneClickListener plusOneClickListener) {
        this.f1663ie = url;
        this.f1664if = 0;
        m2117d(getContext());
        setOnPlusOneClickListener(plusOneClickListener);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.f1661ic.layout(0, 0, right - left, bottom - top);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View view = this.f1661ic;
        measureChild(view, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setAnnotation(int annotation) {
        this.f1662id = annotation;
        m2117d(getContext());
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener listener) {
        this.f1665ig = listener;
        this.f1661ic.setOnClickListener(new DefaultOnPlusOneClickListener(listener));
    }

    public void setSize(int size) {
        this.f1660O = size;
        m2117d(getContext());
    }
}
