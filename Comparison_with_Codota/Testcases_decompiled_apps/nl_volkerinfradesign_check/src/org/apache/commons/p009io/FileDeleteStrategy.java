package org.apache.commons.p009io;

import java.io.File;
import java.io.IOException;

/* renamed from: org.apache.commons.io.FileDeleteStrategy */
public class FileDeleteStrategy {
    public static final FileDeleteStrategy FORCE = new C1945a();
    public static final FileDeleteStrategy NORMAL = new FileDeleteStrategy("Normal");

    /* renamed from: a */
    private final String f6834a;

    protected FileDeleteStrategy(String str) {
        this.f6834a = str;
    }

    public boolean deleteQuietly(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        try {
            return doDelete(file);
        } catch (IOException e) {
            return false;
        }
    }

    public void delete(File file) throws IOException {
        if (file.exists() && !doDelete(file)) {
            throw new IOException("Deletion failed: " + file);
        }
    }

    /* access modifiers changed from: protected */
    public boolean doDelete(File file) throws IOException {
        return file.delete();
    }

    public String toString() {
        return "FileDeleteStrategy[" + this.f6834a + "]";
    }

    /* renamed from: org.apache.commons.io.FileDeleteStrategy$a */
    static class C1945a extends FileDeleteStrategy {
        C1945a() {
            super("Force");
        }

        /* access modifiers changed from: protected */
        public boolean doDelete(File file) throws IOException {
            FileUtils.forceDelete(file);
            return true;
        }
    }
}
