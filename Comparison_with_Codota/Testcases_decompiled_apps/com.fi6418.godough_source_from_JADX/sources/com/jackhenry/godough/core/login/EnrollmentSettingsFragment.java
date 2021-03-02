package com.jackhenry.godough.core.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.p019b.p020a.C1336a;
import com.google.p019b.p020a.C1338c;
import com.jackhenry.godough.core.C1410ab;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.C1916u;
import com.jackhenry.godough.core.model.Carrier;
import com.jackhenry.godough.core.p034b.p035a.C1512c;
import com.jackhenry.godough.core.widgets.ActionButton;
import java.util.List;
import java.util.Locale;

public class EnrollmentSettingsFragment extends C1802r implements View.OnClickListener {
    public static final String TAG = EnrollmentSettingsFragment.class.getSimpleName();

    /* renamed from: a */
    List<Carrier> f6276a;

    /* renamed from: aj */
    private ActionButton f6277aj;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public ArrayAdapter<Carrier> f6278ak;

    /* renamed from: b */
    C1916u f6279b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Carrier f6280c;

    /* renamed from: d */
    private boolean f6281d = true;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CheckedTextView f6282e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public EditText f6283f;

    /* renamed from: g */
    private View f6284g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f6285h;

    /* renamed from: i */
    private String f6286i;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6302a(boolean z) {
        boolean z2 = true;
        this.f6281d = !z;
        CheckedTextView checkedTextView = this.f6282e;
        if (z) {
            z2 = false;
        }
        checkedTextView.setChecked(z2);
    }

    /* renamed from: n */
    private void m6308n() {
        TelephonyManager telephonyManager = (TelephonyManager) getActivity().getSystemService("phone");
        this.f6286i = telephonyManager.getNetworkOperatorName().toUpperCase(Locale.US);
        if (telephonyManager.getLine1Number() != null) {
            String trim = telephonyManager.getLine1Number().trim();
            if (trim.startsWith("1")) {
                trim = trim.substring(1);
            }
            this.f6283f.setText(trim);
        }
        if (this.f6280c == null) {
            for (Carrier next : this.f6276a) {
                if (this.f6286i.toUpperCase(Locale.US).contains(next.getName().toUpperCase(Locale.US))) {
                    this.f6285h.setText(next.getName());
                    this.f6285h.setTag(next);
                    this.f6285h.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    return;
                }
            }
            return;
        }
        this.f6285h.setText(this.f6280c.getName());
        this.f6285h.setTag(this.f6280c);
        this.f6285h.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m6309o() {
        if (this.f6283f.getText().toString().trim().replaceAll("[^0-9]", "").length() < 10 || this.f6285h.getTag() == null) {
            this.f6277aj.setEnabled(false);
        } else {
            this.f6277aj.setEnabled(true);
        }
    }

    /* renamed from: p */
    private synchronized void m6310p() {
        if (this.f6276a != null && getFragmentManager().findFragmentByTag("SELECT_DIALOG") == null) {
            int i = -1;
            if (this.f6285h.getTag() != null) {
                i = this.f6278ak.getPosition((Carrier) this.f6285h.getTag());
            }
            C1512c cVar = new C1512c();
            cVar.mo9713b(getString(C1506am.wireless_provider));
            cVar.mo9712a(this.f6278ak, i, new C1750y(this));
            cVar.show(getFragmentManager(), "SELECT_DIALOG");
        }
    }

    public void onClick(View view) {
        m6310p();
    }

    @SuppressLint({"DefaultLocale"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.enrollment_settings_fragment, (ViewGroup) null, false);
        this.f6276a = ((EnrollmentFragmentActivity) getActivity()).getCarriers();
        this.f6285h = (TextView) inflate.findViewById(C1494ai.provider);
        this.f6282e = (CheckedTextView) inflate.findViewById(C1494ai.alert_label);
        this.f6283f = (EditText) inflate.findViewById(C1494ai.phone_number);
        this.f6277aj = (ActionButton) inflate.findViewById(C1494ai.btn_enroll);
        ActionButton actionButton = (ActionButton) inflate.findViewById(C1494ai.btn_cancel);
        this.f6284g = inflate.findViewById(C1494ai.provider_zone);
        this.f6283f.addTextChangedListener(new C1746u(this));
        this.f6279b = new C1916u(new C1410ab(this));
        if (this.f6279b.mo11157a((String) null, "android.permission.READ_PHONE_STATE", (int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION)) {
            m6308n();
        }
        this.f6278ak = new ArrayAdapter<>(getActivity(), C1496ak.selection_dialog_list_item, 0, this.f6276a);
        this.f6278ak.setDropDownViewResource(C1496ak.selection_dialog_list_item);
        this.f6284g.setOnClickListener(this);
        this.f6277aj.setOnClickListener(new C1747v(this));
        this.f6282e.setOnClickListener(new C1748w(this));
        actionButton.setOnClickListener(new C1749x(this));
        m6302a(!this.f6281d);
        m6309o();
        return inflate;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION:
                if (strArr[0].equals("android.permission.READ_PHONE_STATE") && this.f6279b.mo11156a(iArr[0], (String) null, false)) {
                    m6308n();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public String updatePhoneNumber(String str) {
        C1336a d = C1338c.m5478a().mo9197d("US");
        String str2 = null;
        if (str.length() > 0) {
            String str3 = new String(str.replaceAll("(^[0?])|(^[1?])|([^\\d.])", ""));
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
