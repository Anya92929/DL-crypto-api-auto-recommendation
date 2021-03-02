package com.jackhenry.godough.core.p2p;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.p000v4.app.DialogFragment;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentManager;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.jackhenry.godough.core.C1410ab;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.C1916u;
import com.jackhenry.godough.core.model.P2PPayee;
import com.jackhenry.godough.core.p034b.p035a.C1512c;
import com.jackhenry.godough.core.p034b.p035a.C1514e;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.widgets.ActionButton;
import com.jackhenry.godough.core.widgets.JhaEditText;
import java.util.ArrayList;

public class P2PAddPersonFragment extends C1802r implements View.OnClickListener {
    public static final int DIALOG_P2P_ADD_PAYEE_FAILED = 5036;
    public static final int DIALOG_P2P_ADD_PAYEE_SUCCESS = 5035;

    /* renamed from: a */
    private JhaEditText f6514a;

    /* renamed from: aj */
    private boolean f6515aj = false;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public C1771ak f6516ak;
    /* access modifiers changed from: private */

    /* renamed from: al */
    public P2PPayee f6517al;

    /* renamed from: am */
    private C1916u f6518am;

    /* renamed from: an */
    private TextWatcher f6519an = new C1775d(this);

    /* renamed from: b */
    private JhaEditText f6520b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public JhaEditText f6521c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public JhaEditText f6522d;

    /* renamed from: e */
    private JhaEditText f6523e;

    /* renamed from: f */
    private ImageView f6524f;

    /* renamed from: g */
    private ActionButton f6525g;

    /* renamed from: h */
    private ActionButton f6526h;

    /* renamed from: i */
    private ImageView f6527i;

    /* renamed from: a */
    private void m6539a(JhaEditText jhaEditText) {
        jhaEditText.addTextChangedListener(this.f6519an);
        jhaEditText.setOnFocusChangeListener(new C1776e(this));
        jhaEditText.setOnBackKeyPressedListener(new C1777f(this, jhaEditText));
        jhaEditText.setOnEditorActionListener(new C1778g(this, jhaEditText));
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m6546o() {
        if (getResources().getConfiguration().hardKeyboardHidden == 2 && getResources().getConfiguration().keyboardHidden == 1 && getResources().getConfiguration().orientation == 2) {
            this.f6514a.setHint(this.f6514a.hasFocus() ? getString(C1506am.lbl_name) : "");
            this.f6520b.setHint(this.f6520b.hasFocus() ? getString(C1506am.lbl_nickname) : "");
            this.f6521c.setHint(this.f6521c.hasFocus() ? getString(C1506am.lbl_email) : "");
            this.f6522d.setHint(this.f6522d.hasFocus() ? getString(C1506am.lbl_email_confirm) : "");
            this.f6523e.setHint(this.f6523e.hasFocus() ? getString(C1506am.lbl_keyword) : "");
            return;
        }
        this.f6514a.setHint("");
        this.f6520b.setHint("");
        this.f6521c.setHint("");
        this.f6522d.setHint("");
        this.f6523e.setHint("");
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m6547p() {
        if (this.f6514a.getText().toString().trim().length() <= 0 || this.f6521c.getText().toString().trim().length() <= 0 || this.f6522d.getText().toString().trim().length() <= 0 || this.f6523e.getText().toString().trim().length() <= 0 || !this.f6521c.getText().toString().equals(this.f6522d.getText().toString())) {
            this.f6526h.setEnabled(false);
        } else {
            this.f6526h.setEnabled(true);
        }
    }

    /* renamed from: q */
    private void m6548q() {
        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI), 9999);
    }

