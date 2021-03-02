package com.tapcrowd.app.utils;

import android.annotation.TargetApi;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.images.FastImageLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.apache.cordova.NetworkManager;

@TargetApi(11)
public class TCListObject {
    boolean arrow = true;
    int cellitem;
    int defaultresource = 0;

    /* renamed from: id */
    String f2133id;
    String img;
    String imgname;
    public boolean ispremium = false;
    private boolean isremove = false;
    private String order;
    private String search;
    String sub1;
    String sub2;
    String sub3;
    String text;

    public TCListObject() {
    }

    public boolean getRemove() {
        return this.isremove;
    }

    public TCListObject setRemove(boolean isremove2) {
        this.isremove = isremove2;
        return this;
    }

    public String toString() {
        return this.text;
    }

    public TCListObject setSearch(String search2) {
        this.search = search2;
        return this;
    }

    public String getSearch() {
        return this.search;
    }

    public TCListObject(TCObject tco, String id, String text2, String sub12, String sub22, String img2) {
        this.f2133id = tco.get(id);
        this.img = tco.get(img2);
        this.text = tco.get(text2);
        this.sub1 = tco.get(sub12);
        this.sub2 = tco.get(sub22);
        if (img2 == null) {
            this.img = null;
        } else if (img2.equals("")) {
            this.img = "";
        } else if (img2.equalsIgnoreCase(NetworkManager.TYPE_NONE)) {
            this.img = NetworkManager.TYPE_NONE;
        } else {
            this.img = tco.get(img2);
        }
        this.imgname = Converter.urlToName(this.img);
    }

    public TCListObject(String id, String text2, String sub12, String sub22, String img2) {
        if (img2 != null && !img2.equals("") && !img2.contains("http")) {
            img2 = String.valueOf(App.act.getString(C0846R.string.baseimgurl)) + img2;
        }
        this.f2133id = id;
        this.text = text2;
        this.sub1 = sub12;
        this.sub2 = sub22;
        this.img = img2;
        this.imgname = Converter.urlToName(this.img);
    }

    public TCListObject(String id, boolean ispremium2, String text2, String sub12, String sub22, String img2) {
        if (img2 != null && !img2.equals("") && !img2.contains("http")) {
            img2 = String.valueOf(App.act.getString(C0846R.string.baseimgurl)) + img2;
        }
        this.f2133id = id;
        this.ispremium = ispremium2;
        this.text = text2;
        this.sub1 = sub12;
        this.sub2 = sub22;
        this.img = img2;
        this.imgname = Converter.urlToName(this.img);
    }

    public TCListObject(String id, String text2, String sub12, String sub22, String sub32, String img2) {
        if (img2 != null && !img2.equals("") && !img2.contains("http")) {
            img2 = String.valueOf(App.act.getString(C0846R.string.baseimgurl)) + img2;
        }
        this.f2133id = id;
        this.text = text2;
        this.sub1 = sub12;
        this.sub2 = sub22;
        this.sub3 = sub32;
        this.img = img2;
        this.imgname = Converter.urlToName(this.img);
    }

    public TCListObject(String id, String text2, String sub12, String sub22, String sub32, String img2, int defaultresource2) {
        if (img2 != null && !img2.equals("") && !img2.contains("http")) {
            img2 = String.valueOf(App.act.getString(C0846R.string.baseimgurl)) + img2;
        }
        this.f2133id = id;
        this.text = text2;
        this.sub1 = sub12;
        this.sub2 = sub22;
        this.sub3 = sub32;
        this.img = img2;
        this.imgname = Converter.urlToName(this.img);
        this.defaultresource = defaultresource2;
    }

    public TCListObject(String id, String text2, String sub12, String sub22, String sub32, String img2, int defaultresource2, boolean isPremium) {
        if (img2 != null && !img2.equals("") && !img2.contains("http")) {
            img2 = String.valueOf(App.act.getString(C0846R.string.baseimgurl)) + img2;
        }
        this.f2133id = id;
        this.text = text2;
        this.sub1 = sub12;
        this.sub2 = sub22;
        this.sub3 = sub32;
        this.img = img2;
        this.imgname = Converter.urlToName(this.img);
        this.defaultresource = defaultresource2;
        this.ispremium = isPremium;
    }

