package com.jackhenry.godough.core.alerts;

import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.C1895t;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Alert;
import com.jackhenry.godough.core.p038e.C1586o;

public class AlertDetailFragment extends C1802r {
    public static final String EXTRA_ALERT = "EXTRA_ALERT";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Alert f5973a;

    /* renamed from: b */
    private int f5974b = 0;

    /* renamed from: c */
    private AlertDetailFragment f5975c;

    /* renamed from: d */
    private C1895t<Boolean> f5976d;

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m5975n() {
        mo10988l();
        this.f5976d = new C1502e(this, this.f5975c, new C1500c(this));
        getActivity().getSupportLoaderManager().initLoader(0, (Bundle) null, this.f5976d);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f5975c = this;
        if (bundle == null || !bundle.containsKey("EXTRA_ALERT")) {
            this.f5974b = getActivity().getIntent().getIntExtra("EXTRA_ALERT", 0);
        } else {
            this.f5974b = bundle.getInt("EXTRA_ALERT");
        }
        this.f5973a = GoDoughApp.getAlertsList().get(this.f5974b);
        GoDoughApp.removeAlertFromList(this.f5974b);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.header_message_table, viewGroup);
        TextView textView = (TextView) inflate.findViewById(C1494ai.header);
        TextView textView2 = (TextView) inflate.findViewById(C1494ai.message);
        textView.setText(this.f5973a.getDescription());
        C1586o.m6198a((LayerDrawable) textView.getBackground());
        textView2.setVisibility(0);
        textView2.setText(this.f5973a.getAlertText() + " " + this.f5973a.getHeaderText());
        m5975n();
        return inflate;
    }
}
