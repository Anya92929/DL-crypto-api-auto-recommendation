package com.tapcrowd.app.modules.launcher;

import android.app.ProgressDialog;
import android.content.Intent;
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
import com.tapcrowd.app.modules.info.VenueInfoFragment;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.Internet;
import com.tapcrowd.app.utils.LauncherUtil;
import com.tapcrowd.app.utils.TCDBHelper;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class TCVenueList extends TCListFragment {
    public static TCVenueList newInstance() {
        return new TCVenueList();
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
        int i;
        super.onActivityCreated(savedInstanceState);
        if (!this.retained) {
            boolean img = false;
            List<TCObject> images = C1199DB.getQueryFromDb("SELECT count(*) AS num FROM venues WHERE image1 IS NOT NULL AND image1 != ''");
            if (images.size() > 0) {
                img = !images.get(0).get("num").equals("0");
            }
            List<Object> list = TCDBHelper.getTCListFromDb("SELECT id, name, address, image1, order_value FROM venues ORDER BY order_value DESC, name COLLATE NOCASE", new TCDBHelper.TCListHelperObject(DBFavorites.KEY_NAME, "address", "image1"), false);
            if (img) {
                i = C0846R.drawable.l_def_venues;
            } else {
                i = 0;
            }
            setListAdapter(new TCListObject.TCListObjectAdapter((List) list, i, false));
        }
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        Object obj = l.getItemAtPosition(position);
        if (obj instanceof TCListObject) {
            new LoadDataTask(((TCListObject) obj).getId()).execute(new Void[0]);
        }
    }

    private class LoadDataTask extends AsyncTask<Void, Void, Void> {
        private ProgressDialog dialog = new ProgressDialog(App.act);
        private String venueid;

        public LoadDataTask(String venueid2) {
            this.venueid = venueid2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.dialog = ProgressDialog.show(TCVenueList.this.getActivity(), C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id).get(DBFavorites.KEY_NAME), TCVenueList.this.getResourceString(C0846R.string.loading), false, false);
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... args) {
            List<NameValuePair> postparams = new ArrayList<>();
            postparams.add(new BasicNameValuePair("appid", App.f2123id));
            postparams.add(new BasicNameValuePair("venueid", this.venueid));
            postparams.add(new BasicNameValuePair("bundleid", App.act.getPackageName()));
            C1199DB.jsonToDB(Internet.request("getVenue", postparams), "venueid == " + this.venueid);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
                if (App.tablet) {
                    Intent intent = new Intent(TCVenueList.this.getActivity(), TCLauncher.class);
                    intent.putExtra("venueid", this.venueid);
                    TCVenueList.this.startActivity(intent);
                    return;
                }
                List<TCObject> list = C1199DB.getListFromDb("launchers", "venueid", this.venueid);
                int numlaunchers = list.size();
                for (TCObject item : list) {
                    if (!LauncherUtil.hasFragment(item)) {
                        numlaunchers--;
                    }
                }
                if (numlaunchers == 0) {
                    return;
                }
                if (numlaunchers > 1) {
                    TCVenueList.this.analytics = "/venue/" + this.venueid;
                    Fragments.add(TCVenueList.this, TCLauncherPhoneFragment.newInstance("venueid", this.venueid), (String) null);
                    return;
                }
                for (TCObject item2 : list) {
                    if (LauncherUtil.hasFragment(item2)) {
                        TCVenueList.this.analytics = "/venue/" + this.venueid;
                        if (item2.get("moduletypeid").equals("21")) {
                            Fragments.add(TCVenueList.this, VenueInfoFragment.newInstance(this.venueid), item2.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                            return;
                        } else {
                            Fragments.add(TCVenueList.this, LauncherUtil.getFragment(item2), item2.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                            return;
                        }
                    }
                }
            }
        }
    }
}
