package com.tapcrowd.app.modules.sessions;

import android.os.Bundle;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.PagerAdapter;
import android.support.p000v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.TCListObject2;
import com.tapcrowd.app.utils.TCObject;
import java.util.ArrayList;
import java.util.List;
import twitter4j.internal.http.HttpResponseCode;

public class SessionsByStageFragment extends TCFragment implements ViewPager.OnPageChangeListener {
    List<TCObject> locations;
    ViewPager pager;
    int selectedGroup;
    List<TCObject> sessionGroups;

    public static SessionsByStageFragment newInstance() {
        return new SessionsByStageFragment();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        if (this.title == null) {
            this.title = C1199DB.getFirstObject("launchers", "moduletypeid", "10").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    public View findViewById(int id) {
        return getView().findViewById(id);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(C0846R.layout.sessionbystage, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (C1216LO.getLoDrawable(C1216LO.lineupBackground) != null) {
            findViewById(C0846R.C0847id.main).setBackgroundDrawable(C1216LO.getLoDrawable(C1216LO.lineupBackground));
        } else {
            findViewById(C0846R.C0847id.main).setBackgroundDrawable(C1216LO.getLoDrawable(C1216LO.launcherBackground));
        }
        try {
            findViewById(C0846R.C0847id.title).setBackgroundDrawable(C1216LO.getLoDrawable(C1216LO.navbar));
        } catch (Exception e) {
        }
        this.sessionGroups = C1199DB.getListFromDb("sessiongroups", "eventid", App.curEventId, "order_value +0 DESC");
        if (this.sessionGroups.size() == 1) {
            C1232UI.hide(C0846R.C0847id.prevnext);
        } else {
            findViewById(C0846R.C0847id.prevnext).setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
        }
        this.pager = (ViewPager) findViewById(C0846R.C0847id.viewerpager);
        ((ImageView) findViewById(C0846R.C0847id.prev)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SessionsByStageFragment.this.prev(v);
            }
        });
        ((ImageView) findViewById(C0846R.C0847id.next)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SessionsByStageFragment.this.next(v);
            }
        });
        update();
    }

    public void next(View v) {
        this.selectedGroup++;
        if (this.selectedGroup >= this.sessionGroups.size()) {
            this.selectedGroup = this.sessionGroups.size() - 1;
        }
        update();
    }

    public void prev(View v) {
        this.selectedGroup--;
        if (this.selectedGroup < 0) {
            this.selectedGroup = 0;
        }
        update();
    }

    public void update() {
        try {
            this.locations = C1199DB.getQueryFromDb("SELECT distinct location FROM sessions WHERE sessiongroupid = '" + this.sessionGroups.get(this.selectedGroup).get(DBFavorites.KEY_EVENT_ID) + "' ORDER BY location, order_value +0 DESC, starttime;");
            ((TextView) findViewById(C0846R.C0847id.group)).setText(this.sessionGroups.get(this.selectedGroup).get(DBFavorites.KEY_NAME));
            ((TextView) findViewById(C0846R.C0847id.group)).setTextColor(C1216LO.getLo(C1216LO.sessionHeaderTextColor));
            if (this.selectedGroup == 0) {
                ((ImageView) findViewById(C0846R.C0847id.prev)).setAlpha(128);
            } else {
                ((ImageView) findViewById(C0846R.C0847id.prev)).setAlpha(MotionEventCompat.ACTION_MASK);
            }
            if (this.selectedGroup == this.sessionGroups.size() - 1) {
                ((ImageView) findViewById(C0846R.C0847id.next)).setAlpha(128);
            } else {
                ((ImageView) findViewById(C0846R.C0847id.next)).setAlpha(MotionEventCompat.ACTION_MASK);
            }
            this.pager.removeAllViews();
            this.pager.setAdapter(new StagePageAdapter());
            this.pager.setOnPageChangeListener(this);
            LinearLayout markers = (LinearLayout) findViewById(C0846R.C0847id.markers);
            markers.removeAllViews();
            C1232UI.getColorOverlay((int) C0846R.drawable.viewpager_marker_active, C1216LO.getLo(C1216LO.placeholderOverlayColor));
            C1232UI.getColorOverlay((int) C0846R.drawable.viewpager_marker_inactive, C1216LO.getLo(C1216LO.placeholderOverlayColor));
            int i = 0;
            int len = this.locations.size();
            while (i < len) {
                ImageView iv = new ImageView(getActivity());
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-2, -2);
                lp.leftMargin = 1;
                lp.rightMargin = 1;
                iv.setLayoutParams(lp);
                iv.setBackgroundDrawable(getResources().getDrawable(i == 0 ? C0846R.drawable.viewpager_marker_active : C0846R.drawable.viewpager_marker_inactive));
                markers.addView(iv);
                i++;
            }
        } catch (Exception e) {
        }
    }

    private class StagePageAdapter extends PagerAdapter {
        int numItems;

        public StagePageAdapter() {
            this.numItems = SessionsByStageFragment.this.locations.size();
        }

        public int getCount() {
            return this.numItems;
        }

        public boolean isViewFromObject(View view, Object object) {
            return view == ((View) object);
        }

        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        public Object instantiateItem(ViewGroup container, int position) {
            List<TCObject> sessions;
            final View v = LayoutInflater.from(SessionsByStageFragment.this.getActivity()).inflate(C0846R.layout.page_stagesession, (ViewGroup) null);
            if (SessionsByStageFragment.this.locations.get(position).has("location")) {
                sessions = C1199DB.getQueryFromDb("SELECT * FROM sessions WHERE location = '" + SessionsByStageFragment.this.locations.get(position).get("location") + "' AND sessiongroupid = '" + SessionsByStageFragment.this.sessionGroups.get(SessionsByStageFragment.this.selectedGroup).get(DBFavorites.KEY_EVENT_ID) + "' ORDER BY startdate, starttime, endtime;");
            } else {
                sessions = C1199DB.getQueryFromDb("SELECT * FROM sessions WHERE (location is null OR location = '') AND sessiongroupid = '" + SessionsByStageFragment.this.sessionGroups.get(SessionsByStageFragment.this.selectedGroup).get(DBFavorites.KEY_EVENT_ID) + "' ORDER BY startdate, starttime, endtime;");
            }
            List<TCListObject2> list = new ArrayList<>();
            for (TCObject session : sessions) {
                TCListObject2 tlo = new TCListObject2();
                tlo.celLayout = C0846R.layout.cell_festlistview;
                tlo.f2134id = session.get(DBFavorites.KEY_EVENT_ID);
                tlo.setField(C0846R.C0847id.text, session.get(DBFavorites.KEY_NAME));
                tlo.setField(C0846R.C0847id.sub1, String.valueOf(session.get("starttime")) + " - " + session.get("endtime"));
                tlo.img = session.get("imageurl", "thumb");
                tlo.defaultImage = C0846R.drawable.icon;
                tlo.arrow = true;
                list.add(tlo);
            }
            ((ListView) v.findViewById(C0846R.C0847id.list)).setAdapter(new TCListObject2.TCListObjectAdapter2(list));
            ((ListView) v.findViewById(C0846R.C0847id.list)).setBackgroundColor(C1216LO.getLo(C1216LO.lineupCellBackground));
            ((ListView) v.findViewById(C0846R.C0847id.list)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {
                    TCListObject2 o = (TCListObject2) ((ListView) v.findViewById(C0846R.C0847id.list)).getAdapter().getItem(arg2);
                    if (App.typeid.equals("10")) {
                        Fragments.add(SessionsByStageFragment.this, FestivalSessionDetailFragment.newInstance(o.f2134id), SessionsByStageFragment.this.getResourceString(C0846R.string.detail));
                    } else {
                        Fragments.add(SessionsByStageFragment.this, SessionDetailFragment.newInstance(o.f2134id), SessionsByStageFragment.this.getResourceString(C0846R.string.detail));
                    }
                }
            });
            TextView location = (TextView) v.findViewById(C0846R.C0847id.location);
            location.setText(SessionsByStageFragment.this.locations.get(position).get("location", "Unknown Location"));
            location.setBackgroundColor(C1216LO.getLo(C1216LO.sessionHeaderColor));
            location.getBackground().setAlpha(HttpResponseCode.f2160OK);
            location.setTextColor(C1216LO.getLo(C1216LO.sessionHeaderTextColor));
            container.addView(v);
            return v;
        }
    }

    public void onPageScrollStateChanged(int arg0) {
    }

    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    public void onPageSelected(int position) {
        LinearLayout markers = (LinearLayout) findViewById(C0846R.C0847id.markers);
        int i = 0;
        int len = markers.getChildCount();
        while (i < len) {
            ((ImageView) markers.getChildAt(i)).setBackgroundDrawable(getResources().getDrawable(i == position ? C0846R.drawable.viewpager_marker_active : C0846R.drawable.viewpager_marker_inactive));
            i++;
        }
    }
}
