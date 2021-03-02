package com.myip.vpnroot;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PersonalVPNActivity extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(C2344R.layout.new_product_1, container, false);
        Typeface regular = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Regular.ttf");
        ((TextView) rootView.findViewById(C2344R.C2346id.personal_content)).setTypeface(regular);
        ((TextView) rootView.findViewById(C2344R.C2346id.tv_dollar)).setTypeface(regular);
        Typeface bold = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Bold.ttf");
        ((TextView) rootView.findViewById(C2344R.C2346id.personal_title)).setTypeface(bold);
        ((TextView) rootView.findViewById(C2344R.C2346id.tv_price)).setTypeface(bold);
        ((Button) rootView.findViewById(C2344R.C2346id.btn_order)).setTypeface(bold);
        ((Button) rootView.findViewById(C2344R.C2346id.btn_order)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(PersonalVPNActivity.this.getActivity(), OrderActivity.class);
                i.putExtra(Prop.EXTRA_SKU, "Personal VPN");
                PersonalVPNActivity.this.startActivity(i);
            }
        });
        ((TextView) rootView.findViewById(C2344R.C2346id.tv_price_des)).setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Light.ttf"));
        return rootView;
    }
}
