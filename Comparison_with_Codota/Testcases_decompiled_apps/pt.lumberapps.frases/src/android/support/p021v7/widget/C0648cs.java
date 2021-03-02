package android.support.p021v7.widget;

import android.content.Context;
import android.os.Build;
import android.support.p021v7.view.menu.C0562o;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.widget.cs */
public class C0648cs extends C0636cg implements C0647cr {

    /* renamed from: a */
    private static Method f1574a;

    /* renamed from: d */
    private C0647cr f1575d;

    static {
        Class<PopupWindow> cls = PopupWindow.class;
        try {
            f1574a = cls.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public C0648cs(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0625bw mo3168a(Context context, boolean z) {
        C0649ct ctVar = new C0649ct(context, z);
        ctVar.setHoverListener(this);
        return ctVar;
    }

    /* renamed from: a */
    public void mo2417a(C0562o oVar, MenuItem menuItem) {
        if (this.f1575d != null) {
            this.f1575d.mo2417a(oVar, menuItem);
        }
    }

    /* renamed from: a */
    public void mo3217a(C0647cr crVar) {
        this.f1575d = crVar;
    }

    /* renamed from: a */
    public void mo3218a(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f1534c.setEnterTransition((Transition) obj);
        }
    }

    /* renamed from: b */
    public void mo2418b(C0562o oVar, MenuItem menuItem) {
        if (this.f1575d != null) {
            this.f1575d.mo2418b(oVar, menuItem);
        }
    }

    /* renamed from: b */
    public void mo3219b(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f1534c.setExitTransition((Transition) obj);
        }
    }

    /* renamed from: b */
    public void mo3220b(boolean z) {
        if (f1574a != null) {
            try {
                f1574a.invoke(this.f1534c, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }
}
