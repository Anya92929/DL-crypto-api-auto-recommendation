package com.tapcrowd.app.modules;

import android.content.Context;
import android.os.Bundle;
import android.support.p000v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.attendees.AttendeeDetailFragment;
import com.tapcrowd.app.modules.business.CatalogDetailFragment;
import com.tapcrowd.app.modules.exhibitors.ExhibitorDetailFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.sessions.SessionDetailFragment;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.views.SearchBar;

public class LinkedFragment extends TCListFragment {
    private TCListObject.TCListObjectAdapter adapter;

    public static LinkedFragment newInstance(TCListObject.TCListObjectAdapter adapter2) {
        LinkedFragment fr = new LinkedFragment();
        fr.adapter = adapter2;
        return fr;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2007v == null) {
            this.f2007v = inflater.inflate(C0846R.layout.listview, container, false);
        } else {
            this.retained = true;
            ((ViewGroup) this.f2007v.getParent()).removeView(this.f2007v);
        }
        return this.f2007v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!this.retained) {
            SearchBar searchbar = new SearchBar((Context) getActivity(), (ListFragment) this);
            if (getListView().getHeaderViewsCount() == 0) {
                getListView().addHeaderView(searchbar);
            }
            setListAdapter(this.adapter);
        }
    }

    public void onListItemClick(ListView l, View v, int position, long lid) {
        Object obj = l.getItemAtPosition(position);
        if (obj instanceof TCListObject) {
            String info = ((TCListObject) obj).getId();
            String type = info.split(":")[0];
            String id = info.split(":")[1];
            if (type.equals(DBFavorites.TABLE_EXHIBITORS)) {
                Fragments.add(this, ExhibitorDetailFragment.newInstance(id), getString(C0846R.string.detail));
            } else if (type.equals(LinkedObjects.TABLE_CAT)) {
                Fragments.add(this, CatalogDetailFragment.newInstance(id, (String) null), getString(C0846R.string.detail));
            } else if (type.equals(LinkedObjects.TABLE_ATT)) {
                Fragments.add(this, AttendeeDetailFragment.newInstance(id), getString(C0846R.string.detail));
            } else if (type.equals("sessions")) {
                Fragments.add(this, SessionDetailFragment.newInstance(id), getString(C0846R.string.detail));
            }
        }
    }
}
