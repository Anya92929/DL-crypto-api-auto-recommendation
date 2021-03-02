package android.support.p001v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.p001v4.content.ContextCompat;
import android.support.p001v4.view.GravityCompat;
import android.support.p001v4.view.ViewCompat;
import android.support.p001v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

@Deprecated
/* renamed from: android.support.v4.app.ActionBarDrawerToggle */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* renamed from: a */
    private static final C0030a f29a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Activity f30b;

    /* renamed from: c */
    private final Delegate f31c;

    /* renamed from: d */
    private final DrawerLayout f32d;

    /* renamed from: e */
    private boolean f33e;

    /* renamed from: f */
    private boolean f34f;

    /* renamed from: g */
    private Drawable f35g;

    /* renamed from: h */
    private Drawable f36h;

    /* renamed from: i */
    private C0034e f37i;

    /* renamed from: j */
    private final int f38j;

    /* renamed from: k */
    private final int f39k;

    /* renamed from: l */
    private final int f40l;

    /* renamed from: m */
    private Object f41m;

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$Delegate */
    public interface Delegate {
        @Nullable
        Drawable getThemeUpIndicator();

        void setActionBarDescription(@StringRes int i);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i);
    }

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$DelegateProvider */
    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$a */
    interface C0030a {
        /* renamed from: a */
        Drawable mo91a(Activity activity);

        /* renamed from: a */
        Object mo92a(Object obj, Activity activity, int i);

        /* renamed from: a */
        Object mo93a(Object obj, Activity activity, Drawable drawable, int i);
    }

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$b */
    static class C0031b implements C0030a {
        private C0031b() {
        }

        /* renamed from: a */
        public Drawable mo91a(Activity activity) {
            return null;
        }

        /* renamed from: a */
        public Object mo93a(Object obj, Activity activity, Drawable drawable, int i) {
            return obj;
        }

        /* renamed from: a */
        public Object mo92a(Object obj, Activity activity, int i) {
            return obj;
        }
    }

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$c */
    static class C0032c implements C0030a {
        private C0032c() {
        }

        /* renamed from: a */
        public Drawable mo91a(Activity activity) {
            return C1235i.m5500a(activity);
        }

        /* renamed from: a */
        public Object mo93a(Object obj, Activity activity, Drawable drawable, int i) {
            return C1235i.m5502a(obj, activity, drawable, i);
        }

        /* renamed from: a */
        public Object mo92a(Object obj, Activity activity, int i) {
            return C1235i.m5501a(obj, activity, i);
        }
    }

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$d */
    static class C0033d implements C0030a {
        private C0033d() {
        }

        /* renamed from: a */
        public Drawable mo91a(Activity activity) {
            return C1306j.m5671a(activity);
        }

        /* renamed from: a */
        public Object mo93a(Object obj, Activity activity, Drawable drawable, int i) {
            return C1306j.m5673a(obj, activity, drawable, i);
        }

        /* renamed from: a */
        public Object mo92a(Object obj, Activity activity, int i) {
            return C1306j.m5672a(obj, activity, i);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            f29a = new C0033d();
        } else if (i >= 11) {
            f29a = new C0032c();
        } else {
            f29a = new C0031b();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @DrawableRes int i, @StringRes int i2, @StringRes int i3) {
        this(activity, drawerLayout, !m76a((Context) activity), i, i2, i3);
    }

    /* renamed from: a */
    private static boolean m76a(Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 21 && Build.VERSION.SDK_INT >= 21;
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, boolean z, @DrawableRes int i, @StringRes int i2, @StringRes int i3) {
        this.f33e = true;
        this.f30b = activity;
        if (activity instanceof DelegateProvider) {
            this.f31c = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.f31c = null;
        }
        this.f32d = drawerLayout;
        this.f38j = i;
        this.f39k = i2;
        this.f40l = i3;
        this.f35g = mo73a();
        this.f36h = ContextCompat.getDrawable(activity, i);
        this.f37i = new C0034e(this.f36h);
        this.f37i.mo96b(z ? 0.33333334f : BitmapDescriptorFactory.HUE_RED);
    }

    public void syncState() {
        if (this.f32d.isDrawerOpen((int) GravityCompat.START)) {
            this.f37i.mo95a(1.0f);
        } else {
            this.f37i.mo95a(BitmapDescriptorFactory.HUE_RED);
        }
        if (this.f33e) {
            mo75a(this.f37i, this.f32d.isDrawerOpen((int) GravityCompat.START) ? this.f40l : this.f39k);
        }
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.f35g = mo73a();
            this.f34f = false;
        } else {
            this.f35g = drawable;
            this.f34f = true;
        }
        if (!this.f33e) {
            mo75a(this.f35g, 0);
        }
    }

    public void setHomeAsUpIndicator(int i) {
        Drawable drawable = null;
        if (i != 0) {
            drawable = ContextCompat.getDrawable(this.f30b, i);
        }
        setHomeAsUpIndicator(drawable);
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if (z != this.f33e) {
            if (z) {
                mo75a(this.f37i, this.f32d.isDrawerOpen((int) GravityCompat.START) ? this.f40l : this.f39k);
            } else {
                mo75a(this.f35g, 0);
            }
            this.f33e = z;
        }
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.f33e;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.f34f) {
            this.f35g = mo73a();
        }
        this.f36h = ContextCompat.getDrawable(this.f30b, this.f38j);
        syncState();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.f33e) {
            return false;
        }
        if (this.f32d.isDrawerVisible((int) GravityCompat.START)) {
            this.f32d.closeDrawer((int) GravityCompat.START);
        } else {
            this.f32d.openDrawer((int) GravityCompat.START);
        }
        return true;
    }

    public void onDrawerSlide(View view, float f) {
        float min;
        float a = this.f37i.mo94a();
        if (f > 0.5f) {
            min = Math.max(a, Math.max(BitmapDescriptorFactory.HUE_RED, f - 0.5f) * 2.0f);
        } else {
            min = Math.min(a, f * 2.0f);
        }
        this.f37i.mo95a(min);
    }

    public void onDrawerOpened(View view) {
        this.f37i.mo95a(1.0f);
        if (this.f33e) {
            mo74a(this.f40l);
        }
    }

    public void onDrawerClosed(View view) {
        this.f37i.mo95a(BitmapDescriptorFactory.HUE_RED);
        if (this.f33e) {
            mo74a(this.f39k);
        }
    }

    public void onDrawerStateChanged(int i) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Drawable mo73a() {
        if (this.f31c != null) {
            return this.f31c.getThemeUpIndicator();
        }
        return f29a.mo91a(this.f30b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo75a(Drawable drawable, int i) {
        if (this.f31c != null) {
            this.f31c.setActionBarUpIndicator(drawable, i);
        } else {
            this.f41m = f29a.mo93a(this.f41m, this.f30b, drawable, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo74a(int i) {
        if (this.f31c != null) {
            this.f31c.setActionBarDescription(i);
        } else {
            this.f41m = f29a.mo92a(this.f41m, this.f30b, i);
        }
    }

    /* renamed from: android.support.v4.app.ActionBarDrawerToggle$e */
    class C0034e extends InsetDrawable implements Drawable.Callback {

        /* renamed from: a */
        final /* synthetic */ ActionBarDrawerToggle f42a;

        /* renamed from: b */
        private final boolean f43b;

        /* renamed from: c */
        private final Rect f44c;

        /* renamed from: d */
        private float f45d;

        /* renamed from: e */
        private float f46e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private C0034e(ActionBarDrawerToggle actionBarDrawerToggle, Drawable drawable) {
            super(drawable, 0);
            boolean z = false;
            this.f42a = actionBarDrawerToggle;
            this.f43b = Build.VERSION.SDK_INT > 18 ? true : z;
            this.f44c = new Rect();
        }

        /* renamed from: a */
        public void mo95a(float f) {
            this.f45d = f;
            invalidateSelf();
        }

        /* renamed from: a */
        public float mo94a() {
            return this.f45d;
        }

        /* renamed from: b */
        public void mo96b(float f) {
            this.f46e = f;
            invalidateSelf();
        }

        public void draw(Canvas canvas) {
            int i = 1;
            copyBounds(this.f44c);
            canvas.save();
            boolean z = ViewCompat.getLayoutDirection(this.f42a.f30b.getWindow().getDecorView()) == 1;
            if (z) {
                i = -1;
            }
            int width = this.f44c.width();
            canvas.translate(((float) i) * (-this.f46e) * ((float) width) * this.f45d, BitmapDescriptorFactory.HUE_RED);
            if (z && !this.f43b) {
                canvas.translate((float) width, BitmapDescriptorFactory.HUE_RED);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }
    }
}
