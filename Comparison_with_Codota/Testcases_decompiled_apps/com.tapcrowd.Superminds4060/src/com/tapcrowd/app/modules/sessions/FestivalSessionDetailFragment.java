package com.tapcrowd.app.modules.sessions;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.NotificationToSessionDetail;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.map.MapFragment;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.utils.Actions;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.Notifications;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import com.tapcrowd.app.views.Cell;
import com.tapcrowd.tcanalytics.TCAnalytics;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.apache.cordova.Globalization;

public class FestivalSessionDetailFragment extends TCFragment implements MenuFragment.MenuItemListener {
    private int STAR = 134;
    /* access modifiers changed from: private */

    /* renamed from: fb */
    public String f2108fb;

    /* renamed from: id */
    private String f2109id;
    private MenuFragment menu;
    public View.OnClickListener sesfb = new View.OnClickListener() {
        public void onClick(View v) {
            if (FestivalSessionDetailFragment.this.f2108fb != null) {
                Actions.openWebview(FestivalSessionDetailFragment.this, FestivalSessionDetailFragment.this.f2108fb);
            }
        }
    };
    /* access modifiers changed from: private */
    public TCObject session;
    public View.OnClickListener sestwit = new View.OnClickListener() {
        public void onClick(View v) {
            if (FestivalSessionDetailFragment.this.twit != null) {
                Actions.openWebview(FestivalSessionDetailFragment.this, FestivalSessionDetailFragment.this.twit);
            }
        }
    };
    public View.OnClickListener sesweb = new View.OnClickListener() {
        public void onClick(View v) {
            if (FestivalSessionDetailFragment.this.url != null) {
                Actions.openWebview(FestivalSessionDetailFragment.this, FestivalSessionDetailFragment.this.url);
            }
        }
    };
    public View.OnClickListener sesyt = new View.OnClickListener() {
        public void onClick(View v) {
            if (FestivalSessionDetailFragment.this.f2111yt != null) {
                Actions.openWebview(FestivalSessionDetailFragment.this, FestivalSessionDetailFragment.this.f2111yt);
            }
        }
    };
    /* access modifiers changed from: private */
    public String twit;
    /* access modifiers changed from: private */
    public String url;

    /* renamed from: v */
    private View f2110v;
    /* access modifiers changed from: private */

    /* renamed from: yt */
    public String f2111yt;

    public static FestivalSessionDetailFragment newInstance(String sessionid) {
        FestivalSessionDetailFragment detail = new FestivalSessionDetailFragment();
        detail.session = C1199DB.getObject("sessions", DBFavorites.KEY_EVENT_ID, sessionid);
        detail.f2109id = sessionid;
        return detail;
    }

