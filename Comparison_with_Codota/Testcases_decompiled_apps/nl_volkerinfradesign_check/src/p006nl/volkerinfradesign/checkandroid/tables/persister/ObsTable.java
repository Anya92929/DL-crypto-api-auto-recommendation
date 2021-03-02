package p006nl.volkerinfradesign.checkandroid.tables.persister;

import android.content.ContentValues;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.Table;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;
import p006nl.volkerinfradesign.checkandroid.tables.adapters.ColumnAdapter;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.persister.ObsTable */
public class ObsTable extends Table {

    /* renamed from: a */
    private final Hashtable<Class<?>, ColumnAdapter> f4983a;

    public ObsTable(Class<? extends ObsObject> cls) {
        this(cls, cls.getSimpleName());
    }

    public ObsTable(Class<? extends ObsObject> cls, String str) {
        super(str);
        this.f4983a = new Hashtable<>();
    }

    public final void registerAdapter(Class<?> cls, ColumnAdapter columnAdapter) {
        if (this.f4983a.contains(cls)) {
            throw new IllegalArgumentException("There is alreay an adapter for this type");
        }
        this.f4983a.put(cls, columnAdapter);
    }

    /* access modifiers changed from: protected */
    public <T extends ObsObject> T construct(Class<T> cls) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        return (ObsObject) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final <T extends ObsObject> List<T> mo9809a(Class<T> cls, ViTaCursor viTaCursor) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        Field declaredField;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; viTaCursor.moveToPosition(i); i++) {
            T construct = construct(cls);
            for (String str : viTaCursor.getColumnNames()) {
                int columnIndex = viTaCursor.getColumnIndex(str);
                if (!viTaCursor.isNull(columnIndex) && (declaredField = construct.getClass().getDeclaredField(str)) != null) {
                    ColumnAdapter a = m6044a(declaredField);
                    boolean isAccessible = declaredField.isAccessible();
                    declaredField.setAccessible(true);
                    declaredField.set(construct, a.getValue(viTaCursor, columnIndex));
                    declaredField.setAccessible(isAccessible);
                }
            }
            arrayList.add(construct);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final <T extends ObsObject> T mo9811a(Class<T> cls, Key key) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        T t = null;
        ViTaCursor query = query((String[]) null, "_id = ?", new String[]{Long.toString(key.f4979a)}, (String) null, (String) null, (String) null);
        try {
            List<T> a = mo9809a(cls, query);
            if (!a.isEmpty()) {
                t = (ObsObject) a.get(0);
            }
            return t;
        } finally {
            query.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Key mo9810a(ObsObject obsObject, Key key) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        ContentValues contentValues = new ContentValues();
        for (Column column : getColumns()) {
            Field declaredField = obsObject.getClass().getDeclaredField(column.getName());
            int modifiers = declaredField.getModifiers();
            if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers)) {
                ColumnAdapter a = m6044a(declaredField);
                boolean isAccessible = declaredField.isAccessible();
                declaredField.setAccessible(true);
                a.putValue(column.getName(), declaredField.get(obsObject), contentValues);
                declaredField.setAccessible(isAccessible);
            }
        }
        return null;
    }

    /* renamed from: a */
    private ColumnAdapter m6044a(Field field) throws IllegalStateException {
        return null;
    }
}
