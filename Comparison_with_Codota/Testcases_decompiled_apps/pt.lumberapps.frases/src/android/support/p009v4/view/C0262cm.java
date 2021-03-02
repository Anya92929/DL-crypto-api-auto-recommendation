package android.support.p009v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.view.cm */
interface C0262cm {
    /* renamed from: a */
    int mo1476a(int i, int i2, int i3);

    /* renamed from: a */
    int mo1477a(View view);

    /* renamed from: a */
    C0335fe mo1479a(View view, C0335fe feVar);

    /* renamed from: a */
    void mo1480a(View view, float f);

    /* renamed from: a */
    void mo1481a(View view, int i, int i2);

    /* renamed from: a */
    void mo1482a(View view, int i, Paint paint);

    /* renamed from: a */
    void mo1483a(View view, ColorStateList colorStateList);

    /* renamed from: a */
    void mo1484a(View view, PorterDuff.Mode mode);

    /* renamed from: a */
    void mo1485a(View view, C0152a aVar);

    /* renamed from: a */
    void mo1486a(View view, C0238bp bpVar);

    /* renamed from: a */
    void mo1487a(View view, Runnable runnable);

    /* renamed from: a */
    void mo1488a(View view, Runnable runnable, long j);

    /* renamed from: a */
    void mo1489a(View view, boolean z);

    /* renamed from: a */
    boolean mo1490a(View view, int i);

    /* renamed from: b */
    int mo1491b(View view);

    /* renamed from: b */
    C0335fe mo1492b(View view, C0335fe feVar);

    /* renamed from: b */
    void mo1493b(View view, float f);

    /* renamed from: b */
    void mo1494b(View view, boolean z);

    /* renamed from: b */
    boolean mo1495b(View view, int i);

    /* renamed from: c */
    int mo1496c(View view);

    /* renamed from: c */
    void mo1497c(View view, float f);

    /* renamed from: c */
    void mo1498c(View view, int i);

    /* renamed from: d */
    int mo1499d(View view);

    /* renamed from: d */
    void mo1500d(View view, int i);

    void dispatchFinishTemporaryDetach(View view);

    void dispatchStartTemporaryDetach(View view);

    /* renamed from: e */
    ViewParent mo1503e(View view);

    /* renamed from: e */
    void mo1504e(View view, int i);

    /* renamed from: f */
    int mo1505f(View view);

    /* renamed from: g */
    int mo1506g(View view);

    /* renamed from: h */
    boolean mo1507h(View view);

    /* renamed from: i */
    float mo1508i(View view);

    /* renamed from: j */
    int mo1509j(View view);

    void jumpDrawablesToCurrentState(View view);

    /* renamed from: k */
    C0314ek mo1511k(View view);

    /* renamed from: l */
    int mo1512l(View view);

    /* renamed from: m */
    float mo1513m(View view);

    /* renamed from: n */
    boolean mo1514n(View view);

    /* renamed from: o */
    ColorStateList mo1515o(View view);

    /* renamed from: p */
    PorterDuff.Mode mo1516p(View view);

    void postInvalidateOnAnimation(View view);

    /* renamed from: q */
    boolean mo1518q(View view);

    /* renamed from: r */
    boolean mo1519r(View view);

    void releasePointerCapture(View view);

    void requestApplyInsets(View view);

    /* renamed from: s */
    boolean mo1521s(View view);

    void setPointerCapture(View view);

    void stopNestedScroll(View view);
}
