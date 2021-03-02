package android.support.p001v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.p001v4.app.NotificationCompatApi20;
import android.support.p001v4.app.NotificationCompatApi21;
import android.support.p001v4.app.NotificationCompatBase;
import android.support.p001v4.app.NotificationCompatIceCreamSandwich;
import android.support.p001v4.app.NotificationCompatJellybean;
import android.support.p001v4.app.NotificationCompatKitKat;
import android.support.p001v4.app.RemoteInputCompatBase;
import android.support.p001v4.view.GravityCompat;
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
    @ColorInt
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
    public static final C0072a f275a;

    /* renamed from: android.support.v4.app.NotificationCompat$Extender */
    public interface Extender {
        Builder extend(Builder builder);
    }

    /* renamed from: android.support.v4.app.NotificationCompat$a */
    interface C0072a {
        /* renamed from: a */
        Notification mo651a(Builder builder, BuilderExtender builderExtender);

        /* renamed from: a */
        Bundle mo652a(Notification notification);

        /* renamed from: a */
        Bundle mo653a(NotificationCompatBase.UnreadConversation unreadConversation);

        /* renamed from: a */
        Action mo654a(Notification notification, int i);

        /* renamed from: a */
        NotificationCompatBase.UnreadConversation mo655a(Bundle bundle, NotificationCompatBase.UnreadConversation.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2);

        /* renamed from: a */
        ArrayList<Parcelable> mo656a(Action[] actionArr);

        /* renamed from: a */
        Action[] mo657a(ArrayList<Parcelable> arrayList);

        /* renamed from: b */
        int mo658b(Notification notification);

        /* renamed from: c */
        String mo659c(Notification notification);

        /* renamed from: d */
        boolean mo660d(Notification notification);

        /* renamed from: e */
        String mo661e(Notification notification);

        /* renamed from: f */
        boolean mo662f(Notification notification);

        /* renamed from: g */
        String mo663g(Notification notification);
    }

    /* renamed from: android.support.v4.app.NotificationCompat$BuilderExtender */
    public static class BuilderExtender {
        public Notification build(Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return notificationBuilderWithBuilderAccessor.build();
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$d */
    static class C0075d implements C0072a {
        C0075d() {
        }

        /* renamed from: a */
        public Notification mo651a(Builder builder, BuilderExtender builderExtender) {
            Notification notification = builder.mNotification;
            notification.setLatestEventInfo(builder.mContext, builder.mContentTitle, builder.mContentText, builder.f291a);
            if (builder.f294d > 0) {
                notification.flags |= 128;
            }
            return notification;
        }

        /* renamed from: a */
        public Bundle mo652a(Notification notification) {
            return null;
        }

        /* renamed from: b */
        public int mo658b(Notification notification) {
            return 0;
        }

        /* renamed from: a */
        public Action mo654a(Notification notification, int i) {
            return null;
        }

        /* renamed from: a */
        public Action[] mo657a(ArrayList<Parcelable> arrayList) {
            return null;
        }

        /* renamed from: a */
        public ArrayList<Parcelable> mo656a(Action[] actionArr) {
            return null;
        }

        /* renamed from: c */
        public String mo659c(Notification notification) {
            return null;
        }

        /* renamed from: d */
        public boolean mo660d(Notification notification) {
            return false;
        }

        /* renamed from: e */
        public String mo661e(Notification notification) {
            return null;
        }

        /* renamed from: f */
        public boolean mo662f(Notification notification) {
            return false;
        }

        /* renamed from: g */
        public String mo663g(Notification notification) {
            return null;
        }

        /* renamed from: a */
        public Bundle mo653a(NotificationCompatBase.UnreadConversation unreadConversation) {
            return null;
        }

        /* renamed from: a */
        public NotificationCompatBase.UnreadConversation mo655a(Bundle bundle, NotificationCompatBase.UnreadConversation.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
            return null;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$e */
    static class C0076e extends C0075d {
        C0076e() {
        }

        /* renamed from: a */
        public Notification mo651a(Builder builder, BuilderExtender builderExtender) {
            Notification notification = builder.mNotification;
            notification.setLatestEventInfo(builder.mContext, builder.mContentTitle, builder.mContentText, builder.f291a);
            Notification a = C0001aa.m2a(notification, builder.mContext, builder.mContentTitle, builder.mContentText, builder.f291a, builder.f292b);
            if (builder.f294d > 0) {
                a.flags |= 128;
            }
            return a;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$f */
    static class C0077f extends C0075d {
        C0077f() {
        }

        /* renamed from: a */
        public Notification mo651a(Builder builder, BuilderExtender builderExtender) {
            return C0002ab.m3a(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.f293c, builder.mNumber, builder.f291a, builder.f292b, builder.mLargeIcon);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$g */
    static class C0078g extends C0075d {
        C0078g() {
        }

        /* renamed from: a */
        public Notification mo651a(Builder builder, BuilderExtender builderExtender) {
            return builderExtender.build(builder, new NotificationCompatIceCreamSandwich.Builder(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.f293c, builder.mNumber, builder.f291a, builder.f292b, builder.mLargeIcon, builder.f296f, builder.f297g, builder.f298h));
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$h */
    static class C0079h extends C0075d {
        C0079h() {
        }

        /* renamed from: a */
        public Notification mo651a(Builder builder, BuilderExtender builderExtender) {
            NotificationCompatJellybean.Builder builder2 = new NotificationCompatJellybean.Builder(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.f293c, builder.mNumber, builder.f291a, builder.f292b, builder.mLargeIcon, builder.f296f, builder.f297g, builder.f298h, builder.mUseChronometer, builder.f294d, builder.mSubText, builder.f302l, builder.f304n, builder.f299i, builder.f300j, builder.f301k);
            NotificationCompat.m261b((C2018z) builder2, builder.mActions);
            NotificationCompat.m260b((NotificationBuilderWithBuilderAccessor) builder2, builder.mStyle);
            return builderExtender.build(builder, builder2);
        }

        /* renamed from: a */
        public Bundle mo652a(Notification notification) {
            return NotificationCompatJellybean.m345a(notification);
        }

        /* renamed from: b */
        public int mo658b(Notification notification) {
            return NotificationCompatJellybean.m357b(notification);
        }

        /* renamed from: a */
        public Action mo654a(Notification notification, int i) {
            return (Action) NotificationCompatJellybean.m347a(notification, i, Action.FACTORY, RemoteInput.FACTORY);
        }

        /* renamed from: a */
        public Action[] mo657a(ArrayList<Parcelable> arrayList) {
            return (Action[]) NotificationCompatJellybean.m356a(arrayList, Action.FACTORY, RemoteInput.FACTORY);
        }

        /* renamed from: a */
        public ArrayList<Parcelable> mo656a(Action[] actionArr) {
            return NotificationCompatJellybean.m351a((NotificationCompatBase.Action[]) actionArr);
        }

        /* renamed from: d */
        public boolean mo660d(Notification notification) {
            return NotificationCompatJellybean.m358c(notification);
        }

        /* renamed from: e */
        public String mo661e(Notification notification) {
            return NotificationCompatJellybean.m359d(notification);
        }

        /* renamed from: f */
        public boolean mo662f(Notification notification) {
            return NotificationCompatJellybean.m360e(notification);
        }

        /* renamed from: g */
        public String mo663g(Notification notification) {
            return NotificationCompatJellybean.m361f(notification);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$i */
    static class C0080i extends C0079h {
        C0080i() {
        }

        /* renamed from: a */
        public Notification mo651a(Builder builder, BuilderExtender builderExtender) {
            NotificationCompatKitKat.Builder builder2 = new NotificationCompatKitKat.Builder(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.f293c, builder.mNumber, builder.f291a, builder.f292b, builder.mLargeIcon, builder.f296f, builder.f297g, builder.f298h, builder.f295e, builder.mUseChronometer, builder.f294d, builder.mSubText, builder.f302l, builder.mPeople, builder.f304n, builder.f299i, builder.f300j, builder.f301k);
            NotificationCompat.m261b((C2018z) builder2, builder.mActions);
            NotificationCompat.m260b((NotificationBuilderWithBuilderAccessor) builder2, builder.mStyle);
            return builderExtender.build(builder, builder2);
        }

        /* renamed from: a */
        public Bundle mo652a(Notification notification) {
            return NotificationCompatKitKat.m363a(notification);
        }

        /* renamed from: b */
        public int mo658b(Notification notification) {
            return NotificationCompatKitKat.m365b(notification);
        }

        /* renamed from: a */
        public Action mo654a(Notification notification, int i) {
            return (Action) NotificationCompatKitKat.m364a(notification, i, Action.FACTORY, RemoteInput.FACTORY);
        }

        /* renamed from: d */
        public boolean mo660d(Notification notification) {
            return NotificationCompatKitKat.m366c(notification);
        }

        /* renamed from: e */
        public String mo661e(Notification notification) {
            return NotificationCompatKitKat.m367d(notification);
        }

        /* renamed from: f */
        public boolean mo662f(Notification notification) {
            return NotificationCompatKitKat.m368e(notification);
        }

        /* renamed from: g */
        public String mo663g(Notification notification) {
            return NotificationCompatKitKat.m369f(notification);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$b */
    static class C0073b extends C0080i {
        C0073b() {
        }

        /* renamed from: a */
        public Notification mo651a(Builder builder, BuilderExtender builderExtender) {
            NotificationCompatApi20.Builder builder2 = new NotificationCompatApi20.Builder(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.f293c, builder.mNumber, builder.f291a, builder.f292b, builder.mLargeIcon, builder.f296f, builder.f297g, builder.f298h, builder.f295e, builder.mUseChronometer, builder.f294d, builder.mSubText, builder.f302l, builder.mPeople, builder.f304n, builder.f299i, builder.f300j, builder.f301k);
            NotificationCompat.m261b((C2018z) builder2, builder.mActions);
            NotificationCompat.m260b((NotificationBuilderWithBuilderAccessor) builder2, builder.mStyle);
            return builderExtender.build(builder, builder2);
        }

        /* renamed from: a */
        public Action mo654a(Notification notification, int i) {
            return (Action) NotificationCompatApi20.m331a(notification, i, Action.FACTORY, RemoteInput.FACTORY);
        }

        /* renamed from: a */
        public Action[] mo657a(ArrayList<Parcelable> arrayList) {
            return (Action[]) NotificationCompatApi20.m335a(arrayList, Action.FACTORY, RemoteInput.FACTORY);
        }

        /* renamed from: a */
        public ArrayList<Parcelable> mo656a(Action[] actionArr) {
            return NotificationCompatApi20.m332a((NotificationCompatBase.Action[]) actionArr);
        }

        /* renamed from: d */
        public boolean mo660d(Notification notification) {
            return NotificationCompatApi20.m334a(notification);
        }

        /* renamed from: e */
        public String mo661e(Notification notification) {
            return NotificationCompatApi20.m336b(notification);
        }

        /* renamed from: f */
        public boolean mo662f(Notification notification) {
            return NotificationCompatApi20.m337c(notification);
        }

        /* renamed from: g */
        public String mo663g(Notification notification) {
            return NotificationCompatApi20.m338d(notification);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$c */
    static class C0074c extends C0073b {
        C0074c() {
        }

        /* renamed from: a */
        public Notification mo651a(Builder builder, BuilderExtender builderExtender) {
            NotificationCompatApi21.Builder builder2 = new NotificationCompatApi21.Builder(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.f293c, builder.mNumber, builder.f291a, builder.f292b, builder.mLargeIcon, builder.f296f, builder.f297g, builder.f298h, builder.f295e, builder.mUseChronometer, builder.f294d, builder.mSubText, builder.f302l, builder.f303m, builder.mPeople, builder.f304n, builder.f305o, builder.f306p, builder.f307q, builder.f299i, builder.f300j, builder.f301k);
            NotificationCompat.m261b((C2018z) builder2, builder.mActions);
            NotificationCompat.m260b((NotificationBuilderWithBuilderAccessor) builder2, builder.mStyle);
            return builderExtender.build(builder, builder2);
        }

        /* renamed from: c */
        public String mo659c(Notification notification) {
            return NotificationCompatApi21.m343a(notification);
        }

        /* renamed from: a */
        public Bundle mo653a(NotificationCompatBase.UnreadConversation unreadConversation) {
            return NotificationCompatApi21.m340a(unreadConversation);
        }

        /* renamed from: a */
        public NotificationCompatBase.UnreadConversation mo655a(Bundle bundle, NotificationCompatBase.UnreadConversation.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
            return NotificationCompatApi21.m341a(bundle, factory, factory2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m261b(C2018z zVar, ArrayList<Action> arrayList) {
        Iterator<Action> it = arrayList.iterator();
        while (it.hasNext()) {
            zVar.addAction(it.next());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m260b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, Style style) {
        if (style == null) {
            return;
        }
        if (style instanceof BigTextStyle) {
            BigTextStyle bigTextStyle = (BigTextStyle) style;
            NotificationCompatJellybean.m353a(notificationBuilderWithBuilderAccessor, bigTextStyle.f326e, bigTextStyle.f328g, bigTextStyle.f327f, bigTextStyle.f290a);
        } else if (style instanceof InboxStyle) {
            InboxStyle inboxStyle = (InboxStyle) style;
            NotificationCompatJellybean.m354a(notificationBuilderWithBuilderAccessor, inboxStyle.f326e, inboxStyle.f328g, inboxStyle.f327f, inboxStyle.f324a);
        } else if (style instanceof BigPictureStyle) {
            BigPictureStyle bigPictureStyle = (BigPictureStyle) style;
            NotificationCompatJellybean.m352a(notificationBuilderWithBuilderAccessor, bigPictureStyle.f326e, bigPictureStyle.f328g, bigPictureStyle.f327f, bigPictureStyle.f287a, bigPictureStyle.f288b, bigPictureStyle.f289c);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f275a = new C0074c();
        } else if (Build.VERSION.SDK_INT >= 20) {
            f275a = new C0073b();
        } else if (Build.VERSION.SDK_INT >= 19) {
            f275a = new C0080i();
        } else if (Build.VERSION.SDK_INT >= 16) {
            f275a = new C0079h();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f275a = new C0078g();
        } else if (Build.VERSION.SDK_INT >= 11) {
            f275a = new C0077f();
        } else if (Build.VERSION.SDK_INT >= 9) {
            f275a = new C0076e();
        } else {
            f275a = new C0075d();
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$Builder */
    public static class Builder {

        /* renamed from: a */
        PendingIntent f291a;

        /* renamed from: b */
        PendingIntent f292b;

        /* renamed from: c */
        RemoteViews f293c;

        /* renamed from: d */
        int f294d;

        /* renamed from: e */
        boolean f295e = true;

        /* renamed from: f */
        int f296f;

        /* renamed from: g */
        int f297g;

        /* renamed from: h */
        boolean f298h;

        /* renamed from: i */
        String f299i;

        /* renamed from: j */
        boolean f300j;

        /* renamed from: k */
        String f301k;

        /* renamed from: l */
        boolean f302l = false;

        /* renamed from: m */
        String f303m;
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
        Bundle f304n;

        /* renamed from: o */
        int f305o = 0;

        /* renamed from: p */
        int f306p = 0;

        /* renamed from: q */
        Notification f307q;

        public Builder(Context context) {
            this.mContext = context;
            this.mNotification.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.f294d = 0;
            this.mPeople = new ArrayList<>();
        }

        public Builder setWhen(long j) {
            this.mNotification.when = j;
            return this;
        }

        public Builder setShowWhen(boolean z) {
            this.f295e = z;
            return this;
        }

        public Builder setUsesChronometer(boolean z) {
            this.mUseChronometer = z;
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

        public Builder setContentTitle(CharSequence charSequence) {
            this.mContentTitle = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setContentText(CharSequence charSequence) {
            this.mContentText = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setSubText(CharSequence charSequence) {
            this.mSubText = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setNumber(int i) {
            this.mNumber = i;
            return this;
        }

        public Builder setContentInfo(CharSequence charSequence) {
            this.mContentInfo = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setProgress(int i, int i2, boolean z) {
            this.f296f = i;
            this.f297g = i2;
            this.f298h = z;
            return this;
        }

        public Builder setContent(RemoteViews remoteViews) {
            this.mNotification.contentView = remoteViews;
            return this;
        }

        public Builder setContentIntent(PendingIntent pendingIntent) {
            this.f291a = pendingIntent;
            return this;
        }

        public Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.mNotification.deleteIntent = pendingIntent;
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
            this.f292b = pendingIntent;
            m267a(128, z);
            return this;
        }

        public Builder setTicker(CharSequence charSequence) {
            this.mNotification.tickerText = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            this.mNotification.tickerText = limitCharSequenceLength(charSequence);
            this.f293c = remoteViews;
            return this;
        }

        public Builder setLargeIcon(Bitmap bitmap) {
            this.mLargeIcon = bitmap;
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

        public Builder setVibrate(long[] jArr) {
            this.mNotification.vibrate = jArr;
            return this;
        }

        public Builder setLights(@ColorInt int i, int i2, int i3) {
            boolean z;
            int i4 = 1;
            this.mNotification.ledARGB = i;
            this.mNotification.ledOnMS = i2;
            this.mNotification.ledOffMS = i3;
            if (this.mNotification.ledOnMS == 0 || this.mNotification.ledOffMS == 0) {
                z = false;
            } else {
                z = true;
            }
            Notification notification = this.mNotification;
            int i5 = this.mNotification.flags & -2;
            if (!z) {
                i4 = 0;
            }
            notification.flags = i5 | i4;
            return this;
        }

        public Builder setOngoing(boolean z) {
            m267a(2, z);
            return this;
        }

        public Builder setOnlyAlertOnce(boolean z) {
            m267a(8, z);
            return this;
        }

        public Builder setAutoCancel(boolean z) {
            m267a(16, z);
            return this;
        }

        public Builder setLocalOnly(boolean z) {
            this.f302l = z;
            return this;
        }

        public Builder setCategory(String str) {
            this.f303m = str;
            return this;
        }

        public Builder setDefaults(int i) {
            this.mNotification.defaults = i;
            if ((i & 4) != 0) {
                this.mNotification.flags |= 1;
            }
            return this;
        }

        /* renamed from: a */
        private void m267a(int i, boolean z) {
            if (z) {
                this.mNotification.flags |= i;
                return;
            }
            this.mNotification.flags &= i ^ -1;
        }

        public Builder setPriority(int i) {
            this.f294d = i;
            return this;
        }

        public Builder addPerson(String str) {
            this.mPeople.add(str);
            return this;
        }

        public Builder setGroup(String str) {
            this.f299i = str;
            return this;
        }

        public Builder setGroupSummary(boolean z) {
            this.f300j = z;
            return this;
        }

        public Builder setSortKey(String str) {
            this.f301k = str;
            return this;
        }

        public Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                if (this.f304n == null) {
                    this.f304n = new Bundle(bundle);
                } else {
                    this.f304n.putAll(bundle);
                }
            }
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.f304n = bundle;
            return this;
        }

        public Bundle getExtras() {
            if (this.f304n == null) {
                this.f304n = new Bundle();
            }
            return this.f304n;
        }

        public Builder addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.mActions.add(new Action(i, charSequence, pendingIntent));
            return this;
        }

        public Builder addAction(Action action) {
            this.mActions.add(action);
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

        public Builder setColor(@ColorInt int i) {
            this.f305o = i;
            return this;
        }

        public Builder setVisibility(int i) {
            this.f306p = i;
            return this;
        }

        public Builder setPublicVersion(Notification notification) {
            this.f307q = notification;
            return this;
        }

        public Builder extend(Extender extender) {
            extender.extend(this);
            return this;
        }

        @Deprecated
        public Notification getNotification() {
            return build();
        }

        public Notification build() {
            return NotificationCompat.f275a.mo651a(this, getExtender());
        }

        public BuilderExtender getExtender() {
            return new BuilderExtender();
        }

        protected static CharSequence limitCharSequenceLength(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$Style */
    public static abstract class Style {

        /* renamed from: d */
        Builder f325d;

        /* renamed from: e */
        CharSequence f326e;

        /* renamed from: f */
        CharSequence f327f;

        /* renamed from: g */
        boolean f328g = false;

        public void setBuilder(Builder builder) {
            if (this.f325d != builder) {
                this.f325d = builder;
                if (this.f325d != null) {
                    this.f325d.setStyle(this);
                }
            }
        }

        public Notification build() {
            if (this.f325d != null) {
                return this.f325d.build();
            }
            return null;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$BigPictureStyle */
    public static class BigPictureStyle extends Style {

        /* renamed from: a */
        Bitmap f287a;

        /* renamed from: b */
        Bitmap f288b;

        /* renamed from: c */
        boolean f289c;

        public BigPictureStyle() {
        }

        public BigPictureStyle(Builder builder) {
            setBuilder(builder);
        }

        public BigPictureStyle setBigContentTitle(CharSequence charSequence) {
            this.f326e = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence charSequence) {
            this.f327f = Builder.limitCharSequenceLength(charSequence);
            this.f328g = true;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap bitmap) {
            this.f287a = bitmap;
            return this;
        }

        public BigPictureStyle bigLargeIcon(Bitmap bitmap) {
            this.f288b = bitmap;
            this.f289c = true;
            return this;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$BigTextStyle */
    public static class BigTextStyle extends Style {

        /* renamed from: a */
        CharSequence f290a;

        public BigTextStyle() {
        }

        public BigTextStyle(Builder builder) {
            setBuilder(builder);
        }

        public BigTextStyle setBigContentTitle(CharSequence charSequence) {
            this.f326e = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence charSequence) {
            this.f327f = Builder.limitCharSequenceLength(charSequence);
            this.f328g = true;
            return this;
        }

        public BigTextStyle bigText(CharSequence charSequence) {
            this.f290a = Builder.limitCharSequenceLength(charSequence);
            return this;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$InboxStyle */
    public static class InboxStyle extends Style {

        /* renamed from: a */
        ArrayList<CharSequence> f324a = new ArrayList<>();

        public InboxStyle() {
        }

        public InboxStyle(Builder builder) {
            setBuilder(builder);
        }

        public InboxStyle setBigContentTitle(CharSequence charSequence) {
            this.f326e = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public InboxStyle setSummaryText(CharSequence charSequence) {
            this.f327f = Builder.limitCharSequenceLength(charSequence);
            this.f328g = true;
            return this;
        }

        public InboxStyle addLine(CharSequence charSequence) {
            this.f324a.add(Builder.limitCharSequenceLength(charSequence));
            return this;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$Action */
    public static class Action extends NotificationCompatBase.Action {
        public static final NotificationCompatBase.Action.Factory FACTORY = new NotificationCompatBase.Action.Factory() {
            /* renamed from: a */
            public Action build(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInputCompatBase.RemoteInput[] remoteInputArr) {
                return new Action(i, charSequence, pendingIntent, bundle, (RemoteInput[]) remoteInputArr);
            }

            /* renamed from: a */
            public Action[] newArray(int i) {
                return new Action[i];
            }
        };
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Bundle f276a;
        public PendingIntent actionIntent;

        /* renamed from: b */
        private final RemoteInput[] f277b;
        public int icon;
        public CharSequence title;

        /* renamed from: android.support.v4.app.NotificationCompat$Action$Extender */
        public interface Extender {
            Builder extend(Builder builder);
        }

        public Action(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null);
        }

        private Action(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr) {
            this.icon = i;
            this.title = Builder.limitCharSequenceLength(charSequence);
            this.actionIntent = pendingIntent;
            this.f276a = bundle == null ? new Bundle() : bundle;
            this.f277b = remoteInputArr;
        }

        public int getIcon() {
            return this.icon;
        }

        public CharSequence getTitle() {
            return this.title;
        }

        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public Bundle getExtras() {
            return this.f276a;
        }

        public RemoteInput[] getRemoteInputs() {
            return this.f277b;
        }

        /* renamed from: android.support.v4.app.NotificationCompat$Action$Builder */
        public static final class Builder {

            /* renamed from: a */
            private final int f278a;

            /* renamed from: b */
            private final CharSequence f279b;

            /* renamed from: c */
            private final PendingIntent f280c;

            /* renamed from: d */
            private final Bundle f281d;

            /* renamed from: e */
            private ArrayList<RemoteInput> f282e;

            public Builder(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i, charSequence, pendingIntent, new Bundle());
            }

            public Builder(Action action) {
                this(action.icon, action.title, action.actionIntent, new Bundle(action.f276a));
            }

            private Builder(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
                this.f278a = i;
                this.f279b = Builder.limitCharSequenceLength(charSequence);
                this.f280c = pendingIntent;
                this.f281d = bundle;
            }

            public Builder addExtras(Bundle bundle) {
                if (bundle != null) {
                    this.f281d.putAll(bundle);
                }
                return this;
            }

            public Bundle getExtras() {
                return this.f281d;
            }

            public Builder addRemoteInput(RemoteInput remoteInput) {
                if (this.f282e == null) {
                    this.f282e = new ArrayList<>();
                }
                this.f282e.add(remoteInput);
                return this;
            }

            public Builder extend(Extender extender) {
                extender.extend(this);
                return this;
            }

            public Action build() {
                RemoteInput[] remoteInputArr;
                if (this.f282e != null) {
                    remoteInputArr = (RemoteInput[]) this.f282e.toArray(new RemoteInput[this.f282e.size()]);
                } else {
                    remoteInputArr = null;
                }
                return new Action(this.f278a, this.f279b, this.f280c, this.f281d, remoteInputArr);
            }
        }

        /* renamed from: android.support.v4.app.NotificationCompat$Action$WearableExtender */
        public static final class WearableExtender implements Extender {

            /* renamed from: a */
            private int f283a = 1;

            /* renamed from: b */
            private CharSequence f284b;

            /* renamed from: c */
            private CharSequence f285c;

            /* renamed from: d */
            private CharSequence f286d;

            public WearableExtender() {
            }

            public WearableExtender(Action action) {
                Bundle bundle = action.getExtras().getBundle("android.wearable.EXTENSIONS");
                if (bundle != null) {
                    this.f283a = bundle.getInt("flags", 1);
                    this.f284b = bundle.getCharSequence("inProgressLabel");
                    this.f285c = bundle.getCharSequence("confirmLabel");
                    this.f286d = bundle.getCharSequence("cancelLabel");
                }
            }

            public Builder extend(Builder builder) {
                Bundle bundle = new Bundle();
                if (this.f283a != 1) {
                    bundle.putInt("flags", this.f283a);
                }
                if (this.f284b != null) {
                    bundle.putCharSequence("inProgressLabel", this.f284b);
                }
                if (this.f285c != null) {
                    bundle.putCharSequence("confirmLabel", this.f285c);
                }
                if (this.f286d != null) {
                    bundle.putCharSequence("cancelLabel", this.f286d);
                }
                builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
                return builder;
            }

            public WearableExtender clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.f283a = this.f283a;
                wearableExtender.f284b = this.f284b;
                wearableExtender.f285c = this.f285c;
                wearableExtender.f286d = this.f286d;
                return wearableExtender;
            }

            public WearableExtender setAvailableOffline(boolean z) {
                m266a(1, z);
                return this;
            }

            public boolean isAvailableOffline() {
                return (this.f283a & 1) != 0;
            }

            /* renamed from: a */
            private void m266a(int i, boolean z) {
                if (z) {
                    this.f283a |= i;
                } else {
                    this.f283a &= i ^ -1;
                }
            }

            public WearableExtender setInProgressLabel(CharSequence charSequence) {
                this.f284b = charSequence;
                return this;
            }

            public CharSequence getInProgressLabel() {
                return this.f284b;
            }

            public WearableExtender setConfirmLabel(CharSequence charSequence) {
                this.f285c = charSequence;
                return this;
            }

            public CharSequence getConfirmLabel() {
                return this.f285c;
            }

            public WearableExtender setCancelLabel(CharSequence charSequence) {
                this.f286d = charSequence;
                return this;
            }

            public CharSequence getCancelLabel() {
                return this.f286d;
            }
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$WearableExtender */
    public static final class WearableExtender implements Extender {
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
        private ArrayList<Action> f329a = new ArrayList<>();

        /* renamed from: b */
        private int f330b = 1;

        /* renamed from: c */
        private PendingIntent f331c;

        /* renamed from: d */
        private ArrayList<Notification> f332d = new ArrayList<>();

        /* renamed from: e */
        private Bitmap f333e;

        /* renamed from: f */
        private int f334f;

        /* renamed from: g */
        private int f335g = GravityCompat.END;

        /* renamed from: h */
        private int f336h = -1;

        /* renamed from: i */
        private int f337i = 0;

        /* renamed from: j */
        private int f338j;

        /* renamed from: k */
        private int f339k = 80;

        /* renamed from: l */
        private int f340l;

        public WearableExtender() {
        }

        public WearableExtender(Notification notification) {
            Bundle extras = NotificationCompat.getExtras(notification);
            Bundle bundle = extras != null ? extras.getBundle("android.wearable.EXTENSIONS") : null;
            if (bundle != null) {
                Action[] a = NotificationCompat.f275a.mo657a((ArrayList<Parcelable>) bundle.getParcelableArrayList("actions"));
                if (a != null) {
                    Collections.addAll(this.f329a, a);
                }
                this.f330b = bundle.getInt("flags", 1);
                this.f331c = (PendingIntent) bundle.getParcelable("displayIntent");
                Notification[] a2 = NotificationCompat.m262b(bundle, "pages");
                if (a2 != null) {
                    Collections.addAll(this.f332d, a2);
                }
                this.f333e = (Bitmap) bundle.getParcelable("background");
                this.f334f = bundle.getInt("contentIcon");
                this.f335g = bundle.getInt("contentIconGravity", GravityCompat.END);
                this.f336h = bundle.getInt("contentActionIndex", -1);
                this.f337i = bundle.getInt("customSizePreset", 0);
                this.f338j = bundle.getInt("customContentHeight");
                this.f339k = bundle.getInt("gravity", 80);
                this.f340l = bundle.getInt("hintScreenTimeout");
            }
        }

        public Builder extend(Builder builder) {
            Bundle bundle = new Bundle();
            if (!this.f329a.isEmpty()) {
                bundle.putParcelableArrayList("actions", NotificationCompat.f275a.mo656a((Action[]) this.f329a.toArray(new Action[this.f329a.size()])));
            }
            if (this.f330b != 1) {
                bundle.putInt("flags", this.f330b);
            }
            if (this.f331c != null) {
                bundle.putParcelable("displayIntent", this.f331c);
            }
            if (!this.f332d.isEmpty()) {
                bundle.putParcelableArray("pages", (Parcelable[]) this.f332d.toArray(new Notification[this.f332d.size()]));
            }
            if (this.f333e != null) {
                bundle.putParcelable("background", this.f333e);
            }
            if (this.f334f != 0) {
                bundle.putInt("contentIcon", this.f334f);
            }
            if (this.f335g != 8388613) {
                bundle.putInt("contentIconGravity", this.f335g);
            }
            if (this.f336h != -1) {
                bundle.putInt("contentActionIndex", this.f336h);
            }
            if (this.f337i != 0) {
                bundle.putInt("customSizePreset", this.f337i);
            }
            if (this.f338j != 0) {
                bundle.putInt("customContentHeight", this.f338j);
            }
            if (this.f339k != 80) {
                bundle.putInt("gravity", this.f339k);
            }
            if (this.f340l != 0) {
                bundle.putInt("hintScreenTimeout", this.f340l);
            }
            builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
            return builder;
        }

        public WearableExtender clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.f329a = new ArrayList<>(this.f329a);
            wearableExtender.f330b = this.f330b;
            wearableExtender.f331c = this.f331c;
            wearableExtender.f332d = new ArrayList<>(this.f332d);
            wearableExtender.f333e = this.f333e;
            wearableExtender.f334f = this.f334f;
            wearableExtender.f335g = this.f335g;
            wearableExtender.f336h = this.f336h;
            wearableExtender.f337i = this.f337i;
            wearableExtender.f338j = this.f338j;
            wearableExtender.f339k = this.f339k;
            wearableExtender.f340l = this.f340l;
            return wearableExtender;
        }

        public WearableExtender addAction(Action action) {
            this.f329a.add(action);
            return this;
        }

        public WearableExtender addActions(List<Action> list) {
            this.f329a.addAll(list);
            return this;
        }

        public WearableExtender clearActions() {
            this.f329a.clear();
            return this;
        }

        public List<Action> getActions() {
            return this.f329a;
        }

        public WearableExtender setDisplayIntent(PendingIntent pendingIntent) {
            this.f331c = pendingIntent;
            return this;
        }

        public PendingIntent getDisplayIntent() {
            return this.f331c;
        }

        public WearableExtender addPage(Notification notification) {
            this.f332d.add(notification);
            return this;
        }

        public WearableExtender addPages(List<Notification> list) {
            this.f332d.addAll(list);
            return this;
        }

        public WearableExtender clearPages() {
            this.f332d.clear();
            return this;
        }

        public List<Notification> getPages() {
            return this.f332d;
        }

        public WearableExtender setBackground(Bitmap bitmap) {
            this.f333e = bitmap;
            return this;
        }

        public Bitmap getBackground() {
            return this.f333e;
        }

        public WearableExtender setContentIcon(int i) {
            this.f334f = i;
            return this;
        }

        public int getContentIcon() {
            return this.f334f;
        }

        public WearableExtender setContentIconGravity(int i) {
            this.f335g = i;
            return this;
        }

        public int getContentIconGravity() {
            return this.f335g;
        }

        public WearableExtender setContentAction(int i) {
            this.f336h = i;
            return this;
        }

        public int getContentAction() {
            return this.f336h;
        }

        public WearableExtender setGravity(int i) {
            this.f339k = i;
            return this;
        }

        public int getGravity() {
            return this.f339k;
        }

        public WearableExtender setCustomSizePreset(int i) {
            this.f337i = i;
            return this;
        }

        public int getCustomSizePreset() {
            return this.f337i;
        }

        public WearableExtender setCustomContentHeight(int i) {
            this.f338j = i;
            return this;
        }

        public int getCustomContentHeight() {
            return this.f338j;
        }

        public WearableExtender setStartScrollBottom(boolean z) {
            m269a(8, z);
            return this;
        }

        public boolean getStartScrollBottom() {
            return (this.f330b & 8) != 0;
        }

        public WearableExtender setContentIntentAvailableOffline(boolean z) {
            m269a(1, z);
            return this;
        }

        public boolean getContentIntentAvailableOffline() {
            return (this.f330b & 1) != 0;
        }

        public WearableExtender setHintHideIcon(boolean z) {
            m269a(2, z);
            return this;
        }

        public boolean getHintHideIcon() {
            return (this.f330b & 2) != 0;
        }

        public WearableExtender setHintShowBackgroundOnly(boolean z) {
            m269a(4, z);
            return this;
        }

        public boolean getHintShowBackgroundOnly() {
            return (this.f330b & 4) != 0;
        }

        public WearableExtender setHintAvoidBackgroundClipping(boolean z) {
            m269a(16, z);
            return this;
        }

        public boolean getHintAvoidBackgroundClipping() {
            return (this.f330b & 16) != 0;
        }

        public WearableExtender setHintScreenTimeout(int i) {
            this.f340l = i;
            return this;
        }

        public int getHintScreenTimeout() {
            return this.f340l;
        }

        /* renamed from: a */
        private void m269a(int i, boolean z) {
            if (z) {
                this.f330b |= i;
            } else {
                this.f330b &= i ^ -1;
            }
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$CarExtender */
    public static final class CarExtender implements Extender {

        /* renamed from: a */
        private Bitmap f308a;

        /* renamed from: b */
        private UnreadConversation f309b;

        /* renamed from: c */
        private int f310c = 0;

        public CarExtender() {
        }

        public CarExtender(Notification notification) {
            if (Build.VERSION.SDK_INT >= 21) {
                Bundle bundle = NotificationCompat.getExtras(notification) == null ? null : NotificationCompat.getExtras(notification).getBundle("android.car.EXTENSIONS");
                if (bundle != null) {
                    this.f308a = (Bitmap) bundle.getParcelable("large_icon");
                    this.f310c = bundle.getInt("app_color", 0);
                    this.f309b = (UnreadConversation) NotificationCompat.f275a.mo655a(bundle.getBundle("car_conversation"), UnreadConversation.f311a, RemoteInput.FACTORY);
                }
            }
        }

        public Builder extend(Builder builder) {
            if (Build.VERSION.SDK_INT >= 21) {
                Bundle bundle = new Bundle();
                if (this.f308a != null) {
                    bundle.putParcelable("large_icon", this.f308a);
                }
                if (this.f310c != 0) {
                    bundle.putInt("app_color", this.f310c);
                }
                if (this.f309b != null) {
                    bundle.putBundle("car_conversation", NotificationCompat.f275a.mo653a((NotificationCompatBase.UnreadConversation) this.f309b));
                }
                builder.getExtras().putBundle("android.car.EXTENSIONS", bundle);
            }
            return builder;
        }

        public CarExtender setColor(@ColorInt int i) {
            this.f310c = i;
            return this;
        }

        @ColorInt
        public int getColor() {
            return this.f310c;
        }

        public CarExtender setLargeIcon(Bitmap bitmap) {
            this.f308a = bitmap;
            return this;
        }

        public Bitmap getLargeIcon() {
            return this.f308a;
        }

        public CarExtender setUnreadConversation(UnreadConversation unreadConversation) {
            this.f309b = unreadConversation;
            return this;
        }

        public UnreadConversation getUnreadConversation() {
            return this.f309b;
        }

        /* renamed from: android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation */
        public static class UnreadConversation extends NotificationCompatBase.UnreadConversation {

            /* renamed from: a */
            static final NotificationCompatBase.UnreadConversation.Factory f311a = new NotificationCompatBase.UnreadConversation.Factory() {
                /* renamed from: a */
                public UnreadConversation build(String[] strArr, RemoteInputCompatBase.RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
                    return new UnreadConversation(strArr, (RemoteInput) remoteInput, pendingIntent, pendingIntent2, strArr2, j);
                }
            };

            /* renamed from: b */
            private final String[] f312b;

            /* renamed from: c */
            private final RemoteInput f313c;

            /* renamed from: d */
            private final PendingIntent f314d;

            /* renamed from: e */
            private final PendingIntent f315e;

            /* renamed from: f */
            private final String[] f316f;

            /* renamed from: g */
            private final long f317g;

            UnreadConversation(String[] strArr, RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
                this.f312b = strArr;
                this.f313c = remoteInput;
                this.f315e = pendingIntent2;
                this.f314d = pendingIntent;
                this.f316f = strArr2;
                this.f317g = j;
            }

            public String[] getMessages() {
                return this.f312b;
            }

            public RemoteInput getRemoteInput() {
                return this.f313c;
            }

            public PendingIntent getReplyPendingIntent() {
                return this.f314d;
            }

            public PendingIntent getReadPendingIntent() {
                return this.f315e;
            }

            public String[] getParticipants() {
                return this.f316f;
            }

            public String getParticipant() {
                if (this.f316f.length > 0) {
                    return this.f316f[0];
                }
                return null;
            }

            public long getLatestTimestamp() {
                return this.f317g;
            }

            /* renamed from: android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation$Builder */
            public static class Builder {

                /* renamed from: a */
                private final List<String> f318a = new ArrayList();

                /* renamed from: b */
                private final String f319b;

                /* renamed from: c */
                private RemoteInput f320c;

                /* renamed from: d */
                private PendingIntent f321d;

                /* renamed from: e */
                private PendingIntent f322e;

                /* renamed from: f */
                private long f323f;

                public Builder(String str) {
                    this.f319b = str;
                }

                public Builder addMessage(String str) {
                    this.f318a.add(str);
                    return this;
                }

                public Builder setReplyAction(PendingIntent pendingIntent, RemoteInput remoteInput) {
                    this.f320c = remoteInput;
                    this.f322e = pendingIntent;
                    return this;
                }

                public Builder setReadPendingIntent(PendingIntent pendingIntent) {
                    this.f321d = pendingIntent;
                    return this;
                }

                public Builder setLatestTimestamp(long j) {
                    this.f323f = j;
                    return this;
                }

                public UnreadConversation build() {
                    return new UnreadConversation((String[]) this.f318a.toArray(new String[this.f318a.size()]), this.f320c, this.f322e, this.f321d, new String[]{this.f319b}, this.f323f);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Notification[] m262b(Bundle bundle, String str) {
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

    public static Bundle getExtras(Notification notification) {
        return f275a.mo652a(notification);
    }

    public static int getActionCount(Notification notification) {
        return f275a.mo658b(notification);
    }

    public static Action getAction(Notification notification, int i) {
        return f275a.mo654a(notification, i);
    }

    public static String getCategory(Notification notification) {
        return f275a.mo659c(notification);
    }

    public static boolean getLocalOnly(Notification notification) {
        return f275a.mo660d(notification);
    }

    public static String getGroup(Notification notification) {
        return f275a.mo661e(notification);
    }

    public static boolean isGroupSummary(Notification notification) {
        return f275a.mo662f(notification);
    }

    public static String getSortKey(Notification notification) {
        return f275a.mo663g(notification);
    }
}
