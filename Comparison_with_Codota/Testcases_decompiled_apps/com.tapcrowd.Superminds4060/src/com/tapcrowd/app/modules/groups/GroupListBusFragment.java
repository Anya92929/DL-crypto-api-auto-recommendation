package com.tapcrowd.app.modules.groups;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.business.CatalogDetailFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import java.util.ArrayList;
import java.util.List;

public class GroupListBusFragment extends TCListFragment {
    String module;
    String title;

    public static GroupListBusFragment newInstance(String module2, String title2) {
        GroupListBusFragment list = new GroupListBusFragment();
        list.module = module2;
        list.title = title2;
        return list;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_MODULE, this.module);
        outState.putString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.title);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C0846R.layout.bus_listview, container, false);
        AdHelper.showAds(this, AdHelper.buildPath("25", "list", (String) null));
        if (savedInstanceState != null && this.module == null) {
            this.module = savedInstanceState.getString(DBFavorites.KEY_MODULE);
            this.title = savedInstanceState.getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        }
        C1232UI.setText((int) C0846R.C0847id.name, String.valueOf(this.title.substring(0, 1).toUpperCase()) + this.title.substring(1).toLowerCase(), v);
        TextView n = (TextView) v.findViewById(C0846R.C0847id.name);
        n.setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor) - 570425344);
        n.setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        n.setVisibility(8);
        List<TCListObject> listitems = new ArrayList<>();
        for (TCObject tco : C1199DB.getListFromDb(LinkedObjects.TABLE_CAT, "LOWER(type)", this.module.toLowerCase(), "order_value +0 DESC, name COLLATE NOCASE")) {
            listitems.add(new TCListObject(tco, DBFavorites.KEY_EVENT_ID, DBFavorites.KEY_NAME, (String) null, (String) null, "imagethumb"));
        }
        TCListObject.TCListObjectAdapter adapter = new TCListObject.TCListObjectAdapter(listitems, 0);
        adapter.setLayout(C0846R.layout.cell_tcobject);
        setListAdapter(adapter);
        return v;
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        Fragments.add(this, CatalogDetailFragment.newInstance(((TCListObject) l.getItemAtPosition(position)).getId(), this.module), getResourceString(C0846R.string.detail));
        super.onListItemClick(l, v, position, id);
    }
}
