package android.support.p004v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.p001v4.view.GravityCompat;
import android.support.p001v4.widget.DrawerLayout;
import android.support.p004v7.graphics.drawable.DrawerArrowDrawable;
import android.support.p004v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import p000.C1137fx;

/* renamed from: android.support.v7.app.ActionBarDrawerToggle */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* renamed from: a */
    private final Delegate f1405a;

    /* renamed from: b */
    private final DrawerLayout f1406b;

    /* renamed from: c */
    private C0469b f1407c;

    /* renamed from: d */
    private Drawable f1408d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f1409e;

    /* renamed from: f */
    private boolean f1410f;

    /* renamed from: g */
    private final int f1411g;

    /* renamed from: h */
    private final int f1412h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View.OnClickListener f1413i;

    /* renamed from: j */
    private boolean f1414j;

    /* renamed from: android.support.v7.app.ActionBarDrawerToggle$Delegate */
    public interface Delegate {
        Context getActionBarThemedContext();

        Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(@StringRes int i);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i);
    }

    /* renamed from: android.support.v7.app.ActionBarDrawerToggle$DelegateProvider */
    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    /* renamed from: android.support.v7.app.ActionBarDrawerToggle$b */
    interface C0469b {
        /* renamed from: a */
        void mo3201a(float f);
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @StringRes int i, @StringRes int i2) {
        this(activity, (Toolbar) null, drawerLayout, (Drawable) null, i, i2);
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, @StringRes int i, @StringRes int i2) {
        this(activity, toolbar, drawerLayout, (Drawable) null, i, i2);
    }

    <T extends Drawable & C0469b> ActionBarDrawerToggle(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, T t, @StringRes int i, @StringRes int i2) {
        this.f1409e = true;
        this.f1414j = false;
        if (toolbar != null) {
            this.f1405a = new C0473f(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (ActionBarDrawerToggle.this.f1409e) {
                        ActionBarDrawerToggle.this.m2848b();
                    } else if (ActionBarDrawerToggle.this.f1413i != null) {
                        ActionBarDrawerToggle.this.f1413i.onClick(view);
                    }
                }
            });
        } else if (activity instanceof DelegateProvider) {
            this.f1405a = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else if (Build.VERSION.SDK_INT >= 18) {
            this.f1405a = new C0472e(activity);
        } else if (Build.VERSION.SDK_INT >= 11) {
            this.f1405a = new C0471d(activity);
        } else {
            this.f1405a = new C0470c(activity);
        }
        this.f1406b = drawerLayout;
        this.f1411g = i;
        this.f1412h = i2;
        if (t == null) {
            this.f1407c = new C0468a(activity, this.f1405a.getActionBarThemedContext());
        } else {
            this.f1407c = (C0469b) t;
        }
        this.f1408d = mo3182a();
    }

    public void syncState() {
        if (this.f1406b.isDrawerOpen((int) GravityCompat.START)) {
            this.f1407c.mo3201a(1.0f);
        } else {
            this.f1407c.mo3201a(BitmapDescriptorFactory.HUE_RED);
        }
        if (this.f1409e) {
            mo3184a((Drawable) this.f1407c, this.f1406b.isDrawerOpen((int) GravityCompat.START) ? this.f1412h : this.f1411g);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.f1410f) {
            this.f1408d = mo3182a();
        }
        syncState();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.f1409e) {
            return false;
        }
        m2848b();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2848b() {
        if (this.f1406b.isDrawerVisible((int) GravityCompat.START)) {
            this.f1406b.closeDrawer((int) GravityCompat.START);
        } else {
            this.f1406b.openDrawer((int) GravityCompat.START);
        }
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.f1408d = mo3182a();
            this.f1410f = false;
        } else {
            this.f1408d = drawable;
            this.f1410f = true;
        }
        if (!this.f1409e) {
            mo3184a(this.f1408d, 0);
        }
    }

    public void setHomeAsUpIndicator(int i) {
        Drawable drawable = null;
        if (i != 0) {
            drawable = this.f1406b.getResources().getDrawable(i);
        }
        setHomeAsUpIndicator(drawable);
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.f1409e;
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if (z != this.f1409e) {
            if (z) {
                mo3184a((Drawable) this.f1407c, this.f1406b.isDrawerOpen((int) GravityCompat.START) ? this.f1412h : this.f1411g);
            } else {
                mo3184a(this.f1408d, 0);
            }
            this.f1409e = z;
        }
    }

    public void onDrawerSlide(View view, float f) {
        this.f1407c.mo3201a(Math.min(1.0f, Math.max(BitmapDescriptorFactory.HUE_RED, f)));
    }

    public void onDrawerOpened(View view) {
        this.f1407c.mo3201a(1.0f);
        if (this.f1409e) {
            mo3183a(this.f1412h);
        }
    }

    public void onDrawerClosed(View view) {
        this.f1407c.mo3201a(BitmapDescriptorFactory.HUE_RED);
        if (this.f1409e) {
            mo3183a(this.f1411g);
        }
    }

    public void onDrawerStateChanged(int i) {
    }

    public View.OnClickListener getToolbarNavigationClickListener() {
        return this.f1413i;
    }

    public void setToolbarNavigationClickListener(View.OnClickListener onClickListener) {
        this.f1413i = onClickListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3184a(Drawable drawable, int i) {
        if (!this.f1414j && !this.f1405a.isNavigationVisible()) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.f1414j = true;
        }
        this.f1405a.setActionBarUpIndicator(drawable, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3183a(int i) {
        this.f1405a.setActionBarDescription(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Drawable mo3182a() {
        return this.f1405a.getThemeUpIndicator();
    }

    /* renamed from: android.support.v7.app.ActionBarDrawerToggle$a */
    static class C0468a extends DrawerArrowDrawable implements C0469b {

        /* renamed from: a */
        private final Activity f1416a;

        public C0468a(Activity activity, Context context) {
            super(context);
            this.f1416a = activity;
        }

        /* renamed from: a */
        public void mo3201a(float f) {
            if (f == 1.0f) {
                setVerticalMirror(true);
            } else if (f == BitmapDescriptorFactory.HUE_RED) {
                setVerticalMirror(false);
            }
            setProgress(f);
        }
    }

    /* renamed from: android.support.v7.app.ActionBarDrawerToggle$d */
    static class C0471d implements Delegate {

        /* renamed from: a */
        final Activity f1418a;

        /* renamed from: b */
        C1137fx.C1138a f1419b;

        private C0471d(Activity activity) {
            this.f1418a = activity;
        }

        public Drawable getThemeUpIndicator() {
            return C1137fx.m5124a(this.f1418a);
        }

        public Context getActionBarThemedContext() {
            ActionBar actionBar = this.f1418a.getActionBar();
            if (actionBar != null) {
                return actionBar.getThemedContext();
            }
            return this.f1418a;
        }

        public boolean isNavigationVisible() {
            ActionBar actionBar = this.f1418a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        public void setActionBarUpIndicator(Drawable drawable, int i) {
            this.f1418a.getActionBar().setDisplayShowHomeEnabled(true);
            this.f1419b = C1137fx.m5126a(this.f1419b, this.f1418a, drawable, i);
            this.f1418a.getActionBar().setDisplayShowHomeEnabled(false);
        }

        public void setActionBarDescription(int i) {
            this.f1419b = C1137fx.m5125a(this.f1419b, this.f1418a, i);
        }
    }

    /* renamed from: android.support.v7.app.ActionBarDrawerToggle$e */
    static class C0472e implements Delegate {

        /* renamed from: a */
        final Activity f1420a;

        private C0472e(Activity activity) {
            this.f1420a = activity;
        }

        public Drawable getThemeUpIndicator() {
            TypedArray obtainStyledAttributes = getActionBarThemedContext().obtainStyledAttributes((AttributeSet) null, new int[]{16843531}, 16843470, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        public Context getActionBarThemedContext() {
            ActionBar actionBar = this.f1420a.getActionBar();
            if (actionBar != null) {
                return actionBar.getThemedContext();
            }
            return this.f1420a;
        }

        public boolean isNavigationVisible() {
            ActionBar actionBar = this.f1420a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        public void setActionBarUpIndicator(Drawable drawable, int i) {
            ActionBar actionBar = this.f1420a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i);
            }
        }

        public void setActionBarDescription(int i) {
            ActionBar actionBar = this.f1420a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i);
            }
        }
    }

    /* renamed from: android.support.v7.app.ActionBarDrawerToggle$f */
    static class C0473f implements Delegate {

        /* renamed from: a */
        final Toolbar f1421a;

        /* renamed from: b */
        final Drawable f1422b;

        /* renamed from: c */
        final CharSequence f1423c;

        C0473f(Toolbar toolbar) {
            this.f1421a = toolbar;
            this.f1422b = toolbar.getNavigationIcon();
            this.f1423c = toolbar.getNavigationContentDescription();
        }

        public void setActionBarUpIndicator(Drawable drawable, @StringRes int i) {
            this.f1421a.setNavigationIcon(drawable);
            setActionBarDescription(i);
        }

        public void setActionBarDescription(@StringRes int i) {
            if (i == 0) {
                this.f1421a.setNavigationContentDescription(this.f1423c);
            } else {
                this.f1421a.setNavigationContentDescription(i);
            }
        }

        public Drawable getThemeUpIndicator() {
            return this.f1422b;
        }

        public Context getActionBarThemedContext() {
            return this.f1421a.getContext();
        }

        public boolean isNavigationVisible() {
            return true;
        }
    }

    /* renamed from: android.support.v7.app.ActionBarDrawerToggle$c */
    static class C0470c implements Delegate {

        /* renamed from: a */
        final Activity f1417a;

        C0470c(Activity activity) {
            this.f1417a = activity;
        }

        public void setActionBarUpIndicator(Drawable drawable, @StringRes int i) {
        }

        public void setActionBarDescription(@StringRes int i) {
        }

        public Drawable getThemeUpIndicator() {
            return null;
        }

        public Context getActionBarThemedContext() {
            return this.f1417a;
        }

        public boolean isNavigationVisible() {
            return true;
        }
    }
}
