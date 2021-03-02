package p006nl.volkerinfradesign.checkandroid.data.tree;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* renamed from: nl.volkerinfradesign.checkandroid.data.tree.Item */
public abstract class Item implements Serializable {
    private static final long serialVersionUID = 1130793677342261585L;

    /* renamed from: a */
    private final Calendar f4745a = GregorianCalendar.getInstance(Locale.ROOT);

    /* renamed from: b */
    private final Calendar f4746b = GregorianCalendar.getInstance(Locale.ROOT);

    /* renamed from: c */
    private final long f4747c;

    /* renamed from: d */
    private final String f4748d;

    /* renamed from: e */
    private final String f4749e;

    Item(String str, String str2, long j) {
        this.f4748d = str;
        this.f4749e = str2;
        this.f4747c = j;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Item) {
            return Long.valueOf(((Item) obj).getServerId()).equals(Long.valueOf(getServerId()));
        }
        return super.equals(obj);
    }

    public final Calendar getCreationDate() {
        return this.f4745a;
    }

    public final String getDescription() {
        return this.f4749e;
    }

    public final Calendar getModifiedDate() {
        return this.f4746b;
    }

    public final long getServerId() {
        return this.f4747c;
    }

    public final String getTitle() {
        return this.f4748d;
    }

    public final boolean isModifiedSince(Date date) {
        return this.f4746b.getTime().compareTo(date) >= 0 || this.f4745a.getTime().compareTo(date) >= 0;
    }
}
