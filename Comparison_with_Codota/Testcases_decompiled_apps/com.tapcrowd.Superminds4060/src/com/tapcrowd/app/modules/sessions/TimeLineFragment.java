package com.tapcrowd.app.modules.sessions;

import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.p000v4.view.MotionEventCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.views.ObservableScrollView;
import com.tapcrowd.app.views.ScrollViewListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.cordova.Globalization;

public class TimeLineFragment extends TCFragment implements ScrollViewListener {
    private int CELL_HEIGHT;
    /* access modifiers changed from: private */
    public int MIN_IN_PIXELS;
    boolean first = true;
    int margin;
    private int selectedGroup = 0;
    List<TCObject> sessionGroups;
    private Comparator<TCObject> sortByTimeEnd = new Comparator<TCObject>() {
        public int compare(TCObject object1, TCObject object2) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
            try {
                Date date1 = sdf.parse(object1.get("enddate"));
                Date date2 = sdf.parse(object2.get("enddate"));
                if (date1.after(date2)) {
                    return 1;
                }
                if (date1.before(date2)) {
                    return -1;
                }
                return 0;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    };
    private Comparator<TCObject> sortByTimeStart = new Comparator<TCObject>() {
        public int compare(TCObject object1, TCObject object2) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
            try {
                Date date1 = sdf.parse(object1.get(DBFavorites.KEY_SESSION_STARTDATE));
                Date date2 = sdf.parse(object2.get(DBFavorites.KEY_SESSION_STARTDATE));
                if (date1.after(date2)) {
                    return 1;
                }
                if (date1.before(date2)) {
                    return -1;
                }
                return 0;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    };
    List<View> staticViews;

    /* renamed from: v */
    View f2116v;

    public static TimeLineFragment newInstance() {
        return new TimeLineFragment();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        if (this.title == null) {
            this.title = C1199DB.getFirstObject("launchers", "moduletypeid", "10").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    public void onResume() {
        super.onResume();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2116v == null) {
            this.f2116v = inflater.inflate(C0846R.layout.festival_session, container, false);
        } else {
            this.retained = true;
            ((ViewGroup) this.f2116v.getParent()).removeView(this.f2116v);
        }
        return this.f2116v;
    }

    public View findViewById(int id) {
        return this.f2116v.findViewById(id);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!this.retained) {
            this.MIN_IN_PIXELS = (int) Converter.convertDpToPixel(5.0f, getActivity());
            this.CELL_HEIGHT = (int) Converter.convertDpToPixel(60.0f, getActivity());
            this.sessionGroups = C1199DB.getListFromDb("sessiongroups", "eventid", App.curEventId, "order_value +0 DESC, name");
            showSessions();
        }
    }

    public void showSessions() {
        int width;
        String groupid = this.sessionGroups.get(this.selectedGroup).get(DBFavorites.KEY_EVENT_ID);
        List<TCObject> locations = C1199DB.getQueryFromDb("SELECT DISTINCT location FROM sessions WHERE sessiongroupid = '" + groupid + "' ORDER BY location;");
        this.staticViews = new ArrayList();
        if (C1199DB.getSize("sessions", "sessiongroupid", groupid) != 0) {
            LayoutInflater li = LayoutInflater.from(getActivity());
            LinearLayout lineupview = (LinearLayout) findViewById(C0846R.C0847id.lineupview);
            LinearLayout timereference = (LinearLayout) findViewById(C0846R.C0847id.timereference);
            RelativeLayout prevnext = (RelativeLayout) findViewById(C0846R.C0847id.prevnext);
            ObservableScrollView scrollview = (ObservableScrollView) findViewById(C0846R.C0847id.twoDScrollView);
            ImageView prev = (ImageView) findViewById(C0846R.C0847id.prev);
            ImageView next = (ImageView) findViewById(C0846R.C0847id.next);
            TextView group = (TextView) findViewById(C0846R.C0847id.group);
            View timeindicator = findViewById(C0846R.C0847id.timeindicator);
            View main = findViewById(C0846R.C0847id.main);
            if (C1216LO.getLoDrawable(C1216LO.lineupBackground) != null) {
                main.setBackgroundDrawable(C1216LO.getLoDrawable(C1216LO.lineupBackground));
            } else {
                main.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
            prev.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    TimeLineFragment.this.prev(v);
                }
            });
            next.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    TimeLineFragment.this.next(v);
                }
            });
            RelativeLayout.LayoutParams paramsinit = (RelativeLayout.LayoutParams) timeindicator.getLayoutParams();
            paramsinit.setMargins(-10, 0, 0, 0);
            timeindicator.setLayoutParams(paramsinit);
            scrollview.setScrollViewListener(this);
            final ObservableScrollView observableScrollView = scrollview;
            scrollview.post(new Runnable() {
                public void run() {
                    observableScrollView.scrollTo(0, 0);
                }
            });
            group.setText(this.sessionGroups.get(this.selectedGroup).get(DBFavorites.KEY_NAME));
            group.setTextColor(C1216LO.getLo(C1216LO.sessionHeaderTextColor));
            if (this.sessionGroups.size() == 1) {
                prevnext.setVisibility(8);
            } else {
                prevnext.setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
            }
            if (this.selectedGroup == 0) {
                prev.setAlpha(128);
            } else {
                prev.setAlpha(MotionEventCompat.ACTION_MASK);
            }
            if (this.selectedGroup == this.sessionGroups.size() - 1) {
                next.setAlpha(128);
            } else {
                next.setAlpha(MotionEventCompat.ACTION_MASK);
            }
            TCObject firstSession = C1199DB.getFirstObject("sessions", "sessiongroupid", groupid, "datetime(startdate)");
            int first2 = Converter.timeToInt(firstSession.get("starttime"));
            int first3 = first2 - (first2 % 60);
            String datefirst = firstSession.get(Globalization.DATE);
            TCObject lastSession = C1199DB.getFirstObject("sessions", "sessiongroupid", groupid, "datetime(enddate) DESC");
            int last = Converter.timeToInt(lastSession.get("endtime"));
            int last2 = (last - (last % 60)) + 60;
            if (!datefirst.equals(lastSession.get(Globalization.DATE))) {
                last2 += 1440;
            }
            for (int i = first3; i <= last2; i += 60) {
                int time = i;
                if (time >= 1440) {
                    time -= 1440;
                }
                TextView textView = new TextView(getActivity());
                textView.setLayoutParams(new ViewGroup.LayoutParams(this.MIN_IN_PIXELS * 15, (int) Converter.convertDpToPixel(27.0f, getActivity())));
                textView.setGravity(16);
                textView.setText(Converter.intToTime(time));
                textView.setTextSize(16.0f);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                textView.setTextColor(-16777216);
                timereference.addView(textView);
                for (int j = 0; j < 3; j++) {
                    View v = li.inflate(C0846R.layout.time_sep, (ViewGroup) null);
                    v.setLayoutParams(new ViewGroup.LayoutParams(this.MIN_IN_PIXELS * 15, -1));
                    timereference.addView(v);
                }
            }
            View view = new View(getActivity());
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) Converter.convertDpToPixel(3.0f, getActivity())));
            view.setBackgroundColor(C1216LO.getLo(C1216LO.timelineBorderColor));
            lineupview.addView(view);
            for (TCObject location : locations) {
                Cursor cursor = C1199DB.getDatabase().rawQuery(String.format("SELECT id, date, name, starttime, endtime FROM sessions WHERE location = '%1$s' AND sessiongroupid = '%2$s' ORDER BY datetime(startdate)", new Object[]{location.get("location"), groupid}), (String[]) null);
                if (cursor.getCount() > 0) {
                    TextView textView2 = new TextView(getActivity());
                    textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 16.0f));
                    textView2.setText(location.get("location", "Unknown Location"));
                    textView2.setTextSize(20.0f);
                    textView2.setPadding(10, 5, 5, 5);
                    textView2.setTypeface(Typeface.DEFAULT_BOLD);
                    textView2.setTextColor(C1216LO.getLo(C1216LO.separatorTextColor));
                    textView2.setBackgroundColor(C1216LO.getLo(C1216LO.seperatorBackgroundColor));
                    lineupview.addView(textView2);
                    this.staticViews.add(textView2);
                }
                View seps = li.inflate(C0846R.layout.stage_sep, (ViewGroup) null);
                seps.findViewById(C0846R.C0847id.top).setBackgroundColor(C1216LO.getLo(C1216LO.timelineBorderColor));
                seps.findViewById(C0846R.C0847id.bot).setBackgroundColor(C1216LO.getLo(C1216LO.timelineBorderColor));
                RelativeLayout rl = (RelativeLayout) seps.findViewById(C0846R.C0847id.container);
                if (cursor.moveToFirst()) {
                    int idIndex = cursor.getColumnIndex(DBFavorites.KEY_EVENT_ID);
                    int dateIndex = cursor.getColumnIndex(Globalization.DATE);
                    int nameIndex = cursor.getColumnIndex(DBFavorites.KEY_NAME);
                    int startIndex = cursor.getColumnIndex("starttime");
                    int endIndex = cursor.getColumnIndex("endtime");
                    String date = cursor.getString(dateIndex);
                    do {
                        View v2 = li.inflate(C0846R.layout.cell_festivalsession, (ViewGroup) null);
                        v2.findViewById(C0846R.C0847id.left).setBackgroundColor(C1216LO.getLo(C1216LO.timelineBorderColor));
                        v2.findViewById(C0846R.C0847id.right).setBackgroundColor(C1216LO.getLo(C1216LO.timelineBorderColor));
                        TextView tv = (TextView) v2.findViewById(C0846R.C0847id.name);
                        tv.setText(cursor.getString(nameIndex));
                        tv.setEllipsize(TextUtils.TruncateAt.END);
                        tv.setTextColor(C1216LO.getLo(C1216LO.timelineTextColor));
                        final String string = cursor.getString(idIndex);
                        v2.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                if (App.typeid.equals("10")) {
                                    Fragments.add(TimeLineFragment.this, FestivalSessionDetailFragment.newInstance(string), TimeLineFragment.this.getResourceString(C0846R.string.detail));
                                } else {
                                    Fragments.add(TimeLineFragment.this, SessionDetailFragment.newInstance(string), TimeLineFragment.this.getResourceString(C0846R.string.detail));
                                }
                            }
                        });
                        int starttime = Converter.timeToInt(cursor.getString(startIndex));
                        int endtime = Converter.timeToInt(cursor.getString(endIndex));
                        if (endtime < starttime) {
                            width = ((endtime + 1440) - starttime) * this.MIN_IN_PIXELS;
                        } else {
                            width = (endtime - starttime) * this.MIN_IN_PIXELS;
                        }
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, this.CELL_HEIGHT);
                        v2.findViewById(C0846R.C0847id.cellbg).setBackgroundColor(C1216LO.getLo(C1216LO.timelineColor));
                        int marginLeft = (starttime - first3) * this.MIN_IN_PIXELS;
                        if (!date.equals(cursor.getString(dateIndex))) {
                            marginLeft += this.MIN_IN_PIXELS * 1440;
                        }
                        layoutParams.setMargins(marginLeft, 0, 0, 0);
                        v2.setLayoutParams(layoutParams);
                        rl.addView(v2);
                    } while (cursor.moveToNext());
                }
                lineupview.addView(seps);
            }
            timeindicator.setBackgroundColor(C1216LO.getLo(C1216LO.currentLineupTime));
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) timeindicator.getLayoutParams();
            Calendar c = Calendar.getInstance();
            this.margin = (((c.get(11) * 60) + c.get(12)) - first3) * this.MIN_IN_PIXELS;
            params.setMargins(this.margin, 0, 0, 0);
            if (this.margin - (getActivity().getWindowManager().getDefaultDisplay().getWidth() / 2) > 0) {
                final ObservableScrollView observableScrollView2 = scrollview;
                scrollview.post(new Runnable() {
                    public void run() {
                        observableScrollView2.scrollTo(TimeLineFragment.this.margin - (TimeLineFragment.this.getActivity().getWindowManager().getDefaultDisplay().getWidth() / 2), 0);
                    }
                });
            }
            timeindicator.setLayoutParams(params);
            Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Runnable() {
                public void run() {
                    TimeLineFragment.this.updateTimeIndicator();
                }
            }, 60000, 60000, TimeUnit.MILLISECONDS);
        }
    }

    public void updateTimeIndicator() {
        if (isAdded()) {
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    View timeind = TimeLineFragment.this.findViewById(C0846R.C0847id.timeindicator);
                    RelativeLayout.LayoutParams param = (RelativeLayout.LayoutParams) timeind.getLayoutParams();
                    param.setMargins(param.leftMargin + TimeLineFragment.this.MIN_IN_PIXELS, 0, 0, 0);
                    timeind.setLayoutParams(param);
                }
            });
        }
    }

    public void next(View v) {
        this.selectedGroup++;
        if (this.selectedGroup >= this.sessionGroups.size()) {
            this.selectedGroup = this.sessionGroups.size() - 1;
            return;
        }
        reset();
        showSessions();
    }

    public void prev(View v) {
        this.selectedGroup--;
        if (this.selectedGroup < 0) {
            this.selectedGroup = 0;
            return;
        }
        reset();
        showSessions();
    }

    public void reset() {
        this.first = true;
        ((ObservableScrollView) findViewById(C0846R.C0847id.twoDScrollView)).scrollTo(0, 0);
        ((ViewGroup) findViewById(C0846R.C0847id.timereference)).removeAllViews();
        ((ViewGroup) findViewById(C0846R.C0847id.lineupview)).removeAllViews();
    }

    public void onScrollChanged(ObservableScrollView scrollView, final int x, int y, int oldx, int oldy) {
        View timeref = findViewById(C0846R.C0847id.timereference);
        View timeind = findViewById(C0846R.C0847id.timeindicator);
        timeref.scrollTo(x, 0);
        RelativeLayout.LayoutParams param = (RelativeLayout.LayoutParams) timeind.getLayoutParams();
        param.setMargins(this.margin - x, 0, 0, 0);
        timeind.setLayoutParams(param);
        timeind.scrollTo(x, 0);
        if (this.first) {
            for (final View view : this.staticViews) {
                view.post(new Runnable() {
                    public void run() {
                        view.scrollTo(-x, 0);
                    }
                });
            }
            this.first = false;
            return;
        }
        for (View view2 : this.staticViews) {
            view2.scrollTo(-x, 0);
        }
    }
}
