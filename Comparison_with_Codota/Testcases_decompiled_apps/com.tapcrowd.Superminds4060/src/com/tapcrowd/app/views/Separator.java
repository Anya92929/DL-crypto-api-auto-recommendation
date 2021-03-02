package com.tapcrowd.app.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;

public class Separator extends LinearLayout {

    /* renamed from: tv */
    private TextView f2143tv;

    public Separator(Context context) {
        super(context);
        construct();
    }

    public Separator(Context context, AttributeSet attrs) {
        super(context, attrs);
        String title = context.obtainStyledAttributes(attrs, C0846R.styleable.separator).getString(0);
        if (title != null && !title.equals("")) {
            construct();
            this.f2143tv.setText(title);
        }
    }

    public Separator(String text) {
        super(App.act);
        construct();
        this.f2143tv.setText(text);
    }

    public void setText(String text) {
        this.f2143tv.setText(text);
    }

    private void construct() {
        LayoutInflater.from(getContext()).inflate(C0846R.layout.separator, this);
        this.f2143tv = (TextView) findViewById(C0846R.C0847id.text);
        C1232UI.setFont(this.f2143tv);
        this.f2143tv.setBackgroundColor(C1216LO.getLo(C1216LO.seperatorBackgroundColor));
        this.f2143tv.setTextColor(C1216LO.getLo(C1216LO.separatorTextColor));
    }
}
