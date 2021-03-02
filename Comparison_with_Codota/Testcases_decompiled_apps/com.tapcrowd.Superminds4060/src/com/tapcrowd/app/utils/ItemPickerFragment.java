package com.tapcrowd.app.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.views.SearchBar;

public class ItemPickerFragment extends TCListFragment {
    private ListAdapter adapter;
    private int requestcode;
    private OnFragmentResultListener resultListener;

    public static ItemPickerFragment newInstance(OnFragmentResultListener resultListener2, ListAdapter adapter2, int requestcode2) {
        ItemPickerFragment fr = new ItemPickerFragment();
        fr.requestcode = requestcode2;
        fr.adapter = adapter2;
        fr.resultListener = resultListener2;
        return fr;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2007v == null) {
            this.f2007v = inflater.inflate(C0846R.layout.listview, container, false);
        } else {
            ((ViewGroup) this.f2007v.getParent()).removeView(this.f2007v);
            this.retained = true;
        }
        return this.f2007v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!this.retained) {
            getListView().addHeaderView(new SearchBar((Context) getActivity(), (ListFragment) this));
            setListAdapter(this.adapter);
        }
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = l.getItemAtPosition(position);
        if (o instanceof TCListObject) {
            Intent data = new Intent();
            data.putExtra(DBFavorites.KEY_EVENT_ID, ((TCListObject) o).getId());
            this.resultListener.onFragmentResult(data, this.requestcode, -1);
            Fragments.back();
        }
    }
}
