package com.tapcrowd.app.utils;

import android.content.Context;
import android.database.Cursor;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.search.SearchListAllFragment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TCDBHelper {
    public static ArrayList<Object> getTCListFromDb(String query, TCListHelperObject helper) {
        return getTCListFromDb((ArrayList<Object>) null, query, helper, true, 0, false);
    }

    public static ArrayList<Object> getTCListFromDb(String query, TCListHelperObject helper, boolean separator) {
        return getTCListFromDb((ArrayList<Object>) null, query, helper, separator, 0, false);
    }

    public static ArrayList<Object> getTCListFromDb(ArrayList<Object> list, String query, TCListHelperObject helper, boolean separator) {
        return getTCListFromDb(list, query, helper, separator, 0, false);
    }

    public static ArrayList<Object> getTCListFromDb(String query, TCListHelperObject helper, boolean separator, int drawable) {
        return getTCListFromDb((ArrayList<Object>) null, query, helper, separator, drawable, false);
    }

    public static ArrayList<Object> getTCListFromDb(String query, TCListHelperObject helper, boolean separator, boolean fullTextSeparator) {
        return getTCListFromDb((ArrayList<Object>) null, query, helper, separator, 0, fullTextSeparator);
    }

    public static ArrayList<Object> getTCListFromDb(ArrayList<Object> list, String query, TCListHelperObject helper, boolean separator, int drawable, boolean fullTextSeparator) {
        String string;
        String order;
        if (list == null) {
            list = new ArrayList<>();
        }
        try {
            Cursor c = C1199DB.getDatabase().rawQuery(query, (String[]) null);
            if (c.moveToFirst()) {
                if (separator && c.getColumnIndex("order_value") != -1 && (order = c.getString(c.getColumnIndex("order_value"))) != null && !order.equals("0") && !fullTextSeparator) {
                    separator = false;
                }
                if (separator && c.getCount() < 20 && !fullTextSeparator) {
                    separator = false;
                }
                do {
                    String img = null;
                    if (helper.image != null && (img = c.getString(c.getColumnIndex(helper.image))) == null) {
                        img = "";
                    }
                    boolean isPremium = false;
                    if (helper.premium != null) {
                        String premium = c.getString(c.getColumnIndex(helper.premium));
                        if (!premium.equals("")) {
                            isPremium = true;
                            if (!list.contains(premium)) {
                                list.add(premium);
                            }
                        }
                    }
                    String string2 = c.getString(c.getColumnIndex(DBFavorites.KEY_EVENT_ID));
                    String string3 = helper.text == null ? null : c.getString(c.getColumnIndex(helper.text));
                    String string4 = helper.sub1 == null ? null : c.getString(c.getColumnIndex(helper.sub1));
                    String string5 = helper.sub2 == null ? null : c.getString(c.getColumnIndex(helper.sub2));
                    if (helper.sub3 == null) {
                        string = null;
                    } else {
                        string = c.getString(c.getColumnIndex(helper.sub3));
                    }
                    TCListObject tlo = new TCListObject(string2, string3, string4, string5, string, img, drawable, isPremium);
                    if (helper.isTag()) {
                        String tag = c.getString(c.getColumnIndex("tag"));
                        if (tag == null) {
                            tag = "";
                        }
                        tlo.setSearch(tag);
                    }
                    if (separator && !list.contains(tlo.getText().substring(0, 1).toUpperCase()) && !fullTextSeparator) {
                        list.add(tlo.getText().substring(0, 1).toUpperCase());
                    } else if (separator && fullTextSeparator) {
                        list.add(tlo.getText());
                    }
                    list.add(tlo);
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static class TCListHelperObject {
        /* access modifiers changed from: private */
        public String image;
        /* access modifiers changed from: private */
        public String premium;
        /* access modifiers changed from: private */
        public String sub1;
        /* access modifiers changed from: private */
        public String sub2;
        /* access modifiers changed from: private */
        public String sub3;
        private boolean tag;
        /* access modifiers changed from: private */
        public String text;

        public String getText() {
            return this.text;
        }

        public String getSub1() {
            return this.sub1;
        }

        public String getSub2() {
            return this.sub2;
        }

        public String getSub3() {
            return this.sub3;
        }

        public String getPremium() {
            return this.premium;
        }

        public String getImage() {
            return this.image;
        }

        public boolean isTag() {
            return this.tag;
        }

        public TCListHelperObject(String text2, String sub12, String image2) {
            this.text = text2;
            this.sub1 = sub12;
            this.image = image2;
        }

        public TCListHelperObject(String text2, String sub12, String image2, boolean tag2) {
            this.text = text2;
            this.sub1 = sub12;
            this.image = image2;
            this.tag = tag2;
        }

        public TCListHelperObject(String text2, String sub12, String premium2, String image2, boolean tag2) {
            this.text = text2;
            this.sub1 = sub12;
            this.premium = premium2;
            this.image = image2;
            this.tag = tag2;
        }

        public TCListHelperObject(String text2, String sub12, String sub22, String sub32, String image2, boolean tag2) {
            this.text = text2;
            this.sub1 = sub12;
            this.sub2 = sub22;
            this.sub3 = sub32;
            this.image = image2;
            this.tag = tag2;
        }

        public TCListHelperObject(String text2, String sub12, String sub22, String image2) {
            this.text = text2;
            this.sub1 = sub12;
            this.sub2 = sub22;
            this.image = image2;
        }

        public TCListHelperObject(String text2, String sub12, String sub22, String sub32, String image2) {
            this.text = text2;
            this.sub1 = sub12;
            this.sub2 = sub22;
            this.sub3 = sub32;
            this.image = image2;
        }
    }

    public static List<Object> getSearchListItemsFromQuery(Context context, String[] tables) {
        String query = "";
        for (String table : tables) {
            query = String.valueOf(query) + ((query.length() <= 0 || query.endsWith(" UNION ")) ? "" : " UNION ");
            if (table.equals("groups")) {
                query = String.valueOf(query) + String.format("SELECT %1$s.id as id, %1$s.name as name, %1$s.imageurl as imageurl, '%1$s' as type FROM %1$s WHERE name != 'exhibitorcategories' AND name != 'exhibitorbrands' AND name != 'placescategories' AND name != 'speakercategories' AND name != 'catalogcategories' AND name != 'attendeecategories' AND name != 'Team'", new Object[]{table});
            } else if (table.equals(LinkedObjects.TABLE_CAT)) {
                if (C1199DB.getSize("launchers", "moduletypeid", "25") > 0) {
                    query = String.valueOf(query) + String.format("SELECT %1$s.id as id, %1$s.name as name, %1$s.imageurl as imageurl, 'projects' as type FROM %1$s WHERE %1$s.type == 'projects'", new Object[]{table});
                }
                if (C1199DB.getSize("launchers", "moduletypeid", "15") > 0) {
                    query = String.valueOf(String.valueOf(query) + ((query.length() <= 0 || query.endsWith(" UNION ")) ? "" : " UNION ")) + String.format("SELECT %1$s.id as id, %1$s.name as name, %1$s.imageurl as imageurl, '%1$s' as type FROM %1$s WHERE %1$s.type IS NULL OR %1$s.type == ''", new Object[]{table});
                }
            } else if (table.equals(LinkedObjects.TABLE_ATT)) {
                query = String.valueOf(query) + String.format("SELECT %1$s.id as id, %1$s.name || ' ' || %1$s.firstname as name, %1$s.imageurl as imageurl, '%1$s' as type FROM %1$s", new Object[]{table});
            } else {
                query = String.valueOf(query) + String.format("SELECT %1$s.id as id, %1$s.name as name, %1$s.imageurl as imageurl, '%1$s' as type FROM %1$s", new Object[]{table});
            }
        }
        String query2 = String.valueOf(query) + " ORDER BY type COLLATE LOCALIZED, name COLLATE LOCALIZED";
        List<Object> list = new ArrayList<>();
        try {
            Cursor c = C1199DB.getDatabase().rawQuery(query2, (String[]) null);
            if (c == null || !c.moveToFirst()) {
                c.close();
                return list;
            }
            do {
                String type = c.getString(3);
                String sep = SearchListAllFragment.getSeparator(type);
                if (sep != null && !list.contains(sep)) {
                    list.add(sep);
                }
                String img = c.getString(2);
                if (img == null) {
                    img = "";
                }
                list.add(new TCListObject(String.valueOf(type) + ":" + c.getString(0), c.getString(1), type, (String) null, img));
            } while (c.moveToNext());
            c.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HashSet<String> getIdsFromTables(String constraint, String[] tables) {
        HashSet<String> ids = new HashSet<>();
        String constraint2 = "%" + constraint + "%";
        String query = "";
        for (String table : tables) {
            if (table.equals(LinkedObjects.TABLE_CAT) && C1199DB.getSize("launchers", "moduletypeid", "25") > 0) {
                String query2 = String.valueOf(String.valueOf(query) + (query.length() > 0 ? " UNION " : "")) + getQueryForTable("projects", constraint2);
                query = String.valueOf(String.valueOf(query2) + (query2.length() > 0 ? " UNION " : "")) + getMetaValueQueryForTable("projects", constraint2);
            }
            String query3 = String.valueOf(String.valueOf(query) + (query.length() > 0 ? " UNION " : "")) + getQueryForTable(table, constraint2);
            query = String.valueOf(String.valueOf(query3) + (query3.length() > 0 ? " UNION " : "")) + getMetaValueQueryForTable(table, constraint2);
            if (getTagType(table) != null) {
                query = String.valueOf(String.valueOf(query) + (query.length() > 0 ? " UNION " : "")) + getTagValueQueryForTable(table, constraint2);
            }
        }
        Cursor c = C1199DB.getDatabase().rawQuery(query, (String[]) null);
        if (c == null || !c.moveToFirst()) {
            c.close();
            return ids;
        }
        do {
            ids.add(c.getString(0));
        } while (c.moveToNext());
        c.close();
        return ids;
    }

    private static String getQueryForTable(String table, String constraint) {
        if (table.equals(LinkedObjects.TABLE_ATT)) {
            return String.valueOf("") + String.format("SELECT '%1$s:' || %1$s.id as id FROM %1$s WHERE %1$s.name LIKE '%2$s' OR %1$s.firstname LIKE '%2$s' OR %1$s.company LIKE '%2$s' OR %1$s.function LIKE '%2$s' OR %1$s.email LIKE '%2$s'", new Object[]{table, constraint});
        } else if (table.equals(LinkedObjects.TABLE_CAT)) {
            return String.valueOf("") + String.format("SELECT '%1$s:' || %1$s.id as id FROM %1$s WHERE (%1$s.name LIKE '%2$s' OR %1$s.pdf LIKE '%2$s' OR %1$s.urltitle LIKE '%2$s' OR %1$s.url LIKE '%2$s') AND (%1$s.type IS NULL OR %1$s.type == '')", new Object[]{table, constraint});
        } else if (table.equals("projects")) {
            return String.valueOf("") + String.format("SELECT '%1$s:' || catalog.id as id FROM catalog WHERE (catalog.name LIKE '%2$s' OR catalog.pdf LIKE '%2$s' OR catalog.urltitle LIKE '%2$s' OR catalog.url LIKE '%2$s') AND catalog.type == 'projects'", new Object[]{table, constraint});
        } else if (table.equals("events")) {
            return String.valueOf("") + String.format("SELECT '%1$s:' || %1$s.id as id FROM %1$s WHERE %1$s.name LIKE '%2$s' OR %1$s.phonenr LIKE '%2$s' OR %1$s.email LIKE '%2$s' OR %1$s.datefrom LIKE '%2$s' OR %1$s.dateto LIKE '%2$s' OR %1$s.website LIKE '%2$s'", new Object[]{table, constraint});
        } else if (table.equals("groups")) {
            return String.valueOf("") + String.format("SELECT '%1$s:' || %1$s.id as id FROM %1$s WHERE %1$s.name LIKE '%2$s'", new Object[]{table, constraint});
        } else if (table.equals(DBFavorites.TABLE_EXHIBITORS)) {
            return String.valueOf("") + String.format("SELECT '%1$s:' || %1$s.id as id FROM %1$s WHERE %1$s.name LIKE '%2$s' OR %1$s.tel LIKE '%2$s' OR %1$s.web LIKE '%2$s' OR %1$s.booth LIKE '%2$s' OR %1$s.address LIKE '%2$s' OR %1$s.email LIKE '%2$s'", new Object[]{table, constraint});
        } else if (table.equals("sessions")) {
            return String.valueOf("") + String.format("SELECT '%1$s:' || %1$s.id as id FROM %1$s WHERE %1$s.name LIKE '%2$s' OR %1$s.starttime LIKE '%2$s' OR %1$s.endtime LIKE '%2$s' OR %1$s.location LIKE '%2$s' OR %1$s.date LIKE '%2$s' OR %1$s.url LIKE '%2$s' OR %1$s.twitter LIKE '%2$s'", new Object[]{table, constraint});
        } else if (table.equals("speakers")) {
            return String.valueOf("") + String.format("SELECT '%1$s:' || %1$s.id as id FROM %1$s WHERE %1$s.name LIKE '%2$s' OR %1$s.company LIKE '%2$s' OR %1$s.function LIKE '%2$s'", new Object[]{table, constraint});
        } else if (table.equals("sponsors")) {
            return String.valueOf("") + String.format("SELECT '%1$s:' || %1$s.id as id FROM %1$s WHERE %1$s.name LIKE '%2$s' OR %1$s.website LIKE '%2$s'", new Object[]{table, constraint});
        } else if (table.equals("venues")) {
            return String.valueOf("") + String.format("SELECT '%1$s:' || %1$s.id as id FROM %1$s WHERE %1$s.name LIKE '%2$s' OR %1$s.address LIKE '%2$s' OR %1$s.facebookurl LIKE '%2$s' OR %1$s.telephone LIKE '%2$s' OR %1$s.email LIKE '%2$s' OR %1$s.fax LIKE '%2$s' OR %1$s.website LIKE '%2$s' OR %1$s.twitterurl LIKE '%2$s'", new Object[]{table, constraint});
        } else if (!table.equals("news")) {
            return "";
        } else {
            return String.valueOf("") + String.format("SELECT '%1$s:' || %1$s.id as id FROM %1$s WHERE %1$s.name LIKE '%2$s' OR %1$s.url LIKE '%2$s'", new Object[]{table, constraint});
        }
    }

    private static String getMetaValueQueryForTable(String table, String constraint) {
        return String.valueOf("") + String.format("SELECT DISTINCT '%1$s:' || metavalues.parentId as id FROM metavalues WHERE metavalues.name == 'Keywords' AND metavalues.parentType = '%2$s' AND %3$s", new Object[]{table, getParentType(table), getFieldSearch(new String[]{"metavalues.value"}, constraint)});
    }

    private static String getTagValueQueryForTable(String table, String constraint) {
        return String.valueOf("") + String.format("SELECT DISTINCT '%1$s:' || tagsv2.itemid as id FROM tagsv2 WHERE tagsv2.itemtype = '%2$s' AND tagsv2.tag LIKE '%3$s'", new Object[]{table, getTagType(table), constraint});
    }

    private static String getFieldSearch(String[] fields, String constraint) {
        String query = "";
        List<String> matches = new ArrayList<>();
        Matcher matcher = Pattern.compile("[^\\W\\d](\\w|[-']{1,2}(?=\\w))*").matcher(constraint);
        while (matcher.find()) {
            matches.add(matcher.group());
        }
        String[] items = new String[matches.size()];
        matches.toArray(items);
        for (int i = 0; i < fields.length; i++) {
            query = String.valueOf(query) + fields[i] + " LIKE '%" + implode(items, "%' AND " + fields[i] + " LIKE '%") + "%'";
        }
        return query;
    }

    public static String implode(String[] ary, String delim) {
        String out = "";
        for (int i = 0; i < ary.length; i++) {
            if (i != 0) {
                out = String.valueOf(out) + delim;
            }
            out = String.valueOf(out) + ary[i];
        }
        return out;
    }

    private static String getParentType(String table) {
        if (table.equals(LinkedObjects.TABLE_ATT)) {
            return LinkedObjects.TABLE_ATT;
        }
        if (table.equals(LinkedObjects.TABLE_CAT)) {
            return LinkedObjects.TABLE_CAT;
        }
        if (table.equals("events")) {
            return "event";
        }
        if (table.equals(DBFavorites.TABLE_EXHIBITORS)) {
            return LinkedObjects.TABLE_EXHI;
        }
        if (table.equals("sessions")) {
            return "session";
        }
        if (table.equals("speakers")) {
            return "speaker";
        }
        if (table.equals("sponsors")) {
            return "sponsor";
        }
        if (table.equals("venues")) {
            return "venue";
        }
        if (table.equals("news")) {
            return "newsitem";
        }
        return "";
    }

    private static String getTagType(String table) {
        if (table.equals(LinkedObjects.TABLE_ATT)) {
            return "attendee";
        }
        if (table.equals(LinkedObjects.TABLE_CAT)) {
            return LinkedObjects.TABLE_CAT;
        }
        if (table.equals("events")) {
            return null;
        }
        if (table.equals(DBFavorites.TABLE_EXHIBITORS)) {
            return LinkedObjects.TABLE_EXHI;
        }
        if (table.equals("sessions")) {
            return "session";
        }
        if (table.equals("speakers")) {
            return "speaker";
        }
        if (table.equals("sponsors")) {
            return "sponsor";
        }
        if (!table.equals("venues") && !table.equals("news")) {
            return "";
        }
        return null;
    }
}
