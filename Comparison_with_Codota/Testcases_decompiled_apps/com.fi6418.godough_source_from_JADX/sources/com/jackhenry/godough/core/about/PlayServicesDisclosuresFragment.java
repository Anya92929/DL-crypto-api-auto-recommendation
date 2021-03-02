package com.jackhenry.godough.core.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1802r;

public class PlayServicesDisclosuresFragment extends C1802r {
    public static final String TAG = "PlayServicesDisclosuresFragment";

    /* renamed from: a */
    TextView f5806a;

    /* renamed from: b */
    RelativeLayout f5807b;

    /* renamed from: c */
    ProgressBar f5808c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5807b = (RelativeLayout) layoutInflater.inflate(C1496ak.play_services_disclosures_fragment, viewGroup, false);
        this.f5806a = (TextView) this.f5807b.findViewById(C1494ai.play_services_disclosures_text);
        this.f5808c = (ProgressBar) this.f5807b.findViewById(C1494ai.progress_bar);
        new C1416f(this).execute(new Void[0]);
        return this.f5807b;
    }
}
