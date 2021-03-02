package com.tapcrowd.app.modules.business;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.ItemPickerFragment;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.OnFragmentResultListener;
import com.tapcrowd.app.utils.TCDBHelper;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import com.tapcrowd.app.views.RoundedImageView;
import com.tapcrowd.app.views.SectionView;
import java.util.ArrayList;
import java.util.List;
import org.apache.cordova.Globalization;

public class CatalogCompareFragmentV2 extends TCFragment {
    /* access modifiers changed from: private */
    public static ArrayList<String> ids = new ArrayList<>();
    private final int REQUEST_CODE = 33;
    View.OnClickListener addItem = new View.OnClickListener() {
        public void onClick(View v) {
            List<Object> list = TCDBHelper.getTCListFromDb("SELECT id, order_value, name, imageurl FROM catalog;", new TCDBHelper.TCListHelperObject(DBFavorites.KEY_NAME, (String) null, "imageurl"));
            for (Object o : list) {
                if (o instanceof TCListObject) {
                    TCListObject tlo = (TCListObject) o;
                    if (tlo.getId().equals("swipe2mobile")) {
                        tlo.setText(C1199DB.getFirstObject("launchers", "moduletypeid", "75").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                    }
                }
            }
            Fragments.add(CatalogCompareFragmentV2.this, ItemPickerFragment.newInstance(new OnFragmentResultListener() {
                public void onFragmentResult(Intent data, int requestCode, int resultCode) {
                    String id = data.getStringExtra(DBFavorites.KEY_EVENT_ID);
                    if (!CatalogCompareFragmentV2.ids.contains(id)) {
                        CatalogCompareFragmentV2.ids.add(id);
                    }
                }
            }, new TCListObject.TCListObjectAdapter(list), 33), "");
        }
    };

    public static CatalogCompareFragmentV2 newInstance() {
        return new CatalogCompareFragmentV2();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (ids.size() == 0) {
            this.f2005v = inflater.inflate(C0846R.layout.layout_compare_no_items, container, false);
        } else if (ids.size() == 1) {
            this.f2005v = inflater.inflate(C0846R.layout.layout_compare_one_item, container, false);
        } else {
            this.f2005v = inflater.inflate(C0846R.layout.layout_compare_two_items, container, false);
        }
        return this.f2005v;
    }

    public void onDetach() {
        if (!App.tablet) {
            getActivity().setRequestedOrientation(1);
        }
        super.onDetach();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setRequestedOrientation(-1);
        if (ids.size() == 0) {
            noItems();
        } else if (ids.size() == 1) {
            oneItem();
        } else {
            twoItems();
        }
    }

    public void noItems() {
        this.f2005v.findViewById(C0846R.C0847id.add).setOnClickListener(this.addItem);
    }

    public void oneItem() {
        SectionView.Type type;
        this.f2005v.findViewById(C0846R.C0847id.add).setOnClickListener(this.addItem);
        String id = ids.get(0);
        TCObject catalog = C1199DB.getFirstObject(LinkedObjects.TABLE_CAT, DBFavorites.KEY_EVENT_ID, id);
        FastImageLoader fastImageLoader = new FastImageLoader();
        fastImageLoader.DisplayImage(catalog.get("imageurl"), (ImageView) this.f2005v.findViewById(C0846R.C0847id.image));
        ((TextView) this.f2005v.findViewById(C0846R.C0847id.name)).setText(catalog.get(DBFavorites.KEY_NAME));
        C1232UI.setText((int) C0846R.C0847id.description, catalog.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION), this.f2005v);
        ViewGroup container = (ViewGroup) this.f2005v.findViewById(C0846R.C0847id.container);
        List<TCObject> metavalues = C1199DB.getQueryFromDb(String.format("SELECT type, sortorder, value FROM metavalues WHERE parentType == 'catalog' AND parentId == '%1$s' AND type != 'custom' ORDER BY sortorder + 0 DESC", new Object[]{id}));
        int len = metavalues.size();
        for (int i = 0; i < len; i++) {
            TCObject meta = metavalues.get(i);
            if (meta.get(Globalization.TYPE).equals("header")) {
                SectionView sectionView = new SectionView((Context) getActivity(), meta.get("value"));
                container.addView(sectionView);
                int sublen = len;
                for (int j = i + 1; j < sublen; j++) {
                    TCObject sub = metavalues.get(j);
                    if (sub.get(Globalization.TYPE).equals("header")) {
                        sublen = j;
                    } else {
                        String val = sub.get("value");
                        String text = val.split(";;;")[0];
                        String typeStr = "";
                        if (val.split(";;;").length > 1) {
                            typeStr = val.split(";;;")[1];
                        }
                        if (typeStr.equals("(v)")) {
                            type = SectionView.Type.Yes;
                        } else if (typeStr.equals("-")) {
                            type = SectionView.Type.f2142No;
                        } else if (typeStr.equals("opt")) {
                            type = SectionView.Type.Optional;
                        } else {
                            type = SectionView.Type.None;
                        }
                        sectionView.addView(text, type);
                    }
                }
            }
        }
        addColors(C0846R.C0847id.colors, C1199DB.getQueryFromDb("SELECT value FROM metavalues WHERE parentType == 'catalog' AND parentId == '" + id + "'" + "AND name LIKE 'COLOR:%' AND type = 'custom'"));
        addRims(C0846R.C0847id.rims, C1199DB.getQueryFromDb("SELECT value FROM metavalues WHERE parentType == 'catalog' AND parentId == '" + id + "'" + "AND name LIKE 'RIM:%' AND type = 'custom'"));
        addPrices(C0846R.C0847id.car, C0846R.C0847id.extras, C0846R.C0847id.tot, C1199DB.getQueryFromDb("SELECT name, value FROM metavalues WHERE parentType == 'catalog' AND parentId == '" + id + "'" + "AND name LIKE 'PRICE:%' AND type = 'custom'"));
    }

