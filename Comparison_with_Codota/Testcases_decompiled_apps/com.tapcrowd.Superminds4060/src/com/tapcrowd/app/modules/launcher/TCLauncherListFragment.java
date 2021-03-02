package com.tapcrowd.app.modules.launcher;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.LauncherUtil;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.images.FastImageLoader;
import java.util.ArrayList;
import java.util.List;

public class TCLauncherListFragment extends TCListFragment {
    /* access modifiers changed from: private */
    public FastImageLoader fil;
    private boolean retained;
    private String type;
    private String typeid;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public View f2060v;

    public static TCLauncherListFragment newInstance(String type2, String typeid2) {
        TCLauncherListFragment launcher = new TCLauncherListFragment();
        launcher.type = type2;
        launcher.typeid = typeid2;
        return launcher;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2060v == null) {
            this.f2060v = inflater.inflate(C0846R.layout.listview, container, false);
        } else {
            ((ViewGroup) this.f2060v.getParent()).removeView(this.f2060v);
            this.retained = true;
        }
        return this.f2060v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setShowHomebutton(false);
        if (!this.retained) {
            this.fil = new FastImageLoader();
            if (C1216LO.getLoUrl(C1216LO.launcherBackground) == null) {
                getView().findViewById(C0846R.C0847id.screen).setBackgroundColor(C1216LO.getLo(C1216LO.launcherBackgroundColor));
            } else {
                this.fil.getBitmap(C1216LO.getLoUrl(C1216LO.launcherBackground), new FastImageLoader.LoadBitmapListener() {
                    public void bitmapLoaded(Bitmap bitmap) {
                        TCLauncherListFragment.this.f2060v.findViewById(C0846R.C0847id.main).setBackgroundDrawable(new BitmapDrawable(bitmap));
                    }
                });
            }
            setupList();
        }
    }

    public void setupList() {
        List<TCObject> list = C1199DB.getListFromDb("launchers", this.type, this.typeid, "order_value +0 ASC");
        List<TCObject> toRemove = new ArrayList<>();
        for (TCObject item : list) {
            if (!LauncherUtil.hasFragment(item)) {
                toRemove.add(item);
            }
        }
        for (TCObject remove : toRemove) {
            list.remove(remove);
        }
        setListAdapter(new ListAdapter(list));
    }

    private class ListAdapter extends ArrayAdapter<TCObject> {

        /* renamed from: li */
        LayoutInflater f2061li;

        public ListAdapter(List<TCObject> list) {
            super(TCLauncherListFragment.this.getActivity(), 0, list);
            this.f2061li = LayoutInflater.from(TCLauncherListFragment.this.getActivity());
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            TCObject current = (TCObject) getItem(position);
            if (convertView == null) {
                convertView = this.f2061li.inflate(C0846R.layout.cell_tcobject, (ViewGroup) null);
            }
            convertView.findViewById(C0846R.C0847id.sub1).setVisibility(8);
            convertView.findViewById(C0846R.C0847id.sub2).setVisibility(8);
            ImageView icon = (ImageView) convertView.findViewById(C0846R.C0847id.icon);
            TextView text = (TextView) convertView.findViewById(C0846R.C0847id.text);
            TCLauncherListFragment.this.fil.DisplayImage(current.get(C1216LO.icon), icon, icon.getHeight(), icon.getWidth());
            text.setText(current.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
            text.setTextColor(C1216LO.getLo(C1216LO.launcherTextColor));
            return convertView;
        }
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        TCObject clicked = (TCObject) l.getItemAtPosition(position);
        Fragments.add(this, LauncherUtil.getFragment(clicked), clicked.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
    }
}
