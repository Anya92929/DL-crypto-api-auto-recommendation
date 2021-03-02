package org.apache.commons.p009io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.p009io.FileUtils;

/* renamed from: org.apache.commons.io.comparator.SizeFileComparator */
public class SizeFileComparator extends C1327jn implements Serializable {
    public static final Comparator<File> SIZE_COMPARATOR = new SizeFileComparator();
    public static final Comparator<File> SIZE_REVERSE = new C1328jo(SIZE_COMPARATOR);
    public static final Comparator<File> SIZE_SUMDIR_COMPARATOR = new SizeFileComparator(true);
    public static final Comparator<File> SIZE_SUMDIR_REVERSE = new C1328jo(SIZE_SUMDIR_COMPARATOR);

    /* renamed from: a */
    private final boolean f6856a;

    public /* bridge */ /* synthetic */ List sort(List list) {
        return super.sort((List<File>) list);
    }

    public /* bridge */ /* synthetic */ File[] sort(File[] fileArr) {
        return super.sort(fileArr);
    }

    public SizeFileComparator() {
        this.f6856a = false;
    }

    public SizeFileComparator(boolean z) {
        this.f6856a = z;
    }

    public int compare(File file, File file2) {
        long length;
        long length2;
        if (file.isDirectory()) {
            length = (!this.f6856a || !file.exists()) ? 0 : FileUtils.sizeOfDirectory(file);
        } else {
            length = file.length();
        }
        if (!file2.isDirectory()) {
            length2 = file2.length();
        } else if (!this.f6856a || !file2.exists()) {
            length2 = 0;
        } else {
            length2 = FileUtils.sizeOfDirectory(file2);
        }
        long j = length - length2;
        if (j < 0) {
            return -1;
        }
        if (j > 0) {
            return 1;
        }
        return 0;
    }

    public String toString() {
        return super.toString() + "[sumDirectoryContents=" + this.f6856a + "]";
    }
}
