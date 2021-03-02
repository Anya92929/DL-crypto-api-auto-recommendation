package com.tapcrowd.app.modules.business;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.TCDBHelper;
import com.tapcrowd.app.utils.ThumbsAdapter;

public class BusinessThumbsFragment extends TCFragment {
    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View arg1, int position, long arg3) {
            if (!App.tablet) {
                Fragments.add(BusinessThumbsFragment.this, BusinessViewpagerFragment.newInstance(BusinessThumbsFragment.this.module, position), BusinessThumbsFragment.this.getResourceString(C0846R.string.detail));
            }
        }
    };
    /* access modifiers changed from: private */
    public String module;
    private boolean retained;

    /* renamed from: v */
    private View f2013v;

    public static BusinessThumbsFragment newInstance(String module2) {
        BusinessThumbsFragment fr = new BusinessThumbsFragment();
        fr.module = module2.toLowerCase();
        return fr;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2013v == null) {
            this.f2013v = inflater.inflate(C0846R.layout.layout_gridview, container, false);
        } else {
            ((ViewGroup) this.f2013v.getParent()).removeView(this.f2013v);
            this.retained = true;
        }
        AdHelper.showAds(this, AdHelper.buildPath("24", "list", (String) null));
        return this.f2013v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!this.retained) {
            ThumbsAdapter adapter = new ThumbsAdapter(getActivity(), TCDBHelper.getTCListFromDb(String.format("SELECT id, name, imageurl, order_value FROM catalog WHERE catalog.type == '%1$s' ORDER BY order_value +0 DESC, catalog.name COLLATE NOCASE", new Object[]{this.module}), new TCDBHelper.TCListHelperObject(DBFavorites.KEY_NAME, (String) null, "imageurl", false), false), C0846R.layout.cell_imageview);
            GridView grid = (GridView) this.f2013v.findViewById(C0846R.C0847id.grid);
            grid.setAdapter(adapter);
            grid.setOnItemClickListener(this.listener);
        }
    }
}
