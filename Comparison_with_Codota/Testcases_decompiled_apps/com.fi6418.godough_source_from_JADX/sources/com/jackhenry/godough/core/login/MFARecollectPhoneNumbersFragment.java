package com.jackhenry.godough.core.login;

import android.os.Bundle;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1410ab;
import com.jackhenry.godough.core.C1493ah;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.C1916u;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.MFAPhone;
import com.jackhenry.godough.core.model.MFARecollect;
import com.jackhenry.godough.core.widgets.ActionButton;
import java.util.ArrayList;
import java.util.Iterator;

public class MFARecollectPhoneNumbersFragment extends C1802r implements View.OnClickListener {
    public static final String TAG = MFARecollectPhoneNumbersFragment.class.getSimpleName();

    /* renamed from: a */
    ArrayList<MFAPhoneNumberEntry> f6329a = new ArrayList<>();

    /* renamed from: b */
    ArrayList<MFAPhone> f6330b = new ArrayList<>();

    /* renamed from: c */
    RelativeLayout f6331c = null;

    /* renamed from: d */
    ActionButton f6332d = null;

    /* renamed from: e */
    ActionButton f6333e = null;

    /* renamed from: f */
    MFARecollect f6334f = null;

    /* renamed from: g */
    Bundle f6335g = null;

    /* renamed from: h */
    private C1916u f6336h;

    /* renamed from: i */
    private MFAPhoneNumberEntry f6337i;

    /* renamed from: a */
    private void m6341a(View view) {
        this.f6331c = (RelativeLayout) view.findViewById(C1494ai.add_phonenumber_zone);
        this.f6331c.setOnClickListener(new C1683ca(this));
    }

