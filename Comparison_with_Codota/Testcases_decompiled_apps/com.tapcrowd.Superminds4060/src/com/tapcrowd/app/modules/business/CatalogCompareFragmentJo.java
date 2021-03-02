package com.tapcrowd.app.modules.business;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p000v4.view.PagerAdapter;
import android.support.p000v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.OnFragmentResultListener;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import com.tapcrowd.app.views.ObservableScrollView;
import com.tapcrowd.app.views.ScrollViewListener;
import com.tapcrowd.app.views.Separator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TargetApi(11)
public class CatalogCompareFragmentJo extends TCFragment {
    private final int MaxCompareItems = 2;
    /* access modifiers changed from: private */
    public List<String> ids = new ArrayList();
    private boolean retain;

    /* renamed from: v */
    private View f2015v;

    public static CatalogCompareFragmentJo newInstance() {
        return new CatalogCompareFragmentJo();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2015v == null) {
            this.f2015v = inflater.inflate(C0846R.layout.catalog_compare, container, false);
        } else {
            ((ViewGroup) this.f2015v.getParent()).removeView(this.f2015v);
            this.retain = true;
        }
        return this.f2015v;
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
        if (!this.retain && !this.ids.isEmpty()) {
            String value = "";
            for (String o : this.ids) {
                value = String.valueOf(value) + "' OR id == '" + o;
            }
            ((ViewPager) this.f2015v.findViewById(C0846R.C0847id.viewpager)).setAdapter(new CatalogViewpageAdapter(C1199DB.getListFromDb(LinkedObjects.TABLE_CAT, DBFavorites.KEY_EVENT_ID, value.substring(12))));
        }
    }

    /* access modifiers changed from: private */
    public void pickItem(int requestcode) {
        Fragments.add(this, CatalogPickerFragment.newInstance(new OnFragmentResultListener() {
            public void onFragmentResult(Intent data, int requestCode, int resultCode) {
                CatalogCompareFragmentJo.this.onActivityResult(requestCode, resultCode, data);
            }
        }, requestcode), "");
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1) {
            this.ids.add(data.getStringExtra(DBFavorites.KEY_EVENT_ID));
        }
        onActivityCreated(getArguments());
    }

    private class CatalogViewpageAdapter extends PagerAdapter {

        /* renamed from: li */
        private LayoutInflater f2016li;
        private List<TCObject> tco;
        /* access modifiers changed from: private */

        /* renamed from: y */
        public int f2017y = 0;

        public CatalogViewpageAdapter(List<TCObject> tco2) {
            this.tco = tco2;
            this.f2016li = CatalogCompareFragmentJo.this.getActivity().getLayoutInflater();
        }

        public CharSequence getPageTitle(int position) {
            return this.tco.get(position).get(DBFavorites.KEY_NAME);
        }

        public int getCount() {
            return 2;
        }

        public Object instantiateItem(ViewGroup collection, int position) {
            View view = this.f2016li.inflate(C0846R.layout.catalog_compare_viewpager, (ViewGroup) null);
            TCObject to = this.tco.get(position);
            TextView tvName = (TextView) view.findViewById(C0846R.C0847id.tvName);
            List<TCObject> meta = new ArrayList<>();
            Map<String, TCObject> metaMap = new HashMap<>();
            List<TCObject> allKeys = new ArrayList<>();
            if (to.get(DBFavorites.KEY_EVENT_ID) != null) {
                tvName.setText(to.get(DBFavorites.KEY_NAME));
                tvName.setTextColor(C1216LO.getLo(C1216LO.textcolor));
                new FastImageLoader().DisplayImage(to.get("imageurl"), (ImageView) view.findViewById(C0846R.C0847id.ivPicture));
                meta = C1199DB.getQueryFromDb("SELECT name, value FROM metavalues WHERE parentType == 'catalog' AND parentId == '" + to.get(DBFavorites.KEY_EVENT_ID) + "'");
                String value = "";
                for (String o : CatalogCompareFragmentJo.this.ids) {
                    value = String.valueOf(value) + " OR parentId == '" + o + "'";
                }
                allKeys = C1199DB.getQueryFromDb("SELECT DISTINCT(name) FROM metavalues WHERE parentType == 'catalog' AND ( " + value.substring(4) + " );");
                for (TCObject o2 : meta) {
                    metaMap.put(o2.toString(), o2);
                }
            } else {
                tvName.setText(CatalogCompareFragmentJo.this.getString(C0846R.string.selectcompare));
                tvName.setTextColor(C1216LO.getLo(C1216LO.textcolor));
                tvName.setTextSize(13.0f);
                tvName.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        CatalogCompareFragmentJo.this.pickItem(22);
                    }
                });
            }
            meta.clear();
            ObservableScrollView sv = (ObservableScrollView) view.findViewById(C0846R.C0847id.observableScrollView);
            final ViewGroup viewGroup = collection;
            sv.setScrollViewListener(new ScrollViewListener() {
                public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
                    CatalogViewpageAdapter.this.f2017y = y;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        try {
                            ((ObservableScrollView) viewGroup.getChildAt(i).findViewById(C0846R.C0847id.observableScrollView)).scrollTo(0, y);
                        } catch (Exception e) {
                        }
                    }
                }
            });
            sv.scrollTo(0, this.f2017y);
            LinearLayout compareContainer = (LinearLayout) view.findViewById(C0846R.C0847id.compareContainer);
            LayoutInflater li = CatalogCompareFragmentJo.this.getActivity().getLayoutInflater();
            compareContainer.removeAllViews();
            for (int i = 0; i < allKeys.size(); i++) {
                LinearLayout convertView = (LinearLayout) li.inflate(C0846R.layout.cell_catalogcompare, (ViewGroup) null);
                TCObject o3 = metaMap.get(allKeys.get(i).get(DBFavorites.KEY_NAME));
                ((Separator) convertView.findViewById(C0846R.C0847id.sepkey)).setText(allKeys.get(i).get(DBFavorites.KEY_NAME));
                if (o3 != null) {
                    ((TextView) convertView.findViewById(C0846R.C0847id.value)).setText(o3.get("value"));
                }
                compareContainer.addView(convertView);
            }
            collection.addView(view);
            return view;
        }

        public float getPageWidth(int position) {
            return 0.5f;
        }

        public void destroyItem(View collection, int position, Object view) {
            ((ViewPager) collection).removeView((View) view);
        }

        public boolean isViewFromObject(View view, Object object) {
            return view == ((View) object);
        }

        public void finishUpdate(View arg0) {
        }

        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }

        public Parcelable saveState() {
            return null;
        }

        public void startUpdate(View arg0) {
        }
    }
}
