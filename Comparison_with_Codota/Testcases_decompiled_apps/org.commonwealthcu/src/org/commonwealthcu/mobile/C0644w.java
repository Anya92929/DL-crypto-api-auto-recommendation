package org.commonwealthcu.mobile;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentTransaction;
import android.support.p003v7.appcompat.C0137R;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Locale;
import org.commonwealthcu.mobile.p038a.C0582d;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.commonwealthcu.mobile.w */
public class C0644w extends Fragment {

    /* renamed from: a */
    private EditText f864a;

    /* renamed from: b */
    private EditText f865b;

    /* renamed from: c */
    private View f866c;

    /* renamed from: d */
    private C0619bi f867d;

    /* renamed from: e */
    private String f868e;

    /* renamed from: f */
    private String f869f;

    /* renamed from: g */
    private String f870g;

    /* renamed from: a */
    public final void mo5575a() {
        Log.d("LV", "Directory is: " + this.f868e);
        if (this.f868e.toLowerCase(Locale.US).contains("mobileweb")) {
            HashMap hashMap = new HashMap();
            hashMap.put("m_username", this.f864a.getText().toString());
            hashMap.put("m_password", this.f865b.getText().toString());
            this.f865b.setText("");
            this.f864a.setText("");
            this.f867d.mo5545a();
            new C0582d(getActivity(), hashMap).execute(new String[]{this.f869f + "/commonfiles/MobileWeb/EP/login.asp", this.f870g});
            return;
        }
        Intent intent = new Intent(getActivity(), BankingView.class);
        intent.putExtra("EXTRA_USERNAME", this.f864a.getText().toString());
        intent.putExtra("EXTRA_PWORD", this.f865b.getText().toString());
        this.f865b.setText("");
        this.f864a.setText("");
        getActivity().startActivityForResult(intent, C0137R.styleable.Theme_spinnerStyle);
    }

    /* renamed from: b */
    public final void mo5576b() {
        this.f867d.mo5545a();
    }

    /* renamed from: c */
    public final void mo5577c() {
        if (this.f867d.isVisible()) {
            this.f867d.mo5546b();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C0137R.layout.loginview, viewGroup, false);
        this.f866c = inflate;
        C0250b.m92a((Context) getActivity(), this.f866c);
        this.f864a = (EditText) this.f866c.findViewById(C0137R.C0139id.textUsername);
        this.f865b = (EditText) this.f866c.findViewById(C0137R.C0139id.textPassword);
        MobileBankingApp mobileBankingApp = (MobileBankingApp) getActivity().getApplicationContext();
        String a = mobileBankingApp.mo5460a("UIDNumeric");
        String a2 = mobileBankingApp.mo5460a("AppBackgroundColor");
        this.f868e = mobileBankingApp.mo5469e();
        this.f869f = mobileBankingApp.mo5468d();
        this.f870g = mobileBankingApp.mo5471g();
        if (a2 != null && a2.length() == 7) {
            inflate.setBackgroundDrawable(new ColorDrawable(Color.parseColor(a2)));
        }
        if (a != null && a.equalsIgnoreCase("true")) {
            this.f864a.setInputType(2);
        }
        String a3 = mobileBankingApp.mo5460a("LoginTextColor");
        if (a3 != null && a3.length() == 7) {
            ((TextView) inflate.findViewById(C0137R.C0139id.lblUsername)).setTextColor(Color.parseColor(a3));
            ((TextView) inflate.findViewById(C0137R.C0139id.lblPassword)).setTextColor(Color.parseColor(a3));
        }
        FragmentTransaction beginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        C0619bi biVar = new C0619bi();
        beginTransaction.add(16908290, (Fragment) biVar);
        this.f867d = biVar;
        beginTransaction.commit();
        return inflate;
    }

    public void onStart() {
        super.onStart();
        mo5577c();
        this.f864a.clearFocus();
        this.f864a.requestFocus();
        ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(this.f864a, 1);
    }

    public void onStop() {
        super.onStop();
        mo5577c();
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f864a.getWindowToken(), 0);
    }
}
