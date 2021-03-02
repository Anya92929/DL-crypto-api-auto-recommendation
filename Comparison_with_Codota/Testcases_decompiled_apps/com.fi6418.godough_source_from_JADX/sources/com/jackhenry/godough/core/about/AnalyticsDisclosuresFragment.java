package com.jackhenry.godough.core.about;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;

public class AnalyticsDisclosuresFragment extends C1802r {
    public static final String TAG = "AnalyticsDisclosuresFragment";

    /* renamed from: a */
    TextView f5800a;

    /* renamed from: b */
    RelativeLayout f5801b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5801b = (RelativeLayout) layoutInflater.inflate(C1496ak.analytics_disclosures_fragment, viewGroup, false);
        this.f5800a = (TextView) this.f5801b.findViewById(C1494ai.analytics_disclosures_text);
        this.f5800a.setText(Html.fromHtml(getString(C1506am.analytics_disclosure)));
        return this.f5801b;
    }
}
