package org.apache.commons.p009io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* renamed from: org.apache.commons.io.comparator.CompositeFileComparator */
public class CompositeFileComparator extends C1327jn implements Serializable {

    /* renamed from: a */
    private static final Comparator<?>[] f6851a = new Comparator[0];

    /* renamed from: b */
    private final Comparator<File>[] f6852b;

    public /* bridge */ /* synthetic */ List sort(List list) {
        return super.sort((List<File>) list);
    }

    public /* bridge */ /* synthetic */ File[] sort(File[] fileArr) {
        return super.sort(fileArr);
    }

    public CompositeFileComparator(Comparator<File>... comparatorArr) {
        if (comparatorArr == null) {
            this.f6852b = (Comparator[]) f6851a;
            return;
        }
        this.f6852b = (Comparator[]) new Comparator[comparatorArr.length];
        System.arraycopy(comparatorArr, 0, this.f6852b, 0, comparatorArr.length);
    }

    public CompositeFileComparator(Iterable<Comparator<File>> iterable) {
        if (iterable == null) {
            this.f6852b = (Comparator[]) f6851a;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Comparator<File> add : iterable) {
            arrayList.add(add);
        }
        this.f6852b = (Comparator[]) arrayList.toArray(new Comparator[arrayList.size()]);
    }

    public int compare(File file, File file2) {
        int i = 0;
        for (Comparator<File> compare : this.f6852b) {
            i = compare.compare(file, file2);
            if (i != 0) {
                break;
            }
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append('{');
        for (int i = 0; i < this.f6852b.length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(this.f6852b[i]);
        }
        sb.append('}');
        return sb.toString();
    }
}
