package com.google.zxing.client.android.share;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Browser;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import com.google.android.gms.plus.PlusShare;

public final class BookmarkPickerActivity extends ListActivity {
    private static final String[] BOOKMARK_PROJECTION = {PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, PlusShare.KEY_CALL_TO_ACTION_URL};
    private static final String BOOKMARK_SELECTION = "bookmark = 1 AND url IS NOT NULL";
    private static final String TAG = BookmarkPickerActivity.class.getSimpleName();
    static final int TITLE_COLUMN = 0;
    static final int URL_COLUMN = 1;
    private Cursor cursor;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        this.cursor = getContentResolver().query(Browser.BOOKMARKS_URI, BOOKMARK_PROJECTION, BOOKMARK_SELECTION, (String[]) null, (String) null);
        if (this.cursor == null) {
            Log.w(TAG, "No cursor returned for bookmark query");
            finish();
            return;
        }
        setListAdapter(new BookmarkAdapter(this, this.cursor));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.cursor != null) {
            this.cursor.close();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onListItemClick(ListView l, View view, int position, long id) {
        if (this.cursor.isClosed() || !this.cursor.moveToPosition(position)) {
            setResult(0);
        } else {
            Intent intent = new Intent();
            intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
            intent.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.cursor.getString(0));
            intent.putExtra(PlusShare.KEY_CALL_TO_ACTION_URL, this.cursor.getString(1));
            setResult(-1, intent);
        }
        finish();
    }
}
