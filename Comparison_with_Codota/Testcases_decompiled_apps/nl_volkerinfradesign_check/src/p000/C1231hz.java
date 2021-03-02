package p000;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.p009io.IOUtils;
import p006nl.volkerinfradesign.checkandroid.data.tree.FormItem;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemType;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemsTable;

/* renamed from: hz */
public final class C1231hz implements InspectionItemConstants {

    /* renamed from: a */
    private final ListOrderedMap<String, C1234a> f4345a = new ListOrderedMap<>();

    /* renamed from: b */
    private final SQLiteDatabase f4346b;

    /* renamed from: a */
    public static C1231hz m5486a(SQLiteDatabase sQLiteDatabase, long j, long j2, AtomicInteger atomicInteger, long j3) {
        C1231hz hzVar = new C1231hz(sQLiteDatabase);
        hzVar.m5491a("title", "Projecten");
        hzVar.m5488a("description");
        hzVar.m5489a(InspectionItemConstants.ORDINAL, (Integer) 0);
        if (atomicInteger.get() != -1) {
            hzVar.m5489a(InspectionItemConstants.PARENT_ORDINAL, Integer.valueOf(atomicInteger.get()));
        } else {
            hzVar.m5488a(InspectionItemConstants.PARENT_ORDINAL);
        }
        hzVar.m5491a(InspectionItemConstants.RECORD_TYPE, InspectionItemsTable.RecordType.CUSTOM_ITEM.name());
        hzVar.m5488a("form_item_server_id");
        hzVar.m5490a(InspectionItemConstants.INSPECTION_ID, Long.valueOf(j));
        hzVar.m5488a(InspectionItemConstants.DESCRIPTIVE_IMAGE_URL);
        hzVar.m5492a(InspectionItemConstants.INAPPLICABLE_POSSIBLE, false);
        hzVar.m5489a(InspectionItemConstants.REQUIRED, (Integer) 1);
        hzVar.m5490a("creation_date", Long.valueOf(j2));
        hzVar.m5490a("mod_date", Long.valueOf(j2));
        hzVar.m5492a(InspectionItemConstants.LOCATION_REQUIRED, false);
        hzVar.m5492a(InspectionItemConstants.PICTURE_REQUIRED, false);
        hzVar.m5491a(InspectionItemConstants.INSPECTION_ITEM_TYPE, InspectionItemType.PROJECTS.name());
        hzVar.m5488a(InspectionItemConstants.CHOICES);
        hzVar.m5491a(InspectionItemConstants.GUID, UUID.randomUUID().toString());
        hzVar.m5488a(InspectionItemConstants.ACTION_IDS);
        hzVar.m5488a("form_item_server_id");
        hzVar.m5490a("root_inspection_id", Long.valueOf(j3));
        hzVar.m5488a(InspectionItemConstants.HYPERLINKS);
        return hzVar;
    }

