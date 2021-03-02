package com.tapcrowd.app.modules.conferencebag;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p000v4.app.Fragment;
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
import com.actionbarsherlock.view.MenuItem;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.plus.PlusShare;
import com.google.zxing.client.android.Intents;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.attendees.AttendeeDetailFragment;
import com.tapcrowd.app.modules.business.CatalogDetailFragment;
import com.tapcrowd.app.modules.exhibitors.ExhibitorDetailFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.modules.sessions.SessionDetailFragment;
import com.tapcrowd.app.modules.speakers.SpeakerDetailFragment;
import com.tapcrowd.app.modules.webview.WebViewFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.IntentIntegrator;
import com.tapcrowd.app.utils.Internet;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.User;
import com.tapcrowd.app.utils.images.Utils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.cordova.Globalization;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class FavoritesFragment extends TCFragment implements TabHost.OnTabChangeListener, MenuFragment.MenuItemListener, TCListObject.TCListObjectAdapter.ListRemoveClickListener {
    public final int CHANGE = 234;
    public final int CLEAR = 621;
    public final int EDIT = 3425;
    public final int QR_SCAN = 8182;
    public final int RECEIVE = 649;
    public Handler confhandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    private String tab;
    private TabHost tabHost;
    private boolean thrash;
    /* access modifiers changed from: private */
    public String type;
    /* access modifiers changed from: private */
    public String typeid;

    /* renamed from: v */
    View f2027v;
    private String website;

    public static FavoritesFragment newInstance(String type2, String typeid2) {
        FavoritesFragment fr = new FavoritesFragment();
        fr.type = type2;
        fr.typeid = typeid2;
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
        AdHelper.showAds(this, AdHelper.buildPath("42", "list", (String) null));
        this.f2027v = inflater.inflate(C0846R.layout.personal_programma, container, false);
        setupMenu();
        this.tabHost = (TabHost) this.f2027v.findViewById(16908306);
        this.tabHost.setOnTabChangedListener(this);
        this.f2027v.findViewById(C0846R.C0847id.sep).setBackgroundColor(C1216LO.getLo(C1216LO.topTabBackgroundcolorHigh));
        setupTabs();
        return this.f2027v;
    }

    public void setupMenu() {
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_qr, C1216LO.getLo(C1216LO.navigationColor)), 8182));
        List<MenuFragment.SubMenuContainer> submenu = new ArrayList<>();
        submenu.add(new MenuFragment.SubMenuContainer(3425, getString(C0846R.string.edit, C1199DB.getFirstObject("launchers", "moduletypeid", "42").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE))));
        submenu.add(new MenuFragment.SubMenuContainer(234, getString(C0846R.string.change_email)));
        submenu.add(new MenuFragment.SubMenuContainer(649, String.valueOf(getString(C0846R.string.receive)) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + C1199DB.getFirstObject("launchers", "moduletypeid", "42").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)));
        submenu.add(new MenuFragment.SubMenuContainer(621, String.valueOf(getString(C0846R.string.clear)) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + C1199DB.getFirstObject("launchers", "moduletypeid", "42").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)));
        menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_overflow, C1216LO.getLo(C1216LO.navigationColor)), submenu));
        Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
    }

    public void onResume() {
        if (C1199DB.getSize("launchers", "moduletypeid", "10") > 0) {
            setupSessions();
        }
        if (C1199DB.getSize("launchers", "moduletypeid", "2") > 0) {
            setupExhibitors();
        }
        if (C1199DB.getSize("launchers", "moduletypeid", "14") > 0) {
            setupAttendees();
        }
        if (C1199DB.getSize("launchers", "moduletypeid", "15") > 0) {
            setupCatalog();
        }
        if (C1199DB.getSize("launchers", "moduletypeid", "25") > 0) {
            setupProjects();
        }
        if (C1199DB.getSize("launchers", "moduletypeid", "40") > 0) {
            setupSpeakers();
        }
        if (getActivity().getPackageManager().hasSystemFeature("android.hardware.camera")) {
            setupOther();
        }
        super.onResume();
    }

    public void setupTabs() {
        this.tabHost.setup();
        if (C1199DB.getSize("launchers", "moduletypeid", "10") > 0) {
            this.tabHost.addTab(newTab(C1199DB.getFirstObject("launchers", "moduletypeid", "10").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE), C0846R.C0847id.sessions));
        }
        if (C1199DB.getSize("launchers", "moduletypeid", "2") > 0) {
            this.tabHost.addTab(newTab(C1199DB.getFirstObject("launchers", "moduletypeid", "2").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE), C0846R.C0847id.exhibitors));
        }
        if (C1199DB.getSize("launchers", "moduletypeid", "14") > 0) {
            this.tabHost.addTab(newTab(C1199DB.getFirstObject("launchers", "moduletypeid", "14").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE), C0846R.C0847id.attendees));
        }
        if (C1199DB.getSize("launchers", "moduletypeid", "15") > 0) {
            this.tabHost.addTab(newTab(C1199DB.getFirstObject("launchers", "moduletypeid", "15").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE), C0846R.C0847id.catalog));
        }
        if (C1199DB.getSize("launchers", "moduletypeid", "25") > 0) {
            this.tabHost.addTab(newTab(C1199DB.getFirstObject("launchers", "moduletypeid", "25").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE), C0846R.C0847id.projects));
        }
        if (getActivity().getPackageManager().hasSystemFeature("android.hardware.camera")) {
            this.tabHost.addTab(newTab("Links", C0846R.C0847id.other));
        }
        TabWidget tabWidget = this.tabHost.getTabWidget();
        int tabChildrenCount = tabWidget.getChildCount();
        for (int i = 0; i < tabChildrenCount; i++) {
            ((LinearLayout.LayoutParams) tabWidget.getChildAt(i).getLayoutParams()).setMargins(5, 0, 5, 0);
        }
        tabWidget.requestLayout();
        tabWidget.setDividerDrawable((Drawable) null);
        if (this.tab != null) {
            this.tabHost.setCurrentTabByTag(this.tab);
        }
        if (this.tabHost.getTabWidget().getTabCount() > 0) {
            onTabChanged(this.tabHost.getCurrentTabTag());
        }
    }

    public void setupSessions() {
        ListView lv = (ListView) this.f2027v.findViewById(C0846R.C0847id.lvsessions);
        List<TCObject> sessions = C1199DB.getQueryFromDb("SELECT sessions.*, personal.id AS persid FROM personal INNER JOIN sessions ON personal.tableid == sessions.id WHERE deleted == '0' AND type == 'confbag' ORDER BY date, starttime, endtime");
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
            ((ImageView) this.f2027v.findViewById(C0846R.C0847id.sessionsivempty)).setImageResource(C0846R.drawable.info_conference_bag);
            ((TextView) this.f2027v.findViewById(C0846R.C0847id.sessionstvempty)).setText(getString(C0846R.string.confbagdescription));
        } else {
            lv.setVisibility(0);
        }
        TCListObject.TCListObjectAdapter adapter = new TCListObject.TCListObjectAdapter((List) listitems, 0, false);
        adapter.setThrash(this.thrash, this);
        adapter.setLayout(C0846R.layout.cell_session_new);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Object clicked = arg0.getAdapter().getItem(arg2);
                if (clicked.getClass() == TCListObject.class) {
                    Fragments.add(FavoritesFragment.this, SessionDetailFragment.newInstance(((TCListObject) clicked).getId()), FavoritesFragment.this.getResourceString(C0846R.string.detail));
                }
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                final TCListObject clicked = (TCListObject) arg0.getAdapter().getItem(arg2);
                new AlertDialog.Builder(FavoritesFragment.this.getActivity()).setMessage(FavoritesFragment.this.getString(C0846R.string.are_you_sure_remove_conf_bag)).setPositiveButton(C0846R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ContentValues cv = new ContentValues();
                        cv.put("deleted", "1");
                        cv.put("synced", "0");
                        C1199DB.update("personal", cv, "type == 'confbag' AND tableid =='" + clicked.getId() + "'");
                        Internet.synchConferencebag(FavoritesFragment.this.confhandler);
                        FavoritesFragment.this.onResume();
                        FavoritesFragment.this.setupSessions();
                    }
                }).setNegativeButton(C0846R.string.f2002no, (DialogInterface.OnClickListener) null).show();
                return false;
            }
        });
    }

    public void setupExhibitors() {
        ListView lv = (ListView) this.f2027v.findViewById(C0846R.C0847id.lvexhibitors);
        List<TCObject> list = C1199DB.getQueryFromDb("SELECT exhibitors.* FROM personal INNER JOIN exhibitors ON personal.tableid == exhibitors.id WHERE deleted == '0' AND personal.type == 'confbag'");
        List<TCListObject> temp = new ArrayList<>();
        for (TCObject tco : list) {
            temp.add(new TCListObject(tco.get(DBFavorites.KEY_EVENT_ID), tco.get(DBFavorites.KEY_NAME), tco.has("booth") ? String.valueOf(getString(C0846R.string.location)) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + tco.get("booth") : "", (String) null, tco.get("imageurl", "")));
        }
        if (list.size() == 0) {
            lv.setVisibility(8);
            ((ImageView) this.f2027v.findViewById(C0846R.C0847id.exhibitorsivempty)).setImageResource(C0846R.drawable.info_conference_bag);
            ((TextView) this.f2027v.findViewById(C0846R.C0847id.exhibitorstvempty)).setText(getResourceString(C0846R.string.confbagdescription));
        } else {
            lv.setVisibility(0);
        }
        TCListObject.TCListObjectAdapter adap = new TCListObject.TCListObjectAdapter(temp, 0);
        adap.setThrash(this.thrash, this);
        lv.setAdapter(adap);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Fragments.add(FavoritesFragment.this, ExhibitorDetailFragment.newInstance(((TCListObject) arg0.getAdapter().getItem(arg2)).getId()), FavoritesFragment.this.getResourceString(C0846R.string.detail));
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                final TCListObject clicked = (TCListObject) arg0.getAdapter().getItem(arg2);
                new AlertDialog.Builder(FavoritesFragment.this.getActivity()).setMessage(FavoritesFragment.this.getString(C0846R.string.are_you_sure_remove_conf_bag)).setPositiveButton(C0846R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ContentValues cv = new ContentValues();
                        cv.put("deleted", "1");
                        cv.put("synced", "0");
                        C1199DB.update("personal", cv, "type == 'confbag' AND tableid =='" + clicked.getId() + "'");
                        FavoritesFragment.this.setupExhibitors();
                        FavoritesFragment.this.onResume();
                        Internet.synchConferencebag(FavoritesFragment.this.confhandler);
                    }
                }).setNegativeButton(C0846R.string.f2002no, (DialogInterface.OnClickListener) null).show();
                return false;
            }
        });
    }

    public void setupSpeakers() {
        ListView lv = (ListView) this.f2027v.findViewById(C0846R.C0847id.lvspeakers);
        List<TCObject> list = C1199DB.getQueryFromDb("SELECT speakers.* FROM personal INNER JOIN speakers ON personal.tableid == speakers.id WHERE deleted == '0' AND personal.type == 'confbag'");
        List<TCListObject> temp = new ArrayList<>();
        for (TCObject tco : list) {
            temp.add(new TCListObject(tco, DBFavorites.KEY_EVENT_ID, DBFavorites.KEY_NAME, "company", (String) null, "imageurl"));
        }
        if (list.size() == 0) {
            lv.setVisibility(8);
            ((ImageView) this.f2027v.findViewById(C0846R.C0847id.speakersivempty)).setImageResource(C0846R.drawable.info_conference_bag);
            ((TextView) this.f2027v.findViewById(C0846R.C0847id.speakerstvempty)).setText(getResourceString(C0846R.string.confbagdescription));
        } else {
            lv.setVisibility(0);
        }
        TCListObject.TCListObjectAdapter adap = new TCListObject.TCListObjectAdapter(temp, 0);
        adap.setThrash(this.thrash, this);
        lv.setAdapter(adap);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Fragments.add(FavoritesFragment.this, SpeakerDetailFragment.newInstance(((TCListObject) arg0.getAdapter().getItem(arg2)).getId()), FavoritesFragment.this.getResourceString(C0846R.string.detail));
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                final TCListObject clicked = (TCListObject) arg0.getAdapter().getItem(arg2);
                new AlertDialog.Builder(FavoritesFragment.this.getActivity()).setMessage(FavoritesFragment.this.getString(C0846R.string.are_you_sure_remove_conf_bag)).setPositiveButton(C0846R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ContentValues cv = new ContentValues();
                        cv.put("deleted", "1");
                        cv.put("synced", "0");
                        C1199DB.update("personal", cv, "type == 'confbag' AND tableid =='" + clicked.getId() + "'");
                        FavoritesFragment.this.setupSpeakers();
                        FavoritesFragment.this.onResume();
                        Internet.synchConferencebag(FavoritesFragment.this.confhandler);
                    }
                }).setNegativeButton(C0846R.string.f2002no, (DialogInterface.OnClickListener) null).show();
                return false;
            }
        });
    }

    public void setupAttendees() {
        ListView lv = (ListView) this.f2027v.findViewById(C0846R.C0847id.lvattendees);
        List<TCObject> list = C1199DB.getQueryFromDb("SELECT attendees.* FROM personal INNER JOIN attendees ON personal.tableid == attendees.id WHERE deleted == '0'");
        List<TCListObject> temp = new ArrayList<>();
        for (TCObject tco : list) {
            temp.add(new TCListObject(tco.get(DBFavorites.KEY_EVENT_ID), String.valueOf(tco.get(DBFavorites.KEY_NAME)) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + tco.get("firstname"), tco.get("company"), (String) null, tco.get("imageurl", "")));
        }
        if (list.size() == 0) {
            lv.setVisibility(8);
            ((ImageView) this.f2027v.findViewById(C0846R.C0847id.attendeesivempty)).setImageResource(C0846R.drawable.info_conference_bag);
            ((TextView) this.f2027v.findViewById(C0846R.C0847id.attendeestvempty)).setText(getResourceString(C0846R.string.confbagdescription));
        } else {
            lv.setVisibility(0);
        }
        TCListObject.TCListObjectAdapter adap = new TCListObject.TCListObjectAdapter(temp, C0846R.drawable.icon_attendee);
        adap.setThrash(this.thrash, this);
        lv.setAdapter(adap);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Fragments.add(FavoritesFragment.this, AttendeeDetailFragment.newInstance(((TCListObject) arg0.getAdapter().getItem(arg2)).getId()), FavoritesFragment.this.getResourceString(C0846R.string.detail));
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                final TCListObject clicked = (TCListObject) arg0.getAdapter().getItem(arg2);
                new AlertDialog.Builder(FavoritesFragment.this.getActivity()).setMessage(FavoritesFragment.this.getString(C0846R.string.are_you_sure_remove_conf_bag)).setPositiveButton(C0846R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ContentValues cv = new ContentValues();
                        cv.put("deleted", "1");
                        cv.put("synced", "0");
                        C1199DB.update("personal", cv, "type == 'confbag' AND tableid =='" + clicked.getId() + "'");
                        FavoritesFragment.this.setupAttendees();
                        FavoritesFragment.this.onResume();
                        Internet.synchConferencebag(FavoritesFragment.this.confhandler);
                    }
                }).setNegativeButton(C0846R.string.f2002no, (DialogInterface.OnClickListener) null).show();
                return false;
            }
        });
    }

    public void setupCatalog() {
        ListView lv = (ListView) this.f2027v.findViewById(C0846R.C0847id.lvcatalog);
        List<TCObject> list = C1199DB.getQueryFromDb("SELECT catalog.* FROM personal INNER JOIN catalog ON personal.tableid == catalog.id WHERE deleted == '0' AND personal.table_value == 'catalog'");
        List<TCListObject> temp = new ArrayList<>();
        for (TCObject tco : list) {
            temp.add(new TCListObject(tco.get(DBFavorites.KEY_EVENT_ID), tco.get(DBFavorites.KEY_NAME), (String) null, (String) null, tco.get("imageurl", "")));
        }
        if (list.size() == 0) {
            lv.setVisibility(8);
            ((ImageView) this.f2027v.findViewById(C0846R.C0847id.catalogivempty)).setImageResource(C0846R.drawable.info_conference_bag);
            ((TextView) this.f2027v.findViewById(C0846R.C0847id.catalogtvempty)).setText(getString(C0846R.string.confbagdescription));
        } else {
            lv.setVisibility(0);
        }
        TCListObject.TCListObjectAdapter adap = new TCListObject.TCListObjectAdapter(temp, 0);
        adap.setThrash(this.thrash, this);
        lv.setAdapter(adap);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Fragments.add(FavoritesFragment.this, CatalogDetailFragment.newInstance(((TCListObject) arg0.getAdapter().getItem(arg2)).getId(), 0), FavoritesFragment.this.getResourceString(C0846R.string.detail));
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                final TCListObject clicked = (TCListObject) arg0.getAdapter().getItem(arg2);
                new AlertDialog.Builder(FavoritesFragment.this.getActivity()).setMessage(FavoritesFragment.this.getString(C0846R.string.are_you_sure_remove_conf_bag)).setPositiveButton(C0846R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ContentValues cv = new ContentValues();
                        cv.put("deleted", "1");
                        cv.put("synced", "0");
                        C1199DB.update("personal", cv, "type == 'confbag' AND tableid =='" + clicked.getId() + "'");
                        FavoritesFragment.this.setupAttendees();
                        Internet.synchConferencebag(FavoritesFragment.this.confhandler);
                    }
                }).setNegativeButton(C0846R.string.f2002no, (DialogInterface.OnClickListener) null).show();
                return false;
            }
        });
    }

    public void setupProjects() {
        ListView lv = (ListView) this.f2027v.findViewById(C0846R.C0847id.lvprojects);
        List<TCObject> list = C1199DB.getQueryFromDb("SELECT catalog.* FROM personal INNER JOIN catalog ON personal.tableid == catalog.id WHERE deleted == '0' AND personal.table_value == 'projects' COLLATE NOCASE");
        List<TCListObject> temp = new ArrayList<>();
        for (TCObject tco : list) {
            temp.add(new TCListObject(tco.get(DBFavorites.KEY_EVENT_ID), tco.get(DBFavorites.KEY_NAME), (String) null, (String) null, tco.get("imageurl", "")));
        }
        if (list.size() == 0) {
            lv.setVisibility(8);
            ((ImageView) this.f2027v.findViewById(C0846R.C0847id.projectsivempty)).setImageResource(C0846R.drawable.info_conference_bag);
            ((TextView) this.f2027v.findViewById(C0846R.C0847id.projectstvempty)).setText(getString(C0846R.string.confbagdescription));
        } else {
            lv.setVisibility(0);
        }
        TCListObject.TCListObjectAdapter adap = new TCListObject.TCListObjectAdapter(temp, 0);
        adap.setThrash(this.thrash, this);
        lv.setAdapter(adap);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Fragments.add(FavoritesFragment.this, CatalogDetailFragment.newInstance(((TCListObject) arg0.getAdapter().getItem(arg2)).getId(), "projects"), FavoritesFragment.this.getResourceString(C0846R.string.detail));
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                final TCListObject clicked = (TCListObject) arg0.getAdapter().getItem(arg2);
                new AlertDialog.Builder(FavoritesFragment.this.getActivity()).setMessage(FavoritesFragment.this.getString(C0846R.string.are_you_sure_remove_conf_bag)).setPositiveButton(C0846R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ContentValues cv = new ContentValues();
                        cv.put("deleted", "1");
                        cv.put("synced", "0");
                        C1199DB.update("personal", cv, "type == 'confbag' AND tableid =='" + clicked.getId() + "'");
                        FavoritesFragment.this.setupAttendees();
                        Internet.synchConferencebag(FavoritesFragment.this.confhandler);
                    }
                }).setNegativeButton(C0846R.string.f2002no, (DialogInterface.OnClickListener) null).show();
                return false;
            }
        });
    }

    public void setupOther() {
        ListView lv = (ListView) this.f2027v.findViewById(C0846R.C0847id.lvother);
        List<TCObject> list = C1199DB.getQueryFromDb("SELECT * FROM personal WHERE table_value == 'other' AND deleted == '0'");
        List<TCListObject> temp = new ArrayList<>();
        for (TCObject tco : list) {
            temp.add(new TCListObject(tco, DBFavorites.KEY_EVENT_ID, "extra", (String) null, (String) null, "image"));
        }
        if (list.size() == 0) {
            lv.setVisibility(8);
            ((ImageView) this.f2027v.findViewById(C0846R.C0847id.otherivempty)).setImageResource(C0846R.drawable.info_conference_bag);
            ((TextView) this.f2027v.findViewById(C0846R.C0847id.othertvempty)).setText(getResourceString(C0846R.string.confbagdescription));
        } else {
            lv.setVisibility(0);
        }
        TCListObject.TCListObjectAdapter adap = new TCListObject.TCListObjectAdapter(temp, 0);
        adap.setThrash(this.thrash, this);
        lv.setAdapter(adap);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                TCListObject tco = (TCListObject) arg0.getAdapter().getItem(arg2);
                Fragments.add(FavoritesFragment.this, WebViewFragment.newInstance(tco.getText(), ""), tco.getText());
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                final TCListObject clicked = (TCListObject) arg0.getAdapter().getItem(arg2);
                new AlertDialog.Builder(FavoritesFragment.this.getActivity()).setMessage(FavoritesFragment.this.getString(C0846R.string.are_you_sure_remove_conf_bag)).setPositiveButton(C0846R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ContentValues cv = new ContentValues();
                        cv.put("deleted", "1");
                        cv.put("synced", "0");
                        C1199DB.update("personal", cv, "type == 'confbag' AND id =='" + clicked.getId() + "'");
                        FavoritesFragment.this.setupOther();
                        Internet.synchConferencebag(FavoritesFragment.this.confhandler);
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

    public void save(View v) {
        IntentIntegrator.initiateScan(this, getActivity());
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != 1612) {
            super.onActivityResult(requestCode, resultCode, data);
        } else if (data != null) {
            this.website = data.getStringExtra(Intents.Scan.RESULT);
            new GetTitleFromUrlTask(this, (GetTitleFromUrlTask) null).execute(new String[]{this.website});
            try {
                User.getUserEmail((Fragment) this, FavoritesFragment.class.getDeclaredMethod("addToConferenceBag", new Class[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addToConferenceBag() {
        String email = App.act.getSharedPreferences("TapCrowd", 0).getString("email", "");
        if (this.website.contains("m.tap.cr")) {
            String[] array = this.website.split("/");
            String id = array[array.length - 1];
            String table = array[array.length - 3];
            if (C1199DB.getSize("personal", "tableid", id) == 0) {
                C1199DB.getQueryFromDb("INSERT INTO personal(id, appid, " + this.type + ", email, table_value, tableid, extra, type, deleted, synced) " + "VALUES('" + Utils.generateId() + "', '" + App.f2123id + "', '" + this.typeid + "', '" + email + "', '" + table + "', '" + id + "', '" + this.website + "', 'confbag', '0', '0')");
            }
        } else if (C1199DB.getSize("personal", "extra", this.website) == 0) {
            C1199DB.getQueryFromDb("INSERT INTO personal(id, appid, " + this.type + ", email, table_value, tableid, extra, type, deleted, synced) " + "VALUES('" + Utils.generateId() + "', '" + App.f2123id + "', '" + this.typeid + "', '" + email + "', 'other', '0', '" + this.website + "', 'confbag', '0', '0')");
        }
        onResume();
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

    private class GetTitleFromUrlTask extends AsyncTask<String, Void, String> {
        String url;

        private GetTitleFromUrlTask() {
        }

        /* synthetic */ GetTitleFromUrlTask(FavoritesFragment favoritesFragment, GetTitleFromUrlTask getTitleFromUrlTask) {
            this();
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... params) {
            this.url = params[0];
            try {
                InputStream is = new DefaultHttpClient().execute(new HttpGet(this.url)).getEntity().getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = br.readLine();
                    if (line == null) {
                        String result = sb.toString();
                        is.close();
                        return result.split("<title>")[1].split("</title>")[0];
                    }
                    sb.append(line);
                }
            } catch (Exception e) {
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String result) {
            if (result != null) {
                SharedPreferences.Editor editor = FavoritesFragment.this.getActivity().getPreferences(0).edit();
                editor.putString(this.url, result);
                editor.commit();
                FavoritesFragment.this.setupOther();
            }
            super.onPostExecute(result);
        }
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 234:
                change();
                return;
            case 621:
                clear();
                return;
            case 649:
                receive();
                return;
            case 3425:
                edit();
                return;
            case 8182:
                IntentIntegrator.initiateScan(this, getActivity());
                return;
            default:
                return;
        }
    }

    private void edit() {
        this.thrash = !this.thrash;
        onResume();
    }

    private void change() {
        User.editUserEmail(this);
    }

    private void receive() {
        if (C1199DB.getSize("personal") > 0) {
            final SharedPreferences pref = getActivity().getSharedPreferences("TapCrowd", 0);
            final String email = pref.getString("email", "");
            new Thread(new Runnable() {
                public void run() {
                    List<NameValuePair> postparams = new ArrayList<>();
                    postparams.add(new BasicNameValuePair("lang", pref.getString("lang", (String) null)));
                    postparams.add(new BasicNameValuePair("email", email));
                    postparams.add(new BasicNameValuePair(FavoritesFragment.this.type, FavoritesFragment.this.typeid));
                    Internet.request("sendConfbag", postparams);
                }
            }).start();
            AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
            alert.setMessage("An email has been sent.");
            alert.setPositiveButton(getString(17039370), (DialogInterface.OnClickListener) null);
            alert.show();
            return;
        }
        AlertDialog.Builder alert2 = new AlertDialog.Builder(getActivity());
        alert2.setMessage(getString(C0846R.string.confbagdescription));
        alert2.setPositiveButton(getString(17039370), (DialogInterface.OnClickListener) null);
        alert2.show();
    }

    private void clear() {
        C1199DB.getDatabase().delete("personal", (String) null, (String[]) null);
        onResume();
    }

    public void onRemoveClick(TCListObject tco) {
        String id = tco.getId();
        ContentValues cv = new ContentValues();
        cv.put("deleted", "1");
        cv.put("synced", "0");
        C1199DB.update("personal", cv, "type == 'confbag' AND tableid =='" + id + "'");
        C1199DB.update("personal", cv, "id =='" + id + "'");
        Internet.synchConferencebag(this.confhandler);
        onResume();
    }
}
