package android.support.p000v4.provider;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: android.support.v4.provider.RawDocumentFile */
class RawDocumentFile extends DocumentFile {

    /* renamed from: a */
    private File f1048a;

    RawDocumentFile(DocumentFile documentFile, File file) {
        super(documentFile);
        this.f1048a = file;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(r2.substring(r0 + 1).toLowerCase());
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m770a(java.lang.String r2) {
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.provider.RawDocumentFile.m770a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private static boolean m771a(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    z &= m771a(file2);
                }
                if (!file2.delete()) {
                    Log.w("DocumentFile", "Failed to delete " + file2);
                    z = false;
                }
            }
        }
        return z;
    }

    public boolean canRead() {
        return this.f1048a.canRead();
    }

    public boolean canWrite() {
        return this.f1048a.canWrite();
    }

    public DocumentFile createDirectory(String str) {
        File file = new File(this.f1048a, str);
        if (file.isDirectory() || file.mkdir()) {
            return new RawDocumentFile(this, file);
        }
        return null;
    }

    public DocumentFile createFile(String str, String str2) {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType != null) {
            str2 = str2 + "." + extensionFromMimeType;
        }
        File file = new File(this.f1048a, str2);
        try {
            file.createNewFile();
            return new RawDocumentFile(this, file);
        } catch (IOException e) {
            Log.w("DocumentFile", "Failed to createFile: " + e);
            return null;
        }
    }

    public boolean delete() {
        m771a(this.f1048a);
        return this.f1048a.delete();
    }

    public boolean exists() {
        return this.f1048a.exists();
    }

    public String getName() {
        return this.f1048a.getName();
    }

    public String getType() {
        if (this.f1048a.isDirectory()) {
            return null;
        }
        return m770a(this.f1048a.getName());
    }

    public Uri getUri() {
        return Uri.fromFile(this.f1048a);
    }

    public boolean isDirectory() {
        return this.f1048a.isDirectory();
    }

    public boolean isFile() {
        return this.f1048a.isFile();
    }

    public long lastModified() {
        return this.f1048a.lastModified();
    }

    public long length() {
        return this.f1048a.length();
    }

    public DocumentFile[] listFiles() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = this.f1048a.listFiles();
        if (listFiles != null) {
            for (File rawDocumentFile : listFiles) {
                arrayList.add(new RawDocumentFile(this, rawDocumentFile));
            }
        }
        return (DocumentFile[]) arrayList.toArray(new DocumentFile[arrayList.size()]);
    }

    public boolean renameTo(String str) {
        File file = new File(this.f1048a.getParentFile(), str);
        if (!this.f1048a.renameTo(file)) {
            return false;
        }
        this.f1048a = file;
        return true;
    }
}
