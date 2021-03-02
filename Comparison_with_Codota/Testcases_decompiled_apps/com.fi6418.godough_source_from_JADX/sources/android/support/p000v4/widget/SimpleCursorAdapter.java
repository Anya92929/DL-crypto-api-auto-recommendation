package android.support.p000v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* renamed from: android.support.v4.widget.SimpleCursorAdapter */
public class SimpleCursorAdapter extends ResourceCursorAdapter {

    /* renamed from: j */
    protected int[] f1597j;

    /* renamed from: k */
    protected int[] f1598k;

    /* renamed from: l */
    String[] f1599l;

    /* renamed from: m */
    private int f1600m = -1;

    /* renamed from: n */
    private CursorToStringConverter f1601n;

    /* renamed from: o */
    private ViewBinder f1602o;

    /* renamed from: android.support.v4.widget.SimpleCursorAdapter$CursorToStringConverter */
    public interface CursorToStringConverter {
        CharSequence convertToString(Cursor cursor);
    }

    /* renamed from: android.support.v4.widget.SimpleCursorAdapter$ViewBinder */
    public interface ViewBinder {
        boolean setViewValue(View view, Cursor cursor, int i);
    }

    @Deprecated
    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String[] strArr, int[] iArr) {
        super(context, i, cursor);
        this.f1598k = iArr;
        this.f1599l = strArr;
        m1135a(strArr);
    }

    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String[] strArr, int[] iArr, int i2) {
        super(context, i, cursor, i2);
        this.f1598k = iArr;
        this.f1599l = strArr;
        m1135a(strArr);
    }

    /* renamed from: a */
    private void m1135a(String[] strArr) {
        if (this.f1431c != null) {
            int length = strArr.length;
            if (this.f1597j == null || this.f1597j.length != length) {
                this.f1597j = new int[length];
            }
            for (int i = 0; i < length; i++) {
                this.f1597j[i] = this.f1431c.getColumnIndexOrThrow(strArr[i]);
            }
            return;
        }
        this.f1597j = null;
    }

    public void bindView(View view, Context context, Cursor cursor) {
        ViewBinder viewBinder = this.f1602o;
        int length = this.f1598k.length;
        int[] iArr = this.f1597j;
        int[] iArr2 = this.f1598k;
        for (int i = 0; i < length; i++) {
            View findViewById = view.findViewById(iArr2[i]);
            if (findViewById != null) {
                if (viewBinder != null ? viewBinder.setViewValue(findViewById, cursor, iArr[i]) : false) {
                    continue;
                } else {
                    String string = cursor.getString(iArr[i]);
                    if (string == null) {
                        string = "";
                    }
                    if (findViewById instanceof TextView) {
                        setViewText((TextView) findViewById, string);
                    } else if (findViewById instanceof ImageView) {
                        setViewImage((ImageView) findViewById, string);
                    } else {
                        throw new IllegalStateException(findViewById.getClass().getName() + " is not a " + " view that can be bounds by this SimpleCursorAdapter");
                    }
                }
            }
        }
    }

    public void changeCursorAndColumns(Cursor cursor, String[] strArr, int[] iArr) {
        this.f1599l = strArr;
        this.f1598k = iArr;
        super.changeCursor(cursor);
        m1135a(this.f1599l);
    }

    public CharSequence convertToString(Cursor cursor) {
        return this.f1601n != null ? this.f1601n.convertToString(cursor) : this.f1600m > -1 ? cursor.getString(this.f1600m) : super.convertToString(cursor);
    }

    public CursorToStringConverter getCursorToStringConverter() {
        return this.f1601n;
    }

    public int getStringConversionColumn() {
        return this.f1600m;
    }

    public ViewBinder getViewBinder() {
        return this.f1602o;
    }

    public void setCursorToStringConverter(CursorToStringConverter cursorToStringConverter) {
        this.f1601n = cursorToStringConverter;
    }

    public void setStringConversionColumn(int i) {
        this.f1600m = i;
    }

    public void setViewBinder(ViewBinder viewBinder) {
        this.f1602o = viewBinder;
    }

    public void setViewImage(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void setViewText(TextView textView, String str) {
        textView.setText(str);
    }

    public Cursor swapCursor(Cursor cursor) {
        Cursor swapCursor = super.swapCursor(cursor);
        m1135a(this.f1599l);
        return swapCursor;
    }
}
