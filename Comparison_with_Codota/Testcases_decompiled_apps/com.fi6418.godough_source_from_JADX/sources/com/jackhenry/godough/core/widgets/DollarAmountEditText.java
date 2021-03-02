package com.jackhenry.godough.core.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.jackhenry.godough.core.C1506am;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class DollarAmountEditText extends JhaEditText {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnValueChanged f6856a;

    public interface OnValueChanged {
        void onValueChanged(DollarAmountEditText dollarAmountEditText);
    }

    public DollarAmountEditText(Context context) {
        super(context);
        m6945a();
        setHint(context.getString(C1506am.amount_hint));
    }

    public DollarAmountEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6945a();
    }

    public DollarAmountEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6945a();
    }

    /* renamed from: a */
    private void m6945a() {
        setInputType(8194);
        setOnFocusChangeListener(new C1919a(this));
        addTextChangedListener(new C1920b(this));
    }

    public long getCents() {
        if (getText().toString().equals("")) {
            return 0;
        }
        try {
            return new BigDecimal(getText().toString()).multiply(new BigDecimal(100), new MathContext(0, RoundingMode.UNNECESSARY)).longValueExact();
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void setOnValueChanged(OnValueChanged onValueChanged) {
        this.f6856a = onValueChanged;
    }
}
