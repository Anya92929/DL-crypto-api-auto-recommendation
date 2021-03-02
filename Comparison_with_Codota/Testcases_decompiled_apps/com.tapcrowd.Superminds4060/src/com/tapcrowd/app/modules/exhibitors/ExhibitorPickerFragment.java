package com.tapcrowd.app.modules.exhibitors;

import android.content.Intent;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.OnFragmentResultListener;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.views.SearchBar;
import java.util.ArrayList;
import java.util.List;

public class ExhibitorPickerFragment extends TCListFragment {
    /* access modifiers changed from: private */
    public SearchBar.TextChangedListener listener = new SearchBar.TextChangedListener() {
        public void textChanged(CharSequence s, int count) {
            ((TCListObject.TCListObjectAdapter) ExhibitorPickerFragment.this.getListAdapter()).getFilter().filter(s);
        }
    };
    private int mapheight = 1;
    private String mapid;
    private int mapwidth = 1;
    private int requestcode;
    private OnFragmentResultListener resultListener;
    private boolean retain;

    /* renamed from: v */
    private View f2032v;

    public static ExhibitorPickerFragment newInstance(OnFragmentResultListener resultListener2, int requestcode2, String mapwidth2, String mapheight2, String mapid2) {
        ExhibitorPickerFragment fr = new ExhibitorPickerFragment();
        fr.requestcode = requestcode2;
        fr.mapwidth = Integer.parseInt(mapwidth2);
        fr.mapheight = Integer.parseInt(mapheight2);
        fr.mapid = mapid2;
        fr.resultListener = resultListener2;
        return fr;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2032v == null) {
            this.f2032v = inflater.inflate(C0846R.layout.listview, container, false);
        } else {
            ((ViewGroup) this.f2032v.getParent()).removeView(this.f2032v);
            this.retain = true;
        }
        return this.f2032v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!this.retain) {
            setupListView();
        }
    }

    private void setupListView() {
        new LoadListTask(this, (LoadListTask) null).execute(new Void[0]);
    }

    private class LoadListTask extends AsyncTask<Void, Void, Void> {
        private List<Object> exhibitors;

        private LoadListTask() {
            this.exhibitors = new ArrayList();
        }

        /* synthetic */ LoadListTask(ExhibitorPickerFragment exhibitorPickerFragment, LoadListTask loadListTask) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            C1232UI.show(C0846R.C0847id.titloader);
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            for (TCObject item : C1199DB.getQueryFromDb("SELECT id, booth, name, image_large, x1, y1 FROM exhibitors ORDER BY name COLLATE LOCALIZED")) {
                if (ExhibitorPickerFragment.this.hasARoute(item)) {
                    this.exhibitors.add(new TCListObject(item.get(DBFavorites.KEY_EVENT_ID), item.get(DBFavorites.KEY_NAME), item.get("booth"), (String) null, item.get("image_large", (String) null), (Boolean) true));
                }
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
            ExhibitorPickerFragment.this.getListView().addHeaderView(new SearchBar(ExhibitorPickerFragment.this.getActivity(), ExhibitorPickerFragment.this, ExhibitorPickerFragment.this.listener));
            ExhibitorPickerFragment.this.setListAdapter(new TCListObject.TCListObjectAdapter(this.exhibitors));
        }
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        finishWithResult(((TCListObject) l.getItemAtPosition(position)).getId());
        super.onListItemClick(l, v, position, id);
    }

    private void finishWithResult(String id) {
        Bundle conData = new Bundle();
        conData.putString(DBFavorites.KEY_EVENT_ID, id);
        Intent intent = new Intent();
        intent.putExtras(conData);
        this.resultListener.onFragmentResult(intent, this.requestcode, -1);
        getActivity().onBackPressed();
    }

    public boolean hasARoute(TCObject tco) {
        new ArrayList();
        int rectWidth = (int) (((double) this.mapwidth) * 0.05d);
        int rectHeight = (int) (((double) this.mapheight) * 0.05d);
        Point point = new Point((int) Float.parseFloat(tco.get("x1")), (int) Float.parseFloat(tco.get("y1")));
        if (C1199DB.getListFromDb("indoor_routing_points", "'1'", "1' AND x+0 BETWEEN " + (point.x - rectWidth) + " AND " + (point.x + rectWidth) + " AND y+0 BETWEEN " + (point.y - rectHeight) + " AND " + (point.y + rectHeight) + " AND mapid =='" + this.mapid).isEmpty()) {
            return false;
        }
        return true;
    }
}