    public TCListObject(String id, String text2, String sub12, String sub22, String img2, int defaultresource2) {
        if (img2 != null && !img2.equals("") && !img2.contains("http")) {
            img2 = String.valueOf(App.act.getString(C0846R.string.baseimgurl)) + img2;
        }
        this.f2133id = id;
        this.text = text2;
        this.sub1 = sub12;
        this.sub2 = sub22;
        this.img = img2;
        this.imgname = Converter.urlToName(this.img);
        this.defaultresource = defaultresource2;
    }

    public TCListObject(String id, String text2, String sub12, String sub22, String img2, Boolean arrow2) {
        if (img2 != null && !img2.equals("") && !img2.contains("http")) {
            img2 = String.valueOf(App.act.getString(C0846R.string.baseimgurl)) + img2;
        }
        this.f2133id = id;
        this.text = text2;
        this.sub1 = sub12;
        this.sub2 = sub22;
        this.img = img2;
        this.imgname = Converter.urlToName(this.img);
        this.arrow = arrow2.booleanValue();
    }

    public TCListObject(String id, String text2, String sub12, String sub22, String img2, Boolean arrow2, Boolean ispremium2) {
        if (img2 != null && !img2.equals("") && !img2.contains("http")) {
            img2 = String.valueOf(App.act.getString(C0846R.string.baseimgurl)) + img2;
        }
        this.f2133id = id;
        this.text = text2;
        this.sub1 = sub12;
        this.sub2 = sub22;
        this.img = img2;
        this.imgname = Converter.urlToName(this.img);
        this.arrow = arrow2.booleanValue();
        this.ispremium = ispremium2.booleanValue();
    }

    public TCListObject(String id, String text2, String sub12, String sub22, String img2, int defaultresource2, Boolean arrow2) {
        if (img2 != null && !img2.equals("") && !img2.contains("http")) {
            img2 = String.valueOf(App.act.getString(C0846R.string.baseimgurl)) + img2;
        }
        this.f2133id = id;
        this.text = text2;
        this.sub1 = sub12;
        this.sub2 = sub22;
        this.img = img2;
        this.imgname = Converter.urlToName(this.img);
        this.arrow = arrow2.booleanValue();
        this.defaultresource = defaultresource2;
    }

    public TCListObject(TCObject tco, String id, String text2, String sub12, String sub22, String img2, Boolean arrow2) {
        this.f2133id = tco.get(id);
        this.text = tco.get(text2);
        this.sub1 = tco.get(sub12);
        this.sub2 = tco.get(sub22);
        if (img2 == null) {
            this.img = null;
        } else if (img2.equals("")) {
            this.img = "";
        } else if (img2.equalsIgnoreCase(NetworkManager.TYPE_NONE)) {
            this.img = NetworkManager.TYPE_NONE;
        } else {
            this.img = tco.get(img2);
        }
        this.arrow = arrow2.booleanValue();
        this.imgname = Converter.urlToName(this.img);
    }

    public TCListObject(TCObject tco, String id, String text2, String sub12, String sub22, String img2, int defaultresource2, int cellitem2, Boolean arrow2) {
        if (img2 != null && !img2.equals("") && !img2.contains("http")) {
            img2 = String.valueOf(App.act.getString(C0846R.string.baseimgurl)) + img2;
        }
        this.f2133id = tco.get(id);
        this.text = tco.get(text2);
        this.sub1 = tco.get(sub12);
        this.sub2 = tco.get(sub22);
        if (img2 == null) {
            this.img = null;
        } else if (img2.equals("")) {
            this.img = "";
        } else if (img2.equalsIgnoreCase(NetworkManager.TYPE_NONE)) {
            this.img = NetworkManager.TYPE_NONE;
        } else {
            this.img = tco.get(img2);
        }
        this.arrow = arrow2.booleanValue();
        this.defaultresource = defaultresource2;
        this.cellitem = cellitem2;
        this.imgname = Converter.urlToName(this.img);
    }

    public String getText() {
        return Converter.unicodeToString(this.text);
    }

    public void setText(String text2) {
        this.text = text2;
    }

    public String getId() {
        return this.f2133id;
    }

    public void setId(String id) {
        this.f2133id = id;
    }

