package android.support.p000v4.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.support.p000v4.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.content.Loader */
public class Loader {
    boolean mAbandoned = false;
    boolean mContentChanged = false;
    Context mContext;
    int mId;
    OnLoadCompleteListener mListener;
    boolean mProcessingChange = false;
    boolean mReset = true;
    boolean mStarted = false;

    /* renamed from: android.support.v4.content.Loader$ForceLoadContentObserver */
    public final class ForceLoadContentObserver extends ContentObserver {
        public ForceLoadContentObserver() {
            super(new Handler());
        }

        public final boolean deliverSelfNotifications() {
            return true;
        }

        public final void onChange(boolean z) {
            Loader.this.onContentChanged();
        }
    }

    /* renamed from: android.support.v4.content.Loader$OnLoadCompleteListener */
    public interface OnLoadCompleteListener {
        void onLoadComplete(Loader loader, Object obj);
    }

    public Loader(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void abandon() {
        this.mAbandoned = true;
        onAbandon();
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    public String dataToString(Object obj) {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(obj, sb);
        sb.append("}");
        return sb.toString();
    }

    public void deliverResult(Object obj) {
        if (this.mListener != null) {
            this.mListener.onLoadComplete(this, obj);
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mListener=");
        printWriter.println(this.mListener);
        if (this.mStarted || this.mContentChanged || this.mProcessingChange) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.mStarted);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.mContentChanged);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.mProcessingChange);
        }
        if (this.mAbandoned || this.mReset) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.mAbandoned);
            printWriter.print(" mReset=");
            printWriter.println(this.mReset);
        }
    }

    public void forceLoad() {
        onForceLoad();
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    /* access modifiers changed from: protected */
    public void onAbandon() {
    }

    public void onContentChanged() {
        if (this.mStarted) {
            forceLoad();
        } else {
            this.mContentChanged = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onForceLoad() {
    }

    /* access modifiers changed from: protected */
    public void onReset() {
    }

    /* access modifiers changed from: protected */
    public void onStartLoading() {
    }

    /* access modifiers changed from: protected */
    public void onStopLoading() {
    }

    public void registerListener(int i, OnLoadCompleteListener onLoadCompleteListener) {
        if (this.mListener != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.mListener = onLoadCompleteListener;
        this.mId = i;
    }

    public void reset() {
        onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    public void rollbackContentChanged() {
        if (this.mProcessingChange) {
            this.mContentChanged = true;
        }
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    public boolean takeContentChanged() {
        boolean z = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= z;
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, sb);
        sb.append(" id=");
        sb.append(this.mId);
        sb.append("}");
        return sb.toString();
    }

    public void unregisterListener(OnLoadCompleteListener onLoadCompleteListener) {
        if (this.mListener == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.mListener != onLoadCompleteListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.mListener = null;
        }
    }
}
