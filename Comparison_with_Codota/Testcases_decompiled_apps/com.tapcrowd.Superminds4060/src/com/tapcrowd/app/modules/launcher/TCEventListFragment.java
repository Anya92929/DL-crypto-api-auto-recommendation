package com.tapcrowd.app.modules.launcher;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.Internet;
import com.tapcrowd.app.utils.LauncherUtil;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class TCEventListFragment extends TCListFragment {
    public static TCEventListFragment newInstance() {
        return new TCEventListFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2007v == null) {
            this.f2007v = inflater.inflate(C0846R.layout.listview, container, false);
        } else {
            this.retained = true;
            ((ViewGroup) this.f2007v.getParent()).removeView(this.f2007v);
        }
        setShowHomebutton(false);
        return this.f2007v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        Date start;
        Date end;
        Date start2;
        Date end2;
        Date start3;
        Date end3;
        super.onActivityCreated(savedInstanceState);
        if (!this.retained) {
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
            List<Object> list = new ArrayList<>();
            List<TCObject> events = C1199DB.getQueryFromDb("SELECT * FROM events WHERE datefrom <= '" + dnow3 + "' AND dateto >= '" + dnow3 + "' ORDER BY datefrom ASC, dateto ASC");
            if (events.size() > 0) {
                list.add(getString(C0846R.string.eventsnow).toUpperCase());
            }
            for (TCObject event : events) {
                try {
                    start3 = new SimpleDateFormat("yyyy-MM-dd").parse(event.get("datefrom"));
                    end3 = new SimpleDateFormat("yyyy-MM-dd").parse(event.get("dateto"));
                } catch (ParseException e) {
                    start3 = new Date();
                    end3 = new Date();
                    e.printStackTrace();
                }
                String date = DateFormat.getLongDateFormat(getActivity()).format(start3);
                if (!start3.equals(end3)) {
                    date = String.valueOf(date) + " - " + DateFormat.getLongDateFormat(getActivity()).format(end3);
                }
                list.add(new TCListObject(event.get(DBFavorites.KEY_EVENT_ID), event.get(DBFavorites.KEY_NAME), date, C1199DB.getFirstObject("venues", DBFavorites.KEY_EVENT_ID, event.get("venueid")).get(DBFavorites.KEY_NAME, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR), event.get("thumblogo")));
            }
            List<TCObject> events2 = C1199DB.getQueryFromDb("SELECT * FROM events WHERE datefrom = '1970-01-01'");
            if (events2.size() > 0) {
                list.add(getString(C0846R.string.permanentevents).toUpperCase());
            }
            for (TCObject event2 : events2) {
                C1232UI.setText((int) C0846R.C0847id.date, DateFormat.getLongDateFormat(getActivity()).format(d), this.f2007v);
                list.add(new TCListObject(event2.get(DBFavorites.KEY_EVENT_ID), event2.get(DBFavorites.KEY_NAME), getString(C0846R.string.permanentevents), C1199DB.getFirstObject("venues", DBFavorites.KEY_EVENT_ID, event2.get("venueid")).get(DBFavorites.KEY_NAME, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR), event2.get("thumblogo")));
            }
            List<TCObject> events3 = C1199DB.getQueryFromDb("SELECT * FROM events WHERE datefrom > '" + dnow3 + "' ORDER BY datefrom ASC");
            if (events3.size() > 0) {
                list.add(getString(C0846R.string.futurevents).toUpperCase());
            }
            for (TCObject event3 : events3) {
                try {
                    start2 = new SimpleDateFormat("yyyy-MM-dd").parse(event3.get("datefrom"));
                    end2 = new SimpleDateFormat("yyyy-MM-dd").parse(event3.get("dateto"));
                } catch (ParseException e2) {
                    start2 = new Date();
                    end2 = new Date();
                    e2.printStackTrace();
                }
                String date2 = DateFormat.getLongDateFormat(getActivity()).format(start2);
                if (!start2.equals(end2)) {
                    date2 = String.valueOf(date2) + " - " + DateFormat.getLongDateFormat(getActivity()).format(end2);
                }
                list.add(new TCListObject(event3.get(DBFavorites.KEY_EVENT_ID), event3.get(DBFavorites.KEY_NAME), date2, C1199DB.getFirstObject("venues", DBFavorites.KEY_EVENT_ID, event3.get("venueid")).get(DBFavorites.KEY_NAME, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR), event3.get("thumblogo")));
            }
            List<TCObject> events4 = C1199DB.getQueryFromDb("SELECT * FROM events WHERE dateto < '" + dnow3 + "' AND datefrom != '1970-01-01' ORDER BY datefrom DESC, dateto DESC");
            if (events4.size() > 0) {
                list.add(getString(C0846R.string.pastevents).toUpperCase());
            }
            for (TCObject event4 : events4) {
                try {
                    start = new SimpleDateFormat("yyyy-MM-dd").parse(event4.get("datefrom"));
                    end = new SimpleDateFormat("yyyy-MM-dd").parse(event4.get("dateto"));
                } catch (ParseException e3) {
                    start = new Date();
                    end = new Date();
                    e3.printStackTrace();
                }
                String date3 = DateFormat.getLongDateFormat(getActivity()).format(start);
                if (!start.equals(end)) {
                    date3 = String.valueOf(date3) + " - " + DateFormat.getLongDateFormat(getActivity()).format(end);
                }
                list.add(new TCListObject(event4.get(DBFavorites.KEY_EVENT_ID), event4.get(DBFavorites.KEY_NAME), date3, C1199DB.getFirstObject("venues", DBFavorites.KEY_EVENT_ID, event4.get("venueid")).get(DBFavorites.KEY_NAME, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR), event4.get("thumblogo")));
            }
            setListAdapter(new TCListObject.TCListObjectAdapter(list, 0));
        }
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
            this.dialog = ProgressDialog.show(App.act, C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get(DBFavorites.KEY_NAME), TCEventListFragment.this.getResourceString(C0846R.string.loading), false, true);
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
                            TCEventListFragment.this.analytics = "/event/" + eventid2;
                            Fragments.add(TCEventListFragment.this, LauncherUtil.getFragment(launcher), launcher.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                        }
                    }
                } else if (launchers.size() > 1) {
                    TCEventListFragment.this.analytics = "/event/" + eventid2;
                    Fragments.add(TCEventListFragment.this, TCLauncherPhoneFragment.newInstance("eventid", eventid2), C1199DB.getFirstObject("event", DBFavorites.KEY_EVENT_ID, eventid2).get(DBFavorites.KEY_NAME));
                }
            }
        }
    }
}
