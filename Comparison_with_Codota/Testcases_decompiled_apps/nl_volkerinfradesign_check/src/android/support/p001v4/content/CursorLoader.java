package android.support.p001v4.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.p001v4.content.Loader;
import android.support.p001v4.p003os.CancellationSignal;
import android.support.p001v4.p003os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* renamed from: android.support.v4.content.CursorLoader */
public class CursorLoader extends AsyncTaskLoader<Cursor> {

    /* renamed from: f */
    final Loader<Cursor>.ForceLoadContentObserver f430f = new Loader.ForceLoadContentObserver();

    /* renamed from: g */
    Uri f431g;

    /* renamed from: h */
    String[] f432h;

    /* renamed from: i */
    String f433i;

    /* renamed from: j */
    String[] f434j;

    /* renamed from: k */
    String f435k;

    /* renamed from: l */
    Cursor f436l;

    /* renamed from: m */
    CancellationSignal f437m;

    public Cursor loadInBackground() {
        Cursor query;
        synchronized (this) {
            if (isLoadInBackgroundCanceled()) {
                throw new OperationCanceledException();
            }
            this.f437m = new CancellationSignal();
        }
        try {
            query = ContentResolverCompat.query(getContext().getContentResolver(), this.f431g, this.f432h, this.f433i, this.f434j, this.f435k, this.f437m);
            if (query != null) {
                query.getCount();
                query.registerContentObserver(this.f430f);
            }
            synchronized (this) {
                this.f437m = null;
            }
            return query;
        } catch (RuntimeException e) {
            query.close();
            throw e;
        } catch (Throwable th) {
            synchronized (this) {
                this.f437m = null;
                throw th;
            }
        }
    }

    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        synchronized (this) {
            if (this.f437m != null) {
                this.f437m.cancel();
            }
        }
    }

    public void deliverResult(Cursor cursor) {
        if (!isReset()) {
            Cursor cursor2 = this.f436l;
            this.f436l = cursor;
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

    public CursorLoader(Context context) {
        super(context);
    }

    public CursorLoader(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context);
        this.f431g = uri;
        this.f432h = strArr;
        this.f433i = str;
        this.f434j = strArr2;
        this.f435k = str2;
    }

    /* access modifiers changed from: protected */
    public void onStartLoading() {
        if (this.f436l != null) {
            deliverResult(this.f436l);
        }
        if (takeContentChanged() || this.f436l == null) {
            forceLoad();
        }
    }

    /* access modifiers changed from: protected */
    public void onStopLoading() {
        cancelLoad();
    }

    public void onCanceled(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        super.onReset();
        onStopLoading();
        if (this.f436l != null && !this.f436l.isClosed()) {
            this.f436l.close();
        }
        this.f436l = null;
    }

    public Uri getUri() {
        return this.f431g;
    }

    public void setUri(Uri uri) {
        this.f431g = uri;
    }

    public String[] getProjection() {
        return this.f432h;
    }

    public void setProjection(String[] strArr) {
        this.f432h = strArr;
    }

    public String getSelection() {
        return this.f433i;
    }

    public void setSelection(String str) {
        this.f433i = str;
    }

    public String[] getSelectionArgs() {
        return this.f434j;
    }

    public void setSelectionArgs(String[] strArr) {
        this.f434j = strArr;
    }

    public String getSortOrder() {
        return this.f435k;
    }

    public void setSortOrder(String str) {
        this.f435k = str;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f431g);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f432h));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f433i);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f434j));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f435k);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f436l);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.f452u);
    }
}
