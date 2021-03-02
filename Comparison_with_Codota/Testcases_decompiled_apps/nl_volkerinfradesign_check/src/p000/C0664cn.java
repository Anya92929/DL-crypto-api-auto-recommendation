package p000;

import android.content.Context;
import android.net.Uri;
import android.support.p001v4.provider.DocumentFile;

/* renamed from: cn */
public class C0664cn extends DocumentFile {

    /* renamed from: a */
    private Context f2439a;

    /* renamed from: b */
    private Uri f2440b;

    public C0664cn(DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.f2439a = context;
        this.f2440b = uri;
    }

    public DocumentFile createFile(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    public DocumentFile createDirectory(String str) {
        throw new UnsupportedOperationException();
    }

    public Uri getUri() {
        return this.f2440b;
    }

    public String getName() {
        return C0661ck.m3591b(this.f2439a, this.f2440b);
    }

    public String getType() {
        return C0661ck.m3592c(this.f2439a, this.f2440b);
    }

    public boolean isDirectory() {
        return C0661ck.m3593d(this.f2439a, this.f2440b);
    }

    public boolean isFile() {
        return C0661ck.m3594e(this.f2439a, this.f2440b);
    }

    public long lastModified() {
        return C0661ck.m3595f(this.f2439a, this.f2440b);
    }

    public long length() {
        return C0661ck.m3596g(this.f2439a, this.f2440b);
    }

    public boolean canRead() {
        return C0661ck.m3597h(this.f2439a, this.f2440b);
    }

    public boolean canWrite() {
        return C0661ck.m3598i(this.f2439a, this.f2440b);
    }

    public boolean delete() {
        return C0661ck.m3599j(this.f2439a, this.f2440b);
    }

    public boolean exists() {
        return C0661ck.m3600k(this.f2439a, this.f2440b);
    }

    public DocumentFile[] listFiles() {
        throw new UnsupportedOperationException();
    }

    public boolean renameTo(String str) {
        throw new UnsupportedOperationException();
    }
}
