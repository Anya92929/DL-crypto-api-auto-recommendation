package android.support.p001v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import p000.C0647by;

/* renamed from: android.support.v4.media.session.PlaybackStateCompat */
public final class PlaybackStateCompat implements Parcelable {
    public static final long ACTION_FAST_FORWARD = 64;
    public static final long ACTION_PAUSE = 2;
    public static final long ACTION_PLAY = 4;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024;
    public static final long ACTION_PLAY_FROM_SEARCH = 2048;
    public static final long ACTION_PLAY_FROM_URI = 8192;
    public static final long ACTION_PLAY_PAUSE = 512;
    public static final long ACTION_REWIND = 8;
    public static final long ACTION_SEEK_TO = 256;
    public static final long ACTION_SET_RATING = 128;
    public static final long ACTION_SKIP_TO_NEXT = 32;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096;
    public static final long ACTION_STOP = 1;
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>() {
        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* renamed from: a */
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    };
    public static final long PLAYBACK_POSITION_UNKNOWN = -1;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final int f732a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final long f733b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final long f734c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final float f735d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final long f736e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final CharSequence f737f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final long f738g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<CustomAction> f739h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final long f740i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final Bundle f741j;

    /* renamed from: k */
    private Object f742k;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$Actions */
    public @interface Actions {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$State */
    public @interface State {
    }

    private PlaybackStateCompat(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.f732a = i;
        this.f733b = j;
        this.f734c = j2;
        this.f735d = f;
        this.f736e = j3;
        this.f737f = charSequence;
        this.f738g = j4;
        this.f739h = new ArrayList(list);
        this.f740i = j5;
        this.f741j = bundle;
    }

    private PlaybackStateCompat(Parcel parcel) {
        this.f732a = parcel.readInt();
        this.f733b = parcel.readLong();
        this.f735d = parcel.readFloat();
        this.f738g = parcel.readLong();
        this.f734c = parcel.readLong();
        this.f736e = parcel.readLong();
        this.f737f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f739h = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f740i = parcel.readLong();
        this.f741j = parcel.readBundle();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {");
        sb.append("state=").append(this.f732a);
        sb.append(", position=").append(this.f733b);
        sb.append(", buffered position=").append(this.f734c);
        sb.append(", speed=").append(this.f735d);
        sb.append(", updated=").append(this.f738g);
        sb.append(", actions=").append(this.f736e);
        sb.append(", error=").append(this.f737f);
        sb.append(", custom actions=").append(this.f739h);
        sb.append(", active item id=").append(this.f740i);
        sb.append("}");
        return sb.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f732a);
        parcel.writeLong(this.f733b);
        parcel.writeFloat(this.f735d);
        parcel.writeLong(this.f738g);
        parcel.writeLong(this.f734c);
        parcel.writeLong(this.f736e);
        TextUtils.writeToParcel(this.f737f, parcel, i);
        parcel.writeTypedList(this.f739h);
        parcel.writeLong(this.f740i);
        parcel.writeBundle(this.f741j);
    }

    public int getState() {
        return this.f732a;
    }

    public long getPosition() {
        return this.f733b;
    }

    public long getBufferedPosition() {
        return this.f734c;
    }

    public float getPlaybackSpeed() {
        return this.f735d;
    }

    public long getActions() {
        return this.f736e;
    }

    public List<CustomAction> getCustomActions() {
        return this.f739h;
    }

    public CharSequence getErrorMessage() {
        return this.f737f;
    }

    public long getLastPositionUpdateTime() {
        return this.f738g;
    }

    public long getActiveQueueItemId() {
        return this.f740i;
    }

    @Nullable
    public Bundle getExtras() {
        return this.f741j;
    }

    public static PlaybackStateCompat fromPlaybackState(Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> h = C0647by.m3559h(obj);
        ArrayList arrayList = null;
        if (h != null) {
            arrayList = new ArrayList(h.size());
            for (Object fromCustomAction : h) {
                arrayList.add(CustomAction.fromCustomAction(fromCustomAction));
            }
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(C0647by.m3551a(obj), C0647by.m3553b(obj), C0647by.m3554c(obj), C0647by.m3555d(obj), C0647by.m3556e(obj), C0647by.m3557f(obj), C0647by.m3558g(obj), arrayList, C0647by.m3560i(obj), Build.VERSION.SDK_INT >= 22 ? C0649bz.m3566a(obj) : null);
        playbackStateCompat.f742k = obj;
        return playbackStateCompat;
    }

    public Object getPlaybackState() {
        if (this.f742k != null || Build.VERSION.SDK_INT < 21) {
            return this.f742k;
        }
        ArrayList arrayList = null;
        if (this.f739h != null) {
            arrayList = new ArrayList(this.f739h.size());
            for (CustomAction customAction : this.f739h) {
                arrayList.add(customAction.getCustomAction());
            }
        }
        if (Build.VERSION.SDK_INT >= 22) {
            this.f742k = C0649bz.m3567a(this.f732a, this.f733b, this.f734c, this.f735d, this.f736e, this.f737f, this.f738g, arrayList, this.f740i, this.f741j);
        } else {
            this.f742k = C0647by.m3552a(this.f732a, this.f733b, this.f734c, this.f735d, this.f736e, this.f737f, this.f738g, arrayList, this.f740i);
        }
        return this.f742k;
    }

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() {
            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* renamed from: a */
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        };

        /* renamed from: a */
        private final String f753a;

        /* renamed from: b */
        private final CharSequence f754b;

        /* renamed from: c */
        private final int f755c;

        /* renamed from: d */
        private final Bundle f756d;

        /* renamed from: e */
        private Object f757e;

        private CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f753a = str;
            this.f754b = charSequence;
            this.f755c = i;
            this.f756d = bundle;
        }

