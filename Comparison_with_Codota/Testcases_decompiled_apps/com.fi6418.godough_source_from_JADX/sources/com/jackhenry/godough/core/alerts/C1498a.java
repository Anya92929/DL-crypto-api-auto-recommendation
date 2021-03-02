package com.jackhenry.godough.core.alerts;

import android.support.p000v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jackhenry.android.p022a.p023a.C1349a;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1801q;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Alert;
import com.jackhenry.godough.core.session.C1886b;
import java.util.List;

/* renamed from: com.jackhenry.godough.core.alerts.a */
public class C1498a extends C1801q<Alert> {

    /* renamed from: b */
    private int f5980b;

    public C1498a(int i, Fragment fragment) {
        super(fragment);
        this.f5980b = i;
    }

    public C1498a(Fragment fragment) {
        this(C1496ak.list_item_icon_nav, fragment);
    }

    /* renamed from: a */
    public C1349a<Alert> mo9278a(int i) {
        List<Alert> alertsList = GoDoughApp.getAlertsList();
        if (alertsList == null) {
            alertsList = new C1505h().mo9704b();
            GoDoughApp.setAlertsList(alertsList);
            GoDoughApp.updateAlertCount(alertsList.size());
        } else {
            new C1886b().execute(new Void[0]);
        }
        return new C1349a<>(alertsList, false, -1);
    }

    /* renamed from: a */
    public void mo9279a(LayoutInflater layoutInflater, ViewGroup viewGroup, Alert alert) {
        View inflate = layoutInflater.inflate(this.f5980b, viewGroup);
        viewGroup.setTag(alert);
        inflate.findViewById(C1494ai.line2_right).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(C1494ai.line1);
        textView.setMaxLines(1);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setText(alert.getDescription());
        ((TextView) inflate.findViewById(C1494ai.line2)).setText(alert.getAccountDesignator());
    }

    /* renamed from: b */
    public boolean mo9567b(View view, Exception exc) {
        mo10985a(exc);
        return false;
    }
}
