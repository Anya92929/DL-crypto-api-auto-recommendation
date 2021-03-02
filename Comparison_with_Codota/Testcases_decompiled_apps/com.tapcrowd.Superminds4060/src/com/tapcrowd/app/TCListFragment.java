package com.tapcrowd.app;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockListFragment;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.tcanalytics.TCAnalytics;

public class TCListFragment extends SherlockListFragment {
    public String analytics = "";
    public int contentid;
    private String path;
    protected boolean retained;
    public int selectedindex = -1;
    private boolean show = true;
    protected String title;

    /* renamed from: v */
    protected View f2007v;

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("analytics", this.analytics);
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            getView().findViewById(C0846R.C0847id.title).setVisibility(8);
        } catch (Exception e) {
        }
        if (savedInstanceState != null) {
            this.analytics = savedInstanceState.getString("analytics");
        }
        String color = Integer.toHexString(C1216LO.getLo(C1216LO.navigationColor));
        if (color.length() == 8) {
            color = color.substring(2);
        }
        ActionBar ab = getSherlockActivity().getSupportActionBar();
        if ((App.tablet || ((BitmapDrawable) C1216LO.getLoDrawable(C1216LO.navbarTitleImage)) == null) && this.title == null) {
            this.title = C1199DB.getFirstObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT).get(DBFavorites.KEY_NAME).toUpperCase();
        }
        if (this.title != null) {
            ab.setBackgroundDrawable(new ColorDrawable(C1216LO.getLo(C1216LO.navbarColor)));
            ab.setDisplayShowTitleEnabled(true);
            ab.setTitle((CharSequence) Html.fromHtml("<font color='#" + color + "'>" + this.title.toUpperCase() + "</font>"));
        } else {
            Bitmap bg = C1216LO.getNavbarBackground(getActivity());
            int height = bg.getHeight();
            Bitmap result = Bitmap.createBitmap(bg.getWidth(), height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(result);
            canvas.drawBitmap(bg, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (Paint) null);
            Bitmap logo = ((BitmapDrawable) C1216LO.getLoDrawable(C1216LO.navbarTitleImage)).getBitmap();
            Bitmap scaled = Bitmap.createScaledBitmap(logo, (int) (((double) logo.getWidth()) * (((double) height) / ((double) logo.getHeight()))), height, true);
            canvas.drawBitmap(scaled, (float) ((canvas.getWidth() - scaled.getWidth()) / 2), BitmapDescriptorFactory.HUE_RED, (Paint) null);
            ab.setBackgroundDrawable(new BitmapDrawable(getResources(), result));
            ab.setDisplayShowTitleEnabled(false);
        }
        if (App.tablet) {
            if (C1216LO.getLoDrawable(C1216LO.navbarTablets) != null) {
                ab.setBackgroundDrawable(C1216LO.getLoDrawable(C1216LO.navbarTablets));
            }
            ab.setTitle((CharSequence) Html.fromHtml("<font color='#" + color + "'>" + C1199DB.getFirstObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT).get(DBFavorites.KEY_NAME).toUpperCase() + (this.title == null ? "" : " > " + this.title) + "</font>"));
        }
        if (App.tablet) {
            return;
        }
        if (this.show) {
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setDisplayShowHomeEnabled(true);
            return;
        }
        ab.setDisplayHomeAsUpEnabled(false);
        ab.setDisplayShowHomeEnabled(false);
    }

    public void onResume() {
        super.onResume();
        if (this.path != null) {
            TCAnalytics.log(getActivity(), this.path, "");
        }
    }

    public void onStart() {
        super.onStart();
        C1232UI.setFont((ViewGroup) getView());
    }

    public String getResourceString(int id) {
        if (isAdded()) {
            return getString(id);
        }
        return "";
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setShowHomebutton(boolean show2) {
        this.show = show2;
    }

    public void setPath(String path2) {
        this.path = path2;
    }
}
