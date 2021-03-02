package p000;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

/* renamed from: jo */
public class C1328jo extends C1327jn implements Serializable {

    /* renamed from: a */
    private final Comparator<File> f4590a;

    public C1328jo(Comparator<File> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("Delegate comparator is missing");
        }
        this.f4590a = comparator;
    }

    /* renamed from: a */
    public int compare(File file, File file2) {
        return this.f4590a.compare(file2, file);
    }

    public String toString() {
        return super.toString() + "[" + this.f4590a.toString() + "]";
    }
}
