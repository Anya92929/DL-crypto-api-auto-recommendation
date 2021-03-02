package com.forexcrunch.forexcrunch.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.model.CountryItem;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import java.util.Iterator;

public class FlagListAdapter extends ArrayAdapter<CountryItem> implements CompoundButton.OnCheckedChangeListener {
    private Context context;
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    private LayoutInflater inflater;
    private ArrayList<CountryItem> items;
    private int resource;

    private class ViewHolder {
        public CheckBox flag;
        public TextView name;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(FlagListAdapter flagListAdapter, ViewHolder viewHolder) {
            this();
        }
    }

    public FlagListAdapter(Context ctx, int resourceId, ArrayList<CountryItem> objects) {
        super(ctx, resourceId, objects);
        this.resource = resourceId;
        this.inflater = LayoutInflater.from(ctx);
        this.context = ctx;
        this.items = objects;
    }

    public int getCount() {
        return this.items.size();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(C0089R.layout.flag_item, parent, false);
            holder = new ViewHolder(this, (ViewHolder) null);
            holder.name = (TextView) convertView.findViewById(C0089R.idFlagItem.name);
            holder.flag = (CheckBox) convertView.findViewById(C0089R.idFlagItem.flag);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.flag.setOnCheckedChangeListener(this);
        holder.name.setText(this.items.get(position).getName());
        holder.flag.setGravity(17);
        holder.flag.setTag(new StringBuilder().append(position).toString());
        if (this.items.get(position).isSelected()) {
            holder.flag.setButtonDrawable(this.items.get(position).getFlagResourceIdOn());
            holder.flag.setChecked(true);
        } else {
            holder.flag.setButtonDrawable(this.items.get(position).getFlagResourceIdOff());
            holder.flag.setChecked(false);
        }
        return convertView;
    }

    public ArrayList<CountryItem> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<CountryItem> items2) {
        this.items = items2;
    }

    public void checkAllItems(boolean isChecked) {
        Iterator<CountryItem> it = this.items.iterator();
        while (it.hasNext()) {
            it.next().setSelected(isChecked);
        }
        notifyDataSetChanged();
    }

    public void onCheckedChanged(CompoundButton view, boolean isChecked) {
        this.items.get(Integer.valueOf(view.getTag().toString()).intValue()).setSelected(isChecked);
        notifyDataSetChanged();
    }
}
