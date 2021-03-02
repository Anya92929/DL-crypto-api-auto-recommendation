package com.tapcrowd.app.modules.groups;

import android.content.Context;
import android.os.Bundle;
import android.support.p000v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.business.CatalogDropDownDetail;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.TCDBHelper;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.views.SearchBar;
import java.util.List;

public class GroupImageList extends TCListFragment {
    private String typeid;

    public static GroupImageList newInstance(String typeid2) {
        GroupImageList list = new GroupImageList();
        list.typeid = typeid2;
        return list;
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
            TCListObject.TCListObjectAdapter adapter = new TCListObject.TCListObjectAdapter((List) TCDBHelper.getTCListFromDb(String.format("SELECT id, imageurl, order_value, name, tag FROM (SELECT id, imageurl, '' AS order_value, name, 'group' AS tag FROM groups WHERE parentid == '%1$s' UNION SELECT catalog.id, imageurl, order_value, name, 'catalog' AS tag FROM catalog INNER JOIN groupitems ON groupitems.itemid == catalog.id WHERE type IS NULL AND itemtable == 'catalog' AND groupitems.groupid == '%1$s') ORDER BY order_value +0 DESC, name COLLATE NOCASE", new Object[]{this.typeid}), new TCDBHelper.TCListHelperObject(DBFavorites.KEY_NAME, (String) null, "imageurl", true), true, true), 0, false);
            adapter.setLayout(C0846R.layout.cell_image_list);
            getListView().addHeaderView(new SearchBar((Context) getActivity(), (ListFragment) this));
            setListAdapter(adapter);
        }
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        Object o = l.getItemAtPosition(position);
        if (o instanceof TCListObject) {
            TCListObject tlo = (TCListObject) o;
            if (tlo.getSearch().equals("group")) {
                Fragments.add(this, GroupListFragment.newInstance("parentid", tlo.getId()), tlo.getText());
            } else {
                Fragments.add(this, CatalogDropDownDetail.newInstance(tlo.getId(), 0), getResourceString(C0846R.string.detail));
            }
        }
    }
}
