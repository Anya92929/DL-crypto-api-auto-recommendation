package android.support.p001v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* renamed from: android.support.v4.widget.SimpleCursorAdapter */
public class SimpleCursorAdapter extends ResourceCursorAdapter {

    /* renamed from: a */
    String[] f1293a;

    /* renamed from: b */
    private int f1294b = -1;

    /* renamed from: c */
    private CursorToStringConverter f1295c;

    /* renamed from: d */
    private ViewBinder f1296d;
    protected int[] mFrom;
    protected int[] mTo;

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
        this.mTo = iArr;
        this.f1293a = strArr;
        m2739a(strArr);
    }

    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String[] strArr, int[] iArr, int i2) {
        super(context, i, cursor, i2);
        this.mTo = iArr;
        this.f1293a = strArr;
        m2739a(strArr);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        boolean z;
        ViewBinder viewBinder = this.f1296d;
        int length = this.mTo.length;
        int[] iArr = this.mFrom;
        int[] iArr2 = this.mTo;
        for (int i = 0; i < length; i++) {
            View findViewById = view.findViewById(iArr2[i]);
            if (findViewById != null) {
                if (viewBinder != null) {
                    z = viewBinder.setViewValue(findViewById, cursor, iArr[i]);
                } else {
                    z = false;
                }
                if (z) {
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

    public ViewBinder getViewBinder() {
        return this.f1296d;
    }

    public void setViewBinder(ViewBinder viewBinder) {
        this.f1296d = viewBinder;
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

    public int getStringConversionColumn() {
        return this.f1294b;
    }

    public void setStringConversionColumn(int i) {
        this.f1294b = i;
    }

    public CursorToStringConverter getCursorToStringConverter() {
        return this.f1295c;
    }

    public void setCursorToStringConverter(CursorToStringConverter cursorToStringConverter) {
        this.f1295c = cursorToStringConverter;
    }

    public CharSequence convertToString(Cursor cursor) {
        if (this.f1295c != null) {
            return this.f1295c.convertToString(cursor);
        }
        if (this.f1294b > -1) {
            return cursor.getString(this.f1294b);
        }
        return super.convertToString(cursor);
    }

    /* renamed from: a */
    private void m2739a(String[] strArr) {
        if (this.mCursor != null) {
            int length = strArr.length;
            if (this.mFrom == null || this.mFrom.length != length) {
                this.mFrom = new int[length];
            }
            for (int i = 0; i < length; i++) {
                this.mFrom[i] = this.mCursor.getColumnIndexOrThrow(strArr[i]);
            }
            return;
        }
        this.mFrom = null;
    }

    public Cursor swapCursor(Cursor cursor) {
        Cursor swapCursor = super.swapCursor(cursor);
        m2739a(this.f1293a);
        return swapCursor;
    }

    public void changeCursorAndColumns(Cursor cursor, String[] strArr, int[] iArr) {
        this.f1293a = strArr;
        this.mTo = iArr;
        super.changeCursor(cursor);
        m2739a(this.f1293a);
    }
}