        private CustomAction(Parcel parcel) {
            this.f753a = parcel.readString();
            this.f754b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f755c = parcel.readInt();
            this.f756d = parcel.readBundle();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f753a);
            TextUtils.writeToParcel(this.f754b, parcel, i);
            parcel.writeInt(this.f755c);
            parcel.writeBundle(this.f756d);
        }

        public int describeContents() {
            return 0;
        }

        public static CustomAction fromCustomAction(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(C0647by.C0648a.m3562a(obj), C0647by.C0648a.m3563b(obj), C0647by.C0648a.m3564c(obj), C0647by.C0648a.m3565d(obj));
            customAction.f757e = obj;
            return customAction;
        }

        public Object getCustomAction() {
            if (this.f757e != null || Build.VERSION.SDK_INT < 21) {
                return this.f757e;
            }
            this.f757e = C0647by.C0648a.m3561a(this.f753a, this.f754b, this.f755c, this.f756d);
            return this.f757e;
        }

        public String getAction() {
            return this.f753a;
        }

        public CharSequence getName() {
            return this.f754b;
        }

        public int getIcon() {
            return this.f755c;
        }

        public Bundle getExtras() {
            return this.f756d;
        }

        public String toString() {
            return "Action:mName='" + this.f754b + ", mIcon=" + this.f755c + ", mExtras=" + this.f756d;
        }

        /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder */
        public static final class Builder {

            /* renamed from: a */
            private final String f758a;

            /* renamed from: b */
            private final CharSequence f759b;

            /* renamed from: c */
            private final int f760c;

            /* renamed from: d */
            private Bundle f761d;

            public Builder(String str, CharSequence charSequence, int i) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("You must specify an action to build a CustomAction.");
                } else if (TextUtils.isEmpty(charSequence)) {
                    throw new IllegalArgumentException("You must specify a name to build a CustomAction.");
                } else if (i == 0) {
                    throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction.");
                } else {
                    this.f758a = str;
                    this.f759b = charSequence;
                    this.f760c = i;
                }
            }

            public Builder setExtras(Bundle bundle) {
                this.f761d = bundle;
                return this;
            }

            public CustomAction build() {
                return new CustomAction(this.f758a, this.f759b, this.f760c, this.f761d);
            }
        }
    }

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$Builder */
    public static final class Builder {

        /* renamed from: a */
        private final List<CustomAction> f743a = new ArrayList();

        /* renamed from: b */
        private int f744b;

        /* renamed from: c */
        private long f745c;

        /* renamed from: d */
        private long f746d;

        /* renamed from: e */
        private float f747e;

        /* renamed from: f */
        private long f748f;

        /* renamed from: g */
        private CharSequence f749g;

        /* renamed from: h */
        private long f750h;

        /* renamed from: i */
        private long f751i = -1;

        /* renamed from: j */
        private Bundle f752j;

        public Builder() {
        }

        public Builder(PlaybackStateCompat playbackStateCompat) {
            this.f744b = playbackStateCompat.f732a;
            this.f745c = playbackStateCompat.f733b;
            this.f747e = playbackStateCompat.f735d;
            this.f750h = playbackStateCompat.f738g;
            this.f746d = playbackStateCompat.f734c;
            this.f748f = playbackStateCompat.f736e;
            this.f749g = playbackStateCompat.f737f;
            if (playbackStateCompat.f739h != null) {
                this.f743a.addAll(playbackStateCompat.f739h);
            }
            this.f751i = playbackStateCompat.f740i;
            this.f752j = playbackStateCompat.f741j;
        }

        public Builder setState(int i, long j, float f) {
            return setState(i, j, f, SystemClock.elapsedRealtime());
        }

        public Builder setState(int i, long j, float f, long j2) {
            this.f744b = i;
            this.f745c = j;
            this.f750h = j2;
            this.f747e = f;
            return this;
        }

        public Builder setBufferedPosition(long j) {
            this.f746d = j;
            return this;
        }

        public Builder setActions(long j) {
            this.f748f = j;
            return this;
        }

        public Builder addCustomAction(String str, String str2, int i) {
            return addCustomAction(new CustomAction(str, str2, i, (Bundle) null));
        }

        public Builder addCustomAction(CustomAction customAction) {
            if (customAction == null) {
                throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat.");
            }
            this.f743a.add(customAction);
            return this;
        }

        public Builder setActiveQueueItemId(long j) {
            this.f751i = j;
            return this;
        }

        public Builder setErrorMessage(CharSequence charSequence) {
            this.f749g = charSequence;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.f752j = bundle;
            return this;
        }

        public PlaybackStateCompat build() {
            return new PlaybackStateCompat(this.f744b, this.f745c, this.f746d, this.f747e, this.f748f, this.f749g, this.f750h, this.f743a, this.f751i, this.f752j);
        }
    }
}
