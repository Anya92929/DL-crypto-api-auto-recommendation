package android.support.p001v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p001v4.app.NotificationCompatBase;
import android.support.p001v4.app.RemoteInputCompatBase;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v4.app.NotificationCompatApi21 */
class NotificationCompatApi21 {

    /* renamed from: android.support.v4.app.NotificationCompatApi21$Builder */
    public static class Builder implements NotificationBuilderWithBuilderAccessor, C2018z {

        /* renamed from: a */
        private Notification.Builder f343a;

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3) {
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            Notification.Builder lights = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
            if ((notification.flags & 2) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            Notification.Builder ongoing = lights.setOngoing(z6);
            if ((notification.flags & 8) != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z7);
            if ((notification.flags & 16) != 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z8).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                z9 = true;
            } else {
                z9 = false;
            }
            this.f343a = deleteIntent.setFullScreenIntent(pendingIntent2, z9).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setExtras(bundle).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.f343a.addPerson(it.next());
            }
        }

        public void addAction(NotificationCompatBase.Action action) {
            NotificationCompatApi20.m333a(this.f343a, action);
        }

        public Notification.Builder getBuilder() {
            return this.f343a;
        }

        public Notification build() {
            return this.f343a.build();
        }
    }

    /* renamed from: a */
    public static String m343a(Notification notification) {
        return notification.category;
    }

    /* renamed from: a */
    static Bundle m340a(NotificationCompatBase.UnreadConversation unreadConversation) {
        String str = null;
        if (unreadConversation == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (unreadConversation.getParticipants() != null && unreadConversation.getParticipants().length > 1) {
            str = unreadConversation.getParticipants()[0];
        }
        Parcelable[] parcelableArr = new Parcelable[unreadConversation.getMessages().length];
        for (int i = 0; i < parcelableArr.length; i++) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("text", unreadConversation.getMessages()[i]);
            bundle2.putString("author", str);
            parcelableArr[i] = bundle2;
        }
        bundle.putParcelableArray("messages", parcelableArr);
        RemoteInputCompatBase.RemoteInput remoteInput = unreadConversation.getRemoteInput();
        if (remoteInput != null) {
            bundle.putParcelable("remote_input", m339a(remoteInput));
        }
        bundle.putParcelable("on_reply", unreadConversation.getReplyPendingIntent());
        bundle.putParcelable("on_read", unreadConversation.getReadPendingIntent());
        bundle.putStringArray("participants", unreadConversation.getParticipants());
        bundle.putLong("timestamp", unreadConversation.getLatestTimestamp());
        return bundle;
    }

    /* renamed from: a */
    static NotificationCompatBase.UnreadConversation m341a(Bundle bundle, NotificationCompatBase.UnreadConversation.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        String[] strArr;
        RemoteInputCompatBase.RemoteInput remoteInput;
        boolean z = false;
        if (bundle == null) {
            return null;
        }
        Parcelable[] parcelableArray = bundle.getParcelableArray("messages");
        if (parcelableArray != null) {
            String[] strArr2 = new String[parcelableArray.length];
            int i = 0;
            while (true) {
                if (i < strArr2.length) {
                    if (parcelableArray[i] instanceof Bundle) {
                        strArr2[i] = ((Bundle) parcelableArray[i]).getString("text");
                        if (strArr2[i] == null) {
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return null;
            }
            strArr = strArr2;
        } else {
            strArr = null;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("on_read");
        PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable("on_reply");
        RemoteInput remoteInput2 = (RemoteInput) bundle.getParcelable("remote_input");
        String[] stringArray = bundle.getStringArray("participants");
        if (stringArray == null || stringArray.length != 1) {
            return null;
        }
        if (remoteInput2 != null) {
            remoteInput = m342a(remoteInput2, factory2);
        } else {
            remoteInput = null;
        }
        return factory.build(strArr, remoteInput, pendingIntent2, pendingIntent, stringArray, bundle.getLong("timestamp"));
    }

    /* renamed from: a */
    private static RemoteInput m339a(RemoteInputCompatBase.RemoteInput remoteInput) {
        return new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build();
    }

    /* renamed from: a */
    private static RemoteInputCompatBase.RemoteInput m342a(RemoteInput remoteInput, RemoteInputCompatBase.RemoteInput.Factory factory) {
        return factory.build(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), remoteInput.getExtras());
    }
}
