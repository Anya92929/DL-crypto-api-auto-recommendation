package android.support.p000v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.p000v4.media.session.PlaybackStateCompatApi21;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

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
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

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
    public final int f972a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final long f973b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final long f974c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final float f975d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final long f976e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final CharSequence f977f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final long f978g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<CustomAction> f979h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final long f980i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final Bundle f981j;

    /* renamed from: k */
    private Object f982k;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$Actions */
    public @interface Actions {
    }

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$Builder */
    public final class Builder {

        /* renamed from: a */
        private final List<CustomAction> f983a = new ArrayList();

        /* renamed from: b */
        private int f984b;

        /* renamed from: c */
        private long f985c;

        /* renamed from: d */
        private long f986d;

        /* renamed from: e */
        private float f987e;

        /* renamed from: f */
        private long f988f;

        /* renamed from: g */
        private CharSequence f989g;

        /* renamed from: h */
        private long f990h;

        /* renamed from: i */
        private long f991i = -1;

        /* renamed from: j */
        private Bundle f992j;

        public Builder(PlaybackStateCompat playbackStateCompat) {
            this.f984b = playbackStateCompat.f972a;
            this.f985c = playbackStateCompat.f973b;
            this.f987e = playbackStateCompat.f975d;
            this.f990h = playbackStateCompat.f978g;
            this.f986d = playbackStateCompat.f974c;
            this.f988f = playbackStateCompat.f976e;
            this.f989g = playbackStateCompat.f977f;
            if (playbackStateCompat.f979h != null) {
                this.f983a.addAll(playbackStateCompat.f979h);
            }
            this.f991i = playbackStateCompat.f980i;
            this.f992j = playbackStateCompat.f981j;
        }

        public Builder addCustomAction(CustomAction customAction) {
            if (customAction == null) {
                throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat.");
            }
            this.f983a.add(customAction);
            return this;
        }

        public Builder addCustomAction(String str, String str2, int i) {
            return addCustomAction(new CustomAction(str, str2, i, (Bundle) null));
        }

        public PlaybackStateCompat build() {
            return new PlaybackStateCompat(this.f984b, this.f985c, this.f986d, this.f987e, this.f988f, this.f989g, this.f990h, this.f983a, this.f991i, this.f992j);
        }

        public Builder setActions(long j) {
            this.f988f = j;
            return this;
        }

        public Builder setActiveQueueItemId(long j) {
            this.f991i = j;
            return this;
        }

        public Builder setBufferedPosition(long j) {
            this.f986d = j;
            return this;
        }

        public Builder setErrorMessage(CharSequence charSequence) {
            this.f989g = charSequence;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.f992j = bundle;
            return this;
        }

        public Builder setState(int i, long j, float f) {
            return setState(i, j, f, SystemClock.elapsedRealtime());
        }

        public Builder setState(int i, long j, float f, long j2) {
            this.f984b = i;
            this.f985c = j;
            this.f990h = j2;
            this.f987e = f;
            return this;
        }
    }

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction */
    public final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() {
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        };

        /* renamed from: a */
        private final String f993a;

        /* renamed from: b */
        private final CharSequence f994b;

        /* renamed from: c */
        private final int f995c;

        /* renamed from: d */
        private final Bundle f996d;

        /* renamed from: e */
        private Object f997e;

        /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder */
        public final class Builder {

            /* renamed from: a */
            private final String f998a;

            /* renamed from: b */
            private final CharSequence f999b;

            /* renamed from: c */
            private final int f1000c;

            /* renamed from: d */
            private Bundle f1001d;

            public Builder(String str, CharSequence charSequence, int i) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("You must specify an action to build a CustomAction.");
                } else if (TextUtils.isEmpty(charSequence)) {
                    throw new IllegalArgumentException("You must specify a name to build a CustomAction.");
                } else if (i == 0) {
                    throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction.");
                } else {
                    this.f998a = str;
                    this.f999b = charSequence;
                    this.f1000c = i;
                }
            }

            public CustomAction build() {
                return new CustomAction(this.f998a, this.f999b, this.f1000c, this.f1001d);
            }

            public Builder setExtras(Bundle bundle) {
                this.f1001d = bundle;
                return this;
            }
        }

        private CustomAction(Parcel parcel) {
            this.f993a = parcel.readString();
            this.f994b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f995c = parcel.readInt();
            this.f996d = parcel.readBundle();
        }

        private CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f993a = str;
            this.f994b = charSequence;
            this.f995c = i;
            this.f996d = bundle;
        }

        public static CustomAction fromCustomAction(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(PlaybackStateCompatApi21.CustomAction.getAction(obj), PlaybackStateCompatApi21.CustomAction.getName(obj), PlaybackStateCompatApi21.CustomAction.getIcon(obj), PlaybackStateCompatApi21.CustomAction.getExtras(obj));
            customAction.f997e = obj;
            return customAction;
        }

        public int describeContents() {
            return 0;
        }

        public String getAction() {
            return this.f993a;
        }

        public Object getCustomAction() {
            if (this.f997e != null || Build.VERSION.SDK_INT < 21) {
                return this.f997e;
            }
            this.f997e = PlaybackStateCompatApi21.CustomAction.newInstance(this.f993a, this.f994b, this.f995c, this.f996d);
            return this.f997e;
        }

        public Bundle getExtras() {
            return this.f996d;
        }

        public int getIcon() {
            return this.f995c;
        }

        public CharSequence getName() {
            return this.f994b;
        }

        public String toString() {
            return "Action:mName='" + this.f994b + ", mIcon=" + this.f995c + ", mExtras=" + this.f996d;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f993a);
            TextUtils.writeToParcel(this.f994b, parcel, i);
            parcel.writeInt(this.f995c);
            parcel.writeBundle(this.f996d);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$State */
    public @interface State {
    }

    private PlaybackStateCompat(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.f972a = i;
        this.f973b = j;
        this.f974c = j2;
        this.f975d = f;
        this.f976e = j3;
        this.f977f = charSequence;
        this.f978g = j4;
        this.f979h = new ArrayList(list);
        this.f980i = j5;
        this.f981j = bundle;
    }

    private PlaybackStateCompat(Parcel parcel) {
        this.f972a = parcel.readInt();
        this.f973b = parcel.readLong();
        this.f975d = parcel.readFloat();
        this.f978g = parcel.readLong();
        this.f974c = parcel.readLong();
        this.f976e = parcel.readLong();
        this.f977f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f979h = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f980i = parcel.readLong();
        this.f981j = parcel.readBundle();
    }

    public static PlaybackStateCompat fromPlaybackState(Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> customActions = PlaybackStateCompatApi21.getCustomActions(obj);
        ArrayList arrayList = null;
        if (customActions != null) {
            arrayList = new ArrayList(customActions.size());
            for (Object fromCustomAction : customActions) {
                arrayList.add(CustomAction.fromCustomAction(fromCustomAction));
            }
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(PlaybackStateCompatApi21.getState(obj), PlaybackStateCompatApi21.getPosition(obj), PlaybackStateCompatApi21.getBufferedPosition(obj), PlaybackStateCompatApi21.getPlaybackSpeed(obj), PlaybackStateCompatApi21.getActions(obj), PlaybackStateCompatApi21.getErrorMessage(obj), PlaybackStateCompatApi21.getLastPositionUpdateTime(obj), arrayList, PlaybackStateCompatApi21.getActiveQueueItemId(obj), Build.VERSION.SDK_INT >= 22 ? PlaybackStateCompatApi22.getExtras(obj) : null);
        playbackStateCompat.f982k = obj;
        return playbackStateCompat;
    }

    public int describeContents() {
        return 0;
    }

    public long getActions() {
        return this.f976e;
    }

    public long getActiveQueueItemId() {
        return this.f980i;
    }

    public long getBufferedPosition() {
        return this.f974c;
    }

    public List<CustomAction> getCustomActions() {
        return this.f979h;
    }

    public CharSequence getErrorMessage() {
        return this.f977f;
    }

    public Bundle getExtras() {
        return this.f981j;
    }

    public long getLastPositionUpdateTime() {
        return this.f978g;
    }

    public float getPlaybackSpeed() {
        return this.f975d;
    }

    public Object getPlaybackState() {
        if (this.f982k != null || Build.VERSION.SDK_INT < 21) {
            return this.f982k;
        }
        ArrayList arrayList = null;
        if (this.f979h != null) {
            arrayList = new ArrayList(this.f979h.size());
            for (CustomAction customAction : this.f979h) {
                arrayList.add(customAction.getCustomAction());
            }
        }
        if (Build.VERSION.SDK_INT >= 22) {
            this.f982k = PlaybackStateCompatApi22.newInstance(this.f972a, this.f973b, this.f974c, this.f975d, this.f976e, this.f977f, this.f978g, arrayList, this.f980i, this.f981j);
        } else {
            this.f982k = PlaybackStateCompatApi21.newInstance(this.f972a, this.f973b, this.f974c, this.f975d, this.f976e, this.f977f, this.f978g, arrayList, this.f980i);
        }
        return this.f982k;
    }

    public long getPosition() {
        return this.f973b;
    }

    public int getState() {
        return this.f972a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {");
        sb.append("state=").append(this.f972a);
        sb.append(", position=").append(this.f973b);
        sb.append(", buffered position=").append(this.f974c);
        sb.append(", speed=").append(this.f975d);
        sb.append(", updated=").append(this.f978g);
        sb.append(", actions=").append(this.f976e);
        sb.append(", error=").append(this.f977f);
        sb.append(", custom actions=").append(this.f979h);
        sb.append(", active item id=").append(this.f980i);
        sb.append("}");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f972a);
        parcel.writeLong(this.f973b);
        parcel.writeFloat(this.f975d);
        parcel.writeLong(this.f978g);
        parcel.writeLong(this.f974c);
        parcel.writeLong(this.f976e);
        TextUtils.writeToParcel(this.f977f, parcel, i);
        parcel.writeTypedList(this.f979h);
        parcel.writeLong(this.f980i);
        parcel.writeBundle(this.f981j);
    }
}
