package android.support.p000v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.widget.ResourceCursorAdapter */
public abstract class ResourceCursorAdapter extends CursorAdapter {

    /* renamed from: j */
    private int f1583j;

    /* renamed from: k */
    private int f1584k;

    /* renamed from: l */
    private LayoutInflater f1585l;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i, Cursor cursor) {
        super(context, cursor);
        this.f1584k = i;
        this.f1583j = i;
        this.f1585l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context context, int i, Cursor cursor, int i2) {
        super(context, cursor, i2);
        this.f1584k = i;
        this.f1583j = i;
        this.f1585l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f1584k = i;
        this.f1583j = i;
        this.f1585l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1585l.inflate(this.f1584k, viewGroup, false);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1585l.inflate(this.f1583j, viewGroup, false);
    }

    public void setDropDownViewResource(int i) {
        this.f1584k = i;
    }

    public void setViewResource(int i) {
        this.f1583j = i;
    }
}
