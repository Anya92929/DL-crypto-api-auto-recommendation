package android.support.p000v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p000v4.app.NotificationCompatApi20;
import android.support.p000v4.app.NotificationCompatApi21;
import android.support.p000v4.app.NotificationCompatBase;
import android.support.p000v4.app.NotificationCompatIceCreamSandwich;
import android.support.p000v4.app.NotificationCompatJellybean;
import android.support.p000v4.app.NotificationCompatKitKat;
import android.support.p000v4.app.RemoteInputCompatBase;
import android.support.p000v4.view.GravityCompat;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.app.NotificationCompat */
public class NotificationCompat {
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final NotificationCompatImpl f574a;

    /* renamed from: android.support.v4.app.NotificationCompat$Action */
    public class Action extends NotificationCompatBase.Action {
        public static final NotificationCompatBase.Action.Factory FACTORY = new NotificationCompatBase.Action.Factory() {
            public Action build(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInputCompatBase.RemoteInput[] remoteInputArr) {
                return new Action(i, charSequence, pendingIntent, bundle, (RemoteInput[]) remoteInputArr);
            }

            public Action[] newArray(int i) {
                return new Action[i];
            }
        };
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Bundle f575a;
        public PendingIntent actionIntent;

        /* renamed from: b */
        private final RemoteInput[] f576b;
        public int icon;
        public CharSequence title;

        /* renamed from: android.support.v4.app.NotificationCompat$Action$Builder */
        public final class Builder {

            /* renamed from: a */
            private final int f577a;

            /* renamed from: b */
            private final CharSequence f578b;

            /* renamed from: c */
            private final PendingIntent f579c;

            /* renamed from: d */
            private final Bundle f580d;

            /* renamed from: e */
            private ArrayList<RemoteInput> f581e;

            public Builder(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i, charSequence, pendingIntent, new Bundle());
            }

            private Builder(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
                this.f577a = i;
                this.f578b = Builder.m559a(charSequence);
                this.f579c = pendingIntent;
                this.f580d = bundle;
            }

            public Builder(Action action) {
                this(action.icon, action.title, action.actionIntent, new Bundle(action.f575a));
            }

            public Builder addExtras(Bundle bundle) {
                if (bundle != null) {
                    this.f580d.putAll(bundle);
                }
                return this;
            }

            public Builder addRemoteInput(RemoteInput remoteInput) {
                if (this.f581e == null) {
                    this.f581e = new ArrayList<>();
                }
                this.f581e.add(remoteInput);
                return this;
            }

            public Action build() {
                return new Action(this.f577a, this.f578b, this.f579c, this.f580d, this.f581e != null ? (RemoteInput[]) this.f581e.toArray(new RemoteInput[this.f581e.size()]) : null);
            }

            public Builder extend(Extender extender) {
                extender.extend(this);
                return this;
            }

            public Bundle getExtras() {
                return this.f580d;
            }
        }

        /* renamed from: android.support.v4.app.NotificationCompat$Action$Extender */
        public interface Extender {
            Builder extend(Builder builder);
        }

        /* renamed from: android.support.v4.app.NotificationCompat$Action$WearableExtender */
        public final class WearableExtender implements Extender {

            /* renamed from: a */
            private int f582a = 1;

            /* renamed from: b */
            private CharSequence f583b;

            /* renamed from: c */
            private CharSequence f584c;

            /* renamed from: d */
            private CharSequence f585d;

            public WearableExtender(Action action) {
                Bundle bundle = action.getExtras().getBundle("android.wearable.EXTENSIONS");
                if (bundle != null) {
                    this.f582a = bundle.getInt("flags", 1);
                    this.f583b = bundle.getCharSequence("inProgressLabel");
                    this.f584c = bundle.getCharSequence("confirmLabel");
                    this.f585d = bundle.getCharSequence("cancelLabel");
                }
            }

            /* renamed from: a */
            private void m558a(int i, boolean z) {
                if (z) {
                    this.f582a |= i;
                } else {
                    this.f582a &= i ^ -1;
                }
            }

            public WearableExtender clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.f582a = this.f582a;
                wearableExtender.f583b = this.f583b;
                wearableExtender.f584c = this.f584c;
                wearableExtender.f585d = this.f585d;
                return wearableExtender;
            }

            public Builder extend(Builder builder) {
                Bundle bundle = new Bundle();
                if (this.f582a != 1) {
                    bundle.putInt("flags", this.f582a);
                }
                if (this.f583b != null) {
                    bundle.putCharSequence("inProgressLabel", this.f583b);
                }
                if (this.f584c != null) {
                    bundle.putCharSequence("confirmLabel", this.f584c);
                }
                if (this.f585d != null) {
                    bundle.putCharSequence("cancelLabel", this.f585d);
                }
                builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
                return builder;
            }

            public CharSequence getCancelLabel() {
                return this.f585d;
            }

            public CharSequence getConfirmLabel() {
                return this.f584c;
            }

            public CharSequence getInProgressLabel() {
                return this.f583b;
            }

            public boolean isAvailableOffline() {
                return (this.f582a & 1) != 0;
            }

            public WearableExtender setAvailableOffline(boolean z) {
                m558a(1, z);
                return this;
            }

            public WearableExtender setCancelLabel(CharSequence charSequence) {
                this.f585d = charSequence;
                return this;
            }

