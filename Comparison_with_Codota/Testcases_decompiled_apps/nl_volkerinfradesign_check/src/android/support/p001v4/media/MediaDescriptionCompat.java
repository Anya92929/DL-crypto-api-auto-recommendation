package android.support.p001v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import p000.C0622bn;
import p000.C0624bo;

/* renamed from: android.support.v4.media.MediaDescriptionCompat */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() {
        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.fromMediaDescription(C0622bn.m3439a(parcel));
        }

        /* renamed from: a */
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };

    /* renamed from: a */
    private final String f605a;

    /* renamed from: b */
    private final CharSequence f606b;

    /* renamed from: c */
    private final CharSequence f607c;

    /* renamed from: d */
    private final CharSequence f608d;

    /* renamed from: e */
    private final Bitmap f609e;

    /* renamed from: f */
    private final Uri f610f;

    /* renamed from: g */
    private final Bundle f611g;

    /* renamed from: h */
    private final Uri f612h;

    /* renamed from: i */
    private Object f613i;

    private MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f605a = str;
        this.f606b = charSequence;
        this.f607c = charSequence2;
        this.f608d = charSequence3;
        this.f609e = bitmap;
        this.f610f = uri;
        this.f611g = bundle;
        this.f612h = uri2;
    }

    private MediaDescriptionCompat(Parcel parcel) {
        this.f605a = parcel.readString();
        this.f606b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f607c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f608d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f609e = (Bitmap) parcel.readParcelable((ClassLoader) null);
        this.f610f = (Uri) parcel.readParcelable((ClassLoader) null);
        this.f611g = parcel.readBundle();
        this.f612h = (Uri) parcel.readParcelable((ClassLoader) null);
    }

    @Nullable
    public String getMediaId() {
        return this.f605a;
    }

    @Nullable
    public CharSequence getTitle() {
        return this.f606b;
    }

    @Nullable
    public CharSequence getSubtitle() {
        return this.f607c;
    }

    @Nullable
    public CharSequence getDescription() {
        return this.f608d;
    }

    @Nullable
    public Bitmap getIconBitmap() {
        return this.f609e;
    }

    @Nullable
    public Uri getIconUri() {
        return this.f610f;
    }

    @Nullable
    public Bundle getExtras() {
        return this.f611g;
    }

    @Nullable
    public Uri getMediaUri() {
        return this.f612h;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.f605a);
            TextUtils.writeToParcel(this.f606b, parcel, i);
            TextUtils.writeToParcel(this.f607c, parcel, i);
            TextUtils.writeToParcel(this.f608d, parcel, i);
            parcel.writeParcelable(this.f609e, i);
            parcel.writeParcelable(this.f610f, i);
            parcel.writeBundle(this.f611g);
            return;
        }
        C0622bn.m3441a(getMediaDescription(), parcel, i);
    }

    public String toString() {
        return this.f606b + ", " + this.f607c + ", " + this.f608d;
    }

    public Object getMediaDescription() {
        if (this.f613i != null || Build.VERSION.SDK_INT < 21) {
            return this.f613i;
        }
        Object a = C0622bn.C0623a.m3448a();
        C0622bn.C0623a.m3454a(a, this.f605a);
        C0622bn.C0623a.m3453a(a, this.f606b);
        C0622bn.C0623a.m3455b(a, this.f607c);
        C0622bn.C0623a.m3456c(a, this.f608d);
        C0622bn.C0623a.m3450a(a, this.f609e);
        C0622bn.C0623a.m3451a(a, this.f610f);
        C0622bn.C0623a.m3452a(a, this.f611g);
        if (Build.VERSION.SDK_INT >= 23) {
            C0624bo.C0625a.m3458b(a, this.f612h);
        }
        this.f613i = C0622bn.C0623a.m3449a(a);
        return this.f613i;
    }

    public static MediaDescriptionCompat fromMediaDescription(Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        Builder builder = new Builder();
        builder.setMediaId(C0622bn.m3440a(obj));
        builder.setTitle(C0622bn.m3442b(obj));
        builder.setSubtitle(C0622bn.m3443c(obj));
        builder.setDescription(C0622bn.m3444d(obj));
        builder.setIconBitmap(C0622bn.m3445e(obj));
        builder.setIconUri(C0622bn.m3446f(obj));
        builder.setExtras(C0622bn.m3447g(obj));
        if (Build.VERSION.SDK_INT >= 23) {
            builder.setMediaUri(C0624bo.m3457h(obj));
        }
        MediaDescriptionCompat build = builder.build();
        build.f613i = obj;
        return build;
    }

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$Builder */
    public static final class Builder {

        /* renamed from: a */
        private String f614a;

        /* renamed from: b */
        private CharSequence f615b;

        /* renamed from: c */
        private CharSequence f616c;

        /* renamed from: d */
        private CharSequence f617d;

        /* renamed from: e */
        private Bitmap f618e;

        /* renamed from: f */
        private Uri f619f;

        /* renamed from: g */
        private Bundle f620g;

        /* renamed from: h */
        private Uri f621h;

        public Builder setMediaId(@Nullable String str) {
            this.f614a = str;
            return this;
        }

        public Builder setTitle(@Nullable CharSequence charSequence) {
            this.f615b = charSequence;
            return this;
        }

        public Builder setSubtitle(@Nullable CharSequence charSequence) {
            this.f616c = charSequence;
            return this;
        }

        public Builder setDescription(@Nullable CharSequence charSequence) {
            this.f617d = charSequence;
            return this;
        }

        public Builder setIconBitmap(@Nullable Bitmap bitmap) {
            this.f618e = bitmap;
            return this;
        }

        public Builder setIconUri(@Nullable Uri uri) {
            this.f619f = uri;
            return this;
        }

        public Builder setExtras(@Nullable Bundle bundle) {
            this.f620g = bundle;
            return this;
        }

        public Builder setMediaUri(@Nullable Uri uri) {
            this.f621h = uri;
            return this;
        }

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.f614a, this.f615b, this.f616c, this.f617d, this.f618e, this.f619f, this.f620g, this.f621h);
        }
    }
}
