package android.support.p000v4.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.p000v4.content.Loader;
import android.support.p000v4.p002os.CancellationSignal;
import android.support.p000v4.p002os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* renamed from: android.support.v4.content.CursorLoader */
public class CursorLoader extends AsyncTaskLoader<Cursor> {

    /* renamed from: f */
    final Loader<Cursor>.ForceLoadContentObserver f724f = new Loader.ForceLoadContentObserver();

    /* renamed from: g */
    Uri f725g;

    /* renamed from: h */
    String[] f726h;

    /* renamed from: i */
    String f727i;

    /* renamed from: j */
    String[] f728j;

    /* renamed from: k */
    String f729k;

    /* renamed from: l */
    Cursor f730l;

    /* renamed from: m */
    CancellationSignal f731m;

    public CursorLoader(Context context) {
        super(context);
    }

    public CursorLoader(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context);
        this.f725g = uri;
        this.f726h = strArr;
        this.f727i = str;
        this.f728j = strArr2;
        this.f729k = str2;
    }

    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        synchronized (this) {
            if (this.f731m != null) {
                this.f731m.cancel();
            }
        }
    }

    public void deliverResult(Cursor cursor) {
        if (!isReset()) {
            Cursor cursor2 = this.f730l;
            this.f730l = cursor;
            if (isStarted()) {
                super.deliverResult(cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f725g);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f726h));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f727i);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f728j));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f729k);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f730l);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.f746u);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo1158e() {
        if (this.f730l != null) {
            deliverResult(this.f730l);
        }
        if (takeContentChanged() || this.f730l == null) {
            forceLoad();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo1159f() {
        cancelLoad();
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo1160g() {
        super.mo1160g();
        mo1159f();
        if (this.f730l != null && !this.f730l.isClosed()) {
            this.f730l.close();
        }
        this.f730l = null;
    }

    public String[] getProjection() {
        return this.f726h;
    }

    public String getSelection() {
        return this.f727i;
    }

    public String[] getSelectionArgs() {
        return this.f728j;
    }

    public String getSortOrder() {
        return this.f729k;
    }

    public Uri getUri() {
        return this.f725g;
    }

    public Cursor loadInBackground() {
        Cursor query;
        synchronized (this) {
            if (isLoadInBackgroundCanceled()) {
                throw new OperationCanceledException();
            }
            this.f731m = new CancellationSignal();
        }
        try {
            query = ContentResolverCompat.query(getContext().getContentResolver(), this.f725g, this.f726h, this.f727i, this.f728j, this.f729k, this.f731m);
            if (query != null) {
                query.getCount();
                query.registerContentObserver(this.f724f);
            }
            synchronized (this) {
                this.f731m = null;
            }
            return query;
        } catch (RuntimeException e) {
            query.close();
            throw e;
        } catch (Throwable th) {
            synchronized (this) {
                this.f731m = null;
                throw th;
            }
        }
    }

    public void onCanceled(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    public void setProjection(String[] strArr) {
        this.f726h = strArr;
    }

    public void setSelection(String str) {
        this.f727i = str;
    }

    public void setSelectionArgs(String[] strArr) {
        this.f728j = strArr;
    }

    public void setSortOrder(String str) {
        this.f729k = str;
    }

    public void setUri(Uri uri) {
        this.f725g = uri;
    }
}
