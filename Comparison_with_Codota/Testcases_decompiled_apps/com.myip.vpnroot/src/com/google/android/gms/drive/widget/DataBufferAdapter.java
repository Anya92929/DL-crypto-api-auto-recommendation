package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.drive.internal.C0478v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataBufferAdapter<T> extends BaseAdapter {

    /* renamed from: RJ */
    private final int f1239RJ;

    /* renamed from: RK */
    private int f1240RK;

    /* renamed from: RL */
    private final int f1241RL;

    /* renamed from: RM */
    private final List<DataBuffer<T>> f1242RM;

    /* renamed from: RN */
    private final LayoutInflater f1243RN;

    /* renamed from: RO */
    private boolean f1244RO;
    private final Context mContext;

    public DataBufferAdapter(Context context, int resource) {
        this(context, resource, 0, new ArrayList());
    }

    public DataBufferAdapter(Context context, int resource, int textViewResourceId) {
        this(context, resource, textViewResourceId, new ArrayList());
    }

    public DataBufferAdapter(Context context, int resource, int textViewResourceId, List<DataBuffer<T>> objects) {
        this.f1244RO = true;
        this.mContext = context;
        this.f1240RK = resource;
        this.f1239RJ = resource;
        this.f1241RL = textViewResourceId;
        this.f1242RM = objects;
        this.f1243RN = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public DataBufferAdapter(Context context, int resource, int textViewResourceId, DataBuffer<T>... buffers) {
        this(context, resource, textViewResourceId, Arrays.asList(buffers));
    }

    public DataBufferAdapter(Context context, int resource, List<DataBuffer<T>> objects) {
        this(context, resource, 0, objects);
    }

    public DataBufferAdapter(Context context, int resource, DataBuffer<T>... buffers) {
        this(context, resource, 0, Arrays.asList(buffers));
    }

    /* renamed from: a */
    private View m1703a(int i, View view, ViewGroup viewGroup, int i2) {
        View inflate = view == null ? this.f1243RN.inflate(i2, viewGroup, false) : view;
        try {
            TextView textView = this.f1241RL == 0 ? (TextView) inflate : (TextView) inflate.findViewById(this.f1241RL);
            Object item = getItem(i);
            if (item instanceof CharSequence) {
                textView.setText((CharSequence) item);
            } else {
                textView.setText(item.toString());
            }
            return inflate;
        } catch (ClassCastException e) {
            C0478v.m1340a("DataBufferAdapter", e, "You must supply a resource ID for a TextView");
            throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", e);
        }
    }

    public void append(DataBuffer<T> buffer) {
        this.f1242RM.add(buffer);
        if (this.f1244RO) {
            notifyDataSetChanged();
        }
    }

    public void clear() {
        for (DataBuffer<T> release : this.f1242RM) {
            release.release();
        }
        this.f1242RM.clear();
        if (this.f1244RO) {
            notifyDataSetChanged();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getCount() {
        int i = 0;
        Iterator<DataBuffer<T>> it = this.f1242RM.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().getCount() + i2;
        }
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return m1703a(position, convertView, parent, this.f1240RK);
    }

    public T getItem(int position) throws CursorIndexOutOfBoundsException {
        int i = position;
        for (DataBuffer next : this.f1242RM) {
            int count = next.getCount();
            if (count <= i) {
                i -= count;
            } else {
                try {
                    return next.get(i);
                } catch (CursorIndexOutOfBoundsException e) {
                    throw new CursorIndexOutOfBoundsException(position, getCount());
                }
            }
        }
        throw new CursorIndexOutOfBoundsException(position, getCount());
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return m1703a(position, convertView, parent, this.f1239RJ);
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.f1244RO = true;
    }

    public void setDropDownViewResource(int resource) {
        this.f1240RK = resource;
    }

    public void setNotifyOnChange(boolean notifyOnChange) {
        this.f1244RO = notifyOnChange;
    }
}
