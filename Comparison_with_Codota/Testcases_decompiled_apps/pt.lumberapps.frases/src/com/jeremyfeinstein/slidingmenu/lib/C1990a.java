package com.jeremyfeinstein.slidingmenu.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.support.p009v4.view.C0223ba;
import android.support.p009v4.view.C0242bt;
import android.support.p009v4.view.C0275cz;
import android.support.p009v4.view.C0352v;
import android.support.p021v7.p023b.C0515k;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.jeremyfeinstein.slidingmenu.lib.a */
public class C1990a extends ViewGroup {

    /* renamed from: e */
    private static final Interpolator f7559e = new C1991b();

    /* renamed from: A */
    private float f7560A;

    /* renamed from: a */
    protected int f7561a;

    /* renamed from: b */
    protected VelocityTracker f7562b;

    /* renamed from: c */
    protected int f7563c;

    /* renamed from: d */
    protected int f7564d;

    /* renamed from: f */
    private View f7565f;

    /* renamed from: g */
    private int f7566g;

    /* renamed from: h */
    private Scroller f7567h;

    /* renamed from: i */
    private boolean f7568i;

    /* renamed from: j */
    private boolean f7569j;

    /* renamed from: k */
    private boolean f7570k;

    /* renamed from: l */
    private boolean f7571l;

    /* renamed from: m */
    private int f7572m;

    /* renamed from: n */
    private float f7573n;

    /* renamed from: o */
    private float f7574o;

    /* renamed from: p */
    private float f7575p;

    /* renamed from: q */
    private int f7576q;

    /* renamed from: r */
    private int f7577r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public C1995f f7578s;

    /* renamed from: t */
    private boolean f7579t;

    /* renamed from: u */
    private C1993d f7580u;

    /* renamed from: v */
    private C1993d f7581v;

    /* renamed from: w */
    private C2003n f7582w;

    /* renamed from: x */
    private C2005p f7583x;

    /* renamed from: y */
    private List f7584y;

    /* renamed from: z */
    private boolean f7585z;

    public C1990a(Context context) {
        this(context, (AttributeSet) null);
    }

