package com.tapcrowd.app.modules.favorites_v2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.exhibitors.ExhibitorDetailFragment;
import com.tapcrowd.app.modules.favorites_v2.FavoritesUtil;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.modules.sessions.SessionDetailFragment;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.Internet;
import com.tapcrowd.app.utils.TCCheckboxAdapter;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.views.SearchBar;
import com.tapcrowd.tcanalytics.TCAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import twitter4j.internal.http.HttpResponseCode;

public class FavoritesFragment extends TCListFragment implements MenuFragment.MenuItemListener {
    public static final String TAG = "Fav2";
    public final int CHANGE = 234;
    public final int CLEAR = 621;
    private final int DELETE_ITEM = 327;
    public final int EDIT = 3425;
    public final int RECEIVE = 649;
    private final int SELECT_ALL = HttpResponseCode.BAD_REQUEST;
    private final int SEND_MAIL = 347;
    /* access modifiers changed from: private */
    public TCCheckboxAdapterSectioned adapterSectioned;
    /* access modifiers changed from: private */

    /* renamed from: db */
    public DBFavorites f2033db;
    /* access modifiers changed from: private */
    public boolean hasCAB = false;
    /* access modifiers changed from: private */
    public List<Object> listItems;
    /* access modifiers changed from: private */
    public SearchBar.TextChangedListener listener = new SearchBar.TextChangedListener() {
        public void textChanged(CharSequence s, int count) {
            List<TCObject> queryExhibitors = FavoritesFragment.this.f2033db.getExhibitorsBySearch(s.toString());
            List<TCObject> querySessions = FavoritesFragment.this.f2033db.getSessionsBySearch(s.toString());
            FavoritesFragment.this.listItems.clear();
            if (queryExhibitors.size() > 0) {
                FavoritesFragment.this.listItems.add("Exhibitors");
            }
            for (TCObject item : queryExhibitors) {
                FavoritesFragment.this.listItems.add(new TCListObject(item.get(DBFavorites.KEY_ID), item.get(DBFavorites.KEY_NAME), item.get(DBFavorites.KEY_MODULE), (String) null, (String) null));
            }
            if (querySessions.size() > 0) {
                FavoritesFragment.this.listItems.add("Sessions");
            }
            for (TCObject item2 : querySessions) {
                FavoritesFragment.this.listItems.add(new TCListObject(item2.get(DBFavorites.KEY_ID), item2.get(DBFavorites.KEY_NAME), item2.get(DBFavorites.KEY_MODULE), (String) null, (String) null));
            }
            FavoritesFragment.this.adapterSectioned.notifyDataSetChanged();
        }
    };
    private List<String> selectedIds = new ArrayList();
    /* access modifiers changed from: private */
    public String type;
    /* access modifiers changed from: private */
    public String typeid;

    public static FavoritesFragment newInstance() {
        return newInstance((String) null, (String) null);
    }

