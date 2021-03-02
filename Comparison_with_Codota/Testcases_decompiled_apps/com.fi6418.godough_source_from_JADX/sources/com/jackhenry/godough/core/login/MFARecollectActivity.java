package com.jackhenry.godough.core.login;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Menu;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1593j;
import com.jackhenry.godough.core.model.MFA;
import com.jackhenry.godough.core.model.MFAQuestion;
import com.jackhenry.godough.core.model.MFARecollect;
import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1578g;
import java.util.ArrayList;
import java.util.List;

public class MFARecollectActivity extends AbstractActivity implements C1688cf {
    public static final String EXTRA_MFA = "EXTRA_MFA";
    public static final int MFA_LOGIN = 0;

    /* renamed from: m */
    private int f6322m = 1;

    /* renamed from: n */
    private MFA f6323n;

    /* renamed from: o */
    private C1700cr f6324o;

    /* renamed from: p */
    private MFARecollectQuestionsFragment f6325p;

    /* renamed from: q */
    private MFARecollectPhoneNumbersFragment f6326q;

    /* renamed from: r */
    private String f6327r;

    /* renamed from: s */
    private MFARecollect f6328s;

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo9484c() {
    }

    public void cancel(Object obj) {
        this.f6328s = (MFARecollect) obj;
        if (this.f6327r.equals(MFARecollectPhoneNumbersFragment.TAG)) {
            resetMFACollectionFragement();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Fragment mo9485d() {
        return getSupportFragmentManager().findFragmentByTag(this.f6327r);
    }

    public MFA getMfa() {
        return this.f6323n;
    }

    public MFARecollect getMfaRecollect() {
        if (this.f6328s == null) {
            this.f6328s = new MFARecollect();
        }
        return this.f6328s;
    }

    public List<MFAQuestion> getQuestions(int i) {
        List<MFAQuestion> collectQuestions = this.f6323n.getCollectQuestions();
        if (collectQuestions == null || collectQuestions.size() < 3) {
            return new ArrayList();
        }
        int size = collectQuestions.size() / 3;
        int i2 = (i + 1) * size;
        if (i == 2) {
            i2 = collectQuestions.size();
        }
        return collectQuestions.subList(size * i, i2);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1496ak.mfa_recollect_activity);
        if (bundle == null) {
            this.f6325p = new MFARecollectQuestionsFragment();
            getSupportFragmentManager().beginTransaction().add(C1494ai.layout, this.f6325p, MFARecollectQuestionsFragment.TAG).commit();
            this.f6327r = MFARecollectQuestionsFragment.TAG;
            this.f6323n = (MFA) getIntent().getSerializableExtra("EXTRA_MFA");
        } else {
            this.f6323n = (MFA) bundle.getSerializable("EXTRA_MFA");
            this.f6328s = (MFARecollect) bundle.getSerializable("EXTRA_MFA_RECOLLECT");
            this.f6327r = bundle.getString("EXTRA_CURRENT_FRAGMENT_TAG");
        }
        this.f6324o = (C1700cr) getLastCustomNonConfigurationInstance();
        if (this.f6324o != null) {
            if (this.f6324o.mo10926c()) {
                C1681bz bzVar = new C1681bz(this, mo9485d(), (C1593j) null);
                if (this.f6324o.mo10929e()) {
                    bzVar.mo9589a(this.f6324o.mo10927d());
                } else {
                    bzVar.mo9588a(this.f6324o.mo10925b());
                }
            } else {
                mo9483a(getString(C1506am.dg_processing));
                this.f6324o.mo10923a(new C1681bz(this, mo9485d(), new C1678bw(this)));
            }
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        dismissLoadingDialog();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f6327r.equals(MFARecollectQuestionsFragment.TAG)) {
            showBackButtonWarningDialog();
            return true;
        } else if (i != 4 || !this.f6327r.equals(MFARecollectPhoneNumbersFragment.TAG)) {
            return super.onKeyDown(i, keyEvent);
        } else {
            resetMFACollectionFragement();
            return true;
        }
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return (super.onRetainCustomNonConfigurationInstance() != null || this.f6324o == null || this.f6324o.mo10926c()) ? super.onRetainCustomNonConfigurationInstance() : this.f6324o;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("EXTRA_MFA", this.f6323n);
        bundle.putSerializable("EXTRA_MFA_RECOLLECT", this.f6328s);
        bundle.putString("EXTRA_CURRENT_FRAGMENT_TAG", this.f6327r);
    }

    public void processMFA() {
        mo9483a(getString(C1506am.dg_processing));
        this.f6324o = new C1700cr(this.f6328s, new C1681bz(this, mo9485d(), new C1680by(this)));
        this.f6324o.execute(new Void[0]);
    }

    public void resetMFACollectionFragement() {
        this.f6327r = MFARecollectQuestionsFragment.TAG;
        if (this.f6325p == null) {
            this.f6325p = new MFARecollectQuestionsFragment();
        }
        getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentByTag(MFARecollectPhoneNumbersFragment.TAG)).add(C1494ai.layout, this.f6325p, MFARecollectQuestionsFragment.TAG).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }

    public void setMfa(MFA mfa) {
        this.f6323n = mfa;
    }

    public void setMfaRecollect(MFARecollect mFARecollect) {
        this.f6328s = mFARecollect;
    }

    public void showBackButtonWarningDialog() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1574c(-1, getString(C1506am.btn_ok)));
        arrayList.add(new C1574c(-2, getString(C1506am.btn_cancel)));
        C1576e eVar = new C1576e(C1577f.ERROR, this.f6322m, getString(C1506am.mfa_recollect_questions_title), getString(C1506am.mfa_back_button_text), (List<C1574c>) arrayList);
        eVar.mo9791a((C1578g) new C1679bx(this));
        showDialog(eVar);
    }

    public void submitData(Object obj) {
        this.f6328s = (MFARecollect) obj;
        if (!this.f6323n.isCollectPhone() || !this.f6327r.equals(MFARecollectQuestionsFragment.TAG)) {
            processMFA();
            return;
        }
        this.f6328s.setRiskTransactionId(this.f6323n.getRiskTransactionId());
        this.f6326q = new MFARecollectPhoneNumbersFragment();
        this.f6327r = MFARecollectPhoneNumbersFragment.TAG;
        getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentByTag(MFARecollectQuestionsFragment.TAG)).add(C1494ai.layout, this.f6326q, MFARecollectPhoneNumbersFragment.TAG).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }
}
