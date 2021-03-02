package com.tapcrowd.app.modules.coupons;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.p000v4.view.PagerTitleStrip;
import android.support.p000v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.ViewPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CouponsFragment extends TCFragment {
    private int position;

    public static CouponsFragment newInstance() {
        return new CouponsFragment();
    }

    public static CouponsFragment newInstance(int position2) {
        CouponsFragment fr = new CouponsFragment();
        fr.position = position2;
        return fr;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2005v == null) {
            this.f2005v = inflater.inflate(C0846R.layout.layout_coupons, container, false);
        } else {
            ((ViewGroup) this.f2005v.getParent()).removeView(this.f2005v);
            this.retained = true;
        }
        return this.f2005v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<TCObject> coupons = C1199DB.getListFromDb("coupons", "order_value DESC");
        CouponList claimed = CouponList.load(getActivity());
        List<Object> list = new ArrayList<>();
        for (TCObject coupon : coupons) {
            if (!claimed.contains(coupon.get(DBFavorites.KEY_EVENT_ID))) {
                list.add(new TCListObject(coupon.get(DBFavorites.KEY_EVENT_ID), coupon.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE), coupon.get("content"), (String) null, coupon.get("image")));
            }
        }
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity(), list, C0846R.layout.cell_coupon, this, "coupon");
        ViewPager vp = (ViewPager) this.f2005v.findViewById(C0846R.C0847id.viewpager);
        vp.setAdapter(adapter);
        vp.setCurrentItem(this.position);
        PagerTitleStrip strip = (PagerTitleStrip) this.f2005v.findViewById(C0846R.C0847id.pager_title_strip);
        strip.setBackgroundColor(C1216LO.getLo(C1216LO.seperatorBackgroundColor));
        strip.setTextColor(C1216LO.getLo(C1216LO.separatorTextColor));
        strip.setTextSize(1, 17.0f);
        if (this.retained) {
        }
    }

    private static class Coupon {

        /* renamed from: id */
        public String f2029id;
        public int uses;

        public Coupon(String id, int uses2) {
            this.f2029id = id;
            this.uses = uses2;
        }

        public String toString() {
            JSONObject coupon = new JSONObject();
            try {
                coupon.put(DBFavorites.KEY_EVENT_ID, this.f2029id);
                coupon.put("uses", this.uses);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return coupon.toString();
        }
    }

    private static class CouponList extends ArrayList<Coupon> {
        public boolean contains(String id) {
            Iterator it = iterator();
            while (it.hasNext()) {
                if (((Coupon) it.next()).f2029id.equals(id)) {
                    return true;
                }
            }
            return false;
        }

        public CouponList(JSONArray jArr) {
            if (jArr != null) {
                int len = jArr.length();
                for (int i = 0; i < len; i++) {
                    try {
                        JSONObject jObj = jArr.getJSONObject(i);
                        add(new Coupon(jObj.getString(DBFavorites.KEY_EVENT_ID), jObj.getInt("uses")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public String toString() {
            JSONArray coupons = new JSONArray();
            Iterator it = iterator();
            while (it.hasNext()) {
                try {
                    coupons.put(new JSONObject(((Coupon) it.next()).toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return coupons.toString();
        }

        public void save(Context context) {
            SharedPreferences.Editor edit = context.getSharedPreferences("COUPONS", 0).edit();
            edit.putString("COUPONS", toString());
            edit.commit();
        }

        public static CouponList load(Context context) {
            JSONArray jArr = null;
            String json = context.getSharedPreferences("COUPONS", 0).getString("COUPONS", (String) null);
            if (json != null) {
                try {
                    jArr = new JSONArray(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return new CouponList(jArr);
        }
    }
}
