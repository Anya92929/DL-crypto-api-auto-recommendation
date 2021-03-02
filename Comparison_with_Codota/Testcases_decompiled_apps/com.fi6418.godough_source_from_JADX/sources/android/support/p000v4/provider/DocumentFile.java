package android.support.p000v4.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import java.io.File;

/* renamed from: android.support.v4.provider.DocumentFile */
public abstract class DocumentFile {

    /* renamed from: a */
    private final DocumentFile f1047a;

    DocumentFile(DocumentFile documentFile) {
        this.f1047a = documentFile;
    }

    public static DocumentFile fromFile(File file) {
        return new RawDocumentFile((DocumentFile) null, file);
    }

    public static DocumentFile fromSingleUri(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT >= 19) {
            return new SingleDocumentFile((DocumentFile) null, context, uri);
        }
        return null;
    }

    public static DocumentFile fromTreeUri(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new TreeDocumentFile((DocumentFile) null, context, DocumentsContractApi21.prepareTreeUri(uri));
        }
        return null;
    }

    public static boolean isDocumentUri(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT >= 19) {
            return DocumentsContractApi19.isDocumentUri(context, uri);
        }
        return false;
    }

    public abstract boolean canRead();

    public abstract boolean canWrite();

    public abstract DocumentFile createDirectory(String str);

    public abstract DocumentFile createFile(String str, String str2);

    public abstract boolean delete();

    public abstract boolean exists();

    public DocumentFile findFile(String str) {
        for (DocumentFile documentFile : listFiles()) {
            if (str.equals(documentFile.getName())) {
                return documentFile;
            }
        }
        return null;
    }

    public abstract String getName();

    public DocumentFile getParentFile() {
        return this.f1047a;
    }

    public abstract String getType();

    public abstract Uri getUri();

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract long lastModified();

    public abstract long length();

    public abstract DocumentFile[] listFiles();

    public abstract boolean renameTo(String str);
}
