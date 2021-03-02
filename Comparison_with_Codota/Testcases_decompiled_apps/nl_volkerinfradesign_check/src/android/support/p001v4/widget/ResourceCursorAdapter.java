package android.support.p001v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.widget.ResourceCursorAdapter */
public abstract class ResourceCursorAdapter extends CursorAdapter {

    /* renamed from: a */
    private int f1281a;

    /* renamed from: b */
    private int f1282b;

    /* renamed from: c */
    private LayoutInflater f1283c;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i, Cursor cursor) {
        super(context, cursor);
        this.f1282b = i;
        this.f1281a = i;
        this.f1283c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f1282b = i;
        this.f1281a = i;
        this.f1283c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context context, int i, Cursor cursor, int i2) {
        super(context, cursor, i2);
        this.f1282b = i;
        this.f1281a = i;
        this.f1283c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1283c.inflate(this.f1281a, viewGroup, false);
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1283c.inflate(this.f1282b, viewGroup, false);
    }

    public void setViewResource(int i) {
        this.f1281a = i;
    }

    public void setDropDownViewResource(int i) {
        this.f1282b = i;
    }
}
