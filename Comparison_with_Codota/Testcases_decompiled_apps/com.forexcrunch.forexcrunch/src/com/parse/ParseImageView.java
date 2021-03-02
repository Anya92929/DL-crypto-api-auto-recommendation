package com.parse;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ParseImageView extends ImageView {
    /* access modifiers changed from: private */
    public ParseFile file;
    private boolean isLoaded = false;
    private Drawable placeholder;

    public ParseImageView(Context context) {
        super(context);
    }

    public ParseImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ParseImageView(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (this.file != null) {
            this.file.cancel();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.isLoaded = true;
    }

    public void setPlaceholder(Drawable placeholder2) {
        this.placeholder = placeholder2;
        if (!this.isLoaded) {
            setImageDrawable(this.placeholder);
        }
    }

    public void setParseFile(ParseFile file2) {
        if (this.file != null) {
            this.file.cancel();
        }
        this.isLoaded = false;
        this.file = file2;
        setImageDrawable(this.placeholder);
    }

    public void loadInBackground() {
        loadInBackground((GetDataCallback) null);
    }

    public void loadInBackground(final GetDataCallback completionCallback) {
        if (this.file != null) {
            final ParseFile loadingFile = this.file;
            this.file.getDataInBackground(new GetDataCallback() {
                public void done(byte[] data, ParseException e) {
                    Bitmap bitmap;
                    if (ParseImageView.this.file == loadingFile) {
                        if (!(data == null || (bitmap = BitmapFactory.decodeByteArray(data, 0, data.length)) == null)) {
                            ParseImageView.this.setImageBitmap(bitmap);
                        }
                        if (completionCallback != null) {
                            completionCallback.done(data, e);
                        }
                    }
                }
            });
        } else if (completionCallback != null) {
            completionCallback.done((byte[]) null, (ParseException) null);
        }
    }
}
