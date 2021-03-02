package p000;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;

/* renamed from: ck */
public class C0661ck {
    /* renamed from: a */
    public static boolean m3590a(Context context, Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }

    /* renamed from: b */
    public static String m3591b(Context context, Uri uri) {
        return m3588a(context, uri, "_display_name", (String) null);
    }

    /* renamed from: l */
    private static String m3601l(Context context, Uri uri) {
        return m3588a(context, uri, "mime_type", (String) null);
    }

    /* renamed from: c */
    public static String m3592c(Context context, Uri uri) {
        String l = m3601l(context, uri);
        if ("vnd.android.document/directory".equals(l)) {
            return null;
        }
        return l;
    }

    /* renamed from: d */
    public static boolean m3593d(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(m3601l(context, uri));
    }

    /* renamed from: e */
    public static boolean m3594e(Context context, Uri uri) {
        String l = m3601l(context, uri);
        if ("vnd.android.document/directory".equals(l) || TextUtils.isEmpty(l)) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public static long m3595f(Context context, Uri uri) {
        return m3587a(context, uri, "last_modified", 0);
    }

    /* renamed from: g */
    public static long m3596g(Context context, Uri uri) {
        return m3587a(context, uri, "_size", 0);
    }

    /* renamed from: h */
    public static boolean m3597h(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(m3601l(context, uri))) {
            return true;
        }
        return false;
    }

    /* renamed from: i */
    public static boolean m3598i(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String l = m3601l(context, uri);
        int a = m3586a(context, uri, "flags", 0);
        if (TextUtils.isEmpty(l)) {
            return false;
        }
        if ((a & 4) != 0) {
            return true;
        }
        if ("vnd.android.document/directory".equals(l) && (a & 8) != 0) {
            return true;
        }
        if (TextUtils.isEmpty(l) || (a & 2) == 0) {
            return false;
        }
        return true;
    }

    /* renamed from: j */
    public static boolean m3599j(Context context, Uri uri) {
        return DocumentsContract.deleteDocument(context.getContentResolver(), uri);
    }

    /* renamed from: k */
    public static boolean m3600k(Context context, Uri uri) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"document_id"}, (String) null, (String[]) null, (String) null);
            try {
                boolean z = cursor.getCount() > 0;
                m3589a(cursor);
                return z;
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th) {
            th = th;
            cursor = null;
            m3589a(cursor);
            throw th;
        }
        try {
            Log.w("DocumentFile", "Failed query: " + e);
            m3589a(cursor);
            return false;
        } catch (Throwable th2) {
            th = th2;
            m3589a(cursor);
            throw th;
        }
    }

    /* renamed from: a */
    private static String m3588a(Context context, Uri uri, String str, String str2) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{str}, (String) null, (String[]) null, (String) null);
            try {
                if (!cursor.moveToFirst() || cursor.isNull(0)) {
                    m3589a(cursor);
                    return str2;
                }
                str2 = cursor.getString(0);
                m3589a(cursor);
                return str2;
            } catch (Exception e) {
                e = e;
                try {
                    Log.w("DocumentFile", "Failed query: " + e);
                    m3589a(cursor);
                    return str2;
                } catch (Throwable th) {
                    th = th;
                    m3589a(cursor);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            m3589a(cursor);
            throw th;
        }
    }

    /* renamed from: a */
    private static int m3586a(Context context, Uri uri, String str, int i) {
        return (int) m3587a(context, uri, str, (long) i);
    }

    /* renamed from: a */
    private static long m3587a(Context context, Uri uri, String str, long j) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{str}, (String) null, (String[]) null, (String) null);
            try {
                if (!cursor.moveToFirst() || cursor.isNull(0)) {
                    m3589a(cursor);
                    return j;
                }
                j = cursor.getLong(0);
                m3589a(cursor);
                return j;
            } catch (Exception e) {
                e = e;
                try {
                    Log.w("DocumentFile", "Failed query: " + e);
                    m3589a(cursor);
                    return j;
                } catch (Throwable th) {
                    th = th;
                    m3589a(cursor);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            m3589a(cursor);
            throw th;
        }
    }

    /* renamed from: a */
    private static void m3589a(AutoCloseable autoCloseable) {
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