    public String getSub1() {
        return this.sub1;
    }

    public void setSub1(String sub12) {
        this.sub1 = sub12;
    }

    public String getSub2() {
        return this.sub2;
    }

    public void setSub2(String sub22) {
        this.sub2 = sub22;
    }

    public String getSub3() {
        return this.sub3;
    }

    public void setSub3(String sub32) {
        this.sub3 = sub32;
    }

    public String getImgname() {
        return this.imgname;
    }

    public void setImgname(String imgname2) {
        this.imgname = imgname2;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img2) {
        this.img = img2;
    }

    public int getDefaultresource() {
        return this.defaultresource;
    }

    public void setDefaultresource(int defaultresource2) {
        this.defaultresource = defaultresource2;
    }

    public int getCellitem() {
        return this.cellitem;
    }

    public void setCellitem(int cellitem2) {
        this.cellitem = cellitem2;
    }

    public void setArrow(boolean b) {
        this.arrow = b;
    }

    public boolean showArrow() {
        return this.arrow;
    }

    public TCListObject setOrder(String order2) {
        this.order = order2;
        return this;
    }

    public String getOrder() {
        return this.order;
    }

    public static class TCListObjectAdapter extends ArrayAdapter implements SectionIndexer {
        private HashMap<String, Integer> alphaIndexer;
        private int defaultImage;
        private FastImageLoader fil;
        private Filter filter;
        /* access modifiers changed from: private */
        public List<Object> filtered;
        /* access modifiers changed from: private */
        public List<Object> items;
        private int layout;
        /* access modifiers changed from: private */
        public ListRemoveClickListener listener;
        private LayoutInflater mInflater;
        private int premiumCount;
        private String[] sections;
        public boolean showSections;
        private int textColor;
        private boolean trash;

        public interface ListRemoveClickListener {
            void onRemoveClick(TCListObject tCListObject);
        }

        private static class Holder {
            ImageView arrow;
            ImageView icon;
            TextView sub1;
            TextView sub2;
            TextView text;

            private Holder() {
            }

            /* synthetic */ Holder(Holder holder) {
                this();
            }
        }

        public TCListObjectAdapter(List list) {
            this(list, (int) C0846R.drawable.icon, true);
        }

        public TCListObjectAdapter(List list, int defaultResource) {
            this(list, defaultResource, true);
        }

        public TCListObjectAdapter(List list, int defaultResource, int premiumCount2) {
            this(list, defaultResource, true, premiumCount2);
        }

        public TCListObjectAdapter(List list, int defaultResource, boolean showIndexer) {
            this(list, defaultResource, showIndexer, 0);
        }

        public void addToList(Object object) {
            this.filtered.add(object);
            this.items.add(object);
        }

        public void addToListAtPosition(Object object, int position) {
            this.filtered.add(position, object);
            this.items.add(position, object);
        }

        public TCListObjectAdapter(List list, int defaultResource, boolean showIndexer, int premiumCount2) {
            super(App.act, 0, list);
            this.fil = new FastImageLoader();
            this.sections = new String[0];
            this.layout = C0846R.layout.cell_tcobject;
            this.showSections = false;
            this.showSections = showIndexer;
            this.items = new ArrayList();
            this.filtered = new ArrayList();
            this.items.addAll(list);
            this.filtered.addAll(list);
            this.mInflater = LayoutInflater.from(App.act);
            this.defaultImage = defaultResource;
            this.premiumCount = premiumCount2;
            this.textColor = C1216LO.getLo(C1216LO.textcolor);
            setSections();
        }

        public void setThrash(boolean trash2, ListRemoveClickListener listener2) {
            this.trash = trash2;
            this.listener = listener2;
        }

        public void setLayout(int layout2) {
            this.layout = layout2;
        }

        public int getCount() {
            return this.filtered.size();
        }

        public void add(Object object) {
            this.items.add(object);
            this.filtered.add(object);
        }

