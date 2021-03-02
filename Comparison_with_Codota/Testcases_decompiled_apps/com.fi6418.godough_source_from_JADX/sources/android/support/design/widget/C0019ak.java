package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.p000v4.view.ViewCompat;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.design.widget.ak */
class C0019ak extends LinearLayout {

    /* renamed from: a */
    final /* synthetic */ TabLayout f125a;

    /* renamed from: b */
    private int f126b;

    /* renamed from: c */
    private final Paint f127c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f128d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public float f129e;

    /* renamed from: f */
    private int f130f = -1;

    /* renamed from: g */
    private int f131g = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0019ak(TabLayout tabLayout, Context context) {
        super(context);
        this.f125a = tabLayout;
        setWillNotDraw(false);
        this.f127c = new Paint();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m196b(int i, int i2) {
        if (i != this.f130f || i2 != this.f131g) {
            this.f130f = i;
            this.f131g = i2;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* renamed from: c */
    private void m197c() {
        int i;
        int i2;
        View childAt = getChildAt(this.f128d);
        if (childAt == null || childAt.getWidth() <= 0) {
            i = -1;
            i2 = -1;
        } else {
            i2 = childAt.getLeft();
            i = childAt.getRight();
            if (this.f129e > BitmapDescriptorFactory.HUE_RED && this.f128d < getChildCount() - 1) {
                View childAt2 = getChildAt(this.f128d + 1);
                i2 = (int) ((((float) i2) * (1.0f - this.f129e)) + (this.f129e * ((float) childAt2.getLeft())));
                i = (int) ((((float) i) * (1.0f - this.f129e)) + (((float) childAt2.getRight()) * this.f129e));
            }
        }
        m196b(i2, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo193a(int i) {
        if (this.f127c.getColor() != i) {
            this.f127c.setColor(i);
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo194a(int i, float f) {
        this.f128d = i;
        this.f129e = f;
        m197c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo195a(int i, int i2) {
        int i3;
        int i4;
        boolean z = ViewCompat.getLayoutDirection(this) == 1;
        View childAt = getChildAt(i);
        int left = childAt.getLeft();
        int right = childAt.getRight();
        if (Math.abs(i - this.f128d) <= 1) {
            i4 = this.f130f;
            i3 = this.f131g;
        } else {
            int b = this.f125a.m142c(24);
            if (i < this.f128d) {
                if (z) {
                    i3 = left - b;
                    i4 = i3;
                } else {
                    i3 = right + b;
                    i4 = i3;
                }
            } else if (z) {
                i3 = right + b;
                i4 = i3;
            } else {
                i3 = left - b;
                i4 = i3;
            }
        }
        if (i4 != left || i3 != right) {
            C0026ar a = this.f125a.f106t = C0050bo.m298a();
            a.mo228a(C0008a.f108b);
            a.mo224a(i2);
            a.mo223a((float) BitmapDescriptorFactory.HUE_RED, 1.0f);
            a.mo227a((C0031aw) new C0020al(this, i4, left, i3, right));
            a.mo226a((C0029au) new C0021am(this, i));
            a.mo222a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo196a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).getWidth() <= 0) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public float mo197b() {
        return ((float) this.f128d) + this.f129e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo198b(int i) {
        if (this.f126b != i) {
            this.f126b = i;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f130f >= 0 && this.f131g > this.f130f) {
            canvas.drawRect((float) this.f130f, (float) (getHeight() - this.f126b), (float) this.f131g, (float) getHeight(), this.f127c);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m197c();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) == 1073741824 && this.f125a.f102p == 1 && this.f125a.f101o == 1) {
            int childCount = getChildCount();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                childAt.measure(makeMeasureSpec, i2);
                i3 = Math.max(i3, childAt.getMeasuredWidth());
            }
            if (i3 > 0) {
                if (i3 * childCount <= getMeasuredWidth() - (this.f125a.m142c(16) * 2)) {
                    for (int i5 = 0; i5 < childCount; i5++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                        layoutParams.width = i3;
                        layoutParams.weight = BitmapDescriptorFactory.HUE_RED;
                    }
                } else {
                    int unused = this.f125a.f101o = 0;
                    this.f125a.m155f();
                }
                super.onMeasure(i, i2);
            }
        }
    }
}
