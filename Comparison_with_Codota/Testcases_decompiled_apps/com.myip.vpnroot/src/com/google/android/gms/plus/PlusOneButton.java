package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.C0351q;
import com.google.android.gms.plus.internal.C1965g;

public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    /* access modifiers changed from: private */
    public View ala;
    private int alb;
    /* access modifiers changed from: private */
    public int alc;
    private OnPlusOneClickListener ald;
    private int mSize;

    /* renamed from: uR */
    private String f4498uR;

    protected class DefaultOnPlusOneClickListener implements View.OnClickListener, OnPlusOneClickListener {
        private final OnPlusOneClickListener ale;

        public DefaultOnPlusOneClickListener(OnPlusOneClickListener proxy) {
            this.ale = proxy;
        }

        public void onClick(View view) {
            Intent intent = (Intent) PlusOneButton.this.ala.getTag();
            if (this.ale != null) {
                this.ale.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        public void onPlusOneClick(Intent intent) {
            Context context = PlusOneButton.this.getContext();
            if ((context instanceof Activity) && intent != null) {
                ((Activity) context).startActivityForResult(intent, PlusOneButton.this.alc);
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
        this.alb = getAnnotation(context, attrs);
        this.alc = -1;
        m6534G(getContext());
        if (isInEditMode()) {
        }
    }

    /* renamed from: G */
    private void m6534G(Context context) {
        if (this.ala != null) {
            removeView(this.ala);
        }
        this.ala = C1965g.m6648a(context, this.mSize, this.alb, this.f4498uR, this.alc);
        setOnPlusOneClickListener(this.ald);
        addView(this.ala);
    }

    protected static int getAnnotation(Context context, AttributeSet attrs) {
        String a = C0351q.m871a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attrs, true, false, "PlusOneButton");
        if ("INLINE".equalsIgnoreCase(a)) {
            return 2;
        }
        return !"NONE".equalsIgnoreCase(a) ? 1 : 0;
    }

    protected static int getSize(Context context, AttributeSet attrs) {
        String a = C0351q.m871a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attrs, true, false, "PlusOneButton");
        if ("SMALL".equalsIgnoreCase(a)) {
            return 0;
        }
        if ("MEDIUM".equalsIgnoreCase(a)) {
            return 1;
        }
        return "TALL".equalsIgnoreCase(a) ? 2 : 3;
    }

    public void initialize(String url, int activityRequestCode) {
        C0348n.m852a(getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        this.f4498uR = url;
        this.alc = activityRequestCode;
        m6534G(getContext());
    }

    public void initialize(String url, OnPlusOneClickListener plusOneClickListener) {
        this.f4498uR = url;
        this.alc = 0;
        m6534G(getContext());
        setOnPlusOneClickListener(plusOneClickListener);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.ala.layout(0, 0, right - left, bottom - top);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View view = this.ala;
        measureChild(view, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setAnnotation(int annotation) {
        this.alb = annotation;
        m6534G(getContext());
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener listener) {
        this.ald = listener;
        this.ala.setOnClickListener(new DefaultOnPlusOneClickListener(listener));
    }

    public void setSize(int size) {
        this.mSize = size;
        m6534G(getContext());
    }
}
