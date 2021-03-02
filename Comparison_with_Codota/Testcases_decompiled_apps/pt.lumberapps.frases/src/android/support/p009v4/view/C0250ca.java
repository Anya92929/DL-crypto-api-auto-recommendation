package android.support.p009v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.view.ca */
class C0250ca implements C0262cm {

    /* renamed from: a */
    WeakHashMap f355a = null;

    /* renamed from: b */
    private Method f356b;

    /* renamed from: c */
    private Method f357c;

    /* renamed from: d */
    private boolean f358d;

    C0250ca() {
    }

    /* renamed from: a */
    private boolean m934a(C0240br brVar, int i) {
        int computeHorizontalScrollOffset = brVar.computeHorizontalScrollOffset();
        int computeHorizontalScrollRange = brVar.computeHorizontalScrollRange() - brVar.computeHorizontalScrollExtent();
        if (computeHorizontalScrollRange == 0) {
            return false;
        }
        return i < 0 ? computeHorizontalScrollOffset > 0 : computeHorizontalScrollOffset < computeHorizontalScrollRange + -1;
    }

    /* renamed from: b */
    private void m935b() {
        try {
            this.f356b = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
            this.f357c = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
        } catch (NoSuchMethodException e) {
            Log.e("ViewCompat", "Couldn't find method", e);
        }
        this.f358d = true;
    }

    /* renamed from: b */
    private boolean m936b(C0240br brVar, int i) {
        int computeVerticalScrollOffset = brVar.computeVerticalScrollOffset();
        int computeVerticalScrollRange = brVar.computeVerticalScrollRange() - brVar.computeVerticalScrollExtent();
        if (computeVerticalScrollRange == 0) {
            return false;
        }
        return i < 0 ? computeVerticalScrollOffset > 0 : computeVerticalScrollOffset < computeVerticalScrollRange + -1;
    }

    /* renamed from: a */
    public int mo1476a(int i, int i2, int i3) {
        return View.resolveSize(i, i2);
    }

    /* renamed from: a */
    public int mo1477a(View view) {
        return 2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo1478a() {
        return 10;
    }

    /* renamed from: a */
    public C0335fe mo1479a(View view, C0335fe feVar) {
        return feVar;
    }

    /* renamed from: a */
    public void mo1480a(View view, float f) {
    }

    /* renamed from: a */
    public void mo1481a(View view, int i, int i2) {
    }

    /* renamed from: a */
    public void mo1482a(View view, int i, Paint paint) {
    }

    /* renamed from: a */
    public void mo1483a(View view, ColorStateList colorStateList) {
        C0264co.m1066a(view, colorStateList);
    }

    /* renamed from: a */
    public void mo1484a(View view, PorterDuff.Mode mode) {
        C0264co.m1067a(view, mode);
    }

    /* renamed from: a */
    public void mo1485a(View view, C0152a aVar) {
    }

    /* renamed from: a */
    public void mo1486a(View view, C0238bp bpVar) {
    }

    /* renamed from: a */
    public void mo1487a(View view, Runnable runnable) {
        view.postDelayed(runnable, mo1478a());
    }

    /* renamed from: a */
    public void mo1488a(View view, Runnable runnable, long j) {
        view.postDelayed(runnable, mo1478a() + j);
    }

    /* renamed from: a */
    public void mo1489a(View view, boolean z) {
    }

    /* renamed from: a */
    public boolean mo1490a(View view, int i) {
        return (view instanceof C0240br) && m934a((C0240br) view, i);
    }

    /* renamed from: b */
    public int mo1491b(View view) {
        return 0;
    }

    /* renamed from: b */
    public C0335fe mo1492b(View view, C0335fe feVar) {
        return feVar;
    }

    /* renamed from: b */
    public void mo1493b(View view, float f) {
    }

    /* renamed from: b */
    public void mo1494b(View view, boolean z) {
    }

    /* renamed from: b */
    public boolean mo1495b(View view, int i) {
        return (view instanceof C0240br) && m936b((C0240br) view, i);
    }

    /* renamed from: c */
    public int mo1496c(View view) {
        return 0;
    }

    /* renamed from: c */
    public void mo1497c(View view, float f) {
    }

    /* renamed from: c */
    public void mo1498c(View view, int i) {
    }

    /* renamed from: d */
    public int mo1499d(View view) {
        return 0;
    }

    /* renamed from: d */
    public void mo1500d(View view, int i) {
        C0264co.m1069b(view, i);
    }

    public void dispatchFinishTemporaryDetach(View view) {
        if (!this.f358d) {
            m935b();
        }
        if (this.f357c != null) {
            try {
                this.f357c.invoke(view, new Object[0]);
            } catch (Exception e) {
                Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", e);
            }
        } else {
            view.onFinishTemporaryDetach();
        }
    }

    public void dispatchStartTemporaryDetach(View view) {
        if (!this.f358d) {
            m935b();
        }
        if (this.f356b != null) {
            try {
                this.f356b.invoke(view, new Object[0]);
            } catch (Exception e) {
                Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", e);
            }
        } else {
            view.onStartTemporaryDetach();
        }
    }

    /* renamed from: e */
    public ViewParent mo1503e(View view) {
        return view.getParent();
    }

    /* renamed from: e */
    public void mo1504e(View view, int i) {
        C0264co.m1065a(view, i);
    }

    /* renamed from: f */
    public int mo1505f(View view) {
        return view.getMeasuredWidth();
    }

    /* renamed from: g */
    public int mo1506g(View view) {
        return 0;
    }

    /* renamed from: h */
    public boolean mo1507h(View view) {
        return true;
    }

    /* renamed from: i */
    public float mo1508i(View view) {
        return 0.0f;
    }

    /* renamed from: j */
    public int mo1509j(View view) {
        return C0264co.m1071d(view);
    }

    public void jumpDrawablesToCurrentState(View view) {
    }

    /* renamed from: k */
    public C0314ek mo1511k(View view) {
        return new C0314ek(view);
    }

    /* renamed from: l */
    public int mo1512l(View view) {
        return 0;
    }

    /* renamed from: m */
    public float mo1513m(View view) {
        return 0.0f;
    }

    /* renamed from: n */
    public boolean mo1514n(View view) {
        return false;
    }

    /* renamed from: o */
    public ColorStateList mo1515o(View view) {
        return C0264co.m1064a(view);
    }

    /* renamed from: p */
    public PorterDuff.Mode mo1516p(View view) {
        return C0264co.m1068b(view);
    }

    public void postInvalidateOnAnimation(View view) {
        view.invalidate();
    }

    /* renamed from: q */
    public boolean mo1518q(View view) {
        return C0264co.m1070c(view);
    }

    /* renamed from: r */
    public boolean mo1519r(View view) {
        return C0264co.m1072e(view);
    }

    public void releasePointerCapture(View view) {
    }

    public void requestApplyInsets(View view) {
    }

    /* renamed from: s */
    public boolean mo1521s(View view) {
        return false;
    }

    public void setPointerCapture(View view) {
    }

    public void stopNestedScroll(View view) {
        if (view instanceof C0234bl) {
            ((C0234bl) view).stopNestedScroll();
        }
    }
}
