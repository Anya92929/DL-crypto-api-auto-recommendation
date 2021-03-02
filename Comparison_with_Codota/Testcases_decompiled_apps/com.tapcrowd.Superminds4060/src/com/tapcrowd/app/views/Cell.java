package com.tapcrowd.app.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;

public class Cell extends LinearLayout {

    /* renamed from: tv */
    public TextView f2140tv;

    public Cell(Context context) {
        super(context);
        construct();
    }

    public Cell(String text) {
        super(App.act);
        if (text != null && !text.equals("")) {
            construct();
            this.f2140tv.setText(text);
            findViewById(C0846R.C0847id.arrow).setVisibility(8);
            findViewById(C0846R.C0847id.icon).setVisibility(8);
        }
    }

    public Cell(String text, boolean arrow) {
        super(App.act);
        if (text != null && !text.equals("")) {
            construct();
            this.f2140tv.setText(text);
            if (!arrow) {
                findViewById(C0846R.C0847id.arrow).setVisibility(8);
            }
        }
    }

    public Cell(String text, int draw) {
        super(App.act);
        if (text != null && !text.equals("")) {
            construct();
            this.f2140tv.setText(text);
            this.f2140tv.setTextColor(C1216LO.getLo(C1216LO.textcolor));
            ((ImageView) findViewById(C0846R.C0847id.icon)).setImageResource(draw);
            if (draw == 0) {
                findViewById(C0846R.C0847id.icon).setVisibility(8);
            }
        }
    }

    public Cell(String text, Drawable draw) {
        super(App.act);
        if (text != null && !text.equals("")) {
            construct();
            this.f2140tv.setText(text);
            this.f2140tv.setTextColor(C1216LO.getLo(C1216LO.textcolor));
            ((ImageView) findViewById(C0846R.C0847id.icon)).setImageDrawable(draw);
        }
    }

    public void setImage(Drawable drawable) {
        ((ImageView) findViewById(C0846R.C0847id.icon)).setImageDrawable(drawable);
        findViewById(C0846R.C0847id.icon).setVisibility(0);
    }

    public void hideArrow() {
        findViewById(C0846R.C0847id.arrow).setVisibility(8);
    }

    public Cell showSeparator() {
        try {
            findViewById(C0846R.C0847id.sep).setVisibility(0);
        } catch (Exception e) {
        }
        return this;
    }

    public Cell hideSeparator() {
        try {
            findViewById(C0846R.C0847id.sep).setVisibility(8);
        } catch (Exception e) {
        }
        return this;
    }

    public void setTitle(String text) {
        TextView title = (TextView) findViewById(C0846R.C0847id.title);
        title.setVisibility(0);
        title.setTextColor(C1216LO.getLo(C1216LO.textcolor));
        title.setText(text);
    }

    public void setText(String text) {
        this.f2140tv.setText(text);
    }

    public void setLinksClickable() {
        this.f2140tv.setAutoLinkMask(1);
        this.f2140tv.setLinksClickable(true);
    }

    public void setMaxLines(final int maxlines) {
        if (maxlines != 0) {
            this.f2140tv.setMaxLines(maxlines);
            this.f2140tv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (Cell.this.f2140tv.getLineCount() > maxlines) {
                        Cell.this.f2140tv.setText(Cell.this.f2140tv.getText().subSequence(0, Cell.this.f2140tv.getLayout().getLineEnd(maxlines) - 3) + "...");
                    }
                }
            });
        }
    }

    private void construct() {
        LayoutInflater.from(getContext()).inflate(C0846R.layout.cell_info, this);
        C1232UI.setFont((ViewGroup) this);
        this.f2140tv = (TextView) findViewById(C0846R.C0847id.text);
        this.f2140tv.setTextSize(15.0f);
        this.f2140tv.setTextColor(C1216LO.getLo(C1216LO.textcolor));
        findViewById(C0846R.C0847id.innerwrapper).setBackgroundDrawable(C1232UI.getBackground());
    }
}
