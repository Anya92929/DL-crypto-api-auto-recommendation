package com.tapcrowd.app.modules.events;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.launcher.TCLauncherPhoneFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.Internet;
import com.tapcrowd.app.utils.LauncherUtil;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class EventListFragment extends TCListFragment {
    int posfutur = 0;
    int posnow = 0;
    int pospast = 0;
    int posperm = 0;

    public static EventListFragment newInstance() {
        return new EventListFragment();
    }

    public void onResume() {
        super.onResume();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C0846R.layout.listview, container, false);
        AdHelper.showAds(this, AdHelper.buildPath("26", "list", (String) null));
        List<Object> listitems = new ArrayList<>();
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
        String where = " AND events.appid == " + App.f2123id;
        List<TCObject> now = C1199DB.getQueryFromDb("select * from events where datefrom <= '" + dnow3 + "' AND dateto >= '" + dnow3 + "'" + where + " ORDER BY order_value +0, datefrom ASC, dateto ASC");
        List<TCObject> futur = C1199DB.getQueryFromDb("select * from events where datefrom > '" + dnow3 + "'" + where + " ORDER BY order_value +0, datefrom ASC");
        List<TCObject> past = C1199DB.getQueryFromDb("select * from events where dateto < '" + dnow3 + "' AND datefrom != '1970-01-01'" + where + " ORDER BY order_value +0, datefrom DESC, dateto DESC");
        List<TCObject> ongoing = C1199DB.getQueryFromDb("select * from events where datefrom == '1970-01-01'" + where + " ORDER BY name COLLATE NOCASE");
        if (now.size() > 0) {
            listitems.add(getResourceString(C0846R.string.eventsnow));
            this.posnow = listitems.size() - 1;
            for (TCObject tco : now) {
                listitems.add(new TCListObject(tco.get(DBFavorites.KEY_EVENT_ID), tco.get(DBFavorites.KEY_NAME), Converter.datesToString(tco.get("datefrom"), tco.get("dateto")), C1199DB.getFirstObject("venues", DBFavorites.KEY_EVENT_ID, tco.get("venueid", "")).get(DBFavorites.KEY_NAME, ""), "", tco.get("eventlogo", ""), (int) C0846R.drawable.l_def_events));
            }
        }
        if (ongoing.size() > 0) {
            listitems.add(getResourceString(C0846R.string.permanentevents));
            this.posperm = listitems.size() - 1;
            for (TCObject tco2 : ongoing) {
                listitems.add(new TCListObject(tco2.get(DBFavorites.KEY_EVENT_ID), tco2.get(DBFavorites.KEY_NAME), getResourceString(C0846R.string.permanent), C1199DB.getFirstObject("venues", DBFavorites.KEY_EVENT_ID, tco2.get("venueid", "")).get(DBFavorites.KEY_NAME, ""), "", tco2.get("eventlogo", ""), (int) C0846R.drawable.l_def_events));
            }
        }
        if (futur.size() > 0) {
            listitems.add(getResourceString(C0846R.string.futurevents));
            this.posfutur = listitems.size() - 1;
            for (TCObject tco3 : futur) {
                listitems.add(new TCListObject(tco3.get(DBFavorites.KEY_EVENT_ID), tco3.get(DBFavorites.KEY_NAME), Converter.datesToString(tco3.get("datefrom"), tco3.get("dateto")), C1199DB.getFirstObject("venues", DBFavorites.KEY_EVENT_ID, tco3.get("venueid", "")).get(DBFavorites.KEY_NAME, ""), "", tco3.get("eventlogo", ""), (int) C0846R.drawable.l_def_events));
            }
        }
        if (past.size() > 0) {
            listitems.add(getResourceString(C0846R.string.pastevents));
            this.pospast = listitems.size() - 1;
            for (TCObject tco4 : past) {
                listitems.add(new TCListObject(tco4.get(DBFavorites.KEY_EVENT_ID), tco4.get(DBFavorites.KEY_NAME), Converter.datesToString(tco4.get("datefrom"), tco4.get("dateto")), C1199DB.getFirstObject("venues", DBFavorites.KEY_EVENT_ID, tco4.get("venueid", "")).get(DBFavorites.KEY_NAME, ""), "", tco4.get("eventlogo", ""), (int) C0846R.drawable.l_def_events));
            }
        }
        setListAdapter(new TCListObject.TCListObjectAdapter((List) listitems, (int) C0846R.drawable.l_def_events, false));
        return v;
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        Object o = l.getAdapter().getItem(position);
        if (o.getClass() == TCListObject.class) {
            new LoadDataTask(((TCListObject) o).getId()).execute(new Void[0]);
        }
    }

    public class LoadDataTask extends AsyncTask<Void, Void, Boolean> {
        private ProgressDialog dialog = new ProgressDialog(App.act);
        String eventid;

        public LoadDataTask(String eventid2) {
            this.eventid = eventid2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.dialog = ProgressDialog.show(App.act, C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get(DBFavorites.KEY_NAME), EventListFragment.this.getResourceString(C0846R.string.loading), false, true);
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
                startNextActivity(this.eventid);
            }
        }

        private void startNextActivity(String eventid2) {
            if (C1199DB.getSize("launchers", "eventid", eventid2) > 0) {
                List<TCObject> launchers = C1199DB.getListFromDb("launchers", "eventid", eventid2);
                if (App.tablet || launchers.size() == 1) {
                    for (TCObject launcher : launchers) {
                        if (LauncherUtil.hasFragment(launcher)) {
                            EventListFragment.this.analytics = "/event/" + eventid2;
                            Fragments.add(EventListFragment.this, LauncherUtil.getFragment(launcher), launcher.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                        }
                    }
                } else if (launchers.size() > 1) {
                    EventListFragment.this.analytics = "/event/" + eventid2;
                    Fragments.add(EventListFragment.this, TCLauncherPhoneFragment.newInstance("eventid", eventid2), C1199DB.getFirstObject("event", DBFavorites.KEY_EVENT_ID, eventid2).get(DBFavorites.KEY_NAME));
                }
            }
        }
    }
}