    public C1990a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7561a = -1;
        this.f7579t = true;
        this.f7584y = new ArrayList();
        this.f7564d = 0;
        this.f7585z = false;
        this.f7560A = 0.0f;
        mo9980a();
    }

    /* renamed from: a */
    private int m8202a(float f, int i, int i2) {
        int i3 = this.f7566g;
        return (Math.abs(i2) <= this.f7577r || Math.abs(i) <= this.f7576q) ? Math.round(((float) this.f7566g) + f) : (i <= 0 || i2 <= 0) ? (i >= 0 || i2 >= 0) ? i3 : i3 + 1 : i3 - 1;
    }

    /* renamed from: a */
    private int m8203a(MotionEvent motionEvent, int i) {
        int a = C0223ba.m829a(motionEvent, i);
        if (a == -1) {
            this.f7561a = -1;
        }
        return a;
    }

    /* renamed from: a */
    private boolean m8205a(MotionEvent motionEvent) {
        Rect rect = new Rect();
        for (View hitRect : this.f7584y) {
            hitRect.getHitRect(rect);
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static float m8206b(float f) {
        return (float) Math.ceil((double) f);
    }

    /* renamed from: b */
    private boolean m8207b(MotionEvent motionEvent) {
        int x = (int) (motionEvent.getX() + this.f7560A);
        if (mo9988b()) {
            return this.f7578s.mo10027a(this.f7565f, this.f7566g, (float) x);
        }
        switch (this.f7564d) {
            case 0:
                return this.f7578s.mo10031b(this.f7565f, x);
            case 1:
                return !m8205a(motionEvent);
            default:
                return false;
        }
    }

    /* renamed from: c */
    private void m8208c(int i) {
        int width = getWidth();
        int i2 = i % width;
        mo9981a(i / width, ((float) i2) / ((float) width), i2);
    }

    /* renamed from: c */
    private void m8209c(MotionEvent motionEvent) {
        int i = this.f7561a;
        int a = m8203a(motionEvent, i);
        if (i != -1 && a != -1) {
            float c = C0223ba.m832c(motionEvent, a);
            float f = c - this.f7574o;
            float abs = Math.abs(f);
            float d = C0223ba.m834d(motionEvent, a);
            float abs2 = Math.abs(d - this.f7575p);
            if (abs > ((float) (mo9988b() ? this.f7572m / 2 : this.f7572m)) && abs > abs2 && m8210c(f)) {
                m8213f();
                this.f7574o = c;
                this.f7575p = d;
                setScrollingCacheEnabled(true);
            } else if (abs > ((float) this.f7572m)) {
                this.f7571l = true;
            }
        }
    }

    /* renamed from: c */
    private boolean m8210c(float f) {
        return mo9988b() ? this.f7578s.mo10030b(f) : this.f7578s.mo10026a(f);
    }

    /* renamed from: d */
    private void m8211d(MotionEvent motionEvent) {
        int b = C0223ba.m830b(motionEvent);
        if (C0223ba.m831b(motionEvent, b) == this.f7561a) {
            int i = b == 0 ? 1 : 0;
            this.f7574o = C0223ba.m832c(motionEvent, i);
            this.f7561a = C0223ba.m831b(motionEvent, i);
            if (this.f7562b != null) {
                this.f7562b.clear();
            }
        }
    }

    /* renamed from: e */
    private void m8212e() {
        if (this.f7569j) {
            setScrollingCacheEnabled(false);
            this.f7567h.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f7567h.getCurrX();
            int currY = this.f7567h.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
            if (mo9988b()) {
                if (this.f7583x != null) {
                    this.f7583x.mo10068a();
                }
            } else if (this.f7582w != null) {
                this.f7582w.mo10066a();
            }
        }
        this.f7569j = false;
    }

    /* renamed from: f */
    private void m8213f() {
        this.f7570k = true;
        this.f7585z = false;
    }

    /* renamed from: g */
    private void m8214g() {
        this.f7585z = false;
        this.f7570k = false;
        this.f7571l = false;
        this.f7561a = -1;
        if (this.f7562b != null) {
            this.f7562b.recycle();
            this.f7562b = null;
        }
    }

    private int getLeftBound() {
        return this.f7578s.mo10021a(this.f7565f);
    }

    private int getRightBound() {
        return this.f7578s.mo10028b(this.f7565f);
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f7568i != z) {
            this.f7568i = z;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo9977a(float f) {
        return m8206b((float) (((double) (f - 0.5f)) * 0.4712389167638204d));
    }

    /* renamed from: a */
    public int mo9978a(int i) {
        switch (i) {
            case 0:
            case 2:
                return this.f7578s.mo10022a(this.f7565f, i);
            case 1:
                return this.f7565f.getLeft();
            default:
                return 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1993d mo9979a(C1993d dVar) {
        C1993d dVar2 = this.f7581v;
        this.f7581v = dVar;
        return dVar2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9980a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f7567h = new Scroller(context, f7559e);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f7572m = C0275cz.m1119a(viewConfiguration);
        this.f7576q = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f7563c = viewConfiguration.getScaledMaximumFlingVelocity();
        mo9979a((C1993d) new C1992c(this));
        this.f7577r = (int) (context.getResources().getDisplayMetrics().density * 25.0f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9981a(int i, float f, int i2) {
        if (this.f7580u != null) {
            this.f7580u.mo10019a(i, f, i2);
        }
        if (this.f7581v != null) {
            this.f7581v.mo10019a(i, f, i2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9982a(int i, int i2, int i3) {
        int i4;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i5 = i - scrollX;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            m8212e();
            if (mo9988b()) {
                if (this.f7583x != null) {
                    this.f7583x.mo10068a();
                }
            } else if (this.f7582w != null) {
                this.f7582w.mo10066a();
            }
        } else {
            setScrollingCacheEnabled(true);
            this.f7569j = true;
            int behindWidth = getBehindWidth();
            int i7 = behindWidth / 2;
            float a = (((float) i7) * mo9977a(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / ((float) behindWidth)))) + ((float) i7);
            int abs = Math.abs(i3);
            if (abs > 0) {
                i4 = Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4;
            } else {
                int abs2 = (int) (((((float) Math.abs(i5)) / ((float) behindWidth)) + 1.0f) * 100.0f);
                i4 = 600;
            }
            this.f7567h.startScroll(scrollX, scrollY, i5, i6, Math.min(i4, 600));
            invalidate();
        }
    }

    /* renamed from: a */
    public void mo9983a(int i, boolean z) {
        mo9984a(i, z, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9984a(int i, boolean z, boolean z2) {
        mo9985a(i, z, z2, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9985a(int i, boolean z, boolean z2, int i2) {
        if (z2 || this.f7566g != i) {
            int a = this.f7578s.mo10020a(i);
            boolean z3 = this.f7566g != a;
            this.f7566g = a;
            int a2 = mo9978a(this.f7566g);
            if (z3 && this.f7580u != null) {
                this.f7580u.mo10018a(a);
            }
            if (z3 && this.f7581v != null) {
                this.f7581v.mo10018a(a);
            }
            if (z) {
                mo9982a(a2, 0, i2);
                return;
            }
            m8212e();
            scrollTo(a2, 0);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    /* renamed from: a */
    public boolean mo9986a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return mo9989b(17);
            case 22:
                return mo9989b(66);
            case C0515k.AppCompatTheme_popupMenuStyle:
                if (Build.VERSION.SDK_INT < 11) {
                    return false;
                }
                if (C0352v.m1339a(keyEvent)) {
                    return mo9989b(2);
                }
                if (C0352v.m1340a(keyEvent, 1)) {
                    return mo9989b(1);
                }
                return false;
            default:
                return false;
        }
    }

    public void addIgnoredView(View view) {
        if (!this.f7584y.contains(view)) {
            this.f7584y.add(view);
        }
    }

    /* renamed from: b */
    public boolean mo9988b() {
        return this.f7566g == 0 || this.f7566g == 2;
    }

    /* renamed from: b */
    public boolean mo9989b(int i) {
        boolean z;
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        if (findNextFocus == null || findNextFocus == findFocus) {
            if (i == 17 || i == 1) {
                z = mo9990c();
            } else {
                if (i == 66 || i == 2) {
                    z = mo9992d();
                }
                z = false;
            }
        } else if (i == 17) {
            z = findNextFocus.requestFocus();
        } else {
            if (i == 66) {
                z = (findFocus == null || findNextFocus.getLeft() > findFocus.getLeft()) ? findNextFocus.requestFocus() : mo9992d();
            }
            z = false;
        }
        if (z) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo9990c() {
        if (this.f7566g <= 0) {
            return false;
        }
        mo9983a(this.f7566g - 1, true);
        return true;
    }

    public void computeScroll() {
        if (this.f7567h.isFinished() || !this.f7567h.computeScrollOffset()) {
            m8212e();
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f7567h.getCurrX();
        int currY = this.f7567h.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            m8208c(currX);
        }
        invalidate();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo9992d() {
        if (this.f7566g >= 1) {
            return false;
        }
        mo9983a(this.f7566g + 1, true);
        return true;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f7578s.mo10024a(this.f7565f, canvas);
        this.f7578s.mo10025a(this.f7565f, canvas, getPercentOpen());
        this.f7578s.mo10029b(this.f7565f, canvas, getPercentOpen());
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || mo9986a(keyEvent);
    }

    public int getBehindWidth() {
        if (this.f7578s == null) {
            return 0;
        }
        return this.f7578s.getBehindWidth();
    }

    public View getContent() {
        return this.f7565f;
    }

    public int getContentLeft() {
        return this.f7565f.getLeft() + this.f7565f.getPaddingLeft();
    }

    public int getCurrentItem() {
        return this.f7566g;
    }

    /* access modifiers changed from: protected */
    public float getPercentOpen() {
        return Math.abs(this.f7560A - ((float) this.f7565f.getLeft())) / ((float) getBehindWidth());
    }

    public int getTouchMode() {
        return this.f7564d;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f7579t) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1 || (action != 0 && this.f7571l)) {
            m8214g();
            return false;
        }
        switch (action) {
            case 0:
                int b = C0223ba.m830b(motionEvent);
                this.f7561a = C0223ba.m831b(motionEvent, b);
                if (this.f7561a != -1) {
                    float c = C0223ba.m832c(motionEvent, b);
                    this.f7573n = c;
                    this.f7574o = c;
                    this.f7575p = C0223ba.m834d(motionEvent, b);
                    if (!m8207b(motionEvent)) {
                        this.f7571l = true;
                        break;
                    } else {
                        this.f7570k = false;
                        this.f7571l = false;
                        if (mo9988b() && this.f7578s.mo10032b(this.f7565f, this.f7566g, motionEvent.getX() + this.f7560A)) {
                            this.f7585z = true;
                            break;
                        }
                    }
                }
                break;
            case 2:
                m8209c(motionEvent);
                break;
            case 6:
                m8211d(motionEvent);
                break;
        }
        if (!this.f7570k) {
            if (this.f7562b == null) {
                this.f7562b = VelocityTracker.obtain();
            }
            this.f7562b.addMovement(motionEvent);
        }
        return this.f7570k || this.f7585z;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f7565f.layout(0, 0, i3 - i, i4 - i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(0, i);
        int defaultSize2 = getDefaultSize(0, i2);
        setMeasuredDimension(defaultSize, defaultSize2);
        this.f7565f.measure(getChildMeasureSpec(i, 0, defaultSize), getChildMeasureSpec(i2, 0, defaultSize2));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m8212e();
            scrollTo(mo9978a(this.f7566g), getScrollY());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f7579t) {
            return false;
        }
        if (!this.f7570k && !m8207b(motionEvent)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (this.f7562b == null) {
            this.f7562b = VelocityTracker.obtain();
        }
        this.f7562b.addMovement(motionEvent);
        switch (action & 255) {
            case 0:
                m8212e();
                this.f7561a = C0223ba.m831b(motionEvent, C0223ba.m830b(motionEvent));
                float x = motionEvent.getX();
                this.f7573n = x;
                this.f7574o = x;
                break;
            case 1:
                if (!this.f7570k) {
                    if (this.f7585z && this.f7578s.mo10032b(this.f7565f, this.f7566g, motionEvent.getX() + this.f7560A)) {
                        setCurrentItem(1);
                        m8214g();
                        break;
                    }
                } else {
                    VelocityTracker velocityTracker = this.f7562b;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f7563c);
                    int a = (int) C0242bt.m877a(velocityTracker, this.f7561a);
                    float scrollX = ((float) (getScrollX() - mo9978a(this.f7566g))) / ((float) getBehindWidth());
                    int a2 = m8203a(motionEvent, this.f7561a);
                    if (this.f7561a != -1) {
                        mo9985a(m8202a(scrollX, a, (int) (C0223ba.m832c(motionEvent, a2) - this.f7573n)), true, true, a);
                    } else {
                        mo9985a(this.f7566g, true, true, a);
                    }
                    this.f7561a = -1;
                    m8214g();
                    break;
                }
            case 2:
                if (!this.f7570k) {
                    m8209c(motionEvent);
                    if (this.f7571l) {
                        return false;
                    }
                }
                if (this.f7570k) {
                    int a3 = m8203a(motionEvent, this.f7561a);
                    if (this.f7561a != -1) {
                        float c = C0223ba.m832c(motionEvent, a3);
                        float f = this.f7574o - c;
                        this.f7574o = c;
                        float scrollX2 = ((float) getScrollX()) + f;
                        float leftBound = (float) getLeftBound();
                        float rightBound = (float) getRightBound();
                        if (scrollX2 >= leftBound) {
                            leftBound = scrollX2 > rightBound ? rightBound : scrollX2;
                        }
                        this.f7574o += leftBound - ((float) ((int) leftBound));
                        scrollTo((int) leftBound, getScrollY());
                        m8208c((int) leftBound);
                        break;
                    }
                }
                break;
            case 3:
                if (this.f7570k) {
                    mo9984a(this.f7566g, true, true);
                    this.f7561a = -1;
                    m8214g();
                    break;
                }
                break;
            case 5:
                int b = C0223ba.m830b(motionEvent);
                this.f7574o = C0223ba.m832c(motionEvent, b);
                this.f7561a = C0223ba.m831b(motionEvent, b);
                break;
            case 6:
                m8211d(motionEvent);
                int a4 = m8203a(motionEvent, this.f7561a);
                if (this.f7561a != -1) {
                    this.f7574o = C0223ba.m832c(motionEvent, a4);
                    break;
                }
                break;
        }
        return true;
    }

    public void removeIgnoredView(View view) {
        this.f7584y.remove(view);
    }

    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
        this.f7560A = (float) i;
        this.f7578s.mo10023a(this.f7565f, i, i2);
        ((SlidingMenu) getParent()).mo9921a(getPercentOpen());
    }

    public void setAboveOffset(int i) {
        this.f7565f.setPadding(i, this.f7565f.getPaddingTop(), this.f7565f.getPaddingRight(), this.f7565f.getPaddingBottom());
    }

    public void setContent(View view) {
        if (this.f7565f != null) {
            removeView(this.f7565f);
        }
        this.f7565f = view;
        addView(this.f7565f);
    }

    public void setCurrentItem(int i) {
        mo9984a(i, true, false);
    }

    public void setCustomViewBehind(C1995f fVar) {
        this.f7578s = fVar;
    }

    public void setOnClosedListener(C2003n nVar) {
        this.f7582w = nVar;
    }

    public void setOnOpenedListener(C2005p pVar) {
        this.f7583x = pVar;
    }

    public void setOnPageChangeListener(C1993d dVar) {
        this.f7580u = dVar;
    }

    public void setSlidingEnabled(boolean z) {
        this.f7579t = z;
    }

    public void setTouchMode(int i) {
        this.f7564d = i;
    }
}
