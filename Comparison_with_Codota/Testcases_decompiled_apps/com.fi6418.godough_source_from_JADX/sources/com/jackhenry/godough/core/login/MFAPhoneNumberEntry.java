package com.jackhenry.godough.core.login;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import com.google.p019b.p020a.C1336a;
import com.google.p019b.p020a.C1338c;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.MFAPhone;
import com.jackhenry.godough.core.widgets.JhaEditText;
import java.util.ArrayList;

public class MFAPhoneNumberEntry extends LinearLayout {

    /* renamed from: a */
    MFAPhone f6306a = new MFAPhone();

    /* renamed from: b */
    JhaEditText f6307b = null;

    /* renamed from: c */
    JhaEditText f6308c = null;

    /* renamed from: d */
    Spinner f6309d = null;

    /* renamed from: e */
    ImageView f6310e = null;

    /* renamed from: f */
    ImageView f6311f = null;

    /* renamed from: g */
    ImageView f6312g = null;

    /* renamed from: h */
    Context f6313h = null;

    /* renamed from: i */
    MFARecollectPhoneNumbersFragment f6314i = null;

    /* renamed from: j */
    MFAPhoneNumberEntry f6315j = null;

    /* renamed from: k */
    ArrayList<String> f6316k = new ArrayList<>();

    /* renamed from: l */
    ArrayAdapter<String> f6317l;

    /* renamed from: m */
    RelativeLayout f6318m = null;

    /* renamed from: n */
    String f6319n = "";

    /* renamed from: o */
    boolean f6320o = false;

    /* renamed from: p */
    private ArrayList<String> f6321p = new ArrayList<>();

    public MFAPhoneNumberEntry(Context context) {
        super(context, (AttributeSet) null);
        m6333a(context);
    }

    public MFAPhoneNumberEntry(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6333a(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6332a() {
        this.f6314i.validatePhoneNumbers();
    }

    /* renamed from: a */
    private void m6333a(Context context) {
        this.f6315j = this;
        this.f6313h = context;
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(C1496ak.mfa_phonenumber_entry, this, true);
        this.f6307b = (JhaEditText) findViewById(C1494ai.phoneNumberWatcher);
        this.f6318m = (RelativeLayout) findViewById(C1494ai.extension_zone);
        this.f6308c = (JhaEditText) findViewById(C1494ai.extension_edittext);
        this.f6309d = (Spinner) findViewById(C1494ai.phonenumber_type_lbl);
        this.f6310e = (ImageView) findViewById(C1494ai.phonenumber_delete);
        this.f6311f = (ImageView) findViewById(C1494ai.phonenumber_showextension);
        this.f6312g = (ImageView) findViewById(C1494ai.phonenumber_hideextension);
        if (!isInEditMode()) {
            this.f6310e.setOnClickListener(new C1673br(this));
            this.f6311f.setOnClickListener(new C1674bs(this));
            this.f6312g.setOnClickListener(new C1675bt(this));
            this.f6307b.addTextChangedListener(new C1676bu(this));
        }
        this.f6321p.add(getResources().getString(C1506am.lbl_mobile));
        this.f6321p.add(getResources().getString(C1506am.lbl_home));
        this.f6321p.add(getResources().getString(C1506am.lbl_work));
        this.f6321p.add(getResources().getString(C1506am.lbl_other));
        this.f6316k = this.f6321p;
        this.f6317l = new ArrayAdapter<>(context, C1496ak.selection_dialog_list_item, this.f6321p);
        this.f6317l.setDropDownViewResource(17367049);
        this.f6309d.setAdapter(this.f6317l);
        this.f6309d.setOnItemSelectedListener(new C1677bv(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m6335a(int i) {
        return this.f6309d.getSelectedItem().toString().compareTo(getResources().getString(i)) == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6337b() {
        if (this.f6306a.getType() != MFAPhone.PhoneType.Work.ordinal() && this.f6306a.getType() != MFAPhone.PhoneType.Other.ordinal()) {
            this.f6318m.setVisibility(8);
        } else if (this.f6320o) {
            this.f6318m.setVisibility(0);
            this.f6311f.setVisibility(4);
        } else {
            this.f6318m.setVisibility(8);
            this.f6311f.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        super.dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        super.dispatchFreezeSelfOnly(sparseArray);
    }

    public ArrayList<String> getAllTypeStrings() {
        return this.f6321p;
    }

    public MFAPhone getPhoneInfo() {
        this.f6306a.setNumber(this.f6307b.getText().toString());
        if (this.f6311f.getVisibility() == 4) {
            this.f6306a.setExtension(this.f6308c.getText().toString());
        } else {
            this.f6306a.setExtension((String) null);
        }
        return this.f6306a;
    }

    public void hideExtension() {
        this.f6312g.performClick();
    }

    public boolean isExtensionVisible() {
        return this.f6320o;
    }

    public boolean isPhoneNumberValid() {
        return this.f6307b.getText().toString().trim().replaceAll("[^0-9]", "").length() == 10;
    }

    public void setFocusOnNumberField() {
        this.f6307b.requestFocus();
        this.f6307b.setSelection(this.f6307b.getText().length(), this.f6307b.getText().length());
        ((InputMethodManager) GoDoughApp.getApp().getSystemService("input_method")).showSoftInput(this.f6307b, 1);
    }

    public void setParent(MFARecollectPhoneNumbersFragment mFARecollectPhoneNumbersFragment) {
        this.f6314i = mFARecollectPhoneNumbersFragment;
    }

    public void setVisibility(int i) {
        this.f6311f.setVisibility(4);
        super.setVisibility(i);
        m6337b();
        if (i == 0) {
            setFocusOnNumberField();
        }
    }

    public void showExtension() {
        this.f6311f.performClick();
    }

    public void updateAdapterList(ArrayList<String> arrayList) {
        String str = this.f6321p.get(this.f6306a.getType());
        this.f6316k = arrayList;
        this.f6317l = new ArrayAdapter<>(this.f6313h, 17367048, this.f6316k);
        this.f6317l.setDropDownViewResource(17367049);
        this.f6309d.setAdapter(this.f6317l);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f6316k.size()) {
                if (this.f6316k.get(i2).equals(str)) {
                    this.f6309d.setSelection(i2);
                }
                i = i2 + 1;
            } else {
                m6337b();
                return;
            }
        }
    }

    public void updatePhoneInfo(MFAPhone mFAPhone, boolean z) {
        this.f6306a = mFAPhone;
        if (this.f6306a != null) {
            if (this.f6306a.getNumber() != null) {
                this.f6307b.setText(this.f6306a.getNumber());
            }
            if (this.f6306a.getExtension() != null) {
                this.f6308c.setText(this.f6306a.getExtension());
            }
            if (z) {
                this.f6316k = this.f6314i.getAvailableTypes(this.f6306a.getType());
                updateAdapterList(this.f6316k);
            }
            m6337b();
        }
    }

    public String updatePhoneNumber(String str) {
        C1336a d = C1338c.m5478a().mo9197d("US");
        String str2 = null;
        if (str.length() > 0) {
            String str3 = new String(str.replaceAll("(^[0?])|(^[1?])|([^\\d.])", ""));
            if (str3.length() > 10) {
                str3 = str3.substring(0, 10);
            }
            if (str3 != null) {
                for (int i = 0; i < str3.length(); i++) {
                    str2 = d.mo9186a(str3.charAt(i));
                }
            }
            d.mo9187a();
        }
        return str2;
    }
}
