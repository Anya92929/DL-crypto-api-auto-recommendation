package com.tapcrowd.app.modules.filter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.OnFragmentResultListener;
import com.tapcrowd.app.views.Separator;
import java.util.ArrayList;
import java.util.List;

public class FilterFragment extends TCListFragment implements MenuFragment.MenuItemListener {
    public static String CHECKED = "checked";
    public static String RESULTS = "results";
    private final int DONE = 649;
    /* access modifiers changed from: private */
    public ArrayList<String> checkeditems = new ArrayList<>();
    private List<Object> filteritems = new ArrayList();
    private OnFragmentResultListener listener;
    private boolean retained;

    /* renamed from: v */
    private View f2035v;

    public static FilterFragment newInstance(Intent items, ArrayList<String> checkeditems2, OnFragmentResultListener listener2) {
        FilterFragment fr = new FilterFragment();
        for (String key : new ArrayList<>(items.getExtras().keySet())) {
            if (!key.equals(CHECKED) && !key.equals(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)) {
                if (!key.equals("null")) {
                    fr.filteritems.add(new Separator(key));
                }
                fr.filteritems.addAll(items.getStringArrayListExtra(key));
            }
        }
        if (checkeditems2 != null) {
            fr.checkeditems = checkeditems2;
        }
        fr.listener = listener2;
        return fr;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2035v == null) {
            this.f2035v = inflater.inflate(C0846R.layout.listview, container, false);
        } else {
            ((ViewGroup) this.f2035v.getParent()).removeView(this.f2035v);
            this.retained = true;
        }
        return this.f2035v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupMenu();
        if (!this.retained) {
            setListAdapter(new FilterAdapter(getActivity(), this.filteritems));
        }
    }

    private class FilterAdapter extends ArrayAdapter<Object> {

        /* renamed from: li */
        LayoutInflater f2036li;

        public FilterAdapter(Context context, List<Object> objects) {
            super(context, 0, objects);
            this.f2036li = LayoutInflater.from(context);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            Object text = getItem(position);
            if (text.getClass() != String.class) {
                return (Separator) text;
            }
            View convertView2 = this.f2036li.inflate(C0846R.layout.cell_filter_layout, (ViewGroup) null);
            CheckBox checkbox = (CheckBox) convertView2.findViewById(C0846R.C0847id.checkbox);
            final String textstr = (String) text;
            ((TextView) convertView2.findViewById(C0846R.C0847id.text)).setText(textstr);
            if (FilterFragment.this.checkeditems.contains(text)) {
                checkbox.setChecked(true);
            }
            checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (!isChecked || FilterFragment.this.checkeditems.contains(textstr)) {
                        FilterFragment.this.checkeditems.remove(textstr);
                    } else {
                        FilterFragment.this.checkeditems.add(textstr);
                    }
                    FilterFragment.this.updateCheck();
                }
            });
            return convertView2;
        }
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        ((CheckBox) v.findViewById(C0846R.C0847id.checkbox)).toggle();
    }

    public void updateCheck() {
    }

    public void setupMenu() {
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_vinkje, C1216LO.getLo(C1216LO.navigationColor)), 649));
        Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 649:
                Intent data = new Intent();
                data.putStringArrayListExtra(RESULTS, this.checkeditems.size() == 0 ? null : this.checkeditems);
                this.listener.onFragmentResult(data, 0, -1);
                Fragments.back();
                return;
            default:
                return;
        }
    }
}
