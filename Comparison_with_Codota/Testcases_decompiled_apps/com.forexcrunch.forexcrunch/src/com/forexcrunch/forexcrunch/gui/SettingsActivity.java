package com.forexcrunch.forexcrunch.gui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.gui.utils.Constants;
import com.forexcrunch.forexcrunch.gui.utils.GuiUtil;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.C0165Ad;
import com.google.ads.doubleclick.DfpAdView;
import com.google.analytics.tracking.android.EasyTracker;
import com.parse.PushService;

public class SettingsActivity extends Activity implements View.OnClickListener, AdListener {
    private DfpAdView adView;
    private ImageButton imbOff;
    private ImageButton imbOn;
    private ImageButton imbRate;
    private ImageButton imbShare;
    private Intent intent;
    private boolean isImbOff = false;
    private boolean isImbOn = false;
    private boolean subscribed = false;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0089R.layout.settings_activity);
        initComponents();
        restorePreferences();
        createAd();
    }

    private void restorePreferences() {
        if (PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean("notif", true)) {
            this.imbOn.setImageResource(C0089R.drawable.onon);
            this.imbOff.setImageResource(C0089R.drawable.offoff);
            this.isImbOn = true;
            this.isImbOff = false;
            return;
        }
        this.imbOff.setImageResource(C0089R.drawable.offon);
        this.imbOn.setImageResource(C0089R.drawable.onoff);
        this.isImbOn = false;
        this.isImbOff = true;
    }

    private void initComponents() {
        this.imbOn = (ImageButton) findViewById(C0089R.idsettings.imb_on);
        this.imbOn.setOnClickListener(this);
        this.imbOff = (ImageButton) findViewById(C0089R.idsettings.imb_off);
        this.imbOff.setOnClickListener(this);
        this.imbShare = (ImageButton) findViewById(C0089R.idsettings.imb_share);
        this.imbShare.setOnClickListener(this);
        this.imbRate = (ImageButton) findViewById(C0089R.idsettings.imb_rate);
        this.imbRate.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0089R.idsettings.imb_on:
                if (!this.isImbOn) {
                    this.imbOn.setImageResource(C0089R.drawable.onon);
                    this.imbOff.setImageResource(C0089R.drawable.offoff);
                    this.isImbOn = true;
                    this.isImbOff = false;
                    setNotificationsPreference(true);
                    PushService.subscribe(this, "forex", SplashScreen.class);
                    PushService.subscribe(this, "pruebas", SplashScreen.class);
                    return;
                }
                return;
            case C0089R.idsettings.imb_off:
                if (!this.isImbOff) {
                    this.imbOff.setImageResource(C0089R.drawable.offon);
                    this.imbOn.setImageResource(C0089R.drawable.onoff);
                    this.isImbOff = true;
                    this.isImbOn = false;
                    setNotificationsPreference(false);
                    PushService.unsubscribe(this, "forex");
                    PushService.unsubscribe(this, "pruebas");
                    return;
                }
                return;
            case C0089R.idsettings.imb_share:
                GuiUtil.showShareDialog(this, Constants.FOREX_APP_URL, Constants.SUBJECT_DOWNLOAD_APP, true).show();
                return;
            case C0089R.idsettings.imb_rate:
                GuiUtil.rateApp(this);
                return;
            default:
                return;
        }
    }

    private void setNotificationsPreference(boolean state) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
        editor.putBoolean("notif", state);
        editor.commit();
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

    private void createAd() {
        this.adView = new DfpAdView((Activity) this, new AdSize(320, 50), "/16866187/mobapp_320x50");
        ((LinearLayout) findViewById(C0089R.idsettings.f57ad)).addView(this.adView);
        this.adView.loadAd(new AdRequest());
        this.adView.setAdListener(this);
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
