package com.myip.vpnroot;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class BusinessVPNActivity extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(C2344R.layout.new_product_3, container, false);
        Typeface regular = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Regular.ttf");
        ((TextView) rootView.findViewById(C2344R.C2346id.business_content)).setTypeface(regular);
        Typeface bold = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Bold.ttf");
        ((TextView) rootView.findViewById(C2344R.C2346id.tv_quote)).setTypeface(regular);
        ((Button) rootView.findViewById(C2344R.C2346id.btn_contact_us)).setTypeface(bold);
        ((Button) rootView.findViewById(C2344R.C2346id.btn_contact_us)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BusinessVPNActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.myip.io/contact-us")));
            }
        });
        return rootView;
    }
}
