package p000;

import java.io.Serializable;
import java.util.Comparator;
import p006nl.volkerinfradesign.checkandroid.data.tree.Folder;

/* renamed from: hx */
public class C1224hx implements Serializable, Comparator<Folder> {
    private static final long serialVersionUID = -9185724230482487329L;

    /* renamed from: a */
    public int compare(Folder folder, Folder folder2) {
        if (folder.equals(folder2)) {
            return 0;
        }
        int compareToIgnoreCase = folder.getTitle().compareToIgnoreCase(folder2.getTitle());
        switch (compareToIgnoreCase) {
            case 0:
                return Long.valueOf(folder.getServerId()).compareTo(Long.valueOf(folder2.getServerId()));
            default:
                return compareToIgnoreCase;
        }
    }
}
