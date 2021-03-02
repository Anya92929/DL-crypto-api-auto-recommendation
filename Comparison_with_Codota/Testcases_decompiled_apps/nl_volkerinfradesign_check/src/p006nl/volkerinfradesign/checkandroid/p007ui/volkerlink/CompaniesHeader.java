package p006nl.volkerinfradesign.checkandroid.p007ui.volkerlink;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import p006nl.volkerinfradesign.checkandroid.C1352R;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.volkerlink.CompaniesHeader */
public class CompaniesHeader extends LinearLayout {
    public CompaniesHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CompaniesHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: package-private */
    public ImageButton getCloseButton() {
        return (ImageButton) findViewById(16908327);
    }

    /* access modifiers changed from: package-private */
    public LinearLayout getHintContainer() {
        return (LinearLayout) findViewById(C1352R.C1354id.hintContainer);
    }
}
