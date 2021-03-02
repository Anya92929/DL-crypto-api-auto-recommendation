package com.forexcrunch.forexcrunch.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.gui.utils.Constants;
import com.forexcrunch.forexcrunch.gui.utils.GuiUtil;
import com.google.analytics.tracking.android.EasyTracker;

public class AboutActivity extends Activity implements View.OnClickListener {
    private ImageButton imbFace;
    private ImageButton imbTwitter;
    private Intent intent;
    private TextView txtTextBold;
    private TextView txtTextNormal;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0089R.layout.about_activity);
        this.txtTextBold = (TextView) findViewById(C0089R.idabout.txt_text_bold);
        this.txtTextBold.setText(Html.fromHtml(getString(C0089R.string.text_about_bold)));
        this.txtTextNormal = (TextView) findViewById(C0089R.idabout.txt_text_normal);
        this.txtTextNormal.setText(Html.fromHtml(getString(C0089R.string.text_about_normal)));
        this.imbFace = (ImageButton) findViewById(C0089R.idabout.imb_face);
        this.imbFace.setOnClickListener(this);
        this.imbTwitter = (ImageButton) findViewById(C0089R.idabout.imb_twitter);
        this.imbTwitter.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0089R.idabout.imb_twitter:
                GuiUtil.seeTwiterProfile(this, Constants.FOREX_TWITTER_USERNAME, true);
                return;
            case C0089R.idabout.imb_face:
                GuiUtil.seeFacebookProfile(this, Constants.FOREX_FACEBOOK_ID, true);
                return;
            default:
                return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0089R.C0091menu.home_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case C0089R.id_home_menu.home:
                this.intent = new Intent(this, HomeFragment.class);
                startActivity(this.intent);
                return true;
            case C0089R.id_home_menu.daily:
                this.intent = new Intent(this, DailyFragment.class);
                startActivity(this.intent);
                return true;
            case C0089R.id_home_menu.weekly:
                this.intent = new Intent(this, WeeklyFragment.class);
                startActivity(this.intent);
                return true;
            case C0089R.id_home_menu.news:
                this.intent = new Intent(this, NewsFragment.class);
                startActivity(this.intent);
                return true;
            case C0089R.id_home_menu.calendar:
                this.intent = new Intent(this, CalendarListFragment.class);
                startActivity(this.intent);
                return true;
            case C0089R.id_home_menu.trendy:
                this.intent = new Intent(this, TrendingActivity.class);
                startActivity(this.intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        EasyTracker.getInstance().activityStart(this);
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        EasyTracker.getInstance().activityStop(this);
        super.onStop();
    }
}
