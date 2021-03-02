package com.tapcrowd.app.modules.sessions;

import android.content.Context;
import android.os.Bundle;
import android.support.p000v4.app.ListFragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.TCDBHelper;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.views.SearchBar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.cordova.Globalization;

public class SessionListFragment extends ListFragment {

    /* renamed from: $SWITCH_TABLE$com$tapcrowd$app$modules$sessions$SessionListFragment$ViewType */
    private static /* synthetic */ int[] f2114x9fced4ac;
    Comparator<TCObject> dateSort = new Comparator<TCObject>() {
        public int compare(TCObject lhs, TCObject rhs) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                return Long.valueOf(sdf.parse(lhs.get(Globalization.DATE)).getTime()).compareTo(Long.valueOf(sdf.parse(rhs.get(Globalization.DATE)).getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
                return 0;
            }
        }
    };
    private String eventid;
    private String parameter;
    private String speakerid;
    public String title;
    private ViewType viewType;

    enum SepType {
        Day,
        Alpha,
        SessionGroup,
        Location,
        None
    }

    enum ViewType {
        Type,
        Location,
        DateTime,
        Alpha,
        Empty
    }

    /* renamed from: $SWITCH_TABLE$com$tapcrowd$app$modules$sessions$SessionListFragment$ViewType */
    static /* synthetic */ int[] m2210x9fced4ac() {
        int[] iArr = f2114x9fced4ac;
        if (iArr == null) {
            iArr = new int[ViewType.values().length];
            try {
                iArr[ViewType.Alpha.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ViewType.DateTime.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ViewType.Empty.ordinal()] = 5;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ViewType.Location.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ViewType.Type.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            f2114x9fced4ac = iArr;
        }
        return iArr;
    }

    public static SessionListFragment newInstance(ViewType viewType2, String parameter2, String speakerid2, String eventid2) {
        SessionListFragment fr = new SessionListFragment();
        fr.viewType = viewType2;
        fr.parameter = parameter2;
        fr.speakerid = speakerid2 == null ? "COALESCE(speaker_session.speakerid, '') LIKE '%'  AND sessions.parentid == '0'" : "speaker_session.speakerid == '" + speakerid2 + "'";
        fr.eventid = eventid2;
        return fr;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("parameter", this.parameter);
        outState.putSerializable("viewType", this.viewType);
        outState.putSerializable("speakerid", this.speakerid);
        outState.putSerializable("eventid", this.eventid);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C0846R.layout.listview, container, false);
        v.findViewById(C0846R.C0847id.title).setVisibility(8);
        v.findViewById(C0846R.C0847id.main).setBackgroundColor(C1216LO.getLo(C1216LO.backgroundColor));
        ListView lv = (ListView) v.findViewById(16908298);
        lv.setFastScrollEnabled(true);
        if (lv.getHeaderViewsCount() == 0) {
            lv.addHeaderView(new SearchBar((Context) getActivity(), (ListFragment) this));
        }
        if (savedInstanceState != null) {
            this.viewType = (ViewType) savedInstanceState.getSerializable("viewType");
            this.parameter = savedInstanceState.getString("parameter");
            this.speakerid = savedInstanceState.getString("speakerid");
            this.eventid = savedInstanceState.getString("eventid");
        }
        return v;
    }

