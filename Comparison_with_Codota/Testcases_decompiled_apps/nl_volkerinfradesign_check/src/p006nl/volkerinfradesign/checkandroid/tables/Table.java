package p006nl.volkerinfradesign.checkandroid.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.provider.BaseColumns;
import android.util.Log;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.p009io.IOUtils;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.ViTa;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.Table */
public class Table implements BaseColumns {

    /* renamed from: a */
    private String[] f4957a;

    /* renamed from: b */
    final String f4958b;

    /* renamed from: c */
    private boolean f4959c;

    /* renamed from: d */
    private final Map<String, C1253ih> f4960d = new HashMap();

    /* renamed from: e */
    private ViTaCursorFactory f4961e;

    /* renamed from: f */
    private boolean f4962f;

    public Table(String str) {
        this.f4958b = str;
        m6036a("_id", Column.DataType.INTEGER, true).primaryKey().autoIncrement();
    }

    public int delete(String str, String[] strArr) {
        return ViTa.getWritableDatabase().delete(this, str, strArr);
    }

    public final void drop() {
        ViTa.f4965a.f4966b.getWritableDatabase().execSQL("DROP TABLE IF EXISTS " + this.f4958b);
    }

    public Column getColumn(String str) {
        return this.f4960d.get(str);
    }

    public String[] getColumnNames() {
        if (this.f4957a == null) {
            Set<String> keySet = this.f4960d.keySet();
            this.f4957a = (String[]) keySet.toArray(new String[keySet.size()]);
        }
        return this.f4957a;
    }

    public Collection<? extends Column> getColumns() {
        return Collections.unmodifiableCollection(this.f4960d.values());
    }

    public ViTa.Helper getHelper() {
        return ViTa.getHelper();
    }

    public String getName() {
        return this.f4958b;
    }

    public long insert(ContentValues contentValues) {
        return ViTa.getWritableDatabase().insert(this, "_id", contentValues);
    }

    public long insertOrThrow(ContentValues contentValues) {
        return ViTa.getWritableDatabase().insertOrThrow(this, "_id", contentValues);
    }

