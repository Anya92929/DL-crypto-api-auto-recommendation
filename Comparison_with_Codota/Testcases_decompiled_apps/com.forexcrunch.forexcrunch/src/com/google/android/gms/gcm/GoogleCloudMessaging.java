package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class GoogleCloudMessaging {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
    public static final String MESSAGE_TYPE_MESSAGE = "gcm";
    public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";

    /* renamed from: fh */
    static GoogleCloudMessaging f974fh;

    /* renamed from: fi */
    private Context f975fi;

    /* renamed from: fj */
    private PendingIntent f976fj;

    /* renamed from: fk */
    final BlockingQueue<Intent> f977fk = new LinkedBlockingQueue();

    /* renamed from: fl */
    private Handler f978fl = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            GoogleCloudMessaging.this.f977fk.add((Intent) msg.obj);
        }
    };

    /* renamed from: fm */
    private Messenger f979fm = new Messenger(this.f978fl);

    /* renamed from: aO */
    private void m788aO() {
        Intent intent = new Intent(GCMConstants.INTENT_TO_GCM_UNREGISTRATION);
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
        this.f977fk.clear();
        intent.putExtra("google.messenger", this.f979fm);
        mo4441c(intent);
        this.f975fi.startService(intent);
    }

    /* renamed from: b */
    private void m789b(String... strArr) {
        String c = mo4440c(strArr);
        Intent intent = new Intent(GCMConstants.INTENT_TO_GCM_REGISTRATION);
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
        intent.putExtra("google.messenger", this.f979fm);
        mo4441c(intent);
        intent.putExtra(GCMConstants.EXTRA_SENDER, c);
        this.f975fi.startService(intent);
    }

    public static synchronized GoogleCloudMessaging getInstance(Context context) {
        GoogleCloudMessaging googleCloudMessaging;
        synchronized (GoogleCloudMessaging.class) {
            if (f974fh == null) {
                f974fh = new GoogleCloudMessaging();
                f974fh.f975fi = context;
            }
            googleCloudMessaging = f974fh;
        }
        return googleCloudMessaging;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: aP */
    public synchronized void mo4439aP() {
        if (this.f976fj != null) {
            this.f976fj.cancel();
            this.f976fj = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo4440c(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            sb.append(',').append(strArr[i]);
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized void mo4441c(Intent intent) {
        if (this.f976fj == null) {
            this.f976fj = PendingIntent.getBroadcast(this.f975fi, 0, new Intent(), 0);
        }
        intent.putExtra(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, this.f976fj);
    }

    public void close() {
        mo4439aP();
    }

    public String getMessageType(Intent intent) {
        if (!GCMConstants.INTENT_FROM_GCM_MESSAGE.equals(intent.getAction())) {
            return null;
        }
        String stringExtra = intent.getStringExtra(GCMConstants.EXTRA_SPECIAL_MESSAGE);
        return stringExtra == null ? MESSAGE_TYPE_MESSAGE : stringExtra;
    }

    public String register(String... senderIds) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException(ERROR_MAIN_THREAD);
        }
        this.f977fk.clear();
        m789b(senderIds);
        try {
            Intent poll = this.f977fk.poll(5000, TimeUnit.MILLISECONDS);
            if (poll == null) {
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
            String stringExtra = poll.getStringExtra(GCMConstants.EXTRA_REGISTRATION_ID);
            if (stringExtra != null) {
                return stringExtra;
            }
            poll.getStringExtra(GCMConstants.EXTRA_ERROR);
            String stringExtra2 = poll.getStringExtra(GCMConstants.EXTRA_ERROR);
            if (stringExtra2 != null) {
                throw new IOException(stringExtra2);
            }
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } catch (InterruptedException e) {
            throw new IOException(e.getMessage());
        }
    }

    public void send(String to, String msgId, long timeToLive, Bundle data) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException(ERROR_MAIN_THREAD);
        } else if (to == null) {
            throw new IllegalArgumentException("Missing 'to'");
        } else {
            Intent intent = new Intent("com.google.android.gcm.intent.SEND");
            intent.putExtras(data);
            mo4441c(intent);
            intent.putExtra("google.to", to);
            intent.putExtra("google.message_id", msgId);
            intent.putExtra("google.ttl", Long.toString(timeToLive));
            this.f975fi.sendOrderedBroadcast(intent, (String) null);
        }
    }

    public void send(String to, String msgId, Bundle data) throws IOException {
        send(to, msgId, -1, data);
    }

    public void unregister() throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException(ERROR_MAIN_THREAD);
        }
        m788aO();
        try {
            Intent poll = this.f977fk.poll(5000, TimeUnit.MILLISECONDS);
            if (poll == null) {
                throw new IOException("SERVICE_NOT_AVAILABLE");
            } else if (poll.getStringExtra(GCMConstants.EXTRA_UNREGISTERED) == null) {
                String stringExtra = poll.getStringExtra(GCMConstants.EXTRA_ERROR);
                if (stringExtra != null) {
                    throw new IOException(stringExtra);
                }
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        } catch (InterruptedException e) {
            throw new IOException(e.getMessage());
        }
    }
}
