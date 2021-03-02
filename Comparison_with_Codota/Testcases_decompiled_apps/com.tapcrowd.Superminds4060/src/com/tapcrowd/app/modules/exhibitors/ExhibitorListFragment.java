package com.tapcrowd.app.modules.exhibitors;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.groups.GroupListFragment;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.TCDBHelper;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCListSeparator;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import com.tapcrowd.app.views.SearchBar;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ExhibitorListFragment extends TCListFragment implements MenuFragment.MenuItemListener {
    private final int GROUPS = 324;
    /* access modifiers changed from: private */
    public String eventid;
    /* access modifiers changed from: private */
    public SearchBar.TextChangedListener listener = new SearchBar.TextChangedListener() {
        public void textChanged(CharSequence s, int count) {
            ((TCListObjectAdapter) ExhibitorListFragment.this.getListAdapter()).getFilter().filter(s);
        }
    };
    MenuFragment menu;
    private boolean retain;

    /* renamed from: v */
    View f2031v;

    public static ExhibitorListFragment newInstance(String eventid2) {
        ExhibitorListFragment fr = new ExhibitorListFragment();
        fr.eventid = eventid2;
        return fr;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2031v == null) {
            this.f2031v = inflater.inflate(C0846R.layout.listview, container, false);
        } else {
            ((ViewGroup) this.f2031v.getParent()).removeView(this.f2031v);
            this.retain = true;
        }
        return this.f2031v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupLayout();
        AdHelper.showAds(this, AdHelper.buildPath("2", "list", (String) null));
        if (!this.retain) {
            setupListView();
        }
    }

    private void setupLayout() {
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        if (C1199DB.getSize("groups", "parentid", C1199DB.getObject("groups", "eventid == " + this.eventid + " AND name", "exhibitorcategories").get(DBFavorites.KEY_EVENT_ID)) > 0) {
            menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_categories_navbar, C1216LO.getLo(C1216LO.navigationColor)), 324));
        }
        this.menu = MenuFragment.newInstance(menuitems, this);
        Fragments.addMenu(this, this.menu);
    }

    private void setupListView() {
        new LoadListTask(this, (LoadListTask) null).execute(new Void[0]);
    }

    private class LoadListTask extends AsyncTask<Void, Void, Void> {
        private List<Object> groupitems;
        private boolean img;
        private ArrayList<Object> listitems;
        private int numpremium;
        private boolean showseparators;

        private LoadListTask() {
            this.listitems = new ArrayList<>();
            this.groupitems = new ArrayList();
        }

        /* synthetic */ LoadListTask(ExhibitorListFragment exhibitorListFragment, LoadListTask loadListTask) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            this.listitems = TCDBHelper.getTCListFromDb(String.format("SELECT 'exhibitor:' || exhibitors.id AS id, CASE WHEN premium.title IS NULL THEN '' ELSE premium.title END AS premium, CASE WHEN (exhibitors.booth IS NULL OR exhibitors.booth == '') THEN '' ELSE '%1$s ' || exhibitors.booth END AS booth, exhibitors.name, exhibitors.image_large, GROUP_CONCAT(tagsv2.tag, ' ') as tag FROM exhibitors LEFT OUTER JOIN tagsv2 ON tagsv2.itemid == exhibitors.id AND tagsv2.itemtype == 'exhibitor' INNER JOIN premium ON premium.tableid == exhibitors.id AND premium.tablename == 'exhibitor' WHERE exhibitors.eventid == '%2$s' GROUP BY exhibitors.id ORDER BY sortorder +0 DESC, name COLLATE LOCALIZED", new Object[]{ExhibitorListFragment.this.getResourceString(C0846R.string.location), ExhibitorListFragment.this.eventid}), new TCDBHelper.TCListHelperObject(DBFavorites.KEY_NAME, "booth", "premium", "image_large", true), true);
            this.listitems = TCDBHelper.getTCListFromDb(this.listitems, String.format("SELECT 'exhibitor:' || exhibitors.id AS id, CASE WHEN premium.title IS NULL THEN '' ELSE premium.title END AS premium, CASE WHEN (exhibitors.booth IS NULL OR exhibitors.booth == '') THEN '' ELSE '%1$s ' || exhibitors.booth END AS booth, exhibitors.name, exhibitors.image_large, GROUP_CONCAT(tagsv2.tag, ' ') as tag FROM exhibitors LEFT OUTER JOIN tagsv2 ON tagsv2.itemid == exhibitors.id AND tagsv2.itemtype == 'exhibitor' LEFT OUTER JOIN premium ON premium.tableid == exhibitors.id AND premium.tablename == 'exhibitor' WHERE exhibitors.eventid == '%2$s' GROUP BY exhibitors.id ORDER BY order_value +0 DESC, name COLLATE LOCALIZED", new Object[]{ExhibitorListFragment.this.getResourceString(C0846R.string.location), ExhibitorListFragment.this.eventid}), new TCDBHelper.TCListHelperObject(DBFavorites.KEY_NAME, "booth", "premium", "image_large", true), true);
            List<TCObject> images = C1199DB.getQueryFromDb("SELECT count(*) AS num FROM exhibitors WHERE eventid == '" + ExhibitorListFragment.this.eventid + "' AND imageurl IS NOT NULL AND imageurl != ''");
            if (images.size() > 0) {
                this.img = !images.get(0).get("num").equals("0");
            }
            this.groupitems = TCDBHelper.getTCListFromDb(String.format("SELECT name, imageurl, 'exhibitor:' || groups.id AS id FROM groups WHERE parentid != '0' AND id IN (SELECT DISTINCT groupid FROM groupitems WHERE eventid == '%1$s' AND itemtable == 'exhibitor' UNION SELECT parentid FROM groups WHERE id IN (SELECT DISTINCT groupid FROM groupitems WHERE eventid == '%1$s' AND itemtable == 'exhibitor')) ORDER BY name COLLATE LOCALIZED", new Object[]{ExhibitorListFragment.this.eventid}), new TCDBHelper.TCListHelperObject(DBFavorites.KEY_EVENT_ID, DBFavorites.KEY_NAME, (String) null, "imageurl"), false);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            int i = C0846R.drawable.l_def_exhibitors;
            super.onPostExecute(result);
            if (ExhibitorListFragment.this.isAdded()) {
                ExhibitorListFragment.this.getListView().addHeaderView(new SearchBar(ExhibitorListFragment.this.getActivity(), ExhibitorListFragment.this, ExhibitorListFragment.this.listener));
                C1232UI.getColorOverlay((int) C0846R.drawable.l_def_exhibitors, C1216LO.getLo(C1216LO.textcolor));
                ExhibitorListFragment exhibitorListFragment = ExhibitorListFragment.this;
                ExhibitorListFragment exhibitorListFragment2 = ExhibitorListFragment.this;
                List<Object> list = this.groupitems;
                ArrayList<Object> arrayList = this.listitems;
                if (!this.img) {
                    i = 0;
                }
                exhibitorListFragment.setListAdapter(new TCListObjectAdapter(list, arrayList, i, this.showseparators, this.numpremium));
            }
        }
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        Object o = l.getItemAtPosition(position);
        if (o.getClass() == TCListObject.class) {
            TCListObject tlo = (TCListObject) o;
            String type = tlo.getId().split(":")[0];
            String typeid = tlo.getId().split(":")[1];
            if (type.equals(LinkedObjects.TABLE_EXHI)) {
                Fragments.add(this, ExhibitorDetailFragment.newInstance(typeid), getResourceString(C0846R.string.detail));
            } else {
                Fragments.add(this, GroupListFragment.newInstance("parentid", typeid), tlo.getText());
            }
        }
        super.onListItemClick(l, v, position, id);
    }

    private class TCListObjectAdapter extends ArrayAdapter implements SectionIndexer {
        private HashMap<String, Integer> alphaIndexer;
        private int defaultImage;
        private FastImageLoader fil = new FastImageLoader();
        private Filter filter;
        /* access modifiers changed from: private */
        public List<Object> filtered;
        /* access modifiers changed from: private */
        public List<Object> items;
        private int layout = C0846R.layout.cell_tcobject;
        private LayoutInflater mInflater;
        /* access modifiers changed from: private */
        public List<Object> original;
        private int premiumCount;
        private String[] sections = new String[0];
        public boolean showSections = false;
        private int textColor;

        private class Holder {
            ImageView arrow;
            ImageView icon;
            TextView sub1;
            TextView sub2;
            TextView text;

            private Holder() {
            }

            /* synthetic */ Holder(TCListObjectAdapter tCListObjectAdapter, Holder holder) {
                this();
            }
        }

        public TCListObjectAdapter(List items2, List filtered2, int defaultResource, boolean showIndexer, int premiumCount2) {
            super(App.act, 0, filtered2);
            this.showSections = showIndexer;
            this.items = new ArrayList();
            this.filtered = new ArrayList();
            this.original = new ArrayList();
            this.items.addAll(items2);
            this.filtered.addAll(filtered2);
            this.original.addAll(filtered2);
            this.mInflater = LayoutInflater.from(App.act);
            this.defaultImage = defaultResource;
            this.premiumCount = premiumCount2;
            this.textColor = C1216LO.getLo(C1216LO.textcolor);
            setSections();
        }

        private void setSections() {
            this.alphaIndexer = new HashMap<>();
            if (this.showSections) {
                for (int i = this.filtered.size() - 1; i >= 0; i--) {
                    String s = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
                    if (i < this.premiumCount) {
                        this.alphaIndexer.put("*", Integer.valueOf(i));
                    } else {
                        Object o = this.filtered.get(i);
                        try {
                            if (o.getClass() == String.class) {
                                s = ((String) o).substring(0, 1).replaceAll("[¿¡√·‚„]", "a").toUpperCase();
                            }
                        } catch (Exception e) {
                            s = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
                        }
                        if (!s.equals(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)) {
                            this.alphaIndexer.put(s, Integer.valueOf(i));
                        }
                    }
                }
                ArrayList<String> sectionList = new ArrayList<>(this.alphaIndexer.keySet());
                Collections.sort(sectionList);
                this.sections = new String[sectionList.size()];
                sectionList.toArray(this.sections);
                return;
            }
            this.sections = new String[getCount()];
            int l = this.sections.length;
            for (int i2 = 0; i2 < l; i2++) {
                this.sections[i2] = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
            }
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            Object o = this.filtered.get(position);
            if (o.getClass() == TCListObject.class) {
                TCListObject tlo = (TCListObject) o;
                if (convertView == null || convertView.getTag() == null || !convertView.getTag().equals("tlo")) {
                    convertView = this.mInflater.inflate(this.layout, (ViewGroup) null);
                    C1232UI.setFont((TextView) convertView.findViewById(C0846R.C0847id.text));
                    C1232UI.setFont((TextView) convertView.findViewById(C0846R.C0847id.sub1));
                    C1232UI.setFont((TextView) convertView.findViewById(C0846R.C0847id.sub2));
                    convertView.setTag("tlo");
                }
                Holder holder = new Holder(this, (Holder) null);
                holder.text = (TextView) convertView.findViewById(C0846R.C0847id.text);
                holder.sub1 = (TextView) convertView.findViewById(C0846R.C0847id.sub1);
                holder.sub2 = (TextView) convertView.findViewById(C0846R.C0847id.sub2);
                holder.icon = (ImageView) convertView.findViewById(C0846R.C0847id.icon);
                holder.arrow = (ImageView) convertView.findViewById(C0846R.C0847id.arrow);
                try {
                    if (tlo.ispremium) {
                        holder.text.setTextColor(C1216LO.getLo(C1216LO.premiumCellTextColor));
                        holder.sub1.setTextColor(C1216LO.getLo(C1216LO.premiumCellTextColor));
                        holder.sub2.setTextColor(C1216LO.getLo(C1216LO.premiumCellTextColor));
                        convertView.setBackgroundColor(C1216LO.getLo(C1216LO.premiumCellBgColor));
                    } else {
                        holder.text.setTextColor(this.textColor);
                        holder.sub1.setTextColor(this.textColor);
                        holder.sub2.setTextColor(this.textColor);
                        convertView.setBackgroundColor(0);
                    }
                    if (tlo.getText() == null) {
                        holder.text.setVisibility(8);
                    } else {
                        holder.text.setText(Converter.unicodeToString(Html.fromHtml(tlo.getText()).toString()));
                    }
                    if (tlo.getSub1() == null) {
                        holder.sub1.setVisibility(8);
                        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) holder.text.getLayoutParams();
                        lp.setMargins(10, 15, 10, 15);
                        holder.text.setLayoutParams(lp);
                    } else {
                        holder.sub1.setText(tlo.getSub1());
                    }
                    if (tlo.getSub2() == null) {
                        holder.sub2.setVisibility(8);
                    } else if (tlo.getSub2().equals("")) {
                        holder.sub2.setVisibility(8);
                    } else {
                        holder.sub2.setVisibility(0);
                        holder.sub2.setText(tlo.getSub2());
                    }
                    if (tlo.getImg() == null) {
                        holder.icon.setVisibility(8);
                    } else {
                        holder.icon.setVisibility(0);
                        if (!tlo.getImg().equals("")) {
                            holder.icon.setImageResource(this.defaultImage);
                            this.fil.DisplayImage(tlo.getImg(), holder.icon, holder.icon.getLayoutParams().height, holder.icon.getLayoutParams().width);
                        } else if (this.defaultImage == 0) {
                            holder.icon.setVisibility(8);
                        } else {
                            holder.icon.setImageDrawable(C1232UI.getColorOverlay(this.defaultImage, C1216LO.getLo(C1216LO.placeholderOverlayColor)));
                        }
                    }
                    if (!tlo.showArrow()) {
                        holder.arrow.setVisibility(8);
                    } else {
                        holder.arrow.setVisibility(0);
                    }
                    holder.arrow.setImageResource(C0846R.drawable.default_actionarrow);
                    holder.arrow.setOnClickListener((View.OnClickListener) null);
                    return convertView;
                } catch (Exception e) {
                    e.printStackTrace();
                    return new View(getContext());
                }
            } else if (o.getClass() == String.class) {
                View convertView2 = this.mInflater.inflate(C0846R.layout.separator, (ViewGroup) null);
                TextView tv = (TextView) convertView2.findViewById(C0846R.C0847id.text);
                convertView2.setTag("sep");
                C1232UI.setFont(tv);
                tv.setBackgroundColor(C1216LO.getLo(C1216LO.seperatorBackgroundColor));
                tv.setTextColor(C1216LO.getLo(C1216LO.separatorTextColor));
                tv.setText((String) o);
                return convertView2;
            } else if (o.getClass() == TCListSeparator.class) {
                View convertView3 = this.mInflater.inflate(C0846R.layout.separator, (ViewGroup) null);
                TextView tv2 = (TextView) convertView3.findViewById(C0846R.C0847id.text);
                convertView3.setTag("sep");
                C1232UI.setFont(tv2);
                tv2.setBackgroundColor(C1216LO.getLo(C1216LO.seperatorBackgroundColor));
                tv2.setTextColor(C1216LO.getLo(C1216LO.separatorTextColor));
                tv2.setText(((TCListSeparator) o).toString());
                return convertView3;
            } else if (o.getClass() != Object.class) {
                return new View(App.act);
            } else {
                View convertView4 = this.mInflater.inflate(C0846R.layout.cell_showonfloorplan, (ViewGroup) null);
                convertView4.setTag("floorplan");
                TextView showon = (TextView) convertView4.findViewById(C0846R.C0847id.showon);
                C1232UI.setFont(showon);
                TCObject mapLauncher = C1199DB.getFirstObject("launchers", "moduletypeid", "72");
                if (mapLauncher == null) {
                    mapLauncher = C1199DB.getFirstObject("launchers", "moduletypeid", "5");
                }
                showon.setText(String.valueOf(getContext().getString(C0846R.string.showfloorplan)) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + mapLauncher.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                return convertView4;
            }
        }

        public void notifyDataSetChanged() {
            setSections();
            super.notifyDataSetChanged();
        }

        public void notifyDataSetInvalidated() {
            setSections();
            super.notifyDataSetInvalidated();
        }

        public int getPositionForSection(int section) {
            if (!this.showSections) {
                return section;
            }
            if (section >= this.sections.length) {
                return 0;
            }
            return this.alphaIndexer.get(this.sections[section]).intValue();
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public boolean isEnabled(int position) {
            return (this.filtered.get(position) instanceof TCListObject) || (this.filtered.get(position) instanceof Object);
        }

        public int getSectionForPosition(int position) {
            if (!this.showSections) {
                return position;
            }
            for (int i = this.sections.length - 1; i >= 0; i--) {
                if (position > this.alphaIndexer.get(this.sections[i]).intValue()) {
                    return i;
                }
            }
            return 0;
        }

        public Object getItem(int position) {
            return this.filtered.get(position);
        }

        public Object[] getSections() {
            return this.sections;
        }

        public Filter getFilter() {
            if (this.filter == null) {
                this.filter = new TCFilter(this, (TCFilter) null);
            }
            return this.filter;
        }

        public int getCount() {
            return this.filtered.size();
        }

        private class TCFilter extends Filter {
            private TCFilter() {
            }

            /* synthetic */ TCFilter(TCListObjectAdapter tCListObjectAdapter, TCFilter tCFilter) {
                this();
            }

            /* access modifiers changed from: protected */
            public Filter.FilterResults performFiltering(CharSequence constraint) {
                CharSequence constraint2 = constraint.toString().toLowerCase();
                Filter.FilterResults result = new Filter.FilterResults();
                List<Object> filtexhis = new ArrayList<>();
                List<Object> filtgroups = new ArrayList<>();
                List<Object> filttot = new ArrayList<>();
                if (constraint2 == null || constraint2.length() <= 0) {
                    TCListObjectAdapter.this.showSections = true;
                    result.count = TCListObjectAdapter.this.original.size();
                    result.values = TCListObjectAdapter.this.original;
                } else {
                    boolean isDiacritical = false;
                    int l = constraint2.length();
                    for (int i = 0; i < l; i++) {
                        if (constraint2.charAt(i) > 127) {
                            isDiacritical = true;
                        }
                    }
                    int l2 = TCListObjectAdapter.this.original.size();
                    for (int i2 = 0; i2 < l2; i2++) {
                        if (TCListObjectAdapter.this.original.get(i2).getClass() == TCListObject.class) {
                            TCListObject tlo = (TCListObject) TCListObjectAdapter.this.original.get(i2);
                            String text = tlo.getText().toLowerCase();
                            if (!isDiacritical) {
                                text = Normalizer.normalize(text, Normalizer.Form.NFD);
                            }
                            if (text.contains(constraint2)) {
                                filtexhis.add(tlo);
                            }
                        }
                    }
                    if (filtexhis.size() > 0) {
                        filtexhis.add(0, C1199DB.getFirstObject("launchers", "moduletypeid == '2' AND eventid", ExhibitorListFragment.this.eventid).get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                    }
                    int l3 = TCListObjectAdapter.this.items.size();
                    for (int i3 = 0; i3 < l3; i3++) {
                        if (TCListObjectAdapter.this.items.get(i3).getClass() == TCListObject.class) {
                            TCListObject tlo2 = (TCListObject) TCListObjectAdapter.this.items.get(i3);
                            String text2 = tlo2.getText().toLowerCase();
                            if (!isDiacritical) {
                                text2 = Normalizer.normalize(text2, Normalizer.Form.NFD);
                            }
                            if (text2.contains(constraint2)) {
                                filtgroups.add(tlo2);
                            }
                        }
                    }
                    if (filtgroups.size() > 0) {
                        filtgroups.add(0, ExhibitorListFragment.this.getString(C0846R.string.categorieen));
                    }
                    filttot.addAll(filtexhis);
                    filttot.addAll(filtgroups);
                    TCListObjectAdapter.this.showSections = false;
                    result.count = filttot.size();
                    result.values = filttot;
                }
                return result;
            }

            /* access modifiers changed from: protected */
            public void publishResults(CharSequence constraint, Filter.FilterResults results) {
                TCListObjectAdapter.this.filtered = (List) results.values;
                TCListObjectAdapter.this.notifyDataSetChanged();
                TCListObjectAdapter.this.notifyDataSetInvalidated();
            }
        }
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 324:
                Fragments.add(this, GroupListFragment.newInstance("parentid", C1199DB.getObject("groups", "eventid == " + this.eventid + " AND name", "exhibitorcategories").get(DBFavorites.KEY_EVENT_ID), true), getResourceString(C0846R.string.categorieen));
                return;
            default:
                return;
        }
    }
}
