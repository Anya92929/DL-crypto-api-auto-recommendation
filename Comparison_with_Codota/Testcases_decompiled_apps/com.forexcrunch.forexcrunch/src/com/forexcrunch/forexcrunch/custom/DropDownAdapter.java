package com.forexcrunch.forexcrunch.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.model.DropDownIconItem;
import java.util.ArrayList;

public class DropDownAdapter extends ArrayAdapter<DropDownIconItem> {
    private Context context;
    private LayoutInflater inflater;
    ArrayList<DropDownIconItem> items;
    private int selectedPosition = -1;

    public DropDownAdapter(Context context2, int textViewResourceId, ArrayList<DropDownIconItem> objects) {
        super(context2, textViewResourceId, objects);
        this.items = objects;
        this.context = context2;
        this.inflater = LayoutInflater.from(context2);
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public void setNotifyOnChange(boolean notifyOnChange) {
        super.setNotifyOnChange(notifyOnChange);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public int getCount() {
        return this.items.size();
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        View row = this.inflater.inflate(C0089R.layout.drop_down_view, parent, false);
        TextView spinnerText = (TextView) row.findViewById(C0089R.idDropDownItem.name_view);
        ImageView icon = (ImageView) row.findViewById(C0089R.idDropDownItem.icon);
        if (position < this.items.size()) {
            spinnerText.setText(this.items.get(position).getName());
            icon.setImageResource(this.items.get(position).getIconResId());
        }
        if (this.selectedPosition == -1 || this.selectedPosition != position) {
            spinnerText.setTextColor(this.context.getResources().getColor(C0089R.color.white));
            icon.setImageResource(this.items.get(position).getIconResId());
        } else {
            spinnerText.setTextColor(this.context.getResources().getColor(C0089R.color.orange_time_label));
            icon.setImageResource(this.items.get(position).getIconActivatedResId());
        }
        return row;
    }

    public int getSelectedPosition() {
        return this.selectedPosition;
    }

    public void setSelectedPosition(int selectedPosition2) {
        this.selectedPosition = selectedPosition2;
    }
}