    public void onResume() {
        super.onResume();
        if (this.session.has("loggingpath")) {
            TCAnalytics.log(getActivity(), this.session.get("loggingpath"), "");
        }
        if (C1199DB.getSize("launchers", "moduletypeid", "11") != 0) {
            if (C1199DB.getSize("favorites", "sessionid", this.f2109id) > 0) {
                this.menu.editIcon(this.STAR, C1232UI.getColorOverlay((int) C0846R.drawable.star, -256));
            } else {
                this.menu.editIcon(this.STAR, C1232UI.getColorOverlay((int) C0846R.drawable.star, C1216LO.getLo(C1216LO.navigationColor)));
            }
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.f2109id);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Cell c;
        this.f2110v = inflater.inflate(C0846R.layout.artistdetail, container, false);
        if (savedInstanceState != null && this.session == null) {
            this.f2109id = savedInstanceState.getString(DBFavorites.KEY_EVENT_ID);
            this.session = C1199DB.getObject("sessions", DBFavorites.KEY_EVENT_ID, this.f2109id);
        }
        findViewById(C0846R.C0847id.header).setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
        TextView name = (TextView) findViewById(C0846R.C0847id.name);
        name.setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        name.setText(this.session.get(DBFavorites.KEY_NAME, "").toUpperCase());
        TextView date = (TextView) findViewById(C0846R.C0847id.date);
        date.setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        date.setText(this.session.get(Globalization.DATE, ""));
        TextView time = (TextView) findViewById(C0846R.C0847id.time);
        time.setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        time.setText(String.valueOf(this.session.get("starttime", "")) + " - " + this.session.get("endtime", ""));
        C1232UI.setOverlay(C0846R.C0847id.sesfb, C0846R.drawable.sesfb, -7829368, this.f2110v);
        C1232UI.setOverlay(C0846R.C0847id.sesweb, C0846R.drawable.sesweb, -7829368, this.f2110v);
        C1232UI.setOverlay(C0846R.C0847id.sesyt, C0846R.drawable.sesyt, -7829368, this.f2110v);
        C1232UI.setOverlay(C0846R.C0847id.sestwit, C0846R.drawable.sestwit, -7829368, this.f2110v);
        findViewById(C0846R.C0847id.sesfb).setOnClickListener(this.sesfb);
        findViewById(C0846R.C0847id.sesweb).setOnClickListener(this.sesweb);
        findViewById(C0846R.C0847id.sesyt).setOnClickListener(this.sesyt);
        findViewById(C0846R.C0847id.sestwit).setOnClickListener(this.sestwit);
        C1232UI.getColorOverlay((int) C0846R.drawable.star, C1216LO.getLo(C1216LO.navigationColor));
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        if (C1199DB.getSize("launchers", "moduletypeid", "11") > 0) {
            menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.star, C1216LO.getLo(C1216LO.navigationColor)), this.STAR));
        }
        this.menu = MenuFragment.newInstance(menuitems, this);
        Fragments.addMenu(this, this.menu);
        ((ImageView) findViewById(C0846R.C0847id.icon)).setImageDrawable(C1216LO.getLoDrawable(C1216LO.artistImagePlaceholder));
        if (this.session.has("imageurl") && this.session.get("imageurl").length() > 0) {
            new FastImageLoader().DisplayImage(this.session.get("imageurl"), (ImageView) findViewById(C0846R.C0847id.icon));
        }
        C1232UI.setText((int) C0846R.C0847id.description, this.session.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION), this.f2110v);
        if (this.session.has("location")) {
            if (!this.session.has("xpos") || Float.parseFloat(this.session.get("xpos")) == BitmapDescriptorFactory.HUE_RED) {
                c = C1232UI.addCell2(this.f2110v, this.session.get("location", ""), (View.OnClickListener) null, C1232UI.getColorOverlay((int) C0846R.drawable.icon_navigate_white, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
            } else {
                c = C1232UI.addCell2(this.f2110v, this.session.get("location", ""), new View.OnClickListener() {
                    public void onClick(View v) {
                        Fragments.add(FestivalSessionDetailFragment.this, MapFragment.newInstance(FestivalSessionDetailFragment.this.session.get("mapid"), (float) ((int) Double.parseDouble(FestivalSessionDetailFragment.this.session.get("xpos"))), (float) ((int) Double.parseDouble(FestivalSessionDetailFragment.this.session.get("ypos")))), FestivalSessionDetailFragment.this.session.get("location"));
                    }
                }, C1232UI.getColorOverlay((int) C0846R.drawable.icon_navigate_white, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
            }
            c.setBackgroundDrawable(C1232UI.getBackground());
        }
        for (TCObject meta : C1199DB.getListFromDb("metadata", "identifier", this.f2109id)) {
            if (meta.get("value") != null) {
                if (meta.get("key").equals("facebook")) {
                    C1232UI.setOverlay(C0846R.C0847id.sesfb, C0846R.drawable.sesfb, C1216LO.getLo(C1216LO.textcolor), this.f2110v);
                    this.f2108fb = meta.get("value");
                } else if (meta.get("key").equals("youtube")) {
                    C1232UI.setOverlay(C0846R.C0847id.sesyt, C0846R.drawable.sesyt, C1216LO.getLo(C1216LO.textcolor), this.f2110v);
                    this.f2111yt = meta.get("value");
                } else if (meta.get("key").equals("twitter")) {
                    C1232UI.setOverlay(C0846R.C0847id.sestwit, C0846R.drawable.sestwit, C1216LO.getLo(C1216LO.textcolor), this.f2110v);
                    this.twit = meta.get("value");
                }
            }
        }
        if (this.session.has(PlusShare.KEY_CALL_TO_ACTION_URL)) {
            C1232UI.setOverlay(C0846R.C0847id.sesweb, C0846R.drawable.sesweb, C1216LO.getLo(C1216LO.textcolor), this.f2110v);
            this.url = this.session.get(PlusShare.KEY_CALL_TO_ACTION_URL);
        }
        if (this.session.has("twitter")) {
            C1232UI.setOverlay(C0846R.C0847id.sestwit, C0846R.drawable.sestwit, C1216LO.getLo(C1216LO.textcolor), this.f2110v);
            this.twit = this.session.get("twitter");
        }
        return this.f2110v;
    }

    public View findViewById(int id) {
        return this.f2110v.findViewById(id);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void click(MenuItem item) {
        if (item.getItemId() == 134) {
            addToFavorites();
        }
    }

    private void addToFavorites() {
        Intent intent = new Intent(getActivity(), NotificationToSessionDetail.class);
        intent.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, getString(C0846R.string.detail));
        intent.putExtra(DBFavorites.KEY_EVENT_ID, this.f2109id);
        String datum = this.session.get(DBFavorites.KEY_SESSION_STARTDATE);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
        Date parsed = new Date();
        try {
            parsed = format.parse(datum);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parsed);
        calendar.add(12, -15);
        if (C1199DB.getSize("favorites", "sessionid", this.f2109id) > 0) {
            Notifications.cancelNotification(intent, this.f2109id, this.session.get(DBFavorites.KEY_NAME), "Starts in 15 minutes.", C0846R.drawable.icon, calendar.getTimeInMillis());
            this.menu.editIcon(this.STAR, C1232UI.getColorOverlay((int) C0846R.drawable.star, C1216LO.getLo(C1216LO.navigationColor)));
            C1199DB.remove("favorites", "sessionid", this.f2109id);
            return;
        }
        if (calendar.getTimeInMillis() > System.currentTimeMillis()) {
            Notifications.createNotification(getActivity(), intent, this.f2109id, this.session.get(DBFavorites.KEY_NAME), "Starts in 15 minutes.", C0846R.drawable.icon, calendar.getTimeInMillis());
        }
        this.menu.editIcon(this.STAR, C1232UI.getColorOverlay((int) C0846R.drawable.star, -256));
        C1199DB.write("favorites", "sessionid", this.f2109id);
        new AlertDialog.Builder(getActivity()).setMessage(getString(C0846R.string.favo_added)).setPositiveButton(C0846R.string.favo_pos, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        }).setNegativeButton(C0846R.string.favo_show, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                Fragments.add(FestivalSessionDetailFragment.this, FestivalFavoritesFragment.newInstance(), C1199DB.getFirstObject("launchers", "moduletypeid", "11").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
            }
        }).show();
    }
}
