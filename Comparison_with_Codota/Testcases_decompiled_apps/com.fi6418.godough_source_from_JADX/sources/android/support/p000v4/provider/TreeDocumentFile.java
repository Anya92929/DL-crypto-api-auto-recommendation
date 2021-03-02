package android.support.p000v4.provider;

import android.content.Context;
import android.net.Uri;

/* renamed from: android.support.v4.provider.TreeDocumentFile */
class TreeDocumentFile extends DocumentFile {

    /* renamed from: a */
    private Context f1051a;

    /* renamed from: b */
    private Uri f1052b;

    TreeDocumentFile(DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.f1051a = context;
        this.f1052b = uri;
    }

    public boolean canRead() {
        return DocumentsContractApi19.canRead(this.f1051a, this.f1052b);
    }

    public boolean canWrite() {
        return DocumentsContractApi19.canWrite(this.f1051a, this.f1052b);
    }

    public DocumentFile createDirectory(String str) {
        Uri createDirectory = DocumentsContractApi21.createDirectory(this.f1051a, this.f1052b, str);
        if (createDirectory != null) {
            return new TreeDocumentFile(this, this.f1051a, createDirectory);
        }
        return null;
    }

    public DocumentFile createFile(String str, String str2) {
        Uri createFile = DocumentsContractApi21.createFile(this.f1051a, this.f1052b, str, str2);
        if (createFile != null) {
            return new TreeDocumentFile(this, this.f1051a, createFile);
        }
        return null;
    }

    public boolean delete() {
        return DocumentsContractApi19.delete(this.f1051a, this.f1052b);
    }

    public boolean exists() {
        return DocumentsContractApi19.exists(this.f1051a, this.f1052b);
    }

    public String getName() {
        return DocumentsContractApi19.getName(this.f1051a, this.f1052b);
    }

    public String getType() {
        return DocumentsContractApi19.getType(this.f1051a, this.f1052b);
    }

    public Uri getUri() {
        return this.f1052b;
    }

    public boolean isDirectory() {
        return DocumentsContractApi19.isDirectory(this.f1051a, this.f1052b);
    }

    public boolean isFile() {
        return DocumentsContractApi19.isFile(this.f1051a, this.f1052b);
    }

    public long lastModified() {
        return DocumentsContractApi19.lastModified(this.f1051a, this.f1052b);
    }

    public long length() {
        return DocumentsContractApi19.length(this.f1051a, this.f1052b);
    }

    public DocumentFile[] listFiles() {
        Uri[] listFiles = DocumentsContractApi21.listFiles(this.f1051a, this.f1052b);
        DocumentFile[] documentFileArr = new DocumentFile[listFiles.length];
        for (int i = 0; i < listFiles.length; i++) {
            documentFileArr[i] = new TreeDocumentFile(this, this.f1051a, listFiles[i]);
        }
        return documentFileArr;
    }

    public boolean renameTo(String str) {
        Uri renameTo = DocumentsContractApi21.renameTo(this.f1051a, this.f1052b, str);
        if (renameTo == null) {
            return false;
        }
        this.f1052b = renameTo;
        return true;
    }
}
