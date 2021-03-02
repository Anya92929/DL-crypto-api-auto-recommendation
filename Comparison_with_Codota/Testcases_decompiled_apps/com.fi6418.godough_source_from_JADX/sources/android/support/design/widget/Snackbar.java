package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.design.C0001b;
import android.support.design.C0003d;
import android.support.design.C0004e;
import android.support.design.C0005f;
import android.support.design.C0007h;
import android.support.p000v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class Snackbar {

    /* renamed from: a */
    private static final Handler f67a = new Handler(Looper.getMainLooper(), new C0069q());

    /* renamed from: b */
    private final ViewGroup f68b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final SnackbarLayout f69c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C0077y f70d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C0011ac f71e;

    public class SnackbarLayout extends LinearLayout {

        /* renamed from: a */
        private TextView f72a;

        /* renamed from: b */
        private Button f73b;

        /* renamed from: c */
        private int f74c;

        /* renamed from: d */
        private int f75d;

        /* renamed from: e */
        private C0078z f76e;

        public SnackbarLayout(Context context) {
            this(context, (AttributeSet) null);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0007h.SnackbarLayout);
            this.f74c = obtainStyledAttributes.getDimensionPixelSize(C0007h.SnackbarLayout_android_maxWidth, -1);
            this.f75d = obtainStyledAttributes.getDimensionPixelSize(C0007h.SnackbarLayout_maxActionInlineWidth, -1);
            if (obtainStyledAttributes.hasValue(C0007h.SnackbarLayout_elevation)) {
                ViewCompat.setElevation(this, (float) obtainStyledAttributes.getDimensionPixelSize(C0007h.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(C0005f.design_layout_snackbar_include, this);
        }

        /* renamed from: a */
        private static void m109a(View view, int i, int i2) {
            if (ViewCompat.isPaddingRelative(view)) {
                ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i, ViewCompat.getPaddingEnd(view), i2);
            } else {
                view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
            }
        }

        /* renamed from: a */
        private boolean m110a(int i, int i2, int i3) {
            boolean z = false;
            if (i != getOrientation()) {
                setOrientation(i);
                z = true;
            }
            if (this.f72a.getPaddingTop() == i2 && this.f72a.getPaddingBottom() == i3) {
                return z;
            }
            m109a((View) this.f72a, i2, i3);
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo134a(int i, int i2) {
            ViewCompat.setAlpha(this.f72a, BitmapDescriptorFactory.HUE_RED);
            ViewCompat.animate(this.f72a).alpha(1.0f).setDuration((long) i2).setStartDelay((long) i).start();
            if (this.f73b.getVisibility() == 0) {
                ViewCompat.setAlpha(this.f73b, BitmapDescriptorFactory.HUE_RED);
                ViewCompat.animate(this.f73b).alpha(1.0f).setDuration((long) i2).setStartDelay((long) i).start();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo135b(int i, int i2) {
            ViewCompat.setAlpha(this.f72a, 1.0f);
            ViewCompat.animate(this.f72a).alpha(BitmapDescriptorFactory.HUE_RED).setDuration((long) i2).setStartDelay((long) i).start();
            if (this.f73b.getVisibility() == 0) {
                ViewCompat.setAlpha(this.f73b, 1.0f);
                ViewCompat.animate(this.f73b).alpha(BitmapDescriptorFactory.HUE_RED).setDuration((long) i2).setStartDelay((long) i).start();
            }
        }

        /* access modifiers changed from: package-private */
        public Button getActionView() {
            return this.f73b;
        }

        /* access modifiers changed from: package-private */
        public TextView getMessageView() {
            return this.f72a;
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            this.f72a = (TextView) findViewById(C0004e.snackbar_text);
            this.f73b = (Button) findViewById(C0004e.snackbar_action);
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (z && this.f76e != null) {
                this.f76e.mo310a(this, i, i2, i3, i4);
            }
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i, int i2) {
            boolean z;
            super.onMeasure(i, i2);
            if (this.f74c > 0 && getMeasuredWidth() > this.f74c) {
                i = View.MeasureSpec.makeMeasureSpec(this.f74c, 1073741824);
                super.onMeasure(i, i2);
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(C0003d.design_snackbar_padding_vertical_2lines);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(C0003d.design_snackbar_padding_vertical);
            boolean z2 = this.f72a.getLayout().getLineCount() > 1;
            if (!z2 || this.f75d <= 0 || this.f73b.getMeasuredWidth() <= this.f75d) {
                if (!z2) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (m110a(0, dimensionPixelSize, dimensionPixelSize)) {
                    z = true;
                }
                z = false;
            } else {
                if (m110a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                    z = true;
                }
                z = false;
            }
            if (z) {
                super.onMeasure(i, i2);
            }
        }

        /* access modifiers changed from: package-private */
        public void setOnLayoutChangeListener(C0078z zVar) {
            this.f76e = zVar;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m98b() {
        if (Build.VERSION.SDK_INT >= 14) {
            ViewCompat.setTranslationY(this.f69c, (float) this.f69c.getHeight());
            ViewCompat.animate(this.f69c).translationY(BitmapDescriptorFactory.HUE_RED).setInterpolator(C0008a.f108b).setDuration(250).setListener(new C0072t(this)).start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f69c.getContext(), C0001b.design_snackbar_in);
        loadAnimation.setInterpolator(C0008a.f108b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new C0073u(this));
        this.f69c.startAnimation(loadAnimation);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m99b(int i) {
        C0009aa.m171a().mo170a(this.f71e, i);
    }

    /* renamed from: c */
    private void m103c(int i) {
        if (Build.VERSION.SDK_INT >= 14) {
            ViewCompat.animate(this.f69c).translationY((float) this.f69c.getHeight()).setInterpolator(C0008a.f108b).setDuration(250).setListener(new C0074v(this, i)).start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f69c.getContext(), C0001b.design_snackbar_out);
        loadAnimation.setInterpolator(C0008a.f108b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new C0075w(this, i));
        this.f69c.startAnimation(loadAnimation);
    }

    /* renamed from: c */
    private boolean m104c() {
        ViewGroup.LayoutParams layoutParams = this.f69c.getLayoutParams();
        if (layoutParams instanceof C0061i) {
            C0059g b = ((C0061i) layoutParams).mo282b();
            if (b instanceof SwipeDismissBehavior) {
                return ((SwipeDismissBehavior) b).mo142a() != 0;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m106d(int i) {
        this.f68b.removeView(this.f69c);
        if (this.f70d != null) {
            this.f70d.mo321a(this, i);
        }
        C0009aa.m171a().mo169a(this.f71e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo132a() {
        if (this.f69c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f69c.getLayoutParams();
            if (layoutParams instanceof C0061i) {
                C0076x xVar = new C0076x(this);
                xVar.mo143a(0.1f);
                xVar.mo146b(0.6f);
                xVar.mo144a(0);
                xVar.mo145a((C0014af) new C0070r(this));
                ((C0061i) layoutParams).mo278a((C0059g) xVar);
            }
            this.f68b.addView(this.f69c);
        }
        if (ViewCompat.isLaidOut(this.f69c)) {
            m98b();
        } else {
            this.f69c.setOnLayoutChangeListener(new C0071s(this));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo133a(int i) {
        if (this.f69c.getVisibility() != 0 || m104c()) {
            m106d(i);
        } else {
            m103c(i);
        }
    }
}
