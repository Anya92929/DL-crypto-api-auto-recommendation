package com.forexcrunch.forexcrunch.model;

import android.content.Context;
import com.forexcrunch.forexcrunch.C0089R;
import java.util.ArrayList;

public class DropDownIconItem {
    private int iconActivatedResId;
    private int iconResId;
    private String name;

    public DropDownIconItem(int iconResId2, int iconActivatedResId2, String name2) {
        this.iconResId = iconResId2;
        this.iconActivatedResId = iconActivatedResId2;
        this.name = name2;
    }

    public int getIconResId() {
        return this.iconResId;
    }

    public void setIconResId(int iconResId2) {
        this.iconResId = iconResId2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public static ArrayList<DropDownIconItem> createCalendarDropDownList(Context ctx) {
        ArrayList<DropDownIconItem> list = new ArrayList<>();
        list.add(new DropDownIconItem(C0089R.drawable.recentoff, C0089R.drawable.recenton, ctx.getResources().getString(C0089R.string.recent_title)));
        list.add(new DropDownIconItem(C0089R.drawable.todayoff, C0089R.drawable.todayon, ctx.getResources().getString(C0089R.string.today)));
        list.add(new DropDownIconItem(C0089R.drawable.tomorrowoff, C0089R.drawable.tomorrowon, ctx.getResources().getString(C0089R.string.tomorrow)));
        list.add(new DropDownIconItem(C0089R.drawable.thisweekoff, C0089R.drawable.thisweekon, ctx.getResources().getString(C0089R.string.this_week)));
        list.add(new DropDownIconItem(C0089R.drawable.nextweekoff, C0089R.drawable.nextweekon, ctx.getResources().getString(C0089R.string.next_week)));
        list.add(new DropDownIconItem(C0089R.drawable.customoff, C0089R.drawable.customon, ctx.getResources().getString(C0089R.string.custom)));
        return list;
    }

    public static ArrayList<DropDownIconItem> createSavedDropDownList(Context ctx) {
        ArrayList<DropDownIconItem> list = new ArrayList<>();
        list.add(new DropDownIconItem(C0089R.drawable.daily_svd_art, C0089R.drawable.dailyon_svd_art, ctx.getResources().getString(C0089R.string.menu_daily)));
        list.add(new DropDownIconItem(C0089R.drawable.week_svd_art, C0089R.drawable.weekon_svd_art, ctx.getResources().getString(C0089R.string.menu_weekly)));
        list.add(new DropDownIconItem(C0089R.drawable.news_svd_art, C0089R.drawable.newson_svd_art, ctx.getResources().getString(C0089R.string.menu_news)));
        list.add(new DropDownIconItem(C0089R.drawable.opinion_svd_art, C0089R.drawable.opinionon_svd_art, ctx.getResources().getString(C0089R.string.opinions)));
        list.add(new DropDownIconItem(C0089R.drawable.major_svd_art, C0089R.drawable.majoron_svd_art, ctx.getResources().getString(C0089R.string.major)));
        list.add(new DropDownIconItem(C0089R.drawable.major_svd_art, C0089R.drawable.majoron_svd_art, ctx.getResources().getString(C0089R.string.minor)));
        list.add(new DropDownIconItem(C0089R.drawable.major_svd_art, C0089R.drawable.majoron_svd_art, ctx.getResources().getString(C0089R.string.basic)));
        return list;
    }

    public int getIconActivatedResId() {
        return this.iconActivatedResId;
    }

    public void setIconActivatedResId(int iconActivatedResId2) {
        this.iconActivatedResId = iconActivatedResId2;
    }
}
