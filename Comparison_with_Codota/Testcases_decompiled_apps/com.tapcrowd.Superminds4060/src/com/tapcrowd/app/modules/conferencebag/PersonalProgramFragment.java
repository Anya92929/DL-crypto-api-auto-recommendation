package com.tapcrowd.app.modules.conferencebag;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.business.CatalogDetailFragment;
import com.tapcrowd.app.modules.exhibitors.ExhibitorDetailFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.sessions.SessionDetailFragment;
import com.tapcrowd.app.modules.speakers.SpeakerDetailFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.PersonalProgramSync;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.cordova.Globalization;

public class PersonalProgramFragment extends TCFragment implements TabHost.OnTabChangeListener {
    private String eventid;
    private String tab;
    private TabHost tabHost;

    /* renamed from: v */
    private View f2028v;

    public static PersonalProgramFragment newInstance() {
        return new PersonalProgramFragment();
    }

    public static PersonalProgramFragment newInstance(String eventid2) {
        PersonalProgramFragment fr = new PersonalProgramFragment();
        fr.eventid = eventid2;
        return fr;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("tab", this.tab);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null && this.tab == null) {
            this.tab = savedInstanceState.getString("tab");
        }
        AdHelper.showAds(this, AdHelper.buildPath("43", "list", (String) null));
        this.f2028v = inflater.inflate(C0846R.layout.personal_programma, container, false);
        this.tabHost = (TabHost) this.f2028v.findViewById(16908306);
        this.tabHost.setOnTabChangedListener(this);
        this.f2028v.findViewById(C0846R.C0847id.sep).setBackgroundColor(C1216LO.getLo(C1216LO.topTabBackgroundcolorHigh));
        PersonalProgramSync.search(getActivity(), this.eventid, new PersonalProgramSync.onFinishedListener() {
            public void onFinish() {
                PersonalProgramFragment.this.start();
            }
        });
        return this.f2028v;
    }

    public void start() {
        setupTabs();
        TabWidget tabWidget = this.tabHost.getTabWidget();
        int tabChildrenCount = tabWidget.getChildCount();
        for (int i = 0; i < tabChildrenCount; i++) {
            ((LinearLayout.LayoutParams) tabWidget.getChildAt(i).getLayoutParams()).setMargins(5, 0, 5, 0);
        }
        tabWidget.setDividerDrawable((Drawable) null);
        tabWidget.requestLayout();
    }

    public void setupTabs() {
        this.tabHost.setup();
        if (C1199DB.getSize("launchers", "moduletypeid", "10") > 0) {
            this.tabHost.addTab(newTab(C1199DB.getFirstObject("launchers", "moduletypeid", "10").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE), C0846R.C0847id.sessions));
        }
        if (C1199DB.getSize("launchers", "moduletypeid", "2") > 0) {
            this.tabHost.addTab(newTab(C1199DB.getFirstObject("launchers", "moduletypeid", "2").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE), C0846R.C0847id.exhibitors));
        }
        setupSessions();
        setupCatalog();
        setupExhibitors();
        if (this.tab != null) {
            this.tabHost.setCurrentTabByTag(this.tab);
        }
        if (this.tabHost.getTabWidget().getTabCount() > 0) {
            onTabChanged(this.tabHost.getCurrentTabTag());
        }
    }

    public void onResume() {
        setupSessions();
        setupCatalog();
        setupExhibitors();
        super.onResume();
    }

    public TabHost.TabSpec newTab(String text, int content) {
        View view = getActivity().getLayoutInflater().inflate(C0846R.layout.tab_layout, (ViewGroup) null);
        ((TextView) view.findViewById(C0846R.C0847id.tabtitle)).setText(text);
        TabHost.TabSpec tabSpec = this.tabHost.newTabSpec(text);
        tabSpec.setIndicator(view);
        tabSpec.setContent(content);
        return tabSpec;
    }

    private class TabDrawable extends ShapeDrawable {
        private final Paint fillpaint = new Paint(getPaint());
        private final Paint strokepaint;

        public TabDrawable(Shape s, int fill) {
            super(s);
            this.fillpaint.setColor(fill);
            this.strokepaint = new Paint(this.fillpaint);
            this.strokepaint.setStyle(Paint.Style.STROKE);
        }

        /* access modifiers changed from: protected */
        public void onDraw(Shape shape, Canvas canvas, Paint paint) {
            shape.draw(canvas, this.fillpaint);
            shape.draw(canvas, this.strokepaint);
        }
    }

    public void setupSessions() {
        ListView lv = (ListView) this.f2028v.findViewById(C0846R.C0847id.lvsessions);
        List<TCObject> sessions = C1199DB.getQueryFromDb("SELECT sessions.* FROM persprog INNER JOIN sessions ON persprog.sessionid == sessions.id ORDER BY date, starttime, endtime");
        List<Object> listitems = new ArrayList<>();
        for (TCObject session : sessions) {
            try {
                String s = DateFormat.getLongDateFormat(App.act).format(new SimpleDateFormat("dd/MM/yyyy").parse(session.get(Globalization.DATE)));
                if (!listitems.contains(s)) {
                    listitems.add(s);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String sub2 = "";
            List<TCObject> speakers = C1199DB.getQueryFromDb("SELECT name FROM speakers INNER JOIN speaker_session ON speakers.id == speaker_session.speakerid WHERE speaker_session.sessionid == '" + session.get(DBFavorites.KEY_EVENT_ID) + "';");
            if (speakers.size() > 0) {
                for (TCObject speaker : speakers) {
                    sub2 = String.valueOf(sub2) + speaker.get(DBFavorites.KEY_NAME);
                    if (!speaker.equals(speakers.get(speakers.size() - 1))) {
                        sub2 = String.valueOf(sub2) + ", ";
                    }
                }
            }
            if (sub2.equals("")) {
                sub2 = "   ";
            }
            listitems.add(new TCListObject(session.get(DBFavorites.KEY_EVENT_ID), session.get(DBFavorites.KEY_NAME), String.valueOf(session.get("starttime")) + " - " + session.get("endtime"), sub2, (String) null));
        }
        if (listitems.size() == 0) {
            lv.setVisibility(8);
            ((ImageView) this.f2028v.findViewById(C0846R.C0847id.sessionsivempty)).setImageResource(C0846R.drawable.info_personal_program);
            ((TextView) this.f2028v.findViewById(C0846R.C0847id.sessionstvempty)).setText(getString(C0846R.string.persprogdescription));
        }
        TCListObject.TCListObjectAdapter adapter = new TCListObject.TCListObjectAdapter((List) listitems, 0, false);
        adapter.setLayout(C0846R.layout.cell_session_new);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Object clicked = arg0.getAdapter().getItem(arg2);
                if (clicked.getClass() == TCListObject.class) {
                    Fragments.add(PersonalProgramFragment.this, SessionDetailFragment.newInstance(((TCListObject) clicked).getId()), PersonalProgramFragment.this.getResourceString(C0846R.string.detail));
                }
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                final TCListObject clicked = (TCListObject) arg0.getAdapter().getItem(arg2);
                new AlertDialog.Builder(PersonalProgramFragment.this.getActivity()).setMessage(PersonalProgramFragment.this.getString(C0846R.string.are_you_sure_remove_conf_bag)).setPositiveButton(C0846R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        C1199DB.remove("persprog", "sessionid", clicked.getId());
                        PersonalProgramFragment.this.onResume();
                        PersonalProgramFragment.this.setupSessions();
                    }
                }).setNegativeButton(C0846R.string.f2002no, (DialogInterface.OnClickListener) null).show();
                return false;
            }
        });
    }

    public void setupExhibitors() {
        ListView lv = (ListView) this.f2028v.findViewById(C0846R.C0847id.lvexhibitors);
        List<TCObject> list = C1199DB.getQueryFromDb("SELECT exhibitors.* FROM persprog INNER JOIN exhibitors ON persprog.exhibitorsid == exhibitors.id ORDER BY exhibitors.order_value +0 DESC, exhibitors.name COLLATE NOCASE");
        List<TCListObject> temp = new ArrayList<>();
        for (TCObject tco : list) {
            String booth = "";
            if (tco.has("booth")) {
                booth = String.valueOf(getString(C0846R.string.location)) + tco.get("booth", "");
            }
            temp.add(new TCListObject(tco.get(DBFavorites.KEY_EVENT_ID), tco.get(DBFavorites.KEY_NAME), booth, (String) null, tco.get("imageurl"), (Boolean) true));
        }
        if (list.size() == 0) {
            lv.setVisibility(8);
            ((ImageView) this.f2028v.findViewById(C0846R.C0847id.exhibitorsivempty)).setImageResource(C0846R.drawable.info_personal_program);
            ((TextView) this.f2028v.findViewById(C0846R.C0847id.exhibitorstvempty)).setText(getString(C0846R.string.persprogdescription));
        }
        lv.setAdapter(new TCListObject.TCListObjectAdapter(temp, 0));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Fragments.add(PersonalProgramFragment.this, ExhibitorDetailFragment.newInstance(((TCListObject) arg0.getAdapter().getItem(arg2)).getId()), PersonalProgramFragment.this.getString(C0846R.string.detail));
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                final TCListObject clicked = (TCListObject) arg0.getAdapter().getItem(arg2);
                new AlertDialog.Builder(PersonalProgramFragment.this.getActivity()).setMessage(PersonalProgramFragment.this.getString(C0846R.string.are_you_sure_remove_conf_bag)).setPositiveButton(C0846R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        C1199DB.remove("persprog", "exhibitorsid", clicked.getId());
                        PersonalProgramFragment.this.onResume();
                        PersonalProgramFragment.this.setupExhibitors();
                    }
                }).setNegativeButton(C0846R.string.f2002no, (DialogInterface.OnClickListener) null).show();
                return false;
            }
        });
    }

    public void setupSpeakers() {
        ListView lv = (ListView) this.f2028v.findViewById(C0846R.C0847id.lvspeakers);
        List<TCObject> list = C1199DB.getQueryFromDb("SELECT speakers.* FROM persprog INNER JOIN speakers ON persprog.speakerid == speakers.id ORDER BY speakers.order_value +0 DESC, speakers.name COLLATE NOCASE");
        List<TCListObject> temp = new ArrayList<>();
        for (TCObject tco : list) {
            temp.add(new TCListObject(tco.get(DBFavorites.KEY_EVENT_ID), tco.get(DBFavorites.KEY_NAME), tco.get("company"), (String) null, tco.get("imageurl"), (Boolean) true));
        }
        if (list.size() == 0) {
            lv.setVisibility(8);
            ((ImageView) this.f2028v.findViewById(C0846R.C0847id.speakersivempty)).setImageResource(C0846R.drawable.info_personal_program);
            ((TextView) this.f2028v.findViewById(C0846R.C0847id.speakerstvempty)).setText(getString(C0846R.string.persprogdescription));
        }
        lv.setAdapter(new TCListObject.TCListObjectAdapter(temp, 0));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Fragments.add(PersonalProgramFragment.this, SpeakerDetailFragment.newInstance(((TCListObject) arg0.getAdapter().getItem(arg2)).getId()), PersonalProgramFragment.this.getString(C0846R.string.detail));
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                final TCListObject clicked = (TCListObject) arg0.getAdapter().getItem(arg2);
                new AlertDialog.Builder(PersonalProgramFragment.this.getActivity()).setMessage(PersonalProgramFragment.this.getString(C0846R.string.are_you_sure_remove_conf_bag)).setPositiveButton(C0846R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        C1199DB.remove("persprog", "speakerid", clicked.getId());
                        PersonalProgramFragment.this.onResume();
                        PersonalProgramFragment.this.setupSpeakers();
                    }
                }).setNegativeButton(C0846R.string.f2002no, (DialogInterface.OnClickListener) null).show();
                return false;
            }
        });
    }

    public void setupCatalog() {
        ListView lv = (ListView) this.f2028v.findViewById(C0846R.C0847id.lvcatalog);
        List<TCObject> list = C1199DB.getQueryFromDb("SELECT catalog.* FROM persprog INNER JOIN catalog ON persprog.catalogid == catalog.id ORDER BY catalog.order_value +0 DESC, catalog.name COLLATE NOCASE");
        List<TCListObject> temp = new ArrayList<>();
        for (TCObject tco : list) {
            temp.add(new TCListObject(tco.get(DBFavorites.KEY_EVENT_ID), tco.get(DBFavorites.KEY_NAME), (String) null, (String) null, tco.get("imageurl"), (Boolean) true));
        }
        if (list.size() == 0) {
            lv.setVisibility(8);
            ((ImageView) this.f2028v.findViewById(C0846R.C0847id.catalogivempty)).setImageResource(C0846R.drawable.info_personal_program);
            ((TextView) this.f2028v.findViewById(C0846R.C0847id.catalogtvempty)).setText(getString(C0846R.string.persprogdescription));
        }
        lv.setAdapter(new TCListObject.TCListObjectAdapter(temp, 0));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Fragments.add(PersonalProgramFragment.this, CatalogDetailFragment.newInstance(((TCListObject) arg0.getAdapter().getItem(arg2)).getId(), (String) null), PersonalProgramFragment.this.getString(C0846R.string.detail));
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                final TCListObject clicked = (TCListObject) arg0.getAdapter().getItem(arg2);
                new AlertDialog.Builder(PersonalProgramFragment.this.getActivity()).setMessage(PersonalProgramFragment.this.getString(C0846R.string.are_you_sure_remove_conf_bag)).setPositiveButton(C0846R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        C1199DB.remove("persprog", "catalogid", clicked.getId());
                        PersonalProgramFragment.this.onResume();
                    }
                }).setNegativeButton(C0846R.string.f2002no, (DialogInterface.OnClickListener) null).show();
                return false;
            }
        });
    }

    public void onTabChanged(String tabId) {
        int len = this.tabHost.getTabWidget().getTabCount();
        for (int i = 0; i < len; i++) {
            View tab2 = this.tabHost.getTabWidget().getChildTabViewAt(i);
            tab2.setBackgroundDrawable(new TabDrawable(new RoundRectShape(new float[]{15.0f, 15.0f, 15.0f, 15.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED}, (RectF) null, (float[]) null), C1216LO.getLo(C1216LO.topTabBackgroundcolor)));
            ((TextView) tab2.findViewById(C0846R.C0847id.tabtitle)).setTextColor(C1216LO.getLo(C1216LO.topTabTextColor));
        }
        View current = this.tabHost.getCurrentTabView();
        current.setBackgroundDrawable(new TabDrawable(new RoundRectShape(new float[]{15.0f, 15.0f, 15.0f, 15.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED}, (RectF) null, (float[]) null), C1216LO.getLo(C1216LO.topTabBackgroundcolorHigh)));
        ((TextView) current.findViewById(C0846R.C0847id.tabtitle)).setTextColor(C1216LO.getLo(C1216LO.topTabTextColorHigh));
    }
}
