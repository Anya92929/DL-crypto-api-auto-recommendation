package p000;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import java.util.ArrayList;

/* renamed from: cl */
public class C0662cl {
    /* renamed from: a */
    public static Uri m3603a(Context context, Uri uri, String str, String str2) {
        return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
    }

    /* renamed from: a */
    public static Uri m3602a(Context context, Uri uri, String str) {
        return m3603a(context, uri, "vnd.android.document/directory", str);
    }

    /* renamed from: a */
    public static Uri m3604a(Uri uri) {
        return DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri));
    }

    /* renamed from: a */
    public static Uri[] m3606a(Context context, Uri uri) {
        Cursor cursor;
        ContentResolver contentResolver = context.getContentResolver();
        Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        try {
            cursor = contentResolver.query(buildChildDocumentsUriUsingTree, new String[]{"document_id"}, (String) null, (String[]) null, (String) null);
            while (cursor.moveToNext()) {
                try {
                    arrayList.add(DocumentsContract.buildDocumentUriUsingTree(uri, cursor.getString(0)));
                } catch (Exception e) {
                    e = e;
                    try {
                        Log.w("DocumentFile", "Failed query: " + e);
                        m3605a((AutoCloseable) cursor);
                        return (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
                    } catch (Throwable th) {
                        th = th;
                        m3605a((AutoCloseable) cursor);
                        throw th;
                    }
                }
            }
            m3605a((AutoCloseable) cursor);
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            m3605a((AutoCloseable) cursor);
            throw th;
        }
        return (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
    }

    /* renamed from: b */
    public static Uri m3607b(Context context, Uri uri, String str) {
        return DocumentsContract.renameDocument(context.getContentResolver(), uri, str);
    }

    /* renamed from: a */
    private static void m3605a(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }
}
