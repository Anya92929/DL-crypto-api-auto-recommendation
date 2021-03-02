package com.jackhenry.godough.core.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.AbstractNoUserMenuActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.C1943y;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.MFA;
import com.jackhenry.godough.core.model.MFAResponse;
import com.jackhenry.godough.core.widgets.ActionButton;
import com.jackhenry.godough.core.widgets.JhaEditText;

public class MFAActivity extends AbstractNoUserMenuActivity {
    public static final int DIALOG_MFA_BLOCKED = 5006;
    public static final int DIALOG_MFA_RETRY = 5005;
    public static final String EXTRA_MFA = "EXTRA_MFA";
    public static final String EXTRA_MFA_DESTINATION = "EXTRA_MFA_DESTINATION";
    public static final int MFA_LOGIN = 0;
    public static final int MFA_OK = 3;
    public static final int MFA_P2P = 2;

    /* renamed from: m */
    C1717dh f6295m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f6296n = 0;

    /* renamed from: o */
    private MFA f6297o;

    /* renamed from: p */
    private TextView f6298p;

    /* renamed from: q */
    private TextView f6299q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public JhaEditText f6300r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public JhaEditText f6301s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public ActionButton f6302t;

    /* renamed from: u */
    private ActionButton f6303u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public AbstractActivity f6304v;

    /* renamed from: w */
    private C1716dg f6305w;

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m6329g() {
        if (getResources().getConfiguration().hardKeyboardHidden == 2 && getResources().getConfiguration().keyboardHidden == 1 && getResources().getConfiguration().orientation == 2) {
            this.f6300r.setHint(this.f6300r.hasFocus() ? this.f6297o.getQuestionOne().getQuestion() : "");
            this.f6301s.setHint(this.f6301s.hasFocus() ? this.f6297o.getQuestionTwo().getQuestion() : "");
            return;
        }
        this.f6300r.setHint("");
        this.f6301s.setHint("");
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m6330h() {
        if (this.f6300r.getText().toString().trim().length() <= 0 || this.f6301s.getText().toString().trim().length() <= 0) {
            this.f6302t.setEnabled(false);
        } else {
            this.f6302t.setEnabled(true);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentById(C1494ai.dummy);
    }

    public void onBackPressed() {
        if (this.f6296n != 0) {
            super.onBackPressed();
        }
    }

    public void onCancelClicked(View view) {
        if (this.f6296n == 0) {
            new C1654az((C1943y) null).execute(new Void[0]);
            Intent intent = new Intent(GoDoughApp.getApp(), SplashActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            return;
        }
        resetMFA();
    }

    public void onContinueClicked(View view) {
        mo9483a(getString(C1506am.dg_processing));
        C1670bo boVar = new C1670bo(this, getSupportFragmentManager().findFragmentById(C1494ai.dummy), new C1659bd(this));
        this.f6297o.getQuestionOne().setAnswer(this.f6300r.getText().toString());
        this.f6297o.getQuestionTwo().setAnswer(this.f6301s.getText().toString());
        this.f6295m = new C1717dh(this.f6297o, boVar);
        this.f6295m.execute(new Void[0]);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1496ak.mfa_activity);
        this.f6304v = this;
        this.f6297o = (MFA) getIntent().getSerializableExtra("EXTRA_MFA");
        this.f6296n = getIntent().getIntExtra(EXTRA_MFA_DESTINATION, 0);
        this.f6298p = (TextView) findViewById(C1494ai.first_question);
        this.f6299q = (TextView) findViewById(C1494ai.second_question);
        this.f6300r = (JhaEditText) findViewById(C1494ai.first_question_edit);
        this.f6301s = (JhaEditText) findViewById(C1494ai.second_question_edit);
        this.f6302t = (ActionButton) findViewById(C1494ai.btn_continue);
        this.f6302t.setOnClickListener(new C1658bc(this));
        this.f6303u = (ActionButton) findViewById(C1494ai.btn_cancel);
        this.f6303u.setOnClickListener(new C1661bf(this));
        m6329g();
        this.f6298p.setText(this.f6297o.getQuestionOne().getQuestion());
        this.f6299q.setText(this.f6297o.getQuestionTwo().getQuestion());
        this.f6295m = (C1717dh) getLastCustomNonConfigurationInstance();
        if (this.f6295m != null) {
            if (this.f6295m.mo10926c()) {
                C1670bo boVar = new C1670bo(this, getSupportFragmentManager().findFragmentById(C1494ai.dummy), (C1593j) null);
                if (this.f6295m.mo10929e()) {
                    boVar.mo9589a(this.f6295m.mo10927d());
                } else {
                    boVar.mo9588a((MFAResponse) this.f6295m.mo10925b());
                }
            } else {
                mo9483a(getString(C1506am.dg_processing));
                this.f6295m.mo10923a(new C1670bo(this, getSupportFragmentManager().findFragmentById(C1494ai.dummy), new C1662bg(this)));
            }
        }
        C1663bh bhVar = new C1663bh(this);
        this.f6300r.addTextChangedListener(bhVar);
        this.f6301s.addTextChangedListener(bhVar);
        this.f6301s.setOnEditorActionListener(new C1664bi(this));
        this.f6300r.setOnFocusChangeListener(new C1665bj(this));
        this.f6300r.setOnBackKeyPressedListener(new C1666bk(this));
        this.f6301s.setOnFocusChangeListener(new C1667bl(this));
        this.f6301s.setOnBackKeyPressedListener(new C1668bm(this));
        if (this.f6296n != 0) {
            setActionBarNavigationOn(false);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        dismissLoadingDialog();
        super.onDestroy();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return (super.onRetainCustomNonConfigurationInstance() != null || this.f6295m == null || this.f6295m.mo10926c()) ? super.onRetainCustomNonConfigurationInstance() : this.f6295m;
    }

    public void resetMFA() {
        mo9483a("");
        this.f6305w = new C1716dg(true, new C1669bn(this, getSupportFragmentManager().findFragmentById(C1494ai.dummy), new C1660be(this)));
        this.f6305w.execute(new Void[0]);
    }
}
