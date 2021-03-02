package android.support.p000v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.media.MediaDescriptionCompatApi21;
import android.support.p000v4.media.MediaDescriptionCompatApi23;
import android.text.TextUtils;

/* renamed from: android.support.v4.media.MediaDescriptionCompat */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() {
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return Build.VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel) : MediaDescriptionCompat.fromMediaDescription(MediaDescriptionCompatApi21.fromParcel(parcel));
        }

        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };

    /* renamed from: a */
    private final String f823a;

    /* renamed from: b */
    private final CharSequence f824b;

    /* renamed from: c */
    private final CharSequence f825c;

    /* renamed from: d */
    private final CharSequence f826d;

    /* renamed from: e */
    private final Bitmap f827e;

    /* renamed from: f */
    private final Uri f828f;

    /* renamed from: g */
    private final Bundle f829g;

    /* renamed from: h */
    private final Uri f830h;

    /* renamed from: i */
    private Object f831i;

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$Builder */
    public final class Builder {

        /* renamed from: a */
        private String f832a;

        /* renamed from: b */
        private CharSequence f833b;

        /* renamed from: c */
        private CharSequence f834c;

        /* renamed from: d */
        private CharSequence f835d;

        /* renamed from: e */
        private Bitmap f836e;

        /* renamed from: f */
        private Uri f837f;

        /* renamed from: g */
        private Bundle f838g;

        /* renamed from: h */
        private Uri f839h;

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.f832a, this.f833b, this.f834c, this.f835d, this.f836e, this.f837f, this.f838g, this.f839h);
        }

        public Builder setDescription(CharSequence charSequence) {
            this.f835d = charSequence;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.f838g = bundle;
            return this;
        }

        public Builder setIconBitmap(Bitmap bitmap) {
            this.f836e = bitmap;
            return this;
        }

        public Builder setIconUri(Uri uri) {
            this.f837f = uri;
            return this;
        }

        public Builder setMediaId(String str) {
            this.f832a = str;
            return this;
        }

        public Builder setMediaUri(Uri uri) {
            this.f839h = uri;
            return this;
        }

        public Builder setSubtitle(CharSequence charSequence) {
            this.f834c = charSequence;
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.f833b = charSequence;
            return this;
        }
    }

    private MediaDescriptionCompat(Parcel parcel) {
        this.f823a = parcel.readString();
        this.f824b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f825c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f826d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f827e = (Bitmap) parcel.readParcelable((ClassLoader) null);
        this.f828f = (Uri) parcel.readParcelable((ClassLoader) null);
        this.f829g = parcel.readBundle();
        this.f830h = (Uri) parcel.readParcelable((ClassLoader) null);
    }

    private MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f823a = str;
        this.f824b = charSequence;
        this.f825c = charSequence2;
        this.f826d = charSequence3;
        this.f827e = bitmap;
        this.f828f = uri;
        this.f829g = bundle;
        this.f830h = uri2;
    }

    public static MediaDescriptionCompat fromMediaDescription(Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        Builder builder = new Builder();
        builder.setMediaId(MediaDescriptionCompatApi21.getMediaId(obj));
        builder.setTitle(MediaDescriptionCompatApi21.getTitle(obj));
        builder.setSubtitle(MediaDescriptionCompatApi21.getSubtitle(obj));
        builder.setDescription(MediaDescriptionCompatApi21.getDescription(obj));
        builder.setIconBitmap(MediaDescriptionCompatApi21.getIconBitmap(obj));
        builder.setIconUri(MediaDescriptionCompatApi21.getIconUri(obj));
        builder.setExtras(MediaDescriptionCompatApi21.getExtras(obj));
        if (Build.VERSION.SDK_INT >= 23) {
            builder.setMediaUri(MediaDescriptionCompatApi23.getMediaUri(obj));
        }
        MediaDescriptionCompat build = builder.build();
        build.f831i = obj;
        return build;
    }

    public int describeContents() {
        return 0;
    }

    public CharSequence getDescription() {
        return this.f826d;
    }

    public Bundle getExtras() {
        return this.f829g;
    }

    public Bitmap getIconBitmap() {
        return this.f827e;
    }

    public Uri getIconUri() {
        return this.f828f;
    }

    public Object getMediaDescription() {
        if (this.f831i != null || Build.VERSION.SDK_INT < 21) {
            return this.f831i;
        }
        Object newInstance = MediaDescriptionCompatApi21.Builder.newInstance();
        MediaDescriptionCompatApi21.Builder.setMediaId(newInstance, this.f823a);
        MediaDescriptionCompatApi21.Builder.setTitle(newInstance, this.f824b);
        MediaDescriptionCompatApi21.Builder.setSubtitle(newInstance, this.f825c);
        MediaDescriptionCompatApi21.Builder.setDescription(newInstance, this.f826d);
        MediaDescriptionCompatApi21.Builder.setIconBitmap(newInstance, this.f827e);
        MediaDescriptionCompatApi21.Builder.setIconUri(newInstance, this.f828f);
        MediaDescriptionCompatApi21.Builder.setExtras(newInstance, this.f829g);
        if (Build.VERSION.SDK_INT >= 23) {
            MediaDescriptionCompatApi23.Builder.setMediaUri(newInstance, this.f830h);
        }
        this.f831i = MediaDescriptionCompatApi21.Builder.build(newInstance);
        return this.f831i;
    }

    public String getMediaId() {
        return this.f823a;
    }

    public Uri getMediaUri() {
        return this.f830h;
    }

    public CharSequence getSubtitle() {
        return this.f825c;
    }

    public CharSequence getTitle() {
        return this.f824b;
    }

    public String toString() {
        return this.f824b + ", " + this.f825c + ", " + this.f826d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.f823a);
            TextUtils.writeToParcel(this.f824b, parcel, i);
            TextUtils.writeToParcel(this.f825c, parcel, i);
            TextUtils.writeToParcel(this.f826d, parcel, i);
            parcel.writeParcelable(this.f827e, i);
            parcel.writeParcelable(this.f828f, i);
            parcel.writeBundle(this.f829g);
            return;
        }
        MediaDescriptionCompatApi21.writeToParcel(getMediaDescription(), parcel, i);
    }
}
