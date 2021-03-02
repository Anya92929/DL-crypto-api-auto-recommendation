package com.myip.vpnroot;

import android.os.Bundle;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.app.FragmentTabHost;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewMainActivity extends FragmentActivity {
    private FragmentTabHost mTabHost;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(2048, 2048);
        setContentView(C2344R.layout.new_activity_main);
        this.mTabHost = (FragmentTabHost) findViewById(16908306);
        this.mTabHost.setup(this, getSupportFragmentManager(), 16908305);
        LinearLayout layout1 = new LinearLayout(this);
        layout1.setOrientation(1);
        layout1.setGravity(17);
        ImageView imageView1 = new ImageView(this);
        imageView1.setImageResource(C2344R.C2345drawable.selector_tabhost_products);
        layout1.addView(imageView1, -2, -2);
        TextView textView1 = new TextView(this);
        textView1.setText("Products");
        layout1.addView(textView1, -2, -2);
        this.mTabHost.addTab(this.mTabHost.newTabSpec("Products").setIndicator(layout1), ProductsActivity.class, (Bundle) null);
        LinearLayout layout2 = new LinearLayout(this);
        layout2.setOrientation(1);
        layout2.setGravity(17);
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(C2344R.C2345drawable.selector_tabhost_services);
        layout2.addView(imageView2, -2, -2);
        TextView textView2 = new TextView(this);
        textView2.setText("Services");
        layout2.addView(textView2, -2, -2);
        this.mTabHost.addTab(this.mTabHost.newTabSpec("Services").setIndicator(layout2), ServicesActivity.class, (Bundle) null);
        LinearLayout layout3 = new LinearLayout(this);
        layout3.setOrientation(1);
        layout3.setGravity(17);
        ImageView imageView3 = new ImageView(this);
        imageView3.setImageResource(C2344R.C2345drawable.selector_tabhost_profile);
        layout3.addView(imageView3, -2, -2);
        TextView textView3 = new TextView(this);
        textView3.setText("Options");
        layout3.addView(textView3, -2, -2);
        this.mTabHost.addTab(this.mTabHost.newTabSpec("Options").setIndicator(layout3), OptionsActivity.class, (Bundle) null);
        for (int i = 0; i < this.mTabHost.getTabWidget().getChildCount(); i++) {
            this.mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(C2344R.C2345drawable.shape_transparent);
        }
    }
}
