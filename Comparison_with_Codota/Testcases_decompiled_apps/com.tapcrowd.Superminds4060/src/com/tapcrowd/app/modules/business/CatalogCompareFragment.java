package com.tapcrowd.app.modules.business;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.ItemPickerFragment;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.OnFragmentResultListener;
import com.tapcrowd.app.utils.TCDBHelper;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import com.tapcrowd.app.views.SectionView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.cordova.Globalization;

@TargetApi(11)
public class CatalogCompareFragment extends TCFragment {
    public static ArrayList<String> ids = new ArrayList<>();
    private final int REQUEST_CODE = 33;
    View.OnClickListener addItem = new View.OnClickListener() {
        public void onClick(View v) {
            Fragments.add(CatalogCompareFragment.this, ItemPickerFragment.newInstance(new OnFragmentResultListener() {
                public void onFragmentResult(Intent data, int requestCode, int resultCode) {
                    String id = data.getStringExtra(DBFavorites.KEY_EVENT_ID);
                    if (!CatalogCompareFragment.ids.contains(id)) {
                        CatalogCompareFragment.ids.add(id);
                    }
                }
            }, new TCListObject.TCListObjectAdapter(TCDBHelper.getTCListFromDb("SELECT id, order_value, name, imageurl FROM catalog;", new TCDBHelper.TCListHelperObject(DBFavorites.KEY_NAME, (String) null, "imageurl"))), 33), "");
        }
    };

    public static CatalogCompareFragment newInstance() {
        return new CatalogCompareFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2005v == null) {
            this.f2005v = inflater.inflate(C0846R.layout.layout_compare, container, false);
        } else {
            ((ViewGroup) this.f2005v.getParent()).removeView(this.f2005v);
            this.retained = true;
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
        getActivity().setRequestedOrientation(-1);
        super.onActivityCreated(savedInstanceState);
        if (this.retained) {
        }
    }

    public void onResume() {
        super.onResume();
        ((ViewGroup) this.f2005v.findViewById(C0846R.C0847id.container)).removeAllViews();
        this.f2005v.findViewById(C0846R.C0847id.add).setOnClickListener(this.addItem);
        if (ids.size() == 0) {
            this.f2005v.findViewById(C0846R.C0847id.info).setVisibility(8);
            this.f2005v.findViewById(C0846R.C0847id.line).setVisibility(8);
            this.f2005v.findViewById(C0846R.C0847id.add).setVisibility(0);
            this.f2005v.findViewById(C0846R.C0847id.left).setVisibility(8);
            this.f2005v.findViewById(C0846R.C0847id.right).setVisibility(8);
        } else if (ids.size() == 1) {
            this.f2005v.findViewById(C0846R.C0847id.info).setVisibility(0);
            this.f2005v.findViewById(C0846R.C0847id.line).setVisibility(0);
            this.f2005v.findViewById(C0846R.C0847id.add).setVisibility(0);
            this.f2005v.findViewById(C0846R.C0847id.left).setVisibility(0);
            this.f2005v.findViewById(C0846R.C0847id.right).setVisibility(8);
        } else {
            this.f2005v.findViewById(C0846R.C0847id.info).setVisibility(0);
            this.f2005v.findViewById(C0846R.C0847id.line).setVisibility(0);
            this.f2005v.findViewById(C0846R.C0847id.add).setVisibility(8);
            this.f2005v.findViewById(C0846R.C0847id.left).setVisibility(0);
            this.f2005v.findViewById(C0846R.C0847id.right).setVisibility(0);
        }
        if (ids.size() > 0) {
            showItems();
        }
        if (ids.size() > 0) {
            setupLeft(ids.get(0));
        }
        if (ids.size() > 1) {
            setupRight(ids.get(1));
        }
    }

    public void setupLeft(String id) {
        TCObject catalog = C1199DB.getFirstObject(LinkedObjects.TABLE_CAT, DBFavorites.KEY_EVENT_ID, id);
        new FastImageLoader().DisplayImage(catalog.get("imageurl"), (ImageView) this.f2005v.findViewById(C0846R.C0847id.image_left));
    }

    public void setupRight(String id) {
        TCObject catalog = C1199DB.getFirstObject(LinkedObjects.TABLE_CAT, DBFavorites.KEY_EVENT_ID, id);
        new FastImageLoader().DisplayImage(catalog.get("imageurl"), (ImageView) this.f2005v.findViewById(C0846R.C0847id.image_right));
    }

    private void showItems() {
        String idquery = "";
        Iterator<String> it = ids.iterator();
        while (it.hasNext()) {
            String id = it.next();
            if (idquery.length() > 0) {
                idquery = String.valueOf(idquery) + " OR ";
            }
            idquery = String.valueOf(idquery) + String.format("parentId == '%1$s'", new Object[]{id});
        }
        List<TCObject> metavalues = C1199DB.getQueryFromDb(String.format("SELECT type, sortorder, value, GROUP_CONCAT(parentId || value, ';;;') AS info FROM metavalues WHERE parentType == 'catalog' AND (%1$s) GROUP BY sortorder ORDER BY sortorder + 0 DESC", new Object[]{idquery}));
        ViewGroup container = (ViewGroup) this.f2005v.findViewById(C0846R.C0847id.container);
        int len = metavalues.size();
        for (int i = 0; i < len; i++) {
            TCObject meta = metavalues.get(i);
            if (meta.get(Globalization.TYPE).equals("header")) {
                SectionView section = new SectionView((Context) getActivity(), meta.get("value"));
                container.addView(section);
                int sublen = len;
                for (int j = i + 1; j < sublen; j++) {
                    TCObject sub = metavalues.get(j);
                    if (sub.get(Globalization.TYPE).equals("header")) {
                        sublen = j;
                    } else {
                        addCells(section, sub.get("info"));
                    }
                }
            }
        }
    }

    private void addCells(SectionView section, String info) {
        for (String value : info.split(";;;")) {
            String id = "";
            if (value.startsWith(ids.get(0))) {
                id = ids.get(0);
            } else if (ids.size() > 1) {
                id = ids.get(1);
            }
            value.replaceFirst(id, "");
        }
    }
}