    public void onListItemClick(ListView l, View arg1, int position, long arg3) {
        Object clicked = l.getAdapter().getItem(position);
        if (clicked.getClass() == TCListObject.class) {
            Fragments.add(this, SessionDetailFragment.newInstance(((TCListObject) clicked).getId()), getString(C0846R.string.detail));
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        switch (m2210x9fced4ac()[this.viewType.ordinal()]) {
            case 1:
                showType();
                return;
            case 2:
                showLocation();
                return;
            case 3:
                showDateTime();
                return;
            case 4:
                showAlpha();
                return;
            case 5:
                showEmpty();
                return;
            default:
                return;
        }
    }

    public int getSize() {
        switch (m2210x9fced4ac()[this.viewType.ordinal()]) {
            case 1:
                return Integer.parseInt(C1199DB.getQueryFromDb("SELECT COUNT(sessions.id) AS count FROM sessions LEFT JOIN speaker_session ON sessions.id == speaker_session.sessionid WHERE sessions.sessiongroupid == '" + this.parameter + "' AND " + this.speakerid).get(0).get("count"));
            case 2:
                return Integer.parseInt(C1199DB.getQueryFromDb("SELECT COUNT(sessions.id) AS count FROM sessions LEFT JOIN speaker_session ON sessions.id == speaker_session.sessionid WHERE " + this.speakerid + " AND sessions.eventid == '" + this.eventid + "' AND location IN (SELECT location FROM sessions WHERE id =='" + this.parameter + "')").get(0).get("count"));
            case 3:
                return Integer.parseInt(C1199DB.getQueryFromDb("SELECT COUNT(sessions.id) AS count FROM sessions LEFT JOIN speaker_session ON sessions.id == speaker_session.sessionid WHERE " + this.speakerid + " AND sessions.eventid == '" + this.eventid + "' AND date == '" + this.parameter + "'").get(0).get("count"));
            default:
                return 0;
        }
    }

    private void showType() {
        List<TCObject> sessions = C1199DB.getQueryFromDb("SELECT sessions.*, GROUP_CONCAT(tagsv2.tag, ' ') AS tag, premium.title AS premium FROM sessions LEFT JOIN speaker_session ON sessions.id == speaker_session.sessionid LEFT OUTER JOIN tagsv2 ON tagsv2.itemid == sessions.id AND tagsv2.itemtype == 'session' LEFT OUTER JOIN premium ON premium.tableId == sessions.id AND premium.tablename == 'session' WHERE sessions.sessiongroupid == '" + this.parameter + "' AND " + this.speakerid + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "GROUP BY sessions.id " + "ORDER BY sessions.starttime, sessions.endtime, sessions.name COLLATE NOCASE");
        Collections.sort(sessions, this.dateSort);
        TCListObject.TCListObjectAdapter adapter = new TCListObject.TCListObjectAdapter((List) getListItems(sessions, SepType.Day), 0, false);
        adapter.setLayout(C0846R.layout.cell_session_new);
        setListAdapter(adapter);
    }

    public void showLocation() {
        TCListObject.TCListObjectAdapter adapter = new TCListObject.TCListObjectAdapter((List) getListItems(C1199DB.getQueryFromDb("SELECT sessions.*, GROUP_CONCAT(tagsv2.tag, ' ') AS tag, premium.title AS premium FROM sessions LEFT JOIN speaker_session ON sessions.id == speaker_session.sessionid LEFT OUTER JOIN tagsv2 ON tagsv2.itemid == sessions.id AND tagsv2.itemtype == 'session' LEFT OUTER JOIN premium ON premium.tableId == sessions.id AND premium.tablename == 'session' WHERE " + this.speakerid + " AND sessions.eventid == '" + this.eventid + "' AND location IN (SELECT location FROM sessions WHERE id =='" + this.parameter + "') " + "GROUP BY sessions.id " + "ORDER BY date(sessions.startdate), sessions.starttime, sessions.endtime"), SepType.Day), 0, false);
        adapter.setLayout(C0846R.layout.cell_session_new);
        setListAdapter(adapter);
    }

    public void showDateTime() {
        TCListObject.TCListObjectAdapter adapter = new TCListObject.TCListObjectAdapter((List) getListItems(C1199DB.getQueryFromDb("SELECT sessiongroups.name AS groupname, sessions.*, GROUP_CONCAT(tagsv2.tag, ' ') AS tag, premium.title AS premium FROM sessions LEFT JOIN speaker_session ON sessions.id == speaker_session.sessionid LEFT OUTER JOIN tagsv2 ON tagsv2.itemid == sessions.id AND tagsv2.itemtype == 'session' LEFT OUTER JOIN sessiongroups ON sessiongroups.id == sessions.sessiongroupid LEFT OUTER JOIN premium ON premium.tableId == sessions.id AND premium.tablename == 'session' WHERE " + this.speakerid + " AND sessions.eventid == '" + this.eventid + "' AND date == '" + this.parameter + "' " + "GROUP BY sessions.id " + "ORDER BY sessions.location, sessions.starttime, sessions.endtime"), SepType.Location), 0, false);
        adapter.setLayout(C0846R.layout.cell_session_new);
        setListAdapter(adapter);
    }

    public void showAlpha() {
        TCListObject.TCListObjectAdapter adapter = new TCListObject.TCListObjectAdapter((List) TCDBHelper.getTCListFromDb(String.format("SELECT sessions.id, sessions.name, sessions.starttime || ' - ' || sessions.endtime AS time, GROUP_CONCAT(tagsv2.tag, ' ') AS tag, GROUP_CONCAT(sp.name , ', ') AS speakernames, sessions.order_value FROM sessions LEFT OUTER JOIN tagsv2 ON tagsv2.itemid == sessions.id AND tagsv2.itemtype == 'session' LEFT JOIN speaker_session ON sessions.id == speaker_session.sessionid LEFT OUTER JOIN speakers sp ON sp.id == speaker_session.speakerid WHERE %1$s AND sessions.eventid == '%2$s' GROUP BY sessions.id ORDER BY sessions.name", new Object[]{this.speakerid, this.eventid}), new TCDBHelper.TCListHelperObject(DBFavorites.KEY_NAME, Globalization.TIME, "speakernames", (String) null), true), 0, true);
        adapter.setLayout(C0846R.layout.cell_session_new);
        setListAdapter(adapter);
    }

    private void showEmpty() {
        TCListObject.TCListObjectAdapter adapter = new TCListObject.TCListObjectAdapter((List) new ArrayList<>(), 0, true);
        adapter.setLayout(C0846R.layout.cell_session_new);
        setListAdapter(adapter);
    }

    public List<Object> getListItems(List<TCObject> sessions) {
        return getListItems(sessions, SepType.None);
    }

    public List<Object> getListItems(List<TCObject> sessions, SepType sepType) {
        List<Object> listitems = new ArrayList<>();
        List<Object> premium = new ArrayList<>();
        for (TCObject session : sessions) {
            if (sepType == SepType.Day) {
                try {
                    String s = DateFormat.getLongDateFormat(getActivity()).format(new SimpleDateFormat("dd/MM/yyyy").parse(session.get(Globalization.DATE)));
                    if (!listitems.contains(s)) {
                        listitems.add(s);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (sepType == SepType.Alpha) {
                String s2 = session.get(DBFavorites.KEY_NAME).substring(0, 1).toUpperCase();
                if (!listitems.contains(s2)) {
                    listitems.add(s2);
                }
            } else if (sepType == SepType.SessionGroup) {
                String groupname = session.get("groupname", "");
                if (!listitems.contains(groupname)) {
                    listitems.add(groupname);
                }
            } else if (sepType == SepType.Location) {
                String location = session.get("location", "");
                if (!listitems.contains(location)) {
                    listitems.add(location);
                }
            }
            String sub2 = "";
            List<TCObject> speakers = C1199DB.getQueryFromDb("SELECT name FROM speakers INNER JOIN speaker_session ON speakers.id == speaker_session.speakerid WHERE speaker_session.sessionid == '" + session.get(DBFavorites.KEY_EVENT_ID) + "';");
            if (speakers.size() > 0) {
                for (TCObject item : speakers) {
                    sub2 = String.valueOf(sub2) + item.get(DBFavorites.KEY_NAME);
                    if (!item.equals(speakers.get(speakers.size() - 1))) {
                        sub2 = String.valueOf(sub2) + ", ";
                    }
                }
            }
            if (sub2.equals("")) {
                sub2 = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
            }
            TCListObject object = new TCListObject(session.get(DBFavorites.KEY_EVENT_ID), session.get(DBFavorites.KEY_NAME), String.valueOf(session.get("starttime")) + " - " + session.get("endtime"), sub2, (String) null).setSearch(session.get("tag", ""));
            if (session.has("premium")) {
                object.ispremium = true;
                if (!premium.contains(session.get("premium"))) {
                    premium.add(session.get("premium"));
                }
                premium.add(object);
            }
            listitems.add(object);
        }
        listitems.addAll(0, premium);
        return listitems;
    }
}
