package org.apache.commons.p009io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.p009io.FilenameUtils;
import org.apache.commons.p009io.IOCase;

/* renamed from: org.apache.commons.io.comparator.ExtensionFileComparator */
public class ExtensionFileComparator extends C1327jn implements Serializable {
    public static final Comparator<File> EXTENSION_COMPARATOR = new ExtensionFileComparator();
    public static final Comparator<File> EXTENSION_INSENSITIVE_COMPARATOR = new ExtensionFileComparator(IOCase.INSENSITIVE);
    public static final Comparator<File> EXTENSION_INSENSITIVE_REVERSE = new C1328jo(EXTENSION_INSENSITIVE_COMPARATOR);
    public static final Comparator<File> EXTENSION_REVERSE = new C1328jo(EXTENSION_COMPARATOR);
    public static final Comparator<File> EXTENSION_SYSTEM_COMPARATOR = new ExtensionFileComparator(IOCase.SYSTEM);
    public static final Comparator<File> EXTENSION_SYSTEM_REVERSE = new C1328jo(EXTENSION_SYSTEM_COMPARATOR);

    /* renamed from: a */
    private final IOCase f6853a;

    public /* bridge */ /* synthetic */ List sort(List list) {
        return super.sort((List<File>) list);
    }

    public /* bridge */ /* synthetic */ File[] sort(File[] fileArr) {
        return super.sort(fileArr);
    }

    public ExtensionFileComparator() {
        this.f6853a = IOCase.SENSITIVE;
    }

    public ExtensionFileComparator(IOCase iOCase) {
        this.f6853a = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public int compare(File file, File file2) {
        return this.f6853a.checkCompareTo(FilenameUtils.getExtension(file.getName()), FilenameUtils.getExtension(file2.getName()));
    }

    public String toString() {
        return super.toString() + "[caseSensitivity=" + this.f6853a + "]";
    }
}