    /* renamed from: a */
    public static C1231hz m5487a(SQLiteDatabase sQLiteDatabase, FormItem formItem, int i, AtomicInteger atomicInteger, long j, long j2, long j3, String str) {
        C1231hz hzVar = new C1231hz(sQLiteDatabase);
        hzVar.m5491a("title", formItem.getTitle());
        hzVar.m5491a("description", formItem.getDescription());
        hzVar.m5489a(InspectionItemConstants.ORDINAL, Integer.valueOf(i));
        if (formItem.getType() == InspectionItemType.HEADER) {
            hzVar.m5488a(InspectionItemConstants.PARENT_ORDINAL);
            hzVar.m5491a(InspectionItemConstants.RECORD_TYPE, InspectionItemsTable.RecordType.HEADER.name());
            atomicInteger.set(i);
        } else {
            if (atomicInteger.get() != -1) {
                hzVar.m5489a(InspectionItemConstants.PARENT_ORDINAL, Integer.valueOf(atomicInteger.get()));
            } else {
                hzVar.m5488a(InspectionItemConstants.PARENT_ORDINAL);
            }
            hzVar.m5491a(InspectionItemConstants.RECORD_TYPE, InspectionItemsTable.RecordType.ITEM.name());
        }
        if (str != null) {
            hzVar.m5491a(InspectionItemConstants.INSPECTION_ITEM_VALUE, str);
        }
        hzVar.m5490a("form_item_server_id", Long.valueOf(formItem.getServerId()));
        hzVar.m5490a(InspectionItemConstants.INSPECTION_ID, Long.valueOf(j));
        hzVar.m5491a(InspectionItemConstants.DESCRIPTIVE_IMAGE_URL, formItem.getImageUrl());
        hzVar.m5492a(InspectionItemConstants.INAPPLICABLE_POSSIBLE, formItem.isInapplicablePossible());
        hzVar.m5492a(InspectionItemConstants.REQUIRED, formItem.isRequired());
        hzVar.m5490a("creation_date", Long.valueOf(j2));
        hzVar.m5490a("mod_date", Long.valueOf(j2));
        hzVar.m5492a(InspectionItemConstants.LOCATION_REQUIRED, formItem.isLocationRequired());
        hzVar.m5492a(InspectionItemConstants.PICTURE_REQUIRED, formItem.isPhotoRequired());
        hzVar.m5491a(InspectionItemConstants.INSPECTION_ITEM_TYPE, formItem.getType().name());
        hzVar.m5491a(InspectionItemConstants.CHOICES, formItem.getChoices());
        hzVar.m5491a(InspectionItemConstants.GUID, UUID.randomUUID().toString());
        hzVar.m5493a(InspectionItemConstants.ACTION_IDS, formItem.getActions());
        hzVar.m5490a("form_item_server_id", Long.valueOf(formItem.getServerId()));
        hzVar.m5490a("root_inspection_id", Long.valueOf(j3));
        hzVar.m5491a(InspectionItemConstants.HYPERLINKS, formItem.getHyperlinks());
        return hzVar;
    }

    /* renamed from: a */
    public static C1231hz m5485a(SQLiteDatabase sQLiteDatabase, long j, long j2, long j3) {
        C1231hz hzVar = new C1231hz(sQLiteDatabase);
        hzVar.m5491a("title", "Dummy Header");
        hzVar.m5491a("description", "I am a dummy header and I must be invisible.");
        hzVar.m5489a(InspectionItemConstants.ORDINAL, (Integer) 0);
        hzVar.m5488a(InspectionItemConstants.PARENT_ORDINAL);
        hzVar.m5491a(InspectionItemConstants.RECORD_TYPE, InspectionItemsTable.RecordType.DUMMY_HEADER.name());
        hzVar.m5488a("form_item_server_id");
        hzVar.m5490a(InspectionItemConstants.INSPECTION_ID, Long.valueOf(j));
        hzVar.m5488a(InspectionItemConstants.DESCRIPTIVE_IMAGE_URL);
        hzVar.m5492a(InspectionItemConstants.INAPPLICABLE_POSSIBLE, false);
        hzVar.m5492a(InspectionItemConstants.REQUIRED, false);
        hzVar.m5490a("creation_date", Long.valueOf(j2));
        hzVar.m5490a("mod_date", Long.valueOf(j2));
        hzVar.m5492a(InspectionItemConstants.LOCATION_REQUIRED, false);
        hzVar.m5492a(InspectionItemConstants.PICTURE_REQUIRED, false);
        hzVar.m5491a(InspectionItemConstants.INSPECTION_ITEM_TYPE, InspectionItemType.HEADER.name());
        hzVar.m5488a(InspectionItemConstants.CHOICES);
        hzVar.m5491a(InspectionItemConstants.GUID, UUID.randomUUID().toString());
        hzVar.m5488a(InspectionItemConstants.ACTION_IDS);
        hzVar.m5488a("form_item_server_id");
        hzVar.m5490a("root_inspection_id", Long.valueOf(j3));
        hzVar.m5488a(InspectionItemConstants.HYPERLINKS);
        return hzVar;
    }

