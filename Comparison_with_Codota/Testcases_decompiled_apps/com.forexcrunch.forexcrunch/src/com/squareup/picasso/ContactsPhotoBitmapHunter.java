package com.squareup.picasso;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;

class ContactsPhotoBitmapHunter extends BitmapHunter {
    final Context context;

    ContactsPhotoBitmapHunter(Context context2, Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action) {
        super(picasso, dispatcher, cache, stats, action);
        this.context = context2;
    }

    /* access modifiers changed from: package-private */
    public Bitmap decode(Request data) throws IOException {
        InputStream is = null;
        try {
            is = getInputStream();
            return decodeStream(is, data);
        } finally {
            Utils.closeQuietly(is);
        }
    }

    /* access modifiers changed from: package-private */
    public Picasso.LoadedFrom getLoadedFrom() {
        return Picasso.LoadedFrom.DISK;
    }

    private InputStream getInputStream() throws IOException {
        ContentResolver contentResolver = this.context.getContentResolver();
        Uri uri = getData().uri;
        if (uri.toString().startsWith(ContactsContract.Contacts.CONTENT_LOOKUP_URI.toString()) && (uri = ContactsContract.Contacts.lookupContact(contentResolver, uri)) == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 14) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri);
        }
        return ContactPhotoStreamIcs.get(contentResolver, uri);
    }

    /* JADX INFO: finally extract failed */
    private Bitmap decodeStream(InputStream stream, Request data) throws IOException {
        if (stream == null) {
            return null;
        }
        BitmapFactory.Options options = null;
        if (data.hasSize()) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            InputStream is = getInputStream();
            try {
                BitmapFactory.decodeStream(is, (Rect) null, options);
                Utils.closeQuietly(is);
                calculateInSampleSize(data.targetWidth, data.targetHeight, options);
            } catch (Throwable th) {
                Utils.closeQuietly(is);
                throw th;
            }
        }
        return BitmapFactory.decodeStream(stream, (Rect) null, options);
    }

    @TargetApi(14)
    private static class ContactPhotoStreamIcs {
        private ContactPhotoStreamIcs() {
        }

        static InputStream get(ContentResolver contentResolver, Uri uri) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
    }
}
