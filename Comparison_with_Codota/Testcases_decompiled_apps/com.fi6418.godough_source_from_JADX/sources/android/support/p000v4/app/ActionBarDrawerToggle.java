package android.support.p000v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

@Deprecated
/* renamed from: android.support.v4.app.ActionBarDrawerToggle */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* renamed from: a */
    private static final ActionBarDrawerToggleImpl f256a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Activity f257b;

    /* renamed from: c */
    private final Delegate f258c;

    /* renamed from: d */
    private final DrawerLayout f259d;

    /* renamed from: e */
    private boolean f260e;

    /* renamed from: f */
    private boolean f261f;

    /* renamed from: g */
    private Drawable f262g;

    /* renamed from: h */
    private Drawable f263h;

    /* renamed from: i */
    private SlideDrawable f264i;

    /* renamed from: j */
    private final int f265j;

    /* renamed from: k */
    private final int f266k;

    /* renamed from: l */
    private final int f267l;

    /* renamed from: m */
    private Object f268m;

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$ActionBarDrawerToggleImpl */
    interface ActionBarDrawerToggleImpl {
        Drawable getThemeUpIndicator(Activity activity);

        Object setActionBarDescription(Object obj, Activity activity, int i);

        Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i);
    }

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$ActionBarDrawerToggleImplBase */
    class ActionBarDrawerToggleImplBase implements ActionBarDrawerToggleImpl {
        private ActionBarDrawerToggleImplBase() {
        }

        public Drawable getThemeUpIndicator(Activity activity) {
            return null;
        }

        public Object setActionBarDescription(Object obj, Activity activity, int i) {
            return obj;
        }

        public Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i) {
            return obj;
        }
    }

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$ActionBarDrawerToggleImplHC */
    class ActionBarDrawerToggleImplHC implements ActionBarDrawerToggleImpl {
        private ActionBarDrawerToggleImplHC() {
        }

        public Drawable getThemeUpIndicator(Activity activity) {
            return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(activity);
        }

        public Object setActionBarDescription(Object obj, Activity activity, int i) {
            return ActionBarDrawerToggleHoneycomb.setActionBarDescription(obj, activity, i);
        }

        public Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i) {
            return ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(obj, activity, drawable, i);
        }
    }

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$ActionBarDrawerToggleImplJellybeanMR2 */
    class ActionBarDrawerToggleImplJellybeanMR2 implements ActionBarDrawerToggleImpl {
        private ActionBarDrawerToggleImplJellybeanMR2() {
        }

        public Drawable getThemeUpIndicator(Activity activity) {
            return ActionBarDrawerToggleJellybeanMR2.getThemeUpIndicator(activity);
        }

        public Object setActionBarDescription(Object obj, Activity activity, int i) {
            return ActionBarDrawerToggleJellybeanMR2.setActionBarDescription(obj, activity, i);
        }

        public Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i) {
            return ActionBarDrawerToggleJellybeanMR2.setActionBarUpIndicator(obj, activity, drawable, i);
        }
    }

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$Delegate */
    public interface Delegate {
        Drawable getThemeUpIndicator();

        void setActionBarDescription(int i);

        void setActionBarUpIndicator(Drawable drawable, int i);
    }

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$DelegateProvider */
    public interface DelegateProvider {
        Delegate getDrawerToggleDelegate();
    }

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$SlideDrawable */
    class SlideDrawable extends InsetDrawable implements Drawable.Callback {

        /* renamed from: a */
        final /* synthetic */ ActionBarDrawerToggle f269a;

        /* renamed from: b */
        private final boolean f270b;

        /* renamed from: c */
        private final Rect f271c;

        /* renamed from: d */
        private float f272d;

        /* renamed from: e */
        private float f273e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private SlideDrawable(ActionBarDrawerToggle actionBarDrawerToggle, Drawable drawable) {
            super(drawable, 0);
            boolean z = false;
            this.f269a = actionBarDrawerToggle;
            this.f270b = Build.VERSION.SDK_INT > 18 ? true : z;
            this.f271c = new Rect();
        }

        public void draw(Canvas canvas) {
            int i = 1;
            copyBounds(this.f271c);
            canvas.save();
            boolean z = ViewCompat.getLayoutDirection(this.f269a.f257b.getWindow().getDecorView()) == 1;
            if (z) {
                i = -1;
            }
            int width = this.f271c.width();
            canvas.translate(((float) i) * (-this.f273e) * ((float) width) * this.f272d, BitmapDescriptorFactory.HUE_RED);
            if (z && !this.f270b) {
                canvas.translate((float) width, BitmapDescriptorFactory.HUE_RED);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }

        public float getPosition() {
            return this.f272d;
        }

        public void setOffset(float f) {
            this.f273e = f;
            invalidateSelf();
        }

        public void setPosition(float f) {
            this.f272d = f;
            invalidateSelf();
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            f256a = new ActionBarDrawerToggleImplJellybeanMR2();
        } else if (i >= 11) {
            f256a = new ActionBarDrawerToggleImplHC();
        } else {
            f256a = new ActionBarDrawerToggleImplBase();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, int i, int i2, int i3) {
        this(activity, drawerLayout, !m394a((Context) activity), i, i2, i3);
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, boolean z, int i, int i2, int i3) {
        this.f260e = true;
        this.f257b = activity;
        if (activity instanceof DelegateProvider) {
            this.f258c = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.f258c = null;
        }
        this.f259d = drawerLayout;
        this.f265j = i;
        this.f266k = i2;
        this.f267l = i3;
        this.f262g = mo362a();
        this.f263h = ContextCompat.getDrawable(activity, i);
        this.f264i = new SlideDrawable(this.f263h);
        this.f264i.setOffset(z ? 0.33333334f : BitmapDescriptorFactory.HUE_RED);
    }

    /* renamed from: a */
    private static boolean m394a(Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 21 && Build.VERSION.SDK_INT >= 21;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Drawable mo362a() {
        return this.f258c != null ? this.f258c.getThemeUpIndicator() : f256a.getThemeUpIndicator(this.f257b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo363a(int i) {
        if (this.f258c != null) {
            this.f258c.setActionBarDescription(i);
        } else {
            this.f268m = f256a.setActionBarDescription(this.f268m, this.f257b, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo364a(Drawable drawable, int i) {
        if (this.f258c != null) {
            this.f258c.setActionBarUpIndicator(drawable, i);
        } else {
            this.f268m = f256a.setActionBarUpIndicator(this.f268m, this.f257b, drawable, i);
        }
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.f260e;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.f261f) {
            this.f262g = mo362a();
        }
        this.f263h = ContextCompat.getDrawable(this.f257b, this.f265j);
        syncState();
    }

    public void onDrawerClosed(View view) {
        this.f264i.setPosition(BitmapDescriptorFactory.HUE_RED);
        if (this.f260e) {
            mo363a(this.f266k);
        }
    }

    public void onDrawerOpened(View view) {
        this.f264i.setPosition(1.0f);
        if (this.f260e) {
            mo363a(this.f267l);
        }
    }

    public void onDrawerSlide(View view, float f) {
        float position = this.f264i.getPosition();
        this.f264i.setPosition(f > 0.5f ? Math.max(position, Math.max(BitmapDescriptorFactory.HUE_RED, f - 0.5f) * 2.0f) : Math.min(position, f * 2.0f));
    }

    public void onDrawerStateChanged(int i) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.f260e) {
            return false;
        }
        if (this.f259d.isDrawerVisible(8388611)) {
            this.f259d.closeDrawer(8388611);
        } else {
            this.f259d.openDrawer(8388611);
        }
        return true;
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if (z != this.f260e) {
            if (z) {
                mo364a(this.f264i, this.f259d.isDrawerOpen(8388611) ? this.f267l : this.f266k);
            } else {
                mo364a(this.f262g, 0);
            }
            this.f260e = z;
        }
    }

    public void setHomeAsUpIndicator(int i) {
        Drawable drawable = null;
        if (i != 0) {
            drawable = ContextCompat.getDrawable(this.f257b, i);
        }
        setHomeAsUpIndicator(drawable);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.f262g = mo362a();
            this.f261f = false;
        } else {
            this.f262g = drawable;
            this.f261f = true;
        }
        if (!this.f260e) {
            mo364a(this.f262g, 0);
        }
    }

    public void syncState() {
        if (this.f259d.isDrawerOpen(8388611)) {
            this.f264i.setPosition(1.0f);
        } else {
            this.f264i.setPosition(BitmapDescriptorFactory.HUE_RED);
        }
        if (this.f260e) {
            mo364a(this.f264i, this.f259d.isDrawerOpen(8388611) ? this.f267l : this.f266k);
        }
    }
}
