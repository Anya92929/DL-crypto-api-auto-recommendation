package com.jackhenry.godough.core.login;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Switch;
import android.widget.TextView;
import com.jackhenry.godough.core.AbstractNoUserMenuActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Credentials;
import com.jackhenry.godough.core.model.UserSettings;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1578g;
import com.jackhenry.godough.core.p038e.C1584m;
import com.jackhenry.godough.core.p038e.C1585n;
import com.jackhenry.godough.core.p038e.C1586o;
import com.jackhenry.godough.core.p038e.p039a.C1572e;
import com.jackhenry.godough.core.widgets.ActionButton;
import com.jackhenry.godough.core.widgets.JhaEditText;
import com.jackhenry.godough.p027b.C1389d;
import com.jackhenry.p021a.C1347a;
import java.io.UnsupportedEncodingException;

public class LoginActivity extends AbstractNoUserMenuActivity {
    public static final int DIALOG_LOGIN_FAILED = 5011;
    public static final String INTENT_DESTINATION = "destination";

    /* renamed from: m */
    TextWatcher f6287m = new C1638aj(this);
    /* access modifiers changed from: private */

    /* renamed from: n */
    public JhaEditText f6288n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public JhaEditText f6289o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public ActionButton f6290p;

    /* renamed from: q */
    private ActionButton f6291q;

    /* renamed from: r */
    private Context f6292r;

    /* renamed from: s */
    private C1655b f6293s;

