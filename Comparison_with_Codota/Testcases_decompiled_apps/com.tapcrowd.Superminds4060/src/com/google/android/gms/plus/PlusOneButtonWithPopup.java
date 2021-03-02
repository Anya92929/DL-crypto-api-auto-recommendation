package com.google.android.gms.plus;

import android.app.PendingIntent;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.C0411dm;
import com.google.android.gms.internal.C0540fj;
import com.google.android.gms.internal.C0553fm;

public final class PlusOneButtonWithPopup extends ViewGroup {

    /* renamed from: hN */
    private String f1801hN;

    /* renamed from: it */
    private String f1802it;
    private int mSize;

    /* renamed from: re */
    private View f1803re;

    /* renamed from: rf */
    private int f1804rf;

    /* renamed from: rk */
    private View.OnClickListener f1805rk;

    public PlusOneButtonWithPopup(Context context) {
        this(context, (AttributeSet) null);
    }

    public PlusOneButtonWithPopup(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mSize = PlusOneButton.getSize(context, attrs);
        this.f1804rf = PlusOneButton.getAnnotation(context, attrs);
        this.f1803re = new PlusOneDummyView(context, this.mSize);
        addView(this.f1803re);
    }

    /* renamed from: c */
    private int m2158c(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i) - i2, mode);
            default:
                return i;
        }
    }

    /* renamed from: cS */
    private void m2159cS() {
        if (this.f1803re != null) {
            removeView(this.f1803re);
        }
        this.f1803re = C0553fm.m1659a(getContext(), this.mSize, this.f1804rf, this.f1801hN, this.f1802it);
        if (this.f1805rk != null) {
            setOnClickListener(this.f1805rk);
        }
        addView(this.f1803re);
    }

    /* renamed from: cT */
    private C0540fj m2160cT() throws RemoteException {
        C0540fj ap = C0540fj.C0541a.m1607ap((IBinder) this.f1803re.getTag());
        if (ap != null) {
            return ap;
        }
        if (Log.isLoggable("PlusOneButtonWithPopup", 5)) {
            Log.w("PlusOneButtonWithPopup", "Failed to get PlusOneDelegate");
        }
        throw new RemoteException();
    }

    public void cancelClick() {
        if (this.f1803re != null) {
            try {
                m2160cT().cancelClick();
            } catch (RemoteException e) {
            }
        }
    }

    public PendingIntent getResolution() {
        if (this.f1803re != null) {
            try {
                return m2160cT().getResolution();
            } catch (RemoteException e) {
            }
        }
        return null;
    }

    public void initialize(String url, String accountName) {
        C0411dm.m940a(url, (Object) "Url must not be null");
        this.f1801hN = url;
        this.f1802it = accountName;
        m2159cS();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.f1803re.layout(getPaddingLeft(), getPaddingTop(), (right - left) - getPaddingRight(), (bottom - top) - getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        this.f1803re.measure(m2158c(widthMeasureSpec, paddingLeft), m2158c(heightMeasureSpec, paddingTop));
        setMeasuredDimension(paddingLeft + this.f1803re.getMeasuredWidth(), paddingTop + this.f1803re.getMeasuredHeight());
    }

    public void reinitialize() {
        if (this.f1803re != null) {
            try {
                m2160cT().reinitialize();
            } catch (RemoteException e) {
            }
        }
    }

    public void setAnnotation(int annotation) {
        this.f1804rf = annotation;
        m2159cS();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f1805rk = onClickListener;
        this.f1803re.setOnClickListener(onClickListener);
    }

    public void setSize(int size) {
        this.mSize = size;
        m2159cS();
    }
}