            public WearableExtender setConfirmLabel(CharSequence charSequence) {
                this.f584c = charSequence;
                return this;
            }

            public WearableExtender setInProgressLabel(CharSequence charSequence) {
                this.f583b = charSequence;
                return this;
            }
        }

        public Action(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null);
        }

        private Action(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr) {
            this.icon = i;
            this.title = Builder.m559a(charSequence);
            this.actionIntent = pendingIntent;
            this.f575a = bundle == null ? new Bundle() : bundle;
            this.f576b = remoteInputArr;
        }

        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public Bundle getExtras() {
            return this.f575a;
        }

        public int getIcon() {
            return this.icon;
        }

        public RemoteInput[] getRemoteInputs() {
            return this.f576b;
        }

        public CharSequence getTitle() {
            return this.title;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$BigPictureStyle */
    public class BigPictureStyle extends Style {

        /* renamed from: a */
        Bitmap f586a;

        /* renamed from: b */
        Bitmap f587b;

        /* renamed from: c */
        boolean f588c;

        public BigPictureStyle() {
        }

        public BigPictureStyle(Builder builder) {
            setBuilder(builder);
        }

        public BigPictureStyle bigLargeIcon(Bitmap bitmap) {
            this.f587b = bitmap;
            this.f588c = true;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap bitmap) {
            this.f586a = bitmap;
            return this;
        }

        public BigPictureStyle setBigContentTitle(CharSequence charSequence) {
            this.f625e = Builder.m559a(charSequence);
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence charSequence) {
            this.f626f = Builder.m559a(charSequence);
            this.f627g = true;
            return this;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$BigTextStyle */
    public class BigTextStyle extends Style {

        /* renamed from: a */
        CharSequence f589a;

        public BigTextStyle() {
        }

        public BigTextStyle(Builder builder) {
            setBuilder(builder);
        }

        public BigTextStyle bigText(CharSequence charSequence) {
            this.f589a = Builder.m559a(charSequence);
            return this;
        }

        public BigTextStyle setBigContentTitle(CharSequence charSequence) {
            this.f625e = Builder.m559a(charSequence);
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence charSequence) {
            this.f626f = Builder.m559a(charSequence);
            this.f627g = true;
            return this;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$Builder */
    public class Builder {

        /* renamed from: a */
        PendingIntent f590a;

        /* renamed from: b */
        PendingIntent f591b;

        /* renamed from: c */
        RemoteViews f592c;

        /* renamed from: d */
        int f593d;

        /* renamed from: e */
        boolean f594e = true;

        /* renamed from: f */
        int f595f;

        /* renamed from: g */
        int f596g;

        /* renamed from: h */
        boolean f597h;

        /* renamed from: i */
        String f598i;

        /* renamed from: j */
        boolean f599j;

        /* renamed from: k */
        String f600k;

        /* renamed from: l */
        boolean f601l = false;

        /* renamed from: m */
        String f602m;
        public ArrayList<Action> mActions = new ArrayList<>();
        public CharSequence mContentInfo;
        public CharSequence mContentText;
        public CharSequence mContentTitle;
        public Context mContext;
        public Bitmap mLargeIcon;
        public Notification mNotification = new Notification();
        public int mNumber;
        public ArrayList<String> mPeople;
        public Style mStyle;
        public CharSequence mSubText;
        public boolean mUseChronometer;

        /* renamed from: n */
        Bundle f603n;

        /* renamed from: o */
        int f604o = 0;

        /* renamed from: p */
        int f605p = 0;

        /* renamed from: q */
        Notification f606q;

        public Builder(Context context) {
            this.mContext = context;
            this.mNotification.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.f593d = 0;
            this.mPeople = new ArrayList<>();
        }

        /* renamed from: a */
        protected static CharSequence m559a(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        /* renamed from: a */
        private void m560a(int i, boolean z) {
            if (z) {
                this.mNotification.flags |= i;
                return;
            }
            this.mNotification.flags &= i ^ -1;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public BuilderExtender mo914a() {
            return new BuilderExtender();
        }

        public Builder addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.mActions.add(new Action(i, charSequence, pendingIntent));
            return this;
        }

        public Builder addAction(Action action) {
            this.mActions.add(action);
            return this;
        }

        public Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                if (this.f603n == null) {
                    this.f603n = new Bundle(bundle);
                } else {
                    this.f603n.putAll(bundle);
                }
            }
            return this;
        }

        public Builder addPerson(String str) {
            this.mPeople.add(str);
            return this;
        }

        public Notification build() {
            return NotificationCompat.f574a.build(this, mo914a());
        }

        public Builder extend(Extender extender) {
            extender.extend(this);
            return this;
        }

        public Bundle getExtras() {
            if (this.f603n == null) {
                this.f603n = new Bundle();
            }
            return this.f603n;
        }

        @Deprecated
        public Notification getNotification() {
            return build();
        }

        public Builder setAutoCancel(boolean z) {
            m560a(16, z);
            return this;
        }

        public Builder setCategory(String str) {
            this.f602m = str;
            return this;
        }

        public Builder setColor(int i) {
            this.f604o = i;
            return this;
        }

        public Builder setContent(RemoteViews remoteViews) {
            this.mNotification.contentView = remoteViews;
            return this;
        }

        public Builder setContentInfo(CharSequence charSequence) {
            this.mContentInfo = m559a(charSequence);
            return this;
        }

        public Builder setContentIntent(PendingIntent pendingIntent) {
            this.f590a = pendingIntent;
            return this;
        }

        public Builder setContentText(CharSequence charSequence) {
            this.mContentText = m559a(charSequence);
            return this;
        }

        public Builder setContentTitle(CharSequence charSequence) {
            this.mContentTitle = m559a(charSequence);
            return this;
        }

        public Builder setDefaults(int i) {
            this.mNotification.defaults = i;
            if ((i & 4) != 0) {
                this.mNotification.flags |= 1;
            }
            return this;
        }

        public Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.mNotification.deleteIntent = pendingIntent;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.f603n = bundle;
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
            this.f591b = pendingIntent;
            m560a(128, z);
            return this;
        }

        public Builder setGroup(String str) {
            this.f598i = str;
            return this;
        }

        public Builder setGroupSummary(boolean z) {
            this.f599j = z;
            return this;
        }

        public Builder setLargeIcon(Bitmap bitmap) {
            this.mLargeIcon = bitmap;
            return this;
        }

        public Builder setLights(int i, int i2, int i3) {
            int i4 = 1;
            this.mNotification.ledARGB = i;
            this.mNotification.ledOnMS = i2;
            this.mNotification.ledOffMS = i3;
            boolean z = (this.mNotification.ledOnMS == 0 || this.mNotification.ledOffMS == 0) ? false : true;
            Notification notification = this.mNotification;
            int i5 = this.mNotification.flags & -2;
            if (!z) {
                i4 = 0;
            }
            notification.flags = i5 | i4;
            return this;
        }

        public Builder setLocalOnly(boolean z) {
            this.f601l = z;
            return this;
        }

        public Builder setNumber(int i) {
            this.mNumber = i;
            return this;
        }

        public Builder setOngoing(boolean z) {
            m560a(2, z);
            return this;
        }

        public Builder setOnlyAlertOnce(boolean z) {
            m560a(8, z);
            return this;
        }

        public Builder setPriority(int i) {
            this.f593d = i;
            return this;
        }

        public Builder setProgress(int i, int i2, boolean z) {
            this.f595f = i;
            this.f596g = i2;
            this.f597h = z;
            return this;
        }

        public Builder setPublicVersion(Notification notification) {
            this.f606q = notification;
            return this;
        }

        public Builder setShowWhen(boolean z) {
            this.f594e = z;
            return this;
        }

        public Builder setSmallIcon(int i) {
            this.mNotification.icon = i;
            return this;
        }

        public Builder setSmallIcon(int i, int i2) {
            this.mNotification.icon = i;
            this.mNotification.iconLevel = i2;
            return this;
        }

        public Builder setSortKey(String str) {
            this.f600k = str;
            return this;
        }

        public Builder setSound(Uri uri) {
            this.mNotification.sound = uri;
            this.mNotification.audioStreamType = -1;
            return this;
        }

        public Builder setSound(Uri uri, int i) {
            this.mNotification.sound = uri;
            this.mNotification.audioStreamType = i;
            return this;
        }

        public Builder setStyle(Style style) {
            if (this.mStyle != style) {
                this.mStyle = style;
                if (this.mStyle != null) {
                    this.mStyle.setBuilder(this);
                }
            }
            return this;
        }

        public Builder setSubText(CharSequence charSequence) {
            this.mSubText = m559a(charSequence);
            return this;
        }

        public Builder setTicker(CharSequence charSequence) {
            this.mNotification.tickerText = m559a(charSequence);
            return this;
        }

        public Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            this.mNotification.tickerText = m559a(charSequence);
            this.f592c = remoteViews;
            return this;
        }

        public Builder setUsesChronometer(boolean z) {
            this.mUseChronometer = z;
            return this;
        }

        public Builder setVibrate(long[] jArr) {
            this.mNotification.vibrate = jArr;
            return this;
        }

        public Builder setVisibility(int i) {
            this.f605p = i;
            return this;
        }

        public Builder setWhen(long j) {
            this.mNotification.when = j;
            return this;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$BuilderExtender */
    public class BuilderExtender {
        protected BuilderExtender() {
        }

        public Notification build(Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return notificationBuilderWithBuilderAccessor.build();
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$CarExtender */
    public final class CarExtender implements Extender {

        /* renamed from: a */
        private Bitmap f607a;

        /* renamed from: b */
        private UnreadConversation f608b;

        /* renamed from: c */
        private int f609c = 0;

        /* renamed from: android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation */
        public class UnreadConversation extends NotificationCompatBase.UnreadConversation {

            /* renamed from: a */
            static final NotificationCompatBase.UnreadConversation.Factory f610a = new NotificationCompatBase.UnreadConversation.Factory() {
                public UnreadConversation build(String[] strArr, RemoteInputCompatBase.RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
                    return new UnreadConversation(strArr, (RemoteInput) remoteInput, pendingIntent, pendingIntent2, strArr2, j);
                }
            };

            /* renamed from: b */
            private final String[] f611b;

            /* renamed from: c */
            private final RemoteInput f612c;

            /* renamed from: d */
            private final PendingIntent f613d;

            /* renamed from: e */
            private final PendingIntent f614e;

            /* renamed from: f */
            private final String[] f615f;

            /* renamed from: g */
            private final long f616g;

            /* renamed from: android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation$Builder */
            public class Builder {

                /* renamed from: a */
                private final List<String> f617a = new ArrayList();

                /* renamed from: b */
                private final String f618b;

                /* renamed from: c */
                private RemoteInput f619c;

                /* renamed from: d */
                private PendingIntent f620d;

                /* renamed from: e */
                private PendingIntent f621e;

                /* renamed from: f */
                private long f622f;

                public Builder(String str) {
                    this.f618b = str;
                }

                public Builder addMessage(String str) {
                    this.f617a.add(str);
                    return this;
                }

                public UnreadConversation build() {
                    return new UnreadConversation((String[]) this.f617a.toArray(new String[this.f617a.size()]), this.f619c, this.f621e, this.f620d, new String[]{this.f618b}, this.f622f);
                }

                public Builder setLatestTimestamp(long j) {
                    this.f622f = j;
                    return this;
                }

                public Builder setReadPendingIntent(PendingIntent pendingIntent) {
                    this.f620d = pendingIntent;
                    return this;
                }

                public Builder setReplyAction(PendingIntent pendingIntent, RemoteInput remoteInput) {
                    this.f619c = remoteInput;
                    this.f621e = pendingIntent;
                    return this;
                }
            }

            UnreadConversation(String[] strArr, RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
                this.f611b = strArr;
                this.f612c = remoteInput;
                this.f614e = pendingIntent2;
                this.f613d = pendingIntent;
                this.f615f = strArr2;
                this.f616g = j;
            }

            public long getLatestTimestamp() {
                return this.f616g;
            }

            public String[] getMessages() {
                return this.f611b;
            }

            public String getParticipant() {
                if (this.f615f.length > 0) {
                    return this.f615f[0];
                }
                return null;
            }

            public String[] getParticipants() {
                return this.f615f;
            }

            public PendingIntent getReadPendingIntent() {
                return this.f614e;
            }

            public RemoteInput getRemoteInput() {
                return this.f612c;
            }

            public PendingIntent getReplyPendingIntent() {
                return this.f613d;
            }
        }

        public CarExtender() {
        }

        public CarExtender(Notification notification) {
            if (Build.VERSION.SDK_INT >= 21) {
                Bundle bundle = NotificationCompat.getExtras(notification) == null ? null : NotificationCompat.getExtras(notification).getBundle("android.car.EXTENSIONS");
                if (bundle != null) {
                    this.f607a = (Bitmap) bundle.getParcelable("large_icon");
                    this.f609c = bundle.getInt("app_color", 0);
                    this.f608b = (UnreadConversation) NotificationCompat.f574a.getUnreadConversationFromBundle(bundle.getBundle("car_conversation"), UnreadConversation.f610a, RemoteInput.FACTORY);
                }
            }
        }

        public Builder extend(Builder builder) {
            if (Build.VERSION.SDK_INT >= 21) {
                Bundle bundle = new Bundle();
                if (this.f607a != null) {
                    bundle.putParcelable("large_icon", this.f607a);
                }
                if (this.f609c != 0) {
                    bundle.putInt("app_color", this.f609c);
                }
                if (this.f608b != null) {
                    bundle.putBundle("car_conversation", NotificationCompat.f574a.getBundleForUnreadConversation(this.f608b));
                }
                builder.getExtras().putBundle("android.car.EXTENSIONS", bundle);
            }
            return builder;
        }

        public int getColor() {
            return this.f609c;
        }

        public Bitmap getLargeIcon() {
            return this.f607a;
        }

        public UnreadConversation getUnreadConversation() {
            return this.f608b;
        }

        public CarExtender setColor(int i) {
            this.f609c = i;
            return this;
        }

        public CarExtender setLargeIcon(Bitmap bitmap) {
            this.f607a = bitmap;
            return this;
        }

        public CarExtender setUnreadConversation(UnreadConversation unreadConversation) {
            this.f608b = unreadConversation;
            return this;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$Extender */
    public interface Extender {
        Builder extend(Builder builder);
    }

    /* renamed from: android.support.v4.app.NotificationCompat$InboxStyle */
    public class InboxStyle extends Style {

        /* renamed from: a */
        ArrayList<CharSequence> f623a = new ArrayList<>();

        public InboxStyle() {
        }

        public InboxStyle(Builder builder) {
            setBuilder(builder);
        }

        public InboxStyle addLine(CharSequence charSequence) {
            this.f623a.add(Builder.m559a(charSequence));
            return this;
        }

        public InboxStyle setBigContentTitle(CharSequence charSequence) {
            this.f625e = Builder.m559a(charSequence);
            return this;
        }

        public InboxStyle setSummaryText(CharSequence charSequence) {
            this.f626f = Builder.m559a(charSequence);
            this.f627g = true;
            return this;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatImpl */
    interface NotificationCompatImpl {
        Notification build(Builder builder, BuilderExtender builderExtender);

        Action getAction(Notification notification, int i);

        int getActionCount(Notification notification);

        Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList);

        Bundle getBundleForUnreadConversation(NotificationCompatBase.UnreadConversation unreadConversation);

        String getCategory(Notification notification);

        Bundle getExtras(Notification notification);

        String getGroup(Notification notification);

        boolean getLocalOnly(Notification notification);

        ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actionArr);

        String getSortKey(Notification notification);

        NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(Bundle bundle, NotificationCompatBase.UnreadConversation.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2);

        boolean isGroupSummary(Notification notification);
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatImplApi20 */
    class NotificationCompatImplApi20 extends NotificationCompatImplKitKat {
        NotificationCompatImplApi20() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            NotificationCompatApi20.Builder builder2 = new NotificationCompatApi20.Builder(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.f592c, builder.mNumber, builder.f590a, builder.f591b, builder.mLargeIcon, builder.f595f, builder.f596g, builder.f597h, builder.f594e, builder.mUseChronometer, builder.f593d, builder.mSubText, builder.f601l, builder.mPeople, builder.f603n, builder.f598i, builder.f599j, builder.f600k);
            NotificationCompat.m554b((NotificationBuilderWithActions) builder2, builder.mActions);
            NotificationCompat.m555b((NotificationBuilderWithBuilderAccessor) builder2, builder.mStyle);
            return builderExtender.build(builder, builder2);
        }

        public Action getAction(Notification notification, int i) {
            return (Action) NotificationCompatApi20.getAction(notification, i, Action.FACTORY, RemoteInput.FACTORY);
        }

        public Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList) {
            return (Action[]) NotificationCompatApi20.getActionsFromParcelableArrayList(arrayList, Action.FACTORY, RemoteInput.FACTORY);
        }

        public String getGroup(Notification notification) {
            return NotificationCompatApi20.getGroup(notification);
        }

        public boolean getLocalOnly(Notification notification) {
            return NotificationCompatApi20.getLocalOnly(notification);
        }

        public ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actionArr) {
            return NotificationCompatApi20.getParcelableArrayListForActions(actionArr);
        }

        public String getSortKey(Notification notification) {
            return NotificationCompatApi20.getSortKey(notification);
        }

        public boolean isGroupSummary(Notification notification) {
            return NotificationCompatApi20.isGroupSummary(notification);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatImplApi21 */
    class NotificationCompatImplApi21 extends NotificationCompatImplApi20 {
        NotificationCompatImplApi21() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            NotificationCompatApi21.Builder builder2 = new NotificationCompatApi21.Builder(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.f592c, builder.mNumber, builder.f590a, builder.f591b, builder.mLargeIcon, builder.f595f, builder.f596g, builder.f597h, builder.f594e, builder.mUseChronometer, builder.f593d, builder.mSubText, builder.f601l, builder.f602m, builder.mPeople, builder.f603n, builder.f604o, builder.f605p, builder.f606q, builder.f598i, builder.f599j, builder.f600k);
            NotificationCompat.m554b((NotificationBuilderWithActions) builder2, builder.mActions);
            NotificationCompat.m555b((NotificationBuilderWithBuilderAccessor) builder2, builder.mStyle);
            return builderExtender.build(builder, builder2);
        }

        public Bundle getBundleForUnreadConversation(NotificationCompatBase.UnreadConversation unreadConversation) {
            return NotificationCompatApi21.m566a(unreadConversation);
        }

        public String getCategory(Notification notification) {
            return NotificationCompatApi21.getCategory(notification);
        }

        public NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(Bundle bundle, NotificationCompatBase.UnreadConversation.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
            return NotificationCompatApi21.m567a(bundle, factory, factory2);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatImplBase */
    class NotificationCompatImplBase implements NotificationCompatImpl {
        NotificationCompatImplBase() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            Notification notification = builder.mNotification;
            notification.setLatestEventInfo(builder.mContext, builder.mContentTitle, builder.mContentText, builder.f590a);
            if (builder.f593d > 0) {
                notification.flags |= 128;
            }
            return notification;
        }

        public Action getAction(Notification notification, int i) {
            return null;
        }

        public int getActionCount(Notification notification) {
            return 0;
        }

        public Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList) {
            return null;
        }

        public Bundle getBundleForUnreadConversation(NotificationCompatBase.UnreadConversation unreadConversation) {
            return null;
        }

        public String getCategory(Notification notification) {
            return null;
        }

        public Bundle getExtras(Notification notification) {
            return null;
        }

        public String getGroup(Notification notification) {
            return null;
        }

        public boolean getLocalOnly(Notification notification) {
            return false;
        }

        public ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actionArr) {
            return null;
        }

        public String getSortKey(Notification notification) {
            return null;
        }

        public NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(Bundle bundle, NotificationCompatBase.UnreadConversation.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
            return null;
        }

        public boolean isGroupSummary(Notification notification) {
            return false;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatImplGingerbread */
    class NotificationCompatImplGingerbread extends NotificationCompatImplBase {
        NotificationCompatImplGingerbread() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            Notification notification = builder.mNotification;
            notification.setLatestEventInfo(builder.mContext, builder.mContentTitle, builder.mContentText, builder.f590a);
            Notification add = NotificationCompatGingerbread.add(notification, builder.mContext, builder.mContentTitle, builder.mContentText, builder.f590a, builder.f591b);
            if (builder.f593d > 0) {
                add.flags |= 128;
            }
            return add;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatImplHoneycomb */
    class NotificationCompatImplHoneycomb extends NotificationCompatImplBase {
        NotificationCompatImplHoneycomb() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            return NotificationCompatHoneycomb.m569a(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.f592c, builder.mNumber, builder.f590a, builder.f591b, builder.mLargeIcon);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatImplIceCreamSandwich */
    class NotificationCompatImplIceCreamSandwich extends NotificationCompatImplBase {
        NotificationCompatImplIceCreamSandwich() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            return builderExtender.build(builder, new NotificationCompatIceCreamSandwich.Builder(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.f592c, builder.mNumber, builder.f590a, builder.f591b, builder.mLargeIcon, builder.f595f, builder.f596g, builder.f597h));
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatImplJellybean */
    class NotificationCompatImplJellybean extends NotificationCompatImplBase {
        NotificationCompatImplJellybean() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            NotificationCompatJellybean.Builder builder2 = new NotificationCompatJellybean.Builder(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.f592c, builder.mNumber, builder.f590a, builder.f591b, builder.mLargeIcon, builder.f595f, builder.f596g, builder.f597h, builder.mUseChronometer, builder.f593d, builder.mSubText, builder.f601l, builder.f603n, builder.f598i, builder.f599j, builder.f600k);
            NotificationCompat.m554b((NotificationBuilderWithActions) builder2, builder.mActions);
            NotificationCompat.m555b((NotificationBuilderWithBuilderAccessor) builder2, builder.mStyle);
            return builderExtender.build(builder, builder2);
        }

        public Action getAction(Notification notification, int i) {
            return (Action) NotificationCompatJellybean.getAction(notification, i, Action.FACTORY, RemoteInput.FACTORY);
        }

        public int getActionCount(Notification notification) {
            return NotificationCompatJellybean.getActionCount(notification);
        }

        public Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList) {
            return (Action[]) NotificationCompatJellybean.getActionsFromParcelableArrayList(arrayList, Action.FACTORY, RemoteInput.FACTORY);
        }

        public Bundle getExtras(Notification notification) {
            return NotificationCompatJellybean.getExtras(notification);
        }

        public String getGroup(Notification notification) {
            return NotificationCompatJellybean.getGroup(notification);
        }

        public boolean getLocalOnly(Notification notification) {
            return NotificationCompatJellybean.getLocalOnly(notification);
        }

        public ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actionArr) {
            return NotificationCompatJellybean.getParcelableArrayListForActions(actionArr);
        }

        public String getSortKey(Notification notification) {
            return NotificationCompatJellybean.getSortKey(notification);
        }

        public boolean isGroupSummary(Notification notification) {
            return NotificationCompatJellybean.isGroupSummary(notification);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatImplKitKat */
    class NotificationCompatImplKitKat extends NotificationCompatImplJellybean {
        NotificationCompatImplKitKat() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            NotificationCompatKitKat.Builder builder2 = new NotificationCompatKitKat.Builder(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.f592c, builder.mNumber, builder.f590a, builder.f591b, builder.mLargeIcon, builder.f595f, builder.f596g, builder.f597h, builder.f594e, builder.mUseChronometer, builder.f593d, builder.mSubText, builder.f601l, builder.mPeople, builder.f603n, builder.f598i, builder.f599j, builder.f600k);
            NotificationCompat.m554b((NotificationBuilderWithActions) builder2, builder.mActions);
            NotificationCompat.m555b((NotificationBuilderWithBuilderAccessor) builder2, builder.mStyle);
            return builderExtender.build(builder, builder2);
        }

        public Action getAction(Notification notification, int i) {
            return (Action) NotificationCompatKitKat.getAction(notification, i, Action.FACTORY, RemoteInput.FACTORY);
        }

        public int getActionCount(Notification notification) {
            return NotificationCompatKitKat.getActionCount(notification);
        }

        public Bundle getExtras(Notification notification) {
            return NotificationCompatKitKat.getExtras(notification);
        }

        public String getGroup(Notification notification) {
            return NotificationCompatKitKat.getGroup(notification);
        }

        public boolean getLocalOnly(Notification notification) {
            return NotificationCompatKitKat.getLocalOnly(notification);
        }

        public String getSortKey(Notification notification) {
            return NotificationCompatKitKat.getSortKey(notification);
        }

        public boolean isGroupSummary(Notification notification) {
            return NotificationCompatKitKat.isGroupSummary(notification);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$Style */
    public abstract class Style {

        /* renamed from: d */
        Builder f624d;

        /* renamed from: e */
        CharSequence f625e;

        /* renamed from: f */
        CharSequence f626f;

        /* renamed from: g */
        boolean f627g = false;

        public Notification build() {
            if (this.f624d != null) {
                return this.f624d.build();
            }
            return null;
        }

        public void setBuilder(Builder builder) {
            if (this.f624d != builder) {
                this.f624d = builder;
                if (this.f624d != null) {
                    this.f624d.setStyle(this);
                }
            }
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$WearableExtender */
    public final class WearableExtender implements Extender {
        public static final int SCREEN_TIMEOUT_LONG = -1;
        public static final int SCREEN_TIMEOUT_SHORT = 0;
        public static final int SIZE_DEFAULT = 0;
        public static final int SIZE_FULL_SCREEN = 5;
        public static final int SIZE_LARGE = 4;
        public static final int SIZE_MEDIUM = 3;
        public static final int SIZE_SMALL = 2;
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;

        /* renamed from: a */
        private ArrayList<Action> f628a = new ArrayList<>();

        /* renamed from: b */
        private int f629b = 1;

        /* renamed from: c */
        private PendingIntent f630c;

        /* renamed from: d */
        private ArrayList<Notification> f631d = new ArrayList<>();

        /* renamed from: e */
        private Bitmap f632e;

        /* renamed from: f */
        private int f633f;

        /* renamed from: g */
        private int f634g = GravityCompat.END;

        /* renamed from: h */
        private int f635h = -1;

        /* renamed from: i */
        private int f636i = 0;

        /* renamed from: j */
        private int f637j;

        /* renamed from: k */
        private int f638k = 80;

        /* renamed from: l */
        private int f639l;

        public WearableExtender() {
        }

        public WearableExtender(Notification notification) {
            Bundle extras = NotificationCompat.getExtras(notification);
            Bundle bundle = extras != null ? extras.getBundle("android.wearable.EXTENSIONS") : null;
            if (bundle != null) {
                Action[] actionsFromParcelableArrayList = NotificationCompat.f574a.getActionsFromParcelableArrayList(bundle.getParcelableArrayList("actions"));
                if (actionsFromParcelableArrayList != null) {
                    Collections.addAll(this.f628a, actionsFromParcelableArrayList);
                }
                this.f629b = bundle.getInt("flags", 1);
                this.f630c = (PendingIntent) bundle.getParcelable("displayIntent");
                Notification[] a = NotificationCompat.m556b(bundle, "pages");
                if (a != null) {
                    Collections.addAll(this.f631d, a);
                }
                this.f632e = (Bitmap) bundle.getParcelable("background");
                this.f633f = bundle.getInt("contentIcon");
                this.f634g = bundle.getInt("contentIconGravity", GravityCompat.END);
                this.f635h = bundle.getInt("contentActionIndex", -1);
                this.f636i = bundle.getInt("customSizePreset", 0);
                this.f637j = bundle.getInt("customContentHeight");
                this.f638k = bundle.getInt("gravity", 80);
                this.f639l = bundle.getInt("hintScreenTimeout");
            }
        }

        /* renamed from: a */
        private void m562a(int i, boolean z) {
            if (z) {
                this.f629b |= i;
            } else {
                this.f629b &= i ^ -1;
            }
        }

        public WearableExtender addAction(Action action) {
            this.f628a.add(action);
            return this;
        }

        public WearableExtender addActions(List<Action> list) {
            this.f628a.addAll(list);
            return this;
        }

        public WearableExtender addPage(Notification notification) {
            this.f631d.add(notification);
            return this;
        }

        public WearableExtender addPages(List<Notification> list) {
            this.f631d.addAll(list);
            return this;
        }

        public WearableExtender clearActions() {
            this.f628a.clear();
            return this;
        }

        public WearableExtender clearPages() {
            this.f631d.clear();
            return this;
        }

        public WearableExtender clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.f628a = new ArrayList<>(this.f628a);
            wearableExtender.f629b = this.f629b;
            wearableExtender.f630c = this.f630c;
            wearableExtender.f631d = new ArrayList<>(this.f631d);
            wearableExtender.f632e = this.f632e;
            wearableExtender.f633f = this.f633f;
            wearableExtender.f634g = this.f634g;
            wearableExtender.f635h = this.f635h;
            wearableExtender.f636i = this.f636i;
            wearableExtender.f637j = this.f637j;
            wearableExtender.f638k = this.f638k;
            wearableExtender.f639l = this.f639l;
            return wearableExtender;
        }

        public Builder extend(Builder builder) {
            Bundle bundle = new Bundle();
            if (!this.f628a.isEmpty()) {
                bundle.putParcelableArrayList("actions", NotificationCompat.f574a.getParcelableArrayListForActions((Action[]) this.f628a.toArray(new Action[this.f628a.size()])));
            }
            if (this.f629b != 1) {
                bundle.putInt("flags", this.f629b);
            }
            if (this.f630c != null) {
                bundle.putParcelable("displayIntent", this.f630c);
            }
            if (!this.f631d.isEmpty()) {
                bundle.putParcelableArray("pages", (Parcelable[]) this.f631d.toArray(new Notification[this.f631d.size()]));
            }
            if (this.f632e != null) {
                bundle.putParcelable("background", this.f632e);
            }
            if (this.f633f != 0) {
                bundle.putInt("contentIcon", this.f633f);
            }
            if (this.f634g != 8388613) {
                bundle.putInt("contentIconGravity", this.f634g);
            }
            if (this.f635h != -1) {
                bundle.putInt("contentActionIndex", this.f635h);
            }
            if (this.f636i != 0) {
                bundle.putInt("customSizePreset", this.f636i);
            }
            if (this.f637j != 0) {
                bundle.putInt("customContentHeight", this.f637j);
            }
            if (this.f638k != 80) {
                bundle.putInt("gravity", this.f638k);
            }
            if (this.f639l != 0) {
                bundle.putInt("hintScreenTimeout", this.f639l);
            }
            builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
            return builder;
        }

        public List<Action> getActions() {
            return this.f628a;
        }

        public Bitmap getBackground() {
            return this.f632e;
        }

        public int getContentAction() {
            return this.f635h;
        }

        public int getContentIcon() {
            return this.f633f;
        }

        public int getContentIconGravity() {
            return this.f634g;
        }

        public boolean getContentIntentAvailableOffline() {
            return (this.f629b & 1) != 0;
        }

        public int getCustomContentHeight() {
            return this.f637j;
        }

        public int getCustomSizePreset() {
            return this.f636i;
        }

        public PendingIntent getDisplayIntent() {
            return this.f630c;
        }

        public int getGravity() {
            return this.f638k;
        }

        public boolean getHintAvoidBackgroundClipping() {
            return (this.f629b & 16) != 0;
        }

        public boolean getHintHideIcon() {
            return (this.f629b & 2) != 0;
        }

        public int getHintScreenTimeout() {
            return this.f639l;
        }

        public boolean getHintShowBackgroundOnly() {
            return (this.f629b & 4) != 0;
        }

        public List<Notification> getPages() {
            return this.f631d;
        }

        public boolean getStartScrollBottom() {
            return (this.f629b & 8) != 0;
        }

        public WearableExtender setBackground(Bitmap bitmap) {
            this.f632e = bitmap;
            return this;
        }

        public WearableExtender setContentAction(int i) {
            this.f635h = i;
            return this;
        }

        public WearableExtender setContentIcon(int i) {
            this.f633f = i;
            return this;
        }

        public WearableExtender setContentIconGravity(int i) {
            this.f634g = i;
            return this;
        }

        public WearableExtender setContentIntentAvailableOffline(boolean z) {
            m562a(1, z);
            return this;
        }

        public WearableExtender setCustomContentHeight(int i) {
            this.f637j = i;
            return this;
        }

        public WearableExtender setCustomSizePreset(int i) {
            this.f636i = i;
            return this;
        }

        public WearableExtender setDisplayIntent(PendingIntent pendingIntent) {
            this.f630c = pendingIntent;
            return this;
        }

        public WearableExtender setGravity(int i) {
            this.f638k = i;
            return this;
        }

        public WearableExtender setHintAvoidBackgroundClipping(boolean z) {
            m562a(16, z);
            return this;
        }

        public WearableExtender setHintHideIcon(boolean z) {
            m562a(2, z);
            return this;
        }

        public WearableExtender setHintScreenTimeout(int i) {
            this.f639l = i;
            return this;
        }

        public WearableExtender setHintShowBackgroundOnly(boolean z) {
            m562a(4, z);
            return this;
        }

        public WearableExtender setStartScrollBottom(boolean z) {
            m562a(8, z);
            return this;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f574a = new NotificationCompatImplApi21();
        } else if (Build.VERSION.SDK_INT >= 20) {
            f574a = new NotificationCompatImplApi20();
        } else if (Build.VERSION.SDK_INT >= 19) {
            f574a = new NotificationCompatImplKitKat();
        } else if (Build.VERSION.SDK_INT >= 16) {
            f574a = new NotificationCompatImplJellybean();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f574a = new NotificationCompatImplIceCreamSandwich();
        } else if (Build.VERSION.SDK_INT >= 11) {
            f574a = new NotificationCompatImplHoneycomb();
        } else if (Build.VERSION.SDK_INT >= 9) {
            f574a = new NotificationCompatImplGingerbread();
        } else {
            f574a = new NotificationCompatImplBase();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m554b(NotificationBuilderWithActions notificationBuilderWithActions, ArrayList<Action> arrayList) {
        Iterator<Action> it = arrayList.iterator();
        while (it.hasNext()) {
            notificationBuilderWithActions.addAction(it.next());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m555b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, Style style) {
        if (style == null) {
            return;
        }
        if (style instanceof BigTextStyle) {
            BigTextStyle bigTextStyle = (BigTextStyle) style;
            NotificationCompatJellybean.addBigTextStyle(notificationBuilderWithBuilderAccessor, bigTextStyle.f625e, bigTextStyle.f627g, bigTextStyle.f626f, bigTextStyle.f589a);
        } else if (style instanceof InboxStyle) {
            InboxStyle inboxStyle = (InboxStyle) style;
            NotificationCompatJellybean.addInboxStyle(notificationBuilderWithBuilderAccessor, inboxStyle.f625e, inboxStyle.f627g, inboxStyle.f626f, inboxStyle.f623a);
        } else if (style instanceof BigPictureStyle) {
            BigPictureStyle bigPictureStyle = (BigPictureStyle) style;
            NotificationCompatJellybean.addBigPictureStyle(notificationBuilderWithBuilderAccessor, bigPictureStyle.f625e, bigPictureStyle.f627g, bigPictureStyle.f626f, bigPictureStyle.f586a, bigPictureStyle.f587b, bigPictureStyle.f588c);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Notification[] m556b(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Notification[]) || parcelableArray == null) {
            return (Notification[]) parcelableArray;
        }
        Notification[] notificationArr = new Notification[parcelableArray.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < parcelableArray.length) {
                notificationArr[i2] = (Notification) parcelableArray[i2];
                i = i2 + 1;
            } else {
                bundle.putParcelableArray(str, notificationArr);
                return notificationArr;
            }
        }
    }

    public static Action getAction(Notification notification, int i) {
        return f574a.getAction(notification, i);
    }

    public static int getActionCount(Notification notification) {
        return f574a.getActionCount(notification);
    }

    public static String getCategory(Notification notification) {
        return f574a.getCategory(notification);
    }

    public static Bundle getExtras(Notification notification) {
        return f574a.getExtras(notification);
    }

    public static String getGroup(Notification notification) {
        return f574a.getGroup(notification);
    }

    public static boolean getLocalOnly(Notification notification) {
        return f574a.getLocalOnly(notification);
    }

    public static String getSortKey(Notification notification) {
        return f574a.getSortKey(notification);
    }

    public static boolean isGroupSummary(Notification notification) {
        return f574a.isGroupSummary(notification);
    }
}
