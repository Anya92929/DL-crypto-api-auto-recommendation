package com.forexcrunch.forexcrunch.gui;

import android.app.Activity;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.C0165Ad;
import com.google.ads.doubleclick.DfpAdView;

public class InfoFragment extends Fragment implements AdListener {
    private DfpAdView adView;
    private TextView tvInfo;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(C0089R.layout.info_fragment, container, false);
        this.tvInfo = (TextView) view.findViewById(C0089R.C0090id.Info_tvInfo);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            this.tvInfo.setText(bundle.getString("info"));
        }
        createAd();
    }

    private void createAd() {
        this.adView = new DfpAdView((Activity) getActivity(), new AdSize(320, 50), "/16866187/mobapp_320x50");
        ((LinearLayout) getActivity().findViewById(C0089R.C0090id.Info_ad)).addView(this.adView);
        this.adView.loadAd(new AdRequest());
        this.adView.setAdListener(this);
    }

    public void onDismissScreen(C0165Ad arg0) {
    }

    public void onFailedToReceiveAd(C0165Ad arg0, AdRequest.ErrorCode arg1) {
    }

    public void onLeaveApplication(C0165Ad arg0) {
    }

    public void onPresentScreen(C0165Ad arg0) {
    }

    public void onReceiveAd(C0165Ad arg0) {
    }
}
