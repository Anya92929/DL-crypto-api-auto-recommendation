package com.tapcrowd.app.modules.sessions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import java.util.ArrayList;
import java.util.List;

public class FestivalFavoritesFragment extends TCListFragment {
    public static FestivalFavoritesFragment newInstance() {
        return new FestivalFavoritesFragment();
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
        if (this.retained) {
        }
    }

    public void onResume() {
        super.onResume();
        List<Object> listitems = new ArrayList<>();
        for (TCObject group : C1199DB.getListFromDb("sessiongroups", "order_value +0 DESC")) {
            List<TCObject> list = C1199DB.getQueryFromDb("SELECT * FROM favorites LEFT JOIN sessions ON sessions.id == favorites.sessionid WHERE sessions.sessiongroupid == '" + group.get(DBFavorites.KEY_EVENT_ID) + "' ORDER BY sessions.order_value + 0 DESC, startdate");
            if (list.size() > 0) {
                listitems.add(group.get(DBFavorites.KEY_NAME));
            }
            for (TCObject tco : list) {
                listitems.add(new TCListObject(tco.get(DBFavorites.KEY_EVENT_ID), tco.get(DBFavorites.KEY_NAME), String.valueOf(tco.get("starttime")) + " - " + tco.get("endtime") + "   " + tco.get("location"), (String) null, tco.get("imageurl", "thumb")));
            }
        }
        List<TCObject> list2 = C1199DB.getQueryFromDb("SELECT * FROM favorites LEFT JOIN sessions ON sessions.id == favorites.sessionid WHERE sessions.sessiongroupid == '0' ORDER BY sessions.order_value + 0 DESC, startdate");
        if (list2.size() > 0) {
            listitems.add(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        }
        for (TCObject tco2 : list2) {
            listitems.add(new TCListObject(tco2.get(DBFavorites.KEY_EVENT_ID), tco2.get(DBFavorites.KEY_NAME), String.valueOf(tco2.get("starttime")) + " - " + tco2.get("endtime") + "   " + tco2.get("location"), (String) null, tco2.get("imageurl", "thumb")));
        }
        TCListObject.TCListObjectAdapter adapter = new TCListObject.TCListObjectAdapter(listitems);
        adapter.setLayout(C0846R.layout.cell_tcobject_square);
        setListAdapter(adapter);
        if (listitems.size() == 0) {
            this.f2007v.findViewById(C0846R.C0847id.emptycontainer).setVisibility(0);
            ((TextView) this.f2007v.findViewById(C0846R.C0847id.empty)).setText(getString(C0846R.string.nofavoritesfest));
        }
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        Object o = l.getItemAtPosition(position);
        if (o instanceof TCListObject) {
            Fragments.add(this, FestivalSessionDetailFragment.newInstance(((TCListObject) o).getId()), ((TCListObject) o).getText());
        }
    }
}