    public static FavoritesFragment newInstance(String type2, String typeid2) {
        FavoritesFragment fr = new FavoritesFragment();
        fr.type = type2;
        fr.typeid = typeid2;
        return fr;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Internet.syncFavorites();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!this.retained) {
            this.f2033db = new DBFavorites(App.act);
            new LoadListTask(this, (LoadListTask) null).execute(new Void[0]);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2007v == null) {
            this.f2007v = inflater.inflate(C0846R.layout.listview, container, false);
        } else {
            ((ViewGroup) this.f2007v.getParent()).removeView(this.f2007v);
            this.retained = true;
        }
        setupMenu();
        return this.f2007v;
    }

    public void setupMenu() {
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        String title = C1199DB.getFirstObject("launchers", "moduletypeid", "74").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        List<MenuFragment.SubMenuContainer> submenu = new ArrayList<>();
        submenu.add(new MenuFragment.SubMenuContainer(234, getString(C0846R.string.change_email)));
        submenu.add(new MenuFragment.SubMenuContainer(649, String.valueOf(getString(C0846R.string.receive)) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + title));
        submenu.add(new MenuFragment.SubMenuContainer(621, String.valueOf(getString(C0846R.string.clear)) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + title));
        menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_overflow, C1216LO.getLo(C1216LO.navigationColor)), submenu));
        Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        Object obj = l.getItemAtPosition(position);
        if (obj instanceof TCListObject) {
            TCListObject clicked = (TCListObject) obj;
            if (clicked.getSub1().equalsIgnoreCase(FavoritesUtil.Type.Exhibitors.toString())) {
                Fragments.add(this, ExhibitorDetailFragment.newInstance(this.f2033db.getById(clicked.getId().toString().split("_")[0], clicked.getSub1()).get(DBFavorites.KEY_EVENT_ID)), getResourceString(C0846R.string.detail));
            } else {
                Fragments.add(this, SessionDetailFragment.newInstance(this.f2033db.getById(clicked.getId().toString().split("_")[0], clicked.getSub1()).get(DBFavorites.KEY_EVENT_ID)), getResourceString(C0846R.string.detail));
            }
            closeCAB();
        }
    }

    private void closeCAB() {
        if (Fragments.mode != null) {
            Fragments.mode.finish();
        }
    }

    private class LoadListTask extends AsyncTask<Void, Void, Void> {
        boolean isDeleted;

        private LoadListTask() {
            this.isDeleted = false;
        }

        /* synthetic */ LoadListTask(FavoritesFragment favoritesFragment, LoadListTask loadListTask) {
            this();
        }

        private void addItems(List<TCObject> items, String table) {
            for (TCObject item : items) {
                if (C1199DB.getSize(item.get(DBFavorites.KEY_MODULE), DBFavorites.KEY_EVENT_ID, item.get(DBFavorites.KEY_EVENT_ID)) > 0) {
                    FavoritesFragment.this.listItems.add(new TCListObject(String.valueOf(item.get(DBFavorites.KEY_ID)) + "_" + table, item.get(DBFavorites.KEY_NAME), item.get(DBFavorites.KEY_MODULE), (String) null, (String) null));
                } else {
                    this.isDeleted = true;
                    Log.i(FavoritesFragment.TAG, String.valueOf(item.get(DBFavorites.KEY_EVENT_ID)) + "is deleted");
                    if (table == DBFavorites.TABLE_EXHIBITORS) {
                        FavoritesFragment.this.f2033db.deleteExhibitorByEventId(item.get(DBFavorites.KEY_EVENT_ID));
                    } else {
                        FavoritesFragment.this.f2033db.deleteSessionByEventId(item.get(DBFavorites.KEY_EVENT_ID));
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            FavoritesFragment.this.listItems = new ArrayList();
            List<TCObject> exhibitors = FavoritesFragment.this.f2033db.getAllExhibitors();
            List<TCObject> sessions = FavoritesFragment.this.f2033db.getAllSessions();
            if (exhibitors.size() > 0) {
                FavoritesFragment.this.listItems.add("Exhibitors");
            }
            addItems(exhibitors, DBFavorites.TABLE_EXHIBITORS);
            if (sessions.size() > 0) {
                FavoritesFragment.this.listItems.add("Sessions");
            }
            addItems(sessions, "sessions");
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
            FavoritesFragment.this.getListView().setChoiceMode(2);
            if (FavoritesFragment.this.getListView().getHeaderViewsCount() < 1) {
                FavoritesFragment.this.getListView().addHeaderView(new SearchBar(FavoritesFragment.this.getActivity(), FavoritesFragment.this, FavoritesFragment.this.listener));
            }
            FavoritesFragment.this.adapterSectioned = new TCCheckboxAdapterSectioned(FavoritesFragment.this.listItems, new TCCheckboxAdapter.onCheckboxClickListener() {
                public void onCheckboxClicked(List<String> ids) {
                    FavoritesFragment.this.showCAB(ids);
                }
            });
            FavoritesFragment.this.setListAdapter(FavoritesFragment.this.adapterSectioned);
            if (this.isDeleted) {
                Log.v(FavoritesFragment.TAG, "Some items were removed");
                Toast.makeText(App.act, FavoritesFragment.this.getString(C0846R.string.favorites_deleted_cms), 1).show();
            }
            this.isDeleted = false;
        }
    }

    /* access modifiers changed from: private */
    public void sendEmail() {
    }

    /* access modifiers changed from: private */
    public void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(C0846R.string.are_you_sure_to_delete_selected_items).setTitle(C0846R.string.alert_dialog);
        builder.setPositiveButton(C0846R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                FavoritesFragment.this.deleteItems();
            }
        });
        builder.setNegativeButton(C0846R.string.f2002no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.create().show();
    }

    /* access modifiers changed from: private */
    public void deleteItems() {
        for (int i = 0; i < this.selectedIds.size(); i++) {
            for (Object element : this.listItems) {
                if (element instanceof TCListObject) {
                    TCListObject listObject = (TCListObject) element;
                    if (listObject.getId().equals(this.selectedIds.get(i)) && listObject.getSub1().equalsIgnoreCase(DBFavorites.TABLE_EXHIBITORS)) {
                        this.f2033db.deleteExhibitor(this.selectedIds.get(i).toString().split("_")[0]);
                    } else if (listObject.getId().equals(this.selectedIds.get(i)) && listObject.getSub1().equalsIgnoreCase("sessions")) {
                        this.f2033db.deleteSession(this.selectedIds.get(i).toString().split("_")[0]);
                    }
                }
            }
        }
        new LoadListTask(this, (LoadListTask) null).execute(new Void[0]);
        if (Fragments.mode != null) {
            Fragments.mode.finish();
        }
    }

    /* access modifiers changed from: private */
    public void showCAB(List<String> ids) {
        CallbackHelper callback = new CallbackHelper(this, (CallbackHelper) null);
        if (ids.isEmpty() && this.hasCAB) {
            callback.close();
        } else if (ids.size() >= 1) {
            this.selectedIds = ids;
            if (!this.hasCAB) {
                getSherlockActivity().startActionMode(new CallbackHelper(this, (CallbackHelper) null));
            }
        }
    }

    /* access modifiers changed from: private */
    public void setAllCheckboxes(boolean setState) {
        ListView list = getListView();
        if (list != null) {
            int count = getListAdapter().getCount();
            for (int i = 0; i < count; i++) {
                try {
                    ViewGroup row = (ViewGroup) list.getChildAt(i);
                    if (row instanceof SearchBar) {
                        count++;
                    } else {
                        CheckBox check = (CheckBox) row.findViewById(C0846R.C0847id.checkbox);
                        if (check != null) {
                            check.setChecked(setState);
                        }
                    }
                } catch (NullPointerException e) {
                }
            }
        }
    }

    private class CallbackHelper implements ActionMode.Callback {
        private CallbackHelper() {
        }

        /* synthetic */ CallbackHelper(FavoritesFragment favoritesFragment, CallbackHelper callbackHelper) {
            this();
        }

        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            FavoritesFragment.this.hasCAB = true;
            Fragments.mode = mode;
            menu.add(0, (int) HttpResponseCode.BAD_REQUEST, 0, (int) C0846R.string.select_all).setIcon(C1232UI.getColorOverlay((int) C0846R.drawable.icon_vinkje, C1216LO.getLo(C1216LO.navigationColor)));
            menu.add(0, 347, 0, (int) C0846R.string.mail).setIcon(C1232UI.getColorOverlay((int) C0846R.drawable.icon_email, C1216LO.getLo(C1216LO.navigationColor)));
            menu.add(0, 327, 0, (int) C0846R.string.remove).setIcon(C1232UI.getColorOverlay((int) C0846R.drawable.delete, C1216LO.getLo(C1216LO.navigationColor)));
            return true;
        }

        public void close() {
            Fragments.mode.finish();
        }

        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case 327:
                    FavoritesFragment.this.showConfirmationDialog();
                    return true;
                case 347:
                    FavoritesFragment.this.sendEmail();
                    return true;
                case HttpResponseCode.BAD_REQUEST /*400*/:
                    FavoritesFragment.this.setAllCheckboxes(true);
                    return true;
                default:
                    mode.finish();
                    return false;
            }
        }

        public void onDestroyActionMode(ActionMode mode) {
            FavoritesFragment.this.setAllCheckboxes(false);
            FavoritesFragment.this.hasCAB = false;
        }
    }

    private class EmailDialog extends Dialog implements View.OnClickListener {
        Context context;
        EditText email;
        SharedPreferences pref = getContext().getSharedPreferences("TapCrowd", 0);
        TextView title;

        public EmailDialog(Context context2) {
            super(context2, C0846R.style.transparentDialogTheme);
            requestWindowFeature(1);
            this.context = context2;
        }

        /* access modifiers changed from: protected */
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            View v = getLayoutInflater().inflate(C0846R.layout.confbag_dialog, (ViewGroup) null);
            this.title = (TextView) v.findViewById(C0846R.C0847id.title);
            this.email = (EditText) v.findViewById(C0846R.C0847id.email);
            this.email.setInputType(33);
            if (this.pref.getString("email", (String) null) != null) {
                this.email.setText(this.pref.getString("email", (String) null));
            }
            v.setBackgroundColor(C1216LO.getLo(C1216LO.launcherBackgroundColor));
            this.title.setText(C1199DB.getFirstObject("launchers", "moduletypeid", "74").get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE).toUpperCase(Locale.ENGLISH));
            this.title.setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
            this.title.setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
            Button ok = (Button) v.findViewById(C0846R.C0847id.f1990ok);
            ok.setBackgroundColor(C1216LO.getLo(C1216LO.topTabBackgroundcolor));
            ok.setTextColor(C1216LO.getLo(C1216LO.topTabTextColor));
            ok.setOnClickListener(this);
            Button cancel = (Button) v.findViewById(C0846R.C0847id.cancel);
            cancel.setBackgroundColor(C1216LO.getLo(C1216LO.topTabBackgroundcolor));
            cancel.setTextColor(C1216LO.getLo(C1216LO.topTabTextColor));
            cancel.setOnClickListener(this);
            setContentView(v, new ViewGroup.LayoutParams((((Activity) this.context).getWindowManager().getDefaultDisplay().getWidth() / 5) * (App.tablet ? 3 : 4), -1));
        }

        public void onClick(View v) {
            if (v.getId() == C0846R.C0847id.f1990ok) {
                if (this.email.getText().toString().contains("@")) {
                    SharedPreferences.Editor editor = this.pref.edit();
                    editor.putString("email", this.email.getText().toString());
                    TCAnalytics.log(this.context, "email", this.email.getText().toString());
                    editor.commit();
                    dismiss();
                    return;
                }
                Toast.makeText(App.act, App.act.getString(C0846R.string.invalidemail), 1).show();
            } else if (v.getId() == C0846R.C0847id.cancel) {
                SharedPreferences.Editor edit = this.pref.edit();
                edit.putString("email", "");
                edit.commit();
                dismiss();
            }
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
            default:
                return;
        }
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
        this.f2033db.deleteExhibitors();
        this.f2033db.deleteSessions();
        new LoadListTask(this, (LoadListTask) null).execute(new Void[0]);
    }

    private void change() {
        new EmailDialog(getActivity()).show();
    }
}
