package com.jackhenry.godough.core.widgets;

import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import com.google.p019b.p020a.C1336a;
import com.google.p019b.p020a.C1338c;
import java.util.Locale;

public class PhoneNumberTextWatcher implements TextWatcher {

    /* renamed from: a */
    private boolean f6858a;

    /* renamed from: b */
    private boolean f6859b;

    /* renamed from: c */
    private C1336a f6860c;

    public PhoneNumberTextWatcher() {
        this(Locale.getDefault().getCountry());
    }

    public PhoneNumberTextWatcher(String str) {
        this.f6858a = false;
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.f6860c = C1338c.m5478a().mo9197d(str);
    }

    /* renamed from: a */
    private String m6946a(char c, boolean z) {
        return z ? this.f6860c.mo9189b(c) : this.f6860c.mo9186a(c);
    }

    /* renamed from: a */
    private String m6947a(CharSequence charSequence, int i) {
        String str;
        int i2 = i - 1;
        String str2 = null;
        this.f6860c.mo9187a();
        int length = charSequence.length();
        int i3 = 0;
        boolean z = false;
        char c = 0;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (PhoneNumberUtils.isNonSeparator(charAt)) {
                if (c != 0) {
                    str2 = m6946a(c, z);
                    z = false;
                }
                c = charAt;
                str = str2;
            } else {
                str = str2;
            }
            if (i3 == i2) {
                z = true;
            }
            i3++;
            str2 = str;
        }
        return c != 0 ? m6946a(c, z) : str2;
    }

    /* renamed from: a */
    private void m6948a() {
        this.f6859b = true;
        this.f6860c.mo9187a();
    }

    /* renamed from: a */
    private boolean m6949a(CharSequence charSequence, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            if (!PhoneNumberUtils.isNonSeparator(charSequence.charAt(i3))) {
                return true;
            }
        }
        return false;
    }

    public synchronized void afterTextChanged(Editable editable) {
        String a;
        boolean z = true;
        synchronized (this) {
            if (this.f6859b) {
                if (editable.length() == 0) {
                    z = false;
                }
                this.f6859b = z;
            } else if (!this.f6858a && (a = m6947a((CharSequence) editable, Selection.getSelectionEnd(editable))) != null) {
                int c = this.f6860c.mo9190c();
                this.f6858a = true;
                editable.replace(0, editable.length(), a, 0, a.length());
                if (a.equals(editable.toString())) {
                    Selection.setSelection(editable, c);
                }
                this.f6858a = false;
            }
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!this.f6858a && !this.f6859b && i2 > 0 && m6949a(charSequence, i, i2)) {
            m6948a();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f6858a || this.f6859b) {
        }
    }
}