        public Object getItem(int position) {
            return this.filtered.get(position);
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
                final TCListObject tlo = (TCListObject) o;
                if (tlo.getRemove()) {
                    View convertView2 = this.mInflater.inflate(C0846R.layout.cell_tcremove, (ViewGroup) null);
                    DisplayMetrics dm = parent.getContext().getResources().getDisplayMetrics();
                    Holder holder = new Holder((Holder) null);
                    holder.sub1 = (TextView) convertView2.findViewById(C0846R.C0847id.dismisstext);
                    holder.sub1.setText(Converter.unicodeToString(Html.fromHtml(tlo.getSub1()).toString()));
                    holder.sub1.setWidth(dm.widthPixels / 2);
                    holder.text = (TextView) convertView2.findViewById(C0846R.C0847id.dismissundo);
                    holder.text.setText(Converter.unicodeToString(Html.fromHtml(tlo.getText()).toString()));
                    holder.text.setWidth(dm.widthPixels / 2);
                    return convertView2;
                }
                if (convertView == null || convertView.getTag() == null || !convertView.getTag().equals("tlo")) {
                    convertView = this.mInflater.inflate(this.layout, (ViewGroup) null);
                    C1232UI.setFont((TextView) convertView.findViewById(C0846R.C0847id.text));
                    C1232UI.setFont((TextView) convertView.findViewById(C0846R.C0847id.sub1));
                    C1232UI.setFont((TextView) convertView.findViewById(C0846R.C0847id.sub2));
                    convertView.setTag("tlo");
                }
                Holder holder2 = new Holder((Holder) null);
                holder2.text = (TextView) convertView.findViewById(C0846R.C0847id.text);
                holder2.sub1 = (TextView) convertView.findViewById(C0846R.C0847id.sub1);
                holder2.sub2 = (TextView) convertView.findViewById(C0846R.C0847id.sub2);
                holder2.icon = (ImageView) convertView.findViewById(C0846R.C0847id.icon);
                holder2.arrow = (ImageView) convertView.findViewById(C0846R.C0847id.arrow);
                try {
                    if (tlo.ispremium) {
                        holder2.text.setTextColor(C1216LO.getLo(C1216LO.premiumCellTextColor));
                        holder2.sub1.setTextColor(C1216LO.getLo(C1216LO.premiumCellTextColor));
                        holder2.sub2.setTextColor(C1216LO.getLo(C1216LO.premiumCellTextColor));
                        convertView.setBackgroundColor(C1216LO.getLo(C1216LO.premiumCellBgColor));
                    } else {
                        holder2.text.setTextColor(this.textColor);
                        holder2.sub1.setTextColor(this.textColor);
                        holder2.sub2.setTextColor(this.textColor);
                        convertView.setBackgroundColor(0);
                    }
                    if (tlo.getText() == null) {
                        holder2.text.setVisibility(8);
                    } else {
                        holder2.text.setText(Converter.unicodeToString(Html.fromHtml(tlo.getText()).toString()));
                    }
                    if (tlo.getSub1() == null) {
                        holder2.sub1.setVisibility(8);
                        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) holder2.text.getLayoutParams();
                        lp.setMargins(10, 15, 10, 15);
                        holder2.text.setLayoutParams(lp);
                    } else {
                        holder2.sub1.setText(tlo.getSub1());
                    }
                    if (tlo.getSub2() == null) {
                        holder2.sub2.setVisibility(8);
                    } else if (tlo.getSub2().equals("")) {
                        holder2.sub2.setVisibility(8);
                    } else {
                        holder2.sub2.setVisibility(0);
                        holder2.sub2.setText(tlo.getSub2());
                    }
                    if (tlo.getSub1() == null) {
                        tlo.getSub2();
                    }
                    if (tlo.getImg() == null) {
                        holder2.icon.setVisibility(8);
                    } else {
                        holder2.icon.setVisibility(0);
                        if (!tlo.getImg().equals("")) {
                            if (C1216LO.getLoDrawable(C1216LO.placeholder) != null) {
                                holder2.icon.setImageDrawable(C1216LO.getLoDrawable(C1216LO.placeholder));
                            } else {
                                holder2.icon.setImageResource(this.defaultImage);
                            }
                            this.fil.DisplayImage(tlo.getImg(), holder2.icon, holder2.icon.getLayoutParams().height, holder2.icon.getLayoutParams().width);
                        } else if (this.defaultImage == 0) {
                            holder2.icon.setVisibility(8);
                        } else if (C1216LO.getLoDrawable(C1216LO.placeholder) != null) {
                            holder2.icon.setImageDrawable(C1216LO.getLoDrawable(C1216LO.placeholder));
                        } else {
                            holder2.icon.setImageDrawable(C1232UI.getColorOverlay(this.defaultImage, C1216LO.getLo(C1216LO.placeholderOverlayColor)));
                        }
                    }
                    if (!tlo.showArrow()) {
                        holder2.arrow.setVisibility(8);
                    } else {
                        holder2.arrow.setVisibility(0);
                    }
                    if (this.trash) {
                        C1232UI.getColorOverlay((int) C0846R.drawable.trash, C1216LO.getLo(C1216LO.actionImageOverlayColor));
                        holder2.arrow.setImageResource(C0846R.drawable.trash);
                        holder2.arrow.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                if (TCListObjectAdapter.this.listener != null) {
                                    TCListObjectAdapter.this.listener.onRemoveClick(tlo);
                                }
                            }
                        });
                    } else {
                        holder2.arrow.setOnClickListener((View.OnClickListener) null);
                    }
                    return convertView;
                } catch (Exception e) {
                    e.printStackTrace();
                    return new View(getContext());
                }
            } else if (o.getClass() == String.class) {
                View convertView3 = this.mInflater.inflate(C0846R.layout.separator, (ViewGroup) null);
                TextView tv = (TextView) convertView3.findViewById(C0846R.C0847id.text);
                convertView3.setTag("sep");
                C1232UI.setFont(tv);
                tv.setBackgroundColor(C1216LO.getLo(C1216LO.seperatorBackgroundColor));
                tv.setTextColor(C1216LO.getLo(C1216LO.separatorTextColor));
                tv.setText((String) o);
                return convertView3;
            } else if (o.getClass() != Object.class) {
                return new View(App.act);
            } else {
                View convertView4 = this.mInflater.inflate(C0846R.layout.cell_showonfloorplan, (ViewGroup) null);
                convertView4.setTag("floorplan");
                TextView showon = (TextView) convertView4.findViewById(C0846R.C0847id.showon);
                C1232UI.setFont(showon);
                TCObject mapLauncher = C1199DB.getFirstObject("launchers", "moduletypeid", "72");
                if (!mapLauncher.has(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)) {
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

        public Object[] getSections() {
            return this.sections;
        }

        public Filter getFilter() {
            if (this.filter == null) {
                this.filter = new TCFilter(this, (TCFilter) null);
            }
            return this.filter;
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
                List<Object> filt = new ArrayList<>();
                List<Object> buffer = new ArrayList<>();
                if (constraint2 == null || constraint2.toString().length() <= 0) {
                    result.count = TCListObjectAdapter.this.items.size();
                    result.values = TCListObjectAdapter.this.items;
                } else {
                    boolean isDiacritical = false;
                    int l = constraint2.length();
                    for (int i = 0; i < l; i++) {
                        if (constraint2.charAt(i) > 127) {
                            isDiacritical = true;
                        }
                    }
                    int l2 = TCListObjectAdapter.this.items.size();
                    for (int i2 = 0; i2 < l2; i2++) {
                        if (TCListObjectAdapter.this.items.get(i2).getClass() == TCListObject.class) {
                            TCListObject tlo = (TCListObject) TCListObjectAdapter.this.items.get(i2);
                            String text = tlo.getText().toLowerCase();
                            if (!isDiacritical) {
                                text = Normalizer.removeDiacritic(text);
                            }
                            if (text.contains(constraint2) || (tlo.getSearch() != null && tlo.getSearch().toLowerCase().contains(constraint2))) {
                                buffer.add(tlo);
                            }
                        } else {
                            buffer.add(TCListObjectAdapter.this.items.get(i2));
                        }
                    }
                    int l3 = buffer.size();
                    for (int i3 = 0; i3 < l3; i3++) {
                        Object buf = buffer.get(i3);
                        if (buf.getClass() != String.class) {
                            filt.add(buf);
                        } else if (i3 + 1 < l3 && buffer.get(i3 + 1).getClass() == TCListObject.class) {
                            filt.add(buf);
                        }
                    }
                    result.count = filt.size();
                    result.values = filt;
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
}
