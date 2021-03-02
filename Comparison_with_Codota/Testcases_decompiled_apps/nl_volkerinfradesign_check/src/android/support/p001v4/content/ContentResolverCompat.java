package android.support.p001v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.p001v4.p003os.CancellationSignal;
import android.support.p001v4.p003os.OperationCanceledException;

/* renamed from: android.support.v4.content.ContentResolverCompat */
public class ContentResolverCompat {

    /* renamed from: a */
    private static final C0106a f429a;

    /* renamed from: android.support.v4.content.ContentResolverCompat$a */
    interface C0106a {
        /* renamed from: a */
        Cursor mo784a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);
    }

    /* renamed from: android.support.v4.content.ContentResolverCompat$b */
    static class C0107b implements C0106a {
        C0107b() {
        }

        /* renamed from: a */
        public Cursor mo784a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            if (cancellationSignal != null) {
                cancellationSignal.throwIfCanceled();
            }
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        }
    }

    /* renamed from: android.support.v4.content.ContentResolverCompat$c */
    static class C0108c extends C0107b {
        C0108c() {
        }

        /* renamed from: a */
        public Cursor mo784a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            Object obj;
            if (cancellationSignal != null) {
                try {
                    obj = cancellationSignal.getCancellationSignalObject();
                } catch (Exception e) {
                    if (C0010aj.m20a(e)) {
                        throw new OperationCanceledException();
                    }
                    throw e;
                }
            } else {
                obj = null;
            }
            return C0010aj.m19a(contentResolver, uri, strArr, str, strArr2, str2, obj);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f429a = new C0108c();
        } else {
            f429a = new C0107b();
        }
    }

    private ContentResolverCompat() {
    }

    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return f429a.mo784a(contentResolver, uri, strArr, str, strArr2, str2, cancellationSignal);
    }
}
