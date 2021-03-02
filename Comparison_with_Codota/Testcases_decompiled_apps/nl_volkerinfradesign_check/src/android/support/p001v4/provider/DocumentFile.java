package android.support.p001v4.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import java.io.File;

/* renamed from: android.support.v4.provider.DocumentFile */
public abstract class DocumentFile {

    /* renamed from: a */
    private final DocumentFile f815a;

    public abstract boolean canRead();

    public abstract boolean canWrite();

    public abstract DocumentFile createDirectory(String str);

    public abstract DocumentFile createFile(String str, String str2);

    public abstract boolean delete();

    public abstract boolean exists();

    public abstract String getName();

    public abstract String getType();

    public abstract Uri getUri();

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract long lastModified();

    public abstract long length();

    public abstract DocumentFile[] listFiles();

    public abstract boolean renameTo(String str);

    public DocumentFile(DocumentFile documentFile) {
        this.f815a = documentFile;
    }

    public static DocumentFile fromFile(File file) {
        return new C0663cm((DocumentFile) null, file);
    }

    public static DocumentFile fromSingleUri(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT >= 19) {
            return new C0664cn((DocumentFile) null, context, uri);
        }
        return null;
    }

    public static DocumentFile fromTreeUri(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new C0665co((DocumentFile) null, context, C0662cl.m3604a(uri));
        }
        return null;
    }

    public static boolean isDocumentUri(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT >= 19) {
            return C0661ck.m3590a(context, uri);
        }
        return false;
    }

    public DocumentFile getParentFile() {
        return this.f815a;
    }

    public DocumentFile findFile(String str) {
        for (DocumentFile documentFile : listFiles()) {
            if (str.equals(documentFile.getName())) {
                return documentFile;
            }
        }
        return null;
    }
}
