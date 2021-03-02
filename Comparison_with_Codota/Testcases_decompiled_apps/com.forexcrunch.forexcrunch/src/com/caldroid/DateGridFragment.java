package com.caldroid;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class DateGridFragment extends Fragment {
    private CaldroidGridAdapter gridAdapter;
    private GridView gridView;
    private AdapterView.OnItemClickListener onItemClickListener;

    public AdapterView.OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener2) {
        this.onItemClickListener = onItemClickListener2;
    }

    public CaldroidGridAdapter getGridAdapter() {
        return this.gridAdapter;
    }

    public void setGridAdapter(CaldroidGridAdapter gridAdapter2) {
        this.gridAdapter = gridAdapter2;
    }

    public GridView getGridView() {
        return this.gridView;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.gridView = (GridView) inflater.inflate(C0087R.layout.date_grid_fragment, container, false);
        if (this.gridAdapter != null) {
            this.gridView.setAdapter(this.gridAdapter);
        }
        if (this.onItemClickListener != null) {
            this.gridView.setOnItemClickListener(this.onItemClickListener);
        }
        return this.gridView;
    }
}
