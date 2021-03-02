package com.tapcrowd.app.modules.notifications;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.modules.notifications.MessageDetailFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.Internet;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.UserModule;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

public class NotificationsFragment extends TCFragment implements TabHost.OnTabChangeListener, MenuFragment.MenuItemListener {
    private final int MESSAGE_EDIT = 768;
    private ListView all;
    private TCListObjectAdapter allAdapter;
    /* access modifiers changed from: private */
    public List<String> ids;
    LayoutInflater inflater;
    private int layout;
    private AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> l, View v, int position, long idd) {
            TCListObject tlo = (TCListObject) l.getItemAtPosition(position);
            String type = tlo.getId().split(":")[0];
            String id = tlo.getId().split(":")[1];
            ContentValues cv = new ContentValues();
            cv.put("read", "1");
            C1199DB.update(type, cv, "id == '" + id + "'");
            if (type.equals("push")) {
                Fragments.add(NotificationsFragment.this, MessageDetailFragment.newInstance((String) null, tlo.getText()), NotificationsFragment.this.getResourceString(C0846R.string.detail));
            } else if (type.equals("messages")) {
                TCObject tco = C1199DB.getObject(LinkedObjects.TABLE_ATT, DBFavorites.KEY_EVENT_ID, C1199DB.getFirstObject("messages", DBFavorites.KEY_EVENT_ID, id).get("senderattendeeid"));
                Fragments.add(NotificationsFragment.this, MessageDetailFragment.newInstance(id, (String) null), String.valueOf(tco.get("firstname", "")) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + tco.get(DBFavorites.KEY_NAME, ""));
            }
        }
    };
    private boolean retained;
    private TabHost tabHost;
    private ListView unread;
    private TCListObjectAdapter unreadAdapter;

    /* renamed from: v */
    private View f2098v;

    public static NotificationsFragment newInstance() {
        return new NotificationsFragment();
    }

    public View onCreateView(LayoutInflater inflater2, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater2;
        if (this.f2098v == null) {
            this.f2098v = inflater2.inflate(C0846R.layout.listview_notifications, container, false);
        } else {
            ((ViewGroup) this.f2098v.getParent()).removeView(this.f2098v);
            this.retained = true;
        }
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_notes_nav, C1216LO.getLo(C1216LO.navigationColor)), 768));
        Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
        return this.f2098v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AdHelper.showAds(this, AdHelper.buildPath("65", "list", (String) null));
        if (!this.retained) {
            C1232UI.getColorOverlay((int) C0846R.drawable.icon_delete, C1216LO.getLo(C1216LO.actionbarContentColor));
            C1232UI.getColorOverlay((int) C0846R.drawable.icon_unread, C1216LO.getLo(C1216LO.actionbarContentColor));
            findViewById(C0846R.C0847id.unread_action).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    NotificationsFragment.this.unread();
                }
            });
            findViewById(C0846R.C0847id.trash_action).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    NotificationsFragment.this.trash();
                }
            });
            findViewById(C0846R.C0847id.innercontainer).setBackgroundColor(C1216LO.getLo(C1216LO.actionbarBackgroundColor));
            this.all = (ListView) findViewById(C0846R.C0847id.lvall);
            this.unread = (ListView) findViewById(C0846R.C0847id.lvunread);
            findViewById(C0846R.C0847id.sep).setBackgroundColor(C1216LO.getLo(C1216LO.topTabBackgroundcolorHigh));
            new RetrieveMessages(this, (RetrieveMessages) null).execute(new Void[0]);
            setuptabs();
        }
    }

    public void setuptabs() {
        this.tabHost = (TabHost) findViewById(16908306);
        this.tabHost.setOnTabChangedListener(this);
        this.tabHost.setup();
        this.tabHost.addTab(newTab(getString(C0846R.string.inbox), C0846R.C0847id.all));
        this.tabHost.addTab(newTab(getString(C0846R.string.unread), C0846R.C0847id.unread));
        TabWidget tabWidget = this.tabHost.getTabWidget();
        int tabChildrenCount = tabWidget.getChildCount();
        for (int i = 0; i < tabChildrenCount; i++) {
            ((LinearLayout.LayoutParams) tabWidget.getChildAt(i).getLayoutParams()).setMargins(5, 0, 5, 0);
        }
        tabWidget.setDividerDrawable((Drawable) null);
        tabWidget.requestLayout();
        if (this.tabHost.getTabWidget().getTabCount() > 0) {
            onTabChanged(this.tabHost.getCurrentTabTag());
        }
    }

    public TabHost.TabSpec newTab(String text, int content) {
        View view = this.inflater.inflate(C0846R.layout.tab_layout, (ViewGroup) null);
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

    public void onTabChanged(String arg0) {
        int len = this.tabHost.getTabWidget().getTabCount();
        for (int i = 0; i < len; i++) {
            View tab = this.tabHost.getTabWidget().getChildTabViewAt(i);
            tab.setBackgroundDrawable(new TabDrawable(new RoundRectShape(new float[]{15.0f, 15.0f, 15.0f, 15.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED}, (RectF) null, (float[]) null), C1216LO.getLo(C1216LO.topTabBackgroundcolor)));
            ((TextView) tab.findViewById(C0846R.C0847id.tabtitle)).setTextColor(C1216LO.getLo(C1216LO.topTabTextColor));
        }
        View current = this.tabHost.getCurrentTabView();
        current.setBackgroundDrawable(new TabDrawable(new RoundRectShape(new float[]{15.0f, 15.0f, 15.0f, 15.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED}, (RectF) null, (float[]) null), C1216LO.getLo(C1216LO.topTabBackgroundcolorHigh)));
        ((TextView) current.findViewById(C0846R.C0847id.tabtitle)).setTextColor(C1216LO.getLo(C1216LO.topTabTextColorHigh));
    }

    public void onResume() {
        super.onResume();
        this.ids = new ArrayList();
        List<TCListObject> list = new ArrayList<>();
        if (UserModule.isLoggedIn(getActivity())) {
            list.addAll(createList(C1199DB.getListFromDb("messages", "deleted == '0' AND userid", UserModule.getUserId(getActivity()), "read +0 ASC, timestampcreated DESC")));
        }
        this.allAdapter = new TCListObjectAdapter(list, 0);
        if (this.layout != 0) {
            this.allAdapter.setLayout(this.layout);
        }
        this.all.setAdapter(this.allAdapter);
        this.all.setOnItemClickListener(this.listener);
        List<TCListObject> unreadList = new ArrayList<>();
        if (UserModule.isLoggedIn(getActivity())) {
            unreadList.addAll(createList(C1199DB.getListFromDb("messages", "deleted == '0' AND userid == '" + UserModule.getUserId(getActivity()) + "' AND read", "0", "timestampcreated DESC")));
        }
        this.unreadAdapter = new TCListObjectAdapter(unreadList, 0);
        if (this.layout != 0) {
            this.unreadAdapter.setLayout(this.layout);
        }
        this.unread.setAdapter(this.unreadAdapter);
        this.unread.setOnItemClickListener(this.listener);
        int len = this.tabHost.getTabWidget().getTabCount();
        for (int i = 0; i < len; i++) {
            TextView title = (TextView) this.tabHost.getTabWidget().getChildTabViewAt(i).findViewById(C0846R.C0847id.tabtitle);
            if (title.getText().toString().contains(getString(C0846R.string.unread))) {
                title.setText(String.valueOf(getString(C0846R.string.unread)) + " (" + unreadList.size() + ")");
            }
        }
    }

    public ArrayList<TCListObject> createList(List<TCObject> messages) {
        String name;
        ArrayList<TCListObject> items = new ArrayList<>();
        for (TCObject message : messages) {
            TCObject attendee = C1199DB.getFirstObject(LinkedObjects.TABLE_ATT, DBFavorites.KEY_EVENT_ID, message.get("senderattendeeid"));
            String time = "";
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
                sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
                Date date = sdf.parse(message.get("timestampcreated"));
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                if (DateUtils.isToday(cal.getTimeInMillis())) {
                    time = (cal.get(11) < 10 ? "0" + cal.get(11) : Integer.valueOf(cal.get(11))) + ":" + (cal.get(12) < 10 ? "0" + cal.get(12) : Integer.valueOf(cal.get(12)));
                } else {
                    time = String.valueOf(cal.get(5)) + "/" + (cal.get(2) + 1) + "/" + cal.get(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (attendee.has("firstname")) {
                name = String.valueOf(attendee.get("firstname")) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + attendee.get(DBFavorites.KEY_NAME);
            } else {
                name = getString(C0846R.string.app_name);
            }
            String sub1 = message.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "");
            MessageDetailFragment.MeetingStatus status = new MessageDetailFragment.MeetingStatus(getActivity(), message.get("meetingconfirmed", ""));
            if (status.hasStatus()) {
                sub1 = String.valueOf(sub1) + String.format(" (%1$s)", new Object[]{status.getStatus()});
            }
            if (sub1.equals("") || sub1.equals("Push")) {
                sub1 = message.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
            }
            items.add(new TCListObject("messages:" + message.get(DBFavorites.KEY_EVENT_ID), status.isDeletable(), name, sub1, time, (String) null));
        }
        return items;
    }

    public View findViewById(int id) {
        return this.f2098v.findViewById(id);
    }

    public void show() {
        View actionbutton = findViewById(C0846R.C0847id.actionbuttons);
        TranslateAnimation in = new TranslateAnimation(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, Converter.convertDpToPixel(70.0f, getActivity()), BitmapDescriptorFactory.HUE_RED);
        in.setDuration(200);
        actionbutton.setVisibility(0);
        actionbutton.startAnimation(in);
    }

    public void hide() {
        View actionbutton = findViewById(C0846R.C0847id.actionbuttons);
        TranslateAnimation out = new TranslateAnimation(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, Converter.convertDpToPixel(70.0f, getActivity()));
        out.setDuration(200);
        actionbutton.startAnimation(out);
        actionbutton.setVisibility(8);
    }

    private class TCListObjectAdapter extends ArrayAdapter {
        private int layout = C0846R.layout.cell_tcobject_time;
        private LayoutInflater mInflater = LayoutInflater.from(App.act);
        private int textcolor = C1216LO.getLo(C1216LO.textcolor);

        public void setLayout(int layout2) {
            this.layout = layout2;
        }

        public TCListObjectAdapter(List list, int defaultResource) {
            super(App.act, 0, list);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            Object o = getItem(position);
            if (o.getClass() != TCListObject.class) {
                return new View(App.act);
            }
            final TCListObject tlo = (TCListObject) o;
            if (convertView == null) {
                convertView = this.mInflater.inflate(this.layout, (ViewGroup) null);
            }
            C1232UI.setFont((TextView) convertView.findViewById(C0846R.C0847id.text));
            C1232UI.setFont((TextView) convertView.findViewById(C0846R.C0847id.sub1));
            C1232UI.setFont((TextView) convertView.findViewById(C0846R.C0847id.sub2));
            TextView text = (TextView) convertView.findViewById(C0846R.C0847id.text);
            TextView sub1 = (TextView) convertView.findViewById(C0846R.C0847id.sub1);
            TextView sub2 = (TextView) convertView.findViewById(C0846R.C0847id.sub2);
            convertView.findViewById(C0846R.C0847id.icon).setVisibility(8);
            text.setTextColor(this.textcolor);
            sub1.setTextColor(this.textcolor);
            sub2.setTextColor(this.textcolor);
            try {
                if (tlo.getText() == null) {
                    text.setVisibility(8);
                } else {
                    text.setText(Converter.unicodeToString(Html.fromHtml(tlo.getText()).toString()));
                }
                if (C1199DB.getObject(tlo.getId().split(":")[0], DBFavorites.KEY_EVENT_ID, tlo.getId().split(":")[1]).get("read", "1").equals("0")) {
                    text.setTypeface(Typeface.DEFAULT_BOLD);
                } else {
                    text.setTypeface(Typeface.DEFAULT);
                }
                if (tlo.getSub1() != null) {
                    sub1.setText(tlo.getSub1());
                    sub1.setVisibility(0);
                } else {
                    sub1.setVisibility(8);
                    LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) text.getLayoutParams();
                    lp.setMargins(10, 15, 10, 15);
                    text.setLayoutParams(lp);
                }
                if (tlo.getSub2() == null) {
                    sub2.setVisibility(8);
                } else {
                    sub2.setText(tlo.getSub2());
                }
                if (this.layout == C0846R.layout.cell_tcobject_checkbox) {
                    CheckBox checkbox = (CheckBox) convertView.findViewById(C0846R.C0847id.checkbox);
                    if (tlo.ispremium) {
                        checkbox.setVisibility(0);
                    } else {
                        checkbox.setVisibility(4);
                    }
                    checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked) {
                                NotificationsFragment.this.ids.add(tlo.getId());
                            } else {
                                NotificationsFragment.this.ids.remove(tlo.getId());
                            }
                        }
                    });
                }
                return convertView;
            } catch (Exception e) {
                e.printStackTrace();
                return new View(getContext());
            }
        }
    }

    private class RetrieveMessages extends AsyncTask<Void, Void, Void> {
        private RetrieveMessages() {
        }

        /* synthetic */ RetrieveMessages(NotificationsFragment notificationsFragment, RetrieveMessages retrieveMessages) {
            this();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            NotificationsFragment.sync(NotificationsFragment.this.getActivity());
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
            NotificationsFragment.this.onResume();
        }
    }

    public static void sync(Context context) {
        C1199DB.openDataBase(context);
        List<NameValuePair> postparams = new ArrayList<>();
        String userid = UserModule.getUserId(context);
        if (userid != null) {
            postparams.add(new BasicNameValuePair("appid", App.f2123id));
            postparams.add(new BasicNameValuePair("userid", userid));
            String ids2 = "";
            try {
                JSONArray ja = new JSONObject(Internet.request("getMessages", postparams, context)).getJSONArray("messages");
                int len = ja.length();
                for (int i = 0; i < len; i++) {
                    JSONObject message = ja.getJSONObject(i);
                    ContentValues cv = new ContentValues();
                    cv.put(DBFavorites.KEY_EVENT_ID, message.getString(DBFavorites.KEY_EVENT_ID));
                    cv.put("senderuserid", message.getString("senderuserid"));
                    cv.put("recipientuserid", message.getString("recipientuserid"));
                    cv.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, message.getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                    cv.put("payload", message.getString("payload"));
                    cv.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, message.getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION));
                    cv.put("senderattendeeid", message.getString("senderattendeeid"));
                    cv.put("meetingconfirmed", message.getString("meetingconfirmed"));
                    cv.put("timestampcreated", message.getString("timestampcreated"));
                    cv.put("meetingpoiid", message.getString("meetingpoiid"));
                    cv.put("meetingpoiname", message.getString("meetingpoiname"));
                    cv.put("meetingdatetime", message.getString("meetingdatetime"));
                    cv.put("userid", userid);
                    if (C1199DB.update("messages", cv, String.format("id == '%1$s'", new Object[]{message.getString(DBFavorites.KEY_EVENT_ID)})) == 0) {
                        cv.put("deleted", "0");
                        cv.put("read", "0");
                        C1199DB.add("messages", cv);
                    }
                    ids2 = String.valueOf(String.valueOf(ids2) + (ids2.length() > 0 ? "," : "")) + message.getString(DBFavorites.KEY_EVENT_ID);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (ids2.length() > 0) {
                C1199DB.getQueryFromDb(String.format("DELETE FROM messages WHERE id NOT IN (%1$s)", new Object[]{ids2}));
            }
        }
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 768:
                toggle();
                return;
            default:
                return;
        }
    }

    public void toggle() {
        switch (findViewById(C0846R.C0847id.actionbuttons).getVisibility()) {
            case 0:
                this.layout = C0846R.layout.cell_tcobject_time;
                this.allAdapter.setLayout(this.layout);
                this.all.setAdapter(this.allAdapter);
                this.unreadAdapter.setLayout(this.layout);
                this.unread.setAdapter(this.unreadAdapter);
                hide();
                return;
            case 8:
                this.ids = new ArrayList();
                this.layout = C0846R.layout.cell_tcobject_checkbox;
                this.allAdapter.setLayout(this.layout);
                this.all.setAdapter(this.allAdapter);
                this.unreadAdapter.setLayout(this.layout);
                this.unread.setAdapter(this.unreadAdapter);
                show();
                return;
            default:
                return;
        }
    }

    public void trash() {
        String messageids = "";
        for (String id : this.ids) {
            String type = id.split(":")[0];
            String typeid = id.split(":")[1];
            if (type.equals("push")) {
                C1199DB.remove(type, DBFavorites.KEY_EVENT_ID, typeid);
            } else {
                ContentValues cv = new ContentValues();
                cv.put("deleted", "1");
                C1199DB.update("messages", cv, "id == '" + typeid + "'");
                int length = messageids.length();
                if (type.equals("messages")) {
                    messageids = String.valueOf(messageids) + (length > 0 ? "," : "") + typeid;
                }
            }
        }
        this.ids = new ArrayList();
        onResume();
        if (messageids.length() > 0) {
            new RemoveMessages(messageids, UserModule.getUserId(getActivity())).start();
        }
    }

    public void unread() {
        for (String id : this.ids) {
            String type = id.split(":")[0];
            String typeid = id.split(":")[1];
            ContentValues cv = new ContentValues();
            cv.put("read", "0");
            C1199DB.update(type, cv, "id == '" + typeid + "'");
        }
        this.ids = new ArrayList();
        onResume();
    }

    private class RemoveMessages extends Thread {
        String messageids;
        String userid;

        public RemoveMessages(String messageids2, String userid2) {
            this.userid = userid2;
            this.messageids = messageids2;
        }

        public void run() {
            List<NameValuePair> postparams = new ArrayList<>();
            postparams.add(new BasicNameValuePair("messageids", this.messageids));
            postparams.add(new BasicNameValuePair("userid", this.userid));
            Internet.request("removeMessages", postparams);
            super.run();
        }
    }
}
