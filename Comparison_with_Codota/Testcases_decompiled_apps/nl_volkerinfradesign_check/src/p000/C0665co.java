package p000;

import android.content.Context;
import android.net.Uri;
import android.support.p001v4.provider.DocumentFile;

/* renamed from: co */
public class C0665co extends DocumentFile {

    /* renamed from: a */
    private Context f2441a;

    /* renamed from: b */
    private Uri f2442b;

    public C0665co(DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.f2441a = context;
        this.f2442b = uri;
    }

    public DocumentFile createFile(String str, String str2) {
        Uri a = C0662cl.m3603a(this.f2441a, this.f2442b, str, str2);
        if (a != null) {
            return new C0665co(this, this.f2441a, a);
        }
        return null;
    }

    public DocumentFile createDirectory(String str) {
        Uri a = C0662cl.m3602a(this.f2441a, this.f2442b, str);
        if (a != null) {
            return new C0665co(this, this.f2441a, a);
        }
        return null;
    }

    public Uri getUri() {
        return this.f2442b;
    }

    public String getName() {
        return C0661ck.m3591b(this.f2441a, this.f2442b);
    }

    public String getType() {
        return C0661ck.m3592c(this.f2441a, this.f2442b);
    }

    public boolean isDirectory() {
        return C0661ck.m3593d(this.f2441a, this.f2442b);
    }

    public boolean isFile() {
        return C0661ck.m3594e(this.f2441a, this.f2442b);
    }

    public long lastModified() {
        return C0661ck.m3595f(this.f2441a, this.f2442b);
    }

    public long length() {
        return C0661ck.m3596g(this.f2441a, this.f2442b);
    }

    public boolean canRead() {
        return C0661ck.m3597h(this.f2441a, this.f2442b);
    }

    public boolean canWrite() {
        return C0661ck.m3598i(this.f2441a, this.f2442b);
    }

    public boolean delete() {
        return C0661ck.m3599j(this.f2441a, this.f2442b);
    }

    public boolean exists() {
        return C0661ck.m3600k(this.f2441a, this.f2442b);
    }

    public DocumentFile[] listFiles() {
        Uri[] a = C0662cl.m3606a(this.f2441a, this.f2442b);
        DocumentFile[] documentFileArr = new DocumentFile[a.length];
        for (int i = 0; i < a.length; i++) {
            documentFileArr[i] = new C0665co(this, this.f2441a, a[i]);
        }
        return documentFileArr;
    }

    public boolean renameTo(String str) {
        Uri b = C0662cl.m3607b(this.f2441a, this.f2442b, str);
        if (b == null) {
            return false;
        }
        this.f2442b = b;
        return true;
    }
}
