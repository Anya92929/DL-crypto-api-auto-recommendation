package com.tapcrowd.app.modules.business;

import android.content.Intent;
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

public class CatalogPickerFragment extends TCListFragment {
    /* access modifiers changed from: private */
    public SearchBar.TextChangedListener listener = new SearchBar.TextChangedListener() {
        public void textChanged(CharSequence s, int count) {
            ((TCListObject.TCListObjectAdapter) CatalogPickerFragment.this.getListAdapter()).getFilter().filter(s);
        }
    };
    private int requestcode;
    private OnFragmentResultListener resultListener;
    private boolean retain;

    /* renamed from: v */
    private View f2022v;

    public static CatalogPickerFragment newInstance(OnFragmentResultListener resultListener2, int requestcode2) {
        CatalogPickerFragment cp = new CatalogPickerFragment();
        cp.requestcode = requestcode2;
        cp.resultListener = resultListener2;
        return cp;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2022v == null) {
            this.f2022v = inflater.inflate(C0846R.layout.listview, container, false);
        } else {
            ((ViewGroup) this.f2022v.getParent()).removeView(this.f2022v);
            this.retain = true;
        }
        return this.f2022v;
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
        private List<Object> catalogitems;

        private LoadListTask() {
            this.catalogitems = new ArrayList();
        }

        /* synthetic */ LoadListTask(CatalogPickerFragment catalogPickerFragment, LoadListTask loadListTask) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            C1232UI.show(C0846R.C0847id.titloader);
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            for (TCObject item : C1199DB.getQueryFromDb("SELECT * FROM catalog")) {
                this.catalogitems.add(new TCListObject(item.get(DBFavorites.KEY_EVENT_ID), item.get(DBFavorites.KEY_NAME), (String) null, (String) null, item.get("imageurl", ""), (Boolean) true));
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
            CatalogPickerFragment.this.getListView().addHeaderView(new SearchBar(CatalogPickerFragment.this.getActivity(), CatalogPickerFragment.this, CatalogPickerFragment.this.listener));
            CatalogPickerFragment.this.setListAdapter(new TCListObject.TCListObjectAdapter(this.catalogitems));
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
}
