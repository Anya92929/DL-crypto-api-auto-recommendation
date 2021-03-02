package org.commonwealthcu.mobile.p038a;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Pattern;

/* renamed from: org.commonwealthcu.mobile.a.a */
public final class C0579a implements InputFilter {

    /* renamed from: a */
    private Pattern f694a = Pattern.compile("^(\\d{0," + 4 + "})+((\\.\\d{0,1" + "})?$)||(\\.)?");

    public C0579a(int i, int i2) {
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (!this.f694a.matcher(spanned).matches()) {
            return "";
        }
        return null;
    }
}
