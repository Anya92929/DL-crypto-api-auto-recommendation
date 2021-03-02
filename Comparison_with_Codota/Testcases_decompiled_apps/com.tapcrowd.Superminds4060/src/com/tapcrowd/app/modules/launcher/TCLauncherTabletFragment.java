package com.tapcrowd.app.modules.launcher;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockListFragment;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.settings.SettingsFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.LauncherUtil;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.UserModule;
import com.tapcrowd.app.utils.images.FastImageLoader;
import java.util.ArrayList;
import java.util.List;

public class TCLauncherTabletFragment extends SherlockListFragment {
    FastImageLoader fil = new FastImageLoader();
    List<Object> list;
    int selectedindex = 0;
    String type;
    String typeid;

    public static TCLauncherTabletFragment newInstance(String type2, String typeid2) {
        TCLauncherTabletFragment fr = new TCLauncherTabletFragment();
        fr.type = type2;
        fr.typeid = typeid2;
        return fr;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(C0846R.layout.tablet_launcheritems, container, false);
        v.setBackgroundColor(C1216LO.getLo(C1216LO.tabletBackgroundColor));
        return v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AdHelper.showAds(this, "");
        App.act = getSherlockActivity();
        String color = Integer.toHexString(C1216LO.getLo(C1216LO.titleFontColor));
        if (color.length() == 8) {
            color = color.substring(2);
        }
        TCObject app = C1199DB.getObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, DBFavorites.KEY_EVENT_ID, App.f2123id);
        ActionBar ab = getSherlockActivity().getSupportActionBar();
        ab.setHomeButtonEnabled(false);
        ab.setTitle((CharSequence) Html.fromHtml("<font color='#" + color + "'>" + app.get(DBFavorites.KEY_NAME, "TapCrowd") + "</font>"));
        updateOrientation();
        showDetails(0);
        getListView().setChoiceMode(1);
    }

    public void onResume() {
        App.act = getSherlockActivity();
        super.onResume();
    }

    public void updateOrientation() {
        this.list = new ArrayList();
        List<TCObject> t = C1199DB.getListFromDb("launchers", this.type, this.typeid, "order_value +0");
        if (getResources().getConfiguration().orientation == 2) {
            getActivity().findViewById(C0846R.C0847id.shadowid).setLayoutParams(new LinearLayout.LayoutParams((int) Converter.convertDpToPixel(250.0f, getActivity()), -2));
            for (TCObject tco : t) {
                if (LauncherUtil.hasFragment(tco)) {
                    this.list.add(new TCListObject(tco, DBFavorites.KEY_EVENT_ID, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, PlusShare.KEY_CALL_TO_ACTION_URL, (String) null, C1216LO.icon, (Boolean) false));
                }
            }
            if (C1199DB.getSize("languages") > 0 || C1199DB.getSize("launchers", "moduletypeid", "49") > 0) {
                this.list.add(new TCListObject("settings", getString(C0846R.string.settings), (String) null, (String) null, (String) null, (Boolean) false));
            }
        } else {
            getActivity().findViewById(C0846R.C0847id.shadowid).setLayoutParams(new LinearLayout.LayoutParams((int) Converter.convertDpToPixel(80.0f, getActivity()), -2));
            for (TCObject tco2 : t) {
                if (LauncherUtil.hasFragment(tco2)) {
                    this.list.add(new TCListObject(tco2, DBFavorites.KEY_EVENT_ID, (String) null, PlusShare.KEY_CALL_TO_ACTION_URL, (String) null, C1216LO.icon, (Boolean) false));
                }
            }
            if (C1199DB.getSize("languages") > 0 || C1199DB.getSize("launchers", "moduletypeid", "49") > 0) {
                this.list.add(new TCListObject("settings", (String) null, (String) null, (String) null, (String) null, (Boolean) false));
            }
        }
        getListView().setCacheColorHint(0);
        setListAdapter(new TCListObjectAdapter(this.list));
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        this.selectedindex = position;
        ((ArrayAdapter) getListAdapter()).notifyDataSetChanged();
        TCListObject tlo = (TCListObject) l.getItemAtPosition(position);
        String launcherid = tlo.getId();
        if (UserModule.doLogin(getActivity(), launcherid)) {
            new UserModule.LoginDialog(getActivity(), (Fragment) null, launcherid, LauncherUtil.getFragment(tlo), tlo.getText()).show();
        } else {
            showDetails(position);
        }
    }

    public void setArrow(String moduletypeid) {
        TCListObjectAdapter adapter = (TCListObjectAdapter) getListAdapter();
        int len = adapter.getCount();
        for (int i = 0; i < len; i++) {
            try {
                if (((TCListObject) adapter.getItem(i)).getId().equals(moduletypeid)) {
                    this.selectedindex = i;
                }
            } catch (Exception e) {
            }
        }
        adapter.notifyDataSetChanged();
    }

    private void showDetails(int position) {
        Object o = this.list.get(position);
        if (o.getClass() == TCListObject.class) {
            TCListObject tlo = (TCListObject) o;
            Fragment fragment = LauncherUtil.getFragment(tlo);
            if (fragment != null) {
                Fragments.clear();
                Fragments.add(this, fragment, tlo.getText());
            }
            if (tlo.getId().equals("settings")) {
                Fragments.clear();
                Fragments.add((Fragment) null, SettingsFragment.newInstance(), getString(C0846R.string.settings));
            }
        }
    }

    private class TCListObjectAdapter extends ArrayAdapter<Object> {
        private LayoutInflater mInflater;

        private class Holder {
            ImageView arrow;
            ImageView icon;
            TextView sub1;
            TextView sub2;
            TextView text;

            private Holder() {
            }

            /* synthetic */ Holder(TCListObjectAdapter tCListObjectAdapter, Holder holder) {
                this();
            }
        }

        public TCListObjectAdapter(List<Object> list) {
            super(App.act, 0, list);
            this.mInflater = LayoutInflater.from(TCLauncherTabletFragment.this.getActivity());
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv;
            Holder holder;
            Object o = getItem(position);
            if (o.getClass() == TCListObject.class) {
                TCListObject tlo = (TCListObject) getItem(position);
                if (convertView == null) {
                    convertView = this.mInflater.inflate(C0846R.layout.cell_tcobject_noti, (ViewGroup) null);
                    holder = new Holder(this, (Holder) null);
                    holder.text = (TextView) convertView.findViewById(C0846R.C0847id.text);
                    holder.sub1 = (TextView) convertView.findViewById(C0846R.C0847id.sub1);
                    holder.sub1.setVisibility(8);
                    holder.sub2 = (TextView) convertView.findViewById(C0846R.C0847id.sub2);
                    holder.icon = (ImageView) convertView.findViewById(C0846R.C0847id.icon);
                    holder.arrow = (ImageView) convertView.findViewById(C0846R.C0847id.arrow);
                    convertView.setTag(holder);
                } else {
                    try {
                        holder = (Holder) convertView.getTag();
                    } catch (Exception e) {
                        convertView = this.mInflater.inflate(C0846R.layout.cell_tcobject_noti, (ViewGroup) null);
                        holder = new Holder(this, (Holder) null);
                        holder.text = (TextView) convertView.findViewById(C0846R.C0847id.text);
                        holder.sub1 = (TextView) convertView.findViewById(C0846R.C0847id.sub1);
                        holder.sub1.setVisibility(8);
                        holder.sub2 = (TextView) convertView.findViewById(C0846R.C0847id.sub2);
                        holder.icon = (ImageView) convertView.findViewById(C0846R.C0847id.icon);
                        holder.arrow = (ImageView) convertView.findViewById(C0846R.C0847id.arrow);
                        convertView.setTag(holder);
                    }
                }
                try {
                    if (position == TCLauncherTabletFragment.this.selectedindex) {
                        convertView.setBackgroundColor(C1216LO.getLo(C1216LO.tableviewHighlight));
                    } else {
                        convertView.setBackgroundDrawable((Drawable) null);
                    }
                    holder.text.setTextColor(C1216LO.getLo(C1216LO.launcherTextColor));
                    holder.sub1.setTextColor(C1216LO.getLo(C1216LO.launcherTextColor));
                    holder.sub2.setTextColor(C1216LO.getLo(C1216LO.launcherTextColor));
                    int noticount = 0;
                    if (tlo.getId() != null && C1199DB.getFirstObject("launchers", DBFavorites.KEY_EVENT_ID, tlo.getId()).get("moduletypeid", "").equals("65") && UserModule.isLoggedIn(TCLauncherTabletFragment.this.getActivity())) {
                        noticount = C1199DB.getSize("push", "read", "0");
                        if (UserModule.getUserId(TCLauncherTabletFragment.this.getActivity()) != null) {
                            noticount = C1199DB.getSize("messages", "deleted == '0' AND userid == '" + UserModule.getUserId(TCLauncherTabletFragment.this.getActivity()) + "' AND read", "0");
                        }
                    }
                    TextView noticountTv = (TextView) convertView.findViewById(C0846R.C0847id.number);
                    if (noticount > 0) {
                        noticountTv.setText(new StringBuilder(String.valueOf(noticount)).toString());
                        noticountTv.setVisibility(0);
                    } else {
                        noticountTv.setVisibility(8);
                    }
                    if (tlo.getText() == null) {
                        holder.text.setVisibility(8);
                    } else {
                        String temp = tlo.getText();
                        if (temp != null) {
                            holder.text.setPadding(0, 0, 20, 0);
                            holder.text.setText(Converter.unicodeToString(Html.fromHtml(temp).toString()));
                        }
                    }
                    if (tlo.getSub2() == null) {
                        holder.sub2.setVisibility(8);
                    } else if (tlo.getSub2().equals("")) {
                        holder.sub2.setVisibility(8);
                    } else {
                        holder.sub2.setText(tlo.getSub2());
                    }
                    if (tlo.getImg() == null && tlo.getId().equals("settings")) {
                        holder.icon.setImageResource(C0846R.drawable.list_settings);
                    } else if (tlo.getImg() == null && tlo.getId().equals("help")) {
                        holder.icon.setImageResource(C0846R.drawable.icon_question);
                    } else if (tlo.getImg() == null) {
                        holder.icon.setVisibility(8);
                    } else {
                        holder.icon.setVisibility(0);
                        if (!tlo.getImg().equals("")) {
                            TCLauncherTabletFragment.this.fil.DisplayImage(tlo.getImg(), holder.icon);
                        } else if (tlo.getDefaultresource() == 0) {
                            holder.icon.setVisibility(8);
                        } else {
                            holder.icon.setImageResource(tlo.getDefaultresource());
                        }
                    }
                    if (!tlo.showArrow()) {
                        holder.arrow.setVisibility(8);
                    } else {
                        holder.arrow.setVisibility(0);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return convertView;
            } else if (o.getClass() != String.class) {
                return new View(TCLauncherTabletFragment.this.getActivity());
            } else {
                if (convertView == null) {
                    convertView = this.mInflater.inflate(C0846R.layout.separator, (ViewGroup) null);
                    tv = (TextView) convertView.findViewById(C0846R.C0847id.text);
                    convertView.setTag(tv);
                } else {
                    try {
                        tv = (TextView) convertView.getTag();
                    } catch (Exception e3) {
                        convertView = this.mInflater.inflate(C0846R.layout.separator, (ViewGroup) null);
                        tv = (TextView) convertView.findViewById(C0846R.C0847id.text);
                        convertView.setTag(tv);
                    }
                }
                tv.setBackgroundColor(C1216LO.getLo(C1216LO.seperatorBackgroundColor));
                tv.setTextColor(C1216LO.getLo(C1216LO.separatorTextColor));
                tv.setText((String) o);
                return convertView;
            }
        }
    }
}