    public void twoItems() {
        SectionView.Type typeLeft;
        SectionView.Type typeRight;
        String leftId = ids.get(0);
        String rightId = ids.get(1);
        TCObject left = C1199DB.getFirstObject(LinkedObjects.TABLE_CAT, DBFavorites.KEY_EVENT_ID, leftId);
        TCObject right = C1199DB.getFirstObject(LinkedObjects.TABLE_CAT, DBFavorites.KEY_EVENT_ID, rightId);
        FastImageLoader fastImageLoader = new FastImageLoader();
        fastImageLoader.DisplayImage(left.get("imageurl"), (ImageView) this.f2005v.findViewById(C0846R.C0847id.image_left));
        FastImageLoader fastImageLoader2 = new FastImageLoader();
        fastImageLoader2.DisplayImage(right.get("imageurl"), (ImageView) this.f2005v.findViewById(C0846R.C0847id.image_right));
        ((TextView) this.f2005v.findViewById(C0846R.C0847id.name_left)).setText(left.get(DBFavorites.KEY_NAME));
        ((TextView) this.f2005v.findViewById(C0846R.C0847id.name_right)).setText(right.get(DBFavorites.KEY_NAME));
        ((TextView) this.f2005v.findViewById(C0846R.C0847id.desc_left)).setText(left.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION));
        ((TextView) this.f2005v.findViewById(C0846R.C0847id.desc_right)).setText(right.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION));
        ViewGroup container = (ViewGroup) this.f2005v.findViewById(C0846R.C0847id.container);
        SectionView section = null;
        for (TCObject order : C1199DB.getQueryFromDb(String.format("SELECT DISTINCT sortorder FROM metavalues WHERE parentType == 'catalog' AND (parentId == '%1$s' OR parentId == '%2$s') AND type != 'custom' ORDER BY sortorder + 0 DESC", new Object[]{leftId, rightId}))) {
            List<TCObject> metavalues = C1199DB.getQueryFromDb(String.format("SELECT type, parentId, name, value FROM metavalues WHERE parentType == 'catalog' AND (parentId == '%1$s' OR parentId == '%2$s') AND sortorder == '%3$s' AND type != 'custom' ORDER BY name", new Object[]{leftId, rightId, order.get("sortorder")}));
            if (metavalues.get(0).get(Globalization.TYPE).equals("header")) {
                section = new SectionView((Context) getActivity(), metavalues.get(0).get("value"));
                container.addView(section);
            } else if (section != null) {
                int i = 0;
                int len = metavalues.size();
                while (i < len) {
                    TCObject meta = metavalues.get(i);
                    String leftVal = "/";
                    String rightVal = "/";
                    if (meta.get("parentId").equals(leftId)) {
                        leftVal = meta.get("value");
                    } else {
                        rightVal = meta.get("value");
                    }
                    if (i + 1 < len) {
                        if (metavalues.get(i + 1).get(DBFavorites.KEY_NAME).equals(meta.get(DBFavorites.KEY_NAME))) {
                            TCObject namedMeta = metavalues.get(i + 1);
                            if (namedMeta.get("parentId").equals(leftId)) {
                                leftVal = namedMeta.get("value");
                            } else {
                                rightVal = namedMeta.get("value");
                            }
                            i++;
                        }
                    }
                    String leftTxt = leftVal.split(";;;")[0];
                    String typeStr = "";
                    if (leftVal.split(";;;").length > 1) {
                        typeStr = leftVal.split(";;;")[1];
                    }
                    if (typeStr.equals("(v)")) {
                        typeLeft = SectionView.Type.Yes;
                    } else if (typeStr.equals("-")) {
                        typeLeft = SectionView.Type.f2142No;
                    } else if (typeStr.equals("opt")) {
                        typeLeft = SectionView.Type.Optional;
                    } else {
                        typeLeft = SectionView.Type.None;
                    }
                    String rightTxt = rightVal.split(";;;")[0];
                    String typeStr2 = "";
                    if (rightVal.split(";;;").length > 1) {
                        typeStr2 = rightVal.split(";;;")[1];
                    }
                    if (typeStr2.equals("(v)")) {
                        typeRight = SectionView.Type.Yes;
                    } else if (typeStr2.equals("-")) {
                        typeRight = SectionView.Type.f2142No;
                    } else if (typeStr2.equals("opt")) {
                        typeRight = SectionView.Type.Optional;
                    } else {
                        typeRight = SectionView.Type.None;
                    }
                    section.addView(leftTxt, typeLeft, rightTxt, typeRight);
                    i++;
                }
            }
        }
        addColors(C0846R.C0847id.colors_left, C1199DB.getQueryFromDb("SELECT value FROM metavalues WHERE parentType == 'catalog' AND parentId == '" + leftId + "'" + "AND name LIKE 'COLOR:%' AND type = 'custom'"));
        addColors(C0846R.C0847id.colors_right, C1199DB.getQueryFromDb("SELECT value FROM metavalues WHERE parentType == 'catalog' AND parentId == '" + rightId + "'" + "AND name LIKE 'COLOR:%' AND type = 'custom'"));
        addRims(C0846R.C0847id.rims_left, C1199DB.getQueryFromDb("SELECT value FROM metavalues WHERE parentType == 'catalog' AND parentId == '" + leftId + "'" + "AND name LIKE 'RIM:%' AND type = 'custom'"));
        addRims(C0846R.C0847id.rims_right, C1199DB.getQueryFromDb("SELECT value FROM metavalues WHERE parentType == 'catalog' AND parentId == '" + rightId + "'" + "AND name LIKE 'RIM:%' AND type = 'custom'"));
        addPrices(C0846R.C0847id.car_left, C0846R.C0847id.extras_left, C0846R.C0847id.tot_left, C1199DB.getQueryFromDb("SELECT name, value FROM metavalues WHERE parentType == 'catalog' AND parentId == '" + leftId + "'" + "AND name LIKE 'PRICE:%' AND type = 'custom'"));
        addPrices(C0846R.C0847id.car_right, C0846R.C0847id.extras_right, C0846R.C0847id.tot_right, C1199DB.getQueryFromDb("SELECT name, value FROM metavalues WHERE parentType == 'catalog' AND parentId == '" + rightId + "'" + "AND name LIKE 'PRICE:%' AND type = 'custom'"));
    }

    public void addColors(int parentid, List<TCObject> colors) {
        LinearLayout colorParent = null;
        int convertDpToPixel = (int) Converter.convertDpToPixel(5.0f, getActivity());
        int len = colors.size() + (5 - (colors.size() % 5 == 0 ? 5 : colors.size() % 5));
        for (int i = 0; i < len; i++) {
            if (i % 5 == 0 || colorParent == null) {
                int padding = (int) Converter.convertDpToPixel(5.0f, getActivity());
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -2);
                colorParent = new LinearLayout(getActivity());
                colorParent.setLayoutParams(params);
                colorParent.setPadding(padding, 0, padding, padding);
                ((ViewGroup) this.f2005v.findViewById(parentid)).addView(colorParent);
            }
            int padding2 = (int) Converter.convertDpToPixel(2.0f, getActivity());
            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(0, -2);
            params2.weight = 1.0f;
            params2.leftMargin = padding2;
            params2.rightMargin = padding2;
            if (i < colors.size()) {
                RoundedImageView iv = new RoundedImageView(getActivity());
                iv.setImageResource(C0846R.drawable.gradient_overlay);
                iv.setColor(Color.parseColor(colors.get(i).get("value")));
                iv.setLayoutParams(params2);
                colorParent.addView(iv);
            } else {
                View v = new View(getActivity());
                v.setLayoutParams(params2);
                colorParent.addView(v);
            }
        }
    }

    private void addRims(int parentid, List<TCObject> rims) {
        ViewGroup parent = (ViewGroup) this.f2005v.findViewById(parentid);
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        for (TCObject rim : rims) {
            View v = inflater.inflate(C0846R.layout.cell_rim, (ViewGroup) null);
            new FastImageLoader().DisplayImage(rim.get("value").split(";;;")[0], (ImageView) v.findViewById(C0846R.C0847id.icon));
            ((TextView) v.findViewById(C0846R.C0847id.description)).setText(rim.get("value").split(";;;")[1]);
            parent.addView(v);
        }
    }

    private void addPrices(int carId, int extrasId, int totId, List<TCObject> prices) {
        ViewGroup parent = (ViewGroup) this.f2005v.findViewById(C0846R.C0847id.prices);
        if (prices.size() == 0) {
            parent.setVisibility(8);
        }
        ViewGroup car = (ViewGroup) this.f2005v.findViewById(carId);
        ViewGroup extras = (ViewGroup) this.f2005v.findViewById(extrasId);
        double tot = 0.0d;
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        for (TCObject price : prices) {
            double value = Double.parseDouble(price.get("value").split(";;;")[1]);
            tot += value;
            String text = price.get("value").split(";;;")[0];
            View v = inflater.inflate(C0846R.layout.cell_price, (ViewGroup) null);
            ((TextView) v.findViewById(C0846R.C0847id.text)).setText(text);
            TextView priceTv = (TextView) v.findViewById(C0846R.C0847id.price);
            if (value != 0.0d) {
                priceTv.setText("€" + String.format("%.0f", new Object[]{Double.valueOf(value)}));
            }
            if (price.get(DBFavorites.KEY_NAME).equals("PRICE:CAR")) {
                car.addView(v);
            } else {
                extras.addView(v);
            }
        }
        ((TextView) this.f2005v.findViewById(totId)).setText("€" + String.format("%.0f", new Object[]{Double.valueOf(tot)}));
    }

    public static void add(String id) {
        if (!ids.contains(id)) {
            if (ids.size() == 2) {
                ids.remove(0);
            }
            ids.add(id);
        }
    }
}
