package com.jackhenry.godough.core.login;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.Menu;
import com.jackhenry.godough.core.AbstractNoUserMenuActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.model.EmailAddressData;
import com.jackhenry.godough.core.p038e.C1586o;

public class EmailAddressFragmentActivity extends AbstractNoUserMenuActivity {
    /* access modifiers changed from: private */

    /* renamed from: m */
    public EmailAddressFragment f6272m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public EmailAddressData f6273n;

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return this.f6272m;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo9874g() {
        mo9489f();
        C1738m mVar = new C1738m(this, this.f6272m, new C1736k(this));
        if (getSupportLoaderManager().getLoader(0) == null) {
            getSupportLoaderManager().initLoader(0, (Bundle) null, mVar);
        } else {
            getSupportLoaderManager().restartLoader(0, (Bundle) null, mVar);
        }
    }

    public EmailAddressData getEmailAddressData() {
        return this.f6273n;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1496ak.base_login_activity);
        C1586o.m6205b(findViewById(C1494ai.layout));
        if (bundle == null) {
            this.f6272m = new EmailAddressFragment();
            getSupportFragmentManager().beginTransaction().add(C1494ai.layout, this.f6272m, EmailAddressFragment.TAG).commit();
            mo9874g();
        } else {
            this.f6273n = (EmailAddressData) bundle.getSerializable("EAD");
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("EAD", this.f6273n);
    }

    public void setEmailAddressData(EmailAddressData emailAddressData) {
        this.f6273n = emailAddressData;
    }
}
