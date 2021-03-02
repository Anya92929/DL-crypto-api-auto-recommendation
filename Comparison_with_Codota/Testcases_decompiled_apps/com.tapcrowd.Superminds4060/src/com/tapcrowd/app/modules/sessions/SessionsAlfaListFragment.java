package com.tapcrowd.app.modules.sessions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.modules.speakers.SpeakerListFragment;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import java.util.ArrayList;
import java.util.List;

public class SessionsAlfaListFragment extends TCListFragment implements MenuFragment.MenuItemListener {
    private final int SPEAKERS = 1234;

    public static SessionsAlfaListFragment newInstance() {
        return new SessionsAlfaListFragment();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        if (this.title == null) {
            this.title = C1199DB.getFirstObject("launchers", "moduletypeid", "10").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(C0846R.layout.listview, container, false);
    }

    public void onResume() {
        super.onResume();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<Object> listitems = new ArrayList<>();
        for (TCObject session : C1199DB.getListFromDb("sessions", "eventid", App.curEventId, "name COLLATE NOCASE")) {
            String head = session.get(DBFavorites.KEY_NAME).substring(0, 1).toUpperCase();
            if (!listitems.contains(head)) {
                listitems.add(head);
            }
            listitems.add(new TCListObject(session.get(DBFavorites.KEY_EVENT_ID), session.get(DBFavorites.KEY_NAME), (String) null, (String) null, session.get("imageurl")));
        }
        getListView().setBackgroundColor(C1216LO.getLo(C1216LO.backgroundColor));
        getListView().setDividerHeight(1);
        TCListObject.TCListObjectAdapter tca = new TCListObject.TCListObjectAdapter((List) listitems, 0, false);
        tca.setLayout(C0846R.layout.cell_tcobject_square);
        setListAdapter(tca);
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = l.getAdapter().getItem(position);
        if (o.getClass() == TCListObject.class) {
            TCListObject tlo = (TCListObject) o;
            if (App.typeid.equals("10")) {
                Fragments.add(this, FestivalSessionDetailFragment.newInstance(tlo.getId()), getResourceString(C0846R.string.detail));
            } else {
                Fragments.add(this, SessionDetailFragment.newInstance(tlo.getId()), getResourceString(C0846R.string.detail));
            }
        }
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 1234:
                Fragments.add(this, SpeakerListFragment.newInstance(), getString(C0846R.string.speakers));
                return;
            default:
                return;
        }
    }
}
