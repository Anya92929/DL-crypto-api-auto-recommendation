package com.forexcrunch.forexcrunch.custom;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.gui.utils.Utils;
import com.forexcrunch.forexcrunch.model.CalendarItem;
import java.util.ArrayList;

public class CalendarListAdapter extends BaseAdapter {
    /* access modifiers changed from: private */
    public Context context;
    private LayoutInflater inflater;
    private ArrayList<CalendarItem> items;
    private int resource;

    private class ViewHolder {
        public TextView actualText;
        public TextView consensusText;
        public TextView dateHeader;
        public TextView event;
        public ImageView flag;
        public TextView gmtText;
        public TextView previousText;
        public ImageView volatility;

        private ViewHolder() {
        }

        /* synthetic */ ViewHolder(CalendarListAdapter calendarListAdapter, ViewHolder viewHolder) {
            this();
        }
    }

    public CalendarListAdapter(Context ctx, int resourceId, ArrayList<CalendarItem> objects) {
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
            holder.event = (TextView) view.findViewById(C0089R.idCalendarListItem.event);
            holder.actualText = (TextView) view.findViewById(C0089R.idCalendarListItem.actualText);
            holder.consensusText = (TextView) view.findViewById(C0089R.idCalendarListItem.consensusText);
            holder.previousText = (TextView) view.findViewById(C0089R.idCalendarListItem.previousText);
            holder.gmtText = (TextView) view.findViewById(C0089R.idCalendarListItem.gmtText);
            holder.dateHeader = (TextView) view.findViewById(C0089R.idCalendarListItem.dateHeader);
            holder.volatility = (ImageView) view.findViewById(C0089R.idCalendarListItem.volatility);
            holder.flag = (ImageView) view.findViewById(C0089R.idCalendarListItem.flag);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        checkChangedDay(position, holder);
        setFlagImage(position, holder);
        fillVolatilityInfo(position, holder);
        fillGMTInfo(position, holder);
        fillPreviousInfo(position, holder);
        fillConsensusInfo(position, holder);
        fillActualInfo(position, holder);
        holder.event.setText(this.items.get(position).getName());
        return view;
    }

    private void checkChangedDay(int position, ViewHolder holder) {
        if (position == 0) {
            Utils.getFormattedMonthAndDay(this.items.get(position).getDateTime().getMonth(), this.items.get(position).getDateTime().getDay());
            return;
        }
        int currentDay = this.items.get(position).getDateTime().getDay();
        int currentMonth = this.items.get(position).getDateTime().getMonth();
        if (this.items.get(position - 1).getDateTime().getDay() == currentDay && this.items.get(position - 1).getDateTime().getMonth() == currentMonth) {
            holder.dateHeader.setVisibility(8);
            return;
        }
        holder.dateHeader.setText(Utils.getFormattedMonthAndDay(currentMonth, currentDay));
        holder.dateHeader.setVisibility(0);
    }

    private void fillGMTInfo(int position, ViewHolder holder) {
        holder.gmtText.setText(Utils.getFormattedTime(this.items.get(position).getDateTime().getHour(), this.items.get(position).getDateTime().getMinute()));
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

    private void fillVolatilityInfo(int position, ViewHolder holder) {
        holder.volatility.setImageResource(Utils.getVolatilityResourceId(this.items.get(position).getVolatility()));
    }

    public ArrayList<CalendarItem> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<CalendarItem> items2) {
        this.items = items2;
    }

    public void setFlagImage(int position, ViewHolder holder) {
        if (this.items.get(position).getInternationalCode() == null || this.items.get(position).getInternationalCode().equals("")) {
            holder.flag.setImageResource(C0089R.drawable.nocountry);
        } else {
            new LoadFlagTask(holder, this.items.get(position)).execute(new Void[0]);
        }
    }

    public class LoadFlagTask extends AsyncTask<Void, Void, Void> {
        ViewHolder holder;

        /* renamed from: id */
        int f60id;
        CalendarItem item;

        public LoadFlagTask(ViewHolder holder2, CalendarItem item2) {
            this.holder = holder2;
            this.item = item2;
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            this.f60id = Utils.getFlagImageId(this.item.getInternationalCode().toLowerCase(), CalendarListAdapter.this.context);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            this.holder.flag.setImageResource(this.f60id);
            super.onPostExecute(result);
        }
    }

    public Object getItem(int pos) {
        return this.items.get(pos);
    }

    public long getItemId(int pos) {
        return (long) pos;
    }
}
