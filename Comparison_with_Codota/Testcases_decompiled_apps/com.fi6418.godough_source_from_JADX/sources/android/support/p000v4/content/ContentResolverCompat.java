package android.support.p000v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.p000v4.p002os.CancellationSignal;
import android.support.p000v4.p002os.OperationCanceledException;

/* renamed from: android.support.v4.content.ContentResolverCompat */
public class ContentResolverCompat {

    /* renamed from: a */
    private static final ContentResolverCompatImpl f723a;

    /* renamed from: android.support.v4.content.ContentResolverCompat$ContentResolverCompatImpl */
    interface ContentResolverCompatImpl {
        Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);
    }

    /* renamed from: android.support.v4.content.ContentResolverCompat$ContentResolverCompatImplBase */
    class ContentResolverCompatImplBase implements ContentResolverCompatImpl {
        ContentResolverCompatImplBase() {
        }

        public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            if (cancellationSignal != null) {
                cancellationSignal.throwIfCanceled();
            }
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        }
    }

    /* renamed from: android.support.v4.content.ContentResolverCompat$ContentResolverCompatImplJB */
    class ContentResolverCompatImplJB extends ContentResolverCompatImplBase {
        ContentResolverCompatImplJB() {
        }

        public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            Object obj;
            if (cancellationSignal != null) {
                try {
                    obj = cancellationSignal.getCancellationSignalObject();
                } catch (Exception e) {
                    if (ContentResolverCompatJellybean.m617a(e)) {
                        throw new OperationCanceledException();
                    }
                    throw e;
                }
            } else {
                obj = null;
            }
            return ContentResolverCompatJellybean.query(contentResolver, uri, strArr, str, strArr2, str2, obj);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f723a = new ContentResolverCompatImplJB();
        } else {
            f723a = new ContentResolverCompatImplBase();
        }
    }

    private ContentResolverCompat() {
    }

    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return f723a.query(contentResolver, uri, strArr, str, strArr2, str2, cancellationSignal);
    }
}
