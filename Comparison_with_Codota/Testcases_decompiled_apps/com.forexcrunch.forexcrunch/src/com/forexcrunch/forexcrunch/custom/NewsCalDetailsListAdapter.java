package com.forexcrunch.forexcrunch.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.model.NewsCalDetails;
import java.util.ArrayList;

public class NewsCalDetailsListAdapter extends ArrayAdapter<NewsCalDetails> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<NewsCalDetails> items;
    private int resource;

    private class ViewHolder {
        public TextView tvDate;
        public TextView tvProvider;
        public TextView tvTitle;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(NewsCalDetailsListAdapter newsCalDetailsListAdapter, ViewHolder viewHolder) {
            this();
        }
    }

    public NewsCalDetailsListAdapter(Context ctx, int resourceId, ArrayList<NewsCalDetails> objects) {
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
        View view = convertView;
        if (convertView == null) {
            view = (LinearLayout) this.inflater.inflate(this.resource, (ViewGroup) null);
            holder = new ViewHolder(this, (ViewHolder) null);
            holder.tvTitle = (TextView) view.findViewById(C0089R.idNewsCalDetailsListItem.tvTitle);
            holder.tvDate = (TextView) view.findViewById(C0089R.idNewsCalDetailsListItem.tvDate);
            holder.tvProvider = (TextView) view.findViewById(C0089R.idNewsCalDetailsListItem.tvProvider);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tvTitle.setText(this.items.get(position).getTitle());
        holder.tvDate.setText(this.items.get(position).getDateTime().getFormattedString());
        holder.tvProvider.setText("Provider: " + this.items.get(position).getProvider());
        return view;
    }
}
