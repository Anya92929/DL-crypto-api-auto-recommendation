package com.tapcrowd.app.modules.search;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.attendees.AttendeeDetailFragment;
import com.tapcrowd.app.modules.business.CatalogDetailFragment;
import com.tapcrowd.app.modules.exhibitors.ExhibitorDetailFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.groups.GroupListFragment;
import com.tapcrowd.app.modules.launcher.TCLauncherPhoneFragment;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.modules.news.NewsDetailFragment;
import com.tapcrowd.app.modules.sessions.SessionDetailFragment;
import com.tapcrowd.app.modules.speakers.SpeakerDetailFragment;
import com.tapcrowd.app.modules.sponsors.SponsorDetailFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.Internet;
import com.tapcrowd.app.utils.LauncherUtil;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.TCDBHelper;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import com.tapcrowd.app.views.SearchBar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class SearchListAllFragment extends TCListFragment implements MenuFragment.MenuItemListener {
    private static String attendeeSep;
    private static String catalogSep;
    private static String eventsSep;
    private static String exhibitorsSep;
    private static String groupsSep;
    private static String newsSep;
    private static String projectsSep;
    private static String sessionsSep;
    private static String speakersSep;
    private static String sponsorsSep;
    private static String venuesSep;
    MenuFragment menu;
    boolean retained;
    String[] tables;

    /* renamed from: v */
    View f2107v;

    public static SearchListAllFragment newInstance(String[] tables2) {
        SearchListAllFragment list = new SearchListAllFragment();
        list.tables = tables2;
        return list;
    }

    public static String getSeparator(String type) {
        if (type.equals(LinkedObjects.TABLE_ATT)) {
            if (attendeeSep == null) {
                attendeeSep = C1199DB.getFirstObject("launchers", "moduletypeid", "14").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "");
            }
            return attendeeSep;
        } else if (type.equals(LinkedObjects.TABLE_CAT)) {
            if (catalogSep == null) {
                catalogSep = C1199DB.getFirstObject("launchers", "moduletypeid", "15").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "");
            }
            return catalogSep;
        } else if (type.equals("events")) {
            if (eventsSep == null) {
                eventsSep = C1199DB.getFirstObject("launchers", "moduletypeid", "26").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "");
            }
            return eventsSep;
        } else if (type.equals(DBFavorites.TABLE_EXHIBITORS)) {
            if (exhibitorsSep == null) {
                exhibitorsSep = C1199DB.getFirstObject("launchers", "moduletypeid", "2").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "");
            }
            return exhibitorsSep;
        } else if (type.equals("groups")) {
            if (groupsSep == null) {
                groupsSep = App.act.getString(C0846R.string.categorieen);
            }
            return groupsSep;
        } else if (type.equals("sessions")) {
            if (sessionsSep == null) {
                sessionsSep = C1199DB.getFirstObject("launchers", "moduletypeid", "10").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "");
            }
            return sessionsSep;
        } else if (type.equals("speakers")) {
            if (speakersSep == null) {
                speakersSep = App.act.getString(C0846R.string.speakers);
            }
            return speakersSep;
        } else if (type.equals("sponsors")) {
            if (sponsorsSep == null) {
                sponsorsSep = C1199DB.getFirstObject("launchers", "moduletypeid", "19").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "");
            }
            return sponsorsSep;
        } else if (type.equals("projects")) {
            if (projectsSep == null) {
                projectsSep = C1199DB.getFirstObject("launchers", "moduletypeid", "25").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "");
            }
            return projectsSep;
        } else if (type.equals("venues")) {
            if (venuesSep == null) {
                venuesSep = C1199DB.getFirstObject("launchers", "moduletypeid", "31").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "");
            }
            return venuesSep;
        } else if (!type.equals("news")) {
            return C1199DB.getFirstObject("launchers", "moduletypeid", "").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "");
        } else {
            if (newsSep == null) {
                newsSep = C1199DB.getFirstObject("launchers", "moduletypeid", "1").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "");
            }
            return newsSep;
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArray("tables", this.tables);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2107v == null) {
            this.f2107v = inflater.inflate(C0846R.layout.listview, container, false);
        } else {
            ((ViewGroup) this.f2107v.getParent()).removeView(this.f2107v);
            this.retained = true;
        }
        if (savedInstanceState != null && this.tables == null) {
            this.tables = savedInstanceState.getStringArray("tables");
        }
        this.menu = MenuFragment.newInstance(new ArrayList<>(), this);
        Fragments.addMenu(this, this.menu);
        return this.f2107v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AdHelper.showAds(this, AdHelper.buildPath("67", "list", (String) null));
        if (!this.retained) {
            ((ImageView) this.f2107v.findViewById(C0846R.C0847id.f1987bg)).setImageResource(C0846R.drawable.search_bg);
            new LoadList(this, (LoadList) null).execute(new Void[0]);
        }
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        Object clicked = l.getItemAtPosition(position);
        if (clicked instanceof TCListObject) {
            TCListObject tlo = (TCListObject) clicked;
            String type = tlo.getId().split(":")[0];
            String typeid = tlo.getId().split(":")[1];
            if (type.equals(LinkedObjects.TABLE_ATT)) {
                Fragments.add(this, AttendeeDetailFragment.newInstance(typeid), getString(C0846R.string.detail));
            } else if (type.equals(LinkedObjects.TABLE_CAT) || type.equals("projects")) {
                Fragments.add(this, CatalogDetailFragment.newInstance(typeid, 0), getString(C0846R.string.detail));
            } else if (type.equals("projects")) {
                Fragments.add(this, CatalogDetailFragment.newInstance(typeid, "projects"), getString(C0846R.string.detail));
            } else if (type.equals("events")) {
                new LoadEventDataTask(typeid).execute(new Void[0]);
            } else if (type.equals("groups")) {
                Fragments.add(this, GroupListFragment.newInstance("parentid", typeid), tlo.getText());
            } else if (type.equals(DBFavorites.TABLE_EXHIBITORS)) {
                Fragments.add(this, ExhibitorDetailFragment.newInstance(typeid), getString(C0846R.string.detail));
            } else if (type.equals("sessions")) {
                Fragments.add(this, SessionDetailFragment.newInstance(typeid), getString(C0846R.string.detail));
            } else if (type.equals("speakers")) {
                Fragments.add(this, SpeakerDetailFragment.newInstance(typeid), getString(C0846R.string.detail));
            } else if (type.equals("sponsors")) {
                Fragments.add(this, SponsorDetailFragment.newInstance(typeid), getString(C0846R.string.detail));
            } else if (type.equals("news")) {
                Fragments.add(this, NewsDetailFragment.newInstance(typeid), getString(C0846R.string.detail));
            }
        }
        super.onListItemClick(l, v, position, id);
    }

    private class LoadList extends AsyncTask<Void, Object, Void> {
        TCListObjectAdapter adapter;
        boolean hasimg;
        List<Object> list;
        SearchBar search;

        private LoadList() {
        }

        /* synthetic */ LoadList(SearchListAllFragment searchListAllFragment, LoadList loadList) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            SearchListAllFragment.this.menu.startLoader();
            if (this.search == null) {
                this.search = new SearchBar(SearchListAllFragment.this.getActivity(), SearchListAllFragment.this, new SearchBar.TextChangedListener() {
                    public void textChanged(CharSequence s, int count) {
                        ((ImageView) SearchListAllFragment.this.f2107v.findViewById(C0846R.C0847id.f1987bg)).setImageResource(0);
                        SearchListAllFragment.this.menu.startLoader();
                        LoadList.this.adapter.getFilter().filter(s);
                    }
                });
            }
            SearchListAllFragment.this.getListView().addHeaderView(this.search);
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            String imgquery = "";
            for (int i = 0; i < SearchListAllFragment.this.tables.length; i++) {
                imgquery = String.valueOf(String.valueOf(imgquery) + (imgquery.length() > 0 ? " UNION " : "")) + String.format("SELECT count(%1$s.imageurl) as images FROM %1$s WHERE %1$s.imageurl IS NOT NULL AND %1$s.imageurl != ''", new Object[]{SearchListAllFragment.this.tables[i]});
            }
            Iterator<TCObject> it = C1199DB.getQueryFromDb(imgquery).iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!it.next().get("images", "0").equals("0")) {
                        this.hasimg = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.list = TCDBHelper.getSearchListItemsFromQuery(SearchListAllFragment.this.getActivity(), SearchListAllFragment.this.tables);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            int i;
            SearchListAllFragment.this.menu.stopLoader();
            SearchListAllFragment searchListAllFragment = SearchListAllFragment.this;
            List<Object> list2 = this.list;
            if (this.hasimg) {
                i = C0846R.drawable.l_def_exhibitors;
            } else {
                i = 0;
            }
            this.adapter = new TCListObjectAdapter(list2, i, false);
            SearchListAllFragment.this.setListAdapter(this.adapter);
            super.onPostExecute(result);
        }
    }

    public class LoadEventDataTask extends AsyncTask<Void, Void, Boolean> {
        private ProgressDialog dialog = new ProgressDialog(App.act);
        String eventid;

        public LoadEventDataTask(String eventid2) {
            this.eventid = eventid2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.dialog = ProgressDialog.show(App.act, C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get(DBFavorites.KEY_NAME), SearchListAllFragment.this.getResourceString(C0846R.string.loading), false, true);
            this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialog) {
                    LoadEventDataTask.this.cancel(true);
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
                startNextActivity(this.eventid);
            }
        }

        private void startNextActivity(String eventid2) {
            if (C1199DB.getSize("launchers", "eventid", eventid2) > 0) {
                List<TCObject> launchers = C1199DB.getListFromDb("launchers", "eventid", eventid2);
                if (App.tablet || launchers.size() == 1) {
                    for (TCObject launcher : launchers) {
                        if (LauncherUtil.hasFragment(launcher)) {
                            SearchListAllFragment.this.analytics = "/event/" + eventid2;
                            Fragments.add(SearchListAllFragment.this, LauncherUtil.getFragment(launcher), launcher.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                        }
                    }
                } else if (launchers.size() > 1) {
                    SearchListAllFragment.this.analytics = "/event/" + eventid2;
                    Fragments.add(SearchListAllFragment.this, TCLauncherPhoneFragment.newInstance("eventid", eventid2), C1199DB.getFirstObject("event", DBFavorites.KEY_EVENT_ID, eventid2).get(DBFavorites.KEY_NAME));
                }
            }
        }
    }

    private class TCListObjectAdapter extends ArrayAdapter {
        private int defaultImage;
        private FastImageLoader fil = new FastImageLoader();
        private Filter filter;
        /* access modifiers changed from: private */
        public List<Object> filtered = new ArrayList();
        /* access modifiers changed from: private */
        public List<Object> items = new ArrayList();
        private int layout = C0846R.layout.cell_tcobject;
        private LayoutInflater mInflater;
        private int textColor;

        private class Holder {
            ImageView arrow;
            ImageView icon;
            TextView sub1;
            TextView sub2;
            TextView text;

            private Holder() {
            }

            /* synthetic */ Holder(TCListObjectAdapter tCListObjectAdapter, Holder holder) {
                this();
            }
        }

        public void addToList(Object object) {
            this.filtered.add(object);
            this.items.add(object);
        }

        public TCListObjectAdapter(List list, int defaultResource, boolean showIndexer) {
            super(App.act, 0, list);
            for (Object item : list) {
                this.items.add(item);
            }
            clear();
            this.mInflater = LayoutInflater.from(App.act);
            this.defaultImage = defaultResource;
            this.textColor = C1216LO.getLo(C1216LO.textcolor);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            Object o = this.filtered.get(position);
            if (o.getClass() == TCListObject.class) {
                TCListObject tlo = (TCListObject) o;
                if (convertView == null || convertView.getTag() == null || !convertView.getTag().equals("tlo")) {
                    convertView = this.mInflater.inflate(this.layout, (ViewGroup) null);
                    C1232UI.setFont((TextView) convertView.findViewById(C0846R.C0847id.text));
                    C1232UI.setFont((TextView) convertView.findViewById(C0846R.C0847id.sub1));
                    C1232UI.setFont((TextView) convertView.findViewById(C0846R.C0847id.sub2));
                    convertView.setTag("tlo");
                }
                Holder holder = new Holder(this, (Holder) null);
                holder.text = (TextView) convertView.findViewById(C0846R.C0847id.text);
                holder.sub1 = (TextView) convertView.findViewById(C0846R.C0847id.sub1);
                holder.sub2 = (TextView) convertView.findViewById(C0846R.C0847id.sub2);
                holder.icon = (ImageView) convertView.findViewById(C0846R.C0847id.icon);
                holder.arrow = (ImageView) convertView.findViewById(C0846R.C0847id.arrow);
                try {
                    holder.text.setTextColor(this.textColor);
                    holder.sub1.setTextColor(this.textColor);
                    holder.sub2.setTextColor(this.textColor);
                    convertView.setBackgroundColor(0);
                    if (tlo.getText() == null) {
                        holder.text.setVisibility(8);
                    } else {
                        holder.text.setText(Converter.unicodeToString(Html.fromHtml(tlo.getText()).toString()));
                    }
                    holder.sub1.setVisibility(8);
                    holder.sub2.setVisibility(8);
                    if (tlo.getImg() == null) {
                        holder.icon.setVisibility(8);
                    } else {
                        holder.icon.setVisibility(0);
                        if (!tlo.getImg().equals("")) {
                            holder.icon.setImageResource(this.defaultImage);
                            this.fil.DisplayImage(tlo.getImg(), holder.icon, holder.icon.getLayoutParams().height, holder.icon.getLayoutParams().width);
                        } else if (this.defaultImage == 0) {
                            holder.icon.setVisibility(8);
                        } else {
                            holder.icon.setImageDrawable(C1232UI.getColorOverlay(this.defaultImage, C1216LO.getLo(C1216LO.placeholderOverlayColor)));
                        }
                    }
                    return convertView;
                } catch (Exception e) {
                    e.printStackTrace();
                    return new View(getContext());
                }
            } else if (o.getClass() != String.class) {
                return new View(App.act);
            } else {
                View convertView2 = this.mInflater.inflate(C0846R.layout.separator, (ViewGroup) null);
                TextView tv = (TextView) convertView2.findViewById(C0846R.C0847id.text);
                convertView2.setTag("sep");
                C1232UI.setFont(tv);
                tv.setBackgroundColor(C1216LO.getLo(C1216LO.seperatorBackgroundColor));
                tv.setTextColor(C1216LO.getLo(C1216LO.separatorTextColor));
                tv.setText((String) o);
                return convertView2;
            }
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public boolean isEnabled(int position) {
            return !(this.filtered.get(position) instanceof String);
        }

        public Filter getFilter() {
            if (this.filter == null) {
                this.filter = new TCFilter(this, (TCFilter) null);
            }
            return this.filter;
        }

        private class TCFilter extends Filter {
            private TCFilter() {
            }

            /* synthetic */ TCFilter(TCListObjectAdapter tCListObjectAdapter, TCFilter tCFilter) {
                this();
            }

            /* access modifiers changed from: protected */
            public Filter.FilterResults performFiltering(CharSequence constraint) {
                List<String> seps = new ArrayList<>();
                CharSequence constraint2 = constraint.toString().toLowerCase();
                Filter.FilterResults result = new Filter.FilterResults();
                List<Object> filt = new ArrayList<>();
                if (constraint2 == null || constraint2.toString().length() <= 0) {
                    result.count = TCListObjectAdapter.this.items.size();
                    result.values = TCListObjectAdapter.this.items;
                } else {
                    HashSet<String> ids = TCDBHelper.getIdsFromTables(constraint2.toString(), SearchListAllFragment.this.tables);
                    for (Object object : TCListObjectAdapter.this.items) {
                        if (object instanceof TCListObject) {
                            String id = ((TCListObject) object).getId();
                            if (ids.contains(id)) {
                                String type = ((TCListObject) object).getSub1();
                                if (!seps.contains(type)) {
                                    seps.add(type);
                                    filt.add(SearchListAllFragment.getSeparator(type));
                                }
                                filt.add(object);
                                ids.remove(id);
                            }
                        }
                    }
                    result.count = filt.size();
                    result.values = filt;
                }
                return result;
            }

            /* access modifiers changed from: protected */
            public void publishResults(CharSequence constraint, Filter.FilterResults results) {
                SearchListAllFragment.this.menu.stopLoader();
                TCListObjectAdapter.this.filtered = (List) results.values;
                TCListObjectAdapter.this.notifyDataSetChanged();
                TCListObjectAdapter.this.clear();
                int l = TCListObjectAdapter.this.filtered.size();
                for (int i = 0; i < l; i++) {
                    TCListObjectAdapter.this.add(TCListObjectAdapter.this.filtered.get(i));
                }
                TCListObjectAdapter.this.notifyDataSetInvalidated();
            }
        }
    }

    public void click(MenuItem item) {
    }
}
