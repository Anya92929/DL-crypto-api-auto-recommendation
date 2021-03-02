package p006nl.volkerinfradesign.checkandroid.data;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;
import p006nl.volkerinfradesign.checkandroid.data.tree.Root;

/* renamed from: nl.volkerinfradesign.checkandroid.data.StructuresDir */
public class StructuresDir {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Comparator<String> f4707a = new Comparator<String>() {
        /* renamed from: a */
        public int compare(String str, String str2) {
            if (str.equals(str2)) {
                return 0;
            }
            String replace = str.replace("structure_", "");
            String replace2 = str2.replace("structure_", "");
            return Integer.valueOf(replace2.substring(0, replace2.length() - 4)).compareTo(Integer.valueOf(replace.substring(0, replace.length() - 4)));
        }
    };

    /* renamed from: b */
    private final File f4708b;

    StructuresDir(File file) {
        this.f4708b = new File(file, "structures");
    }

    public File getDir() {
        if (!this.f4708b.exists()) {
            this.f4708b.mkdir();
        }
        return this.f4708b;
    }

    public Root loadRecent() {
        TreeMap treeMap = new TreeMap();
        for (File file : getDir().listFiles()) {
            String replace = file.getName().replace("structure_", "");
            treeMap.put(Integer.valueOf(replace.substring(0, replace.length() - 4)), file);
        }
        if (treeMap.isEmpty()) {
            return null;
        }
        return (Root) SystemUtils.load(Root.class, (File) treeMap.lastEntry().getValue());
    }

    public File newFile() {
        TreeSet treeSet = new TreeSet();
        for (String replace : getDir().list()) {
            String replace2 = replace.replace("structure_", "");
            treeSet.add(Integer.valueOf(replace2.substring(0, replace2.length() - 4)));
        }
        return new File(getDir(), "structure_" + (treeSet.isEmpty() ? 1 : ((Integer) Collections.max(treeSet)).intValue() + 1) + ".ser");
    }

    public void removeOld() {
        final File dir = getDir();
        C13802 r3 = new ArrayList<String>() {
            {
                TreeSet treeSet = new TreeSet(StructuresDir.f4707a);
                Collections.addAll(treeSet, dir.list());
                addAll(treeSet);
            }
        };
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 < r3.size()) {
                new File(dir, (String) r3.get(i2)).delete();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void save(Root root) {
        SystemUtils.save(root, root.getFile());
    }

    public boolean isEmpty() {
        return getDir().list().length == 0;
    }
}
