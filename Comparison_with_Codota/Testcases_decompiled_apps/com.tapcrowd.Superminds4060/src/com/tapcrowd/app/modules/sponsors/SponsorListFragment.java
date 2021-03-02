package com.tapcrowd.app.modules.sponsors;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import java.util.ArrayList;
import java.util.List;

public class SponsorListFragment extends TCListFragment {
    public static SponsorListFragment newInstance() {
        return new SponsorListFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(C0846R.layout.listview, container, false);
    }

    public void onResume() {
        super.onResume();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AdHelper.showAds(this, AdHelper.buildPath("19", "list", (String) null));
        List<TCObject> groups = C1199DB.getListFromDb("sponsorgroups", "eventid", App.curEventId, "order_value +0 DESC, name COLLATE NOCASE");
        List<Object> listitems = new ArrayList<>();
        if (groups.size() > 0) {
            for (TCObject group : groups) {
                List<TCObject> sponsors = C1199DB.getListFromDb("sponsors", "sponsorgroupid", group.get(DBFavorites.KEY_EVENT_ID), "order_value +0 DESC, name");
                if (sponsors.size() > 0) {
                    listitems.add(group.get(DBFavorites.KEY_NAME).toUpperCase());
                    for (TCObject sponsor : sponsors) {
                        listitems.add(new TCListObject(sponsor.get(DBFavorites.KEY_EVENT_ID, ""), sponsor.get(DBFavorites.KEY_NAME, ""), (String) null, (String) null, sponsor.get("imagethumb")));
                    }
                }
            }
            setListAdapter(new TCListObject.TCListObjectAdapter(listitems, C0846R.drawable.l_def_exhibitors));
            return;
        }
        for (TCObject tco : C1199DB.getListFromDb("sponsors", "eventid", App.curEventId, "order_value +0 DESC, name")) {
            listitems.add(new TCListObject(tco.get(DBFavorites.KEY_EVENT_ID), tco.get(DBFavorites.KEY_NAME), "", "", tco.get("imagethumb"), (Boolean) true));
        }
        setListAdapter(new TCListObject.TCListObjectAdapter((List) listitems, (int) C0846R.drawable.l_def_exhibitors, false));
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        Object o = l.getAdapter().getItem(position);
        if (o.getClass() == TCListObject.class) {
            Fragments.add(this, SponsorDetailFragment.newInstance(((TCListObject) o).getId()), getResourceString(C0846R.string.detail));
        }
    }
}
