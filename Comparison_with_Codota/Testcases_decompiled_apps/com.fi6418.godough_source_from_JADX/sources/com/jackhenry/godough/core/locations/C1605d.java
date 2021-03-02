package com.jackhenry.godough.core.locations;

import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jackhenry.android.p022a.p023a.C1349a;
import com.jackhenry.godough.core.C1491af;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1801q;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.GoDoughLocation;
import java.text.NumberFormat;

/* renamed from: com.jackhenry.godough.core.locations.d */
public class C1605d extends C1801q<GoDoughLocation> {

    /* renamed from: b */
    private int f6237b;

    /* renamed from: c */
    private NumberFormat f6238c;

    /* renamed from: d */
    private boolean f6239d = false;

    public C1605d(int i, Fragment fragment, boolean z) {
        super(fragment);
        this.f6237b = i;
        this.f6238c = NumberFormat.getInstance();
        this.f6238c.setMinimumFractionDigits(1);
        this.f6238c.setMaximumFractionDigits(1);
        this.f6239d = z;
    }

    /* renamed from: a */
    public C1349a<GoDoughLocation> mo9278a(int i) {
        return null;
    }

    /* renamed from: a */
    public void mo9279a(LayoutInflater layoutInflater, ViewGroup viewGroup, GoDoughLocation goDoughLocation) {
        View inflate = layoutInflater.inflate(this.f6237b, viewGroup);
        viewGroup.setTag(goDoughLocation);
        TextView textView = (TextView) inflate.findViewById(C1494ai.line_right);
        ((TextView) inflate.findViewById(C1494ai.line1)).setText(goDoughLocation.getLocationName());
        ((TextView) inflate.findViewById(C1494ai.line2)).setText(goDoughLocation.getAddress1());
        double milesToLocation = goDoughLocation.getMilesToLocation();
        if (milesToLocation == -1.0d || this.f6239d) {
            textView.setVisibility(8);
        } else if (goDoughLocation.getLatitude() == 0.0d || goDoughLocation.getLongitude() == 0.0d) {
            textView.setText(GoDoughApp.getApp().getString(C1506am.lbl_no_lat_lng));
            textView.setTextColor(inflate.getResources().getColor(C1491af.miles_blue));
        } else {
            textView.setText(this.f6238c.format(milesToLocation) + " mi");
            textView.setTextColor(inflate.getResources().getColor(C1491af.miles_blue));
        }
    }

    /* renamed from: b */
    public boolean mo9567b(View view, Exception exc) {
        mo10985a(exc);
        return false;
    }
}
