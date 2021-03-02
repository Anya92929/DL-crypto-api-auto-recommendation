package org.apache.commons.p009io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.p009io.IOCase;

/* renamed from: org.apache.commons.io.comparator.NameFileComparator */
public class NameFileComparator extends C1327jn implements Serializable {
    public static final Comparator<File> NAME_COMPARATOR = new NameFileComparator();
    public static final Comparator<File> NAME_INSENSITIVE_COMPARATOR = new NameFileComparator(IOCase.INSENSITIVE);
    public static final Comparator<File> NAME_INSENSITIVE_REVERSE = new C1328jo(NAME_INSENSITIVE_COMPARATOR);
    public static final Comparator<File> NAME_REVERSE = new C1328jo(NAME_COMPARATOR);
    public static final Comparator<File> NAME_SYSTEM_COMPARATOR = new NameFileComparator(IOCase.SYSTEM);
    public static final Comparator<File> NAME_SYSTEM_REVERSE = new C1328jo(NAME_SYSTEM_COMPARATOR);

    /* renamed from: a */
    private final IOCase f6854a;

    public /* bridge */ /* synthetic */ List sort(List list) {
        return super.sort((List<File>) list);
    }

    public /* bridge */ /* synthetic */ File[] sort(File[] fileArr) {
        return super.sort(fileArr);
    }

    public NameFileComparator() {
        this.f6854a = IOCase.SENSITIVE;
    }

    public NameFileComparator(IOCase iOCase) {
        this.f6854a = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public int compare(File file, File file2) {
        return this.f6854a.checkCompareTo(file.getName(), file2.getName());
    }

    public String toString() {
        return super.toString() + "[caseSensitivity=" + this.f6854a + "]";
    }
}
