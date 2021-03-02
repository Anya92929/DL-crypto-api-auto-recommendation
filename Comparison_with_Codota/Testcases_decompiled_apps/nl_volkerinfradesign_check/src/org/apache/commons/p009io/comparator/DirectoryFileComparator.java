package org.apache.commons.p009io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

/* renamed from: org.apache.commons.io.comparator.DirectoryFileComparator */
public class DirectoryFileComparator extends C1327jn implements Serializable {
    public static final Comparator<File> DIRECTORY_COMPARATOR = new DirectoryFileComparator();
    public static final Comparator<File> DIRECTORY_REVERSE = new C1328jo(DIRECTORY_COMPARATOR);

    public /* bridge */ /* synthetic */ List sort(List list) {
        return super.sort((List<File>) list);
    }

    public /* bridge */ /* synthetic */ File[] sort(File[] fileArr) {
        return super.sort(fileArr);
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public int compare(File file, File file2) {
        return m7285a(file) - m7285a(file2);
    }

    /* renamed from: a */
    private int m7285a(File file) {
        if (file.isDirectory()) {
            return 1;
        }
        return 2;
    }
}
