package com.tapcrowd.app.modules.launcher;

import android.content.Context;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.imageloader.ImageLoader;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.modules.attendees.AttendeeDetailFragment;
import com.tapcrowd.app.modules.exhibitors.ExhibitorDetailFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.sessions.SessionDetailFragment;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends SherlockFragment {
    final int SEARCH_ID = 1672;
    private TextWatcher SearchWatcher = new TextWatcher() {
        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            List<TCListObject> list = new ArrayList<>();
            List<TCObject> query = C1199DB.getSearchResultFromDb(DBFavorites.TABLE_EXHIBITORS, DBFavorites.KEY_NAME, arg0.toString(), "5");
            int len = query.size();
            for (int i = 0; i < len; i++) {
                TCObject tco = query.get(i);
                String img = null;
                if (i == 0) {
                    img = "http://upload.tapcrowd.com/" + C1199DB.getObject("launchers", "moduletypeid", "2").get(C1216LO.icon, "");
                }
                list.add(new TCListObject("exhibitors:" + tco.get(DBFavorites.KEY_EVENT_ID), tco.get(DBFavorites.KEY_NAME), (String) null, (String) null, img));
            }
            List<TCObject> query2 = C1199DB.getSearchResultFromDb("sessions", DBFavorites.KEY_NAME, arg0.toString(), "5");
            int len2 = query2.size();
            for (int i2 = 0; i2 < len2; i2++) {
                TCObject tco2 = query2.get(i2);
                String img2 = null;
                if (i2 == 0) {
                    img2 = "http://upload.tapcrowd.com/" + C1199DB.getObject("launchers", "moduletypeid", "10").get(C1216LO.icon, "");
                }
                list.add(new TCListObject("sessions:" + tco2.get(DBFavorites.KEY_EVENT_ID), tco2.get(DBFavorites.KEY_NAME), (String) null, (String) null, img2));
            }
            List<TCObject> query3 = C1199DB.getSearchResultFromDb(LinkedObjects.TABLE_ATT, DBFavorites.KEY_NAME, arg0.toString(), "5");
            int len3 = query3.size();
            for (int i3 = 0; i3 < len3; i3++) {
                TCObject tco3 = query3.get(i3);
                String img3 = null;
                if (i3 == 0) {
                    img3 = "http://upload.tapcrowd.com/" + C1199DB.getObject("launchers", "moduletypeid", "14").get(C1216LO.icon, "");
                }
                list.add(new TCListObject("attendees:" + tco3.get(DBFavorites.KEY_EVENT_ID), tco3.get(DBFavorites.KEY_NAME), (String) null, (String) null, img3));
            }
            ListView lv = (ListView) SearchFragment.this.getView().findViewById(C0846R.C0847id.searchresultbox);
            lv.setAdapter(new TCListObjectAdapter(list, SearchFragment.this.getActivity()));
            lv.setDividerHeight(0);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    TCListObject tlo = (TCListObject) arg0.getAdapter().getItem(arg2);
                    String type = tlo.getId().split(":")[0];
                    String id = tlo.getId().split(":")[1];
                    if (type.equals(DBFavorites.TABLE_EXHIBITORS)) {
                        ((TCLauncherTabletFragment) SearchFragment.this.getActivity().getSupportFragmentManager().findFragmentByTag("launcher")).setArrow("2");
                        Fragments.clear();
                        Fragments.add((Fragment) null, ExhibitorDetailFragment.newInstance(id), SearchFragment.this.getString(C0846R.string.detail));
                        SearchFragment.this.hide();
                    } else if (type.equals("sessions")) {
                        ((TCLauncherTabletFragment) SearchFragment.this.getActivity().getSupportFragmentManager().findFragmentByTag("launcher")).setArrow("10");
                        Fragments.clear();
                        Fragments.add((Fragment) null, SessionDetailFragment.newInstance(id), SearchFragment.this.getString(C0846R.string.detail));
                        SearchFragment.this.hide();
                    } else if (type.equals(LinkedObjects.TABLE_ATT)) {
                        ((TCLauncherTabletFragment) SearchFragment.this.getActivity().getSupportFragmentManager().findFragmentByTag("launcher")).setArrow("14");
                        Fragments.clear();
                        Fragments.add((Fragment) null, AttendeeDetailFragment.newInstance(id), SearchFragment.this.getString(C0846R.string.detail));
                        SearchFragment.this.hide();
                    }
                }
            });
        }

        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
        }

        public void afterTextChanged(Editable arg0) {
        }
    };
    MenuItem menuitem;
    EditText searchbox;

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(C0846R.layout.searchbox, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        getView().findViewById(C0846R.C0847id.close).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SearchFragment.this.hide();
            }
        });
        getView().setVisibility(8);
        super.onActivityCreated(savedInstanceState);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        this.searchbox = new EditText(getActivity());
        this.searchbox.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.searchbox.setHint(C0846R.string.search_hint);
        this.searchbox.addTextChangedListener(this.SearchWatcher);
        this.menuitem = menu.add(0, 1672, 0, (int) C0846R.string.search_hint);
        this.menuitem.setIcon(C1232UI.getColorOverlay((int) C0846R.drawable.ic_search_inverse, C1216LO.getLo(C1216LO.navigationColor)));
        this.menuitem.setActionView((View) this.searchbox);
        this.menuitem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            public boolean onMenuItemActionExpand(MenuItem item) {
                SearchFragment.this.searchbox.post(new Runnable() {
                    public void run() {
                        SearchFragment.this.show();
                    }
                });
                return true;
            }

            public boolean onMenuItemActionCollapse(MenuItem item) {
                ((InputMethodManager) SearchFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(SearchFragment.this.searchbox.getWindowToken(), 0);
                SearchFragment.this.getView().setVisibility(8);
                return true;
            }
        });
        this.menuitem.setShowAsAction(10);
        super.onCreateOptionsMenu(menu, inflater);
    }

    /* access modifiers changed from: private */
    public void show() {
        getView().setVisibility(0);
        this.searchbox.requestFocus();
        this.searchbox.setText("");
        ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(this.searchbox, 1);
    }

    /* access modifiers changed from: private */
    public void hide() {
        this.menuitem.collapseActionView();
    }

    public static class TCListObjectAdapter extends ArrayAdapter<TCListObject> {
        private ImageLoader imageLoader = new ImageLoader();
        private LayoutInflater inflater = LayoutInflater.from(App.act);

        public TCListObjectAdapter(List<TCListObject> list, Context context) {
            super(context, 0, list);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            Object o = getItem(position);
            if (o.getClass() != TCListObject.class) {
                return new View(getContext());
            }
            TCListObject tlo = (TCListObject) o;
            View convertView2 = this.inflater.inflate(C0846R.layout.cell_tcobject, (ViewGroup) null);
            convertView2.findViewById(C0846R.C0847id.sub1).setVisibility(8);
            convertView2.findViewById(C0846R.C0847id.sub2).setVisibility(8);
            ((TextView) convertView2.findViewById(C0846R.C0847id.text)).setText(tlo.getText());
            ImageView iv = (ImageView) convertView2.findViewById(C0846R.C0847id.icon);
            if (tlo.getImg() != null) {
                View view = new View(getContext());
                view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
                ((ViewGroup) convertView2).addView(view);
                this.imageLoader.bind(iv, tlo.getImg(), (ImageLoader.Callback) null);
            } else {
                iv.setVisibility(4);
            }
            return convertView2;
        }
    }
}
