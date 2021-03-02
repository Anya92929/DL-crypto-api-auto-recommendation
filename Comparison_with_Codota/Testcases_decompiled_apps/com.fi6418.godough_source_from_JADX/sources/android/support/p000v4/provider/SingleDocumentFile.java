package android.support.p000v4.provider;

import android.content.Context;
import android.net.Uri;

/* renamed from: android.support.v4.provider.SingleDocumentFile */
class SingleDocumentFile extends DocumentFile {

    /* renamed from: a */
    private Context f1049a;

    /* renamed from: b */
    private Uri f1050b;

    SingleDocumentFile(DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.f1049a = context;
        this.f1050b = uri;
    }

    public boolean canRead() {
        return DocumentsContractApi19.canRead(this.f1049a, this.f1050b);
    }

    public boolean canWrite() {
        return DocumentsContractApi19.canWrite(this.f1049a, this.f1050b);
    }

    public DocumentFile createDirectory(String str) {
        throw new UnsupportedOperationException();
    }

    public DocumentFile createFile(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    public boolean delete() {
        return DocumentsContractApi19.delete(this.f1049a, this.f1050b);
    }

    public boolean exists() {
        return DocumentsContractApi19.exists(this.f1049a, this.f1050b);
    }

    public String getName() {
        return DocumentsContractApi19.getName(this.f1049a, this.f1050b);
    }

    public String getType() {
        return DocumentsContractApi19.getType(this.f1049a, this.f1050b);
    }

    public Uri getUri() {
        return this.f1050b;
    }

    public boolean isDirectory() {
        return DocumentsContractApi19.isDirectory(this.f1049a, this.f1050b);
    }

    public boolean isFile() {
        return DocumentsContractApi19.isFile(this.f1049a, this.f1050b);
    }

    public long lastModified() {
        return DocumentsContractApi19.lastModified(this.f1049a, this.f1050b);
    }

    public long length() {
        return DocumentsContractApi19.length(this.f1049a, this.f1050b);
    }

    public DocumentFile[] listFiles() {
        throw new UnsupportedOperationException();
    }

    public boolean renameTo(String str) {
        throw new UnsupportedOperationException();
    }
}
