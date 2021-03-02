package com.forexcrunch.forexcrunch.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.model.HistTableModel;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;

public class HistTableListAdapter extends BaseAdapter {
    private Context context;
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    private LayoutInflater inflater;
    private ArrayList<HistTableModel> items;
    private int resource;

    private class ViewHolder {
        public TextView actualText;
        public TextView consensusText;
        public TextView graphicalText;
        public TextView previousText;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(HistTableListAdapter histTableListAdapter, ViewHolder viewHolder) {
            this();
        }
    }

    public HistTableListAdapter(Context ctx, int resourceId, ArrayList<HistTableModel> objects) {
        this.resource = resourceId;
        this.inflater = (LayoutInflater) ctx.getSystemService("layout_inflater");
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
            holder.actualText = (TextView) view.findViewById(C0089R.idHistTableListItem.actual);
            holder.consensusText = (TextView) view.findViewById(C0089R.idHistTableListItem.consensusText);
            holder.previousText = (TextView) view.findViewById(C0089R.idHistTableListItem.previousText);
            holder.graphicalText = (TextView) view.findViewById(C0089R.idHistTableListItem.graphic);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        fillGraphicInfo(position, holder);
        fillPreviousInfo(position, holder);
        fillConsensusInfo(position, holder);
        fillActualInfo(position, holder);
        return view;
    }

    private void fillGraphicInfo(int position, ViewHolder holder) {
        holder.graphicalText.setText(this.items.get(position).getDateTime().getFormattedString());
    }

    private void fillActualInfo(int position, ViewHolder holder) {
        if (this.items.get(position).getDisplayActual() == null || this.items.get(position).getDisplayActual().equals("")) {
            holder.actualText.setText("-");
        } else {
            holder.actualText.setText(this.items.get(position).getDisplayActual());
        }
    }

    private void fillConsensusInfo(int position, ViewHolder holder) {
        if (this.items.get(position).getDisplayConsensus() == null || this.items.get(position).getDisplayConsensus().equals("")) {
            holder.consensusText.setText("-");
        } else {
            holder.consensusText.setText(this.items.get(position).getDisplayConsensus());
        }
    }

    private void fillPreviousInfo(int position, ViewHolder holder) {
        if (this.items.get(position).getDisplayPrevious() == null || this.items.get(position).getDisplayPrevious().equals("")) {
            holder.previousText.setText("-");
        } else {
            holder.previousText.setText(this.items.get(position).getDisplayPrevious());
        }
    }

    public ArrayList<HistTableModel> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<HistTableModel> items2) {
        this.items = items2;
    }

    public Object getItem(int pos) {
        return this.items.get(pos);
    }

    public long getItemId(int pos) {
        return (long) pos;
    }
}
