package p006nl.volkerinfradesign.checkandroid.tables;

import android.content.Context;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.Settings */
public final class Settings {

    /* renamed from: a */
    final Context f4951a;

    /* renamed from: b */
    String f4952b = "database_name";

    /* renamed from: c */
    int f4953c = 1;

    /* renamed from: d */
    boolean f4954d = false;

    /* renamed from: e */
    OnVersionChangedListener f4955e;

    /* renamed from: nl.volkerinfradesign.checkandroid.tables.Settings$Action */
    public enum Action {
        NOTHING,
        WIPE
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.tables.Settings$OnVersionChangedListener */
    public interface OnVersionChangedListener {
        public static final OnVersionChangedListener WIPE_INSTANCE = new OnVersionChangedListener() {
            public Action onDowngrade(int i, int i2) {
                return Action.WIPE;
            }

            public Action onUpgrade(int i, int i2) {
                return Action.WIPE;
            }
        };

        Action onDowngrade(int i, int i2);

        Action onUpgrade(int i, int i2);
    }

    public Settings(Context context) {
        this.f4951a = context;
    }

    public Settings setDatabaseName(String str) {
        this.f4952b = str;
        return this;
    }

    public Settings setDebug() {
        this.f4954d = true;
        return this;
    }

    public Settings setOnVersionChangedListener(OnVersionChangedListener onVersionChangedListener) {
        this.f4955e = onVersionChangedListener;
        return this;
    }

    public Settings setVersion(int i) {
        this.f4953c = i;
        return this;
    }
}
