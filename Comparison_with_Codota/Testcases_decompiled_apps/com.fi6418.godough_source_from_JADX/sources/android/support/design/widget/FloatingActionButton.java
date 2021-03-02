package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.C0003d;
import android.support.design.widget.Snackbar;
import android.support.p000v4.view.ViewCompat;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

@C0060h(mo275a = Behavior.class)
public class FloatingActionButton extends ImageView {

    /* renamed from: a */
    private ColorStateList f58a;

    /* renamed from: b */
    private PorterDuff.Mode f59b;

    /* renamed from: c */
    private int f60c;

    /* renamed from: d */
    private int f61d;

    /* renamed from: e */
    private int f62e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Rect f63f;

    /* renamed from: g */
    private final C0067o f64g;

    public class Behavior extends C0059g<FloatingActionButton> {

        /* renamed from: a */
        private static final boolean f65a = (Build.VERSION.SDK_INT >= 11);

        /* renamed from: b */
        private Rect f66b;

        /* renamed from: a */
        private float m86a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            float f = BitmapDescriptorFactory.HUE_RED;
            List<View> c = coordinatorLayout.mo81c((View) floatingActionButton);
            int size = c.size();
            int i = 0;
            while (i < size) {
                View view = c.get(i);
                i++;
                f = (!(view instanceof Snackbar.SnackbarLayout) || !coordinatorLayout.mo76a((View) floatingActionButton, view)) ? f : Math.min(f, ViewCompat.getTranslationY(view) - ((float) view.getHeight()));
            }
            return f;
        }

        /* renamed from: a */
        private boolean m87a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (((C0061i) floatingActionButton.getLayoutParams()).mo276a() != appBarLayout.getId()) {
                return false;
            }
            if (this.f66b == null) {
                this.f66b = new Rect();
            }
            Rect rect = this.f66b;
            C0042bg.m283b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.mo118b();
            } else {
                floatingActionButton.mo117a();
            }
            return true;
        }

        /* renamed from: b */
        private void m88b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i = 0;
            Rect a = floatingActionButton.f63f;
            if (a != null && a.centerX() > 0 && a.centerY() > 0) {
                C0061i iVar = (C0061i) floatingActionButton.getLayoutParams();
                int i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - iVar.rightMargin ? a.right : floatingActionButton.getLeft() <= iVar.leftMargin ? -a.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getBottom() - iVar.bottomMargin) {
                    i = a.bottom;
                } else if (floatingActionButton.getTop() <= iVar.topMargin) {
                    i = -a.top;
                }
                floatingActionButton.offsetTopAndBottom(i);
                floatingActionButton.offsetLeftAndRight(i2);
            }
        }

        /* renamed from: c */
        private void m89c(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (floatingActionButton.getVisibility() == 0) {
                ViewCompat.setTranslationY(floatingActionButton, m86a(coordinatorLayout, floatingActionButton));
            }
        }

        /* renamed from: a */
        public boolean mo53a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List<View> c = coordinatorLayout.mo81c((View) floatingActionButton);
            int size = c.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = c.get(i2);
                if ((view instanceof AppBarLayout) && m87a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.mo69a((View) floatingActionButton, i);
            m88b(coordinatorLayout, floatingActionButton);
            return true;
        }

        /* renamed from: a */
        public boolean mo63b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return f65a && (view instanceof Snackbar.SnackbarLayout);
        }

        /* renamed from: b */
        public boolean mo64c(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof Snackbar.SnackbarLayout) {
                m89c(coordinatorLayout, floatingActionButton, view);
                return false;
            } else if (!(view instanceof AppBarLayout)) {
                return false;
            } else {
                m87a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
        }
    }

    /* renamed from: a */
    private static int m82a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    /* renamed from: a */
    public void mo117a() {
        this.f64g.mo308c();
    }

    /* renamed from: b */
    public void mo118b() {
        this.f64g.mo307b();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f64g.mo306a(getDrawableState());
    }

    public ColorStateList getBackgroundTintList() {
        return this.f58a;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f59b;
    }

    /* access modifiers changed from: package-private */
    public final int getSizeDimension() {
        switch (this.f62e) {
            case 1:
                return getResources().getDimensionPixelSize(C0003d.design_fab_size_mini);
            default:
                return getResources().getDimensionPixelSize(C0003d.design_fab_size_normal);
        }
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f64g.mo301a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        int min = Math.min(m82a(sizeDimension, i), m82a(sizeDimension, i2));
        setMeasuredDimension(this.f63f.left + min + this.f63f.right, min + this.f63f.top + this.f63f.bottom);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f64g != null) {
            this.f64g.mo305a(drawable, this.f58a, this.f59b, this.f61d, this.f60c);
        }
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f58a != colorStateList) {
            this.f58a = colorStateList;
            this.f64g.mo303a(colorStateList);
        }
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f59b != mode) {
            this.f59b = mode;
            this.f64g.mo304a(mode);
        }
    }

    public void setRippleColor(int i) {
        if (this.f61d != i) {
            this.f61d = i;
            this.f64g.mo302a(i);
        }
    }
}
