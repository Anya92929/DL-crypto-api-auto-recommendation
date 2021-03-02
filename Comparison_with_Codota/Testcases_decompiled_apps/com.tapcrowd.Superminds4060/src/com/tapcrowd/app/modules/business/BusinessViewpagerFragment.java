package com.tapcrowd.app.modules.business;

import android.os.Bundle;
import android.support.p000v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.utils.TCDBHelper;
import com.tapcrowd.app.utils.ViewPagerAdapter;

public class BusinessViewpagerFragment extends TCFragment {
    private String module;
    private int position;
    private boolean retained;

    /* renamed from: v */
    private View f2014v;

    public static BusinessViewpagerFragment newInstance(String module2, int position2) {
        BusinessViewpagerFragment fr = new BusinessViewpagerFragment();
        fr.module = module2;
        fr.position = position2;
        return fr;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2014v == null) {
            this.f2014v = inflater.inflate(C0846R.layout.layout_viewpager, container, false);
        } else {
            ((ViewGroup) this.f2014v.getParent()).removeView(this.f2014v);
            this.retained = false;
        }
        return this.f2014v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!this.retained) {
            ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity(), TCDBHelper.getTCListFromDb(String.format("SELECT id, description, imageurl, order_value FROM catalog WHERE catalog.type == '%1$s' ORDER BY order_value +0 DESC, catalog.name COLLATE NOCASE", new Object[]{this.module}), new TCDBHelper.TCListHelperObject(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, (String) null, "imageurl", false), false), C0846R.layout.cell_business_viewpager);
            ViewPager pager = (ViewPager) this.f2014v.findViewById(C0846R.C0847id.viewpager);
            pager.setAdapter(adapter);
            pager.setCurrentItem(this.position);
        }
    }
}
