package android.support.p021v7.p022a;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListView;

/* renamed from: android.support.v7.a.y */
class C0503y extends CursorAdapter {

    /* renamed from: a */
    final /* synthetic */ ListView f870a;

    /* renamed from: b */
    final /* synthetic */ C0495q f871b;

    /* renamed from: c */
    final /* synthetic */ C0501w f872c;

    /* renamed from: d */
    private final int f873d;

    /* renamed from: e */
    private final int f874e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0503y(C0501w wVar, Context context, Cursor cursor, boolean z, ListView listView, C0495q qVar) {
        super(context, cursor, z);
        this.f872c = wVar;
        this.f870a = listView;
        this.f871b = qVar;
        Cursor cursor2 = getCursor();
        this.f873d = cursor2.getColumnIndexOrThrow(this.f872c.f837I);
        this.f874e = cursor2.getColumnIndexOrThrow(this.f872c.f838J);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f873d));
        this.f870a.setItemChecked(cursor.getPosition(), cursor.getInt(this.f874e) == 1);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f872c.f843b.inflate(this.f871b.f784I, viewGroup, false);
    }
}