    /* renamed from: r */
    private void m6549r() {
        mo10933n();
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager().beginTransaction().add((Fragment) C1514e.m5999a(new C1576e(C1577f.INFO, 0, getString(C1506am.lbl_keyword), getString(C1506am.info_keyword)), true), "INFO_DIALOG").commitAllowingStateLoss();
        }
    }

    public P2PPayee getP2PPayee() {
        return this.f6517al;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public void mo10933n() {
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        DialogFragment dialogFragment = (DialogFragment) supportFragmentManager.findFragmentByTag("INFO_DIALOG");
        if (dialogFragment != null) {
            supportFragmentManager.beginTransaction().remove(dialogFragment).commitAllowingStateLoss();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 9999:
                if (i2 == -1) {
                    resetData();
                    this.f6515aj = true;
                    Cursor query = getActivity().getContentResolver().query(intent.getData(), (String[]) null, (String) null, (String[]) null, (String) null);
                    if (query.moveToFirst()) {
                        this.f6514a.setText(query.getString(query.getColumnIndex("display_name")));
                        Cursor query2 = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, (String[]) null, "contact_id = " + query.getString(query.getColumnIndex("_id")), (String[]) null, (String) null);
                        ArrayList arrayList = new ArrayList();
                        while (query2.moveToNext()) {
                            arrayList.add(query2.getString(query2.getColumnIndex("data1")));
                        }
                        if (arrayList.size() > 1) {
                            ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), 17367043, arrayList);
                            C1512c cVar = new C1512c();
                            cVar.mo9713b(getString(C1506am.title_select_email_address));
                            cVar.mo9712a(arrayAdapter, -1, new C1779h(this, arrayList));
                            cVar.show(getFragmentManager(), "SELECT_DIALOG");
                        } else if (arrayList.size() > 0) {
                            this.f6521c.setText((CharSequence) arrayList.get(0));
                            this.f6522d.setText((CharSequence) arrayList.get(0));
                        }
                        query2.close();
                    }
                    query.close();
                    return;
                }
                this.f6515aj = true;
                return;
            default:
                return;
        }
    }

    public void onClick(View view) {
        if (view == this.f6525g.getButton()) {
            getActivity().setResult(0);
            getActivity().finish();
        } else if (view == this.f6526h.getButton()) {
            submitData();
        } else if (view == this.f6527i) {
            this.f6518am = new C1916u(new C1410ab(this));
            if (this.f6518am.mo11157a((String) null, "android.permission.READ_CONTACTS", (int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION)) {
                m6548q();
            }
        } else if (view == this.f6524f) {
            m6549r();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.p2p_add_person_fragment, viewGroup);
        this.f6514a = (JhaEditText) inflate.findViewById(C1494ai.name_edit);
        this.f6514a.addTextChangedListener(this.f6519an);
        this.f6520b = (JhaEditText) inflate.findViewById(C1494ai.nickname_edit);
        this.f6520b.addTextChangedListener(this.f6519an);
        this.f6521c = (JhaEditText) inflate.findViewById(C1494ai.email_edit);
        this.f6521c.addTextChangedListener(this.f6519an);
        this.f6522d = (JhaEditText) inflate.findViewById(C1494ai.email_confirm_edit);
        this.f6522d.addTextChangedListener(this.f6519an);
        this.f6523e = (JhaEditText) inflate.findViewById(C1494ai.keyword_edit);
        this.f6523e.addTextChangedListener(this.f6519an);
        this.f6524f = (ImageView) inflate.findViewById(C1494ai.btn_info);
        this.f6525g = (ActionButton) inflate.findViewById(C1494ai.btn_cancel);
        this.f6526h = (ActionButton) inflate.findViewById(C1494ai.btn_submit);
        this.f6527i = (ImageView) inflate.findViewById(C1494ai.contacts);
        m6539a(this.f6514a);
        m6539a(this.f6521c);
        m6539a(this.f6520b);
        m6539a(this.f6522d);
        m6539a(this.f6523e);
        this.f6524f.setOnClickListener(this);
        this.f6525g.setOnClickListener(this);
        this.f6526h.setOnClickListener(this);
        this.f6527i.setOnClickListener(this);
        m6547p();
        return inflate;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION:
                if (this.f6518am.mo11156a(iArr[0], getString(C1506am.contact_permission_needed), false)) {
                    m6548q();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onStart() {
        super.onStart();
        if (this.f6516ak == null) {
            return;
        }
        if (this.f6516ak == null || !this.f6516ak.mo10926c()) {
            mo10986b(getString(C1506am.ellipse_adding_payee));
        } else if (this.f6516ak.mo10929e()) {
            this.f6516ak.mo10922a().mo9589a(this.f6516ak.mo10927d());
        } else {
            this.f6516ak.mo10922a().mo9588a(this.f6516ak.mo10925b());
        }
    }

    public void resetData() {
        if (!this.f6515aj) {
            this.f6514a.setText("");
            this.f6520b.setText("");
            this.f6521c.setText("");
            this.f6522d.setText("");
            this.f6523e.setText("");
            m6547p();
            m6546o();
        }
        this.f6515aj = false;
    }

    public void submitData() {
        mo10986b(getString(C1506am.ellipse_adding_payee));
        C1781j jVar = new C1781j(this, this, new C1780i(this));
        this.f6517al = new P2PPayee((String) null, this.f6514a.getText().toString(), this.f6520b.getText().toString(), this.f6521c.getText().toString(), this.f6523e.getText().toString());
        this.f6516ak = new C1771ak(getP2PPayee(), jVar);
        this.f6516ak.execute(new Void[0]);
    }
}
