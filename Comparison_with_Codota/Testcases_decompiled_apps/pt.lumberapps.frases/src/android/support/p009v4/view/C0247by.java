package android.support.p009v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.p009v4.p018e.C0130c;
import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.view.by */
public class C0247by {

    /* renamed from: a */
    static final C0262cm f352a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (C0130c.m319a()) {
            f352a = new C0248bz();
        } else if (i >= 23) {
            f352a = new C0261cl();
        } else if (i >= 21) {
            f352a = new C0260ck();
        } else if (i >= 19) {
            f352a = new C0259cj();
        } else if (i >= 17) {
            f352a = new C0257ch();
        } else if (i >= 16) {
            f352a = new C0256cg();
        } else if (i >= 15) {
            f352a = new C0254ce();
        } else if (i >= 14) {
            f352a = new C0255cf();
        } else if (i >= 11) {
            f352a = new C0253cd();
        } else if (i >= 9) {
            f352a = new C0252cc();
        } else if (i >= 7) {
            f352a = new C0251cb();
        } else {
            f352a = new C0250ca();
        }
    }

    /* renamed from: a */
    public static int m887a(int i, int i2, int i3) {
        return f352a.mo1476a(i, i2, i3);
    }

    /* renamed from: a */
    public static int m888a(View view) {
        return f352a.mo1477a(view);
    }

    /* renamed from: a */
    public static C0335fe m889a(View view, C0335fe feVar) {
        return f352a.mo1479a(view, feVar);
    }

    /* renamed from: a */
    public static void m890a(View view, float f) {
        f352a.mo1480a(view, f);
    }

    /* renamed from: a */
    public static void m891a(View view, int i, int i2) {
        f352a.mo1481a(view, i, i2);
    }

    /* renamed from: a */
    public static void m892a(View view, int i, Paint paint) {
        f352a.mo1482a(view, i, paint);
    }

    /* renamed from: a */
    public static void m893a(View view, ColorStateList colorStateList) {
        f352a.mo1483a(view, colorStateList);
    }

    /* renamed from: a */
    public static void m894a(View view, PorterDuff.Mode mode) {
        f352a.mo1484a(view, mode);
    }

    /* renamed from: a */
    public static void m895a(View view, C0152a aVar) {
        f352a.mo1485a(view, aVar);
    }

    /* renamed from: a */
    public static void m896a(View view, C0238bp bpVar) {
        f352a.mo1486a(view, bpVar);
    }

    /* renamed from: a */
    public static void m897a(View view, Runnable runnable) {
        f352a.mo1487a(view, runnable);
    }

    /* renamed from: a */
    public static void m898a(View view, Runnable runnable, long j) {
        f352a.mo1488a(view, runnable, j);
    }

    /* renamed from: a */
    public static void m899a(View view, boolean z) {
        f352a.mo1489a(view, z);
    }

    /* renamed from: a */
    public static boolean m900a(View view, int i) {
        return f352a.mo1490a(view, i);
    }

    /* renamed from: b */
    public static int m901b(View view) {
        return f352a.mo1491b(view);
    }

    /* renamed from: b */
    public static C0335fe m902b(View view, C0335fe feVar) {
        return f352a.mo1492b(view, feVar);
    }

    /* renamed from: b */
    public static void m903b(View view, float f) {
        f352a.mo1493b(view, f);
    }

    /* renamed from: b */
    public static void m904b(View view, boolean z) {
        f352a.mo1494b(view, z);
    }

    /* renamed from: b */
    public static boolean m905b(View view, int i) {
        return f352a.mo1495b(view, i);
    }

    /* renamed from: c */
    public static int m906c(View view) {
        return f352a.mo1496c(view);
    }

    /* renamed from: c */
    public static void m907c(View view, float f) {
        f352a.mo1497c(view, f);
    }

    /* renamed from: c */
    public static void m908c(View view, int i) {
        f352a.mo1498c(view, i);
    }

    /* renamed from: d */
    public static int m909d(View view) {
        return f352a.mo1499d(view);
    }

    /* renamed from: d */
    public static void m910d(View view, int i) {
        f352a.mo1504e(view, i);
    }

    public static void dispatchFinishTemporaryDetach(View view) {
        f352a.dispatchFinishTemporaryDetach(view);
    }

    public static void dispatchStartTemporaryDetach(View view) {
        f352a.dispatchStartTemporaryDetach(view);
    }

    /* renamed from: e */
    public static ViewParent m911e(View view) {
        return f352a.mo1503e(view);
    }

    /* renamed from: e */
    public static void m912e(View view, int i) {
        f352a.mo1500d(view, i);
    }

    /* renamed from: f */
    public static int m913f(View view) {
        return f352a.mo1505f(view);
    }

    /* renamed from: g */
    public static int m914g(View view) {
        return f352a.mo1506g(view);
    }

    /* renamed from: h */
    public static float m915h(View view) {
        return f352a.mo1508i(view);
    }

    /* renamed from: i */
    public static int m916i(View view) {
        return f352a.mo1509j(view);
    }

    /* renamed from: j */
    public static C0314ek m917j(View view) {
        return f352a.mo1511k(view);
    }

    public static void jumpDrawablesToCurrentState(View view) {
        f352a.jumpDrawablesToCurrentState(view);
    }

    /* renamed from: k */
    public static float m918k(View view) {
        return f352a.mo1513m(view);
    }

    /* renamed from: l */
    public static int m919l(View view) {
        return f352a.mo1512l(view);
    }

    /* renamed from: m */
    public static boolean m920m(View view) {
        return f352a.mo1514n(view);
    }

    /* renamed from: n */
    public static boolean m921n(View view) {
        return f352a.mo1507h(view);
    }

    /* renamed from: o */
    public static ColorStateList m922o(View view) {
        return f352a.mo1515o(view);
    }

    /* renamed from: p */
    public static PorterDuff.Mode m923p(View view) {
        return f352a.mo1516p(view);
    }

    public static void postInvalidateOnAnimation(View view) {
        f352a.postInvalidateOnAnimation(view);
    }

    /* renamed from: q */
    public static boolean m924q(View view) {
        return f352a.mo1518q(view);
    }

    /* renamed from: r */
    public static boolean m925r(View view) {
        return f352a.mo1519r(view);
    }

    public static void releasePointerCapture(View view) {
        f352a.releasePointerCapture(view);
    }

    public static void requestApplyInsets(View view) {
        f352a.requestApplyInsets(view);
    }

    /* renamed from: s */
    public static boolean m926s(View view) {
        return f352a.mo1521s(view);
    }

    public static void setPointerCapture(View view) {
        f352a.setPointerCapture(view);
    }

    public static void stopNestedScroll(View view) {
        f352a.stopNestedScroll(view);
    }
}
