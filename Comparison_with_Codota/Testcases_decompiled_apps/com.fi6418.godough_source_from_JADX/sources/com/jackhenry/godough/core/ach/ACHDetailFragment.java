package com.jackhenry.godough.core.ach;

import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.p000v4.app.DialogFragment;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentManager;
import android.support.p000v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.jackhenry.android.widget.calendar.DateComparator;
import com.jackhenry.android.widget.calendar.OnDateChosen;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.model.ACH;
import com.jackhenry.godough.core.model.ACHRequest;
import com.jackhenry.godough.core.model.OffsetAccount;
import com.jackhenry.godough.core.p034b.p035a.C1510a;
import com.jackhenry.godough.core.p034b.p035a.C1512c;
import com.jackhenry.godough.core.p034b.p035a.C1514e;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.p038e.C1580i;
import com.jackhenry.godough.core.p038e.C1586o;
import com.jackhenry.godough.core.widgets.ActionButton;
import java.util.Calendar;
import java.util.Collections;

public class ACHDetailFragment extends C1802r {
    public static final String EXTRA_ACH = "EXTRA_ACH";
    public static final String PRE_INIT_DIALOG_TAG = "PRE_INIT_DIALOG_TAG";

    /* renamed from: a */
    private boolean f5935a = true;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public C1488s f5936aj;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CheckedTextView f5937b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f5938c;

    /* renamed from: d */
    private TextView f5939d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f5940e;

    /* renamed from: f */
    private ActionButton f5941f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ArrayAdapter<OffsetAccount> f5942g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ACH f5943h;

    /* renamed from: i */
    private boolean f5944i;

