package com.jackhenry.godough.core.login;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.content.ContextCompat;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.C0853e;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.AbstractNoUserMenuActivity;
import com.jackhenry.godough.core.C1491af;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.locations.AbstractLocationActivity;
import com.jackhenry.godough.core.locations.LocationsFragmentActivity;
import com.jackhenry.godough.core.model.GoDoughLocation;
import com.jackhenry.godough.core.model.Notification;
import com.jackhenry.godough.core.model.NotificationList;
import com.jackhenry.godough.core.model.Settings;
import com.jackhenry.godough.core.p037d.C1564a;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1578g;
import com.jackhenry.godough.core.p038e.C1585n;
import com.jackhenry.godough.core.p038e.C1586o;
import com.jackhenry.godough.core.session.C1885a;
import com.jackhenry.godough.core.widgets.ActionButton;
import com.jackhenry.godough.core.widgets.ProgressBarIceCream;
import com.jackhenry.godough.p024a.C1373a;
import com.jackhenry.p021a.C1347a;
import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AbstractNoUserMenuActivity implements C1578g {
    public static final String EXTRA_FINISH = "EXTRA_FINISH";
    public static final int REQ_CODE_ENV_SETTINGS = 2;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public transient LinearLayout f6354m;

    /* renamed from: n */
    private transient ProgressBarIceCream f6355n;

    /* renamed from: o */
    private transient ActionButton f6356o;

    /* renamed from: p */
    private transient ActionButton f6357p;

    /* renamed from: q */
    private transient ImageView f6358q;

    /* renamed from: r */
    private transient View f6359r;

    /* renamed from: s */
    private transient TextView f6360s;

    /* renamed from: t */
    private Activity f6361t;

    /* renamed from: a */
    private void m6377a(C1585n nVar) {
        if (C1347a.m5548a(getApplicationContext().getPackageName()) != null) {
            ImageButton imageButton = (ImageButton) findViewById(C1494ai.settings);
            imageButton.setVisibility(0);
            imageButton.setOnClickListener(new C1710da(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m6381g() {
        C1712dc dcVar = new C1712dc(this, getSupportFragmentManager().findFragmentById(C1494ai.dummy), new C1706cx(this));
        this.f6360s.setBackground(ContextCompat.getDrawable(this.f6361t, C1491af.splash_version_background));
        this.f6360s.getBackground().setAlpha(255);
        this.f6354m.setVisibility(4);
        getSupportLoaderManager().initLoader(0, (Bundle) null, dcVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m6382h() {
        showNotifications();
        m6383i();
        m6384j();
    }

    /* renamed from: i */
    private void m6383i() {
        this.f6357p.updateTheme();
        this.f6355n.setVisibility(8);
        C1585n nVar = new C1585n(GoDoughApp.getApp());
        this.f6356o.setText((CharSequence) nVar.mo9815f());
        this.f6357p.setText((CharSequence) nVar.mo9816g());
        if (GoDoughApp.getSettings() == null || !GoDoughApp.getSettings().isLocationsEnabled()) {
            this.f6356o.setVisibility(8);
        } else {
            this.f6356o.setVisibility(0);
        }
    }

    /* renamed from: j */
    private void m6384j() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, 17432576);
        loadAnimation.setDuration(1500);
        loadAnimation.setAnimationListener(new C1708cz(this));
        this.f6354m.startAnimation(loadAnimation);
        Drawable background = this.f6360s.getBackground();
        this.f6354m.setVisibility(0);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(background, "alpha", new int[]{255, 0});
        ofInt.setDuration(400);
        ofInt.start();
    }

    /* renamed from: k */
    private void m6385k() {
        Intent intent = new Intent(GoDoughApp.getApp(), SplashActivity.class);
        intent.addFlags(67108864);
        startActivity(intent);
        finish();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.dummy);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 5002) {
            if (!C1564a.m6120a()) {
                showNoNetworkDialog();
            } else {
                m6385k();
            }
        } else if (i == 2) {
            C1586o.m6210e();
            GoDoughApp.setLocations((List<GoDoughLocation>) null);
            GoDoughApp.setuID(-1);
            GoDoughApp.setSettings((Settings) null);
            m6385k();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6361t = this;
        if (getIntent().getExtras() == null || !getIntent().getExtras().getBoolean(EXTRA_FINISH, false)) {
            C1373a.m5616a((String) null);
            GoDoughApp.getCookieManager().getCookieStore().removeAll();
            C1885a.m6861b();
            C1585n nVar = new C1585n(GoDoughApp.getApp());
            View inflate = getLayoutInflater().inflate(C1496ak.splash_activity, (ViewGroup) null);
            this.f6354m = (LinearLayout) inflate.findViewById(C1494ai.button_bar);
            this.f6355n = (ProgressBarIceCream) inflate.findViewById(C1494ai.progress_bar);
            this.f6356o = (ActionButton) inflate.findViewById(C1494ai.btn_location);
            this.f6357p = (ActionButton) inflate.findViewById(C1494ai.btn_login);
            this.f6356o.setText((CharSequence) nVar.mo9815f());
            this.f6356o.setOnClickListener(new C1703cu(this));
            this.f6357p.setText((CharSequence) nVar.mo9816g());
            this.f6357p.setOnClickListener(new C1704cv(this));
            this.f6358q = (ImageView) inflate.findViewById(C1494ai.logo);
            this.f6359r = inflate.findViewById(C1494ai.layout);
            this.f6360s = (TextView) inflate.findViewById(C1494ai.version);
            try {
                this.f6360s.setText(getApplication().getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            } catch (PackageManager.NameNotFoundException e) {
            }
            if (C1586o.m6207c()) {
                this.f6358q.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                this.f6358q.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            C1586o.m6206c(this.f6359r);
            setContentView(inflate, false);
            getSupportActionBar().hide();
            m6377a(nVar);
            if (getSupportLoaderManager().getLoader(0) == null) {
                m6381g();
            } else {
                m6383i();
            }
        } else {
            finish();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    public void onDialogButtonClicked(int i, C1574c cVar) {
        switch (i) {
            case AbstractActivity.DIALOG_NO_API:
                switch (cVar.mo9788a()) {
                    case -2:
                        m6385k();
                        return;
                    case -1:
                        finish();
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }

    public void onLocationClicked(View view) {
        Intent intent = new Intent(GoDoughApp.getApp(), LocationsFragmentActivity.class);
        intent.putExtra(AbstractLocationActivity.PARAM_LOGGED_IN, false);
        startActivity(intent);
    }

    public void onLoginClicked(View view) {
        startActivity(new Intent(GoDoughApp.getApp(), LoginActivity.class));
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Dialog a = C0853e.m4238a(C0853e.m4237a((Context) this), this, 0, new C1705cw(this));
        if (a != null) {
            a.show();
        }
    }

    public void showNotifications() {
        NotificationList notifications;
        Notification notification;
        if (GoDoughApp.getSettings() != null && (notifications = GoDoughApp.getSettings().getNotifications()) != null && notifications.getNotifications() != null && !notifications.getNotifications().isEmpty() && (notification = notifications.getNotifications().get(0)) != null && notification.isValid()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new C1574c(-1, getString(C1506am.btn_ok)));
            if (!notification.isMandatoryUpdate()) {
                arrayList.add(new C1574c(-3, getString(C1506am.btn_remind_later)));
            }
            C1576e eVar = new C1576e(C1577f.NO_HEADER, 5035, getString(C1506am.app_redirect_title), notification.getMessage(), (List<C1574c>) arrayList);
            eVar.mo9791a((C1578g) new C1711db(this, notification, this));
            showNonCancelableDialog(eVar);
        }
    }
}
