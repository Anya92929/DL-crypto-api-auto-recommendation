package android.support.p009v4.widget;

import android.content.Context;
import android.support.p009v4.view.C0223ba;
import android.support.p009v4.view.C0242bt;
import android.support.p009v4.view.C0247by;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

/* renamed from: android.support.v4.widget.bn */
public class C0398bn {

    /* renamed from: v */
    private static final Interpolator f519v = new C0399bo();

    /* renamed from: a */
    private int f520a;

    /* renamed from: b */
    private int f521b;

    /* renamed from: c */
    private int f522c = -1;

    /* renamed from: d */
    private float[] f523d;

    /* renamed from: e */
    private float[] f524e;

    /* renamed from: f */
    private float[] f525f;

    /* renamed from: g */
    private float[] f526g;

    /* renamed from: h */
    private int[] f527h;

    /* renamed from: i */
    private int[] f528i;

    /* renamed from: j */
    private int[] f529j;

    /* renamed from: k */
    private int f530k;

    /* renamed from: l */
    private VelocityTracker f531l;

    /* renamed from: m */
    private float f532m;

    /* renamed from: n */
    private float f533n;

    /* renamed from: o */
    private int f534o;

    /* renamed from: p */
    private int f535p;

    /* renamed from: q */
    private C0390bf f536q;

    /* renamed from: r */
    private final C0401bq f537r;

    /* renamed from: s */
    private View f538s;

    /* renamed from: t */
    private boolean f539t;

    /* renamed from: u */
    private final ViewGroup f540u;

    /* renamed from: w */
    private final Runnable f541w = new C0400bp(this);

    private C0398bn(Context context, ViewGroup viewGroup, C0401bq bqVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (bqVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f540u = viewGroup;
            this.f537r = bqVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f534o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f521b = viewConfiguration.getScaledTouchSlop();
            this.f532m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f533n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f536q = C0390bf.m1565a(context, f519v);
        }
    }

