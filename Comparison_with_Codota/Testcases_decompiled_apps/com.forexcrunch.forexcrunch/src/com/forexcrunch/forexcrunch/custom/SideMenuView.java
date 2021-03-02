package com.forexcrunch.forexcrunch.custom;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.gui.AboutActivity;
import com.forexcrunch.forexcrunch.gui.SavedArticlesActivity;
import com.forexcrunch.forexcrunch.gui.SettingsActivity;
import com.forexcrunch.forexcrunch.gui.SubscribeActivity;

public class SideMenuView extends LinearLayout implements View.OnClickListener {
    private Context context;
    private Intent intent;
    private LinearLayout menu;
    private TextView txtAbout;
    private TextView txtSavedArticles;
    private TextView txtSettings;
    private TextView txtSubscribe;

    public SideMenuView(Context context2, AttributeSet attrs) {
        super(context2, attrs);
        this.context = context2;
        if (!isInEditMode()) {
            try {
                LayoutInflater.from(getContext()).inflate(C0089R.layout.side_menu, this, true);
            } catch (Exception e) {
            }
            this.menu = (LinearLayout) findViewById(C0089R.idSideMenu.menu);
            this.menu.setOnClickListener((View.OnClickListener) null);
            this.txtSavedArticles = (TextView) findViewById(C0089R.idSideMenu.txt_saved_articles);
            this.txtSavedArticles.setOnClickListener(this);
            this.txtSettings = (TextView) findViewById(C0089R.idSideMenu.txt_settings);
            this.txtSettings.setOnClickListener(this);
            this.txtAbout = (TextView) findViewById(C0089R.idSideMenu.txt_about);
            this.txtAbout.setOnClickListener(this);
            this.txtSubscribe = (TextView) findViewById(C0089R.idSideMenu.txt_subscribe);
            this.txtSubscribe.setOnClickListener(this);
        }
    }

    public void showMenu() {
        this.menu.setVisibility(0);
        this.menu.startAnimation(AnimationUtils.loadAnimation(getContext(), C0089R.anim.rbm_in_from_left));
    }

    public void hideMenu() {
        this.menu.setVisibility(8);
        this.menu.startAnimation(AnimationUtils.loadAnimation(getContext(), C0089R.anim.rbm_out_to_left));
    }

    public void toggleMenu() {
        if (this.menu.getVisibility() == 8) {
            showMenu();
        } else {
            hideMenu();
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0089R.idSideMenu.txt_saved_articles:
                this.intent = new Intent(this.context, SavedArticlesActivity.class);
                this.context.startActivity(this.intent);
                return;
            case C0089R.idSideMenu.txt_settings:
                this.intent = new Intent(this.context, SettingsActivity.class);
                this.context.startActivity(this.intent);
                return;
            case C0089R.idSideMenu.txt_subscribe:
                this.intent = new Intent(this.context, SubscribeActivity.class);
                this.context.startActivity(this.intent);
                return;
            case C0089R.idSideMenu.txt_about:
                this.intent = new Intent(this.context, AboutActivity.class);
                this.context.startActivity(this.intent);
                return;
            default:
                return;
        }
    }
}
