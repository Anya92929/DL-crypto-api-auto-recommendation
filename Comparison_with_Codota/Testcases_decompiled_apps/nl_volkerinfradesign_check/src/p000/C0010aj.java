package p000;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;

/* renamed from: aj */
public class C0010aj {
    /* renamed from: a */
    public static Cursor m19a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, Object obj) {
        return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) obj);
    }

    /* renamed from: a */
    public static boolean m20a(Exception exc) {
        return exc instanceof OperationCanceledException;
    }
}
