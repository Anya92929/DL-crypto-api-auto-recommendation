package android.support.p003v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p000v4.widget.DrawerLayout;
import android.support.p003v7.app.ActionBarDrawerToggleHoneycomb;
import android.support.p003v7.graphics.drawable.DrawerArrowDrawable;
import android.support.p003v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v7.app.ActionBarDrawerToggle */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* renamed from: a */
    private final Delegate f1722a;

    /* renamed from: b */
    private final DrawerLayout f1723b;

    /* renamed from: c */
    private DrawerToggle f1724c;

    /* renamed from: d */
    private Drawable f1725d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f1726e;

    /* renamed from: f */
    private boolean f1727f;

    /* renamed from: g */
    private final int f1728g;

    /* renamed from: h */
    private final int f1729h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View.OnClickListener f1730i;

    /* renamed from: j */
    private boolean f1731j;

    /* renamed from: android.support.v7.app.ActionBarDrawerToggle$Delegate */
    public interface Delegate {
        Context getActionBarThemedContext();

        Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(int i);

        void setActionBarUpIndicator(Drawable drawable, int i);
    }

    /* renamed from: android.support.v7.app.ActionBarDrawerToggle$DelegateProvider */
    public interface DelegateProvider {
        Delegate getDrawerToggleDelegate();
    }

    /* renamed from: android.support.v7.app.ActionBarDrawerToggle$DrawerArrowDrawableToggle */
    class DrawerArrowDrawableToggle extends DrawerArrowDrawable implements DrawerToggle {

        /* renamed from: a */
        private final Activity f1733a;

        public DrawerArrowDrawableToggle(Activity activity, Context context) {
            super(context);
            this.f1733a = activity;
        }

        public float getPosition() {
            return getProgress();
        }

        public void setPosition(float f) {
            if (f == 1.0f) {
                setVerticalMirror(true);
            } else if (f == BitmapDescriptorFactory.HUE_RED) {
                setVerticalMirror(false);
            }
            setProgress(f);
        }
    }

    /* renamed from: android.support.v7.app.ActionBarDrawerToggle$DrawerToggle */
    interface DrawerToggle {
        float getPosition();

        void setPosition(float f);
    }

    /* renamed from: android.support.v7.app.ActionBarDrawerToggle$DummyDelegate */
    class DummyDelegate implements Delegate {

        /* renamed from: a */
        final Activity f1734a;

        DummyDelegate(Activity activity) {
            this.f1734a = activity;
        }

        public Context getActionBarThemedContext() {
            return this.f1734a;
        }

        public Drawable getThemeUpIndicator() {
            return null;
        }

        public boolean isNavigationVisible() {
            return true;
        }

        public void setActionBarDescription(int i) {
        }

        public void setActionBarUpIndicator(Drawable drawable, int i) {
        }
    }

    /* renamed from: android.support.v7.app.ActionBarDrawerToggle$HoneycombDelegate */
    class HoneycombDelegate implements Delegate {

        /* renamed from: a */
        final Activity f1735a;

        /* renamed from: b */
        ActionBarDrawerToggleHoneycomb.SetIndicatorInfo f1736b;

        private HoneycombDelegate(Activity activity) {
            this.f1735a = activity;
        }

        public Context getActionBarThemedContext() {
            ActionBar actionBar = this.f1735a.getActionBar();
            return actionBar != null ? actionBar.getThemedContext() : this.f1735a;
        }

        public Drawable getThemeUpIndicator() {
            return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(this.f1735a);
        }

        public boolean isNavigationVisible() {
            ActionBar actionBar = this.f1735a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        public void setActionBarDescription(int i) {
            this.f1736b = ActionBarDrawerToggleHoneycomb.setActionBarDescription(this.f1736b, this.f1735a, i);
        }

        public void setActionBarUpIndicator(Drawable drawable, int i) {
            this.f1735a.getActionBar().setDisplayShowHomeEnabled(true);
            this.f1736b = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(this.f1736b, this.f1735a, drawable, i);
            this.f1735a.getActionBar().setDisplayShowHomeEnabled(false);
        }
    }

    /* renamed from: android.support.v7.app.ActionBarDrawerToggle$JellybeanMr2Delegate */
    class JellybeanMr2Delegate implements Delegate {

        /* renamed from: a */
        final Activity f1737a;

        private JellybeanMr2Delegate(Activity activity) {
            this.f1737a = activity;
        }

        public Context getActionBarThemedContext() {
            ActionBar actionBar = this.f1737a.getActionBar();
            return actionBar != null ? actionBar.getThemedContext() : this.f1737a;
        }

        public Drawable getThemeUpIndicator() {
            TypedArray obtainStyledAttributes = getActionBarThemedContext().obtainStyledAttributes((AttributeSet) null, new int[]{16843531}, 16843470, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        public boolean isNavigationVisible() {
            ActionBar actionBar = this.f1737a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        public void setActionBarDescription(int i) {
            ActionBar actionBar = this.f1737a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i);
            }
        }

        public void setActionBarUpIndicator(Drawable drawable, int i) {
            ActionBar actionBar = this.f1737a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i);
            }
        }
    }

    /* renamed from: android.support.v7.app.ActionBarDrawerToggle$ToolbarCompatDelegate */
    class ToolbarCompatDelegate implements Delegate {

        /* renamed from: a */
        final Toolbar f1738a;

        /* renamed from: b */
        final Drawable f1739b;

        /* renamed from: c */
        final CharSequence f1740c;

        ToolbarCompatDelegate(Toolbar toolbar) {
            this.f1738a = toolbar;
            this.f1739b = toolbar.getNavigationIcon();
            this.f1740c = toolbar.getNavigationContentDescription();
        }

        public Context getActionBarThemedContext() {
            return this.f1738a.getContext();
        }

        public Drawable getThemeUpIndicator() {
            return this.f1739b;
        }

        public boolean isNavigationVisible() {
            return true;
        }

        public void setActionBarDescription(int i) {
            if (i == 0) {
                this.f1738a.setNavigationContentDescription(this.f1740c);
            } else {
                this.f1738a.setNavigationContentDescription(i);
            }
        }

        public void setActionBarUpIndicator(Drawable drawable, int i) {
            this.f1738a.setNavigationIcon(drawable);
            setActionBarDescription(i);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, int i, int i2) {
        this(activity, (Toolbar) null, drawerLayout, (Drawable) null, i, i2);
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int i, int i2) {
        this(activity, toolbar, drawerLayout, (Drawable) null, i, i2);
    }

    <T extends Drawable & DrawerToggle> ActionBarDrawerToggle(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, T t, int i, int i2) {
        this.f1726e = true;
        this.f1731j = false;
        if (toolbar != null) {
            this.f1722a = new ToolbarCompatDelegate(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (ActionBarDrawerToggle.this.f1726e) {
                        ActionBarDrawerToggle.this.m1219b();
                    } else if (ActionBarDrawerToggle.this.f1730i != null) {
                        ActionBarDrawerToggle.this.f1730i.onClick(view);
                    }
                }
            });
        } else if (activity instanceof DelegateProvider) {
            this.f1722a = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else if (Build.VERSION.SDK_INT >= 18) {
            this.f1722a = new JellybeanMr2Delegate(activity);
        } else if (Build.VERSION.SDK_INT >= 11) {
            this.f1722a = new HoneycombDelegate(activity);
        } else {
            this.f1722a = new DummyDelegate(activity);
        }
        this.f1723b = drawerLayout;
        this.f1728g = i;
        this.f1729h = i2;
        if (t == null) {
            this.f1724c = new DrawerArrowDrawableToggle(activity, this.f1722a.getActionBarThemedContext());
        } else {
            this.f1724c = (DrawerToggle) t;
        }
        this.f1725d = mo3600a();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1219b() {
        if (this.f1723b.isDrawerVisible(8388611)) {
            this.f1723b.closeDrawer(8388611);
        } else {
            this.f1723b.openDrawer(8388611);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Drawable mo3600a() {
        return this.f1722a.getThemeUpIndicator();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3601a(int i) {
        this.f1722a.setActionBarDescription(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3602a(Drawable drawable, int i) {
        if (!this.f1731j && !this.f1722a.isNavigationVisible()) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.f1731j = true;
        }
        this.f1722a.setActionBarUpIndicator(drawable, i);
    }

    public View.OnClickListener getToolbarNavigationClickListener() {
        return this.f1730i;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.f1726e;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.f1727f) {
            this.f1725d = mo3600a();
        }
        syncState();
    }

    public void onDrawerClosed(View view) {
        this.f1724c.setPosition(BitmapDescriptorFactory.HUE_RED);
        if (this.f1726e) {
            mo3601a(this.f1728g);
        }
    }

    public void onDrawerOpened(View view) {
        this.f1724c.setPosition(1.0f);
        if (this.f1726e) {
            mo3601a(this.f1729h);
        }
    }

    public void onDrawerSlide(View view, float f) {
        this.f1724c.setPosition(Math.min(1.0f, Math.max(BitmapDescriptorFactory.HUE_RED, f)));
    }

    public void onDrawerStateChanged(int i) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.f1726e) {
            return false;
        }
        m1219b();
        return true;
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        if (z != this.f1726e) {
            if (z) {
                mo3602a((Drawable) this.f1724c, this.f1723b.isDrawerOpen(8388611) ? this.f1729h : this.f1728g);
            } else {
                mo3602a(this.f1725d, 0);
            }
            this.f1726e = z;
        }
    }

    public void setHomeAsUpIndicator(int i) {
        Drawable drawable = null;
        if (i != 0) {
            drawable = this.f1723b.getResources().getDrawable(i);
        }
        setHomeAsUpIndicator(drawable);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.f1725d = mo3600a();
            this.f1727f = false;
        } else {
            this.f1725d = drawable;
            this.f1727f = true;
        }
        if (!this.f1726e) {
            mo3602a(this.f1725d, 0);
        }
    }

    public void setToolbarNavigationClickListener(View.OnClickListener onClickListener) {
        this.f1730i = onClickListener;
    }

    public void syncState() {
        if (this.f1723b.isDrawerOpen(8388611)) {
            this.f1724c.setPosition(1.0f);
        } else {
            this.f1724c.setPosition(BitmapDescriptorFactory.HUE_RED);
        }
        if (this.f1726e) {
            mo3602a((Drawable) this.f1724c, this.f1723b.isDrawerOpen(8388611) ? this.f1729h : this.f1728g);
        }
    }
}
