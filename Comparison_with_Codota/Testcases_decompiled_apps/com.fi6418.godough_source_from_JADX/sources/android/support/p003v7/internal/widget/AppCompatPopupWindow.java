package android.support.p003v7.internal.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.p000v4.widget.PopupWindowCompat;
import android.support.p003v7.appcompat.C0235R;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* renamed from: android.support.v7.internal.widget.AppCompatPopupWindow */
public class AppCompatPopupWindow extends PopupWindow {

    /* renamed from: a */
    private static final boolean f2307a = (Build.VERSION.SDK_INT < 21);

    /* renamed from: b */
    private boolean f2308b;

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0235R.styleable.PopupWindow, i, 0);
        if (obtainStyledAttributes.hasValue(C0235R.styleable.PopupWindow_overlapAnchor)) {
            setSupportOverlapAnchor(obtainStyledAttributes.getBoolean(C0235R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0235R.styleable.PopupWindow_android_popupBackground));
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT < 14) {
            m1497a(this);
        }
    }

    /* renamed from: a */
    private static void m1497a(final PopupWindow popupWindow) {
        try {
            final Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
            declaredField.setAccessible(true);
            Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(true);
            final ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = (ViewTreeObserver.OnScrollChangedListener) declaredField2.get(popupWindow);
            declaredField2.set(popupWindow, new ViewTreeObserver.OnScrollChangedListener() {
                public void onScrollChanged() {
                    try {
                        WeakReference weakReference = (WeakReference) declaredField.get(popupWindow);
                        if (weakReference != null && weakReference.get() != null) {
                            onScrollChangedListener.onScrollChanged();
                        }
                    } catch (IllegalAccessException e) {
                    }
                }
            });
        } catch (Exception e) {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", e);
        }
    }

    public boolean getSupportOverlapAnchor() {
        return f2307a ? this.f2308b : PopupWindowCompat.getOverlapAnchor(this);
    }

    public void setSupportOverlapAnchor(boolean z) {
        if (f2307a) {
            this.f2308b = z;
        } else {
            PopupWindowCompat.setOverlapAnchor(this, z);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f2307a && this.f2308b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @TargetApi(19)
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f2307a && this.f2308b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        super.update(view, i, (!f2307a || !this.f2308b) ? i2 : i2 - view.getHeight(), i3, i4);
    }
}