    public final long insertWithOnConflict(ContentValues contentValues, ViTa.ConflictAlogrithm conflictAlogrithm) {
        return ViTa.getWritableDatabase().insertWithOnConflict(this, "_id", contentValues, conflictAlogrithm);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public final ColumnEditor putColumn(String str, Column.DataType dataType) {
        return m6036a(str, dataType, false);
    }

    public ViTaCursor query(boolean z, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        if (mo8477a()) {
            return ViTa.getReadableDatabase().queryWithFactory(this.f4961e, z, this, strArr, str, strArr2, str2, str3, str4, str5);
        }
        return ViTa.getReadableDatabase().query(this, z, strArr, str, strArr2, str2, str3, str4, str5);
    }

    public ViTaCursor query(String str, String[] strArr, String... strArr2) {
        if (mo8477a()) {
            return ViTa.getReadableDatabase().queryWithFactory(this.f4961e, false, this, strArr2, str, strArr, (String) null, (String) null, (String) null, (String) null);
        }
        return ViTa.getReadableDatabase().query(this, strArr2, str, strArr, (String) null, (String) null, (String) null);
    }

    public ViTaCursor query(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        if (mo8477a()) {
            return ViTa.getReadableDatabase().queryWithFactory(this.f4961e, false, this, strArr, str, strArr2, str2, str3, str4, (String) null);
        }
        return ViTa.getReadableDatabase().query(this, strArr, str, strArr2, str2, str3, str4);
    }

    public ViTaCursor query(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        if (mo8477a()) {
            return ViTa.getReadableDatabase().queryWithFactory(this.f4961e, false, this, strArr, str, strArr2, str2, str3, str4, str5);
        }
        return ViTa.getReadableDatabase().query(this, strArr, str, strArr2, str2, str3, str4, str5);
    }

    public ViTaCursor queryWithFactory(ViTaCursorFactory viTaCursorFactory, boolean z, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        return ViTa.getReadableDatabase().queryWithFactory(viTaCursorFactory, z, this, strArr, str, strArr2, str2, str3, str4, str5);
    }

    public boolean removeColumn(String str) {
        this.f4959c = false;
        if (this.f4960d.remove(str) != null) {
            return true;
        }
        return false;
    }

    public final int size() {
        int i = 0;
        Cursor rawQuery = ViTa.getReadableDatabase().rawQuery("SELECT COUNT (_id) FROM " + this.f4958b, (String[]) null, this);
        try {
            if (rawQuery.moveToFirst()) {
                i = rawQuery.getInt(0);
            }
            return i;
        } finally {
            rawQuery.close();
        }
    }

    public final void synchronize() {
        C1530b bVar;
        if (!this.f4959c) {
            Cursor rawQuery = ViTa.f4965a.f4966b.getReadableDatabase().rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name=?;", new String[]{this.f4958b});
            try {
                if (!rawQuery.moveToFirst()) {
                    ViTa.f4965a.f4966b.getWritableDatabase().execSQL("CREATE TABLE " + getCreationStatement());
                } else {
                    bVar = new C1530b();
                    HashSet hashSet = new HashSet();
                    HashSet hashSet2 = new HashSet();
                    HashSet hashSet3 = new HashSet();
                    C1529a aVar = new C1529a(this.f4960d.values());
                    for (int i = 0; bVar.moveToPosition(i); i++) {
                        String string = bVar.getString(bVar.getColumnIndex("name"));
                        C1253ih ihVar = (C1253ih) getColumn(string);
                        if (ihVar != null) {
                            aVar.remove(ihVar);
                            if (!bVar.equals(ihVar)) {
                                hashSet2.add(string);
                            }
                            if (ihVar.isImportable()) {
                                hashSet3.add(ihVar);
                            }
                        } else {
                            hashSet.add(string);
                        }
                    }
                    if (!hashSet.isEmpty() || !hashSet2.isEmpty() || aVar.mo9764a()) {
                        if (ViTa.f4965a.f4967c.f4954d) {
                            if (!hashSet.isEmpty()) {
                                Log.i(ViTa.LOG_TAG, "removing columns: " + hashSet.toString());
                            }
                            if (!hashSet2.isEmpty()) {
                                Log.i(ViTa.LOG_TAG, "altering columns: " + hashSet2.toString());
                            }
                        }
                    } else if (!aVar.isEmpty()) {
                        if (ViTa.f4965a.f4967c.f4954d) {
                            HashSet hashSet4 = new HashSet();
                            Iterator it = aVar.iterator();
                            while (it.hasNext()) {
                                hashSet4.add(((C1253ih) it.next()).getName());
                            }
                            Log.i(ViTa.LOG_TAG, "adding columns: " + hashSet4.toString());
                        }
                        m6037a((Collection<C1253ih>) aVar);
                    }
                    bVar.close();
                }
                this.f4959c = true;
                rawQuery.close();
            } catch (Throwable th) {
                rawQuery.close();
                throw th;
            }
        }
    }

    public String toString() {
        return this.f4958b + ": " + getColumnNames().toString();
    }

    public int update(ContentValues contentValues, String str, String[] strArr) {
        return ViTa.getWritableDatabase().update(this, contentValues, str, strArr);
    }

    public int updateWithOnConflict(ContentValues contentValues, String str, String[] strArr, ViTa.ConflictAlogrithm conflictAlogrithm) {
        return ViTa.getWritableDatabase().updateWithOnConflict(this, contentValues, str, strArr, conflictAlogrithm);
    }

    /* access modifiers changed from: protected */
    public final String getCreationStatement() {
        return m6035a(this.f4958b);
    }

    public ViTaCursorFactory onCreateDefaultFactory() {
        return null;
    }

    /* renamed from: c */
    public void mo9740c() {
        this.f4959c = false;
        this.f4957a = null;
    }

    /* renamed from: a */
    private void m6037a(Collection<C1253ih> collection) {
        for (C1253ih a : collection) {
            ViTa.f4965a.f4966b.getWritableDatabase().execSQL("ALTER TABLE " + this.f4958b + " ADD COLUMN " + a.mo8545a());
        }
        if (ViTa.f4965a.f4967c.f4954d) {
            mo8480b();
        }
    }

    /* renamed from: a */
    private boolean mo8477a() {
        if (!this.f4962f) {
            this.f4961e = onCreateDefaultFactory();
            this.f4962f = true;
        }
        if (this.f4961e != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private final String m6035a(String str) {
        String str2 = str + " (";
        Iterator<C1253ih> it = this.f4960d.values().iterator();
        while (true) {
            String str3 = str2;
            if (!it.hasNext()) {
                return str3.substring(0, str3.length() - 1) + "\n)";
            }
            str2 = str3 + "\n\t" + ((C1253ih) it.next()).mo8545a() + ",";
        }
    }

    /* renamed from: b */
    private void mo8480b() {
        C1530b bVar = new C1530b();
        try {
            Log.i(ViTa.LOG_TAG, "Execution result:\n\n" + bVar.toString());
        } finally {
            bVar.close();
        }
    }

    /* renamed from: a */
    private ColumnEditor m6036a(String str, Column.DataType dataType, boolean z) {
        if (z || str != "_id") {
            C1253ih ihVar = new C1253ih(this, str, dataType);
            this.f4959c = false;
            this.f4960d.put(str, ihVar);
            return ihVar;
        }
        throw new IllegalArgumentException("The _id columns is added by default and is immutable!");
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.tables.Table$a */
    final class C1529a extends HashSet<C1253ih> {
        private C1529a(Collection<C1253ih> collection) {
            super(collection);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo9764a() {
            Iterator it = iterator();
            while (it.hasNext()) {
                if (((C1253ih) it.next()).isUnique()) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.tables.Table$b */
    class C1530b extends CursorWrapper implements Column {
        public C1530b() {
            super(ViTa.f4965a.f4966b.getWritableDatabase().rawQuery("pragma table_info(" + Table.this.f4958b + ")", (String[]) null));
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Column)) {
                return super.equals(obj);
            }
            Column column = (Column) obj;
            boolean equals = getDefaultValue() == null ? column.getDefaultValue() == null : getDefaultValue().equals(column.getDefaultValue());
            if (getName().equals(column.getName()) && getType().equals(column.getType()) && equals && isNotNull() == column.isNotNull() && isAutoIncrement() == column.isAutoIncrement() && isPrimaryKey() == column.isPrimaryKey() && isUnique() == column.isUnique()) {
                return true;
            }
            return false;
        }

        public String getDefaultValue() {
            return getString(getColumnIndex("dflt_value"));
        }

        public String getName() {
            return getString(getColumnIndex("name"));
        }

        public Table getTable() {
            return Table.this;
        }

        public Column.DataType getType() {
            return Column.DataType.valueOf(getString(getColumnIndex("type")));
        }

        public boolean isAutoIncrement() {
            boolean z = false;
            if (isPrimaryKey()) {
                Cursor rawQuery = ViTa.f4965a.f4966b.getReadableDatabase().rawQuery("SELECT COUNT(*) FROM sqlite_sequence WHERE name=? LIMIT 1", new String[]{Table.this.f4958b});
                try {
                    z = rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            return z;
        }

        public boolean isImportable() {
            throw new UnsupportedOperationException();
        }

        public boolean isNotNull() {
            return getInt(getColumnIndex("notnull")) > 0;
        }

        public boolean isPrimaryKey() {
            return getInt(getColumnIndex("pk")) > 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a0, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a4, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isUnique() {
            /*
                r8 = this;
                r5 = 0
                r0 = 1
                r1 = 0
                nl.volkerinfradesign.checkandroid.tables.ViTa r2 = p006nl.volkerinfradesign.checkandroid.tables.ViTa.f4965a
                nl.volkerinfradesign.checkandroid.tables.ViTa$Helper r2 = r2.f4966b
                android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "pragma index_list("
                java.lang.StringBuilder r3 = r3.append(r4)
                nl.volkerinfradesign.checkandroid.tables.Table r4 = p006nl.volkerinfradesign.checkandroid.tables.Table.this
                java.lang.String r4 = r4.f4958b
                java.lang.StringBuilder r3 = r3.append(r4)
                java.lang.String r4 = ")"
                java.lang.StringBuilder r3 = r3.append(r4)
                java.lang.String r3 = r3.toString()
                android.database.Cursor r4 = r2.rawQuery(r3, r5)
                r3 = r1
            L_0x002d:
                boolean r2 = r4.moveToPosition(r3)     // Catch:{ all -> 0x00a5 }
                if (r2 == 0) goto L_0x00aa
                java.lang.String r2 = "unique"
                int r2 = r4.getColumnIndex(r2)     // Catch:{ all -> 0x00a5 }
                int r2 = r4.getInt(r2)     // Catch:{ all -> 0x00a5 }
                if (r2 <= 0) goto L_0x0094
                r2 = r0
            L_0x0040:
                if (r2 == 0) goto L_0x009c
                java.lang.String r2 = "name"
                int r2 = r4.getColumnIndex(r2)     // Catch:{ all -> 0x00a5 }
                java.lang.String r2 = r4.getString(r2)     // Catch:{ all -> 0x00a5 }
                nl.volkerinfradesign.checkandroid.tables.ViTa r5 = p006nl.volkerinfradesign.checkandroid.tables.ViTa.f4965a     // Catch:{ all -> 0x00a5 }
                nl.volkerinfradesign.checkandroid.tables.ViTa$Helper r5 = r5.f4966b     // Catch:{ all -> 0x00a5 }
                android.database.sqlite.SQLiteDatabase r5 = r5.getReadableDatabase()     // Catch:{ all -> 0x00a5 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a5 }
                r6.<init>()     // Catch:{ all -> 0x00a5 }
                java.lang.String r7 = "pragma index_info("
                java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x00a5 }
                java.lang.StringBuilder r2 = r6.append(r2)     // Catch:{ all -> 0x00a5 }
                java.lang.String r6 = ")"
                java.lang.StringBuilder r2 = r2.append(r6)     // Catch:{ all -> 0x00a5 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00a5 }
                r6 = 0
                android.database.Cursor r5 = r5.rawQuery(r2, r6)     // Catch:{ all -> 0x00a5 }
                r2 = r1
            L_0x0073:
                boolean r6 = r5.moveToPosition(r2)     // Catch:{ all -> 0x00a0 }
                if (r6 == 0) goto L_0x0099
                java.lang.String r6 = "name"
                int r6 = r5.getColumnIndex(r6)     // Catch:{ all -> 0x00a0 }
                java.lang.String r6 = r5.getString(r6)     // Catch:{ all -> 0x00a0 }
                java.lang.String r7 = r8.getName()     // Catch:{ all -> 0x00a0 }
                boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x00a0 }
                if (r6 == 0) goto L_0x0096
                r5.close()     // Catch:{ all -> 0x00a5 }
                r4.close()
            L_0x0093:
                return r0
            L_0x0094:
                r2 = r1
                goto L_0x0040
            L_0x0096:
                int r2 = r2 + 1
                goto L_0x0073
            L_0x0099:
                r5.close()     // Catch:{ all -> 0x00a5 }
            L_0x009c:
                int r2 = r3 + 1
                r3 = r2
                goto L_0x002d
            L_0x00a0:
                r0 = move-exception
                r5.close()     // Catch:{ all -> 0x00a5 }
                throw r0     // Catch:{ all -> 0x00a5 }
            L_0x00a5:
                r0 = move-exception
                r4.close()
                throw r0
            L_0x00aa:
                r4.close()
                r0 = r1
                goto L_0x0093
            */
            throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.tables.Table.C1530b.isUnique():boolean");
        }

        public String toString() {
            String str = "";
            for (int i = 0; moveToPosition(i); i++) {
                str = str + C1253ih.m5544a(this) + IOUtils.LINE_SEPARATOR_UNIX;
            }
            return str.trim();
        }
    }
}
