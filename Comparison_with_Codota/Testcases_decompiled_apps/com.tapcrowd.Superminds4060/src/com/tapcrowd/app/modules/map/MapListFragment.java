package com.tapcrowd.app.modules.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.TCListObject;
import java.util.ArrayList;
import java.util.List;

public class MapListFragment extends TCListFragment {
    String groupid;

    public static MapListFragment newInstance(String groupid2) {
        MapListFragment fr = new MapListFragment();
        fr.groupid = groupid2;
        return fr;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("groupid", this.groupid);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C0846R.layout.listview, container, false);
        if (savedInstanceState != null && this.groupid == null) {
            this.groupid = savedInstanceState.getString("groupid");
        }
        return v;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0061, code lost:
        r13 = com.tapcrowd.app.utils.C1199DB.getObject(com.tapcrowd.app.modules.favorites_v2.DBFavorites.TABLE_EXHIBITORS, com.tapcrowd.app.modules.favorites_v2.DBFavorites.KEY_EVENT_ID, r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityCreated(android.os.Bundle r16) {
        /*
            r15 = this;
            super.onActivityCreated(r16)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.lang.String r0 = "groupitems"
            java.lang.String r3 = "groupid"
            java.lang.String r4 = r15.groupid
            java.util.List r0 = com.tapcrowd.app.utils.C1199DB.getListFromDb(r0, r3, r4)
            r9.addAll(r0)
            java.util.Iterator r0 = r9.iterator()
        L_0x001e:
            boolean r3 = r0.hasNext()
            if (r3 != 0) goto L_0x0047
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Iterator r14 = r11.iterator()
        L_0x002d:
            boolean r0 = r14.hasNext()
            if (r0 != 0) goto L_0x0089
            com.tapcrowd.app.modules.map.MapListFragment$1 r0 = new com.tapcrowd.app.modules.map.MapListFragment$1
            r0.<init>()
            java.util.Collections.sort(r10, r0)
            com.tapcrowd.app.utils.TCListObject$TCListObjectAdapter r0 = new com.tapcrowd.app.utils.TCListObject$TCListObjectAdapter
            r3 = 2130837780(0x7f020114, float:1.7280524E38)
            r0.<init>(r10, r3)
            r15.setListAdapter(r0)
            return
        L_0x0047:
            java.lang.Object r7 = r0.next()
            com.tapcrowd.app.utils.TCObject r7 = (com.tapcrowd.app.utils.TCObject) r7
            java.lang.String r3 = "itemtable"
            java.lang.String r12 = r7.get(r3)
            java.lang.String r3 = "itemid"
            java.lang.String r8 = r7.get(r3)
            java.lang.String r3 = "exhibitor"
            boolean r3 = r12.equals(r3)
            if (r3 == 0) goto L_0x001e
            java.lang.String r3 = "exhibitors"
            java.lang.String r4 = "id"
            com.tapcrowd.app.utils.TCObject r13 = com.tapcrowd.app.utils.C1199DB.getObject(r3, r4, r8)
            java.lang.String r3 = "mapid"
            java.lang.String r1 = r13.get(r3)
            if (r1 == 0) goto L_0x001e
            java.lang.String r3 = "0"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x001e
            boolean r3 = r11.contains(r1)
            if (r3 != 0) goto L_0x001e
            java.lang.String r3 = "mapid"
            java.lang.String r3 = r13.get(r3)
            r11.add(r3)
            goto L_0x001e
        L_0x0089:
            java.lang.Object r1 = r14.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r0 = "map"
            java.lang.String r3 = "id"
            com.tapcrowd.app.utils.TCObject r0 = com.tapcrowd.app.utils.C1199DB.getFirstObject(r0, r3, r1)
            java.lang.String r3 = "title"
            java.lang.String r4 = ""
            java.lang.String r2 = r0.get((java.lang.String) r3, (java.lang.String) r4)
            com.tapcrowd.app.utils.TCListObject r0 = new com.tapcrowd.app.utils.TCListObject
            r3 = 0
            r4 = 0
            java.lang.String r5 = ""
            r6 = 2130837780(0x7f020114, float:1.7280524E38)
            r0.<init>((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (int) r6)
            r10.add(r0)
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapcrowd.app.modules.map.MapListFragment.onActivityCreated(android.os.Bundle):void");
    }

    public void onListItemClick(ListView l, View v, int position, long idd) {
        super.onListItemClick(l, v, position, idd);
        List<String> list = new ArrayList<>();
        list.add(this.groupid);
        Fragments.add(this, MapFragment.newInstance(((TCListObject) l.getAdapter().getItem(position)).getId(), list), this.title);
    }
}