    /* renamed from: n */
    private void m6342n() {
        if (this.f6335g != null) {
            this.f6330b.clear();
            new MFAPhone();
            for (int i = 0; i < this.f6329a.size(); i++) {
                String str = "MFARECOLLECTPHONE" + Integer.toString(i) + "EXTENSIONVISIBILITY";
                MFAPhone mFAPhone = (MFAPhone) this.f6335g.getSerializable("MFARECOLLECTPHONE" + Integer.toString(i));
                this.f6329a.get(i).setVisibility(this.f6335g.getInt("MFARECOLLECTPHONE" + Integer.toString(i) + "VISIBILITY"));
                int i2 = 8;
                if (this.f6335g.containsKey(str)) {
                    i2 = this.f6335g.getInt(str);
                }
                if (i2 == 0) {
                    this.f6329a.get(i).showExtension();
                }
                mFAPhone.setNumber(mFAPhone.getNumber().trim().replaceAll("[^0-9]", ""));
                this.f6329a.get(i).updatePhoneInfo(mFAPhone, false);
            }
            Iterator<MFAPhoneNumberEntry> it = this.f6329a.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                MFAPhoneNumberEntry next = it.next();
                if (next.getVisibility() == 0) {
                    i3++;
                    this.f6330b.add(next.getPhoneInfo());
                }
                i3 = i3;
            }
            updatePhoneEntryTypes();
            if (i3 > 3) {
                this.f6331c.setEnabled(false);
            } else {
                this.f6331c.setEnabled(true);
            }
        }
    }

    /* renamed from: o */
    private String m6343o() {
        TelephonyManager telephonyManager = (TelephonyManager) GoDoughApp.getApp().getSystemService("phone");
        if (telephonyManager.getLine1Number() == null) {
            return null;
        }
        String trim = telephonyManager.getLine1Number().trim();
        if (trim.startsWith("1")) {
            trim = trim.substring(1);
        }
        return trim.replaceAll("[^0-9]", "");
    }

    /* renamed from: p */
    private void m6344p() {
        for (int i = 0; i < this.f6330b.size(); i++) {
            MFAPhone mFAPhone = this.f6330b.get(i);
            MFAPhoneNumberEntry mFAPhoneNumberEntry = this.f6329a.get(i);
            mFAPhoneNumberEntry.setVisibility(0);
            if (mFAPhone.getExtension() != null) {
                mFAPhoneNumberEntry.showExtension();
            }
            mFAPhoneNumberEntry.updatePhoneInfo(mFAPhone, true);
            if (mFAPhone.getNumber() == null) {
                mFAPhoneNumberEntry.setVisibility(8);
            }
        }
        if (this.f6330b.size() == 0) {
            MFAPhoneNumberEntry mFAPhoneNumberEntry2 = this.f6329a.get(0);
            MFAPhone mFAPhone2 = new MFAPhone();
            mFAPhone2.setType(MFAPhone.PhoneType.Mobile.ordinal());
            mFAPhoneNumberEntry2.updatePhoneInfo(mFAPhone2, true);
            mFAPhoneNumberEntry2.setVisibility(0);
        }
        updatePhoneEntryTypes();
        if (this.f6330b.size() > 3) {
            this.f6331c.setEnabled(false);
        } else {
            this.f6331c.setEnabled(true);
        }
    }

    /* renamed from: q */
    private void m6345q() {
        ArrayList<MFAPhone> phoneInfo = getPhoneInfo();
        this.f6334f.setPhoneOne((MFAPhone) null);
        this.f6334f.setPhoneTwo((MFAPhone) null);
        this.f6334f.setPhoneThree((MFAPhone) null);
        this.f6334f.setPhoneFour((MFAPhone) null);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < phoneInfo.size()) {
                MFAPhone mFAPhone = phoneInfo.get(i2);
                switch (i2) {
                    case 0:
                        this.f6334f.setPhoneOne(mFAPhone);
                        break;
                    case 1:
                        this.f6334f.setPhoneTwo(mFAPhone);
                        break;
                    case 2:
                        this.f6334f.setPhoneThree(mFAPhone);
                        break;
                    case 3:
                        this.f6334f.setPhoneFour(mFAPhone);
                        break;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void addPhoneNumberEntry(Integer num) {
        int i = 0;
        while (true) {
            if (i >= this.f6329a.size()) {
                break;
            } else if (this.f6329a.get(i).getVisibility() == 8) {
                MFAPhone mFAPhone = new MFAPhone();
                mFAPhone.setType(num.intValue());
                this.f6329a.get(i).updatePhoneInfo(mFAPhone, true);
                this.f6329a.get(i).setVisibility(0);
                updatePhoneEntryTypes();
                break;
            } else {
                i++;
            }
        }
        validatePhoneNumbers();
    }

    public void checkPermissionGetDevicePhoneNumber(MFAPhoneNumberEntry mFAPhoneNumberEntry) {
        this.f6336h = new C1916u(new C1410ab(this));
        if (this.f6336h.mo11157a((String) null, "android.permission.READ_PHONE_STATE", (int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION)) {
            mFAPhoneNumberEntry.f6307b.setText(m6343o());
        } else {
            this.f6337i = mFAPhoneNumberEntry;
        }
    }

    public ArrayList<String> getAvailableTypes(int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        C1684cb cbVar = new C1684cb(this);
        if (!cbVar.mo9989a() || i == MFAPhone.PhoneType.Mobile.ordinal()) {
            arrayList.add(getResources().getString(C1506am.lbl_mobile));
        }
        if (!cbVar.mo9990b() || i == MFAPhone.PhoneType.Home.ordinal()) {
            arrayList.add(getResources().getString(C1506am.lbl_home));
        }
        if (!cbVar.mo9991c() || i == MFAPhone.PhoneType.Work.ordinal()) {
            arrayList.add(getResources().getString(C1506am.lbl_work));
        }
        if (!cbVar.mo9992d() || i == MFAPhone.PhoneType.Other.ordinal()) {
            arrayList.add(getResources().getString(C1506am.lbl_other));
        }
        return arrayList;
    }

    public ArrayList<MFAPhone> getPhoneInfo() {
        ArrayList<MFAPhone> arrayList = new ArrayList<>();
        Iterator<MFAPhoneNumberEntry> it = this.f6329a.iterator();
        while (it.hasNext()) {
            MFAPhoneNumberEntry next = it.next();
            if (next.getVisibility() == 0) {
                MFAPhone phoneInfo = next.getPhoneInfo();
                if (!next.isExtensionVisible()) {
                    phoneInfo.setExtension((String) null);
                }
                phoneInfo.setNumber(phoneInfo.getNumber().replaceAll("[^0-9]", ""));
                arrayList.add(phoneInfo);
            }
        }
        return arrayList;
    }

    public ArrayList<MFAPhoneNumberEntry> getPhoneNumberEntries() {
        return this.f6329a;
    }

    public C1684cb getPhoneTypeAvailabilities() {
        return new C1684cb(this);
    }

    public void onClick(View view) {
        if (view.getTag() != null && view.getTag().equals(this.f6332d.getButton().getTag())) {
            m6345q();
            ((MFARecollectActivity) getActivity()).submitData(this.f6334f);
        } else if (view.getTag() != null && view.getTag().equals(this.f6333e.getButton().getTag())) {
            m6345q();
            ((MFARecollectActivity) getActivity()).cancel(this.f6334f);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ((AbstractActivity) getActivity()).getSupportActionBar().setTitle((CharSequence) getResources().getString(C1506am.mfa_callback_verification));
        View inflate = layoutInflater.inflate(C1496ak.mfa_phonenumber_fragment, (ViewGroup) null, false);
        this.f6332d = (ActionButton) inflate.findViewById(C1494ai.btn_submit);
        this.f6332d.setOnClickListener(this);
        this.f6332d.getButton().setTag(Integer.valueOf(C1506am.btn_submit));
        this.f6333e = (ActionButton) inflate.findViewById(C1494ai.btn_back);
        this.f6333e.setOnClickListener(this);
        this.f6333e.getButton().setTag(Integer.valueOf(C1506am.btn_back));
        this.f6329a.clear();
        this.f6329a.add((MFAPhoneNumberEntry) inflate.findViewById(C1494ai.mfaPhone1));
        this.f6329a.add((MFAPhoneNumberEntry) inflate.findViewById(C1494ai.mfaPhone2));
        this.f6329a.add((MFAPhoneNumberEntry) inflate.findViewById(C1494ai.mfaPhone3));
        this.f6329a.add((MFAPhoneNumberEntry) inflate.findViewById(C1494ai.mfaPhone4));
        m6341a(inflate);
        Iterator<MFAPhoneNumberEntry> it = this.f6329a.iterator();
        while (it.hasNext()) {
            it.next().setParent(this);
        }
        m6342n();
        if (this.f6334f == null) {
            this.f6330b.clear();
            this.f6334f = ((MFARecollectActivity) getActivity()).getMfaRecollect();
            if (this.f6334f.getPhoneOne() != null) {
                this.f6330b.add(this.f6334f.getPhoneOne());
            }
            if (this.f6334f.getPhoneTwo() != null) {
                this.f6330b.add(this.f6334f.getPhoneTwo());
            }
            if (this.f6334f.getPhoneThree() != null) {
                this.f6330b.add(this.f6334f.getPhoneThree());
            }
            if (this.f6334f.getPhoneFour() != null) {
                this.f6330b.add(this.f6334f.getPhoneFour());
            }
        }
        m6344p();
        return inflate;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION:
                if (strArr[0].equals("android.permission.READ_PHONE_STATE") && this.f6336h.mo11156a(iArr[0], (String) null, false)) {
                    this.f6337i.f6307b.setText(m6343o());
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f6335g == null) {
            this.f6335g = new Bundle();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f6329a.size()) {
                this.f6335g.putSerializable("MFARECOLLECTPHONE" + Integer.toString(i2), this.f6329a.get(i2).getPhoneInfo());
                this.f6335g.putInt("MFARECOLLECTPHONE" + Integer.toString(i2) + "VISIBILITY", this.f6329a.get(i2).getVisibility());
                this.f6335g.putInt("MFARECOLLECTPHONE" + Integer.toString(i2) + "EXTENSIONVISIBILITY", this.f6329a.get(i2).f6318m.getVisibility());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void updatePhoneEntryTypes() {
        Iterator<MFAPhoneNumberEntry> it = this.f6329a.iterator();
        int i = 0;
        while (it.hasNext()) {
            MFAPhoneNumberEntry next = it.next();
            if (next.getVisibility() == 0) {
                next.updateAdapterList(getAvailableTypes(next.getPhoneInfo().getType()));
                i++;
            }
            next.f6307b.setSelection(next.f6307b.getText().toString().length(), next.f6307b.getText().toString().length());
        }
        if (i > 3) {
            this.f6331c.setEnabled(false);
        } else {
            this.f6331c.setEnabled(true);
        }
    }

    public void validatePhoneNumbers() {
        int i;
        this.f6332d.setEnabled(true);
        Iterator<MFAPhoneNumberEntry> it = this.f6329a.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            MFAPhoneNumberEntry next = it.next();
            if (next.getVisibility() == 0) {
                if (!next.isPhoneNumberValid()) {
                    this.f6332d.setEnabled(false);
                }
                i = i2 + 1;
            } else {
                i = i2;
            }
            i2 = i;
        }
        if (i2 == 0) {
            this.f6332d.setEnabled(false);
        }
        if (i2 == 4) {
            this.f6331c.setVisibility(8);
            this.f6329a.get(3).setBackgroundResource(C1493ah.list_item_last_shadow_overlay);
        } else if (this.f6331c.getVisibility() == 8) {
            this.f6331c.setVisibility(0);
            this.f6329a.get(3).setBackgroundResource(C1493ah.list_item_shadow_overlay);
        }
    }
}
