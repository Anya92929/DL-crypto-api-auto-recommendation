package org.commonwealthcu.mobile;

import android.content.Context;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p003v7.appcompat.C0137R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.commonwealthcu.mobile.bi */
public final class C0619bi extends Fragment {

    /* renamed from: a */
    private View f833a;

    /* renamed from: b */
    private TextView f834b;

    /* renamed from: a */
    public final void mo5545a() {
        this.f833a.setVisibility(0);
    }

    /* renamed from: b */
    public final void mo5546b() {
        this.f833a.setVisibility(8);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C0137R.layout.waiting_modal, viewGroup, false);
        inflate.findViewById(C0137R.C0139id.progressBar1);
        this.f833a = inflate;
        this.f834b = (TextView) inflate.findViewById(C0137R.C0139id.loadingText);
        this.f834b.setTypeface(C0250b.m81a((Context) getActivity()));
        return inflate;
    }
}
