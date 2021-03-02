package android.support.p021v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.p009v4.widget.C0377at;
import android.support.p021v7.p023b.C0515k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

/* renamed from: android.support.v7.widget.ba */
public class C0603ba extends PopupWindow {

    /* renamed from: a */
    private static final boolean f1426a = (Build.VERSION.SDK_INT < 21);

    /* renamed from: b */
    private boolean f1427b;

    public C0603ba(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0670dn a = C0670dn.m3014a(context, attributeSet, C0515k.PopupWindow, i, 0);
        if (a.mo3332g(C0515k.PopupWindow_overlapAnchor)) {
            mo3011a(a.mo3320a(C0515k.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a.mo3318a(C0515k.PopupWindow_android_popupBackground));
        a.mo3319a();
        if (Build.VERSION.SDK_INT < 14) {
            m2767a((PopupWindow) this);
        }
    }

    /* renamed from: a */
    private static void m2767a(PopupWindow popupWindow) {
        try {
            Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
            declaredField.setAccessible(true);
            Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(true);
            declaredField2.set(popupWindow, new C0604bb(declaredField, popupWindow, (ViewTreeObserver.OnScrollChangedListener) declaredField2.get(popupWindow)));
        } catch (Exception e) {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", e);
        }
    }

    /* renamed from: a */
    public void mo3011a(boolean z) {
        if (f1426a) {
            this.f1427b = z;
        } else {
            C0377at.m1545a((PopupWindow) this, z);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f1426a && this.f1427b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @TargetApi(19)
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f1426a && this.f1427b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        super.update(view, i, (!f1426a || !this.f1427b) ? i2 : i2 - view.getHeight(), i3, i4);
    }
}
