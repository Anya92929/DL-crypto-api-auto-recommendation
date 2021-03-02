package com.google.android.gms.plus;

import android.app.PendingIntent;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.C0525br;
import com.google.android.gms.internal.C0538bu;
import com.google.android.gms.internal.C0621s;

public final class PlusOneButtonWithPopup extends ViewGroup {

    /* renamed from: O */
    private int f1668O;

    /* renamed from: g */
    private String f1669g;

    /* renamed from: ic */
    private View f1670ic;

    /* renamed from: id */
    private int f1671id;

    /* renamed from: ie */
    private String f1672ie;

    /* renamed from: ij */
    private View.OnClickListener f1673ij;

    public PlusOneButtonWithPopup(Context context) {
        this(context, (AttributeSet) null);
    }

    public PlusOneButtonWithPopup(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f1668O = PlusOneButton.getSize(context, attrs);
        this.f1671id = PlusOneButton.getAnnotation(context, attrs);
        this.f1670ic = new PlusOneDummyView(context, this.f1668O);
        addView(this.f1670ic);
    }

    /* renamed from: bv */
    private void m2118bv() {
        if (this.f1670ic != null) {
            removeView(this.f1670ic);
        }
        this.f1670ic = C0538bu.m1532a(getContext(), this.f1668O, this.f1671id, this.f1672ie, this.f1669g);
        if (this.f1673ij != null) {
            setOnClickListener(this.f1673ij);
        }
        addView(this.f1670ic);
    }

    /* renamed from: bw */
    private C0525br m2119bw() throws RemoteException {
        C0525br aa = C0525br.C0526a.m1440aa((IBinder) this.f1670ic.getTag());
        if (aa != null) {
            return aa;
        }
        if (Log.isLoggable("PlusOneButtonWithPopup", 5)) {
            Log.w("PlusOneButtonWithPopup", "Failed to get PlusOneDelegate");
        }
        throw new RemoteException();
    }

    /* renamed from: c */
    private int m2120c(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i) - i2, mode);
            default:
                return i;
        }
    }

    public void cancelClick() {
        if (this.f1670ic != null) {
            try {
                m2119bw().cancelClick();
            } catch (RemoteException e) {
            }
        }
    }

    public PendingIntent getResolution() {
        if (this.f1670ic != null) {
            try {
                return m2119bw().getResolution();
            } catch (RemoteException e) {
            }
        }
        return null;
    }

    public void initialize(String url, String accountName) {
        C0621s.m1887b(url, (Object) "Url must not be null");
        this.f1672ie = url;
        this.f1669g = accountName;
        m2118bv();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.f1670ic.layout(getPaddingLeft(), getPaddingTop(), (right - left) - getPaddingRight(), (bottom - top) - getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        this.f1670ic.measure(m2120c(widthMeasureSpec, paddingLeft), m2120c(heightMeasureSpec, paddingTop));
        setMeasuredDimension(paddingLeft + this.f1670ic.getMeasuredWidth(), paddingTop + this.f1670ic.getMeasuredHeight());
    }

    public void reinitialize() {
        if (this.f1670ic != null) {
            try {
                m2119bw().reinitialize();
            } catch (RemoteException e) {
            }
        }
    }

    public void setAnnotation(int annotation) {
        this.f1671id = annotation;
        m2118bv();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f1673ij = onClickListener;
        this.f1670ic.setOnClickListener(onClickListener);
    }

    public void setSize(int size) {
        this.f1668O = size;
        m2118bv();
    }
}
