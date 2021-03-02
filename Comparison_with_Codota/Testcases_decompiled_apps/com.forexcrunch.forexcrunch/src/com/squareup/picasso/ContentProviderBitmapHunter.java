package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;

class ContentProviderBitmapHunter extends ContentStreamBitmapHunter {
    private static final String[] CONTENT_ORIENTATION = {"orientation"};

    ContentProviderBitmapHunter(Context context, Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action) {
        super(context, picasso, dispatcher, cache, stats, action);
    }

    /* access modifiers changed from: package-private */
    public Bitmap decode(Request data) throws IOException {
        setExifRotation(getContentProviderExifRotation(this.context.getContentResolver(), data.uri));
        return super.decodeContentStream(data);
    }

    static int getContentProviderExifRotation(ContentResolver contentResolver, Uri uri) {
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(uri, CONTENT_ORIENTATION, (String) null, (String[]) null, (String) null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return 0;
            }
            int i = cursor.getInt(0);
            if (cursor == null) {
                return i;
            }
            cursor.close();
            return i;
        } catch (RuntimeException e) {
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