    /* renamed from: d */
    private void m5923d(String str) {
        if (!this.f5944i) {
            this.f5944i = true;
            m5938q();
            if (getActivity() != null) {
                getActivity().getSupportFragmentManager().beginTransaction().add((Fragment) C1514e.m5999a(new C1576e(C1577f.ERROR, 0, getString(C1506am.title_ach_preinit_failed), str), true), PRE_INIT_DIALOG_TAG).commitAllowingStateLoss();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m5933n() {
        mo10988l();
        C1483n nVar = new C1483n(this, this, new C1475f(this));
        if (getActivity().getSupportLoaderManager().getLoader(0) == null) {
            getActivity().getSupportLoaderManager().initLoader(0, (Bundle) null, nVar);
        } else {
            getActivity().getSupportLoaderManager().restartLoader(0, (Bundle) null, nVar);
        }
    }

    /* renamed from: o */
    private void m5935o() {
        m5937p();
        m5940s();
        m5939r();
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m5937p() {
        if (this.f5943h.getOffsetAccounts() != null) {
            this.f5942g = new ArrayAdapter<>(getActivity(), C1496ak.selection_dialog_list_item, 0, this.f5943h.getOffsetAccounts());
            this.f5942g.setDropDownViewResource(C1496ak.selection_dialog_list_item);
        }
        if (this.f5943h.isOffsetAllowed()) {
            this.f5938c.setVisibility(0);
            this.f5938c.setOnClickListener(new C1477h(this));
            this.f5939d = (TextView) this.f5938c.findViewById(C1494ai.offset_value);
        } else {
            this.f5938c.setVisibility(8);
        }
        mo10989m();
        if (!this.f5943h.isPreInitSuccess()) {
            m5923d(this.f5943h.getPreInitMessage());
        }
    }

    /* renamed from: q */
    private void m5938q() {
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        DialogFragment dialogFragment = (DialogFragment) supportFragmentManager.findFragmentByTag(PRE_INIT_DIALOG_TAG);
        if (dialogFragment != null) {
            supportFragmentManager.beginTransaction().remove(dialogFragment).commitAllowingStateLoss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m5939r() {
        if (this.f5938c.getTag() != null) {
            this.f5939d.setText(((OffsetAccount) this.f5938c.getTag()).getPseudoName());
            this.f5939d.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        m5941t();
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m5940s() {
        if (this.f5940e.getTag() != null) {
            TextView textView = (TextView) this.f5940e.findViewById(C1494ai.date_value);
            textView.setText(C1580i.m6154a((Calendar) this.f5940e.getTag()));
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        m5941t();
    }

    /* access modifiers changed from: private */
    /* renamed from: t */
    public void m5941t() {
        boolean z = true;
        if (this.f5940e.getTag() == null || !this.f5943h.isPreInitSuccess() || (this.f5943h.isOffsetAllowed() && this.f5938c.getTag() == null)) {
            z = false;
        }
        this.f5941f.setEnabled(z);
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public synchronized void m5942u() {
        if (getFragmentManager().findFragmentByTag("SELECT_DIALOG") == null) {
            int i = -1;
            if (this.f5938c.getTag() != null) {
                i = this.f5942g.getPosition((OffsetAccount) this.f5938c.getTag());
            }
            C1512c cVar = new C1512c();
            cVar.mo9713b(getString(C1506am.select_account));
            cVar.mo9712a(this.f5942g, i, new C1478i(this));
            cVar.show(getFragmentManager(), "SELECT_DIALOG");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public synchronized void m5943v() {
        if (getFragmentManager().findFragmentByTag("SELECT_DIALOG") == null) {
            C1510a aVar = new C1510a();
            aVar.mo9709b(getString(C1506am.lbl_effective_date));
            if (this.f5940e.getTag() != null) {
                aVar.mo9707a((Calendar) this.f5940e.getTag());
            }
            Collections.sort(this.f5943h.getEffectiveDates(), new DateComparator());
            if (this.f5943h.getEffectiveDates() == null || this.f5943h.getEffectiveDates().get(0) == null) {
                aVar.mo9710b(Calendar.getInstance());
            } else {
                aVar.mo9710b(this.f5943h.getEffectiveDates().get(0));
            }
            aVar.mo9708a(this.f5943h.getEffectiveDates());
            aVar.mo9706a((OnDateChosen) new C1479j(this, aVar));
            aVar.show(getFragmentManager(), "SELECT_DIALOG");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5943h = (ACH) getActivity().getIntent().getSerializableExtra("EXTRA_ACH");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Object obj = null;
        View inflate = layoutInflater.inflate(C1496ak.ach_detail_fragment, viewGroup);
        TextView textView = (TextView) inflate.findViewById(C1494ai.header);
        textView.setText(this.f5943h.getName());
        C1586o.m6198a((LayerDrawable) textView.getBackground());
        ((TextView) inflate.findViewById(C1494ai.company_name)).setText(this.f5943h.getCompanyName());
        ((TextView) inflate.findViewById(C1494ai.code)).setText(this.f5943h.getCode());
        ((TextView) inflate.findViewById(C1494ai.debit_amount)).setText(this.f5943h.getTotalDebitsFormatted());
        ((TextView) inflate.findViewById(C1494ai.credit_amount)).setText(this.f5943h.getTotalCreditsFormatted());
        ((ActionButton) inflate.findViewById(C1494ai.btn_cancel)).setOnClickListener(new C1471b(this));
        this.f5941f = (ActionButton) inflate.findViewById(C1494ai.btn_action);
        this.f5941f.setOnClickListener(new C1472c(this));
        boolean isChecked = this.f5937b != null ? this.f5937b.isChecked() : false;
        this.f5937b = (CheckedTextView) inflate.findViewById(C1494ai.amount_label);
        this.f5937b.setChecked(isChecked);
        this.f5937b.setOnClickListener(new C1473d(this));
        Object tag = this.f5938c != null ? this.f5938c.getTag() : null;
        this.f5938c = inflate.findViewById(C1494ai.offset_section);
        this.f5938c.setTag(tag);
        if (this.f5940e != null) {
            obj = this.f5940e.getTag();
        }
        this.f5940e = inflate.findViewById(C1494ai.date_section);
        this.f5940e.setTag(obj);
        this.f5940e.setOnClickListener(new C1474e(this));
        if (this.f5935a) {
            this.f5935a = false;
            m5933n();
        } else {
            m5935o();
        }
        return inflate;
    }

    public void onStart() {
        super.onStart();
        if (this.f5936aj == null) {
            return;
        }
        if (this.f5936aj == null || !this.f5936aj.mo10926c()) {
            mo10986b(getString(C1506am.dg_processing));
        } else if (this.f5936aj.mo10929e()) {
            this.f5936aj.mo10922a().mo9589a(this.f5936aj.mo10927d());
        } else {
            this.f5936aj.mo10922a().mo9588a(this.f5936aj.mo10925b());
        }
    }

    public void submitData(Object obj) {
        mo10986b(getString(C1506am.dg_processing));
        ACHRequest aCHRequest = (ACHRequest) obj;
        this.f5936aj = new C1488s(aCHRequest, new C1481l(this, this, new C1480k(this, aCHRequest)));
        this.f5936aj.execute(new Void[0]);
    }
}
