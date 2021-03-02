package android.support.p021v7.p022a;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.p009v4.app.ActivityCompat;
import android.support.p009v4.app.FragmentActivity;
import android.support.p009v4.app.NavUtils;
import android.support.p009v4.app.TaskStackBuilder;
import android.support.p009v4.view.C0352v;
import android.support.p021v7.view.C0521b;
import android.support.p021v7.view.C0522c;
import android.support.p021v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v7.a.ag */
public class C0433ag extends FragmentActivity implements TaskStackBuilder.SupportParentable, C0434ah, C0486h {

    /* renamed from: a */
    private C0435ai f584a;

    /* renamed from: b */
    private int f585b = 0;

    /* renamed from: c */
    private boolean f586c;

    /* renamed from: a */
    public C0485g mo1948a() {
        return mo1961e().mo1991g();
    }

    /* renamed from: a */
    public C0521b mo1949a(C0522c cVar) {
        return null;
    }

    /* renamed from: a */
    public void mo1950a(TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.addParentStack((Activity) this);
    }

    /* renamed from: a */
    public void mo1951a(C0521b bVar) {
    }

    /* renamed from: a */
    public void mo1952a(Toolbar toolbar) {
        mo1961e().mo1978a(toolbar);
    }

    /* renamed from: a */
    public boolean mo1953a(Intent intent) {
        return NavUtils.shouldUpRecreateTask(this, intent);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        mo1961e().mo1984b(view, layoutParams);
    }

    /* renamed from: b */
    public C0426a mo1955b() {
        return mo1961e().mo1974a();
    }

    /* renamed from: b */
    public void mo1956b(TaskStackBuilder taskStackBuilder) {
    }

    /* renamed from: b */
    public void mo1957b(C0521b bVar) {
    }

    /* renamed from: c */
    public boolean mo1958c() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (mo1953a(supportParentActivityIntent)) {
            TaskStackBuilder create = TaskStackBuilder.create(this);
            mo1950a(create);
            mo1956b(create);
            create.startActivities();
            try {
                ActivityCompat.finishAffinity(this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
        }
        return true;
    }

    @Deprecated
    /* renamed from: d */
    public void mo1959d() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (C0352v.m1342c(keyEvent) && keyEvent.getUnicodeChar(keyEvent.getMetaState() & -28673) == 60) {
            int action = keyEvent.getAction();
            if (action == 0) {
                C0426a b = mo1955b();
                if (b != null && b.mo1917b() && b.mo1927g()) {
                    this.f586c = true;
                    return true;
                }
            } else if (action == 1 && this.f586c) {
                this.f586c = false;
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* renamed from: e */
    public C0435ai mo1961e() {
        if (this.f584a == null) {
            this.f584a = C0435ai.m1810a((Activity) this, (C0434ah) this);
        }
        return this.f584a;
    }

    public View findViewById(int i) {
        return mo1961e().mo1975a(i);
    }

    public MenuInflater getMenuInflater() {
        return mo1961e().mo1981b();
    }

    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    public void invalidateOptionsMenu() {
        mo1961e().mo1989e();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        mo1961e().mo1976a(configuration);
    }

    public void onContentChanged() {
        mo1959d();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        C0435ai e = mo1961e();
        e.mo1992h();
        e.mo1977a(bundle);
        if (e.mo1993i() && this.f585b != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.f585b, false);
            } else {
                setTheme(this.f585b);
            }
        }
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        mo1961e().mo1990f();
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        C0426a b = mo1955b();
        if (menuItem.getItemId() != 16908332 || b == null || (b.mo1907a() & 4) == 0) {
            return false;
        }
        return mo1958c();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        mo1961e().mo1983b(bundle);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        mo1961e().mo1988d();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        mo1961e().mo1986c(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        mo1961e().mo1985c();
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        mo1961e().mo1980a(charSequence);
    }

    public void setContentView(int i) {
        mo1961e().mo1982b(i);
    }

    public void setContentView(View view) {
        mo1961e().setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        mo1961e().mo1979a(view, layoutParams);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.f585b = i;
    }

    public void supportInvalidateOptionsMenu() {
        mo1961e().mo1989e();
    }

    public void supportNavigateUpTo(Intent intent) {
        NavUtils.navigateUpTo(this, intent);
    }
}
