package com.tapcrowd.app.modules.launcher;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.view.PagerAdapter;
import android.support.p000v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.modules.sessions.FestivalSessionDetailFragment;
import com.tapcrowd.app.modules.sessions.SessionDetailFragment;
import com.tapcrowd.app.modules.settings.SettingsFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.Internet;
import com.tapcrowd.app.utils.LauncherUtil;
import com.tapcrowd.app.utils.TCLauncherItem;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.UserModule;
import com.tapcrowd.app.utils.images.FastImageLoader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.cordova.Globalization;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class TCLauncherPhoneFragment extends TCFragment implements ViewPager.OnPageChangeListener, MenuFragment.MenuItemListener {
    private final int SETTINGS = 1456;
    FastImageLoader fil = new FastImageLoader();
    List<TCObject> list;
    int numRows = 3;
    boolean root;
    String sessionid;
    private View.OnClickListener switchtab = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case C0846R.C0847id.pager_tab:
                    C1232UI.show(C0846R.C0847id.viewerpager, TCLauncherPhoneFragment.this.f2062v);
                    C1232UI.hide(C0846R.C0847id.list, TCLauncherPhoneFragment.this.f2062v);
                    TCLauncherPhoneFragment.this.f2062v.findViewById(C0846R.C0847id.event_tab).setBackgroundResource(C0846R.drawable.tab2unsel);
                    TCLauncherPhoneFragment.this.f2062v.findViewById(C0846R.C0847id.pager_tab).setBackgroundResource(C0846R.drawable.tab1sel);
                    return;
                case C0846R.C0847id.event_tab:
                    C1232UI.hide(C0846R.C0847id.viewerpager, TCLauncherPhoneFragment.this.f2062v);
                    C1232UI.show(C0846R.C0847id.list, TCLauncherPhoneFragment.this.f2062v);
                    TCLauncherPhoneFragment.this.f2062v.findViewById(C0846R.C0847id.event_tab).setBackgroundResource(C0846R.drawable.tab2sel);
                    TCLauncherPhoneFragment.this.f2062v.findViewById(C0846R.C0847id.pager_tab).setBackgroundResource(C0846R.drawable.tab1unsel);
                    return;
                default:
                    return;
            }
        }
    };
    List<TCLauncherItem> tabs = new ArrayList();
    String type;
    String typeid;

    /* renamed from: v */
    View f2062v;

    public static TCLauncherPhoneFragment newInstance(String type2, String typeid2) {
        TCLauncherPhoneFragment launcher = new TCLauncherPhoneFragment();
        launcher.type = type2;
        launcher.typeid = typeid2;
        return launcher;
    }

    public static TCLauncherPhoneFragment newInstance(String type2, String typeid2, boolean root2) {
        TCLauncherPhoneFragment launcher = new TCLauncherPhoneFragment();
        launcher.type = type2;
        launcher.typeid = typeid2;
        launcher.root = root2;
        return launcher;
    }

    public static TCLauncherPhoneFragment newInstance(String type2, String typeid2, String sessionid2, boolean root2) {
        TCLauncherPhoneFragment launcher = new TCLauncherPhoneFragment();
        launcher.type = type2;
        launcher.typeid = typeid2;
        launcher.sessionid = sessionid2;
        launcher.root = root2;
        return launcher;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Globalization.TYPE, this.type);
        outState.putString("typeid", this.typeid);
        outState.putString("sessionid", this.sessionid);
        outState.putBoolean("root", this.root);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f2062v = inflater.inflate(C0846R.layout.viewpager, (ViewGroup) null);
        if (savedInstanceState != null && this.type == null) {
            this.type = savedInstanceState.getString(Globalization.TYPE);
            this.typeid = savedInstanceState.getString("typeid");
            this.sessionid = savedInstanceState.getString("sessionid");
            this.root = savedInstanceState.getBoolean("root");
        }
        this.f2062v.findViewById(C0846R.C0847id.tabs).setVisibility(0);
        if (this.root) {
            setShowHomebutton(false);
        }
        if (C1199DB.isNull()) {
            C1199DB.openDataBase();
        }
        int windowheight = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        if (C1199DB.getSize("ad") > 0) {
            windowheight = (int) (((float) windowheight) - Converter.convertDpToPixel(55.0f, getActivity()));
        }
        int windowheight2 = (int) (((float) windowheight) - Converter.convertDpToPixel(60.0f, getActivity()));
        int celheight = (int) Converter.convertDpToPixel(125.0f, getActivity());
        this.numRows = 0;
        while (windowheight2 > celheight) {
            windowheight2 -= celheight;
            this.numRows++;
        }
        return this.f2062v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (this.sessionid != null) {
            if (App.typeid.equals("10")) {
                Fragments.add(this, FestivalSessionDetailFragment.newInstance(this.sessionid), getString(C0846R.string.detail));
            } else {
                Fragments.add(this, SessionDetailFragment.newInstance(this.sessionid), getString(C0846R.string.detail));
            }
        }
        this.sessionid = null;
        setupMenu();
        AdHelper.showAds(this, "");
        fill();
        if (!App.typeid.equals("1") || !this.type.equals("venueid")) {
            this.f2062v.findViewById(C0846R.C0847id.tabs).setVisibility(8);
        } else {
            setUpVenueTabs();
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void setupMenu() {
        if (C1199DB.getSize("languages") > 1 || C1199DB.getSize("launchers", "moduletypeid", "49") > 0) {
            ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
            menuitems.add(new MenuFragment.MenuItemContainer(getString(C0846R.string.settings), 1456));
            Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
        }
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 1456:
                Fragments.add(this, SettingsFragment.newInstance(), getString(C0846R.string.settings));
                return;
            default:
                return;
        }
    }

    public void setUpVenueTabs() {
        this.f2062v.findViewById(C0846R.C0847id.tabs).setVisibility(0);
        this.f2062v.findViewById(C0846R.C0847id.event_tab).setOnClickListener(this.switchtab);
        this.f2062v.findViewById(C0846R.C0847id.pager_tab).setOnClickListener(this.switchtab);
        final List<Object> listitems = new ArrayList<>();
        Date d = new Date();
        String dnow = (d.getYear() + 1900) + "-";
        if (d.getMonth() + 1 < 10) {
            dnow = String.valueOf(dnow) + "0";
        }
        String dnow2 = String.valueOf(dnow) + (d.getMonth() + 1) + "-";
        if (d.getDate() < 10) {
            dnow2 = String.valueOf(dnow2) + "0";
        }
        String dnow3 = String.valueOf(dnow2) + d.getDate();
        List<TCObject> now = C1199DB.getQueryFromDb("select * from events where datefrom <= '" + dnow3 + "' AND dateto >= '" + dnow3 + "' AND appid == " + App.f2123id + " ORDER BY order_value +0 DESC, datefrom ASC, dateto ASC");
        List<TCObject> futur = C1199DB.getQueryFromDb("select * from events where datefrom > '" + dnow3 + "' AND appid == " + App.f2123id + " ORDER BY order_value +0 DESC, datefrom ASC");
        List<TCObject> past = C1199DB.getQueryFromDb("select * from events where dateto < '" + dnow3 + "' AND datefrom != '1970-01-01' AND appid == " + App.f2123id + " ORDER BY order_value +0 DESC");
        List<TCObject> ongoing = C1199DB.getQueryFromDb("select * from events where datefrom == '1970-01-01' AND appid == " + App.f2123id + " ORDER BY order_value +0 DESC");
        if (now.size() > 0) {
            listitems.add(getString(C0846R.string.eventsnow));
            for (TCObject tco : now) {
                String logo = "";
                if (tco.has("eventlogo")) {
                    logo = tco.get("eventlogo");
                }
                listitems.add(new TCListObject(tco.get(DBFavorites.KEY_EVENT_ID), tco.get(DBFavorites.KEY_NAME), Converter.datesToString(tco.get("datefrom"), tco.get("dateto")), "", logo));
            }
        }
        if (ongoing.size() > 0) {
            listitems.add(getString(C0846R.string.permanentevents));
            for (TCObject tco2 : ongoing) {
                String logo2 = "";
                if (tco2.has("eventlogo")) {
                    logo2 = tco2.get("eventlogo");
                }
                listitems.add(new TCListObject(tco2.get(DBFavorites.KEY_EVENT_ID), tco2.get(DBFavorites.KEY_NAME), getString(C0846R.string.permanent), "", logo2));
            }
        }
        if (futur.size() > 0) {
            listitems.add(getString(C0846R.string.futurevents));
            for (TCObject tco3 : futur) {
                String logo3 = "";
                if (tco3.has("eventlogo")) {
                    logo3 = tco3.get("eventlogo");
                }
                listitems.add(new TCListObject(tco3.get(DBFavorites.KEY_EVENT_ID), tco3.get(DBFavorites.KEY_NAME), Converter.datesToString(tco3.get("datefrom"), tco3.get("dateto")), "", logo3));
            }
        }
        if (past.size() > 0) {
            listitems.add(getString(C0846R.string.pastevents));
            for (TCObject tco4 : past) {
                String logo4 = "";
                if (tco4.has("eventlogo")) {
                    logo4 = tco4.get("eventlogo");
                }
                listitems.add(new TCListObject(tco4.get(DBFavorites.KEY_EVENT_ID), tco4.get(DBFavorites.KEY_NAME), Converter.datesToString(tco4.get("datefrom"), tco4.get("dateto")), (String) null, logo4));
            }
        }
        ((ListView) this.f2062v.findViewById(C0846R.C0847id.list)).setAdapter(new TCListObject.TCListObjectAdapter(listitems, C0846R.drawable.l_def_events));
        ((ListView) this.f2062v.findViewById(C0846R.C0847id.list)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {
                Object o = listitems.get(arg2);
                if (o.getClass() == TCListObject.class) {
                    TCListObject tlo = (TCListObject) o;
                    App.curEventId = tlo.getId();
                    new LoadDataTask(tlo.getId()).execute(new Void[0]);
                }
            }
        });
    }

    public class LoadDataTask extends AsyncTask<Void, Void, Boolean> {
        private ProgressDialog dialog = new ProgressDialog(App.act);
        String eventid;

        public LoadDataTask(String eventid2) {
            this.eventid = eventid2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.dialog = ProgressDialog.show(App.act, C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get(DBFavorites.KEY_NAME), TCLauncherPhoneFragment.this.getResourceString(C0846R.string.loading), false, true);
            this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialog) {
                    LoadDataTask.this.cancel(true);
                }
            });
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(Void... args) {
            List<NameValuePair> postparams = new ArrayList<>();
            postparams.add(new BasicNameValuePair("appid", App.f2123id));
            postparams.add(new BasicNameValuePair("eventid", this.eventid));
            postparams.add(new BasicNameValuePair("bundleid", App.act.getPackageName()));
            C1199DB.jsonToDB(Internet.request("getEvent", postparams), "eventid == " + this.eventid);
            List<TCObject> maps = C1199DB.getListFromDb("map", "eventid", this.eventid);
            FastImageLoader fil = new FastImageLoader();
            for (TCObject to : maps) {
                fil.downloadIfNotExists(to.get("imageurl"));
            }
            return true;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean result) {
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
                TCLauncherPhoneFragment.this.startNextActivity(this.eventid);
            }
        }
    }

    /* access modifiers changed from: private */
    public void startNextActivity(String eventid) {
        if (C1199DB.getSize("launchers", "eventid", eventid) > 0) {
            List<TCObject> launchers = C1199DB.getListFromDb("launchers", "eventid", eventid);
            if (App.tablet || launchers.size() == 1) {
                for (TCObject launcher : launchers) {
                    if (LauncherUtil.hasFragment(launcher)) {
                        Fragments.add(this, LauncherUtil.getFragment(launcher), launcher.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                    }
                }
            } else if (launchers.size() > 1) {
                Fragments.add(this, newInstance("eventid", eventid), C1199DB.getFirstObject("event", DBFavorites.KEY_EVENT_ID, eventid).get(DBFavorites.KEY_NAME));
            }
        }
    }

    public void onResume() {
        super.onResume();
        if ((this.list.size() != C1199DB.getSize("launchers", this.type, this.typeid) || (C1199DB.getSize("launchers", "moduletypeid", "64") > 0 && UserModule.isLoggedIn(getActivity()))) && UserModule.getUserId(getActivity()) != null) {
            fill();
        }
    }

    public void fill() {
        if (C1216LO.launcherBackground == 0) {
            getView().findViewById(C0846R.C0847id.screen).setBackgroundColor(C1216LO.getLo(C1216LO.launcherBackgroundColor));
        } else {
            this.fil.getBitmap(C1216LO.getLoUrl(C1216LO.launcherBackground), new FastImageLoader.LoadBitmapListener() {
                public void bitmapLoaded(Bitmap bitmap) {
                    TCLauncherPhoneFragment.this.f2062v.findViewById(C0846R.C0847id.screen).setBackgroundDrawable(new BitmapDrawable(bitmap));
                }
            });
        }
        double numlaunchers = (double) C1199DB.getSize("launchers", this.type, this.typeid);
        this.list = C1199DB.getListFromDb("launchers", this.type, this.typeid, "order_value +0");
        for (TCObject item : this.list) {
            if (!LauncherUtil.hasFragment(item)) {
                numlaunchers -= 1.0d;
            }
        }
        double pages = numlaunchers / ((double) (this.numRows * 3));
        long rest = Long.parseLong(new StringBuilder().append(pages).toString().split("\\.")[1]);
        double pages2 = (double) ((int) pages);
        if (rest > 0) {
            pages2 += 1.0d;
        }
        getView().findViewById(C0846R.C0847id.header).setVisibility(8);
        ViewPagerAdapter vpadapter = new ViewPagerAdapter((int) pages2, getActivity(), this.type, this.typeid);
        ViewPager vpager = (ViewPager) getView().findViewById(C0846R.C0847id.viewerpager);
        vpager.setAdapter(vpadapter);
        vpager.setOnPageChangeListener(this);
        LinearLayout markers = (LinearLayout) getView().findViewById(C0846R.C0847id.pager);
        markers.removeAllViews();
        if (pages2 > 1.0d) {
            C1232UI.getColorOverlay((int) C0846R.drawable.viewpager_marker_active, C1216LO.getLo(C1216LO.launcherTextColor));
            C1232UI.getColorOverlay((int) C0846R.drawable.viewpager_marker_inactive, C1216LO.getLo(C1216LO.launcherTextColor));
            int i = 0;
            while (((double) i) < pages2) {
                ImageView iv = new ImageView(getActivity());
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-2, -2);
                lp.leftMargin = 2;
                lp.rightMargin = 2;
                iv.setLayoutParams(lp);
                iv.setBackgroundDrawable(getResources().getDrawable(i == 0 ? C0846R.drawable.viewpager_marker_active : C0846R.drawable.viewpager_marker_inactive));
                markers.addView(iv);
                i++;
            }
        }
    }

    public class ViewPagerAdapter extends PagerAdapter {
        private Context context;
        private int pages;
        String type;
        String typeid;

        public ViewPagerAdapter(int pages2, Context context2, String type2, String typeid2) {
            this.pages = pages2;
            this.context = context2;
            this.type = type2;
            this.typeid = typeid2;
        }

        public int getCount() {
            return this.pages;
        }

        public Object instantiateItem(View collection, int position) {
            View view = ((Activity) this.context).getLayoutInflater().inflate(C0846R.layout.tclauncher, (ViewGroup) null);
            TCLauncherPhoneFragment.this.fillLauncher(position, this.type, this.typeid);
            ((GridView) view.findViewById(C0846R.C0847id.grid)).setAdapter(new TCLauncherAdapter(this.context));
            ((ViewPager) collection).addView(view);
            return view;
        }

        public void destroyItem(View collection, int position, Object object) {
            ((ViewPager) collection).removeView((View) object);
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isViewFromObject(android.view.View r3, java.lang.Object r4) {
            /*
                r2 = this;
                r0 = r4
                android.view.View r0 = (android.view.View) r0
                if (r3 != r0) goto L_0x0007
                r1 = 1
            L_0x0006:
                return r1
            L_0x0007:
                r1 = 0
                goto L_0x0006
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapcrowd.app.modules.launcher.TCLauncherPhoneFragment.ViewPagerAdapter.isViewFromObject(android.view.View, java.lang.Object):boolean");
        }

        public void finishUpdate(View arg0) {
        }

        public Parcelable saveState() {
            return null;
        }

        public void startUpdate(View arg0) {
        }

        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }
    }

    private class TCLauncherAdapter extends ArrayAdapter<TCLauncherItem> {
        Context context;

        public TCLauncherAdapter(Context context2) {
            super(context2, 0, TCLauncherPhoneFragment.this.tabs);
            this.context = context2;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = ((Activity) this.context).getLayoutInflater();
            final TCLauncherItem t = (TCLauncherItem) getItem(position);
            View rowView = inflater.inflate(C0846R.layout.cell_launcher, (ViewGroup) null);
            if (t.getIconurl() == null || t.getIconurl().equals("")) {
                ((ImageView) rowView.findViewById(C0846R.C0847id.icon)).setImageResource(t.defaulticon);
            } else {
                TCLauncherPhoneFragment.this.fil.DisplayImage(t.getIconurl(), (ImageView) rowView.findViewById(C0846R.C0847id.icon));
            }
            TextView noticountTv = (TextView) rowView.findViewById(C0846R.C0847id.number);
            if (t.getNoticount() > 0) {
                noticountTv.setText(new StringBuilder(String.valueOf(t.getNoticount())).toString());
                noticountTv.setVisibility(0);
            } else {
                noticountTv.setVisibility(8);
            }
            TextView tv = (TextView) rowView.findViewById(C0846R.C0847id.text);
            tv.setText(t.getText());
            TCObject textcolor = C1199DB.getObject("appearance", "controlname", C1216LO.launcherTextColor);
            if (textcolor.has("controlname")) {
                tv.setTextColor(Color.parseColor("#" + textcolor.get("value")));
            }
            rowView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    try {
                        if (UserModule.doLogin(TCLauncherPhoneFragment.this.getActivity(), t.getId())) {
                            new UserModule.LoginDialog(TCLauncherPhoneFragment.this.getActivity(), TCLauncherPhoneFragment.this, t).show();
                        } else {
                            Fragments.add(TCLauncherPhoneFragment.this, t.fragment, t.getText());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            return rowView;
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public boolean isEnabled(int position) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void fillLauncher(int page, String type2, String typeid2) {
        this.tabs = new ArrayList();
        List<TCObject> list2 = C1199DB.getListFromDb("launchers", type2, typeid2, "order_value +0 ASC");
        List<TCObject> toRemove = new ArrayList<>();
        for (TCObject item : list2) {
            if (!LauncherUtil.hasFragment(item)) {
                toRemove.add(item);
            }
        }
        for (TCObject remove : toRemove) {
            list2.remove(remove);
        }
        int i = page * this.numRows * 3;
        while (i < list2.size() && i < (page + 1) * this.numRows * 3) {
            TCObject tco = list2.get(i);
            Fragment fragment = LauncherUtil.getFragment(tco);
            if (App.typeid.equals("7") || App.typeid.equals("8")) {
                if (fragment instanceof TCFragment) {
                    TCFragment tCFragment = (TCFragment) fragment;
                    tCFragment.analytics = String.valueOf(tCFragment.analytics) + "/venue/" + typeid2;
                }
                if (fragment instanceof TCListFragment) {
                    TCListFragment tCListFragment = (TCListFragment) fragment;
                    tCListFragment.analytics = String.valueOf(tCListFragment.analytics) + "/venue/" + typeid2;
                }
            }
            int noticount = 0;
            if (tco.get("moduletypeid").equals("65") && UserModule.isLoggedIn(getActivity())) {
                noticount = C1199DB.getSize("push", "read", "0");
                if (UserModule.getUserId(getActivity()) != null) {
                    noticount += C1199DB.getSize("messages", "deleted == '0' AND userid == '" + UserModule.getUserId(getActivity()) + "' AND read", "0");
                }
            }
            if (fragment != null) {
                String url = "";
                int resid = C0846R.drawable.icon;
                if (tco.get(C1216LO.icon) != null) {
                    String u = tco.get(C1216LO.icon);
                    if (u.contains("http://")) {
                        url = u;
                    } else if (u.contains("upload")) {
                        url = "http://upload.tapcrowd.com/" + u;
                    } else {
                        try {
                            resid = getResources().getIdentifier(u, "drawable", "com.tapcrowd.app");
                        } catch (Exception e) {
                        }
                    }
                }
                this.tabs.add(new TCLauncherItem(tco.get(DBFavorites.KEY_EVENT_ID), tco.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE), url, resid, fragment, noticount));
            }
            i++;
        }
    }

    public void onPageScrollStateChanged(int arg0) {
    }

    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    public void onPageSelected(int position) {
        LinearLayout markers = (LinearLayout) getView().findViewById(C0846R.C0847id.pager);
        int i = 0;
        int len = markers.getChildCount();
        while (i < len) {
            ((ImageView) markers.getChildAt(i)).setBackgroundDrawable(getResources().getDrawable(i == position ? C0846R.drawable.viewpager_marker_active : C0846R.drawable.viewpager_marker_inactive));
            i++;
        }
    }
}
