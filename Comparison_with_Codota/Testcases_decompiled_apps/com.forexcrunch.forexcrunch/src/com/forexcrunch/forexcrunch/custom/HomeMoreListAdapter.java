package com.forexcrunch.forexcrunch.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;

public class HomeMoreListAdapter extends ArrayAdapter<String> {
    private Context context;
    protected ImageLoader imageLoader;
    private LayoutInflater inflater;
    private ArrayList<String> items;
    private int resource;

    public HomeMoreListAdapter(Context ctx, int resourceId, ArrayList<String> objects) {
        super(ctx, resourceId, objects);
        this.resource = resourceId;
        this.inflater = LayoutInflater.from(ctx);
        this.context = ctx;
        this.items = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView != null) {
            return convertView;
        }
        View convertView2 = (RelativeLayout) this.inflater.inflate(this.resource, (ViewGroup) null);
        ((TextView) convertView2.findViewById(C0089R.idMoreListItem.title)).setText(this.items.get(position));
        return convertView2;
    }

    public ArrayList<String> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<String> items2) {
        this.items = items2;
    }
}
