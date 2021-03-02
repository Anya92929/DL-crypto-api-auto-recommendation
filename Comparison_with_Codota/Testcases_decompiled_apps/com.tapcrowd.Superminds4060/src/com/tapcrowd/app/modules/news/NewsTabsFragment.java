package com.tapcrowd.app.modules.news;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.FBFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.modules.webview.WebViewFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1204FB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.Internet;
import com.tapcrowd.app.utils.TCListObject2;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.cordova.Globalization;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

public class NewsTabsFragment extends FBFragment implements TabHost.OnTabChangeListener, MenuFragment.MenuItemListener {
    final int REFRESH = 42;
    final int SHARE = 53;
    LayoutInflater inflater;
    MenuFragment menu;
    TCObject social;
    TabHost tabHost;
    String tabid;
    String type = "";
    String typeid = "";

    /* renamed from: v */
    View f2087v;

    public static NewsTabsFragment newInstance(String table, String tableid) {
        NewsTabsFragment detail = new NewsTabsFragment();
        detail.type = table;
        detail.typeid = tableid;
        return detail;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Globalization.TYPE, this.type);
        outState.putString("typeid", this.typeid);
    }

    public void onResume() {
        super.onResume();
    }

    public View onCreateView(LayoutInflater inflater2, ViewGroup container, Bundle savedInstanceState) {
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_refresh, C1216LO.getLo(C1216LO.navigationColor)), 42));
        menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_share, C1216LO.getLo(C1216LO.navigationColor)), 53));
        this.menu = MenuFragment.newInstance(menuitems, this);
        Fragments.addMenu(this, this.menu);
        this.menu.hide(42);
        AdHelper.showAds(this, AdHelper.buildPath("1", "list", (String) null));
        this.inflater = inflater2;
        if (this.f2087v == null) {
            this.f2087v = inflater2.inflate(C0846R.layout.resto_mediatabs, container, false);
            if (savedInstanceState != null && this.type == null) {
                this.type = savedInstanceState.getString(Globalization.TYPE);
                this.typeid = savedInstanceState.getString("typeid");
            }
            this.social = C1199DB.getObject("social", this.type, this.typeid);
            this.tabHost = (TabHost) this.f2087v.findViewById(16908306);
            this.tabHost.setOnTabChangedListener(this);
            this.f2087v.findViewById(C0846R.C0847id.sep).setBackgroundColor(C1216LO.getLo(C1216LO.topTabBackgroundcolorHigh));
            setupTabs();
            return this.f2087v;
        }
        ((ViewGroup) this.f2087v.getParent()).removeView(this.f2087v);
        return this.f2087v;
    }

    public void setupTabs() {
        this.tabHost.setup();
        if (C1199DB.getSize("news", this.type, this.typeid) > 0) {
            this.tabHost.addTab(newTab(getResourceString(C0846R.string.cell_news), C0846R.C0847id.news));
            new ParseNewsTask(this, (ParseNewsTask) null).execute(new Void[0]);
        }
        if (this.social.has("twittersearchurl")) {
            this.tabHost.addTab(newTab("Twitter", C0846R.C0847id.twitter));
        }
        if (this.social.get("facebookid") != null) {
            this.tabHost.addTab(newTab("Facebook", C0846R.C0847id.facebook));
        }
        TabWidget tabWidget = this.tabHost.getTabWidget();
        int tabChildrenCount = tabWidget.getChildCount();
        for (int i = 0; i < tabChildrenCount; i++) {
            ((LinearLayout.LayoutParams) tabWidget.getChildAt(i).getLayoutParams()).setMargins(5, 0, 5, 0);
        }
        tabWidget.setDividerDrawable((Drawable) null);
        tabWidget.requestLayout();
        if (this.tabHost.getTabWidget().getTabCount() > 0) {
            onTabChanged(this.tabHost.getCurrentTabTag());
        } else {
            C1232UI.show(C0846R.C0847id.no_tabs, this.f2087v);
        }
        if (this.tabHost.getTabWidget().getTabCount() == 1) {
            this.f2087v.findViewById(C0846R.C0847id.navigation).setVisibility(8);
        }
    }

    public TabHost.TabSpec newTab(String text, int content) {
        View view = this.inflater.inflate(C0846R.layout.tab_layout, (ViewGroup) null);
        ((TextView) view.findViewById(C0846R.C0847id.tabtitle)).setText(text);
        TabHost.TabSpec tabSpec = this.tabHost.newTabSpec(text);
        tabSpec.setIndicator(view);
        tabSpec.setContent(content);
        return tabSpec;
    }

    public void onTabChanged(String tabId) {
        int len = this.tabHost.getTabWidget().getTabCount();
        for (int i = 0; i < len; i++) {
            View tab = this.tabHost.getTabWidget().getChildTabViewAt(i);
            tab.setBackgroundDrawable(new TabDrawable(new RoundRectShape(new float[]{15.0f, 15.0f, 15.0f, 15.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED}, (RectF) null, (float[]) null), C1216LO.getLo(C1216LO.topTabBackgroundcolor)));
            ((TextView) tab.findViewById(C0846R.C0847id.tabtitle)).setTextColor(C1216LO.getLo(C1216LO.topTabTextColor));
        }
        View current = this.tabHost.getCurrentTabView();
        current.setBackgroundDrawable(new TabDrawable(new RoundRectShape(new float[]{15.0f, 15.0f, 15.0f, 15.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED}, (RectF) null, (float[]) null), C1216LO.getLo(C1216LO.topTabBackgroundcolorHigh)));
        ((TextView) current.findViewById(C0846R.C0847id.tabtitle)).setTextColor(C1216LO.getLo(C1216LO.topTabTextColorHigh));
        this.tabid = tabId;
        if (tabId.equals("Twitter")) {
            parseTwitter();
        } else if (tabId.equals("Facebook")) {
            parseFacebook();
        }
    }

    private class ParseNewsTask extends AsyncTask<Void, TCListObject2, Void> {
        TCListObject2.TCListObjectAdapter2 adapter;
        boolean img;
        List<TCListObject2> newslist;

        private ParseNewsTask() {
            this.newslist = new ArrayList();
        }

        /* synthetic */ ParseNewsTask(NewsTabsFragment newsTabsFragment, ParseNewsTask parseNewsTask) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            ListView lv = (ListView) NewsTabsFragment.this.f2087v.findViewById(C0846R.C0847id.newslist);
            lv.setBackgroundColor(Color.parseColor("#ffffff"));
            List<TCObject> images = C1199DB.getQueryFromDb("SELECT count(*) AS num FROM news WHERE " + NewsTabsFragment.this.type + " == '" + NewsTabsFragment.this.typeid + "' AND image IS NOT NULL AND image != ''");
            if (images.size() > 0) {
                this.img = !images.get(0).get("num").equals("0");
            }
            this.adapter = new TCListObject2.TCListObjectAdapter2(this.newslist);
            lv.setAdapter(this.adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    ((TCListObject2.TCListObjectAdapter2) arg0.getAdapter()).setSelectedIndex(arg2, (ListView) arg0);
                    Fragments.add(NewsTabsFragment.this, NewsDetailFragment.newInstance(((TCListObject2) arg0.getAdapter().getItem(arg2)).f2134id), NewsTabsFragment.this.getResourceString(C0846R.string.detail));
                }
            });
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            Cursor cursor = C1199DB.getDatabase().rawQuery("SELECT id, datum, title, txt, image FROM news WHERE " + NewsTabsFragment.this.type + " == '" + NewsTabsFragment.this.typeid + "' ORDER BY datum DESC", (String[]) null);
            if (!cursor.moveToFirst()) {
                return null;
            }
            int indexId = cursor.getColumnIndex(DBFavorites.KEY_EVENT_ID);
            int indexDatum = cursor.getColumnIndex("datum");
            int indexTitle = cursor.getColumnIndex(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
            int indexTxt = cursor.getColumnIndex("txt");
            int indexImage = cursor.getColumnIndex("image");
            do {
                String datum = cursor.getString(indexDatum);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
                Date parsed = new Date();
                try {
                    parsed = format.parse(datum);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                TCListObject2 tlo = new TCListObject2();
                tlo.time = parsed;
                tlo.celLayout = C0846R.layout.cell_newsobject;
                tlo.f2134id = cursor.getString(indexId);
                tlo.setField(C0846R.C0847id.text, Html.fromHtml(cursor.getString(indexTitle)).toString());
                tlo.setField(C0846R.C0847id.sub2, Html.fromHtml(cursor.getString(indexTxt)).toString());
                tlo.setField(C0846R.C0847id.sub1, Converter.dateToTimeAgo(parsed));
                tlo.img = cursor.getString(indexImage);
                if (this.img) {
                    tlo.defaultImage = C0846R.drawable.default_news;
                }
                publishProgress(new TCListObject2[]{tlo});
            } while (cursor.moveToNext());
            return null;
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(TCListObject2... values) {
            super.onProgressUpdate(values);
            this.newslist.add(values[0]);
            this.adapter.notifyDataSetChanged();
        }
    }

    public void parseTwitter() {
        this.menu.show(42);
        if (this.f2087v.findViewById(C0846R.C0847id.twitterloading).getVisibility() == 8) {
            new parseTwitterTask(this, (parseTwitterTask) null).execute(new Void[0]);
        }
    }

    public void parseFacebook() {
        this.menu.show(42);
        if (this.f2087v.findViewById(C0846R.C0847id.facebookloading).getVisibility() == 8) {
            new parseFacebookTask(this, (parseFacebookTask) null).execute(new Void[0]);
        }
    }

    private class parseTwitterTask extends AsyncTask<Void, TCListObject2, List<TCListObject2>> {
        TCListObject2.TCListObjectAdapter2 adapter;
        List<TCListObject2> list;
        boolean newAdapter;

        private parseTwitterTask() {
            this.newAdapter = true;
        }

        /* synthetic */ parseTwitterTask(NewsTabsFragment newsTabsFragment, parseTwitterTask parsetwittertask) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.list = new ArrayList();
            ListView lv = (ListView) NewsTabsFragment.this.f2087v.findViewById(C0846R.C0847id.twitterlist);
            lv.setBackgroundColor(Color.parseColor("#ffffff"));
            if (lv.getAdapter() == null) {
                this.newAdapter = false;
                this.adapter = new TCListObject2.TCListObjectAdapter2(this.list);
                lv.setAdapter(this.adapter);
            }
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    TCListObject2 tlo = (TCListObject2) arg0.getAdapter().getItem(arg2);
                    String id = tlo.f2134id;
                    String name = tlo.params.get(Integer.valueOf(C0846R.C0847id.text));
                    if (parseTwitterTask.this.isPackageInstalled("com.twitter.android", NewsTabsFragment.this.getActivity())) {
                        Intent i = new Intent("android.intent.action.VIEW");
                        i.setPackage("com.twitter.android");
                        i.setData(Uri.parse(String.format("https://twitter.com/%1$s/status/%2$s", new Object[]{name, id})));
                        NewsTabsFragment.this.startActivity(i);
                        return;
                    }
                    Intent i2 = new Intent("android.intent.action.VIEW");
                    i2.setData(Uri.parse(String.format("https://twitter.com/%1$s/status/%2$s", new Object[]{name, id})));
                    NewsTabsFragment.this.startActivity(i2);
                }
            });
            NewsTabsFragment.this.f2087v.findViewById(C0846R.C0847id.emptytwitter).setVisibility(8);
            NewsTabsFragment.this.f2087v.findViewById(C0846R.C0847id.twitterloading).setVisibility(0);
            super.onPreExecute();
        }

        /* access modifiers changed from: private */
        public boolean isPackageInstalled(String packagename, Context context) {
            try {
                context.getPackageManager().getPackageInfo(packagename, 1);
                return true;
            } catch (PackageManager.NameNotFoundException e) {
                return false;
            }
        }

        /* access modifiers changed from: protected */
        public List<TCListObject2> doInBackground(Void... params) {
            try {
                JSONObject jo = new JSONObject(Internet.request(NewsTabsFragment.this.social.get("twittersearchurl"), (List<NameValuePair>) null));
                if (jo.has("results")) {
                    JSONArray ar = jo.getJSONArray("results");
                    for (int i = 0; i < ar.length(); i++) {
                        try {
                            TCListObject2 tweet = new TCListObject2();
                            JSONObject jobj = (JSONObject) ar.get(i);
                            tweet.f2134id = jobj.getString(DBFavorites.KEY_EVENT_ID);
                            tweet.img = jobj.getString("profile_image_url");
                            tweet.params.put(Integer.valueOf(C0846R.C0847id.sub2), Html.fromHtml(jobj.getString("text")).toString());
                            tweet.params.put(Integer.valueOf(C0846R.C0847id.text), Html.fromHtml(jobj.getString("from_user")).toString());
                            String time = jobj.getString("created_at");
                            tweet.params.put(Integer.valueOf(C0846R.C0847id.sub1), Converter.timeToTimeAgo(time));
                            try {
                                tweet.time = new Date(time);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            tweet.celLayout = C0846R.layout.cell_twitobject;
                            publishProgress(new TCListObject2[]{tweet});
                        } catch (Exception e2) {
                        }
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return this.list;
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(TCListObject2... values) {
            this.list.add(values[0]);
            if (!this.newAdapter) {
                this.adapter.notifyDataSetChanged();
            }
            super.onProgressUpdate(values);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(List<TCListObject2> result) {
            NewsTabsFragment.this.f2087v.findViewById(C0846R.C0847id.twitterloading).setVisibility(8);
            if (this.newAdapter) {
                this.adapter = new TCListObject2.TCListObjectAdapter2(this.list);
                ((ListView) NewsTabsFragment.this.f2087v.findViewById(C0846R.C0847id.twitterlist)).setAdapter(this.adapter);
            }
            if (result.size() == 0) {
                TextView empty = (TextView) NewsTabsFragment.this.f2087v.findViewById(C0846R.C0847id.emptytwitter);
                empty.setText(C0846R.string.emptyTwitter);
                empty.setVisibility(0);
            }
            super.onPostExecute(result);
        }
    }

    private class parseFacebookTask extends AsyncTask<Void, TCListObject2, List<TCListObject2>> {
        TCListObject2.TCListObjectAdapter2 adapter;
        List<TCListObject2> list;
        boolean newAdapter;

        private parseFacebookTask() {
            this.newAdapter = true;
        }

        /* synthetic */ parseFacebookTask(NewsTabsFragment newsTabsFragment, parseFacebookTask parsefacebooktask) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.list = new ArrayList();
            ListView lv = (ListView) NewsTabsFragment.this.f2087v.findViewById(C0846R.C0847id.facebooklist);
            lv.setBackgroundColor(Color.parseColor("#ffffff"));
            if (lv.getAdapter() == null) {
                this.newAdapter = false;
                this.adapter = new TCListObject2.TCListObjectAdapter2(this.list);
                lv.setAdapter(this.adapter);
            }
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    TCListObject2 tco = (TCListObject2) arg0.getAdapter().getItem(arg2);
                    TextView text = (TextView) arg1.findViewById(C0846R.C0847id.text);
                    String title = NewsTabsFragment.this.getResourceString(C0846R.string.app_name);
                    if (text != null) {
                        title = text.getText().toString();
                    }
                    if (tco.f2134id != null) {
                        Fragments.add(NewsTabsFragment.this, WebViewFragment.newInstance(tco.f2134id, title), NewsTabsFragment.this.getResourceString(C0846R.string.detail));
                        ((TCListObject2.TCListObjectAdapter2) arg0.getAdapter()).setSelectedIndex(arg2, (ListView) arg0);
                    }
                }
            });
            NewsTabsFragment.this.f2087v.findViewById(C0846R.C0847id.emptyfacebook).setVisibility(8);
            NewsTabsFragment.this.f2087v.findViewById(C0846R.C0847id.facebookloading).setVisibility(0);
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public List<TCListObject2> doInBackground(Void... params) {
            ArrayList arrayList = new ArrayList();
            if (App.typeid.equals("5")) {
                arrayList.add(new BasicNameValuePair(Globalization.TYPE, GCMConstants.EXTRA_APPLICATION_PENDING_INTENT));
                arrayList.add(new BasicNameValuePair(DBFavorites.KEY_EVENT_ID, App.f2123id));
            } else if (NewsTabsFragment.this.type.equals("venueid")) {
                arrayList.add(new BasicNameValuePair(Globalization.TYPE, "venue"));
                arrayList.add(new BasicNameValuePair(DBFavorites.KEY_EVENT_ID, NewsTabsFragment.this.typeid));
            } else {
                arrayList.add(new BasicNameValuePair(Globalization.TYPE, "event"));
                arrayList.add(new BasicNameValuePair(DBFavorites.KEY_EVENT_ID, NewsTabsFragment.this.typeid));
            }
            arrayList.add(new BasicNameValuePair("lang", User.getLanguage(NewsTabsFragment.this.getActivity())));
            try {
                JSONObject call = new JSONObject(Internet.request("getFacebook", arrayList));
                JSONObject jo = new JSONObject(call.getJSONObject("0").getString("json"));
                String hash = call.getString("hash");
                if (jo.has("data")) {
                    JSONArray ar = jo.getJSONArray("data");
                    int len = ar.length();
                    for (int i = 0; i < len; i++) {
                        try {
                            JSONObject o = ar.getJSONObject(i);
                            TCListObject2 post = new TCListObject2();
                            String type = o.getString(Globalization.TYPE);
                            if (o.has("link")) {
                                post.f2134id = o.getString("link");
                            } else {
                                post.f2134id = null;
                            }
                            if (type.equals("link")) {
                                post.celLayout = C0846R.layout.cell_fblink;
                                if (o.has("picture")) {
                                    post.img = o.getString("picture");
                                } else if (o.has("from")) {
                                    JSONObject user = o.getJSONObject("from");
                                    if (user.has(DBFavorites.KEY_EVENT_ID)) {
                                        post.img = "http://graph.facebook.com/" + user.getString(DBFavorites.KEY_EVENT_ID) + "/picture";
                                    }
                                }
                            } else if (type.equals("video")) {
                                post.celLayout = C0846R.layout.cell_fbvideo;
                                if (o.has("picture")) {
                                    post.img = o.getString("picture");
                                }
                            } else if (type.equals("status")) {
                                post.celLayout = C0846R.layout.cell_fbstatus;
                                if (o.has("from")) {
                                    JSONObject user2 = o.getJSONObject("from");
                                    if (user2.has(DBFavorites.KEY_EVENT_ID)) {
                                        post.img = "http://graph.facebook.com/" + user2.getString(DBFavorites.KEY_EVENT_ID) + "/picture";
                                    }
                                    if (user2.has(DBFavorites.KEY_NAME)) {
                                        post.params.put(Integer.valueOf(C0846R.C0847id.text), user2.getString(DBFavorites.KEY_NAME));
                                    }
                                }
                            } else if (type.equals("photo")) {
                                post.celLayout = C0846R.layout.cell_fbphoto;
                                post.img = "https://graph.facebook.com/" + o.getString("object_id") + "/picture?type=normal&access_token=" + hash;
                            }
                            if (o.has("message")) {
                                post.params.put(Integer.valueOf(C0846R.C0847id.sub1), o.getString("message"));
                            } else if (o.has(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION)) {
                                post.params.put(Integer.valueOf(C0846R.C0847id.sub1), o.getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION));
                            } else if (o.has("story")) {
                                post.params.put(Integer.valueOf(C0846R.C0847id.sub1), o.getString("story"));
                            }
                            if (o.has(DBFavorites.KEY_NAME)) {
                                post.params.put(Integer.valueOf(C0846R.C0847id.text), o.getString(DBFavorites.KEY_NAME));
                            } else {
                                post.params.put(Integer.valueOf(C0846R.C0847id.text), (Object) null);
                            }
                            if (o.has("likes")) {
                                String likes = new StringBuilder(String.valueOf(o.getJSONObject("likes").getJSONArray("data").length())).toString();
                                if (likes.length() > 3) {
                                    likes = String.valueOf(likes.substring(0, likes.length() - 3)) + "k";
                                }
                                post.params.put(Integer.valueOf(C0846R.C0847id.totallike), likes);
                            } else {
                                post.params.put(Integer.valueOf(C0846R.C0847id.totallike), "0");
                            }
                            if (o.has("comments")) {
                                String comments = new StringBuilder(String.valueOf(o.getJSONObject("comments").getJSONArray("data").length())).toString();
                                if (comments.length() > 3) {
                                    comments = String.valueOf(comments.substring(0, comments.length() - 3)) + "k";
                                }
                                post.params.put(Integer.valueOf(C0846R.C0847id.totalcomment), comments);
                            } else {
                                post.params.put(Integer.valueOf(C0846R.C0847id.totalcomment), "0");
                            }
                            if (o.has("created_time")) {
                                Date parsed = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(o.getString("created_time"));
                                post.time = parsed;
                                post.params.put(Integer.valueOf(C0846R.C0847id.timeago), Converter.dateToTimeAgo(parsed));
                            }
                            if ((type.equals("status") || type.equals("link")) && post.params.get(Integer.valueOf(C0846R.C0847id.sub1)) == null) {
                                post.celLayout = 0;
                            }
                            if (post.celLayout != 0) {
                                publishProgress(new TCListObject2[]{post});
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return this.list;
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(TCListObject2... values) {
            this.list.add(values[0]);
            if (!this.newAdapter) {
                this.adapter.notifyDataSetChanged();
            }
            super.onProgressUpdate(values);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(List<TCListObject2> result) {
            NewsTabsFragment.this.f2087v.findViewById(C0846R.C0847id.facebookloading).setVisibility(8);
            if (this.newAdapter) {
                this.adapter = new TCListObject2.TCListObjectAdapter2(this.list);
                ((ListView) NewsTabsFragment.this.f2087v.findViewById(C0846R.C0847id.facebooklist)).setAdapter(this.adapter);
            }
            if (result.size() == 0) {
                TextView empty = (TextView) NewsTabsFragment.this.f2087v.findViewById(C0846R.C0847id.emptyfacebook);
                empty.setText(C0846R.string.emptyFacebook);
                empty.setVisibility(0);
            }
            super.onPostExecute(result);
        }
    }

    private class TabDrawable extends ShapeDrawable {
        private final Paint fillpaint = new Paint(getPaint());
        private final Paint strokepaint;

        public TabDrawable(Shape s, int fill) {
            super(s);
            this.fillpaint.setColor(fill);
            this.strokepaint = new Paint(this.fillpaint);
            this.strokepaint.setStyle(Paint.Style.STROKE);
        }

        /* access modifiers changed from: protected */
        public void onDraw(Shape shape, Canvas canvas, Paint paint) {
            shape.draw(canvas, this.fillpaint);
            shape.draw(canvas, this.strokepaint);
        }
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 42:
                refresh();
                return;
            case 53:
                share();
                return;
            default:
                return;
        }
    }

    public void refresh() {
        if (this.tabHost.getCurrentTabTag().equals("Twitter")) {
            parseTwitter();
        } else if (this.tabHost.getCurrentTabTag().equals("Facebook")) {
            parseFacebook();
        }
    }

    public void share() {
        Intent shareIntent = new Intent("android.intent.action.SEND");
        shareIntent.setType("text/plain");
        shareIntent.putExtra("android.intent.extra.SUBJECT", getResourceString(C0846R.string.app_name));
        shareIntent.putExtra("android.intent.extra.TEXT", "http://" + C1199DB.getFirstObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get("subdomain", "") + ".m.tap.cr ");
        startActivity(Intent.createChooser(shareIntent, "Share"));
    }

    public void onAuthorize() {
        C1204FB.shareDialog(this.facebook, "http://" + C1199DB.getFirstObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get("subdomain", "") + ".m.tap.cr");
    }
}
