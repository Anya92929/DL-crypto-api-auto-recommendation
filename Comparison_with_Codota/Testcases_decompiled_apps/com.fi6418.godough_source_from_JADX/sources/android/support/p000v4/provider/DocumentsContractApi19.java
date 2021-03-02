package android.support.p000v4.provider;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;

/* renamed from: android.support.v4.provider.DocumentsContractApi19 */
class DocumentsContractApi19 {
    DocumentsContractApi19() {
    }

    /* renamed from: a */
    private static int m764a(Context context, Uri uri, String str, int i) {
        return (int) m765a(context, uri, str, (long) i);
    }

    /* renamed from: a */
    private static long m765a(Context context, Uri uri, String str, long j) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{str}, (String) null, (String[]) null, (String) null);
            try {
                if (!cursor.moveToFirst() || cursor.isNull(0)) {
                    m768a(cursor);
                    return j;
                }
                j = cursor.getLong(0);
                m768a(cursor);
                return j;
            } catch (Exception e) {
                e = e;
                try {
                    Log.w("DocumentFile", "Failed query: " + e);
                    m768a(cursor);
                    return j;
                } catch (Throwable th) {
                    th = th;
                    m768a(cursor);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            m768a(cursor);
            throw th;
        }
    }

    /* renamed from: a */
    private static String m766a(Context context, Uri uri) {
        return m767a(context, uri, "mime_type", (String) null);
    }

    /* renamed from: a */
    private static String m767a(Context context, Uri uri, String str, String str2) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{str}, (String) null, (String[]) null, (String) null);
            try {
                if (!cursor.moveToFirst() || cursor.isNull(0)) {
                    m768a(cursor);
                    return str2;
                }
                str2 = cursor.getString(0);
                m768a(cursor);
                return str2;
            } catch (Exception e) {
                e = e;
                try {
                    Log.w("DocumentFile", "Failed query: " + e);
                    m768a(cursor);
                    return str2;
                } catch (Throwable th) {
                    th = th;
                    m768a(cursor);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            m768a(cursor);
            throw th;
        }
    }

    /* renamed from: a */
    private static void m768a(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static boolean canRead(Context context, Uri uri) {
        return context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(m766a(context, uri));
    }

    public static boolean canWrite(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String a = m766a(context, uri);
        int a2 = m764a(context, uri, "flags", 0);
        if (TextUtils.isEmpty(a)) {
            return false;
        }
        if ((a2 & 4) != 0) {
            return true;
        }
        if (!"vnd.android.document/directory".equals(a) || (a2 & 8) == 0) {
            return !TextUtils.isEmpty(a) && (a2 & 2) != 0;
        }
        return true;
    }

    public static boolean delete(Context context, Uri uri) {
        return DocumentsContract.deleteDocument(context.getContentResolver(), uri);
    }

    public static boolean exists(Context context, Uri uri) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"document_id"}, (String) null, (String[]) null, (String) null);
            try {
                boolean z = cursor.getCount() > 0;
                m768a(cursor);
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
            m768a(cursor);
            throw th;
        }
        try {
            Log.w("DocumentFile", "Failed query: " + e);
            m768a(cursor);
            return false;
        } catch (Throwable th2) {
            th = th2;
            m768a(cursor);
            throw th;
        }
    }

    public static String getName(Context context, Uri uri) {
        return m767a(context, uri, "_display_name", (String) null);
    }

    public static String getType(Context context, Uri uri) {
        String a = m766a(context, uri);
        if ("vnd.android.document/directory".equals(a)) {
            return null;
        }
        return a;
    }

    public static boolean isDirectory(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(m766a(context, uri));
    }

    public static boolean isDocumentUri(Context context, Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }

    public static boolean isFile(Context context, Uri uri) {
        String a = m766a(context, uri);
        return !"vnd.android.document/directory".equals(a) && !TextUtils.isEmpty(a);
    }

    public static long lastModified(Context context, Uri uri) {
        return m765a(context, uri, "last_modified", 0);
    }

    public static long length(Context context, Uri uri) {
        return m765a(context, uri, "_size", 0);
    }
}