    /* renamed from: t */
    private Switch f6294t;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6314b(String str) {
        dismissLoadingDialog();
        C1576e eVar = new C1576e(C1577f.ERROR, DIALOG_LOGIN_FAILED, getString(C1506am.dg_login_failed_title), str);
        eVar.mo9791a((C1578g) new C1640al(this));
        showDialog(eVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m6318g() {
        if (getResources().getConfiguration().hardKeyboardHidden == 2 && getResources().getConfiguration().keyboardHidden == 1 && getResources().getConfiguration().orientation == 2) {
            this.f6288n.setHint(this.f6288n.hasFocus() ? GoDoughApp.getSettings().getUserNameLabel() : "");
            this.f6289o.setHint(this.f6289o.hasFocus() ? GoDoughApp.getSettings().getPasswordLabel() : "");
            return;
        }
        this.f6288n.setHint("");
        this.f6289o.setHint("");
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m6319h() {
        if (this.f6289o.getText().toString().trim().length() <= 0 || this.f6288n.getText().toString().trim().length() <= 0) {
            this.f6290p.setEnabled(false);
        } else {
            this.f6290p.setEnabled(true);
        }
    }

    /* renamed from: i */
    private void m6320i() {
        mo9483a(getString(C1506am.dg_logging_in));
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.dummy);
    }

    public void onCancelClicked(View view) {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setShowArrowOnToolbar(true);
        GoDoughApp.setUserSettings((UserSettings) null);
        setContentView(C1496ak.login_activity);
        this.f6292r = this;
        GoDoughApp.setNotificationRedirect(getIntent().getIntExtra(INTENT_DESTINATION, 0));
        C1585n nVar = new C1585n(GoDoughApp.getApp());
        this.f6288n = (JhaEditText) findViewById(C1494ai.etxtUserId);
        this.f6288n.setInputType(524432);
        this.f6289o = (JhaEditText) findViewById(C1494ai.etxtPwd);
        this.f6290p = (ActionButton) findViewById(C1494ai.btn_login);
        this.f6290p.setEnabled(false);
        this.f6290p.setText((CharSequence) nVar.mo9816g());
        this.f6290p.setOnClickListener(new C1636ah(this));
        this.f6291q = (ActionButton) findViewById(C1494ai.btn_cancel);
        this.f6291q.setOnClickListener(new C1641am(this));
        this.f6294t = (Switch) findViewById(C1494ai.remember_me_checkbox);
        C1584m mVar = new C1584m(this);
        if (!mVar.mo9800a("REMEMBER_ME_ENABLED", false) || Build.VERSION.SDK_INT <= 17) {
            findViewById(C1494ai.remember_me_label).setVisibility(8);
            findViewById(C1494ai.remember_mem_btn_info).setVisibility(8);
            this.f6294t.setVisibility(8);
        } else {
            this.f6294t.setOnCheckedChangeListener(new C1642an(this, mVar));
            findViewById(C1494ai.remember_mem_btn_info).setOnClickListener(new C1643ao(this));
            if (mVar.mo9800a("REMEMBER_ME_CHECKED", false)) {
                try {
                    C1572e eVar = new C1572e();
                    this.f6294t.setChecked(true);
                    byte[] a = eVar.mo9786a("DATA2");
                    if (a != null) {
                        String str = new String(a, "UTF-8");
                        this.f6288n.setText(getString(C1506am.masked_id, new Object[]{str.substring(0, 3)}));
                        this.f6288n.setEnabled(false);
                    }
                } catch (C1389d e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }
        C1586o.m6205b(findViewById(C1494ai.layout));
        if (GoDoughApp.getSettings().getUserNameLabel() != null) {
            ((TextView) findViewById(C1494ai.txtUserId)).setText(GoDoughApp.getSettings().getUserNameLabel());
        }
        if (GoDoughApp.getSettings().getPasswordLabel() != null) {
            ((TextView) findViewById(C1494ai.txtPwd)).setText(GoDoughApp.getSettings().getPasswordLabel());
        }
        m6318g();
        this.f6288n.addTextChangedListener(this.f6287m);
        this.f6289o.addTextChangedListener(this.f6287m);
        if (bundle != null) {
            this.f6288n.setText(bundle.getString("ID"));
            this.f6289o.setText(bundle.getString("PWD"));
        }
        this.f6289o.setOnEditorActionListener(new C1644ap(this));
        Object lastCustomNonConfigurationInstance = getLastCustomNonConfigurationInstance();
        if (lastCustomNonConfigurationInstance instanceof C1655b) {
            this.f6293s = (C1655b) lastCustomNonConfigurationInstance;
            if (this.f6293s != null) {
                C1649au auVar = new C1649au(this, mo9485d(), new C1645aq(this));
                if (!this.f6293s.mo10926c()) {
                    this.f6293s.mo10923a(auVar);
                } else if (this.f6293s.mo10929e()) {
                    auVar.mo9589a(this.f6293s.mo10927d());
                } else {
                    auVar.mo9588a((String) this.f6293s.mo10925b());
                }
            }
        }
        this.f6288n.setOnFocusChangeListener(new C1646ar(this));
        this.f6288n.setOnBackKeyPressedListener(new C1647as(this));
        this.f6289o.setOnFocusChangeListener(new C1648at(this));
        this.f6289o.setOnBackKeyPressedListener(new C1637ai(this));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public void onLoginClicked(View view) {
        if (this.f6288n.getText().toString().trim().length() != 0 && this.f6289o.getText().toString().trim().length() != 0) {
            m6320i();
            GoDoughApp.setuID(this.f6288n.getText().toString().trim().hashCode());
            C1649au auVar = new C1649au(this, mo9485d(), new C1639ak(this));
            String trim = this.f6288n.getText().toString().trim();
            if (!this.f6288n.isEnabled() && Build.VERSION.SDK_INT > 17) {
                try {
                    trim = new String(new C1572e().mo9786a("DATA2"), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (C1389d e2) {
                    e2.printStackTrace();
                }
            }
            this.f6293s = new C1655b(new Credentials(trim.trim(), this.f6289o.getText().toString().trim(), C1347a.m5547a(getApplicationContext()), C1585n.m6169a(C1347a.m5550c(getApplicationContext()), C1347a.m5551d(getApplicationContext())), this.f6294t.isChecked()), auVar);
            this.f6293s.execute(new Void[0]);
        }
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return (super.onRetainCustomNonConfigurationInstance() != null || this.f6293s == null || this.f6293s.mo10926c()) ? super.onRetainCustomNonConfigurationInstance() : this.f6293s;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("ID", this.f6288n.getText().toString());
        bundle.putString("PWD", this.f6289o.getText().toString());
    }

    public void showKeyBoard() {
        ((InputMethodManager) this.f6292r.getSystemService("input_method")).toggleSoftInput(1, 0);
        this.f6288n.requestFocus();
        this.f6288n.setSelection(this.f6288n.getText().length());
    }
}