    private C1231hz(SQLiteDatabase sQLiteDatabase) {
        this.f4346b = sQLiteDatabase;
    }

    public String toString() {
        String str = "{\n";
        Iterator<Map.Entry<String, C1234a>> it = this.f4345a.entrySet().iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2 + "}";
            }
            Map.Entry next = it.next();
            str = str2 + "\t" + ((String) next.getKey()) + " = " + next.getValue() + IOUtils.LINE_SEPARATOR_UNIX;
        }
    }

    /* renamed from: a */
    public long mo8432a() {
        int i = 0;
        SQLiteStatement compileStatement = this.f4346b.compileStatement(String.format("insert into %s (%s)\nvalues\n(%s);", new Object[]{InspectionItemConstants.TABLE_NAME, m5495c(), m5494b()}));
        List<C1234a> valueList = this.f4345a.valueList();
        while (true) {
            int i2 = i;
            if (i2 >= valueList.size()) {
                return compileStatement.executeInsert();
            }
            valueList.get(i2).mo8434a(compileStatement, i2 + 1);
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    private void m5493a(String str, long[] jArr) {
        String str2;
        if (jArr != null) {
            JsonArray jsonArray = new JsonArray();
            for (long valueOf : jArr) {
                jsonArray.add(new JsonPrimitive((Number) Long.valueOf(valueOf)));
            }
            str2 = jsonArray.toString();
        } else {
            str2 = null;
        }
        m5491a(str, str2);
    }

    /* renamed from: a */
    private void m5491a(String str, final String str2) {
        this.f4345a.put(str, new C1234a(str2) {
            /* renamed from: a */
            public void mo8434a(SQLiteStatement sQLiteStatement, int i) {
                if (str2 != null) {
                    if (StringUtils.isNotBlank(str2)) {
                        str2.replaceAll("'", "'");
                    }
                    sQLiteStatement.bindString(i, str2);
                    return;
                }
                sQLiteStatement.bindNull(i);
            }
        });
    }

    /* renamed from: a */
    private void m5490a(String str, final Long l) {
        this.f4345a.put(str, new C1234a(l) {
            /* renamed from: a */
            public void mo8434a(SQLiteStatement sQLiteStatement, int i) {
                if (l != null) {
                    sQLiteStatement.bindLong(i, l.longValue());
                } else {
                    sQLiteStatement.bindNull(i);
                }
            }
        });
    }

    /* renamed from: a */
    private void m5492a(String str, boolean z) {
        m5489a(str, Integer.valueOf(z ? 1 : 0));
    }

    /* renamed from: a */
    private void m5488a(String str) {
        m5491a(str, (String) null);
    }

    /* renamed from: a */
    private void m5489a(String str, Integer num) {
        m5490a(str, num != null ? Long.valueOf(num.longValue()) : null);
    }

    /* renamed from: b */
    private String m5494b() {
        boolean z;
        int size = this.f4345a.size();
        String str = "";
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                z = true;
            } else {
                z = false;
            }
            str = str + (z ? "?" : "?,");
        }
        return str;
    }

    /* renamed from: c */
    private String m5495c() {
        boolean z;
        List<String> keyList = this.f4345a.keyList();
        String str = "\n\t";
        int i = 0;
        while (i < keyList.size()) {
            if (i == keyList.size() - 1) {
                z = true;
            } else {
                z = false;
            }
            i++;
            str = (str + keyList.get(i)) + (z ? IOUtils.LINE_SEPARATOR_UNIX : ",\n\t");
        }
        return str;
    }

    /* renamed from: hz$a */
    abstract class C1234a {

        /* renamed from: a */
        private final Object f4351a;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo8434a(SQLiteStatement sQLiteStatement, int i);

        C1234a(Object obj) {
            this.f4351a = obj;
        }

        public final String toString() {
            if (this.f4351a != null) {
                return this.f4351a.toString();
            }
            return null;
        }
    }
}
