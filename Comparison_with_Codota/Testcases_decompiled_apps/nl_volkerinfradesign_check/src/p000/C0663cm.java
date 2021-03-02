package p000;

import android.net.Uri;
import android.support.p001v4.provider.DocumentFile;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: cm */
public class C0663cm extends DocumentFile {

    /* renamed from: a */
    private File f2438a;

    public C0663cm(DocumentFile documentFile, File file) {
        super(documentFile);
        this.f2438a = file;
    }

    public DocumentFile createFile(String str, String str2) {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType != null) {
            str2 = str2 + "." + extensionFromMimeType;
        }
        File file = new File(this.f2438a, str2);
        try {
            file.createNewFile();
            return new C0663cm(this, file);
        } catch (IOException e) {
            Log.w("DocumentFile", "Failed to createFile: " + e);
            return null;
        }
    }

    public DocumentFile createDirectory(String str) {
        File file = new File(this.f2438a, str);
        if (file.isDirectory() || file.mkdir()) {
            return new C0663cm(this, file);
        }
        return null;
    }

    public Uri getUri() {
        return Uri.fromFile(this.f2438a);
    }

    public String getName() {
        return this.f2438a.getName();
    }

    public String getType() {
        if (this.f2438a.isDirectory()) {
            return null;
        }
        return m3608a(this.f2438a.getName());
    }

    public boolean isDirectory() {
        return this.f2438a.isDirectory();
    }

    public boolean isFile() {
        return this.f2438a.isFile();
    }

    public long lastModified() {
        return this.f2438a.lastModified();
    }

    public long length() {
        return this.f2438a.length();
    }

    public boolean canRead() {
        return this.f2438a.canRead();
    }

    public boolean canWrite() {
        return this.f2438a.canWrite();
    }

    public boolean delete() {
        m3609a(this.f2438a);
        return this.f2438a.delete();
    }

    public boolean exists() {
        return this.f2438a.exists();
    }

    public DocumentFile[] listFiles() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = this.f2438a.listFiles();
        if (listFiles != null) {
            for (File cmVar : listFiles) {
                arrayList.add(new C0663cm(this, cmVar));
            }
        }
        return (DocumentFile[]) arrayList.toArray(new DocumentFile[arrayList.size()]);
    }

    public boolean renameTo(String str) {
        File file = new File(this.f2438a.getParentFile(), str);
        if (!this.f2438a.renameTo(file)) {
            return false;
        }
        this.f2438a = file;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(r2.substring(r0 + 1).toLowerCase());
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m3608a(java.lang.String r2) {
        /*
            r0 = 46
            int r0 = r2.lastIndexOf(r0)
            if (r0 < 0) goto L_0x001d
            int r0 = r0 + 1
            java.lang.String r0 = r2.substring(r0)
            java.lang.String r0 = r0.toLowerCase()
            android.webkit.MimeTypeMap r1 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r0 = r1.getMimeTypeFromExtension(r0)
            if (r0 == 0) goto L_0x001d
        L_0x001c:
            return r0
        L_0x001d:
            java.lang.String r0 = "application/octet-stream"
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0663cm.m3608a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private static boolean m3609a(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    z &= m3609a(file2);
                }
                if (!file2.delete()) {
                    Log.w("DocumentFile", "Failed to delete " + file2);
                    z = false;
                }
            }
        }
        return z;
    }
}
