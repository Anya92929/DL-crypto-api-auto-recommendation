package com.tapcrowd.app.views;

import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.App;

public class Notifier extends RelativeLayout {
    public Notifier(int resource) {
        super(App.act);
        LayoutInflater.from(getContext()).inflate(C0846R.layout.notifier, this);
        ((TextView) findViewById(C0846R.C0847id.text)).setText(App.notify);
        if (resource == 0) {
            findViewById(C0846R.C0847id.prog).setVisibility(0);
        } else {
            ((ImageView) findViewById(C0846R.C0847id.icon)).setImageResource(resource);
        }
        findViewById(C0846R.C0847id.notificationmain).setBackgroundColor(App.notifycolor);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) generateDefaultLayoutParams();
        params.addRule(12);
        setLayoutParams(params);
    }
}