    /* renamed from: a */
    private float m1636a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        return abs > f3 ? f <= 0.0f ? -f3 : f3 : f;
    }

    /* renamed from: a */
    private int m1637a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f540u.getWidth();
        int i4 = width / 2;
        float b = (m1646b(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        int abs = Math.abs(i2);
        return Math.min(abs > 0 ? Math.round(Math.abs(b / ((float) abs)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), 600);
    }

    /* renamed from: a */
    private int m1638a(View view, int i, int i2, int i3, int i4) {
        int b = m1647b(i3, (int) this.f533n, (int) this.f532m);
        int b2 = m1647b(i4, (int) this.f533n, (int) this.f532m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m1637a(i2, b2, this.f537r.mo1859b(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m1637a(i, b, this.f537r.mo1765a(view)))));
    }

    /* renamed from: a */
    public static C0398bn m1639a(ViewGroup viewGroup, float f, C0401bq bqVar) {
        C0398bn a = m1640a(viewGroup, bqVar);
        a.f521b = (int) (((float) a.f521b) * (1.0f / f));
        return a;
    }

    /* renamed from: a */
    public static C0398bn m1640a(ViewGroup viewGroup, C0401bq bqVar) {
        return new C0398bn(viewGroup.getContext(), viewGroup, bqVar);
    }

    /* renamed from: a */
    private void m1641a(float f, float f2) {
        this.f539t = true;
        this.f537r.mo1771a(this.f538s, f, f2);
        this.f539t = false;
        if (this.f520a == 1) {
            mo1851c(0);
        }
    }

    /* renamed from: a */
    private void m1642a(float f, float f2, int i) {
        m1654f(i);
        float[] fArr = this.f523d;
        this.f525f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.f524e;
        this.f526g[i] = f2;
        fArr2[i] = f2;
        this.f527h[i] = m1651e((int) f, (int) f2);
        this.f530k |= 1 << i;
    }

    /* renamed from: a */
    private boolean m1643a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f527h[i] & i2) != i2 || (this.f535p & i2) == 0 || (this.f529j[i] & i2) == i2 || (this.f528i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f521b) && abs2 <= ((float) this.f521b)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f537r.mo1777b(i2)) {
            return (this.f528i[i] & i2) == 0 && abs > ((float) this.f521b);
        }
        int[] iArr = this.f529j;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    /* renamed from: a */
    private boolean m1644a(int i, int i2, int i3, int i4) {
        int left = this.f538s.getLeft();
        int top = this.f538s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f536q.mo1819h();
            mo1851c(0);
            return false;
        }
        this.f536q.mo1808a(left, top, i5, i6, m1638a(this.f538s, i5, i6, i3, i4));
        mo1851c(2);
        return true;
    }

    /* renamed from: a */
    private boolean m1645a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f537r.mo1765a(view) > 0;
        boolean z2 = this.f537r.mo1859b(view) > 0;
        if (z && z2) {
            return (f * f) + (f2 * f2) > ((float) (this.f521b * this.f521b));
        }
        if (z) {
            return Math.abs(f) > ((float) this.f521b);
        }
        if (z2) {
            return Math.abs(f2) > ((float) this.f521b);
        }
        return false;
    }

    /* renamed from: b */
    private float m1646b(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    /* renamed from: b */
    private int m1647b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        return abs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    /* renamed from: b */
    private void m1648b(float f, float f2, int i) {
        int i2 = 1;
        if (!m1643a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m1643a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m1643a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m1643a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f528i;
            iArr[i] = iArr[i] | i2;
            this.f537r.mo1775b(i2, i);
        }
    }

    /* renamed from: b */
    private void m1649b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int left = this.f538s.getLeft();
        int top = this.f538s.getTop();
        if (i3 != 0) {
            i5 = this.f537r.mo1766a(this.f538s, i, i3);
            C0247by.m912e(this.f538s, i5 - left);
        } else {
            i5 = i;
        }
        if (i4 != 0) {
            i6 = this.f537r.mo1774b(this.f538s, i2, i4);
            C0247by.m910d(this.f538s, i6 - top);
        } else {
            i6 = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f537r.mo1772a(this.f538s, i5, i6, i5 - left, i6 - top);
        }
    }

    /* renamed from: c */
    private void m1650c(MotionEvent motionEvent) {
        int c = C0223ba.m833c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = C0223ba.m831b(motionEvent, i);
            float c2 = C0223ba.m832c(motionEvent, i);
            float d = C0223ba.m834d(motionEvent, i);
            this.f525f[b] = c2;
            this.f526g[b] = d;
        }
    }

    /* renamed from: e */
    private int m1651e(int i, int i2) {
        int i3 = 0;
        if (i < this.f540u.getLeft() + this.f534o) {
            i3 = 1;
        }
        if (i2 < this.f540u.getTop() + this.f534o) {
            i3 |= 4;
        }
        if (i > this.f540u.getRight() - this.f534o) {
            i3 |= 2;
        }
        return i2 > this.f540u.getBottom() - this.f534o ? i3 | 8 : i3;
    }

    /* renamed from: e */
    private void m1652e(int i) {
        if (this.f523d != null) {
            this.f523d[i] = 0.0f;
            this.f524e[i] = 0.0f;
            this.f525f[i] = 0.0f;
            this.f526g[i] = 0.0f;
            this.f527h[i] = 0;
            this.f528i[i] = 0;
            this.f529j[i] = 0;
            this.f530k &= (1 << i) ^ -1;
        }
    }

    /* renamed from: f */
    private void m1653f() {
        if (this.f523d != null) {
            Arrays.fill(this.f523d, 0.0f);
            Arrays.fill(this.f524e, 0.0f);
            Arrays.fill(this.f525f, 0.0f);
            Arrays.fill(this.f526g, 0.0f);
            Arrays.fill(this.f527h, 0);
            Arrays.fill(this.f528i, 0);
            Arrays.fill(this.f529j, 0);
            this.f530k = 0;
        }
    }

    /* renamed from: f */
    private void m1654f(int i) {
        if (this.f523d == null || this.f523d.length <= i) {
            float[] fArr = new float[(i + 1)];
            float[] fArr2 = new float[(i + 1)];
            float[] fArr3 = new float[(i + 1)];
            float[] fArr4 = new float[(i + 1)];
            int[] iArr = new int[(i + 1)];
            int[] iArr2 = new int[(i + 1)];
            int[] iArr3 = new int[(i + 1)];
            if (this.f523d != null) {
                System.arraycopy(this.f523d, 0, fArr, 0, this.f523d.length);
                System.arraycopy(this.f524e, 0, fArr2, 0, this.f524e.length);
                System.arraycopy(this.f525f, 0, fArr3, 0, this.f525f.length);
                System.arraycopy(this.f526g, 0, fArr4, 0, this.f526g.length);
                System.arraycopy(this.f527h, 0, iArr, 0, this.f527h.length);
                System.arraycopy(this.f528i, 0, iArr2, 0, this.f528i.length);
                System.arraycopy(this.f529j, 0, iArr3, 0, this.f529j.length);
            }
            this.f523d = fArr;
            this.f524e = fArr2;
            this.f525f = fArr3;
            this.f526g = fArr4;
            this.f527h = iArr;
            this.f528i = iArr2;
            this.f529j = iArr3;
        }
    }

    /* renamed from: g */
    private void m1655g() {
        this.f531l.computeCurrentVelocity(1000, this.f532m);
        m1641a(m1636a(C0242bt.m877a(this.f531l, this.f522c), this.f533n, this.f532m), m1636a(C0242bt.m878b(this.f531l, this.f522c), this.f533n, this.f532m));
    }

    /* renamed from: g */
    private boolean m1656g(int i) {
        if (mo1846b(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    /* renamed from: a */
    public int mo1836a() {
        return this.f520a;
    }

    /* renamed from: a */
    public void mo1837a(float f) {
        this.f533n = f;
    }

    /* renamed from: a */
    public void mo1838a(int i) {
        this.f535p = i;
    }

    /* renamed from: a */
    public void mo1839a(View view, int i) {
        if (view.getParent() != this.f540u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f540u + ")");
        }
        this.f538s = view;
        this.f522c = i;
        this.f537r.mo1776b(view, i);
        mo1851c(1);
    }

    /* renamed from: a */
    public boolean mo1840a(int i, int i2) {
        if (this.f539t) {
            return m1644a(i, i2, (int) C0242bt.m877a(this.f531l, this.f522c), (int) C0242bt.m878b(this.f531l, this.f522c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ff, code lost:
        if (r8 != r7) goto L_0x010e;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo1841a(android.view.MotionEvent r14) {
        /*
            r13 = this;
            int r0 = android.support.p009v4.view.C0223ba.m828a(r14)
            int r1 = android.support.p009v4.view.C0223ba.m830b(r14)
            if (r0 != 0) goto L_0x000d
            r13.mo1856e()
        L_0x000d:
            android.view.VelocityTracker r2 = r13.f531l
            if (r2 != 0) goto L_0x0017
            android.view.VelocityTracker r2 = android.view.VelocityTracker.obtain()
            r13.f531l = r2
        L_0x0017:
            android.view.VelocityTracker r2 = r13.f531l
            r2.addMovement(r14)
            switch(r0) {
                case 0: goto L_0x0026;
                case 1: goto L_0x0128;
                case 2: goto L_0x0092;
                case 3: goto L_0x0128;
                case 4: goto L_0x001f;
                case 5: goto L_0x005a;
                case 6: goto L_0x011f;
                default: goto L_0x001f;
            }
        L_0x001f:
            int r0 = r13.f520a
            r1 = 1
            if (r0 != r1) goto L_0x012d
            r0 = 1
        L_0x0025:
            return r0
        L_0x0026:
            float r0 = r14.getX()
            float r1 = r14.getY()
            r2 = 0
            int r2 = android.support.p009v4.view.C0223ba.m831b(r14, r2)
            r13.m1642a((float) r0, (float) r1, (int) r2)
            int r0 = (int) r0
            int r1 = (int) r1
            android.view.View r0 = r13.mo1854d(r0, r1)
            android.view.View r1 = r13.f538s
            if (r0 != r1) goto L_0x0048
            int r1 = r13.f520a
            r3 = 2
            if (r1 != r3) goto L_0x0048
            r13.mo1848b((android.view.View) r0, (int) r2)
        L_0x0048:
            int[] r0 = r13.f527h
            r0 = r0[r2]
            int r1 = r13.f535p
            r1 = r1 & r0
            if (r1 == 0) goto L_0x001f
            android.support.v4.widget.bq r1 = r13.f537r
            int r3 = r13.f535p
            r0 = r0 & r3
            r1.mo1769a((int) r0, (int) r2)
            goto L_0x001f
        L_0x005a:
            int r0 = android.support.p009v4.view.C0223ba.m831b(r14, r1)
            float r2 = android.support.p009v4.view.C0223ba.m832c(r14, r1)
            float r1 = android.support.p009v4.view.C0223ba.m834d(r14, r1)
            r13.m1642a((float) r2, (float) r1, (int) r0)
            int r3 = r13.f520a
            if (r3 != 0) goto L_0x007f
            int[] r1 = r13.f527h
            r1 = r1[r0]
            int r2 = r13.f535p
            r2 = r2 & r1
            if (r2 == 0) goto L_0x001f
            android.support.v4.widget.bq r2 = r13.f537r
            int r3 = r13.f535p
            r1 = r1 & r3
            r2.mo1769a((int) r1, (int) r0)
            goto L_0x001f
        L_0x007f:
            int r3 = r13.f520a
            r4 = 2
            if (r3 != r4) goto L_0x001f
            int r2 = (int) r2
            int r1 = (int) r1
            android.view.View r1 = r13.mo1854d(r2, r1)
            android.view.View r2 = r13.f538s
            if (r1 != r2) goto L_0x001f
            r13.mo1848b((android.view.View) r1, (int) r0)
            goto L_0x001f
        L_0x0092:
            float[] r0 = r13.f523d
            if (r0 == 0) goto L_0x001f
            float[] r0 = r13.f524e
            if (r0 == 0) goto L_0x001f
            int r2 = android.support.p009v4.view.C0223ba.m833c(r14)
            r0 = 0
            r1 = r0
        L_0x00a0:
            if (r1 >= r2) goto L_0x0107
            int r3 = android.support.p009v4.view.C0223ba.m831b(r14, r1)
            boolean r0 = r13.m1656g(r3)
            if (r0 != 0) goto L_0x00b0
        L_0x00ac:
            int r0 = r1 + 1
            r1 = r0
            goto L_0x00a0
        L_0x00b0:
            float r0 = android.support.p009v4.view.C0223ba.m832c(r14, r1)
            float r4 = android.support.p009v4.view.C0223ba.m834d(r14, r1)
            float[] r5 = r13.f523d
            r5 = r5[r3]
            float r5 = r0 - r5
            float[] r6 = r13.f524e
            r6 = r6[r3]
            float r6 = r4 - r6
            int r0 = (int) r0
            int r4 = (int) r4
            android.view.View r4 = r13.mo1854d(r0, r4)
            if (r4 == 0) goto L_0x010c
            boolean r0 = r13.m1645a((android.view.View) r4, (float) r5, (float) r6)
            if (r0 == 0) goto L_0x010c
            r0 = 1
        L_0x00d3:
            if (r0 == 0) goto L_0x010e
            int r7 = r4.getLeft()
            int r8 = (int) r5
            int r8 = r8 + r7
            android.support.v4.widget.bq r9 = r13.f537r
            int r10 = (int) r5
            int r8 = r9.mo1766a((android.view.View) r4, (int) r8, (int) r10)
            int r9 = r4.getTop()
            int r10 = (int) r6
            int r10 = r10 + r9
            android.support.v4.widget.bq r11 = r13.f537r
            int r12 = (int) r6
            int r10 = r11.mo1774b(r4, r10, r12)
            android.support.v4.widget.bq r11 = r13.f537r
            int r11 = r11.mo1765a((android.view.View) r4)
            android.support.v4.widget.bq r12 = r13.f537r
            int r12 = r12.mo1859b((android.view.View) r4)
            if (r11 == 0) goto L_0x0101
            if (r11 <= 0) goto L_0x010e
            if (r8 != r7) goto L_0x010e
        L_0x0101:
            if (r12 == 0) goto L_0x0107
            if (r12 <= 0) goto L_0x010e
            if (r10 != r9) goto L_0x010e
        L_0x0107:
            r13.m1650c((android.view.MotionEvent) r14)
            goto L_0x001f
        L_0x010c:
            r0 = 0
            goto L_0x00d3
        L_0x010e:
            r13.m1648b((float) r5, (float) r6, (int) r3)
            int r5 = r13.f520a
            r6 = 1
            if (r5 == r6) goto L_0x0107
            if (r0 == 0) goto L_0x00ac
            boolean r0 = r13.mo1848b((android.view.View) r4, (int) r3)
            if (r0 == 0) goto L_0x00ac
            goto L_0x0107
        L_0x011f:
            int r0 = android.support.p009v4.view.C0223ba.m831b(r14, r1)
            r13.m1652e(r0)
            goto L_0x001f
        L_0x0128:
            r13.mo1856e()
            goto L_0x001f
        L_0x012d:
            r0 = 0
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p009v4.widget.C0398bn.mo1841a(android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    public boolean mo1842a(View view, int i, int i2) {
        this.f538s = view;
        this.f522c = -1;
        boolean a = m1644a(i, i2, 0, 0);
        if (!a && this.f520a == 0 && this.f538s != null) {
            this.f538s = null;
        }
        return a;
    }

    /* renamed from: a */
    public boolean mo1843a(boolean z) {
        boolean z2;
        if (this.f520a == 2) {
            boolean g = this.f536q.mo1818g();
            int b = this.f536q.mo1813b();
            int c = this.f536q.mo1814c();
            int left = b - this.f538s.getLeft();
            int top = c - this.f538s.getTop();
            if (left != 0) {
                C0247by.m912e(this.f538s, left);
            }
            if (top != 0) {
                C0247by.m910d(this.f538s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f537r.mo1772a(this.f538s, b, c, left, top);
            }
            if (g && b == this.f536q.mo1815d() && c == this.f536q.mo1816e()) {
                this.f536q.mo1819h();
                z2 = false;
            } else {
                z2 = g;
            }
            if (!z2) {
                if (z) {
                    this.f540u.post(this.f541w);
                } else {
                    mo1851c(0);
                }
            }
        }
        return this.f520a == 2;
    }

    /* renamed from: b */
    public int mo1844b() {
        return this.f534o;
    }

    /* renamed from: b */
    public void mo1845b(MotionEvent motionEvent) {
        int i;
        int i2 = 0;
        int a = C0223ba.m828a(motionEvent);
        int b = C0223ba.m830b(motionEvent);
        if (a == 0) {
            mo1856e();
        }
        if (this.f531l == null) {
            this.f531l = VelocityTracker.obtain();
        }
        this.f531l.addMovement(motionEvent);
        switch (a) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int b2 = C0223ba.m831b(motionEvent, 0);
                View d = mo1854d((int) x, (int) y);
                m1642a(x, y, b2);
                mo1848b(d, b2);
                int i3 = this.f527h[b2];
                if ((this.f535p & i3) != 0) {
                    this.f537r.mo1769a(i3 & this.f535p, b2);
                    return;
                }
                return;
            case 1:
                if (this.f520a == 1) {
                    m1655g();
                }
                mo1856e();
                return;
            case 2:
                if (this.f520a != 1) {
                    int c = C0223ba.m833c(motionEvent);
                    while (i2 < c) {
                        int b3 = C0223ba.m831b(motionEvent, i2);
                        if (m1656g(b3)) {
                            float c2 = C0223ba.m832c(motionEvent, i2);
                            float d2 = C0223ba.m834d(motionEvent, i2);
                            float f = c2 - this.f523d[b3];
                            float f2 = d2 - this.f524e[b3];
                            m1648b(f, f2, b3);
                            if (this.f520a != 1) {
                                View d3 = mo1854d((int) c2, (int) d2);
                                if (m1645a(d3, f, f2) && mo1848b(d3, b3)) {
                                }
                            }
                            m1650c(motionEvent);
                            return;
                        }
                        i2++;
                    }
                    m1650c(motionEvent);
                    return;
                } else if (m1656g(this.f522c)) {
                    int a2 = C0223ba.m829a(motionEvent, this.f522c);
                    float c3 = C0223ba.m832c(motionEvent, a2);
                    float d4 = C0223ba.m834d(motionEvent, a2);
                    int i4 = (int) (c3 - this.f525f[this.f522c]);
                    int i5 = (int) (d4 - this.f526g[this.f522c]);
                    m1649b(this.f538s.getLeft() + i4, this.f538s.getTop() + i5, i4, i5);
                    m1650c(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.f520a == 1) {
                    m1641a(0.0f, 0.0f);
                }
                mo1856e();
                return;
            case 5:
                int b4 = C0223ba.m831b(motionEvent, b);
                float c4 = C0223ba.m832c(motionEvent, b);
                float d5 = C0223ba.m834d(motionEvent, b);
                m1642a(c4, d5, b4);
                if (this.f520a == 0) {
                    mo1848b(mo1854d((int) c4, (int) d5), b4);
                    int i6 = this.f527h[b4];
                    if ((this.f535p & i6) != 0) {
                        this.f537r.mo1769a(i6 & this.f535p, b4);
                        return;
                    }
                    return;
                } else if (mo1852c((int) c4, (int) d5)) {
                    mo1848b(this.f538s, b4);
                    return;
                } else {
                    return;
                }
            case 6:
                int b5 = C0223ba.m831b(motionEvent, b);
                if (this.f520a == 1 && b5 == this.f522c) {
                    int c5 = C0223ba.m833c(motionEvent);
                    while (true) {
                        if (i2 >= c5) {
                            i = -1;
                        } else {
                            int b6 = C0223ba.m831b(motionEvent, i2);
                            if (b6 != this.f522c) {
                                if (mo1854d((int) C0223ba.m832c(motionEvent, i2), (int) C0223ba.m834d(motionEvent, i2)) == this.f538s && mo1848b(this.f538s, b6)) {
                                    i = this.f522c;
                                }
                            }
                            i2++;
                        }
                    }
                    if (i == -1) {
                        m1655g();
                    }
                }
                m1652e(b5);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    public boolean mo1846b(int i) {
        return (this.f530k & (1 << i)) != 0;
    }

    /* renamed from: b */
    public boolean mo1847b(int i, int i2) {
        if (!mo1846b(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f525f[i2] - this.f523d[i2];
        float f2 = this.f526g[i2] - this.f524e[i2];
        if (z && z2) {
            return (f * f) + (f2 * f2) > ((float) (this.f521b * this.f521b));
        }
        if (z) {
            return Math.abs(f) > ((float) this.f521b);
        }
        if (z2) {
            return Math.abs(f2) > ((float) this.f521b);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo1848b(View view, int i) {
        if (view == this.f538s && this.f522c == i) {
            return true;
        }
        if (view == null || !this.f537r.mo1773a(view, i)) {
            return false;
        }
        this.f522c = i;
        mo1839a(view, i);
        return true;
    }

    /* renamed from: b */
    public boolean mo1849b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    /* renamed from: c */
    public View mo1850c() {
        return this.f538s;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo1851c(int i) {
        this.f540u.removeCallbacks(this.f541w);
        if (this.f520a != i) {
            this.f520a = i;
            this.f537r.mo1768a(i);
            if (this.f520a == 0) {
                this.f538s = null;
            }
        }
    }

    /* renamed from: c */
    public boolean mo1852c(int i, int i2) {
        return mo1849b(this.f538s, i, i2);
    }

    /* renamed from: d */
    public int mo1853d() {
        return this.f521b;
    }

    /* renamed from: d */
    public View mo1854d(int i, int i2) {
        for (int childCount = this.f540u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f540u.getChildAt(this.f537r.mo1860c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: d */
    public boolean mo1855d(int i) {
        int length = this.f523d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (mo1847b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public void mo1856e() {
        this.f522c = -1;
        m1653f();
        if (this.f531l != null) {
            this.f531l.recycle();
            this.f531l = null;
        }
    }
}
