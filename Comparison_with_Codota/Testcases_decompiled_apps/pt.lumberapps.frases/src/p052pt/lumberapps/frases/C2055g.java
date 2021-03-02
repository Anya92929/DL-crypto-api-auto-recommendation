package p052pt.lumberapps.frases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

/* renamed from: pt.lumberapps.frases.g */
public class C2055g extends SQLiteOpenHelper {

    /* renamed from: a */
    private static String f7745a = "favoritas";

    public C2055g(Context context) {
        super(context, "Frases", (SQLiteDatabase.CursorFactory) null, 2);
    }

    /* renamed from: a */
    public ArrayList mo10196a() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor rawQuery = writableDatabase.rawQuery("SELECT  * FROM " + f7745a, (String[]) null);
        if (rawQuery.moveToFirst()) {
            do {
                C2038ar arVar = new C2038ar();
                arVar.mo10184c(rawQuery.getString(0));
                arVar.mo10182b(rawQuery.getString(1));
                arVar.mo10180a(rawQuery.getString(2));
                arrayList.add(arVar);
            } while (rawQuery.moveToNext());
        }
        writableDatabase.close();
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2038ar mo10197a(String str) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor query = readableDatabase.query(f7745a, new String[]{"id", "frase", "Autor"}, "frase=?", new String[]{str}, (String) null, (String) null, (String) null, (String) null);
        if (query != null) {
            query.moveToFirst();
        }
        C2038ar arVar = new C2038ar(query.getString(0), query.getString(1), query.getString(2));
        readableDatabase.close();
        return arVar;
    }

    /* renamed from: a */
    public void mo10198a(C2038ar arVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("frase", arVar.mo10181b());
        contentValues.put("Autor", arVar.mo10179a());
        contentValues.put("quatro", arVar.mo10183c());
        writableDatabase.insert(f7745a, (String) null, contentValues);
        writableDatabase.close();
    }

    /* renamed from: b */
    public void mo10199b(C2038ar arVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete(f7745a, "frase = ?", new String[]{String.valueOf(arVar.mo10181b())});
        writableDatabase.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE " + f7745a + "(" + "id" + " INTEGER PRIMARY KEY," + "frase" + " TEXT," + "Autor" + " TEXT," + "quatro" + " TEXT," + "cinco" + " TEXT" + ")");
        sQLiteDatabase.execSQL("CREATE TABLE OUTRA(id INTEGER PRIMARY KEY,frase TEXT,Autor TEXT,quatro TEXT,cinco TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + f7745a);
        onCreate(sQLiteDatabase);
    }
}
