package android.support.p004v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.p001v4.widget.PopupWindowCompat;
import android.support.p004v7.appcompat.C0505R;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* renamed from: android.support.v7.widget.AppCompatPopupWindow */
public class AppCompatPopupWindow extends PopupWindow {

    /* renamed from: a */
    private static final boolean f2025a = (Build.VERSION.SDK_INT < 21);

    /* renamed from: b */
    private boolean f2026b;

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0505R.styleable.PopupWindow, i, 0);
        if (obtainStyledAttributes.hasValue(C0505R.styleable.PopupWindow_overlapAnchor)) {
            setSupportOverlapAnchor(obtainStyledAttributes.getBoolean(C0505R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0505R.styleable.PopupWindow_android_popupBackground));
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT < 14) {
            m3186a(this);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f2025a && this.f2026b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @TargetApi(19)
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f2025a && this.f2026b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        int i5;
        if (!f2025a || !this.f2026b) {
            i5 = i2;
        } else {
            i5 = i2 - view.getHeight();
        }
        super.update(view, i, i5, i3, i4);
    }

    /* renamed from: a */
    private static void m3186a(final PopupWindow popupWindow) {
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

    public void setSupportOverlapAnchor(boolean z) {
        if (f2025a) {
            this.f2026b = z;
        } else {
            PopupWindowCompat.setOverlapAnchor(this, z);
        }
    }

    public boolean getSupportOverlapAnchor() {
        if (f2025a) {
            return this.f2026b;
        }
        return PopupWindowCompat.getOverlapAnchor(this);
    }
}
