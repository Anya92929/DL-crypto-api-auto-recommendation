package org.apache.commons.p009io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.p009io.IOCase;

/* renamed from: org.apache.commons.io.comparator.PathFileComparator */
public class PathFileComparator extends C1327jn implements Serializable {
    public static final Comparator<File> PATH_COMPARATOR = new PathFileComparator();
    public static final Comparator<File> PATH_INSENSITIVE_COMPARATOR = new PathFileComparator(IOCase.INSENSITIVE);
    public static final Comparator<File> PATH_INSENSITIVE_REVERSE = new C1328jo(PATH_INSENSITIVE_COMPARATOR);
    public static final Comparator<File> PATH_REVERSE = new C1328jo(PATH_COMPARATOR);
    public static final Comparator<File> PATH_SYSTEM_COMPARATOR = new PathFileComparator(IOCase.SYSTEM);
    public static final Comparator<File> PATH_SYSTEM_REVERSE = new C1328jo(PATH_SYSTEM_COMPARATOR);

    /* renamed from: a */
    private final IOCase f6855a;

    public /* bridge */ /* synthetic */ List sort(List list) {
        return super.sort((List<File>) list);
    }

    public /* bridge */ /* synthetic */ File[] sort(File[] fileArr) {
        return super.sort(fileArr);
    }

    public PathFileComparator() {
        this.f6855a = IOCase.SENSITIVE;
    }

    public PathFileComparator(IOCase iOCase) {
        this.f6855a = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public int compare(File file, File file2) {
        return this.f6855a.checkCompareTo(file.getPath(), file2.getPath());
    }

    public String toString() {
        return super.toString() + "[caseSensitivity=" + this.f6855a + "]";
    }
}
