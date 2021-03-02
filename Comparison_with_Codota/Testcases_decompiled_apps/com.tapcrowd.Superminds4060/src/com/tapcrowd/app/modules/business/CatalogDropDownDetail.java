package com.tapcrowd.app.modules.business;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.modules.notes.AddNoteFragment;
import com.tapcrowd.app.modules.swipe2mobile.Swipe2MobileFragment;
import com.tapcrowd.app.modules.webview.WebViewFragment;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.User;
import com.tapcrowd.app.utils.images.FastImageLoader;
import com.tapcrowd.app.views.ImageViewpager;
import com.tapcrowd.app.views.RoundedImageView;
import com.tapcrowd.tcanalytics.TCAnalytics;
import java.util.ArrayList;
import java.util.List;

public class CatalogDropDownDetail extends TCFragment implements MenuFragment.MenuItemListener {
    private final int NOTES = 5345;
    private final int SHARE = 556;
    private final int SWIPE = 799;
    View.OnClickListener brochure = new View.OnClickListener() {
        public void onClick(View v) {
            Fragments.add(CatalogDropDownDetail.this, WebViewFragment.newInstance("http://www1.citobi.be/KIA138/mobile/folderModel.action?lg=nl&source=KiaMotors&resource=mobile&utm_campaign=kia-app&utm_medium=offline&utm_source=kia-app", "modelReference=" + C1199DB.getFirstObject("metavalues", "parentType == 'catalog' AND name == 'MODEL' AND parentId", CatalogDropDownDetail.this.f2020id).get("value")), "");
        }
    };
    View.OnClickListener compare = new View.OnClickListener() {
        public void onClick(View v) {
            CatalogCompareFragmentV2.add(CatalogDropDownDetail.this.f2020id);
            Fragments.add(CatalogDropDownDetail.this, CatalogCompareFragmentV2.newInstance(), C1199DB.getFirstObject("launchers", "moduletypeid", "73").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: id */
    public String f2020id;
    private String module;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public TCObject f2021o;
    private boolean swipe2mobile;
    View.OnClickListener testdrive = new View.OnClickListener() {
        public void onClick(View v) {
            Fragments.add(CatalogDropDownDetail.this, WebViewFragment.newInstance(String.valueOf(String.valueOf("http://www1.citobi.be/KIA138/mobile/model.action?source=KiaMotors&resource=mobile &utm_campaign=kia-app&utm_medium=offline&utm_source=kia-app") + "&lg=" + User.getLanguage(CatalogDropDownDetail.this.getActivity())) + "&modelReference=" + C1199DB.getQueryFromDb("SELECT value FROM metavalues WHERE parentType == 'catalog' AND parentId == '" + CatalogDropDownDetail.this.f2021o.get(DBFavorites.KEY_EVENT_ID) + "' AND name == 'MODEL'").get(0).get("value"), true), "");
        }
    };
    private String text;

    public static CatalogDropDownDetail newInstance(String id, int nullcolumnhack) {
        CatalogDropDownDetail detail = new CatalogDropDownDetail();
        detail.f2020id = id;
        return detail;
    }

    public static CatalogDropDownDetail newInstance(String id, boolean swipe2mobile2) {
        CatalogDropDownDetail detail = new CatalogDropDownDetail();
        detail.f2020id = id;
        detail.swipe2mobile = swipe2mobile2;
        return detail;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.f2020id);
        outState.putString("text", this.text);
        outState.putString(DBFavorites.KEY_MODULE, this.module);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f2005v = inflater.inflate(C0846R.layout.bus_dropdown_detail, container, false);
        if (savedInstanceState != null && this.f2020id == null) {
            this.f2020id = savedInstanceState.getString(DBFavorites.KEY_EVENT_ID);
            this.text = savedInstanceState.getString("text");
            this.module = savedInstanceState.getString(DBFavorites.KEY_MODULE);
        }
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        if (C1199DB.getSize("launchers", "moduletypeid", "35") > 0) {
            menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_notes_nav, C1216LO.getLo(C1216LO.navigationColor)), 5345));
        }
        menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_share, C1216LO.getLo(C1216LO.navigationColor)), 556));
        if (this.swipe2mobile) {
            menuitems.add(new MenuFragment.MenuItemContainer(getString(C0846R.string.New), 799, true));
        }
        Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
        this.f2021o = C1199DB.getFirstObject(LinkedObjects.TABLE_CAT, DBFavorites.KEY_EVENT_ID, this.f2020id);
        C1232UI.setText((int) C0846R.C0847id.name, this.f2021o.get(DBFavorites.KEY_NAME, ""), this.f2005v);
        C1232UI.setTextColor(C0846R.C0847id.name, -1, this.f2005v);
        String description = this.f2021o.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        if (description.equals("\n\n\n\n")) {
            description = null;
        }
        C1232UI.setText((int) C0846R.C0847id.description, description, this.f2005v);
        addColors(C1199DB.getQueryFromDb("SELECT value FROM metavalues WHERE parentType == 'catalog' AND parentId == '" + this.f2021o.get(DBFavorites.KEY_EVENT_ID) + "'" + "AND name LIKE 'COLOR:%' AND type = 'custom'"));
        addRims(C1199DB.getQueryFromDb("SELECT value FROM metavalues WHERE parentType == 'catalog' AND parentId == '" + this.f2021o.get(DBFavorites.KEY_EVENT_ID) + "'" + "AND name LIKE 'RIM:%' AND type = 'custom'"));
        addPrices(C1199DB.getQueryFromDb("SELECT name, value FROM metavalues WHERE parentType == 'catalog' AND parentId == '" + this.f2021o.get(DBFavorites.KEY_EVENT_ID) + "'" + "AND name LIKE 'PRICE:%' AND type = 'custom'"));
        List<String> images = new ArrayList<>();
        if (this.f2021o.has("imageurl")) {
            images.add(this.f2021o.get("imageurl"));
        }
        for (TCObject meta : C1199DB.getQueryFromDb("SELECT value FROM metavalues WHERE type == 'image' AND  parentType == 'catalog' AND parentId == '" + this.f2021o.get(DBFavorites.KEY_EVENT_ID) + "'")) {
            images.add(meta.get("value"));
        }
        ImageViewpager ivp = (ImageViewpager) this.f2005v.findViewById(C0846R.C0847id.imageViewpager);
        ivp.setVisibility(0);
        ivp.showImages(images);
        if (images.size() == 0) {
            ivp.setVisibility(8);
            this.f2005v.findViewById(C0846R.C0847id.placeholder).setVisibility(0);
        }
        C1232UI.AddDropDownMetaData(this, LinkedObjects.TABLE_CAT, this.f2021o.get(DBFavorites.KEY_EVENT_ID), this.f2005v);
        this.f2005v.findViewById(C0846R.C0847id.testdrive).setOnClickListener(this.testdrive);
        this.f2005v.findViewById(C0846R.C0847id.brochure).setOnClickListener(this.brochure);
        this.f2005v.findViewById(C0846R.C0847id.compare).setOnClickListener(this.compare);
        return this.f2005v;
    }

    private void addColors(List<TCObject> colors) {
        LinearLayout colorParent = null;
        int padding = (int) Converter.convertDpToPixel(5.0f, getActivity());
        if (colors.size() == 0) {
            ((ViewGroup) this.f2005v.findViewById(C0846R.C0847id.colors)).setVisibility(8);
        }
        int len = colors.size() + (8 - (colors.size() % 8 == 0 ? 8 : colors.size() % 8));
        for (int i = 0; i < len; i++) {
            if (i % 8 == 0 || colorParent == null) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -2);
                colorParent = new LinearLayout(getActivity());
                colorParent.setLayoutParams(params);
                colorParent.setPadding(padding, padding, padding, padding);
                ((ViewGroup) this.f2005v.findViewById(C0846R.C0847id.colors)).addView(colorParent);
            }
            padding = (int) Converter.convertDpToPixel(2.0f, getActivity());
            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(0, -2);
            params2.weight = 1.0f;
            params2.leftMargin = padding;
            params2.rightMargin = padding;
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

    private void addRims(List<TCObject> rims) {
        ViewGroup parent = (ViewGroup) this.f2005v.findViewById(C0846R.C0847id.rims);
        if (rims.size() == 0) {
            parent.setVisibility(8);
        }
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        for (TCObject rim : rims) {
            View v = inflater.inflate(C0846R.layout.cell_rim, (ViewGroup) null);
            new FastImageLoader().DisplayImage(rim.get("value").split(";;;")[0], (ImageView) v.findViewById(C0846R.C0847id.icon));
            ((TextView) v.findViewById(C0846R.C0847id.description)).setText(rim.get("value").split(";;;")[1]);
            parent.addView(v);
        }
    }

    private void addPrices(List<TCObject> prices) {
        ViewGroup parent = (ViewGroup) this.f2005v.findViewById(C0846R.C0847id.prices);
        if (prices.size() == 0) {
            parent.setVisibility(8);
        }
        ViewGroup car = (ViewGroup) this.f2005v.findViewById(C0846R.C0847id.car);
        ViewGroup extras = (ViewGroup) this.f2005v.findViewById(C0846R.C0847id.extras);
        double tot = 0.0d;
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        for (TCObject price : prices) {
            double value = Double.parseDouble(price.get("value").split(";;;")[1]);
            tot += value;
            String text2 = price.get("value").split(";;;")[0];
            View v = inflater.inflate(C0846R.layout.cell_price, (ViewGroup) null);
            ((TextView) v.findViewById(C0846R.C0847id.text)).setText(text2);
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
        ((TextView) this.f2005v.findViewById(C0846R.C0847id.tot)).setText("€" + String.format("%.0f", new Object[]{Double.valueOf(tot)}));
    }

    public void onResume() {
        super.onResume();
        if (this.f2021o.has("loggingpath")) {
            TCAnalytics.log(getActivity(), this.f2021o.get("loggingpath"), "");
        }
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 556:
                share();
                return;
            case 799:
                Swipe2MobileFragment.remove();
                Fragments.add((Fragment) null, Swipe2MobileFragment.newInstance(), this.title);
                return;
            case 5345:
                Fragments.add(this, AddNoteFragment.newInstance(LinkedObjects.TABLE_CAT, this.f2020id), "");
                return;
            default:
                return;
        }
    }

    public void share() {
        Intent textIntent = new Intent("android.intent.action.SEND");
        Intent mailIntent = new Intent("android.intent.action.SEND");
        textIntent.setType("text/plain");
        mailIntent.setType("message/rfc822");
        String message = getString(C0846R.string.kia_share, this.f2021o.get(DBFavorites.KEY_NAME));
        textIntent.putExtra("android.intent.extra.SUBJECT", message);
        textIntent.putExtra("android.intent.extra.TEXT", message);
        mailIntent.putExtra("android.intent.extra.SUBJECT", message);
        mailIntent.putExtra("android.intent.extra.TEXT", message);
        Intent chooser = Intent.createChooser(textIntent, "Share");
        chooser.putExtra("android.intent.extra.INITIAL_INTENTS", new Intent[]{mailIntent});
        startActivity(chooser);
    }
}
