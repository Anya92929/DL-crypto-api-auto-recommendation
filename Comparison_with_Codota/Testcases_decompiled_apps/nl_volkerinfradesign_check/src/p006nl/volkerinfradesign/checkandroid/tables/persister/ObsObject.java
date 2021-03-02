package p006nl.volkerinfradesign.checkandroid.tables.persister;

import java.util.Hashtable;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.persister.ObsObject */
public class ObsObject {

    /* renamed from: a */
    static final Hashtable<Class<? extends ObsObject>, ObsTable> f4980a = new Hashtable<>();

    /* renamed from: b */
    private final ObsTable f4981b;

    /* renamed from: c */
    private Key f4982c;

    public ObsObject() {
        Class<?> cls = getClass();
        ObsTable obsTable = f4980a.get(cls);
        if (obsTable == null) {
            this.f4981b = new ObsTable(cls);
            f4980a.put(cls, getTable());
            return;
        }
        this.f4981b = obsTable;
    }

    public static <T extends ObsObject> T load(Class<T> cls, Key key) {
        try {
            return f4980a.get(cls).mo9811a(cls, key);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean save() {
        try {
            this.f4982c = getTable().mo9810a(this, this.f4982c);
            return true;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return false;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public final ObsTable getTable() {
        return this.f4981b;
    }

    public final Key getKey() {
        return this.f4982c;
    }

    public final boolean hasKey() {
        return this.f4982c != null;
    }
}
