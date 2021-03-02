package com.tapcrowd.app.utils;

import android.database.Cursor;
import android.support.p000v4.app.Fragment;
import android.view.View;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.modules.LinkedFragment;
import com.tapcrowd.app.modules.attendees.AttendeeDetailFragment;
import com.tapcrowd.app.modules.business.CatalogDetailFragment;
import com.tapcrowd.app.modules.exhibitors.ExhibitorDetailFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.sessions.SessionDetailFragment;
import com.tapcrowd.app.utils.TCDBHelper;
import com.tapcrowd.app.utils.TCListObject;
import java.util.List;
import org.apache.cordova.Globalization;

public class LinkedObjects {
    private static final String MOD_ID_ATT = "14";
    private static final String MOD_ID_CAT = "15";
    private static final String MOD_ID_EXHI = "2";
    private static final String MOD_ID_SESS = "10";
    public static final String TABLE_ATT = "attendees";
    public static final String TABLE_CAT = "catalog";
    public static final String TABLE_EXHI = "exhibitor";
    public static final String TABLE_SESS = "sessions";
    private static final String[] TYPES = {TABLE_EXHI, TABLE_CAT, TABLE_ATT, "sessions"};

    public static void add(Fragment caller, View v, String parenttype, String parentid) {
        int index;
        for (String type : TYPES) {
            if (!parenttype.equals(type)) {
                Cursor c = C1199DB.getDatabase().rawQuery("SELECT DISTINCT destinationitemid FROM linkedobject WHERE originaltable == ? AND originitemid == ? AND destinationtable == ?", new String[]{parenttype, parentid, type});
                String[] ids = new String[c.getCount()];
                int index2 = 0;
                int idIndex = c.getColumnIndex("destinationitemid");
                if (c.moveToFirst()) {
                    while (true) {
                        index = index2 + 1;
                        ids[index2] = c.getString(idIndex);
                        if (!c.moveToNext()) {
                            break;
                        }
                        index2 = index;
                    }
                    int i = index;
                }
                if (ids.length > 0) {
                    C1232UI.addCell(v, getLauncherTitle(type), (View.OnClickListener) new LinkedCellClickListener(caller, type, ids), C1232UI.getColorOverlay((int) C0846R.drawable.icon_linked, C1216LO.getLo(C1216LO.actionImageOverlayColor)));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static String getLauncherTitle(String parenttype) {
        String modTypeId = "";
        if (parenttype.equals(TABLE_EXHI)) {
            modTypeId = MOD_ID_EXHI;
        }
        if (parenttype.equals(TABLE_CAT)) {
            modTypeId = MOD_ID_CAT;
        }
        if (parenttype.equals(TABLE_ATT)) {
            modTypeId = MOD_ID_ATT;
        }
        if (parenttype.equals("sessions")) {
            modTypeId = MOD_ID_SESS;
        }
        return C1199DB.getFirstObject("launchers", "moduletypeid", modTypeId).get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "");
    }

    private static class LinkedCellClickListener implements View.OnClickListener {
        Fragment caller;
        String[] ids;
        String type;

        public LinkedCellClickListener(Fragment caller2, String type2, String[] ids2) {
            this.caller = caller2;
            this.type = type2;
            this.ids = ids2;
        }

        public void onClick(View v) {
            if (this.type.equals(LinkedObjects.TABLE_EXHI)) {
                exibitors();
            }
            if (this.type.equals(LinkedObjects.TABLE_CAT)) {
                catalog();
            }
            if (this.type.equals(LinkedObjects.TABLE_ATT)) {
                attendees();
            }
            if (this.type.equals("sessions")) {
                sessions();
            }
        }

        private void exibitors() {
            if (this.ids.length == 1) {
                Fragments.add(this.caller, ExhibitorDetailFragment.newInstance(this.ids[0]), this.caller.getString(C0846R.string.detail));
                return;
            }
            Fragments.add(this.caller, LinkedFragment.newInstance(new TCListObject.TCListObjectAdapter((List) TCDBHelper.getTCListFromDb(String.format("SELECT 'exhibitors:' || exhibitors.id AS id, CASE WHEN exhibitors.booth IS NULL THEN '' ELSE '%1$s ' || exhibitors.booth END AS booth, exhibitors.name, exhibitors.image_large, GROUP_CONCAT(tagsv2.tag, ' ') as tag FROM exhibitors LEFT OUTER JOIN tagsv2 ON tagsv2.itemid == exhibitors.id AND tagsv2.itemtype == 'exhibitor' WHERE exhibitors.id IN (%1$s) GROUP BY exhibitors.id ORDER BY name COLLATE LOCALIZED", new Object[]{idsToString()}), new TCDBHelper.TCListHelperObject(DBFavorites.KEY_NAME, "booth", "image_large", true), true), (int) C0846R.drawable.l_def_exhibitors, true)), LinkedObjects.getLauncherTitle(this.type));
        }

        private void catalog() {
            if (this.ids.length == 1) {
                Fragments.add(this.caller, CatalogDetailFragment.newInstance(this.ids[0]), this.caller.getString(C0846R.string.detail));
                return;
            }
            Fragments.add(this.caller, LinkedFragment.newInstance(new TCListObject.TCListObjectAdapter((List) TCDBHelper.getTCListFromDb(String.format("SELECT 'catalog:' || id AS id, name, order_value FROM catalog WHERE id IN (%1$s) ORDER BY name", new Object[]{idsToString()}), new TCDBHelper.TCListHelperObject(DBFavorites.KEY_NAME, (String) null, (String) null), true), 0, true)), LinkedObjects.getLauncherTitle(this.type));
        }

        private void attendees() {
            if (this.ids.length == 1) {
                Fragments.add(this.caller, AttendeeDetailFragment.newInstance(this.ids[0]), this.caller.getString(C0846R.string.detail));
                return;
            }
            Fragments.add(this.caller, LinkedFragment.newInstance(new TCListObject.TCListObjectAdapter(TCDBHelper.getTCListFromDb(String.format("SELECT 'attendees:' || attendees.id AS id, attendees.firstname || ' ' || attendees.name AS name, attendees.company, attendees.imageurl, attendees.order_value, attendees.company || ' ' || attendees.country || ' ' || IFNULL(GROUP_CONCAT(tagsv2.tag, ' '), '') AS tag FROM attendees LEFT OUTER JOIN tagsv2 ON tagsv2.itemid == attendees.id AND tagsv2.itemtype == 'attendees' WHERE attendees.id IN (%1$s) GROUP BY attendees.id ORDER BY attendees.firstname COLLATE LOCALIZED, attendees.name COLLATE LOCALIZED", new Object[]{idsToString()}), new TCDBHelper.TCListHelperObject(DBFavorites.KEY_NAME, "company", "imageurl", true)), C0846R.drawable.icon_attendee)), LinkedObjects.getLauncherTitle(this.type));
        }

        private void sessions() {
            if (this.ids.length == 1) {
                Fragments.add(this.caller, SessionDetailFragment.newInstance(this.ids[0]), this.caller.getString(C0846R.string.detail));
                return;
            }
            TCListObject.TCListObjectAdapter adapter = new TCListObject.TCListObjectAdapter((List) TCDBHelper.getTCListFromDb(String.format("SELECT 'sessions:' || s.id AS id, s.name, s.starttime || ' - ' || s.endtime AS time, GROUP_CONCAT(tagsv2.tag, ' ') AS tag, GROUP_CONCAT(sp.name , ', ') AS speakernames, s.order_value FROM sessions s LEFT OUTER JOIN tagsv2 ON tagsv2.itemid == s.id AND tagsv2.itemtype == 'session' LEFT JOIN speaker_session ON s.id == speaker_session.sessionid LEFT OUTER JOIN speakers sp ON sp.id == speaker_session.speakerid WHERE s.id IN (%1$s) GROUP BY s.id ORDER BY s.name", new Object[]{idsToString()}), new TCDBHelper.TCListHelperObject(DBFavorites.KEY_NAME, Globalization.TIME, "speakernames", (String) null), true), 0, true);
            adapter.setLayout(C0846R.layout.cell_session_new);
            Fragments.add(this.caller, LinkedFragment.newInstance(adapter), LinkedObjects.getLauncherTitle(this.type));
        }

        private String idsToString() {
            String result = "";
            for (String id : this.ids) {
                if (result.length() > 0) {
                    result = String.valueOf(result) + ", ";
                }
                result = String.valueOf(result) + id;
            }
            return result;
        }
    }
}
